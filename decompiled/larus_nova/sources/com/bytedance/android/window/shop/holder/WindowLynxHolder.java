package com.bytedance.android.window.shop.holder;

import android.graphics.Rect;
import android.view.ViewGroup;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;
import com.bytedance.android.ec.core.widget.RoundedFrameLayout;
import com.bytedance.android.ec.hybrid.card.api.ECLynxCardErrorType;
import com.bytedance.android.ec.hybrid.card.api.IECLynxCardLifeCycle;
import com.bytedance.android.ec.hybrid.card.util.k;
import com.bytedance.android.ec.window.base.product.lynxcard.ECLynxCardEvent;
import com.bytedance.android.window.shop.holder.presenter.HeadAnimationPresenter;
import com.bytedance.android.window.shop.product.presenter.lynxCard.ECLynxCardPresenter;
import com.bytedance.android.window.shop.repository.tab.entity.WindowLayoutType;
import com.bytedance.android.window.shop.repository.tab.entity.f;
import com.bytedance.android.window.shop.repository.tab.entity.v;
import com.bytedance.ies.sdk.widgets.api.WidgetService;
import com.larus.nova.R;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import com.ss.android.ugc.aweme.kiwi.presenter.QGroupPresenter;
import com.ss.android.ugc.aweme.kiwi.presenter.QIPresenter;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes14.dex */
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u0003:\u0001\u0004¨\u0006\u0005"}, d2 = {"Lcom/bytedance/android/window/shop/holder/WindowLynxHolder;", "Lcom/bytedance/android/window/shop/holder/ShopWindowGenericHolder;", "Lcom/bytedance/android/window/shop/repository/tab/entity/v;", "Lcom/bytedance/android/ec/hybrid/card/api/IECLynxCardLifeCycle;", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "ec-biz-store-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class WindowLynxHolder extends ShopWindowGenericHolder<v> implements IECLynxCardLifeCycle {
    public final Function2<v, ECLynxCardEvent, Unit> A;
    public final boolean B;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public float f187876v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public WindowLayoutType f187877w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public v f187878x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public final Lazy f187879y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public final Fragment f187880z;

    public static final class a {
    }

    static {
    }

    @Override // com.bytedance.android.ec.hybrid.card.api.IECLynxCardLifeCycle
    public final void createViewDuration(long r100) {
    }

    @Override // com.bytedance.android.ec.hybrid.card.api.IECLynxCardLifeCycle
    public final void onCreateKitViewEnd(long r100) {
    }

    @Override // com.bytedance.android.ec.hybrid.card.api.IECLynxCardLifeCycle
    public final void onDestroy() {
    }

    @Override // com.bytedance.android.ec.hybrid.card.api.IECLynxCardLifeCycle
    public final void onFirstScreen() {
    }

    @Override // com.bytedance.android.ec.hybrid.card.api.IECLynxCardLifeCycle
    public final void onLoadStart() {
    }

    @Override // com.bytedance.android.ec.hybrid.card.api.IECLynxCardLifeCycle
    public final void onLoadSuccess() {
    }

    @Override // com.bytedance.android.ec.hybrid.card.api.IECLynxCardLifeCycle
    public final void onPreCreateView(boolean r100) {
    }

    @Override // com.bytedance.android.ec.hybrid.card.api.IECLynxCardLifeCycle
    public final void onRealSuccess() {
    }

    @Override // com.bytedance.android.ec.hybrid.card.api.IECLynxCardLifeCycle
    public final void onReceivedError(com.bytedance.lynx.service.model.b r100) {
    }

    @Override // com.bytedance.android.ec.hybrid.card.api.IECLynxCardLifeCycle
    public final void onRuntimeReady() {
    }

    @Override // com.bytedance.android.ec.hybrid.card.api.IECLynxCardLifeCycle
    public final void onTimingSetup(Map<String, ? extends Object> r100) {
    }

    @Override // com.bytedance.android.ec.hybrid.card.api.IECLynxCardLifeCycle
    public final void onTimingSetupPref(k r100) {
    }

    @Override // com.bytedance.android.ec.hybrid.card.api.IECLynxCardLifeCycle
    public final void onTimingUpdatePref(k r100) {
    }

    @Override // com.bytedance.android.ec.hybrid.card.api.IECLynxCardLifeCycle
    public final void onTransDataTime(long r100, long r101) {
    }

    @Override // com.bytedance.android.window.shop.holder.ShopWindowGenericHolder
    public final boolean v4() {
        return false;
    }

    @Override // com.bytedance.android.window.shop.holder.ShopWindowItemHolder
    public final boolean s4() {
        v r100 = this.f187878x;
        if (r100 == null) goto L7;
        v.b r101 = r100.f189636k;
        if (r101 == null) goto L7;
        Boolean r102 = r101.b();
    L9:
        if (Intrinsics.areEqual(r102, Boolean.FALSE) == true) goto L11;
        WindowLayoutType r103 = this.f187877w;
        if (r103 != null) goto L17;
    L19:
        return false;
    L17:
        if (r103.isSingleColumn() != true) goto L19;
        return true;
    L11:
        if (this.f187876v <= 0.5f) goto L20;
        return true;
    L20:
        return false;
    L7:
        r102 = null;
        goto L9
    }

    @Override // com.bytedance.android.window.shop.holder.ShopWindowGenericHolder, com.bytedance.android.window.shop.holder.ShopWindowItemHolder
    public final void q4(f r100) {
        v r101 = (v) r100;
        Intrinsics.checkNotNullParameter(r101, "vo");
        v.b r102 = r101.f189636k;
        if (r102 == null) goto L5;
        this.f187876v = r102.d();
    L5:
        this.f187878x = r101;
        super.q4(r101);
    }

    @Override // com.bytedance.android.window.shop.holder.ShopWindowItemHolder
    public final Rect r4(int r110) {
        v r111 = this.f187878x;
        if (r111 == null) goto L10;
        v.b r112 = r111.f189636k;
        if (r112 == null) goto L10;
        v.c r113 = r112.a();
        if (r113 == null) goto L10;
        return new Rect(d.a(Integer.valueOf(r113.b())), d.a(Integer.valueOf(r113.d())), d.a(Integer.valueOf(r113.c())), d.a(Integer.valueOf(r113.a())));
    L10:
        ViewGroup.LayoutParams r114 = this.itemView.getLayoutParams();
        if (r114 == null) goto L40;
        int r115 = ((StaggeredGridLayoutManager.LayoutParams) r114).getSpanIndex();
        v r100 = this.f187878x;
        if (r100 == null) goto L17;
        v.b r101 = r100.f189636k;
        if (r101 == null) goto L17;
        Boolean r102 = r101.b();
    L19:
        if ((!Intrinsics.areEqual(r102, Boolean.TRUE)) == true) goto L21;
        WindowLayoutType r103 = this.f187877w;
        if (r103 == null) goto L38;
        if (r103.isDoubleColumn() != true) goto L38;
        if ((r115 % 2) != 1) goto L36;
        return new Rect(d.a(Double.valueOf(4.5d)), 0, d.a(12), d.a(9));
    L36:
        return new Rect(d.a(12), 0, d.a(Double.valueOf(4.5d)), d.a(9));
    L38:
        return new Rect(d.a(12), 0, d.a(12), d.a(8));
    L21:
        if (this.f187876v <= 0.5f) goto L24;
        return new Rect(d.a(12), d.a(8), d.a(12), d.a(8));
    L24:
        if ((r115 % 2) != 1) goto L27;
        return new Rect(d.a(Double.valueOf(4.5d)), 0, d.a(12), d.a(9));
    L27:
        return new Rect(d.a(12), 0, d.a(Double.valueOf(4.5d)), d.a(9));
    L17:
        r102 = null;
        goto L19
    L40:
        throw new NullPointerException("null cannot be cast to non-null type androidx.recyclerview.widget.StaggeredGridLayoutManager.LayoutParams");
    }

    @Override // com.bytedance.android.window.shop.holder.ShopWindowGenericHolder
    public final QIPresenter u4(Fragment r100) {
        Intrinsics.checkNotNullParameter(r100, WidgetService.PARAM_FRAGMENT);
        QGroupPresenter r101 = new QGroupPresenter();
        r101.a((ECLynxCardPresenter) this.f187879y.getValue());
        if (this.B == false) goto L5;
        r101.a(new HeadAnimationPresenter());
    L5:
        return r101;
    }

    @Override // com.bytedance.android.ec.hybrid.card.api.IECLynxCardLifeCycle
    public final void useCache(@IECLynxCardLifeCycle.ECLynxCardCacheType String r100) {
        Intrinsics.checkNotNullParameter(r100, "cache");
        Intrinsics.checkNotNullParameter(r100, "cache");
    }

    /* JADX WARN: Multi-variable type inference failed */
    public WindowLynxHolder(Fragment r100, Function2<? super v, ? super ECLynxCardEvent, Unit> r101, boolean r102) {
        Intrinsics.checkNotNullParameter(r100, WidgetService.PARAM_FRAGMENT);
        Intrinsics.checkNotNullParameter(r101, "callback");
        RoundedFrameLayout r103 = new RoundedFrameLayout(r100.getContext());
        r103.setId(R.id.ec_shop_lynx_container);
        r103.setMinimumHeight(5);
        Unit r104 = Unit.INSTANCE;
        super(r100, r103);
        this.f187880z = r100;
        this.A = r101;
        this.B = r102;
        this.f187876v = 1.0f;
        this.f187877w = WindowLayoutType.DOUBLECOLUMN;
        this.f187879y = LazyKt.lazy(new WindowLynxHolder$lynxCardPresenter$2(this));
    }

    @Override // com.bytedance.android.ec.hybrid.card.api.IECLynxCardLifeCycle
    public final void onLoadFailed(ECLynxCardErrorType r100, Integer r101, String r102) {
        Intrinsics.checkNotNullParameter(r100, "type");
        Intrinsics.checkNotNullParameter(r100, "type");
    }
}
