package androidx.constraintlayout.solver;

/* JADX INFO: loaded from: classes17.dex */
public class GoalRow extends ArrayRow {
    public GoalRow(Cache r100) {
        super(r100);
    }

    @Override // androidx.constraintlayout.solver.ArrayRow, androidx.constraintlayout.solver.LinearSystem.Row
    public void addError(SolverVariable r100) {
        super.addError(r100);
        r100.usageInRowCount--;
    }
}
