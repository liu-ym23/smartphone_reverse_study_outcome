package com.android.server.permission.access.util;

/* JADX INFO: compiled from: IntExtensions.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class IntExtensionsKt {
    public static final boolean hasAnyBit(int $this$hasAnyBit, int bits) {
        if (($this$hasAnyBit & bits) == 0) goto L5;
        return true;
    L5:
        return false;
    }

    public static final boolean hasBits(int $this$hasBits, int bits) {
        if (($this$hasBits & bits) != bits) goto L5;
        return true;
    L5:
        return false;
    }

    public static final int andInv(int $this$andInv, int other) {
        return (~other) & $this$andInv;
    }
}
