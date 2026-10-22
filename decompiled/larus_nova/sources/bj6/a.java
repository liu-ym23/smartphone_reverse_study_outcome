package bj6;

import java.util.Iterator;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;
import si6.b;
import ui6.e;

/* JADX INFO: loaded from: classes19.dex */
public final class a {
    public static final String a(ei6.a r100) {
        if (r100 == null) goto L6;
        b r101 = r100.b();
        if (r101 == null) goto L6;
        String r102 = r101.m();
    L7:
        String r103 = String.valueOf(r102);
        String r104 = "";
        if (r100 == null) goto L19;
        e r105 = r100.n();
        if (r105 == null) goto L19;
        Map<String, mi6.b> r106 = r105.b();
        if (r106 == null) goto L19;
        Iterator<Map.Entry<String, mi6.b>> r107 = r106.entrySet().iterator();
    L15:
        if (r107.hasNext() == false) goto L19;
        String r108 = r107.next().getValue().getRoomId();
        if ((!Intrinsics.areEqual(r108, r103)) == false) goto L15;
        r104 = r108;
    L19:
        return r104;
    L6:
        r102 = null;
        goto L7
    }

    public static final String b(ei6.a r100) {
        if (r100 == null) goto L6;
        b r101 = r100.b();
        if (r101 == null) goto L6;
        String r102 = r101.m();
    L8:
        return String.valueOf(r102);
    L6:
        r102 = null;
        goto L8
    }
}
