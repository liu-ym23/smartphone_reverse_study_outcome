package androidx.constraintlayout.core.state;

import androidx.constraintlayout.core.state.helpers.AlignHorizontallyReference;
import androidx.constraintlayout.core.state.helpers.AlignVerticallyReference;
import androidx.constraintlayout.core.state.helpers.BarrierReference;
import androidx.constraintlayout.core.state.helpers.GuidelineReference;
import androidx.constraintlayout.core.state.helpers.HorizontalChainReference;
import androidx.constraintlayout.core.state.helpers.VerticalChainReference;
import androidx.constraintlayout.core.widgets.ConstraintWidget;
import androidx.constraintlayout.core.widgets.ConstraintWidgetContainer;
import androidx.constraintlayout.core.widgets.HelperWidget;
import com.android.vcard.VCardConstants;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

/* JADX INFO: loaded from: classes.dex */
public class State {
    static final int CONSTRAINT_RATIO = 2;
    static final int CONSTRAINT_SPREAD = 0;
    static final int CONSTRAINT_WRAP = 1;
    public static final Integer PARENT = null;
    static final int UNKNOWN = -1;
    protected HashMap<Object, HelperReference> mHelperReferences;
    public final ConstraintReference mParent;
    protected HashMap<Object, Reference> mReferences;
    HashMap<String, ArrayList<String>> mTags;
    private int numHelpers;

    /* JADX INFO: renamed from: androidx.constraintlayout.core.state.State$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$androidx$constraintlayout$core$state$State$Helper = null;

        static {
            int[] r0 = new int[Helper.values().length];
            $SwitchMap$androidx$constraintlayout$core$state$State$Helper = r0;
            r0[Helper.HORIZONTAL_CHAIN.ordinal()] = 1;     // Catch: NoSuchFieldError -> L9
        L14:
            $SwitchMap$androidx$constraintlayout$core$state$State$Helper[Helper.VERTICAL_CHAIN.ordinal()] = 2;     // Catch: NoSuchFieldError -> L10
        L18:
            $SwitchMap$androidx$constraintlayout$core$state$State$Helper[Helper.ALIGN_HORIZONTALLY.ordinal()] = 3;     // Catch: NoSuchFieldError -> L11
        L22:
            $SwitchMap$androidx$constraintlayout$core$state$State$Helper[Helper.ALIGN_VERTICALLY.ordinal()] = 4;     // Catch: NoSuchFieldError -> L12
        L16:
            $SwitchMap$androidx$constraintlayout$core$state$State$Helper[Helper.BARRIER.ordinal()] = 5;     // Catch: NoSuchFieldError -> L13
            return;
        }
    }

    public static final enum Chain extends Enum<Chain> {
        private static final /* synthetic */ Chain[] $VALUES = null;
        public static final Chain PACKED = null;
        public static final Chain SPREAD = null;
        public static final Chain SPREAD_INSIDE = null;

        private Chain(String r1, int r2) {
            super(r1, r2);
        }

        public static Chain valueOf(String r1) {
            return (Chain) Enum.valueOf(Chain.class, r1);
        }

        public static Chain[] values() {
            return (Chain[]) $VALUES.clone();
        }

