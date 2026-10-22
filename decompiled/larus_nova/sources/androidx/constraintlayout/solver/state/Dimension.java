package androidx.constraintlayout.solver.state;

import androidx.constraintlayout.solver.widgets.ConstraintWidget;
import r27.a;

/* JADX INFO: loaded from: classes17.dex */
public class Dimension {
    public static final Object FIXED_DIMENSION = null;
    public static final Object PARENT_DIMENSION = null;
    public static final Object PERCENT_DIMENSION = null;
    public static final Object SPREAD_DIMENSION = null;
    public static final Object WRAP_DIMENSION = null;
    private final int WRAP_CONTENT;
    Object mInitialValue;
    boolean mIsSuggested;
    int mMax;
    int mMin;
    float mPercent;
    float mRatio;
    int mValue;

    public static final enum Type extends Enum<Type> {
        private static final /* synthetic */ Type[] $VALUES = null;
        public static final Type FIXED = null;
        public static final Type MATCH_CONSTRAINT = null;
        public static final Type MATCH_PARENT = null;
        public static final Type WRAP = null;

        static {
            Type r100 = new Type("FIXED", 0);
            FIXED = r100;
            Type r101 = new Type("WRAP", 1);
            WRAP = r101;
            Type r102 = new Type("MATCH_PARENT", 2);
            MATCH_PARENT = r102;
            Type r103 = new Type("MATCH_CONSTRAINT", 3);
            MATCH_CONSTRAINT = r103;
            $VALUES = new Type[]{r100, r101, r102, r103};
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

    public Dimension ratio(float r100) {
        return this;
    }

    static {
        FIXED_DIMENSION = new Object();
        WRAP_DIMENSION = new Object();
        SPREAD_DIMENSION = new Object();
        PARENT_DIMENSION = new Object();
        PERCENT_DIMENSION = new Object();
    }

    public static Dimension Parent() {
        return new Dimension(PARENT_DIMENSION);
    }

    public static Dimension Spread() {
        return new Dimension(SPREAD_DIMENSION);
    }

    public static Dimension Wrap() {
        return new Dimension(WRAP_DIMENSION);
    }

    private Dimension() {
        this.WRAP_CONTENT = -2;
        this.mMin = 0;
        this.mMax = Integer.MAX_VALUE;
        this.mPercent = 1.0f;
        this.mValue = 0;
        this.mRatio = 1.0f;
        this.mInitialValue = WRAP_DIMENSION;
        this.mIsSuggested = false;
    }

    public float getRatio() {
        return this.mRatio;
    }

    public int getValue() {
        return this.mValue;
    }

    private Dimension(Object r100) {
        this.WRAP_CONTENT = -2;
        this.mMin = 0;
        this.mMax = Integer.MAX_VALUE;
        this.mPercent = 1.0f;
        this.mValue = 0;
        this.mRatio = 1.0f;
        this.mIsSuggested = false;
        this.mInitialValue = r100;
    }

    public static Dimension Fixed(int r100) {
        Dimension r101 = new Dimension(FIXED_DIMENSION);
        r101.fixed(r100);
        return r101;
    }

    public static Dimension Suggested(int r100) {
        Dimension r101 = new Dimension();
        r101.suggested(r100);
        return r101;
    }

    public Dimension fixed(Object r100) {
        this.mInitialValue = r100;
        if ((r100 instanceof Integer) == false) goto L5;
        this.mValue = ((Integer) r100).intValue();
        this.mInitialValue = null;
    L5:
        return this;
    }

    public Dimension max(Object r100) {
        Object r101 = WRAP_DIMENSION;
        if (r100 == r101) goto L5;
    L7:
        return this;
    L5:
        if (this.mIsSuggested == false) goto L7;
        this.mInitialValue = r101;
        this.mMax = Integer.MAX_VALUE;
        goto L7
    }

    public Dimension min(Object r100) {
        if (r100 != WRAP_DIMENSION) goto L5;
        this.mMin = -2;
    L5:
        return this;
    }

    public void setRatio(float r100) {
        this.mRatio = r100;
    }

    public void setValue(int r100) {
        this.mIsSuggested = false;
        this.mInitialValue = null;
        this.mValue = r100;
    }

    public Dimension suggested(Object r100) {
        this.mInitialValue = r100;
        this.mIsSuggested = true;
        return this;
    }

    public static Dimension Fixed(Object r100) {
        Dimension r101 = new Dimension(FIXED_DIMENSION);
        r101.fixed(r100);
        return r101;
    }

    public static Dimension Suggested(Object r100) {
        Dimension r101 = new Dimension();
        r101.suggested(r100);
        return r101;
    }

    public Dimension fixed(int r100) {
        this.mInitialValue = null;
        this.mValue = r100;
        return this;
    }

    public Dimension max(int r100) {
        if (this.mMax < 0) goto L5;
        this.mMax = r100;
    L5:
        return this;
    }

    public Dimension min(int r100) {
        if (r100 < 0) goto L4;
        this.mMin = r100;
    L4:
        return this;
    }

    public Dimension suggested(int r100) {
        this.mIsSuggested = true;
        return this;
    }

    public static Dimension Percent(Object r100, float r101) {
        Dimension r102 = new Dimension(PERCENT_DIMENSION);
        r102.percent(r100, r101);
        return r102;
    }

    public Dimension percent(Object r100, float r101) {
        this.mPercent = r101;
        return this;
    }

    public void apply(State r100, ConstraintWidget r101, int r102) {
        int r103 = 2;
        if (r102 != 0) goto L29;
        if (this.mIsSuggested == false) goto L14;
        r101.setHorizontalDimensionBehaviour(ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT);
        Object r104 = this.mInitialValue;
        if (r104 != WRAP_DIMENSION) goto L10;
        r103 = 1;
    L13:
        r101.setHorizontalMatchStyle(r103, this.mMin, this.mMax, this.mPercent);
        return;
    L10:
        if (r104 == PERCENT_DIMENSION) goto L13;
        r103 = 0;
        goto L13
    L14:
        int r105 = this.mMin;
        if (r105 <= 0) goto L17;
        r101.setMinWidth(r105);
    L17:
        int r106 = this.mMax;
        if (r106 >= Integer.MAX_VALUE) goto L20;
        r101.setMaxWidth(r106);
    L20:
        Object r107 = this.mInitialValue;
        if (r107 != WRAP_DIMENSION) goto L24;
        r101.setHorizontalDimensionBehaviour(ConstraintWidget.DimensionBehaviour.WRAP_CONTENT);
        return;
    L24:
        if (r107 != PARENT_DIMENSION) goto L26;
        r101.setHorizontalDimensionBehaviour(ConstraintWidget.DimensionBehaviour.MATCH_PARENT);
        return;
    L26:
        if (r107 != null) goto L56;
        r101.setHorizontalDimensionBehaviour(ConstraintWidget.DimensionBehaviour.FIXED);
        r101.setWidth(this.mValue);
        return;
    L56:
        return;
    L29:
        if (this.mIsSuggested == false) goto L38;
        r101.setVerticalDimensionBehaviour(ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT);
        Object r108 = this.mInitialValue;
        if (r108 != WRAP_DIMENSION) goto L34;
        r103 = 1;
    L37:
        r101.setVerticalMatchStyle(r103, this.mMin, this.mMax, this.mPercent);
        return;
    L34:
        if (r108 == PERCENT_DIMENSION) goto L37;
        r103 = 0;
        goto L37
    L38:
        int r109 = this.mMin;
        if (r109 <= 0) goto L41;
        r101.setMinHeight(r109);
    L41:
        int r110 = this.mMax;
        if (r110 >= Integer.MAX_VALUE) goto L44;
        r101.setMaxHeight(r110);
    L44:
        Object r111 = this.mInitialValue;
        if (r111 != WRAP_DIMENSION) goto L48;
        r101.setVerticalDimensionBehaviour(ConstraintWidget.DimensionBehaviour.WRAP_CONTENT);
        return;
    L48:
        if (r111 != PARENT_DIMENSION) goto L50;
        r101.setVerticalDimensionBehaviour(ConstraintWidget.DimensionBehaviour.MATCH_PARENT);
        return;
    L50:
        if (r111 != null) goto L61;
        r101.setVerticalDimensionBehaviour(ConstraintWidget.DimensionBehaviour.FIXED);
        r101.setHeight(this.mValue);
        return;
    }
}
