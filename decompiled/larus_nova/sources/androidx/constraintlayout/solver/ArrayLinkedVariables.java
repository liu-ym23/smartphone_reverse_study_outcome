package androidx.constraintlayout.solver;

import java.util.Arrays;

/* JADX INFO: loaded from: classes3.dex */
public class ArrayLinkedVariables implements ArrayRow.ArrayRowVariables {
    private static final boolean DEBUG = false;
    private static final boolean FULL_NEW_CHECK = false;
    static final int NONE = -1;
    private static float epsilon = 0.001f;
    private int ROW_SIZE;
    private SolverVariable candidate;
    int currentSize;
    private int[] mArrayIndices;
    private int[] mArrayNextIndices;
    private float[] mArrayValues;
    protected final Cache mCache;
    private boolean mDidFillOnce;
    private int mHead;
    private int mLast;
    private final ArrayRow mRow;

    @Override // androidx.constraintlayout.solver.ArrayRow.ArrayRowVariables
    public final void clear() {
        int r100 = this.mHead;
        int r101 = 0;
    L4:
        if (r100 == (-1)) goto L11;
        if (r101 >= this.currentSize) goto L11;
        SolverVariable r102 = this.mCache.mIndexedVariables[this.mArrayIndices[r100]];
        if (r102 == null) goto L10;
        r102.removeFromRow(this.mRow);
    L10:
        r100 = this.mArrayNextIndices[r100];
        r101 = r101 + 1;
    L11:
        this.mHead = -1;
        this.mLast = -1;
        this.mDidFillOnce = false;
        this.currentSize = 0;
    }

    @Override // androidx.constraintlayout.solver.ArrayRow.ArrayRowVariables
    public void display() {
        int r100 = this.currentSize;
        System.out.print("{ ");
        int r101 = 0;
    L3:
        if (r101 >= r100) goto L9;
        SolverVariable r102 = getVariable(r101);
        if (r102 == null) goto L8;
        System.out.print(r102 + " = " + getVariableValue(r101) + " ");
    L8:
        r101 = r101 + 1;
        goto L3
    L9:
        System.out.println(" }");
    }

    public SolverVariable getPivotCandidate() {
        SolverVariable r100 = this.candidate;
        if (r100 != null) goto L18;
        int r101 = this.mHead;
        int r102 = 0;
        SolverVariable r103 = null;
    L6:
        if (r101 == (-1)) goto L17;
        if (r102 >= this.currentSize) goto L17;
        if (this.mArrayValues[r101] >= 0.0f) goto L16;
        SolverVariable r104 = this.mCache.mIndexedVariables[this.mArrayIndices[r101]];
        if (r103 != null) goto L14;
    L15:
        r103 = r104;
        goto L16
    L14:
        if (r103.strength < r104.strength) goto L15;
    L16:
        r101 = this.mArrayNextIndices[r101];
        r102 = r102 + 1;
    L17:
        return r103;
    L18:
        return r100;
    }

    public boolean hasAtLeastOnePositiveVariable() {
        int r100 = this.mHead;
        int r101 = 0;
    L4:
        if (r100 == (-1)) goto L12;
        if (r101 >= this.currentSize) goto L12;
        if (this.mArrayValues[r100] > 0.0f) goto L9;
        r100 = this.mArrayNextIndices[r100];
        r101 = r101 + 1;
        goto L4
    L9:
        return true;
    L12:
        return false;
    }

    @Override // androidx.constraintlayout.solver.ArrayRow.ArrayRowVariables
    public void invert() {
        int r100 = this.mHead;
        int r101 = 0;
    L4:
        if (r100 == (-1)) goto L8;
        if (r101 >= this.currentSize) goto L11;
        float[] r102 = this.mArrayValues;
        r102[r100] = r102[r100] * (-1.0f);
        r100 = this.mArrayNextIndices[r100];
        r101 = r101 + 1;
        goto L4
    L11:
        return;
    }

