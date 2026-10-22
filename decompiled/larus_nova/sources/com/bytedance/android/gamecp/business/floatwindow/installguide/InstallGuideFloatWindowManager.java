package com.bytedance.android.gamecp.business.floatwindow.installguide;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Build;
import android.view.animation.AccelerateDecelerateInterpolator;
import com.bytedance.android.gamecp.business.GamePromoteTrack;
import com.bytedance.android.gamecp.business.n0;
import com.bytedance.android.gamecp.common.setting.config.j2;
import com.bytedance.android.gamecp.common.utils.a1;
import com.bytedance.android.gamecp.common.utils.e0;
import com.bytedance.android.gamecp.common.utils.y0;
import com.bytedance.android.livesdkapi.depend.log.LogFilterName;
import com.bytedance.common.utility.Logger;
import com.obric.assistant.interaction.impl.window.helpers.DialogLancet;
import com.ss.android.download.api.constant.BaseConstants;
import com.ss.android.downloadlib.install.AppFloatingWindowInterceptor;
import com.ss.android.downloadlib.install.IBeforeInterceptCallback;
import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import wu.t;

/* JADX INFO: loaded from: classes44.dex */
public final class InstallGuideFloatWindowManager {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static boolean f53171a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static Disposable f53172b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static Disposable f53173c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static Object f53174d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final Lazy f53175e = null;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static volatile boolean f53176f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final InstallGuideFloatWindowManager f53177g = null;

    public static final class a<T> implements Consumer {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final a f53178a = null;

        static {
            f53178a = new a();
        }

        public a() {
        }

        @Override // io.reactivex.functions.Consumer
        public final void accept(Object r100) {
            Long r101 = (Long) r100;
            InstallGuideFloatWindowManager.b();
        }
    }

    public static final class b implements DialogInterface.OnDismissListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ int f53179a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ OverlayPermissionDialog f53180b;

        public b(int r100, OverlayPermissionDialog r101) {
            this.f53179a = r100;
            this.f53180b = r101;
        }

