package androidx.constraintlayout.solver.state;

import androidx.constraintlayout.solver.state.helpers.AlignHorizontallyReference;
import androidx.constraintlayout.solver.state.helpers.AlignVerticallyReference;
import androidx.constraintlayout.solver.state.helpers.BarrierReference;
import androidx.constraintlayout.solver.state.helpers.GuidelineReference;
import androidx.constraintlayout.solver.state.helpers.HorizontalChainReference;
import androidx.constraintlayout.solver.state.helpers.VerticalChainReference;
import androidx.constraintlayout.solver.widgets.ConstraintWidget;
import androidx.constraintlayout.solver.widgets.ConstraintWidgetContainer;
import androidx.constraintlayout.solver.widgets.HelperWidget;
import com.alibaba.gaiax.model.GXAnimation;
import java.util.HashMap;
import java.util.Iterator;
import r27.a;

/* JADX INFO: loaded from: classes17.dex */
public class State {
    static final int CONSTRAINT_RATIO = 2;
    static final int CONSTRAINT_SPREAD = 0;
    static final int CONSTRAINT_WRAP = 1;
    public static final Integer PARENT = null;
    static final int UNKNOWN = -1;
    protected HashMap<Object, HelperReference> mHelperReferences;
    public final ConstraintReference mParent;
    protected HashMap<Object, Reference> mReferences;
    private int numHelpers;

    /* JADX INFO: renamed from: androidx.constraintlayout.solver.state.State$1, reason: invalid class name */
    public static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$androidx$constraintlayout$solver$state$State$Helper = null;

