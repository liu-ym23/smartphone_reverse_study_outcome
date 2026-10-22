package org.slf4j.helpers;

import java.io.PrintStream;

/* loaded from: classes5.dex */
public class Reporter {

    /* renamed from: a, reason: collision with root package name */
    public static final String[] f37935a = {"System.out", "stdout", "sysout"};

    /* renamed from: b, reason: collision with root package name */
    public static final TargetChoice f37936b = e();

    /* renamed from: c, reason: collision with root package name */
    public static final Level f37937c = g();

    public enum Level {
        DEBUG(0),
        INFO(1),
        WARN(2),
        ERROR(3);

        int levelInt;

        Level(int i10) {
            this.levelInt = i10;
        }

        private int getLevelInt() {
            return this.levelInt;
        }
    }

    public enum TargetChoice {
        Stderr,
        Stdout
    }

    public static void a(String str) {
        if (h(Level.DEBUG)) {
            d().println("SLF4J(D): " + str);
        }
    }

    public static final void b(String str) {
        d().println("SLF4J(E): " + str);
    }

    public static final void c(String str, Throwable th) {
        d().println("SLF4J(E): " + str);
        d().println("SLF4J(E): Reported exception:");
        th.printStackTrace(d());
    }

    public static PrintStream d() {
        return f37936b.ordinal() != 1 ? System.err : System.out;
    }

    public static TargetChoice e() {
        String property = System.getProperty("slf4j.internal.report.stream");
        if (property == null || property.isEmpty()) {
            return TargetChoice.Stderr;
        }
        for (String str : f37935a) {
            if (str.equalsIgnoreCase(property)) {
                return TargetChoice.Stdout;
            }
        }
        return TargetChoice.Stderr;
    }

    public static void f(String str) {
        if (h(Level.INFO)) {
            d().println("SLF4J(I): " + str);
        }
    }

    public static Level g() {
        String property = System.getProperty("slf4j.internal.verbosity");
        return (property == null || property.isEmpty()) ? Level.INFO : property.equalsIgnoreCase("DEBUG") ? Level.DEBUG : property.equalsIgnoreCase("ERROR") ? Level.ERROR : property.equalsIgnoreCase("WARN") ? Level.WARN : Level.INFO;
    }

    public static boolean h(Level level) {
        return level.levelInt >= f37937c.levelInt;
    }

    public static final void i(String str) {
        if (h(Level.WARN)) {
            d().println("SLF4J(W): " + str);
        }
    }
}
