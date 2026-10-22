package com.bytedance.android.shopping.store.home.presenter;

import android.animation.ObjectAnimator;
import android.animation.PropertyValuesHolder;
import android.view.View;
import androidx.fragment.app.Fragment;
import com.bytedance.android.ec.store.common.floatelement.StoreCartEntryConfig;
import com.bytedance.android.ec.store.view.ECShopLabelTextView;
import com.bytedance.android.live.core.anim.LiveDegradeFpsAnimator;
import com.bytedance.android.shopping.store.home.datasource.ECShopDataStorageForRemote;
import com.bytedance.android.shopping.store.home.entity.CartCtrlInfo;
import com.bytedance.android.shopping.store.home.entity.ECShopCartInfo;
import com.bytedance.android.shopping.store.home.entity.ShopCartIconType;
import com.bytedance.android.shopping.store.home.entity.ShopCartStatus;
import com.bytedance.android.shopping.store.home.view.LottieAnimationViewWithPlayCount;
import com.bytedance.android.shopping.store.repository.vo.ShopRemoteStruct;
import com.bytedance.android.shopping.store.repository.vo.TabEnum;
import com.bytedance.android.shopping.store.viewmodel.ECStoreViewModel;
import com.bytedance.services.apm.api.EnsureManager;
import com.facebook.drawee.view.SimpleDraweeView;
import com.google.gson.Gson;
import com.ss.android.ugc.aweme.compat.nullable.Observer;
import com.ss.android.ugc.aweme.kiwi.model.QModel;
import java.lang.ref.WeakReference;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes14.dex */
public final class ECShopFloatCartEntryPresenterV2 extends ECShopAbsFloatPresenter {

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final Lazy f183920k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final long f183921l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final Lazy f183922m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final Lazy f183923n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public final Lazy f183924o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public final Lazy f183925p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public final Lazy f183926q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public Runnable f183927r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public ECShopCartInfo f183928s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public boolean f183929t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public AnimationStatus f183930u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public float f183931v;

    public static final class a implements z3 {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ ECShopFloatCartEntryPresenterV2 f183932a;

        @Override // com.bytedance.android.shopping.store.home.presenter.z3
        public final void onHidden() {
        }

        @Override // com.bytedance.android.shopping.store.home.presenter.z3
        public final void a() {
            ECShopFloatCartEntryPresenterV2 r100 = this.f183932a;
            if (r100.f183929t == true) goto L15;
            ECStoreViewModel r101 = r100.W();
            ECShopCartInfo r102 = this.f183932a.f183928s;
            if (r102 == null) goto L7;
            Map<String, String> r103 = r102.getLogExtra();
        L8:
            Pair<String, String>[] r104 = new Pair[7];
            r104[0] = TuplesKt.to("page_name", "store_page");
            r104[1] = TuplesKt.to(com.bytedance.android.ec.core.event.a.KEY_STORE_TYPE, "shop");
            r104[2] = TuplesKt.to(com.bytedance.android.ec.core.event.a.KEY_CLICK_AREA, "icon");
            r104[3] = TuplesKt.to("author_id", this.f183932a.W().getStoreParam().getStoreAccountParam().getUserId());
            r104[4] = TuplesKt.to(com.bytedance.android.ec.core.event.a.KEY_SHOP_ID, this.f183932a.W().getStoreParam().getShopId());
            r104[5] = TuplesKt.to("sec_shop_id", this.f183932a.W().getStoreParam().getSecShopId());
            ShopCartStatus.a r105 = ShopCartStatus.Companion;
            ECShopCartInfo r106 = this.f183932a.f183928s;
            if (r106 == null) goto L13;
            CartCtrlInfo r107 = r106.getCartCtrlInfo();
            if (r107 == null) goto L13;
            Integer r108 = r107.getShopCartStatus();
        L14:
            r105.getClass();
            r104[6] = TuplesKt.to("cart_status", ShopCartStatus.a.a(r108));
            r101.doEventAction("show_cart_entrance", r103, r104);
        L13:
            r108 = null;
            goto L14
        L7:
            r103 = null;
        L15:
            ECShopFloatCartEntryPresenterV2 r109 = this.f183932a;
            r109.f183929t = true;
            Runnable r110 = r109.f183927r;
            if (r110 == null) goto L18;
            r110.run();
        L18:
            this.f183932a.f183927r = null;
        }

