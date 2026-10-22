package com.bytedance.android.livesdk.livecommerce.playback.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Typeface;
import android.text.TextPaint;
import android.util.AttributeSet;
import android.view.ViewGroup;
import androidx.appcompat.widget.AppCompatTextView;
import com.larus.nova.R;
import com.ss.android.lark.utils.statistics.PerfLog;
import com.ss.android.ml.process.bl.MLConfigModel;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes10.dex */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B'\b\u0007\u0012\u0006\u0010\u000f\u001a\u00020\u000e\u0012\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u0010\u0012\b\b\u0002\u0010\u0012\u001a\u00020\u0002¢\u0006\u0004\b\u0013\u0010\u0014J\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002J\u0012\u0010\b\u001a\u00020\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0016J\u0010\u0010\n\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\u0002H\u0016J\u0012\u0010\r\u001a\u00020\u00042\b\u0010\f\u001a\u0004\u0018\u00010\u000bH\u0016¨\u0006\u0015"}, d2 = {"Lcom/bytedance/android/livesdk/livecommerce/playback/widget/StrokedTextView;", "Landroidx/appcompat/widget/AppCompatTextView;", "", "color", "", "setStrokeColor", "Landroid/graphics/Typeface;", MLConfigModel.MODEL_TYPE_TF, "setTypeface", "maxPixels", "setMaxWidth", "Landroid/view/ViewGroup$LayoutParams;", "params", "setLayoutParams", "Landroid/content/Context;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/util/AttributeSet;", "attrs", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "livecommerce_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class StrokedTextView extends AppCompatTextView {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final AppCompatTextView f150017a;

    public StrokedTextView(Context r100) {
        AttributeSet r101 = null;
        this(r100, r101, 6, 0);
    }

    public StrokedTextView(Context r100, AttributeSet r101) {
        this(r100, r101, 4, 0);
    }

    @Override // android.widget.TextView, android.view.View
    public final void onDraw(Canvas r100) {
        Intrinsics.checkNotNullParameter(r100, "canvas");
        AppCompatTextView r101 = this.f150017a;
        if (r101 == null) goto L5;
        r101.draw(r100);
    L5:
        super.onDraw(r100);
    }

    @Override // android.view.View
    public void setLayoutParams(ViewGroup.LayoutParams r100) {
        super.setLayoutParams(r100);
        AppCompatTextView r101 = this.f150017a;
        if (r101 == null) goto L6;
        r101.setLayoutParams(r100);
        return;
    }

    @Override // android.widget.TextView
    public void setMaxWidth(int r100) {
        super.setMaxWidth(r100);
        AppCompatTextView r101 = this.f150017a;
        if (r101 == null) goto L6;
        r101.setMaxWidth(r100);
        return;
    }

    public final void setStrokeColor(int r100) {
        AppCompatTextView r101 = this.f150017a;
        if (r101 == null) goto L6;
        r101.setTextColor(r100);
        return;
    }

    @Override // android.widget.TextView
    public void setTypeface(Typeface r100) {
        super.setTypeface(r100);
        AppCompatTextView r101 = this.f150017a;
        if (r101 == null) goto L6;
        r101.setTypeface(r100);
        return;
    }

    @Override // androidx.appcompat.widget.AppCompatTextView, android.widget.TextView, android.view.View
    public final void onMeasure(int r100, int r101) {
        super.onMeasure(r100, r101);
        AppCompatTextView r102 = this.f150017a;
        if (r102 == null) goto L5;
        CharSequence r103 = r102.getText();
    L6:
        if (r103 != null) goto L8;
    L9:
        AppCompatTextView r104 = this.f150017a;
        if (r104 == null) goto L12;
        r104.setText(getText());
    L12:
        postInvalidate();
    L13:
        AppCompatTextView r105 = this.f150017a;
        if (r105 == null) goto L17;
        r105.measure(r100, r101);
        return;
    L17:
        return;
    L8:
        if ((!Intrinsics.areEqual(r103, getText())) == false) goto L13;
    L5:
        r103 = null;
        goto L6
    }

    @Override // androidx.appcompat.widget.AppCompatTextView, android.widget.TextView
    public final void setTextSize(int r100, float r101) {
        super.setTextSize(r100, r101);
        AppCompatTextView r102 = this.f150017a;
        if (r102 == null) goto L6;
        r102.setTextSize(r100, r101);
        return;
    }

    public StrokedTextView(Context r100, AttributeSet r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r101, r102);
        AppCompatTextView r103 = new AppCompatTextView(r100, r101, r102);
        this.f150017a = r103;
        TypedArray r104 = r100.obtainStyledAttributes(r101, new int[]{R.attr.strokeColor, R.attr.strokeWidth});
        int r105 = r104.getColor(0, -16777216);
        float r106 = r104.getDimension(1, 1.0f);
        TextPaint r107 = r103.getPaint();
        if (r107 == null) goto L5;
        r107.setStrokeWidth(r106);
    L5:
        if (r107 == null) goto L7;
        r107.setStyle(Paint.Style.STROKE);
    L7:
        r103.setTextColor(r105);
        r103.setGravity(getGravity());
    }

    public /* synthetic */ StrokedTextView(Context r100, AttributeSet r101, int r102, int r103) {
        if ((r102 & 2) == 0) goto L5;
        r101 = null;
    L5:
        this(r100, r101, 0);
    }

    @Override // android.widget.TextView
    public final void setShadowLayer(float r100, float r101, float r102, int r103) {
        super.setShadowLayer(r100, r101, r102, r103);
        AppCompatTextView r104 = this.f150017a;
        if (r104 == null) goto L6;
        r104.setShadowLayer(r100, r101, r102, r103);
        return;
    }

    @Override // androidx.appcompat.widget.AppCompatTextView, android.widget.TextView, android.view.View
    public final void onLayout(boolean r100, int r101, int r102, int r103, int r104) {
        super.onLayout(r100, r101, r102, r103, r104);
        AppCompatTextView r105 = this.f150017a;
        if (r105 == null) goto L6;
        r105.layout(r101, r102, r103, r104);
        return;
    }
}
