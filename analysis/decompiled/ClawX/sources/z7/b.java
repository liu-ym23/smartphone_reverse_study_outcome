package z7;

import java.io.IOException;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;

/* compiled from: r8-map-id-ca86e8b578419e4708a9a7ee3f056b062b20ba338a8b13e201aefe3710dbf238 */
/* loaded from: classes.dex */
public interface b {
    void a(String str, Object... objArr);

    boolean b();

    void c(String str, Object obj, Object obj2);

    boolean d();

    void e(Integer num);

    void f(String str, Object obj, Object obj2);

    void g(String str, Object... objArr);

    String getName();

    void h(String str);

    boolean i();

    default boolean j(int i8) {
        char c3;
        if (i8 == 1) {
            c3 = '(';
        } else if (i8 == 2) {
            c3 = 30;
        } else if (i8 == 3) {
            c3 = 20;
        } else if (i8 == 4) {
            c3 = '\n';
        } else {
            if (i8 != 5) {
                throw null;
            }
            c3 = 0;
        }
        if (c3 == 0) {
            return p();
        }
        if (c3 == '\n') {
            return d();
        }
        if (c3 == 20) {
            return m();
        }
        if (c3 == 30) {
            return b();
        }
        if (c3 == '(') {
            return i();
        }
        StringBuilder sb = new StringBuilder("Level [");
        sb.append(i8 != 1 ? i8 != 2 ? i8 != 3 ? i8 != 4 ? i8 != 5 ? AbstractJsonLexerKt.NULL : "TRACE" : "DEBUG" : "INFO" : "WARN" : "ERROR");
        sb.append("] not recognized.");
        throw new IllegalArgumentException(sb.toString());
    }

    void k(Object obj, String str);

    void l(Object obj, String str);

    boolean m();

    void n(String str, Exception exc);

    void o(String str);

    boolean p();

    void q(IOException iOException);

    void r(Object... objArr);
}
