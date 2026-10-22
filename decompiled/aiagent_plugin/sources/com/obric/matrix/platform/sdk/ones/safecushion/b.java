package com.obric.matrix.platform.sdk.ones.safecushion;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.a.p;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* JADX INFO: compiled from: MatrixCushionConfig.kt */
/* JADX INFO: loaded from: classes4.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final String f33715a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final int f33716b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final Map<Integer, List<com.obric.matrix.platform.sdk.ones.safecushion.a.a>> f33717c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final com.obric.matrix.platform.sdk.ones.safecushion.ui.b f33718d;

    /* JADX INFO: compiled from: Comparisons.kt */
    public static final class a<T> implements Comparator {
        public a() {
        }

        @Override // java.util.Comparator
        public final int compare(T r2, T r3) {
            return d.b.a.a((Comparable) ZeusTransformUtils.preCheckCast((Integer) ZeusTransformUtils.preCheckCast(((Map.Entry) ZeusTransformUtils.preCheckCast(r2, Map.Entry.class, "com.obric.aiagent.plugin")).getKey(), Integer.class, "com.obric.aiagent.plugin"), Comparable.class, "com.obric.aiagent.plugin"), (Comparable) ZeusTransformUtils.preCheckCast((Integer) ZeusTransformUtils.preCheckCast(((Map.Entry) ZeusTransformUtils.preCheckCast(r3, Map.Entry.class, "com.obric.aiagent.plugin")).getKey(), Integer.class, "com.obric.aiagent.plugin"), Comparable.class, "com.obric.aiagent.plugin"));
        }
    }

    public final String a() {
        return this.f33715a;
    }

    public final int b() {
        return this.f33716b;
    }

    public final com.obric.matrix.platform.sdk.ones.safecushion.ui.b c() {
        return this.f33718d;
    }

    public final List<com.obric.matrix.platform.sdk.ones.safecushion.a.a> a(int r6) {
        Iterable r5 = (Iterable) ZeusTransformUtils.preCheckCast(this.f33717c.entrySet(), Iterable.class, "com.obric.aiagent.plugin");
        Collection r0 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(), Collection.class, "com.obric.aiagent.plugin");
        Iterator r7 = r5.iterator();
    L4:
        if (r7.hasNext() == false) goto L11;
        Object r2 = r7.next();
        if (((Number) ZeusTransformUtils.preCheckCast(((Map.Entry) ZeusTransformUtils.preCheckCast(r2, Map.Entry.class, "com.obric.aiagent.plugin")).getKey(), Number.class, "com.obric.aiagent.plugin")).intValue() > r6) goto L8;
        boolean r3 = true;
    L9:
        if (r3 == false) goto L4;
        r0.add(r2);
        goto L4
    L8:
        r3 = false;
        goto L9
    L11:
        Iterable r8 = (Iterable) ZeusTransformUtils.preCheckCast(p.a((Iterable) ZeusTransformUtils.preCheckCast((List) ZeusTransformUtils.preCheckCast(r0, List.class, "com.obric.aiagent.plugin"), Iterable.class, "com.obric.aiagent.plugin"), (Comparator) ZeusTransformUtils.preCheckCast(new a(), Comparator.class, "com.obric.aiagent.plugin")), Iterable.class, "com.obric.aiagent.plugin");
        Collection r9 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(), Collection.class, "com.obric.aiagent.plugin");
        Iterator r10 = r8.iterator();
    L13:
        if (r10.hasNext() == false) goto L16;
        p.a(r9, (Iterable) ZeusTransformUtils.preCheckCast((List) ZeusTransformUtils.preCheckCast(((Map.Entry) ZeusTransformUtils.preCheckCast(r10.next(), Map.Entry.class, "com.obric.aiagent.plugin")).getValue(), List.class, "com.obric.aiagent.plugin"), Iterable.class, "com.obric.aiagent.plugin"));
        goto L13
    L16:
        return (List) ZeusTransformUtils.preCheckCast(r9, List.class, "com.obric.aiagent.plugin");
    }
}
