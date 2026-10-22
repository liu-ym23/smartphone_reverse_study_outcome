package com.obric.oui.constraintlayout.core;

/* JADX INFO: loaded from: classes3.dex */
public class GoalRow extends ArrayRow {
    public GoalRow(Cache r1) {
        super(r1);
    }

    @Override // com.obric.oui.constraintlayout.core.ArrayRow, com.obric.oui.constraintlayout.core.LinearSystem.Row
    public void addError(SolverVariable r1) {
        super.addError(r1);
        r1.usageInRowCount--;
    }
}
