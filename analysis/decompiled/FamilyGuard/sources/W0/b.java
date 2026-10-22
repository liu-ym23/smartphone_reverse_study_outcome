package W0;

import X0.j;
import java.security.MessageDigest;
import z0.InterfaceC1340f;

/* loaded from: classes.dex */
public final class b implements InterfaceC1340f {

    /* renamed from: b, reason: collision with root package name */
    private final Object f5719b;

    public b(Object obj) {
        this.f5719b = j.d(obj);
    }

    @Override // z0.InterfaceC1340f
    public void b(MessageDigest messageDigest) {
        messageDigest.update(this.f5719b.toString().getBytes(InterfaceC1340f.f24045a));
    }

    @Override // z0.InterfaceC1340f
    public boolean equals(Object obj) {
        if (obj instanceof b) {
            return this.f5719b.equals(((b) obj).f5719b);
        }
        return false;
    }

    @Override // z0.InterfaceC1340f
    public int hashCode() {
        return this.f5719b.hashCode();
    }

    public String toString() {
        return "ObjectKey{object=" + this.f5719b + '}';
    }
}
