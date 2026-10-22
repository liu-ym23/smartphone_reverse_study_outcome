package com.bytedance.android.window.shop.home.presenter;

import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.core.graphics.ColorUtils;
import com.bytedance.android.ec.model.ECUrlModel;
import com.bytedance.mt.protector.impl.UriProtector;
import com.facebook.common.references.CloseableReference;
import com.facebook.drawee.generic.GenericDraweeHierarchy;
import com.facebook.drawee.generic.RoundingParams;
import com.facebook.drawee.view.SimpleDraweeView;
import com.facebook.imagepipeline.bitmaps.PlatformBitmapFactory;
import com.facebook.imagepipeline.request.BasePostprocessor;
import com.facebook.imagepipeline.request.ImageRequestBuilder;
import com.larus.nova.R;
import com.ss.android.ugc.aweme.compat.nullable.Observer;
import com.ss.android.ugc.aweme.kiwi.model.QModel;
import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.IntRange;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes14.dex */
public final class ECWindowDialogStyledBackgroundPresenter extends AbsECWindowPresenter {
    public static final Pair<Integer, Integer> A = null;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public static final Pair<IntRange, Pair<Integer, Integer>>[] f188329z = null;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final Lazy f188330m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final Lazy f188331n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public final Lazy f188332o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public final Lazy f188333p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public final Lazy f188334q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public final Lazy f188335r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public final Lazy f188336s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public final Lazy f188337t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public final Lazy f188338u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public final Lazy f188339v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public final float[][] f188340w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public final float f188341x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public final CompositeDisposable f188342y;

    public static final class a {
    }

    public static final class b extends BasePostprocessor {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final float f188343a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final float f188344b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final Function1<int[], Unit> f188345c;

        @Override // com.facebook.imagepipeline.request.BasePostprocessor, com.facebook.imagepipeline.request.Postprocessor
        public final CloseableReference<Bitmap> process(Bitmap r110, PlatformBitmapFactory r111) {
            if (r110 == null) goto L4;
            if (r111 == null) goto L7;
            int r100 = (int) (this.f188343a * r110.getHeight());
            CloseableReference<Bitmap> r101 = r111.createBitmap(r110, 0, r100, r110.getWidth(), ((int) (this.f188344b * r110.getHeight())) - r100);
            Function1<int[], Unit> r102 = this.f188345c;
            if (r102 == null) goto L11;
            Bitmap r103 = r101.get();
            int[] r104 = new int[r103.getWidth()];
            r103.getPixels(r104, 0, r103.getWidth(), 0, r103.getHeight() - 1, r103.getWidth(), 1);
            r102.invoke(r104);
        L11:
            CloseableReference<Bitmap> r105 = CloseableReference.cloneOrNull(r101);
            if (r105 == null) goto L14;
            return r105;
        L14:
            return super.process(r110, r111);
        L7:
            return super.process(r110, null);
        L4:
            return super.process(r110, r111);
        }

        public b(float r100, float r101, Function1 r102) {
            this.f188343a = r100;
            this.f188344b = r101;
            this.f188345c = r102;
        }
    }

    public static final class c<T> implements Observer {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ ECWindowDialogStyledBackgroundPresenter f188346a;

        public c(ECWindowDialogStyledBackgroundPresenter r100) {
            this.f188346a = r100;
        }

