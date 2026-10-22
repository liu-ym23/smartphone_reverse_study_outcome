package com.bytedance.android.livesdk.livecommerce.saascoupon;

import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.Lifecycle;
import bl2.g;
import com.bytedance.android.ec.base.settings.SDKSettingsCacheManager;
import com.bytedance.android.ec.base.settings.h;
import com.bytedance.android.ec.common.api.jump.model.LiveRoomParams;
import com.bytedance.android.ec.core.hybrid.utils.ECLiveHybridUtil;
import com.bytedance.android.ec.core.utils.z1;
import com.bytedance.android.ec.hybrid.hostapi.IECHybridKevaService;
import com.bytedance.android.ec.sdk.helper.i;
import com.bytedance.android.ec.sdk.helper.q;
import com.bytedance.android.ec.sdk.helper.r;
import com.bytedance.android.livesdk.livecommerce.ECLiveCommerceModel_ProvideLiveServiceFactory;
import com.bytedance.android.livesdk.livecommerce.model.FilterNullArrayList;
import com.bytedance.android.livesdk.livecommerce.utils.EComABUtils;
import com.bytedance.android.livesdkapi.depend.live.ILiveRoomPlayFragmentConstant;
import com.bytedance.android.livesdkapi.service.IPerformanceManager;
import com.bytedance.services.apm.api.EnsureManager;
import com.ss.android.lark.utils.statistics.PerfLog;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import el2.k;
import el2.l;
import el2.n;
import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;
import java.lang.ref.WeakReference;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.text.StringsKt;
import org.json.JSONArray;
import org.json.JSONObject;
import ti.j;

/* JADX INFO: loaded from: classes10.dex */
public final class SaasCouponService implements n {
    public static final /* synthetic */ int B = 0;
    public final Lazy A;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public k f152827a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final dl2.e f152828b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final g f152829c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Handler f152830d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final Lazy f152831e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final int f152832f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public boolean f152833g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public bl2.e f152834h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public boolean f152835i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public WeakReference<Context> f152836j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public Function1<? super JSONObject, Unit> f152837k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public com.bytedance.android.livesdk.livecommerce.saascoupon.lynxcoupon.a f152838l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final Lazy f152839m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final Lazy f152840n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public Function0<LiveRoomParams> f152841o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public boolean f152842p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public final Lazy f152843q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public Runnable f152844r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public Runnable f152845s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public Runnable f152846t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public Disposable f152847u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public final CompositeDisposable f152848v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public final int f152849w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public String f152850x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public int f152851y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public final Lazy f152852z;

    public static final class a {
    }

    public static final class b<T> implements Consumer {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ SaasCouponService f152853a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ boolean f152854b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ boolean f152855c;

        public b(SaasCouponService r100, boolean r101, boolean r102) {
            this.f152853a = r100;
            this.f152854b = r101;
            this.f152855c = r102;
        }

