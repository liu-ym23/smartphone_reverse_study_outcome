package d4;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/* loaded from: classes.dex */
public final class a {

    /* renamed from: b, reason: collision with root package name */
    public static final a f2836b = new a(Collections.unmodifiableMap(new HashMap()));

    /* renamed from: a, reason: collision with root package name */
    public final Map f2837a;

    public a(Map map) {
        this.f2837a = map;
    }

    public final boolean equals(Object obj) {
        if (obj instanceof a) {
            return this.f2837a.equals(((a) obj).f2837a);
        }
        return false;
    }

    public final int hashCode() {
        return this.f2837a.hashCode();
    }

    public final String toString() {
        return this.f2837a.toString();
    }
}
