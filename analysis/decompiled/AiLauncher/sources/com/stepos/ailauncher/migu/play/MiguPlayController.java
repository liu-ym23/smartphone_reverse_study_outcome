package com.stepos.ailauncher.migu.play;

import Z8.C1173v;
import android.app.Application;
import android.content.ComponentName;
import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.widget.Toast;
import androidx.exifinterface.media.ExifInterface;
import com.autonavi.aps.amapapi.config.Const;
import com.migu.music.ipc.MusicIpcSdk;
import com.migu.music.ipc.wrap.MusicIpcSdkException;
import com.stepos.ailauncher.foundation.appui.card.provider.didi.o0;
import com.stepos.ailauncher.migu.play.MiguInstallState;
import com.stepos.ailauncher.migu.play.MiguPlayController;
import h9.InterfaceC4149a;
import io.ktor.http.ContentType;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArraySet;
import kotlin.C4849c;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Pair;
import kotlin.Result;
import p9.InterfaceC5063a;
import p9.InterfaceC5074l;

@Metadata(d1 = {"\u0000´\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\f\n\u0002\u0010\u0003\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\t\n\u0002\b\t\n\u0002\u0010 \n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\b\u0003\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b*\u0004\u0089\u0001\u008c\u0001\bÀ\u0002\u0018\u00002\u00020\u0001:\u0002\u0096\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J/\u0010\u000b\u001a\u00020\t2\u0006\u0010\u0005\u001a\u00020\u00042\b\b\u0002\u0010\u0007\u001a\u00020\u00062\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\t0\bH\u0002¢\u0006\u0004\b\u000b\u0010\fJ\u000f\u0010\r\u001a\u00020\tH\u0002¢\u0006\u0004\b\r\u0010\u0003J!\u0010\u0012\u001a\u00020\t2\u0006\u0010\u000f\u001a\u00020\u000e2\b\u0010\u0011\u001a\u0004\u0018\u00010\u0010H\u0002¢\u0006\u0004\b\u0012\u0010\u0013J!\u0010\u0014\u001a\u00020\u00102\u0006\u0010\u000f\u001a\u00020\u000e2\b\u0010\u0011\u001a\u0004\u0018\u00010\u0010H\u0002¢\u0006\u0004\b\u0014\u0010\u0015J\u0017\u0010\u0016\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u0016\u0010\u0017J\u001f\u0010\u0019\u001a\u00020\t2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0018\u001a\u00020\u0010H\u0002¢\u0006\u0004\b\u0019\u0010\u001aJ\u0017\u0010\u001b\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u001b\u0010\u0017J\u000f\u0010\u001c\u001a\u00020\tH\u0002¢\u0006\u0004\b\u001c\u0010\u0003J\u001f\u0010\u001f\u001a\u00020\t2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u001e\u001a\u00020\u001dH\u0002¢\u0006\u0004\b\u001f\u0010 J\u0019\u0010!\u001a\u0004\u0018\u00010\u000e2\u0006\u0010\u001e\u001a\u00020\u001dH\u0002¢\u0006\u0004\b!\u0010\"J+\u0010&\u001a\u00020\t2\u0006\u0010\u000f\u001a\u00020\u000e2\b\u0010$\u001a\u0004\u0018\u00010#2\b\u0010%\u001a\u0004\u0018\u00010\u0010H\u0002¢\u0006\u0004\b&\u0010'J\u000f\u0010(\u001a\u00020\tH\u0002¢\u0006\u0004\b(\u0010\u0003J\u0017\u0010)\u001a\u00020\t2\u0006\u0010\u0018\u001a\u00020\u0010H\u0002¢\u0006\u0004\b)\u0010*J\u000f\u0010+\u001a\u00020\tH\u0002¢\u0006\u0004\b+\u0010\u0003J1\u00100\u001a\u00020\t2\b\u0010\u0018\u001a\u0004\u0018\u00010\u00102\u0006\u0010-\u001a\u00020,2\u0006\u0010.\u001a\u00020,2\u0006\u0010/\u001a\u00020\u000eH\u0002¢\u0006\u0004\b0\u00101J\u0017\u00103\u001a\u00020\t2\u0006\u00102\u001a\u00020\u0010H\u0002¢\u0006\u0004\b3\u0010*J\u0017\u00105\u001a\u00020\t2\u0006\u00104\u001a\u00020\u0010H\u0002¢\u0006\u0004\b5\u0010*J%\u00108\u001a\u00020\t2\u0006\u0010\u0005\u001a\u00020\u00042\f\u00107\u001a\b\u0012\u0004\u0012\u00020\u001006H\u0002¢\u0006\u0004\b8\u00109J\u000f\u0010:\u001a\u00020\tH\u0002¢\u0006\u0004\b:\u0010\u0003J\u000f\u0010;\u001a\u00020\tH\u0002¢\u0006\u0004\b;\u0010\u0003J\u0019\u0010<\u001a\u00020\t2\b\u0010\u0018\u001a\u0004\u0018\u00010\u0010H\u0002¢\u0006\u0004\b<\u0010*J\u0019\u0010=\u001a\u00020\t2\b\u0010\u0018\u001a\u0004\u0018\u00010\u0010H\u0002¢\u0006\u0004\b=\u0010*J\u0017\u0010>\u001a\u00020\t2\u0006\u00104\u001a\u00020\u0010H\u0002¢\u0006\u0004\b>\u0010*J\u000f\u0010?\u001a\u00020\u0006H\u0002¢\u0006\u0004\b?\u0010@J#\u0010D\u001a\u00020\t2\u0012\u0010C\u001a\u000e\u0012\u0004\u0012\u00020B\u0012\u0004\u0012\u00020B0AH\u0002¢\u0006\u0004\bD\u0010EJ\u0017\u0010H\u001a\u00020\t2\u0006\u0010G\u001a\u00020FH\u0002¢\u0006\u0004\bH\u0010IJ\u0017\u0010J\u001a\u00020\t2\u0006\u0010\u0011\u001a\u00020\u0010H\u0002¢\u0006\u0004\bJ\u0010*J\r\u0010K\u001a\u00020B¢\u0006\u0004\bK\u0010LJ\r\u0010M\u001a\u00020F¢\u0006\u0004\bM\u0010NJ\u0015\u0010Q\u001a\u00020\t2\u0006\u0010P\u001a\u00020O¢\u0006\u0004\bQ\u0010RJ\u0015\u0010S\u001a\u00020\t2\u0006\u0010P\u001a\u00020O¢\u0006\u0004\bS\u0010RJ\u0015\u0010V\u001a\u00020\t2\u0006\u0010U\u001a\u00020T¢\u0006\u0004\bV\u0010WJ\u001f\u0010X\u001a\u00020\t2\u0006\u0010\u0005\u001a\u00020\u00042\b\u0010\u0018\u001a\u0004\u0018\u00010\u0010¢\u0006\u0004\bX\u0010\u001aJ\u0015\u0010Z\u001a\u00020Y2\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\bZ\u0010[J\u0015\u0010\\\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\\\u0010\u0017J\u0017\u0010]\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b]\u0010^J\u000f\u0010_\u001a\u0004\u0018\u00010\u0006¢\u0006\u0004\b_\u0010`J\u0015\u0010a\u001a\u00020\t2\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\ba\u0010bJ\u0017\u0010c\u001a\u00020\t2\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004¢\u0006\u0004\bc\u0010bJ\r\u0010d\u001a\u00020\t¢\u0006\u0004\bd\u0010\u0003J#\u0010f\u001a\u00020\t2\u0006\u0010\u0005\u001a\u00020\u00042\f\u0010e\u001a\b\u0012\u0004\u0012\u00020\u001006¢\u0006\u0004\bf\u00109R\u0014\u0010h\u001a\u00020g8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bh\u0010iR\u0018\u0010j\u001a\u0004\u0018\u00010\u00048\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bj\u0010kR\u0016\u0010l\u001a\u00020\u00068\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bl\u0010?R\u0016\u0010m\u001a\u00020B8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bm\u0010nR\u0016\u0010o\u001a\u00020F8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bo\u0010pR\u0016\u0010q\u001a\u00020\u000e8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bq\u0010\u0014R\u0018\u0010r\u001a\u0004\u0018\u00010\u00108\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\br\u0010sR\u001a\u0010u\u001a\b\u0012\u0004\u0012\u00020O0t8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bu\u0010vR\u0016\u0010w\u001a\u00020\u00068\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bw\u0010?R\u0016\u0010y\u001a\u00020x8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\by\u0010zR\u0018\u0010{\u001a\u0004\u0018\u00010Y8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b{\u0010|R\u0018\u0010}\u001a\u0004\u0018\u00010Y8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b}\u0010|R\u001e\u0010~\u001a\n\u0012\u0004\u0012\u00020\t\u0018\u00010\b8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b~\u0010\u007fR\"\u0010\u0081\u0001\u001a\u000b\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0080\u00018\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b\u0081\u0001\u0010\u0082\u0001R\u001a\u0010\u0083\u0001\u001a\u0004\u0018\u00010\u00108\u0002@\u0002X\u0082\u000e¢\u0006\u0007\n\u0005\b\u0083\u0001\u0010sR\u0018\u0010\u0084\u0001\u001a\u00020\u000e8\u0002@\u0002X\u0082\u000e¢\u0006\u0007\n\u0005\b\u0084\u0001\u0010\u0014R\u0018\u0010\u0085\u0001\u001a\u00020\u00068\u0002@\u0002X\u0082\u000e¢\u0006\u0007\n\u0005\b\u0085\u0001\u0010?R\u0018\u0010\u0086\u0001\u001a\u00020\u00068\u0002@\u0002X\u0082\u000e¢\u0006\u0007\n\u0005\b\u0086\u0001\u0010?R\u0016\u0010\u0087\u0001\u001a\u00020\u00108\u0002X\u0082T¢\u0006\u0007\n\u0005\b\u0087\u0001\u0010sR\u0016\u0010\u0088\u0001\u001a\u00020\u000e8\u0002X\u0082T¢\u0006\u0007\n\u0005\b\u0088\u0001\u0010\u0014R\u0018\u0010\u008a\u0001\u001a\u00030\u0089\u00018\u0002X\u0082\u0004¢\u0006\b\n\u0006\b\u008a\u0001\u0010\u008b\u0001R\u0018\u0010\u008d\u0001\u001a\u00030\u008c\u00018\u0002X\u0082\u0004¢\u0006\b\n\u0006\b\u008d\u0001\u0010\u008e\u0001R\u0018\u0010\u0092\u0001\u001a\u00030\u008f\u00018BX\u0082\u0004¢\u0006\b\u001a\u0006\b\u0090\u0001\u0010\u0091\u0001R\u0019\u0010\u0095\u0001\u001a\u0004\u0018\u00010\u00048BX\u0082\u0004¢\u0006\b\u001a\u0006\b\u0093\u0001\u0010\u0094\u0001¨\u0006\u0097\u0001"}, d2 = {"Lcom/stepos/ailauncher/migu/play/MiguPlayController;", "", "<init>", "()V", "Landroid/content/Context;", "context", "", "silent", "Lkotlin/Function0;", "LY8/t;", "action", "Q", "(Landroid/content/Context;ZLp9/a;)V", "h0", "", "errorCode", "", "message", "g0", "(ILjava/lang/String;)V", "I", "(ILjava/lang/String;)Ljava/lang/String;", "o0", "(Landroid/content/Context;)Z", "songId", "N", "(Landroid/content/Context;Ljava/lang/String;)V", "x0", "q0", "", "t", "k0", "(Landroid/content/Context;Ljava/lang/Throwable;)V", ExifInterface.GPS_MEASUREMENT_INTERRUPTED, "(Ljava/lang/Throwable;)Ljava/lang/Integer;", "Lcom/stepos/ailauncher/migu/play/MiguPlayError;", "error", "hostMessage", "A0", "(ILcom/stepos/ailauncher/migu/play/MiguPlayError;Ljava/lang/String;)V", "l0", "H", "(Ljava/lang/String;)V", "J", "", "positionMs", "durationMs", "percent", "I0", "(Ljava/lang/String;JJI)V", "advancedTo", "c0", "via", "C0", "", "ids", "K", "(Landroid/content/Context;Ljava/util/List;)V", "U", "i0", "a0", "b0", "s0", "Z", "()Z", "Lkotlin/Function1;", "Lcom/stepos/ailauncher/migu/play/c0;", "transform", "L0", "(Lp9/l;)V", "Lcom/stepos/ailauncher/migu/play/b0;", "next", "u0", "(Lcom/stepos/ailauncher/migu/play/b0;)V", "F0", "B0", "()Lcom/stepos/ailauncher/migu/play/c0;", "p0", "()Lcom/stepos/ailauncher/migu/play/b0;", "Lcom/stepos/ailauncher/migu/play/a0;", "observer", "E0", "(Lcom/stepos/ailauncher/migu/play/a0;)V", "K0", "Landroid/app/Application;", ContentType.Application.TYPE, "Y", "(Landroid/app/Application;)V", "G0", "Lcom/stepos/ailauncher/migu/play/MiguCardSurface;", "y0", "(Landroid/content/Context;)Lcom/stepos/ailauncher/migu/play/MiguCardSurface;", "z0", "v0", "(Landroid/content/Context;)Ljava/lang/Boolean;", "w0", "()Ljava/lang/Boolean;", ExifInterface.LATITUDE_SOUTH, "(Landroid/content/Context;)V", "e0", "f0", "songIds", "m0", "Landroid/os/Handler;", "mainHandler", "Landroid/os/Handler;", "appContext", "Landroid/content/Context;", "sdkAuthorized", "currentSnapshot", "Lcom/stepos/ailauncher/migu/play/c0;", "currentProgress", "Lcom/stepos/ailauncher/migu/play/b0;", "lastForwardedPercent", "lastForwardedSongId", "Ljava/lang/String;", "Ljava/util/concurrent/CopyOnWriteArraySet;", "observers", "Ljava/util/concurrent/CopyOnWriteArraySet;", "callbacksRegistered", "Lcom/stepos/ailauncher/migu/play/MiguPlayController$BindState;", "bindState", "Lcom/stepos/ailauncher/migu/play/MiguPlayController$BindState;", "lastKnownSurface", "Lcom/stepos/ailauncher/migu/play/MiguCardSurface;", "lastResolvedSurface", "pendingAction", "Lp9/a;", "Ljava/lang/ref/WeakReference;", "pendingContext", "Ljava/lang/ref/WeakReference;", "singleTrackGuardId", "singleTrackMaxPercent", "suppressPauseNetworkHint", "networkStopHinted", "PAID_MESSAGE_FALLBACK", "NEAR_END_PERCENT", "com/stepos/ailauncher/migu/play/MiguPlayController$playbackCallbacks$1", "playbackCallbacks", "Lcom/stepos/ailauncher/migu/play/MiguPlayController$playbackCallbacks$1;", "com/stepos/ailauncher/migu/play/MiguPlayController$b", "connectionListener", "Lcom/stepos/ailauncher/migu/play/MiguPlayController$b;", "Lcom/migu/music/ipc/MusicIpcSdk;", "X", "()Lcom/migu/music/ipc/MusicIpcSdk;", "sdk", ExifInterface.LONGITUDE_WEST, "()Landroid/content/Context;", "dialogContext", "BindState", "migu_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class MiguPlayController {
    private static final int NEAR_END_PERCENT = 95;
    private static final String PAID_MESSAGE_FALLBACK = "该首歌曲需付费收听";
    private static Context appContext;
    private static volatile boolean callbacksRegistered;
    private static volatile String lastForwardedSongId;
    private static MiguCardSurface lastKnownSurface;
    private static MiguCardSurface lastResolvedSurface;
    private static boolean networkStopHinted;
    private static InterfaceC5063a<Y8.t> pendingAction;
    private static WeakReference<Context> pendingContext;
    private static boolean sdkAuthorized;
    private static volatile String singleTrackGuardId;
    private static volatile int singleTrackMaxPercent;
    private static boolean suppressPauseNetworkHint;
    public static final MiguPlayController INSTANCE = new MiguPlayController();
    private static final Handler mainHandler = new Handler(Looper.getMainLooper());
    private static MiguPlaybackSnapshot currentSnapshot = MiguPlaybackSnapshot.INSTANCE.a();
    private static MiguPlaybackProgress currentProgress = MiguPlaybackProgress.INSTANCE.a();
    private static volatile int lastForwardedPercent = -1;
    private static final CopyOnWriteArraySet<a0> observers = new CopyOnWriteArraySet<>();
    private static BindState bindState = BindState.IDLE;
    private static final MiguPlayController$playbackCallbacks$1 playbackCallbacks = new MiguPlayController$playbackCallbacks$1();
    private static final b connectionListener = new b();

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* JADX WARN: Unknown enum class pattern. Please report as an issue! */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0007\b\u0082\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007¨\u0006\b"}, d2 = {"Lcom/stepos/ailauncher/migu/play/MiguPlayController$BindState;", "", "<init>", "(Ljava/lang/String;I)V", "IDLE", "BINDING", "BOUND", "FAILED", "migu_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final class BindState {
        private static final /* synthetic */ InterfaceC4149a $ENTRIES;
        private static final /* synthetic */ BindState[] $VALUES;
        public static final BindState IDLE = new BindState("IDLE", 0);
        public static final BindState BINDING = new BindState("BINDING", 1);
        public static final BindState BOUND = new BindState("BOUND", 2);
        public static final BindState FAILED = new BindState("FAILED", 3);

        private static final /* synthetic */ BindState[] $values() {
            return new BindState[]{IDLE, BINDING, BOUND, FAILED};
        }

        static {
            BindState[] bindStateArr$values = $values();
            $VALUES = bindStateArr$values;
            $ENTRIES = kotlin.enums.a.a(bindStateArr$values);
        }

        private BindState(String str, int i10) {
        }

        public static InterfaceC4149a<BindState> getEntries() {
            return $ENTRIES;
        }

        public static BindState valueOf(String str) {
            return (BindState) Enum.valueOf(BindState.class, str);
        }

        public static BindState[] values() {
            return (BindState[]) $VALUES.clone();
        }
    }

    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    public static final /* synthetic */ class a {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;
        public static final /* synthetic */ int[] $EnumSwitchMapping$1;

        static {
            int[] iArr = new int[MiguPlayAction.values().length];
            try {
                iArr[MiguPlayAction.PLAY_NEW.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[MiguPlayAction.PAUSE.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            $EnumSwitchMapping$0 = iArr;
            int[] iArr2 = new int[BindState.values().length];
            try {
                iArr2[BindState.IDLE.ordinal()] = 1;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                iArr2[BindState.BINDING.ordinal()] = 2;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                iArr2[BindState.BOUND.ordinal()] = 3;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                iArr2[BindState.FAILED.ordinal()] = 4;
            } catch (NoSuchFieldError unused6) {
            }
            $EnumSwitchMapping$1 = iArr2;
        }
    }

    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0019\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0006J\u0019\u0010\u0007\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016¢\u0006\u0004\b\u0007\u0010\u0006J\u0019\u0010\b\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016¢\u0006\u0004\b\b\u0010\u0006J\u0019\u0010\t\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016¢\u0006\u0004\b\t\u0010\u0006¨\u0006\n"}, d2 = {"com/stepos/ailauncher/migu/play/MiguPlayController$b", "LQ3/a;", "Landroid/content/ComponentName;", "name", "LY8/t;", Const.INTENT_KEY_APIKEY, "(Landroid/content/ComponentName;)V", "onServiceDisconnected", "onBindingDied", "onNullBinding", "migu_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final class b extends Q3.a {
        @Override // Q3.b
        public void a(ComponentName name) {
            MiguPlayController.callbacksRegistered = false;
            MiguPlayController.INSTANCE.U();
        }

        @Override // Q3.b
        public void onBindingDied(ComponentName name) {
            MiguPlayController.INSTANCE.i0();
        }

        @Override // Q3.b
        public void onNullBinding(ComponentName name) {
            MiguPlayController.INSTANCE.i0();
        }

        @Override // Q3.b
        public void onServiceDisconnected(ComponentName name) {
            MiguPlayController.INSTANCE.i0();
        }
    }

    @Metadata(d1 = {"\u0000\u001f\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u000f\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0003\u0010\u0004J!\u0010\t\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u00052\b\u0010\b\u001a\u0004\u0018\u00010\u0007H\u0016¢\u0006\u0004\b\t\u0010\n¨\u0006\u000b"}, d2 = {"com/stepos/ailauncher/migu/play/MiguPlayController$c", "LQ3/c;", "LY8/t;", Const.INTENT_KEY_PKGNAME, "()V", "", "errorCode", "", "message", Const.INTENT_KEY_APIKEY, "(ILjava/lang/String;)V", "migu_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final class c implements Q3.c {
        public c() {
        }

        public static final void e(MiguPlayController miguPlayController, int i10, String str) {
            miguPlayController.g0(i10, str);
        }

        public static final void f(MiguPlayController miguPlayController) {
            miguPlayController.h0();
        }

        @Override // Q3.c
        public void a(final int errorCode, final String message) {
            Handler handler = MiguPlayController.mainHandler;
            final MiguPlayController miguPlayController = MiguPlayController.this;
            handler.post(new Runnable() { // from class: com.stepos.ailauncher.migu.play.O
                @Override // java.lang.Runnable
                public final void run() {
                    MiguPlayController.c.e(miguPlayController, errorCode, message);
                }
            });
        }

        @Override // Q3.c
        public void b() {
            Handler handler = MiguPlayController.mainHandler;
            final MiguPlayController miguPlayController = MiguPlayController.this;
            handler.post(new Runnable() { // from class: com.stepos.ailauncher.migu.play.P
                @Override // java.lang.Runnable
                public final void run() {
                    MiguPlayController.c.f(miguPlayController);
                }
            });
        }
    }

    public static final /* synthetic */ void D(boolean z10) {
        networkStopHinted = z10;
    }

    public static final MiguPlaybackSnapshot D0(MiguPlaybackSnapshot it) {
        kotlin.jvm.internal.p.i(it, "it");
        return MiguPlaybackSnapshot.c(it, null, false, false, 5, null);
    }

    public static final Y8.t H0(Context context, String str) {
        INSTANCE.N(context, str);
        return Y8.t.f7040a;
    }

    public static final void J0() {
        INSTANCE.C0("progressEnd");
    }

    public static final MiguPlaybackSnapshot L(List list, MiguPlaybackSnapshot it) {
        kotlin.jvm.internal.p.i(it, "it");
        return new MiguPlaybackSnapshot((String) Z8.F.q0(list), true, false, 4, null);
    }

    public static final MiguPlaybackSnapshot M(MiguPlaybackSnapshot miguPlaybackSnapshot, MiguPlaybackSnapshot it) {
        kotlin.jvm.internal.p.i(it, "it");
        return miguPlaybackSnapshot;
    }

    public static final void M0(InterfaceC5074l interfaceC5074l) {
        INSTANCE.L0(interfaceC5074l);
    }

    public static final MiguPlaybackSnapshot O(String str, MiguPlayAction miguPlayAction, MiguPlaybackSnapshot it) {
        kotlin.jvm.internal.p.i(it, "it");
        return Z.INSTANCE.d(it, str, miguPlayAction);
    }

    public static final MiguPlaybackSnapshot P(MiguPlaybackSnapshot miguPlaybackSnapshot, MiguPlaybackSnapshot it) {
        kotlin.jvm.internal.p.i(it, "it");
        return miguPlaybackSnapshot;
    }

    public static /* synthetic */ void R(MiguPlayController miguPlayController, Context context, boolean z10, InterfaceC5063a interfaceC5063a, int i10, Object obj) {
        if ((i10 & 2) != 0) {
            z10 = false;
        }
        miguPlayController.Q(context, z10, interfaceC5063a);
    }

    public static final Y8.t T() {
        return Y8.t.f7040a;
    }

    public static final void d0() {
        INSTANCE.C0("songChanged");
    }

    public static final MiguPlaybackSnapshot j0(MiguPlaybackSnapshot it) {
        kotlin.jvm.internal.p.i(it, "it");
        return MiguPlaybackSnapshot.c(it, null, false, false, 5, null);
    }

    public static final Y8.t n0(Context context, List list) {
        INSTANCE.K(context, list);
        return Y8.t.f7040a;
    }

    public static final void r0() {
        Iterator<T> it = observers.iterator();
        while (it.hasNext()) {
            ((a0) it.next()).c();
        }
    }

    public static final MiguPlaybackSnapshot t0(MiguPlaybackSnapshot it) {
        kotlin.jvm.internal.p.i(it, "it");
        return MiguPlaybackSnapshot.c(it, null, false, false, 5, null);
    }

    /* JADX WARN: Removed duplicated region for block: B:19:0x0029  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void A0(int r4, com.stepos.ailauncher.migu.play.MiguPlayError r5, java.lang.String r6) {
        /*
            r3 = this;
            com.stepos.ailauncher.migu.play.MiguPlayError r0 = com.stepos.ailauncher.migu.play.MiguPlayError.NEED_LOGIN
            if (r5 != r0) goto L8
            r3.f0()
            return
        L8:
            com.stepos.ailauncher.migu.play.MiguPlayError r0 = com.stepos.ailauncher.migu.play.MiguPlayError.PAID_OR_REGION_LIMITED
            r1 = 0
            if (r5 != r0) goto L30
            com.stepos.ailauncher.migu.play.MiguPlayError$a r2 = com.stepos.ailauncher.migu.play.MiguPlayError.INSTANCE
            boolean r2 = r2.a(r6)
            if (r2 != 0) goto L30
            android.content.Context r2 = r3.W()
            if (r2 == 0) goto L30
            com.stepos.ailauncher.migu.play.z r3 = com.stepos.ailauncher.migu.play.C3377z.INSTANCE
            if (r6 == 0) goto L29
            boolean r4 = La.H.x0(r6)
            if (r4 != 0) goto L26
            goto L27
        L26:
            r6 = r1
        L27:
            if (r6 != 0) goto L2c
        L29:
            java.lang.String r6 = "该首歌曲需付费收听"
        L2c:
            r3.i(r2, r6)
            return
        L30:
            if (r5 != r0) goto L3a
            if (r6 == 0) goto L3a
            boolean r0 = La.H.x0(r6)
            if (r0 == 0) goto L66
        L3a:
            if (r5 == 0) goto L40
            java.lang.String r1 = r5.getToast()
        L40:
            if (r1 == 0) goto L47
            java.lang.String r6 = r5.getToast()
            goto L66
        L47:
            if (r6 == 0) goto L4f
            boolean r5 = La.H.x0(r6)
            if (r5 == 0) goto L66
        L4f:
            java.lang.StringBuilder r5 = new java.lang.StringBuilder
            r5.<init>()
            java.lang.String r6 = "播放失败("
            r5.append(r6)
            r5.append(r4)
            java.lang.String r4 = ")"
            r5.append(r4)
            java.lang.String r6 = r5.toString()
        L66:
            r3.F0(r6)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stepos.ailauncher.migu.play.MiguPlayController.A0(int, com.stepos.ailauncher.migu.play.MiguPlayError, java.lang.String):void");
    }

    public final MiguPlaybackSnapshot B0() {
        return currentSnapshot;
    }

    public final void C0(String via) {
        Object objB;
        String str = singleTrackGuardId;
        if (str == null) {
            return;
        }
        J();
        suppressPauseNetworkHint = true;
        try {
            Result.Companion companion = Result.INSTANCE;
            X().S();
            objB = Result.b(Y8.t.f7040a);
        } catch (Throwable th) {
            Result.Companion companion2 = Result.INSTANCE;
            objB = Result.b(C4849c.a(th));
        }
        Throwable thE = Result.e(objB);
        if (thE != null) {
            R5.b bVar = R5.b.INSTANCE;
            String message = thE.getMessage();
            if (message == null) {
                message = "";
            }
            bVar.h("music.singleTrack.pause.fail", Y8.j.a("message", message));
        }
        L0(new InterfaceC5074l() { // from class: com.stepos.ailauncher.migu.play.C
            @Override // p9.InterfaceC5074l
            public final Object invoke(Object obj) {
                return MiguPlayController.D0((MiguPlaybackSnapshot) obj);
            }
        });
        R5.b.INSTANCE.c("music.singleTrack.stopped", Y8.j.a("via", via), Y8.j.a("songId", str));
    }

    public final void E0(a0 observer) {
        kotlin.jvm.internal.p.i(observer, "observer");
        observers.add(observer);
    }

    public final void F0(String message) {
        Context context = appContext;
        if (context == null) {
            return;
        }
        Toast.makeText(context, message, 0).show();
    }

    public final void G0(final Context context, final String songId) {
        kotlin.jvm.internal.p.i(context, "context");
        if (songId == null || songId.length() == 0) {
            F0("songId不能为空");
        } else if (o0(context)) {
            R(this, context, false, new InterfaceC5063a() { // from class: com.stepos.ailauncher.migu.play.F
                @Override // p9.InterfaceC5063a
                public final Object invoke() {
                    return MiguPlayController.H0(context, songId);
                }
            }, 2, null);
        }
    }

    public final void H(String songId) {
        singleTrackGuardId = songId;
        singleTrackMaxPercent = 0;
    }

    public final String I(int errorCode, String message) {
        if (errorCode == 0) {
            return "音乐播放授权失败";
        }
        if (errorCode == 1) {
            return "未安装咪咕音乐";
        }
        if (errorCode == 6) {
            return "播放服务未就绪";
        }
        switch (errorCode) {
            case 8:
                return "播放服务未就绪";
            case 9:
                return "请先登录咪咕音乐";
            case 10:
                return "咪咕音乐版本过低，请更新后再试";
            default:
                if (message == null) {
                    return "连接咪咕音乐失败，请重试";
                }
                if (La.H.x0(message)) {
                    message = null;
                }
                return message == null ? "连接咪咕音乐失败，请重试" : message;
        }
    }

    public final void I0(String songId, long positionMs, long durationMs, int percent) {
        String str = singleTrackGuardId;
        if (str == null || songId == null || !kotlin.jvm.internal.p.d(songId, str)) {
            return;
        }
        if (percent > singleTrackMaxPercent) {
            singleTrackMaxPercent = percent;
        }
        if (durationMs > 0) {
            if (positionMs < durationMs) {
                return;
            }
        } else if (percent < 100) {
            return;
        }
        mainHandler.post(new Runnable() { // from class: com.stepos.ailauncher.migu.play.N
            @Override // java.lang.Runnable
            public final void run() {
                MiguPlayController.J0();
            }
        });
    }

    public final void J() {
        singleTrackGuardId = null;
        singleTrackMaxPercent = 0;
    }

    public final void K(Context context, final List<String> ids) {
        Object objB;
        Object objB2;
        if (x0(context)) {
            J();
            networkStopHinted = false;
            try {
                Result.Companion companion = Result.INSTANCE;
                X().a0(2);
                objB = Result.b(Y8.t.f7040a);
            } catch (Throwable th) {
                Result.Companion companion2 = Result.INSTANCE;
                objB = Result.b(C4849c.a(th));
            }
            Throwable thE = Result.e(objB);
            if (thE != null) {
                R5.b bVar = R5.b.INSTANCE;
                String message = thE.getMessage();
                if (message == null) {
                    message = "";
                }
                bVar.h("music.playAll.setPlayMode.fail", Y8.j.a("message", message));
            }
            final MiguPlaybackSnapshot miguPlaybackSnapshot = currentSnapshot;
            L0(new InterfaceC5074l() { // from class: com.stepos.ailauncher.migu.play.H
                @Override // p9.InterfaceC5074l
                public final Object invoke(Object obj) {
                    return MiguPlayController.L(ids, (MiguPlaybackSnapshot) obj);
                }
            });
            try {
                l0();
                X().T(new ArrayList(ids), 1);
                objB2 = Result.b(Y8.t.f7040a);
            } catch (Throwable th2) {
                Result.Companion companion3 = Result.INSTANCE;
                objB2 = Result.b(C4849c.a(th2));
            }
            Throwable thE2 = Result.e(objB2);
            if (thE2 != null) {
                R5.b bVar2 = R5.b.INSTANCE;
                Pair pairA = Y8.j.a("count", Integer.valueOf(ids.size()));
                MiguPlayController miguPlayController = INSTANCE;
                Pair pairA2 = Y8.j.a("errorCode", miguPlayController.V(thE2));
                String message2 = thE2.getMessage();
                bVar2.h("music.playAll.fail", pairA, pairA2, Y8.j.a("message", message2 != null ? message2 : ""));
                miguPlayController.k0(context, thE2);
            }
            if (Result.h(objB2)) {
                return;
            }
            L0(new InterfaceC5074l() { // from class: com.stepos.ailauncher.migu.play.I
                @Override // p9.InterfaceC5074l
                public final Object invoke(Object obj) {
                    return MiguPlayController.M(miguPlaybackSnapshot, (MiguPlaybackSnapshot) obj);
                }
            });
        }
    }

    public final void K0(a0 observer) {
        kotlin.jvm.internal.p.i(observer, "observer");
        observers.remove(observer);
    }

    public final void L0(final InterfaceC5074l<? super MiguPlaybackSnapshot, MiguPlaybackSnapshot> transform) {
        if (!kotlin.jvm.internal.p.d(Looper.myLooper(), Looper.getMainLooper())) {
            mainHandler.post(new Runnable() { // from class: com.stepos.ailauncher.migu.play.B
                @Override // java.lang.Runnable
                public final void run() {
                    MiguPlayController.M0(transform);
                }
            });
            return;
        }
        MiguPlaybackSnapshot miguPlaybackSnapshotInvoke = transform.invoke(currentSnapshot);
        if (kotlin.jvm.internal.p.d(miguPlaybackSnapshotInvoke, currentSnapshot)) {
            return;
        }
        boolean zD = kotlin.jvm.internal.p.d(miguPlaybackSnapshotInvoke.getSongId(), currentSnapshot.getSongId());
        currentSnapshot = miguPlaybackSnapshotInvoke;
        if (!zD) {
            currentProgress = MiguPlaybackProgress.INSTANCE.a();
            lastForwardedSongId = null;
            lastForwardedPercent = -1;
        }
        for (a0 a0Var : observers) {
            try {
                Result.Companion companion = Result.INSTANCE;
                a0Var.d();
                Result.b(Y8.t.f7040a);
            } catch (Throwable th) {
                Result.Companion companion2 = Result.INSTANCE;
                Result.b(C4849c.a(th));
            }
        }
    }

    public final void N(Context context, final String songId) {
        Object objB;
        final MiguPlaybackSnapshot miguPlaybackSnapshot = currentSnapshot;
        final MiguPlayAction miguPlayActionC = Z.INSTANCE.c(miguPlaybackSnapshot, songId);
        MiguPlayAction miguPlayAction = MiguPlayAction.PLAY_NEW;
        if (miguPlayActionC != miguPlayAction || x0(context)) {
            if (miguPlayActionC == miguPlayAction) {
                H(songId);
                networkStopHinted = false;
            }
            L0(new InterfaceC5074l() { // from class: com.stepos.ailauncher.migu.play.J
                @Override // p9.InterfaceC5074l
                public final Object invoke(Object obj) {
                    return MiguPlayController.O(songId, miguPlayActionC, (MiguPlaybackSnapshot) obj);
                }
            });
            try {
                Result.Companion companion = Result.INSTANCE;
                int i10 = a.$EnumSwitchMapping$0[miguPlayActionC.ordinal()];
                if (i10 == 1) {
                    l0();
                    X().T(C1173v.h(songId), 1);
                } else {
                    if (i10 != 2) {
                        throw new NoWhenBranchMatchedException();
                    }
                    suppressPauseNetworkHint = true;
                    X().S();
                }
                objB = Result.b(Y8.t.f7040a);
            } catch (Throwable th) {
                Result.Companion companion2 = Result.INSTANCE;
                objB = Result.b(C4849c.a(th));
            }
            Throwable thE = Result.e(objB);
            if (thE != null) {
                R5.b bVar = R5.b.INSTANCE;
                Pair pairA = Y8.j.a("action", miguPlayActionC.name());
                Pair pairA2 = Y8.j.a("songId", songId);
                MiguPlayController miguPlayController = INSTANCE;
                Pair pairA3 = Y8.j.a("errorCode", miguPlayController.V(thE));
                String message = thE.getMessage();
                if (message == null) {
                    message = "";
                }
                bVar.h("music.toggle.fail", pairA, pairA2, pairA3, Y8.j.a("message", message));
                miguPlayController.k0(context, thE);
            }
            if (Result.h(objB)) {
                return;
            }
            L0(new InterfaceC5074l() { // from class: com.stepos.ailauncher.migu.play.K
                @Override // p9.InterfaceC5074l
                public final Object invoke(Object obj) {
                    return MiguPlayController.P(miguPlaybackSnapshot, (MiguPlaybackSnapshot) obj);
                }
            });
            if (miguPlayActionC == MiguPlayAction.PLAY_NEW) {
                J();
            }
        }
    }

    public final void Q(Context context, boolean silent, InterfaceC5063a<Y8.t> action) {
        Context context2;
        Object objB;
        pendingContext = new WeakReference<>(context);
        if (X().M()) {
            U();
            action.invoke();
            return;
        }
        pendingAction = action;
        BindState bindState2 = bindState;
        BindState bindState3 = BindState.BINDING;
        if (bindState2 == bindState3 || (context2 = appContext) == null) {
            return;
        }
        bindState = bindState3;
        if (!silent) {
            F0("正在连接咪咕音乐…");
        }
        try {
            Result.Companion companion = Result.INSTANCE;
            X().J(context2, new c());
            objB = Result.b(Y8.t.f7040a);
        } catch (Throwable th) {
            Result.Companion companion2 = Result.INSTANCE;
            objB = Result.b(C4849c.a(th));
        }
        Throwable thE = Result.e(objB);
        if (thE != null) {
            R5.b bVar = R5.b.INSTANCE;
            String message = thE.getMessage();
            if (message == null) {
                message = "";
            }
            bVar.h("music.initBind.throw", Y8.j.a("message", message));
            if (!silent) {
                INSTANCE.F0("连接咪咕音乐失败");
            }
        }
        if (Result.h(objB)) {
            return;
        }
        bindState = BindState.FAILED;
        pendingAction = null;
        pendingContext = null;
        q0();
    }

    public final void S(Context context) {
        kotlin.jvm.internal.p.i(context, "context");
        pendingContext = new WeakReference<>(context);
        q0();
        if (!sdkAuthorized || kotlin.jvm.internal.p.d(v0(context), Boolean.FALSE) || X().M() || bindState == BindState.BINDING) {
            return;
        }
        Q(context, true, new InterfaceC5063a() { // from class: com.stepos.ailauncher.migu.play.E
            @Override // p9.InterfaceC5063a
            public final Object invoke() {
                return MiguPlayController.T();
            }
        });
    }

    public final void U() {
        Object objB;
        if (callbacksRegistered || !X().M()) {
            return;
        }
        try {
            Result.Companion companion = Result.INSTANCE;
            X().W(playbackCallbacks);
            objB = Result.b(Y8.t.f7040a);
        } catch (Throwable th) {
            Result.Companion companion2 = Result.INSTANCE;
            objB = Result.b(C4849c.a(th));
        }
        if (Result.h(objB)) {
            callbacksRegistered = true;
        }
        Throwable thE = Result.e(objB);
        if (thE != null) {
            R5.b bVar = R5.b.INSTANCE;
            String message = thE.getMessage();
            if (message == null) {
                message = "";
            }
            bVar.h("music.registerCallbacks.fail", Y8.j.a("message", message));
        }
    }

    public final Integer V(Throwable t10) {
        MusicIpcSdkException musicIpcSdkException = t10 instanceof MusicIpcSdkException ? (MusicIpcSdkException) t10 : null;
        if (musicIpcSdkException != null) {
            return Integer.valueOf(musicIpcSdkException.a());
        }
        return null;
    }

    public final Context W() {
        WeakReference<Context> weakReference = pendingContext;
        if (weakReference != null) {
            return weakReference.get();
        }
        return null;
    }

    public final MusicIpcSdk X() {
        MusicIpcSdk musicIpcSdkI = MusicIpcSdk.I();
        kotlin.jvm.internal.p.h(musicIpcSdkI, "getInstance(...)");
        return musicIpcSdkI;
    }

    public final void Y(Application application) {
        boolean z10;
        kotlin.jvm.internal.p.i(application, "application");
        appContext = application;
        if (!C3356d.INSTANCE.a()) {
            R5.b.INSTANCE.h("music.initSdk.skip", Y8.j.a("reason", "credentials_absent"));
            return;
        }
        try {
            X().K(application, C3356d.APP_ID, C3356d.APP_KEY);
            X().U(connectionListener);
            z10 = true;
        } catch (Throwable th) {
            R5.b bVar = R5.b.INSTANCE;
            String message = th.getMessage();
            if (message == null) {
                message = "";
            }
            bVar.h("music.initSdk.fail", Y8.j.a("message", message));
            z10 = false;
        }
        sdkAuthorized = z10;
    }

    public final boolean Z() {
        Object objB;
        Context context = appContext;
        if (context == null) {
            return true;
        }
        try {
            Result.Companion companion = Result.INSTANCE;
            objB = Result.b(Boolean.valueOf(com.stepos.ailauncher.common.utils.I.INSTANCE.b(context)));
        } catch (Throwable th) {
            Result.Companion companion2 = Result.INSTANCE;
            objB = Result.b(C4849c.a(th));
        }
        Boolean bool = Boolean.TRUE;
        if (Result.g(objB)) {
            objB = bool;
        }
        return ((Boolean) objB).booleanValue();
    }

    public final void a0(String songId) {
        if (songId == null || songId.length() == 0 || currentSnapshot.getSongId() == null || kotlin.jvm.internal.p.d(songId, currentSnapshot.getSongId())) {
            if (C3373v.INSTANCE.b(currentSnapshot.getIsPlaying(), Z(), networkStopHinted)) {
                s0("buffering");
            }
        }
    }

    public final void b0(String songId) {
        if (songId != null && songId.length() != 0 && currentSnapshot.getSongId() != null && !kotlin.jvm.internal.p.d(songId, currentSnapshot.getSongId())) {
            suppressPauseNetworkHint = false;
            return;
        }
        boolean z10 = suppressPauseNetworkHint;
        suppressPauseNetworkHint = false;
        boolean Z10 = Z();
        C3373v c3373v = C3373v.INSTANCE;
        if (c3373v.c(Z10, networkStopHinted, z10, c3373v.a(currentProgress, 95))) {
            s0(o0.TRACK_STATUS_PAUSED);
        }
    }

    public final void c0(String advancedTo) {
        String str = singleTrackGuardId;
        if (str == null || kotlin.jvm.internal.p.d(advancedTo, str)) {
            return;
        }
        if (singleTrackMaxPercent >= 95) {
            mainHandler.post(new Runnable() { // from class: com.stepos.ailauncher.migu.play.L
                @Override // java.lang.Runnable
                public final void run() {
                    MiguPlayController.d0();
                }
            });
        } else {
            J();
            R5.b.INSTANCE.c("music.singleTrack.disarm", Y8.j.a("reason", "manual_switch"), Y8.j.a("maxPercent", Integer.valueOf(singleTrackMaxPercent)));
        }
    }

    public final void e0(Context context) {
        lastKnownSurface = MiguCardSurface.INSTALL;
        q0();
        R5.b.INSTANCE.c("music.cardSurface.needInstall", new Pair[0]);
        if (!observers.isEmpty() || context == null) {
            return;
        }
        C3362j.INSTANCE.o(context);
    }

    public final void f0() {
        lastKnownSurface = MiguCardSurface.LOGIN;
        q0();
        R5.b.INSTANCE.c("music.cardSurface.needLogin", new Pair[0]);
    }

    public final void g0(int errorCode, String message) {
        if (errorCode == 7) {
            return;
        }
        bindState = BindState.FAILED;
        pendingAction = null;
        R5.b.INSTANCE.h("music.initBind.fail", Y8.j.a("errorCode", Integer.valueOf(errorCode)), Y8.j.a("message", message == null ? "" : message));
        if (errorCode == 1) {
            e0(W());
        } else if (errorCode == 9) {
            f0();
        } else {
            q0();
            F0(I(errorCode, message));
        }
    }

    public final void h0() {
        bindState = BindState.BOUND;
        U();
        q0();
        InterfaceC5063a<Y8.t> interfaceC5063a = pendingAction;
        pendingAction = null;
        if (interfaceC5063a != null) {
            interfaceC5063a.invoke();
        }
    }

    public final void i0() {
        callbacksRegistered = false;
        bindState = BindState.IDLE;
        pendingAction = null;
        L0(new InterfaceC5074l() { // from class: com.stepos.ailauncher.migu.play.D
            @Override // p9.InterfaceC5074l
            public final Object invoke(Object obj) {
                return MiguPlayController.j0((MiguPlaybackSnapshot) obj);
            }
        });
    }

    public final void k0(Context context, Throwable t10) {
        Integer numV = V(t10);
        if (numV != null && numV.intValue() == 9) {
            f0();
            return;
        }
        String message = t10.getMessage();
        if (message == null) {
            message = "播放失败";
        }
        F0(message);
    }

    public final void l0() {
        Object objB;
        suppressPauseNetworkHint = true;
        try {
            Result.Companion companion = Result.INSTANCE;
            X().S();
            objB = Result.b(Y8.t.f7040a);
        } catch (Throwable th) {
            Result.Companion companion2 = Result.INSTANCE;
            objB = Result.b(C4849c.a(th));
        }
        Throwable thE = Result.e(objB);
        if (thE != null) {
            R5.b bVar = R5.b.INSTANCE;
            String message = thE.getMessage();
            if (message == null) {
                message = "";
            }
            bVar.h("music.pauseBeforePlay.fail", Y8.j.a("message", message));
        }
    }

    public final void m0(final Context context, List<String> songIds) {
        kotlin.jvm.internal.p.i(context, "context");
        kotlin.jvm.internal.p.i(songIds, "songIds");
        final ArrayList arrayList = new ArrayList();
        for (Object obj : songIds) {
            if (((String) obj).length() > 0) {
                arrayList.add(obj);
            }
        }
        if (arrayList.isEmpty()) {
            F0("没有可播放的歌曲");
        } else if (o0(context)) {
            R(this, context, false, new InterfaceC5063a() { // from class: com.stepos.ailauncher.migu.play.G
                @Override // p9.InterfaceC5063a
                public final Object invoke() {
                    return MiguPlayController.n0(context, arrayList);
                }
            }, 2, null);
        }
    }

    public final boolean o0(Context context) {
        Object objB;
        if (!sdkAuthorized) {
            F0("音乐播放暂不可用");
            return false;
        }
        try {
            Result.Companion companion = Result.INSTANCE;
            objB = Result.b(Boolean.valueOf(P3.b.b(context)));
        } catch (Throwable th) {
            Result.Companion companion2 = Result.INSTANCE;
            objB = Result.b(C4849c.a(th));
        }
        Throwable thE = Result.e(objB);
        if (thE != null) {
            R5.b bVar = R5.b.INSTANCE;
            String message = thE.getMessage();
            if (message == null) {
                message = "";
            }
            bVar.h("music.isInstalled.fail", Y8.j.a("message", message));
        }
        Boolean bool = Boolean.TRUE;
        if (Result.g(objB)) {
            objB = bool;
        }
        if (((Boolean) objB).booleanValue()) {
            return true;
        }
        R5.b.INSTANCE.h("music.preflight.notInstalled", new Pair[0]);
        e0(context);
        return false;
    }

    public final MiguPlaybackProgress p0() {
        return currentProgress;
    }

    public final void q0() {
        mainHandler.post(new Runnable() { // from class: com.stepos.ailauncher.migu.play.M
            @Override // java.lang.Runnable
            public final void run() {
                MiguPlayController.r0();
            }
        });
    }

    public final void s0(String via) {
        networkStopHinted = true;
        R5.b.INSTANCE.h("music.networkStop.hint", Y8.j.a("via", via));
        L0(new InterfaceC5074l() { // from class: com.stepos.ailauncher.migu.play.A
            @Override // p9.InterfaceC5074l
            public final Object invoke(Object obj) {
                return MiguPlayController.t0((MiguPlaybackSnapshot) obj);
            }
        });
        MiguPlayError miguPlayError = MiguPlayError.NETWORK_ERROR;
        A0(miguPlayError.getCode(), miguPlayError, null);
    }

    public final void u0(MiguPlaybackProgress next) {
        if (kotlin.jvm.internal.p.d(next.getSongId(), currentSnapshot.getSongId()) && !kotlin.jvm.internal.p.d(next, currentProgress)) {
            currentProgress = next;
            for (a0 a0Var : observers) {
                try {
                    Result.Companion companion = Result.INSTANCE;
                    a0Var.b();
                    Result.b(Y8.t.f7040a);
                } catch (Throwable th) {
                    Result.Companion companion2 = Result.INSTANCE;
                    Result.b(C4849c.a(th));
                }
            }
        }
    }

    public final Boolean v0(Context context) {
        Object objB;
        kotlin.jvm.internal.p.i(context, "context");
        try {
            Result.Companion companion = Result.INSTANCE;
            objB = Result.b(Boolean.valueOf(P3.b.b(context)));
        } catch (Throwable th) {
            Result.Companion companion2 = Result.INSTANCE;
            objB = Result.b(C4849c.a(th));
        }
        Throwable thE = Result.e(objB);
        if (thE != null) {
            R5.b bVar = R5.b.INSTANCE;
            String message = thE.getMessage();
            if (message == null) {
                message = "";
            }
            bVar.h("music.isInstalled.fail", Y8.j.a("message", message));
        }
        if (Result.g(objB)) {
            objB = null;
        }
        return (Boolean) objB;
    }

    public final Boolean w0() {
        Object objB;
        if (!X().M()) {
            return null;
        }
        try {
            Result.Companion companion = Result.INSTANCE;
            objB = Result.b(Boolean.valueOf(X().L()));
        } catch (Throwable th) {
            Result.Companion companion2 = Result.INSTANCE;
            objB = Result.b(C4849c.a(th));
        }
        Throwable thE = Result.e(objB);
        if (thE != null) {
            R5.b bVar = R5.b.INSTANCE;
            String message = thE.getMessage();
            if (message == null) {
                message = "";
            }
            bVar.h("music.isLoginSuccess.fail", Y8.j.a("message", message));
        }
        return (Boolean) (Result.g(objB) ? null : objB);
    }

    public final boolean x0(Context context) {
        if (!kotlin.jvm.internal.p.d(w0(), Boolean.FALSE)) {
            return true;
        }
        f0();
        return false;
    }

    public final MiguCardSurface y0(Context context) {
        MiguBindPhase miguBindPhase;
        String strValueOf;
        String strName;
        kotlin.jvm.internal.p.i(context, "context");
        Boolean boolV0 = v0(context);
        Boolean boolW0 = w0();
        C3355c c3355c = C3355c.INSTANCE;
        MiguInstallState.Phase phaseI = MiguInstallState.INSTANCE.i(boolV0);
        int i10 = a.$EnumSwitchMapping$1[bindState.ordinal()];
        if (i10 == 1) {
            miguBindPhase = MiguBindPhase.IDLE;
        } else if (i10 == 2) {
            miguBindPhase = MiguBindPhase.BINDING;
        } else if (i10 == 3) {
            miguBindPhase = MiguBindPhase.BOUND;
        } else {
            if (i10 != 4) {
                throw new NoWhenBranchMatchedException();
            }
            miguBindPhase = MiguBindPhase.FAILED;
        }
        MiguCardSurface miguCardSurfaceA = c3355c.a(boolV0, phaseI, boolW0, miguBindPhase, sdkAuthorized, lastKnownSurface, X().M());
        if (miguCardSurfaceA != lastResolvedSurface) {
            R5.b bVar = R5.b.INSTANCE;
            Pair pairA = Y8.j.a("surface", miguCardSurfaceA.name());
            String str = "null";
            if (boolW0 == null || (strValueOf = String.valueOf(boolW0.booleanValue())) == null) {
                strValueOf = "null";
            }
            Pair pairA2 = Y8.j.a("loggedIn", strValueOf);
            Pair pairA3 = Y8.j.a("bind", bindState.name());
            Pair pairA4 = Y8.j.a("ready", Boolean.valueOf(X().M()));
            MiguCardSurface miguCardSurface = lastKnownSurface;
            if (miguCardSurface != null && (strName = miguCardSurface.name()) != null) {
                str = strName;
            }
            bVar.c("music.cardSurface.resolve", pairA, pairA2, pairA3, pairA4, Y8.j.a("lastKnown", str));
            lastResolvedSurface = miguCardSurfaceA;
        }
        if (miguCardSurfaceA != MiguCardSurface.HIDDEN) {
            lastKnownSurface = miguCardSurfaceA;
        }
        return miguCardSurfaceA;
    }

    public final boolean z0(Context context) {
        kotlin.jvm.internal.p.i(context, "context");
        return y0(context) != MiguCardSurface.PLAYLIST;
    }
}
