package vc;

import org.slf4j.Marker;
import org.slf4j.event.Level;

/* loaded from: classes5.dex */
public interface c {
    void a(String str, Object obj, Object obj2);

    void b(String str, Object obj, Object obj2);

    void c(String str, Object obj, Object obj2);

    default xc.e d(Level level) {
        return new xc.b(this, level);
    }

    void debug(String str);

    void debug(String str, Throwable th);

    void debug(String str, Object... objArr);

    default xc.e e(Level level) {
        return f(level) ? d(level) : xc.g.b();
    }

    void error(String str);

    void error(String str, Throwable th);

    void error(String str, Object... objArr);

    default boolean f(Level level) {
        int i10 = level.toInt();
        if (i10 == 0) {
            return isTraceEnabled();
        }
        if (i10 == 10) {
            return isDebugEnabled();
        }
        if (i10 == 20) {
            return isInfoEnabled();
        }
        if (i10 == 30) {
            return isWarnEnabled();
        }
        if (i10 == 40) {
            return isErrorEnabled();
        }
        throw new IllegalArgumentException("Level [" + level + "] not recognized.");
    }

    boolean g(Marker marker);

    String getName();

    boolean h(Marker marker);

    void i(String str, Object obj);

    void info(String str);

    void info(String str, Throwable th);

    void info(String str, Object... objArr);

    boolean isDebugEnabled();

    boolean isErrorEnabled();

    boolean isInfoEnabled();

    boolean isTraceEnabled();

    boolean isWarnEnabled();

    void j(String str, Object obj);

    void k(Marker marker, String str, Throwable th);

    void l(Marker marker, String str, Throwable th);

    void m(String str, Object obj);

    void n(Marker marker, String str, Throwable th);

    void q(String str, Object obj, Object obj2);

    void t(String str, Object obj);

    void trace(String str);

    void trace(String str, Throwable th);

    void trace(String str, Object... objArr);

    void u(String str, Object obj);

    boolean v(Marker marker);

    boolean w(Marker marker);

    void warn(String str);

    void warn(String str, Throwable th);

    void warn(String str, Object... objArr);

    void x(Marker marker, String str, Throwable th);

    void y(Marker marker, String str, Throwable th);

    boolean z(Marker marker);
}
