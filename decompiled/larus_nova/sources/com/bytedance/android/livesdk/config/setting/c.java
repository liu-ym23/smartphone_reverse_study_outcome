package com.bytedance.android.livesdk.config.setting;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes8.dex */
public final class c {
    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof c) == false) goto L12;
        ((c) r100).getClass();
        if (Intrinsics.areEqual(null, null) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(null, null) == true) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(null, null) == true) goto L19;
        return false;
    L19:
        return true;
    L12:
        return false;
    }

    public final int hashCode() {
        return 0;
    }

    public final String toString() {
        return "DisableSchemaConfig(host=null, condition=null, tips=null)";
    }
}
