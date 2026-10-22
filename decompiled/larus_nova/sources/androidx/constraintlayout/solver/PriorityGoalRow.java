package androidx.constraintlayout.solver;

import java.util.Arrays;

/* JADX INFO: loaded from: classes3.dex */
public class PriorityGoalRow extends ArrayRow {
    private static final boolean DEBUG = false;
    static final int NOT_FOUND = -1;
    private static final float epsilon = 1.0E-4f;
    private int TABLE_SIZE;
    GoalVariableAccessor accessor;
    private SolverVariable[] arrayGoals;
    Cache mCache;
    private int numGoals;
    private SolverVariable[] sortArray;

    public class GoalVariableAccessor implements Comparable {
        PriorityGoalRow row;
        final /* synthetic */ PriorityGoalRow this$0;
        SolverVariable variable;

        public final boolean isNull() {
            int r100 = 0;
        L4:
            if (r100 >= 9) goto L9;
            if (this.variable.goalStrengthVector[r100] != 0.0f) goto L7;
            r100 = r100 + 1;
            goto L4
        L7:
            return false;
        L9:
            return true;
        }

        public final boolean isNegative() {
            int r100 = 8;
        L4:
            if (r100 < 0) goto L13;
            float r101 = this.variable.goalStrengthVector[r100];
            if (r101 > 0.0f) goto L7;
            if (r101 < 0.0f) goto L10;
            r100 = r100 - 1;
            goto L4
        L10:
            return true;
        L7:
            return false;
        L13:
            return false;
        }

        public void reset() {
            Arrays.fill(this.variable.goalStrengthVector, 0.0f);
        }

        public String toString() {
            String r100 = "[ ";
            if (this.variable == null) goto L9;
            int r101 = 0;
        L6:
            if (r101 >= 9) goto L9;
            r100 = r100 + this.variable.goalStrengthVector[r101] + " ";
            r101 = r101 + 1;
        L9:
            return r100 + "] " + this.variable;
        }

        public void add(SolverVariable r100) {
            int r101 = 0;
        L4:
            if (r101 >= 9) goto L9;
            float[] r102 = this.variable.goalStrengthVector;
            float r103 = r102[r101] + r100.goalStrengthVector[r101];
            r102[r101] = r103;
            if (Math.abs(r103) >= 1.0E-4f) goto L8;
            this.variable.goalStrengthVector[r101] = 0.0f;
        L8:
            r101 = r101 + 1;
            goto L4
        }

        @Override // java.lang.Comparable
        public int compareTo(Object r100) {
            return this.variable.f15332id - ((SolverVariable) r100).f15332id;
        }

        public void init(SolverVariable r100) {
            this.variable = r100;
        }

        public final boolean isSmallerThan(SolverVariable r100) {
            int r101 = 8;
        L4:
            if (r101 < 0) goto L12;
            float r102 = r100.goalStrengthVector[r101];
            float r103 = this.variable.goalStrengthVector[r101];
            if (r103 != r102) goto L9;
            r101 = r101 - 1;
            goto L4
        L9:
            if (r103 >= r102) goto L12;
            return true;
        L12:
            return false;
        }

        public GoalVariableAccessor(PriorityGoalRow r100, PriorityGoalRow r101) {
            this.this$0 = r100;
            this.row = r101;
        }

        public boolean addToGoal(SolverVariable r110, float r111) {
            boolean r100 = true;
            int r101 = 0;
            if (this.variable.inGoal == false) goto L14;
            int r102 = 0;
        L5:
            if (r102 >= 9) goto L11;
            float[] r103 = this.variable.goalStrengthVector;
            float r104 = r103[r102] + (r110.goalStrengthVector[r102] * r111);
            r103[r102] = r104;
            if (Math.abs(r104) >= 1.0E-4f) goto L9;
            this.variable.goalStrengthVector[r102] = 0.0f;
        L10:
            r102 = r102 + 1;
            goto L5
        L9:
            r100 = false;
            goto L10
        L11:
            if (r100 == false) goto L13;
            PriorityGoalRow.access$000(this.this$0, this.variable);
        L13:
            return false;
        L14:
            if (r101 >= 9) goto L23;
            float r105 = r110.goalStrengthVector[r101];
            if (r105 == 0.0f) goto L21;
            float r106 = r105 * r111;
            if (Math.abs(r106) >= 1.0E-4f) goto L20;
            r106 = 0.0f;
        L20:
            this.variable.goalStrengthVector[r101] = r106;
        L22:
            r101 = r101 + 1;
            goto L14
        L21:
            this.variable.goalStrengthVector[r101] = 0.0f;
            goto L22
        L23:
            return true;
        }
    }

    @Override // androidx.constraintlayout.solver.ArrayRow, androidx.constraintlayout.solver.LinearSystem.Row
    public void clear() {
        this.numGoals = 0;
        this.constantValue = 0.0f;
    }

