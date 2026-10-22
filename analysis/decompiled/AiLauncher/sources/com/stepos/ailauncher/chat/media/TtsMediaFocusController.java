package com.stepos.ailauncher.chat.media;

import Y8.t;
import Z8.C1173v;
import Z8.C1174w;
import Z8.F;
import Z8.H;
import Z8.I;
import Z8.Q;
import Z8.Y;
import android.app.ActivityManager;
import android.content.ComponentName;
import android.content.Context;
import android.media.AudioAttributes;
import android.media.AudioManager;
import android.media.AudioPlaybackConfiguration;
import android.media.AudioRecordingConfiguration;
import android.os.Handler;
import android.os.Looper;
import android.os.SystemClock;
import androidx.exifinterface.media.ExifInterface;
import com.autonavi.aps.amapapi.config.Const;
import com.stepos.ailauncher.agent.aispace.skill.feishu.C2309e;
import com.stepos.ailauncher.agent.aispace.skill.wecom.C2330a;
import com.stepos.ailauncher.chat.media.MusicVolumeDucker;
import com.stepos.ailauncher.common.utils.MicOccupancyMonitor;
import com.stepos.ailauncher.contract.api.speech.ISpeechService;
import h8.C4148a;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import kotlin.C4849c;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Result;
import p9.InterfaceC5063a;
import p9.InterfaceC5074l;
import v9.C5685n;

