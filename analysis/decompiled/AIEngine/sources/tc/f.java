package tc;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final class f extends u0<Boolean, boolean[], e> {

    /* renamed from: c, reason: collision with root package name */
    public static final f f12977c = new f(g.f12981a);

    @Override // tc.a
    public final int h(Object obj) {
        boolean[] zArr = (boolean[]) obj;
        kotlin.jvm.internal.g.f(zArr, "<this>");
        return zArr.length;
    }

    @Override // tc.o, tc.a
    public final void j(sc.b bVar, int i10, Object obj) {
        e builder = (e) obj;
        kotlin.jvm.internal.g.f(builder, "builder");
        boolean zI = bVar.i(this.f13058b, i10);
        builder.b(builder.d() + 1);
        boolean[] zArr = builder.f12972a;
        int i11 = builder.f12973b;
        builder.f12973b = i11 + 1;
        zArr[i11] = zI;
    }

    @Override // tc.a
    public final Object k(Object obj) {
        boolean[] zArr = (boolean[]) obj;
        kotlin.jvm.internal.g.f(zArr, "<this>");
        e eVar = new e();
        eVar.f12972a = zArr;
        eVar.f12973b = zArr.length;
        eVar.b(10);
        return eVar;
    }

    @Override // tc.u0
    public final boolean[] n() {
        return new boolean[0];
    }

    @Override // tc.u0
    public final void o(sc.c encoder, boolean[] zArr, int i10) {
        boolean[] content = zArr;
        kotlin.jvm.internal.g.f(encoder, "encoder");
        kotlin.jvm.internal.g.f(content, "content");
        for (int i11 = 0; i11 < i10; i11++) {
            encoder.p(this.f13058b, i11, content[i11]);
        }
    }
}
