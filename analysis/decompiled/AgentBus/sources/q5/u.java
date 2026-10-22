package q5;

import java.util.ArrayList;

/* loaded from: classes.dex */
public final class u extends a0 {

    /* renamed from: a, reason: collision with root package name */
    public final ArrayList f8776a;

    public u(ArrayList arrayList) {
        this.f8776a = arrayList;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof u) && this.f8776a.equals(((u) obj).f8776a);
    }

    public final int hashCode() {
        return this.f8776a.hashCode();
    }

    public final String toString() {
        return "Broadcast(targets=" + this.f8776a + ")";
    }
}
