package u5;

import kotlin.jvm.internal.p;

/* compiled from: r8-map-id-ca86e8b578419e4708a9a7ee3f056b062b20ba338a8b13e201aefe3710dbf238 */
/* loaded from: classes.dex */
public final class c extends a {
    static {
        new c((char) 1, (char) 0);
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof c)) {
            return false;
        }
        char c3 = this.f5657a;
        char c8 = this.f5658b;
        if (p.g(c3, c8) > 0) {
            c cVar = (c) obj;
            if (p.g(cVar.f5657a, cVar.f5658b) > 0) {
                return true;
            }
        }
        c cVar2 = (c) obj;
        return c3 == cVar2.f5657a && c8 == cVar2.f5658b;
    }

    public final int hashCode() {
        char c3 = this.f5657a;
        char c8 = this.f5658b;
        if (p.g(c3, c8) > 0) {
            return -1;
        }
        return (c3 * 31) + c8;
    }

    public final String toString() {
        return this.f5657a + ".." + this.f5658b;
    }
}
