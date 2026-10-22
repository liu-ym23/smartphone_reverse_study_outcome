package tc;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final class i extends u0<Byte, byte[], h> {

    /* renamed from: c, reason: collision with root package name */
    public static final i f12991c = new i(j.f12996a);

    @Override // tc.a
    public final int h(Object obj) {
        byte[] bArr = (byte[]) obj;
        kotlin.jvm.internal.g.f(bArr, "<this>");
        return bArr.length;
    }

    @Override // tc.o, tc.a
    public final void j(sc.b bVar, int i10, Object obj) {
        h builder = (h) obj;
        kotlin.jvm.internal.g.f(builder, "builder");
        byte B = bVar.B(this.f13058b, i10);
        builder.b(builder.d() + 1);
        byte[] bArr = builder.f12986a;
        int i11 = builder.f12987b;
        builder.f12987b = i11 + 1;
        bArr[i11] = B;
    }

    @Override // tc.a
    public final Object k(Object obj) {
        byte[] bArr = (byte[]) obj;
        kotlin.jvm.internal.g.f(bArr, "<this>");
        h hVar = new h();
        hVar.f12986a = bArr;
        hVar.f12987b = bArr.length;
        hVar.b(10);
        return hVar;
    }

    @Override // tc.u0
    public final byte[] n() {
        return new byte[0];
    }

    @Override // tc.u0
    public final void o(sc.c encoder, byte[] bArr, int i10) {
        byte[] content = bArr;
        kotlin.jvm.internal.g.f(encoder, "encoder");
        kotlin.jvm.internal.g.f(content, "content");
        for (int i11 = 0; i11 < i10; i11++) {
            encoder.l(this.f13058b, i11, content[i11]);
        }
    }
}
