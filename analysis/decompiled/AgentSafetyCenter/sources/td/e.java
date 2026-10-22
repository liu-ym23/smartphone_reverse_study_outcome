package td;

import java.lang.reflect.Method;
import java.util.concurrent.LinkedBlockingQueue;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final class e implements rd.b {

    /* renamed from: c, reason: collision with root package name */
    public String f13298c;

    /* renamed from: f, reason: collision with root package name */
    public volatile rd.b f13299f;

    /* renamed from: g, reason: collision with root package name */
    public Boolean f13300g;

    /* renamed from: h, reason: collision with root package name */
    public Method f13301h;
    public sd.a i;

    /* renamed from: j, reason: collision with root package name */
    public LinkedBlockingQueue f13302j;

    /* renamed from: k, reason: collision with root package name */
    public boolean f13303k;

    @Override // rd.b
    public final void a(String str, Object obj, Object obj2) {
        i().a(str, obj, obj2);
    }

    @Override // rd.b
    public final void b(Object obj, String str) {
        i().b(obj, str);
    }

    @Override // rd.b
    public final void c(String str, Object obj, Object obj2) {
        i().c(str, obj, obj2);
    }

    @Override // rd.b
    public final void d(Object obj) {
        i().d(obj);
    }

    @Override // rd.b
    public final void debug(String str) {
        i().debug(str);
    }

    @Override // rd.b
    public final void e(String str, Object obj, Object obj2) {
        i().e(str, obj, obj2);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return obj != null && e.class == obj.getClass() && this.f13298c.equals(((e) obj).f13298c);
    }

    @Override // rd.b
    public final void error(String str) {
        i().error(str);
    }

    @Override // rd.b
    public final void f(Object obj, String str) {
        i().f(obj, str);
    }

    @Override // rd.b
    public final boolean g(int i) {
        return i().g(i);
    }

    @Override // rd.b
    public final String getName() {
        return this.f13298c;
    }

    @Override // rd.b
    public final void h(Object obj, String str) {
        i().h(obj, str);
    }

    public final int hashCode() {
        return this.f13298c.hashCode();
    }

    public final rd.b i() {
        if (this.f13299f != null) {
            return this.f13299f;
        }
        if (this.f13303k) {
            return b.f13293c;
        }
        if (this.i == null) {
            LinkedBlockingQueue linkedBlockingQueue = this.f13302j;
            sd.a aVar = new sd.a();
            aVar.f12193f = this;
            aVar.f12192c = this.f13298c;
            aVar.f12194g = linkedBlockingQueue;
            this.i = aVar;
        }
        return this.i;
    }

    @Override // rd.b
    public final void info(String str) {
        i().info(str);
    }

    @Override // rd.b
    public final boolean isDebugEnabled() {
        return i().isDebugEnabled();
    }

    @Override // rd.b
    public final boolean isErrorEnabled() {
        return i().isErrorEnabled();
    }

    @Override // rd.b
    public final boolean isInfoEnabled() {
        return i().isInfoEnabled();
    }

    @Override // rd.b
    public final boolean isTraceEnabled() {
        return i().isTraceEnabled();
    }

    @Override // rd.b
    public final boolean isWarnEnabled() {
        return i().isWarnEnabled();
    }

    public final boolean j() {
        Boolean bool = this.f13300g;
        if (bool != null) {
            return bool.booleanValue();
        }
        try {
            this.f13301h = this.f13299f.getClass().getMethod("log", sd.b.class);
            this.f13300g = Boolean.TRUE;
        } catch (NoSuchMethodException unused) {
            this.f13300g = Boolean.FALSE;
        }
        return this.f13300g.booleanValue();
    }

    @Override // rd.b
    public final void trace(String str) {
        i().trace(str);
    }

    @Override // rd.b
    public final void warn(String str) {
        i().warn(str);
    }

    @Override // rd.b
    public final void debug(String str, Object... objArr) {
        i().debug(str, objArr);
    }

    @Override // rd.b
    public final void error(String str, Object... objArr) {
        i().error(str, objArr);
    }

    @Override // rd.b
    public final void info(String str, Object... objArr) {
        i().info(str, objArr);
    }

    @Override // rd.b
    public final void trace(String str, Object... objArr) {
        i().trace(str, objArr);
    }

    @Override // rd.b
    public final void warn(String str, Object... objArr) {
        i().warn(str, objArr);
    }

    @Override // rd.b
    public final void debug(String str, Throwable th) {
        i().debug(str, th);
    }

    @Override // rd.b
    public final void error(String str, Throwable th) {
        i().error(str, th);
    }

    @Override // rd.b
    public final void info(String str, Throwable th) {
        i().info(str, th);
    }

    @Override // rd.b
    public final void trace(String str, Throwable th) {
        i().trace(str, th);
    }

    @Override // rd.b
    public final void warn(String str, Throwable th) {
        i().warn(str, th);
    }
}