    @Override // androidx.constraintlayout.solver.ArrayRow.ArrayRowVariables
    public int sizeInBytes() {
        return (((this.mArrayIndices.length * 4) * 3) + 0) + 36;
    }

    public String toString() {
        int r100 = this.mHead;
        String r101 = "";
        int r102 = 0;
    L4:
        if (r100 == (-1)) goto L8;
        if (r102 >= this.currentSize) goto L8;
        r101 = ((r101 + " -> ") + this.mArrayValues[r100] + " : ") + this.mCache.mIndexedVariables[this.mArrayIndices[r100]];
        r100 = this.mArrayNextIndices[r100];
        r102 = r102 + 1;
    L8:
        return r101;
    }

    @Override // androidx.constraintlayout.solver.ArrayRow.ArrayRowVariables
    public int getCurrentSize() {
        return this.currentSize;
    }

    public int getHead() {
        return this.mHead;
    }

    @Override // androidx.constraintlayout.solver.ArrayRow.ArrayRowVariables
    public boolean contains(SolverVariable r100) {
        int r101 = this.mHead;
        if (r101 != (-1)) goto L5;
        return false;
    L5:
        int r102 = 0;
    L6:
        if (r101 == (-1)) goto L14;
        if (r102 >= this.currentSize) goto L14;
        if (this.mArrayIndices[r101] == r100.f15332id) goto L11;
        r101 = this.mArrayNextIndices[r101];
        r102 = r102 + 1;
        goto L6
    L11:
        return true;
    L14:
        return false;
    }

    @Override // androidx.constraintlayout.solver.ArrayRow.ArrayRowVariables
    public void divideByAmount(float r100) {
        int r101 = this.mHead;
        int r102 = 0;
    L4:
        if (r101 == (-1)) goto L8;
        if (r102 >= this.currentSize) goto L11;
        float[] r103 = this.mArrayValues;
        r103[r101] = r103[r101] / r100;
        r101 = this.mArrayNextIndices[r101];
        r102 = r102 + 1;
        goto L4
    L11:
        return;
    }

    @Override // androidx.constraintlayout.solver.ArrayRow.ArrayRowVariables
    public final float get(SolverVariable r100) {
        int r101 = this.mHead;
        int r102 = 0;
    L4:
        if (r101 == (-1)) goto L12;
        if (r102 >= this.currentSize) goto L17;
        if (this.mArrayIndices[r101] == r100.f15332id) goto L10;
        r101 = this.mArrayNextIndices[r101];
        r102 = r102 + 1;
        goto L4
    L10:
        return this.mArrayValues[r101];
    L17:
        return 0.0f;
    L12:
        return 0.0f;
    }

    public final int getId(int r100) {
        return this.mArrayIndices[r100];
    }

    public final int getNextIndice(int r100) {
        return this.mArrayNextIndices[r100];
    }

    public final float getValue(int r100) {
        return this.mArrayValues[r100];
    }

    @Override // androidx.constraintlayout.solver.ArrayRow.ArrayRowVariables
    public SolverVariable getVariable(int r100) {
        int r101 = this.mHead;
        int r102 = 0;
    L4:
        if (r101 == (-1)) goto L11;
        if (r102 >= this.currentSize) goto L16;
        if (r102 == r100) goto L9;
        r101 = this.mArrayNextIndices[r101];
        r102 = r102 + 1;
        goto L4
    L9:
        return this.mCache.mIndexedVariables[this.mArrayIndices[r101]];
    L16:
        return null;
    L11:
        return null;
    }

    @Override // androidx.constraintlayout.solver.ArrayRow.ArrayRowVariables
    public float getVariableValue(int r100) {
        int r101 = this.mHead;
        int r102 = 0;
    L4:
        if (r101 == (-1)) goto L11;
        if (r102 >= this.currentSize) goto L16;
        if (r102 == r100) goto L9;
        r101 = this.mArrayNextIndices[r101];
        r102 = r102 + 1;
        goto L4
    L9:
        return this.mArrayValues[r101];
    L16:
        return 0.0f;
    L11:
        return 0.0f;
    }

