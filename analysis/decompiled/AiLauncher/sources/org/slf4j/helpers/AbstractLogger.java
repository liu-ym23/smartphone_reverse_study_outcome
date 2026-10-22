package org.slf4j.helpers;

import java.io.ObjectStreamException;
import java.io.Serializable;
import org.slf4j.Marker;
import org.slf4j.event.Level;

/* loaded from: classes5.dex */
public abstract class AbstractLogger implements vc.c, Serializable {

    /* renamed from: a, reason: collision with root package name */
    public String f37930a;

    public final void A(Level level, Marker marker, String str, Object obj, Object obj2) {
        if (obj2 instanceof Throwable) {
            D(level, marker, str, new Object[]{obj}, (Throwable) obj2);
        } else {
            D(level, marker, str, new Object[]{obj, obj2}, null);
        }
    }

    public final void C(Level level, Marker marker, String str, Object[] objArr) {
        Throwable thA = c.a(objArr);
        if (thA != null) {
            D(level, marker, str, c.b(objArr), thA);
        } else {
            D(level, marker, str, objArr, null);
        }
    }

    public abstract void D(Level level, Marker marker, String str, Object[] objArr, Throwable th);

    public final void E(Level level, Marker marker, String str, Throwable th) {
        D(level, marker, str, null, th);
    }

    public final void F(Level level, Marker marker, String str, Object obj) {
        D(level, marker, str, new Object[]{obj}, null);
    }

    @Override // vc.c
    public void a(String str, Object obj, Object obj2) {
        if (isDebugEnabled()) {
            A(Level.DEBUG, null, str, obj, obj2);
        }
    }

    @Override // vc.c
    public void b(String str, Object obj, Object obj2) {
        if (isTraceEnabled()) {
            A(Level.TRACE, null, str, obj, obj2);
        }
    }

    @Override // vc.c
    public void c(String str, Object obj, Object obj2) {
        if (isWarnEnabled()) {
            A(Level.WARN, null, str, obj, obj2);
        }
    }

    @Override // vc.c
    public void debug(String str) {
        if (isDebugEnabled()) {
            E(Level.DEBUG, null, str, null);
        }
    }

    @Override // vc.c
    public void error(String str) {
        if (isErrorEnabled()) {
            E(Level.ERROR, null, str, null);
        }
    }

    @Override // vc.c
    public String getName() {
        return this.f37930a;
    }

    @Override // vc.c
    public void i(String str, Object obj) {
        if (isInfoEnabled()) {
            F(Level.INFO, null, str, obj);
        }
    }

    @Override // vc.c
    public void info(String str) {
        if (isInfoEnabled()) {
            E(Level.INFO, null, str, null);
        }
    }

    @Override // vc.c
    public void j(String str, Object obj) {
        if (isWarnEnabled()) {
            F(Level.WARN, null, str, obj);
        }
    }

    @Override // vc.c
    public void k(Marker marker, String str, Throwable th) {
        if (g(marker)) {
            E(Level.WARN, marker, str, th);
        }
    }

    @Override // vc.c
    public void l(Marker marker, String str, Throwable th) {
        if (z(marker)) {
            E(Level.INFO, marker, str, th);
        }
    }

    @Override // vc.c
    public void m(String str, Object obj) {
        if (isTraceEnabled()) {
            F(Level.TRACE, null, str, obj);
        }
    }

    @Override // vc.c
    public void n(Marker marker, String str, Throwable th) {
        if (v(marker)) {
            E(Level.TRACE, marker, str, th);
        }
    }

    @Override // vc.c
    public void q(String str, Object obj, Object obj2) {
        if (isErrorEnabled()) {
            A(Level.ERROR, null, str, obj, obj2);
        }
    }

    public Object readResolve() throws ObjectStreamException {
        return vc.e.m(getName());
    }

    @Override // vc.c
    public void t(String str, Object obj) {
        if (isDebugEnabled()) {
            F(Level.DEBUG, null, str, obj);
        }
    }

    @Override // vc.c
    public void trace(String str) {
        if (isTraceEnabled()) {
            E(Level.TRACE, null, str, null);
        }
    }

    @Override // vc.c
    public void u(String str, Object obj) {
        if (isErrorEnabled()) {
            F(Level.ERROR, null, str, obj);
        }
    }

    @Override // vc.c
    public void warn(String str) {
        if (isWarnEnabled()) {
            E(Level.WARN, null, str, null);
        }
    }

    @Override // vc.c
    public void x(Marker marker, String str, Throwable th) {
        if (h(marker)) {
            E(Level.DEBUG, marker, str, th);
        }
    }

    @Override // vc.c
    public void y(Marker marker, String str, Throwable th) {
        if (w(marker)) {
            E(Level.ERROR, marker, str, th);
        }
    }

    @Override // vc.c
    public void debug(String str, Object... objArr) {
        if (isDebugEnabled()) {
            C(Level.DEBUG, null, str, objArr);
        }
    }

    @Override // vc.c
    public void error(String str, Object... objArr) {
        if (isErrorEnabled()) {
            C(Level.ERROR, null, str, objArr);
        }
    }

    @Override // vc.c
    public void info(String str, Object... objArr) {
        if (isInfoEnabled()) {
            C(Level.INFO, null, str, objArr);
        }
    }

    @Override // vc.c
    public void trace(String str, Object... objArr) {
        if (isTraceEnabled()) {
            C(Level.TRACE, null, str, objArr);
        }
    }

    @Override // vc.c
    public void warn(String str, Object... objArr) {
        if (isWarnEnabled()) {
            C(Level.WARN, null, str, objArr);
        }
    }

    @Override // vc.c
    public void debug(String str, Throwable th) {
        if (isDebugEnabled()) {
            E(Level.DEBUG, null, str, th);
        }
    }

    @Override // vc.c
    public void error(String str, Throwable th) {
        if (isErrorEnabled()) {
            E(Level.ERROR, null, str, th);
        }
    }

    @Override // vc.c
    public void info(String str, Throwable th) {
        if (isInfoEnabled()) {
            E(Level.INFO, null, str, th);
        }
    }

    @Override // vc.c
    public void trace(String str, Throwable th) {
        if (isTraceEnabled()) {
            E(Level.TRACE, null, str, th);
        }
    }

    @Override // vc.c
    public void warn(String str, Throwable th) {
        if (isWarnEnabled()) {
            E(Level.WARN, null, str, th);
        }
    }
}
