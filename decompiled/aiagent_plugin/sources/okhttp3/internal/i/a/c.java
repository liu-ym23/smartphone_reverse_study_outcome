package okhttp3.internal.i.a;

import android.util.Log;
import com.obric.aiagent.apm.impl.BuildConfig;
import com.ss.android.socialbase.downloader.constants.DownloadErrorCode;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.a.ao;
import d.h.b.o;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.concurrent.CopyOnWriteArraySet;
import java.util.logging.Handler;
import java.util.logging.Level;
import java.util.logging.Logger;
import me.ele.lancet.base.annotations.Skip;
import okhttp3.z;

/* JADX INFO: compiled from: AndroidLog.kt */
/* JADX INFO: loaded from: classes5.dex */
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final c f40098a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final CopyOnWriteArraySet<Logger> f40099b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final Map<String, String> f40100c = null;

    private c() {
    }

    static {
        f40098a = new c();
        f40099b = new CopyOnWriteArraySet();
        LinkedHashMap r0 = new LinkedHashMap();
        Package r1 = z.class.getPackage();
        if (r1 == null) goto L5;
        String r2 = r1.getName();
    L7:
        if (r2 == null) goto L9;
        ((Map) ZeusTransformUtils.preCheckCast(r0, Map.class, "com.obric.aiagent.plugin")).put(r2, "OkHttp");
    L9:
        Map r3 = (Map) ZeusTransformUtils.preCheckCast(r0, Map.class, "com.obric.aiagent.plugin");
        String r4 = z.class.getName();
        o.c(r4, "OkHttpClient::class.java.name");
        r3.put(r4, "okhttp.OkHttpClient");
        Map r5 = (Map) ZeusTransformUtils.preCheckCast(r0, Map.class, "com.obric.aiagent.plugin");
        String r6 = okhttp3.internal.g.e.class.getName();
        o.c(r6, "Http2::class.java.name");
        r5.put(r6, "okhttp.Http2");
        Map r7 = (Map) ZeusTransformUtils.preCheckCast(r0, Map.class, "com.obric.aiagent.plugin");
        String r8 = okhttp3.internal.c.d.class.getName();
        o.c(r8, "TaskRunner::class.java.name");
        r7.put(r8, "okhttp.TaskRunner");
        ((Map) ZeusTransformUtils.preCheckCast(r0, Map.class, "com.obric.aiagent.plugin")).put("okhttp3.mockwebserver.MockWebServer", "okhttp.MockWebServer");
        f40100c = ao.d((Map) ZeusTransformUtils.preCheckCast(r0, Map.class, "com.obric.aiagent.plugin"));
        return;
    L5:
        r2 = null;
        goto L7
    }

    public final void a(String r7, int r8, String r9, Throwable r10) {
        o.e(r7, "loggerName");
        o.e(r9, "message");
        String r6 = a(r7);
        if (a(r6, r8) == false) goto L16;
        if (r10 == null) goto L6;
        r9 = r9 + '\n' + Log.getStackTraceString(r10);
    L6:
        int r11 = 0;
        int r12 = r9.length();
    L7:
        if (r11 >= r12) goto L20;
        int r0 = d.o.o.a((CharSequence) ZeusTransformUtils.preCheckCast(r9, CharSequence.class, "com.obric.aiagent.plugin"), '\n', r11, false, 4, null);
        if (r0 != (-1)) goto L12;
        r0 = r12;
    L12:
        int r1 = Math.min(r0, r11 + DownloadErrorCode.ERROR_CRONET_HTTP_ERROR_END);
        String r13 = r9.substring(r11, r1);
        o.c(r13, "this as java.lang.String…ing(startIndex, endIndex)");
        a(r8, r6, r13);
        if (r1 >= r0) goto L14;
        r11 = r1;
        goto L12
    L14:
        r11 = r1 + 1;
        goto L7
    L20:
        return;
    }

    private final String a(String r3) {
        String r2 = (String) ZeusTransformUtils.preCheckCast(f40100c.get(r3), String.class, "com.obric.aiagent.plugin");
        if (r2 == null) goto L5;
        return r2;
    L5:
        return d.o.o.e(r3, 23);
    }

    public final void a() {
        Iterator<Map.Entry<String, String>> r0 = f40100c.entrySet().iterator();
    L4:
        if (r0.hasNext() == false) goto L6;
        Map.Entry r1 = (Map.Entry) ZeusTransformUtils.preCheckCast(r0.next(), Map.Entry.class, "com.obric.aiagent.plugin");
        a((String) ZeusTransformUtils.preCheckCast(r1.getKey(), String.class, "com.obric.aiagent.plugin"), (String) ZeusTransformUtils.preCheckCast(r1.getValue(), String.class, "com.obric.aiagent.plugin"));
        goto L4
    }

    private final void a(String r2, String r3) {
        Logger r1 = Logger.getLogger(r2);
        if (f40099b.add(r1) == false) goto L13;
        r1.setUseParentHandlers(false);
        if (a(r3, 3) == false) goto L8;
        Level r4 = Level.FINE;
    L11:
        r1.setLevel(r4);
        r1.addHandler((Handler) ZeusTransformUtils.preCheckCast(d.f40101a, Handler.class, "com.obric.aiagent.plugin"));
        return;
    L8:
        if (a(r3, 4) == false) goto L10;
        r4 = Level.INFO;
        goto L11
    L10:
        r4 = Level.WARNING;
        goto L11
    }

    @Skip({BuildConfig.LIBRARY_PACKAGE_NAME})
    public static boolean a(String r1, int r2) {
        if (com.obric.aiagent.apm.impl.a.a() == true) goto L7;
        return Log.isLoggable(r1, r2);
    L7:
        if (r2 == 6) goto L9;
    L11:
        return false;
    L9:
        if (Log.isLoggable(r1, r2) == false) goto L11;
        return true;
    }

    @Skip({BuildConfig.LIBRARY_PACKAGE_NAME})
    public static int a(int r1, String r2, String r3) {
        if (com.obric.aiagent.apm.impl.a.a() == false) goto L10;
        if (r1 == 6) goto L10;
        return 0;
    L10:
        return Log.println(r1, r2, r3);
    }
}
