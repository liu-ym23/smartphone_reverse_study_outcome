package com.bytedance.android.ec.core.imagex.opt;

import com.facebook.imagepipeline.common.Priority;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes43.dex */
public final class y {
    public static final Priority a(com.bytedance.android.shopping.api.image.d0 r100) {
        Intrinsics.checkNotNullParameter(r100, "$this$priorityEnum");
        Integer r101 = r100.a();
        if (r101 != null) goto L6;
    L8:
        if (r101 != null) goto L11;
    L13:
        if (r101 != null) goto L16;
    L18:
        if (r101 == null) goto L24;
        if (r101.intValue() != 3) goto L24;
        return Priority.IMMEDIATE;
    L24:
        return Priority.MEDIUM;
    L16:
        if (r101.intValue() != 2) goto L18;
        return Priority.HIGH;
    L11:
        if (r101.intValue() != 1) goto L13;
        return Priority.MEDIUM;
    L6:
        if (r101.intValue() != 0) goto L8;
        return Priority.LOW;
    }
}
