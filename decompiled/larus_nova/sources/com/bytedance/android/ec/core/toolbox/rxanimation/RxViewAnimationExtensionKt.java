package com.bytedance.android.ec.core.toolbox.rxanimation;

import android.animation.TimeInterpolator;
import android.animation.ValueAnimator;
import android.content.res.Resources;
import android.view.View;
import android.view.animation.Interpolator;
import com.obric.assistant.interaction.impl.window.WindowDisplayMetricsOverride;
import com.ss.ttvideoengine.DataLoaderHelper;
import io.reactivex.Completable;
import io.reactivex.Observable;
import io.reactivex.functions.Function;
import kotlin.Pair;
import kotlin.Triple;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes43.dex */
public final class RxViewAnimationExtensionKt {

    public static final class a<T, R> implements Function {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ View f45341a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ float f45342b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ Long f45343c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final /* synthetic */ TimeInterpolator f45344d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final /* synthetic */ Long f45345e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public final /* synthetic */ boolean f45346f;

        public a(View r100, float r101, Long r102, TimeInterpolator r103, Long r104, boolean r105) {
            this.f45341a = r100;
            this.f45342b = r101;
            this.f45343c = r102;
            this.f45344d = r103;
            this.f45345e = r104;
            this.f45346f = r105;
        }

        @Override // io.reactivex.functions.Function
        public final Object apply(Object r210) {
            final Float r100 = (Float) r210;
            Intrinsics.checkNotNullParameter(r100, "defaultAlpha");
            return RxViewAnimationExtensionKt.h(RxViewAnimationExtensionKt.e(this.f45341a, Float.valueOf(this.f45342b), null, null, null, null, null, null, null, null, null, null, this.f45343c, this.f45344d, this.f45345e, 2046), this.f45346f, new RxViewAnimationExtensionKt$alpha$1$1(this, r100));
        }
    }

    public static final class b<T, R> implements Function {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ View f45362a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ float f45363b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ Long f45364c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final /* synthetic */ TimeInterpolator f45365d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final /* synthetic */ Long f45366e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public final /* synthetic */ boolean f45367f;

        public b(View r100, float r101, Long r102, TimeInterpolator r103, Long r104, boolean r105) {
            this.f45362a = r100;
            this.f45363b = r101;
            this.f45364c = r102;
            this.f45365d = r103;
            this.f45366e = r104;
            this.f45367f = r105;
        }

        @Override // io.reactivex.functions.Function
        public final Object apply(Object r210) {
            final Float r100 = (Float) r210;
            Intrinsics.checkNotNullParameter(r100, "defaultRotation");
            return RxViewAnimationExtensionKt.h(RxViewAnimationExtensionKt.e(this.f45362a, null, null, null, null, null, Float.valueOf(this.f45363b), null, null, null, null, null, this.f45364c, this.f45365d, this.f45366e, 2015), this.f45367f, new RxViewAnimationExtensionKt$rotation$1$1(this, r100));
        }
    }

    public static final class c<T, R> implements Function {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ View f45373a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ float f45374b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ Long f45375c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final /* synthetic */ TimeInterpolator f45376d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final /* synthetic */ Long f45377e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public final /* synthetic */ boolean f45378f;

        public c(View r100, float r101, Long r102, TimeInterpolator r103, Long r104, boolean r105) {
            this.f45373a = r100;
            this.f45374b = r101;
            this.f45375c = r102;
            this.f45376d = r103;
            this.f45377e = r104;
            this.f45378f = r105;
        }

        @Override // io.reactivex.functions.Function
        public final Object apply(Object r210) {
            final Float r100 = (Float) r210;
            Intrinsics.checkNotNullParameter(r100, "defaultRotationX");
            return RxViewAnimationExtensionKt.h(RxViewAnimationExtensionKt.e(this.f45373a, null, null, null, null, null, null, Float.valueOf(this.f45374b), null, null, null, null, this.f45375c, this.f45376d, this.f45377e, 1983), this.f45378f, new RxViewAnimationExtensionKt$rotationX$1$1(this, r100));
        }
    }

