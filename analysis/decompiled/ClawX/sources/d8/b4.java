package d8;

import java.time.Duration;

/* compiled from: r8-map-id-ca86e8b578419e4708a9a7ee3f056b062b20ba338a8b13e201aefe3710dbf238 */
/* loaded from: classes.dex */
public final class b4 extends d0 {

    /* renamed from: b, reason: collision with root package name */
    public Integer f1962b;

    static {
        Duration.ofMillis(6553600L);
    }

    @Override // d8.d0
    public final void a(u uVar) throws l4 {
        int iRemaining = uVar.f2171a.remaining();
        if (iRemaining == 0) {
            this.f1962b = null;
        } else {
            if (iRemaining != 2) {
                throw new l4(a8.b.k(iRemaining, "invalid length (", ") of the data in the edns_tcp_keepalive option"));
            }
            this.f1962b = Integer.valueOf(uVar.d());
        }
    }

    @Override // d8.d0
    public final String b() {
        Integer num = this.f1962b;
        return num != null ? String.valueOf(num) : "-";
    }

    @Override // d8.d0
    public final void c(b0.j jVar) {
        Integer num = this.f1962b;
        if (num != null) {
            jVar.j(num.intValue());
        }
    }
}
