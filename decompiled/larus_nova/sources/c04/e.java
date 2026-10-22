package c04;

import java.util.LinkedHashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes14.dex */
public final class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Map<Integer, Map<Integer, f>> f21917a = null;

    static {
        f21917a = new LinkedHashMap();
    }

    public static f a(int r100, int r101) {
        Map<Integer, Map<Integer, f>> r102 = f21917a;
        LinkedHashMap r103 = (LinkedHashMap) r102;
        if (((Map) r103.get(Integer.valueOf(r100))) != null) goto L5;
        r102.put(Integer.valueOf(r100), new LinkedHashMap());
    L5:
        Map r104 = (Map) r103.get(Integer.valueOf(r100));
        if (r104 == null) goto L8;
        f r105 = (f) r104.get(Integer.valueOf(r101));
    L9:
        if (r105 != null) goto L13;
        r105 = new f();
        Map r106 = (Map) r103.get(Integer.valueOf(r100));
        if (r106 == null) goto L13;
        f r107 = (f) r106.put(Integer.valueOf(r101), r105);
    L13:
        return r105;
    L8:
        r105 = null;
        goto L9
    }
}
