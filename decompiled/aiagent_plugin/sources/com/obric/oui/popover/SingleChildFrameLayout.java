package com.obric.oui.popover;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import com.obric.oui.layout.OUIFrameLayout;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.h.b.h;
import d.h.b.o;

/* JADX INFO: compiled from: SingleChildFrameLayout.kt */
/* JADX INFO: loaded from: classes4.dex */
public final class SingleChildFrameLayout extends OUIFrameLayout {
    /* JADX WARN: Multi-variable type inference failed */
    public SingleChildFrameLayout(Context r3) {
        Context r4 = (Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.aiagent.plugin");
        o.e(r4, "context");
        this(r4, null, 2, 0 == true ? 1 : 0);
    }

    public /* synthetic */ SingleChildFrameLayout(Context r2, AttributeSet r3, int r4, h r5) {
        Context r6 = (Context) ZeusTransformUtils.wrapperContextForParams(r2, Context.class, "com.obric.aiagent.plugin");
        AttributeSet r7 = (AttributeSet) ZeusTransformUtils.wrapperContextForParams(r3, AttributeSet.class, "com.obric.aiagent.plugin");
        if ((r4 & 2) == 0) goto L5;
        r7 = null;
    L5:
        this(r6, r7);
    }

    public SingleChildFrameLayout(Context r10, AttributeSet r11) {
        Context r3 = (Context) ZeusTransformUtils.wrapperContextForParams(r10, Context.class, "com.obric.aiagent.plugin");
        AttributeSet r4 = (AttributeSet) ZeusTransformUtils.wrapperContextForParams(r11, AttributeSet.class, "com.obric.aiagent.plugin");
        o.e(r3, "context");
        super(r3, r4, 0, null, 12, null);
    }

    @Override // com.obric.oui.layout.OUIFrameLayout, android.widget.FrameLayout, android.view.View
    public void onMeasure(int r6, int r7) {
        super.onMeasure(r6, r7);
        View r0 = getChildAt(0);
        if (r0 != null) goto L5;
        return;
    L5:
        int r1 = View.MeasureSpec.getMode(r6);
        int r8 = View.MeasureSpec.getSize(r6);
        int r2 = View.MeasureSpec.getMode(r7);
        int r9 = View.MeasureSpec.getSize(r7);
        int r3 = (r0.getMeasuredWidth() + getPaddingLeft()) + getPaddingRight();
        int r4 = (r0.getMeasuredHeight() + getPaddingTop()) + getPaddingBottom();
        if (r1 != Integer.MIN_VALUE) goto L9;
        if (r2 != Integer.MIN_VALUE) goto L9;
        setMeasuredDimension(r3, r4);
        return;
    L9:
        if (r1 != Integer.MIN_VALUE) goto L11;
        setMeasuredDimension(r3, r9);
        return;
    L11:
        if (r2 != Integer.MIN_VALUE) goto L13;
        setMeasuredDimension(r8, r4);
        return;
    L13:
        setMeasuredDimension(r8, r9);
    }
}
