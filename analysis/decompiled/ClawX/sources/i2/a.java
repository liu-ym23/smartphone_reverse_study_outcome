package i2;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/* compiled from: r8-map-id-ca86e8b578419e4708a9a7ee3f056b062b20ba338a8b13e201aefe3710dbf238 */
/* loaded from: classes.dex */
public final class a {

    /* renamed from: b, reason: collision with root package name */
    public static final a f3137b = new a(Collections.unmodifiableMap(new HashMap()));

    /* renamed from: a, reason: collision with root package name */
    public final Map f3138a;

    public a(Map map) {
        this.f3138a = map;
    }

    public final boolean equals(Object obj) {
        if (obj instanceof a) {
            return this.f3138a.equals(((a) obj).f3138a);
        }
        return false;
    }

    public final int hashCode() {
        return this.f3138a.hashCode();
    }

    public final String toString() {
        return this.f3138a.toString();
    }
}
