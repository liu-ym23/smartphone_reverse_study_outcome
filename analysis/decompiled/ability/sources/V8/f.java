package V8;

import X8.AbstractC0275f;
import java.util.Collection;
import kotlin.reflect.jvm.internal.impl.incremental.components.NoLookupLocation;

/* loaded from: classes4.dex */
public final class f implements S7.a {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f1395a;
    public final h b;

    public /* synthetic */ f(h hVar, int i) {
        this.f1395a = i;
        this.b = hVar;
    }

    @Override // S7.a
    public final Object invoke() {
        int i = this.f1395a;
        h hVar = this.b;
        switch (i) {
            case 0:
                Q8.f fVar = Q8.f.m;
                Q8.o.f1129a.getClass();
                Q8.l lVar = Q8.l.b;
                NoLookupLocation noLookupLocation = NoLookupLocation.f4986a;
                return hVar.h(fVar, lVar);
            default:
                Y8.f fVar2 = hVar.g;
                kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.b classDescriptor = hVar.f1396j;
                fVar2.getClass();
                kotlin.jvm.internal.k.f(classDescriptor, "classDescriptor");
                Collection collectionE = ((AbstractC0275f) classDescriptor.m()).e();
                kotlin.jvm.internal.k.e(collectionE, "getSupertypes(...)");
                return collectionE;
        }
    }
}