@Metadata(d1 = {"\u0000\u008c\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\t\n\u0002\u0010\u0007\n\u0002\b\b\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\b\u0006\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\b\b*\u0002\\m\u0018\u0000 r2\u00020\u0001:\u0001sB\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\u000f\u0010\u0007\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\u0007\u0010\bJ\u000f\u0010\n\u001a\u00020\tH\u0002¢\u0006\u0004\b\n\u0010\u000bJ\u000f\u0010\f\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\f\u0010\bJ\u000f\u0010\r\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\r\u0010\bJ\u000f\u0010\u000e\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\u000e\u0010\bJ\u000f\u0010\u000f\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\u000f\u0010\bJ\u000f\u0010\u0010\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\u0010\u0010\bJ\u000f\u0010\u0011\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\u0011\u0010\bJ\u000f\u0010\u0012\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\u0012\u0010\bJ\u0017\u0010\u0015\u001a\u00020\u00062\u0006\u0010\u0014\u001a\u00020\u0013H\u0002¢\u0006\u0004\b\u0015\u0010\u0016J\u000f\u0010\u0017\u001a\u00020\tH\u0002¢\u0006\u0004\b\u0017\u0010\u000bJ\u000f\u0010\u0018\u001a\u00020\tH\u0002¢\u0006\u0004\b\u0018\u0010\u000bJ\u000f\u0010\u0019\u001a\u00020\tH\u0002¢\u0006\u0004\b\u0019\u0010\u000bJ\u000f\u0010\u001a\u001a\u00020\tH\u0002¢\u0006\u0004\b\u001a\u0010\u000bJ\u000f\u0010\u001b\u001a\u00020\tH\u0002¢\u0006\u0004\b\u001b\u0010\u000bJ\u0017\u0010\u001e\u001a\u00020\t2\u0006\u0010\u001d\u001a\u00020\u001cH\u0002¢\u0006\u0004\b\u001e\u0010\u001fJ\u000f\u0010 \u001a\u00020\tH\u0002¢\u0006\u0004\b \u0010\u000bJ\u000f\u0010!\u001a\u00020\tH\u0002¢\u0006\u0004\b!\u0010\u000bJ\u000f\u0010\"\u001a\u00020\tH\u0002¢\u0006\u0004\b\"\u0010\u000bJ\u000f\u0010#\u001a\u00020\tH\u0002¢\u0006\u0004\b#\u0010\u000bJ\u000f\u0010$\u001a\u00020\tH\u0002¢\u0006\u0004\b$\u0010\u000bJ\u0017\u0010'\u001a\u00020\t2\u0006\u0010&\u001a\u00020%H\u0002¢\u0006\u0004\b'\u0010(J\u0015\u0010*\u001a\b\u0012\u0004\u0012\u00020\u001c0)H\u0002¢\u0006\u0004\b*\u0010+J\u000f\u0010,\u001a\u00020\u0006H\u0002¢\u0006\u0004\b,\u0010\bJ\u000f\u0010-\u001a\u00020\u0006H\u0002¢\u0006\u0004\b-\u0010\bJ\u000f\u0010.\u001a\u00020\tH\u0002¢\u0006\u0004\b.\u0010\u000bJ\u000f\u0010/\u001a\u00020\tH\u0002¢\u0006\u0004\b/\u0010\u000bJ#\u00103\u001a\u00020\t2\u0012\u00102\u001a\u000e\u0012\u0004\u0012\u000201\u0012\u0004\u0012\u00020\u001c00H\u0002¢\u0006\u0004\b3\u00104J\u000f\u00105\u001a\u00020\tH\u0002¢\u0006\u0004\b5\u0010\u000bJ\u000f\u00106\u001a\u00020\tH\u0002¢\u0006\u0004\b6\u0010\u000bJ\u0017\u00108\u001a\u00020\t2\u0006\u00107\u001a\u00020\u001cH\u0002¢\u0006\u0004\b8\u0010\u001fJ\u001b\u00109\u001a\u000e\u0012\u0004\u0012\u000201\u0012\u0004\u0012\u00020\u001c00H\u0002¢\u0006\u0004\b9\u0010:J\u001b\u0010;\u001a\u000e\u0012\u0004\u0012\u000201\u0012\u0004\u0012\u00020\u001c00H\u0002¢\u0006\u0004\b;\u0010:J/\u0010?\u001a\u000e\u0012\u0004\u0012\u000201\u0012\u0004\u0012\u00020\u001c002\u0012\u0010>\u001a\u000e\u0012\u0004\u0012\u00020=\u0012\u0004\u0012\u00020\t0<H\u0002¢\u0006\u0004\b?\u0010@J\u0017\u0010B\u001a\u00020\t2\u0006\u0010A\u001a\u00020=H\u0002¢\u0006\u0004\bB\u0010CJ\r\u0010D\u001a\u00020\u0006¢\u0006\u0004\bD\u0010\bJ\r\u0010E\u001a\u00020\u0006¢\u0006\u0004\bE\u0010\bR\u001c\u0010G\u001a\n F*\u0004\u0018\u00010\u00020\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bG\u0010HR\u0016\u0010J\u001a\u0004\u0018\u00010I8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bJ\u0010KR\u0014\u0010M\u001a\u00020L8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bM\u0010NR\u0016\u0010O\u001a\u00020\t8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bO\u0010PR\u0016\u0010Q\u001a\u00020\t8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bQ\u0010PR\"\u0010R\u001a\u000e\u0012\u0004\u0012\u000201\u0012\u0004\u0012\u00020\u001c008\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bR\u0010SR\u0018\u0010T\u001a\u0004\u0018\u00010\u001c8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bT\u0010UR\u0016\u0010V\u001a\u00020\t8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bV\u0010PR\u0016\u0010W\u001a\u00020\t8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bW\u0010PR\u0016\u0010Y\u001a\u00020X8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bY\u0010$R\u0016\u0010Z\u001a\u00020X8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bZ\u0010$R\u0016\u0010[\u001a\u00020\t8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b[\u0010PR\u0014\u0010]\u001a\u00020\\8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b]\u0010^R*\u0010`\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010_8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b`\u0010a\u001a\u0004\bb\u0010c\"\u0004\bd\u0010eR\u0014\u0010g\u001a\u00020f8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bg\u0010hR\u0014\u0010i\u001a\u00020f8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bi\u0010hR\u0014\u0010j\u001a\u00020f8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bj\u0010hR\u0014\u0010k\u001a\u00020f8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bk\u0010hR\u0014\u0010l\u001a\u00020f8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bl\u0010hR\u0014\u0010n\u001a\u00020m8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bn\u0010oR\u0014\u0010p\u001a\u00020f8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bp\u0010hR\u0016\u0010q\u001a\u00020\u00138\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bq\u0010/¨\u0006t"}, d2 = {"Lcom/stepos/ailauncher/chat/media/TtsMediaFocusController;", "", "Landroid/content/Context;", "context", "<init>", "(Landroid/content/Context;)V", "LY8/t;", "L", "()V", "", "y", "()Z", "x", "z", "i0", "l0", "e0", "h0", "w", "", "gain", "u", "(F)V", "B", "G", "M", "C", "K", "", "source", ExifInterface.GPS_DIRECTION_TRUE, "(I)Z", "N", "H", ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, "I", "J", "Landroid/content/ComponentName;", "component", ExifInterface.LATITUDE_SOUTH, "(Landroid/content/ComponentName;)Z", "", "Y", "()Ljava/util/List;", "b0", "j0", "D", "F", "", "", "current", ExifInterface.LONGITUDE_EAST, "(Ljava/util/Map;)Z", "Q", "P", "streamType", "R", "U", "()Ljava/util/Map;", ExifInterface.LONGITUDE_WEST, "Lkotlin/Function1;", "Landroid/media/AudioAttributes;", "match", ExifInterface.GPS_MEASUREMENT_INTERRUPTED, "(Lp9/l;)Ljava/util/Map;", "attr", "O", "(Landroid/media/AudioAttributes;)Z", "t", "c0", "kotlin.jvm.PlatformType", "appContext", "Landroid/content/Context;", "Landroid/media/AudioManager;", "audioManager", "Landroid/media/AudioManager;", "Landroid/os/Handler;", "mainHandler", "Landroid/os/Handler;", "sessionActive", "Z", "volumeHeld", "baselineMediaCounts", "Ljava/util/Map;", "savedAlarmVolume", "Ljava/lang/Integer;", "duckedForNotify", "restoringNotifyDuck", "", "notifyRestoreStartMs", "answeredSinceMs", "playbackCallbackRegistered", "com/stepos/ailauncher/chat/media/TtsMediaFocusController$c", "playbackCallback", "Lcom/stepos/ailauncher/chat/media/TtsMediaFocusController$c;", "Lkotlin/Function0;", "onFocusLost", "Lp9/a;", "getOnFocusLost", "()Lp9/a;", "g0", "(Lp9/a;)V", "Ljava/lang/Runnable;", "captureBaseline", "Ljava/lang/Runnable;", "recheckNewMedia", "watchIncomingCall", "pollNotifyDuck", "restoreNotifyDuckTick", "com/stepos/ailauncher/chat/media/TtsMediaFocusController$d", "reassertAlarmDuck", "Lcom/stepos/ailauncher/chat/media/TtsMediaFocusController$d;", "restoreAlarmVolume", "lastAppliedDuckGain", "Companion", Const.INTENT_KEY_APIKEY, "chat_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class TtsMediaFocusController {
    private static final long ALARM_REASSERT_MS = 250;
    private static final long ALARM_RESTORE_SETTLE_MS = 300;
    private static final long ANSWER_CONFIRM_MS = 800;
    private static final long BASELINE_SETTLE_MS = 300;
    private static final long CALL_STATE_POLL_MS = 300;
    private static final long NEW_MEDIA_RECHECK_MS = 200;
    private static final float NOTIFY_DUCK_GAIN = 0.2f;
    private static final long NOTIFY_DUCK_POLL_MS = 200;
    private static final long NOTIFY_RESTORE_MS = 600;
    private static final long NOTIFY_RESTORE_TICK_MS = 40;
    private static final String TAG = "TtsMediaFocusCtrl";
    private static final int USAGE_NOTIFY_COMM_DELAYED = 9;
    private static final int USAGE_NOTIFY_COMM_INSTANT = 8;
    private static final int USAGE_NOTIFY_COMM_REQUEST = 7;
    private long answeredSinceMs;
    private final Context appContext;
    private final AudioManager audioManager;
    private Map<String, Integer> baselineMediaCounts;
    private final Runnable captureBaseline;
    private boolean duckedForNotify;
    private float lastAppliedDuckGain;
    private final Handler mainHandler;
    private long notifyRestoreStartMs;
    private InterfaceC5063a<t> onFocusLost;
    private final c playbackCallback;
    private boolean playbackCallbackRegistered;
    private final Runnable pollNotifyDuck;
    private final d reassertAlarmDuck;
    private final Runnable recheckNewMedia;
    private final Runnable restoreAlarmVolume;
    private final Runnable restoreNotifyDuckTick;
    private boolean restoringNotifyDuck;
    private Integer savedAlarmVolume;
    private boolean sessionActive;
    private boolean volumeHeld;
    private final Runnable watchIncomingCall;
    private static final Set<String> VOIP_PACKAGES = Y.j("com.tencent.mm", C2330a.PKG_WECOM, C2309e.PKG_FEISHU, "com.ss.android.lark.oversea", "com.alibaba.android.rimet");

    @Metadata(d1 = {"\u0000\u0011\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010(\n\u0002\b\u0006*\u0001\u0000\b\n\u0018\u00002\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0001J\u0015\u0010\u0003\u001a\b\u0012\u0004\u0012\u00028\u00000\u0002H\u0016¢\u0006\u0004\b\u0003\u0010\u0004J\u0017\u0010\u0006\u001a\u00028\u00012\u0006\u0010\u0005\u001a\u00028\u0000H\u0016¢\u0006\u0004\b\u0006\u0010\u0007¨\u0006\b"}, d2 = {"com/stepos/ailauncher/chat/media/TtsMediaFocusController$b", "LZ8/H;", "", Const.INTENT_KEY_PKGNAME, "()Ljava/util/Iterator;", "element", Const.INTENT_KEY_APIKEY, "(Ljava/lang/Object;)Ljava/lang/Object;", "kotlin-stdlib"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final class b implements H<AudioAttributes, String> {
        final /* synthetic */ Iterable $this_groupingBy;

        public b(Iterable iterable) {
            this.$this_groupingBy = iterable;
        }

        @Override // Z8.H
        public String a(AudioAttributes element) {
            AudioAttributes audioAttributes = element;
            return audioAttributes.getUsage() + "|" + audioAttributes.getContentType() + "|" + audioAttributes.getFlags();
        }

        @Override // Z8.H
        public Iterator<AudioAttributes> b() {
            return this.$this_groupingBy.iterator();
        }
    }

    @Metadata(d1 = {"\u0000\u001b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u001d\u0010\u0006\u001a\u00020\u00052\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002H\u0016¢\u0006\u0004\b\u0006\u0010\u0007¨\u0006\b"}, d2 = {"com/stepos/ailauncher/chat/media/TtsMediaFocusController$c", "Landroid/media/AudioManager$AudioPlaybackCallback;", "", "Landroid/media/AudioPlaybackConfiguration;", "configs", "LY8/t;", "onPlaybackConfigChanged", "(Ljava/util/List;)V", "chat_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final class c extends AudioManager.AudioPlaybackCallback {

        @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
        public static final /* synthetic */ class a {
            public static final /* synthetic */ int[] $EnumSwitchMapping$0;

            static {
                int[] iArr = new int[TtsNewPlaybackGuard.values().length];
                try {
                    iArr[TtsNewPlaybackGuard.STOP.ordinal()] = 1;
                } catch (NoSuchFieldError unused) {
                }
                try {
                    iArr[TtsNewPlaybackGuard.DUCK.ordinal()] = 2;
                } catch (NoSuchFieldError unused2) {
                }
                try {
                    iArr[TtsNewPlaybackGuard.IGNORE.ordinal()] = 3;
                } catch (NoSuchFieldError unused3) {
                }
                $EnumSwitchMapping$0 = iArr;
            }
        }

        public c() {
        }

        @Override // android.media.AudioManager.AudioPlaybackCallback
        public void onPlaybackConfigChanged(List<AudioPlaybackConfiguration> configs) {
            kotlin.jvm.internal.p.i(configs, "configs");
            if (TtsMediaFocusController.this.sessionActive && !TtsMediaFocusController.this.y()) {
                TtsMediaFocusController.this.z();
                int i10 = a.$EnumSwitchMapping$0[r.d(TtsMediaFocusController.this.F(), TtsMediaFocusController.this.D(), TtsMediaFocusController.this.B()).ordinal()];
                if (i10 == 1) {
                    TtsMediaFocusController.this.mainHandler.removeCallbacks(TtsMediaFocusController.this.recheckNewMedia);
                    TtsMediaFocusController.this.mainHandler.postDelayed(TtsMediaFocusController.this.recheckNewMedia, 200L);
                } else if (i10 == 2) {
                    MusicVolumeDucker.INSTANCE.A();
                } else if (i10 != 3) {
                    throw new NoWhenBranchMatchedException();
                }
            }
        }
    }

    @Metadata(d1 = {"\u0000\u0011\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u000f\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0003\u0010\u0004¨\u0006\u0005"}, d2 = {"com/stepos/ailauncher/chat/media/TtsMediaFocusController$d", "Ljava/lang/Runnable;", "LY8/t;", "run", "()V", "chat_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final class d implements Runnable {
        public d() {
        }

        @Override // java.lang.Runnable
        public void run() {
            if (TtsMediaFocusController.this.sessionActive && TtsMediaFocusController.this.savedAlarmVolume != null && TtsMediaFocusController.this.A()) {
                TtsMediaFocusController.this.l0();
                TtsMediaFocusController.this.mainHandler.postDelayed(this, 250L);
            }
        }
    }

    public TtsMediaFocusController(Context context) {
        kotlin.jvm.internal.p.i(context, "context");
        Context applicationContext = context.getApplicationContext();
        this.appContext = applicationContext;
        Object systemService = applicationContext.getSystemService("audio");
        this.audioManager = systemService instanceof AudioManager ? (AudioManager) systemService : null;
        this.mainHandler = new Handler(Looper.getMainLooper());
        this.baselineMediaCounts = kotlin.collections.a.i();
        this.playbackCallback = new c();
        this.captureBaseline = new Runnable() { // from class: com.stepos.ailauncher.chat.media.l
            @Override // java.lang.Runnable
            public final void run() {
                TtsMediaFocusController.v(this.f25613a);
            }
        };
        this.recheckNewMedia = new Runnable() { // from class: com.stepos.ailauncher.chat.media.m
            @Override // java.lang.Runnable
            public final void run() {
                TtsMediaFocusController.a0(this.f25614a);
            }
        };
        this.watchIncomingCall = new Runnable() { // from class: com.stepos.ailauncher.chat.media.n
            @Override // java.lang.Runnable
            public final void run() {
                TtsMediaFocusController.k0(this.f25615a);
            }
        };
        this.pollNotifyDuck = new Runnable() { // from class: com.stepos.ailauncher.chat.media.o
            @Override // java.lang.Runnable
            public final void run() {
                TtsMediaFocusController.Z(this.f25616a);
            }
        };
        this.restoreNotifyDuckTick = new Runnable() { // from class: com.stepos.ailauncher.chat.media.p
            @Override // java.lang.Runnable
            public final void run() {
                TtsMediaFocusController.f0(this.f25617a);
            }
        };
        this.reassertAlarmDuck = new d();
        this.restoreAlarmVolume = new Runnable() { // from class: com.stepos.ailauncher.chat.media.q
            @Override // java.lang.Runnable
            public final void run() {
                TtsMediaFocusController.d0(this.f25618a);
            }
        };
        this.lastAppliedDuckGain = Float.NaN;
    }

    public static final boolean X(AudioAttributes it) {
        kotlin.jvm.internal.p.i(it, "it");
        return it.getContentType() == 3;
    }

    public static final void Z(TtsMediaFocusController ttsMediaFocusController) {
        if (ttsMediaFocusController.sessionActive) {
            if ((ttsMediaFocusController.duckedForNotify || ttsMediaFocusController.restoringNotifyDuck) && !ttsMediaFocusController.y()) {
                if (ttsMediaFocusController.B()) {
                    if (ttsMediaFocusController.restoringNotifyDuck) {
                        ttsMediaFocusController.restoringNotifyDuck = false;
                        ttsMediaFocusController.u(0.2f);
                    }
                    ttsMediaFocusController.mainHandler.postDelayed(ttsMediaFocusController.pollNotifyDuck, 200L);
                    return;
                }
                if (!ttsMediaFocusController.duckedForNotify || ttsMediaFocusController.restoringNotifyDuck) {
                    return;
                }
                C4148a.k(TAG, "alert sound ended -> restore TTS volume", false, 4, null);
                ttsMediaFocusController.h0();
            }
        }
    }

    public static final void a0(TtsMediaFocusController ttsMediaFocusController) {
        if (ttsMediaFocusController.sessionActive && !ttsMediaFocusController.y() && ttsMediaFocusController.F()) {
            C4148a.k(TAG, "new movie playback -> 中断TTS", false, 4, null);
            ttsMediaFocusController.L();
        }
    }

    public static final void d0(TtsMediaFocusController ttsMediaFocusController) {
        if (!ttsMediaFocusController.sessionActive || ttsMediaFocusController.A()) {
            return;
        }
        ttsMediaFocusController.e0();
    }

    public static final void f0(TtsMediaFocusController ttsMediaFocusController) {
        if (ttsMediaFocusController.sessionActive && ttsMediaFocusController.restoringNotifyDuck && !ttsMediaFocusController.y()) {
            if (ttsMediaFocusController.B()) {
                ttsMediaFocusController.restoringNotifyDuck = false;
                ttsMediaFocusController.u(0.2f);
                ttsMediaFocusController.mainHandler.postDelayed(ttsMediaFocusController.pollNotifyDuck, 200L);
                return;
            }
            float fM = C5685n.m((SystemClock.elapsedRealtime() - ttsMediaFocusController.notifyRestoreStartMs) / NOTIFY_RESTORE_MS, 0.0f, 1.0f);
            float f10 = 1.0f - fM;
            ttsMediaFocusController.u(((1.0f - (f10 * f10)) * 0.8f) + 0.2f);
            if (fM < 1.0f) {
                ttsMediaFocusController.mainHandler.postDelayed(ttsMediaFocusController.restoreNotifyDuckTick, NOTIFY_RESTORE_TICK_MS);
                return;
            }
            ttsMediaFocusController.restoringNotifyDuck = false;
            ttsMediaFocusController.duckedForNotify = false;
            ttsMediaFocusController.u(1.0f);
            C4148a.k(TAG, "notify duck restore complete", false, 4, null);
        }
    }

    public static final void k0(TtsMediaFocusController ttsMediaFocusController) {
        if (ttsMediaFocusController.sessionActive) {
            if (!ttsMediaFocusController.y()) {
                ttsMediaFocusController.z();
            }
            if (ttsMediaFocusController.sessionActive) {
                ttsMediaFocusController.mainHandler.postDelayed(ttsMediaFocusController.watchIncomingCall, 300L);
            }
        }
    }

    public static final void v(TtsMediaFocusController ttsMediaFocusController) {
        if (!ttsMediaFocusController.sessionActive) {
            return;
        }
        Map<String, Integer> mapU = ttsMediaFocusController.U();
        LinkedHashMap linkedHashMap = new LinkedHashMap(Q.e(mapU.size()));
        Iterator<T> it = mapU.entrySet().iterator();
        while (true) {
            int iIntValue = 0;
            if (!it.hasNext()) {
                ttsMediaFocusController.baselineMediaCounts = linkedHashMap;
                C4148a.k(TAG, "baseline media=" + linkedHashMap, false, 4, null);
                return;
            }
            Map.Entry entry = (Map.Entry) it.next();
            Object key = entry.getKey();
            String str = (String) entry.getKey();
            int iIntValue2 = ((Number) entry.getValue()).intValue();
            Integer num = ttsMediaFocusController.baselineMediaCounts.get(str);
            if (num != null) {
                iIntValue = num.intValue();
            }
            linkedHashMap.put(key, Integer.valueOf(Math.min(iIntValue2, iIntValue)));
        }
    }

    public final boolean A() {
        List<Integer> listY = Y();
        if ((listY instanceof Collection) && listY.isEmpty()) {
            return false;
        }
        Iterator<T> it = listY.iterator();
        while (it.hasNext()) {
            if (r.b(((Number) it.next()).intValue())) {
                return true;
            }
        }
        return false;
    }

    public final boolean B() {
        if (G() || N() || I()) {
            return true;
        }
        AudioManager audioManager = this.audioManager;
        if (audioManager == null || audioManager.getMode() != 3 || C()) {
            return J();
        }
        return true;
    }

    public final boolean C() {
        Object objB;
        AudioManager audioManager = this.audioManager;
        boolean z10 = false;
        if (audioManager == null) {
            return false;
        }
        try {
            Result.Companion companion = Result.INSTANCE;
            List<AudioRecordingConfiguration> activeRecordingConfigurations = audioManager.getActiveRecordingConfigurations();
            kotlin.jvm.internal.p.h(activeRecordingConfigurations, "getActiveRecordingConfigurations(...)");
            List<AudioRecordingConfiguration> list = activeRecordingConfigurations;
            if (!(list instanceof Collection) || !list.isEmpty()) {
                Iterator<T> it = list.iterator();
                while (true) {
                    if (!it.hasNext()) {
                        break;
                    }
                    if (!((AudioRecordingConfiguration) it.next()).isClientSilenced()) {
                        z10 = true;
                        break;
                    }
                }
            }
            objB = Result.b(Boolean.valueOf(z10));
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

    public final boolean D() {
        return E(U());
    }

    public final boolean E(Map<String, Integer> current) {
        int iIntValue;
        int iIntValue2;
        Iterator<Map.Entry<String, Integer>> it = current.entrySet().iterator();
        do {
            iIntValue = 0;
            if (!it.hasNext()) {
                return false;
            }
            Map.Entry<String, Integer> next = it.next();
            String key = next.getKey();
            iIntValue2 = next.getValue().intValue();
            Integer num = this.baselineMediaCounts.get(key);
            if (num != null) {
                iIntValue = num.intValue();
            }
        } while (iIntValue2 <= iIntValue);
        return true;
    }

    public final boolean F() {
        return E(W());
    }

    public final boolean G() {
        if (P()) {
            return true;
        }
        List<Integer> listY = Y();
        if ((listY instanceof Collection) && listY.isEmpty()) {
            return false;
        }
        Iterator<T> it = listY.iterator();
        while (it.hasNext()) {
            int iIntValue = ((Number) it.next()).intValue();
            if (iIntValue == 5 || iIntValue == 10 || iIntValue == 8 || iIntValue == 9) {
                return true;
            }
        }
        return false;
    }

    public final boolean H() {
        List<Integer> listY = Y();
        if ((listY instanceof Collection) && listY.isEmpty()) {
            return false;
        }
        Iterator<T> it = listY.iterator();
        while (it.hasNext()) {
            if (r.c(((Number) it.next()).intValue())) {
                return true;
            }
        }
        return false;
    }

    public final boolean I() {
        List<Integer> listY = Y();
        if ((listY instanceof Collection) && listY.isEmpty()) {
            return false;
        }
        Iterator<T> it = listY.iterator();
        while (it.hasNext()) {
            if (((Number) it.next()).intValue() == 2) {
                return true;
            }
        }
        return false;
    }

    public final boolean J() {
        Object objB;
        Object systemService = this.appContext.getSystemService("activity");
        List listM = null;
        ActivityManager activityManager = systemService instanceof ActivityManager ? (ActivityManager) systemService : null;
        boolean z10 = false;
        if (activityManager == null) {
            return false;
        }
        try {
            Result.Companion companion = Result.INSTANCE;
            List<ActivityManager.AppTask> appTasks = activityManager.getAppTasks();
            kotlin.jvm.internal.p.h(appTasks, "getAppTasks(...)");
            ArrayList arrayList = new ArrayList();
            Iterator<T> it = appTasks.iterator();
            while (it.hasNext()) {
                ComponentName componentName = ((ActivityManager.AppTask) it.next()).getTaskInfo().topActivity;
                if (componentName != null) {
                    arrayList.add(componentName);
                }
            }
            List<ActivityManager.RunningTaskInfo> runningTasks = activityManager.getRunningTasks(8);
            if (runningTasks != null) {
                listM = new ArrayList();
                Iterator<T> it2 = runningTasks.iterator();
                while (it2.hasNext()) {
                    ComponentName componentName2 = ((ActivityManager.RunningTaskInfo) it2.next()).topActivity;
                    if (componentName2 != null) {
                        listM.add(componentName2);
                    }
                }
            }
            if (listM == null) {
                listM = C1173v.m();
            }
            List listS0 = F.S0(arrayList, listM);
            if (!(listS0 instanceof Collection) || !listS0.isEmpty()) {
                Iterator it3 = listS0.iterator();
                while (true) {
                    if (!it3.hasNext()) {
                        break;
                    }
                    if (S((ComponentName) it3.next())) {
                        z10 = true;
                        break;
                    }
                }
            }
            objB = Result.b(Boolean.valueOf(z10));
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

    public final boolean K() {
        Object objB;
        AudioManager audioManager = this.audioManager;
        boolean z10 = false;
        if (audioManager == null) {
            return false;
        }
        try {
            Result.Companion companion = Result.INSTANCE;
            List<AudioRecordingConfiguration> activeRecordingConfigurations = audioManager.getActiveRecordingConfigurations();
            kotlin.jvm.internal.p.h(activeRecordingConfigurations, "getActiveRecordingConfigurations(...)");
            List<AudioRecordingConfiguration> list = activeRecordingConfigurations;
            if (!(list instanceof Collection) || !list.isEmpty()) {
                Iterator<T> it = list.iterator();
                while (true) {
                    if (!it.hasNext()) {
                        break;
                    }
                    AudioRecordingConfiguration audioRecordingConfiguration = (AudioRecordingConfiguration) it.next();
                    if (!audioRecordingConfiguration.isClientSilenced() && T(audioRecordingConfiguration.getClientAudioSource())) {
                        z10 = true;
                        break;
                    }
                }
            }
            objB = Result.b(Boolean.valueOf(z10));
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

    public final void L() {
        this.mainHandler.removeCallbacks(this.recheckNewMedia);
        com.stepos.ailauncher.chat.tts.a.INSTANCE.a();
        InterfaceC5063a<t> interfaceC5063a = this.onFocusLost;
        if (interfaceC5063a != null) {
            interfaceC5063a.invoke();
        }
        c0();
    }

    public final boolean M() {
        MicOccupancyMonitor micOccupancyMonitor = MicOccupancyMonitor.INSTANCE;
        micOccupancyMonitor.D();
        if (micOccupancyMonitor.r()) {
            return true;
        }
        AudioManager audioManager = this.audioManager;
        if (audioManager != null && audioManager.getMode() == 2) {
            return true;
        }
        if (!K()) {
            this.answeredSinceMs = 0L;
            return false;
        }
        long jElapsedRealtime = SystemClock.elapsedRealtime();
        long j10 = this.answeredSinceMs;
        if (j10 != 0) {
            return jElapsedRealtime - j10 >= 800;
        }
        this.answeredSinceMs = jElapsedRealtime;
        C4148a.k(TAG, "voip capture seen, wait 800ms to confirm answer", false, 4, null);
        return false;
    }

    public final boolean N() {
        AudioManager audioManager = this.audioManager;
        if (audioManager == null) {
            return false;
        }
        return audioManager.getMode() == 1 || Q() || H();
    }

    public final boolean O(AudioAttributes attr) {
        return attr.getUsage() == 1 || attr.getContentType() == 3 || attr.getContentType() == 2;
    }

    public final boolean P() {
        return R(5);
    }

    public final boolean Q() {
        return R(2);
    }

    public final boolean R(int streamType) {
        Object objB;
        AudioManager audioManager = this.audioManager;
        if (audioManager == null) {
            return false;
        }
        try {
            Result.Companion companion = Result.INSTANCE;
            Class cls = Integer.TYPE;
            Object objInvoke = AudioManager.class.getMethod("isStreamActive", cls, cls).invoke(audioManager, Integer.valueOf(streamType), 0);
            kotlin.jvm.internal.p.g(objInvoke, "null cannot be cast to non-null type kotlin.Boolean");
            Boolean bool = (Boolean) objInvoke;
            bool.booleanValue();
            objB = Result.b(bool);
        } catch (Throwable th) {
            Result.Companion companion2 = Result.INSTANCE;
            objB = Result.b(C4849c.a(th));
        }
        Boolean bool2 = Boolean.FALSE;
        if (Result.g(objB)) {
            objB = bool2;
        }
        return ((Boolean) objB).booleanValue();
    }

    public final boolean S(ComponentName component) {
        if (!VOIP_PACKAGES.contains(component.getPackageName())) {
            return false;
        }
        String className = component.getClassName();
        kotlin.jvm.internal.p.h(className, "getClassName(...)");
        String lowerCase = className.toLowerCase(Locale.ROOT);
        kotlin.jvm.internal.p.h(lowerCase, "toLowerCase(...)");
        return La.H.g0(lowerCase, "voip", false, 2, null) || La.H.g0(lowerCase, "multitalk", false, 2, null) || La.H.g0(lowerCase, "ipcall", false, 2, null) || La.H.g0(lowerCase, "videocall", false, 2, null) || La.H.g0(lowerCase, "voicecall", false, 2, null) || La.H.g0(lowerCase, "ringtone", false, 2, null) || La.H.g0(lowerCase, "incoming", false, 2, null) || La.H.g0(lowerCase, "talkui", false, 2, null) || La.H.g0(lowerCase, "meeting", false, 2, null);
    }

    public final boolean T(int source) {
        return source == 7 || source == 4 || source == 2;
    }

    public final Map<String, Integer> U() {
        return V(new TtsMediaFocusController$longMediaCounts$1(this));
    }

    public final Map<String, Integer> V(InterfaceC5074l<? super AudioAttributes, Boolean> match) {
        Object objB;
        AudioManager audioManager = this.audioManager;
        if (audioManager == null) {
            return kotlin.collections.a.i();
        }
        try {
            Result.Companion companion = Result.INSTANCE;
            List<AudioPlaybackConfiguration> activePlaybackConfigurations = audioManager.getActivePlaybackConfigurations();
            kotlin.jvm.internal.p.h(activePlaybackConfigurations, "getActivePlaybackConfigurations(...)");
            ArrayList arrayList = new ArrayList();
            Iterator<T> it = activePlaybackConfigurations.iterator();
            while (it.hasNext()) {
                AudioAttributes audioAttributes = ((AudioPlaybackConfiguration) it.next()).getAudioAttributes();
                if (!match.invoke(audioAttributes).booleanValue()) {
                    audioAttributes = null;
                }
                if (audioAttributes != null) {
                    arrayList.add(audioAttributes);
                }
            }
            objB = Result.b(I.a(new b(arrayList)));
        } catch (Throwable th) {
            Result.Companion companion2 = Result.INSTANCE;
            objB = Result.b(C4849c.a(th));
        }
        Map mapI = kotlin.collections.a.i();
        if (Result.g(objB)) {
            objB = mapI;
        }
        return (Map) objB;
    }

    public final Map<String, Integer> W() {
        return V(new InterfaceC5074l() { // from class: com.stepos.ailauncher.chat.media.k
            @Override // p9.InterfaceC5074l
            public final Object invoke(Object obj) {
                return Boolean.valueOf(TtsMediaFocusController.X((AudioAttributes) obj));
            }
        });
    }

    public final List<Integer> Y() {
        Object objB;
        AudioManager audioManager = this.audioManager;
        if (audioManager == null) {
            return C1173v.m();
        }
        try {
            Result.Companion companion = Result.INSTANCE;
            List<AudioPlaybackConfiguration> activePlaybackConfigurations = audioManager.getActivePlaybackConfigurations();
            kotlin.jvm.internal.p.h(activePlaybackConfigurations, "getActivePlaybackConfigurations(...)");
            List<AudioPlaybackConfiguration> list = activePlaybackConfigurations;
            ArrayList arrayList = new ArrayList(C1174w.x(list, 10));
            Iterator<T> it = list.iterator();
            while (it.hasNext()) {
                arrayList.add(Integer.valueOf(((AudioPlaybackConfiguration) it.next()).getAudioAttributes().getUsage()));
            }
            objB = Result.b(arrayList);
        } catch (Throwable th) {
            Result.Companion companion2 = Result.INSTANCE;
            objB = Result.b(C4849c.a(th));
        }
        List listM = C1173v.m();
        if (Result.g(objB)) {
            objB = listM;
        }
        return (List) objB;
    }

    public final void b0() {
        Object objB;
        AudioManager audioManager = this.audioManager;
        if (audioManager == null || this.playbackCallbackRegistered) {
            return;
        }
        try {
            Result.Companion companion = Result.INSTANCE;
            audioManager.registerAudioPlaybackCallback(this.playbackCallback, this.mainHandler);
            this.playbackCallbackRegistered = true;
            objB = Result.b(t.f7040a);
        } catch (Throwable th) {
            Result.Companion companion2 = Result.INSTANCE;
            objB = Result.b(C4849c.a(th));
        }
        Throwable thE = Result.e(objB);
        if (thE != null) {
            C4148a.t(TAG, "registerAudioPlaybackCallback failed", thE, false, 8, null);
        }
    }

    public final void c0() {
        if (this.sessionActive || this.volumeHeld) {
            this.sessionActive = false;
            if (this.volumeHeld) {
                this.volumeHeld = false;
                MusicVolumeDucker.INSTANCE.D(MusicVolumeDucker.Reason.TTS);
            }
            this.mainHandler.removeCallbacks(this.captureBaseline);
            this.mainHandler.removeCallbacks(this.recheckNewMedia);
            this.mainHandler.removeCallbacks(this.watchIncomingCall);
            this.mainHandler.removeCallbacks(this.pollNotifyDuck);
            this.mainHandler.removeCallbacks(this.restoreNotifyDuckTick);
            this.mainHandler.removeCallbacks(this.reassertAlarmDuck);
            this.mainHandler.removeCallbacks(this.restoreAlarmVolume);
            j0();
            w();
            e0();
            this.answeredSinceMs = 0L;
            this.baselineMediaCounts = kotlin.collections.a.i();
        }
    }

    public final void e0() {
        Object objB;
        Integer num = this.savedAlarmVolume;
        if (num != null) {
            int iIntValue = num.intValue();
            this.savedAlarmVolume = null;
            AudioManager audioManager = this.audioManager;
            if (audioManager == null) {
                return;
            }
            try {
                Result.Companion companion = Result.INSTANCE;
                audioManager.setStreamVolume(4, iIntValue, 0);
                objB = Result.b(Integer.valueOf(C4148a.k(TAG, "restore alarm stream=" + iIntValue, false, 4, null)));
            } catch (Throwable th) {
                Result.Companion companion2 = Result.INSTANCE;
                objB = Result.b(C4849c.a(th));
            }
            Throwable thE = Result.e(objB);
            if (thE != null) {
                C4148a.t(TAG, "restore alarm volume failed", thE, false, 8, null);
            }
        }
    }

    public final void g0(InterfaceC5063a<t> interfaceC5063a) {
        this.onFocusLost = interfaceC5063a;
    }

    public final void h0() {
        if (this.duckedForNotify) {
            this.restoringNotifyDuck = true;
            this.notifyRestoreStartMs = SystemClock.elapsedRealtime();
            this.mainHandler.removeCallbacks(this.pollNotifyDuck);
            this.mainHandler.removeCallbacks(this.restoreNotifyDuckTick);
            this.mainHandler.post(this.restoreNotifyDuckTick);
        }
    }

    public final void i0() {
        if (this.sessionActive) {
            if (!A()) {
                if (this.savedAlarmVolume != null) {
                    this.mainHandler.removeCallbacks(this.reassertAlarmDuck);
                    this.mainHandler.removeCallbacks(this.restoreAlarmVolume);
                    this.mainHandler.postDelayed(this.restoreAlarmVolume, 300L);
                    return;
                }
                return;
            }
            this.mainHandler.removeCallbacks(this.restoreAlarmVolume);
            if (this.savedAlarmVolume == null) {
                AudioManager audioManager = this.audioManager;
                Integer numValueOf = audioManager != null ? Integer.valueOf(audioManager.getStreamVolume(4)) : null;
                this.savedAlarmVolume = numValueOf;
                C4148a.k(TAG, "alarm playback -> duck alarm stream saved=" + numValueOf, false, 4, null);
            }
            l0();
            this.mainHandler.removeCallbacks(this.reassertAlarmDuck);
            this.mainHandler.postDelayed(this.reassertAlarmDuck, 250L);
        }
    }

    public final void j0() {
        AudioManager audioManager = this.audioManager;
        if (audioManager != null && this.playbackCallbackRegistered) {
            this.playbackCallbackRegistered = false;
            try {
                Result.Companion companion = Result.INSTANCE;
                audioManager.unregisterAudioPlaybackCallback(this.playbackCallback);
                Result.b(t.f7040a);
            } catch (Throwable th) {
                Result.Companion companion2 = Result.INSTANCE;
                Result.b(C4849c.a(th));
            }
        }
    }

    public final void l0() {
        Integer num;
        int iIntValue;
        int iA;
        Object objB;
        AudioManager audioManager = this.audioManager;
        if (audioManager == null || (num = this.savedAlarmVolume) == null || audioManager.getStreamVolume(4) == (iA = r.a((iIntValue = num.intValue())))) {
            return;
        }
        try {
            Result.Companion companion = Result.INSTANCE;
            audioManager.setStreamVolume(4, iA, 0);
            objB = Result.b(Integer.valueOf(C4148a.k(TAG, "duck alarm stream=" + iA + " saved=" + iIntValue, false, 4, null)));
        } catch (Throwable th) {
            Result.Companion companion2 = Result.INSTANCE;
            objB = Result.b(C4849c.a(th));
        }
        Throwable thE = Result.e(objB);
        if (thE != null) {
            C4148a.t(TAG, "duck alarm volume failed", thE, false, 8, null);
        }
    }

    public final void t() {
        if (this.sessionActive) {
            return;
        }
        this.sessionActive = true;
        if (!this.volumeHeld) {
            MusicVolumeDucker.INSTANCE.q(MusicVolumeDucker.Reason.TTS);
            this.volumeHeld = true;
        }
        this.baselineMediaCounts = U();
        this.mainHandler.removeCallbacks(this.captureBaseline);
        this.mainHandler.postDelayed(this.captureBaseline, 300L);
        b0();
        this.mainHandler.removeCallbacks(this.watchIncomingCall);
        this.mainHandler.post(this.watchIncomingCall);
        C4148a.k(TAG, "acquire: duck music stream volume without audio focus", false, 4, null);
    }

    public final void u(float gain) {
        if (this.lastAppliedDuckGain == gain) {
            return;
        }
        this.lastAppliedDuckGain = gain;
        ISpeechService iSpeechService = (ISpeechService) D5.a.INSTANCE.a(ISpeechService.class);
        if (iSpeechService != null) {
            iSpeechService.setSpeakDuckGain(gain);
        }
    }

    public final void w() {
        this.mainHandler.removeCallbacks(this.pollNotifyDuck);
        this.mainHandler.removeCallbacks(this.restoreNotifyDuckTick);
        boolean z10 = this.duckedForNotify || this.restoringNotifyDuck;
        this.duckedForNotify = false;
        this.restoringNotifyDuck = false;
        this.notifyRestoreStartMs = 0L;
        this.lastAppliedDuckGain = Float.NaN;
        if (z10) {
            u(1.0f);
        }
    }

    public final void x() {
        this.restoringNotifyDuck = false;
        this.mainHandler.removeCallbacks(this.restoreNotifyDuckTick);
        if (!this.duckedForNotify) {
            this.duckedForNotify = true;
            C4148a.k(TAG, "alert sound -> duck TTS gain=0.2", false, 4, null);
            u(0.2f);
        }
        this.mainHandler.removeCallbacks(this.pollNotifyDuck);
        this.mainHandler.postDelayed(this.pollNotifyDuck, 200L);
    }

    public final boolean y() {
        if (!M()) {
            return false;
        }
        C4148a.k(TAG, "call answered -> stop TTS", false, 4, null);
        L();
        return true;
    }

    public final void z() {
        i0();
        if (B()) {
            x();
        } else {
            if (!this.duckedForNotify || this.restoringNotifyDuck) {
                return;
            }
            C4148a.k(TAG, "alert sound ended -> restore TTS volume", false, 4, null);
            h0();
        }
    }
}
