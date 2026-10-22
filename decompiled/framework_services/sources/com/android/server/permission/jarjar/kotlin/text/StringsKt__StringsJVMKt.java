package com.android.server.permission.jarjar.kotlin.text;

import com.android.server.permission.jarjar.kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: StringsJVM.kt */
/* JADX INFO: loaded from: classes2.dex */
class StringsKt__StringsJVMKt extends StringsKt__StringNumberConversionsKt {
    public static /* synthetic */ boolean startsWith$default(String r0, String r1, boolean r2, int r3, Object r4) {
        if ((r3 & 2) == 0) goto L6;
        r2 = false;
    L6:
        return startsWith(r0, r1, r2);
    }

    public static final boolean startsWith(String $this$startsWith, String prefix, boolean ignoreCase) {
        Intrinsics.checkNotNullParameter($this$startsWith, "<this>");
        Intrinsics.checkNotNullParameter(prefix, "prefix");
        if (ignoreCase == true) goto L7;
        return $this$startsWith.startsWith(prefix);
    L7:
        return regionMatches($this$startsWith, 0, prefix, 0, prefix.length(), ignoreCase);
    }

    public static final boolean regionMatches(String $this$regionMatches, int thisOffset, String other, int otherOffset, int length, boolean ignoreCase) {
        Intrinsics.checkNotNullParameter($this$regionMatches, "<this>");
        Intrinsics.checkNotNullParameter(other, "other");
        if (ignoreCase == true) goto L6;
        return $this$regionMatches.regionMatches(thisOffset, other, otherOffset, length);
    L6:
        return $this$regionMatches.regionMatches(ignoreCase, thisOffset, other, otherOffset, length);
    }
}
