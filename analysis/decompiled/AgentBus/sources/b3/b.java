package b3;

import java.util.LinkedHashMap;
import q7.k;

/* loaded from: classes.dex */
public abstract class b {

    /* renamed from: a, reason: collision with root package name */
    public final LinkedHashMap f1483a = new LinkedHashMap();

    public final boolean equals(Object obj) {
        if (obj instanceof b) {
            return k.a(this.f1483a, ((b) obj).f1483a);
        }
        return false;
    }

    public final int hashCode() {
        return this.f1483a.hashCode();
    }

    public final String toString() {
        return "CreationExtras(extras=" + this.f1483a + ')';
    }
}