        @Override // io.reactivex.functions.Consumer
        public final void accept(Object r110) {
            bl2.b r111 = (bl2.b) r110;
            if (r111 != null) goto L5;
        L100:
            this.f152853a.b(Boolean.FALSE, 2);
            return;
        L5:
            if (r111.a() != 0) goto L100;
            bl2.e r100 = r111.e();
            el.a r101 = null;
            if (r100 == null) goto L10;
            bl2.d r102 = r100.d();
        L11:
            long r103 = 0;
            if (r102 == null) goto L62;
            bl2.e r104 = r111.e();
            if (r104 == null) goto L16;
            List<bl2.c> r105 = r104.a();
        L17:
            if (r105 == null) goto L62;
            if (this.f152853a.f152835i == true) goto L110;
            bl2.e r106 = r111.e();
            if (r106 == null) goto L25;
            long r107 = r106.b();
        L27:
            if (r107 >= 0) goto L29;
            this.f152853a.b(Boolean.FALSE, 2);
        L29:
            this.f152853a.b(Boolean.TRUE, null);
            this.f152853a.f152834h = r111.e();
            bl2.e r108 = r111.e();
            if (r108 == null) goto L53;
            List<bl2.c> r109 = r108.a();
            if (r109 == null) goto L53;
            Iterator<bl2.c> r112 = r109.iterator();
        L35:
            if (r112.hasNext() == false) goto L53;
            bl2.c r113 = r112.next();
            String r114 = r113.k();
            if (r114 == null) goto L39;
            g r115 = this.f152853a.f152829c;
            r115.getClass();
            Intrinsics.checkNotNullParameter(r114, "<set-?>");
            r115.f19416m = r114;
        L39:
            String r116 = r113.j();
            if (r116 == null) goto L42;
            g r117 = this.f152853a.f152829c;
            r117.getClass();
            Intrinsics.checkNotNullParameter(r116, "<set-?>");
            r117.f19415l = r116;
        L42:
            String r118 = r113.d();
            if (r118 == null) goto L45;
            g r119 = this.f152853a.f152829c;
            r119.getClass();
            Intrinsics.checkNotNullParameter(r118, "<set-?>");
            r119.f19406c = r118;
        L45:
            String r120 = r113.c();
            if (r120 == null) goto L48;
            g r121 = this.f152853a.f152829c;
            r121.getClass();
            Intrinsics.checkNotNullParameter(r120, "<set-?>");
            r121.f19417n = r120;
        L48:
            String r122 = r113.e();
            if (r122 == null) goto L51;
            g r123 = this.f152853a.f152829c;
            r123.getClass();
            Intrinsics.checkNotNullParameter(r122, "<set-?>");
            r123.f19418o = r122;
        L51:
            this.f152853a.f152829c.f19414k = r113.h();
        L53:
            if (this.f152854b == false) goto L55;
        L57:
            bl2.e r124 = r111.e();
            if (r124 == null) goto L60;
            r103 = r124.b();
        L60:
            r103 = r103 * 1000;
        L61:
            SaasCouponService r125 = this.f152853a;
            r125.f152830d.postDelayed((Runnable) r125.f152843q.getValue(), r103);
            return;
        L55:
            if (this.f152855c == false) goto L57;
        L25:
            r107 = 0;
            goto L27
        L110:
            return;
        L16:
            r105 = null;
        L62:
            el.b r126 = r111.d();
            boolean r127 = true;
            if (r126 != null) goto L65;
        L75:
            el.a r128 = r111.c();
            if (r128 == null) goto L92;
            if (EComABUtils.enableLiveExpansionCoupon() == true) goto L80;
        L86:
            r127 = false;
        L87:
            if (r127 == false) goto L89;
            r101 = r128;
        L89:
            if (r101 == null) goto L92;
            SaasCouponService r129 = this.f152853a;
            d r130 = new d(r101, this);
            r129.f152845s = r130;
            r129.f152830d.postDelayed(r130, r101.c());
            return;
        L80:
            if (r128.a() == null) goto L86;
            if (r128.b() == null) goto L86;
            if (r128.c() <= 0) goto L86;
        L92:
            if (this.f152854b == false) goto L94;
        L96:
            this.f152853a.b(Boolean.FALSE, 2);
        L97:
            String r131 = r111.f();
            if (r131 == null) goto L108;
            SaasCouponService.c(this.f152853a, r131);
            return;
        L108:
            return;
        L94:
            if (this.f152855c == true) goto L96;
            this.f152853a.b(Boolean.FALSE, 3);
            goto L97
        L65:
            if (r126.a() != null) goto L67;
        L69:
            boolean r132 = false;
        L70:
            if (r132 == true) goto L73;
            r126 = null;
        L73:
            if (r126 == null) goto L75;
            SaasCouponService r133 = this.f152853a;
            com.bytedance.android.livesdk.livecommerce.saascoupon.c r134 = new com.bytedance.android.livesdk.livecommerce.saascoupon.c(r126, this, r111);
            r133.f152844r = r134;
            r133.f152830d.postDelayed(r134, ((Number) r133.f152839m.getValue()).longValue());
            return;
        L67:
            if (r126.b() == null) goto L69;
            r132 = true;
            goto L70
        L10:
            r102 = null;
            goto L11
        }
    }

    public static final class c<T> implements Consumer {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ SaasCouponService f152856a;

