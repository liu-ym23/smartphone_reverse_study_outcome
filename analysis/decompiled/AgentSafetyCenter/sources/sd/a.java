package sd;

import java.io.Serializable;
import java.util.concurrent.LinkedBlockingQueue;
import td.e;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final class a implements rd.b, Serializable {

    /* renamed from: c, reason: collision with root package name */
    public String f12192c;

    /* renamed from: f, reason: collision with root package name */
    public e f12193f;

    /* renamed from: g, reason: collision with root package name */
    public LinkedBlockingQueue f12194g;

    @Override // rd.b
    public final void a(String str, Object obj, Object obj2) {
        i(4, obj, obj2, str);
    }

    @Override // rd.b
    public final void b(Object obj, String str) {
        k(new Object[]{obj}, 2);
    }

    @Override // rd.b
    public final void c(String str, Object obj, Object obj2) {
        i(2, obj, obj2, str);
    }

    @Override // rd.b
    public final void d(Object obj) {
        k(new Object[]{obj}, 3);
    }

    @Override // rd.b
    public final void debug(String str) {
        k(null, 4);
    }

    @Override // rd.b
    public final void e(String str, Object obj, Object obj2) {
        i(1, obj, obj2, str);
    }

    @Override // rd.b
    public final void error(String str) {
        k(null, 1);
    }

    @Override // rd.b
    public final void f(Object obj, String str) {
        k(new Object[]{obj}, 1);
    }

    @Override // rd.b
    public final String getName() {
        return this.f12192c;
    }

    @Override // rd.b
    public final void h(Object obj, String str) {
        k(new Object[]{obj}, 4);
    }

    public final void i(int i, Object obj, Object obj2, String str) {
        if (obj2 instanceof Throwable) {
            k(new Object[]{obj}, i);
        } else {
            k(new Object[]{obj, obj2}, i);
        }
    }

    @Override // rd.b
    public final void info(String str) {
        k(null, 3);
    }

    @Override // rd.b
    public final boolean isDebugEnabled() {
        return true;
    }

    @Override // rd.b
    public final boolean isErrorEnabled() {
        return true;
    }

    @Override // rd.b
    public final boolean isInfoEnabled() {
        return true;
    }

    @Override // rd.b
    public final boolean isTraceEnabled() {
        return true;
    }

    @Override // rd.b
    public final boolean isWarnEnabled() {
        return true;
    }

    /* JADX WARN: Removed duplicated region for block: B:9:0x0012  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void j(int r3, java.lang.String r4, java.lang.Object[] r5) {
        /*
            r2 = this;
            if (r5 == 0) goto L12
            int r4 = r5.length
            if (r4 != 0) goto L6
            goto L12
        L6:
            int r4 = r5.length
            int r4 = r4 + (-1)
            r4 = r5[r4]
            boolean r0 = r4 instanceof java.lang.Throwable
            if (r0 == 0) goto L12
            java.lang.Throwable r4 = (java.lang.Throwable) r4
            goto L13
        L12:
            r4 = 0
        L13:
            if (r4 == 0) goto L2f
            if (r5 == 0) goto L29
            int r4 = r5.length
            if (r4 == 0) goto L29
            int r4 = r5.length
            int r4 = r4 + (-1)
            java.lang.Object[] r0 = new java.lang.Object[r4]
            if (r4 <= 0) goto L25
            r1 = 0
            java.lang.System.arraycopy(r5, r1, r0, r1, r4)
        L25:
            r2.k(r0, r3)
            return
        L29:
            java.lang.String r2 = "non-sensical empty or null argument array"
            od.f.e(r2)
            return
        L2f:
            r2.k(r5, r3)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: sd.a.j(int, java.lang.String, java.lang.Object[]):void");
    }

    public final void k(Object[] objArr, int i) {
        b bVar = new b();
        System.currentTimeMillis();
        bVar.f12195a = i;
        bVar.f12196b = this.f12193f;
        Thread.currentThread().getName();
        bVar.f12197c = objArr;
        this.f12194g.add(bVar);
    }

    @Override // rd.b
    public final void trace(String str) {
        k(null, 5);
    }

    @Override // rd.b
    public final void warn(String str) {
        k(null, 2);
    }

    @Override // rd.b
    public final void debug(String str, Object... objArr) {
        j(4, str, objArr);
    }

    @Override // rd.b
    public final void error(String str, Object... objArr) {
        j(1, str, objArr);
    }

    @Override // rd.b
    public final void info(String str, Object... objArr) {
        j(3, str, objArr);
    }

    @Override // rd.b
    public final void trace(String str, Object... objArr) {
        j(5, str, objArr);
    }

    @Override // rd.b
    public final void warn(String str, Object... objArr) {
        j(2, str, objArr);
    }

    @Override // rd.b
    public final void debug(String str, Throwable th) {
        k(null, 4);
    }

    @Override // rd.b
    public final void error(String str, Throwable th) {
        k(null, 1);
    }

    @Override // rd.b
    public final void info(String str, Throwable th) {
        k(null, 3);
    }

    @Override // rd.b
    public final void trace(String str, Throwable th) {
        k(null, 5);
    }

    @Override // rd.b
    public final void warn(String str, Throwable th) {
        k(null, 2);
    }
}
