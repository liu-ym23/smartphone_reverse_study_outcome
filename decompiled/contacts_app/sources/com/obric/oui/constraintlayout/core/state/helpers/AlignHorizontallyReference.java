package com.obric.oui.constraintlayout.core.state.helpers;

import com.obric.oui.constraintlayout.core.state.ConstraintReference;
import com.obric.oui.constraintlayout.core.state.HelperReference;
import com.obric.oui.constraintlayout.core.state.State;
import java.util.Iterator;

/* JADX INFO: loaded from: classes3.dex */
public class AlignHorizontallyReference extends HelperReference {
    private float mBias;

    public AlignHorizontallyReference(State r2) {
        super(r2, State.Helper.ALIGN_VERTICALLY);
        this.mBias = 0.5f;
    }

    @Override // com.obric.oui.constraintlayout.core.state.HelperReference, com.obric.oui.constraintlayout.core.state.ConstraintReference, com.obric.oui.constraintlayout.core.state.Reference
    public void apply() {
        Iterator<Object> r0 = this.mReferences.iterator();
    L4:
        if (r0.hasNext() == false) goto L22;
        Object r1 = r0.next();
        ConstraintReference r2 = this.mHelperState.constraints(r1);
        r2.clearHorizontal();
        if (this.mStartToStart == null) goto L9;
        r2.startToStart(this.mStartToStart);
    L13:
        if (this.mEndToStart == null) goto L16;
        r2.endToStart(this.mEndToStart);
    L19:
        float r3 = this.mBias;
        if (r3 == 0.5f) goto L4;
        r2.horizontalBias(r3);
        goto L4
    L16:
        if (this.mEndToEnd == null) goto L18;
        r2.endToEnd(this.mEndToEnd);
        goto L19
    L18:
        r2.endToEnd(State.PARENT);
        goto L19
    L9:
        if (this.mStartToEnd == null) goto L11;
        r2.startToEnd(this.mStartToEnd);
        goto L13
    L11:
        r2.startToStart(State.PARENT);
        goto L13
    }
}
