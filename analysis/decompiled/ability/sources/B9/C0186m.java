package B9;

/* renamed from: B9.m, reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C0186m extends Y {
    public static final C0186m c = new C0186m(C0187n.f248a);

    @Override // B9.AbstractC0174a
    public final int e(Object obj) {
        char[] cArr = (char[]) obj;
        kotlin.jvm.internal.k.f(cArr, "<this>");
        return cArr.length;
    }

    @Override // B9.AbstractC0188o, B9.AbstractC0174a
    public final void h(A9.c cVar, int i, Object obj) {
        C0185l builder = (C0185l) obj;
        kotlin.jvm.internal.k.f(builder, "builder");
        char cDecodeCharElement = cVar.decodeCharElement(this.b, i);
        builder.b(builder.d() + 1);
        char[] cArr = builder.f246a;
        int i6 = builder.b;
        builder.b = i6 + 1;
        cArr[i6] = cDecodeCharElement;
    }

    @Override // B9.AbstractC0174a
    public final Object i(Object obj) {
        char[] cArr = (char[]) obj;
        kotlin.jvm.internal.k.f(cArr, "<this>");
        C0185l c0185l = new C0185l();
        c0185l.f246a = cArr;
        c0185l.b = cArr.length;
        c0185l.b(10);
        return c0185l;
    }

    @Override // B9.Y
    public final Object l() {
        return new char[0];
    }

    @Override // B9.Y
    public final void m(A9.d encoder, Object obj, int i) {
        char[] content = (char[]) obj;
        kotlin.jvm.internal.k.f(encoder, "encoder");
        kotlin.jvm.internal.k.f(content, "content");
        for (int i6 = 0; i6 < i; i6++) {
            encoder.encodeCharElement(this.b, i6, content[i6]);
        }
    }
}
