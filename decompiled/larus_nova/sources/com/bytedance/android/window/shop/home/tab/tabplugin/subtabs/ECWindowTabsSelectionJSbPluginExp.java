package com.bytedance.android.window.shop.home.tab.tabplugin.subtabs;

import com.bytedance.android.ec.core.utils.s0;
import com.bytedance.android.window.shop.home.presenter.AbsECWindowPresenter$observableSourceFromLiveData$2;
import com.bytedance.android.window.shop.home.tab.tabplugin.ECWindowJsbPlugin;
import com.bytedance.android.window.shop.home.tab.tabplugin.c;
import com.bytedance.android.window.shop.home.viewmodel.ECWindowViewModel;
import com.bytedance.android.window.shop.repository.dto.p;
import io.reactivex.disposables.Disposable;
import java.util.ArrayList;
import java.util.List;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import org.greenrobot.eventbus.Subscribe;

/* JADX INFO: loaded from: classes14.dex */
public final class ECWindowTabsSelectionJSbPluginExp extends ECWindowJsbPlugin {

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final /* synthetic */ int f188958g = 0;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final List<p> f188959b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final List<Runnable> f188960c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public Disposable f188961d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final ECWindowViewModel f188962e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final Function2<String, List<p>, Unit> f188963f;

    public static final class a {
    }

    static {
    }

    @Override // com.bytedance.android.window.shop.home.tab.tabplugin.ECWindowJsbPlugin
    public final List<c> c() {
        return CollectionsKt.listOf(new c[]{new c("ecom.coupon.receive_result", new ECWindowTabsSelectionJSbPluginExp$createJsbActions$1(this)), new c("ecom.window.tab_anchor", new ECWindowTabsSelectionJSbPluginExp$createJsbActions$2(this))});
    }

    @Override // com.bytedance.android.window.shop.home.tab.tabplugin.ECWindowJsbPlugin, com.bytedance.android.window.shop.home.tab.tabplugin.e
    public final void a() {
        super.a();
        s0.c(this);
    }

    @Override // com.bytedance.android.window.shop.home.tab.tabplugin.ECWindowJsbPlugin, com.bytedance.android.window.shop.home.tab.tabplugin.e
    public final void b() {
        super.b();
        s0.e(this);
        Disposable r100 = this.f188961d;
        if (r100 == null) goto L6;
        r100.dispose();
        return;
    }

    @Subscribe
    public final void onReceiveAnchorEvent(com.bytedance.android.window.shop.home.tab.tabplugin.a r100) {
        Intrinsics.checkNotNullParameter(r100, "anchorParam");
        if ((!Intrinsics.areEqual(r100.f188930a, this.f188962e.getShopParam().getSecAuthorId())) == false) goto L5;
        return;
    L5:
        this.f188963f.invoke(r100.f188931b, this.f188959b);
    }

    public ECWindowTabsSelectionJSbPluginExp(ECWindowViewModel r100, Function2 r101, AbsECWindowPresenter$observableSourceFromLiveData$2 r102) {
        Intrinsics.checkNotNullParameter(r100, "viewModel");
        Intrinsics.checkNotNullParameter(r101, "onTabSelected");
        Intrinsics.checkNotNullParameter(r102, "categoryListSource");
        this.f188962e = r100;
        this.f188963f = r101;
        this.f188959b = new ArrayList();
        this.f188960c = new ArrayList();
        r102.subscribe(new com.bytedance.android.window.shop.home.tab.tabplugin.subtabs.a(this));
    }
}
