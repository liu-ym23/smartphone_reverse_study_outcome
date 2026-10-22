package androidx.constraintlayout.core.state;

/* JADX INFO: loaded from: classes.dex */
public abstract class State {

    public static final enum Chain extends Enum<Chain> {
        private static final /* synthetic */ Chain[] $VALUES = null;
        public static final Chain PACKED = null;
        public static final Chain SPREAD = null;
        public static final Chain SPREAD_INSIDE = null;

        static {
            Chain r10 = new Chain("SPREAD", 0);
            SPREAD = r10;
            Chain r11 = new Chain("SPREAD_INSIDE", 1);
            SPREAD_INSIDE = r11;
            Chain r12 = new Chain("PACKED", 2);
            PACKED = r12;
            $VALUES = new Chain[]{r10, r11, r12};
        }

        private Chain(String r10, int r11) {
            super(r10, r11);
        }

        public static Chain valueOf(String r10) {
            return (Chain) Enum.valueOf(Chain.class, r10);
        }

        public static Chain[] values() {
            return (Chain[]) $VALUES.clone();
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

        static {
            Constraint r10 = new Constraint("LEFT_TO_LEFT", 0);
            LEFT_TO_LEFT = r10;
            Constraint r11 = new Constraint("LEFT_TO_RIGHT", 1);
            LEFT_TO_RIGHT = r11;
            Constraint r12 = new Constraint("RIGHT_TO_LEFT", 2);
            RIGHT_TO_LEFT = r12;
            Constraint r13 = new Constraint("RIGHT_TO_RIGHT", 3);
            RIGHT_TO_RIGHT = r13;
            Constraint r14 = new Constraint("START_TO_START", 4);
            START_TO_START = r14;
            Constraint r15 = new Constraint("START_TO_END", 5);
            START_TO_END = r15;
            Constraint r16 = new Constraint("END_TO_START", 6);
            END_TO_START = r16;
            Constraint r17 = new Constraint("END_TO_END", 7);
            END_TO_END = r17;
            Constraint r18 = new Constraint("TOP_TO_TOP", 8);
            TOP_TO_TOP = r18;
            Constraint r19 = new Constraint("TOP_TO_BOTTOM", 9);
            TOP_TO_BOTTOM = r19;
            Constraint r110 = new Constraint("BOTTOM_TO_TOP", 10);
            BOTTOM_TO_TOP = r110;
            Constraint r111 = new Constraint("BOTTOM_TO_BOTTOM", 11);
            BOTTOM_TO_BOTTOM = r111;
            Constraint r112 = new Constraint("BASELINE_TO_BASELINE", 12);
            BASELINE_TO_BASELINE = r112;
            Constraint r113 = new Constraint("BASELINE_TO_TOP", 13);
            BASELINE_TO_TOP = r113;
            Constraint r20 = new Constraint("BASELINE_TO_BOTTOM", 14);
            BASELINE_TO_BOTTOM = r20;
            Constraint r21 = new Constraint("CENTER_HORIZONTALLY", 15);
            CENTER_HORIZONTALLY = r21;
            Constraint r22 = new Constraint("CENTER_VERTICALLY", 16);
            CENTER_VERTICALLY = r22;
            Constraint r23 = new Constraint("CIRCULAR_CONSTRAINT", 17);
            CIRCULAR_CONSTRAINT = r23;
            $VALUES = new Constraint[]{r10, r11, r12, r13, r14, r15, r16, r17, r18, r19, r110, r111, r112, r113, r20, r21, r22, r23};
        }

        private Constraint(String r10, int r11) {
            super(r10, r11);
        }

        public static Constraint valueOf(String r10) {
            return (Constraint) Enum.valueOf(Constraint.class, r10);
        }

        public static Constraint[] values() {
            return (Constraint[]) $VALUES.clone();
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
            Direction r10 = new Direction("LEFT", 0);
            LEFT = r10;
            Direction r11 = new Direction("RIGHT", 1);
            RIGHT = r11;
            Direction r12 = new Direction("START", 2);
            START = r12;
            Direction r13 = new Direction("END", 3);
            END = r13;
            Direction r14 = new Direction("TOP", 4);
            TOP = r14;
            Direction r15 = new Direction("BOTTOM", 5);
            BOTTOM = r15;
            $VALUES = new Direction[]{r10, r11, r12, r13, r14, r15};
        }

        private Direction(String r10, int r11) {
            super(r10, r11);
        }

        public static Direction valueOf(String r10) {
            return (Direction) Enum.valueOf(Direction.class, r10);
        }

        public static Direction[] values() {
            return (Direction[]) $VALUES.clone();
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
            Helper r10 = new Helper("HORIZONTAL_CHAIN", 0);
            HORIZONTAL_CHAIN = r10;
            Helper r11 = new Helper("VERTICAL_CHAIN", 1);
            VERTICAL_CHAIN = r11;
            Helper r12 = new Helper("ALIGN_HORIZONTALLY", 2);
            ALIGN_HORIZONTALLY = r12;
            Helper r13 = new Helper("ALIGN_VERTICALLY", 3);
            ALIGN_VERTICALLY = r13;
            Helper r14 = new Helper("BARRIER", 4);
            BARRIER = r14;
            Helper r15 = new Helper("LAYER", 5);
            LAYER = r15;
            Helper r16 = new Helper("FLOW", 6);
            FLOW = r16;
            $VALUES = new Helper[]{r10, r11, r12, r13, r14, r15, r16};
        }

        private Helper(String r10, int r11) {
            super(r10, r11);
        }

        public static Helper valueOf(String r10) {
            return (Helper) Enum.valueOf(Helper.class, r10);
        }

        public static Helper[] values() {
            return (Helper[]) $VALUES.clone();
        }
    }
}
