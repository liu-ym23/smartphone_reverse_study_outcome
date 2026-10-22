package androidx.constraintlayout.core.state.helpers;

import androidx.constraintlayout.core.state.ConstraintReference;
import androidx.constraintlayout.core.state.State;
import java.util.Iterator;

/* JADX INFO: loaded from: classes.dex */
public class HorizontalChainReference extends ChainReference {

    /* JADX INFO: renamed from: androidx.constraintlayout.core.state.helpers.HorizontalChainReference$1, reason: invalid class name */
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

    public HorizontalChainReference(State r2) {
        super(r2, State.Helper.HORIZONTAL_CHAIN);
    }

    @Override // androidx.constraintlayout.core.state.HelperReference, androidx.constraintlayout.core.state.ConstraintReference, androidx.constraintlayout.core.state.Reference
    public void apply() {
        Iterator<Object> r0 = this.mReferences.iterator();
    L4:
        if (r0.hasNext() == false) goto L6;
        this.mState.constraints(r0.next()).clearHorizontal();
        goto L4
    L6:
        Iterator<Object> r1 = this.mReferences.iterator();
        ConstraintReference r2 = null;
        ConstraintReference r3 = null;
    L8:
        if (r1.hasNext() == false) goto L28;
        ConstraintReference r4 = this.mState.constraints(r1.next());
        if (r3 == null) goto L12;
    L25:
        if (r2 == null) goto L27;
        r2.endToStart(r4.getKey());
        r4.startToEnd(r2.getKey());
    L27:
        r2 = r4;
        goto L8
    L12:
        if (this.mStartToStart == null) goto L15;
        r4.startToStart(this.mStartToStart).margin(this.mMarginStart).marginGone(this.mMarginStartGone);
    L24:
        r3 = r4;
        goto L25
    L15:
        if (this.mStartToEnd == null) goto L18;
        r4.startToEnd(this.mStartToEnd).margin(this.mMarginStart).marginGone(this.mMarginStartGone);
        goto L24
    L18:
        if (this.mLeftToLeft == null) goto L21;
        r4.startToStart(this.mLeftToLeft).margin(this.mMarginLeft).marginGone(this.mMarginLeftGone);
        goto L24
    L21:
        if (this.mLeftToRight == null) goto L23;
        r4.startToEnd(this.mLeftToRight).margin(this.mMarginLeft).marginGone(this.mMarginLeftGone);
        goto L24
    L23:
        r4.startToStart(State.PARENT);
        goto L24
    L28:
        if (r2 != null) goto L30;
    L42:
        if (r3 != null) goto L45;
        return;
    L45:
        if (this.mBias == 0.5f) goto L47;
        r3.horizontalBias(this.mBias);
    L47:
        int r5 = AnonymousClass1.$SwitchMap$androidx$constraintlayout$core$state$State$Chain[this.mStyle.ordinal()];
        if (r5 != 1) goto L50;
        r3.setHorizontalChainStyle(0);
        return;
    L50:
        if (r5 != 2) goto L52;
        r3.setHorizontalChainStyle(1);
        return;
    L52:
        if (r5 != 3) goto L64;
        r3.setHorizontalChainStyle(2);
        return;
    L64:
        return;
    L30:
        if (this.mEndToStart == null) goto L33;
        r2.endToStart(this.mEndToStart).margin(this.mMarginEnd).marginGone(this.mMarginEndGone);
        goto L42
    L33:
        if (this.mEndToEnd == null) goto L36;
        r2.endToEnd(this.mEndToEnd).margin(this.mMarginEnd).marginGone(this.mMarginEndGone);
        goto L42
    L36:
        if (this.mRightToLeft == null) goto L39;
        r2.endToStart(this.mRightToLeft).margin(this.mMarginRight).marginGone(this.mMarginRightGone);
        goto L42
    L39:
        if (this.mRightToRight == null) goto L41;
        r2.endToEnd(this.mRightToRight).margin(this.mMarginRight).marginGone(this.mMarginRightGone);
        goto L42
    L41:
        r2.endToEnd(State.PARENT);
        goto L42
    }
}
