package com.google.zxing.oned.rss;

/* JADX INFO: loaded from: classes3.dex */
public class DataCharacter {
    private final int checksumPortion;
    private final int value;

    public DataCharacter(int r1, int r2) {
        this.value = r1;
        this.checksumPortion = r2;
    }

    public final int getValue() {
        return this.value;
    }

    public final int getChecksumPortion() {
        return this.checksumPortion;
    }

    public final String toString() {
        return this.value + "(" + this.checksumPortion + ')';
    }

    public final boolean equals(Object r4) {
        if ((r4 instanceof DataCharacter) == true) goto L5;
        return false;
    L5:
        DataCharacter r5 = (DataCharacter) r4;
        if (this.value == r5.value) goto L8;
    L11:
        return false;
    L8:
        if (this.checksumPortion != r5.checksumPortion) goto L11;
        return true;
    }

    public final int hashCode() {
        int r0 = this.value;
        return this.checksumPortion ^ r0;
    }
}
