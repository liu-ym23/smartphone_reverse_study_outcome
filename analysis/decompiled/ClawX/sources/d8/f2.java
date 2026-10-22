package d8;

import java.net.InetSocketAddress;

/* compiled from: r8-map-id-ca86e8b578419e4708a9a7ee3f056b062b20ba338a8b13e201aefe3710dbf238 */
/* loaded from: classes.dex */
public final class f2 {

    /* renamed from: a, reason: collision with root package name */
    public final InetSocketAddress f1991a;

    public f2(InetSocketAddress inetSocketAddress) {
        this.f1991a = inetSocketAddress;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof f2)) {
            return false;
        }
        InetSocketAddress inetSocketAddress = ((f2) obj).f1991a;
        InetSocketAddress inetSocketAddress2 = this.f1991a;
        return inetSocketAddress2 == null ? inetSocketAddress == null : inetSocketAddress2.equals(inetSocketAddress);
    }

    public final int hashCode() {
        int i8 = (59 + 43) * 59;
        InetSocketAddress inetSocketAddress = this.f1991a;
        return i8 + (inetSocketAddress != null ? inetSocketAddress.hashCode() : 43);
    }
}
