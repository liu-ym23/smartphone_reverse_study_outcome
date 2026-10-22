package kotlin.io;

import java.io.File;
import kotlin.jvm.internal.q;

/* JADX INFO: loaded from: classes4.dex */
public abstract class c {
    public static final /* synthetic */ String a(File r10, File r11, String r12) {
        return b(r10, r11, r12);
    }

    public static final String b(File r10, File r11, String r12) {
        StringBuilder r13 = new StringBuilder(r10.toString());
        if (r11 == null) goto L5;
        r13.append(" -> " + r11);
    L5:
        if (r12 == null) goto L7;
        r13.append(": " + r12);
    L7:
        String r14 = r13.toString();
        q.f(r14, "toString(...)");
        return r14;
    }
}
