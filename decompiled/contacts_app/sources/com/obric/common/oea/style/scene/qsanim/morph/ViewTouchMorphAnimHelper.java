package com.obric.common.oea.style.scene.qsanim.morph;

import android.view.MotionEvent;
import android.view.View;
import com.obric.common.oea.foundation.util.OEALogger;
import com.obric.common.oea.style.scene.qsanim.common.KtExt;
import com.obric.oui.material.MaterialConfigFormatNames;
import com.ttnet.org.chromium.base.BaseSwitches;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.math.MathKt;
import kotlin.ranges.RangesKt;

/* JADX INFO: compiled from: ViewTouchMorphAnimHelper.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0016\u0018\u0000 \u00182\u00020\u0001:\u0001\u0018B=\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\u0006\u0010\t\u001a\u00020\b\u0012\u0006\u0010\n\u001a\u00020\b\u0012\u0006\u0010\u000b\u001a\u00020\b¢\u0006\u0002\u0010\fJ4\u0010\r\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\b0\u000e2\u0006\u0010\u000f\u001a\u00020\u00052\u0006\u0010\u0010\u001a\u00020\u00052\u0006\u0010\u0011\u001a\u00020\u00052\u0006\u0010\u0012\u001a\u00020\u0005H\u0014J\u001a\u0010\u0013\u001a\u00020\u00142\b\u0010\u0015\u001a\u0004\u0018\u00010\u00032\b\u0010\u0016\u001a\u0004\u0018\u00010\u0017R\u000e\u0010\u000b\u001a\u00020\bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\bX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0019"}, d2 = {"Lcom/obric/common/oea/style/scene/qsanim/morph/ViewTouchMorphAnimHelper;", "Lcom/obric/common/oea/style/scene/qsanim/morph/ViewMorphAnimHelper;", "view", "Landroid/view/View;", "morphFactorX", "", "morphFactorY", "leftMorphStartPoint", "", "rightMorphStartPoint", "upMorphStartPoint", "downMorphStartPoint", "(Landroid/view/View;FFIIII)V", "calculateNewSize", "Lkotlin/Pair;", MaterialConfigFormatNames.X, MaterialConfigFormatNames.Y, "dx", "dy", "handleTouchEvent", "", BaseSwitches.V, "event", "Landroid/view/MotionEvent;", "Companion", "style_standardRelease"}, k = 1, mv = {1, 4, 3})
public class ViewTouchMorphAnimHelper extends ViewMorphAnimHelper {
    public static final Companion Companion = null;
    private static final String TAG = "ViewTouchMorphAnimHelper";
    private final int downMorphStartPoint;
    private final int leftMorphStartPoint;
    private final int rightMorphStartPoint;
    private final int upMorphStartPoint;

    /* JADX INFO: compiled from: ViewTouchMorphAnimHelper.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u0005"}, d2 = {"Lcom/obric/common/oea/style/scene/qsanim/morph/ViewTouchMorphAnimHelper$Companion;", "", "()V", "TAG", "", "style_standardRelease"}, k = 1, mv = {1, 4, 3})
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker r1) {
            this();
        }
    }

    static {
        Companion = new Companion(null);
    }

    public ViewTouchMorphAnimHelper(View r14, float r15, float r16, int r17, int r18, int r19, int r20) {
        Intrinsics.checkNotNullParameter(r14, "view");
        super(r14, r15, r16, 0, 0, 0, 0, false, false, 120, null);
        this.leftMorphStartPoint = r17;
        this.rightMorphStartPoint = r18;
        this.upMorphStartPoint = r19;
        this.downMorphStartPoint = r20;
    }

    public final void handleTouchEvent(View r3, MotionEvent r4) {
        if (r4 == null) goto L4;
        Integer r5 = Integer.valueOf(r4.getAction());
    L5:
        if (r5 != null) goto L8;
    L10:
        if (r5 != null) goto L13;
    L15:
        if (r5 != null) goto L18;
    L20:
        if (r5 != null) goto L23;
        return;
    L23:
        if (r5.intValue() != 3) goto L28;
    L24:
        dragEnd();
        return;
    L28:
        return;
    L18:
        if (r5.intValue() != 1) goto L20;
    L13:
        if (r5.intValue() != 2) goto L15;
        dragContinue(r4.getX(), r4.getY());
        return;
    L8:
        if (r5.intValue() != 0) goto L10;
        startDrag(r4.getX(), r4.getY());
        return;
    L4:
        r5 = null;
        goto L5
    }

    @Override // com.obric.common.oea.style.scene.qsanim.morph.ViewMorphAnimHelper
    protected Pair<Integer, Integer> calculateNewSize(float r11, float r12, float r13, float r14) {
        float r0 = 0;
        if (r13 <= r0) goto L5;
        float r1 = RangesKt.coerceAtLeast(r13, this.rightMorphStartPoint) - this.rightMorphStartPoint;
    L6:
        float r3 = r1;
        if (r14 <= r0) goto L9;
        float r2 = RangesKt.coerceAtLeast(r14, this.downMorphStartPoint) - this.downMorphStartPoint;
    L11:
        if (getMorphFactorX() == 0.0f) goto L14;
        OEALogger.INSTANCE.d(TAG, "calculateNewSize, x: " + r11 + ", dx: " + r13 + ", coercedDx: " + r3 + ", leftStart: " + this.leftMorphStartPoint + ", rightStart: " + this.rightMorphStartPoint);
    L14:
        if (getMorphFactorY() == 0.0f) goto L16;
        OEALogger.INSTANCE.d(TAG, "calculateNewSize, y: " + r12 + ", dy: " + r14 + ", coercedDy: " + r2 + ", upStart: " + this.upMorphStartPoint + ", downStart: " + this.downMorphStartPoint);
    L16:
        float r15 = KtExt.dampedClamp$default(KtExt.INSTANCE, r3, getOriginalWidth() * getMorphFactorX(), 0.0f, 4, null);
        float r16 = KtExt.dampedClamp$default(KtExt.INSTANCE, r2, getOriginalHeight() * getMorphFactorY(), 0.0f, 4, null);
        float r17 = getView().getWidth();
        float r18 = getView().getHeight();
        float r4 = ((r17 * r16) * (-1.0f)) / r18;
        float r19 = ((r18 * r15) * (-1.0f)) / r17;
        return new Pair(Integer.valueOf(MathKt.roundToInt((getOriginalWidth() + r15) + r4)), Integer.valueOf(MathKt.roundToInt((getOriginalHeight() + r16) + r19)));
    L9:
        r2 = RangesKt.coerceAtMost(r14, -this.upMorphStartPoint) + this.upMorphStartPoint;
        goto L11
    L5:
        r1 = RangesKt.coerceAtMost(r13, -this.leftMorphStartPoint) + this.leftMorphStartPoint;
        goto L6
    }
}
