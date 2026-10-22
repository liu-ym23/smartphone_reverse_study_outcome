package androidx.fragment.app;

import androidx.collection.SimpleArrayMap;

/* JADX INFO: loaded from: classes.dex */
public abstract class p {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final SimpleArrayMap f3376a = null;

    static {
        f3376a = new SimpleArrayMap();
    }

    public p() {
    }

    public static boolean b(ClassLoader r10, String r11) {
        return Fragment.class.isAssignableFrom(c(r10, r11));
    L4:
        return false;
    }

    public static Class c(ClassLoader r10, String r11) {
        SimpleArrayMap r12 = f3376a;
        SimpleArrayMap r13 = (SimpleArrayMap) r12.get(r10);
        if (r13 != null) goto L5;
        r13 = new SimpleArrayMap();
        r12.put(r10, r13);
    L5:
        Class r14 = (Class) r13.get(r11);
        if (r14 != null) goto L9;
        Class<?> r15 = Class.forName(r11, false, r10);
        r13.put(r11, r15);
        return r15;
    L9:
        return r14;
    }

    public static Class d(ClassLoader r10, String r11) {
        return c(r10, r11);
    L5:
        e = move-exception;
        throw new Fragment.InstantiationException("Unable to instantiate fragment " + r11 + ": make sure class is a valid subclass of Fragment", e);
    L8:
        e = move-exception;
        throw new Fragment.InstantiationException("Unable to instantiate fragment " + r11 + ": make sure class name exists", e);
    }

    public abstract Fragment a(ClassLoader r10, String r11);
}
