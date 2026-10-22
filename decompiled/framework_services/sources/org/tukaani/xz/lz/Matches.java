package org.tukaani.xz.lz;

/* JADX INFO: loaded from: classes3.dex */
public final class Matches {
    public int count;
    public final int[] dist;
    public final int[] len;

    Matches(int countMax) {
        this.count = 0;
        this.len = new int[countMax];
        this.dist = new int[countMax];
    }
}
