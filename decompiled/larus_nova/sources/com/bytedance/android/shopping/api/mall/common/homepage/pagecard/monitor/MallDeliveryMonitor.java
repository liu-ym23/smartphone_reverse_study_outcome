package com.bytedance.android.shopping.api.mall.common.homepage.pagecard.monitor;

import android.app.Activity;
import android.app.Application;
import android.os.Bundle;
import android.widget.ImageView;
import com.byted.cast.linkcommon.cybergarage.upnp.device.ST;
import com.bytedance.android.ec.hybrid.service.IMallDeepFeedAnimationService;
import com.bytedance.android.shopping.api.mall.common.tools.DeliveryViewAnimHelper;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;
import kk.d;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;
import y93.b;
import y93.e;

/* JADX INFO: loaded from: classes13.dex */
public final class MallDeliveryMonitor implements b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Map<String, Map<String, Object>> f170365a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Map<String, Map<String, Object>> f170366b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Map<String, Map<String, Object>> f170367c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Map<String, Set<String>> f170368d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final Map<String, Map<String, String>> f170369e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final Map<String, Integer> f170370f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public MallDeliveryLifecycleCallback f170371g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final Lazy f170372h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final Map<String, String> f170373i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public String f170374j;

    public final class MallDeliveryLifecycleCallback implements Application.ActivityLifecycleCallbacks {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public Integer f170375a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public boolean f170376b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public boolean f170377c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final MallDeliveryMonitor$MallDeliveryLifecycleCallback$unregisterRunnable$1 f170378d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final String f170379e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public final String f170380f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public final boolean f170381g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public final /* synthetic */ MallDeliveryMonitor f170382h;

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public final void onActivityPaused(Activity r100) {
            Intrinsics.checkNotNullParameter(r100, "activity");
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public final void onActivitySaveInstanceState(Activity r100, Bundle r101) {
            Intrinsics.checkNotNullParameter(r100, "activity");
            Intrinsics.checkNotNullParameter(r101, "outState");
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public final void onActivityStarted(Activity r100) {
            Intrinsics.checkNotNullParameter(r100, "activity");
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public final void onActivityDestroyed(Activity r100) {
            Intrinsics.checkNotNullParameter(r100, "activity");
            Integer r101 = this.f170375a;
            int r102 = r100.hashCode();
            if (r101 != null) goto L6;
            return;
        L6:
            if (r101.intValue() != r102) goto L9;
            this.f170378d.run();
            return;
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public final void onActivityResumed(final Activity r110) {
            Intrinsics.checkNotNullParameter(r110, "activity");
            Integer r100 = this.f170375a;
            int r101 = r110.hashCode();
            if (r100 != null) goto L6;
            return;
        L6:
            if (r100.intValue() != r101) goto L34;
            Result.Companion r102 = Result.Companion;     // Catch: Throwable -> L25
            DeliveryViewAnimHelper.f170397n.getClass();     // Catch: Throwable -> L25
            if (DeliveryViewAnimHelper.f170389f != null) goto L10;
        L20:
            boolean r103 = false;
        L21:
            if (r103 == false) goto L23;
            int r104 = DeliveryViewAnimHelper.f170385b;     // Catch: Throwable -> L25
            int r105 = DeliveryViewAnimHelper.f170386c;     // Catch: Throwable -> L25
            int r106 = DeliveryViewAnimHelper.f170387d;     // Catch: Throwable -> L25
            int r107 = DeliveryViewAnimHelper.f170388e;     // Catch: Throwable -> L25
            ImageView r108 = ((IMallDeepFeedAnimationService) ServiceManager.get().getService(IMallDeepFeedAnimationService.class)).b(r110, DeliveryViewAnimHelper.f170390g, true);     // Catch: Throwable -> L25
            DeliveryViewAnimHelper.c(r110, ((IMallDeepFeedAnimationService) ServiceManager.get().getService(IMallDeepFeedAnimationService.class)).b(r110, DeliveryViewAnimHelper.f170389f, false), r108, r104, r105, r106, r107, this.f170381g);     // Catch: Throwable -> L25
        L23:
            DeliveryViewAnimHelper.b();     // Catch: Throwable -> L25
            Object r109 = Result.m9449constructorimpl(Unit.INSTANCE);     // Catch: Throwable -> L25
        L28:
            if (Result.m9452exceptionOrNullimpl(r109) == null) goto L30;
            DeliveryViewAnimHelper.f170397n.getClass();
            DeliveryViewAnimHelper.b();
        L30:
            d.c(new MallDeliveryMonitor$MallDeliveryLifecycleCallback$onActivityResumed$3(this, r110));
            return;
        L10:
            if (DeliveryViewAnimHelper.f170390g == null) goto L20;
            if (DeliveryViewAnimHelper.f170385b <= 0) goto L20;
            if (DeliveryViewAnimHelper.f170386c <= 0) goto L20;
            if (DeliveryViewAnimHelper.f170387d <= 0) goto L20;
            if (DeliveryViewAnimHelper.f170388e <= 0) goto L20;
            r103 = true;
        L25:
            th = move-exception;
            Result.Companion r111 = Result.Companion;
            r109 = Result.m9449constructorimpl(ResultKt.createFailure(th));
            goto L28
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public final void onActivityStopped(Activity r100) {
            Intrinsics.checkNotNullParameter(r100, "activity");
            Integer r101 = this.f170375a;
            int r102 = r100.hashCode();
            if (r101 != null) goto L6;
            return;
        L6:
            if (r101.intValue() == r102) goto L8;
            return;
        L8:
            if (r100.isFinishing() == false) goto L10;
        L11:
            this.f170378d.run();
            return;
        L10:
            if (r100.isDestroyed() == true) goto L11;
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public final void onActivityCreated(Activity r100, Bundle r101) {
            Intrinsics.checkNotNullParameter(r100, "activity");
            if (this.f170375a != null) goto L6;
            this.f170375a = Integer.valueOf(r100.hashCode());
            return;
        }

        public MallDeliveryLifecycleCallback(MallDeliveryMonitor r100, String r101, String r102, boolean r103) {
            Intrinsics.checkNotNullParameter(r101, ST.UUID_DEVICE);
            Intrinsics.checkNotNullParameter(r102, "schema");
            this.f170382h = r100;
            this.f170379e = r101;
            this.f170380f = r102;
            this.f170381g = r103;
            MallDeliveryMonitor$MallDeliveryLifecycleCallback$unregisterRunnable$1 r104 = new MallDeliveryMonitor$MallDeliveryLifecycleCallback$unregisterRunnable$1(this);
            this.f170378d = r104;
            if (((Number) r100.f170372h.getValue()).intValue() != 0) goto L6;
            t93.a.b().postDelayed(r104, 10000);
            return;
        }
    }

    public static final class a {
    }

    static {
    }

    public MallDeliveryMonitor() {
        this.f170365a = new LinkedHashMap();
        this.f170366b = new LinkedHashMap();
        this.f170367c = new LinkedHashMap();
        this.f170368d = new LinkedHashMap();
        this.f170369e = new LinkedHashMap();
        this.f170370f = new LinkedHashMap();
        this.f170372h = LazyKt.lazy(MallDeliveryMonitor$enableInitUnregister$2.INSTANCE);
        this.f170373i = new LinkedHashMap();
        this.f170374j = "";
    }

    @Override // y93.b
    public final void c(final e r100) {
        Intrinsics.checkNotNullParameter(r100, "params");
        d.c(new MallDeliveryMonitor$reportAction$1(this, r100));
    }

    @Override // y93.b
    public final Map<String, Object> h(String r100) {
        Intrinsics.checkNotNullParameter(r100, ST.UUID_DEVICE);
        return (Map) ((LinkedHashMap) this.f170366b).get(r100);
    }

    @Override // y93.b
    public final void a(final String r100, final Map<String, ? extends Object> r101) {
        Intrinsics.checkNotNullParameter(r100, ST.UUID_DEVICE);
        Intrinsics.checkNotNullParameter(r101, "lynxRecord");
        d.c(new MallDeliveryMonitor$onRecordLynx$1(this, r100, r101));
    }

    @Override // y93.b
    public final void b(final String r100, final Map<String, ? extends Object> r101) {
        Intrinsics.checkNotNullParameter(r100, ST.UUID_DEVICE);
        d.c(new MallDeliveryMonitor$reportDeliveryErr$1(this, r100, r101));
    }

    @Override // y93.b
    public final void e(final String r100, final Map r101) {
        Intrinsics.checkNotNullParameter(r100, ST.UUID_DEVICE);
        final String r102 = "tti";
        Intrinsics.checkNotNullParameter("tti", "process");
        Intrinsics.checkNotNullParameter(r101, "actionParams");
        d.c(new MallDeliveryMonitor$reportActionFromLynx$1(this, r100, r102, r101));
    }

    @Override // y93.b
    public final void f(String r100, Map<String, ? extends Object> r101) {
        Intrinsics.checkNotNullParameter(r100, ST.UUID_DEVICE);
        Intrinsics.checkNotNullParameter(r101, "params");
        Map r102 = (Map) ((LinkedHashMap) this.f170366b).get(r100);
        if (r102 == null) goto L5;
        r102.putAll(r101);
        return;
    L5:
        LinkedHashMap r103 = (LinkedHashMap) this.f170367c;
        Object r104 = r103.get(r100);
        if (r104 != null) goto L8;
        r104 = new LinkedHashMap();
        r103.put(r100, r104);
    L8:
        ((Map) r104).putAll(r101);
    }

    @Override // y93.b
    public final void g(final String r100, final boolean r101, final Map<String, ? extends Object> r102) {
        Intrinsics.checkNotNullParameter(r100, ST.UUID_DEVICE);
        d.c(new MallDeliveryMonitor$reportRecord$1(this, r100, r101, r102));
    }

    public static final void i(final MallDeliveryMonitor r100, final JSONObject r101, final String r102, final String r103) {
        r100.getClass();
        d.c(new MallDeliveryMonitor$fillingBaseEventParams$1(r100, r101, r102, r103));
    }

    @Override // y93.b
    public final void d(String r100, String r101, Long r102, String r103) {
        Intrinsics.checkNotNullParameter(r100, ST.UUID_DEVICE);
        Intrinsics.checkNotNullParameter(r101, "timing");
        Map r104 = (Map) ((LinkedHashMap) this.f170366b).get(r100);
        if (r104 == null) goto L9;
        if (r102 == null) goto L6;
        long r105 = r102.longValue();
    L7:
        r104.put(r101, Long.valueOf(r105));
        goto L9
    L6:
        r105 = System.currentTimeMillis();
    L9:
        if (Intrinsics.areEqual(r101, "mall_enter_time") == false) goto L16;
        if (r103 == null) goto L14;
        Map r106 = (Map) ((LinkedHashMap) this.f170366b).get(r100);
        if (r106 == null) goto L14;
        r106.put("mall_source_page", r103);
    L14:
        c(new e("mall_enter", r100));
        return;
    }
}
