package com.bytedance.android.livesdk.chatroom.ui;

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
import com.ss.android.cert.manager.constants.BytedCertConstant;
import com.ss.android.lark.utils.statistics.PerfLog;
import com.ss.android.ml.process.bl.MLConfigModel;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes8.dex */
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\b\u0016\u0018\u00002\u00020\u0001B#\b\u0017\u0012\u0006\u0010\u0014\u001a\u00020\u0013\u0012\b\u0010\u0016\u001a\u0004\u0018\u00010\u0015\u0012\u0006\u0010\u0018\u001a\u00020\u0017¢\u0006\u0004\b\u0019\u0010\u001aB\u001b\b\u0016\u0012\u0006\u0010\u0014\u001a\u00020\u0013\u0012\b\u0010\u0016\u001a\u0004\u0018\u00010\u0015¢\u0006\u0004\b\u0019\u0010\u001bB\u0011\b\u0016\u0012\u0006\u0010\u0014\u001a\u00020\u0013¢\u0006\u0004\b\u0019\u0010\u001cJ\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0012\u0010\b\u001a\u00020\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0016J\u0010\u0010\u000b\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\tH\u0016R$\u0010\u0012\u001a\u0004\u0018\u00010\u00018\u0016@\u0016X\u0096\u000e¢\u0006\u0012\n\u0004\b\f\u0010\r\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011¨\u0006\u001d"}, d2 = {"Lcom/bytedance/android/livesdk/chatroom/ui/StrokeTextView;", "Landroidx/appcompat/widget/AppCompatTextView;", "", "size", "", "setTextSize", "Landroid/graphics/Typeface;", MLConfigModel.MODEL_TYPE_TF, "setTypeface", "Landroid/view/ViewGroup$LayoutParams;", "params", "setLayoutParams", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "Landroidx/appcompat/widget/AppCompatTextView;", "getOutlineTextView", "()Landroidx/appcompat/widget/AppCompatTextView;", "setOutlineTextView", "(Landroidx/appcompat/widget/AppCompatTextView;)V", "outlineTextView", "Landroid/content/Context;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/util/AttributeSet;", "attrs", "", "defStyle", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "(Landroid/content/Context;)V", "livecommonui_saasRelease"}, k = 1, mv = {1, 4, 3})
public class StrokeTextView extends AppCompatTextView {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public AppCompatTextView f112548a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public float f112549b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f112550c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public boolean f112551d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public boolean f112552e;

    public final void init() {
        if (this.f112549b <= 0) goto L18;
        this.f112551d = true;
        AppCompatTextView r100 = getOutlineTextView();
        if (r100 == null) goto L7;
        TextPaint r101 = r100.getPaint();
    L8:
        if (r101 == null) goto L10;
        r101.setStrokeWidth(this.f112549b);
    L10:
        if (r101 == null) goto L12;
        r101.setStyle(Paint.Style.STROKE);
    L12:
        AppCompatTextView r102 = getOutlineTextView();
        if (r102 == null) goto L15;
        r102.setTextColor(this.f112550c);
    L15:
        AppCompatTextView r103 = getOutlineTextView();
        if (r103 == null) goto L20;
        r103.setGravity(getGravity());
        return;
    L20:
        return;
    L7:
        r101 = null;
        goto L8
    L18:
        this.f112551d = false;
    }

    public AppCompatTextView getOutlineTextView() {
        return this.f112548a;
    }

    public StrokeTextView(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        this(r100, null);
    }

    @Override // android.widget.TextView, android.view.View
    public void onDraw(Canvas r100) {
        Intrinsics.checkNotNullParameter(r100, "canvas");
        if (this.f112551d == false) goto L7;
        AppCompatTextView r101 = getOutlineTextView();
        if (r101 == null) goto L7;
        r101.draw(r100);
    L7:
        super.onDraw(r100);
    }

    @Override // android.view.View
    public void setLayoutParams(ViewGroup.LayoutParams r100) {
        Intrinsics.checkNotNullParameter(r100, "params");
        super.setLayoutParams(r100);
        AppCompatTextView r101 = getOutlineTextView();
        if (r101 == null) goto L6;
        r101.setLayoutParams(r100);
        return;
    }

