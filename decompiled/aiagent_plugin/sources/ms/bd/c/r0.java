package ms.bd.c;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes4.dex */
public abstract class r0 extends u0.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static r0 f39594a;

    public static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private long f39595a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private String f39596b;

        public a() {
        }

        public final void a(String r3) {
            this.f39596b = r3;
            this.f39595a = System.currentTimeMillis();
        }

        public final void a(String r9, int r10) {
            r0 r0 = r0.a();
            if (r0 != null) goto L5;
            return;
        L5:
            long r1 = System.currentTimeMillis();
            long r3 = this.f39595a;
            r0.a(r1 - r3, r3, this.f39596b, r9, r10);
        }

        public final void b(String r9, int r10) {
            r0 r0 = r0.a();
            if (r0 != null) goto L5;
            return;
        L5:
            long r1 = System.currentTimeMillis();
            long r3 = this.f39595a;
            r0.b(r1 - r3, r3, this.f39596b, r9, r10);
        }
    }

    public r0() {
    }

    public static synchronized r0 a() {
        monitor-enter(r0.class);
        r0 r1 = f39594a;     // Catch: Throwable -> L7
        monitor-exit(r0.class);
        return r1;
    L7:
        th = move-exception;
        throw th;
    }

    public static synchronized void a(u1 r1) {
        monitor-enter(r0.class);
        f39594a = r1;     // Catch: Throwable -> L7
        monitor-exit(r0.class);
        return;
    L7:
        th = move-exception;
        throw th;
    }

    @Override // ms.bd.c.u0.a
    public final Object a(int r7, int r8, long r9, String r11, Object r12) {
        if (r7 != 131073) goto L11;
        if (r11 != null) goto L6;
    L9:
        return null;
    L6:
        if (a(r11) == false) goto L9;
        return (String) ZeusTransformUtils.preCheckCast(com.bytedance.mobsec.matrix.a.a(16777217, 0, 0, "86aa2c", new byte[]{6, 31}), String.class, "com.obric.aiagent.plugin");
    L11:
        if (r7 != 131074) goto L19;
        String[] r10 = (String[]) ZeusTransformUtils.preCheckCast(r12, String[].class, "com.obric.aiagent.plugin");
        if (r11 == null) goto L19;
        if (r10 == null) goto L19;
        if (r10.length == 0) goto L19;
        a(r11, new JSONObject(r10[0]), new JSONObject(r10[1]), new JSONObject(r10[2]));
    L19:
        return null;
    }

    public abstract void a(long r1, long r3, String r5, String r6, int r7);

    public abstract void a(String r1, JSONObject r2, JSONObject r3, JSONObject r4);

    public abstract boolean a(String r1);

    public abstract void b(long r1, long r3, String r5, String r6, int r7);
}
