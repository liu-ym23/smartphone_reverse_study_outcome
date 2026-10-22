package d.f;

import java.io.File;

/* JADX INFO: compiled from: Exceptions.kt */
/* JADX INFO: loaded from: classes4.dex */
public final class d {
    public static final /* synthetic */ String a(File r0, File r1, String r2) {
        return b(r0, r1, r2);
    }

    private static final String b(File r2, File r3, String r4) {
        StringBuilder r0 = new StringBuilder(r2.toString());
        if (r3 == null) goto L5;
        r0.append(" -> " + r3);
    L5:
        if (r4 == null) goto L7;
        r0.append(": " + r4);
    L7:
        String r5 = r0.toString();
        d.h.b.o.c(r5, "toString(...)");
        return r5;
    }
}
