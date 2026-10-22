package androidx.constraintlayout.solver;

import java.util.Arrays;

/* JADX INFO: loaded from: classes17.dex */
public class SolverVariableValues implements ArrayRow.ArrayRowVariables {
    private static final boolean DEBUG = false;
    private static final boolean HASH = true;
    private static float epsilon = 0.001f;
    private int HASH_SIZE;
    private final int NONE;
    private int SIZE;
    int head;
    int[] keys;
    protected final Cache mCache;
    int mCount;
    private final ArrayRow mRow;
    int[] next;
    int[] nextKeys;
    int[] previous;
    float[] values;
    int[] variables;

    private void displayHash() {
        int r100 = 0;
    L4:
        if (r100 >= this.HASH_SIZE) goto L15;
        if (this.keys[r100] == (-1)) goto L14;
        String r101 = hashCode() + " hash [" + r100 + "] => ";
        int r102 = this.keys[r100];
        boolean r103 = false;
    L8:
        if (r103 == true) goto L13;
        r101 = r101 + " " + this.variables[r102];
        int r104 = this.nextKeys[r102];
        if (r104 != (-1)) goto L11;
        r103 = true;
        goto L8
    L11:
        r102 = r104;
        goto L8
    L13:
        System.out.println(r101);
    L14:
        r100 = r100 + 1;
        goto L4
    }

    private int findEmptySlot() {
        int r100 = 0;
    L4:
        if (r100 >= this.SIZE) goto L9;
        if (this.variables[r100] == (-1)) goto L7;
        r100 = r100 + 1;
        goto L4
    L7:
        return r100;
    L9:
        return -1;
    }

    @Override // androidx.constraintlayout.solver.ArrayRow.ArrayRowVariables
    public int sizeInBytes() {
        return 0;
    }

    private void increaseSize() {
        int r100 = this.SIZE * 2;
        this.variables = Arrays.copyOf(this.variables, r100);
        this.values = Arrays.copyOf(this.values, r100);
        this.previous = Arrays.copyOf(this.previous, r100);
        this.next = Arrays.copyOf(this.next, r100);
        this.nextKeys = Arrays.copyOf(this.nextKeys, r100);
        int r101 = this.SIZE;
    L3:
        if (r101 >= r100) goto L5;
        this.variables[r101] = -1;
        this.nextKeys[r101] = -1;
        r101 = r101 + 1;
        goto L3
    L5:
        this.SIZE = r100;
    }

    @Override // androidx.constraintlayout.solver.ArrayRow.ArrayRowVariables
    public void clear() {
        int r100 = this.mCount;
        int r101 = 0;
    L3:
        if (r101 >= r100) goto L8;
        SolverVariable r102 = getVariable(r101);
        if (r102 == null) goto L7;
        r102.removeFromRow(this.mRow);
    L7:
        r101 = r101 + 1;
        goto L3
    L8:
        int r103 = 0;
    L10:
        if (r103 >= this.SIZE) goto L12;
        this.variables[r103] = -1;
        this.nextKeys[r103] = -1;
        r103 = r103 + 1;
        goto L10
    L12:
        int r104 = 0;
    L14:
        if (r104 >= this.HASH_SIZE) goto L16;
        this.keys[r104] = -1;
        r104 = r104 + 1;
        goto L14
    L16:
        this.mCount = 0;
        this.head = -1;
    }