    @Override // androidx.constraintlayout.solver.ArrayRow.ArrayRowVariables
    public int indexOf(SolverVariable r100) {
        int r101 = this.mHead;
        if (r101 != (-1)) goto L5;
        return -1;
    L5:
        int r102 = 0;
    L6:
        if (r101 == (-1)) goto L13;
        if (r102 >= this.currentSize) goto L13;
        if (this.mArrayIndices[r101] == r100.f15332id) goto L11;
        r101 = this.mArrayNextIndices[r101];
        r102 = r102 + 1;
        goto L6
    L11:
        return r101;
    L13:
        return -1;
    }

    public ArrayLinkedVariables(ArrayRow r100, Cache r101) {
        this.currentSize = 0;
        this.ROW_SIZE = 8;
        this.candidate = null;
        this.mArrayIndices = new int[8];
        this.mArrayNextIndices = new int[8];
        this.mArrayValues = new float[8];
        this.mHead = -1;
        this.mLast = -1;
        this.mDidFillOnce = false;
        this.mRow = r100;
        this.mCache = r101;
    }

    @Override // androidx.constraintlayout.solver.ArrayRow.ArrayRowVariables
    public final void put(SolverVariable r100, float r110) {
        if (r110 != 0.0f) goto L6;
        remove(r100, true);
        return;
    L6:
        int r101 = this.mHead;
        if (r101 != (-1)) goto L14;
        this.mHead = 0;
        this.mArrayValues[0] = r110;
        this.mArrayIndices[0] = r100.f15332id;
        this.mArrayNextIndices[0] = -1;
        r100.usageInRowCount++;
        r100.addToRow(this.mRow);
        this.currentSize++;
        if (this.mDidFillOnce == true) goto L67;
        int r102 = this.mLast + 1;
        this.mLast = r102;
        int[] r111 = this.mArrayIndices;
        if (r102 < r111.length) goto L68;
        this.mDidFillOnce = true;
        this.mLast = r111.length - 1;
        return;
    L68:
        return;
    L67:
        return;
    L14:
        int r103 = 0;
        int r104 = -1;
    L15:
        if (r101 == (-1)) goto L25;
        if (r103 >= this.currentSize) goto L25;
        int r105 = this.mArrayIndices[r101];
        int r106 = r100.f15332id;
        if (r105 == r106) goto L20;
        if (r105 >= r106) goto L24;
        r104 = r101;
    L24:
        r101 = this.mArrayNextIndices[r101];
        r103 = r103 + 1;
        goto L15
    L20:
        this.mArrayValues[r101] = r110;
        return;
    L25:
        int r107 = this.mLast;
        int r108 = r107 + 1;
        if (this.mDidFillOnce == false) goto L31;
        int[] r109 = this.mArrayIndices;
        if (r109[r107] == (-1)) goto L32;
        r107 = r109.length;
    L32:
        int[] r112 = this.mArrayIndices;
        if (r107 >= r112.length) goto L35;
    L43:
        int[] r113 = this.mArrayIndices;
        if (r107 < r113.length) goto L46;
        r107 = r113.length;
        int r114 = this.ROW_SIZE * 2;
        this.ROW_SIZE = r114;
        this.mDidFillOnce = false;
        this.mLast = r107 - 1;
        this.mArrayValues = Arrays.copyOf(this.mArrayValues, r114);
        this.mArrayIndices = Arrays.copyOf(this.mArrayIndices, this.ROW_SIZE);
        this.mArrayNextIndices = Arrays.copyOf(this.mArrayNextIndices, this.ROW_SIZE);
    L46:
        this.mArrayIndices[r107] = r100.f15332id;
        this.mArrayValues[r107] = r110;
        if (r104 == (-1)) goto L49;
        int[] r115 = this.mArrayNextIndices;
        r115[r107] = r115[r104];
        r115[r104] = r107;
    L50:
        r100.usageInRowCount++;
        r100.addToRow(this.mRow);
        int r116 = this.currentSize + 1;
        this.currentSize = r116;
        if (this.mDidFillOnce == true) goto L53;
        this.mLast++;
    L53:
        int[] r117 = this.mArrayIndices;
        if (r116 < r117.length) goto L57;
        this.mDidFillOnce = true;
    L57:
        if (this.mLast < r117.length) goto L69;
        this.mDidFillOnce = true;
        this.mLast = r117.length - 1;
        return;
    L69:
        return;
    L49:
        this.mArrayNextIndices[r107] = this.mHead;
        this.mHead = r107;
        goto L50
    L35:
        if (this.currentSize >= r112.length) goto L43;
        int r118 = 0;
    L37:
        int[] r119 = this.mArrayIndices;
        if (r118 >= r119.length) goto L43;
        if (r119[r118] == (-1)) goto L41;
        r118 = r118 + 1;
        goto L37
    L41:
        r107 = r118;
        goto L43
    L31:
        r107 = r108;
        goto L32
    }

