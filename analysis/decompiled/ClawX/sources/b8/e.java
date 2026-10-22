package b8;

import java.io.IOException;
import java.lang.reflect.Method;
import java.util.Queue;
import java.util.concurrent.LinkedBlockingQueue;

/* compiled from: r8-map-id-ca86e8b578419e4708a9a7ee3f056b062b20ba338a8b13e201aefe3710dbf238 */
/* loaded from: classes.dex */
public final class e implements z7.b {

    /* renamed from: a, reason: collision with root package name */
    public final String f1003a;

    /* renamed from: b, reason: collision with root package name */
    public volatile z7.b f1004b;

    /* renamed from: c, reason: collision with root package name */
    public Boolean f1005c;
    public Method d;

    /* renamed from: e, reason: collision with root package name */
    public a8.a f1006e;

    /* renamed from: f, reason: collision with root package name */
    public final Queue f1007f;

    /* renamed from: g, reason: collision with root package name */
    public final boolean f1008g;

    public e(String str, LinkedBlockingQueue linkedBlockingQueue, boolean z) {
        this.f1003a = str;
        this.f1007f = linkedBlockingQueue;
        this.f1008g = z;
    }

    @Override // z7.b
    public final void a(String str, Object... objArr) {
        s().a(str, objArr);
    }

    @Override // z7.b
    public final boolean b() {
        return s().b();
    }

    @Override // z7.b
    public final void c(String str, Object obj, Object obj2) {
        s().c(str, obj, obj2);
    }

    @Override // z7.b
    public final boolean d() {
        return s().d();
    }

    @Override // z7.b
    public final void e(Integer num) {
        s().e(num);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return obj != null && e.class == obj.getClass() && this.f1003a.equals(((e) obj).f1003a);
    }

    @Override // z7.b
    public final void f(String str, Object obj, Object obj2) {
        s().f(str, obj, obj2);
    }

    @Override // z7.b
    public final void g(String str, Object... objArr) {
        s().g(str, objArr);
    }

    @Override // z7.b
    public final String getName() {
        return this.f1003a;
    }

    @Override // z7.b
    public final void h(String str) {
        s().h(str);
    }

    public final int hashCode() {
        return this.f1003a.hashCode();
    }

    @Override // z7.b
    public final boolean i() {
        return s().i();
    }

    @Override // z7.b
    public final boolean j(int i8) {
        return s().j(i8);
    }

    @Override // z7.b
    public final void k(Object obj, String str) {
        s().k(obj, str);
    }

    @Override // z7.b
    public final void l(Object obj, String str) {
        s().l(obj, str);
    }

    @Override // z7.b
    public final boolean m() {
        return s().m();
    }

    @Override // z7.b
    public final void n(String str, Exception exc) {
        s().n(str, exc);
    }

    @Override // z7.b
    public final void o(String str) {
        s().o(str);
    }

    @Override // z7.b
    public final boolean p() {
        return s().p();
    }

    @Override // z7.b
    public final void q(IOException iOException) {
        s().q(iOException);
    }

    @Override // z7.b
    public final void r(Object... objArr) {
        s().r(objArr);
    }

    public final z7.b s() {
        if (this.f1004b != null) {
            return this.f1004b;
        }
        if (this.f1008g) {
            return b.f998a;
        }
        if (this.f1006e == null) {
            Queue queue = this.f1007f;
            a8.a aVar = new a8.a();
            aVar.f236b = this;
            aVar.f235a = this.f1003a;
            aVar.f237c = queue;
            this.f1006e = aVar;
        }
        return this.f1006e;
    }

    public final boolean t() {
        Boolean bool = this.f1005c;
        if (bool != null) {
            return bool.booleanValue();
        }
        try {
            this.d = this.f1004b.getClass().getMethod("log", a8.c.class);
            this.f1005c = Boolean.TRUE;
        } catch (NoSuchMethodException unused) {
            this.f1005c = Boolean.FALSE;
        }
        return this.f1005c.booleanValue();
    }
}
