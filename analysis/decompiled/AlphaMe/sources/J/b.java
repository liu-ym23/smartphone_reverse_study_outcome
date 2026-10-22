package J;

import com.stepos.alphame.awareness.AwarenessDataItem;
import java.util.Objects;

/* loaded from: classes.dex */
public final class b {

    /* renamed from: a, reason: collision with root package name */
    public final Object f848a;

    /* renamed from: b, reason: collision with root package name */
    public final Object f849b;

    public b(Object obj, Object obj2) {
        this.f848a = obj;
        this.f849b = obj2;
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof b)) {
            return false;
        }
        b bVar = (b) obj;
        return Objects.equals(bVar.f848a, this.f848a) && Objects.equals(bVar.f849b, this.f849b);
    }

    public final int hashCode() {
        Object obj = this.f848a;
        int iHashCode = obj == null ? 0 : obj.hashCode();
        Object obj2 = this.f849b;
        return iHashCode ^ (obj2 != null ? obj2.hashCode() : 0);
    }

    public final String toString() {
        return "Pair{" + this.f848a + AwarenessDataItem.PERMISSION_SPLITTER + this.f849b + "}";
    }
}
