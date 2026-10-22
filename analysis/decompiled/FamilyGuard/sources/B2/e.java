package B2;

import android.app.Application;
import android.content.Context;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.Set;

/* loaded from: classes.dex */
public class e {

    /* renamed from: a, reason: collision with root package name */
    private static final boolean f205a = R1.a.f("FamilyGuardUsage", R1.a.f4965a);

    /* renamed from: b, reason: collision with root package name */
    private static boolean f206b = false;

    /* renamed from: c, reason: collision with root package name */
    private static Q2.c f207c;

    public static /* synthetic */ Object a(Context context, int i5) {
        if (i5 != 2) {
            return null;
        }
        return N2.b.a(context);
    }

    private static String b(Map<String, String> map) {
        if (!f206b) {
            return null;
        }
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        if (map != null) {
            Set<Map.Entry<String, String>> setEntrySet = map.entrySet();
            if (!setEntrySet.isEmpty()) {
                for (Map.Entry<String, String> entry : setEntrySet) {
                    sb.append(entry.getKey());
                    sb.append(":");
                    sb.append(entry.getValue());
                    sb.append(",");
                }
            }
        }
        sb.append("]");
        return sb.toString();
    }

    public static void c() {
        if (f206b) {
            return;
        }
        R1.a.e("FamilyGuardUsage", "init");
        final Application applicationA = P1.a.a();
        O2.b.r(new O2.a() { // from class: B2.d
            @Override // O2.a
            public final Object a(int i5) {
                return e.a(applicationA, i5);
            }
        });
        Q2.a aVar = new Q2.a();
        aVar.a(true);
        aVar.b(f205a);
        Q2.c.b(applicationA, Q2.b.APP, aVar, "20013637", "1");
        f207c = Q2.c.a();
        f206b = true;
    }

    private static void d(String str, String str2, Map<String, String> map) {
        if (f206b) {
            Objects.requireNonNull(f207c);
            Objects.requireNonNull(str);
            if (f205a) {
                R1.a.k("FamilyGuardUsage", "[onEvent] eventName=" + str + ", properties=" + b(map));
            }
            f207c.d(str, str2, map);
        }
    }

    static void e(String str, String[] strArr, Object... objArr) {
        if (f206b) {
            HashMap map = new HashMap();
            if (strArr != null && strArr.length > 0) {
                if (objArr == null || objArr.length == 0) {
                    throw new IllegalArgumentException("params is not empty but values is empty");
                }
                if (strArr.length > objArr.length) {
                    throw new IllegalArgumentException("params's length is great than values's length");
                }
                for (int i5 = 0; i5 < strArr.length; i5++) {
                    map.put(strArr[i5], String.valueOf(objArr[i5]));
                }
            }
            d(str, P1.a.a().getPackageName(), map);
        }
    }
}
