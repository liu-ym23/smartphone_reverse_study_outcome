package com.obric.oui.tag;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import com.bytedance.apm.constant.TraceStatsConsts;
import com.obric.oui.text.OTextView;
import kotlin.Metadata;
import kotlin.collections.ArraysKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;

/* JADX INFO: compiled from: OTextTag.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B%\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\u0010\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\fH\u0002J\b\u0010\u000b\u001a\u00020\fH\u0002J\b\u0010\r\u001a\u00020\nH\u0002J0\u0010\u000e\u001a\u00020\n2\u0006\u0010\u000f\u001a\u00020\f2\u0006\u0010\u0010\u001a\u00020\u00072\u0006\u0010\u0011\u001a\u00020\u00072\u0006\u0010\u0012\u001a\u00020\u00072\u0006\u0010\u0013\u001a\u00020\u0007H\u0014J\u0018\u0010\u0014\u001a\u00020\n2\u0006\u0010\u0015\u001a\u00020\u00072\u0006\u0010\u0016\u001a\u00020\u0007H\u0014J0\u0010\u0017\u001a\u00020\n2\b\u0010\u0010\u001a\u0004\u0018\u00010\u00182\b\u0010\u0011\u001a\u0004\u0018\u00010\u00182\b\u0010\u0012\u001a\u0004\u0018\u00010\u00182\b\u0010\u0013\u001a\u0004\u0018\u00010\u0018H\u0016J0\u0010\u0019\u001a\u00020\n2\b\u0010\u001a\u001a\u0004\u0018\u00010\u00182\b\u0010\u0011\u001a\u0004\u0018\u00010\u00182\b\u0010\u001b\u001a\u0004\u0018\u00010\u00182\b\u0010\u0013\u001a\u0004\u0018\u00010\u0018H\u0016¨\u0006\u001c"}, d2 = {"Lcom/obric/oui/tag/OTextTag;", "Lcom/obric/oui/text/OTextView;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "adjustPaddingStart", "", "hasStartDrawable", "", "initView", "onLayout", "changed", "left", "top", "right", "bottom", "onMeasure", "widthMeasureSpec", "heightMeasureSpec", "setCompoundDrawables", "Landroid/graphics/drawable/Drawable;", "setCompoundDrawablesRelative", "start", TraceStatsConsts.STATS_KEY_END, "OUI_standardRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class OTextTag extends OTextView {
    public OTextTag(Context r8) {
        Intrinsics.checkNotNullParameter(r8, "context");
        this(r8, null, 0, 6, null);
    }

    public OTextTag(Context r8, AttributeSet r9) {
        Intrinsics.checkNotNullParameter(r8, "context");
        this(r8, r9, 0, 4, null);
    }

    public /* synthetic */ OTextTag(Context r1, AttributeSet r2, int r3, int r4, DefaultConstructorMarker r5) {
        if ((r4 & 2) == 0) goto L6;
        r2 = null;
    L6:
        if ((r4 & 4) == 0) goto L8;
        r3 = 0;
    L8:
        this(r1, r2, r3);
    }

    public OTextTag(Context r9, AttributeSet r10, int r11) {
        Intrinsics.checkNotNullParameter(r9, "context");
        super(r9, r10, r11, null, 8, null);
        initView();
    }

    private final void initView() {
        ColorStateList r0 = ColorStateList.valueOf(getCurrentTextColor());
        Intrinsics.checkNotNullExpressionValue(r0, "valueOf(textColor)");
        setCompoundDrawableTintList(r0);
        adjustPaddingStart(hasStartDrawable());
    }

    @Override // com.obric.oui.text.OTextView, android.widget.TextView, android.view.View
    protected void onMeasure(int r1, int r2) {
        super.onMeasure(r1, r2);
    }

    @Override // com.obric.oui.text.OTextView, android.widget.TextView, android.view.View
    protected void onLayout(boolean r1, int r2, int r3, int r4, int r5) {
        super.onLayout(r1, r2, r3, r4, r5);
    }

    @Override // android.widget.TextView
    public void setCompoundDrawables(Drawable r1, Drawable r2, Drawable r3, Drawable r4) {
        super.setCompoundDrawables(r1, r2, r3, r4);
        if (r1 == null) goto L5;
        boolean r5 = true;
    L6:
        adjustPaddingStart(r5);
        return;
    L5:
        r5 = false;
        goto L6
    }

    @Override // android.widget.TextView
    public void setCompoundDrawablesRelative(Drawable r1, Drawable r2, Drawable r3, Drawable r4) {
        super.setCompoundDrawablesRelative(r1, r2, r3, r4);
        if (r1 == null) goto L5;
        boolean r5 = true;
    L6:
        adjustPaddingStart(r5);
        return;
    L5:
        r5 = false;
        goto L6
    }

    private final boolean hasStartDrawable() {
        Drawable[] r0 = getCompoundDrawables();
        Intrinsics.checkNotNullExpressionValue(r0, "getCompoundDrawables()");
        if (ArraysKt.getOrNull(r0, 0) != null) goto L6;
        Drawable[] r2 = getCompoundDrawablesRelative();
        Intrinsics.checkNotNullExpressionValue(r2, "getCompoundDrawablesRelative()");
        if (ArraysKt.getOrNull(r2, 0) != null) goto L6;
        return false;
    L6:
        return true;
    }

    private final void adjustPaddingStart(boolean r6) {
        int r0 = getPaddingTop();
        int r1 = getPaddingEnd();
        int r2 = getPaddingBottom();
        int r3 = RangesKt.coerceAtLeast(getCompoundDrawablePadding(), 0);
        if (r6 == false) goto L5;
        int r7 = RangesKt.coerceAtLeast(r1 - r3, 0);
    L7:
        if (r7 == getPaddingStart()) goto L10;
        setPaddingRelative(r7, r0, r1, r2);
        return;
    L10:
        return;
    L5:
        r7 = r1;
        goto L7
    }
}