    @Override // androidx.constraintlayout.solver.ArrayRow, androidx.constraintlayout.solver.LinearSystem.Row
    public boolean isEmpty() {
        if (this.numGoals != 0) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // androidx.constraintlayout.solver.ArrayRow
    public String toString() {
        String r100 = " goal -> (" + this.constantValue + ") : ";
        int r101 = 0;
    L4:
        if (r101 >= this.numGoals) goto L6;
        this.accessor.init(this.arrayGoals[r101]);
        r100 = r100 + this.accessor + " ";
        r101 = r101 + 1;
        goto L4
    L6:
        return r100;
    }

    public PriorityGoalRow(Cache r100) {
        super(r100);
        this.TABLE_SIZE = 128;
        this.arrayGoals = new SolverVariable[128];
        this.sortArray = new SolverVariable[128];
        this.numGoals = 0;
        this.accessor = new GoalVariableAccessor(this, this);
        this.mCache = r100;
    }

    private final void addToGoal(SolverVariable r100) {
        int r101 = this.numGoals + 1;
        SolverVariable[] r102 = this.arrayGoals;
        if (r101 <= r102.length) goto L5;
        SolverVariable[] r103 = (SolverVariable[]) Arrays.copyOf(r102, r102.length * 2);
        this.arrayGoals = r103;
        this.sortArray = (SolverVariable[]) Arrays.copyOf(r103, r103.length * 2);
    L5:
        SolverVariable[] r104 = this.arrayGoals;
        int r105 = this.numGoals;
        r104[r105] = r100;
        int r106 = r105 + 1;
        this.numGoals = r106;
        if (r106 > 1) goto L8;
    L17:
        r100.inGoal = true;
        r100.addToRow(this);
        return;
    L8:
        if (r104[r106 - 1].f15332id <= r100.f15332id) goto L17;
        int r107 = 0;
        int r108 = 0;
    L10:
        int r109 = this.numGoals;
        if (r108 >= r109) goto L13;
        this.sortArray[r108] = this.arrayGoals[r108];
        r108 = r108 + 1;
        goto L10
    L13:
        Arrays.sort(this.sortArray, 0, r109, new AnonymousClass1(this));
    L15:
        if (r107 >= this.numGoals) goto L17;
        this.arrayGoals[r107] = this.sortArray[r107];
        r107 = r107 + 1;
        goto L15
    }

    private final void removeGoal(SolverVariable r100) {
        int r101 = 0;
    L4:
        if (r101 >= this.numGoals) goto L13;
        if (this.arrayGoals[r101] == r100) goto L7;
        r101 = r101 + 1;
    L7:
        int r102 = this.numGoals;
        if (r101 >= (r102 - 1)) goto L10;
        SolverVariable[] r103 = this.arrayGoals;
        int r104 = r101 + 1;
        r103[r101] = r103[r104];
        r101 = r104;
        goto L7
    L10:
        this.numGoals = r102 - 1;
        r100.inGoal = false;
        return;
    }

    @Override // androidx.constraintlayout.solver.ArrayRow, androidx.constraintlayout.solver.LinearSystem.Row
    public void addError(SolverVariable r100) {
        this.accessor.init(r100);
        this.accessor.reset();
        r100.goalStrengthVector[r100.strength] = 1.0f;
        addToGoal(r100);
    }

    public static /* synthetic */ void access$000(PriorityGoalRow r100, SolverVariable r101) {
        r100.removeGoal(r101);
    }

    @Override // androidx.constraintlayout.solver.ArrayRow, androidx.constraintlayout.solver.LinearSystem.Row
    public SolverVariable getPivotCandidate(LinearSystem r100, boolean[] r101) {
        int r102 = 0;
        int r103 = -1;
    L4:
        if (r102 >= this.numGoals) goto L17;
        SolverVariable r104 = this.arrayGoals[r102];
        if (r101[r104.f15332id] == true) goto L16;
        this.accessor.init(r104);
        if (r103 != (-1)) goto L14;
        if (this.accessor.isNegative() == false) goto L16;
    L15:
        r103 = r102;
        goto L16
    L14:
        if (this.accessor.isSmallerThan(this.arrayGoals[r103]) == true) goto L15;
    L16:
        r102 = r102 + 1;
        goto L4
    L17:
        if (r103 != (-1)) goto L21;
        return null;
    L21:
        return this.arrayGoals[r103];
    }

    @Override // androidx.constraintlayout.solver.ArrayRow, androidx.constraintlayout.solver.LinearSystem.Row
    public void updateFromRow(LinearSystem r100, ArrayRow r101, boolean r102) {
        SolverVariable r103 = r101.variable;
        if (r103 != null) goto L5;
        return;
    L5:
        ArrayRow.ArrayRowVariables r104 = r101.variables;
        int r105 = r104.getCurrentSize();
        int r106 = 0;
    L6:
        if (r106 >= r105) goto L11;
        SolverVariable r107 = r104.getVariable(r106);
        float r108 = r104.getVariableValue(r106);
        this.accessor.init(r107);
        if (this.accessor.addToGoal(r103, r108) == false) goto L10;
        addToGoal(r107);
    L10:
        this.constantValue += r101.constantValue * r108;
        r106 = r106 + 1;
        goto L6
    L11:
        removeGoal(r103);
    }
}
