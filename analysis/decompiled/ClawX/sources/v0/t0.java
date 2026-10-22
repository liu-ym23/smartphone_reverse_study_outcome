package v0;

/* compiled from: r8-map-id-ca86e8b578419e4708a9a7ee3f056b062b20ba338a8b13e201aefe3710dbf238 */
/* loaded from: classes.dex */
public final class t0 {

    /* renamed from: a, reason: collision with root package name */
    public int f5936a;

    /* renamed from: b, reason: collision with root package name */
    public int f5937b;

    /* renamed from: c, reason: collision with root package name */
    public int f5938c;
    public int d;

    /* renamed from: e, reason: collision with root package name */
    public int f5939e;

    public final boolean a() {
        int i8 = this.f5936a;
        int i9 = 2;
        if ((i8 & 7) != 0) {
            int i10 = this.d;
            int i11 = this.f5937b;
            if (((i10 > i11 ? 1 : i10 == i11 ? 2 : 4) & i8) == 0) {
                return false;
            }
        }
        if ((i8 & 112) != 0) {
            int i12 = this.d;
            int i13 = this.f5938c;
            if ((((i12 > i13 ? 1 : i12 == i13 ? 2 : 4) << 4) & i8) == 0) {
                return false;
            }
        }
        if ((i8 & 1792) != 0) {
            int i14 = this.f5939e;
            int i15 = this.f5937b;
            if ((((i14 > i15 ? 1 : i14 == i15 ? 2 : 4) << 8) & i8) == 0) {
                return false;
            }
        }
        if ((i8 & 28672) != 0) {
            int i16 = this.f5939e;
            int i17 = this.f5938c;
            if (i16 > i17) {
                i9 = 1;
            } else if (i16 != i17) {
                i9 = 4;
            }
            if (((i9 << 12) & i8) == 0) {
                return false;
            }
        }
        return true;
    }
}
