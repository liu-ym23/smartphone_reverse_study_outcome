package com.bytedance.common.utility.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.widget.TextView;
import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: loaded from: classes.dex */
public class DrawableCenterTextView extends TextView {
    public DrawableCenterTextView(Context r3) {
        super((Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.aiagent.plugin"));
    }

    public DrawableCenterTextView(Context r3, AttributeSet r4) {
        super((Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.aiagent.plugin"), (AttributeSet) ZeusTransformUtils.wrapperContextForParams(r4, AttributeSet.class, "com.obric.aiagent.plugin"));
    }

    public DrawableCenterTextView(Context r3, AttributeSet r4, int r5) {
        super((Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.aiagent.plugin"), (AttributeSet) ZeusTransformUtils.wrapperContextForParams(r4, AttributeSet.class, "com.obric.aiagent.plugin"), r5);
    }

    public DrawableCenterTextView(Context r3, AttributeSet r4, int r5, int r6) {
        super((Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.aiagent.plugin"), (AttributeSet) ZeusTransformUtils.wrapperContextForParams(r4, AttributeSet.class, "com.obric.aiagent.plugin"), r5, r6);
    }

    @Override // android.widget.TextView, android.view.View
    public void onDraw(Canvas r5) {
        Drawable[] r0 = getCompoundDrawables();
        if (r0 != null) goto L5;
    L17:
        super.onDraw(r5);
        return;
    L5:
        if (r0.length != 4) goto L17;
        Drawable r1 = r0[0];
        Drawable r2 = r0[2];
        if (r1 != null) goto L9;
        if (r2 == null) goto L17;
    L9:
        float r3 = getPaint().measureText(getText().toString());
        int r4 = getCompoundDrawablePadding();
        if (r1 == null) goto L12;
        int r6 = r1.getIntrinsicWidth();
    L13:
        float r7 = (r3 + r6) + r4;
        if (r1 == null) goto L16;
        setGravity(19);
        r5.translate((getWidth() - r7) / 2.0f, 0.0f);
        goto L17
    L16:
        setGravity(21);
        r5.translate((r7 - getWidth()) / 2.0f, 0.0f);
        goto L17
    L12:
        r6 = r2.getIntrinsicWidth();
        goto L13
    }
}
