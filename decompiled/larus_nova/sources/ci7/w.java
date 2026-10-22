package ci7;

import java.util.concurrent.ConcurrentHashMap;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
public final class w {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final ConcurrentHashMap<Class<?>, di7.d> f23890a = null;

    static {
        f23890a = new ConcurrentHashMap();
    }

    public static di7.d b(Class r100) {
        if (Intrinsics.areEqual(r100, ei7.a.class) == false) goto L14;
        di7.a r101 = (di7.a) a(di7.a.class, false);
        if (r101 == null) goto L7;
        bi7.d r102 = r101.c();
    L9:
        if ((r102 instanceof di7.d) == true) goto L12;
        return null;
    L12:
        return r102;
    L7:
        r102 = null;
        goto L9
    L14:
        if (Intrinsics.areEqual(r100, ei7.b.class) == false) goto L25;
        di7.b r103 = (di7.b) a(di7.b.class, false);
        if (r103 == null) goto L18;
        ei7.b r104 = r103.j();
    L20:
        if ((r104 instanceof di7.d) == true) goto L23;
        return null;
    L23:
        return r104;
    L18:
        r104 = null;
        goto L20
    L25:
        return null;
    }

    public static di7.d a(Class r100, boolean r101) {
        di7.d r102 = f23890a.get(r100);
        if (r102 == null) goto L5;
        return r102;
    L5:
        if (r101 == false) goto L9;
        mi7.e.b("UgServiceManager", "The implementation of '" + r100.getSimpleName() + "' not found, do you add the right dependency?");
        return null;
    L9:
        return null;
    }
}
