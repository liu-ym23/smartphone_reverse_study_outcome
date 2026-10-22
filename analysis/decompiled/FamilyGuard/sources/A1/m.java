package A1;

import java.util.Map;
import java.util.Set;

/* loaded from: classes.dex */
public final class m extends j {

    /* renamed from: a, reason: collision with root package name */
    private final C1.h<String, j> f65a = new C1.h<>();

    public boolean equals(Object obj) {
        if (obj != this) {
            return (obj instanceof m) && ((m) obj).f65a.equals(this.f65a);
        }
        return true;
    }

    public int hashCode() {
        return this.f65a.hashCode();
    }

    public void o(String str, j jVar) {
        if (jVar == null) {
            jVar = l.f64a;
        }
        this.f65a.put(str, jVar);
    }

    public Set<Map.Entry<String, j>> p() {
        return this.f65a.entrySet();
    }
}