        @Override // com.bytedance.android.shopping.store.home.presenter.z3
        public final void onClick() {
            ECStoreViewModel r100 = this.f183932a.W();
            Pair<String, String>[] r101 = new Pair[7];
            r101[0] = TuplesKt.to("page_name", "store_page");
            r101[1] = TuplesKt.to(com.bytedance.android.ec.core.event.a.KEY_STORE_TYPE, "shop");
            r101[2] = TuplesKt.to(com.bytedance.android.ec.core.event.a.KEY_CLICK_AREA, "icon");
            r101[3] = TuplesKt.to("author_id", this.f183932a.W().getStoreParam().getStoreAccountParam().getUserId());
            r101[4] = TuplesKt.to(com.bytedance.android.ec.core.event.a.KEY_SHOP_ID, this.f183932a.W().getStoreParam().getShopId());
            r101[5] = TuplesKt.to("sec_shop_id", this.f183932a.W().getStoreParam().getSecShopId());
            ShopCartStatus.a r102 = ShopCartStatus.Companion;
            ECShopCartInfo r103 = this.f183932a.f183928s;
            if (r103 == null) goto L7;
            CartCtrlInfo r104 = r103.getCartCtrlInfo();
            if (r104 == null) goto L7;
            Integer r105 = r104.getShopCartStatus();
        L8:
            r102.getClass();
            r101[6] = TuplesKt.to("cart_status", ShopCartStatus.a.a(r105));
            r100.doEventAction("click_cart_entrance", r101);
            return;
        L7:
            r105 = null;
            goto L8
        }

        public a(ECShopFloatCartEntryPresenterV2 r100) {
            this.f183932a = r100;
        }
    }

    public static final class b implements a4 {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ ECShopFloatCartEntryPresenterV2 f183933a;

        @Override // com.bytedance.android.shopping.store.home.presenter.a4
        public final jm.a<Integer> a() {
            return this.f183933a.W().getScrollState();
        }

        @Override // com.bytedance.android.shopping.store.home.presenter.a4
        public final jm.a<Pair<Integer, Integer>> b() {
            return this.f183933a.W().getSelectedTabLocation();
        }

        @Override // com.bytedance.android.shopping.store.home.presenter.a4
        public final jm.a<Float> c() {
            return this.f183933a.W().getCollapseFactor();
        }

        @Override // com.bytedance.android.shopping.store.home.presenter.a4
        public final jm.a<StoreCartEntryConfig> d() {
            return this.f183933a.W().getCartEntryConfig();
        }

        public b(ECShopFloatCartEntryPresenterV2 r100) {
            this.f183933a = r100;
        }

        @Override // com.bytedance.android.shopping.store.home.presenter.a4
        public final void e(LottieAnimationViewWithPlayCount r100) {
            this.f183933a.W().getCartAnimationView().setValue(new WeakReference(r100));
        }

        @Override // com.bytedance.android.shopping.store.home.presenter.a4
        public final void f(View r100) {
            this.f183933a.W().getCartView().setValue(new WeakReference(r100));
        }
    }

    public static final class c<T> implements Observer {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ ECShopFloatCartEntryPresenterV2 f183934a;

        public c(ECShopFloatCartEntryPresenterV2 r100) {
            this.f183934a = r100;
        }

        @Override // androidx.lifecycle.Observer
        public final void onChanged(Object r100) {
            StoreCartEntryConfig r101 = (StoreCartEntryConfig) r100;
            ECShopFloatCartEntryPresenterV2 r102 = this.f183934a;
            boolean r103 = false;
            if (r101 == null) goto L13;
            String r104 = r101.getJumpUrl();
            if (r104 != null) goto L7;
        L10:
            boolean r105 = true;
        L11:
            if (r105 == true) goto L13;
            r103 = true;
            goto L13
        L7:
            if (StringsKt.isBlank(r104) == true) goto L10;
            r105 = false;
        L13:
            r102.f183859h = Boolean.valueOf(r103);
            Boolean r106 = this.f183934a.f183859h;
            Intrinsics.checkNotNull(r106);
            if (r106.booleanValue() == false) goto L17;
            this.f183934a.Q();
            this.f183934a.y().setOnClickListener(new z(this, r101));
            return;
        }
    }

    public static final class d<T> implements Observer {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ ECShopFloatCartEntryPresenterV2 f183935a;

