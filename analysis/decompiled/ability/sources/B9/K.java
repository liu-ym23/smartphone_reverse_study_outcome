package B9;

/* loaded from: classes4.dex */
public final class K extends Y {
    public static final K c = new K(L.f223a);

    @Override // B9.AbstractC0174a
    public final int e(Object obj) {
        long[] jArr = (long[]) obj;
        kotlin.jvm.internal.k.f(jArr, "<this>");
        return jArr.length;
    }

    @Override // B9.AbstractC0188o, B9.AbstractC0174a
    public final void h(A9.c cVar, int i, Object obj) {
        J builder = (J) obj;
        kotlin.jvm.internal.k.f(builder, "builder");
        long jDecodeLongElement = cVar.decodeLongElement(this.b, i);
        builder.b(builder.d() + 1);
        long[] jArr = builder.f222a;
        int i6 = builder.b;
        builder.b = i6 + 1;
        jArr[i6] = jDecodeLongElement;
    }

    @Override // B9.AbstractC0174a
    public final Object i(Object obj) {
        long[] jArr = (long[]) obj;
        kotlin.jvm.internal.k.f(jArr, "<this>");
        J j5 = new J();
        j5.f222a = jArr;
        j5.b = jArr.length;
        j5.b(10);
        return j5;
    }

    @Override // B9.Y
    public final Object l() {
        return new long[0];
    }

    @Override // B9.Y
    public final void m(A9.d encoder, Object obj, int i) {
        long[] content = (long[]) obj;
        kotlin.jvm.internal.k.f(encoder, "encoder");
        kotlin.jvm.internal.k.f(content, "content");
        for (int i6 = 0; i6 < i; i6++) {
            encoder.encodeLongElement(this.b, i6, content[i6]);
        }
    }
}
