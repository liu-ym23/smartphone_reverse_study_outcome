package com.bytedance.android.shopping.skubuy.module;

import com.bytedance.android.shopping.abscontainer.arch.core.data.RefreshProtocolSource;
import com.bytedance.android.shopping.abscontainer.common_biz.widget.error.ErrorButtonAction;
import com.bytedance.android.shopping.skubuy.cache.SkuBuyResponseCacheHelper;
import com.larus.dora.obric.device_management.device_home.DoraObricDeviceHomeViewModel;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Lazy;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import u33.a;
import v43.a;
import v43.b;
import v43.n;
import v43.o;
import v43.s;
import v43.t;
import v43.u;

/* JADX INFO: loaded from: classes13.dex */
public final class SkuBuyCoreFlowModule<STATE extends v43.b & v43.a & s & o & n, PROPS extends u33.a> extends s33.b<STATE, PROPS> {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f183119b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final com.bytedance.android.shopping.skubuy.cache.a f183120c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public long f183121d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public k33.a f183122e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public boolean f183123f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public int f183124g;

    @Override // s33.b
    public final void x() {
    }

    public final void B() {
        ((v43.b) this.f540457a.f507247a).a().c(new y43.a(true, true, false, false, 24));
        ((v43.b) this.f540457a.f507247a).g().c(new x43.a(126));
        this.f540457a.f507250d.g().a(null, null, null);
    }

    @Override // s33.b
    public final void c() {
        ((v43.b) this.f540457a.f507247a).a().c(new y43.a(false, false, false, false, 30));
    }

    @Override // s33.b
    public final com.bytedance.android.shopping.abscontainer.arch.core.lifecycle.a d() {
        return new com.bytedance.android.shopping.abscontainer.arch.core.lifecycle.a(!this.f183123f);
    }

    @Override // s33.b
    public final void y() {
        ((v43.b) this.f540457a.f507247a).a().a(new f(this));
        ((v43.b) this.f540457a.f507247a).g().a(new g(this));
        Lazy r100 = SkuBuyResponseCacheHelper.f183110a;
        com.bytedance.android.shopping.abscontainer.arch.core.cache.a r101 = SkuBuyResponseCacheHelper.b(this.f183120c);
        if (r101 == null) goto L5;
        n33.a r102 = r101.f164128a;
    L6:
        if (r102 == null) goto L8;
        this.f540457a.f507250d.c().a();
        this.f540457a.f507250d.c().h(r102, RefreshProtocolSource.QUERY, new n33.d("biz_first_enter", null));
        this.f540457a.f507250d.a().c(MapsKt.mapOf(TuplesKt.to("has_used_cache", "1")));
        ((v43.b) this.f540457a.f507247a).a().c(new y43.a(false, false, false, false, 30));
        return;
    L8:
        ((v43.b) this.f540457a.f507247a).a().c(new y43.a(true, true, false, true, 16));
        return;
    L5:
        r102 = null;
        goto L6
    }

    @Override // s33.b
    public final String j() {
        return this.f183119b;
    }

    public SkuBuyCoreFlowModule(l33.b<STATE, PROPS> r100) {
        Intrinsics.checkNotNullParameter(r100, "containerContext");
        super(r100);
        this.f183119b = "CoreFlowModule";
        Lazy r101 = SkuBuyResponseCacheHelper.f183110a;
        this.f183120c = SkuBuyResponseCacheHelper.a(r100.f507249c.f548574a.getSchemaModel());
    }

