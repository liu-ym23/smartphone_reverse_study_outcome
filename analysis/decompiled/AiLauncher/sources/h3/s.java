package h3;

import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import n3.InterfaceC4938b;

/* loaded from: classes2.dex */
public class s<T> implements InterfaceC4938b<Set<T>> {

    /* renamed from: b, reason: collision with root package name */
    public volatile Set<T> f32944b = null;

    /* renamed from: a, reason: collision with root package name */
    public volatile Set<InterfaceC4938b<T>> f32943a = Collections.newSetFromMap(new ConcurrentHashMap());

    public s(Collection<InterfaceC4938b<T>> collection) {
        this.f32943a.addAll(collection);
    }

    public static s<?> b(Collection<InterfaceC4938b<?>> collection) {
        return new s<>((Set) collection);
    }

    public synchronized void a(InterfaceC4938b<T> interfaceC4938b) {
        try {
            if (this.f32944b == null) {
                this.f32943a.add(interfaceC4938b);
            } else {
                this.f32944b.add(interfaceC4938b.get());
            }
        } catch (Throwable th) {
            throw th;
        }
    }

    @Override // n3.InterfaceC4938b
    /* renamed from: c, reason: merged with bridge method [inline-methods] */
    public Set<T> get() {
        if (this.f32944b == null) {
            synchronized (this) {
                try {
                    if (this.f32944b == null) {
                        this.f32944b = Collections.newSetFromMap(new ConcurrentHashMap());
                        d();
                    }
                } finally {
                }
            }
        }
        return Collections.unmodifiableSet(this.f32944b);
    }

    public final synchronized void d() {
        try {
            Iterator<InterfaceC4938b<T>> it = this.f32943a.iterator();
            while (it.hasNext()) {
                this.f32944b.add(it.next().get());
            }
            this.f32943a = null;
        } catch (Throwable th) {
            throw th;
        }
    }
}
