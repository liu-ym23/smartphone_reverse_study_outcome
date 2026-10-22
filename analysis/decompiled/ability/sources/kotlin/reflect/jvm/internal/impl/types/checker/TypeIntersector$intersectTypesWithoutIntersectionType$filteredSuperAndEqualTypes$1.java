package kotlin.reflect.jvm.internal.impl.types.checker;

import S7.n;
import X8.w;
import Y8.l;
import Z7.f;
import kotlin.jvm.internal.FunctionReference;
import kotlin.jvm.internal.k;
import kotlin.jvm.internal.m;

/* loaded from: classes4.dex */
final /* synthetic */ class TypeIntersector$intersectTypesWithoutIntersectionType$filteredSuperAndEqualTypes$1 extends FunctionReference implements n {
    @Override // kotlin.jvm.internal.CallableReference, Z7.c
    public final String getName() {
        return "equalTypes";
    }

    @Override // kotlin.jvm.internal.CallableReference
    public final f getOwner() {
        return m.f4928a.b(l.class);
    }

    @Override // kotlin.jvm.internal.CallableReference
    public final String getSignature() {
        return "equalTypes(Lorg/jetbrains/kotlin/types/KotlinType;Lorg/jetbrains/kotlin/types/KotlinType;)Z";
    }

    @Override // S7.n
    public final Object invoke(Object obj, Object obj2) {
        w p02 = (w) obj;
        w p1 = (w) obj2;
        k.f(p02, "p0");
        k.f(p1, "p1");
        return Boolean.valueOf(((l) this.receiver).a(p02, p1));
    }
}
