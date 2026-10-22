package com.android.server.permission.jarjar.kotlin;

import com.android.server.permission.jarjar.kotlin.jvm.internal.Intrinsics;
import com.android.server.permission.jarjar.kotlin.text.CharsKt;

/* JADX INFO: compiled from: UnsignedJVM.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class UnsignedKt {
    public static final String ulongToString(long value, int base) {
        if (value < 0) goto L6;
        String r0 = Long.toString(value, CharsKt.checkRadix(base));
        Intrinsics.checkNotNullExpressionValue(r0, "toString(...)");
        return r0;
    L6:
        long quotient = ((value >>> 1) / ((long) base)) << 1;
        long rem = value - (((long) base) * quotient);
        if (rem < base) goto L9;
        rem = rem - ((long) base);
        quotient = quotient + 1;
    L9:
        StringBuilder r1 = new StringBuilder();
        String r6 = Long.toString(quotient, CharsKt.checkRadix(base));
        Intrinsics.checkNotNullExpressionValue(r6, "toString(...)");
        r1.append(r6);
        String r7 = Long.toString(rem, CharsKt.checkRadix(base));
        Intrinsics.checkNotNullExpressionValue(r7, "toString(...)");
        r1.append(r7);
        return r1.toString();
    }
}
