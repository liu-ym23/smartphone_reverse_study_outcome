package com.obric.common.oea.style.scene.qsanim.morph;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.widget.SeekBar;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.h.b.h;
import d.h.b.o;

/* JADX INFO: compiled from: VerticalSeekBarMorphFrame.kt */
/* JADX INFO: loaded from: classes4.dex */
public class VerticalSeekBarMorphFrame extends SeekBarMorphParentLayout {
    private c viewMorphHelper;

    public VerticalSeekBarMorphFrame(Context r7) {
        this((Context) ZeusTransformUtils.wrapperContextForParams(r7, Context.class, "com.obric.aiagent.plugin"), null, 0, 6, null);
    }

    public VerticalSeekBarMorphFrame(Context r9, AttributeSet r10) {
        this((Context) ZeusTransformUtils.wrapperContextForParams(r9, Context.class, "com.obric.aiagent.plugin"), (AttributeSet) ZeusTransformUtils.wrapperContextForParams(r10, AttributeSet.class, "com.obric.aiagent.plugin"), 0, 4, null);
    }

    public /* synthetic */ VerticalSeekBarMorphFrame(Context r2, AttributeSet r3, int r4, int r5, h r6) {
        Context r7 = (Context) ZeusTransformUtils.wrapperContextForParams(r2, Context.class, "com.obric.aiagent.plugin");
        AttributeSet r8 = (AttributeSet) ZeusTransformUtils.wrapperContextForParams(r3, AttributeSet.class, "com.obric.aiagent.plugin");
        if ((r5 & 2) == 0) goto L6;
        r8 = (AttributeSet) ZeusTransformUtils.preCheckCast(null, AttributeSet.class, "com.obric.aiagent.plugin");
    L6:
        if ((r5 & 4) == 0) goto L8;
        r4 = 0;
    L8:
        this(r7, r8, r4);
    }

    public VerticalSeekBarMorphFrame(Context r3, AttributeSet r4, int r5) {
        Context r6 = (Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.aiagent.plugin");
        AttributeSet r7 = (AttributeSet) ZeusTransformUtils.wrapperContextForParams(r4, AttributeSet.class, "com.obric.aiagent.plugin");
        o.e(r6, "context");
        super(r6, r7, r5);
    }

    public static /* synthetic */ void init$default(VerticalSeekBarMorphFrame r9, SeekBar r10, int r11, int r12, float r13, float r14, float r15, int r16, Object r17) {
        if (r17 != null) goto L14;
        if ((r16 & 16) == 0) goto L6;
        float r7 = 0.0f;
    L8:
        if ((r16 & 32) == 0) goto L10;
        float r8 = 0.0f;
    L11:
        r9.init(r10, r11, r12, r13, r7, r8);
        return;
    L10:
        r8 = r15;
        goto L11
    L6:
        r7 = r14;
        goto L8
    L14:
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: init");
    }

    public final void init(SeekBar r20, int r21, int r22, float r23, float r24, float r25) {
        o.e(r20, "seekBar");
        super.init(r20, r21, r22, r23, true);
        c r0 = this.viewMorphHelper;
        if (r0 == null) goto L5;
        com.obric.common.oea.style.scene.qsanim.common.a r1 = r0.g();
    L6:
        c r2 = this.viewMorphHelper;
        if (r2 == null) goto L9;
        r2.d();
    L9:
        c r3 = new c((View) ZeusTransformUtils.preCheckCast(getSeekBarChild(), View.class, "com.obric.aiagent.plugin"), 0.0f, r23, Integer.MAX_VALUE, Integer.MAX_VALUE, r21, r22, true, false);
        this.viewMorphHelper = r3;
        if (r24 != 0.0f) goto L12;
    L15:
        com.obric.common.oea.foundation.b.c.a(com.obric.common.oea.foundation.b.c.f32472a, SeekBarMorphParentLayout.TAG, "init, originalWidth or originalHeight is 0, use last value", null, 4, null);
        if (r1 == null) goto L20;
        c r4 = this.viewMorphHelper;
        if (r4 == null) goto L20;
        r4.a(r1);
    L20:
        c r5 = this.viewMorphHelper;
        if (r5 == null) goto L24;
        r5.c();
        return;
    L24:
        return;
    L12:
        if (r25 == 0.0f) goto L15;
        if (r3 == null) goto L20;
        r3.c(r24, r25);
        goto L20
    L5:
        r1 = null;
        goto L6
    }

    @Override // com.obric.common.oea.style.scene.qsanim.morph.SeekBarMorphParentLayout
    public void startDrag(float r2) {
        c r1 = this.viewMorphHelper;
        if (r1 == null) goto L6;
        r1.a(0.0f, r2);
        return;
    }

    @Override // com.obric.common.oea.style.scene.qsanim.morph.SeekBarMorphParentLayout
    public void dragContinue(float r2) {
        c r1 = this.viewMorphHelper;
        if (r1 == null) goto L6;
        r1.b(0.0f, r2);
        return;
    }

    @Override // com.obric.common.oea.style.scene.qsanim.morph.SeekBarMorphParentLayout
    public void dragEnd() {
        c r0 = this.viewMorphHelper;
        if (r0 == null) goto L6;
        r0.f();
        return;
    }

    @Override // com.obric.common.oea.style.scene.qsanim.morph.SeekBarMorphParentLayout
    public float getDeltaMove(MotionEvent r2) {
        o.e(r2, "motionEvent");
        return r2.getY() - getLastTouchPoint().y;
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        c r0 = this.viewMorphHelper;
        if (r0 == null) goto L6;
        r0.e();
        return;
    }
}
