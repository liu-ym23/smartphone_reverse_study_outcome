package b8;

import java.io.PrintStream;

/* compiled from: r8-map-id-ca86e8b578419e4708a9a7ee3f056b062b20ba338a8b13e201aefe3710dbf238 */
/* loaded from: classes.dex */
public abstract class d {

    /* renamed from: a, reason: collision with root package name */
    public static final int f1001a;

    /* renamed from: b, reason: collision with root package name */
    public static final int f1002b;

    static {
        int i8;
        String[] strArr = {"System.out", "stdout", "sysout"};
        String property = System.getProperty("slf4j.internal.report.stream");
        int i9 = 2;
        if (property == null || property.isEmpty()) {
            i8 = 1;
        } else {
            for (int i10 = 0; i10 < 3; i10++) {
                if (strArr[i10].equalsIgnoreCase(property)) {
                    i8 = 2;
                    break;
                }
            }
            i8 = 1;
        }
        f1001a = i8;
        String property2 = System.getProperty("slf4j.internal.verbosity");
        if (property2 != null && !property2.isEmpty()) {
            if (property2.equalsIgnoreCase("DEBUG")) {
                i9 = 1;
            } else if (property2.equalsIgnoreCase("ERROR")) {
                i9 = 4;
            } else if (property2.equalsIgnoreCase("WARN")) {
                i9 = 3;
            }
        }
        f1002b = i9;
    }

    public static final void a(String str, Throwable th) {
        b().println("SLF4J(E): " + str);
        b().println("SLF4J(E): Reported exception:");
        th.printStackTrace(b());
    }

    public static PrintStream b() {
        return m.f.a(f1001a) != 1 ? System.err : System.out;
    }

    public static final void c(String str) {
        if (m.f.a(3) >= m.f.a(f1002b)) {
            b().println("SLF4J(W): " + str);
        }
    }
}
