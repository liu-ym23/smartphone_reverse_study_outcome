package B9;

/* loaded from: classes4.dex */
public final class m0 extends Y {
    public static final m0 c = new m0(n0.f249a);

    @Override // B9.AbstractC0174a
    public final int e(Object obj) {
        int[] collectionSize = ((C7.l) obj).f311a;
        kotlin.jvm.internal.k.f(collectionSize, "$this$collectionSize");
        return collectionSize.length;
    }

    @Override // B9.AbstractC0188o, B9.AbstractC0174a
    public final void h(A9.c cVar, int i, Object obj) {
        l0 builder = (l0) obj;
        kotlin.jvm.internal.k.f(builder, "builder");
        int iDecodeInt = cVar.decodeInlineElement(this.b, i).decodeInt();
        builder.b(builder.d() + 1);
        int[] iArr = builder.f247a;
        int i6 = builder.b;
        builder.b = i6 + 1;
        iArr[i6] = iDecodeInt;
    }

    @Override // B9.AbstractC0174a
    public final Object i(Object obj) {
        int[] toBuilder = ((C7.l) obj).f311a;
        kotlin.jvm.internal.k.f(toBuilder, "$this$toBuilder");
        l0 l0Var = new l0();
        l0Var.f247a = toBuilder;
        l0Var.b = toBuilder.length;
        l0Var.b(10);
        return l0Var;
    }

    @Override // B9.Y
    public final Object l() {
        return new C7.l(new int[0]);
    }

    @Override // B9.Y
    public final void m(A9.d encoder, Object obj, int i) {
        int[] iArr = ((C7.l) obj).f311a;
        kotlin.jvm.internal.k.f(encoder, "encoder");
        for (int i6 = 0; i6 < i; i6++) {
            encoder.encodeInlineElement(this.b, i6).encodeInt(iArr[i6]);
        }
    }
}
