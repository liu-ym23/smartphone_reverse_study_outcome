package androidx.constraintlayout.solver.state.helpers;

import androidx.constraintlayout.solver.state.ConstraintReference;
import androidx.constraintlayout.solver.state.State;
import java.util.Iterator;

/* JADX INFO: loaded from: classes17.dex */
public class VerticalChainReference extends ChainReference {
    private Object mBottomToBottom;
    private Object mBottomToTop;
    private Object mTopToBottom;
    private Object mTopToTop;

    /* JADX INFO: renamed from: androidx.constraintlayout.solver.state.helpers.VerticalChainReference$1, reason: invalid class name */
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
        this.mState.constraints(r100.next()).clearVertical();
        goto L4
    L6:
        Iterator<Object> r101 = this.mReferences.iterator();
        ConstraintReference r102 = null;
        ConstraintReference r103 = null;
    L8:
        if (r101.hasNext() == false) goto L22;
        ConstraintReference r104 = this.mState.constraints(r101.next());
        if (r103 != null) goto L19;
        Object r105 = this.mTopToTop;
        if (r105 == null) goto L14;
        r104.topToTop(r105);
    L18:
        r103 = r104;
        goto L19
    L14:
        Object r106 = this.mTopToBottom;
        if (r106 == null) goto L17;
        r104.topToBottom(r106);
        goto L18
    L17:
        r104.topToTop(State.PARENT);
    L19:
        if (r102 == null) goto L21;
        r102.bottomToTop(r104.getKey());
        r104.topToBottom(r102.getKey());
    L21:
        r102 = r104;
        goto L8
    L22:
        if (r102 == null) goto L30;
        Object r107 = this.mBottomToTop;
        if (r107 == null) goto L26;
        r102.bottomToTop(r107);
        goto L30
    L26:
        Object r108 = this.mBottomToBottom;
        if (r108 == null) goto L29;
        r102.bottomToBottom(r108);
        goto L30
    L29:
        r102.bottomToBottom(State.PARENT);
    L30:
        if (r103 == null) goto L34;
        float r109 = this.mBias;
        if (r109 == 0.5f) goto L34;
        r103.verticalBias(r109);
    L34:
        int r110 = AnonymousClass1.$SwitchMap$androidx$constraintlayout$solver$state$State$Chain[this.mStyle.ordinal()];
        if (r110 != 1) goto L37;
        r103.setVerticalChainStyle(0);
        return;
    L37:
        if (r110 != 2) goto L39;
        r103.setVerticalChainStyle(1);
        return;
    L39:
        if (r110 != 3) goto L51;
        r103.setVerticalChainStyle(2);
        return;
    }

    public VerticalChainReference(State r100) {
        super(r100, State.Helper.VERTICAL_CHAIN);
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
