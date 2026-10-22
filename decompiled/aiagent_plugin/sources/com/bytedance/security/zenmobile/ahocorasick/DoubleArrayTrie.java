package com.bytedance.security.zenmobile.ahocorasick;

import java.util.Arrays;

/* JADX INFO: loaded from: classes.dex */
public class DoubleArrayTrie {
    static final int RESIZE_DELTA = 512;
    int[] base;
    int[] check;
    int nextCheckPos;
    int size;
    boolean[] used;

    public DoubleArrayTrie() {
    }

    public boolean extractMatchSearch(byte[] r6, int r7) {
        int r0 = this.size;
        if (r0 > 0) goto L5;
        return false;
    L5:
        if (r7 < 0) goto L27;
        if (r7 >= r0) goto L30;
        int r8 = this.base[r7];
        int r1 = r6.length;
        int r2 = 0;
    L10:
        if (r2 >= r1) goto L19;
        int r4 = (r6[r2] + r8) + 1;
        if (r4 >= this.size) goto L13;
        if (this.check[r4] != r8) goto L17;
        r8 = this.base[r4];
        r2 = r2 + 1;
        goto L10
    L17:
        return false;
    L13:
        return false;
    L19:
        if (this.check[r8] == r8) goto L21;
        return false;
    L21:
        if (this.base[r8] < 0) goto L23;
        return false;
    L23:
        return true;
    L30:
        return false;
    L27:
        return false;
    }

    void resize(int r2) {
        if (this.size != 0) goto L5;
        this.base = new int[r2];
        this.check = new int[r2];
        this.used = new boolean[r2];
    L6:
        this.size = r2;
        return;
    L5:
        this.base = Arrays.copyOf(this.base, r2);
        this.check = Arrays.copyOf(this.check, r2);
        this.used = Arrays.copyOf(this.used, r2);
        goto L6
    }
}
