package B9;

/* renamed from: B9.i, reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C0182i extends Y {
    public static final C0182i c = new C0182i(C0183j.f244a);

    @Override // B9.AbstractC0174a
    public final int e(Object obj) {
        byte[] bArr = (byte[]) obj;
        kotlin.jvm.internal.k.f(bArr, "<this>");
        return bArr.length;
    }

    @Override // B9.AbstractC0188o, B9.AbstractC0174a
    public final void h(A9.c cVar, int i, Object obj) {
        C0181h builder = (C0181h) obj;
        kotlin.jvm.internal.k.f(builder, "builder");
        byte bDecodeByteElement = cVar.decodeByteElement(this.b, i);
        builder.b(builder.d() + 1);
        byte[] bArr = builder.f241a;
        int i6 = builder.b;
        builder.b = i6 + 1;
        bArr[i6] = bDecodeByteElement;
    }

    @Override // B9.AbstractC0174a
    public final Object i(Object obj) {
        byte[] bArr = (byte[]) obj;
        kotlin.jvm.internal.k.f(bArr, "<this>");
        C0181h c0181h = new C0181h();
        c0181h.f241a = bArr;
        c0181h.b = bArr.length;
        c0181h.b(10);
        return c0181h;
    }

    @Override // B9.Y
    public final Object l() {
        return new byte[0];
    }

    @Override // B9.Y
    public final void m(A9.d encoder, Object obj, int i) {
        byte[] content = (byte[]) obj;
        kotlin.jvm.internal.k.f(encoder, "encoder");
        kotlin.jvm.internal.k.f(content, "content");
        for (int i6 = 0; i6 < i; i6++) {
            encoder.encodeByteElement(this.b, i6, content[i6]);
        }
    }
}
