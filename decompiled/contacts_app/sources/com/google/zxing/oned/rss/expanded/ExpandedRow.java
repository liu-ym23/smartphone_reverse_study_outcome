package com.google.zxing.oned.rss.expanded;

import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes3.dex */
final class ExpandedRow {
    private final List<ExpandedPair> pairs;
    private final int rowNumber;
    private final boolean wasReversed;

    ExpandedRow(List<ExpandedPair> r2, int r3, boolean r4) {
        this.pairs = new ArrayList(r2);
        this.rowNumber = r3;
        this.wasReversed = r4;
    }

    List<ExpandedPair> getPairs() {
        return this.pairs;
    }

    int getRowNumber() {
        return this.rowNumber;
    }

    boolean isReversed() {
        return this.wasReversed;
    }

    boolean isEquivalent(List<ExpandedPair> r1) {
        return this.pairs.equals(r1);
    }

    public String toString() {
        return "{ " + this.pairs + " }";
    }

    public boolean equals(Object r4) {
        if ((r4 instanceof ExpandedRow) == true) goto L5;
        return false;
    L5:
        ExpandedRow r5 = (ExpandedRow) r4;
        if (this.pairs.equals(r5.getPairs()) == true) goto L8;
    L11:
        return false;
    L8:
        if (this.wasReversed != r5.wasReversed) goto L11;
        return true;
    }

    public int hashCode() {
        int r0 = this.pairs.hashCode();
        return Boolean.valueOf(this.wasReversed).hashCode() ^ r0;
    }
}
