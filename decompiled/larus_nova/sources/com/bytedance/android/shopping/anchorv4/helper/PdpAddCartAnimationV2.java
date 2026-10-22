package com.bytedance.android.shopping.anchorv4.helper;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.Point;
import android.graphics.PointF;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import com.bytedance.android.ec.core.imagex.ImageExtensionsKt;
import com.bytedance.android.ui.ec.widget.ecdraweeview.ECDraweeView;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.lang.ref.WeakReference;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes12.dex */
public final class PdpAddCartAnimationV2 extends BasePdpAddCartAnimation {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final float f166885f = 0.0f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final int f166886g = 0;

    public static final class a {
    }

    public static final class b implements ValueAnimator.AnimatorUpdateListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ ValueAnimator f166887a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ View f166888b;

        public b(ValueAnimator r100, View r101) {
            this.f166887a = r100;
            this.f166888b = r101;
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public final void onAnimationUpdate(ValueAnimator r100) {
            Object r101 = this.f166887a.getAnimatedValue();     // Catch: Exception -> L7
            if (r101 == null) goto L6;
            float r102 = ((Float) r101).floatValue();     // Catch: Exception -> L7
            int r103 = com.bytedance.android.shopping.utils.x.f187159a;     // Catch: Exception -> L7
            float r104 = 0.96f + (0.04000002f * r102);     // Catch: Exception -> L7
            float r105 = 0.0f + (1.0f * r102);     // Catch: Exception -> L7
            this.f166888b.setScaleX(r104);     // Catch: Exception -> L7
            this.f166888b.setScaleY(r104);     // Catch: Exception -> L7
            this.f166888b.setAlpha(r105);     // Catch: Exception -> L7
            return;
        L6:
            throw new NullPointerException("null cannot be cast to non-null type kotlin.Float");     // Catch: Exception -> L7
        L7:
            this.f166888b.setVisibility(4);
        }
    }

    public static final class c implements ValueAnimator.AnimatorUpdateListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ ValueAnimator f166889a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ int f166890b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ PointF f166891c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final /* synthetic */ int f166892d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final /* synthetic */ PdpAddCartAnimationV2 f166893e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public final /* synthetic */ int f166894f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public final /* synthetic */ int f166895g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public final /* synthetic */ View f166896h;

        public c(ValueAnimator r100, int r101, PointF r102, int r103, PdpAddCartAnimationV2 r104, int r105, int r106, View r107) {
            this.f166889a = r100;
            this.f166890b = r101;
            this.f166891c = r102;
            this.f166892d = r103;
            this.f166893e = r104;
            this.f166894f = r105;
            this.f166895g = r106;
            this.f166896h = r107;
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public final void onAnimationUpdate(ValueAnimator r100) {
            Object r101 = this.f166889a.getAnimatedValue();     // Catch: Exception -> L9
            if (r101 == null) goto L8;
            float r102 = ((Float) r101).floatValue();     // Catch: Exception -> L9
            int r103 = com.bytedance.android.shopping.utils.x.f187159a;     // Catch: Exception -> L9
            this.f166893e.e(this.f166896h, (int) com.bytedance.android.shopping.utils.x.a(r102, this.f166894f, this.f166890b, this.f166891c.x), (int) com.bytedance.android.shopping.utils.x.a(r102, this.f166895g, this.f166892d, this.f166891c.y));     // Catch: Exception -> L9
            float r104 = ((-0.8f) * r102) + 1.0f;     // Catch: Exception -> L9
            this.f166896h.setScaleX(r104);     // Catch: Exception -> L9
            this.f166896h.setScaleY(r104);     // Catch: Exception -> L9
            if (r102 <= 0.91f) goto L12;
            this.f166896h.setAlpha((((r102 - 0.91f) / 0.09f) * (-1.0f)) + 1.0f);     // Catch: Exception -> L9
            return;
        L12:
            return;
        L8:
            throw new NullPointerException("null cannot be cast to non-null type kotlin.Float");     // Catch: Exception -> L9
        L9:
            this.f166896h.setVisibility(4);
        }
    }

    static {
        f166885f = com.bytedance.android.ec.core.utils.q.a(12);
        f166886g = com.bytedance.android.shopping.extensions.b.a(104);
    }

    @Override // com.bytedance.android.shopping.anchorv4.helper.BasePdpAddCartAnimation
    public final ECDraweeView a() {
        ECDraweeView r110 = new ECDraweeView(getContext(), null, 0, 6, null);
        int r100 = f166886g;
        r110.setLayoutParams(new ViewGroup.LayoutParams(r100, r100));
        r110.setCornerRadius(f166885f);
        r110.setBorderWidth(com.bytedance.android.ec.core.utils.q.a(2));
        r110.setBorderColor((int) 4294914884L);
        String r101 = this.f166860c;
        if (r101 == null) goto L5;
        ImageExtensionsKt.w(r110, r101, null, null, null, null, null, null, null, false, null, null, 4094);
    L5:
        return r110;
    }

    @Override // com.bytedance.android.shopping.anchorv4.helper.BasePdpAddCartAnimation
    public final WindowManager.LayoutParams b() {
        Point r100 = this.f166858a;
        int r101 = r100.x;
        int r102 = f166886g;
        int r103 = r101 - (r102 / 2);
        int r104 = r100.y - (r102 / 2);
        WindowManager.LayoutParams r105 = super.b();
        r105.x = r103;
        r105.y = r104;
        r105.width = r102;
        r105.height = r102;
        return r105;
    }

    public PdpAddCartAnimationV2(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100);
    }

    @Override // com.bytedance.android.shopping.anchorv4.helper.BasePdpAddCartAnimation
    public final void d(View r110, final Function0<Unit> r111) {
        Intrinsics.checkNotNullParameter(r110, "view");
        Point r100 = this.f166858a;
        int r101 = r100.x;
        int r102 = f166886g / 2;
        int r112 = r101 - r102;
        int r113 = r100.y - r102;
        r110.setScaleX(0.96f);
        r110.setScaleY(0.96f);
        r110.setAlpha(0.0f);
        final ValueAnimator r103 = ValueAnimator.ofFloat(new float[]{0.0f, 1.0f});
        r103.setDuration(200);
        r103.addUpdateListener(new b(r103, r110));
        final ValueAnimator r104 = ValueAnimator.ofFloat(new float[]{0.0f, 1.0f});
        r104.setDuration(550);
        Point r105 = this.f166859b;
        int r106 = r105.x - r102;
        int r107 = r105.y - r102;
        PointF r108 = new PointF(r112, r113);
        PointF r109 = new PointF(r106, r107);
        float r114 = (r108.x + r109.x) / 2.0f;
        float r115 = Math.abs(r109.y - r108.y);
        float r116 = r108.y;
        float r117 = r109.y;
        float r118 = r115 * 0.3f;
        if (r116 <= r117) goto L5;
        float r119 = r117 + r118;
    L6:
        r104.addUpdateListener(new c(r104, r106, new PointF(r114, r119), r107, this, r112, r113, r110));
        AnimatorSet r120 = new AnimatorSet();
        r120.playSequentially(new Animator[]{r103, r104});
        com.bytedance.android.ec.core.utils.f.a(r120, new PdpAddCartAnimationV2$startAnimationImpl$$inlined$apply$lambda$3(r103, r104, r111));
        WeakReference<Animator> r121 = o.f166970a;
        o.f166970a = new WeakReference(r120);
        r120.start();
        return;
    L5:
        r119 = r116 - r118;
        goto L6
    }
}
