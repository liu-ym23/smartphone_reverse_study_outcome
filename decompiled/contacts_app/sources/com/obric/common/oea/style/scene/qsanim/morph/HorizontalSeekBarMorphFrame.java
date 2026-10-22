package com.obric.common.oea.style.scene.qsanim.morph;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.widget.SeekBar;
import com.obric.common.oea.foundation.util.OEALogger;
import com.obric.common.oea.style.scene.qsanim.common.AnimViewParams;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: HorizontalSeekBarMorphFrame.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\t\b\u0016\u0018\u00002\u00020\u0001B%\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\u0010\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000eH\u0016J\b\u0010\u000f\u001a\u00020\fH\u0016J\u0010\u0010\u0010\u001a\u00020\u000e2\u0006\u0010\u0011\u001a\u00020\u0012H\u0016J<\u0010\u0013\u001a\u00020\f2\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u00072\u0006\u0010\u0017\u001a\u00020\u00072\u0006\u0010\u0018\u001a\u00020\u000e2\b\b\u0002\u0010\u0019\u001a\u00020\u000e2\b\b\u0002\u0010\u001a\u001a\u00020\u000eH\u0007J\b\u0010\u001b\u001a\u00020\fH\u0014J\u0010\u0010\u001c\u001a\u00020\f2\u0006\u0010\u001d\u001a\u00020\u000eH\u0016R\u0010\u0010\t\u001a\u0004\u0018\u00010\nX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u001e"}, d2 = {"Lcom/obric/common/oea/style/scene/qsanim/morph/HorizontalSeekBarMorphFrame;", "Lcom/obric/common/oea/style/scene/qsanim/morph/SeekBarMorphParentLayout;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "viewMorphHelper", "Lcom/obric/common/oea/style/scene/qsanim/morph/ViewMorphAnimHelper;", "dragContinue", "", "force", "", "dragEnd", "getDeltaMove", "motionEvent", "Landroid/view/MotionEvent;", "init", "seekBar", "Landroid/widget/SeekBar;", "maxProgress", "minProgress", "morphFactor", "originalWidth", "originalHeight", "onDetachedFromWindow", "startDrag", "initForce", "style_standardRelease"}, k = 1, mv = {1, 4, 3})
public class HorizontalSeekBarMorphFrame extends SeekBarMorphParentLayout {
    private ViewMorphAnimHelper viewMorphHelper;

    public HorizontalSeekBarMorphFrame(Context r7) {
        this(r7, null, 0, 6, null);
    }

    public HorizontalSeekBarMorphFrame(Context r7, AttributeSet r8) {
        this(r7, r8, 0, 4, null);
    }

    public /* synthetic */ HorizontalSeekBarMorphFrame(Context r1, AttributeSet r2, int r3, int r4, DefaultConstructorMarker r5) {
        if ((r4 & 2) == 0) goto L6;
        r2 = null;
        AttributeSet r6 = (AttributeSet) null;
    L6:
        if ((r4 & 4) == 0) goto L8;
        r3 = 0;
    L8:
        this(r1, r2, r3);
    }

    public HorizontalSeekBarMorphFrame(Context r2, AttributeSet r3, int r4) {
        Intrinsics.checkNotNullParameter(r2, "context");
        super(r2, r3, r4);
    }

    public static /* synthetic */ void init$default(HorizontalSeekBarMorphFrame r9, SeekBar r10, int r11, int r12, float r13, float r14, float r15, int r16, Object r17) {
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
        Intrinsics.checkNotNullParameter(r20, "seekBar");
        super.init(r20, r21, r22, r23, false);
        ViewMorphAnimHelper r0 = this.viewMorphHelper;
        if (r0 == null) goto L5;
        AnimViewParams r1 = r0.getOriginalViewParams$style_standardRelease();
    L6:
        ViewMorphAnimHelper r2 = this.viewMorphHelper;
        if (r2 == null) goto L9;
        r2.release();
    L9:
        ViewMorphAnimHelper r3 = new ViewMorphAnimHelper(getSeekBarChild(), r23, 0.0f, r22, r21, Integer.MAX_VALUE, Integer.MAX_VALUE, false, false);
        this.viewMorphHelper = r3;
        if (r24 != 0.0f) goto L12;
    L14:
        OEALogger.e$default(OEALogger.INSTANCE, SeekBarMorphParentLayout.TAG, "init, originalWidth or originalHeight is 0, use last value", null, 4, null);
        if (r1 == null) goto L19;
        ViewMorphAnimHelper r4 = this.viewMorphHelper;
        if (r4 == null) goto L19;
        r4.setOriginalViewParams$style_standardRelease(r1);
    L19:
        ViewMorphAnimHelper r5 = this.viewMorphHelper;
        if (r5 == null) goto L23;
        r5.init();
        return;
    L23:
        return;
    L12:
        if (r25 == 0.0f) goto L14;
        r3.setOriginalViewSize(r24, r25);
        goto L19
    L5:
        r1 = null;
        goto L6
    }

    @Override // com.obric.common.oea.style.scene.qsanim.morph.SeekBarMorphParentLayout
    public void startDrag(float r2) {
        ViewMorphAnimHelper r1 = this.viewMorphHelper;
        if (r1 == null) goto L6;
        r1.startDrag(r2, 0.0f);
        return;
    }

    @Override // com.obric.common.oea.style.scene.qsanim.morph.SeekBarMorphParentLayout
    public void dragContinue(float r2) {
        ViewMorphAnimHelper r1 = this.viewMorphHelper;
        if (r1 == null) goto L6;
        r1.dragContinue(r2, 0.0f);
        return;
    }

    @Override // com.obric.common.oea.style.scene.qsanim.morph.SeekBarMorphParentLayout
    public void dragEnd() {
        ViewMorphAnimHelper r0 = this.viewMorphHelper;
        if (r0 == null) goto L6;
        r0.dragEnd();
        return;
    }

    @Override // com.obric.common.oea.style.scene.qsanim.morph.SeekBarMorphParentLayout
    public float getDeltaMove(MotionEvent r2) {
        Intrinsics.checkNotNullParameter(r2, "motionEvent");
        return r2.getX() - getLastTouchPoint().x;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        ViewMorphAnimHelper r0 = this.viewMorphHelper;
        if (r0 == null) goto L6;
        r0.cancelAnim();
        return;
    }
}
