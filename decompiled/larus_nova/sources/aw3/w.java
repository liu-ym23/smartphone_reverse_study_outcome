package aw3;

import android.os.Handler;
import android.os.Looper;
import androidx.camera.video.AudioStats;
import com.bytedance.applet.audio.background.AppletBackgroundAudioMediaSessionService;
import com.bytedance.applet.audio.background.BackgroundAudioEventName;
import com.bytedance.applet.audio.background.BackgroundAudioPlaybackState;
import com.google.gson.JsonObject;
import com.larus.apm.impl.protector.RunnableProtector;
import com.larus.audio.controller.GlobalAudioController;
import com.larus.audio.controller.GlobalAudioStateEnum;
import com.larus.audio.observer.GlobalAudioObserver;
import com.larus.audioplayer.api.music.MusicPlayManagerDelegate;
import com.larus.utils.logger.FLogger;
import com.obric.aiagent.assistant.idl.IFlowAppIntentIDL;
import com.ss.android.downloadad.api.model.NativeDownloadModel;
import com.ss.android.dypay.api.DyPayConstant;
import java.lang.ref.SoftReference;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArrayList;
import kotlin.Lazy;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.ranges.RangesKt;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes14.dex */
public final class w implements p0.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final w f16506a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static q0 f16507b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final Map<String, q0> f16508c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final Set<BackgroundAudioEventName> f16509d = null;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static p0 f16510e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static Double f16511f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static boolean f16512g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static boolean f16513h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static boolean f16514i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static final b f16515j = null;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public static String f16516k;

    public /* synthetic */ class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f16517a = null;

        static {
            int[] r100 = new int[BackgroundAudioPlaybackState.values().length];
            r100[BackgroundAudioPlaybackState.PLAYING.ordinal()] = 1;     // Catch: NoSuchFieldError -> L9
        L13:
            r100[BackgroundAudioPlaybackState.PAUSED.ordinal()] = 2;     // Catch: NoSuchFieldError -> L10
        L19:
            r100[BackgroundAudioPlaybackState.STOPPED.ordinal()] = 3;     // Catch: NoSuchFieldError -> L11
        L15:
            r100[BackgroundAudioPlaybackState.ERROR.ordinal()] = 4;     // Catch: NoSuchFieldError -> L12
        L7:
            f16517a = r100;
        }
    }

    public static final class b implements Runnable {
        public b() {
        }

        public final void a() {
            p0 r100 = w.f16510e;
            if (r100 != null) goto L5;
        L9:
            w.f16514i = false;
            return;
        L5:
            if (w.f16507b.f16491m != BackgroundAudioPlaybackState.PLAYING) goto L9;
            w r101 = w.f16506a;
            w.u(r100);
            w.s(r101, BackgroundAudioEventName.TIMEUPDATE, q0.a(w.f16507b), null, null, 12);
            com.larus.utils.y.b().postDelayed(this, 250);
        }

        @Override // java.lang.Runnable
        public final void run() {
            a();     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }
    }

    public w() {
    }

    static {
        f16506a = new w();
        f16507b = new q0(0);
        f16508c = new LinkedHashMap();
        f16509d = new LinkedHashSet();
        f16513h = true;
        f16515j = new b();
    }

    public static void D() {
        final p0 r100 = f16510e;
        if (r100 != null) goto L5;
        return;
    L5:
        f16510e = null;
        f16511f = null;
        boolean r101 = false;
        f16512g = false;
        f16513h = true;
        F();
        boolean r102 = r100.f16474f.isWorking();
        final Ref.BooleanRef r103 = new Ref.BooleanRef();
        Function0<Unit> r104 = new g(r103, r100);
        if (r100.f16471c == true) goto L9;
        r100.f16474f.g(r104);
        r101 = true;
    L9:
        if (r101 == false) goto L14;
        if (r102 == false) goto L12;
    L17:
        FLogger.f375446a.i("AppletBackgroundAudioManager", "current player detached. stopped: " + r101 + ", wasWorking: " + r102);
        return;
    L12:
        if (r103.element == true) goto L17;
    L14:
        if (r100.f16471c == true) goto L17;
        r100.f16471c = true;
        r100.f16474f.release();
        goto L17
    }

    public static void F() {
        if (f16514i == true) goto L5;
        return;
    L5:
        f16514i = false;
        SoftReference<Handler> r100 = com.larus.utils.y.f375498a;
        b r101 = f16515j;
        Intrinsics.checkNotNullParameter(r101, "action");
        com.larus.utils.y.a(r101);
    }

    public static q0 o() {
        H("mediaSessionStateSnapshot");
        if (f16516k == null) goto L18;
        String r100 = f16507b.f16479a;
        if (r100 != null) goto L7;
    L10:
        boolean r101 = true;
    L11:
        if (r101 == true) goto L20;
        p0 r102 = f16510e;
        if (r102 == null) goto L17;
        u(r102);
    L17:
        return q0.a(f16507b);
    L20:
        return null;
    L7:
        if (StringsKt.isBlank(r100) == true) goto L10;
        r101 = false;
        goto L11
    L18:
        return null;
    }

    public static q0 C(String r100) {
        H("stateForApplet");
        if (n(r100) == false) goto L9;
        p0 r101 = f16510e;
        if (r101 == null) goto L10;
        u(r101);
    L10:
        return q0.a(f16507b);
    L9:
        return j(r100);
    }

    public static void H(String r100) {
        if (Intrinsics.areEqual(Looper.myLooper(), Looper.getMainLooper()) == true) goto L6;
        FLogger.f375446a.e("AppletBackgroundAudioManager", r100.concat(" should run on main thread"));
        return;
    }

    public static q0 j(String r100) {
        String r101 = p(r100);
        if (r101 == null) goto L5;
        q0 r102 = (q0) ((LinkedHashMap) f16508c).get(r101);
        if (r102 == null) goto L10;
        return q0.a(r102);
    L10:
        return new q0(0);
    L5:
        return new q0(0);
    }

    public static void l(final p0 r100) {
        Double r101 = f16511f;
        if (r101 == null) goto L6;
        final double r102 = r101.doubleValue();
        f16511f = null;
        r100.e(r102, new j(r100, r102));
        FLogger.f375446a.i("AppletBackgroundAudioManager", "initial seek requested. position: " + r102);
        return;
    }

    public static boolean m(p0 r100) {
        if (f16510e != r100) goto L5;
        return true;
    L5:
        return false;
    }

    public static boolean n(String r100) {
        String r101 = f16516k;
        if (r101 != null) goto L7;
        return false;
    L7:
        return Intrinsics.areEqual(r101, p(r100));
    }

    public static String p(String r100) {
        if (r100 != null) goto L4;
    L6:
        return null;
    L4:
        if ((!StringsKt.isBlank(r100)) == false) goto L6;
        return r100;
    }

    public static void u(p0 r110) {
        q0 r100 = f16507b;
        double r101 = ((double) RangesKt.coerceAtLeast(r110.f16474f.f(), 0)) / 1000.0d;
        double r102 = ((double) RangesKt.coerceAtLeast(r110.f16474f.getAudioDuration(), 0)) / 1000.0d;
        double r103 = ((double) RangesKt.coerceAtLeast(r110.f16474f.f(), 0)) / 1000.0d;
        double r111 = ((double) RangesKt.coerceAtLeast(r110.f16474f.getAudioDuration(), 0)) / 1000.0d;
        int r104 = RangesKt.coerceIn(r110.f16474f.k(), 0, 100);
        if (r111 <= AudioStats.AUDIO_AMPLITUDE_NONE) goto L5;
        double r112 = (r111 * ((double) r104)) / 100.0d;
    L6:
        double r105 = RangesKt.coerceAtLeast(r112, r103);
        int r106 = p0.f16468g;
        Double r113 = Double.valueOf(p0.a.a(r110.f16474f.e()));
        r100.getClass();
        r100.f16486h = RangesKt.coerceAtLeast(r101, AudioStats.AUDIO_AMPLITUDE_NONE);
        r100.f16487i = RangesKt.coerceAtLeast(r102, AudioStats.AUDIO_AMPLITUDE_NONE);
        r100.f16489k = RangesKt.coerceAtLeast(r105, AudioStats.AUDIO_AMPLITUDE_NONE);
        if (r113 == null) goto L10;
        r100.f16490l = r113.doubleValue();
        return;
    L10:
        return;
    L5:
        r112 = 0.0d;
        goto L6
    }

    public static void z(final Function0 r100) {
        if (Intrinsics.areEqual(Looper.myLooper(), Looper.getMainLooper()) == false) goto L5;
        r100.invoke();
        return;
    L5:
        com.larus.utils.y.c(new f(r100));
    }

    public final l0 E(String r100) {
        H("stopForApplet");
        if (f16516k != null) goto L7;
        return new l0(j(r100), null);
    L7:
        if (n(r100) == false) goto L9;
        FLogger r101 = FLogger.f375446a;
        StringBuilder r102 = new StringBuilder("stop requested. appletId: ");
        String r103 = p(r100);
        String r104 = "";
        if (r103 != null) goto L13;
        r103 = "";
    L13:
        r102.append(r103);
        r102.append(", owner: ");
        String r105 = f16516k;
        if (r105 == null) goto L17;
        r104 = r105;
    L17:
        r102.append(r104);
        r102.append(", state: ");
        r102.append(f16507b.b());
        r101.i("AppletBackgroundAudioManager", r102.toString());
        D();
        f16507b.e(BackgroundAudioPlaybackState.STOPPED);
        f16507b.d(AudioStats.AUDIO_AMPLITUDE_NONE);
        CopyOnWriteArrayList<Function1<AppletBackgroundAudioMediaSessionService, Unit>> r106 = g0.f16422a;
        g0.c(q0.a(f16507b));
        G(this, q0.a(f16507b));
        s(this, BackgroundAudioEventName.STOP, q0.a(f16507b), null, null, 12);
        return new l0(q0.a(f16507b), null);
    L9:
        return v(m0.f16452g, r100, "stop");
    }

    @Override // aw3.p0.b
    public final void a(final p0 r100) {
        Intrinsics.checkNotNullParameter(r100, "player");
        z(new aw3.b(r100));
    }

    @Override // aw3.p0.b
    public final void b(final p0 r100) {
        Intrinsics.checkNotNullParameter(r100, "player");
        z(new i(r100));
    }

    @Override // aw3.p0.b
    public final void c(final p0 r100) {
        Intrinsics.checkNotNullParameter(r100, "player");
        z(new h(r100));
    }

    @Override // aw3.p0.b
    public final void d(final p0 r100) {
        Intrinsics.checkNotNullParameter(r100, "player");
        z(new d(r100));
    }

    @Override // aw3.p0.b
    public final void g(final p0 r100) {
        Intrinsics.checkNotNullParameter(r100, "player");
        z(new u(r100));
    }

    @Override // aw3.p0.b
    public final void h(final p0 r100) {
        Intrinsics.checkNotNullParameter(r100, "player");
        z(new s(r100));
    }

    @Override // aw3.p0.b
    public final void i(final p0 r100) {
        Intrinsics.checkNotNullParameter(r100, "player");
        z(new c(r100));
    }

    public final l0 q(String r100) {
        H("pauseForApplet");
        if (f16516k != null) goto L7;
        return new l0(j(r100), null);
    L7:
        if (n(r100) == false) goto L9;
        FLogger r101 = FLogger.f375446a;
        StringBuilder r102 = new StringBuilder("pause requested. appletId: ");
        String r103 = p(r100);
        String r104 = "";
        if (r103 != null) goto L13;
        r103 = "";
    L13:
        r102.append(r103);
        r102.append(", owner: ");
        String r105 = f16516k;
        if (r105 == null) goto L17;
        r104 = r105;
    L17:
        r102.append(r104);
        r102.append(", state: ");
        r102.append(f16507b.b());
        r101.i("AppletBackgroundAudioManager", r102.toString());
        p0 r106 = f16510e;
        boolean r107 = false;
        if (r106 != null) goto L20;
    L25:
        if (r107 == false) goto L28;
        return new l0(q0.a(f16507b), null);
    L28:
        return x(m0.f16451f);
    L20:
        if (r106.f16471c == false) goto L22;
        boolean r108 = false;
    L23:
        if (r108 != true) goto L25;
        r107 = true;
        goto L25
    L22:
        r106.f16474f.h(false, "background_audio");
        r108 = true;
        goto L23
    L9:
        return v(m0.f16452g, r100, "pause");
    }

    public final l0 r(String r110) {
        H("playForApplet");
        String r100 = p(r110);
        if (r100 != null) goto L7;
        return v(m0.f16455j, r110, "play");
    L7:
        if (n(r100) == true) goto L19;
        String r111 = j(r100).f16479a;
        if (r111 != null) goto L11;
    L14:
        boolean r112 = true;
    L15:
        if (r112 == true) goto L17;
        k(r100, "play");
        goto L19
    L17:
        return v(m0.f16448c, r100, "play");
    L11:
        if (r111.length() == 0) goto L14;
        r112 = false;
    L19:
        String r113 = f16507b.f16479a;
        if (r113 != null) goto L22;
    L25:
        boolean r114 = true;
    L26:
        if (r114 == true) goto L28;
        FLogger r115 = FLogger.f375446a;
        StringBuilder r101 = new StringBuilder("play requested. appletId: ");
        r101.append(r100);
        r101.append(", owner: ");
        String r102 = f16516k;
        String r103 = "";
        if (r102 != null) goto L32;
        r102 = "";
    L32:
        r101.append(r102);
        r101.append(", state: ");
        r101.append(f16507b.b());
        r115.i("AppletBackgroundAudioManager", r101.toString());
        String r104 = f16507b.f16479a;
        if (r104 != null) goto L35;
    L69:
        p0 r105 = null;
    L70:
        if (r105 == null) goto L72;
        f16512g = false;
        f16513h = false;
        q0 r106 = q0.a(f16507b);
        Intrinsics.checkNotNullParameter(r106, "state");
        if (r105.f16471c == false) goto L76;
    L79:
        StringBuilder r107 = new StringBuilder("play rejected. released: ");
        r107.append(r105.f16471c);
        r107.append(", hasUrl: ");
        r107.append(!StringsKt.isBlank(r105.f16470b));
        r115.e("BackgroundAudioPlayer", r107.toString());
        m0 r108 = m0.f16451f;
    L80:
        if (r108 != null) goto L90;
        if (MusicPlayManagerDelegate.f290176b.d() == false) goto L94;
        String r109 = f16516k;
        if (r109 == null) goto L87;
        r103 = r109;
    L87:
        r115.i("AppletBackgroundAudioManager", "background audio takeover requested applet music stop. owner: ".concat(r103));
    L94:
        return new l0(q0.a(f16507b), null);
    L90:
        if (f16507b.f16491m != BackgroundAudioPlaybackState.ERROR) goto L93;
        return new l0(q0.a(f16507b), r108);
    L93:
        return x(r108);
    L76:
        if (StringsKt.isBlank(r105.f16470b) == true) goto L79;
        r105.f16473e = null;
        r105.f(r106);
        r105.f16474f.i("background_audio");
        r108 = r105.f16473e;
        goto L80
    L72:
        return x(m0.f16451f);
    L35:
        if ((!StringsKt.isBlank(r104)) == true) goto L38;
        r104 = null;
    L38:
        if (r104 == null) goto L69;
        r105 = f16510e;
        if (r105 == null) goto L43;
        String r116 = r105.f16470b;
    L45:
        if (Intrinsics.areEqual(r116, r104) == false) goto L47;
        r105.f(q0.a(f16507b));
        CopyOnWriteArrayList<Function1<AppletBackgroundAudioMediaSessionService, Unit>> r117 = g0.f16422a;
        g0.a(q0.a(f16507b));
        goto L70
    L47:
        D();
        Double r118 = Double.valueOf(f16507b.f16485g);
        double r119 = r118.doubleValue();
        if (Double.isInfinite(r119) == false) goto L50;
    L52:
        boolean r120 = false;
    L53:
        if (r120 == true) goto L55;
    L57:
        boolean r121 = false;
    L58:
        if (r121 == true) goto L61;
        r118 = null;
    L61:
        f16511f = r118;
        r105 = new p0(q0.a(f16507b), this);
        f16510e = r105;
        f16512g = false;
        f16513h = false;
        StringBuilder r122 = new StringBuilder("new player created. owner: ");
        String r123 = f16516k;
        if (r123 != null) goto L64;
        r123 = "";
    L64:
        r122.append(r123);
        r122.append(", hasInitialSeek: ");
        if (f16511f == null) goto L67;
        boolean r124 = true;
    L68:
        r122.append(r124);
        r122.append(", state: ");
        r122.append(f16507b.b());
        r115.i("AppletBackgroundAudioManager", r122.toString());
        goto L70
    L67:
        r124 = false;
        goto L68
    L55:
        if (r119 <= AudioStats.AUDIO_AMPLITUDE_NONE) goto L57;
        r121 = true;
        goto L58
    L50:
        if (Double.isNaN(r119) == true) goto L52;
        r120 = true;
        goto L53
    L43:
        r116 = null;
        goto L45
    L28:
        return x(m0.f16448c);
    L22:
        if (r113.length() == 0) goto L25;
        r114 = false;
        goto L26
    }

    public final l0 x(m0 r100) {
        F();
        f16507b.e(BackgroundAudioPlaybackState.ERROR);
        f16513h = true;
        q0 r101 = q0.a(f16507b);
        CopyOnWriteArrayList<Function1<AppletBackgroundAudioMediaSessionService, Unit>> r102 = g0.f16422a;
        Intrinsics.checkNotNullParameter(r101, "state");
        Intrinsics.checkNotNullParameter(r100, "error");
        FLogger r103 = FLogger.f375446a;
        r103.e("AppletBackgroundAudioMediaSessionController", "media session error. errorCode: " + r100.f16456a + ", state: " + r101.b());
        GlobalAudioController.f289658a.d(g0.f16423b);
        g0.f16422a.clear();
        g0.e(new d0(new y()));
        GlobalAudioObserver.f289772a.f("plugin_background_audio", Integer.valueOf(r100.f16456a), null);
        g0.f(GlobalAudioStateEnum.STOPPED, f16516k);
        G(this, r101);
        StringBuilder r104 = new StringBuilder("background audio error. owner: ");
        String r105 = f16516k;
        if (r105 != null) goto L5;
        r105 = "";
    L5:
        r104.append(r105);
        r104.append(", errorCode: ");
        r104.append(r100.f16456a);
        r104.append(", errorMsg: ");
        r104.append(r100.f16457b);
        r104.append(", state: ");
        r104.append(r101.b());
        r103.e("AppletBackgroundAudioManager", r104.toString());
        s(this, BackgroundAudioEventName.ERROR, r101, r100, null, 8);
        return new l0(r101, r100);
    }

    public static boolean B(String r100, q0 r101) {
        if (r100 != null) goto L6;
        return false;
    L6:
        if (f16510e != null) goto L8;
    L10:
        boolean r102 = false;
    L11:
        if (r102 == false) goto L13;
    L14:
        return true;
    L13:
        if (r101.f16491m != BackgroundAudioPlaybackState.STOPPED) goto L14;
        return false;
    L8:
        if (f16513h == true) goto L10;
        r102 = true;
        goto L11
    }

    public static void G(w r100, q0 r101) {
        String r102 = f16516k;
        r100.getClass();
        com.bytedance.applet.task.b.f192232a.getClass();
        com.bytedance.applet.task.b.b(r101, r102);
    }

    public static void w(String r100, String r101) {
        Intrinsics.checkNotNullParameter(r101, "reason");
        final String r102 = p(r100);
        if (r102 != null) goto L6;
        FLogger.f375446a.i("AppletBackgroundAudioManager", "release ignored from lifecycle. reason: " + r101 + ", appletId missing");
        return;
    L6:
        FLogger.f375446a.i("AppletBackgroundAudioManager", "release requested from lifecycle. reason: " + r101 + ", appletId: " + r102);
        z(new v(r102));
    }

    public final l0 A(double r110, String r111) {
        H("seekToForApplet");
        if (f16516k != null) goto L7;
        return new l0(j(r111), null);
    L7:
        if (n(r111) == true) goto L11;
        return v(m0.f16452g, r111, "seek");
    L11:
        if (Double.isInfinite(r110) == false) goto L13;
    L15:
        boolean r100 = false;
    L16:
        final double r101 = AudioStats.AUDIO_AMPLITUDE_NONE;
        if (r100 == false) goto L19;
        r101 = RangesKt.coerceAtLeast(r110, AudioStats.AUDIO_AMPLITUDE_NONE);
    L19:
        f16507b.d(r101);
        FLogger r102 = FLogger.f375446a;
        StringBuilder r103 = new StringBuilder("seek requested. appletId: ");
        String r112 = p(r111);
        String r104 = "";
        if (r112 != null) goto L22;
        r112 = "";
    L22:
        r103.append(r112);
        r103.append(", owner: ");
        String r113 = f16516k;
        if (r113 == null) goto L26;
        r104 = r113;
    L26:
        r103.append(r104);
        r103.append(", position: ");
        r103.append(r101);
        r103.append(", rawPosition: ");
        r103.append(r110);
        r102.i("AppletBackgroundAudioManager", r103.toString());
        s(this, BackgroundAudioEventName.SEEKING, q0.a(f16507b), null, null, 12);
        final p0 r114 = f16510e;
        if (r114 != null) goto L31;
        return x(m0.f16451f);
    L31:
        if (r114.e(r101, new t(r114, r101)) == false) goto L34;
        return new l0(q0.a(f16507b), null);
    L34:
        return x(m0.f16450e);
    L13:
        if (Double.isNaN(r110) == true) goto L15;
        r100 = true;
        goto L16
    }

    @Override // aw3.p0.b
    public final void e(final p0 r100, final String r101) {
        Intrinsics.checkNotNullParameter(r100, "player");
        Intrinsics.checkNotNullParameter(r101, "reason");
        z(new k(r100, r101));
    }

    @Override // aw3.p0.b
    public final void f(final p0 r100, final m0 r101) {
        Intrinsics.checkNotNullParameter(r100, "player");
        Intrinsics.checkNotNullParameter(r101, "error");
        z(new e(r100, r101));
    }

    public final void k(String r100, String r101) {
        String r102 = p(r100);
        if (Intrinsics.areEqual(f16516k, r102) == false) goto L5;
        return;
    L5:
        String r103 = f16516k;
        q0 r104 = q0.a(f16507b);
        boolean r105 = B(r103, r104);
        D();
        f16516k = r102;
        if (r102 == null) goto L9;
        q0 r106 = f16508c.remove(r102);
        if (r106 == null) goto L9;
    L10:
        f16507b = r106;
        f16511f = null;
        FLogger r107 = FLogger.f375446a;
        StringBuilder r108 = new StringBuilder("owner changed. reason: ");
        r108.append(r101);
        r108.append(", previous: ");
        if (r103 != null) goto L13;
        String r109 = "";
    L14:
        r108.append(r109);
        r108.append(", next: ");
        if (r102 != null) goto L17;
        r102 = "";
    L17:
        r108.append(r102);
        r108.append(", previousState: ");
        r108.append(r104.b());
        r108.append(", nextState: ");
        r108.append(f16507b.b());
        r107.i("AppletBackgroundAudioManager", r108.toString());
        if (r105 == false) goto L21;
        r104.e(BackgroundAudioPlaybackState.STOPPED);
        r104.d(AudioStats.AUDIO_AMPLITUDE_NONE);
        g0.c(r104);
        com.bytedance.applet.task.b.f192232a.getClass();
        com.bytedance.applet.task.b.b(r104, r103);
        s(this, BackgroundAudioEventName.STOP, r104, null, r103, 4);
        return;
    L21:
        return;
    L13:
        r109 = r103;
    L9:
        r106 = new q0(0);
        goto L10
    }

    public final void t(BackgroundAudioEventName r100, String r101) {
        p0 r102 = f16510e;
        if (r102 == null) goto L5;
        u(r102);
    L5:
        FLogger.f375446a.i("AppletBackgroundAudioManager", "media session track event. event: " + r100.getValue() + ", appletId: " + r101);
        s(this, r100, q0.a(f16507b), null, r101, 4);
    }

    public final void y(m0 r100, String r101) {
        if (f16512g == false) goto L6;
        FLogger.f375446a.i("AppletBackgroundAudioManager", "player error ignored. reason: already reported, source: " + r101 + ", errorCode: " + r100.f16456a);
        return;
    L6:
        f16512g = true;
        F();
        x(r100);
    }

    public static l0 v(m0 r100, String r101, String r102) {
        q0 r103 = C(r101);
        FLogger r104 = FLogger.f375446a;
        StringBuilder r105 = new StringBuilder("action rejected. action: ");
        r105.append(r102);
        r105.append(", appletId: ");
        String r106 = p(r101);
        String r107 = "";
        if (r106 != null) goto L5;
        r106 = "";
    L5:
        r105.append(r106);
        r105.append(", owner: ");
        String r108 = f16516k;
        if (r108 == null) goto L9;
        r107 = r108;
    L9:
        r105.append(r107);
        r105.append(", error: ");
        r105.append(r100.f16457b);
        r104.e("AppletBackgroundAudioManager", r105.toString());
        return new l0(r103, r100);
    }

    public static void s(w r100, BackgroundAudioEventName r101, q0 r102, m0 r103, String r104, int r105) {
        Integer r106 = null;
        if ((r105 & 4) == 0) goto L6;
        r103 = null;
    L6:
        if ((r105 & 8) == 0) goto L8;
        r104 = f16516k;
    L8:
        r100.getClass();
        if (r101 == BackgroundAudioEventName.TIMEUPDATE) goto L18;
        FLogger r107 = FLogger.f375446a;
        StringBuilder r108 = new StringBuilder("publish event. event: ");
        r108.append(r101.getValue());
        r108.append(", targetAppletId: ");
        if (r104 != null) goto L13;
        String r109 = "";
    L14:
        r108.append(r109);
        r108.append(", errorCode: ");
        if (r103 == null) goto L17;
        r106 = Integer.valueOf(r103.f16456a);
    L17:
        r108.append(r106);
        r108.append(", state: ");
        r108.append(r102.b());
        r107.i("AppletBackgroundAudioManager", r108.toString());
        goto L18
    L13:
        r109 = r104;
    L18:
        Lazy r110 = l3.d.f507201a;
        n0 r111 = new n0(r101, r102, r103, r104);
        q0 r112 = r111.f16462b;
        JsonObject r113 = new JsonObject();
        String r114 = r112.f16479a;
        if (r114 == null) goto L21;
        r113.addProperty("src", r114);
    L21:
        String r115 = r112.f16480b;
        if (r115 == null) goto L24;
        r113.addProperty("title", r115);
    L24:
        String r116 = r112.f16481c;
        if (r116 == null) goto L27;
        r113.addProperty("epname", r116);
    L27:
        String r117 = r112.f16482d;
        if (r117 == null) goto L30;
        r113.addProperty("singer", r117);
    L30:
        String r118 = r112.f16483e;
        if (r118 == null) goto L33;
        r113.addProperty("coverImgUrl", r118);
    L33:
        String r119 = r112.f16484f;
        if (r119 == null) goto L36;
        r113.addProperty(NativeDownloadModel.JsonKey.WEB_URL, r119);
    L36:
        r113.addProperty(DyPayConstant.KEY_START_TIME, Double.valueOf(r112.f16485g));
        r113.addProperty("currentTime", Double.valueOf(r112.f16486h));
        r113.addProperty("duration", Double.valueOf(r112.f16487i));
        r113.addProperty("paused", Boolean.valueOf(r112.f16488j));
        r113.addProperty("buffered", Double.valueOf(r112.f16489k));
        r113.addProperty("playbackRate", Double.valueOf(r112.f16490l));
        JsonObject r120 = new JsonObject();
        r120.addProperty("eventName", r111.f16461a.getValue());
        r120.add("state", r113);
        String r121 = r111.f16464d;
        if (r121 == null) goto L39;
        r120.addProperty(IFlowAppIntentIDL.PARAM_APPLET_ID, r121);
    L39:
        m0 r122 = r111.f16463c;
        if (r122 == null) goto L42;
        r120.addProperty("errCode", Integer.valueOf(r122.f16456a));
        r120.addProperty("errMsg", r122.f16457b);
    L42:
        l3.a r123 = new l3.a("doubao.onBackgroundAudioManagerStateChange", r120, 4);
        r123.f507199d = r104;
        l3.d.c(r123);
    }
}
