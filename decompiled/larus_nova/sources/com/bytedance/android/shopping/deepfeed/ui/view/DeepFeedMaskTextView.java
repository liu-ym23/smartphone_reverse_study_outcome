package com.bytedance.android.shopping.deepfeed.ui.view;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.LinearGradient;
import android.graphics.Paint;
import android.graphics.Shader;
import android.util.AttributeSet;
import android.util.TypedValue;
import androidx.appcompat.widget.AppCompatTextView;
import com.larus.nova.R;
import com.obric.assistant.interaction.impl.window.WindowDisplayMetricsOverride;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;

/* JADX INFO: loaded from: classes13.dex */
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B'\b\u0007\u0012\u0006\u0010\u0012\u001a\u00020\u0011\u0012\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u0013\u0012\b\b\u0002\u0010\u0015\u001a\u00020\u0002¢\u0006\u0004\b\u0016\u0010\u0017J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0016J\u000e\u0010\n\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\bJ\u000e\u0010\u000b\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\bJ\u000e\u0010\u000e\u001a\u00020\u00042\u0006\u0010\r\u001a\u00020\fJ\u000e\u0010\u0010\u001a\u00020\u00042\u0006\u0010\u000f\u001a\u00020\f¨\u0006\u0018"}, d2 = {"Lcom/bytedance/android/shopping/deepfeed/ui/view/DeepFeedMaskTextView;", "Landroidx/appcompat/widget/AppCompatTextView;", "", "color", "", "setTextColor", "Landroid/content/res/ColorStateList;", "colors", "", "enabled", "setMaskEnabled", "setArrowEnabled", "", "lengthPx", "setMaskLengthPx", "lengthDp", "setMaskLengthDp", "Landroid/content/Context;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/util/AttributeSet;", "attrs", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "ec-shopping-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class DeepFeedMaskTextView extends AppCompatTextView {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public boolean f173886a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public boolean f173887b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public float f173888c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public LinearGradient f173889d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public float f173890e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public int f173891f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final Paint f173892g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public int f173893h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public int f173894i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public int f173895j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public int f173896k;

    public DeepFeedMaskTextView(Context r100) {
        AttributeSet r101 = null;
        this(r100, r101, 6, 0);
    }

    public DeepFeedMaskTextView(Context r100, AttributeSet r101) {
        this(r100, r101, 4, 0);
    }

    public final void y() {
        this.f173889d = null;
        this.f173890e = -1.0f;
        this.f173891f = 0;
        invalidate();
    }

    public final void x() {
        int r100 = this.f173893h;
        int r101 = this.f173894i;
        int r102 = this.f173895j;
        if (this.f173887b == true) goto L5;
        int r103 = 0;
    L6:
        super.setPadding(r100, r101, r102 + r103, this.f173896k);
        return;
    L5:
        Resources r104 = getResources();
        float r105 = TypedValue.applyDimension(1, 12.0f, WindowDisplayMetricsOverride.apply(r104, r104.getDisplayMetrics()));
        Resources r106 = getResources();
        r103 = (int) (r105 + TypedValue.applyDimension(1, 6.0f, WindowDisplayMetricsOverride.apply(r106, r106.getDisplayMetrics())));
        goto L6
    }

    @Override // android.widget.TextView, android.view.View
    public final void onDraw(Canvas r110) {
        Intrinsics.checkNotNullParameter(r110, "canvas");
        float r100 = RangesKt.coerceAtLeast((getWidth() - getPaddingLeft()) - getPaddingRight(), 0.0f);
        int r101 = getCurrentTextColor();
        if (this.f173886a == true) goto L5;
    L17:
        this.f173889d = null;
    L18:
        Shader r102 = getPaint().getShader();
        if (this.f173886a == true) goto L21;
    L23:
        super.onDraw(r110);
        getPaint().setShader(r102);
        if (this.f173887b == true) goto L26;
        return;
    L26:
        if (getWidth() > 0) goto L28;
        return;
    L28:
        if (getHeight() <= 0) goto L34;
        Resources r103 = getResources();
        float r104 = TypedValue.applyDimension(1, 12.0f, WindowDisplayMetricsOverride.apply(r103, r103.getDisplayMetrics()));
        float r105 = getWidth() - this.f173895j;
        float r111 = r105 - r104;
        float r112 = getHeight() / 2.0f;
        float r106 = r104 / 2.0f;
        this.f173892g.setColor(getCurrentTextColor());
        Paint r107 = this.f173892g;
        Resources r108 = getResources();
        r107.setStrokeWidth(TypedValue.applyDimension(1, 1.5f, WindowDisplayMetricsOverride.apply(r108, r108.getDisplayMetrics())));
        r110.drawLine(r111, r112 - r106, r105, r112, this.f173892g);
        r110.drawLine(r111, r112 + r106, r105, r112, this.f173892g);
        return;
    L34:
        return;
    L21:
        if (this.f173889d == null) goto L23;
        getPaint().setShader(this.f173889d);
        goto L23
    L5:
        if (r100 <= 0.0f) goto L17;
        if (this.f173888c <= 0.0f) goto L17;
        if (this.f173889d != null) goto L12;
    L16:
        this.f173889d = new LinearGradient(getPaddingLeft(), 0.0f, getWidth() - getPaddingRight(), 0.0f, new int[]{r101, r101, Color.argb(0, Color.red(r101), Color.green(r101), Color.blue(r101))}, new float[]{0.0f, RangesKt.coerceIn((r100 - RangesKt.coerceAtMost(this.f173888c, r100)) / r100, 0.0f, 1.0f), 1.0f}, Shader.TileMode.CLAMP);
        this.f173890e = r100;
        this.f173891f = r101;
        goto L18
    L12:
        if (this.f173890e != r100) goto L16;
        if (this.f173891f != r101) goto L16;
        goto L16
    }

    public final void setArrowEnabled(boolean r100) {
        if (this.f173887b != r100) goto L5;
        return;
    L5:
        this.f173887b = r100;
        x();
        y();
        requestLayout();
    }

    public final void setMaskEnabled(boolean r100) {
        if (this.f173886a != r100) goto L5;
        return;
    L5:
        this.f173886a = r100;
        y();
    }

    public final void setMaskLengthDp(float r100) {
        Resources r101 = getResources();
        setMaskLengthPx(TypedValue.applyDimension(1, r100, WindowDisplayMetricsOverride.apply(r101, r101.getDisplayMetrics())));
    }

    public final void setMaskLengthPx(float r100) {
        float r101 = RangesKt.coerceAtLeast(r100, 0.0f);
        if (this.f173888c != r101) goto L5;
        return;
    L5:
        this.f173888c = r101;
        y();
    }

    @Override // android.widget.TextView
    public void setTextColor(int r100) {
        super.setTextColor(r100);
        y();
    }

    @Override // android.widget.TextView
    public void setTextColor(ColorStateList r100) {
        super.setTextColor(r100);
        y();
    }

    public DeepFeedMaskTextView(Context r100, AttributeSet r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r101, r102);
        Resources r103 = getResources();
        this.f173888c = TypedValue.applyDimension(1, 48.0f, WindowDisplayMetricsOverride.apply(r103, r103.getDisplayMetrics()));
        this.f173890e = -1.0f;
        Paint r104 = new Paint(1);
        r104.setStyle(Paint.Style.STROKE);
        r104.setStrokeCap(Paint.Cap.ROUND);
        r104.setStrokeJoin(Paint.Join.ROUND);
        Unit r105 = Unit.INSTANCE;
        this.f173892g = r104;
        this.f173893h = getPaddingLeft();
        this.f173894i = getPaddingTop();
        this.f173895j = getPaddingRight();
        this.f173896k = getPaddingBottom();
        TypedArray r106 = r100.obtainStyledAttributes(r101, new int[]{R.attr.ec_mask_enabled, R.attr.ec_mask_length});
        this.f173886a = r106.getBoolean(0, false);
        Resources r107 = getResources();
        this.f173888c = r106.getDimension(1, TypedValue.applyDimension(1, 48.0f, WindowDisplayMetricsOverride.apply(r107, r107.getDisplayMetrics())));
        r106.recycle();
    }

    public /* synthetic */ DeepFeedMaskTextView(Context r100, AttributeSet r101, int r102, int r103) {
        if ((r102 & 2) == 0) goto L5;
        r101 = null;
    L5:
        this(r100, r101, 0);
    }

    @Override // android.widget.TextView, android.view.View
    public final void setPadding(int r100, int r101, int r102, int r103) {
        this.f173893h = r100;
        this.f173894i = r101;
        this.f173895j = r102;
        this.f173896k = r103;
        x();
    }
}
