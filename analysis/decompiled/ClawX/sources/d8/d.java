package d8;

import java.io.Serializable;
import java.net.InetAddress;

/* compiled from: r8-map-id-ca86e8b578419e4708a9a7ee3f056b062b20ba338a8b13e201aefe3710dbf238 */
/* loaded from: classes.dex */
public final class d implements Serializable {

    /* renamed from: a, reason: collision with root package name */
    public final int f1973a;

    /* renamed from: b, reason: collision with root package name */
    public final boolean f1974b;

    /* renamed from: c, reason: collision with root package name */
    public final int f1975c;
    public final Object d;

    public d(int i8, boolean z, Serializable serializable, int i9) {
        this.f1973a = i8;
        this.f1974b = z;
        this.d = serializable;
        this.f1975c = i9;
        if (i9 < 0 || i9 >= 256 || ((i8 == 1 && i9 > 32) || (i8 == 2 && i9 > 128))) {
            throw new IllegalArgumentException("invalid prefix length");
        }
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof d)) {
            return false;
        }
        d dVar = (d) obj;
        return this.f1973a == dVar.f1973a && this.f1974b == dVar.f1974b && this.f1975c == dVar.f1975c && this.d.equals(dVar.d);
    }

    public final int hashCode() {
        return this.d.hashCode() + this.f1975c + (this.f1974b ? 1 : 0);
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder();
        if (this.f1974b) {
            sb.append("!");
        }
        int i8 = this.f1973a;
        sb.append(i8);
        sb.append(":");
        Object obj = this.d;
        if (i8 == 1 || i8 == 2) {
            sb.append(((InetAddress) obj).getHostAddress());
        } else {
            sb.append(b8.h.O((byte[]) obj));
        }
        sb.append("/");
        sb.append(this.f1975c);
        return sb.toString();
    }
}