        @Override // androidx.lifecycle.Observer
        public final void onChanged(Object r110) {
            uq3.a r111 = (uq3.a) r110;
            ECWindowDialogStyledBackgroundPresenter r100 = this.f188346a;
            uq3.o r101 = r111.f551204c;
            ECUrlModel r102 = null;
            if (r101 == null) goto L5;
            String r103 = r101.f551258i;
        L6:
            r100.getClass();
            ECWindowDialogStyledBackgroundPresenter.a0(r100, ECWindowDialogStyledBackgroundPresenter.b0(r103), null);
            uq3.o r104 = r111.f551204c;
            if (r104 == null) goto L9;
            ECUrlModel r105 = r104.f551256g;
        L10:
            boolean r106 = false;
            if (r105 == null) goto L38;
            ECWindowDialogStyledBackgroundPresenter r107 = this.f188346a;
            r107.getClass();
            int r108 = (int) (com.bytedance.android.ec.window.base.utils.c.f49722a * 0.5612789f);
            if ((r108 - r107.i0().getHeight()) <= 0) goto L15;
            int r109 = r108 - r107.i0().getHeight();
        L16:
            wg.a.d(r107.c0(), r109);
            ((View) r107.f188336s.getValue()).setVisibility(0);
            ((View) r107.f188337t.getValue()).setVisibility(0);
            r107.h0().setVisibility(0);
            ECWindowDialogStyledBackgroundPresenter r112 = this.f188346a;
            uq3.o r113 = r111.f551204c;
            r112.getClass();
            if (r113 == null) goto L19;
            ECUrlModel r114 = r113.f551256g;
        L20:
            if (r114 == null) goto L24;
            Integer r115 = r113.f551257h;
            if (r115 == null) goto L24;
            int r116 = r115.intValue();
            View r117 = r112.w().b(R.id.ec_shop_background_second_dialog).f();
            r117.setBackgroundColor(r116);
            r117.setVisibility(0);
        L24:
            ECWindowDialogStyledBackgroundPresenter r118 = this.f188346a;
            uq3.o r119 = r111.f551204c;
            if (r119 == null) goto L27;
            Integer r120 = r119.f551257h;
        L28:
            r118.getClass();
            if (r120 == null) goto L31;
            r120.intValue();
            ((View) r118.f188336s.getValue()).setBackgroundDrawable(new GradientDrawable(GradientDrawable.Orientation.TOP_BOTTOM, new int[]{Color.argb(138, Color.red(r120.intValue()), Color.green(r120.intValue()), Color.blue(r120.intValue())), r120.intValue()}));
            ((View) r118.f188337t.getValue()).setBackgroundColor(r120.intValue());
        L31:
            ECWindowDialogStyledBackgroundPresenter r121 = this.f188346a;
            uq3.o r122 = r111.f551204c;
            if (r122 == null) goto L34;
            Integer r123 = r122.f551257h;
        L35:
            r121.getClass();
            if (r123 == null) goto L38;
            r123.intValue();
            r121.h0().setBackgroundDrawable(new GradientDrawable(GradientDrawable.Orientation.TOP_BOTTOM, new int[]{Color.argb(71, Color.red(r123.intValue()), Color.green(r123.intValue()), Color.blue(r123.intValue())), Color.argb(138, Color.red(r123.intValue()), Color.green(r123.intValue()), Color.blue(r123.intValue()))}));
            goto L38
        L34:
            r123 = null;
            goto L35
        L27:
            r120 = null;
            goto L28
        L19:
            r114 = null;
            goto L20
        L15:
            r109 = 0;
        L38:
            ECWindowDialogStyledBackgroundPresenter r124 = this.f188346a;
            uq3.o r125 = r111.f551204c;
            if (r125 == null) goto L41;
            r102 = r125.f551256g;
        L41:
            if (r102 == null) goto L43;
            r106 = true;
        L43:
            r124.O().getTopBarHeight().a(r124.U(), new o0(r124, r106), true);
            return;
        L9:
            r105 = null;
            goto L10
        L5:
            r103 = null;
            goto L6
        }
    }

    public static final class d<T> implements Observer {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ ECWindowDialogStyledBackgroundPresenter f188347a;

        public d(ECWindowDialogStyledBackgroundPresenter r100) {
            this.f188347a = r100;
        }

        @Override // androidx.lifecycle.Observer
        public final void onChanged(Object r100) {
            Float r101 = (Float) r100;
            this.f188347a.f0().setTranslationY((-this.f188347a.d0().getHeight()) * r101.floatValue());
            this.f188347a.h0().setTranslationY((-this.f188347a.d0().getHeight()) * r101.floatValue());
        }
    }

    public static final class e<T> implements Observer {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ ECWindowDialogStyledBackgroundPresenter f188348a;

        public e(ECWindowDialogStyledBackgroundPresenter r100) {
            this.f188348a = r100;
        }

        @Override // androidx.lifecycle.Observer
        public final void onChanged(Object r100) {
            Float r101 = (Float) r100;
            ECWindowDialogStyledBackgroundPresenter r102 = this.f188348a;
            float[] r103 = r102.e0(r101.floatValue());
            Drawable r104 = ((View) r102.f188335r.getValue()).getBackground();
            Drawable r105 = null;
            if ((r104 instanceof GradientDrawable) == true) goto L5;
            r104 = null;
        L5:
            GradientDrawable r106 = (GradientDrawable) r104;
            if (r106 == null) goto L8;
            r106.setCornerRadii(r103);
            r106.invalidateSelf();
        L8:
            RoundingParams r107 = r102.c0().getHierarchy().getRoundingParams();
            if (r107 != null) goto L11;
            r107 = new RoundingParams();
        L11:
            r107.setCornersRadii(r103);
            r102.c0().getHierarchy().setRoundingParams(r107);
            Drawable r108 = ((View) r102.f188336s.getValue()).getBackground();
            if ((r108 instanceof GradientDrawable) == false) goto L15;
            r105 = r108;
        L15:
            GradientDrawable r109 = (GradientDrawable) r105;
            if (r109 == null) goto L18;
            r109.setCornerRadii(r103);
        L18:
            this.f188348a.f0().setAlpha(r101.floatValue());
            this.f188348a.h0().setAlpha(r101.floatValue());
            this.f188348a.i0().setAlpha(r101.floatValue());
            ((View) this.f188348a.f188339v.getValue()).setAlpha(1 - r101.floatValue());
        }
    }

