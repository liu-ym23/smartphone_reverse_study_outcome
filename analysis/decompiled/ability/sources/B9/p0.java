package B9;

/* loaded from: classes4.dex */
public final class p0 extends Y {
    public static final p0 c = new p0(q0.f253a);

    @Override // B9.AbstractC0174a
    public final int e(Object obj) {
        long[] collectionSize = ((C7.n) obj).f313a;
        kotlin.jvm.internal.k.f(collectionSize, "$this$collectionSize");
        return collectionSize.length;
    }

    @Override // B9.AbstractC0188o, B9.AbstractC0174a
    public final void h(A9.c cVar, int i, Object obj) {
        o0 builder = (o0) obj;
        kotlin.jvm.internal.k.f(builder, "builder");
        long jDecodeLong = cVar.decodeInlineElement(this.b, i).decodeLong();
        builder.b(builder.d() + 1);
        long[] jArr = builder.f251a;
        int i6 = builder.b;
        builder.b = i6 + 1;
        jArr[i6] = jDecodeLong;
    }

    @Override // B9.AbstractC0174a
    public final Object i(Object obj) {
        long[] toBuilder = ((C7.n) obj).f313a;
        kotlin.jvm.internal.k.f(toBuilder, "$this$toBuilder");
        o0 o0Var = new o0();
        o0Var.f251a = toBuilder;
        o0Var.b = toBuilder.length;
        o0Var.b(10);
        return o0Var;
    }

    @Override // B9.Y
    public final Object l() {
        return new C7.n(new long[0]);
    }

    @Override // B9.Y
    public final void m(A9.d encoder, Object obj, int i) {
        long[] jArr = ((C7.n) obj).f313a;
        kotlin.jvm.internal.k.f(encoder, "encoder");
        for (int i6 = 0; i6 < i; i6++) {
            encoder.encodeInlineElement(this.b, i6).encodeLong(jArr[i6]);
        }
    }
}
