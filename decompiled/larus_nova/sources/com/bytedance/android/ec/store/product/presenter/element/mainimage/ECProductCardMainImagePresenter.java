package com.bytedance.android.ec.store.product.presenter.element.mainimage;

import android.animation.Animator;
import android.animation.ObjectAnimator;
import android.graphics.Rect;
import android.view.View;
import android.view.ViewGroup;
import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.PagerAdapter;
import com.alibaba.gaiax.template.GXTemplateKey;
import com.baidu.platform.comapi.map.MapController;
import com.bytedance.android.ec.core.imagex.ImageExtensionsKt;
import com.bytedance.android.ec.core.imagex.h0;
import com.bytedance.android.ec.core.imagex.r;
import com.bytedance.android.ec.core.widget.AspectRatioFrameLayout;
import com.bytedance.android.ec.store.product.holder.LayoutTypes;
import com.bytedance.android.ec.store.repository.vo.ScrollStatus;
import com.bytedance.android.ec.store.repository.vo.StoreV2ProductItemVO;
import com.bytedance.android.ec.store.utils.playable.PlayAbleType;
import com.bytedance.android.shopping.extensions.k;
import com.bytedance.android.shopping.store.home.view.ShopNoTouchViewpager;
import com.bytedance.ies.sdk.widgets.api.WidgetService;
import com.facebook.drawee.view.SimpleDraweeView;
import com.facebook.imagepipeline.request.ImageRequest;
import com.larus.nova.R;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.TimeUnit;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.jvm.internal.Reflection;
import kotlin.ranges.RangesKt;
import kotlin.reflect.KProperty;
import kotlin.text.StringsKt;
import sm.j;

/* JADX INFO: loaded from: classes44.dex */
public final class ECProductCardMainImagePresenter extends com.bytedance.android.ec.store.product.presenter.element.mainimage.a implements ln.c {

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public ShopNoTouchViewpager f48298m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public AspectRatioFrameLayout f48299n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public SimpleDraweeView f48300o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public ln.b f48301p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public Disposable f48302q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public boolean f48303r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public int f48304s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public StoreV2ProductItemVO f48305t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public final nn.b f48306u;

    public static final class a implements Animator.AnimatorListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ ECProductCardMainImagePresenter f48307a;

        @Override // android.animation.Animator.AnimatorListener
        public final void onAnimationCancel(Animator r100) {
            Intrinsics.checkNotNullParameter(r100, GXTemplateKey.GAIAX_ANIMATION);
        }

        @Override // android.animation.Animator.AnimatorListener
        public final void onAnimationRepeat(Animator r100) {
            Intrinsics.checkNotNullParameter(r100, GXTemplateKey.GAIAX_ANIMATION);
        }

        @Override // android.animation.Animator.AnimatorListener
        public final void onAnimationStart(Animator r100) {
            Intrinsics.checkNotNullParameter(r100, GXTemplateKey.GAIAX_ANIMATION);
        }

        public a(ECProductCardMainImagePresenter r100) {
            this.f48307a = r100;
        }

