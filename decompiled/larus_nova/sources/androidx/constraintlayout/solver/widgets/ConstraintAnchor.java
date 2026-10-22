package androidx.constraintlayout.solver.widgets;

import androidx.constraintlayout.solver.Cache;
import androidx.constraintlayout.solver.SolverVariable;
import androidx.constraintlayout.solver.widgets.analyzer.Grouping;
import androidx.constraintlayout.solver.widgets.analyzer.WidgetGroup;
import com.bytedance.android.livesdk.chatroom.event.UserProfileEvent;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import r27.a;

/* JADX INFO: loaded from: classes3.dex */
public class ConstraintAnchor {
    private static final boolean ALLOW_BINARY = false;
    private static final int UNSET_GONE_MARGIN = -1;
    private HashSet<ConstraintAnchor> mDependents;
    private int mFinalValue;
    int mGoneMargin;
    private boolean mHasFinalValue;
    public int mMargin;
    public final ConstraintWidget mOwner;
    SolverVariable mSolverVariable;
    public ConstraintAnchor mTarget;
    public final Type mType;

    /* JADX INFO: renamed from: androidx.constraintlayout.solver.widgets.ConstraintAnchor$1, reason: invalid class name */
    /* JADX INFO: loaded from: classes17.dex */
    public static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$androidx$constraintlayout$solver$widgets$ConstraintAnchor$Type = null;

