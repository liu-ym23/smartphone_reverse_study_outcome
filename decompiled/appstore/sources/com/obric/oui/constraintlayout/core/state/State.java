package com.obric.oui.constraintlayout.core.state;

import io.reactivex.annotations.SchedulerSupport;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes4.dex */
public abstract class State {

    public static final enum Chain extends Enum<Chain> {
        private static final /* synthetic */ Chain[] $VALUES = null;
        public static final Chain PACKED = null;
        public static final Chain SPREAD = null;
        public static final Chain SPREAD_INSIDE = null;
        public static Map<String, Chain> chainMap;
        public static Map<String, Integer> valueMap;

        static {
            Chain r10 = new Chain("SPREAD", 0);
            SPREAD = r10;
            Chain r11 = new Chain("SPREAD_INSIDE", 1);
            SPREAD_INSIDE = r11;
            Chain r12 = new Chain("PACKED", 2);
            PACKED = r12;
            $VALUES = new Chain[]{r10, r11, r12};
            chainMap = new HashMap();
            valueMap = new HashMap();
            chainMap.put("packed", r12);
            chainMap.put("spread_inside", r11);
            chainMap.put("spread", r10);
            valueMap.put("packed", 2);
            valueMap.put("spread_inside", 1);
            valueMap.put("spread", 0);
        }

        private Chain(String r10, int r11) {
            super(r10, r11);
        }

        public static Chain getChainByString(String r10) {
            if (chainMap.containsKey(r10) == true) goto L5;
            return null;
        L5:
            return chainMap.get(r10);
        }

        public static int getValueByString(String r10) {
            if (valueMap.containsKey(r10) == true) goto L5;
            return -1;
        L5:
            return valueMap.get(r10).intValue();
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
        public static final Constraint BOTTOM_TO_BASELINE = null;
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
        public static final Constraint TOP_TO_BASELINE = null;
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
            Constraint r110 = new Constraint("TOP_TO_BASELINE", 10);
            TOP_TO_BASELINE = r110;
            Constraint r111 = new Constraint("BOTTOM_TO_TOP", 11);
            BOTTOM_TO_TOP = r111;
            Constraint r112 = new Constraint("BOTTOM_TO_BOTTOM", 12);
            BOTTOM_TO_BOTTOM = r112;
            Constraint r113 = new Constraint("BOTTOM_TO_BASELINE", 13);
            BOTTOM_TO_BASELINE = r113;
            Constraint r20 = new Constraint("BASELINE_TO_BASELINE", 14);
            BASELINE_TO_BASELINE = r20;
            Constraint r21 = new Constraint("BASELINE_TO_TOP", 15);
            BASELINE_TO_TOP = r21;
            Constraint r22 = new Constraint("BASELINE_TO_BOTTOM", 16);
            BASELINE_TO_BOTTOM = r22;
            Constraint r23 = new Constraint("CENTER_HORIZONTALLY", 17);
            CENTER_HORIZONTALLY = r23;
            Constraint r24 = new Constraint("CENTER_VERTICALLY", 18);
            CENTER_VERTICALLY = r24;
            Constraint r25 = new Constraint("CIRCULAR_CONSTRAINT", 19);
            CIRCULAR_CONSTRAINT = r25;
            $VALUES = new Constraint[]{r10, r11, r12, r13, r14, r15, r16, r17, r18, r19, r110, r111, r112, r113, r20, r21, r22, r23, r24, r25};
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
        public static final Helper COLUMN = null;
        public static final Helper FLOW = null;
        public static final Helper GRID = null;
        public static final Helper HORIZONTAL_CHAIN = null;
        public static final Helper HORIZONTAL_FLOW = null;
        public static final Helper LAYER = null;
        public static final Helper ROW = null;
        public static final Helper VERTICAL_CHAIN = null;
        public static final Helper VERTICAL_FLOW = null;

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
            Helper r16 = new Helper("HORIZONTAL_FLOW", 6);
            HORIZONTAL_FLOW = r16;
            Helper r17 = new Helper("VERTICAL_FLOW", 7);
            VERTICAL_FLOW = r17;
            Helper r18 = new Helper("GRID", 8);
            GRID = r18;
            Helper r19 = new Helper("ROW", 9);
            ROW = r19;
            Helper r110 = new Helper("COLUMN", 10);
            COLUMN = r110;
            Helper r111 = new Helper("FLOW", 11);
            FLOW = r111;
            $VALUES = new Helper[]{r10, r11, r12, r13, r14, r15, r16, r17, r18, r19, r110, r111};
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

    public static final enum Wrap extends Enum<Wrap> {
        private static final /* synthetic */ Wrap[] $VALUES = null;
        public static final Wrap ALIGNED = null;
        public static final Wrap CHAIN = null;
        public static final Wrap NONE = null;
        public static Map<String, Integer> valueMap;
        public static Map<String, Wrap> wrapMap;

        static {
            Wrap r10 = new Wrap("NONE", 0);
            NONE = r10;
            Wrap r11 = new Wrap("CHAIN", 1);
            CHAIN = r11;
            Wrap r12 = new Wrap("ALIGNED", 2);
            ALIGNED = r12;
            $VALUES = new Wrap[]{r10, r11, r12};
            wrapMap = new HashMap();
            valueMap = new HashMap();
            wrapMap.put(SchedulerSupport.NONE, r10);
            wrapMap.put("chain", r11);
            wrapMap.put("aligned", r12);
            valueMap.put(SchedulerSupport.NONE, 0);
            valueMap.put("chain", 3);
            valueMap.put("aligned", 2);
        }

        private Wrap(String r10, int r11) {
            super(r10, r11);
        }

        public static Wrap getChainByString(String r10) {
            if (wrapMap.containsKey(r10) == true) goto L5;
            return null;
        L5:
            return wrapMap.get(r10);
        }

        public static int getValueByString(String r10) {
            if (valueMap.containsKey(r10) == true) goto L5;
            return -1;
        L5:
            return valueMap.get(r10).intValue();
        }

        public static Wrap valueOf(String r10) {
            return (Wrap) Enum.valueOf(Wrap.class, r10);
        }

        public static Wrap[] values() {
            return (Wrap[]) $VALUES.clone();
        }
    }
}
