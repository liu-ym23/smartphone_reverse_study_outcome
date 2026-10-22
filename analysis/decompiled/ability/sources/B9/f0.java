package B9;

/* loaded from: classes4.dex */
public final class f0 extends Y {
    public static final f0 c = new f0(g0.f240a);

    @Override // B9.AbstractC0174a
    public final int e(Object obj) {
        short[] sArr = (short[]) obj;
        kotlin.jvm.internal.k.f(sArr, "<this>");
        return sArr.length;
    }

    @Override // B9.AbstractC0188o, B9.AbstractC0174a
    public final void h(A9.c cVar, int i, Object obj) {
        e0 builder = (e0) obj;
        kotlin.jvm.internal.k.f(builder, "builder");
        short sDecodeShortElement = cVar.decodeShortElement(this.b, i);
        builder.b(builder.d() + 1);
        short[] sArr = builder.f238a;
        int i6 = builder.b;
        builder.b = i6 + 1;
        sArr[i6] = sDecodeShortElement;
    }

    @Override // B9.AbstractC0174a
    public final Object i(Object obj) {
        short[] sArr = (short[]) obj;
        kotlin.jvm.internal.k.f(sArr, "<this>");
        e0 e0Var = new e0();
        e0Var.f238a = sArr;
        e0Var.b = sArr.length;
        e0Var.b(10);
        return e0Var;
    }

    @Override // B9.Y
    public final Object l() {
        return new short[0];
    }

    @Override // B9.Y
    public final void m(A9.d encoder, Object obj, int i) {
        short[] content = (short[]) obj;
        kotlin.jvm.internal.k.f(encoder, "encoder");
        kotlin.jvm.internal.k.f(content, "content");
        for (int i6 = 0; i6 < i; i6++) {
            encoder.encodeShortElement(this.b, i6, content[i6]);
        }
    }
}
