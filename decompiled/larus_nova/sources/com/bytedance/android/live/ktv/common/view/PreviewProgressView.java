package com.bytedance.android.live.ktv.common.view;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewpager2.widget.ViewPager2;
import com.bytedance.android.live.core.utils.UtilityKotlinExtentionsKt;
import com.larus.nova.R;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes45.dex */
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001:\u0001\u001aB\u0017\u0012\u0006\u0010\u0015\u001a\u00020\u0014\u0012\u0006\u0010\u0017\u001a\u00020\u0016¢\u0006\u0004\b\u0018\u0010\u0019J\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002J\u000e\u0010\b\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006J\u000e\u0010\u000b\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\tR0\u0010\u0013\u001a\u0010\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0004\u0018\u00010\f8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012¨\u0006\u001b"}, d2 = {"Lcom/bytedance/android/live/ktv/common/view/PreviewProgressView;", "Landroidx/constraintlayout/widget/ConstraintLayout;", "", "color", "", "setProgressColor", "", "percent", "setProgress", "", "progress", "setProgressText", "Lkotlin/Function1;", "f", "Lkotlin/jvm/functions/Function1;", "getDragProgressListener", "()Lkotlin/jvm/functions/Function1;", "setDragProgressListener", "(Lkotlin/jvm/functions/Function1;)V", "dragProgressListener", "Landroid/content/Context;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/util/AttributeSet;", "attrs", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "b", "livektv-common_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class PreviewProgressView extends ConstraintLayout {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final View f70757a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final View f70758b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final TextView f70759c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public float f70760d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public Float f70761e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public Function1<? super Float, Unit> f70762f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public float f70763g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public boolean f70764h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public Boolean f70765i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public View f70766j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final int f70767k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public ViewPager2 f70768l;

    public static final class a implements View.OnTouchListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ PreviewProgressView f70769a;

        public a(PreviewProgressView r100) {
            this.f70769a = r100;
        }

        @Override // android.view.View.OnTouchListener
        public final boolean onTouch(View r110, MotionEvent r111) {
            int r112 = r111.getAction();
            boolean r100 = false;
            if (r112 == 0) goto L52;
            if (r112 != 1) goto L6;
            PreviewProgressView r113 = this.f70769a;
            r113.f70764h = false;
            if (r111.getX() < this.f70769a.f70763g) goto L46;
            r100 = true;
        L46:
            r113.f70765i = Boolean.valueOf(r100);
            Function1<Float, Unit> r114 = this.f70769a.getDragProgressListener();
            if (r114 == null) goto L49;
            Unit r115 = r114.invoke(Float.valueOf(this.f70769a.f70760d));
        L49:
            PreviewProgressView.R5(this.f70769a);
            ViewPager2 r116 = this.f70769a.f70768l;
            if (r116 == null) goto L95;
            r116.setUserInputEnabled(true);
        L95:
            return true;
        L6:
            if (r112 != 2) goto L8;
            float r117 = r111.getX();
            PreviewProgressView r118 = this.f70769a;
            float r101 = r118.f70763g;
            float r102 = r101 + (r117 - r101);
            View r119 = r118.f70758b;
            if (r119 != null) goto L23;
            Intrinsics.throwUninitializedPropertyAccessException("progressViewParent");
        L23:
            float r103 = r102 / r119.getWidth();
            if (r103 <= 1.0f) goto L27;
            r118.f70760d = 1.0f;
        L30:
            View r120 = this.f70769a.f70757a;
            if (r120 != null) goto L33;
            Intrinsics.throwUninitializedPropertyAccessException("progressView");
        L33:
            PreviewProgressView r121 = this.f70769a;
            float r104 = r121.f70760d;
            View r122 = r121.f70758b;
            if (r122 != null) goto L36;
            Intrinsics.throwUninitializedPropertyAccessException("progressViewParent");
        L36:
            q32.a.a(r120, (int) (r104 * r122.getWidth()));
            PreviewProgressView r123 = this.f70769a;
            View r124 = r123.f70766j;
            if (r124 == null) goto L42;
            float r105 = r123.f70760d;
            View r125 = r123.f70758b;
            if (r125 != null) goto L41;
            Intrinsics.throwUninitializedPropertyAccessException("progressViewParent");
        L41:
            r124.setX((r105 * r125.getWidth()) - (this.f70769a.f70767k / 2.0f));
        L42:
            this.f70769a.f70764h = true;
            goto L95
        L27:
            if (r103 >= 0.0f) goto L29;
            r118.f70760d = 0.0f;
            goto L30
        L29:
            r118.f70760d = r103;
            goto L30
        L8:
            if (r112 != 3) goto L10;
            PreviewProgressView.R5(this.f70769a);
            goto L95
        L10:
            if (r112 != 4) goto L95;
            View r126 = this.f70769a.f70757a;
            if (r126 != null) goto L15;
            Intrinsics.throwUninitializedPropertyAccessException("progressView");
        L15:
            PreviewProgressView r127 = this.f70769a;
            float r106 = r127.f70760d;
            View r128 = r127.f70758b;
            if (r128 != null) goto L18;
            Intrinsics.throwUninitializedPropertyAccessException("progressViewParent");
        L18:
            q32.a.a(r126, (int) (r106 * r128.getWidth()));
            PreviewProgressView.R5(this.f70769a);
            goto L95
        L52:
            this.f70769a.f70763g = r111.getX();
            PreviewProgressView r129 = this.f70769a;
            r129.f70761e = Float.valueOf(r129.f70760d);
            PreviewProgressView r130 = this.f70769a;
            View r131 = r130.f70757a;
            if (r131 != null) goto L55;
            Intrinsics.throwUninitializedPropertyAccessException("progressView");
        L55:
            Drawable r132 = r131.getBackground();
            View r107 = null;
            if ((r132 instanceof GradientDrawable) == true) goto L58;
            r132 = null;
        L58:
            GradientDrawable r133 = (GradientDrawable) r132;
            if (r133 == null) goto L61;
            r133.setCornerRadius(UtilityKotlinExtentionsKt.h(24));
        L61:
            View r134 = r130.f70757a;
            if (r134 != null) goto L64;
            Intrinsics.throwUninitializedPropertyAccessException("progressView");
        L64:
            View r108 = r130.f70757a;
            if (r108 != null) goto L67;
            Intrinsics.throwUninitializedPropertyAccessException("progressView");
        L67:
            r134.setPivotY(r108.getHeight() / 2.0f);
            View r135 = r130.f70757a;
            if (r135 != null) goto L70;
            Intrinsics.throwUninitializedPropertyAccessException("progressView");
        L70:
            r135.animate().scaleY(2.0f).setDuration(300).start();
            View r136 = r130.f70766j;
            if (r136 != null) goto L91;
            View r137 = new View(r130.getContext());
            r130.f70766j = r137;
            r137.setBackgroundResource(R.drawable.ttlive_solo_ktv_preview_progress_indicator_ic);
            int r109 = r130.f70767k;
            FrameLayout.LayoutParams r138 = new FrameLayout.LayoutParams(r109, r109);
            View r139 = r130.f70766j;
            if (r139 == null) goto L78;
            View r140 = r130.f70757a;
            if (r140 != null) goto L77;
            Intrinsics.throwUninitializedPropertyAccessException("progressView");
        L77:
            r139.setY((-r140.getHeight()) / 2.0f);
        L78:
            View r141 = r130.f70766j;
            if (r141 == null) goto L81;
            r141.setLayoutParams(r138);
        L81:
            View r142 = r130.f70758b;
            if (r142 != null) goto L85;
            Intrinsics.throwUninitializedPropertyAccessException("progressViewParent");
        L85:
            if ((r142 instanceof FrameLayout) == false) goto L88;
            r107 = r142;
        L88:
            FrameLayout r143 = (FrameLayout) r107;
            if (r143 == null) goto L92;
            r143.addView(r130.f70766j, r138);
        L92:
            ViewPager2 r144 = this.f70769a.f70768l;
            if (r144 == null) goto L95;
            r144.setUserInputEnabled(false);
            goto L95
        L91:
            r136.setVisibility(0);
            goto L92
        }
    }

    public static final class b {
    }

    static {
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onAttachedToWindow() {
        super.onAttachedToWindow();
        Object r100 = getParent();
        View r101 = null;
        if ((r100 instanceof View) == true) goto L5;
        r100 = null;
    L5:
        View r102 = (View) r100;
    L6:
        if (r102 == null) goto L14;
        if ((r102 instanceof ViewPager2) == true) goto L14;
        Object r103 = r102.getParent();
        if ((r103 instanceof View) == true) goto L12;
        r103 = null;
    L12:
        r102 = (View) r103;
    L14:
        if ((r102 instanceof ViewPager2) == false) goto L17;
        r101 = r102;
    L17:
        this.f70768l = (ViewPager2) r101;
    }

    public final Function1<Float, Unit> getDragProgressListener() {
        return this.f70762f;
    }

    public static final void R5(PreviewProgressView r100) {
        View r101 = r100.f70757a;
        if (r101 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("progressView");
    L5:
        Drawable r102 = r101.getBackground();
        if ((r102 instanceof GradientDrawable) == true) goto L8;
        r102 = null;
    L8:
        GradientDrawable r103 = (GradientDrawable) r102;
        if (r103 == null) goto L11;
        r103.setCornerRadius(UtilityKotlinExtentionsKt.h(12));
    L11:
        View r104 = r100.f70757a;
        if (r104 != null) goto L14;
        Intrinsics.throwUninitializedPropertyAccessException("progressView");
    L14:
        View r105 = r100.f70757a;
        if (r105 != null) goto L17;
        Intrinsics.throwUninitializedPropertyAccessException("progressView");
    L17:
        r104.setPivotY(r105.getHeight() / 2.0f);
        View r106 = r100.f70757a;
        if (r106 != null) goto L20;
        Intrinsics.throwUninitializedPropertyAccessException("progressView");
    L20:
        r106.animate().scaleY(1.0f).setDuration(300).start();
        View r107 = r100.f70766j;
        if (r107 == null) goto L24;
        r107.setVisibility(8);
        return;
    }

    public final void setDragProgressListener(Function1<? super Float, Unit> r100) {
        this.f70762f = r100;
    }

    public final void setProgress(float r100) {
        if (this.f70761e == null) goto L20;
        Boolean r101 = this.f70765i;
        if (r101 == null) goto L20;
        if (Intrinsics.areEqual(r101, Boolean.TRUE) == false) goto L12;
        if (r100 >= this.f70760d) goto L12;
        return;
    L12:
        if (Intrinsics.areEqual(this.f70765i, Boolean.FALSE) == false) goto L20;
        Float r102 = this.f70761e;
        if (r102 == null) goto L16;
        float r103 = r102.floatValue();
    L18:
        if (r100 <= r103) goto L20;
        return;
    L16:
        r103 = 0.0f;
    L20:
        this.f70761e = null;
        this.f70765i = null;
        if (this.f70764h == false) goto L24;
        return;
    L24:
        if (r100 <= 1.0f) goto L27;
        this.f70760d = 1.0f;
    L30:
        View r104 = this.f70757a;
        if (r104 != null) goto L33;
        Intrinsics.throwUninitializedPropertyAccessException("progressView");
    L33:
        View r105 = this.f70758b;
        if (r105 != null) goto L36;
        Intrinsics.throwUninitializedPropertyAccessException("progressViewParent");
    L36:
        q32.a.a(r104, (int) (r105.getWidth() * r100));
        return;
    L27:
        if (r100 >= 0.0f) goto L29;
        this.f70760d = 0.0f;
        goto L30
    L29:
        this.f70760d = r100;
        goto L30
    }

    public final void setProgressColor(int r100) {
        View r101 = this.f70757a;
        if (r101 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("progressView");
    L5:
        r101.setBackgroundColor(r100);
    }

    public final void setProgressText(String r100) {
        Intrinsics.checkNotNullParameter(r100, "progress");
        TextView r101 = this.f70759c;
        if (r101 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("mTvProgress");
    L5:
        r101.setText(r100);
    }

    public PreviewProgressView(Context r100, AttributeSet r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r101, "attrs");
        super(r100, r101);
        this.f70767k = UtilityKotlinExtentionsKt.i(10);
        LayoutInflater.from(r100).inflate(R.layout.view_preview_progress, this);
        this.f70757a = findViewById(R.id.progress_view);
        this.f70758b = findViewById(R.id.progress_container);
        this.f70759c = (TextView) findViewById(R.id.tv_target_time);
        setOnTouchListener(new a(this));
    }
}
