package androidx.datastore.preferences.protobuf;

import java.util.Collections;
import java.util.Map;

/* loaded from: classes.dex */
public final class o {

    /* renamed from: a, reason: collision with root package name */
    public static volatile o f913a;

    /* renamed from: b, reason: collision with root package name */
    public static final o f914b;

    static {
        o oVar = new o();
        Map map = Collections.EMPTY_MAP;
        f914b = oVar;
    }

    public static o a() {
        o oVar;
        o oVar2 = f913a;
        if (oVar2 != null) {
            return oVar2;
        }
        synchronized (o.class) {
            try {
                oVar = f913a;
                if (oVar == null) {
                    Class cls = n.f909a;
                    o oVar3 = null;
                    if (cls != null) {
                        try {
                            oVar3 = (o) cls.getDeclaredMethod("getEmptyRegistry", null).invoke(null, null);
                        } catch (Exception unused) {
                        }
                    }
                    oVar = oVar3 != null ? oVar3 : f914b;
                    f913a = oVar;
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return oVar;
    }
}
