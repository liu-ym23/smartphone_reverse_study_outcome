package com.bytedance.android.ec.window.base.common.taskgraph.collector.staticcollector;

import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes44.dex */
public final class a<ElementA, ElementB, ElementC, IN> extends e<IN> {

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final g<f<IN, ElementA>, f<IN, ElementB>, f<IN, ElementC>> f49187j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final Function3<ElementA, ElementB, ElementC, IN> f49188k;

    @Override // com.bytedance.android.ec.window.base.common.taskgraph.collector.staticcollector.e
    public final List<f<IN, ? extends Object>> g() {
        g<f<IN, ElementA>, f<IN, ElementB>, f<IN, ElementC>> r100 = this.f49187j;
        Intrinsics.checkNotNullParameter(r100, "$this$toList");
        return CollectionsKt.listOf(new Object[]{r100.f49191a, r100.f49192b, r100.f49196c});
    }

    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$UnknownArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    @Override // com.bytedance.android.ec.window.base.common.taskgraph.collector.staticcollector.e
    public final IN h() {
        g<f<IN, ElementA>, f<IN, ElementB>, f<IN, ElementC>> r100 = this.f49187j;
        T r101 = r100.f49191a.f49185h;
        if (r101 != 0) goto L5;
        return null;
    L5:
        T r102 = r100.f49192b.f49185h;
        if (r102 != 0) goto L8;
        return null;
    L8:
        T r103 = r100.f49196c.f49185h;
        if (r103 != 0) goto L12;
        return null;
    L12:
        return (IN) this.f49188k.invoke(r101, r102, r103);
    }

    public a(ao.b r100, Function3 r101) {
        Intrinsics.checkNotNullParameter(r100, "nodeId");
        Intrinsics.checkNotNullParameter(r101, "transformer");
        super(r100);
        this.f49188k = r101;
        this.f49187j = new g(new f(this.f49194i + "-receiver-node1", this), new f(this.f49194i + "-receiver-node2", this), new f(this.f49194i + "-receiver-node3", this));
    }
}
