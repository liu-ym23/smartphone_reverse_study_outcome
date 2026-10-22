package com.stepos.ailauncher.chat.media;

import Y8.t;
import Z8.F;
import android.media.AudioAttributes;
import android.media.AudioManager;
import android.media.AudioPlaybackConfiguration;
import android.os.Handler;
import android.os.Looper;
import android.os.Process;
import android.os.SystemClock;
import androidx.exifinterface.media.ExifInterface;
import com.stepos.ailauncher.common.utils.C3197a;
import h8.C4148a;
import h9.InterfaceC4149a;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import kotlin.C4849c;
import kotlin.Metadata;
import kotlin.Result;
import p9.InterfaceC5063a;
import r9.C5227b;
import v9.C5685n;

@Metadata(d1 = {"\u0000\u0088\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\b\u0003\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004*\u0002FI\bÆ\u0002\u0018\u00002\u00020\u0001:\u0001OB\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0017\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u0007\u0010\bJ\u0017\u0010\t\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\t\u0010\bJ\u000f\u0010\n\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\n\u0010\u0003J\u000f\u0010\u000b\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\u000b\u0010\u0003J\u000f\u0010\f\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\f\u0010\u0003J\u000f\u0010\r\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\r\u0010\u0003J\u000f\u0010\u000e\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\u000e\u0010\u0003J\u0017\u0010\u0011\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u000fH\u0002¢\u0006\u0004\b\u0011\u0010\u0012J\u001f\u0010\u0016\u001a\u00020\u00062\u0006\u0010\u0014\u001a\u00020\u00132\u0006\u0010\u0015\u001a\u00020\u000fH\u0002¢\u0006\u0004\b\u0016\u0010\u0017J\u000f\u0010\u0018\u001a\u00020\u000fH\u0002¢\u0006\u0004\b\u0018\u0010\u0019J\u0011\u0010\u001a\u001a\u0004\u0018\u00010\u0013H\u0002¢\u0006\u0004\b\u001a\u0010\u001bJ\u0017\u0010\u001d\u001a\u00020\u001c2\u0006\u0010\u0014\u001a\u00020\u0013H\u0002¢\u0006\u0004\b\u001d\u0010\u001eJ\u0017\u0010!\u001a\u00020\u001c2\u0006\u0010 \u001a\u00020\u001fH\u0002¢\u0006\u0004\b!\u0010\"J\u0019\u0010%\u001a\u0004\u0018\u00010\u000f2\u0006\u0010$\u001a\u00020#H\u0002¢\u0006\u0004\b%\u0010&J\u001d\u0010)\u001a\u00020\u00062\f\u0010(\u001a\b\u0012\u0004\u0012\u00020\u00060'H\u0002¢\u0006\u0004\b)\u0010*J\u0015\u0010+\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b+\u0010\bJ\u0015\u0010,\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b,\u0010\bJ\r\u0010-\u001a\u00020\u0006¢\u0006\u0004\b-\u0010\u0003R\u0014\u0010/\u001a\u00020.8\u0002X\u0082T¢\u0006\u0006\n\u0004\b/\u00100R\u0014\u00102\u001a\u0002018\u0002X\u0082T¢\u0006\u0006\n\u0004\b2\u0010\tR\u0014\u00104\u001a\u0002038\u0002X\u0082T¢\u0006\u0006\n\u0004\b4\u0010\fR\u0014\u00105\u001a\u0002038\u0002X\u0082T¢\u0006\u0006\n\u0004\b5\u0010\fR\u0014\u00106\u001a\u0002038\u0002X\u0082T¢\u0006\u0006\n\u0004\b6\u0010\fR\u0014\u00108\u001a\u0002078\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b8\u00109R0\u0010<\u001a\u001e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u000f0:j\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u000f`;8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b<\u0010=R\u0018\u0010>\u001a\u0004\u0018\u00010\u000f8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b>\u0010?R\u0018\u0010@\u001a\u0004\u0018\u00010\u000f8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b@\u0010?R\u0016\u0010A\u001a\u00020\u001c8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bA\u0010BR\u0016\u0010C\u001a\u00020\u000f8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bC\u0010\u000bR\u0016\u0010D\u001a\u0002038\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bD\u0010\fR\u0016\u0010E\u001a\u00020\u001c8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bE\u0010BR\u0014\u0010G\u001a\u00020F8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bG\u0010HR\u0014\u0010J\u001a\u00020I8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bJ\u0010KR\u0014\u0010M\u001a\u00020L8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bM\u0010N¨\u0006P"}, d2 = {"Lcom/stepos/ailauncher/chat/media/MusicVolumeDucker;", "", "<init>", "()V", "Lcom/stepos/ailauncher/chat/media/MusicVolumeDucker$Reason;", "reason", "LY8/t;", "s", "(Lcom/stepos/ailauncher/chat/media/MusicVolumeDucker$Reason;)V", "F", "L", "I", "J", "u", "v", "", "saved", "x", "(I)I", "Landroid/media/AudioManager;", "am", "volume", "M", "(Landroid/media/AudioManager;I)V", "K", "()I", "t", "()Landroid/media/AudioManager;", "", "y", "(Landroid/media/AudioManager;)Z", "Landroid/media/AudioAttributes;", "attr", "z", "(Landroid/media/AudioAttributes;)Z", "Landroid/media/AudioPlaybackConfiguration;", "config", "C", "(Landroid/media/AudioPlaybackConfiguration;)Ljava/lang/Integer;", "Lkotlin/Function0;", "block", "G", "(Lp9/a;)V", "q", "D", ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, "", "TAG", "Ljava/lang/String;", "", "DUCK_RATIO", "", "RESTORE_MS", "TICK_MS", "REASSERT_MS", "Landroid/os/Handler;", "handler", "Landroid/os/Handler;", "Ljava/util/HashMap;", "Lkotlin/collections/HashMap;", "counts", "Ljava/util/HashMap;", "savedVolume", "Ljava/lang/Integer;", "lastWritten", "restoring", "Z", "restoreFrom", "restoreStartMs", "playbackUidReadWarned", "com/stepos/ailauncher/chat/media/MusicVolumeDucker$a", "reassertDuck", "Lcom/stepos/ailauncher/chat/media/MusicVolumeDucker$a;", "com/stepos/ailauncher/chat/media/MusicVolumeDucker$b", "restoreTick", "Lcom/stepos/ailauncher/chat/media/MusicVolumeDucker$b;", "Ljava/lang/Runnable;", "confirmRestore", "Ljava/lang/Runnable;", "Reason", "chat_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class MusicVolumeDucker {
    private static final float DUCK_RATIO = 0.3f;
    private static final long REASSERT_MS = 250;
    private static final long RESTORE_MS = 1000;
    private static final String TAG = "MusicVolumeDucker";
    private static final long TICK_MS = 40;
    private static Integer lastWritten;
    private static boolean playbackUidReadWarned;
    private static int restoreFrom;
    private static long restoreStartMs;
    private static boolean restoring;
    private static Integer savedVolume;
    public static final MusicVolumeDucker INSTANCE = new MusicVolumeDucker();
    private static final Handler handler = new Handler(Looper.getMainLooper());
    private static final HashMap<Reason, Integer> counts = new HashMap<>();
    private static final a reassertDuck = new a();
    private static final b restoreTick = new b();
    private static final Runnable confirmRestore = new Runnable() { // from class: com.stepos.ailauncher.chat.media.a
        @Override // java.lang.Runnable
        public final void run() {
            MusicVolumeDucker.w();
        }
    };

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* JADX WARN: Unknown enum class pattern. Please report as an issue! */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, d2 = {"Lcom/stepos/ailauncher/chat/media/MusicVolumeDucker$Reason;", "", "<init>", "(Ljava/lang/String;I)V", "VOICE", "TTS", "chat_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final class Reason {
        private static final /* synthetic */ InterfaceC4149a $ENTRIES;
        private static final /* synthetic */ Reason[] $VALUES;
        public static final Reason VOICE = new Reason("VOICE", 0);
        public static final Reason TTS = new Reason("TTS", 1);

        private static final /* synthetic */ Reason[] $values() {
            return new Reason[]{VOICE, TTS};
        }

        static {
            Reason[] reasonArr$values = $values();
            $VALUES = reasonArr$values;
            $ENTRIES = kotlin.enums.a.a(reasonArr$values);
        }

        private Reason(String str, int i10) {
        }

        public static InterfaceC4149a<Reason> getEntries() {
            return $ENTRIES;
        }

        public static Reason valueOf(String str) {
            return (Reason) Enum.valueOf(Reason.class, str);
        }

        public static Reason[] values() {
            return (Reason[]) $VALUES.clone();
        }
    }

    @Metadata(d1 = {"\u0000\u0011\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u000f\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0003\u0010\u0004¨\u0006\u0005"}, d2 = {"com/stepos/ailauncher/chat/media/MusicVolumeDucker$a", "Ljava/lang/Runnable;", "LY8/t;", "run", "()V", "chat_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final class a implements Runnable {
        @Override // java.lang.Runnable
        public void run() {
            AudioManager audioManagerT;
            Integer num;
            MusicVolumeDucker musicVolumeDucker = MusicVolumeDucker.INSTANCE;
            if (musicVolumeDucker.K() == 0 || (audioManagerT = musicVolumeDucker.t()) == null || (num = MusicVolumeDucker.savedVolume) == null) {
                return;
            }
            int iIntValue = num.intValue();
            int iX = musicVolumeDucker.x(iIntValue);
            int streamVolume = audioManagerT.getStreamVolume(3);
            if (streamVolume != iX) {
                C4148a.k(MusicVolumeDucker.TAG, "reassert duck stream=" + iX + " actual=" + streamVolume + " saved=" + iIntValue, false, 4, null);
                musicVolumeDucker.M(audioManagerT, iX);
            }
            MusicVolumeDucker.handler.postDelayed(this, 250L);
        }
    }

    @Metadata(d1 = {"\u0000\u0011\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u000f\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0003\u0010\u0004¨\u0006\u0005"}, d2 = {"com/stepos/ailauncher/chat/media/MusicVolumeDucker$b", "Ljava/lang/Runnable;", "LY8/t;", "run", "()V", "chat_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final class b implements Runnable {
        @Override // java.lang.Runnable
        public void run() {
            Integer num;
            if (MusicVolumeDucker.restoring) {
                MusicVolumeDucker musicVolumeDucker = MusicVolumeDucker.INSTANCE;
                if (musicVolumeDucker.K() <= 0) {
                    AudioManager audioManagerT = musicVolumeDucker.t();
                    if (audioManagerT == null || (num = MusicVolumeDucker.savedVolume) == null) {
                        return;
                    }
                    int iIntValue = num.intValue();
                    float fM = C5685n.m((SystemClock.elapsedRealtime() - MusicVolumeDucker.restoreStartMs) / 1000, 0.0f, 1.0f);
                    float f10 = 1.0f - fM;
                    int iB = MusicVolumeDucker.restoreFrom + C5227b.b((iIntValue - MusicVolumeDucker.restoreFrom) * (1.0f - (f10 * f10)));
                    musicVolumeDucker.M(audioManagerT, iIntValue >= MusicVolumeDucker.restoreFrom ? C5685n.n(iB, MusicVolumeDucker.restoreFrom, iIntValue) : C5685n.n(iB, iIntValue, MusicVolumeDucker.restoreFrom));
                    if (fM < 1.0f) {
                        MusicVolumeDucker.handler.postDelayed(this, MusicVolumeDucker.TICK_MS);
                        return;
                    }
                    musicVolumeDucker.M(audioManagerT, iIntValue);
                    C4148a.k(MusicVolumeDucker.TAG, "restore complete stream=" + iIntValue, false, 4, null);
                    MusicVolumeDucker.restoring = false;
                    MusicVolumeDucker.handler.postDelayed(MusicVolumeDucker.confirmRestore, 250L);
                    return;
                }
            }
            MusicVolumeDucker.restoring = false;
        }
    }

    public static final t B() {
        MusicVolumeDucker musicVolumeDucker = INSTANCE;
        if (musicVolumeDucker.K() > 0) {
            musicVolumeDucker.L();
            musicVolumeDucker.I();
        }
        return t.f7040a;
    }

    public static final t E(Reason reason) {
        INSTANCE.F(reason);
        return t.f7040a;
    }

    public static final void H(InterfaceC5063a interfaceC5063a) {
        interfaceC5063a.invoke();
    }

    public static final t r(Reason reason) {
        INSTANCE.s(reason);
        return t.f7040a;
    }

    public static final void w() {
        Integer num;
        if (restoring) {
            return;
        }
        MusicVolumeDucker musicVolumeDucker = INSTANCE;
        if (musicVolumeDucker.K() <= 0 && (num = savedVolume) != null) {
            int iIntValue = num.intValue();
            AudioManager audioManagerT = musicVolumeDucker.t();
            if (audioManagerT == null) {
                return;
            }
            musicVolumeDucker.M(audioManagerT, iIntValue);
            C4148a.k(TAG, "restore confirm stream=" + iIntValue, false, 4, null);
            musicVolumeDucker.v();
        }
    }

    public final void A() {
        G(new InterfaceC5063a() { // from class: com.stepos.ailauncher.chat.media.d
            @Override // p9.InterfaceC5063a
            public final Object invoke() {
                return MusicVolumeDucker.B();
            }
        });
    }

    public final Integer C(AudioPlaybackConfiguration config) {
        try {
            Object objInvoke = config.getClass().getMethod("getClientUid", null).invoke(config, null);
            if (objInvoke instanceof Integer) {
                return (Integer) objInvoke;
            }
            return null;
        } catch (Throwable th) {
            if (!playbackUidReadWarned) {
                playbackUidReadWarned = true;
                C4148a.u(TAG, "playback getClientUid unavailable: " + th.getMessage(), false, 4, null);
            }
            return null;
        }
    }

    public final void D(final Reason reason) {
        kotlin.jvm.internal.p.i(reason, "reason");
        G(new InterfaceC5063a() { // from class: com.stepos.ailauncher.chat.media.b
            @Override // p9.InterfaceC5063a
            public final Object invoke() {
                return MusicVolumeDucker.E(reason);
            }
        });
    }

    public final void F(Reason reason) {
        HashMap<Reason, Integer> map = counts;
        Integer num = map.get(reason);
        if (num != null) {
            int iIntValue = num.intValue();
            if (iIntValue <= 1) {
                map.remove(reason);
            } else {
                map.put(reason, Integer.valueOf(iIntValue - 1));
            }
            if (K() > 0) {
                L();
                I();
            } else {
                handler.removeCallbacks(reassertDuck);
                J();
            }
        }
    }

    public final void G(final InterfaceC5063a<t> block) {
        if (kotlin.jvm.internal.p.d(Looper.myLooper(), Looper.getMainLooper())) {
            block.invoke();
        } else {
            handler.post(new Runnable() { // from class: com.stepos.ailauncher.chat.media.e
                @Override // java.lang.Runnable
                public final void run() {
                    MusicVolumeDucker.H(block);
                }
            });
        }
    }

    public final void I() {
        Handler handler2 = handler;
        a aVar = reassertDuck;
        handler2.removeCallbacks(aVar);
        if (K() > 0) {
            handler2.postDelayed(aVar, 250L);
        }
    }

    public final void J() {
        Integer num = savedVolume;
        AudioManager audioManagerT = t();
        if (num == null || audioManagerT == null) {
            v();
            return;
        }
        int streamVolume = audioManagerT.getStreamVolume(3);
        if (streamVolume == num.intValue()) {
            v();
            return;
        }
        restoring = true;
        restoreFrom = streamVolume;
        restoreStartMs = SystemClock.elapsedRealtime();
        Handler handler2 = handler;
        b bVar = restoreTick;
        handler2.removeCallbacks(bVar);
        handler2.removeCallbacks(confirmRestore);
        handler2.post(bVar);
    }

    public final int K() {
        Collection<Integer> collectionValues = counts.values();
        kotlin.jvm.internal.p.h(collectionValues, "<get-values>(...)");
        return F.d1(collectionValues);
    }

    public final void L() {
        AudioManager audioManagerT = t();
        if (audioManagerT == null || K() == 0) {
            return;
        }
        if (!y(audioManagerT)) {
            C4148a.k(TAG, "skip duck, no playing external media holds=" + counts, false, 4, null);
            return;
        }
        if (savedVolume == null) {
            savedVolume = Integer.valueOf(audioManagerT.getStreamVolume(3));
        }
        Integer num = savedVolume;
        if (num != null) {
            int iIntValue = num.intValue();
            int iX = x(iIntValue);
            int streamVolume = audioManagerT.getStreamVolume(3);
            M(audioManagerT, iX);
            C4148a.k(TAG, "duck stream=" + iX + " saved=" + iIntValue + " actual=" + streamVolume + " holds=" + counts, false, 4, null);
        }
    }

    public final void M(AudioManager am, int volume) {
        Object objB;
        Integer num;
        int iN = C5685n.n(volume, 0, C5685n.f(am.getStreamMaxVolume(3), 0));
        if (am.getStreamVolume(3) == iN && (num = lastWritten) != null && num.intValue() == iN) {
            return;
        }
        try {
            Result.Companion companion = Result.INSTANCE;
            am.setStreamVolume(3, iN, 0);
            lastWritten = Integer.valueOf(iN);
            objB = Result.b(t.f7040a);
        } catch (Throwable th) {
            Result.Companion companion2 = Result.INSTANCE;
            objB = Result.b(C4849c.a(th));
        }
        Throwable thE = Result.e(objB);
        if (thE != null) {
            C4148a.t(TAG, "setStreamVolume failed volume=" + iN, thE, false, 8, null);
        }
    }

    public final void q(final Reason reason) {
        kotlin.jvm.internal.p.i(reason, "reason");
        G(new InterfaceC5063a() { // from class: com.stepos.ailauncher.chat.media.c
            @Override // p9.InterfaceC5063a
            public final Object invoke() {
                return MusicVolumeDucker.r(reason);
            }
        });
    }

    public final void s(Reason reason) {
        HashMap<Reason, Integer> map = counts;
        Integer num = map.get(reason);
        map.put(reason, Integer.valueOf((num != null ? num.intValue() : 0) + 1));
        u();
        L();
        I();
    }

    public final AudioManager t() {
        Object systemService = C3197a.INSTANCE.a().getSystemService("audio");
        if (systemService instanceof AudioManager) {
            return (AudioManager) systemService;
        }
        return null;
    }

    public final void u() {
        restoring = false;
        Handler handler2 = handler;
        handler2.removeCallbacks(restoreTick);
        handler2.removeCallbacks(confirmRestore);
    }

    public final void v() {
        u();
        handler.removeCallbacks(reassertDuck);
        savedVolume = null;
        lastWritten = null;
    }

    public final int x(int saved) {
        return saved <= 1 ? saved : C5685n.n(C5227b.b(saved * 0.3f), 1, saved - 1);
    }

    public final boolean y(AudioManager am) {
        Object objB;
        boolean z10;
        int iMyUid = Process.myUid();
        try {
            Result.Companion companion = Result.INSTANCE;
            List<AudioPlaybackConfiguration> activePlaybackConfigurations = am.getActivePlaybackConfigurations();
            kotlin.jvm.internal.p.h(activePlaybackConfigurations, "getActivePlaybackConfigurations(...)");
            List<AudioPlaybackConfiguration> list = activePlaybackConfigurations;
            boolean z11 = false;
            if (!(list instanceof Collection) || !list.isEmpty()) {
                Iterator<T> it = list.iterator();
                while (true) {
                    if (!it.hasNext()) {
                        break;
                    }
                    AudioPlaybackConfiguration audioPlaybackConfiguration = (AudioPlaybackConfiguration) it.next();
                    kotlin.jvm.internal.p.f(audioPlaybackConfiguration);
                    Integer numC = C(audioPlaybackConfiguration);
                    if (numC == null || numC.intValue() != iMyUid) {
                        AudioAttributes audioAttributes = audioPlaybackConfiguration.getAudioAttributes();
                        kotlin.jvm.internal.p.h(audioAttributes, "getAudioAttributes(...)");
                        z10 = z(audioAttributes);
                    } else {
                        z10 = false;
                    }
                    if (z10) {
                        z11 = true;
                        break;
                    }
                }
            }
            objB = Result.b(Boolean.valueOf(z11));
        } catch (Throwable th) {
            Result.Companion companion2 = Result.INSTANCE;
            objB = Result.b(C4849c.a(th));
        }
        Boolean bool = Boolean.FALSE;
        if (Result.g(objB)) {
            objB = bool;
        }
        return ((Boolean) objB).booleanValue();
    }

    public final boolean z(AudioAttributes attr) {
        return attr.getUsage() == 1 || attr.getUsage() == 14 || attr.getContentType() == 2 || attr.getContentType() == 3;
    }
}
