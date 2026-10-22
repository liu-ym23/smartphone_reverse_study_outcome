package d8;

/* compiled from: r8-map-id-ca86e8b578419e4708a9a7ee3f056b062b20ba338a8b13e201aefe3710dbf238 */
/* loaded from: classes.dex */
public final class j3 extends i3 {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f2037a;

    /* renamed from: b, reason: collision with root package name */
    public byte[] f2038b;

    public /* synthetic */ j3(int i8) {
        this.f2037a = i8;
    }

    @Override // d8.i3
    public final void a(byte[] bArr) {
        switch (this.f2037a) {
            case 0:
                this.f2038b = bArr;
                break;
            default:
                this.f2038b = bArr;
                break;
        }
    }

    @Override // d8.i3
    public final byte[] b() {
        switch (this.f2037a) {
        }
        return this.f2038b;
    }

    @Override // d8.i3
    public final String toString() {
        switch (this.f2037a) {
            case 0:
                return a.a.f0(this.f2038b);
            default:
                return w2.a(this.f2038b, false);
        }
    }
}