    @Override // androidx.constraintlayout.solver.ArrayRow.ArrayRowVariables
    public final float remove(SolverVariable r100, boolean r110) {
        if (this.candidate != r100) goto L5;
        this.candidate = null;
    L5:
        int r101 = this.mHead;
        if (r101 != (-1)) goto L8;
        return 0.0f;
    L8:
        int r102 = 0;
        int r103 = -1;
    L9:
        if (r101 == (-1)) goto L26;
        if (r102 >= this.currentSize) goto L26;
        if (this.mArrayIndices[r101] == r100.f15332id) goto L15;
        r102 = r102 + 1;
        r103 = r101;
        r101 = this.mArrayNextIndices[r101];
        goto L9
    L15:
        if (r101 != this.mHead) goto L17;
        this.mHead = this.mArrayNextIndices[r101];
    L18:
        if (r110 == false) goto L20;
        r100.removeFromRow(this.mRow);
    L20:
        r100.usageInRowCount--;
        this.currentSize--;
        this.mArrayIndices[r101] = -1;
        if (this.mDidFillOnce == false) goto L24;
        this.mLast = r101;
    L24:
        return this.mArrayValues[r101];
    L17:
        int[] r104 = this.mArrayNextIndices;
        r104[r103] = r104[r101];
    L26:
        return 0.0f;
    }

    @Override // androidx.constraintlayout.solver.ArrayRow.ArrayRowVariables
    public float use(ArrayRow r100, boolean r101) {
        float r102 = get(r100.variable);
        remove(r100.variable, r101);
        ArrayRow.ArrayRowVariables r103 = r100.variables;
        int r104 = r103.getCurrentSize();
        int r105 = 0;
    L3:
        if (r105 >= r104) goto L5;
        SolverVariable r106 = r103.getVariable(r105);
        add(r106, r103.get(r106) * r102, r101);
        r105 = r105 + 1;
        goto L3
    L5:
        return r102;
    }

