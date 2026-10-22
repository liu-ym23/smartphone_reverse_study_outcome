package com.android.server.permission.jarjar.kotlin.text;

import com.android.server.permission.jarjar.kotlin.UnsignedKt;

/* JADX INFO: compiled from: UStrings.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class UStringsKt {
    /* JADX INFO: renamed from: toString-V7xB4Y4, reason: not valid java name */
    public static final String m6566toStringV7xB4Y4(int $this$toString_u2dV7xB4Y4, int radix) {
        long r1 = ((long) $this$toString_u2dV7xB4Y4) & 4294967295L;
        return UnsignedKt.ulongToString(r1, CharsKt.checkRadix(radix));
    }
}
