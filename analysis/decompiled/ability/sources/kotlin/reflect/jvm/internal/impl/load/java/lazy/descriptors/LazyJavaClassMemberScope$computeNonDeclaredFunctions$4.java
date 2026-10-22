package kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors;

import S7.k;
import Z7.f;
import kotlin.jvm.internal.FunctionReference;
import kotlin.jvm.internal.m;

/* loaded from: classes4.dex */
final /* synthetic */ class LazyJavaClassMemberScope$computeNonDeclaredFunctions$4 extends FunctionReference implements k {
    @Override // kotlin.jvm.internal.CallableReference, Z7.c
    public final String getName() {
        return "searchMethodsInSupertypesWithoutBuiltinMagic";
    }

    @Override // kotlin.jvm.internal.CallableReference
    public final f getOwner() {
        return m.f4928a.b(a.class);
    }

    @Override // kotlin.jvm.internal.CallableReference
    public final String getSignature() {
        return "searchMethodsInSupertypesWithoutBuiltinMagic(Lorg/jetbrains/kotlin/name/Name;)Ljava/util/Collection;";
    }

    @Override // S7.k
    public final Object invoke(Object obj) {
        G8.f p02 = (G8.f) obj;
        kotlin.jvm.internal.k.f(p02, "p0");
        return ((a) this.receiver).N(p02);
    }
}
