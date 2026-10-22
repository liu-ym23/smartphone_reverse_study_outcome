package bytekn.foundation.utils;

import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.Iterator;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes28.dex */
public final class b {
    public static final String a(Throwable r100, int r101) {
        StringWriter r102 = new StringWriter();     // Catch: Throwable -> L19
        r100.printStackTrace(new PrintWriter(r102));     // Catch: Throwable -> L19
        String r103 = r102.getBuffer().toString();     // Catch: Throwable -> L19
        List r104 = StringsKt.split$default(r103, new String[]{"\n"}, false, 0, 6, null);     // Catch: Throwable -> L19
        if (r101 <= 0) goto L25;
        Iterator r105 = r104.iterator();     // Catch: Throwable -> L19
        int r106 = 0;
        String r107 = "";
    L7:
        if (r105.hasNext() == false) goto L18;
        Object r108 = r105.next();     // Catch: Throwable -> L19
        int r109 = r106 + 1;     // Catch: Throwable -> L19
        if (r106 >= 0) goto L12;
        CollectionsKt.throwIndexOverflow();     // Catch: Throwable -> L19
    L12:
        String r110 = (String) r108;     // Catch: Throwable -> L19
        if (r101 <= r106) goto L16;
        r107 = r107 + r110 + "\n";     // Catch: Throwable -> L19
    L16:
        r106 = r109;
        goto L7
    L18:
        return r107;
    L25:
        return r103;
    L26:
        return "";
    }
}
