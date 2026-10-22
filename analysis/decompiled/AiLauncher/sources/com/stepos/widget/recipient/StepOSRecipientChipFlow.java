package com.stepos.widget.recipient;

import android.content.Context;
import android.content.res.Resources;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import com.autonavi.aps.amapapi.config.Const;
import com.stepos.statsapp.v3.lib.plugin.constants.UxipConstants;
import com.stepos.widget.R;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0012\u0018\u00002\u00020\u0001B'\b\u0007\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0004\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\b\u0010\tJ\u001f\u0010\r\u001a\u00020\f2\u0006\u0010\n\u001a\u00020\u00062\u0006\u0010\u000b\u001a\u00020\u0006H\u0014¢\u0006\u0004\b\r\u0010\u000eJ7\u0010\u0015\u001a\u00020\f2\u0006\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u0011\u001a\u00020\u00062\u0006\u0010\u0012\u001a\u00020\u00062\u0006\u0010\u0013\u001a\u00020\u00062\u0006\u0010\u0014\u001a\u00020\u0006H\u0014¢\u0006\u0004\b\u0015\u0010\u0016R,\u0010\u0018\u001a\u00020\u00062\b\b\u0001\u0010\u0017\u001a\u00020\u00068G@FX\u0086\u000e¢\u0006\u0012\n\u0004\b\u0018\u0010\u0019\u001a\u0004\b\u001a\u0010\u001b\"\u0004\b\u001c\u0010\u001dR,\u0010\u001e\u001a\u00020\u00062\b\b\u0001\u0010\u0017\u001a\u00020\u00068G@FX\u0086\u000e¢\u0006\u0012\n\u0004\b\u001e\u0010\u0019\u001a\u0004\b\u001f\u0010\u001b\"\u0004\b \u0010\u001d¨\u0006!"}, d2 = {"Lcom/stepos/widget/recipient/StepOSRecipientChipFlow;", "Landroid/view/ViewGroup;", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attrs", "", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "widthMeasureSpec", "heightMeasureSpec", "LY8/t;", "onMeasure", "(II)V", "", "changed", "l", "t", "r", Const.INTENT_KEY_PKGNAME, "onLayout", "(ZIIII)V", UxipConstants.f30680s, "itemSpacing", "I", "getItemSpacing", "()I", "setItemSpacing", "(I)V", "lineSpacing", "getLineSpacing", "setLineSpacing", "StepOSWidget_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class StepOSRecipientChipFlow extends ViewGroup {
    private int itemSpacing;
    private int lineSpacing;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public StepOSRecipientChipFlow(Context context) {
        this(context, null, 0, 6, null);
        kotlin.jvm.internal.p.i(context, "context");
    }

    public final int getItemSpacing() {
        return this.itemSpacing;
    }

    public final int getLineSpacing() {
        return this.lineSpacing;
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onLayout(boolean changed, int l10, int t10, int r10, int b10) {
        boolean z10 = getLayoutDirection() == 1;
        int i10 = r10 - l10;
        int paddingStart = (i10 - getPaddingStart()) - getPaddingEnd();
        int paddingTop = getPaddingTop();
        int childCount = getChildCount();
        int i11 = 0;
        int iMax = 0;
        for (int i12 = 0; i12 < childCount; i12++) {
            View childAt = getChildAt(i12);
            if (childAt.getVisibility() != 8) {
                int measuredWidth = childAt.getMeasuredWidth();
                int measuredHeight = childAt.getMeasuredHeight();
                if (i11 > 0 && this.itemSpacing + i11 + measuredWidth > paddingStart) {
                    paddingTop += iMax + this.lineSpacing;
                    i11 = 0;
                    iMax = 0;
                }
                if (i11 > 0) {
                    i11 += this.itemSpacing;
                }
                int paddingEnd = z10 ? ((i10 - getPaddingEnd()) - i11) - measuredWidth : getPaddingStart() + i11;
                childAt.layout(paddingEnd, paddingTop, paddingEnd + measuredWidth, paddingTop + measuredHeight);
                i11 += measuredWidth;
                iMax = Math.max(iMax, measuredHeight);
            }
        }
    }

    @Override // android.view.View
    public void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        int size = View.MeasureSpec.getSize(widthMeasureSpec);
        int mode = View.MeasureSpec.getMode(widthMeasureSpec);
        int paddingStart = mode == 0 ? Integer.MAX_VALUE : (size - getPaddingStart()) - getPaddingEnd();
        int iMakeMeasureSpec = View.MeasureSpec.makeMeasureSpec(paddingStart, Integer.MIN_VALUE);
        int iMakeMeasureSpec2 = View.MeasureSpec.makeMeasureSpec(0, 0);
        int childCount = getChildCount();
        int iMax = 0;
        int i10 = 0;
        int i11 = 0;
        int iMax2 = 0;
        for (int i12 = 0; i12 < childCount; i12++) {
            View childAt = getChildAt(i12);
            if (childAt.getVisibility() != 8) {
                measureChild(childAt, iMakeMeasureSpec, iMakeMeasureSpec2);
                int measuredWidth = childAt.getMeasuredWidth();
                int measuredHeight = childAt.getMeasuredHeight();
                if (i10 <= 0 || this.itemSpacing + i10 + measuredWidth <= paddingStart) {
                    if (i10 > 0) {
                        i10 += this.itemSpacing;
                    }
                    i10 += measuredWidth;
                    iMax2 = Math.max(iMax2, measuredHeight);
                } else {
                    iMax = Math.max(iMax, i10);
                    i11 += iMax2 + this.lineSpacing;
                    iMax2 = measuredHeight;
                    i10 = measuredWidth;
                }
            }
        }
        int iMax3 = Math.max(iMax, i10);
        int i13 = i11 + iMax2;
        if (mode != 1073741824) {
            size = iMax3 + getPaddingStart() + getPaddingEnd();
        }
        setMeasuredDimension(size, View.resolveSize(i13 + getPaddingTop() + getPaddingBottom(), heightMeasureSpec));
    }

    public final void setItemSpacing(int i10) {
        if (i10 < 0) {
            throw new IllegalArgumentException(("itemSpacing must be >= 0 but was " + i10).toString());
        }
        if (this.itemSpacing == i10) {
            return;
        }
        this.itemSpacing = i10;
        requestLayout();
    }

    public final void setLineSpacing(int i10) {
        if (i10 < 0) {
            throw new IllegalArgumentException(("lineSpacing must be >= 0 but was " + i10).toString());
        }
        if (this.lineSpacing == i10) {
            return;
        }
        this.lineSpacing = i10;
        requestLayout();
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public StepOSRecipientChipFlow(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, null);
        kotlin.jvm.internal.p.i(context, "context");
    }

    public /* synthetic */ StepOSRecipientChipFlow(Context context, AttributeSet attributeSet, int i10, int i11, kotlin.jvm.internal.i iVar) {
        this(context, (i11 & 2) != 0 ? null : attributeSet, (i11 & 4) != 0 ? 0 : i10);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public StepOSRecipientChipFlow(Context context, AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
        kotlin.jvm.internal.p.i(context, "context");
        Resources resources = getResources();
        int i11 = R.dimen.stepos_recipient_chip_spacing;
        this.itemSpacing = resources.getDimensionPixelSize(i11);
        this.lineSpacing = getResources().getDimensionPixelSize(i11);
    }
}
