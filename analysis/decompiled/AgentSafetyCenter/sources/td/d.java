package td;

import java.io.PrintStream;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public abstract class d {

    /* renamed from: a, reason: collision with root package name */
    public static final int f13296a;

    /* renamed from: b, reason: collision with root package name */
    public static final int f13297b;

    static {
        int i;
        String[] strArr = {"System.out", "stdout", "sysout"};
        String property = System.getProperty("slf4j.internal.report.stream");
        int i3 = 2;
        if (property == null || property.isEmpty()) {
            i = 1;
        } else {
            for (int i10 = 0; i10 < 3; i10++) {
                if (strArr[i10].equalsIgnoreCase(property)) {
                    i = 2;
                    break;
                }
            }
            i = 1;
        }
        f13296a = i;
        String property2 = System.getProperty("slf4j.internal.verbosity");
        if (property2 != null && !property2.isEmpty()) {
            if (property2.equalsIgnoreCase("DEBUG")) {
                i3 = 1;
            } else if (property2.equalsIgnoreCase("ERROR")) {
                i3 = 4;
            } else if (property2.equalsIgnoreCase("WARN")) {
                i3 = 3;
            }
        }
        f13297b = i3;
    }

    public static final void a(String str, Throwable th) {
        b().println("SLF4J(E): ".concat(str));
        b().println("SLF4J(E): Reported exception:");
        th.printStackTrace(b());
    }

    public static PrintStream b() {
        return s.f.c(f13296a) != 1 ? System.err : System.out;
    }

    public static final void c(String str) {
        if (s.f.c(3) >= s.f.c(f13297b)) {
            b().println("SLF4J(W): " + str);
        }
    }
}
