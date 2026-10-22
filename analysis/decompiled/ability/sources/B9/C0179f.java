package B9;

/* renamed from: B9.f, reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C0179f extends Y {
    public static final C0179f c = new C0179f(C0180g.f239a);

    @Override // B9.AbstractC0174a
    public final int e(Object obj) {
        boolean[] zArr = (boolean[]) obj;
        kotlin.jvm.internal.k.f(zArr, "<this>");
        return zArr.length;
    }

    @Override // B9.AbstractC0188o, B9.AbstractC0174a
    public final void h(A9.c cVar, int i, Object obj) {
        C0178e builder = (C0178e) obj;
        kotlin.jvm.internal.k.f(builder, "builder");
        boolean zDecodeBooleanElement = cVar.decodeBooleanElement(this.b, i);
        builder.b(builder.d() + 1);
        boolean[] zArr = builder.f237a;
        int i6 = builder.b;
        builder.b = i6 + 1;
        zArr[i6] = zDecodeBooleanElement;
    }

    @Override // B9.AbstractC0174a
    public final Object i(Object obj) {
        boolean[] zArr = (boolean[]) obj;
        kotlin.jvm.internal.k.f(zArr, "<this>");
        C0178e c0178e = new C0178e();
        c0178e.f237a = zArr;
        c0178e.b = zArr.length;
        c0178e.b(10);
        return c0178e;
    }

    @Override // B9.Y
    public final Object l() {
        return new boolean[0];
    }

    @Override // B9.Y
    public final void m(A9.d encoder, Object obj, int i) {
        boolean[] content = (boolean[]) obj;
        kotlin.jvm.internal.k.f(encoder, "encoder");
        kotlin.jvm.internal.k.f(content, "content");
        for (int i6 = 0; i6 < i; i6++) {
            encoder.encodeBooleanElement(this.b, i6, content[i6]);
        }
    }
}