    public static final class d<T, R> implements Function {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ View f45379a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ float f45380b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ Long f45381c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final /* synthetic */ TimeInterpolator f45382d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final /* synthetic */ Long f45383e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public final /* synthetic */ boolean f45384f;

        public d(View r100, float r101, Long r102, TimeInterpolator r103, Long r104, boolean r105) {
            this.f45379a = r100;
            this.f45380b = r101;
            this.f45381c = r102;
            this.f45382d = r103;
            this.f45383e = r104;
            this.f45384f = r105;
        }

        @Override // io.reactivex.functions.Function
        public final Object apply(Object r210) {
            final Float r100 = (Float) r210;
            Intrinsics.checkNotNullParameter(r100, "defaultRotationY");
            return RxViewAnimationExtensionKt.h(RxViewAnimationExtensionKt.e(this.f45379a, null, null, null, null, null, null, null, Float.valueOf(this.f45380b), null, null, null, this.f45381c, this.f45382d, this.f45383e, 1919), this.f45384f, new RxViewAnimationExtensionKt$rotationY$1$1(this, r100));
        }
    }

    public static final class e<T, R> implements Function {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ View f45385a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ float f45386b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ Long f45387c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final /* synthetic */ TimeInterpolator f45388d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final /* synthetic */ Long f45389e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public final /* synthetic */ boolean f45390f;

        public e(View r100, float r101, Long r102, TimeInterpolator r103, Long r104, boolean r105) {
            this.f45385a = r100;
            this.f45386b = r101;
            this.f45387c = r102;
            this.f45388d = r103;
            this.f45389e = r104;
            this.f45390f = r105;
        }

        @Override // io.reactivex.functions.Function
        public final Object apply(Object r210) {
            Pair r100 = (Pair) r210;
            Intrinsics.checkNotNullParameter(r100, "<name for destructuring parameter 0>");
            final float r101 = ((Number) r100.component1()).floatValue();
            final float r102 = ((Number) r100.component2()).floatValue();
            return RxViewAnimationExtensionKt.h(RxViewAnimationExtensionKt.e(this.f45385a, null, null, null, Float.valueOf(this.f45386b), Float.valueOf(this.f45386b), null, null, null, null, null, null, this.f45387c, this.f45388d, this.f45389e, DataLoaderHelper.DATALOADER_KEY_INT_OPTIMIZE_RANGE), this.f45390f, new RxViewAnimationExtensionKt$scale$1$1(this, r101, r102));
        }
    }

    public static final class f<T, R> implements Function {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ View f45391a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ float f45392b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ Long f45393c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final /* synthetic */ TimeInterpolator f45394d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final /* synthetic */ Long f45395e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public final /* synthetic */ boolean f45396f;

        public f(View r100, float r101, Long r102, TimeInterpolator r103, Long r104, boolean r105) {
            this.f45391a = r100;
            this.f45392b = r101;
            this.f45393c = r102;
            this.f45394d = r103;
            this.f45395e = r104;
            this.f45396f = r105;
        }

        @Override // io.reactivex.functions.Function
        public final Object apply(Object r210) {
            final Float r100 = (Float) r210;
            Intrinsics.checkNotNullParameter(r100, "defaultScaleX");
            return RxViewAnimationExtensionKt.h(RxViewAnimationExtensionKt.e(this.f45391a, null, null, null, Float.valueOf(this.f45392b), null, null, null, null, null, null, null, this.f45393c, this.f45394d, this.f45395e, 2039), this.f45396f, new RxViewAnimationExtensionKt$scaleX$1$1(this, r100));
        }
    }

    public static final class g<T, R> implements Function {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ View f45397a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ float f45398b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ Long f45399c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final /* synthetic */ TimeInterpolator f45400d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final /* synthetic */ Long f45401e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public final /* synthetic */ boolean f45402f;

