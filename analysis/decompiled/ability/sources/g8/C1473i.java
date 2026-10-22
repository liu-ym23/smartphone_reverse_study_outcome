package g8;

import D7.v;
import Z7.t;
import j8.InterfaceC1603b;
import j8.InterfaceC1605d;
import k8.z;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.reflect.jvm.internal.impl.builtins.jvm.JvmBuiltIns$Kind;

/* renamed from: g8.i, reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C1473i extends e8.i {
    public static final /* synthetic */ t[] h;
    public e8.k f;
    public final W8.h g;

    static {
        kotlin.jvm.internal.n nVar = kotlin.jvm.internal.m.f4928a;
        h = new t[]{nVar.g(new PropertyReference1Impl(nVar.b(C1473i.class), "customizer", "getCustomizer()Lorg/jetbrains/kotlin/builtins/jvm/JvmBuiltInsCustomizer;"))};
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C1473i(W8.i iVar) {
        super(iVar);
        JvmBuiltIns$Kind[] jvmBuiltIns$KindArr = JvmBuiltIns$Kind.f4947a;
        this.g = new W8.h(iVar, new J4.e(10, this, iVar));
    }

    public final kotlin.reflect.jvm.internal.impl.builtins.jvm.b J() {
        return (kotlin.reflect.jvm.internal.impl.builtins.jvm.b) S0.b.g1(this.g, h[0]);
    }

    @Override // e8.i
    public final InterfaceC1603b d() {
        return J();
    }

    @Override // e8.i
    public final Iterable l() {
        Iterable iterableL = super.l();
        z zVarK = k();
        kotlin.jvm.internal.k.e(zVarK, "getBuiltInsModule(...)");
        return v.P0(iterableL, new C1471g(this.d, zVarK));
    }

    @Override // e8.i
    public final InterfaceC1605d p() {
        return J();
    }
}
