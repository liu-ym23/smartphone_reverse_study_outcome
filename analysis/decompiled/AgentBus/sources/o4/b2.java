package o4;

import java.util.Collection;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

/* loaded from: classes.dex */
public final class b2 {

    /* renamed from: a, reason: collision with root package name */
    public static final ConcurrentHashMap f7283a = new ConcurrentHashMap();

    public static boolean a(String str) {
        q7.k.e(str, "frameId");
        return f7283a.containsKey(str);
    }

    public static a2 b(String str) {
        q7.k.e(str, "frameId");
        return (a2) f7283a.get(str);
    }

    public static a2 c(String str, String str2) {
        a2 a2Var = new a2(str, str2, (c5.b) null, (String) null, System.currentTimeMillis(), 28);
        if (f7283a.putIfAbsent(str, a2Var) == null) {
            return a2Var;
        }
        return null;
    }

    public static a2 d(String str) {
        q7.k.e(str, "frameId");
        return (a2) f7283a.remove(str);
    }

    public static List e() {
        Collection collectionValues = f7283a.values();
        q7.k.d(collectionValues, "<get-values>(...)");
        return d7.r.m1(collectionValues);
    }
}