    @Override // s33.b
    public final void e(n33.c r110) {
        Intrinsics.checkNotNullParameter(r110, "response");
        int r100 = this.f183124g;
        if (r100 > 0) goto L5;
    L8:
        ((v43.b) this.f540457a.f507247a).a().c(new y43.a(false, false, false, false, 30));
        n33.a r111 = r110.f516914a;
        if (r111 == null) goto L12;
        final Map<String, Object> r112 = r111.f();
        if (r112 == null) goto L12;
    L13:
        Object r101 = r112.get("icon");
        Object r102 = null;
        if ((r101 instanceof String) == true) goto L16;
        r101 = null;
    L16:
        String r103 = (String) r101;
        Object r104 = r112.get("title");
        if ((r104 instanceof String) == true) goto L19;
        r104 = null;
    L19:
        String r113 = (String) r104;
        Object r105 = r112.get("description");
        if ((r105 instanceof String) == true) goto L22;
        r105 = null;
    L22:
        String r114 = (String) r105;
        Object r106 = r112.get("button_text");
        if ((r106 instanceof String) == true) goto L25;
        r106 = null;
    L25:
        String r115 = (String) r106;
        Object r107 = r112.get("button_action");
        if ((r107 instanceof String) == false) goto L29;
        r102 = r107;
    L29:
        ((v43.b) this.f540457a.f507247a).g().c(new x43.a(true, true, r103, r113, r114, r115, (String) r102));
        this.f540457a.f507251e.f527569f.c(new SkuBuyCoreFlowModule$flowQueryFetchFailed$1(this, r112));
        this.f540457a.f507251e.f527569f.b(new SkuBuyCoreFlowModule$flowQueryFetchFailed$2(this));
        return;
    L12:
        r112 = MapsKt.mapOf(new Pair[]{TuplesKt.to("icon", "https://p6-piu.byteimg.com/tos-cn-i-8jisjyls3a/c5f693c88544439089cde4031581841b~tplv-8jisjyls3a-image.image"), TuplesKt.to("title", "网络异常"), TuplesKt.to("description", "请重新刷新页面"), TuplesKt.to("button_text", "刷新"), TuplesKt.to("button_action", ErrorButtonAction.REFRESH.getValue()), TuplesKt.to("debounce_time", 0)});
        goto L13
    L5:
        if (r110.f516916c == null) goto L8;
        this.f183124g = r100 - 1;
        ((n) this.f540457a.f507247a).I(true);
        n r116 = (n) this.f540457a.f507247a;
        r116.i(r116.L() + 1);
        B();
    }

    @Override // s33.b
    public final void f(n33.f r100) {
        Intrinsics.checkNotNullParameter(r100, "response");
        boolean r101 = false;
        if (com.bytedance.android.shopping.abscontainer.common_biz.helper.a.a(this.f540457a.f507250d.c(), null) == false) goto L14;
        Object r102 = r100.f516923e.get("query_version");
        if ((r102 instanceof Integer) == true) goto L7;
        r102 = null;
    L7:
        Integer r103 = (Integer) r102;
        if (r103 == null) goto L10;
        int r104 = r103.intValue();
    L12:
        if (r104 >= ((v43.a) this.f540457a.f507247a).h()) goto L14;
        return;
    L10:
        r104 = 0;
    L14:
        ((v43.b) this.f540457a.f507247a).g().c(new x43.a(126));
        ((s) this.f540457a.f507247a).B(r100);
        if (((v43.a) this.f540457a.f507247a).h() != 0) goto L17;
        r101 = true;
    L17:
        this.f183123f = r101;
        this.f540457a.f507250d.c().h(r100.f516920b, RefreshProtocolSource.QUERY, new n33.d("biz_first_enter", r100.f516921c));
        this.f540457a.f507250d.e().c(new SkuBuyCoreFlowModule$flowQueryFetchSucceed$2(this, r100, null));
    }

