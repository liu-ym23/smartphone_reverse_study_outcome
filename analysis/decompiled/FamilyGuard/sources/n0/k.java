package n0;

import androidx.exifinterface.media.ExifInterface;
import java.lang.reflect.Modifier;
import java.util.HashMap;
import java.util.Map;
import m0.InterfaceC0856d;
import u0.C1152b;

/* loaded from: classes.dex */
public class k {

    /* renamed from: e, reason: collision with root package name */
    private static String f18908e = C1152b.b(InterfaceC0856d.class);

    /* renamed from: f, reason: collision with root package name */
    private static final Map<String, String> f18909f = new a();

    /* renamed from: a, reason: collision with root package name */
    private final String f18910a;

    /* renamed from: b, reason: collision with root package name */
    private final Class<?>[] f18911b;

    /* renamed from: c, reason: collision with root package name */
    protected g f18912c = null;

    /* renamed from: d, reason: collision with root package name */
    protected boolean f18913d;

    static class a extends HashMap<String, String> {
        a() {
            put("int", "I");
            put("boolean", "Z");
            put("byte", "B");
            put("char", "C");
            put("short", ExifInterface.LATITUDE_SOUTH);
            put("float", "F");
            put("long", "J");
            put("double", "D");
        }
    }

    public k(String str, Class<?>[] clsArr) {
        this.f18910a = str;
        this.f18911b = clsArr;
    }

    private boolean a(j jVar, String str) {
        String strC = jVar.c();
        StringBuilder sb = new StringBuilder();
        while (strC.endsWith("[]")) {
            sb.append('[');
            strC = strC.substring(0, strC.length() - 2);
        }
        if (sb.length() != 0) {
            Map<String, String> map = f18909f;
            if (map.containsKey(strC)) {
                sb.append(map.get(strC));
                strC = sb.toString();
            } else {
                sb.append('L');
                sb.append(strC);
                sb.append(';');
                strC = sb.toString();
            }
        }
        return strC.equals(str);
    }

    public String[] b() {
        g gVar = this.f18912c;
        return (gVar == null || !gVar.f18884e) ? new String[0] : gVar.a().split(",");
    }

    public boolean c() {
        return this.f18913d;
    }

    public void d(String str) {
        if (f18908e.equals(str)) {
            this.f18913d = true;
        }
    }

    protected g e(int i5, String str, String str2) {
        if (this.f18912c != null || !str.equals(this.f18910a)) {
            return null;
        }
        j[] jVarArrA = j.a(str2);
        int i6 = 0;
        for (j jVar : jVarArrA) {
            String strC = jVar.c();
            if (strC.equals("long") || strC.equals("double")) {
                i6++;
            }
        }
        if (jVarArrA.length != this.f18911b.length) {
            return null;
        }
        for (int i7 = 0; i7 < jVarArrA.length; i7++) {
            if (!a(jVarArrA[i7], this.f18911b[i7].getName())) {
                return null;
            }
        }
        g gVar = new g(!Modifier.isStatic(i5) ? 1 : 0, jVarArrA.length + i6);
        this.f18912c = gVar;
        return gVar;
    }
}
