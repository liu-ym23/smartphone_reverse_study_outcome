package kotlin.reflect.jvm.internal.impl.types.checker;

import S7.n;
import X8.w;
import Y8.j;
import Y8.l;
import Z7.f;
import kotlin.jvm.internal.FunctionReference;
import kotlin.jvm.internal.k;
import kotlin.jvm.internal.m;

/* loaded from: classes4.dex */
final /* synthetic */ class TypeIntersector$intersectTypesWithoutIntersectionType$filteredEqualTypes$1 extends FunctionReference implements n {
    @Override // kotlin.jvm.internal.CallableReference, Z7.c
    public final String getName() {
        return "isStrictSupertype";
    }

    @Override // kotlin.jvm.internal.CallableReference
    public final f getOwner() {
        return m.f4928a.b(b.class);
    }

    @Override // kotlin.jvm.internal.CallableReference
    public final String getSignature() {
        return "isStrictSupertype(Lorg/jetbrains/kotlin/types/KotlinType;Lorg/jetbrains/kotlin/types/KotlinType;)Z";
    }

    @Override // S7.n
    public final Object invoke(Object obj, Object obj2) {
        w p02 = (w) obj;
        w p1 = (w) obj2;
        k.f(p02, "p0");
        k.f(p1, "p1");
        ((b) this.receiver).getClass();
        Y8.k.b.getClass();
        l lVar = j.b;
        return Boolean.valueOf(lVar.b(p02, p1) && !lVar.b(p1, p02));
    }
}
