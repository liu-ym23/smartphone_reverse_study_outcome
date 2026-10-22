package com.obric.oui.popover;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.LinearLayout;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.h.b.h;
import d.h.b.o;

/* JADX INFO: compiled from: PopoverLinearLayout.kt */
/* JADX INFO: loaded from: classes4.dex */
public class PopoverLinearLayout extends LinearLayout {
    /* JADX WARN: Multi-variable type inference failed */
    public PopoverLinearLayout(Context r3) {
        Context r4 = (Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.aiagent.plugin");
        o.e(r4, "context");
        this(r4, null, 2, 0 == true ? 1 : 0);
    }

    public /* synthetic */ PopoverLinearLayout(Context r2, AttributeSet r3, int r4, h r5) {
        Context r6 = (Context) ZeusTransformUtils.wrapperContextForParams(r2, Context.class, "com.obric.aiagent.plugin");
        AttributeSet r7 = (AttributeSet) ZeusTransformUtils.wrapperContextForParams(r3, AttributeSet.class, "com.obric.aiagent.plugin");
        if ((r4 & 2) == 0) goto L5;
        r7 = null;
    L5:
        this(r6, r7);
    }

    public PopoverLinearLayout(Context r3, AttributeSet r4) {
        Context r5 = (Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.aiagent.plugin");
        AttributeSet r6 = (AttributeSet) ZeusTransformUtils.wrapperContextForParams(r4, AttributeSet.class, "com.obric.aiagent.plugin");
        o.e(r5, "context");
        super(r5, r6);
    }

    @Override // android.view.View
    public void setPressed(boolean r1) {
        super.setPressed(r1);
        if (r1 == false) goto L5;
        setAlpha(0.66f);
        return;
    L5:
        setAlpha(1.0f);
    }
}