        public g(View r100, float r101, Long r102, TimeInterpolator r103, Long r104, boolean r105) {
            this.f45397a = r100;
            this.f45398b = r101;
            this.f45399c = r102;
            this.f45400d = r103;
            this.f45401e = r104;
            this.f45402f = r105;
        }

        @Override // io.reactivex.functions.Function
        public final Object apply(Object r210) {
            final Float r100 = (Float) r210;
            Intrinsics.checkNotNullParameter(r100, "defaultScaleY");
            return RxViewAnimationExtensionKt.h(RxViewAnimationExtensionKt.e(this.f45397a, null, null, null, null, Float.valueOf(this.f45398b), null, null, null, null, null, null, this.f45399c, this.f45400d, this.f45401e, 2031), this.f45402f, new RxViewAnimationExtensionKt$scaleY$1$1(this, r100));
        }
    }

    public static final class h<T, R> implements Function {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ View f45403a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ float f45404b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ float f45405c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final /* synthetic */ Long f45406d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final /* synthetic */ TimeInterpolator f45407e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public final /* synthetic */ Long f45408f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public final /* synthetic */ boolean f45409g;

        public h(View r100, float r101, float r102, Long r103, TimeInterpolator r104, Long r105, boolean r106) {
            this.f45403a = r100;
            this.f45404b = r101;
            this.f45405c = r102;
            this.f45406d = r103;
            this.f45407e = r104;
            this.f45408f = r105;
            this.f45409g = r106;
        }

        @Override // io.reactivex.functions.Function
        public final Object apply(Object r210) {
            Pair r100 = (Pair) r210;
            Intrinsics.checkNotNullParameter(r100, "<name for destructuring parameter 0>");
            final float r101 = ((Number) r100.component1()).floatValue();
            final float r102 = ((Number) r100.component2()).floatValue();
            return RxViewAnimationExtensionKt.h(RxViewAnimationExtensionKt.e(this.f45403a, null, Float.valueOf(this.f45404b), Float.valueOf(this.f45405c), null, null, null, null, null, null, null, null, this.f45406d, this.f45407e, this.f45408f, 2041), this.f45409g, new RxViewAnimationExtensionKt$translation$1$1(this, r101, r102));
        }
    }

    public static final class i<T, R> implements Function {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ View f45414a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ float f45415b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ Long f45416c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final /* synthetic */ TimeInterpolator f45417d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final /* synthetic */ Long f45418e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public final /* synthetic */ boolean f45419f;

        public i(View r100, float r101, Long r102, TimeInterpolator r103, Long r104, boolean r105) {
            this.f45414a = r100;
            this.f45415b = r101;
            this.f45416c = r102;
            this.f45417d = r103;
            this.f45418e = r104;
            this.f45419f = r105;
        }

        @Override // io.reactivex.functions.Function
        public final Object apply(Object r210) {
            final Float r100 = (Float) r210;
            Intrinsics.checkNotNullParameter(r100, "defaultTranslationX");
            return RxViewAnimationExtensionKt.h(RxViewAnimationExtensionKt.e(this.f45414a, null, Float.valueOf(this.f45415b), null, null, null, null, null, null, null, null, null, this.f45416c, this.f45417d, this.f45418e, 2045), this.f45419f, new RxViewAnimationExtensionKt$translationX$1$1(this, r100));
        }
    }

    public static final class j<T, R> implements Function {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ View f45420a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ float f45421b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ Long f45422c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final /* synthetic */ TimeInterpolator f45423d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final /* synthetic */ Long f45424e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public final /* synthetic */ boolean f45425f;

        public j(View r100, float r101, Long r102, TimeInterpolator r103, Long r104, boolean r105) {
            this.f45420a = r100;
            this.f45421b = r101;
            this.f45422c = r102;
            this.f45423d = r103;
            this.f45424e = r104;
            this.f45425f = r105;
        }

