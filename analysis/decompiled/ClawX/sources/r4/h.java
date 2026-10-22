package r4;

import java.util.Map;
import kotlin.jvm.internal.p;

/* compiled from: r8-map-id-ca86e8b578419e4708a9a7ee3f056b062b20ba338a8b13e201aefe3710dbf238 */
/* loaded from: classes.dex */
public final class h implements Map.Entry, q5.d {

    /* renamed from: a, reason: collision with root package name */
    public final Object f5101a;

    /* renamed from: b, reason: collision with root package name */
    public Object f5102b;

    public h(Object obj, Object obj2) {
        this.f5101a = obj;
        this.f5102b = obj2;
    }

    @Override // java.util.Map.Entry
    public final boolean equals(Object obj) {
        if (obj != null && (obj instanceof Map.Entry)) {
            Map.Entry entry = (Map.Entry) obj;
            if (p.a(entry.getKey(), this.f5101a) && p.a(entry.getValue(), this.f5102b)) {
                return true;
            }
        }
        return false;
    }

    @Override // java.util.Map.Entry
    public final Object getKey() {
        return this.f5101a;
    }

    @Override // java.util.Map.Entry
    public final Object getValue() {
        return this.f5102b;
    }

    @Override // java.util.Map.Entry
    public final int hashCode() {
        Object obj = this.f5101a;
        p.b(obj);
        int iHashCode = obj.hashCode() + 527;
        Object obj2 = this.f5102b;
        p.b(obj2);
        return obj2.hashCode() + iHashCode;
    }

    @Override // java.util.Map.Entry
    public final Object setValue(Object obj) {
        this.f5102b = obj;
        return obj;
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(this.f5101a);
        sb.append('=');
        sb.append(this.f5102b);
        return sb.toString();
    }
}
