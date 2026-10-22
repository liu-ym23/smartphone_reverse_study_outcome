package x;

import android.content.Context;
import java.lang.reflect.Method;

/* loaded from: classes2.dex */
public final class p implements j {

    /* renamed from: a, reason: collision with root package name */
    public static final Object f6868a;
    public static final Class b;
    public static final Method c;

    static {
        try {
            Class<?> cls = Class.forName("com.android.id.impl.IdProviderImpl");
            b = cls;
            f6868a = cls.newInstance();
            c = cls.getMethod("getOAID", Context.class);
        } catch (Exception e) {
            String str = i.i;
            M.a.f("Api#static reflect exception! ").append(e.getMessage());
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x001b  */
    @Override // x.j
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final D9.n c(android.content.Context r4) throws java.lang.IllegalAccessException, java.lang.IllegalArgumentException, java.lang.reflect.InvocationTargetException {
        /*
            r3 = this;
            r3 = 0
            D9.n r0 = new D9.n     // Catch: java.lang.Exception -> L1f
            r0.<init>()     // Catch: java.lang.Exception -> L1f
            java.lang.reflect.Method r1 = x.p.c     // Catch: java.lang.Exception -> L1f
            java.lang.Object r2 = x.p.f6868a     // Catch: java.lang.Exception -> L1f
            if (r2 == 0) goto L1b
            if (r1 == 0) goto L1b
            java.lang.Object[] r4 = new java.lang.Object[]{r4}     // Catch: java.lang.Exception -> L1b
            java.lang.Object r4 = r1.invoke(r2, r4)     // Catch: java.lang.Exception -> L1b
            if (r4 == 0) goto L1b
            java.lang.String r4 = (java.lang.String) r4     // Catch: java.lang.Exception -> L1b
            goto L1c
        L1b:
            r4 = r3
        L1c:
            r0.f443a = r4     // Catch: java.lang.Exception -> L1f
            return r0
        L1f:
            r4 = move-exception
            r4.printStackTrace()
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: x.p.c(android.content.Context):D9.n");
    }

    @Override // x.j
    public final boolean g(Context context) {
        return (b == null || f6868a == null || c == null) ? false : true;
    }
}
