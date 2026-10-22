package androidx.constraintlayout.solver.state.helpers;

import androidx.constraintlayout.solver.state.ConstraintReference;
import androidx.constraintlayout.solver.state.State;
import java.util.Iterator;

/* JADX INFO: loaded from: classes17.dex */
public class HorizontalChainReference extends ChainReference {
    private Object mEndToEnd;
    private Object mEndToStart;
    private Object mStartToEnd;
    private Object mStartToStart;

    /* JADX INFO: renamed from: androidx.constraintlayout.solver.state.helpers.HorizontalChainReference$1, reason: invalid class name */
    public static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$androidx$constraintlayout$solver$state$State$Chain = null;

        static {
            int[] r100 = new int[State.Chain.values().length];
            $SwitchMap$androidx$constraintlayout$solver$state$State$Chain = r100;
            r100[State.Chain.SPREAD.ordinal()] = 1;     // Catch: NoSuchFieldError -> L7
        L10:
            $SwitchMap$androidx$constraintlayout$solver$state$State$Chain[State.Chain.SPREAD_INSIDE.ordinal()] = 2;     // Catch: NoSuchFieldError -> L8
        L12:
            $SwitchMap$androidx$constraintlayout$solver$state$State$Chain[State.Chain.PACKED.ordinal()] = 3;     // Catch: NoSuchFieldError -> L9
            return;
        }
    }

    @Override // androidx.constraintlayout.solver.state.HelperReference
    public void apply() {
        Iterator<Object> r100 = this.mReferences.iterator();
    L4:
        if (r100.hasNext() == false) goto L6;
        this.mState.constraints(r100.next()).clearHorizontal();
        goto L4
    L6:
        Iterator<Object> r101 = this.mReferences.iterator();
        ConstraintReference r102 = null;
        ConstraintReference r103 = null;
    L8:
        if (r101.hasNext() == false) goto L22;
        ConstraintReference r104 = this.mState.constraints(r101.next());
        if (r103 != null) goto L19;
        Object r105 = this.mStartToStart;
        if (r105 == null) goto L14;
        r104.startToStart(r105);
    L18:
        r103 = r104;
        goto L19
    L14:
        Object r106 = this.mStartToEnd;
        if (r106 == null) goto L17;
        r104.startToEnd(r106);
        goto L18
    L17:
        r104.startToStart(State.PARENT);
    L19:
        if (r102 == null) goto L21;
        r102.endToStart(r104.getKey());
        r104.startToEnd(r102.getKey());
    L21:
        r102 = r104;
        goto L8
    L22:
        if (r102 == null) goto L30;
        Object r107 = this.mEndToStart;
        if (r107 == null) goto L26;
        r102.endToStart(r107);
        goto L30
    L26:
        Object r108 = this.mEndToEnd;
        if (r108 == null) goto L29;
        r102.endToEnd(r108);
        goto L30
    L29:
        r102.endToEnd(State.PARENT);
    L30:
        if (r103 == null) goto L34;
        float r109 = this.mBias;
        if (r109 == 0.5f) goto L34;
        r103.horizontalBias(r109);
    L34:
        int r110 = AnonymousClass1.$SwitchMap$androidx$constraintlayout$solver$state$State$Chain[this.mStyle.ordinal()];
        if (r110 != 1) goto L37;
        r103.setHorizontalChainStyle(0);
        return;
    L37:
        if (r110 != 2) goto L39;
        r103.setHorizontalChainStyle(1);
        return;
    L39:
        if (r110 != 3) goto L51;
        r103.setHorizontalChainStyle(2);
        return;
    }

    public HorizontalChainReference(State r100) {
        super(r100, State.Helper.HORIZONTAL_CHAIN);
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
