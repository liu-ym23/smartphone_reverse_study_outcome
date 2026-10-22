package ca;

import aa.InterfaceC0315b;
import ba.C0866a;
import java.lang.reflect.Method;
import java.util.Queue;
import java.util.concurrent.LinkedBlockingQueue;
import org.slf4j.event.EventRecordingLogger;
import org.slf4j.event.Level;
import org.slf4j.helpers.NOPLogger;

/* renamed from: ca.c, reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C0894c implements InterfaceC0315b {

    /* renamed from: a, reason: collision with root package name */
    public final String f2107a;
    public volatile InterfaceC0315b b;
    public Boolean c;
    public Method d;
    public EventRecordingLogger e;
    public final Queue f;
    public final boolean g;

    public C0894c(String str, LinkedBlockingQueue linkedBlockingQueue, boolean z10) {
        this.f2107a = str;
        this.f = linkedBlockingQueue;
        this.g = z10;
    }

    @Override // aa.InterfaceC0315b
    public final void a(String str, Object obj, Object obj2) {
        k().a(str, obj, obj2);
    }

    @Override // aa.InterfaceC0315b
    public final void b(Integer num, String str, Object obj) {
        k().b(num, str, obj);
    }

    @Override // aa.InterfaceC0315b
    public final void c(String str, Object obj, Object obj2) {
        k().c(str, obj, obj2);
    }

    @Override // aa.InterfaceC0315b
    public final boolean d(Level level) {
        return k().d(level);
    }

    @Override // aa.InterfaceC0315b
    public final void debug(String str) {
        k().debug(str);
    }

    @Override // aa.InterfaceC0315b
    public final void e(Object obj, String str) {
        k().e(obj, str);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return obj != null && C0894c.class == obj.getClass() && this.f2107a.equals(((C0894c) obj).f2107a);
    }

    @Override // aa.InterfaceC0315b
    public final void error(String str) {
        k().error(str);
    }

    @Override // aa.InterfaceC0315b
    public final void f(Object obj, String str) {
        k().f(obj, str);
    }

    @Override // aa.InterfaceC0315b
    public final void g(Object obj, String str) {
        k().g(obj, str);
    }

    @Override // aa.InterfaceC0315b
    public final String getName() {
        return this.f2107a;
    }

    @Override // aa.InterfaceC0315b
    public final void h(Object obj, String str) {
        k().h(obj, str);
    }

    public final int hashCode() {
        return this.f2107a.hashCode();
    }

    @Override // aa.InterfaceC0315b
    public final void i(String str, Object obj, Object obj2) {
        k().i(str, obj, obj2);
    }

    @Override // aa.InterfaceC0315b
    public final void info(String str) {
        k().info(str);
    }

    @Override // aa.InterfaceC0315b
    public final boolean isDebugEnabled() {
        return k().isDebugEnabled();
    }

    @Override // aa.InterfaceC0315b
    public final boolean isErrorEnabled() {
        return k().isErrorEnabled();
    }

    @Override // aa.InterfaceC0315b
    public final boolean isInfoEnabled() {
        return k().isInfoEnabled();
    }

    @Override // aa.InterfaceC0315b
    public final boolean isTraceEnabled() {
        return k().isTraceEnabled();
    }

    @Override // aa.InterfaceC0315b
    public final boolean isWarnEnabled() {
        return k().isWarnEnabled();
    }

    @Override // aa.InterfaceC0315b
    public final void j(Object obj, String str) {
        k().j(obj, str);
    }

    public final InterfaceC0315b k() {
        if (this.b != null) {
            return this.b;
        }
        if (this.g) {
            return NOPLogger.f5514a;
        }
        if (this.e == null) {
            Queue queue = this.f;
            EventRecordingLogger eventRecordingLogger = new EventRecordingLogger();
            eventRecordingLogger.b = this;
            eventRecordingLogger.f5512a = this.f2107a;
            eventRecordingLogger.c = queue;
            this.e = eventRecordingLogger;
        }
        return this.e;
    }

    public final boolean l() {
        Boolean bool = this.c;
        if (bool != null) {
            return bool.booleanValue();
        }
        try {
            this.d = this.b.getClass().getMethod("log", C0866a.class);
            this.c = Boolean.TRUE;
        } catch (NoSuchMethodException unused) {
            this.c = Boolean.FALSE;
        }
        return this.c.booleanValue();
    }

    @Override // aa.InterfaceC0315b
    public final void trace(String str) {
        k().trace(str);
    }

    @Override // aa.InterfaceC0315b
    public final void warn(String str) {
        k().warn(str);
    }

    @Override // aa.InterfaceC0315b
    public final void debug(String str, Object... objArr) {
        k().debug(str, objArr);
    }

    @Override // aa.InterfaceC0315b
    public final void error(String str, Object... objArr) {
        k().error(str, objArr);
    }

    @Override // aa.InterfaceC0315b
    public final void info(String str, Object... objArr) {
        k().info(str, objArr);
    }

    @Override // aa.InterfaceC0315b
    public final void trace(String str, Object... objArr) {
        k().trace(str, objArr);
    }

    @Override // aa.InterfaceC0315b
    public final void warn(String str, Object... objArr) {
        k().warn(str, objArr);
    }

    @Override // aa.InterfaceC0315b
    public final void debug(String str, Throwable th) {
        k().debug(str, th);
    }

    @Override // aa.InterfaceC0315b
    public final void error(String str, Throwable th) {
        k().error(str, th);
    }

    @Override // aa.InterfaceC0315b
    public final void info(String str, Throwable th) {
        k().info(str, th);
    }

    @Override // aa.InterfaceC0315b
    public final void trace(String str, Throwable th) {
        k().trace(str, th);
    }

    @Override // aa.InterfaceC0315b
    public final void warn(String str, Throwable th) {
        k().warn(str, th);
    }
}
