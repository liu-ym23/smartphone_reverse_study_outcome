package androidx.datastore.preferences.protobuf;

import java.lang.invoke.VarHandle;
import java.util.Collections;
import java.util.Map;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final class n {

    /* renamed from: a, reason: collision with root package name */
    public static volatile n f1158a;

    /* renamed from: b, reason: collision with root package name */
    public static final n f1159b;

    static {
        n nVar = new n();
        Map map = Collections.EMPTY_MAP;
        VarHandle.storeStoreFence();
        f1159b = nVar;
    }

    public static n a() {
        n nVar;
        t0 t0Var = t0.f1207c;
        n nVar2 = f1158a;
        if (nVar2 != null) {
            return nVar2;
        }
        synchronized (n.class) {
            try {
                nVar = f1158a;
                if (nVar == null) {
                    Class cls = m.f1155a;
                    n nVar3 = null;
                    if (cls != null) {
                        try {
                            nVar3 = (n) cls.getDeclaredMethod("getEmptyRegistry", null).invoke(null, null);
                        } catch (Exception unused) {
                        }
                    }
                    nVar = nVar3 != null ? nVar3 : f1159b;
                    f1158a = nVar;
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return nVar;
    }
}
