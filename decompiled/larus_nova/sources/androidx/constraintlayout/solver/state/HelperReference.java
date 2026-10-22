package androidx.constraintlayout.solver.state;

import androidx.constraintlayout.solver.widgets.HelperWidget;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes17.dex */
public class HelperReference {
    private HelperWidget mHelperWidget;
    protected ArrayList<Object> mReferences;
    protected final State mState;
    final State.Helper mType;

    public void apply() {
    }

    public HelperWidget getHelperWidget() {
        return this.mHelperWidget;
    }

    public State.Helper getType() {
        return this.mType;
    }

    public HelperReference add(Object... r100) {
        int r101 = r100.length;
        int r102 = 0;
    L3:
        if (r102 >= r101) goto L5;
        Object r103 = r100[r102];
        this.mReferences.add(r103);
        r102 = r102 + 1;
        goto L3
    L5:
        return this;
    }

    public void setHelperWidget(HelperWidget r100) {
        this.mHelperWidget = r100;
    }

    public HelperReference(State r100, State.Helper r101) {
        this.mReferences = new ArrayList();
        this.mState = r100;
        this.mType = r101;
    }
}
