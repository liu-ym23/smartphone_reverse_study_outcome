package com.bytedance.android.livesdk.livecommerce.view;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import androidx.appcompat.widget.LinearLayoutCompat;
import com.larus.nova.R;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes10.dex */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\f\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0016\u0018\u00002\u00020\u0001B'\b\u0007\u0012\u0006\u0010\u0010\u001a\u00020\u000f\u0012\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u0011\u0012\b\b\u0002\u0010\u0013\u001a\u00020\u0002¢\u0006\u0004\b\u0014\u0010\u0015R*\u0010\n\u001a\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u00028\u0006@FX\u0086\u000e¢\u0006\u0012\n\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR*\u0010\u000e\u001a\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u00028\u0006@FX\u0086\u000e¢\u0006\u0012\n\u0004\b\u000b\u0010\u0005\u001a\u0004\b\f\u0010\u0007\"\u0004\b\r\u0010\t¨\u0006\u0016"}, d2 = {"Lcom/bytedance/android/livesdk/livecommerce/view/ECMaxSizeLinearLayout;", "Landroidx/appcompat/widget/LinearLayoutCompat;", "", "value", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "I", "getMMaxWidth", "()I", "setMMaxWidth", "(I)V", "mMaxWidth", "b", "getMMaxHeight", "setMMaxHeight", "mMaxHeight", "Landroid/content/Context;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/util/AttributeSet;", "attrs", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "livecommerce_saasRelease"}, k = 1, mv = {1, 4, 3})
public class ECMaxSizeLinearLayout extends LinearLayoutCompat {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f153170a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f153171b;

    public ECMaxSizeLinearLayout(Context r100) {
        AttributeSet r101 = null;
        this(r100, r101, 6, 0);
    }

    public ECMaxSizeLinearLayout(Context r100, AttributeSet r101) {
        this(r100, r101, 4, 0);
    }

    public final int getMMaxHeight() {
        return this.f153171b;
    }

    public final int getMMaxWidth() {
        return this.f153170a;
    }

    @Override // androidx.appcompat.widget.LinearLayoutCompat, android.view.ViewGroup
    public /* bridge */ /* synthetic */ ViewGroup.LayoutParams generateLayoutParams(ViewGroup.LayoutParams r100) {
        return generateLayoutParams(r100);
    }

    public final void setMMaxHeight(int r100) {
        this.f153171b = r100;
        requestLayout();
    }

    public final void setMMaxWidth(int r100) {
        this.f153170a = r100;
        requestLayout();
    }

    @Override // androidx.appcompat.widget.LinearLayoutCompat, android.view.View
    public final void onMeasure(int r100, int r101) {
        int r102 = View.MeasureSpec.getSize(r100);
        int r103 = View.MeasureSpec.getSize(r101);
        int r104 = this.f153170a;
        if (r104 <= 0) goto L6;
        if (r104 >= r102) goto L6;
        int r105 = View.MeasureSpec.getMode(r100);
        r100 = View.MeasureSpec.makeMeasureSpec(this.f153170a, r105);
    L6:
        int r106 = this.f153171b;
        if (r106 <= 0) goto L10;
        if (r106 >= r103) goto L10;
        int r107 = View.MeasureSpec.getMode(r101);
        r101 = View.MeasureSpec.makeMeasureSpec(this.f153171b, r107);
    L10:
        super.onMeasure(r100, r101);
    }

    public ECMaxSizeLinearLayout(Context r100, AttributeSet r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r101, r102);
        TypedArray r103 = r100.obtainStyledAttributes(r101, new int[]{R.attr.maxHeight, R.attr.maxWidth}, r102, 0);
        setMMaxWidth(r103.getDimensionPixelSize(1, 0));
        setMMaxHeight(r103.getDimensionPixelSize(0, 0));
        r103.recycle();
    }

    public /* synthetic */ ECMaxSizeLinearLayout(Context r100, AttributeSet r101, int r102, int r103) {
        if ((r102 & 2) == 0) goto L5;
        r101 = null;
    L5:
        this(r100, r101, 0);
    }
}
