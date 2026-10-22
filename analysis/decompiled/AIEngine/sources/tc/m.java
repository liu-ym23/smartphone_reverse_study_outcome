package tc;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final class m extends u0<Character, char[], l> {

    /* renamed from: c, reason: collision with root package name */
    public static final m f13012c = new m(n.f13016a);

    @Override // tc.a
    public final int h(Object obj) {
        char[] cArr = (char[]) obj;
        kotlin.jvm.internal.g.f(cArr, "<this>");
        return cArr.length;
    }

    @Override // tc.o, tc.a
    public final void j(sc.b bVar, int i10, Object obj) {
        l builder = (l) obj;
        kotlin.jvm.internal.g.f(builder, "builder");
        char cE = bVar.e(this.f13058b, i10);
        builder.b(builder.d() + 1);
        char[] cArr = builder.f13005a;
        int i11 = builder.f13006b;
        builder.f13006b = i11 + 1;
        cArr[i11] = cE;
    }

    @Override // tc.a
    public final Object k(Object obj) {
        char[] cArr = (char[]) obj;
        kotlin.jvm.internal.g.f(cArr, "<this>");
        l lVar = new l();
        lVar.f13005a = cArr;
        lVar.f13006b = cArr.length;
        lVar.b(10);
        return lVar;
    }

    @Override // tc.u0
    public final char[] n() {
        return new char[0];
    }

    @Override // tc.u0
    public final void o(sc.c encoder, char[] cArr, int i10) {
        char[] content = cArr;
        kotlin.jvm.internal.g.f(encoder, "encoder");
        kotlin.jvm.internal.g.f(content, "content");
        for (int i11 = 0; i11 < i10; i11++) {
            encoder.A(this.f13058b, i11, content[i11]);
        }
    }
}
