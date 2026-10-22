package kotlin.reflect.jvm.internal.impl.types.checker;

import kotlin.jvm.internal.p;
import kotlin.reflect.jvm.internal.impl.types.TypeCheckerState;
import kotlin.reflect.jvm.internal.impl.types.checker.KotlinTypePreparator;
import kotlin.reflect.jvm.internal.impl.types.checker.c;
import za.C6468n;
import za.InterfaceC6455a;

/* loaded from: classes5.dex */
public final class a {
    public static final TypeCheckerState a(boolean z10, boolean z11, InterfaceC6455a typeSystemContext, KotlinTypePreparator kotlinTypePreparator, c kotlinTypeRefiner) {
        p.i(typeSystemContext, "typeSystemContext");
        p.i(kotlinTypePreparator, "kotlinTypePreparator");
        p.i(kotlinTypeRefiner, "kotlinTypeRefiner");
        return new TypeCheckerState(z10, z11, false, true, typeSystemContext, kotlinTypePreparator, kotlinTypeRefiner);
    }

    public static /* synthetic */ TypeCheckerState b(boolean z10, boolean z11, InterfaceC6455a interfaceC6455a, KotlinTypePreparator kotlinTypePreparator, c cVar, int i10, Object obj) {
        if ((i10 & 2) != 0) {
            z11 = true;
        }
        if ((i10 & 4) != 0) {
            interfaceC6455a = C6468n.f45422a;
        }
        if ((i10 & 8) != 0) {
            kotlinTypePreparator = KotlinTypePreparator.a.f36096a;
        }
        if ((i10 & 16) != 0) {
            cVar = c.a.f36099a;
        }
        return a(z10, z11, interfaceC6455a, kotlinTypePreparator, cVar);
    }
}