    public static final class f<T> implements Observer {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ SimpleDraweeView f188349a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ float f188350b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ float f188351c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final /* synthetic */ Function1 f188352d;

        public f(ECWindowDialogStyledBackgroundPresenter r100, SimpleDraweeView r101, float r102, float r103, Function1 r104) {
            this.f188349a = r101;
            this.f188350b = r102;
            this.f188351c = r103;
            this.f188352d = r104;
        }

        @Override // androidx.lifecycle.Observer
        public final void onChanged(Object r100) {
            uq3.o r101 = ((uq3.a) r100).f551204c;
            if (r101 == null) goto L9;
            ECUrlModel r102 = r101.f551256g;
            if (r102 == null) goto L9;
            String r103 = r102.getFirstUrl();
            if (r103 == null) goto L9;
            this.f188349a.setImageRequest(ImageRequestBuilder.newBuilderWithSource(UriProtector.parse(r103)).setPostprocessor(new b(this.f188350b, this.f188351c, this.f188352d)).build());
            return;
        L9:
            SimpleDraweeView r104 = this.f188349a;
            ImageRequestBuilder r105 = ImageRequestBuilder.newBuilderWithResourceId(R.drawable.ec_window_header_default_shader);
            float r106 = this.f188350b;
            float r107 = this.f188351c;
            Function1 r108 = this.f188352d;
            com.bytedance.android.ec.core.utils.q.a(475);
            int r109 = com.bytedance.android.ec.window.base.utils.c.f49722a;
            r104.setImageRequest(r105.setPostprocessor(new b(r106, r107, r108)).build());
        }
    }

    public final SimpleDraweeView c0() {
        return (SimpleDraweeView) this.f188338u.getValue();
    }

    public final FrameLayout d0() {
        return (FrameLayout) this.f188333p.getValue();
    }

    public final SimpleDraweeView f0() {
        return (SimpleDraweeView) this.f188331n.getValue();
    }

    public final View h0() {
        return (View) this.f188332o.getValue();
    }

    public final View i0() {
        return (View) this.f188330m.getValue();
    }

    static {
        f188329z = new Pair[]{new Pair(new IntRange(0, 60), new Pair(Integer.valueOf((int) 4284500019L), Integer.valueOf((int) 4283905836L))), new Pair(new IntRange(61, 180), new Pair(Integer.valueOf((int) 4282206261L), Integer.valueOf((int) 4281220147L))), new Pair(new IntRange(181, 240), new Pair(Integer.valueOf((int) 4280828262L), Integer.valueOf((int) 4280627288L))), new Pair(new IntRange(241, 300), new Pair(Integer.valueOf((int) 4280952390L), Integer.valueOf((int) 4281873241L))), new Pair(new IntRange(301, 360), new Pair(Integer.valueOf((int) 4284427067L), Integer.valueOf((int) 4282851108L)))};
        int r100 = (int) 4284374622L;
        A = new Pair(Integer.valueOf(r100), Integer.valueOf(r100));
    }

    @Override // com.ss.android.ugc.aweme.kiwi.presenter.QPresenter
    public final void C() {
        this.f188342y.clear();
    }

