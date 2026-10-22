package z2;

import java.util.Map;
import java.util.Set;

/* renamed from: z2.q, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public abstract class AbstractC6235q implements InterfaceC6066J {

    /* renamed from: a, reason: collision with root package name */
    public transient Set f45092a;

    /* renamed from: b, reason: collision with root package name */
    public transient Map f45093b;

    public abstract Map c();

    public abstract Set d();

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof InterfaceC6066J) {
            return zzv().equals(((InterfaceC6066J) obj).zzv());
        }
        return false;
    }

    public final int hashCode() {
        return zzv().hashCode();
    }

    public final String toString() {
        return zzv().toString();
    }

    @Override // z2.InterfaceC6066J
    public final Map zzv() {
        Map map = this.f45093b;
        if (map != null) {
            return map;
        }
        Map mapC = c();
        this.f45093b = mapC;
        return mapC;
    }

    @Override // z2.InterfaceC6066J
    public final Set zzw() {
        Set set = this.f45092a;
        if (set != null) {
            return set;
        }
        Set setD = d();
        this.f45092a = setD;
        return setD;
    }
}
