package b8;

import java.lang.ref.WeakReference;

/* loaded from: classes4.dex */
public final class w0 {

    /* renamed from: a, reason: collision with root package name */
    public final WeakReference f2062a;
    public final int b;

    public w0(ClassLoader classLoader) {
        this.f2062a = new WeakReference(classLoader);
        this.b = System.identityHashCode(classLoader);
    }

    public final boolean equals(Object obj) {
        return (obj instanceof w0) && this.f2062a.get() == ((w0) obj).f2062a.get();
    }

    public final int hashCode() {
        return this.b;
    }

    public final String toString() {
        String string;
        ClassLoader classLoader = (ClassLoader) this.f2062a.get();
        return (classLoader == null || (string = classLoader.toString()) == null) ? "<null>" : string;
    }
}
