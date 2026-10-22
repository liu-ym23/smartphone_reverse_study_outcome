package com.bytedance.android.shopping.anchorv4.ai;

import androidx.fragment.app.FragmentActivity;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes12.dex */
public final class h0 implements g0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final y f165660a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final i0 f165661b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final x f165662c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final f0 f165663d;

    @Override // com.bytedance.android.shopping.anchorv4.ai.g0
    public final f b(Function1<? super u, Unit> r100) {
        Intrinsics.checkNotNullParameter(r100, "listener");
        this.f165662c.getClass();
        Intrinsics.checkNotNullParameter(r100, "listener");
        w r101 = new w(r100);
        com.bytedance.android.ec.core.utils.s0.c(r101);
        return new v(r101);
    }

    @Override // com.bytedance.android.shopping.anchorv4.ai.g0
    public final f c(Function1 r100) {
        Intrinsics.checkNotNullParameter("ecom.pdp.add_cart", "eventName");
        Intrinsics.checkNotNullParameter(r100, "listener");
        return this.f165661b.a(r100);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r3v0, types: [com.bytedance.android.shopping.anchorv4.ai.PdpAIPageEventObserverImpl$createFragmentCoverCallback$1] */
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
    @Override // com.bytedance.android.shopping.anchorv4.ai.g0
    public final f a(final int r100, final Function0<Unit> r101) {
        Intrinsics.checkNotNullParameter(r101, "listener");
        return new r(new f[]{this.f165660a.a(new PdpAIPageEventObserverImpl$createFragmentCoverCallback$1(this, r100, r101))});
    }

    public h0(FragmentActivity r100, y r101, i0 r102) {
        x r103 = new x();
        f0 r104 = new f0();
        Intrinsics.checkNotNullParameter(r100, "currentActivity");
        Intrinsics.checkNotNullParameter(r101, "fragmentLifecycleRegistration");
        Intrinsics.checkNotNullParameter(r102, "pdpEventRegistration");
        Intrinsics.checkNotNullParameter(r103, "favoriteChangedEventRegistration");
        Intrinsics.checkNotNullParameter(r104, "pageCoverFilter");
        this.f165660a = r101;
        this.f165661b = r102;
        this.f165662c = r103;
        this.f165663d = r104;
    }
}
