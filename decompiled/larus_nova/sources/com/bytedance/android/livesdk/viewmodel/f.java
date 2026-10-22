package com.bytedance.android.livesdk.viewmodel;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes11.dex */
public final class f<T> {
    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof f) == false) goto L8;
        ((f) r100).getClass();
        if (Intrinsics.areEqual(null, null) == true) goto L13;
        return false;
    L13:
        return true;
    L8:
        return false;
    }

    public final int hashCode() {
        int r100 = (int) 0;
        return (((r100 * 31) + r100) * 31) + 0;
    }

    public final String toString() {
        return "LuckyBox(availableTime=0, expireTime=0, data=null)";
    }
}
