package com.bytedance.android.livesdk.gift.platform.business.normal.view.v2;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapShader;
import android.graphics.Canvas;
import android.graphics.ComposeShader;
import android.graphics.LinearGradient;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.Shader;
import android.util.AttributeSet;
import android.view.View;
import com.alibaba.gaiax.template.GXTemplateKey;
import com.bytedance.android.live.core.utils.s1;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u00002\u00020\u0001:\u0002\u0012\u0013B'\b\u0007\u0012\u0006\u0010\f\u001a\u00020\u000b\u0012\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\r\u0012\b\b\u0002\u0010\u000f\u001a\u00020\u0002¢\u0006\u0004\b\u0010\u0010\u0011J\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002J\u000e\u0010\u0007\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0002J\u000e\u0010\n\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\b¨\u0006\u0014"}, d2 = {"Lcom/bytedance/android/livesdk/gift/platform/business/normal/view/v2/GiftIconMaskView;", "Landroid/view/View;", "", "count", "", "setRepeatCount", "mode", "setShaderMode", "Lcom/bytedance/android/livesdk/gift/platform/business/normal/view/v2/GiftIconMaskView$b;", "onShaderAinmatorListener", "setOnShaderAinmatorListener", "Landroid/content/Context;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/util/AttributeSet;", "attrs", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "b", "livegift-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class GiftIconMaskView extends View {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Paint f129825a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public ValueAnimator f129826b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public boolean f129827c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public Bitmap f129828d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public BitmapShader f129829e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public int f129830f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public int f129831g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public b f129832h;

    public static final class a {
    }

    public interface b {
        void onAnimationEnd(Animator r100);

        void onAnimationStart(Animator r100);
    }

    public static final class c implements ValueAnimator.AnimatorUpdateListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ GiftIconMaskView f129833a;

        public c(GiftIconMaskView r100) {
            this.f129833a = r100;
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public final void onAnimationUpdate(ValueAnimator r110) {
            Intrinsics.checkNotNullParameter(r110, "it");
            if ((r110.getAnimatedValue() instanceof Float) == false) goto L9;
            Object r111 = r110.getAnimatedValue();
            if (r111 == null) goto L8;
            float r100 = ((Float) r111).floatValue();
        L11:
            if (this.f129833a.f129831g != 0) goto L13;
            float r101 = r100;
            LinearGradient r112 = new LinearGradient(0.0f, s1.e(40.0f), r101, s1.e(40.0f) - r100, new int[]{0, -1, 0}, new float[]{0.3f, 0.5f, 0.7f}, Shader.TileMode.CLAMP);
        L14:
            BitmapShader r102 = this.f129833a.f129829e;
            Intrinsics.checkNotNull(r102);
            ComposeShader r103 = new ComposeShader(r112, r102, PorterDuff.Mode.DST_ATOP);
            this.f129833a.f129825a.setShader(r103);
            this.f129833a.invalidate();
            return;
        L13:
            float r104 = r100;
            r112 = new LinearGradient(0.0f, 0.0f, r104, r100, new int[]{0, -1, 0}, new float[]{0.3f, 0.5f, 0.7f}, Shader.TileMode.CLAMP);
            goto L14
        L8:
            throw new NullPointerException("null cannot be cast to non-null type kotlin.Float");
        L9:
            r100 = 0.0f;
            goto L11
        }
    }

    public static final class d extends AnimatorListenerAdapter {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ GiftIconMaskView f129834a;

        public d(GiftIconMaskView r100) {
            this.f129834a = r100;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public final void onAnimationEnd(Animator r100) {
            Intrinsics.checkNotNullParameter(r100, GXTemplateKey.GAIAX_ANIMATION);
            GiftIconMaskView r101 = this.f129834a;
            r101.f129827c = false;
            b r102 = r101.f129832h;
            if (r102 == null) goto L6;
            r102.onAnimationEnd(r100);
            return;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public final void onAnimationStart(Animator r100) {
            Intrinsics.checkNotNullParameter(r100, GXTemplateKey.GAIAX_ANIMATION);
            GiftIconMaskView r101 = this.f129834a;
            r101.f129827c = true;
            b r102 = r101.f129832h;
            if (r102 == null) goto L6;
            r102.onAnimationStart(r100);
            return;
        }
    }

    static {
    }

    public GiftIconMaskView(Context r100) {
        AttributeSet r101 = null;
        this(r100, r101, 6, 0);
    }

    public GiftIconMaskView(Context r100, AttributeSet r101) {
        this(r100, r101, 4, 0);
    }

    public final void b() {
        if (this.f129829e != null) goto L5;
        return;
    L5:
        if (getVisibility() == 8) goto L40;
        ValueAnimator r100 = this.f129826b;
        if (r100 != null) goto L10;
    L20:
        ValueAnimator r101 = ValueAnimator.ofFloat(new float[]{0.0f, s1.e(40.0f) * 3});
        this.f129826b = r101;
        if (r101 == null) goto L23;
        r101.setDuration(800);
    L23:
        ValueAnimator r102 = this.f129826b;
        if (r102 == null) goto L26;
        r102.addUpdateListener(new c(this));
    L26:
        int r103 = this.f129830f;
        if (r103 <= 0) goto L31;
        ValueAnimator r104 = this.f129826b;
        if (r104 == null) goto L31;
        r104.setRepeatCount(r103);
    L31:
        ValueAnimator r105 = this.f129826b;
        if (r105 == null) goto L34;
        r105.addListener(new d(this));
    L34:
        ValueAnimator r106 = this.f129826b;
        if (r106 == null) goto L39;
        r106.start();
        return;
    L39:
        return;
    L10:
        if (r100.isRunning() != true) goto L20;
        ValueAnimator r107 = this.f129826b;
        if (r107 == null) goto L14;
        r107.cancel();
    L14:
        ValueAnimator r108 = this.f129826b;
        if (r108 == null) goto L17;
        r108.removeAllListeners();
    L17:
        ValueAnimator r109 = this.f129826b;
        if (r109 == null) goto L20;
        r109.removeAllUpdateListeners();
        goto L20
    }

    public final void c() {
        ValueAnimator r100 = this.f129826b;
        if (r100 != null) goto L5;
        return;
    L5:
        if (r100.isRunning() != true) goto L17;
        ValueAnimator r101 = this.f129826b;
        if (r101 == null) goto L9;
        r101.cancel();
    L9:
        ValueAnimator r102 = this.f129826b;
        if (r102 == null) goto L12;
        r102.removeAllListeners();
    L12:
        ValueAnimator r103 = this.f129826b;
        if (r103 == null) goto L18;
        r103.removeAllUpdateListeners();
        return;
    L18:
        return;
    }

    public final void a(Bitmap r100) {
        if (r100 == null) goto L5;
        this.f129828d = r100;
        Shader.TileMode r101 = Shader.TileMode.CLAMP;
        this.f129829e = new BitmapShader(r100, r101, r101);
        invalidate();
        return;
    }

    @Override // android.view.View
    public final void onDraw(Canvas r100) {
        Intrinsics.checkNotNullParameter(r100, "canvas");
        super.onDraw(r100);
        Bitmap r101 = this.f129828d;     // Catch: Exception -> L14
        if (r101 == null) goto L13;
        Intrinsics.checkNotNull(r101);     // Catch: Exception -> L14
        if (r101.isRecycled() == false) goto L9;
        return;
    L9:
        if (this.f129827c == false) goto L11;
        r100.drawRect(0.0f, 0.0f, getWidth(), getHeight(), this.f129825a);     // Catch: Exception -> L14
    L17:
        return;
    L11:
        this.f129825a.setShader(this.f129829e);     // Catch: Exception -> L14
        r100.drawRect(0.0f, 0.0f, getWidth(), getHeight(), this.f129825a);     // Catch: Exception -> L14
        goto L17
    L13:
        return;
    L14:
        e = move-exception;
        e.printStackTrace();
    }

    public final void setOnShaderAinmatorListener(b r100) {
        Intrinsics.checkNotNullParameter(r100, "onShaderAinmatorListener");
        this.f129832h = r100;
    }

    public final void setRepeatCount(int r100) {
        this.f129830f = r100;
    }

    public final void setShaderMode(int r100) {
        this.f129831g = r100;
    }

    public GiftIconMaskView(Context r100, AttributeSet r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r101, r102);
        this.f129825a = new Paint();
    }

    public /* synthetic */ GiftIconMaskView(Context r100, AttributeSet r101, int r102, int r103) {
        if ((r102 & 2) == 0) goto L5;
        r101 = null;
    L5:
        this(r100, r101, 0);
    }
}
