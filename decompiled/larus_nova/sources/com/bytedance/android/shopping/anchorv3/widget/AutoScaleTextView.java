package com.bytedance.android.shopping.anchorv3.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Paint;
import android.util.AttributeSet;
import androidx.appcompat.widget.AppCompatTextView;
import com.larus.nova.R;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes12.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\u0018\u00002\u00020\u0001B'\b\u0007\u0012\u0006\u0010\u0007\u001a\u00020\u0006\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\b\u0012\b\b\u0002\u0010\u000b\u001a\u00020\n¢\u0006\u0004\b\f\u0010\rJ\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002¨\u0006\u000e"}, d2 = {"Lcom/bytedance/android/shopping/anchorv3/widget/AutoScaleTextView;", "Landroidx/appcompat/widget/AppCompatTextView;", "", "minTextSize", "", "setMinTextSize", "Landroid/content/Context;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/util/AttributeSet;", "attrs", "", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "ec-shopping-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class AutoScaleTextView extends AppCompatTextView {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public float f165585a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public float f165586b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public Paint f165587c;

    public AutoScaleTextView(Context r100) {
        AttributeSet r101 = null;
        this(r100, r101, 6, 0);
    }

    public AutoScaleTextView(Context r100, AttributeSet r101) {
        this(r100, r101, 4, 0);
    }

    public final void setMinTextSize(float r100) {
        this.f165586b = r100;
    }

    public final void x(String r100, int r101) {
        if (r101 > 0) goto L4;
        return;
    L4:
        if (r100 != null) goto L6;
    L9:
        boolean r102 = true;
    L10:
        if (r102 == true) goto L47;
        int r103 = (r101 - getPaddingLeft()) - getPaddingRight();
        Paint r104 = this.f165587c;
        if (r104 != null) goto L15;
        Intrinsics.throwUninitializedPropertyAccessException("textPaint");
    L15:
        r104.set(getPaint());
        Paint r105 = this.f165587c;
        if (r105 != null) goto L18;
        Intrinsics.throwUninitializedPropertyAccessException("textPaint");
    L18:
        r105.setTextSize(this.f165585a);
        Paint r106 = this.f165587c;
        if (r106 != null) goto L21;
        Intrinsics.throwUninitializedPropertyAccessException("textPaint");
    L21:
        float r107 = r103;
        if (r106.measureText(r100) > r107) goto L25;
        setTextSize(0, this.f165585a);
        return;
    L25:
        float r108 = this.f165586b;
        float r109 = this.f165585a;
    L27:
        if ((r109 - r108) <= 0.5f) goto L38;
        float r110 = (r109 + r108) / 2;
        Paint r111 = this.f165587c;
        if (r111 != null) goto L31;
        Intrinsics.throwUninitializedPropertyAccessException("textPaint");
    L31:
        r111.setTextSize(r110);
        Paint r112 = this.f165587c;
        if (r112 != null) goto L35;
        Intrinsics.throwUninitializedPropertyAccessException("textPaint");
    L35:
        if (r112.measureText(r100) >= r107) goto L36;
        r108 = r110;
        goto L27
    L36:
        r109 = r110;
        goto L27
    L38:
        setTextSize(0, r108);
        return;
    L47:
        return;
    L6:
        if (r100.length() == 0) goto L9;
        r102 = false;
        goto L10
    }

    public AutoScaleTextView(Context r100, AttributeSet r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r101, r102);
        TypedArray r103 = getContext().obtainStyledAttributes(r101, new int[]{R.attr.astv_minTextSize});
        this.f165586b = r103.getDimension(0, 10.0f);
        this.f165587c = new Paint();
        r103.recycle();
        this.f165585a = getTextSize();
    }

    public /* synthetic */ AutoScaleTextView(Context r100, AttributeSet r101, int r102, int r103) {
        if ((r102 & 2) == 0) goto L5;
        r101 = null;
    L5:
        this(r100, r101, 0);
    }

    @Override // android.view.View
    public final void onSizeChanged(int r100, int r101, int r102, int r103) {
        if (r100 == r102) goto L5;
        x(getText().toString(), r100);
        return;
    }

    @Override // androidx.appcompat.widget.AppCompatTextView, android.widget.TextView
    public final void onTextChanged(CharSequence r100, int r101, int r102, int r103) {
        Intrinsics.checkNotNullParameter(r100, "text");
        x(r100.toString(), getWidth());
    }
}