        public c(SaasCouponService r100) {
            this.f152856a = r100;
        }

        @Override // io.reactivex.functions.Consumer
        public final void accept(Object r100) {
            Throwable r101 = (Throwable) r100;
            this.f152856a.b(Boolean.FALSE, 2);
        }
    }

    static {
    }

    public final boolean g() {
        return ((Boolean) this.f152831e.getValue()).booleanValue();
    }

    public final int d() {
        if (this.f152851y != (-1)) goto L6;
        this.f152851y = q.f48131a.getInt("saascoupon_show_toast_count_daily", 0);
    L6:
        return this.f152851y;
    }

    @Override // el2.n
    public final void destroy() {
        ECLiveHybridUtil.p("LIVEROOM_SHOW_SHOT_REDPACK", (j) this.f152852z.getValue());
        ECLiveHybridUtil.p("LIVEROOM_OPEN_PRODUCT_LIST", (j) this.A.getValue());
        this.f152848v.clear();
        Disposable r100 = this.f152847u;
        if (r100 == null) goto L5;
        r100.dispose();
    L5:
        this.f152847u = null;
        this.f152830d.removeCallbacks((Runnable) this.f152843q.getValue());
        Runnable r101 = this.f152844r;
        if (r101 == null) goto L8;
        this.f152830d.removeCallbacks(r101);
    L8:
        Runnable r102 = this.f152845s;
        if (r102 == null) goto L11;
        this.f152830d.removeCallbacks(r102);
    L11:
        Runnable r103 = this.f152846t;
        if (r103 == null) goto L14;
        this.f152830d.removeCallbacks(r103);
    L14:
        com.bytedance.android.livesdk.livecommerce.saascoupon.lynxcoupon.a r104 = this.f152838l;
        if (r104 == null) goto L17;
        r104.a(false);
    L17:
        this.f152834h = null;
        WeakReference<Context> r105 = this.f152836j;
        if (r105 == null) goto L20;
        r105.clear();
    L20:
        this.f152837k = null;
        this.f152841o = null;
        al2.a.f4122a = "";
        al2.a.f4123b = "";
        al2.a.f4124c = "";
        al2.a.f4125d = 0;
    }

    public final boolean f() {
        WeakReference<Context> r100 = this.f152836j;
        Lifecycle.State r101 = null;
        if (r100 == null) goto L5;
        Context r102 = r100.get();
    L7:
        if ((r102 instanceof FragmentActivity) == true) goto L9;
        r102 = null;
    L9:
        FragmentActivity r103 = (FragmentActivity) r102;
        if (r103 == null) goto L15;
        Lifecycle r104 = r103.getLifecycle();
        if (r104 == null) goto L15;
        r101 = r104.getCurrentState();
    L15:
        if (r101 != Lifecycle.State.RESUMED) goto L17;
        return true;
    L17:
        return false;
    L5:
        r102 = null;
        goto L7
    }

