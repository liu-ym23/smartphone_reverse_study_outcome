package aa;

import org.slf4j.event.Level;

/* renamed from: aa.b, reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public interface InterfaceC0315b {
    void a(String str, Object obj, Object obj2);

    void b(Integer num, String str, Object obj);

    void c(String str, Object obj, Object obj2);

    default boolean d(Level level) {
        int i = level.f5513a;
        if (i == 0) {
            return isTraceEnabled();
        }
        if (i == 10) {
            return isDebugEnabled();
        }
        if (i == 20) {
            return isInfoEnabled();
        }
        if (i == 30) {
            return isWarnEnabled();
        }
        if (i == 40) {
            return isErrorEnabled();
        }
        throw new IllegalArgumentException("Level [" + level + "] not recognized.");
    }

    void debug(String str);

    void debug(String str, Throwable th);

    void debug(String str, Object... objArr);

    void e(Object obj, String str);

    void error(String str);

    void error(String str, Throwable th);

    void error(String str, Object... objArr);

    void f(Object obj, String str);

    void g(Object obj, String str);

    String getName();

    void h(Object obj, String str);

    void i(String str, Object obj, Object obj2);

    void info(String str);

    void info(String str, Throwable th);

    void info(String str, Object... objArr);

    boolean isDebugEnabled();

    boolean isErrorEnabled();

    boolean isInfoEnabled();

    boolean isTraceEnabled();

    boolean isWarnEnabled();

    void j(Object obj, String str);

    void trace(String str);

    void trace(String str, Throwable th);

    void trace(String str, Object... objArr);

    void warn(String str);

    void warn(String str, Throwable th);

    void warn(String str, Object... objArr);
}
