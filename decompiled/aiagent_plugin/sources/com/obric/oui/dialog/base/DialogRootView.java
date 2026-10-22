package com.obric.oui.dialog.base;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import com.obric.oui.common.util.g;
import com.obric.oui.dialog.alert.view.RadiusLayout;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.h.b.h;
import d.h.b.o;

/* JADX INFO: compiled from: DialogRootView.kt */
/* JADX INFO: loaded from: classes4.dex */
public final class DialogRootView extends RadiusLayout {
    public DialogRootView(Context r7) {
        Context r1 = (Context) ZeusTransformUtils.wrapperContextForParams(r7, Context.class, "com.obric.aiagent.plugin");
        o.e(r1, "context");
        this(r1, null, 0, 6, null);
    }

    public DialogRootView(Context r9, AttributeSet r10) {
        Context r3 = (Context) ZeusTransformUtils.wrapperContextForParams(r9, Context.class, "com.obric.aiagent.plugin");
        AttributeSet r4 = (AttributeSet) ZeusTransformUtils.wrapperContextForParams(r10, AttributeSet.class, "com.obric.aiagent.plugin");
        o.e(r3, "context");
        this(r3, r4, 0, 4, null);
    }

    public /* synthetic */ DialogRootView(Context r2, AttributeSet r3, int r4, int r5, h r6) {
        Context r7 = (Context) ZeusTransformUtils.wrapperContextForParams(r2, Context.class, "com.obric.aiagent.plugin");
        AttributeSet r8 = (AttributeSet) ZeusTransformUtils.wrapperContextForParams(r3, AttributeSet.class, "com.obric.aiagent.plugin");
        if ((r5 & 2) == 0) goto L6;
        r8 = null;
    L6:
        if ((r5 & 4) == 0) goto L8;
        r4 = 0;
    L8:
        this(r7, r8, r4);
    }

    public DialogRootView(Context r3, AttributeSet r4, int r5) {
        Context r6 = (Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.aiagent.plugin");
        AttributeSet r7 = (AttributeSet) ZeusTransformUtils.wrapperContextForParams(r4, AttributeSet.class, "com.obric.aiagent.plugin");
        o.e(r6, "context");
        super(r6, r7, r5);
    }

    @Override // com.obric.oui.dialog.alert.view.RadiusLayout, android.widget.FrameLayout, android.view.View
    public void onMeasure(int r8, int r9) {
        Context r0 = (Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(getContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin");
        o.c(r0, "context");
        int r1 = (int) (((double) g.b(r0)) * 0.9d);
        int r3 = View.MeasureSpec.getSize(r9);
        int r10 = View.MeasureSpec.getMode(r9);
        if (r10 == Integer.MIN_VALUE) goto L7;
        if (r10 == 0) goto L6;
        int r11 = View.MeasureSpec.makeMeasureSpec(Math.min(r3, r1), 1073741824);
    L9:
        if (View.MeasureSpec.getMode(r8) != Integer.MIN_VALUE) goto L11;
        Context r12 = (Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(getContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin");
        o.c(r12, "context");
        r8 = View.MeasureSpec.makeMeasureSpec(g.a(r12), 1073741824);
    L11:
        super.onMeasure(r8, r11);
        return;
    L6:
        r11 = View.MeasureSpec.makeMeasureSpec(r1, Integer.MIN_VALUE);
        goto L9
    L7:
        r11 = View.MeasureSpec.makeMeasureSpec(Math.min(r3, r1), Integer.MIN_VALUE);
        goto L9
    }
}