        static {
            int[] r100 = new int[Helper.values().length];
            $SwitchMap$androidx$constraintlayout$solver$state$State$Helper = r100;
            r100[Helper.HORIZONTAL_CHAIN.ordinal()] = 1;     // Catch: NoSuchFieldError -> L9
        L14:
            $SwitchMap$androidx$constraintlayout$solver$state$State$Helper[Helper.VERTICAL_CHAIN.ordinal()] = 2;     // Catch: NoSuchFieldError -> L10
        L18:
            $SwitchMap$androidx$constraintlayout$solver$state$State$Helper[Helper.ALIGN_HORIZONTALLY.ordinal()] = 3;     // Catch: NoSuchFieldError -> L11
        L22:
            $SwitchMap$androidx$constraintlayout$solver$state$State$Helper[Helper.ALIGN_VERTICALLY.ordinal()] = 4;     // Catch: NoSuchFieldError -> L12
        L16:
            $SwitchMap$androidx$constraintlayout$solver$state$State$Helper[Helper.BARRIER.ordinal()] = 5;     // Catch: NoSuchFieldError -> L13
            return;
        }
    }

    public static final enum Chain extends Enum<Chain> {
        private static final /* synthetic */ Chain[] $VALUES = null;
        public static final Chain PACKED = null;
        public static final Chain SPREAD = null;
        public static final Chain SPREAD_INSIDE = null;

        static {
            Chain r100 = new Chain("SPREAD", 0);
            SPREAD = r100;
            Chain r101 = new Chain("SPREAD_INSIDE", 1);
            SPREAD_INSIDE = r101;
            Chain r102 = new Chain("PACKED", 2);
            PACKED = r102;
            $VALUES = new Chain[]{r100, r101, r102};
        }

        public static Chain[] values() {
            return (Chain[]) $VALUES.clone();
        }

        public static Chain valueOf(String r100) {
            return (Chain) a.a(Chain.class, r100);
        }

        private Chain(String r100, int r101) {
            super(r100, r101);
        }
    }

    public static final enum Constraint extends Enum<Constraint> {
        private static final /* synthetic */ Constraint[] $VALUES = null;
        public static final Constraint BASELINE_TO_BASELINE = null;
        public static final Constraint BOTTOM_TO_BOTTOM = null;
        public static final Constraint BOTTOM_TO_TOP = null;
        public static final Constraint CENTER_HORIZONTALLY = null;
        public static final Constraint CENTER_VERTICALLY = null;
        public static final Constraint END_TO_END = null;
        public static final Constraint END_TO_START = null;
        public static final Constraint LEFT_TO_LEFT = null;
        public static final Constraint LEFT_TO_RIGHT = null;
        public static final Constraint RIGHT_TO_LEFT = null;
        public static final Constraint RIGHT_TO_RIGHT = null;
        public static final Constraint START_TO_END = null;
        public static final Constraint START_TO_START = null;
        public static final Constraint TOP_TO_BOTTOM = null;
        public static final Constraint TOP_TO_TOP = null;

        static {
            Constraint r100 = new Constraint("LEFT_TO_LEFT", 0);
            LEFT_TO_LEFT = r100;
            Constraint r101 = new Constraint("LEFT_TO_RIGHT", 1);
            LEFT_TO_RIGHT = r101;
            Constraint r102 = new Constraint("RIGHT_TO_LEFT", 2);
            RIGHT_TO_LEFT = r102;
            Constraint r103 = new Constraint("RIGHT_TO_RIGHT", 3);
            RIGHT_TO_RIGHT = r103;
            Constraint r104 = new Constraint("START_TO_START", 4);
            START_TO_START = r104;
            Constraint r105 = new Constraint("START_TO_END", 5);
            START_TO_END = r105;
            Constraint r110 = new Constraint("END_TO_START", 6);
            END_TO_START = r110;
            Constraint r111 = new Constraint("END_TO_END", 7);
            END_TO_END = r111;
            Constraint r112 = new Constraint("TOP_TO_TOP", 8);
            TOP_TO_TOP = r112;
            Constraint r113 = new Constraint("TOP_TO_BOTTOM", 9);
            TOP_TO_BOTTOM = r113;
            Constraint r114 = new Constraint("BOTTOM_TO_TOP", 10);
            BOTTOM_TO_TOP = r114;
            Constraint r115 = new Constraint("BOTTOM_TO_BOTTOM", 11);
            BOTTOM_TO_BOTTOM = r115;
            Constraint r106 = new Constraint("BASELINE_TO_BASELINE", 12);
            BASELINE_TO_BASELINE = r106;
            Constraint r107 = new Constraint("CENTER_HORIZONTALLY", 13);
            CENTER_HORIZONTALLY = r107;
            Constraint r108 = new Constraint("CENTER_VERTICALLY", 14);
            CENTER_VERTICALLY = r108;
            $VALUES = new Constraint[]{r100, r101, r102, r103, r104, r105, r110, r111, r112, r113, r114, r115, r106, r107, r108};
        }

        public static Constraint[] values() {
            return (Constraint[]) $VALUES.clone();
        }

        public static Constraint valueOf(String r100) {
            return (Constraint) a.a(Constraint.class, r100);
        }

        private Constraint(String r100, int r101) {
            super(r100, r101);
        }
    }

    public static final enum Direction extends Enum<Direction> {
        private static final /* synthetic */ Direction[] $VALUES = null;
        public static final Direction BOTTOM = null;
        public static final Direction END = null;
        public static final Direction LEFT = null;
        public static final Direction RIGHT = null;
        public static final Direction START = null;
        public static final Direction TOP = null;

        static {
            Direction r100 = new Direction("LEFT", 0);
            LEFT = r100;
            Direction r101 = new Direction("RIGHT", 1);
            RIGHT = r101;
            Direction r102 = new Direction(GXAnimation.STATE_START, 2);
            START = r102;
            Direction r103 = new Direction(GXAnimation.STATE_END, 3);
            END = r103;
            Direction r104 = new Direction("TOP", 4);
            TOP = r104;
            Direction r105 = new Direction("BOTTOM", 5);
            BOTTOM = r105;
            $VALUES = new Direction[]{r100, r101, r102, r103, r104, r105};
        }

        public static Direction[] values() {
            return (Direction[]) $VALUES.clone();
        }

        public static Direction valueOf(String r100) {
            return (Direction) a.a(Direction.class, r100);
        }

        private Direction(String r100, int r101) {
            super(r100, r101);
        }
    }

    public static final enum Helper extends Enum<Helper> {
        private static final /* synthetic */ Helper[] $VALUES = null;
        public static final Helper ALIGN_HORIZONTALLY = null;
        public static final Helper ALIGN_VERTICALLY = null;
        public static final Helper BARRIER = null;
        public static final Helper FLOW = null;
        public static final Helper HORIZONTAL_CHAIN = null;
        public static final Helper LAYER = null;
        public static final Helper VERTICAL_CHAIN = null;

        static {
            Helper r100 = new Helper("HORIZONTAL_CHAIN", 0);
            HORIZONTAL_CHAIN = r100;
            Helper r101 = new Helper("VERTICAL_CHAIN", 1);
            VERTICAL_CHAIN = r101;
            Helper r102 = new Helper("ALIGN_HORIZONTALLY", 2);
            ALIGN_HORIZONTALLY = r102;
            Helper r103 = new Helper("ALIGN_VERTICALLY", 3);
            ALIGN_VERTICALLY = r103;
            Helper r104 = new Helper("BARRIER", 4);
            BARRIER = r104;
            Helper r105 = new Helper("LAYER", 5);
            LAYER = r105;
            Helper r110 = new Helper("FLOW", 6);
            FLOW = r110;
            $VALUES = new Helper[]{r100, r101, r102, r103, r104, r105, r110};
        }

        public static Helper[] values() {
            return (Helper[]) $VALUES.clone();
        }

        public static Helper valueOf(String r100) {
            return (Helper) a.a(Helper.class, r100);
        }

        private Helper(String r100, int r101) {
            super(r100, r101);
        }
    }

    static {
        PARENT = 0;
    }

    private String createHelperKey() {
        StringBuilder r100 = new StringBuilder("__HELPER_KEY_");
        int r101 = this.numHelpers;
        this.numHelpers = r101 + 1;
        r100.append(r101);
        r100.append("__");
        return r100.toString();
    }

    public void directMapping() {
        Iterator<Object> r100 = this.mReferences.keySet().iterator();
    L4:
        if (r100.hasNext() == false) goto L6;
        Object r101 = r100.next();
        constraints(r101).setView(r101);
        goto L4
    }

    public void reset() {
        this.mHelperReferences.clear();
    }

    public State() {
        this.mReferences = new HashMap();
        this.mHelperReferences = new HashMap();
        ConstraintReference r100 = new ConstraintReference(this);
        this.mParent = r100;
        this.numHelpers = 0;
        this.mReferences.put(PARENT, r100);
    }

    public void apply(ConstraintWidgetContainer r100) {
        r100.removeAllChildren();
        this.mParent.getWidth().apply(this, r100, 0);
        this.mParent.getHeight().apply(this, r100, 1);
        Iterator<Object> r101 = this.mHelperReferences.keySet().iterator();
    L4:
        if (r101.hasNext() == false) goto L11;
        Object r102 = r101.next();
        HelperWidget r103 = this.mHelperReferences.get(r102).getHelperWidget();
        if (r103 == null) goto L4;
        Reference r104 = this.mReferences.get(r102);
        if (r104 != null) goto L10;
        r104 = constraints(r102);
    L10:
        r104.setConstraintWidget(r103);
        goto L4
    L11:
        Iterator<Object> r105 = this.mReferences.keySet().iterator();
    L13:
        if (r105.hasNext() == false) goto L21;
        Object r106 = r105.next();
        Reference r107 = this.mReferences.get(r106);
        if (r107 != this.mParent) goto L16;
        r107.setConstraintWidget(r100);
        goto L13
    L16:
        ConstraintWidget r108 = r107.getConstraintWidget();
        r108.setParent(null);
        if ((r107 instanceof GuidelineReference) == false) goto L19;
        r107.apply();
    L19:
        r100.add(r108);
        goto L13
    L21:
        Iterator<Object> r109 = this.mHelperReferences.keySet().iterator();
    L23:
        if (r109.hasNext() == false) goto L31;
        Object r110 = r109.next();
        HelperReference r111 = this.mHelperReferences.get(r110);
        if (r111.getHelperWidget() == null) goto L23;
        Iterator<Object> r112 = r111.mReferences.iterator();
    L28:
        if (r112.hasNext() == false) goto L30;
        Object r113 = r112.next();
        Reference r114 = this.mReferences.get(r113);
        r111.getHelperWidget().add(r114.getConstraintWidget());
        goto L28
    L30:
        r111.apply();
        goto L23
    L31:
        Iterator<Object> r115 = this.mReferences.keySet().iterator();
    L33:
        if (r115.hasNext() == false) goto L35;
        Object r116 = r115.next();
        this.mReferences.get(r116).apply();
        goto L33
    }

    public AlignHorizontallyReference centerHorizontally(Object... r100) {
        AlignHorizontallyReference r101 = (AlignHorizontallyReference) helper(null, Helper.ALIGN_HORIZONTALLY);
        r101.add(r100);
        return r101;
    }

    public AlignVerticallyReference centerVertically(Object... r100) {
        AlignVerticallyReference r101 = (AlignVerticallyReference) helper(null, Helper.ALIGN_VERTICALLY);
        r101.add(r100);
        return r101;
    }

    public ConstraintReference constraints(Object r100) {
        Reference r101 = this.mReferences.get(r100);
        if (r101 != null) goto L6;
        r101 = createConstraintReference(r100);
        this.mReferences.put(r100, r101);
        r101.setKey(r100);
    L6:
        if ((r101 instanceof ConstraintReference) == true) goto L8;
        return null;
    L8:
        return (ConstraintReference) r101;
    }

    public int convertDimension(Object r100) {
        if ((r100 instanceof Float) == false) goto L7;
        return ((Float) r100).intValue();
    L7:
        if ((r100 instanceof Integer) == true) goto L9;
        return 0;
    L9:
        return ((Integer) r100).intValue();
    }

    public ConstraintReference createConstraintReference(Object r100) {
        return new ConstraintReference(this);
    }

    public State height(Dimension r100) {
        return setHeight(r100);
    }

    public HorizontalChainReference horizontalChain(Object... r100) {
        HorizontalChainReference r101 = (HorizontalChainReference) helper(null, Helper.HORIZONTAL_CHAIN);
        r101.add(r100);
        return r101;
    }

    public GuidelineReference horizontalGuideline(Object r100) {
        return guideline(r100, 0);
    }

    public Reference reference(Object r100) {
        return this.mReferences.get(r100);
    }

    public State setHeight(Dimension r100) {
        this.mParent.setHeight(r100);
        return this;
    }

    public State setWidth(Dimension r100) {
        this.mParent.setWidth(r100);
        return this;
    }

    public VerticalChainReference verticalChain(Object... r100) {
        VerticalChainReference r101 = (VerticalChainReference) helper(null, Helper.VERTICAL_CHAIN);
        r101.add(r100);
        return r101;
    }

    public GuidelineReference verticalGuideline(Object r100) {
        return guideline(r100, 1);
    }

    public State width(Dimension r100) {
        return setWidth(r100);
    }

    public BarrierReference barrier(Object r100, Direction r101) {
        BarrierReference r102 = (BarrierReference) helper(r100, Helper.BARRIER);
        r102.setBarrierDirection(r101);
        return r102;
    }

    public GuidelineReference guideline(Object r100, int r101) {
        Reference r102 = this.mReferences.get(r100);
        Object r103 = r102;
        if (r102 != null) goto L6;
        GuidelineReference r104 = new GuidelineReference(this);
        r104.setOrientation(r101);
        r104.setKey(r100);
        this.mReferences.put(r100, r104);
        r103 = r104;
    L6:
        return (GuidelineReference) r103;
    }

    public HelperReference helper(Object r100, Helper r101) {
        if (r100 != null) goto L4;
        r100 = createHelperKey();
    L4:
        HelperReference r102 = this.mHelperReferences.get(r100);
        if (r102 != null) goto L24;
        int r103 = AnonymousClass1.$SwitchMap$androidx$constraintlayout$solver$state$State$Helper[r101.ordinal()];
        if (r103 != 1) goto L9;
        HelperReference r104 = new HorizontalChainReference(this);
    L22:
        r102 = r104;
    L23:
        this.mHelperReferences.put(r100, r102);
        goto L24
    L9:
        if (r103 != 2) goto L11;
        r104 = new VerticalChainReference(this);
        goto L22
    L11:
        if (r103 != 3) goto L13;
        r104 = new AlignHorizontallyReference(this);
        goto L22
    L13:
        if (r103 != 4) goto L15;
        r104 = new AlignVerticallyReference(this);
        goto L22
    L15:
        if (r103 == 5) goto L17;
        r102 = new HelperReference(this, r101);
        goto L23
    L17:
        r104 = new BarrierReference(this);
    L24:
        return r102;
    }

    public void map(Object r100, Object r101) {
        constraints(r100).setView(r101);
    }
}
