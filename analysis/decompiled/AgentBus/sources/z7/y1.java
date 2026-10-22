package z7;

import java.lang.ref.WeakReference;

/* loaded from: classes.dex */
public final class y1 {

    /* renamed from: a, reason: collision with root package name */
    public final WeakReference f11991a;

    /* renamed from: b, reason: collision with root package name */
    public final int f11992b;

    public y1(ClassLoader classLoader) {
        this.f11991a = new WeakReference(classLoader);
        this.f11992b = System.identityHashCode(classLoader);
    }

    public final boolean equals(Object obj) {
        return (obj instanceof y1) && this.f11991a.get() == ((y1) obj).f11991a.get();
    }

    public final int hashCode() {
        return this.f11992b;
    }

    public final String toString() {
        String string;
        ClassLoader classLoader = (ClassLoader) this.f11991a.get();
        return (classLoader == null || (string = classLoader.toString()) == null) ? "<null>" : string;
    }
}