        @Override // io.reactivex.functions.Function
        public final Object apply(Object r210) {
            final Float r100 = (Float) r210;
            Intrinsics.checkNotNullParameter(r100, "defaultTranslationY");
            return RxViewAnimationExtensionKt.h(RxViewAnimationExtensionKt.e(this.f45420a, null, null, Float.valueOf(this.f45421b), null, null, null, null, null, null, null, null, this.f45422c, this.f45423d, this.f45424e, 2043), this.f45425f, new RxViewAnimationExtensionKt$translationY$1$1(this, r100));
        }
    }

    public static final class k<T, R> implements Function {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ View f45426a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ float f45427b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ Long f45428c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final /* synthetic */ TimeInterpolator f45429d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final /* synthetic */ Long f45430e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public final /* synthetic */ boolean f45431f;

        public k(View r100, float r101, Long r102, TimeInterpolator r103, Long r104, boolean r105) {
            this.f45426a = r100;
            this.f45427b = r101;
            this.f45428c = r102;
            this.f45429d = r103;
            this.f45430e = r104;
            this.f45431f = r105;
        }

        @Override // io.reactivex.functions.Function
        public final Object apply(Object r210) {
            final Float r100 = (Float) r210;
            Intrinsics.checkNotNullParameter(r100, "defaultX");
            return RxViewAnimationExtensionKt.h(RxViewAnimationExtensionKt.e(this.f45426a, null, null, null, null, null, null, null, null, Float.valueOf(this.f45427b), null, null, this.f45428c, this.f45429d, this.f45430e, 1791), this.f45431f, new RxViewAnimationExtensionKt$x$1$1(this, r100));
        }
    }

    public static final class l<T, R> implements Function {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ View f45432a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ Float f45433b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ Float f45434c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final /* synthetic */ Float f45435d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final /* synthetic */ Long f45436e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public final /* synthetic */ TimeInterpolator f45437f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public final /* synthetic */ Long f45438g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public final /* synthetic */ boolean f45439h;

        public l(View r100, Float r101, Float r102, Float r103, Long r104, TimeInterpolator r105, Long r106, boolean r107) {
            this.f45432a = r100;
            this.f45433b = r101;
            this.f45434c = r102;
            this.f45435d = r103;
            this.f45436e = r104;
            this.f45437f = r105;
            this.f45438g = r106;
            this.f45439h = r107;
        }

        @Override // io.reactivex.functions.Function
        public final Object apply(Object r210) {
            Triple r100 = (Triple) r210;
            Intrinsics.checkNotNullParameter(r100, "<name for destructuring parameter 0>");
            final float r101 = ((Number) r100.component1()).floatValue();
            final float r102 = ((Number) r100.component2()).floatValue();
            final float r103 = ((Number) r100.component3()).floatValue();
            return RxViewAnimationExtensionKt.h(RxViewAnimationExtensionKt.e(this.f45432a, null, null, null, null, null, null, null, null, this.f45433b, this.f45434c, this.f45435d, this.f45436e, this.f45437f, this.f45438g, 255), this.f45439h, new RxViewAnimationExtensionKt$xyz$1$1(this, r101, r102, r103));
        }
    }

    public static final class m<T, R> implements Function {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ View f45440a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ float f45441b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ Long f45442c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final /* synthetic */ TimeInterpolator f45443d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final /* synthetic */ Long f45444e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public final /* synthetic */ boolean f45445f;

        public m(View r100, float r101, Long r102, TimeInterpolator r103, Long r104, boolean r105) {
            this.f45440a = r100;
            this.f45441b = r101;
            this.f45442c = r102;
            this.f45443d = r103;
            this.f45444e = r104;
            this.f45445f = r105;
        }

