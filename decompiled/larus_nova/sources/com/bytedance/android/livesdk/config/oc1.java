package com.bytedance.android.livesdk.config;

import java.util.Iterator;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes8.dex */
public final class oc1 {
    public static final void a(List<nc1> r100, nc1 r101) {
        Intrinsics.checkNotNullParameter(r100, "$this$record");
        Intrinsics.checkNotNullParameter(r101, "record");
        Iterator<T> r102 = r100.iterator();
    L4:
        if (r102.hasNext() == false) goto L9;
        nc1 r103 = (nc1) r102.next();
        if (Intrinsics.areEqual(r103.a(), r101.a()) == false) goto L4;
        r103.c(r101.b());
        return;
    L9:
        r100.add(r101);
    }
}
