package ba;

import ua.C5622h;
import ua.InterfaceC5623i;

/* loaded from: classes5.dex */
public final class i implements InterfaceC5623i {

    /* renamed from: a, reason: collision with root package name */
    public final p f15333a;

    /* renamed from: b, reason: collision with root package name */
    public final kotlin.reflect.jvm.internal.impl.load.kotlin.e f15334b;

    public i(p kotlinClassFinder, kotlin.reflect.jvm.internal.impl.load.kotlin.e deserializedDescriptorResolver) {
        kotlin.jvm.internal.p.i(kotlinClassFinder, "kotlinClassFinder");
        kotlin.jvm.internal.p.i(deserializedDescriptorResolver, "deserializedDescriptorResolver");
        this.f15333a = kotlinClassFinder;
        this.f15334b = deserializedDescriptorResolver;
    }

    @Override // ua.InterfaceC5623i
    public C5622h a(ga.b classId) {
        kotlin.jvm.internal.p.i(classId, "classId");
        kotlin.reflect.jvm.internal.impl.load.kotlin.f fVarB = q.b(this.f15333a, classId, this.f15334b.f().g().d());
        if (fVarB == null) {
            return null;
        }
        kotlin.jvm.internal.p.d(fVarB.j(), classId);
        return this.f15334b.l(fVarB);
    }
}
