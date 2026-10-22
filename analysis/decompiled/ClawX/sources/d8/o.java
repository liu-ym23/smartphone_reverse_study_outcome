package d8;

/* compiled from: r8-map-id-ca86e8b578419e4708a9a7ee3f056b062b20ba338a8b13e201aefe3710dbf238 */
/* loaded from: classes.dex */
public final class o extends d0 {

    /* renamed from: b, reason: collision with root package name */
    public byte[] f2098b;

    /* renamed from: c, reason: collision with root package name */
    public byte[] f2099c;

    @Override // d8.d0
    public final void a(u uVar) throws l4 {
        int iRemaining = uVar.f2171a.remaining();
        if (iRemaining < 8) {
            throw new l4("invalid length of client cookie");
        }
        this.f2098b = uVar.b(8);
        if (iRemaining > 8) {
            if (iRemaining < 16 || iRemaining > 40) {
                throw new l4("invalid length of server cookie");
            }
            this.f2099c = uVar.a();
        }
    }

    @Override // d8.d0
    public final String b() {
        if (this.f2099c == null) {
            return b8.h.O(this.f2098b);
        }
        return b8.h.O(this.f2098b) + " " + b8.h.O(this.f2099c);
    }

    @Override // d8.d0
    public final void c(b0.j jVar) {
        jVar.h(this.f2098b);
        byte[] bArr = this.f2099c;
        if (bArr != null) {
            jVar.g(0, bArr.length, bArr);
        }
    }
}