        @Override // android.animation.Animator.AnimatorListener
        public final void onAnimationEnd(Animator r100) {
            Intrinsics.checkNotNullParameter(r100, GXTemplateKey.GAIAX_ANIMATION);
            ShopNoTouchViewpager r101 = this.f48307a.f48298m;
            if (r101 == null) goto L6;
            r101.setVisibility(8);
            return;
        }
    }

    @Override // com.ss.android.ugc.aweme.kiwi.presenter.QFragmentPresenter
    public final void c0() {
        this.f48304s = 0;
        Disposable r100 = this.f48302q;
        if (r100 == null) goto L5;
        r100.dispose();
    L5:
        this.f48306u.f519621a = null;
    }

    @Override // ln.c
    public final Rect r() {
        return null;
    }

    @Override // ln.c
    public final void B() {
        ShopNoTouchViewpager r100 = this.f48298m;
        if (r100 == null) goto L13;
        ObjectAnimator r101 = ObjectAnimator.ofFloat(r100, "alpha", new float[]{1.0f, 0.0f});
        r101.setDuration(100);
        r101.addListener(new a(this));
        r101.start();
        ShopNoTouchViewpager r102 = this.f48298m;
        if (r102 == null) goto L7;
        r102.setCurrentItem(0, false);
    L7:
        Disposable r103 = this.f48302q;
        if (r103 == null) goto L10;
        r103.dispose();
    L10:
        this.f48302q = null;
        return;
    L13:
        throw new NullPointerException("null cannot be cast to non-null type android.view.View");
    }

    @Override // ln.c
    public final void R() {
        StoreV2ProductItemVO r100 = this.f48305t;
        if (r100 == null) goto L28;
        List<String> r101 = r100.f48426f;
        if (r101 == null) goto L29;
        ArrayList r102 = new ArrayList();
        Iterator<T> r103 = r101.iterator();
    L9:
        if (r103.hasNext() == false) goto L11;
        String r104 = (String) r103.next();
        SimpleDraweeView r105 = new SimpleDraweeView(Y().c());
        h0.e(r105, r104, this.f542549f.j(null), null, null, 120);
        Unit r106 = Unit.INSTANCE;
        r102.add(r105);
        goto L9
    L11:
        ShopNoTouchViewpager r107 = this.f48298m;
        if (r107 == null) goto L14;
        r107.setAdapter(new AutoScrollImageAdapter(r102));
    L14:
        ShopNoTouchViewpager r108 = this.f48298m;
        if (r108 == null) goto L19;
        PagerAdapter r109 = r108.getAdapter();
        if (r109 == null) goto L19;
        r109.notifyDataSetChanged();
    L19:
        T r110 = this.f542554k;
        if (r110 == 0) goto L22;
        ScrollStatus r111 = ScrollStatus.SCROLLED;
        Intrinsics.checkNotNullParameter(r111, "<set-?>");
        r110.H = r111;
    L22:
        ShopNoTouchViewpager r112 = this.f48298m;
        if (r112 == null) goto L25;
        r112.setVisibility(0);
    L25:
        Function0<Unit> r113 = new ECProductCardMainImagePresenter$execStart$1(this);
        this.f48302q = com.bytedance.android.ec.core.rxjava.a.a(1000, 1666, TimeUnit.MILLISECONDS).subscribeOn(Schedulers.computation()).observeOn(AndroidSchedulers.mainThread()).subscribe(new b(r113), c.f48309a, d.f48310a);
        return;
    L29:
        return;
    }

    @Override // ln.c
    public final boolean isPlaying() {
        Disposable r100 = this.f48302q;
        if (r100 != null) goto L5;
        return false;
    L5:
        if (r100.isDisposed() == true) goto L9;
        return true;
    L9:
        return false;
    }

    @Override // ln.c
    public final void pausePlay() {
        v();
        M();
    }

    @Override // ln.c
    public final void startPlay() {
        R();
        x();
    }

    @Override // ln.c
    public final void stopPlay() {
        B();
        z();
    }

    @Override // ln.c
    public final void M() {
        ln.c.a.a(this);
    }

    @Override // ln.c
    public final PlayAbleType P() {
        return PlayAbleType.MAIN_IMAGE;
    }

    @Override // ln.c
    public final ln.b m() {
        return this.f48301p;
    }

    @Override // ln.c
    public final void v() {
        stopPlay();
    }

    @Override // ln.c
    public final void x() {
        ln.c.a.b(this);
    }

    @Override // ln.c
    public final void z() {
        ln.c.a.c(this);
    }

    public /* synthetic */ ECProductCardMainImagePresenter(Fragment r100) {
        this(r100, new nn.b());
    }

    @Override // ln.c
    public final List<ln.c> L(Rect r100) {
        Intrinsics.checkNotNullParameter(r100, "visibleArea");
        View r101 = a0();
        Intrinsics.checkNotNullParameter(r101, "$this$isInArea");
        Intrinsics.checkNotNullParameter(r100, "recyclerViewRectCache");
        Rect r102 = new Rect();
        r101.getGlobalVisibleRect(r102);
        boolean r103 = false;
        if ((r102.bottom - r102.top) >= r101.getHeight()) goto L6;
    L10:
        if (r103 == false) goto L12;
        StoreV2ProductItemVO r104 = this.f542554k;
        if (r104 == null) goto L23;
        if (r104.E != true) goto L23;
        if (this.f542549f.m(r104) == false) goto L23;
        return CollectionsKt.listOf(this);
    L23:
        return CollectionsKt.emptyList();
    L12:
        return CollectionsKt.emptyList();
    L6:
        if (r102.intersect(r100) == false) goto L10;
        int r105 = RangesKt.coerceAtMost(r102.bottom, r100.bottom) - RangesKt.coerceAtLeast(r102.top, r100.top);
        if (RangesKt.coerceAtMost(r101.getHeight(), r100.height()) != r105) goto L10;
        r103 = true;
        goto L10
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r6v16, types: [T, java.util.List<java.lang.String>] */
    /* JADX WARN: Type inference failed for: r8v0, types: [T, java.util.List<java.lang.String>] */
    @Override // sm.l
    public final void e0(StoreV2ProductItemVO r110) {
        StoreV2ProductItemVO r100 = this.f542554k;
        if (r100 != null) goto L5;
    L9:
        boolean r101 = false;
    L10:
        this.f48303r = r101;
        this.f48304s = 0;
        if (r110 == 0) goto L109;
        this.f542554k = r110;
        Intrinsics.checkNotNullParameter(r110, MapController.ITEM_LAYER_TAG);
        this.f48305t = r110;
        SimpleDraweeView r102 = (SimpleDraweeView) a0().findViewById(R.id.store_product_card_image);
        if (r102 == null) goto L108;
        this.f48300o = r102;
        AspectRatioFrameLayout r103 = (AspectRatioFrameLayout) a0().findViewById(R.id.store_product_card_image_wrapper);
        this.f48299n = r103;
        if (r103 == null) goto L18;
        int r104 = r103.getWidth();
    L22:
        AspectRatioFrameLayout r105 = this.f48299n;
        if (r105 == null) goto L25;
        int r106 = r105.getHeight();
    L29:
        Ref.ObjectRef r107 = new Ref.ObjectRef();
        r107.element = r110.f48426f;
        AspectRatioFrameLayout r108 = this.f48299n;
        if (r108 == null) goto L33;
        r108.setRatio(1.0f);
    L33:
        if (this.f542549f.c() != LayoutTypes.RECYCLER_VIEW_ITEM_DOUBLE) goto L46;
        List<String> r109 = r110.f48446z;
        if ((!r109.isEmpty()) == true) goto L38;
        r109 = null;
    L38:
        if (r109 == null) goto L40;
        String r111 = (String) CollectionsKt.first(r109);
    L42:
        if (k.c(r111) == false) goto L46;
        r107.element = r110.f48446z;
        r106 = (r104 / 3) * 4;
        AspectRatioFrameLayout r112 = this.f48299n;
        if (r112 == null) goto L46;
        r112.setRatio(1.3333334f);
        goto L46
    L40:
        r111 = null;
    L46:
        Pair<? extends r, ImageRequest[]> r113 = r110.f48427g;
        if (r113 == null) goto L72;
        r r114 = r113.getFirst();
        if (r114 == null) goto L56;
        r r115 = this.f542549f.j(Integer.valueOf(r110.f48442v));
        if (r115 == null) goto L54;
        String r116 = r115.f44944g;
        if (r116 == null) goto L54;
    L55:
        Intrinsics.checkNotNullParameter(r116, "<set-?>");
        r114.f44944g = r116;
    L54:
        r116 = "unknown";
    L56:
        SimpleDraweeView r117 = this.f48300o;
        if (r117 != null) goto L59;
        Intrinsics.throwUninitializedPropertyAccessException("image");
    L59:
        KProperty[] r118 = ImageExtensionsKt.f44433a;
        Intrinsics.checkNotNullParameter(r117, "$this$load");
        ImageRequest[] r119 = r113.getSecond();
        r r120 = r113.getFirst();
        Intrinsics.checkNotNullParameter(r117, "$this$load");
        if (r119 != null) goto L62;
    L68:
        boolean r121 = true;
    L69:
        if (r121 == true) goto L84;
        ImageExtensionsKt.u(r117, r119, null, r120);
    L84:
        List r122 = (List) r107.element;
        ArrayList r123 = new ArrayList();
        Iterator r124 = r122.iterator();
    L86:
        if (r124.hasNext() == false) goto L90;
        Object r125 = r124.next();
        if ((!StringsKt.isBlank((String) r125)) == false) goto L86;
        r123.add(r125);
        goto L86
    L90:
        StoreV2ProductItemVO r126 = this.f542554k;
        if (r126 != null) goto L93;
    L101:
        ShopNoTouchViewpager r127 = (ShopNoTouchViewpager) a0().findViewById(R.id.shop_product_image_viewpager);
        if (r127 == null) goto L105;
        this.f48298m = r127;
        r127.setVisibility(0);
    L105:
        j r128 = this.f542553j;
        if (r128 == null) goto L108;
        r128.b(Reflection.getOrCreateKotlinClass(sm.k.class), new e(this, r107));
        goto L108
    L93:
        if (r126.E != true) goto L101;
        if (this.f542549f.m(r126) == false) goto L101;
        if (r123.size() <= 1) goto L101;
        T r129 = this.f542554k;
        if (r129 == 0) goto L101;
        ScrollStatus r130 = ScrollStatus.CAN_BUT_NOT_SCROLL;
        Intrinsics.checkNotNullParameter(r130, "<set-?>");
        r129.H = r130;
        goto L101
    L62:
        if (r119.length != 0) goto L64;
        boolean r131 = true;
    L65:
        if (r131 == true) goto L68;
        r121 = false;
        goto L69
    L64:
        r131 = false;
        goto L65
    L72:
        List r132 = (List) r107.element;
        if ((!r132.isEmpty()) == false) goto L75;
        List r133 = r132;
    L76:
        if (r133 == null) goto L84;
        AspectRatioFrameLayout r134 = this.f48299n;
        if (r134 == null) goto L80;
        ViewGroup.LayoutParams r135 = r134.getLayoutParams();
        r135.height = r106;
        r134.setLayoutParams(r135);
    L80:
        SimpleDraweeView r136 = this.f48300o;
        if (r136 != null) goto L83;
        Intrinsics.throwUninitializedPropertyAccessException("image");
    L83:
        Integer r137 = Integer.valueOf(r104);
        Integer r138 = Integer.valueOf(r106);
        Integer r139 = Integer.valueOf(r110.f48442v);
        Intrinsics.checkNotNullParameter(r136, "draweeView");
        h0.f(r136, r133, this.f542549f.j(r139), r137, r138, 96);
        goto L84
    L75:
        r133 = null;
        goto L76
    L25:
        SimpleDraweeView r140 = this.f48300o;
        if (r140 != null) goto L28;
        Intrinsics.throwUninitializedPropertyAccessException("image");
    L28:
        r106 = r140.getHeight();
        goto L29
    L18:
        SimpleDraweeView r141 = this.f48300o;
        if (r141 != null) goto L21;
        Intrinsics.throwUninitializedPropertyAccessException("image");
    L21:
        r104 = r141.getWidth();
    L108:
        this.f542550g.e(r110);
    L109:
        this.f48306u.f519621a = this;
        return;
    L5:
        if (r100.E != true) goto L9;
        if (this.f542549f.m(r100) != true) goto L9;
        r101 = true;
        goto L10
    }

    @Override // ln.c
    public final void k1(nn.e.a r100) {
        this.f48301p = r100;
    }

    public ECProductCardMainImagePresenter(Fragment r100, nn.b r101) {
        Intrinsics.checkNotNullParameter(r100, WidgetService.PARAM_FRAGMENT);
        Intrinsics.checkNotNullParameter(r101, "playableProxy");
        super(r100);
        this.f48306u = r101;
    }
}
