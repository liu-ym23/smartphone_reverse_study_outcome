package androidx.datastore.preferences.protobuf;

import java.util.Collections;
import java.util.Map;

/* compiled from: r8-map-id-ca86e8b578419e4708a9a7ee3f056b062b20ba338a8b13e201aefe3710dbf238 */
/* loaded from: classes.dex */
public final class n {

    /* renamed from: a, reason: collision with root package name */
    public static volatile n f529a;

    /* renamed from: b, reason: collision with root package name */
    public static final n f530b;

    static {
        n nVar = new n();
        Map map = Collections.EMPTY_MAP;
        f530b = nVar;
    }

    public static n a() {
        n nVar;
        r0 r0Var = r0.f559c;
        n nVar2 = f529a;
        if (nVar2 != null) {
            return nVar2;
        }
        synchronized (n.class) {
            try {
                nVar = f529a;
                if (nVar == null) {
                    Class cls = m.f514a;
                    n nVar3 = null;
                    if (cls != null) {
                        try {
                            nVar3 = (n) cls.getDeclaredMethod("getEmptyRegistry", null).invoke(null, null);
                        } catch (Exception unused) {
                        }
                    }
                    nVar = nVar3 != null ? nVar3 : f530b;
                    f529a = nVar;
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return nVar;
    }
}
