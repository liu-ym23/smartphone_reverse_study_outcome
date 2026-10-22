package b0;

import java.util.List;
import java.util.Objects;

/* compiled from: r8-map-id-ca86e8b578419e4708a9a7ee3f056b062b20ba338a8b13e201aefe3710dbf238 */
/* loaded from: classes.dex */
public final class c {

    /* renamed from: a, reason: collision with root package name */
    public String f810a;

    /* renamed from: b, reason: collision with root package name */
    public String f811b;

    /* renamed from: c, reason: collision with root package name */
    public List f812c;

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof c)) {
            return false;
        }
        c cVar = (c) obj;
        return Objects.equals(this.f810a, cVar.f810a) && Objects.equals(this.f811b, cVar.f811b) && Objects.equals(this.f812c, cVar.f812c);
    }

    public final int hashCode() {
        return Objects.hash(this.f810a, this.f811b, this.f812c);
    }
}
