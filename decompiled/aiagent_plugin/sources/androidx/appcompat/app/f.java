package androidx.appcompat.app;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.LinkedHashSet;
import java.util.Locale;

/* JADX INFO: compiled from: LocaleOverlayHelper.java */
/* JADX INFO: loaded from: classes.dex */
final class f {
    static androidx.core.os.i a(androidx.core.os.i r1, androidx.core.os.i r2) {
        if (r1 == null) goto L9;
        if (r1.b() == true) goto L9;
        return b(r1, r2);
    L9:
        return androidx.core.os.i.e();
    }

    private static androidx.core.os.i b(androidx.core.os.i r4, androidx.core.os.i r5) {
        LinkedHashSet r0 = new LinkedHashSet();
        int r1 = 0;
    L4:
        if (r1 >= (r4.c() + r5.c())) goto L13;
        if (r1 >= r4.c()) goto L8;
        Locale r2 = r4.a(r1);
    L9:
        if (r2 == null) goto L11;
        r0.add(r2);
    L11:
        r1 = r1 + 1;
        goto L4
    L8:
        r2 = r5.a(r1 - r4.c());
        goto L9
    L13:
        return androidx.core.os.i.a((Locale[]) ZeusTransformUtils.preCheckCast(r0.toArray(new Locale[r0.size()]), Locale[].class, "com.obric.aiagent.plugin"));
    }
}
