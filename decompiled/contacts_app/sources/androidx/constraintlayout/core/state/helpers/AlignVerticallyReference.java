package androidx.constraintlayout.core.state.helpers;

import androidx.constraintlayout.core.state.ConstraintReference;
import androidx.constraintlayout.core.state.HelperReference;
import androidx.constraintlayout.core.state.State;
import java.util.Iterator;

/* JADX INFO: loaded from: classes.dex */
public class AlignVerticallyReference extends HelperReference {
    private float mBias;

    public AlignVerticallyReference(State r2) {
        super(r2, State.Helper.ALIGN_VERTICALLY);
        this.mBias = 0.5f;
    }

    @Override // androidx.constraintlayout.core.state.HelperReference, androidx.constraintlayout.core.state.ConstraintReference, androidx.constraintlayout.core.state.Reference
    public void apply() {
        Iterator<Object> r0 = this.mReferences.iterator();
    L4:
        if (r0.hasNext() == false) goto L22;
        Object r1 = r0.next();
        ConstraintReference r2 = this.mState.constraints(r1);
        r2.clearVertical();
        if (this.mTopToTop == null) goto L9;
        r2.topToTop(this.mTopToTop);
    L13:
        if (this.mBottomToTop == null) goto L16;
        r2.bottomToTop(this.mBottomToTop);
    L19:
        float r3 = this.mBias;
        if (r3 == 0.5f) goto L4;
        r2.verticalBias(r3);
        goto L4
    L16:
        if (this.mBottomToBottom == null) goto L18;
        r2.bottomToBottom(this.mBottomToBottom);
        goto L19
    L18:
        r2.bottomToBottom(State.PARENT);
        goto L19
    L9:
        if (this.mTopToBottom == null) goto L11;
        r2.topToBottom(this.mTopToBottom);
        goto L13
    L11:
        r2.topToTop(State.PARENT);
        goto L13
    }
}
