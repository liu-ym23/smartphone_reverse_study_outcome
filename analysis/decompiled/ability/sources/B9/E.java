package B9;

/* loaded from: classes4.dex */
public final class E extends Y {
    public static final E c = new E(F.f218a);

    @Override // B9.AbstractC0174a
    public final int e(Object obj) {
        int[] iArr = (int[]) obj;
        kotlin.jvm.internal.k.f(iArr, "<this>");
        return iArr.length;
    }

    @Override // B9.AbstractC0188o, B9.AbstractC0174a
    public final void h(A9.c cVar, int i, Object obj) {
        D builder = (D) obj;
        kotlin.jvm.internal.k.f(builder, "builder");
        int iDecodeIntElement = cVar.decodeIntElement(this.b, i);
        builder.b(builder.d() + 1);
        int[] iArr = builder.f217a;
        int i6 = builder.b;
        builder.b = i6 + 1;
        iArr[i6] = iDecodeIntElement;
    }

    @Override // B9.AbstractC0174a
    public final Object i(Object obj) {
        int[] iArr = (int[]) obj;
        kotlin.jvm.internal.k.f(iArr, "<this>");
        D d = new D();
        d.f217a = iArr;
        d.b = iArr.length;
        d.b(10);
        return d;
    }

    @Override // B9.Y
    public final Object l() {
        return new int[0];
    }

    @Override // B9.Y
    public final void m(A9.d encoder, Object obj, int i) {
        int[] content = (int[]) obj;
        kotlin.jvm.internal.k.f(encoder, "encoder");
        kotlin.jvm.internal.k.f(content, "content");
        for (int i6 = 0; i6 < i; i6++) {
            encoder.encodeIntElement(this.b, i6, content[i6]);
        }
    }
}
