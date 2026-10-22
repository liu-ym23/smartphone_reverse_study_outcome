package B9;

import java.util.Iterator;

/* loaded from: classes4.dex */
public abstract class Y extends AbstractC0188o {
    public final X b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public Y(x9.b primitiveSerializer) {
        super(primitiveSerializer);
        kotlin.jvm.internal.k.f(primitiveSerializer, "primitiveSerializer");
        this.b = new X(primitiveSerializer.getDescriptor());
    }

    @Override // B9.AbstractC0174a
    public final Object a() {
        return (W) i(l());
    }

    @Override // B9.AbstractC0174a
    public final int b(Object obj) {
        W w8 = (W) obj;
        kotlin.jvm.internal.k.f(w8, "<this>");
        return w8.d();
    }

    @Override // B9.AbstractC0174a
    public final void c(int i, Object obj) {
        W w8 = (W) obj;
        kotlin.jvm.internal.k.f(w8, "<this>");
        w8.b(i);
    }

    @Override // B9.AbstractC0174a
    public final Iterator d(Object obj) {
        throw new IllegalStateException("This method lead to boxing and must not be used, use writeContents instead");
    }

    @Override // B9.AbstractC0174a, x9.InterfaceC2123a
    public final Object deserialize(A9.e decoder) {
        kotlin.jvm.internal.k.f(decoder, "decoder");
        return f(decoder);
    }

    @Override // x9.f, x9.InterfaceC2123a
    public final z9.g getDescriptor() {
        return this.b;
    }

    @Override // B9.AbstractC0174a
    public final Object j(Object obj) {
        W w8 = (W) obj;
        kotlin.jvm.internal.k.f(w8, "<this>");
        return w8.a();
    }

    @Override // B9.AbstractC0188o
    public final void k(int i, Object obj, Object obj2) {
        kotlin.jvm.internal.k.f((W) obj, "<this>");
        throw new IllegalStateException("This method lead to boxing and must not be used, use Builder.append instead");
    }

    public abstract Object l();

    public abstract void m(A9.d dVar, Object obj, int i);

    @Override // B9.AbstractC0188o, x9.f
    public final void serialize(A9.f fVar, Object obj) {
        int iE = e(obj);
        X x10 = this.b;
        A9.d dVarBeginCollection = fVar.beginCollection(x10, iE);
        m(dVarBeginCollection, obj, iE);
        dVarBeginCollection.endStructure(x10);
    }
}
