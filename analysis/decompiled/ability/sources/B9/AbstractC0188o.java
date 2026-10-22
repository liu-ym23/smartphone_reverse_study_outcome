package B9;

import java.util.Iterator;

/* renamed from: B9.o, reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public abstract class AbstractC0188o extends AbstractC0174a {

    /* renamed from: a, reason: collision with root package name */
    public final x9.b f250a;

    public AbstractC0188o(x9.b bVar) {
        this.f250a = bVar;
    }

    @Override // B9.AbstractC0174a
    public final void g(A9.c cVar, Object obj, int i, int i6) {
        if (i6 < 0) {
            throw new IllegalArgumentException("Size must be known in advance when using READ_ALL");
        }
        for (int i10 = 0; i10 < i6; i10++) {
            h(cVar, i + i10, obj);
        }
    }

    @Override // B9.AbstractC0174a
    public void h(A9.c cVar, int i, Object obj) {
        k(i, obj, cVar.decodeSerializableElement(getDescriptor(), i, this.f250a, null));
    }

    public abstract void k(int i, Object obj, Object obj2);

    @Override // x9.f
    public void serialize(A9.f fVar, Object obj) {
        int iE = e(obj);
        z9.g descriptor = getDescriptor();
        A9.d dVarBeginCollection = fVar.beginCollection(descriptor, iE);
        Iterator itD = d(obj);
        for (int i = 0; i < iE; i++) {
            dVarBeginCollection.encodeSerializableElement(getDescriptor(), i, this.f250a, itD.next());
        }
        dVarBeginCollection.endStructure(descriptor);
    }
}
