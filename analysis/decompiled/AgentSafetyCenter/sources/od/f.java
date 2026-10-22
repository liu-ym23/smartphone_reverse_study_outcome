package od;

import com.fasterxml.jackson.core.JsonFactory;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.NoSuchElementException;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final /* synthetic */ class f implements s.v {
    public static /* synthetic */ void b() {
        throw new IllegalArgumentException();
    }

    public static /* synthetic */ void c(Object obj) {
        throw new IllegalArgumentException(obj.toString());
    }

    public static /* synthetic */ void d(Object obj, String str) throws FileNotFoundException {
        throw new FileNotFoundException(str + obj);
    }

    public static /* synthetic */ void e(String str) {
        throw new IllegalStateException(str);
    }

    public static /* synthetic */ void f(String str, Object obj, Object obj2) {
        throw new NoSuchElementException(str + obj + obj2);
    }

    public static /* synthetic */ void g(String str, Throwable th) {
        throw new RuntimeException(str, th);
    }

    public static /* synthetic */ void h(StringBuilder sb2, Object obj) {
        sb2.append(obj);
        throw new IllegalStateException(sb2.toString());
    }

    public static /* synthetic */ void i(Throwable th, Object obj, String str) {
        throw new SecurityException(str + obj, th);
    }

    public static /* synthetic */ void j() {
        throw new ClassCastException();
    }

    public static /* synthetic */ void k(Object obj, String str) throws IOException {
        throw new IOException(str + obj);
    }

    public static /* synthetic */ void l(String str) throws IOException {
        throw new IOException(str);
    }

    public static /* synthetic */ void m(String str, Object obj, Object obj2) {
        throw new IllegalArgumentException(str + obj + obj2);
    }

    public static /* synthetic */ void n(Object obj, String str) throws IOException {
        throw new IOException(str + obj);
    }

    public static /* synthetic */ void o(String str) {
        throw new RuntimeException(str);
    }

    public static /* synthetic */ void p(String str, Object obj, Object obj2) {
        throw new IllegalArgumentException(str + obj + obj2);
    }

    public static /* synthetic */ void q(Object obj, String str) {
        throw new IllegalArgumentException((str + obj + JsonFactory.DEFAULT_QUOTE_CHAR).toString());
    }

    public static /* synthetic */ void r(String str, Object obj, Object obj2) {
        throw new IllegalStateException((str + obj + obj2).toString());
    }

    public static /* synthetic */ void s(Object obj, String str) {
        throw new xd.d(str + obj);
    }

    @Override // s.v
    public float a(float f5) {
        return f5;
    }
}
