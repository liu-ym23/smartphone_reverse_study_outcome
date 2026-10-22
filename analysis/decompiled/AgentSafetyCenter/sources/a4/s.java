package a4;

import java.nio.ByteBuffer;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final class s {

    /* renamed from: a, reason: collision with root package name */
    public int f193a;

    /* renamed from: b, reason: collision with root package name */
    public w f194b;

    /* renamed from: c, reason: collision with root package name */
    public w f195c;

    /* renamed from: d, reason: collision with root package name */
    public w f196d;

    /* renamed from: e, reason: collision with root package name */
    public int f197e;

    /* renamed from: f, reason: collision with root package name */
    public int f198f;

    public final void a() {
        this.f193a = 1;
        this.f195c = this.f194b;
        this.f198f = 0;
    }

    public final boolean b() {
        b4.a aVarB = this.f195c.f211b.b();
        int iA = aVarB.a(6);
        return !(iA == 0 || ((ByteBuffer) aVarB.f1900h).get(iA + aVarB.f1897c) == 0) || this.f197e == 65039;
    }
}
