package h3;

import com.google.firebase.components.DependencyException;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;
import m3.InterfaceC4896c;
import n3.InterfaceC4938b;

/* loaded from: classes2.dex */
public final class x extends AbstractC4125a {

    /* renamed from: a, reason: collision with root package name */
    public final Set<Class<?>> f32951a;

    /* renamed from: b, reason: collision with root package name */
    public final Set<Class<?>> f32952b;

    /* renamed from: c, reason: collision with root package name */
    public final Set<Class<?>> f32953c;

    /* renamed from: d, reason: collision with root package name */
    public final Set<Class<?>> f32954d;

    /* renamed from: e, reason: collision with root package name */
    public final Set<Class<?>> f32955e;

    /* renamed from: f, reason: collision with root package name */
    public final Set<Class<?>> f32956f;

    /* renamed from: g, reason: collision with root package name */
    public final InterfaceC4128d f32957g;

    public static class a implements InterfaceC4896c {

        /* renamed from: a, reason: collision with root package name */
        public final Set<Class<?>> f32958a;

        /* renamed from: b, reason: collision with root package name */
        public final InterfaceC4896c f32959b;

        public a(Set<Class<?>> set, InterfaceC4896c interfaceC4896c) {
            this.f32958a = set;
            this.f32959b = interfaceC4896c;
        }
    }

    public x(C4127c<?> c4127c, InterfaceC4128d interfaceC4128d) {
        HashSet hashSet = new HashSet();
        HashSet hashSet2 = new HashSet();
        HashSet hashSet3 = new HashSet();
        HashSet hashSet4 = new HashSet();
        HashSet hashSet5 = new HashSet();
        for (C4139o c4139o : c4127c.c()) {
            if (c4139o.d()) {
                if (c4139o.f()) {
                    hashSet4.add(c4139o.b());
                } else {
                    hashSet.add(c4139o.b());
                }
            } else if (c4139o.c()) {
                hashSet3.add(c4139o.b());
            } else if (c4139o.f()) {
                hashSet5.add(c4139o.b());
            } else {
                hashSet2.add(c4139o.b());
            }
        }
        if (!c4127c.f().isEmpty()) {
            hashSet.add(InterfaceC4896c.class);
        }
        this.f32951a = Collections.unmodifiableSet(hashSet);
        this.f32952b = Collections.unmodifiableSet(hashSet2);
        this.f32953c = Collections.unmodifiableSet(hashSet3);
        this.f32954d = Collections.unmodifiableSet(hashSet4);
        this.f32955e = Collections.unmodifiableSet(hashSet5);
        this.f32956f = c4127c.f();
        this.f32957g = interfaceC4128d;
    }

    @Override // h3.InterfaceC4128d
    public <T> InterfaceC4938b<Set<T>> a(Class<T> cls) {
        if (this.f32955e.contains(cls)) {
            return this.f32957g.a(cls);
        }
        throw new DependencyException(String.format("Attempting to request an undeclared dependency Provider<Set<%s>>.", cls));
    }

    @Override // h3.AbstractC4125a, h3.InterfaceC4128d
    public <T> Set<T> b(Class<T> cls) {
        if (this.f32954d.contains(cls)) {
            return this.f32957g.b(cls);
        }
        throw new DependencyException(String.format("Attempting to request an undeclared dependency Set<%s>.", cls));
    }

    @Override // h3.InterfaceC4128d
    public <T> InterfaceC4938b<T> c(Class<T> cls) {
        if (this.f32952b.contains(cls)) {
            return this.f32957g.c(cls);
        }
        throw new DependencyException(String.format("Attempting to request an undeclared dependency Provider<%s>.", cls));
    }

    @Override // h3.AbstractC4125a, h3.InterfaceC4128d
    public <T> T get(Class<T> cls) {
        if (!this.f32951a.contains(cls)) {
            throw new DependencyException(String.format("Attempting to request an undeclared dependency %s.", cls));
        }
        T t10 = (T) this.f32957g.get(cls);
        return !cls.equals(InterfaceC4896c.class) ? t10 : (T) new a(this.f32956f, (InterfaceC4896c) t10);
    }
}
