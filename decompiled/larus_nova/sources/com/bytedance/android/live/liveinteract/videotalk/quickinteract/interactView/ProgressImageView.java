package com.bytedance.android.live.liveinteract.videotalk.quickinteract.interactView;

import android.animation.Animator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;
import com.alibaba.gaiax.template.GXTemplateKey;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.livesdk.utils.r2;
import com.larus.nova.R;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;

/* JADX INFO: loaded from: classes46.dex */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\u0018\u00002\u00020\u0001:\u0001\nB'\b\u0007\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0004\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\b\u0010\t¨\u0006\u000b"}, d2 = {"Lcom/bytedance/android/live/liveinteract/videotalk/quickinteract/interactView/ProgressImageView;", "Landroid/view/View;", "Landroid/content/Context;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/util/AttributeSet;", "attrs", "", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "liveinteract-impl_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class ProgressImageView extends View {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public float f79550a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public ValueAnimator f79551b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public float f79552c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Bitmap f79553d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final float f79554e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final Matrix f79555f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final Paint f79556g;

    public static final class a {
    }

    public static final class b implements ValueAnimator.AnimatorUpdateListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ ProgressImageView f79557a;

        public b(ProgressImageView r100) {
            this.f79557a = r100;
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public final void onAnimationUpdate(ValueAnimator r100) {
            Intrinsics.checkNotNullParameter(r100, "it");
            ProgressImageView r101 = this.f79557a;
            Object r102 = r100.getAnimatedValue();
            if (r102 == null) goto L7;
            r101.f79550a = ((Float) r102).floatValue();
            this.f79557a.invalidate();
            return;
        L7:
            throw new NullPointerException("null cannot be cast to non-null type kotlin.Float");
        }
    }

    public static final class c implements Animator.AnimatorListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ ProgressImageView f79558a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ String f79559b;

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

        @Override // android.animation.Animator.AnimatorListener
        public final void onAnimationEnd(Animator r100) {
            Intrinsics.checkNotNullParameter(r100, GXTemplateKey.GAIAX_ANIMATION);
            gj0.i.a("ProgressImageView", "onAnimationEnd curProgress : " + this.f79558a.f79550a + "  targetProgress : " + this.f79558a.f79552c);
            ProgressImageView r101 = this.f79558a;
            if (r101.f79550a == 1.0f) goto L5;
        L9:
            this.f79558a.setVisibility(0);
        L10:
            ProgressImageView r102 = this.f79558a;
            if (r102.f79550a == r102.f79552c) goto L14;
            r102.a(this.f79559b);
            return;
        L14:
            return;
        L5:
            if (r101.f79552c != 1.0f) goto L9;
            if (r2.a(this.f79559b) == false) goto L9;
            this.f79558a.setVisibility(8);
            goto L10
        }

        public c(ProgressImageView r100, String r101) {
            this.f79558a = r100;
            this.f79559b = r101;
        }
    }

    static {
    }

    public ProgressImageView(Context r100) {
        AttributeSet r101 = null;
        this(r100, r101, 6, 0);
    }

    public ProgressImageView(Context r100, AttributeSet r101) {
        this(r100, r101, 4, 0);
    }

    public final void a(String r100) {
        Ref.LongRef r101 = new Ref.LongRef();
        r101.element = (long) (Math.abs(this.f79550a - this.f79552c) / this.f79554e);
        gj0.i.a("ProgressImageView", "startAnimation curProgress : " + this.f79550a + "  targetProgress : " + this.f79552c + "  d :" + r101.element);
        ValueAnimator r102 = ValueAnimator.ofFloat(new float[]{this.f79550a, this.f79552c});
        r102.setDuration(r101.element);
        r102.addUpdateListener(new b(this));
        r102.addListener(new c(this, r100));
        Unit r103 = Unit.INSTANCE;
        this.f79551b = r102;
        r102.start();
    }

    @Override // android.view.View
    public final void onDraw(Canvas r100) {
        Intrinsics.checkNotNullParameter(r100, "canvas");
        super.onDraw(r100);
        r100.clipRect(0, 0, (int) (getWidth() * this.f79550a), getHeight());
        r100.drawBitmap(this.f79553d, this.f79555f, this.f79556g);
    }

    public ProgressImageView(Context r100, AttributeSet r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r101, r102);
        Bitmap r103 = s1.g(R.drawable.star_wish_progress);
        this.f79553d = r103;
        this.f79554e = 0.001f;
        this.f79555f = new Matrix();
        Paint r104 = new Paint();
        r104.setAntiAlias(true);
        Unit r105 = Unit.INSTANCE;
        this.f79556g = r104;
        Matrix r106 = new Matrix();
        r106.postScale(s1.f(50.0f) / r103.getWidth(), s1.f(14.0f) / r103.getHeight());
        this.f79555f = r106;
    }

    public final void b(float r100, String r101, boolean r102) {
        if (r100 <= 0) goto L8;
        if (r100 > 1.0f) goto L8;
    L11:
        this.f79552c = r100;
        gj0.i.a("ProgressImageView", "updateProgress curProgress : " + this.f79550a + "  targetProgress : " + this.f79552c + " updateWithAnim=" + r102);
        if (this.f79552c == this.f79550a) goto L26;
        ValueAnimator r103 = this.f79551b;
        if (r103 != null) goto L16;
    L17:
        if (r102 == false) goto L19;
        a(r101);
        return;
    L19:
        float r104 = this.f79552c;
        this.f79550a = r104;
        if (r104 == 1.0f) goto L22;
    L24:
        setVisibility(0);
    L25:
        invalidate();
        return;
    L22:
        if (r2.a(r101) == false) goto L24;
        setVisibility(8);
        goto L25
    L16:
        if (r103.isRunning() != true) goto L17;
    L26:
        float r105 = this.f79552c;
        float r106 = this.f79550a;
        if (r105 == r106) goto L29;
        return;
    L29:
        if (r106 == 1.0f) goto L31;
        return;
    L31:
        if (getVisibility() != 0) goto L39;
        if (r101 == null) goto L40;
        setVisibility(8);
        return;
    L40:
        return;
    L39:
        return;
    L8:
        if (r100 <= 1.0f) goto L10;
        r100 = 1.0f;
        goto L11
    L10:
        r100 = 0.0f;
        goto L11
    }

    public /* synthetic */ ProgressImageView(Context r100, AttributeSet r101, int r102, int r103) {
        if ((r102 & 2) == 0) goto L5;
        r101 = null;
    L5:
        this(r100, r101, 0);
    }
}
