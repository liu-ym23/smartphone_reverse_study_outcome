package qb;

import java.security.Permission;
import java.util.HashSet;

/* loaded from: classes.dex */
public final class b extends Permission {

    /* renamed from: f, reason: collision with root package name */
    public final HashSet f8835f;

    public b(String str) {
        super(str);
        HashSet hashSet = new HashSet();
        this.f8835f = hashSet;
        hashSet.add(str);
    }

    public final boolean equals(Object obj) {
        return (obj instanceof b) && this.f8835f.equals(((b) obj).f8835f);
    }

    @Override // java.security.Permission
    public final String getActions() {
        return this.f8835f.toString();
    }

    public final int hashCode() {
        return this.f8835f.hashCode();
    }

    @Override // java.security.Permission
    public final boolean implies(Permission permission) {
        if (!(permission instanceof b)) {
            return false;
        }
        b bVar = (b) permission;
        return getName().equals(bVar.getName()) || this.f8835f.containsAll(bVar.f8835f);
    }
}
