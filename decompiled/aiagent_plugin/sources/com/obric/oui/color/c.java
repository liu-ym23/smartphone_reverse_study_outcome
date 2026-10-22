package com.obric.oui.color;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.h.b.o;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Objects;

/* JADX INFO: compiled from: BlendConfig.kt */
/* JADX INFO: loaded from: classes4.dex */
public final class c {
    public static final a a(b r2) {
        o.e(r2, "<this>");
        return new a(r2.a(), r2.b());
    }

    public static final b[] a(a[] r6) {
        o.e(r6, "<this>");
        Collection r0 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(r6.length), Collection.class, "com.obric.aiagent.plugin");
        int r1 = r6.length;
        int r4 = 0;
    L3:
        if (r4 >= r1) goto L5;
        r0.add(r6[r4].c());
        r4 = r4 + 1;
        goto L3
    L5:
        Object[] r7 = ((Collection) ZeusTransformUtils.preCheckCast((List) ZeusTransformUtils.preCheckCast(r0, List.class, "com.obric.aiagent.plugin"), Collection.class, "com.obric.aiagent.plugin")).toArray(new b[0]);
        Objects.requireNonNull(r7, "null cannot be cast to non-null type kotlin.Array<T of kotlin.collections.ArraysKt__ArraysJVMKt.toTypedArray>");
        return (b[]) ZeusTransformUtils.preCheckCast(r7, b[].class, "com.obric.aiagent.plugin");
    }

    public static final a[] a(b[] r6) {
        o.e(r6, "<this>");
        Collection r0 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(r6.length), Collection.class, "com.obric.aiagent.plugin");
        int r1 = r6.length;
        int r4 = 0;
    L3:
        if (r4 >= r1) goto L5;
        r0.add(a(r6[r4]));
        r4 = r4 + 1;
        goto L3
    L5:
        Object[] r7 = ((Collection) ZeusTransformUtils.preCheckCast((List) ZeusTransformUtils.preCheckCast(r0, List.class, "com.obric.aiagent.plugin"), Collection.class, "com.obric.aiagent.plugin")).toArray(new a[0]);
        Objects.requireNonNull(r7, "null cannot be cast to non-null type kotlin.Array<T of kotlin.collections.ArraysKt__ArraysJVMKt.toTypedArray>");
        return (a[]) ZeusTransformUtils.preCheckCast(r7, a[].class, "com.obric.aiagent.plugin");
    }
}