    public ECWindowDialogStyledBackgroundPresenter() {
        this.f188330m = LazyKt.lazy(new ECWindowDialogStyledBackgroundPresenter$topBarView$2(this));
        this.f188331n = LazyKt.lazy(new ECWindowDialogStyledBackgroundPresenter$topBarBackgroundImageView$2(this));
        this.f188332o = LazyKt.lazy(new ECWindowDialogStyledBackgroundPresenter$topBarBackgroundMask$2(this));
        this.f188333p = LazyKt.lazy(new ECWindowDialogStyledBackgroundPresenter$infoAreaView$2(this));
        this.f188334q = LazyKt.lazy(new ECWindowDialogStyledBackgroundPresenter$infoAreaBgView$2(this));
        this.f188335r = LazyKt.lazy(new ECWindowDialogStyledBackgroundPresenter$infoAreaBackgroundImageView$2(this));
        this.f188336s = LazyKt.lazy(new ECWindowDialogStyledBackgroundPresenter$infoAreaBackgroundImageViewMask$2(this));
        this.f188337t = LazyKt.lazy(new ECWindowDialogStyledBackgroundPresenter$infoAreaBackgroundSecondPart$2(this));
        this.f188338u = LazyKt.lazy(new ECWindowDialogStyledBackgroundPresenter$infoAreaBackgroundShaderImageView$2(this));
        this.f188339v = LazyKt.lazy(new ECWindowDialogStyledBackgroundPresenter$dragIndicatorView$2(this));
        this.f188340w = new float[101][];
        this.f188341x = com.bytedance.android.ec.core.utils.q.a(12);
        this.f188342y = new CompositeDisposable();
    }

    public static Pair b0(String r100) {
        int r101 = 0;
        if (r100 != null) goto L5;
    L8:
        boolean r102 = true;
    L9:
        if (r102 == true) goto L11;
        float[] r103 = new float[3];
        Integer r104 = com.bytedance.android.ec.core.utils.s.b(r100);
        if (r104 == null) goto L33;
        Color.colorToHSV(r104.intValue(), r103);
        int r105 = (int) r103[0];
        float r106 = r103[1];
        float r107 = r103[2];
        float r108 = 100;
        float r109 = 10;
        if ((r106 * r108) <= r109) goto L31;
        if ((r107 * r108) <= r109) goto L31;
        Pair<IntRange, Pair<Integer, Integer>>[] r110 = f188329z;
        int r111 = r110.length;
    L20:
        if (r101 >= r111) goto L25;
        Pair<IntRange, Pair<Integer, Integer>> r112 = r110[r101];
        if (r112.component1().contains(r105) == true) goto L26;
        r101 = r101 + 1;
    L26:
        if (r112 == null) goto L37;
        Pair<Integer, Integer> r113 = r112.getSecond();
        if (r113 == null) goto L37;
        return r113;
    L37:
        return A;
    L25:
        r112 = null;
    L31:
        return A;
    L33:
        return A;
    L11:
        return A;
    L5:
        if (StringsKt.isBlank(r100) == true) goto L8;
        r102 = false;
        goto L9
    }

    @Override // com.ss.android.ugc.aweme.kiwi.presenter.QPresenter
    public final void A(QModel r100) {
        if (com.bytedance.android.ec.window.base.utils.c.a(d0(), new ECWindowDialogStyledBackgroundPresenter$attachIndicatorView$1(this)) != null) goto L6;
        FrameLayout r101 = d0();
        View r102 = (View) this.f188339v.getValue();
        FrameLayout.LayoutParams r103 = new FrameLayout.LayoutParams(com.bytedance.android.shopping.extensions.b.b(32), com.bytedance.android.shopping.extensions.b.b(4));
        r103.gravity = 1;
        r103.setMargins(0, com.bytedance.android.shopping.extensions.b.b(6), 0, 0);
        Unit r104 = Unit.INSTANCE;
        r101.addView(r102, r103);
    L6:
        FrameLayout r105 = (FrameLayout) w().b(R.id.ec_shop_background_container_dialog).f();
        if (com.bytedance.android.ec.window.base.utils.c.a(r105, new ECWindowDialogStyledBackgroundPresenter$attachTopBarBackgroundView$1(this)) != null) goto L11;
        r105.addView(f0());
        View r106 = h0();
        FrameLayout.LayoutParams r107 = new FrameLayout.LayoutParams(-1, -1);
        r107.gravity = 80;
        Unit r108 = Unit.INSTANCE;
        r105.addView(r106, -1, r107);
    L11:
        if (com.bytedance.android.ec.window.base.utils.c.a((FrameLayout) this.f188334q.getValue(), new ECWindowDialogStyledBackgroundPresenter$attachInfoAreaBackgroundView$1(this)) != null) goto L14;
        ((FrameLayout) this.f188334q.getValue()).addView((View) this.f188336s.getValue(), 0, new ViewGroup.LayoutParams(-1, com.bytedance.android.shopping.extensions.b.b(130)));
        FrameLayout r109 = (FrameLayout) this.f188334q.getValue();
        View r110 = (View) this.f188337t.getValue();
        FrameLayout.LayoutParams r111 = new FrameLayout.LayoutParams(-1, -1);
        r111.setMargins(0, com.bytedance.android.shopping.extensions.b.b(130), 0, 0);
        Unit r112 = Unit.INSTANCE;
        r109.addView(r110, 0, r111);
        ((FrameLayout) this.f188334q.getValue()).addView(c0(), 0, new ViewGroup.LayoutParams(-1, -1));
        ((FrameLayout) this.f188334q.getValue()).addView((View) this.f188335r.getValue(), 0, new ViewGroup.LayoutParams(-1, -1));
    L14:
        O().getHeaderResponse().a(U(), new c(this), true);
        O().getSubCollapseProgress().observe(U(), new d(this));
        O().getCollapseProgress().observe(U(), new e(this));
        zn.b<uq3.a> r113 = O().getHeaderResponse();
        Intrinsics.checkNotNullParameter(r113, "source");
        Disposable r114 = Observable.zip(new AbsECWindowPresenter$observableSourceFromLiveData$1(this, r113), new k0(this), new l0(this)).subscribeOn(AndroidSchedulers.mainThread()).observeOn(AndroidSchedulers.mainThread()).subscribe(new m0(this), n0.f188575a);
        this.f188342y.add(r114);
    }