        public d(ECShopFloatCartEntryPresenterV2 r100) {
            this.f183935a = r100;
        }

        @Override // androidx.lifecycle.Observer
        public final void onChanged(Object r110) {
            ECShopCartInfo r111 = (ECShopCartInfo) r110;
            this.f183935a.f183928s = r111;
            if (r111 == null) goto L7;
            Map<String, String> r100 = r111.getBizExtra();
            if (r100 == null) goto L7;
            String r101 = r100.get("icon_type");
        L9:
            if (Intrinsics.areEqual(r101, ShopCartIconType.RED.getType()) == false) goto L15;
            if (this.f183935a.W().isBrandShopUpgrade() == false) goto L13;
            this.f183935a.U().setAnimation("shop_cart_animation_all_red_new.json");
        L18:
            this.f183935a.y().setOnClickListener(new b0(this, r111));
            Gson r102 = new Gson();     // Catch: Exception -> L27
            CartCtrlInfo r103 = r111.getCartCtrlInfo();     // Catch: Exception -> L27
            if (r103 == null) goto L22;
            String r104 = r103.getNativeStorage();     // Catch: Exception -> L27
        L23:
            ShopRemoteStruct r105 = (ShopRemoteStruct) r102.fromJson(r104, ShopRemoteStruct.class);     // Catch: Exception -> L27
            if (r105 == null) goto L29;
            ECShopDataStorageForRemote.f183626b.c(r105.getActionType(), r105.getSecShopId(), r105.getUserId(), r105.getBusinessId(), r105.getData());     // Catch: Exception -> L27
            this.f183935a.W().getStoreParam().updateSqlClientData();     // Catch: Exception -> L27
        L29:
            CartCtrlInfo r106 = r111.getCartCtrlInfo();
            if (r106 == null) goto L32;
            Integer r107 = r106.getShopCartStatus();
        L33:
            int r108 = ShopCartStatus.BOTTOM.getStatus();
            if (r107 != null) goto L37;
        L39:
            int r109 = ShopCartStatus.SLIDE.getStatus();
            if (r107 != null) goto L43;
        L50:
            ShopCartStatus.ICON.getStatus();
            if (r107 == null) goto L61;
            r107.intValue();
            return;
        L61:
            return;
        L43:
            if (r107.intValue() != r109) goto L50;
            this.f183935a.V().setVisibility(8);
            this.f183935a.V().a(r111.getBottomLabel(), true);
            com.bytedance.android.ec.core.imagex.h0.d((SimpleDraweeView) this.f183935a.f183924o.getValue(), r111.getProductImg(), this.f183935a.W().getImageCallerContext(), null, null, null, null, 120);
            ((ECShopLabelTextView) this.f183935a.f183925p.getValue()).a(r111.getSlideLabel(), false);
            ECShopFloatCartEntryPresenterV2 r112 = this.f183935a;
            SimpleDraweeView r113 = (SimpleDraweeView) r112.f183924o.getValue();
            Intrinsics.checkNotNullParameter(r113, "$this$unSpecifiedWidth");
            r113.measure(View.MeasureSpec.makeMeasureSpec(0, 0), 0);
            float r114 = r113.getMeasuredWidth();
            ECShopLabelTextView r115 = (ECShopLabelTextView) this.f183935a.f183925p.getValue();
            Intrinsics.checkNotNullParameter(r115, "$this$unSpecifiedWidth");
            r115.measure(View.MeasureSpec.makeMeasureSpec(0, 0), 0);
            r112.f183931v = ((r114 + r115.getMeasuredWidth()) + com.bytedance.android.shopping.store.utils.o.a(63)) + com.bytedance.android.shopping.store.utils.o.a(26);
            ECShopFloatCartEntryPresenterV2 r116 = this.f183935a;
            if (r116.f183930u == AnimationStatus.RUNNING) goto L60;
            a0 r117 = new a0(this, r111);
            r116.f183927r = r117;
            if (r116.f183929t == false) goto L58;
            r117.run();
            this.f183935a.f183927r = null;
            return;
        L58:
            return;
        L60:
            return;
        L37:
            if (r107.intValue() != r108) goto L39;
            this.f183935a.V().a(r111.getBottomLabel(), true);
            this.f183935a.V().setVisibility(0);
            return;
        L32:
            r107 = null;
            goto L33
        L22:
            r104 = null;
        L27:
            e = move-exception;
            EnsureManager.ensureNotReachHere(e);
            goto L29
        L13:
            this.f183935a.U().setAnimation("shop_cart_animation_all_red.json");
            goto L18
        L15:
            if (this.f183935a.W().isBrandShopUpgrade() == false) goto L17;
            this.f183935a.U().setAnimation("shop_cart_animation_black_red_new.json");
            goto L18
        L17:
            this.f183935a.U().setAnimation("shop_cart_animation_black_red.json");
        L7:
            r101 = null;
            goto L9
        }
    }

