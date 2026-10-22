package com.bytedance.android.ec.window.base.common.taskgraph.collector.staticcollector;

import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes44.dex */
public final class b<ElementA, ElementB, IN> extends e<IN> {

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final d<f<IN, ElementA>, f<IN, ElementB>> f49189j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final Function2<ElementA, ElementB, IN> f49190k;

    @Override // com.bytedance.android.ec.window.base.common.taskgraph.collector.staticcollector.e
    public final List<f<IN, ? extends Object>> g() {
        d<f<IN, ElementA>, f<IN, ElementB>> r100 = this.f49189j;
        return CollectionsKt.listOf(new f[]{r100.f49191a, r100.f49192b});
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
        d<f<IN, ElementA>, f<IN, ElementB>> r100 = this.f49189j;
        T r101 = r100.f49191a.f49185h;
        if (r101 != 0) goto L5;
        return null;
    L5:
        T r102 = r100.f49192b.f49185h;
        if (r102 != 0) goto L9;
        return null;
    L9:
        return (IN) this.f49190k.invoke(r101, r102);
    }

    public b(ao.b r100, Function2 r101) {
        Intrinsics.checkNotNullParameter(r100, "nodeId");
        Intrinsics.checkNotNullParameter(r101, "transformer");
        super(r100);
        this.f49190k = r101;
        this.f49189j = new d(new f(this.f49194i + "-receiver-node1", this), new f(this.f49194i + "-receiver-node2", this));
    }
}
