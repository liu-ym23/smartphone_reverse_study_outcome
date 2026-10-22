package c36;

import java.util.LinkedHashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes19.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Map<String, m16.b> f22277a = null;

    static {
        f22277a = new LinkedHashMap();
    }

    public static m16.b a(String r100) {
        if (r100 == null) goto L8;
        m16.b r101 = (m16.b) ((LinkedHashMap) f22277a).get(r100);
        if (r101 == null) goto L6;
        return r101;
    L6:
        return new m16.b();
    L8:
        return new m16.b();
    }

    public static void c(String r100) {
        if (r100 == null) goto L4;
        f22277a.remove(r100);
    L4:
        f22277a.size();
    }

    public static void b(String r100, m16.b r101) {
        if (r100 == null) goto L6;
        if (r101 != null) goto L5;
        r101 = new m16.b();
    L5:
        f22277a.put(r100, r101);
    L6:
        f22277a.size();
    }
}