    public final synchronized float[] e0(float r100) {
        monitor-enter(this);
        int r101 = 0;
        if (r100 > 0) goto L7;
    L20:
        float[] r102 = this.f188340w[r101];     // Catch: Throwable -> L17
        if (r102 == null) goto L14;
        monitor-exit(this);
        return r102;
    L14:
        float r103 = this.f188341x * (1 - r100);     // Catch: Throwable -> L17
        float[] r104 = com.bytedance.android.ec.window.base.utils.c.b(r103, r103, 0.0f, 0.0f);     // Catch: Throwable -> L17
        this.f188340w[r101] = r104;     // Catch: Throwable -> L17
        monitor-exit(this);
        return r104;
    L17:
        th = move-exception;
        throw th;
    L7:
        if (r100 < 1) goto L9;
        r101 = 100;
        goto L20
    L9:
        r101 = (int) (100 * r100);
        goto L20
    }

    public static final void Z(ECWindowDialogStyledBackgroundPresenter r100, final io.reactivex.Observer r101) {
        View r102 = r100.i0();
        Integer r103 = Integer.valueOf(com.bytedance.android.shopping.extensions.b.b(88));
        int r104 = r102.getHeight();
        if (r104 > 0) goto L8;
        if (r103 != null) goto L7;
        r104 = 0;
        goto L8
    L7:
        r104 = r103.intValue();
    L8:
        float r105 = r104 / (com.bytedance.android.shopping.extensions.b.b(145) + r104);
        r100.j0(r100.f0(), 0.0f, r105, null);
        r100.j0(r100.c0(), r105, 1.0f, new ECWindowDialogStyledBackgroundPresenter$executeRenderCutBackground$1(r101));
    }

    public static final void a0(ECWindowDialogStyledBackgroundPresenter r100, Pair r101, Bitmap r102) {
        float r103 = r100.i0().getHeight() / (r100.i0().getHeight() + r100.d0().getHeight());
        int r104 = ((Number) r101.getFirst()).intValue();
        int r105 = ((Number) r101.getSecond()).intValue();
        int r106 = ColorUtils.blendARGB(r104, r105, r103);
        int[][] r107 = {new int[]{r104, r106}, new int[]{r106, r105}};
        GenericDraweeHierarchy r108 = r100.f0().getHierarchy();
        GradientDrawable r109 = new GradientDrawable();
        com.bytedance.android.ec.window.base.utils.c.e(r109, (int[]) r107[0].clone());
        Unit r110 = Unit.INSTANCE;
        r108.setBackgroundImage(r109);
        View r111 = (View) r100.f188335r.getValue();
        GradientDrawable r112 = new GradientDrawable();
        com.bytedance.android.ec.window.base.utils.c.e(r112, (int[]) r107[1].clone());
        r112.setCornerRadii(r100.e0(0.0f));
        com.bytedance.android.ec.window.base.utils.c.d(r111, r112);
        if (r102 == null) goto L5;
        r100.O().getHeaderResponse().a(r100.U(), new p0(r100, r102), true);
        return;
    L5:
        r100.O().getHeaderResponse().a(r100.U(), new q0(r100, r107), true);
    }

    public final void j0(SimpleDraweeView r110, float r111, float r112, Function1<? super int[], Unit> r113) {
        O().getHeaderResponse().a(U(), new f(this, r110, r111, r112, r113), false);
    }
}
