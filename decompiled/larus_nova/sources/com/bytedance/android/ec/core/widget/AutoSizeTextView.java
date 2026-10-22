package com.bytedance.android.ec.core.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.core.widget.TextViewCompat;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes43.dex */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0016\u0018\u00002\u00020\u0001B'\b\u0007\u0012\u0006\u0010\n\u001a\u00020\t\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u000b\u0012\b\b\u0002\u0010\r\u001a\u00020\u0006¢\u0006\u0004\b\u000e\u0010\u000fJ\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002J\u000e\u0010\b\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006¨\u0006\u0010"}, d2 = {"Lcom/bytedance/android/ec/core/widget/AutoSizeTextView;", "Landroidx/appcompat/widget/AppCompatTextView;", "", "baseTextSize", "", "setBaseTextSize", "", "maxWidth", "setViewMaxWidth", "Landroid/content/Context;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/util/AttributeSet;", "attrs", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "ec-core_saasRelease"}, k = 1, mv = {1, 4, 3})
public class AutoSizeTextView extends AppCompatTextView {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public float f45863a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f45864b;

    public AutoSizeTextView(Context r100) {
        AttributeSet r101 = null;
        this(r100, r101, 6, 0);
    }

    public AutoSizeTextView(Context r100, AttributeSet r101) {
        this(r100, r101, 4, 0);
    }

    public final void setBaseTextSize(float r100) {
        this.f45863a = r100;
    }

    public final void setViewMaxWidth(int r100) {
        this.f45864b = r100;
    }

    @Override // androidx.appcompat.widget.AppCompatTextView, android.widget.TextView, android.view.View
    public final void onMeasure(int r100, int r101) {
        if (this.f45864b > 0) goto L5;
    L22:
        super.onMeasure(r100, r101);
        return;
    L5:
        if (TextViewCompat.getAutoSizeTextType(this) == 1) goto L22;
        int r102 = View.MeasureSpec.getMode(r100);
        int r103 = this.f45864b;
        int r104 = Integer.MAX_VALUE;
        if (r102 != 0) goto L9;
        int r105 = Integer.MAX_VALUE;
    L10:
        int r106 = Math.min(r103, r105);
        if (View.MeasureSpec.getMode(r101) == 0) goto L14;
        r104 = View.MeasureSpec.getSize(r101);
    L14:
        float r107 = this.f45863a;
        setTextSize(0, r107);
        super.onMeasure(View.MeasureSpec.makeMeasureSpec(0, 0), r101);
    L16:
        if (getMeasuredHeight() > r104) goto L20;
        if (getMeasuredWidth() > r106) goto L20;
        return;
    L20:
        if (r107 <= 0) goto L27;
        r107 = r107 - vf4.a.b(1);
        setTextSize(0, r107);
        super.onMeasure(View.MeasureSpec.makeMeasureSpec(0, 0), r101);
        goto L16
    L27:
        return;
    L9:
        r105 = View.MeasureSpec.getSize(r100);
        goto L10
    }

    public AutoSizeTextView(Context r100, AttributeSet r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r101, r102);
    }

    public /* synthetic */ AutoSizeTextView(Context r100, AttributeSet r101, int r102, int r103) {
        if ((r102 & 2) == 0) goto L5;
        r101 = null;
    L5:
        this(r100, r101, 0);
    }
}