    @Override // s33.b
    public final void h(com.bytedance.kmp.ec.yata.common.biz.callback.a r100) {
        Intrinsics.checkNotNullParameter(r100, DoraObricDeviceHomeViewModel.PARAM_PRODUCT_MODEL);
        String r101 = r100.f251371b;
        t r102 = ((s) this.f540457a.f507247a).A();
        Object r103 = null;
        if (r102 == null) goto L12;
        List<u> r104 = r102.f553082b;
        if (r104 == null) goto L12;
        ArrayList r105 = new ArrayList();
        Iterator<T> r106 = r104.iterator();
    L8:
        if (r106.hasNext() == false) goto L13;
        Object r107 = r106.next();
        if (Intrinsics.areEqual(((u) r107).f553084b, r101) == false) goto L8;
        r105.add(r107);
    L13:
        b43.c r108 = b43.c.f17507a;
        if (r105 == null) goto L16;
        boolean r109 = r105.isEmpty();
    L17:
        if (r109 == true) goto L19;
        return;
    L19:
        String r110 = r100.f251372c;
        Object r111 = this.f540457a.f507250d.c().e("delay_loading_map");
        if ((r111 instanceof Map) == true) goto L22;
        r111 = null;
    L22:
        Map r112 = (Map) r111;
        if (r112 == null) goto L25;
        Object r113 = r112.get(r110);
    L27:
        if ((r113 instanceof Integer) == false) goto L30;
        r103 = r113;
    L30:
        Integer r114 = (Integer) r103;
        if (r114 == null) goto L33;
        int r115 = r114.intValue();
    L34:
        if (r115 <= 0) goto L39;
        ((v43.b) this.f540457a.f507247a).a().c(new y43.a(true, false, false, true, 16));
        k33.a r116 = this.f183122e;
        if (r116 == null) goto L38;
        r116.cancel();
    L38:
        this.f183122e = this.f540457a.f507250d.e().a(r115, new SkuBuyCoreFlowModule$flowUplinkStart$1(this));
        return;
    L39:
        ((v43.b) this.f540457a.f507247a).a().c(new y43.a(true, false, true, true, 16));
        return;
    L33:
        r115 = 0;
        goto L34
    L25:
        r113 = null;
        goto L27
    L16:
        r109 = true;
    L12:
        r105 = null;
        goto L13
    }

    @Override // s33.b
    public final void g(com.bytedance.kmp.ec.yata.common.biz.callback.a r100, n33.c r101) {
        Intrinsics.checkNotNullParameter(r100, DoraObricDeviceHomeViewModel.PARAM_PRODUCT_MODEL);
        Intrinsics.checkNotNullParameter(r101, "response");
        k33.a r102 = this.f183122e;
        if (r102 == null) goto L5;
        r102.cancel();
    L5:
        ((v43.b) this.f540457a.f507247a).a().c(new y43.a(false, false, false, false, 30));
        n33.a r103 = r101.f516914a;
        com.bytedance.kmp.ec.yata.common.protocol.data.c r104 = null;
        String r105 = null;
        if (r103 == null) goto L8;
        String r106 = r103.b();
    L9:
        if (r106 != null) goto L11;
    L14:
        boolean r107 = true;
    L15:
        if (r107 == true) goto L22;
        j33.e r108 = this.f540457a.f507250d.b();
        n33.a r109 = r101.f516914a;
        if (r109 == null) goto L19;
        r105 = r109.b();
    L19:
        if (r105 != null) goto L21;
        r105 = "";
    L21:
        r108.showToast(r105);
        return;
    L22:
        n33.a r110 = r101.f516914a;
        if (r110 == null) goto L25;
        r104 = r110.g();
    L25:
        if (r104 != null) goto L29;
        this.f540457a.f507250d.b().showToast("网络存在异常，请稍后重试");
        return;
    L29:
        return;
    L11:
        if (r106.length() == 0) goto L14;
        r107 = false;
        goto L15
    L8:
        r106 = null;
        goto L9
    }

    @Override // s33.b
    public final void i(com.bytedance.kmp.ec.yata.common.biz.callback.a r100, n33.f r101) {
        Intrinsics.checkNotNullParameter(r100, DoraObricDeviceHomeViewModel.PARAM_PRODUCT_MODEL);
        Intrinsics.checkNotNullParameter(r101, "response");
        k33.a r102 = this.f183122e;
        if (r102 == null) goto L6;
        r102.cancel();
        return;
    }
}
