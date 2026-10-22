package com.stepos.taskrobot.llmapi.stepfun.view.popup;

import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import com.stepos.taskrobot.llmapi.stepfun.view.popup.HandleVerticalDraggerKt;
import kotlin.Metadata;
import kotlin.jvm.internal.k;

@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a\u001b\u0010\u0004\u001a\u00020\u0003*\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u0001H\u0000¢\u0006\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2 = {"Lcom/stepos/taskrobot/llmapi/stepfun/view/popup/HandleVerticalDragger;", "Landroid/view/View;", "handle", "LC7/r;", "bindTouchListener", "(Lcom/stepos/taskrobot/llmapi/stepfun/view/popup/HandleVerticalDragger;Landroid/view/View;)V", "stepfun_release"}, k = 2, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class HandleVerticalDraggerKt {
    public static final void bindTouchListener(final HandleVerticalDragger handleVerticalDragger, View handle) {
        k.f(handleVerticalDragger, "<this>");
        k.f(handle, "handle");
        final VelocityTracker[] velocityTrackerArr = new VelocityTracker[1];
        handle.setOnTouchListener(new View.OnTouchListener() { // from class: k6.a
            @Override // android.view.View.OnTouchListener
            public final boolean onTouch(View view, MotionEvent motionEvent) {
                return HandleVerticalDraggerKt.bindTouchListener$lambda$0(velocityTrackerArr, handleVerticalDragger, view, motionEvent);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:14:0x0026  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final boolean bindTouchListener$lambda$0(android.view.VelocityTracker[] r4, com.stepos.taskrobot.llmapi.stepfun.view.popup.HandleVerticalDragger r5, android.view.View r6, android.view.MotionEvent r7) {
        /*
            r6 = 0
            r0 = r4[r6]
            if (r0 != 0) goto Lb
            android.view.VelocityTracker r0 = android.view.VelocityTracker.obtain()
            r4[r6] = r0
        Lb:
            r0.addMovement(r7)
            int r1 = r7.getActionMasked()
            r2 = 1
            if (r1 == 0) goto L39
            if (r1 == r2) goto L26
            r3 = 2
            if (r1 == r3) goto L1e
            r7 = 3
            if (r1 == r7) goto L26
            goto L40
        L1e:
            float r4 = r7.getRawY()
            r5.onMove(r4)
            goto L40
        L26:
            r7 = 1000(0x3e8, float:1.401E-42)
            r0.computeCurrentVelocity(r7)
            float r7 = r0.getYVelocity()
            r5.onUp(r7)
            r0.recycle()
            r5 = 0
            r4[r6] = r5
            goto L40
        L39:
            float r4 = r7.getRawY()
            r5.onDown(r4)
        L40:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stepos.taskrobot.llmapi.stepfun.view.popup.HandleVerticalDraggerKt.bindTouchListener$lambda$0(android.view.VelocityTracker[], com.stepos.taskrobot.llmapi.stepfun.view.popup.HandleVerticalDragger, android.view.View, android.view.MotionEvent):boolean");
    }
}
