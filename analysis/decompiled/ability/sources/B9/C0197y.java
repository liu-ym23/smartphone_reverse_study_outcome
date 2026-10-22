package B9;

/* renamed from: B9.y, reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C0197y extends Y {
    public static final C0197y c = new C0197y(C0198z.f264a);

    @Override // B9.AbstractC0174a
    public final int e(Object obj) {
        float[] fArr = (float[]) obj;
        kotlin.jvm.internal.k.f(fArr, "<this>");
        return fArr.length;
    }

    @Override // B9.AbstractC0188o, B9.AbstractC0174a
    public final void h(A9.c cVar, int i, Object obj) {
        C0196x builder = (C0196x) obj;
        kotlin.jvm.internal.k.f(builder, "builder");
        float fDecodeFloatElement = cVar.decodeFloatElement(this.b, i);
        builder.b(builder.d() + 1);
        float[] fArr = builder.f263a;
        int i6 = builder.b;
        builder.b = i6 + 1;
        fArr[i6] = fDecodeFloatElement;
    }

    @Override // B9.AbstractC0174a
    public final Object i(Object obj) {
        float[] fArr = (float[]) obj;
        kotlin.jvm.internal.k.f(fArr, "<this>");
        C0196x c0196x = new C0196x();
        c0196x.f263a = fArr;
        c0196x.b = fArr.length;
        c0196x.b(10);
        return c0196x;
    }

    @Override // B9.Y
    public final Object l() {
        return new float[0];
    }

    @Override // B9.Y
    public final void m(A9.d encoder, Object obj, int i) {
        float[] content = (float[]) obj;
        kotlin.jvm.internal.k.f(encoder, "encoder");
        kotlin.jvm.internal.k.f(content, "content");
        for (int i6 = 0; i6 < i; i6++) {
            encoder.encodeFloatElement(this.b, i6, content[i6]);
        }
    }
}