    @Override // androidx.constraintlayout.solver.ArrayRow.ArrayRowVariables
    public void display() {
        int r100 = this.mCount;
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

    @Override // androidx.constraintlayout.solver.ArrayRow.ArrayRowVariables
    public void invert() {
        int r100 = this.mCount;
        int r101 = this.head;
        int r102 = 0;
    L3:
        if (r102 >= r100) goto L8;
        float[] r103 = this.values;
        r103[r101] = r103[r101] * (-1.0f);
        r101 = this.next[r101];
        if (r101 == (-1)) goto L11;
        r102 = r102 + 1;
        goto L3
    L11:
        return;
    }

    public String toString() {
        String r100 = hashCode() + " { ";
        int r101 = this.mCount;
        int r102 = 0;
    L3:
        if (r102 >= r101) goto L18;
        SolverVariable r103 = getVariable(r102);
        if (r103 == null) goto L16;
        String r104 = r100 + r103 + " = " + getVariableValue(r102) + " ";
        int r105 = indexOf(r103);
        String r106 = r104 + "[p: ";
        if (this.previous[r105] == (-1)) goto L10;
        String r107 = r106 + this.mCache.mIndexedVariables[this.variables[this.previous[r105]]];
    L11:
        String r108 = r107 + ", n: ";
        if (this.next[r105] == (-1)) goto L14;
        String r109 = r108 + this.mCache.mIndexedVariables[this.variables[this.next[r105]]];
    L15:
        r100 = r109 + "]";
        goto L16
    L14:
        r109 = r108 + "none";
        goto L15
    L10:
        r107 = r106 + "none";
    L16:
        r102 = r102 + 1;
        goto L3
    L18:
        return r100 + " }";
    }

    @Override // androidx.constraintlayout.solver.ArrayRow.ArrayRowVariables
    public int getCurrentSize() {
        return this.mCount;
    }

    private void removeFromHashMap(SolverVariable r100) {
        int r101 = r100.f15332id;
        int r102 = r101 % this.HASH_SIZE;
        int[] r103 = this.keys;
        int r104 = r103[r102];
        if (r104 != (-1)) goto L6;
        return;
    L6:
        if (this.variables[r104] != r101) goto L8;
        int[] r105 = this.nextKeys;
        r103[r102] = r105[r104];
        r105[r104] = -1;
        return;
    L8:
        int[] r106 = this.nextKeys;
        int r107 = r106[r104];
        if (r107 == (-1)) goto L13;
        if (this.variables[r107] == r101) goto L13;
        r104 = r107;
    L13:
        if (r107 != (-1)) goto L15;
        return;
    L15:
        if (this.variables[r107] != r101) goto L22;
        r106[r104] = r106[r107];
        r106[r107] = -1;
        return;
    }

    @Override // androidx.constraintlayout.solver.ArrayRow.ArrayRowVariables
    public boolean contains(SolverVariable r100) {
        if (indexOf(r100) == (-1)) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // androidx.constraintlayout.solver.ArrayRow.ArrayRowVariables
    public void divideByAmount(float r100) {
        int r101 = this.mCount;
        int r102 = this.head;
        int r103 = 0;
    L3:
        if (r103 >= r101) goto L8;
        float[] r104 = this.values;
        r104[r102] = r104[r102] / r100;
        r102 = this.next[r102];
        if (r102 == (-1)) goto L11;
        r103 = r103 + 1;
        goto L3
    L11:
        return;
    }

    @Override // androidx.constraintlayout.solver.ArrayRow.ArrayRowVariables
    public float get(SolverVariable r100) {
        int r101 = indexOf(r100);
        if (r101 != (-1)) goto L5;
        return 0.0f;
    L5:
        return this.values[r101];
    }

    @Override // androidx.constraintlayout.solver.ArrayRow.ArrayRowVariables
    public SolverVariable getVariable(int r100) {
        int r101 = this.mCount;
        if (r101 != 0) goto L5;
        return null;
    L5:
        int r102 = this.head;
        int r103 = 0;
    L6:
        if (r103 >= r101) goto L16;
        if (r103 != r100) goto L12;
        if (r102 == (-1)) goto L12;
        return this.mCache.mIndexedVariables[this.variables[r102]];
    L12:
        r102 = this.next[r102];
        if (r102 == (-1)) goto L16;
        r103 = r103 + 1;
    L16:
        return null;
    }

    @Override // androidx.constraintlayout.solver.ArrayRow.ArrayRowVariables
    public float getVariableValue(int r100) {
        int r101 = this.mCount;
        int r102 = this.head;
        int r103 = 0;
    L3:
        if (r103 >= r101) goto L11;
        if (r103 == r100) goto L6;
        r102 = this.next[r102];
        if (r102 == (-1)) goto L16;
        r103 = r103 + 1;
        goto L3
    L16:
        return 0.0f;
    L6:
        return this.values[r102];
    L11:
        return 0.0f;
    }

    @Override // androidx.constraintlayout.solver.ArrayRow.ArrayRowVariables
    public int indexOf(SolverVariable r100) {
        if (this.mCount == 0) goto L22;
        if (r100 == null) goto L22;
        int r101 = r100.f15332id;
        int r102 = r101 % this.HASH_SIZE;
        int r103 = this.keys[r102];
        if (r103 != (-1)) goto L10;
        return -1;
    L10:
        if (this.variables[r103] != r101) goto L12;
        return r103;
    L12:
        r103 = this.nextKeys[r103];
        if (r103 == (-1)) goto L17;
        if (this.variables[r103] != r101) goto L12;
    L17:
        if (r103 != (-1)) goto L20;
        return -1;
    L20:
        if (this.variables[r103] != r101) goto L22;
        return r103;
    L22:
        return -1;
    }

    public SolverVariableValues(ArrayRow r100, Cache r101) {
        this.NONE = -1;
        this.SIZE = 16;
        this.HASH_SIZE = 16;
        this.keys = new int[16];
        this.nextKeys = new int[16];
        this.variables = new int[16];
        this.values = new float[16];
        this.previous = new int[16];
        this.next = new int[16];
        this.mCount = 0;
        this.head = -1;
        this.mRow = r100;
        this.mCache = r101;
        clear();
    }

    private void addToHashMap(SolverVariable r100, int r101) {
        int r102 = r100.f15332id % this.HASH_SIZE;
        int[] r103 = this.keys;
        int r104 = r103[r102];
        if (r104 != (-1)) goto L5;
        r103[r102] = r101;
    L9:
        this.nextKeys[r101] = -1;
        return;
    L5:
        int[] r105 = this.nextKeys;
        int r106 = r105[r104];
        if (r106 == (-1)) goto L8;
        r104 = r106;
        goto L5
    L8:
        r105[r104] = r101;
        goto L9
    }

    @Override // androidx.constraintlayout.solver.ArrayRow.ArrayRowVariables
    public void put(SolverVariable r100, float r101) {
        float r102 = epsilon;
        if (r101 > (-r102)) goto L5;
    L8:
        int r103 = 0;
        if (this.mCount != 0) goto L11;
        addVariable(0, r100, r101);
        addToHashMap(r100, 0);
        this.head = 0;
        return;
    L11:
        int r104 = indexOf(r100);
        if (r104 == (-1)) goto L15;
        this.values[r104] = r101;
        return;
    L15:
        if ((this.mCount + 1) < this.SIZE) goto L17;
        increaseSize();
    L17:
        int r105 = this.mCount;
        int r106 = this.head;
        int r107 = -1;
    L18:
        if (r103 >= r105) goto L29;
        int r108 = this.variables[r106];
        int r109 = r100.f15332id;
        if (r108 == r109) goto L21;
        if (r108 >= r109) goto L25;
        r107 = r106;
    L25:
        r106 = this.next[r106];
        if (r106 == (-1)) goto L29;
        r103 = r103 + 1;
        goto L18
    L21:
        this.values[r106] = r101;
        return;
    L29:
        insertVariable(r107, r100, r101);
        return;
    L5:
        if (r101 >= r102) goto L8;
        remove(r100, true);
    }

    @Override // androidx.constraintlayout.solver.ArrayRow.ArrayRowVariables
    public float remove(SolverVariable r100, boolean r101) {
        int r102 = indexOf(r100);
        if (r102 != (-1)) goto L6;
        return 0.0f;
    L6:
        removeFromHashMap(r100);
        float r103 = this.values[r102];
        if (this.head != r102) goto L9;
        this.head = this.next[r102];
    L9:
        this.variables[r102] = -1;
        int[] r104 = this.previous;
        int r105 = r104[r102];
        if (r105 == (-1)) goto L12;
        int[] r106 = this.next;
        r106[r105] = r106[r102];
    L12:
        int r107 = this.next[r102];
        if (r107 == (-1)) goto L15;
        r104[r107] = r104[r102];
    L15:
        this.mCount--;
        r100.usageInRowCount--;
        if (r101 == false) goto L18;
        r100.removeFromRow(this.mRow);
    L18:
        return r103;
    }

    @Override // androidx.constraintlayout.solver.ArrayRow.ArrayRowVariables
    public float use(ArrayRow r100, boolean r101) {
        float r102 = get(r100.variable);
        remove(r100.variable, r101);
        SolverVariableValues r103 = (SolverVariableValues) r100.variables;
        int r104 = r103.getCurrentSize();
        int r105 = 0;
        int r106 = 0;
    L3:
        if (r105 >= r104) goto L8;
        int r107 = r103.variables[r106];
        if (r107 == (-1)) goto L7;
        float r108 = r103.values[r106];
        add(this.mCache.mIndexedVariables[r107], r108 * r102, r101);
        r105 = r105 + 1;
    L7:
        r106 = r106 + 1;
        goto L3
    L8:
        return r102;
    }

    private void addVariable(int r100, SolverVariable r101, float r102) {
        this.variables[r100] = r101.f15332id;
        this.values[r100] = r102;
        this.previous[r100] = -1;
        this.next[r100] = -1;
        r101.addToRow(this.mRow);
        r101.usageInRowCount++;
        this.mCount++;
    }

    private void insertVariable(int r100, SolverVariable r101, float r102) {
        int r103 = findEmptySlot();
        addVariable(r103, r101, r102);
        if (r100 == (-1)) goto L5;
        this.previous[r103] = r100;
        int[] r104 = this.next;
        r104[r103] = r104[r100];
        r104[r100] = r103;
    L9:
        int r105 = this.next[r103];
        if (r105 == (-1)) goto L12;
        this.previous[r105] = r103;
    L12:
        addToHashMap(r101, r103);
        return;
    L5:
        this.previous[r103] = -1;
        if (this.mCount <= 0) goto L8;
        this.next[r103] = this.head;
        this.head = r103;
        goto L9
    L8:
        this.next[r103] = -1;
        goto L9
    }

    @Override // androidx.constraintlayout.solver.ArrayRow.ArrayRowVariables
    public void add(SolverVariable r100, float r101, boolean r102) {
        float r103 = epsilon;
        if (r101 > (-r103)) goto L5;
    L7:
        int r104 = indexOf(r100);
        if (r104 != (-1)) goto L10;
        put(r100, r101);
        return;
    L10:
        float[] r105 = this.values;
        float r106 = r105[r104] + r101;
        r105[r104] = r106;
        float r107 = epsilon;
        if (r106 > (-r107)) goto L13;
        return;
    L13:
        if (r106 >= r107) goto L18;
        r105[r104] = 0.0f;
        remove(r100, r102);
        return;
    L18:
        return;
    L5:
        if (r101 >= r103) goto L7;
    }
}
