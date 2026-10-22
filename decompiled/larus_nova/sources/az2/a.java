package az2;

import android.view.View;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes12.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Map<String, Map<String, Object>> f16790a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final Map<String, Map<String, Object>> f16791b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final Map<String, f> f16792c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final a f16793d = null;

    public a() {
    }

    static {
        f16793d = new a();
        f16790a = new LinkedHashMap();
        f16791b = new LinkedHashMap();
        f16792c = new LinkedHashMap();
    }

    public static Map a(String r100) {
        Map<String, Map<String, Object>> r101 = f16790a;
        LinkedHashMap r102 = (LinkedHashMap) r101;
        if (r102.get(r100) != null) goto L5;
        r101.put(r100, new LinkedHashMap());
    L5:
        Object r103 = r102.get(r100);
        if (r103 != null) goto L9;
        Intrinsics.throwNpe();
    L9:
        return (Map) r103;
    }

    public static Map b(String r100) {
        Map<String, Map<String, Object>> r101 = f16791b;
        LinkedHashMap r102 = (LinkedHashMap) r101;
        if (r102.get(r100) != null) goto L5;
        r101.put(r100, new LinkedHashMap());
    L5:
        Object r103 = r102.get(r100);
        if (r103 != null) goto L9;
        Intrinsics.throwNpe();
    L9:
        return (Map) r103;
    }

    public static List c(View r100) {
        ArrayList r101 = new ArrayList();
        Iterator r102 = ((LinkedHashMap) f16792c).entrySet().iterator();
    L4:
        if (r102.hasNext() == false) goto L10;
        Map.Entry r103 = (Map.Entry) r102.next();
        View r104 = ((f) r103.getValue()).f16802a.get();
        if (r104 == null) goto L4;
        if (r104.equals(r100) != true) goto L4;
        r101.add(r103.getKey());
        goto L4
    L10:
        return r101;
    }

    public static py2.a d(View r100) {
        ArrayList r101 = new ArrayList();
        Iterator r102 = ((ArrayList) c(r100)).iterator();
    L4:
        if (r102.hasNext() == false) goto L7;
        r101.add(a((String) r102.next()));
        goto L4
    L7:
        return new py2.a(r101);
    }

    public static py2.b e(View r100) {
        ArrayList r101 = new ArrayList();
        Iterator r102 = ((ArrayList) c(r100)).iterator();
    L4:
        if (r102.hasNext() == false) goto L7;
        r101.add(b((String) r102.next()));
        goto L4
    L7:
        return new py2.b(r101);
    }
}
