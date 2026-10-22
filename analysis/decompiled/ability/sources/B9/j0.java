package B9;

/* loaded from: classes4.dex */
public final class j0 extends Y {
    public static final j0 c = new j0(k0.f245a);

    @Override // B9.AbstractC0174a
    public final int e(Object obj) {
        byte[] collectionSize = ((C7.j) obj).f309a;
        kotlin.jvm.internal.k.f(collectionSize, "$this$collectionSize");
        return collectionSize.length;
    }

    @Override // B9.AbstractC0188o, B9.AbstractC0174a
    public final void h(A9.c cVar, int i, Object obj) {
        i0 builder = (i0) obj;
        kotlin.jvm.internal.k.f(builder, "builder");
        byte bDecodeByte = cVar.decodeInlineElement(this.b, i).decodeByte();
        builder.b(builder.d() + 1);
        byte[] bArr = builder.f243a;
        int i6 = builder.b;
        builder.b = i6 + 1;
        bArr[i6] = bDecodeByte;
    }

    @Override // B9.AbstractC0174a
    public final Object i(Object obj) {
        byte[] toBuilder = ((C7.j) obj).f309a;
        kotlin.jvm.internal.k.f(toBuilder, "$this$toBuilder");
        i0 i0Var = new i0();
        i0Var.f243a = toBuilder;
        i0Var.b = toBuilder.length;
        i0Var.b(10);
        return i0Var;
    }

    @Override // B9.Y
    public final Object l() {
        return new C7.j(new byte[0]);
    }

    @Override // B9.Y
    public final void m(A9.d encoder, Object obj, int i) {
        byte[] bArr = ((C7.j) obj).f309a;
        kotlin.jvm.internal.k.f(encoder, "encoder");
        for (int i6 = 0; i6 < i; i6++) {
            encoder.encodeInlineElement(this.b, i6).encodeByte(bArr[i6]);
        }
    }
}
