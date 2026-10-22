package androidx.constraintlayout.solver.state.helpers;

import androidx.constraintlayout.solver.state.ConstraintReference;
import androidx.constraintlayout.solver.state.HelperReference;
import androidx.constraintlayout.solver.state.State;
import java.util.Iterator;

/* JADX INFO: loaded from: classes17.dex */
public class AlignVerticallyReference extends HelperReference {
    private float mBias;
    private Object mBottomToBottom;
    private Object mBottomToTop;
    private Object mTopToBottom;
    private Object mTopToTop;

    @Override // androidx.constraintlayout.solver.state.HelperReference
    public void apply() {
        Iterator<Object> r100 = this.mReferences.iterator();
    L4:
        if (r100.hasNext() == false) goto L22;
        Object r101 = r100.next();
        ConstraintReference r102 = this.mState.constraints(r101);
        r102.clearVertical();
        Object r103 = this.mTopToTop;
        if (r103 == null) goto L8;
        r102.topToTop(r103);
    L12:
        Object r104 = this.mBottomToTop;
        if (r104 == null) goto L15;
        r102.bottomToTop(r104);
    L19:
        float r105 = this.mBias;
        if (r105 == 0.5f) goto L4;
        r102.verticalBias(r105);
        goto L4
    L15:
        Object r106 = this.mBottomToBottom;
        if (r106 == null) goto L18;
        r102.bottomToBottom(r106);
        goto L19
    L18:
        r102.bottomToBottom(State.PARENT);
        goto L19
    L8:
        Object r107 = this.mTopToBottom;
        if (r107 == null) goto L11;
        r102.topToBottom(r107);
        goto L12
    L11:
        r102.topToTop(State.PARENT);
        goto L12
    }

    public AlignVerticallyReference(State r100) {
        super(r100, State.Helper.ALIGN_VERTICALLY);
        this.mBias = 0.5f;
    }

    public void bias(float r100) {
        this.mBias = r100;
    }

    public void bottomToBottom(Object r100) {
        this.mBottomToBottom = r100;
    }

    public void bottomToTop(Object r100) {
        this.mBottomToTop = r100;
    }

    public void topToBottom(Object r100) {
        this.mTopToBottom = r100;
    }

    public void topToTop(Object r100) {
        this.mTopToTop = r100;
    }
}
