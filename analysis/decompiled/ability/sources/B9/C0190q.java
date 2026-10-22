package B9;

/* renamed from: B9.q, reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C0190q extends Y {
    public static final C0190q c = new C0190q(r.f254a);

    @Override // B9.AbstractC0174a
    public final int e(Object obj) {
        double[] dArr = (double[]) obj;
        kotlin.jvm.internal.k.f(dArr, "<this>");
        return dArr.length;
    }

    @Override // B9.AbstractC0188o, B9.AbstractC0174a
    public final void h(A9.c cVar, int i, Object obj) {
        C0189p builder = (C0189p) obj;
        kotlin.jvm.internal.k.f(builder, "builder");
        double dDecodeDoubleElement = cVar.decodeDoubleElement(this.b, i);
        builder.b(builder.d() + 1);
        double[] dArr = builder.f252a;
        int i6 = builder.b;
        builder.b = i6 + 1;
        dArr[i6] = dDecodeDoubleElement;
    }

    @Override // B9.AbstractC0174a
    public final Object i(Object obj) {
        double[] dArr = (double[]) obj;
        kotlin.jvm.internal.k.f(dArr, "<this>");
        C0189p c0189p = new C0189p();
        c0189p.f252a = dArr;
        c0189p.b = dArr.length;
        c0189p.b(10);
        return c0189p;
    }

    @Override // B9.Y
    public final Object l() {
        return new double[0];
    }

    @Override // B9.Y
    public final void m(A9.d encoder, Object obj, int i) {
        double[] content = (double[]) obj;
        kotlin.jvm.internal.k.f(encoder, "encoder");
        kotlin.jvm.internal.k.f(content, "content");
        for (int i6 = 0; i6 < i; i6++) {
            encoder.encodeDoubleElement(this.b, i6, content[i6]);
        }
    }
}
