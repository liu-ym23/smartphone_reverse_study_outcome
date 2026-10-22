package g9;

import android.content.Context;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final class s {
    /* JADX WARN: Removed duplicated region for block: B:25:0x0078  */
    /* JADX WARN: Removed duplicated region for block: B:35:0x00a6  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x00bf  */
    /* JADX WARN: Removed duplicated region for block: B:38:0x00c6  */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0015  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:32:0x0093 -> B:33:0x0099). Please report as a decompilation issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final java.lang.Object a(xb.a r18, long r19, long r21, pb.c r23) {
        /*
            Method dump skipped, instructions count: 201
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: g9.s.a(xb.a, long, long, pb.c):java.lang.Object");
    }

    public p0 b(Context context) {
        p0 p0Var;
        context.getClass();
        Context applicationContext = context.getApplicationContext();
        p0 p0Var2 = p0.i;
        if (p0Var2 != null) {
            return p0Var2;
        }
        synchronized (this) {
            p0Var = p0.i;
            if (p0Var == null) {
                applicationContext.getClass();
                p0Var = new p0(applicationContext);
                p0.i = p0Var;
            }
        }
        return p0Var;
    }
}
