package androidx.constraintlayout.core.state;

import androidx.constraintlayout.core.state.helpers.Facade;
import androidx.constraintlayout.core.widgets.ConstraintWidget;
import androidx.constraintlayout.core.widgets.HelperWidget;
import java.util.ArrayList;
import java.util.Collections;

/* JADX INFO: loaded from: classes.dex */
public class HelperReference extends ConstraintReference implements Facade {
    private HelperWidget mHelperWidget;
    protected ArrayList<Object> mReferences;
    protected final State mState;
    final State.Helper mType;

    @Override // androidx.constraintlayout.core.state.ConstraintReference, androidx.constraintlayout.core.state.Reference
    public void apply() {
    }

    public HelperReference(State r2, State.Helper r3) {
        super(r2);
        this.mReferences = new ArrayList();
        this.mState = r2;
        this.mType = r3;
    }

    public State.Helper getType() {
        return this.mType;
    }

    public HelperReference add(Object... r2) {
        Collections.addAll(this.mReferences, r2);
        return this;
    }

    public void setHelperWidget(HelperWidget r1) {
        this.mHelperWidget = r1;
    }

    public HelperWidget getHelperWidget() {
        return this.mHelperWidget;
    }

    @Override // androidx.constraintlayout.core.state.ConstraintReference, androidx.constraintlayout.core.state.Reference
    public ConstraintWidget getConstraintWidget() {
        return getHelperWidget();
    }
}
