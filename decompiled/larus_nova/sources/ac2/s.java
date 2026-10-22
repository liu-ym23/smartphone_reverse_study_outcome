package ac2;

import com.bytedance.android.live.core.log.ALogger;
import com.ttnet.org.chromium.net.urlconnection.CronetHttpURLConnection;
import java.io.IOException;
import java.net.CookieHandler;
import java.net.URI;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes9.dex */
public final class s {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static CookieHandler f2643a;

    static {
    }

    @JvmStatic
    public static final Map<String, String> a(String r100, boolean r101) {
        Intrinsics.checkNotNullParameter(r100, "url");
        URI r102 = com.bytedance.frameworks.baselib.network.http.util.l.a(r100);
        if (r101 == true) goto L5;
        f2643a = CookieHandler.getDefault();
        ALogger.i("TraceClientMonitor", "get CookieHandler EveryTime");
    L49:
        HashMap r103 = new HashMap();     // Catch: Throwable -> L43
        CookieHandler r104 = f2643a;     // Catch: Throwable -> L43
        if (r104 != null) goto L47;
    L14:
        Map<String, List<String>> r105 = null;
    L16:
        if (r105 != null) goto L18;
    L21:
        boolean r106 = true;
    L22:
        if (r106 == true) goto L46;
        Iterator<Map.Entry<String, List<String>>> r107 = r105.entrySet().iterator();     // Catch: Throwable -> L43
    L25:
        if (r107.hasNext() == false) goto L46;
        Map.Entry<String, List<String>> r108 = r107.next();     // Catch: Throwable -> L43
        String r109 = r108.getKey();     // Catch: Throwable -> L43
        List<String> r110 = r108.getValue();     // Catch: Throwable -> L43
        StringBuilder r111 = new StringBuilder();     // Catch: Throwable -> L43
        if (StringsKt.equals(CronetHttpURLConnection.SS_COOKIE, r109, true) == true) goto L33;
        if (StringsKt.equals("Cookie", r109, true) == true) goto L33;
        if (StringsKt.equals("Cookie2", r109, true) == false) goto L25;
    L33:
        if ((!r110.isEmpty()) == false) goto L25;
        Iterator<String> r112 = r110.iterator();     // Catch: Throwable -> L43
        int r113 = 0;
    L36:
        if (r112.hasNext() == false) goto L41;
        String r114 = r112.next();     // Catch: Throwable -> L43
        if (r113 <= 0) goto L40;
        r111.append("; ");     // Catch: Throwable -> L43
    L40:
        r111.append(r114);     // Catch: Throwable -> L43
        r113 = r113 + 1;     // Catch: Throwable -> L43
        goto L36
    L41:
        return MapsKt.hashMapOf(new Pair[]{TuplesKt.to(r109, r111.toString())});
    L46:
        return new HashMap();
    L18:
        if (r105.isEmpty() == true) goto L21;
        r106 = false;
        goto L22
    L47:
        Intrinsics.checkNotNull(r104);     // Catch: IOException -> L12 Throwable -> L43
        r105 = r104.get(r102, r103);     // Catch: IOException -> L12 Throwable -> L43
    L12:
        e = move-exception;
        e.printStackTrace();     // Catch: Throwable -> L43
    L43:
        th = move-exception;
        th.printStackTrace();
        goto L46
    L5:
        if (f2643a != null) goto L49;
        f2643a = CookieHandler.getDefault();
        ALogger.i("TraceClientMonitor", "get CookieHandler Once");
        goto L49
    }
}