    public void setOutlineTextView(AppCompatTextView r100) {
        this.f112548a = r100;
    }

    @Override // android.widget.TextView
    public void setTextSize(float r100) {
        super.setTextSize(r100);
        AppCompatTextView r101 = getOutlineTextView();
        if (r101 == null) goto L5;
        r101.setTextSize(1, r100);
    L5:
        this.f112552e = true;
    }

    @Override // android.widget.TextView
    public void setTypeface(Typeface r100) {
        super.setTypeface(r100);
        AppCompatTextView r101 = getOutlineTextView();
        if (r101 == null) goto L6;
        r101.setTypeface(r100);
        return;
    }

    public StrokeTextView(Context r100, AttributeSet r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        this(r100, r101, 0);
    }

    @Override // androidx.appcompat.widget.AppCompatTextView, android.widget.TextView, android.view.View
    public final void onMeasure(int r100, int r101) {
        super.onMeasure(r100, r101);
        if (this.f112551d == false) goto L17;
        AppCompatTextView r102 = getOutlineTextView();
        if (r102 == null) goto L7;
        CharSequence r103 = r102.getText();
    L9:
        if ((!Intrinsics.areEqual(r103, getText())) == false) goto L17;
        AppCompatTextView r104 = getOutlineTextView();
        if (r104 == null) goto L13;
        r104.setText(getText());
    L13:
        postInvalidate();
        AppCompatTextView r105 = getOutlineTextView();
        if (r105 == null) goto L22;
        r105.measure(r100, r101);
        return;
    L22:
        return;
    L7:
        r103 = null;
    L17:
        if (this.f112552e == false) goto L24;
        AppCompatTextView r106 = getOutlineTextView();
        if (r106 == null) goto L25;
        r106.measure(r100, r101);
        return;
    L25:
        return;
    }

    @Override // androidx.appcompat.widget.AppCompatTextView, android.widget.TextView
    public final void setTextSize(int r100, float r101) {
        super.setTextSize(r100, r101);
        AppCompatTextView r102 = getOutlineTextView();
        if (r102 == null) goto L5;
        r102.setTextSize(r100, r101);
    L5:
        this.f112552e = true;
    }

    @Override // androidx.appcompat.widget.AppCompatTextView, android.widget.TextView
    public final void setTypeface(Typeface r100, int r101) {
        super.setTypeface(r100, r101);
        AppCompatTextView r102 = getOutlineTextView();
        if (r102 == null) goto L6;
        r102.setTypeface(r100, r101);
        return;
    }

    public final void x(float r100, int r101) {
        this.f112549b = r100;
        this.f112550c = r101;
        init();
    }

    public StrokeTextView(Context r100, AttributeSet r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r101, r102);
        if (r101 == null) goto L8;
        TypedArray r103 = r100.obtainStyledAttributes(r101, new int[]{R.attr.stroke_color, R.attr.stroke_width, R.attr.ttlive_stroke_color, R.attr.ttlive_stroke_width}, r102, 0);
        if (r103 != null) goto L7;
        return;
    L7:
        this.f112549b = r103.getFloat(3, 0.0f);
        this.f112550c = r103.getColor(2, getResources().getColor(R.color.ttlive_white));
    L8:
        setOutlineTextView(new AppCompatTextView(r100, r101, r102));
        init();
    }

    @Override // android.widget.TextView, android.view.View
    public final void setPadding(int r100, int r101, int r102, int r103) {
        super.setPadding(r100, r101, r102, r103);
        AppCompatTextView r104 = getOutlineTextView();
        if (r104 == null) goto L6;
        r104.setPadding(r100, r101, r102, r103);
        return;
    }

    @Override // androidx.appcompat.widget.AppCompatTextView, android.widget.TextView, android.view.View
    public final void onLayout(boolean r100, int r101, int r102, int r103, int r104) {
        super.onLayout(r100, r101, r102, r103, r104);
        if (this.f112551d == false) goto L8;
        AppCompatTextView r105 = getOutlineTextView();
        if (r105 == null) goto L9;
        r105.layout(r101, r102, r103, r104);
        return;
    L9:
        return;
    }
}
