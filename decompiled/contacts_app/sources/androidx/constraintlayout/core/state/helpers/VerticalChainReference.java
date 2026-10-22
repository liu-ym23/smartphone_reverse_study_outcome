package androidx.constraintlayout.core.state.helpers;

import androidx.constraintlayout.core.state.ConstraintReference;
import androidx.constraintlayout.core.state.State;
import java.util.Iterator;

/* JADX INFO: loaded from: classes.dex */
public class VerticalChainReference extends ChainReference {

    /* JADX INFO: renamed from: androidx.constraintlayout.core.state.helpers.VerticalChainReference$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$androidx$constraintlayout$core$state$State$Chain = null;

        static {
            int[] r0 = new int[State.Chain.values().length];
            $SwitchMap$androidx$constraintlayout$core$state$State$Chain = r0;
            r0[State.Chain.SPREAD.ordinal()] = 1;     // Catch: NoSuchFieldError -> L7
        L10:
            $SwitchMap$androidx$constraintlayout$core$state$State$Chain[State.Chain.SPREAD_INSIDE.ordinal()] = 2;     // Catch: NoSuchFieldError -> L8
        L12:
            $SwitchMap$androidx$constraintlayout$core$state$State$Chain[State.Chain.PACKED.ordinal()] = 3;     // Catch: NoSuchFieldError -> L9
            return;
        }
    }

    public VerticalChainReference(State r2) {
        super(r2, State.Helper.VERTICAL_CHAIN);
    }

    @Override // androidx.constraintlayout.core.state.HelperReference, androidx.constraintlayout.core.state.ConstraintReference, androidx.constraintlayout.core.state.Reference
    public void apply() {
        Iterator<Object> r0 = this.mReferences.iterator();
    L4:
        if (r0.hasNext() == false) goto L6;
        this.mState.constraints(r0.next()).clearVertical();
        goto L4
    L6:
        Iterator<Object> r1 = this.mReferences.iterator();
        ConstraintReference r2 = null;
        ConstraintReference r3 = null;
    L8:
        if (r1.hasNext() == false) goto L22;
        ConstraintReference r4 = this.mState.constraints(r1.next());
        if (r3 == null) goto L12;
    L19:
        if (r2 == null) goto L21;
        r2.bottomToTop(r4.getKey());
        r4.topToBottom(r2.getKey());
    L21:
        r2 = r4;
        goto L8
    L12:
        if (this.mTopToTop == null) goto L15;
        r4.topToTop(this.mTopToTop).margin(this.mMarginTop).marginGone(this.mMarginTopGone);
    L18:
        r3 = r4;
        goto L19
    L15:
        if (this.mTopToBottom == null) goto L17;
        r4.topToBottom(this.mTopToBottom).margin(this.mMarginTop).marginGone(this.mMarginTopGone);
        goto L18
    L17:
        r4.topToTop(State.PARENT);
        goto L18
    L22:
        if (r2 != null) goto L24;
    L30:
        if (r3 != null) goto L33;
        return;
    L33:
        if (this.mBias == 0.5f) goto L35;
        r3.verticalBias(this.mBias);
    L35:
        int r5 = AnonymousClass1.$SwitchMap$androidx$constraintlayout$core$state$State$Chain[this.mStyle.ordinal()];
        if (r5 != 1) goto L38;
        r3.setVerticalChainStyle(0);
        return;
    L38:
        if (r5 != 2) goto L40;
        r3.setVerticalChainStyle(1);
        return;
    L40:
        if (r5 != 3) goto L52;
        r3.setVerticalChainStyle(2);
        return;
    L52:
        return;
    L24:
        if (this.mBottomToTop == null) goto L27;
        r2.bottomToTop(this.mBottomToTop).margin(this.mMarginBottom).marginGone(this.mMarginBottomGone);
        goto L30
    L27:
        if (this.mBottomToBottom == null) goto L29;
        r2.bottomToBottom(this.mBottomToBottom).margin(this.mMarginBottom).marginGone(this.mMarginBottomGone);
        goto L30
    L29:
        r2.bottomToBottom(State.PARENT);
        goto L30
    }
}
