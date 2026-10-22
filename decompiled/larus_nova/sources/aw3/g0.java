package aw3;

import android.os.Looper;
import com.bytedance.applet.audio.background.AppletBackgroundAudioMediaSessionService;
import com.bytedance.applet.audio.background.BackgroundAudioPlaybackState;
import com.larus.audio.controller.GlobalAudioController;
import com.larus.audio.controller.GlobalAudioStateEnum;
import com.larus.audio.observer.GlobalAudioObserver;
import com.larus.common.apphost.AppHost;
import com.larus.utils.logger.FLogger;
import java.util.LinkedHashMap;
import java.util.concurrent.CopyOnWriteArrayList;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes14.dex */
public final class g0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final CopyOnWriteArrayList<Function1<AppletBackgroundAudioMediaSessionService, Unit>> f16422a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final a f16423b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static AppletBackgroundAudioMediaSessionService f16424c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static com.bytedance.applet.audio.background.a f16425d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static boolean f16426e;

    public static final class a implements e78.c {
        public a() {
        }

        @Override // e78.c
        public final boolean b() {
            return false;
        }

        @Override // e78.c
        public final void c() {
        }

        @Override // e78.c
        public final void d() {
        }

        @Override // e78.c
        public final boolean e() {
            return false;
        }

        @Override // e78.c
        public final String getBizScene() {
            return "plugin_background_audio";
        }

        @Override // e78.c
        public final String getScene() {
            return "plugin_background_audio";
        }

        @Override // e78.c
        public final void a() {
            CopyOnWriteArrayList<Function1<AppletBackgroundAudioMediaSessionService, Unit>> r100 = g0.f16422a;
            FLogger.f375446a.i("AppletBackgroundAudioMediaSessionController", "media session release from global controller");
            g0.f16422a.clear();
            g0.e(new d0(new z()));
        }

        @Override // e78.c
        public final GlobalAudioStateEnum getState() {
            w r100 = w.f16506a;
            if (w.f16516k == null) goto L20;
            BackgroundAudioPlaybackState r101 = w.f16507b.f16491m;
            int r102 = w.a.f16517a[r101.ordinal()];
            if (r102 == 1) goto L19;
            if (r102 == 2) goto L23;
            if (r102 == 3) goto L22;
            if (r102 != 4) goto L15;
            return GlobalAudioStateEnum.STOPPED;
        L15:
            throw new NoWhenBranchMatchedException();
        L22:
            return GlobalAudioStateEnum.STOPPED;
        L23:
            return GlobalAudioStateEnum.PAUSED;
        L19:
            return GlobalAudioStateEnum.PLAYING;
        L20:
            return GlobalAudioStateEnum.NONE;
        }

        @Override // e78.c
        public final boolean pause() {
            w r100 = w.f16506a;
            String r101 = w.f16516k;
            if (r101 != null) goto L5;
            return false;
        L5:
            w.z(new o(r101));
            return true;
        }

        @Override // e78.c
        public final boolean play() {
            w r100 = w.f16506a;
            String r101 = w.f16516k;
            if (r101 != null) goto L5;
            return false;
        L5:
            w.z(new p(r101));
            return true;
        }

        @Override // e78.c
        public final boolean stop() {
            w r100 = w.f16506a;
            String r101 = w.f16516k;
            if (r101 != null) goto L5;
            return false;
        L5:
            w.z(new q(r101));
            return true;
        }
    }

    static {
        f16422a = new CopyOnWriteArrayList();
        f16423b = new a();
    }

    public static void d() {
        com.bytedance.applet.audio.background.a r100 = f16425d;
        if (r100 != null) goto L10;
    L8:
        f16425d = null;
        f16424c = null;
        f16426e = false;
        f16422a.clear();
        return;
    L10:
        AppHost.f326268a.getApplication().unbindService(r100);     // Catch: Exception -> L6
    L6:
        e = move-exception;
        FLogger.f375446a.e("AppletBackgroundAudioMediaSessionController", "unbind media session service failed", e);
        goto L8
    }

    public static void a(q0 r100) {
        Intrinsics.checkNotNullParameter(r100, "state");
        FLogger.f375446a.i("AppletBackgroundAudioMediaSessionController", "media session metadata changed. state: " + r100.b());
        AppletBackgroundAudioMediaSessionService r101 = f16424c;
        if (r101 != null) goto L5;
        return;
    L5:
        if ((!r101.f191434j) == true) goto L8;
        r101 = null;
    L8:
        if (r101 == null) goto L12;
        r101.k();
        r101.l();
        return;
    }

    public static void b(q0 r100) {
        Intrinsics.checkNotNullParameter(r100, "state");
        FLogger.f375446a.i("AppletBackgroundAudioMediaSessionController", "media session seeked. state: " + r100.b());
        AppletBackgroundAudioMediaSessionService r101 = f16424c;
        if (r101 != null) goto L5;
        return;
    L5:
        if ((!r101.f191434j) == true) goto L8;
        r101 = null;
    L8:
        if (r101 == null) goto L12;
        r101.l();
        return;
    }

    public static void c(q0 r100) {
        Intrinsics.checkNotNullParameter(r100, "state");
        FLogger.f375446a.i("AppletBackgroundAudioMediaSessionController", "media session stopped. state: " + r100.b());
        GlobalAudioController.f289658a.d(f16423b);
        f16422a.clear();
        e(new d0(new x()));
        f(GlobalAudioStateEnum.STOPPED, w.f16516k);
    }

    public static void e(final Function0 r100) {
        if (Intrinsics.areEqual(Looper.myLooper(), Looper.getMainLooper()) == false) goto L5;
        r100.invoke();
        return;
    L5:
        com.larus.utils.y.c(new f0(r100));
    }

    public static void f(GlobalAudioStateEnum r100, String r101) {
        GlobalAudioObserver r102 = GlobalAudioObserver.f289772a;
        LinkedHashMap r103 = new LinkedHashMap();
        if (r101 == null) goto L5;
        r103.put("applet_id", r101);
    L5:
        r102.c("plugin_background_audio", r100, r103);
    }
}
