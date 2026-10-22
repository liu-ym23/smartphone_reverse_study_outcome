package D9;

import kotlin.Result;

/* loaded from: classes4.dex */
public abstract class b {

    /* renamed from: a, reason: collision with root package name */
    public static final int f436a;

    static {
        Object objA;
        try {
            String property = System.getProperty("kotlinx.serialization.json.pool.size");
            objA = property != null ? j9.t.f0(property) : null;
        } catch (Throwable th) {
            objA = kotlin.b.a(th);
        }
        Integer num = (Integer) (objA instanceof Result.Failure ? null : objA);
        f436a = num != null ? num.intValue() : 2097152;
    }
}