        @Override // io.reactivex.functions.Function
        public final Object apply(Object r210) {
            final Float r100 = (Float) r210;
            Intrinsics.checkNotNullParameter(r100, "defaultY");
            return RxViewAnimationExtensionKt.h(RxViewAnimationExtensionKt.e(this.f45440a, null, null, null, null, null, null, null, null, null, Float.valueOf(this.f45441b), null, this.f45442c, this.f45443d, this.f45444e, 1535), this.f45445f, new RxViewAnimationExtensionKt$y$1$1(this, r100));
        }
    }

    public static final class n<T, R> implements Function {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ View f45446a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ float f45447b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ Long f45448c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final /* synthetic */ TimeInterpolator f45449d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final /* synthetic */ Long f45450e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public final /* synthetic */ boolean f45451f;

        public n(View r100, float r101, Long r102, TimeInterpolator r103, Long r104, boolean r105) {
            this.f45446a = r100;
            this.f45447b = r101;
            this.f45448c = r102;
            this.f45449d = r103;
            this.f45450e = r104;
            this.f45451f = r105;
        }

        @Override // io.reactivex.functions.Function
        public final Object apply(Object r210) {
            final Float r100 = (Float) r210;
            Intrinsics.checkNotNullParameter(r100, "defaultZ");
            return RxViewAnimationExtensionKt.h(RxViewAnimationExtensionKt.e(this.f45446a, null, null, null, null, null, null, null, null, null, null, Float.valueOf(this.f45447b), this.f45448c, this.f45449d, this.f45450e, 1023), this.f45451f, new RxViewAnimationExtensionKt$z$1$1(this, r100));
        }
    }

    public static final float a(float r100) {
        Resources r101 = Resources.getSystem();
        return r100 * WindowDisplayMetricsOverride.apply(r101, r101.getDisplayMetrics()).density;
    }

    public static final Completable h(Completable r100, boolean r101, Function0<? extends Completable> r102) {
        if (r101 == true) goto L4;
        return r100;
    L4:
        return r100.andThen(r102.invoke());
    }

    public static final void b(ValueAnimator r100, Long r101, Interpolator r102, Function0 r103, Function1 r104) {
        if (r101 == null) goto L4;
        r100.setDuration(r101.longValue());
    L4:
        if (r102 == null) goto L6;
        r100.setInterpolator(r102);
    L6:
        r100.addUpdateListener(new com.bytedance.android.ec.core.toolbox.rxanimation.d(r104, r103));
        r100.addListener(new com.bytedance.android.ec.core.toolbox.rxanimation.e(r103));
        r100.start();
    }

    public static /* synthetic */ Completable d(View r100, float r101, Long r110, TimeInterpolator r111, int r112) {
        if ((r112 & 2) == 0) goto L5;
        Long r102 = null;
    L7:
        if ((r112 & 4) == 0) goto L9;
        TimeInterpolator r103 = null;
    L11:
        return c(r100, r101, r102, r103, null, false);
    L9:
        r103 = r111;
        goto L11
    L5:
        r102 = r110;
        goto L7
    }

    public static final Completable f(final Pair<Float, Float> r100, final Long r101, final Interpolator r102, boolean r103, final Function1<? super Float, Unit> r104) {
        Intrinsics.checkNotNullParameter(r100, "$this$rangeFloatToCompletable");
        Intrinsics.checkNotNullParameter(r104, "action");
        return h(Completable.create(new RxViewAnimationExtensionKt$rangeFloatToCompletable$1(r100, r101, r102, r104)), r103, new RxViewAnimationExtensionKt$rangeFloatToCompletable$2(r100, r101, r102, r104));
    }

    public static final Completable g(final Pair<Integer, Integer> r100, final Long r101, final Interpolator r102, boolean r103, final Function1<? super Integer, Unit> r104) {
        Intrinsics.checkNotNullParameter(r100, "$this$rangeIntToCompletable");
        Intrinsics.checkNotNullParameter(r104, "action");
        Completable r105 = Completable.create(new RxViewAnimationExtensionKt$rangeIntToCompletable$1(r100, r101, r102, r104));
        if (r103 == true) goto L5;
        return r105;
    L5:
        return r105.andThen(g(TuplesKt.to(r100.getSecond(), r100.getFirst()), r101, r102, false, r104));
    }

