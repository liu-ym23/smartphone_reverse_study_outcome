package com.obric.oui.forms;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.widget.EditText;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.h.b.h;
import d.h.b.o;

/* JADX INFO: compiled from: AbsOInput.kt */
/* JADX INFO: loaded from: classes4.dex */
public abstract class AbsOInput extends ConstraintLayout {
    private boolean isInScrollView;
    private float lastScrollX;
    private float lastScrollY;

    public AbsOInput(Context r7) {
        Context r1 = (Context) ZeusTransformUtils.wrapperContextForParams(r7, Context.class, "com.obric.aiagent.plugin");
        o.e(r1, "context");
        this(r1, null, 0, 6, null);
    }

    public AbsOInput(Context r9, AttributeSet r10) {
        Context r3 = (Context) ZeusTransformUtils.wrapperContextForParams(r9, Context.class, "com.obric.aiagent.plugin");
        AttributeSet r4 = (AttributeSet) ZeusTransformUtils.wrapperContextForParams(r10, AttributeSet.class, "com.obric.aiagent.plugin");
        o.e(r3, "context");
        this(r3, r4, 0, 4, null);
    }

    public abstract EditText getInterEditText();

    public /* synthetic */ AbsOInput(Context r2, AttributeSet r3, int r4, int r5, h r6) {
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

    public AbsOInput(Context r3, AttributeSet r4, int r5) {
        Context r6 = (Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.aiagent.plugin");
        AttributeSet r7 = (AttributeSet) ZeusTransformUtils.wrapperContextForParams(r4, AttributeSet.class, "com.obric.aiagent.plugin");
        o.e(r6, "context");
        super(r6, r7, r5);
    }

    public final boolean isInScrollView() {
        return this.isInScrollView;
    }

    public final void setInScrollView(boolean r1) {
        this.isInScrollView = r1;
    }

    public static /* synthetic */ void setTextFading$default(AbsOInput r7, boolean r8, boolean r9, boolean r10, boolean r11, int r12, int r13, Object r14) {
        if (r14 != null) goto L22;
        if ((r13 & 1) == 0) goto L6;
        boolean r2 = false;
    L8:
        if ((r13 & 2) == 0) goto L10;
        boolean r3 = false;
    L12:
        if ((r13 & 4) == 0) goto L14;
        boolean r4 = false;
    L16:
        if ((r13 & 8) == 0) goto L18;
        boolean r5 = false;
    L19:
        r7.setTextFading(r2, r3, r4, r5, r12);
        return;
    L18:
        r5 = r11;
        goto L19
    L14:
        r4 = r10;
        goto L16
    L10:
        r3 = r9;
        goto L12
    L6:
        r2 = r8;
        goto L8
    L22:
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: setTextFading");
    }

    public final void setTextFading(boolean r7, boolean r8, boolean r9, boolean r10, int r11) {
        EditText r6 = getInterEditText();
        if (ZeusTransformUtils.instanceOf(r6, OEditText.class) == false) goto L5;
        ((OEditText) ZeusTransformUtils.preCheckCast(r6, OEditText.class, "com.obric.aiagent.plugin")).setTextFading(r7, r8, r9, r10, r11);
        return;
    L5:
        r6.setFadingEdgeLength(r11);
        boolean r12 = false;
        if (r7 == true) goto L10;
        if (r9 == true) goto L10;
        boolean r13 = false;
    L11:
        r6.setHorizontalFadingEdgeEnabled(r13);
        if (r8 == true) goto L14;
        if (r10 == true) goto L14;
    L15:
        r6.setVerticalFadingEdgeEnabled(r12);
        return;
    L14:
        r12 = true;
    L10:
        r13 = true;
        goto L11
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent r7) {
        if (r7 == null) goto L36;
        if (this.isInScrollView == false) goto L36;
        float r0 = r7.getX();
        float r1 = r7.getY();
        int r2 = r7.getAction();
        if (r2 != 0) goto L8;
        this.lastScrollY = r0;
        this.lastScrollY = r1;
        goto L36
    L8:
        if (r2 != 1) goto L10;
        super.requestDisallowInterceptTouchEvent(false);
        goto L36
    L10:
        if (r2 != 2) goto L12;
        EditText r3 = getInterEditText();
        if (r0 <= this.lastScrollX) goto L20;
        if (r3.canScrollHorizontally(-1) == false) goto L20;
    L31:
        super.requestDisallowInterceptTouchEvent(true);
    L32:
        this.lastScrollX = r0;
        this.lastScrollY = r1;
    L20:
        if (r0 >= this.lastScrollX) goto L24;
        if (r3.canScrollHorizontally(1) == true) goto L31;
    L24:
        if (r1 >= this.lastScrollY) goto L28;
        if (r3.canScrollVertically(1) == true) goto L31;
    L28:
        if (r1 <= this.lastScrollY) goto L32;
        if (r3.canScrollVertically(-1) == false) goto L32;
    L12:
        if (r2 != 3) goto L36;
        super.requestDisallowInterceptTouchEvent(false);
    L36:
        return super.dispatchTouchEvent(r7);
    }
}