    @Override // androidx.constraintlayout.solver.ArrayRow.ArrayRowVariables
    public void add(SolverVariable r100, float r110, boolean r111) {
        float r101 = epsilon;
        if (r110 > (-r101)) goto L5;
    L7:
        int r102 = this.mHead;
        if (r102 != (-1)) goto L15;
        this.mHead = 0;
        this.mArrayValues[0] = r110;
        this.mArrayIndices[0] = r100.f15332id;
        this.mArrayNextIndices[0] = -1;
        r100.usageInRowCount++;
        r100.addToRow(this.mRow);
        this.currentSize++;
        if (this.mDidFillOnce == true) goto L81;
        int r103 = this.mLast + 1;
        this.mLast = r103;
        int[] r112 = this.mArrayIndices;
        if (r103 < r112.length) goto L82;
        this.mDidFillOnce = true;
        this.mLast = r112.length - 1;
        return;
    L82:
        return;
    L81:
        return;
    L15:
        int r104 = 0;
        int r105 = -1;
    L16:
        if (r102 == (-1)) goto L42;
        if (r104 >= this.currentSize) goto L42;
        int r106 = this.mArrayIndices[r102];
        int r107 = r100.f15332id;
        if (r106 == r107) goto L21;
        if (r106 >= r107) goto L41;
        r105 = r102;
    L41:
        r102 = this.mArrayNextIndices[r102];
        r104 = r104 + 1;
        goto L16
    L21:
        float[] r108 = this.mArrayValues;
        float r109 = r108[r102] + r110;
        float r113 = epsilon;
        if (r109 > (-r113)) goto L24;
    L26:
        r108[r102] = r109;
        if (r109 == 0.0f) goto L29;
        return;
    L29:
        if (r102 != this.mHead) goto L31;
        this.mHead = this.mArrayNextIndices[r102];
    L32:
        if (r111 == false) goto L35;
        r100.removeFromRow(this.mRow);
    L35:
        if (this.mDidFillOnce == false) goto L37;
        this.mLast = r102;
    L37:
        r100.usageInRowCount--;
        this.currentSize--;
        return;
    L31:
        int[] r114 = this.mArrayNextIndices;
        r114[r105] = r114[r102];
        goto L32
    L24:
        if (r109 >= r113) goto L26;
        r109 = 0.0f;
    L42:
        int r115 = this.mLast;
        int r116 = r115 + 1;
        if (this.mDidFillOnce == false) goto L48;
        int[] r117 = this.mArrayIndices;
        if (r117[r115] == (-1)) goto L49;
        r115 = r117.length;
    L49:
        int[] r118 = this.mArrayIndices;
        if (r115 >= r118.length) goto L52;
    L60:
        int[] r119 = this.mArrayIndices;
        if (r115 < r119.length) goto L63;
        r115 = r119.length;
        int r120 = this.ROW_SIZE * 2;
        this.ROW_SIZE = r120;
        this.mDidFillOnce = false;
        this.mLast = r115 - 1;
        this.mArrayValues = Arrays.copyOf(this.mArrayValues, r120);
        this.mArrayIndices = Arrays.copyOf(this.mArrayIndices, this.ROW_SIZE);
        this.mArrayNextIndices = Arrays.copyOf(this.mArrayNextIndices, this.ROW_SIZE);
    L63:
        this.mArrayIndices[r115] = r100.f15332id;
        this.mArrayValues[r115] = r110;
        if (r105 == (-1)) goto L66;
        int[] r121 = this.mArrayNextIndices;
        r121[r115] = r121[r105];
        r121[r105] = r115;
    L67:
        r100.usageInRowCount++;
        r100.addToRow(this.mRow);
        this.currentSize++;
        if (this.mDidFillOnce == true) goto L70;
        this.mLast++;
    L70:
        int r122 = this.mLast;
        int[] r123 = this.mArrayIndices;
        if (r122 < r123.length) goto L84;
        this.mDidFillOnce = true;
        this.mLast = r123.length - 1;
        return;
    L84:
        return;
    L66:
        this.mArrayNextIndices[r115] = this.mHead;
        this.mHead = r115;
        goto L67
    L52:
        if (this.currentSize >= r118.length) goto L60;
        int r124 = 0;
    L54:
        int[] r125 = this.mArrayIndices;
        if (r124 >= r125.length) goto L60;
        if (r125[r124] == (-1)) goto L58;
        r124 = r124 + 1;
        goto L54
    L58:
        r115 = r124;
        goto L60
    L48:
        r115 = r116;
        goto L49
    L5:
        if (r110 >= r101) goto L7;
    }
}
