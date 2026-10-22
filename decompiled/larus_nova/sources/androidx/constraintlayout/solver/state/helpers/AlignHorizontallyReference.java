package androidx.constraintlayout.solver.state.helpers;

import androidx.constraintlayout.solver.state.ConstraintReference;
import androidx.constraintlayout.solver.state.HelperReference;
import androidx.constraintlayout.solver.state.State;
import java.util.Iterator;

/* JADX INFO: loaded from: classes17.dex */
public class AlignHorizontallyReference extends HelperReference {
    private float mBias;
    private Object mEndToEnd;
    private Object mEndToStart;
    private Object mStartToEnd;
    private Object mStartToStart;

    @Override // androidx.constraintlayout.solver.state.HelperReference
    public void apply() {
        Iterator<Object> r100 = this.mReferences.iterator();
    L4:
        if (r100.hasNext() == false) goto L22;
        Object r101 = r100.next();
        ConstraintReference r102 = this.mState.constraints(r101);
        r102.clearHorizontal();
        Object r103 = this.mStartToStart;
        if (r103 == null) goto L8;
        r102.startToStart(r103);
    L12:
        Object r104 = this.mEndToStart;
        if (r104 == null) goto L15;
        r102.endToStart(r104);
    L19:
        float r105 = this.mBias;
        if (r105 == 0.5f) goto L4;
        r102.horizontalBias(r105);
        goto L4
    L15:
        Object r106 = this.mEndToEnd;
        if (r106 == null) goto L18;
        r102.endToEnd(r106);
        goto L19
    L18:
        r102.endToEnd(State.PARENT);
        goto L19
    L8:
        Object r107 = this.mStartToEnd;
        if (r107 == null) goto L11;
        r102.startToEnd(r107);
        goto L12
    L11:
        r102.startToStart(State.PARENT);
        goto L12
    }

    public AlignHorizontallyReference(State r100) {
        super(r100, State.Helper.ALIGN_VERTICALLY);
        this.mBias = 0.5f;
    }

    public void bias(float r100) {
        this.mBias = r100;
    }

    public void endToEnd(Object r100) {
        this.mEndToEnd = r100;
    }

    public void endToStart(Object r100) {
        this.mEndToStart = r100;
    }

    public void startToEnd(Object r100) {
        this.mStartToEnd = r100;
    }

    public void startToStart(Object r100) {
        this.mStartToStart = r100;
    }
}