    public final LottieAnimationViewWithPlayCount U() {
        return (LottieAnimationViewWithPlayCount) this.f183922m.getValue();
    }

    public final ECShopLabelTextView V() {
        return (ECShopLabelTextView) this.f183923n.getValue();
    }

    public final ECStoreViewModel W() {
        return (ECStoreViewModel) this.f183920k.getValue();
    }

    @Override // com.bytedance.android.shopping.store.home.presenter.ECShopAbsFloatPresenter
    public final z3 E() {
        return new a(this);
    }

    @Override // com.bytedance.android.shopping.store.home.presenter.ECShopAbsFloatPresenter
    public final a4 F() {
        return new b(this);
    }

    @Override // com.bytedance.android.shopping.store.home.presenter.ECShopAbsFloatPresenter
    public final boolean D() {
        uj3.j r100 = W().getCurrentTab();
        if (r100 != null) goto L6;
        return false;
    L6:
        if (r100.i() == true) goto L10;
        if (r100.g() == true) goto L10;
        return false;
    L10:
        if (r100.f550300d != TabEnum.MOMENTS_TAB.getType()) goto L12;
        boolean r101 = true;
    L13:
        if (r101 == true) goto L17;
        return true;
    L17:
        return false;
    L12:
        r101 = false;
        goto L13
    }

    public ECShopFloatCartEntryPresenterV2(final Fragment r100) {
        super(r100);
        this.f183920k = LazyKt.lazy(new ECShopFloatCartEntryPresenterV2$viewModel$2(this, r100));
        this.f183921l = 200;
        this.f183922m = LazyKt.lazy(new ECShopFloatCartEntryPresenterV2$cartAnimation$2(this));
        this.f183923n = LazyKt.lazy(new ECShopFloatCartEntryPresenterV2$cartBottomDesc$2(this));
        this.f183924o = LazyKt.lazy(new ECShopFloatCartEntryPresenterV2$productImg$2(this));
        this.f183925p = LazyKt.lazy(new ECShopFloatCartEntryPresenterV2$cartSlideDesc$2(this));
        this.f183926q = LazyKt.lazy(new ECShopFloatCartEntryPresenterV2$cartSlideWrapper$2(this));
        this.f183930u = AnimationStatus.DEFAULT;
        this.f183931v = com.bytedance.android.ec.core.utils.q.a(20);
    }

    public static final void S(ECShopFloatCartEntryPresenterV2 r100) {
        r100.V().setVisibility(0);
        ObjectAnimator r101 = ObjectAnimator.ofPropertyValuesHolder(r100.V(), new PropertyValuesHolder[]{PropertyValuesHolder.ofFloat(LiveDegradeFpsAnimator.SCALE_X, new float[]{0.0f, 1.0f}), PropertyValuesHolder.ofFloat(LiveDegradeFpsAnimator.SCALE_Y, new float[]{0.0f, 1.0f})});
        r101.setInterpolator(new com.bytedance.android.ec.hybrid.tools.g(2.366f));
        r101.setDuration(343);
        r101.start();
    }

    public static final View T(ECShopFloatCartEntryPresenterV2 r100) {
        return (View) r100.f183926q.getValue();
    }

    @Override // com.ss.android.ugc.aweme.kiwi.presenter.QPresenter
    public final void A(QModel r100) {
        jm.a<StoreCartEntryConfig> r101 = G().d();
        if (r101 == null) goto L5;
        r101.a(I(), new c(this), false);
    L5:
        W().getCartInfo().a(I(), new d(this), false);
        K();
    }

    @Override // com.bytedance.android.shopping.store.home.presenter.ECShopAbsFloatPresenter
    public final void O(int r100) {
        if (r100 != 0) goto L4;
        G().f(y());
        G().e(U());
        return;
    L4:
        G().f(null);
        G().e(null);
    }
}
