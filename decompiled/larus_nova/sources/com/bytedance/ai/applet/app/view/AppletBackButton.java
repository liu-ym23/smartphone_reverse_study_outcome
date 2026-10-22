package com.bytedance.ai.applet.app.view;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.widget.ImageButton;
import android.widget.ImageView;
import androidx.appcompat.widget.AppCompatImageButton;
import com.larus.nova.R;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.math.MathKt;
import kotlin.ranges.RangesKt;

/* JADX INFO: loaded from: classes43.dex */
@Metadata(d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B'\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ\u0010\u0010\u0017\u001a\u00020\u00182\b\b\u0002\u0010\u0019\u001a\u00020\u001aJ\u0018\u0010\u001b\u001a\u00020\u00182\u0006\u0010\u001c\u001a\u00020\u00072\u0006\u0010\u001d\u001a\u00020\u0007H\u0014J\u0010\u0010\u001e\u001a\u00020\u00182\u0006\u0010\u001f\u001a\u00020 H\u0014J\b\u0010!\u001a\u00020\u0018H\u0002R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0011X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0011X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0015X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0015X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\""}, d2 = {"Lcom/bytedance/ai/applet/app/view/AppletBackButton;", "Landroidx/appcompat/widget/AppCompatImageButton;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "buttonSizePx", "", "cornerRadiusPx", "shadowPaddingPx", "shadowRadiusPx", "strokeWidthPx", "buttonRect", "Landroid/graphics/RectF;", "strokeRect", "appliedNightMode", "fillPaint", "Landroid/graphics/Paint;", "strokePaint", "refreshTheme", "", "force", "", "onMeasure", "widthMeasureSpec", "heightMeasureSpec", "onDraw", "canvas", "Landroid/graphics/Canvas;", "updateButtonRect", "ai-sdk_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class AppletBackButton extends AppCompatImageButton {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final float f34474a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final float f34475b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final float f34476c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final float f34477d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final RectF f34478e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final RectF f34479f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final Paint f34480g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final Paint f34481h;

    public AppletBackButton(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        AttributeSet r101 = null;
        this(r100, r101, 6, 0);
    }

    public AppletBackButton(Context r100, AttributeSet r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        this(r100, r101, 4, 0);
    }

    @Override // android.widget.ImageView, android.view.View
    public final void onDraw(Canvas r100) {
        Intrinsics.checkNotNullParameter(r100, "canvas");
        float r101 = Math.min(this.f34474a, Math.min(getWidth(), getHeight()));
        float r102 = (getWidth() - r101) / 2.0f;
        float r103 = (getHeight() - r101) / 2.0f;
        this.f34478e.set(r102, r103, r102 + r101, r101 + r103);
        RectF r104 = this.f34478e;
        float r105 = this.f34475b;
        r100.drawRoundRect(r104, r105, r105, this.f34480g);
        this.f34479f.set(this.f34478e);
        float r106 = this.f34477d / 2.0f;
        this.f34479f.inset(r106, r106);
        float r107 = RangesKt.coerceAtLeast(this.f34475b - r106, 0.0f);
        r100.drawRoundRect(this.f34479f, r107, r107, this.f34481h);
        super.onDraw(r100);
    }

    @Override // android.widget.ImageView, android.view.View
    public final void onMeasure(int r100, int r101) {
        int r102 = MathKt.roundToInt(this.f34474a + (this.f34476c * 2));
        setMeasuredDimension(ImageButton.resolveSize(r102, r100), ImageButton.resolveSize(r102, r101));
    }

    public AppletBackButton(Context r100, AttributeSet r101, int r110) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r101, r110);
        this.f34474a = getResources().getDimension(R.dimen.applet_back_button_size);
        this.f34475b = getResources().getDimension(R.dimen.applet_back_button_corner_radius);
        this.f34476c = getResources().getDimension(R.dimen.applet_back_button_shadow_padding);
        float r102 = getResources().getDimension(R.dimen.applet_back_button_shadow_radius);
        float r103 = getResources().getDimension(R.dimen.applet_back_button_stroke_width);
        this.f34477d = r103;
        this.f34478e = new RectF();
        this.f34479f = new RectF();
        Paint r111 = new Paint(1);
        r111.setStyle(Paint.Style.FILL);
        this.f34480g = r111;
        Paint r104 = new Paint(1);
        r104.setStyle(Paint.Style.STROKE);
        r104.setStrokeWidth(r103);
        this.f34481h = r104;
        setBackground(null);
        setClickable(true);
        setFocusable(true);
        setScaleType(ImageView.ScaleType.CENTER);
        setImageResource(R.drawable.ic_applet_nav_back);
        setLayerType(1, null);
        int r105 = getResources().getConfiguration().uiMode;
        r111.setColor(t2.a.c(getContext(), R.attr.applet_action_bar_bg_color, R.color.applet_app_action_bar_bg_color));
        r111.setShadowLayer(r102, 0.0f, 0.0f, t2.a.c(getContext(), R.attr.applet_action_bar_shadow_color, R.color.applet_app_action_bar_shadow_color));
        r104.setColor(t2.a.c(getContext(), R.attr.applet_action_bar_stroke_color, R.color.applet_app_action_bar_stroke_color));
        int r106 = t2.a.c(getContext(), R.attr.applet_action_bar_icon_color, R.color.neutral_100);
        int r107 = t2.a.c(getContext(), R.attr.applet_action_bar_icon_press_color, R.color.applet_app_action_bar_button_press);
        setImageTintList(new ColorStateList(new int[][]{new int[]{android.R.attr.state_pressed}, new int[0]}, new int[]{r107, r106}));
        setImageResource(R.drawable.ic_applet_nav_back);
        invalidate();
    }

    public /* synthetic */ AppletBackButton(Context r100, AttributeSet r101, int r102, int r103) {
        if ((r102 & 2) == 0) goto L5;
        r101 = null;
    L5:
        this(r100, r101, 0);
    }
}