    public SaasCouponService() {
        this.f152828b = new dl2.e();
        this.f152829c = new g();
        this.f152830d = new Handler(Looper.getMainLooper());
        this.f152831e = LazyKt.lazy(SaasCouponService$isStartLogin$2.INSTANCE);
        int r100 = com.bytedance.android.ec.core.abtest.j.f43647a;
        Object r101 = 0;
        int r102 = com.bytedance.android.ec.base.settings.b.f42814a;
        Result.Companion r103 = Result.Companion;     // Catch: Throwable -> L165
        h.a();     // Catch: Throwable -> L165
        SDKSettingsCacheManager r104 = SDKSettingsCacheManager.f42812e;     // Catch: Throwable -> L165
        Object r105 = null;
        r104.getClass();     // Catch: Throwable -> L56
        Object r106 = SDKSettingsCacheManager.f42809b.get("pre_init_is_start_login");     // Catch: Throwable -> L56
        if (r106 != null) goto L11;
    L53:
        Object r107 = null;
    L54:
        Object r108 = Result.m9449constructorimpl(r107);     // Catch: Throwable -> L56
    L58:
        Throwable r109 = Result.m9452exceptionOrNullimpl(r108);     // Catch: Throwable -> L165
        if (r109 == null) goto L62;
        EnsureManager.ensureNotReachHere(r109);     // Catch: Throwable -> L165
    L62:
        if (Result.m9455isFailureimpl(r108) == false) goto L65;
        r108 = null;
    L65:
        if ((r108 instanceof Integer) == true) goto L67;
        r108 = null;
    L67:
        Object r110 = (Integer) r108;     // Catch: Throwable -> L165
        if (r110 != null) goto L74;
        r104.getClass();     // Catch: Throwable -> L165
        Object r111 = SDKSettingsCacheManager.f42808a.get("pre_init_is_start_login");     // Catch: Throwable -> L165
        if ((r111 instanceof Integer) == true) goto L73;
        r111 = null;
    L73:
        r110 = (Integer) r111;     // Catch: Throwable -> L165
    L74:
        if (r110 != null) goto L174;
        int r112 = com.bytedance.android.ec.base.settings.g.f42821a;     // Catch: Throwable -> L165
    L153:
        th = move-exception;
        Result.Companion r113 = Result.Companion;     // Catch: Throwable -> L165
        Object r114 = Result.m9449constructorimpl(ResultKt.createFailure(th));     // Catch: Throwable -> L165
    L156:
        if (Result.m9452exceptionOrNullimpl(r114) != null) goto L186;
    L157:
        r110 = r114;
    L163:
        SDKSettingsCacheManager.f42812e.getClass();     // Catch: Throwable -> L165
        SDKSettingsCacheManager.e("pre_init_is_start_login", r110);     // Catch: Throwable -> L165
        goto L174
    L186:
        r114 = ((IECHybridKevaService) ServiceManager.get().getService(IECHybridKevaService.class)).getSDKSettingsValueFromRepo("pre_init_is_start_login", Integer.class, r101);     // Catch: Throwable -> L160
    L161:
        if (r114 != null) goto L157;
        r110 = r101;
    L160:
        r114 = r101;
        goto L161
    L176:
        SDKSettingsCacheManager.f42812e.getClass();     // Catch: Throwable -> L127
        Object r115 = SDKSettingsCacheManager.f42809b.get("pre_init_is_start_login");     // Catch: Throwable -> L127
        if (r115 != null) goto L82;
    L124:
        Object r116 = null;
    L125:
        Object r117 = Result.m9449constructorimpl(r116);     // Catch: Throwable -> L127
    L129:
        Throwable r118 = Result.m9452exceptionOrNullimpl(r117);     // Catch: Throwable -> L153
        if (r118 == null) goto L133;
        EnsureManager.ensureNotReachHere(r118);     // Catch: Throwable -> L153
    L133:
        if (Result.m9455isFailureimpl(r117) == false) goto L136;
        r117 = null;
    L136:
        if ((r117 instanceof Integer) == true) goto L138;
        r117 = null;
    L138:
        Integer r119 = (Integer) r117;     // Catch: Throwable -> L153
        if (r119 == null) goto L141;
        r110 = r119;
        goto L163
    L141:
        jj4.b r120 = jj4.b.f499326b;     // Catch: Throwable -> L153
        Object r121 = jj4.a.a("pre_init_is_start_login", Integer.class, r101, false);     // Catch: Throwable -> L153
        if (r121 != null) goto L145;
        Intrinsics.throwNpe();     // Catch: Throwable -> L153
    L145:
        if ((r121 instanceof Integer) == false) goto L148;
        r105 = r121;
    L148:
        Object r122 = (Integer) r105;     // Catch: Throwable -> L153
        if (r122 != null) goto L151;
        r122 = r101;
    L151:
        r114 = Result.m9449constructorimpl(r122);     // Catch: Throwable -> L153
    L82:
        if ((r115 instanceof Integer) == true) goto L84;
        Object r123 = null;
    L85:
        r116 = (Integer) r123;     // Catch: Throwable -> L127
        if (r116 != null) goto L125;
        if ((r115 instanceof Number) == false) goto L112;
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Integer.class), Reflection.getOrCreateKotlinClass(Float.TYPE)) == false) goto L97;
        Float r124 = Float.valueOf(((Number) r115).floatValue());     // Catch: Throwable -> L127
        if ((r124 instanceof Integer) == true) goto L95;
        r124 = null;
    L95:
        r116 = (Integer) r124;     // Catch: Throwable -> L127
        goto L125
    L97:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Integer.class), Reflection.getOrCreateKotlinClass(Double.TYPE)) == false) goto L103;
        Double r125 = Double.valueOf(((Number) r115).doubleValue());     // Catch: Throwable -> L127
        if ((r125 instanceof Integer) == true) goto L101;
        r125 = null;
    L101:
        r116 = (Integer) r125;     // Catch: Throwable -> L127
        goto L125
    L103:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Integer.class), Reflection.getOrCreateKotlinClass(Integer.TYPE)) == false) goto L106;
        r116 = Integer.valueOf(((Number) r115).intValue());     // Catch: Throwable -> L127
        goto L125
    L106:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Integer.class), Reflection.getOrCreateKotlinClass(Long.TYPE)) == false) goto L112;
        Long r126 = Long.valueOf(((Number) r115).longValue());     // Catch: Throwable -> L127
        if ((r126 instanceof Integer) == true) goto L110;
        r126 = null;
    L110:
        r116 = (Integer) r126;     // Catch: Throwable -> L127
    L112:
        if ((r115 instanceof JSONObject) == false) goto L114;
    L184:
        Object r127 = SDKSettingsCacheManager.a().fromJson(r115.toString(), Integer.class);     // Catch: Throwable -> L120
        if ((r127 instanceof Integer) == true) goto L118;
        r127 = null;
    L118:
        Object r128 = Result.m9449constructorimpl((Integer) r127);     // Catch: Throwable -> L120
    L122:
        r116 = r128;
        if (Result.m9455isFailureimpl(r116) == false) goto L125;
    L120:
        th = move-exception;
        Result.Companion r129 = Result.Companion;     // Catch: Throwable -> L127
        r128 = Result.m9449constructorimpl(ResultKt.createFailure(th));     // Catch: Throwable -> L127
        goto L122
    L114:
        if ((r115 instanceof JSONArray) == false) goto L124;
    L84:
        r123 = r115;
    L127:
        th = move-exception;
        Result.Companion r130 = Result.Companion;     // Catch: Throwable -> L153
        r117 = Result.m9449constructorimpl(ResultKt.createFailure(th));     // Catch: Throwable -> L153
    L174:
        this.f152832f = ((Number) r110).intValue();
        this.f152833g = true;
        this.f152839m = LazyKt.lazy(SaasCouponService$lynxCouponShowDelay$2.INSTANCE);
        this.f152840n = LazyKt.lazy(SaasCouponService$isShowDurationEventNAReport$2.INSTANCE);
        this.f152843q = LazyKt.lazy(new SaasCouponService$showToastRun$2(this));
        this.f152848v = new CompositeDisposable();
        this.f152849w = EComABUtils.saasCouponToastMaxShowCountDaily();
        this.f152851y = -1;
        this.f152852z = LazyKt.lazy(new SaasCouponService$fullPageEventCloseBlockSubscriber$2(this));
        this.A = LazyKt.lazy(new SaasCouponService$fullPageEventOpenProductListSubscriber$2(this));
        this.f152827a = ECLiveCommerceModel_ProvideLiveServiceFactory.proxyProvideLiveService(hh2.a.a().f485153f);
        return;
    L11:
        if ((r106 instanceof Integer) == true) goto L13;
        Object r131 = null;
    L14:
        r107 = (Integer) r131;     // Catch: Throwable -> L56
        if (r107 != null) goto L54;
        if ((r106 instanceof Number) == false) goto L41;
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Integer.class), Reflection.getOrCreateKotlinClass(Float.TYPE)) == false) goto L26;
        Float r132 = Float.valueOf(((Number) r106).floatValue());     // Catch: Throwable -> L56
        if ((r132 instanceof Integer) == true) goto L24;
        r132 = null;
    L24:
        r107 = (Integer) r132;     // Catch: Throwable -> L56
        goto L54
    L26:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Integer.class), Reflection.getOrCreateKotlinClass(Double.TYPE)) == false) goto L32;
        Double r133 = Double.valueOf(((Number) r106).doubleValue());     // Catch: Throwable -> L56
        if ((r133 instanceof Integer) == true) goto L30;
        r133 = null;
    L30:
        r107 = (Integer) r133;     // Catch: Throwable -> L56
        goto L54
    L32:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Integer.class), Reflection.getOrCreateKotlinClass(Integer.TYPE)) == false) goto L35;
        r107 = Integer.valueOf(((Number) r106).intValue());     // Catch: Throwable -> L56
        goto L54
    L35:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Integer.class), Reflection.getOrCreateKotlinClass(Long.TYPE)) == false) goto L41;
        Long r134 = Long.valueOf(((Number) r106).longValue());     // Catch: Throwable -> L56
        if ((r134 instanceof Integer) == true) goto L39;
        r134 = null;
    L39:
        r107 = (Integer) r134;     // Catch: Throwable -> L56
    L41:
        if ((r106 instanceof JSONObject) == false) goto L43;
    L180:
        Object r135 = SDKSettingsCacheManager.a().fromJson(r106.toString(), Integer.class);     // Catch: Throwable -> L49
        if ((r135 instanceof Integer) == true) goto L47;
        r135 = null;
    L47:
        Object r136 = Result.m9449constructorimpl((Integer) r135);     // Catch: Throwable -> L49
    L51:
        r107 = r136;
        if (Result.m9455isFailureimpl(r107) == false) goto L54;
    L49:
        th = move-exception;
        Result.Companion r137 = Result.Companion;     // Catch: Throwable -> L56
        r136 = Result.m9449constructorimpl(ResultKt.createFailure(th));     // Catch: Throwable -> L56
        goto L51
    L43:
        if ((r106 instanceof JSONArray) == false) goto L53;
    L13:
        r131 = r106;
    L56:
        th = move-exception;
        Result.Companion r138 = Result.Companion;     // Catch: Throwable -> L165
        r108 = Result.m9449constructorimpl(ResultKt.createFailure(th));     // Catch: Throwable -> L165
    L165:
        th = move-exception;
        Result.Companion r139 = Result.Companion;
        Object r140 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        Throwable r141 = Result.m9452exceptionOrNullimpl(r140);
        if (r141 == null) goto L170;
        EnsureManager.ensureNotReachHere(r141);
    L170:
        if (Result.m9455isFailureimpl(r140) == true) goto L173;
        r101 = r140;
    L173:
        r110 = r101;
        goto L174
    }

    public static final void c(SaasCouponService r100, String r101) {
        WeakReference<Context> r102 = r100.f152836j;
        if (r102 == null) goto L32;
        Context r103 = r102.get();
        if (r103 != null) goto L8;
        return;
    L8:
        if (r.f48132a.isLogin() == true) goto L11;
        return;
    L11:
        if (Intrinsics.areEqual(r100.f152829c.f19405b, "preview_benefit_coupon_popup") == false) goto L30;
        String r104 = new SimpleDateFormat("yyyyMMdd", Locale.getDefault()).format(new Date(System.currentTimeMillis()));
        if (r100.f152850x != null) goto L16;
        r100.f152850x = q.f48131a.getString("saascoupon_last_show_toast_date", "");
    L16:
        if (Intrinsics.areEqual(r100.f152850x, r104) == false) goto L21;
        if (r100.d() < r100.f152849w) goto L21;
        boolean r105 = false;
    L28:
        if (r105 == true) goto L30;
        return;
    L21:
        if (r100.f152850x != null) goto L23;
        r100.f152850x = q.f48131a.getString("saascoupon_last_show_toast_date", "");
    L23:
        r105 = true;
        if (Intrinsics.areEqual(r100.f152850x, r104) == false) goto L26;
        r100.f152851y = r100.d() + 1;
    L27:
        q.f48131a.d("saascoupon_show_toast_count_daily", r100.d());
        goto L28
    L26:
        r100.f152850x = r104;
        q.f48131a.putString("saascoupon_last_show_toast_date", r104);
        r100.f152851y = 1;
    L30:
        i.f48124a.e(r103, r101, false, false);
        return;
    }

    @Override // el2.n
    public final void b(Boolean r100, Integer r101) {
        Function1<? super JSONObject, Unit> r102 = this.f152837k;
        if (r102 == null) goto L11;
        JSONObject r103 = new JSONObject();
        if (r100 == null) goto L7;
        r100.booleanValue();
        r103.put("is_coupon_need_show", r100.booleanValue());
    L7:
        if (r101 == null) goto L9;
        r101.intValue();
        r103.put("action_type", r101.intValue());
    L9:
        Unit r104 = Unit.INSTANCE;
        Unit r105 = r102.invoke(r103);
        return;
    }

    public final void e(boolean r100, boolean r101) {
        g r102 = this.f152829c;
        r102.f19422s = r100;
        CompositeDisposable r103 = this.f152848v;
        dl2.e r104 = this.f152828b;
        r104.getClass();
        Intrinsics.checkNotNullParameter(r102, "requestParams");
        FilterNullArrayList<si2.k> r105 = new FilterNullArrayList();
        r105.add(new si2.k("enter_from", r102.f19404a));
        r105.add(new si2.k("popup_key", r102.f19405b));
        r105.add(new si2.k("room_id", r102.f19407d));
        r105.add(new si2.k("anchor_open_id", r102.f19408e));
        r105.add(new si2.k("reqid", r102.f19409f));
        r105.add(new si2.k("token", r102.f19410g));
        r105.add(new si2.k("cid", String.valueOf(r102.f19411h)));
        r105.add(new si2.k("ad_id", String.valueOf(r102.f19412i)));
        r105.add(new si2.k("biz_tag", r102.f19413j));
        r105.add(new si2.k("skip_frequency", String.valueOf(r102.f19419p)));
        r105.add(new si2.k("is_inner", String.valueOf(r102.f19420q)));
        r105.add(si2.k.a.a(ILiveRoomPlayFragmentConstant.ENTER_ECOM_LIVE_PARAMS, r102.f19421r));
        r105.add(new si2.k("is_first_request", String.valueOf(r102.f19422s)));
        l r106 = r104.f469112a;
        if (r106 == null) goto L6;
        Observable r107 = r106.b(si2.g.R, r105, bl2.b.class, new dl2.c());
        if (r107 == null) goto L6;
    L7:
        r103.add(r107.subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe(new b(this, r100, r101), new c(this)));
        return;
    L6:
        r107 = Observable.create(dl2.b.f469111a);
        goto L7
    }

    @Override // el2.n
    public final void a(Context r100, Bundle r110, Function1 r111, sg2.n r112) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r110, "args");
        Intrinsics.checkNotNullParameter(r111, "callBack");
        Intrinsics.checkNotNullParameter(r112, "getLiveRoomParams");
        Disposable r101 = null;
        if ((r100 instanceof FragmentActivity) == true) goto L5;
        Context r102 = null;
    L6:
        FragmentActivity r103 = (FragmentActivity) r102;
        if (r103 == null) goto L11;
        Lifecycle r104 = r103.getLifecycle();
        if (r104 == null) goto L11;
        r104.addObserver(new SaasCouponService$tryShowSaasCouponDialog$1(this));
    L11:
        this.f152836j = new WeakReference(r100);
        this.f152837k = r111;
        this.f152841o = r112;
        g r105 = this.f152829c;
        String r113 = r110.getString("room_id", "");
        r105.getClass();
        Intrinsics.checkNotNullParameter(r113, "<set-?>");
        r105.f19407d = r113;
        g r106 = this.f152829c;
        r110.getBoolean(IPerformanceManager.Params.is_portrait, true);
        r106.getClass();
        g r107 = this.f152829c;
        String r114 = r110.getString("anchor_open_id", "");
        r107.getClass();
        Intrinsics.checkNotNullParameter(r114, "<set-?>");
        r107.f19408e = r114;
        g r108 = this.f152829c;
        String r115 = r110.getString("enter_from", "live");
        r108.getClass();
        Intrinsics.checkNotNullParameter(r115, "<set-?>");
        r108.f19404a = r115;
        this.f152829c.f19419p = r110.getBoolean("first_coupon_popup_skip_frequency", false);
        this.f152829c.f19420q = r110.getBoolean("is_inner", false);
        JSONObject r109 = z1.g(r110.getString("enter_request", ""));
        if (r109 == null) goto L16;
        JSONObject r116 = r109.optJSONObject("params");
        if (r116 == null) goto L16;
        g r117 = this.f152829c;
        String r118 = r116.optString("reqid", "");
        r117.getClass();
        Intrinsics.checkNotNullParameter(r118, "<set-?>");
        r117.f19409f = r118;
        g r119 = this.f152829c;
        String r120 = r116.optString("token", "");
        r119.getClass();
        Intrinsics.checkNotNullParameter(r120, "<set-?>");
        r119.f19410g = r120;
        this.f152829c.f19411h = r116.optLong("cid", 0);
        this.f152829c.f19412i = r116.optLong("ad_id", 0);
        g r121 = this.f152829c;
        String r122 = r116.optString("biz_tag", "");
        r121.getClass();
        Intrinsics.checkNotNullParameter(r122, "<set-?>");
        r121.f19413j = r122;
    L16:
        String r123 = r110.getString("saas_coupon_popup_key");
        if (r123 != null) goto L19;
    L24:
        String r124 = r110.getString(ILiveRoomPlayFragmentConstant.ENTER_ECOM_LIVE_PARAMS);
        if (r124 == null) goto L33;
        if ((!StringsKt.isBlank(r124)) == true) goto L30;
        r124 = null;
    L30:
        if (r124 == null) goto L33;
        this.f152829c.f19421r = r124;
    L33:
        if (al2.a.f4122a.length() != 0) goto L35;
        boolean r125 = true;
    L36:
        if (r125 == false) goto L39;
        String r126 = r110.getString(com.bytedance.android.ec.core.event.a.KEY_CARD_TYPE, "");
        Intrinsics.checkNotNullParameter(r126, "<set-?>");
        al2.a.f4122a = r126;
    L39:
        if (al2.a.f4123b.length() != 0) goto L41;
        boolean r127 = true;
    L42:
        if (r127 == false) goto L45;
        String r128 = r110.getString("enter_from_event", "");
        Intrinsics.checkNotNullParameter(r128, "<set-?>");
        al2.a.f4123b = r128;
    L45:
        if (al2.a.f4124c.length() != 0) goto L47;
        boolean r129 = true;
    L48:
        if (r129 == false) goto L51;
        String r130 = r110.getString("previous_page", "");
        Intrinsics.checkNotNullParameter(r130, "<set-?>");
        al2.a.f4124c = r130;
    L51:
        if (al2.a.f4125d != 0) goto L53;
        al2.a.f4125d = r110.getLong("is_from_ug", 0);
    L53:
        int r131 = r110.getInt("saas_coupon_popup_has_applied", 0);
        al2.a.f4126e = r131;
        if (r131 != 0) goto L56;
        boolean r132 = true;
    L57:
        this.f152842p = r132;
        if (this.f152832f == 0) goto L60;
        dm.a.a("SaasCouponService").i("tryShowSaasCouponDialog, room_id: " + this.f152829c.f19407d + ", isStartLogin:" + g());
    L60:
        Observable<Boolean> r133 = r.f48132a.b();
        if (r133 == null) goto L63;
        r101 = r133.subscribe(new com.bytedance.android.livesdk.livecommerce.saascoupon.b(this));
    L63:
        this.f152847u = r101;
        e(true, false);
        return;
    L56:
        r132 = false;
        goto L57
    L47:
        r129 = false;
        goto L48
    L41:
        r127 = false;
        goto L42
    L35:
        r125 = false;
        goto L36
    L19:
        if (r123.length() <= 0) goto L21;
        boolean r134 = true;
    L22:
        if (r134 == false) goto L24;
        g r135 = this.f152829c;
        r135.getClass();
        Intrinsics.checkNotNullParameter(r123, "<set-?>");
        r135.f19405b = r123;
        goto L24
    L21:
        r134 = false;
        goto L22
    L5:
        r102 = r100;
        goto L6
    }
}