        @Override // android.content.DialogInterface.OnDismissListener
        public final void onDismiss(DialogInterface r100) {
            if (this.f53179a == 2) goto L5;
        L12:
            OverlayPermissionDialog r101 = this.f53180b;
            if (r101.f53188m == false) goto L16;
            int r102 = l.f53208a;
            LinkedHashMap r103 = new LinkedHashMap();
            int r104 = GamePromoteTrack.f51759a;
            GamePromoteTrack.b(r103);
            int r105 = com.bytedance.android.gamecp.common.track.b.f56775a;
            com.bytedance.android.gamecp.common.track.b.g("livesdk_mini_game_window_setting_open", r103, new String[]{LogFilterName.ROOM, LogFilterName.PAGE_SOURCE_LOG});
            return;
        L16:
            if (r101.f53190o == false) goto L19;
            l.a("1");
            return;
        L19:
            if (r101.f53189n == false) goto L21;
            l.a("2");
            return;
        L21:
            l.a("3");
            return;
        L5:
            if (this.f53180b.f53188m == true) goto L12;
            int r106 = n0.f56187a;
            Object r107 = InstallGuideFloatWindowManager.f53174d;
            if ((r107 instanceof IBeforeInterceptCallback) == true) goto L9;
            r107 = null;
        L9:
            IBeforeInterceptCallback r108 = (IBeforeInterceptCallback) r107;
            if (r108 == null) goto L12;
            r108.onDenied();
            goto L12
        }
    }

    public static final class c implements com.bytedance.android.gamecp.business.floatwindow.installguide.c {
        public c() {
        }

        @Override // com.bytedance.android.gamecp.business.floatwindow.installguide.c
        public final void onGranted() {
            int r100 = n0.f56187a;
            boolean r101 = InstallGuideFloatWindowManager.f53171a;
            Object r102 = InstallGuideFloatWindowManager.f53174d;
            if ((r102 instanceof IBeforeInterceptCallback) == true) goto L5;
            r102 = null;
        L5:
            IBeforeInterceptCallback r103 = (IBeforeInterceptCallback) r102;
            if (r103 == null) goto L9;
            r103.onGranted();
            return;
        }
    }

    public InstallGuideFloatWindowManager() {
    }

    static {
        f53177g = new InstallGuideFloatWindowManager();
        f53175e = LazyKt.lazy(InstallGuideFloatWindowManager$installGuideConfig$2.INSTANCE);
    }

    public static final /* synthetic */ Context a() {
        return f53177g.getContext();
    }

    public static final void b() {
        InstallGuideFloatWindowManager r100 = f53177g;
        ss.b r101 = ss.i.a();
        if (r101 == null) goto L5;
        r101.a();
    L5:
        InstallGuideView r102 = new InstallGuideView(r100.getContext(), new g());
        int r103 = y0.b(245.0f);
        int r104 = y0.b(261.0f);
        ss.i.a r105 = new ss.i.a(y0.getContext());
        r105.f543317b = r102;
        r105.f543318c = r103;
        r105.f543319d = r104;
        r105.f543320e = (y0.g() - r103) - 0;
        r105.f543321f = (y0.f() / 2) - (r104 / 2);
        r105.f543327l = "install_guide";
        r105.f543322g = 3;
        r105.f543323h = 0;
        r105.f543324i = 0;
        AccelerateDecelerateInterpolator r106 = new AccelerateDecelerateInterpolator();
        r105.f543325j = 300;
        r105.f543326k = r106;
        r105.f543328m = true;
        r105.f543329n = true;
        Map<String, ss.b> r107 = ss.i.f543314a;
        HashMap r108 = (HashMap) r107;
        if (r108.containsKey(r105.f543327l) == false) goto L9;
        Logger.e("LiveFloatWindowManager", "Float window has been added!");
    L12:
        ss.b r109 = ss.i.a();
        if (r109 == null) goto L15;
        r109.c();
    L15:
        f53171a = false;
        int r110 = l.f53208a;
        LinkedHashMap r111 = new LinkedHashMap();
        int r112 = GamePromoteTrack.f51759a;
        GamePromoteTrack.b(r111);
        int r113 = com.bytedance.android.gamecp.common.track.b.f56775a;
        com.bytedance.android.gamecp.common.track.b.g("livesdk_mini_game_window_show", r111, new String[]{LogFilterName.ROOM, LogFilterName.PAGE_SOURCE_LOG});
        return;
    L9:
        if (r105.f543317b != null) goto L11;
        Logger.e("LiveFloatWindowManager", "view can not be null!");
        goto L12
    L11:
        ss.e r114 = new ss.e(r105);
        r108.put(r105.f543327l, r114);
        goto L12
    }

    public static final boolean c() {
        InstallGuideFloatWindowManager r100 = f53177g;
        if (r100.d() == true) goto L6;
        return false;
    L6:
        if (ru.b.d(r100.getContext()) == false) goto L9;
        return false;
    L9:
        if (((j2) f53175e.getValue()).b() == true) goto L11;
    L12:
        return true;
    L11:
        if ((System.currentTimeMillis() - a1.b().getLong("live.key.INSTALL_OVERLAY_PERMISSION_LAST_TIME", 0)) >= (mt.a.a(a1.b().getInt("live.key.INSTALL_OVERLAY_PERMISSION_FIBONACCO_NUM", 0)) * BaseConstants.Time.DAY)) goto L12;
        return false;
    }

    public static boolean g() {
        Integer r100 = t.f561389a.getValue();
        if (r100 == null) goto L8;
        if (r100.intValue() != 0) goto L8;
    L10:
        return false;
    L8:
        if (((j2) f53175e.getValue()).c() == false) goto L10;
        return true;
    }

    public final void f() {
        if (f53176f == false) goto L5;
        return;
    L5:
        monitor-enter(this);
    L21:
        th = move-exception;
        throw th;
    L7:
        if (f53176f == false) goto L11;
        monitor-exit(this);
        return;
    L11:
        f53176f = true;     // Catch: Throwable -> L21
        if (((j2) f53175e.getValue()).d() == false) goto L15;
        int r100 = n0.f56187a;     // Catch: Throwable -> L21
        AppFloatingWindowInterceptor.setDownloadInstallFeatureCallback(new j());     // Catch: Throwable -> L21
    L15:
        if (g() == true) goto L18;
        monitor-exit(this);
        return;
    L18:
        jv.a.a().c(com.bytedance.android.gamecp.business.download.a.class).subscribe(h.f53205a);     // Catch: Throwable -> L21
        com.bytedance.android.gamecp.host_api.a.b().getHostAppService().y0(new i());     // Catch: Throwable -> L21
        Unit r101 = Unit.INSTANCE;     // Catch: Throwable -> L21
        monitor-exit(this);
    }

    private final Context getContext() {
        return y0.getContext();
    }

    public final boolean d() {
        if (g() == true) goto L5;
        return false;
    L5:
        List<n> r100 = e();
        if (r100 != null) goto L8;
    L11:
        boolean r101 = true;
    L12:
        if (r101 == false) goto L14;
        return false;
    L14:
        return true;
    L8:
        if (r100.isEmpty() == true) goto L11;
        r101 = false;
        goto L12
    }

    public final List<n> e() {
        String r100 = a1.b().getString("live.key.INSTALL_FLOAT_WINDOW_INFO", "");
        boolean r101 = false;
        if (r100 != null) goto L5;
    L8:
        boolean r102 = true;
    L10:
        if (r102 == false) goto L12;
        return null;
    L12:
        com.bytedance.android.gamecp.business.floatwindow.installguide.a r103 = (com.bytedance.android.gamecp.business.floatwindow.installguide.a) e0.g(r100, com.bytedance.android.gamecp.business.floatwindow.installguide.a.class);
        if (r103 == null) goto L15;
        Boolean r104 = r103.isShowFloatWindow;
    L17:
        if ((!Intrinsics.areEqual(r104, Boolean.TRUE)) == true) goto L43;
        List<n> r105 = r103.stepList;
        if (r105 != null) goto L21;
    L24:
        boolean r106 = true;
    L25:
        if (r106 == true) goto L43;
        int r107 = yt.j.f569017a;
        Context r108 = getContext();
        if (Build.VERSION.SDK_INT < 26) goto L32;
        if (r108 == null) goto L32;
        r101 = r108.getPackageManager().canRequestPackageInstalls();     // Catch: Exception -> L44
    L33:
        if (r101 == false) goto L35;
        ArrayList r109 = new ArrayList();
        List<n> r110 = r103.stepList;
        Intrinsics.checkNotNull(r110);
        Iterator<n> r111 = r110.iterator();
    L38:
        if (r111.hasNext() == false) goto L42;
        n r112 = r111.next();
        if ((!Intrinsics.areEqual(r112.hideWhenHasInstallPermission, Boolean.TRUE)) == false) goto L38;
        r109.add(r112);
        goto L38
    L42:
        return r109;
    L35:
        return r103.stepList;
    L32:
        r101 = true;
        goto L33
    L21:
        if (r105.isEmpty() == true) goto L24;
        r106 = false;
    L43:
        return null;
    L15:
        r104 = null;
        goto L17
    L5:
        if (r100.length() == 0) goto L8;
        r102 = false;
        goto L10
    }

    public final void h() {
        if (ru.b.d(getContext()) == true) goto L6;
        return;
    L6:
        if (d() == true) goto L8;
        return;
    L8:
        long r100 = ((j2) f53175e.getValue()).f();
        Disposable r101 = f53173c;
        if (r101 != null) goto L11;
    L15:
        f53173c = Observable.timer(r100, TimeUnit.MILLISECONDS).observeOn(AndroidSchedulers.mainThread()).subscribe(a.f53178a);
        return;
    L11:
        if (r101.isDisposed() == true) goto L15;
        Disposable r102 = f53173c;
        if (r102 == null) goto L15;
        r102.dispose();
        goto L15
    }

    public static void i(int r100) {
        Activity r101 = com.bytedance.android.gamecp.host_api.a.b().getHostAppService().getCurrentActivity();
        if (r101 != null) goto L6;
        return;
    L6:
        if (r100 != 1) goto L8;
        c r102 = null;
    L9:
        OverlayPermissionDialog r103 = new OverlayPermissionDialog(r101, r102, r100);
        if (DialogLancet.shouldBlockDialogShow(r103) == false) goto L17;
        DialogLancet.handleBlockedDialogShow(r103);
    L14:
        r103.setOnDismissListener(new b(r100, r103));
        int r104 = a1.b().getInt("live.key.INSTALL_OVERLAY_PERMISSION_FIBONACCO_NUM", 0);
        a1.a().putLong("live.key.INSTALL_OVERLAY_PERMISSION_LAST_TIME", System.currentTimeMillis()).apply();
        a1.a().putInt("live.key.INSTALL_OVERLAY_PERMISSION_FIBONACCO_NUM", r104 + 1).apply();
        return;
    L17:
        DialogLancet.sLastShowStack = new Throwable();     // Catch: Exception -> L16
    L13:
        DialogLancet.beforeDialogShow(r103);
        r103.show();
        DialogLancet.afterDialogShow(r103);
        goto L14
    L8:
        r102 = new c();
        goto L9
    }
}
