package wc;

import java.util.Objects;

/* loaded from: classes5.dex */
public class b {

    /* renamed from: a, reason: collision with root package name */
    public final String f43264a;

    /* renamed from: b, reason: collision with root package name */
    public final Object f43265b;

    public b(String str, Object obj) {
        this.f43264a = str;
        this.f43265b = obj;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && getClass() == obj.getClass()) {
            b bVar = (b) obj;
            if (Objects.equals(this.f43264a, bVar.f43264a) && Objects.equals(this.f43265b, bVar.f43265b)) {
                return true;
            }
        }
        return false;
    }

    public int hashCode() {
        return Objects.hash(this.f43264a, this.f43265b);
    }

    public String toString() {
        return String.valueOf(this.f43264a) + "=\"" + String.valueOf(this.f43265b) + "\"";
    }
}
