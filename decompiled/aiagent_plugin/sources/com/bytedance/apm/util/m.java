package com.bytedance.apm.util;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import com.obric.aiagent.platform.depend.ILogDepend;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;
import me.ele.lancet.base.annotations.Skip;

/* JADX INFO: compiled from: NetUtils.java */
/* JADX INFO: loaded from: classes.dex */
public class m {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static com.bytedance.common.utility.i.c f4984a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static com.bytedance.common.utility.i.b f4985b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static com.bytedance.apm.net.a f4986c;

    static {
        f4985b = com.bytedance.common.utility.i.b.f6735a;
    }

    public static boolean a(Context r3) {
        NetworkInfo r4 = ((ConnectivityManager) ZeusTransformUtils.preCheckCast(((Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.aiagent.plugin")).getSystemService("connectivity"), ConnectivityManager.class, "com.obric.aiagent.plugin")).getActiveNetworkInfo();     // Catch: Exception -> L9
        if (r4 == null) goto L12;
        if (r4.isConnected() == false) goto L13;
        return true;
    L13:
        return false;
    L12:
        return false;
    L14:
        return false;
    }

    public static boolean b(Context r4) {
        NetworkInfo r5 = ((ConnectivityManager) ZeusTransformUtils.preCheckCast(((Context) ZeusTransformUtils.wrapperContextForParams(r4, Context.class, "com.obric.aiagent.plugin")).getSystemService("connectivity"), ConnectivityManager.class, "com.obric.aiagent.plugin")).getActiveNetworkInfo();     // Catch: Exception -> L20
        if (r5 != null) goto L6;
        return false;
    L6:
        if (r5.isAvailable() == false) goto L24;
        com.bytedance.common.utility.i.c r1 = f4984a;     // Catch: Exception -> L20
        if (r1 == null) goto L17;
        if (r1.a() == com.bytedance.common.utility.i.b.f6736b) goto L17;
        if (f4984a.a() == com.bytedance.common.utility.i.b.f) goto L15;
        return false;
    L15:
        return true;
    L17:
        if (1 == r5.getType()) goto L19;
        return false;
    L19:
        return true;
    L24:
        return false;
    L26:
        return false;
    }

    public static void a(com.bytedance.apm.net.a r2) {
        f4986c = (com.bytedance.apm.net.a) ZeusTransformUtils.wrapperContextForParams(r2, com.bytedance.apm.net.a.class, "com.obric.aiagent.plugin");
    }

    public static HttpURLConnection a(String r2) {
        com.bytedance.apm.net.a r0 = f4986c;
        if (r0 != null) goto L6;
        return (HttpURLConnection) ZeusTransformUtils.preCheckCast(a(new URL(r2)), HttpURLConnection.class, "com.obric.aiagent.plugin");
    L6:
        return r0.a(r2);
    }

    @Skip({"com.obric.aiagent.okhttp"})
    public static URLConnection a(URL r4) {
        URL r0 = (URL) ZeusTransformUtils.preCheckCast(r4, URL.class, "com.obric.aiagent.plugin");
        String r1 = r0.getHost();
        String r2 = r0.getPath();
        if (com.obric.aiagent.a.b.a(r1, r2) == false) goto L5;
        ILogDepend.Companion.i("AiAgentUrlConnLancet", "openConnection drop host=" + r1 + " path=" + r2);
        com.obric.aiagent.a.b.a(com.obric.aiagent.a.b.b(r1, r2), r1, r2);
        throw new IOException("[NetGuard] dropped ");
    L5:
        return r4.openConnection();
    }
}
