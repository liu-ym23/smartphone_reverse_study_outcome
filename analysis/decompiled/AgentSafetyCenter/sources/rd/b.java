package rd;

import od.f;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public interface b {
    void a(String str, Object obj, Object obj2);

    void b(Object obj, String str);

    void c(String str, Object obj, Object obj2);

    void d(Object obj);

    void debug(String str);

    void debug(String str, Throwable th);

    void debug(String str, Object... objArr);

    void e(String str, Object obj, Object obj2);

    void error(String str);

    void error(String str, Throwable th);

    void error(String str, Object... objArr);

    void f(Object obj, String str);

    default boolean g(int i) {
        char c9;
        if (i == 1) {
            c9 = '(';
        } else if (i == 2) {
            c9 = 30;
        } else if (i == 3) {
            c9 = 20;
        } else if (i == 4) {
            c9 = '\n';
        } else {
            if (i != 5) {
                throw null;
            }
            c9 = 0;
        }
        if (c9 == 0) {
            return isTraceEnabled();
        }
        if (c9 == '\n') {
            return isDebugEnabled();
        }
        if (c9 == 20) {
            return isInfoEnabled();
        }
        if (c9 == 30) {
            return isWarnEnabled();
        }
        if (c9 == '(') {
            return isErrorEnabled();
        }
        f.m("Level [", i != 1 ? i != 2 ? i != 3 ? i != 4 ? i != 5 ? "null" : "TRACE" : "DEBUG" : "INFO" : "WARN" : "ERROR", "] not recognized.");
        return false;
    }

    String getName();

    void h(Object obj, String str);

    void info(String str);

    void info(String str, Throwable th);

    void info(String str, Object... objArr);

    boolean isDebugEnabled();

    boolean isErrorEnabled();

    boolean isInfoEnabled();

    boolean isTraceEnabled();

    boolean isWarnEnabled();

    void trace(String str);

    void trace(String str, Throwable th);

    void trace(String str, Object... objArr);

    void warn(String str);

    void warn(String str, Throwable th);

    void warn(String str, Object... objArr);
}
