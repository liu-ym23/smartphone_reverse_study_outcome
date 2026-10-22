package androidx.appcompat.app;

import java.util.LinkedHashSet;
import java.util.Locale;

/* JADX INFO: loaded from: classes.dex */
public abstract class k {
    public static androidx.core.os.e a(androidx.core.os.e r10, androidx.core.os.e r11) {
        LinkedHashSet r12 = new LinkedHashSet();
        int r13 = 0;
    L4:
        if (r13 >= (r10.f() + r11.f())) goto L13;
        if (r13 >= r10.f()) goto L8;
        Locale r14 = r10.c(r13);
    L9:
        if (r14 == null) goto L11;
        r12.add(r14);
    L11:
        r13 = r13 + 1;
        goto L4
    L8:
        r14 = r11.c(r13 - r10.f());
        goto L9
    L13:
        return androidx.core.os.e.a((Locale[]) r12.toArray(new Locale[r12.size()]));
    }

    public static androidx.core.os.e b(androidx.core.os.e r10, androidx.core.os.e r11) {
        if (r10 == null) goto L9;
        if (r10.e() == true) goto L9;
        return a(r10, r11);
    L9:
        return androidx.core.os.e.d();
    }
}
