package a8;

import b8.e;
import java.io.IOException;
import java.io.Serializable;
import java.util.Queue;

/* compiled from: r8-map-id-ca86e8b578419e4708a9a7ee3f056b062b20ba338a8b13e201aefe3710dbf238 */
/* loaded from: classes.dex */
public final class a implements z7.b, Serializable {

    /* renamed from: a, reason: collision with root package name */
    public String f235a;

    /* renamed from: b, reason: collision with root package name */
    public e f236b;

    /* renamed from: c, reason: collision with root package name */
    public Queue f237c;

    @Override // z7.b
    public final void a(String str, Object... objArr) {
        t(4, str, objArr);
    }

    @Override // z7.b
    public final boolean b() {
        return true;
    }

    @Override // z7.b
    public final void c(String str, Object obj, Object obj2) {
        s(4, str, obj, obj2);
    }

    @Override // z7.b
    public final boolean d() {
        return true;
    }

    @Override // z7.b
    public final void e(Integer num) {
        u(new Object[]{num}, 5);
    }

    @Override // z7.b
    public final void f(String str, Object obj, Object obj2) {
        s(5, str, obj, obj2);
    }

    @Override // z7.b
    public final void g(String str, Object... objArr) {
        t(5, str, objArr);
    }

    @Override // z7.b
    public final String getName() {
        return this.f235a;
    }

    @Override // z7.b
    public final void h(String str) {
        u(null, 5);
    }

    @Override // z7.b
    public final boolean i() {
        return true;
    }

    @Override // z7.b
    public final void k(Object obj, String str) {
        u(new Object[]{obj}, 2);
    }

    @Override // z7.b
    public final void l(Object obj, String str) {
        u(new Object[]{obj}, 4);
    }

    @Override // z7.b
    public final boolean m() {
        return true;
    }

    @Override // z7.b
    public final void n(String str, Exception exc) {
        u(null, 2);
    }

    @Override // z7.b
    public final void o(String str) {
        u(null, 4);
    }

    @Override // z7.b
    public final boolean p() {
        return true;
    }

    @Override // z7.b
    public final void q(IOException iOException) {
        u(null, 1);
    }

    @Override // z7.b
    public final void r(Object... objArr) {
        t(2, "Failed to close channel l={}/r={}", objArr);
    }

    public final void s(int i8, String str, Object obj, Object obj2) {
        if (obj2 instanceof Throwable) {
            u(new Object[]{obj}, i8);
        } else {
            u(new Object[]{obj, obj2}, i8);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:8:0x0010  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void t(int r3, java.lang.String r4, java.lang.Object[] r5) {
        /*
            r2 = this;
            int r4 = r5.length
            if (r4 != 0) goto L4
            goto L10
        L4:
            int r4 = r5.length
            int r4 = r4 + (-1)
            r4 = r5[r4]
            boolean r0 = r4 instanceof java.lang.Throwable
            if (r0 == 0) goto L10
            java.lang.Throwable r4 = (java.lang.Throwable) r4
            goto L11
        L10:
            r4 = 0
        L11:
            if (r4 == 0) goto L2d
            int r4 = r5.length
            if (r4 == 0) goto L25
            int r4 = r5.length
            int r4 = r4 + (-1)
            java.lang.Object[] r0 = new java.lang.Object[r4]
            if (r4 <= 0) goto L21
            r1 = 0
            java.lang.System.arraycopy(r5, r1, r0, r1, r4)
        L21:
            r2.u(r0, r3)
            return
        L25:
            java.lang.IllegalStateException r2 = new java.lang.IllegalStateException
            java.lang.String r3 = "non-sensical empty or null argument array"
            r2.<init>(r3)
            throw r2
        L2d:
            r2.u(r5, r3)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: a8.a.t(int, java.lang.String, java.lang.Object[]):void");
    }

    public final void u(Object[] objArr, int i8) {
        c cVar = new c();
        System.currentTimeMillis();
        cVar.f238a = i8;
        cVar.f239b = this.f236b;
        Thread.currentThread().getName();
        cVar.f240c = objArr;
        this.f237c.add(cVar);
    }
}
