package a2;

/* compiled from: r8-map-id-ca86e8b578419e4708a9a7ee3f056b062b20ba338a8b13e201aefe3710dbf238 */
/* loaded from: classes.dex */
public final class f extends g {
    public final /* synthetic */ int d;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ f(byte[] bArr, int i8) {
        super(bArr);
        this.d = i8;
    }

    @Override // a2.g
    public final e r(byte[] bArr, int i8) {
        switch (this.d) {
            case 0:
                return new d(bArr, i8, 0);
            default:
                return new d(bArr, i8, 1);
        }
    }
}
