package com.obric.oui.popover;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import com.obric.oui.layout.OUIFrameLayout;
import kotlin.Metadata;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.q;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0000\u0018\u00002\u00020\u0001B\u001b\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010\u0006J\u0018\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\nH\u0014¨\u0006\f"}, d2 = {"Lcom/obric/oui/popover/SingleChildFrameLayout;", "Lcom/obric/oui/layout/OUIFrameLayout;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "onMeasure", "", "widthMeasureSpec", "", "heightMeasureSpec", "OUI_standardRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class SingleChildFrameLayout extends OUIFrameLayout {
    /* JADX WARN: Multi-variable type inference failed */
    @JvmOverloads
    public SingleChildFrameLayout(@NotNull Context r10) {
        q.g(r10, "context");
        this(r10, null, 2, 0 == true ? 1 : 0);
    }

    @Override // com.obric.oui.layout.OUIFrameLayout, android.widget.FrameLayout, android.view.View
    public void onMeasure(int r10, int r11) {
        super.onMeasure(r10, r11);
        View r12 = getChildAt(0);
        if (r12 != null) goto L5;
        return;
    L5:
        int r13 = View.MeasureSpec.getMode(r10);
        int r14 = View.MeasureSpec.getSize(r10);
        int r15 = View.MeasureSpec.getMode(r11);
        int r16 = View.MeasureSpec.getSize(r11);
        int r17 = (r12.getMeasuredWidth() + getPaddingLeft()) + getPaddingRight();
        int r18 = (r12.getMeasuredHeight() + getPaddingTop()) + getPaddingBottom();
        if (r13 != Integer.MIN_VALUE) goto L9;
        if (r15 != Integer.MIN_VALUE) goto L9;
        setMeasuredDimension(r17, r18);
        return;
    L9:
        if (r13 != Integer.MIN_VALUE) goto L11;
        setMeasuredDimension(r17, r16);
        return;
    L11:
        if (r15 != Integer.MIN_VALUE) goto L13;
        setMeasuredDimension(r14, r18);
        return;
    L13:
        setMeasuredDimension(r14, r16);
    }

    public /* synthetic */ SingleChildFrameLayout(Context r10, AttributeSet r11, int r12, DefaultConstructorMarker r13) {
        if ((r12 & 2) == 0) goto L5;
        r11 = null;
    L5:
        this(r10, r11);
    }

    @JvmOverloads
    public SingleChildFrameLayout(@NotNull Context r10, @Nullable AttributeSet r11) {
        q.g(r10, "context");
        super(r10, r11, 0, null, 12, null);
    }
}
