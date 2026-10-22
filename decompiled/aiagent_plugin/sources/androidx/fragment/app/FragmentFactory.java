package androidx.fragment.app;

import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: loaded from: classes.dex */
public class FragmentFactory {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final androidx.b.g<ClassLoader, androidx.b.g<String, Class<?>>> f1730a = null;

    public FragmentFactory() {
    }

    static {
        f1730a = new androidx.b.g();
    }

    private static Class<?> d(ClassLoader r4, String r5) {
        androidx.b.g<ClassLoader, androidx.b.g<String, Class<?>>> r0 = f1730a;
        androidx.b.g<String, Class<?>> r1 = (androidx.b.g) ZeusTransformUtils.preCheckCast(r0.get(r4), androidx.b.g.class, "com.obric.aiagent.plugin");
        if (r1 != null) goto L5;
        r1 = new androidx.b.g();
        r0.put(r4, r1);
    L5:
        Class<?> r2 = (Class) ZeusTransformUtils.preCheckCast(r1.get(r5), Class.class, "com.obric.aiagent.plugin");
        if (r2 != null) goto L9;
        Class<?> r3 = Class.forName(r5, false, r4);
        r1.put(r5, r3);
        return r3;
    L9:
        return r2;
    }

    static boolean a(ClassLoader r0, String r1) {
        return Fragment.class.isAssignableFrom(d(r0, r1));
    L4:
        return false;
    }

    public static Class<? extends Fragment> b(ClassLoader r3, String r4) {
        return d(r3, r4);
    L5:
        e = move-exception;
        throw new Fragment.b("Unable to instantiate fragment " + r4 + ": make sure class is a valid subclass of Fragment", e);
    L8:
        e = move-exception;
        throw new Fragment.b("Unable to instantiate fragment " + r4 + ": make sure class name exists", e);
    }

    public Fragment c(ClassLoader r4, String r5) {
        return (Fragment) ZeusTransformUtils.preCheckCast(b(r4, r5).getConstructor(new Class[0]).newInstance(new Object[0]), Fragment.class, "com.obric.aiagent.plugin");
    L11:
        e = move-exception;
        throw new Fragment.b("Unable to instantiate fragment " + r5 + ": make sure class name exists, is public, and has an empty constructor that is public", e);
    L14:
        e = move-exception;
        throw new Fragment.b("Unable to instantiate fragment " + r5 + ": make sure class name exists, is public, and has an empty constructor that is public", e);
    L8:
        e = move-exception;
        throw new Fragment.b("Unable to instantiate fragment " + r5 + ": could not find Fragment constructor", e);
    L5:
        e = move-exception;
        throw new Fragment.b("Unable to instantiate fragment " + r5 + ": calling Fragment constructor caused an exception", e);
    }
}