    public static final Completable c(View r100, float r110, Long r111, TimeInterpolator r112, Long r113, boolean r114) {
        Intrinsics.checkNotNullParameter(r100, "$this$alpha");
        return Observable.just(Float.valueOf(r100.getAlpha())).flatMapCompletable(new a(r100, r110, r111, r112, r113, r114));
    }

    public static final Completable i(View r100, float r110, Long r111, TimeInterpolator r112, Long r113, boolean r114) {
        Intrinsics.checkNotNullParameter(r100, "$this$rotation");
        return Observable.just(Float.valueOf(r100.getRotation())).flatMapCompletable(new b(r100, r110, r111, r112, r113, r114));
    }

    public static final Completable j(View r100, float r110, Long r111, TimeInterpolator r112, Long r113, boolean r114) {
        Intrinsics.checkNotNullParameter(r100, "$this$rotationX");
        return Observable.just(Float.valueOf(r100.getRotationX())).flatMapCompletable(new c(r100, r110, r111, r112, r113, r114));
    }

    public static final Completable k(View r100, float r110, Long r111, TimeInterpolator r112, Long r113, boolean r114) {
        Intrinsics.checkNotNullParameter(r100, "$this$rotationY");
        return Observable.just(Float.valueOf(r100.getRotationY())).flatMapCompletable(new d(r100, r110, r111, r112, r113, r114));
    }

    public static final Completable l(View r100, float r110, Long r111, TimeInterpolator r112, Long r113, boolean r114) {
        Intrinsics.checkNotNullParameter(r100, "$this$scale");
        return Observable.just(TuplesKt.to(Float.valueOf(r100.getScaleX()), Float.valueOf(r100.getScaleY()))).flatMapCompletable(new e(r100, r110, r111, r112, r113, r114));
    }

    public static final Completable m(View r100, float r110, Long r111, TimeInterpolator r112, Long r113, boolean r114) {
        Intrinsics.checkNotNullParameter(r100, "$this$scaleX");
        return Observable.just(Float.valueOf(r100.getScaleX())).flatMapCompletable(new f(r100, r110, r111, r112, r113, r114));
    }

    public static final Completable n(View r100, float r110, Long r111, TimeInterpolator r112, Long r113, boolean r114) {
        Intrinsics.checkNotNullParameter(r100, "$this$scaleY");
        return Observable.just(Float.valueOf(r100.getScaleY())).flatMapCompletable(new g(r100, r110, r111, r112, r113, r114));
    }

    public static final Completable p(View r100, float r110, Long r111, TimeInterpolator r112, Long r113, boolean r114) {
        Intrinsics.checkNotNullParameter(r100, "$this$translationX");
        return Observable.just(Float.valueOf(r100.getTranslationX())).flatMapCompletable(new i(r100, r110, r111, r112, r113, r114));
    }

    public static final Completable q(View r100, float r110, Long r111, TimeInterpolator r112, Long r113, boolean r114) {
        Intrinsics.checkNotNullParameter(r100, "$this$translationY");
        return Observable.just(Float.valueOf(r100.getTranslationY())).flatMapCompletable(new j(r100, r110, r111, r112, r113, r114));
    }

    public static final Completable r(View r100, float r110, Long r111, TimeInterpolator r112, Long r113, boolean r114) {
        Intrinsics.checkNotNullParameter(r100, "$this$x");
        return Observable.just(Float.valueOf(r100.getX())).flatMapCompletable(new k(r100, r110, r111, r112, r113, r114));
    }

    public static final Completable t(View r100, float r110, Long r111, TimeInterpolator r112, Long r113, boolean r114) {
        Intrinsics.checkNotNullParameter(r100, "$this$y");
        return Observable.just(Float.valueOf(r100.getY())).flatMapCompletable(new m(r100, r110, r111, r112, r113, r114));
    }

