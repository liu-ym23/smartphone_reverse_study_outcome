package com.obric.oui.forms;

import android.content.Context;
import android.util.AttributeSet;
import androidx.appcompat.widget.AppCompatEditText;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.h.b.h;
import d.h.b.o;

/* JADX INFO: compiled from: OFormEditText.kt */
/* JADX INFO: loaded from: classes4.dex */
public final class OFormEditText extends AppCompatEditText {
    private boolean isBottomFading;
    private boolean isLeftFading;
    private boolean isRightFading;
    private boolean isTopFading;

    public OFormEditText(Context r7) {
        Context r1 = (Context) ZeusTransformUtils.wrapperContextForParams(r7, Context.class, "com.obric.aiagent.plugin");
        o.e(r1, "context");
        this(r1, null, 0, 6, null);
    }

    public OFormEditText(Context r9, AttributeSet r10) {
        Context r3 = (Context) ZeusTransformUtils.wrapperContextForParams(r9, Context.class, "com.obric.aiagent.plugin");
        AttributeSet r4 = (AttributeSet) ZeusTransformUtils.wrapperContextForParams(r10, AttributeSet.class, "com.obric.aiagent.plugin");
        o.e(r3, "context");
        this(r3, r4, 0, 4, null);
    }

    public /* synthetic */ OFormEditText(Context r2, AttributeSet r3, int r4, int r5, h r6) {
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

    public OFormEditText(Context r3, AttributeSet r4, int r5) {
        Context r6 = (Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.aiagent.plugin");
        AttributeSet r7 = (AttributeSet) ZeusTransformUtils.wrapperContextForParams(r4, AttributeSet.class, "com.obric.aiagent.plugin");
        o.e(r6, "context");
        super(r6, r7, r5);
    }

    public final boolean isLeftFading() {
        return this.isLeftFading;
    }

    public final void setLeftFading(boolean r1) {
        this.isLeftFading = r1;
    }

    public final boolean isRightFading() {
        return this.isRightFading;
    }

    public final void setRightFading(boolean r1) {
        this.isRightFading = r1;
    }

    public final boolean isTopFading() {
        return this.isTopFading;
    }

    public final void setTopFading(boolean r1) {
        this.isTopFading = r1;
    }

    public final boolean isBottomFading() {
        return this.isBottomFading;
    }

    public final void setBottomFading(boolean r1) {
        this.isBottomFading = r1;
    }

    public static /* synthetic */ void setTextFading$default(OFormEditText r7, boolean r8, boolean r9, boolean r10, boolean r11, int r12, int r13, Object r14) {
        if ((r13 & 1) == 0) goto L5;
        boolean r2 = false;
    L7:
        if ((r13 & 2) == 0) goto L9;
        boolean r3 = false;
    L11:
        if ((r13 & 4) == 0) goto L13;
        boolean r4 = false;
    L15:
        if ((r13 & 8) == 0) goto L17;
        boolean r5 = false;
    L18:
        r7.setTextFading(r2, r3, r4, r5, r12);
        return;
    L17:
        r5 = r11;
        goto L18
    L13:
        r4 = r10;
        goto L15
    L9:
        r3 = r9;
        goto L11
    L5:
        r2 = r8;
        goto L7
    }

    public final void setTextFading(boolean r1, boolean r2, boolean r3, boolean r4, int r5) {
        setFadingEdgeLength(r5);
        this.isLeftFading = r1;
        this.isTopFading = r2;
        this.isRightFading = r3;
        this.isBottomFading = r4;
        boolean r6 = false;
        if (r1 == true) goto L7;
        if (r3 == true) goto L7;
        boolean r7 = false;
    L8:
        setHorizontalFadingEdgeEnabled(r7);
        if (this.isTopFading == false) goto L11;
    L12:
        r6 = true;
    L13:
        setVerticalFadingEdgeEnabled(r6);
        return;
    L11:
        if (this.isBottomFading == false) goto L13;
    L7:
        r7 = true;
        goto L8
    }

    @Override // android.widget.TextView, android.view.View
    public float getLeftFadingEdgeStrength() {
        if (this.isLeftFading == true) goto L7;
        return 0.0f;
    L7:
        return super.getLeftFadingEdgeStrength();
    }

    @Override // android.widget.TextView, android.view.View
    public float getRightFadingEdgeStrength() {
        if (this.isRightFading == true) goto L7;
        return 0.0f;
    L7:
        return super.getRightFadingEdgeStrength();
    }

    @Override // android.view.View
    public float getTopFadingEdgeStrength() {
        if (this.isTopFading == true) goto L7;
        return 0.0f;
    L7:
        return super.getTopFadingEdgeStrength();
    }

    @Override // android.view.View
    public float getBottomFadingEdgeStrength() {
        if (this.isBottomFading == true) goto L7;
        return 0.0f;
    L7:
        return super.getBottomFadingEdgeStrength();
    }
}
