package y5;

import d8.x0;

/* compiled from: r8-map-id-ca86e8b578419e4708a9a7ee3f056b062b20ba338a8b13e201aefe3710dbf238 */
/* loaded from: classes.dex */
public final class h implements i {

    /* renamed from: a, reason: collision with root package name */
    public final long f6354a;

    /* renamed from: b, reason: collision with root package name */
    public final int f6355b;

    public h(int i8, long j4) {
        this.f6354a = j4;
        this.f6355b = i8;
    }

    @Override // y5.i
    public final f toInstant() {
        e eVar = f.f6347c;
        long j4 = f.d.f6349a;
        long j8 = this.f6354a;
        if (j8 >= j4 && j8 <= f.f6348e.f6349a) {
            return e.a(this.f6355b, j8);
        }
        throw new x0("The parsed date is outside the range representable by Instant (Unix epoch second " + j8 + ')');
    }
}
