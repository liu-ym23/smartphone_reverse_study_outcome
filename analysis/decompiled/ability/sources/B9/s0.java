package B9;

/* loaded from: classes4.dex */
public final class s0 extends Y {
    public static final s0 c = new s0(t0.f258a);

    @Override // B9.AbstractC0174a
    public final int e(Object obj) {
        short[] collectionSize = ((C7.q) obj).f316a;
        kotlin.jvm.internal.k.f(collectionSize, "$this$collectionSize");
        return collectionSize.length;
    }

    @Override // B9.AbstractC0188o, B9.AbstractC0174a
    public final void h(A9.c cVar, int i, Object obj) {
        r0 builder = (r0) obj;
        kotlin.jvm.internal.k.f(builder, "builder");
        short sDecodeShort = cVar.decodeInlineElement(this.b, i).decodeShort();
        builder.b(builder.d() + 1);
        short[] sArr = builder.f255a;
        int i6 = builder.b;
        builder.b = i6 + 1;
        sArr[i6] = sDecodeShort;
    }

    @Override // B9.AbstractC0174a
    public final Object i(Object obj) {
        short[] toBuilder = ((C7.q) obj).f316a;
        kotlin.jvm.internal.k.f(toBuilder, "$this$toBuilder");
        r0 r0Var = new r0();
        r0Var.f255a = toBuilder;
        r0Var.b = toBuilder.length;
        r0Var.b(10);
        return r0Var;
    }

    @Override // B9.Y
    public final Object l() {
        return new C7.q(new short[0]);
    }

    @Override // B9.Y
    public final void m(A9.d encoder, Object obj, int i) {
        short[] sArr = ((C7.q) obj).f316a;
        kotlin.jvm.internal.k.f(encoder, "encoder");
        for (int i6 = 0; i6 < i; i6++) {
            encoder.encodeInlineElement(this.b, i6).encodeShort(sArr[i6]);
        }
    }
}
