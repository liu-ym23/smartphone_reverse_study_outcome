package org.slf4j.helpers;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Queue;
import org.slf4j.Marker;
import org.slf4j.event.EventRecordingLogger;
import org.slf4j.event.Level;

/* loaded from: classes5.dex */
public class h implements vc.c {

    /* renamed from: a, reason: collision with root package name */
    public final String f37946a;

    /* renamed from: b, reason: collision with root package name */
    public volatile vc.c f37947b;

    /* renamed from: c, reason: collision with root package name */
    public Boolean f37948c;

    /* renamed from: d, reason: collision with root package name */
    public Method f37949d;

    /* renamed from: e, reason: collision with root package name */
    public EventRecordingLogger f37950e;

    /* renamed from: f, reason: collision with root package name */
    public final Queue<wc.d> f37951f;

    /* renamed from: g, reason: collision with root package name */
    public final boolean f37952g;

    public h(String str, Queue<wc.d> queue, boolean z10) {
        this.f37946a = str;
        this.f37951f = queue;
        this.f37952g = z10;
    }

    public boolean A() {
        return this.f37947b instanceof NOPLogger;
    }

    public boolean B() {
        return this.f37947b == null;
    }

    public void C(wc.c cVar) {
        if (r()) {
            try {
                this.f37949d.invoke(this.f37947b, cVar);
            } catch (IllegalAccessException | IllegalArgumentException | InvocationTargetException unused) {
            }
        }
    }

    public void D(vc.c cVar) {
        this.f37947b = cVar;
    }

    @Override // vc.c
    public void a(String str, Object obj, Object obj2) {
        o().a(str, obj, obj2);
    }

    @Override // vc.c
    public void b(String str, Object obj, Object obj2) {
        o().b(str, obj, obj2);
    }

    @Override // vc.c
    public void c(String str, Object obj, Object obj2) {
        o().c(str, obj, obj2);
    }

    @Override // vc.c
    public xc.e d(Level level) {
        return o().d(level);
    }

    @Override // vc.c
    public void debug(String str) {
        o().debug(str);
    }

    @Override // vc.c
    public xc.e e(Level level) {
        return o().e(level);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return obj != null && getClass() == obj.getClass() && this.f37946a.equals(((h) obj).f37946a);
    }

    @Override // vc.c
    public void error(String str) {
        o().error(str);
    }

    @Override // vc.c
    public boolean f(Level level) {
        return o().f(level);
    }

    @Override // vc.c
    public boolean g(Marker marker) {
        return o().g(marker);
    }

    @Override // vc.c
    public String getName() {
        return this.f37946a;
    }

    @Override // vc.c
    public boolean h(Marker marker) {
        return o().h(marker);
    }

    public int hashCode() {
        return this.f37946a.hashCode();
    }

    @Override // vc.c
    public void i(String str, Object obj) {
        o().i(str, obj);
    }

    @Override // vc.c
    public void info(String str) {
        o().info(str);
    }

    @Override // vc.c
    public boolean isDebugEnabled() {
        return o().isDebugEnabled();
    }

    @Override // vc.c
    public boolean isErrorEnabled() {
        return o().isErrorEnabled();
    }

    @Override // vc.c
    public boolean isInfoEnabled() {
        return o().isInfoEnabled();
    }

    @Override // vc.c
    public boolean isTraceEnabled() {
        return o().isTraceEnabled();
    }

    @Override // vc.c
    public boolean isWarnEnabled() {
        return o().isWarnEnabled();
    }

    @Override // vc.c
    public void j(String str, Object obj) {
        o().j(str, obj);
    }

    @Override // vc.c
    public void k(Marker marker, String str, Throwable th) {
        o().k(marker, str, th);
    }

    @Override // vc.c
    public void l(Marker marker, String str, Throwable th) {
        o().l(marker, str, th);
    }

    @Override // vc.c
    public void m(String str, Object obj) {
        o().m(str, obj);
    }

    @Override // vc.c
    public void n(Marker marker, String str, Throwable th) {
        o().n(marker, str, th);
    }

    public vc.c o() {
        return this.f37947b != null ? this.f37947b : this.f37952g ? NOPLogger.f37933b : p();
    }

    public final vc.c p() {
        if (this.f37950e == null) {
            this.f37950e = new EventRecordingLogger(this, this.f37951f);
        }
        return this.f37950e;
    }

    @Override // vc.c
    public void q(String str, Object obj, Object obj2) {
        o().q(str, obj, obj2);
    }

    public boolean r() {
        Boolean bool = this.f37948c;
        if (bool != null) {
            return bool.booleanValue();
        }
        try {
            this.f37949d = this.f37947b.getClass().getMethod(com.stepos.statsapp.v3.lib.plugin.events.b.f30786f, wc.c.class);
            this.f37948c = Boolean.TRUE;
        } catch (NoSuchMethodException unused) {
            this.f37948c = Boolean.FALSE;
        }
        return this.f37948c.booleanValue();
    }

    @Override // vc.c
    public void t(String str, Object obj) {
        o().t(str, obj);
    }

    @Override // vc.c
    public void trace(String str) {
        o().trace(str);
    }

    @Override // vc.c
    public void u(String str, Object obj) {
        o().u(str, obj);
    }

    @Override // vc.c
    public boolean v(Marker marker) {
        return o().v(marker);
    }

    @Override // vc.c
    public boolean w(Marker marker) {
        return o().w(marker);
    }

    @Override // vc.c
    public void warn(String str) {
        o().warn(str);
    }

    @Override // vc.c
    public void x(Marker marker, String str, Throwable th) {
        o().x(marker, str, th);
    }

    @Override // vc.c
    public void y(Marker marker, String str, Throwable th) {
        o().y(marker, str, th);
    }

    @Override // vc.c
    public boolean z(Marker marker) {
        return o().z(marker);
    }

    @Override // vc.c
    public void debug(String str, Object... objArr) {
        o().debug(str, objArr);
    }

    @Override // vc.c
    public void error(String str, Object... objArr) {
        o().error(str, objArr);
    }

    @Override // vc.c
    public void info(String str, Object... objArr) {
        o().info(str, objArr);
    }

    @Override // vc.c
    public void trace(String str, Object... objArr) {
        o().trace(str, objArr);
    }

    @Override // vc.c
    public void warn(String str, Object... objArr) {
        o().warn(str, objArr);
    }

    @Override // vc.c
    public void debug(String str, Throwable th) {
        o().debug(str, th);
    }

    @Override // vc.c
    public void error(String str, Throwable th) {
        o().error(str, th);
    }

    @Override // vc.c
    public void info(String str, Throwable th) {
        o().info(str, th);
    }

    @Override // vc.c
    public void trace(String str, Throwable th) {
        o().trace(str, th);
    }

    @Override // vc.c
    public void warn(String str, Throwable th) {
        o().warn(str, th);
    }
}
