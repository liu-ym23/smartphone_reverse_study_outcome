package eb;

import com.stepos.account.oauth.OAuthConstants;
import java.lang.ref.Reference;
import java.util.ArrayList;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.TimeUnit;

/* loaded from: classes.dex */
public final class n {

    /* renamed from: a, reason: collision with root package name */
    public final long f3312a;

    /* renamed from: b, reason: collision with root package name */
    public final db.c f3313b;

    /* renamed from: c, reason: collision with root package name */
    public final db.b f3314c;

    /* renamed from: d, reason: collision with root package name */
    public final ConcurrentLinkedQueue f3315d;

    public n(db.e eVar) {
        TimeUnit timeUnit = TimeUnit.MINUTES;
        q7.k.e(eVar, "taskRunner");
        q7.k.e(timeUnit, "timeUnit");
        this.f3312a = timeUnit.toNanos(5L);
        this.f3313b = eVar.e();
        this.f3314c = new db.b(this, a1.a.m(new StringBuilder(), bb.b.f1665g, " ConnectionPool"));
        this.f3315d = new ConcurrentLinkedQueue();
    }

    /* JADX WARN: Removed duplicated region for block: B:29:0x002c A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:31:0x0031 A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final boolean a(ab.a r5, eb.i r6, java.util.ArrayList r7, boolean r8) {
        /*
            r4 = this;
            java.util.concurrent.ConcurrentLinkedQueue r4 = r4.f3315d
            java.util.Iterator r4 = r4.iterator()
        L6:
            boolean r0 = r4.hasNext()
            r1 = 0
            if (r0 == 0) goto L35
            java.lang.Object r0 = r4.next()
            eb.m r0 = (eb.m) r0
            java.lang.String r2 = "connection"
            q7.k.d(r0, r2)
            monitor-enter(r0)
            r2 = 1
            if (r8 == 0) goto L26
            hb.p r3 = r0.f3301g     // Catch: java.lang.Throwable -> L24
            if (r3 == 0) goto L21
            r1 = r2
        L21:
            if (r1 == 0) goto L31
            goto L26
        L24:
            r4 = move-exception
            goto L33
        L26:
            boolean r1 = r0.h(r5, r7)     // Catch: java.lang.Throwable -> L24
            if (r1 == 0) goto L31
            r6.b(r0)     // Catch: java.lang.Throwable -> L24
            monitor-exit(r0)
            return r2
        L31:
            monitor-exit(r0)
            goto L6
        L33:
            monitor-exit(r0)
            throw r4
        L35:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: eb.n.a(ab.a, eb.i, java.util.ArrayList, boolean):boolean");
    }

    public final int b(m mVar, long j2) {
        byte[] bArr = bb.b.f1659a;
        ArrayList arrayList = mVar.f3310p;
        int i2 = 0;
        while (i2 < arrayList.size()) {
            Reference reference = (Reference) arrayList.get(i2);
            if (reference.get() != null) {
                i2++;
            } else {
                String strConcat = "A connection to " + mVar.f3296b.f515a.f493h + " was leaked. Did you forget to close a response body?";
                ib.m mVar2 = ib.m.f5049a;
                ib.m mVar3 = ib.m.f5049a;
                Object obj = ((g) reference).f3270a;
                mVar3.getClass();
                q7.k.e(strConcat, OAuthConstants.FACTOR_RESULT_MESSAGE);
                if (obj == null) {
                    strConcat = strConcat.concat(" To see where this was allocated, set the OkHttpClient logger level to FINE: Logger.getLogger(OkHttpClient.class.getName()).setLevel(Level.FINE);");
                }
                ib.m.g(5, strConcat, (Throwable) obj);
                arrayList.remove(i2);
                mVar.f3304j = true;
                if (arrayList.isEmpty()) {
                    mVar.f3311q = j2 - this.f3312a;
                    return 0;
                }
            }
        }
        return arrayList.size();
    }
}
