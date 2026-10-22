package org.slf4j.helpers;

import java.io.PrintStream;

/* loaded from: classes4.dex */
public abstract class a {

    /* renamed from: a, reason: collision with root package name */
    public static final Reporter$TargetChoice f5517a;
    public static final Reporter$Level b;

    static {
        String[] strArr = {"System.out", "stdout", "sysout"};
        String property = System.getProperty("slf4j.internal.report.stream");
        Reporter$TargetChoice reporter$TargetChoice = Reporter$TargetChoice.f5516a;
        if (property != null && !property.isEmpty()) {
            int i = 0;
            while (true) {
                if (i >= 3) {
                    break;
                }
                if (strArr[i].equalsIgnoreCase(property)) {
                    reporter$TargetChoice = Reporter$TargetChoice.b;
                    break;
                }
                i++;
            }
        }
        f5517a = reporter$TargetChoice;
        String property2 = System.getProperty("slf4j.internal.verbosity");
        Reporter$Level reporter$Level = Reporter$Level.INFO;
        if (property2 != null && !property2.isEmpty()) {
            if (property2.equalsIgnoreCase("DEBUG")) {
                reporter$Level = Reporter$Level.DEBUG;
            } else if (property2.equalsIgnoreCase("ERROR")) {
                reporter$Level = Reporter$Level.ERROR;
            } else if (property2.equalsIgnoreCase("WARN")) {
                reporter$Level = Reporter$Level.WARN;
            }
        }
        b = reporter$Level;
    }

    public static void a(String str) {
        if (b.f5515a <= 0) {
            c().println("SLF4J(D): " + str);
        }
    }

    public static final void b(String str, Throwable th) {
        c().println("SLF4J(E): " + str);
        c().println("SLF4J(E): Reported exception:");
        th.printStackTrace(c());
    }

    public static PrintStream c() {
        return f5517a.ordinal() != 1 ? System.err : System.out;
    }

    public static void d(String str) {
        if (1 >= b.f5515a) {
            c().println("SLF4J(I): " + str);
        }
    }

    public static final void e(String str) {
        if (2 >= b.f5515a) {
            c().println("SLF4J(W): " + str);
        }
    }
}
