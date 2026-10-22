package com.bytedance.android.window.shop.home.tab.tabplugin;

import com.bytedance.android.ec.core.utils.s0;
import com.bytedance.android.window.shop.home.viewmodel.ECWindowViewModel;
import java.util.List;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.greenrobot.eventbus.Subscribe;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes14.dex */
public final class ECWindowTabNewProductPlugin extends ECWindowJsbPlugin {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final /* synthetic */ int f188918e = 0;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final ECWindowViewModel f188919b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final com.bytedance.android.window.shop.c f188920c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Function1<TabNavigationParams, Unit> f188921d;

    public static final class a {
    }

    static {
    }

    @Override // com.bytedance.android.window.shop.home.tab.tabplugin.ECWindowJsbPlugin
    public final List<c> c() {
        return CollectionsKt.listOf(new c[]{new c("ecom.coupon.receive_result", new ECWindowTabNewProductPlugin$createJsbActions$1(this)), new c("ecom.window.category_anchor", new ECWindowTabNewProductPlugin$createJsbActions$2(this))});
    }

    @Override // com.bytedance.android.window.shop.home.tab.tabplugin.ECWindowJsbPlugin, com.bytedance.android.window.shop.home.tab.tabplugin.e
    public final void a() {
        super.a();
        s0.c(this);
    }

    @Override // com.bytedance.android.window.shop.home.tab.tabplugin.ECWindowJsbPlugin, com.bytedance.android.window.shop.home.tab.tabplugin.e
    public final void b() {
        s0.e(this);
        super.b();
    }

    public final void h(JSONObject r100) {
        String r101 = r100.optString("sec_author_id", "");
        boolean r102 = true;
        if ((!Intrinsics.areEqual(r101, "")) == true) goto L6;
        r101 = null;
    L6:
        if (r101 != null) goto L8;
    L11:
        if (r102 == false) goto L14;
        Function1<TabNavigationParams, Unit> r103 = this.f188921d;
        TabNavigationParams.Companion.getClass();
        r103.invoke(TabNavigationParams.a.a(r100));
        return;
    L14:
        return;
    L8:
        if (Intrinsics.areEqual(r101, this.f188919b.getShopParam().getSecAuthorId()) == true) goto L11;
        r102 = false;
        goto L11
    }

    @Subscribe
    public final void onReceiveAnchorEvent(com.bytedance.android.window.shop.home.tab.tabplugin.a r100) {
        Intrinsics.checkNotNullParameter(r100, "anchorParam");
        if ((!Intrinsics.areEqual(this.f188920c, com.bytedance.android.window.shop.c.f187762c)) == false) goto L6;
        return;
    L6:
        if ((!Intrinsics.areEqual(r100.f188930a, this.f188919b.getShopParam().getSecAuthorId())) == false) goto L8;
        return;
    L8:
        String r101 = r100.f188931b;
        if (r101 != null) goto L11;
        WindowNavigationParam.Companion.getClass();
        WindowNavigationParam r102 = WindowNavigationParam.a.b();
    L12:
        WindowNavigationParam r103 = r102;
        String r104 = r100.f188932c;
        if (r104 != null) goto L15;
        r104 = "";
    L15:
        Long r105 = r100.f188933d;
        Function1<TabNavigationParams, Unit> r106 = this.f188921d;
        WindowNavigationParam.Companion.getClass();
        r106.invoke(new TabNavigationParams(WindowNavigationParam.a.b(), r105, r103, r104, null, WindowNavigationParam.a.b()));
        return;
    L11:
        WindowNavigationParam.Companion.getClass();
        r102 = WindowNavigationParam.a.c(r101);
        goto L12
    }

    /* JADX WARN: Multi-variable type inference failed */
    public ECWindowTabNewProductPlugin(ECWindowViewModel r100, com.bytedance.android.window.shop.c r101, Function1<? super TabNavigationParams, Unit> r102) {
        Intrinsics.checkNotNullParameter(r100, "viewModel");
        Intrinsics.checkNotNullParameter(r101, "currentTabType");
        Intrinsics.checkNotNullParameter(r102, "actionPerformer");
        this.f188919b = r100;
        this.f188920c = r101;
        this.f188921d = r102;
    }
}
