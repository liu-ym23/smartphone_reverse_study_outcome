package B3;

import java.io.PrintStream;

/* loaded from: classes2.dex */
public abstract class f implements t3.h {

    /* renamed from: a, reason: collision with root package name */
    public static final int f226a;

    /* renamed from: b, reason: collision with root package name */
    public static final int f227b;

    static {
        f226a = 128;
        if (d.f224b) {
            f226a = 16;
        }
        String property = System.getProperty("rx.ring-buffer.size");
        if (property != null) {
            try {
                f226a = Integer.parseInt(property);
            } catch (NumberFormatException e4) {
                PrintStream printStream = System.err;
                StringBuilder sbW = B0.g.w("Failed to set 'rx.buffer.size' with value ", property, " => ");
                sbW.append(e4.getMessage());
                printStream.println(sbW.toString());
            }
        }
        f227b = f226a;
        new e(0);
        new e(1);
    }
}
