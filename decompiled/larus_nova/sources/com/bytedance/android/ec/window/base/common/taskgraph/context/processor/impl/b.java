package com.bytedance.android.ec.window.base.common.taskgraph.context.processor.impl;

import com.bytedance.android.ec.window.base.common.taskgraph.PipelineNode;
import com.bytedance.android.ec.window.base.common.taskgraph.context.NodeType;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Typography;

/* JADX INFO: loaded from: classes44.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final List<com.bytedance.android.ec.window.base.common.taskgraph.a> f49208a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f49209b;

    public b(String r100) {
        Intrinsics.checkNotNullParameter(r100, "graphName");
        this.f49209b = r100;
        this.f49208a = Collections.synchronizedList(new ArrayList());
    }

    public static boolean b(NodeType r100, NodeType r101) {
        if (r100.compareTo(r101) > 0) goto L5;
        return true;
    L5:
        return false;
    }

    public final synchronized List<com.bytedance.android.ec.window.base.common.taskgraph.a> d(NodeType r100, List<com.bytedance.android.ec.window.base.common.taskgraph.a> r101) {
        monitor-enter(this);
        LinkedHashSet r102 = new LinkedHashSet();     // Catch: Throwable -> L18
        Iterator<T> r103 = r101.iterator();     // Catch: Throwable -> L18
    L5:
        if (r103.hasNext() == false) goto L15;
        com.bytedance.android.ec.window.base.common.taskgraph.a r104 = (com.bytedance.android.ec.window.base.common.taskgraph.a) r103.next();     // Catch: Throwable -> L18
        if (b(r104.f49178a.c(), r100) == true) goto L5;
        if (b(r104.f49179b.c(), r100) == true) goto L11;
        r102.add(r104);     // Catch: Throwable -> L18
        goto L5
    L11:
        PipelineNode<?, ?> r105 = a(r104.f49179b, r101, r100);     // Catch: Throwable -> L18
        if (r105 == null) goto L5;
        r102.add(new com.bytedance.android.ec.window.base.common.taskgraph.a(r104.f49178a, r105));     // Catch: Throwable -> L18
        goto L5
    L15:
        List<com.bytedance.android.ec.window.base.common.taskgraph.a> r106 = CollectionsKt.toList(r102);     // Catch: Throwable -> L18
        monitor-exit(this);
        return r106;
    L18:
        th = move-exception;
        throw th;
    }

    public final synchronized PipelineNode<?, ?> a(PipelineNode<?, ?> r100, List<com.bytedance.android.ec.window.base.common.taskgraph.a> r101, NodeType r102) {
        monitor-enter(this);
    L3:
        if (r100 == null) goto L21;
        if (b(r100.c(), r102) == false) goto L21;
        Iterator<T> r103 = r101.iterator();     // Catch: Throwable -> L18
    L8:
        if (r103.hasNext() == false) goto L12;
        Object r104 = r103.next();     // Catch: Throwable -> L18
        if (Intrinsics.areEqual(((com.bytedance.android.ec.window.base.common.taskgraph.a) r104).f49178a, r100) == false) goto L8;
    L13:
        com.bytedance.android.ec.window.base.common.taskgraph.a r105 = (com.bytedance.android.ec.window.base.common.taskgraph.a) r104;     // Catch: Throwable -> L18
        if (r105 != null) goto L15;
        r100 = null;
        goto L3
    L15:
        r100 = r105.f49179b;     // Catch: Throwable -> L18
        goto L3
    L12:
        r104 = null;
    L18:
        th = move-exception;
        throw th;
    L21:
        monitor-exit(this);
        return r100;
    }

    public final synchronized String c(PipelineNode<?, ?> r100, PipelineNode<?, ?> r101, NodeType r102, Function1<? super PipelineNode<?, ?>, String> r103) {
        monitor-enter(this);
    L20:
        th = move-exception;
        throw th;
    L5:
        if (b(r100.c(), r102) == false) goto L7;
    L17:
        String r104 = "\"" + r103.invoke(r100) + "\" -> \"" + r103.invoke(r101) + "\" [style = dotted, label = \"link\"]";     // Catch: Throwable -> L20
        monitor-exit(this);
        return r104;
    L7:
        if (b(r101.c(), r102) == true) goto L17;
        if (r101.c() != NodeType.COLLECTOR) goto L14;
        String r105 = "\"" + r103.invoke(r100) + "\" -> \"" + r103.invoke(r101) + "\" [style = dashed]";     // Catch: Throwable -> L20
        monitor-exit(this);
        return r105;
    L14:
        String r106 = "\"" + r103.invoke(r100) + "\" -> \"" + r103.invoke(r101) + Typography.quote;     // Catch: Throwable -> L20
        monitor-exit(this);
        return r106;
    }
}
