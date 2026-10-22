package kotlin.reflect.jvm.internal.impl.types.checker;

import kotlin.jvm.internal.FunctionReferenceImpl;
import p9.p;
import ya.S;

/* loaded from: classes5.dex */
public final /* synthetic */ class TypeIntersector$intersectTypesWithoutIntersectionType$filteredEqualTypes$1 extends FunctionReferenceImpl implements p<S, S, Boolean> {
    public TypeIntersector$intersectTypesWithoutIntersectionType$filteredEqualTypes$1(Object obj) {
        super(2, obj, TypeIntersector.class, "isStrictSupertype", "isStrictSupertype(Lorg/jetbrains/kotlin/types/KotlinType;Lorg/jetbrains/kotlin/types/KotlinType;)Z", 0);
    }

    @Override // p9.p
    /* renamed from: l, reason: merged with bridge method [inline-methods] */
    public final Boolean invoke(S p02, S p12) {
        kotlin.jvm.internal.p.i(p02, "p0");
        kotlin.jvm.internal.p.i(p12, "p1");
        return Boolean.valueOf(((TypeIntersector) this.receiver).g(p02, p12));
    }
}
