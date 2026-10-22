package androidx.constraintlayout.solver.state.helpers;

import androidx.constraintlayout.solver.state.HelperReference;
import androidx.constraintlayout.solver.state.State;

/* JADX INFO: loaded from: classes17.dex */
public class ChainReference extends HelperReference {
    protected float mBias;
    protected State.Chain mStyle;

    public float getBias() {
        return this.mBias;
    }

    public State.Chain getStyle() {
        return State.Chain.SPREAD;
    }

    public void bias(float r100) {
        this.mBias = r100;
    }

    public void style(State.Chain r100) {
        this.mStyle = r100;
    }

    public ChainReference(State r100, State.Helper r101) {
        super(r100, r101);
        this.mBias = 0.5f;
        this.mStyle = State.Chain.SPREAD;
    }
}
