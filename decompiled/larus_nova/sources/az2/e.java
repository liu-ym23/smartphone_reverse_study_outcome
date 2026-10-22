package az2;

import android.view.View;
import java.util.LinkedHashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes12.dex */
public final class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f16800a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final Map<String, c> f16801b = null;

    static {
        f16800a = a.f16793d;
        f16801b = new LinkedHashMap();
    }

    public static void e(String r100) {
        ty2.a.d();
        f16800a.getClass();
        a.f16790a.remove(r100);
        a.f16791b.remove(r100);
    }

    public static void a(String r100, String r101, boolean r102) {
        ty2.a.d();
        d(r100, r101, Boolean.valueOf(r102));
    }

    public static void b(String r100, String r101, long r102) {
        ty2.a.d();
        d(r100, r101, Long.valueOf(r102));
    }

    public static void c(String r100, String r101, String r102) {
        ty2.a.d();
        d(r100, r101, r102);
    }

    public static void d(String r100, String r101, Object r102) {
        int r103 = r101.hashCode();
        if (r103 == (-907987551)) goto L16;
        if (r103 == (-245775970)) goto L13;
        if (r103 == 855478153) goto L10;
    L18:
        boolean r104 = false;
    L19:
        if (r104 == false) goto L21;
        f16800a.getClass();
        a.a(r100).put(r101, r102);
    L22:
        f16800a.getClass();
        f r105 = (f) ((LinkedHashMap) a.f16792c).get(r100);
        if (r105 == null) goto L28;
        Map<String, c> r106 = f16801b;
        LinkedHashMap r107 = (LinkedHashMap) r106;
        c r108 = (c) r107.get(r105.getType());
        if (r108 == null) goto L29;
        View r109 = r105.f16802a.get();
        r108.a();
        return;
    L29:
        return;
    L28:
        return;
    L21:
        f16800a.getClass();
        a.b(r100).put(r101, r102);
        goto L22
    L10:
        if (r101.equals("container_name") == false) goto L18;
    L17:
        r104 = true;
        goto L19
    L13:
        if (r101.equals("template_res_type") == false) goto L18;
    L16:
        if (r101.equals("schema") == false) goto L18;
        goto L17
    }
}