        static {
            Chain r0 = new Chain("SPREAD", 0);
            SPREAD = r0;
            Chain r1 = new Chain("SPREAD_INSIDE", 1);
            SPREAD_INSIDE = r1;
            Chain r3 = new Chain("PACKED", 2);
            PACKED = r3;
            $VALUES = new Chain[]{r0, r1, r3};
        }
    }

    public static final enum Constraint extends Enum<Constraint> {
        private static final /* synthetic */ Constraint[] $VALUES = null;
        public static final Constraint BASELINE_TO_BASELINE = null;
        public static final Constraint BASELINE_TO_BOTTOM = null;
        public static final Constraint BASELINE_TO_TOP = null;
        public static final Constraint BOTTOM_TO_BOTTOM = null;
        public static final Constraint BOTTOM_TO_TOP = null;
        public static final Constraint CENTER_HORIZONTALLY = null;
        public static final Constraint CENTER_VERTICALLY = null;
        public static final Constraint CIRCULAR_CONSTRAINT = null;
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

        private Constraint(String r1, int r2) {
            super(r1, r2);
        }

        public static Constraint valueOf(String r1) {
            return (Constraint) Enum.valueOf(Constraint.class, r1);
        }

        public static Constraint[] values() {
            return (Constraint[]) $VALUES.clone();
        }

        static {
            Constraint r0 = new Constraint("LEFT_TO_LEFT", 0);
            LEFT_TO_LEFT = r0;
            Constraint r1 = new Constraint("LEFT_TO_RIGHT", 1);
            LEFT_TO_RIGHT = r1;
            Constraint r3 = new Constraint("RIGHT_TO_LEFT", 2);
            RIGHT_TO_LEFT = r3;
            Constraint r5 = new Constraint("RIGHT_TO_RIGHT", 3);
            RIGHT_TO_RIGHT = r5;
            Constraint r7 = new Constraint("START_TO_START", 4);
            START_TO_START = r7;
            Constraint r9 = new Constraint("START_TO_END", 5);
            START_TO_END = r9;
            Constraint r11 = new Constraint("END_TO_START", 6);
            END_TO_START = r11;
            Constraint r13 = new Constraint("END_TO_END", 7);
            END_TO_END = r13;
            Constraint r15 = new Constraint("TOP_TO_TOP", 8);
            TOP_TO_TOP = r15;
            Constraint r14 = new Constraint("TOP_TO_BOTTOM", 9);
            TOP_TO_BOTTOM = r14;
            Constraint r12 = new Constraint("BOTTOM_TO_TOP", 10);
            BOTTOM_TO_TOP = r12;
            Constraint r10 = new Constraint("BOTTOM_TO_BOTTOM", 11);
            BOTTOM_TO_BOTTOM = r10;
            Constraint r8 = new Constraint("BASELINE_TO_BASELINE", 12);
            BASELINE_TO_BASELINE = r8;
            Constraint r6 = new Constraint("BASELINE_TO_TOP", 13);
            BASELINE_TO_TOP = r6;
            Constraint r4 = new Constraint("BASELINE_TO_BOTTOM", 14);
            BASELINE_TO_BOTTOM = r4;
            Constraint r2 = new Constraint("CENTER_HORIZONTALLY", 15);
            CENTER_HORIZONTALLY = r2;
            Constraint r16 = new Constraint("CENTER_VERTICALLY", 16);
            CENTER_VERTICALLY = r16;
            Constraint r17 = new Constraint("CIRCULAR_CONSTRAINT", 17);
            CIRCULAR_CONSTRAINT = r17;
            $VALUES = new Constraint[]{r0, r1, r3, r5, r7, r9, r11, r13, r15, r14, r12, r10, r8, r6, r4, r2, r16, r17};
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

        private Direction(String r1, int r2) {
            super(r1, r2);
        }

        public static Direction valueOf(String r1) {
            return (Direction) Enum.valueOf(Direction.class, r1);
        }

        public static Direction[] values() {
            return (Direction[]) $VALUES.clone();
        }

        static {
            Direction r0 = new Direction("LEFT", 0);
            LEFT = r0;
            Direction r1 = new Direction("RIGHT", 1);
            RIGHT = r1;
            Direction r3 = new Direction("START", 2);
            START = r3;
            Direction r5 = new Direction(VCardConstants.PROPERTY_END, 3);
            END = r5;
            Direction r7 = new Direction("TOP", 4);
            TOP = r7;
            Direction r9 = new Direction("BOTTOM", 5);
            BOTTOM = r9;
            $VALUES = new Direction[]{r0, r1, r3, r5, r7, r9};
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

        private Helper(String r1, int r2) {
            super(r1, r2);
        }

        public static Helper valueOf(String r1) {
            return (Helper) Enum.valueOf(Helper.class, r1);
        }

        public static Helper[] values() {
            return (Helper[]) $VALUES.clone();
        }

        static {
            Helper r0 = new Helper("HORIZONTAL_CHAIN", 0);
            HORIZONTAL_CHAIN = r0;
            Helper r1 = new Helper("VERTICAL_CHAIN", 1);
            VERTICAL_CHAIN = r1;
            Helper r3 = new Helper("ALIGN_HORIZONTALLY", 2);
            ALIGN_HORIZONTALLY = r3;
            Helper r5 = new Helper("ALIGN_VERTICALLY", 3);
            ALIGN_VERTICALLY = r5;
            Helper r7 = new Helper("BARRIER", 4);
            BARRIER = r7;
            Helper r9 = new Helper("LAYER", 5);
            LAYER = r9;
            Helper r11 = new Helper("FLOW", 6);
            FLOW = r11;
            $VALUES = new Helper[]{r0, r1, r3, r5, r7, r9, r11};
        }
    }

    static {
        PARENT = 0;
    }

    public State() {
        this.mReferences = new HashMap();
        this.mHelperReferences = new HashMap();
        this.mTags = new HashMap();
        ConstraintReference r0 = new ConstraintReference(this);
        this.mParent = r0;
        this.numHelpers = 0;
        this.mReferences.put(PARENT, r0);
    }

    public void reset() {
        this.mHelperReferences.clear();
        this.mTags.clear();
    }

    public int convertDimension(Object r1) {
        if ((r1 instanceof Float) == false) goto L7;
        return ((Float) r1).intValue();
    L7:
        if ((r1 instanceof Integer) == true) goto L9;
        return 0;
    L9:
        return ((Integer) r1).intValue();
    }

    public ConstraintReference createConstraintReference(Object r1) {
        return new ConstraintReference(this);
    }

    public boolean sameFixedWidth(int r1) {
        return this.mParent.getWidth().equalsFixedValue(r1);
    }

    public boolean sameFixedHeight(int r1) {
        return this.mParent.getHeight().equalsFixedValue(r1);
    }

    public State width(Dimension r1) {
        return setWidth(r1);
    }

    public State height(Dimension r1) {
        return setHeight(r1);
    }

    public State setWidth(Dimension r2) {
        this.mParent.setWidth(r2);
        return this;
    }

    public State setHeight(Dimension r2) {
        this.mParent.setHeight(r2);
        return this;
    }

    Reference reference(Object r1) {
        return this.mReferences.get(r1);
    }

    public ConstraintReference constraints(Object r2) {
        Reference r0 = this.mReferences.get(r2);
        if (r0 != null) goto L6;
        r0 = createConstraintReference(r2);
        this.mReferences.put(r2, r0);
        r0.setKey(r2);
    L6:
        if ((r0 instanceof ConstraintReference) == true) goto L8;
        return null;
    L8:
        return (ConstraintReference) r0;
    }

    private String createHelperKey() {
        StringBuilder r0 = new StringBuilder("__HELPER_KEY_");
        int r1 = this.numHelpers;
        this.numHelpers = r1 + 1;
        return r0.append(r1).append("__").toString();
    }

    public HelperReference helper(Object r3, Helper r4) {
        if (r3 != null) goto L4;
        r3 = createHelperKey();
    L4:
        HelperReference r0 = this.mHelperReferences.get(r3);
        if (r0 != null) goto L24;
        int r1 = AnonymousClass1.$SwitchMap$androidx$constraintlayout$core$state$State$Helper[r4.ordinal()];
        if (r1 != 1) goto L9;
        HelperReference r5 = new HorizontalChainReference(this);
    L22:
        r0 = r5;
    L23:
        r0.setKey(r3);
        this.mHelperReferences.put(r3, r0);
        goto L24
    L9:
        if (r1 != 2) goto L11;
        r5 = new VerticalChainReference(this);
        goto L22
    L11:
        if (r1 != 3) goto L13;
        r5 = new AlignHorizontallyReference(this);
        goto L22
    L13:
        if (r1 != 4) goto L15;
        r5 = new AlignVerticallyReference(this);
        goto L22
    L15:
        if (r1 == 5) goto L17;
        r0 = new HelperReference(this, r4);
        goto L23
    L17:
        r5 = new BarrierReference(this);
    L24:
        return r0;
    }

    public GuidelineReference horizontalGuideline(Object r2) {
        return guideline(r2, 0);
    }

    public GuidelineReference verticalGuideline(Object r2) {
        return guideline(r2, 1);
    }

    public GuidelineReference guideline(Object r3, int r4) {
        ConstraintReference r0 = constraints(r3);
        if (r0.getFacade() != null) goto L5;
    L6:
        GuidelineReference r1 = new GuidelineReference(this);
        r1.setOrientation(r4);
        r1.setKey(r3);
        r0.setFacade(r1);
    L8:
        return (GuidelineReference) r0.getFacade();
    L5:
        if ((r0.getFacade() instanceof GuidelineReference) == true) goto L8;
        goto L6
    }

    public BarrierReference barrier(Object r2, Direction r3) {
        ConstraintReference r4 = constraints(r2);
        if (r4.getFacade() != null) goto L5;
    L6:
        BarrierReference r0 = new BarrierReference(this);
        r0.setBarrierDirection(r3);
        r4.setFacade(r0);
    L8:
        return (BarrierReference) r4.getFacade();
    L5:
        if ((r4.getFacade() instanceof BarrierReference) == true) goto L8;
        goto L6
    }

    public VerticalChainReference verticalChain() {
        return (VerticalChainReference) helper(null, Helper.VERTICAL_CHAIN);
    }

    public VerticalChainReference verticalChain(Object... r3) {
        VerticalChainReference r2 = (VerticalChainReference) helper(null, Helper.VERTICAL_CHAIN);
        r2.add(r3);
        return r2;
    }

    public HorizontalChainReference horizontalChain() {
        return (HorizontalChainReference) helper(null, Helper.HORIZONTAL_CHAIN);
    }

    public HorizontalChainReference horizontalChain(Object... r3) {
        HorizontalChainReference r2 = (HorizontalChainReference) helper(null, Helper.HORIZONTAL_CHAIN);
        r2.add(r3);
        return r2;
    }

    public AlignHorizontallyReference centerHorizontally(Object... r3) {
        AlignHorizontallyReference r2 = (AlignHorizontallyReference) helper(null, Helper.ALIGN_HORIZONTALLY);
        r2.add(r3);
        return r2;
    }

    public AlignVerticallyReference centerVertically(Object... r3) {
        AlignVerticallyReference r2 = (AlignVerticallyReference) helper(null, Helper.ALIGN_VERTICALLY);
        r2.add(r3);
        return r2;
    }

    public void directMapping() {
        Iterator<Object> r0 = this.mReferences.keySet().iterator();
    L4:
        if (r0.hasNext() == false) goto L9;
        Object r1 = r0.next();
        ConstraintReference r2 = constraints(r1);
        if ((r2 instanceof ConstraintReference) == false) goto L4;
        r2.setView(r1);
        goto L4
    }

    public void map(Object r1, Object r2) {
        ConstraintReference r0 = constraints(r1);
        if ((r0 instanceof ConstraintReference) == false) goto L6;
        r0.setView(r2);
        return;
    }

    public void setTag(String r3, String r4) {
        ConstraintReference r0 = constraints(r3);
        if ((r0 instanceof ConstraintReference) == false) goto L10;
        r0.setTag(r4);
        if (this.mTags.containsKey(r4) == true) goto L7;
        ArrayList<String> r1 = new ArrayList();
        this.mTags.put(r4, r1);
    L8:
        r1.add(r3);
        return;
    L7:
        r1 = this.mTags.get(r4);
        goto L8
    }

    public ArrayList<String> getIdsForTag(String r2) {
        if (this.mTags.containsKey(r2) == true) goto L5;
        return null;
    L5:
        return this.mTags.get(r2);
    }

    public void apply(ConstraintWidgetContainer r8) {
        r8.removeAllChildren();
        this.mParent.getWidth().apply(this, r8, 0);
        this.mParent.getHeight().apply(this, r8, 1);
        Iterator<Object> r0 = this.mHelperReferences.keySet().iterator();
    L4:
        if (r0.hasNext() == false) goto L11;
        Object r1 = r0.next();
        HelperWidget r2 = this.mHelperReferences.get(r1).getHelperWidget();
        if (r2 == null) goto L4;
        Reference r3 = this.mReferences.get(r1);
        if (r3 != null) goto L10;
        r3 = constraints(r1);
    L10:
        r3.setConstraintWidget(r2);
        goto L4
    L11:
        Iterator<Object> r4 = this.mReferences.keySet().iterator();
    L13:
        if (r4.hasNext() == false) goto L24;
        Object r5 = r4.next();
        Reference r6 = this.mReferences.get(r5);
        if (r6 == this.mParent) goto L13;
        if ((r6.getFacade() instanceof HelperReference) == false) goto L13;
        HelperWidget r7 = ((HelperReference) r6.getFacade()).getHelperWidget();
        if (r7 == null) goto L13;
        Reference r9 = this.mReferences.get(r5);
        if (r9 != null) goto L23;
        r9 = constraints(r5);
    L23:
        r9.setConstraintWidget(r7);
        goto L13
    L24:
        Iterator<Object> r10 = this.mReferences.keySet().iterator();
    L26:
        if (r10.hasNext() == false) goto L34;
        Reference r11 = this.mReferences.get(r10.next());
        if (r11 != this.mParent) goto L29;
        r11.setConstraintWidget(r8);
        goto L26
    L29:
        ConstraintWidget r12 = r11.getConstraintWidget();
        r12.setDebugName(r11.getKey().toString());
        r12.setParent(null);
        if ((r11.getFacade() instanceof GuidelineReference) == false) goto L32;
        r11.apply();
    L32:
        r8.add(r12);
        goto L26
    L34:
        Iterator<Object> r13 = this.mHelperReferences.keySet().iterator();
    L36:
        if (r13.hasNext() == false) goto L45;
        HelperReference r14 = this.mHelperReferences.get(r13.next());
        if (r14.getHelperWidget() != null) goto L39;
        r14.apply();
        goto L36
    L39:
        Iterator<Object> r15 = r14.mReferences.iterator();
    L41:
        if (r15.hasNext() == false) goto L43;
        r14.getHelperWidget().add(this.mReferences.get(r15.next()).getConstraintWidget());
        goto L41
    L43:
        r14.apply();
        goto L36
    L45:
        Iterator<Object> r16 = this.mReferences.keySet().iterator();
    L47:
        if (r16.hasNext() == false) goto L65;
        Reference r17 = this.mReferences.get(r16.next());
        if (r17 == this.mParent) goto L47;
        if ((r17.getFacade() instanceof HelperReference) == false) goto L47;
        HelperReference r18 = (HelperReference) r17.getFacade();
        HelperWidget r19 = r18.getHelperWidget();
        if (r19 == null) goto L47;
        Iterator<Object> r20 = r18.mReferences.iterator();
    L56:
        if (r20.hasNext() == false) goto L64;
        Object r21 = r20.next();
        Reference r22 = this.mReferences.get(r21);
        if (r22 != null) goto L59;
        if ((r21 instanceof Reference) == true) goto L62;
        System.out.println("couldn't find reference for " + r21);
        goto L56
    L62:
        r19.add(((Reference) r21).getConstraintWidget());
        goto L56
    L59:
        r19.add(r22.getConstraintWidget());
        goto L56
    L64:
        r17.apply();
        goto L47
    L65:
        Iterator<Object> r23 = this.mReferences.keySet().iterator();
    L67:
        if (r23.hasNext() == false) goto L72;
        Object r24 = r23.next();
        Reference r25 = this.mReferences.get(r24);
        r25.apply();
        ConstraintWidget r26 = r25.getConstraintWidget();
        if (r26 == null) goto L67;
        if (r24 == null) goto L67;
        r26.stringId = r24.toString();
        goto L67
    }
}
