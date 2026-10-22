package androidx.datastore.preferences.protobuf;

import java.util.Collections;
import java.util.Map;

/* loaded from: classes.dex */
public final class r {

    /* renamed from: b, reason: collision with root package name */
    public static volatile r f3532b;

    /* renamed from: c, reason: collision with root package name */
    public static final r f3533c;

    /* renamed from: a, reason: collision with root package name */
    public final Map f3534a = Collections.emptyMap();

    static {
        try {
            Class.forName("androidx.datastore.preferences.protobuf.Extension");
        } catch (ClassNotFoundException unused) {
        }
        f3533c = new r();
    }

    public static r a() {
        r rVar = f3532b;
        if (rVar == null) {
            synchronized (r.class) {
                try {
                    rVar = f3532b;
                    if (rVar == null) {
                        Class cls = AbstractC0270q.f3525a;
                        if (cls != null) {
                            try {
                                rVar = (r) cls.getDeclaredMethod("getEmptyRegistry", new Class[0]).invoke(null, new Object[0]);
                            } catch (Exception unused) {
                            }
                            f3532b = rVar;
                        } else {
                            rVar = f3533c;
                            f3532b = rVar;
                        }
                    }
                } finally {
                }
            }
        }
        return rVar;
    }
}
