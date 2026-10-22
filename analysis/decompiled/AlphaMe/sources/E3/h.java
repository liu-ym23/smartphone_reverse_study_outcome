package E3;

import androidx.room.AbstractC0351g;
import java.util.Iterator;
import java.util.Map;
import java.util.Properties;
import java.util.concurrent.atomic.AtomicReference;

/* loaded from: classes2.dex */
public final class h {

    /* renamed from: f, reason: collision with root package name */
    public static final h f420f = new h();

    /* renamed from: g, reason: collision with root package name */
    public static final f f421g = new f();

    /* renamed from: a, reason: collision with root package name */
    public final AtomicReference f422a = new AtomicReference();

    /* renamed from: b, reason: collision with root package name */
    public final AtomicReference f423b = new AtomicReference();

    /* renamed from: c, reason: collision with root package name */
    public final AtomicReference f424c = new AtomicReference();

    /* renamed from: d, reason: collision with root package name */
    public final AtomicReference f425d = new AtomicReference();

    /* renamed from: e, reason: collision with root package name */
    public final AtomicReference f426e = new AtomicReference();

    public static Object d(Class cls, Properties properties) {
        Properties properties2 = (Properties) properties.clone();
        String simpleName = cls.getSimpleName();
        String property = properties2.getProperty("rxjava.plugin." + simpleName + ".implementation");
        if (property == null) {
            Iterator it = properties2.entrySet().iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                Map.Entry entry = (Map.Entry) it.next();
                String string = entry.getKey().toString();
                if (string.startsWith("rxjava.plugin.") && string.endsWith(".class") && simpleName.equals(entry.getValue().toString())) {
                    String strN = B0.g.n("rxjava.plugin.", string.substring(0, string.length() - 6).substring(14), ".impl");
                    String property2 = properties2.getProperty(strN);
                    if (property2 == null) {
                        throw new IllegalStateException("Implementing class declaration for " + simpleName + " missing: " + strN);
                    }
                    property = property2;
                }
            }
        }
        if (property == null) {
            return null;
        }
        try {
            return Class.forName(property).asSubclass(cls).newInstance();
        } catch (ClassCastException e4) {
            throw new IllegalStateException(simpleName + " implementation is not an instance of " + simpleName + ": " + property, e4);
        } catch (ClassNotFoundException e5) {
            throw new IllegalStateException(AbstractC0351g.q(simpleName, " implementation class not found: ", property), e5);
        } catch (IllegalAccessException e6) {
            throw new IllegalStateException(AbstractC0351g.q(simpleName, " implementation not able to be accessed: ", property), e6);
        } catch (InstantiationException e7) {
            throw new IllegalStateException(AbstractC0351g.q(simpleName, " implementation not able to be instantiated: ", property), e7);
        }
    }

    public final g a() {
        AtomicReference atomicReference = this.f425d;
        if (atomicReference.get() == null) {
            Object objD = d(g.class, System.getProperties());
            if (objD == null) {
                atomicReference.compareAndSet(null, new g());
            } else {
                atomicReference.compareAndSet(null, (g) objD);
            }
        }
        return (g) atomicReference.get();
    }

    public final f b() {
        AtomicReference atomicReference = this.f422a;
        if (atomicReference.get() == null) {
            Object objD = d(f.class, System.getProperties());
            if (objD == null) {
                atomicReference.compareAndSet(null, f421g);
            } else {
                atomicReference.compareAndSet(null, (f) objD);
            }
        }
        return (f) atomicReference.get();
    }

    public final d c() {
        AtomicReference atomicReference = this.f423b;
        if (atomicReference.get() == null) {
            Object objD = d(d.class, System.getProperties());
            if (objD == null) {
                atomicReference.compareAndSet(null, e.f419a);
            } else {
                atomicReference.compareAndSet(null, (d) objD);
            }
        }
        return (d) atomicReference.get();
    }

    public final i e() {
        AtomicReference atomicReference = this.f426e;
        if (atomicReference.get() == null) {
            Object objD = d(i.class, System.getProperties());
            if (objD == null) {
                atomicReference.compareAndSet(null, i.f427a);
            } else {
                atomicReference.compareAndSet(null, (i) objD);
            }
        }
        return (i) atomicReference.get();
    }

    public final j f() {
        AtomicReference atomicReference = this.f424c;
        if (atomicReference.get() == null) {
            Object objD = d(j.class, System.getProperties());
            if (objD == null) {
                atomicReference.compareAndSet(null, k.f428a);
            } else {
                atomicReference.compareAndSet(null, (j) objD);
            }
        }
        return (j) atomicReference.get();
    }
}
