package com.android.server.permission.jarjar.kotlin.text;

import com.android.server.permission.jarjar.kotlin.ranges.IntRange;

/* JADX INFO: compiled from: CharJVM.kt */
/* JADX INFO: loaded from: classes2.dex */
class CharsKt__CharJVMKt {
    public static int checkRadix(int radix) {
        boolean r0 = false;
        if (2 <= radix) goto L5;
    L7:
        if (r0 == false) goto L10;
        return radix;
    L10:
        throw new IllegalArgumentException("radix " + radix + " was not in valid range " + new IntRange(2, 36));
    L5:
        if (radix >= 37) goto L7;
        r0 = true;
        goto L7
    }
}
