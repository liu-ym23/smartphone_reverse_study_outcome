package okhttp3.internal.c;

import d.h.b.ad;
import d.h.b.o;
import java.util.Arrays;
import java.util.logging.Logger;

/* JADX INFO: compiled from: TaskLogger.kt */
/* JADX INFO: loaded from: classes4.dex */
public final class b {
    public static final /* synthetic */ void a(a r0, c r1, String r2) {
        b(r0, r1, r2);
    }

    private static final void b(a r4, c r5, String r6) {
        Logger r0 = d.f39848a.a();
        StringBuilder r7 = new StringBuilder().append(r5.b()).append(' ');
        ad r1 = ad.f38485a;
        String r8 = String.format("%-22s", Arrays.copyOf(new Object[]{r6}, 1));
        o.c(r8, "format(format, *args)");
        r0.fine(r7.append(r8).append(": ").append(r4.b()).toString());
    }

    public static final String a(long r12) {
        if (r12 > (-999500000)) goto L6;
        String r13 = ((r12 - ((long) 500000000)) / ((long) 1000000000)) + " s ";
    L18:
        ad r14 = ad.f38485a;
        String r15 = String.format("%6s", Arrays.copyOf(new Object[]{r13}, 1));
        o.c(r15, "format(format, *args)");
        return r15;
    L6:
        if (r12 > (-999500)) goto L9;
        r13 = ((r12 - ((long) 500000)) / ((long) 1000000)) + " ms";
        goto L18
    L9:
        if (r12 > 0) goto L12;
        r13 = ((r12 - ((long) 500)) / ((long) 1000)) + " µs";
        goto L18
    L12:
        if (r12 >= 999500) goto L15;
        r13 = ((r12 + ((long) 500)) / ((long) 1000)) + " µs";
        goto L18
    L15:
        if (r12 >= 999500000) goto L17;
        r13 = ((r12 + ((long) 500000)) / ((long) 1000000)) + " ms";
        goto L18
    L17:
        r13 = ((r12 + ((long) 500000000)) / ((long) 1000000000)) + " s ";
        goto L18
    }
}
