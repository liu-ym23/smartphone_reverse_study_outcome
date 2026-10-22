package com.bytedance.android.livesdk.interactivity.api;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes9.dex */
public final class r {
    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof r) == false) goto L8;
        ((r) r100).getClass();
        if (Intrinsics.areEqual(null, null) == true) goto L13;
        return false;
    L13:
        return true;
    L8:
        return false;
    }

    public final int hashCode() {
        return 0;
    }

    public final String toString() {
        return "PublicScreenScrollEvent(focus=false, source=null)";
    }
}