        static {
            int[] r100 = new int[Type.values().length];
            $SwitchMap$androidx$constraintlayout$solver$widgets$ConstraintAnchor$Type = r100;
            r100[Type.CENTER.ordinal()] = 1;     // Catch: NoSuchFieldError -> L13
        L24:
            $SwitchMap$androidx$constraintlayout$solver$widgets$ConstraintAnchor$Type[Type.LEFT.ordinal()] = 2;     // Catch: NoSuchFieldError -> L14
        L28:
            $SwitchMap$androidx$constraintlayout$solver$widgets$ConstraintAnchor$Type[Type.RIGHT.ordinal()] = 3;     // Catch: NoSuchFieldError -> L15
        L38:
            $SwitchMap$androidx$constraintlayout$solver$widgets$ConstraintAnchor$Type[Type.TOP.ordinal()] = 4;     // Catch: NoSuchFieldError -> L16
        L26:
            $SwitchMap$androidx$constraintlayout$solver$widgets$ConstraintAnchor$Type[Type.BOTTOM.ordinal()] = 5;     // Catch: NoSuchFieldError -> L17
        L30:
            $SwitchMap$androidx$constraintlayout$solver$widgets$ConstraintAnchor$Type[Type.BASELINE.ordinal()] = 6;     // Catch: NoSuchFieldError -> L18
        L32:
            $SwitchMap$androidx$constraintlayout$solver$widgets$ConstraintAnchor$Type[Type.CENTER_X.ordinal()] = 7;     // Catch: NoSuchFieldError -> L19
        L34:
            $SwitchMap$androidx$constraintlayout$solver$widgets$ConstraintAnchor$Type[Type.CENTER_Y.ordinal()] = 8;     // Catch: NoSuchFieldError -> L20
        L22:
            $SwitchMap$androidx$constraintlayout$solver$widgets$ConstraintAnchor$Type[Type.NONE.ordinal()] = 9;     // Catch: NoSuchFieldError -> L21
            return;
        }
    }

    public static final enum Type extends Enum<Type> {
        private static final /* synthetic */ Type[] $VALUES = null;
        public static final Type BASELINE = null;
        public static final Type BOTTOM = null;
        public static final Type CENTER = null;
        public static final Type CENTER_X = null;
        public static final Type CENTER_Y = null;
        public static final Type LEFT = null;
        public static final Type NONE = null;
        public static final Type RIGHT = null;
        public static final Type TOP = null;

        static {
            Type r100 = new Type(UserProfileEvent.POSITION_NONE, 0);
            NONE = r100;
            Type r101 = new Type("LEFT", 1);
            LEFT = r101;
            Type r102 = new Type("TOP", 2);
            TOP = r102;
            Type r103 = new Type("RIGHT", 3);
            RIGHT = r103;
            Type r104 = new Type("BOTTOM", 4);
            BOTTOM = r104;
            Type r105 = new Type("BASELINE", 5);
            BASELINE = r105;
            Type r110 = new Type("CENTER", 6);
            CENTER = r110;
            Type r111 = new Type("CENTER_X", 7);
            CENTER_X = r111;
            Type r112 = new Type("CENTER_Y", 8);
            CENTER_Y = r112;
            $VALUES = new Type[]{r100, r101, r102, r103, r104, r105, r110, r111, r112};
        }

        public static Type[] values() {
            return (Type[]) $VALUES.clone();
        }

        public static Type valueOf(String r100) {
            return (Type) a.a(Type.class, r100);
        }

        private Type(String r100, int r101) {
            super(r100, r101);
        }
    }

    public void resetFinalResolution() {
        this.mHasFinalValue = false;
        this.mFinalValue = 0;
    }

    public int getFinalValue() {
        if (this.mHasFinalValue == true) goto L7;
        return 0;
    L7:
        return this.mFinalValue;
    }

    public int getMargin() {
        if (this.mOwner.getVisibility() != 8) goto L7;
        return 0;
    L7:
        if (this.mGoneMargin <= (-1)) goto L15;
        ConstraintAnchor r100 = this.mTarget;
        if (r100 == null) goto L15;
        if (r100.mOwner.getVisibility() != 8) goto L15;
        return this.mGoneMargin;
    L15:
        return this.mMargin;
    }

    public final ConstraintAnchor getOpposite() {
        switch(AnonymousClass1.$SwitchMap$androidx$constraintlayout$solver$widgets$ConstraintAnchor$Type[this.mType.ordinal()]) {
            case 1: goto L14;
            case 2: goto L13;
            case 3: goto L11;
            case 4: goto L9;
            case 5: goto L7;
            case 6: goto L14;
            case 7: goto L14;
            case 8: goto L14;
            case 9: goto L14;
            default: goto L5;
        };
    L14:
        return null;
    L5:
        throw new AssertionError(this.mType.name());
    L7:
        return this.mOwner.mTop;
    L9:
        return this.mOwner.mBottom;
    L11:
        return this.mOwner.mLeft;
    L13:
        return this.mOwner.mRight;
    }

    public boolean hasCenteredDependents() {
        HashSet<ConstraintAnchor> r100 = this.mDependents;
        if (r100 != null) goto L5;
        return false;
    L5:
        Iterator<ConstraintAnchor> r101 = r100.iterator();
    L7:
        if (r101.hasNext() == false) goto L12;
        if (r101.next().getOpposite().isConnected() == false) goto L7;
        return true;
    L12:
        return false;
    }

    public boolean hasDependents() {
        HashSet<ConstraintAnchor> r100 = this.mDependents;
        if (r100 != null) goto L6;
        return false;
    L6:
        if (r100.size() <= 0) goto L9;
        return true;
    L9:
        return false;
    }

    public boolean isConnected() {
        if (this.mTarget == null) goto L5;
        return true;
    L5:
        return false;
    }

    public boolean isSideAnchor() {
        switch(AnonymousClass1.$SwitchMap$androidx$constraintlayout$solver$widgets$ConstraintAnchor$Type[this.mType.ordinal()]) {
            case 1: goto L8;
            case 2: goto L6;
            case 3: goto L6;
            case 4: goto L6;
            case 5: goto L6;
            case 6: goto L8;
            case 7: goto L8;
            case 8: goto L8;
            case 9: goto L8;
            default: goto L5;
        };
    L6:
        return true;
    L8:
        return false;
    L5:
        throw new AssertionError(this.mType.name());
    }

    public boolean isVerticalAnchor() {
        switch(AnonymousClass1.$SwitchMap$androidx$constraintlayout$solver$widgets$ConstraintAnchor$Type[this.mType.ordinal()]) {
            case 1: goto L8;
            case 2: goto L8;
            case 3: goto L8;
            case 4: goto L6;
            case 5: goto L6;
            case 6: goto L6;
            case 7: goto L8;
            case 8: goto L6;
            case 9: goto L6;
            default: goto L5;
        };
    L6:
        return true;
    L8:
        return false;
    L5:
        throw new AssertionError(this.mType.name());
    }

    public void reset() {
        ConstraintAnchor r100 = this.mTarget;
        if (r100 == null) goto L9;
        HashSet<ConstraintAnchor> r101 = r100.mDependents;
        if (r101 == null) goto L9;
        r101.remove(this);
        if (this.mTarget.mDependents.size() != 0) goto L9;
        this.mTarget.mDependents = null;
    L9:
        this.mDependents = null;
        this.mTarget = null;
        this.mMargin = 0;
        this.mGoneMargin = -1;
        this.mHasFinalValue = false;
        this.mFinalValue = 0;
    }

    public String toString() {
        return this.mOwner.getDebugName() + ":" + this.mType.toString();
    }

    public HashSet<ConstraintAnchor> getDependents() {
        return this.mDependents;
    }

    public ConstraintWidget getOwner() {
        return this.mOwner;
    }

    public SolverVariable getSolverVariable() {
        return this.mSolverVariable;
    }

    public ConstraintAnchor getTarget() {
        return this.mTarget;
    }

    public Type getType() {
        return this.mType;
    }

    public boolean hasFinalValue() {
        return this.mHasFinalValue;
    }

    public boolean isConnectionAllowed(ConstraintWidget r100) {
        if (isConnectionToMe(r100, new HashSet()) == false) goto L5;
        return false;
    L5:
        ConstraintWidget r101 = getOwner().getParent();
        if (r101 != r100) goto L9;
        return true;
    L9:
        if (r100.getParent() != r101) goto L11;
        return true;
    L11:
        return false;
    }

    public boolean isSimilarDimensionConnection(ConstraintAnchor r100) {
        Type r101 = r100.getType();
        Type r102 = this.mType;
        if (r101 != r102) goto L6;
        return true;
    L6:
        switch(AnonymousClass1.$SwitchMap$androidx$constraintlayout$solver$widgets$ConstraintAnchor$Type[r102.ordinal()]) {
            case 1: goto L31;
            case 2: goto L22;
            case 3: goto L22;
            case 4: goto L11;
            case 5: goto L11;
            case 6: goto L11;
            case 7: goto L22;
            case 8: goto L11;
            case 9: goto L9;
            default: goto L8;
        };
    L9:
        return false;
    L8:
        throw new AssertionError(this.mType.name());
    L11:
        if (r101 != Type.TOP) goto L13;
        return true;
    L13:
        if (r101 != Type.BOTTOM) goto L15;
        return true;
    L15:
        if (r101 != Type.CENTER_Y) goto L17;
        return true;
    L17:
        if (r101 == Type.BASELINE) goto L38;
        return false;
    L38:
        return true;
    L22:
        if (r101 != Type.LEFT) goto L24;
        return true;
    L24:
        if (r101 != Type.RIGHT) goto L26;
        return true;
    L26:
        if (r101 == Type.CENTER_X) goto L41;
        return false;
    L41:
        return true;
    L31:
        if (r101 != Type.BASELINE) goto L42;
        return false;
    L42:
        return true;
    }

    public boolean isValidConnection(ConstraintAnchor r100) {
        boolean r101 = false;
        if (r100 != null) goto L5;
        return false;
    L5:
        Type r102 = r100.getType();
        Type r103 = this.mType;
        if (r102 != r103) goto L16;
        if (r103 == Type.BASELINE) goto L10;
    L14:
        return true;
    L10:
        if (r100.getOwner().hasBaseline() == true) goto L12;
    L13:
        return false;
    L12:
        if (getOwner().hasBaseline() == true) goto L14;
    L16:
        switch(AnonymousClass1.$SwitchMap$androidx$constraintlayout$solver$widgets$ConstraintAnchor$Type[r103.ordinal()]) {
            case 1: goto L51;
            case 2: goto L36;
            case 3: goto L36;
            case 4: goto L21;
            case 5: goto L21;
            case 6: goto L19;
            case 7: goto L19;
            case 8: goto L19;
            case 9: goto L19;
            default: goto L18;
        };
    L19:
        return false;
    L18:
        throw new AssertionError(this.mType.name());
    L21:
        if (r102 != Type.TOP) goto L23;
    L26:
        boolean r104 = true;
    L28:
        if ((r100.getOwner() instanceof Guideline) == false) goto L58;
        if (r104 == false) goto L31;
    L32:
        r101 = true;
    L34:
        return r101;
    L31:
        if (r102 != Type.CENTER_Y) goto L34;
    L58:
        return r104;
    L23:
        if (r102 == Type.BOTTOM) goto L26;
        r104 = false;
        goto L28
    L36:
        if (r102 != Type.LEFT) goto L38;
    L41:
        boolean r105 = true;
    L43:
        if ((r100.getOwner() instanceof Guideline) == false) goto L59;
        if (r105 == false) goto L46;
    L47:
        r101 = true;
    L49:
        return r101;
    L46:
        if (r102 != Type.CENTER_X) goto L49;
    L59:
        return r105;
    L38:
        if (r102 == Type.RIGHT) goto L41;
        r105 = false;
        goto L43
    L51:
        if (r102 != Type.BASELINE) goto L53;
        return false;
    L53:
        if (r102 != Type.CENTER_X) goto L55;
        return false;
    L55:
        if (r102 == Type.CENTER_Y) goto L62;
        return true;
    L62:
        return false;
    }

    public void resetSolverVariable(Cache r100) {
        SolverVariable r101 = this.mSolverVariable;
        if (r101 != null) goto L5;
        this.mSolverVariable = new SolverVariable(SolverVariable.Type.UNRESTRICTED, null);
        return;
    L5:
        r101.reset();
    }

    public void setFinalValue(int r100) {
        this.mFinalValue = r100;
        this.mHasFinalValue = true;
    }

    public void setGoneMargin(int r100) {
        if (isConnected() == false) goto L6;
        this.mGoneMargin = r100;
        return;
    }

    public void setMargin(int r100) {
        if (isConnected() == false) goto L6;
        this.mMargin = r100;
        return;
    }

    public ConstraintAnchor(ConstraintWidget r100, Type r101) {
        this.mDependents = null;
        this.mMargin = 0;
        this.mGoneMargin = -1;
        this.mOwner = r100;
        this.mType = r101;
    }

    private boolean isConnectionToMe(ConstraintWidget r100, HashSet<ConstraintWidget> r101) {
        if (r101.contains(r100) == false) goto L5;
        return false;
    L5:
        r101.add(r100);
        if (r100 != getOwner()) goto L8;
        return true;
    L8:
        ArrayList<ConstraintAnchor> r102 = r100.getAnchors();
        int r103 = r102.size();
        int r104 = 0;
    L9:
        if (r104 >= r103) goto L18;
        ConstraintAnchor r105 = (ConstraintAnchor) ListProtector.get(r102, r104);
        if (r105.isSimilarDimensionConnection(this) == false) goto L17;
        if (r105.isConnected() == false) goto L17;
        if (isConnectionToMe(r105.getTarget().getOwner(), r101) == false) goto L17;
        return true;
    L17:
        r104 = r104 + 1;
        goto L9
    L18:
        return false;
    }

    public boolean connect(ConstraintAnchor r100, int r101) {
        return connect(r100, r101, -1, false);
    }

    public void copyFrom(ConstraintAnchor r100, HashMap<ConstraintWidget, ConstraintWidget> r101) {
        ConstraintAnchor r102 = this.mTarget;
        if (r102 == null) goto L7;
        HashSet<ConstraintAnchor> r103 = r102.mDependents;
        if (r103 == null) goto L7;
        r103.remove(this);
    L7:
        ConstraintAnchor r104 = r100.mTarget;
        if (r104 == null) goto L10;
        Type r105 = r104.getType();
        this.mTarget = r101.get(r100.mTarget.mOwner).getAnchor(r105);
    L11:
        ConstraintAnchor r106 = this.mTarget;
        if (r106 != null) goto L14;
    L17:
        this.mMargin = r100.mMargin;
        this.mGoneMargin = r100.mGoneMargin;
        return;
    L14:
        if (r106.mDependents != null) goto L16;
        r106.mDependents = new HashSet();
    L16:
        this.mTarget.mDependents.add(this);
        goto L17
    L10:
        this.mTarget = null;
        goto L11
    }

    public boolean isConnectionAllowed(ConstraintWidget r100, ConstraintAnchor r101) {
        return isConnectionAllowed(r100);
    }

    public void findDependents(int r100, ArrayList<WidgetGroup> r101, WidgetGroup r102) {
        HashSet<ConstraintAnchor> r103 = this.mDependents;
        if (r103 == null) goto L8;
        Iterator<ConstraintAnchor> r104 = r103.iterator();
    L6:
        if (r104.hasNext() == false) goto L10;
        Grouping.findDependents(r104.next().mOwner, r100, r101, r102);
        goto L6
    L10:
        return;
    }

    public boolean connect(ConstraintAnchor r100, int r101, int r102, boolean r103) {
        if (r100 != null) goto L7;
        reset();
        return true;
    L7:
        if (r103 == false) goto L9;
    L11:
        this.mTarget = r100;
        if (r100.mDependents != null) goto L14;
        r100.mDependents = new HashSet();
    L14:
        HashSet<ConstraintAnchor> r104 = this.mTarget.mDependents;
        if (r104 == null) goto L17;
        r104.add(this);
    L17:
        if (r101 <= 0) goto L19;
        this.mMargin = r101;
    L20:
        this.mGoneMargin = r102;
        return true;
    L19:
        this.mMargin = 0;
        goto L20
    L9:
        if (isValidConnection(r100) == true) goto L11;
        return false;
    }
}
