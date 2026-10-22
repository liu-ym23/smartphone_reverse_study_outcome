package androidx.constraintlayout.solver.state.helpers;

import androidx.constraintlayout.solver.state.HelperReference;
import androidx.constraintlayout.solver.state.State;
import androidx.constraintlayout.solver.widgets.Barrier;
import androidx.constraintlayout.solver.widgets.HelperWidget;

/* JADX INFO: loaded from: classes17.dex */
public class BarrierReference extends HelperReference {
    private Barrier mBarrierWidget;
    private State.Direction mDirection;
    private int mMargin;

    /* JADX INFO: renamed from: androidx.constraintlayout.solver.state.helpers.BarrierReference$1, reason: invalid class name */
    public static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$androidx$constraintlayout$solver$state$State$Direction = null;

        static {
            int[] r100 = new int[State.Direction.values().length];
            $SwitchMap$androidx$constraintlayout$solver$state$State$Direction = r100;
            r100[State.Direction.LEFT.ordinal()] = 1;     // Catch: NoSuchFieldError -> L10
        L16:
            $SwitchMap$androidx$constraintlayout$solver$state$State$Direction[State.Direction.START.ordinal()] = 2;     // Catch: NoSuchFieldError -> L11
        L20:
            $SwitchMap$androidx$constraintlayout$solver$state$State$Direction[State.Direction.RIGHT.ordinal()] = 3;     // Catch: NoSuchFieldError -> L12
        L26:
            $SwitchMap$androidx$constraintlayout$solver$state$State$Direction[State.Direction.END.ordinal()] = 4;     // Catch: NoSuchFieldError -> L13
        L18:
            $SwitchMap$androidx$constraintlayout$solver$state$State$Direction[State.Direction.TOP.ordinal()] = 5;     // Catch: NoSuchFieldError -> L14
        L22:
            $SwitchMap$androidx$constraintlayout$solver$state$State$Direction[State.Direction.BOTTOM.ordinal()] = 6;     // Catch: NoSuchFieldError -> L15
            return;
        }
    }

    @Override // androidx.constraintlayout.solver.state.HelperReference
    public HelperWidget getHelperWidget() {
        if (this.mBarrierWidget != null) goto L6;
        this.mBarrierWidget = new Barrier();
    L6:
        return this.mBarrierWidget;
    }

    @Override // androidx.constraintlayout.solver.state.HelperReference
    public void apply() {
        getHelperWidget();
        int r100 = 0;
        switch(AnonymousClass1.$SwitchMap$androidx$constraintlayout$solver$state$State$Direction[this.mDirection.ordinal()]) {
            case 1: goto L8;
            case 2: goto L8;
            case 3: goto L7;
            case 4: goto L7;
            case 5: goto L6;
            case 6: goto L5;
            default: goto L8;
        };
    L5:
        r100 = 3;
        goto L8
    L6:
        r100 = 2;
        goto L8
    L7:
        r100 = 1;
    L8:
        this.mBarrierWidget.setBarrierType(r100);
        this.mBarrierWidget.setMargin(this.mMargin);
    }

    public BarrierReference(State r100) {
        super(r100, State.Helper.BARRIER);
    }

    public void margin(Object r100) {
        margin(this.mState.convertDimension(r100));
    }

    public void setBarrierDirection(State.Direction r100) {
        this.mDirection = r100;
    }

    public void margin(int r100) {
        this.mMargin = r100;
    }
}
