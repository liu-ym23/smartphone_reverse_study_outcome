package com.bytedance.android.ec.window.base.common.taskgraph.context.processor.impl;

import android.os.SystemClock;
import com.alipay.sdk.m.u.i;
import com.byted.cast.common.TeaEventTrack;
import com.bytedance.android.ec.window.base.common.taskgraph.PipelineNode;
import com.bytedance.android.ec.window.base.common.taskgraph.context.NodeType;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import kotlin.NoWhenBranchMatchedException;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes44.dex */
public final class c extends co.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final b f49210a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final d f49211b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f49212c;

    public c() {
        Intrinsics.checkNotNullParameter("windowLaunch", "pipelineName");
        this.f49212c = "windowLaunch";
        this.f49210a = new b("\"windowLaunch\"");
        this.f49211b = new d();
    }

    public static String c(final c r110) {
        NodeType r100 = NodeType.COLLECTOR;
        r110.getClass();
        Intrinsics.checkNotNullParameter(r100, "ignoreLevel");
        d r101 = r110.f49211b;
        if (r101.f49213a.isEmpty() == false) goto L5;
        final Map r102 = MapsKt.emptyMap();
    L28:
        final String r103 = "\\n";
        Function1<PipelineNode<?, ?>, String> r104 = new DotGeneratorProcessor$getGraph$provider$1(r110, r103, r102);
        b r111 = r110.f49210a;
        monitor-enter(r111);
        Intrinsics.checkNotNullParameter(r100, "ignoreLevel");     // Catch: Throwable -> L65
        Intrinsics.checkNotNullParameter(r104, "nameProvider");     // Catch: Throwable -> L65
        StringBuilder r105 = new StringBuilder();     // Catch: Throwable -> L65
        r105.append("digraph ");     // Catch: Throwable -> L65
        r105.append(r111.f49209b);     // Catch: Throwable -> L65
        r105.append(" {");     // Catch: Throwable -> L65
        r105.append('\n');     // Catch: Throwable -> L65
        r105.append("rankdir = LR");     // Catch: Throwable -> L65
        r105.append('\n');     // Catch: Throwable -> L65
        List<com.bytedance.android.ec.window.base.common.taskgraph.a> r106 = r111.d(r100, r111.f49208a);     // Catch: Throwable -> L65
        LinkedHashSet r107 = new LinkedHashSet();     // Catch: Throwable -> L65
        Iterator<T> r108 = r106.iterator();     // Catch: Throwable -> L65
    L32:
        if (r108.hasNext() == false) goto L34;
        com.bytedance.android.ec.window.base.common.taskgraph.a r109 = (com.bytedance.android.ec.window.base.common.taskgraph.a) r108.next();     // Catch: Throwable -> L65
        r107.add(r109.f49178a);     // Catch: Throwable -> L65
        r107.add(r109.f49179b);     // Catch: Throwable -> L65
        goto L32
    L34:
        Iterator r112 = r107.iterator();     // Catch: Throwable -> L65
    L36:
        if (r112.hasNext() == false) goto L58;
        PipelineNode<?, ?> r113 = (PipelineNode) r112.next();     // Catch: Throwable -> L65
        if (b.b(r113.c(), r100) == true) goto L36;
        r105.append("\"");     // Catch: Throwable -> L65
        r105.append(r104.invoke(r113));     // Catch: Throwable -> L65
        r105.append("\"");     // Catch: Throwable -> L65
        NodeType r114 = r113.c();     // Catch: Throwable -> L65
        int r115 = a.f49207a[r114.ordinal()];     // Catch: Throwable -> L65
        if (r115 != 1) goto L43;
        String r116 = ":body[shape=box style=filled color=darkgoldenrod]";
    L57:
        r105.append(r116);     // Catch: Throwable -> L65
        r105.append('\n');     // Catch: Throwable -> L65
        goto L36
    L43:
        if (r115 != 2) goto L45;
        r116 = ":body[shape=box style=filled color=lightblue]";
        goto L57
    L45:
        if (r115 != 3) goto L47;
        r116 = ":body[style=filled color=lightgray]";
        goto L57
    L47:
        if (r115 != 4) goto L49;
        r116 = ":body[style=filled color=yellow]";
        goto L57
    L49:
        if (r115 != 5) goto L52;
        r116 = ":body[style=filled color=lightpink]";
        goto L57
    L52:
        throw new NoWhenBranchMatchedException();     // Catch: Throwable -> L65
    L58:
        Iterator<T> r117 = r106.iterator();     // Catch: Throwable -> L65
    L60:
        if (r117.hasNext() == false) goto L62;
        com.bytedance.android.ec.window.base.common.taskgraph.a r118 = (com.bytedance.android.ec.window.base.common.taskgraph.a) r117.next();     // Catch: Throwable -> L65
        r105.append(r111.c(r118.f49178a, r118.f49179b, r100, r104));     // Catch: Throwable -> L65
        r105.append('\n');     // Catch: Throwable -> L65
        goto L60
    L62:
        r105.append(i.f25855d);     // Catch: Throwable -> L65
        r105.append('\n');     // Catch: Throwable -> L65
        String r119 = r105.toString();     // Catch: Throwable -> L65
        monitor-exit(r111);
        return r119;
    L65:
        th = move-exception;
        throw th;
    L5:
        Iterator<T> r120 = r101.f49213a.entrySet().iterator();
        if (r120.hasNext() == true) goto L8;
        Object r121 = null;
    L18:
        Map.Entry r122 = (Map.Entry) r121;
        if (r122 == null) goto L23;
        Long r123 = (Long) r122.getValue();
        if (r123 == null) goto L23;
        long r124 = r123.longValue();
    L24:
        r102 = MapsKt.toMutableMap(r101.f49213a);
        Iterator r125 = r102.entrySet().iterator();
    L26:
        if (r125.hasNext() == false) goto L28;
        Map.Entry r126 = (Map.Entry) r125.next();
        r102.put(r126.getKey(), Long.valueOf(((Number) r126.getValue()).longValue() - r124));
    L23:
        r124 = 0;
        goto L24
    L8:
        Object r127 = r120.next();
        if (r120.hasNext() == true) goto L11;
    L10:
        r121 = r127;
        goto L18
    L11:
        long r128 = ((Number) ((Map.Entry) r127).getValue()).longValue();
    L12:
        Object r129 = r120.next();
        long r130 = ((Number) ((Map.Entry) r129).getValue()).longValue();
        if (r128 <= r130) goto L16;
        r127 = r129;
        r128 = r130;
    L16:
        if (r120.hasNext() == true) goto L12;
        goto L10
    }

    @Override // co.a
    public final void a(PipelineNode<?, ?> r100, PipelineNode<?, ?> r101) {
        Intrinsics.checkNotNullParameter(r100, "cur");
        Intrinsics.checkNotNullParameter(r101, TeaEventTrack.ACTION_DRAMA_NEXT);
        d r102 = this.f49211b;
        r102.getClass();
        Intrinsics.checkNotNullParameter(r101, "node");
        Long r103 = r102.f49213a.get(r101);
        if (r103 == null) goto L7;
        long r104 = r103.longValue();
        long r105 = SystemClock.elapsedRealtime() - r104;
        r102.f49214b.put(r101, Long.valueOf(r105));
        return;
    }

    @Override // co.a
    public final void b(PipelineNode<?, ?> r100, PipelineNode<?, ?> r101) {
        Intrinsics.checkNotNullParameter(r100, "cur");
        Intrinsics.checkNotNullParameter(r101, TeaEventTrack.ACTION_DRAMA_NEXT);
        d r102 = this.f49211b;
        r102.getClass();
        Intrinsics.checkNotNullParameter(r101, "node");
        if (r102.f49213a.get(r101) != null) goto L6;
        r102.f49213a.put(r101, Long.valueOf(SystemClock.elapsedRealtime()));
    L6:
        b r103 = this.f49210a;
        monitor-enter(r103);
        Intrinsics.checkNotNullParameter(r100, "src");     // Catch: Throwable -> L11
        Intrinsics.checkNotNullParameter(r101, "dst");     // Catch: Throwable -> L11
        r103.f49208a.add(new com.bytedance.android.ec.window.base.common.taskgraph.a(r100, r101));     // Catch: Throwable -> L11
        monitor-exit(r103);
        return;
    L11:
        th = move-exception;
        throw th;
    }
}