    public static final Completable u(View r100, float r110, Long r111, TimeInterpolator r112, Long r113, boolean r114) {
        Intrinsics.checkNotNullParameter(r100, "$this$z");
        return Observable.just(Float.valueOf(r100.getZ())).flatMapCompletable(new n(r100, r110, r111, r112, r113, r114));
    }

    public static final Completable o(View r110, float r111, float r112, Long r113, TimeInterpolator r114, Long r115, boolean r116) {
        Intrinsics.checkNotNullParameter(r110, "$this$translation");
        return Observable.just(TuplesKt.to(Float.valueOf(r110.getTranslationX()), Float.valueOf(r110.getTranslationY()))).flatMapCompletable(new h(r110, r111, r112, r113, r114, r115, r116));
    }

    public static final Completable s(View r110, Float r111, Float r112, Float r113, Long r114, TimeInterpolator r115, Long r116, boolean r117) {
        Intrinsics.checkNotNullParameter(r110, "$this$xyz");
        return Observable.just(new Triple(Float.valueOf(r110.getX()), Float.valueOf(r110.getY()), Float.valueOf(r110.getZ()))).flatMapCompletable(new l(r110, r111, r112, r113, r114, r115, r116, r117));
    }

    public static Completable e(final View r110, Float r210, Float r211, Float r212, Float r213, Float r214, Float r215, Float r216, Float r217, Float r218, Float r219, Float r310, Long r311, TimeInterpolator r312, Long r313, int r314) {
        if ((r314 & 1) == 0) goto L5;
        final Float r100 = null;
    L7:
        if ((r314 & 2) == 0) goto L9;
        final Float r101 = null;
    L11:
        if ((r314 & 4) == 0) goto L13;
        final Float r102 = null;
    L15:
        if ((r314 & 8) == 0) goto L17;
        final Float r103 = null;
    L19:
        if ((r314 & 16) == 0) goto L21;
        final Float r104 = null;
    L23:
        if ((r314 & 32) == 0) goto L25;
        final Float r111 = null;
    L27:
        if ((r314 & 64) == 0) goto L29;
        final Float r112 = null;
    L31:
        if ((r314 & 128) == 0) goto L33;
        final Float r113 = null;
    L35:
        if ((r314 & 256) == 0) goto L37;
        final Float r114 = null;
    L39:
        if ((r314 & 512) == 0) goto L41;
        final Float r115 = null;
    L43:
        if ((r314 & 1024) == 0) goto L45;
        final Float r116 = null;
    L47:
        if ((r314 & 2048) == 0) goto L49;
        final Long r117 = null;
    L51:
        if ((r314 & 4096) == 0) goto L53;
        final TimeInterpolator r118 = null;
    L55:
        if ((r314 & 8192) == 0) goto L57;
        final Long r119 = null;
    L58:
        Intrinsics.checkNotNullParameter(r110, "$this$animate");
        return Completable.create(new RxViewAnimationExtensionKt$animate$2(r110, r100, r101, r102, r103, r104, r111, r112, r113, r114, r115, r116, r117, r118, r119));
    L57:
        r119 = r313;
        goto L58
    L53:
        r118 = r312;
        goto L55
    L49:
        r117 = r311;
        goto L51
    L45:
        r116 = r310;
        goto L47
    L41:
        r115 = r219;
        goto L43
    L37:
        r114 = r218;
        goto L39
    L33:
        r113 = r217;
        goto L35
    L29:
        r112 = r216;
        goto L31
    L25:
        r111 = r215;
        goto L27
    L21:
        r104 = r214;
        goto L23
    L17:
        r103 = r213;
        goto L19
    L13:
        r102 = r212;
        goto L15
    L9:
        r101 = r211;
        goto L11
    L5:
        r100 = r210;
        goto L7
    }
}
