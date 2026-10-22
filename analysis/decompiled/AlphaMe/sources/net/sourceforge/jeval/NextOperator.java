package net.sourceforge.jeval;

import net.sourceforge.jeval.operator.Operator;

/* loaded from: classes2.dex */
class NextOperator {
    private int index;
    private Operator operator;

    public NextOperator(Operator operator, int i4) {
        this.operator = operator;
        this.index = i4;
    }

    public int getIndex() {
        return this.index;
    }

    public Operator getOperator() {
        return this.operator;
    }
}
