package z2;

import java.util.AbstractMap;
import java.util.Collection;
import java.util.Set;

/* renamed from: z2.H, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public abstract class AbstractC6064H extends AbstractMap {

    /* renamed from: a, reason: collision with root package name */
    public transient Set f44675a;

    /* renamed from: b, reason: collision with root package name */
    public transient Collection f44676b;

    public abstract Set b();

    @Override // java.util.AbstractMap, java.util.Map
    public final Set entrySet() {
        Set set = this.f44675a;
        if (set != null) {
            return set;
        }
        Set setB = b();
        this.f44675a = setB;
        return setB;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public final Collection values() {
        Collection collection = this.f44676b;
        if (collection != null) {
            return collection;
        }
        C6063G c6063g = new C6063G(this);
        this.f44676b = c6063g;
        return c6063g;
    }
}
