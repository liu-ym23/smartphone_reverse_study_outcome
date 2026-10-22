package com.bytedanceos.common.model;

import java.util.Objects;

/* JADX INFO: loaded from: classes2.dex */
public class ClickCode {
    public static final int FIRST = 0;
    public static final int NAN = -1;
    public static final ClickCode NULL = null;
    public static final int SECOND = 1;
    public static final int THIRD = 2;
    private final int mCellKey;
    private final int[] mCodes;

    static {
        NULL = new ClickCode(-1, new int[]{-1});
    }

    public ClickCode(int r10, int... r11) {
        Objects.requireNonNull(r11, "Codes must not be null");
        this.mCodes = r11;
        this.mCellKey = r10;
    }

    public int cellKey() {
        return this.mCellKey;
    }

    public int location(int r10) {
        int r11 = 0;
    L3:
        int[] r12 = this.mCodes;
        if (r11 >= r12.length) goto L9;
        if (r10 == r12[r11]) goto L7;
        r11 = r11 + 1;
        goto L3
    L7:
        return r11;
    L9:
        return -1;
    }
}
