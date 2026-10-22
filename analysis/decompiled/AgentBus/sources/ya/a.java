package ya;

import c7.l;
import ga.r;
import w7.e0;

/* loaded from: classes.dex */
public abstract class a {

    /* renamed from: a, reason: collision with root package name */
    public static final int f11730a;

    static {
        Object objN;
        try {
            String property = System.getProperty("kotlinx.serialization.json.pool.size");
            objN = property != null ? r.i0(property) : null;
        } catch (Throwable th) {
            objN = e0.n(th);
        }
        Integer num = (Integer) (objN instanceof l ? null : objN);
        f11730a = num != null ? num.intValue() : 2097152;
    }
}
