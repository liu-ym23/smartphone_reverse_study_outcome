package com.android.contacts.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ListView;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: ViewUtils.kt */
/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u0007\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u001b\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010\u0006J\u0018\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\b2\u0006\u0010\u0017\u001a\u00020\bH\u0015R$\u0010\t\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\b@FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\rR$\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0007\u001a\u00020\u000e@FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013¨\u0006\u0018"}, d2 = {"Lcom/android/contacts/widget/FixHeightByItemCountListView;", "Landroid/widget/ListView;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "value", "", "itemHeight", "getItemHeight", "()I", "setItemHeight", "(I)V", "", "maxShowCount", "getMaxShowCount", "()F", "setMaxShowCount", "(F)V", "onMeasure", "", "widthMeasureSpec", "heightMeasureSpec", "app_QssiCnRelease"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class FixHeightByItemCountListView extends ListView {
    private int itemHeight;
    private float maxShowCount;

    /* JADX WARN: Multi-variable type inference failed */
    public FixHeightByItemCountListView(Context r3) {
        Intrinsics.checkNotNullParameter(r3, "context");
        this(r3, null, 2, 0 == true ? 1 : 0);
    }

    public /* synthetic */ FixHeightByItemCountListView(Context r1, AttributeSet r2, int r3, DefaultConstructorMarker r4) {
        if ((r3 & 2) == 0) goto L5;
        r2 = null;
    L5:
        this(r1, r2);
    }

    public FixHeightByItemCountListView(Context r2, AttributeSet r3) {
        Intrinsics.checkNotNullParameter(r2, "context");
        super(r2, r3);
        this.maxShowCount = 3.0f;
    }

    public final int getItemHeight() {
        return this.itemHeight;
    }

    public final void setItemHeight(int r1) {
        this.itemHeight = r1;
        requestLayout();
    }

    public final float getMaxShowCount() {
        return this.maxShowCount;
    }

    public final void setMaxShowCount(float r1) {
        this.maxShowCount = r1;
        requestLayout();
    }

    @Override // android.widget.ListView, android.widget.AbsListView, android.view.View
    protected void onMeasure(int r3, int r4) {
        if (this.itemHeight > 0) goto L5;
    L15:
        super.onMeasure(r3, r4);
        return;
    L5:
        if (this.maxShowCount <= 0.0f) goto L15;
        if (getAdapter() == null) goto L15;
        if (getAdapter().getCount() <= 0) goto L15;
        float r5 = getAdapter().getCount();
        float r0 = this.maxShowCount;
        if (r5 > r0) goto L14;
        r0 = getAdapter().getCount();
    L14:
        super.onMeasure(r3, View.MeasureSpec.makeMeasureSpec((((int) (r0 * this.itemHeight)) + getPaddingTop()) + getPaddingBottom(), 1073741824));
    }
}
