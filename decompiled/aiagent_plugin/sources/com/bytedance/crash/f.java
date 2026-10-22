package com.bytedance.crash;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.net.BindException;
import java.net.ConnectException;
import java.net.NoRouteToHostException;
import java.net.PortUnreachableException;
import java.net.ProtocolException;
import java.net.SocketException;
import java.net.SocketTimeoutException;
import java.net.UnknownHostException;
import java.util.Collection;
import java.util.Map;
import javax.net.ssl.SSLException;
import org.apache.http.conn.ConnectTimeoutException;

/* JADX INFO: compiled from: Ensure.java */
/* JADX INFO: loaded from: classes.dex */
public class f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static boolean f7458a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @Deprecated
    private static final g f7459b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static int f7460c;

    @Deprecated
    public static boolean a(Object r0) {
        return false;
    }

    @Deprecated
    public static boolean a(Object r0, String r1) {
        return false;
    }

    @Deprecated
    public static boolean a(Collection r2) {
        Collection r3 = (Collection) ZeusTransformUtils.wrapperContextForParams(r2, Collection.class, "com.obric.aiagent.plugin");
        return false;
    }

    @Deprecated
    public static boolean a(boolean r0) {
        return false;
    }

    @Deprecated
    public static boolean a(boolean r0, String r1) {
        return false;
    }

    @Deprecated
    public static boolean a(boolean r0, String r1, Map<String, String> r2) {
        Map r3 = (Map) ZeusTransformUtils.wrapperContextForParams(r2, Map.class, "com.obric.aiagent.plugin");
        return false;
    }

    @Deprecated
    public static boolean b(boolean r0) {
        return false;
    }

    @Deprecated
    public static boolean b(boolean r0, String r1) {
        return false;
    }

    @Deprecated
    public static boolean b(boolean r0, String r1, Map<String, String> r2) {
        Map r3 = (Map) ZeusTransformUtils.wrapperContextForParams(r2, Map.class, "com.obric.aiagent.plugin");
        return false;
    }

    static {
        f7459b = new g();
        f7460c = 0;
    }

    @Deprecated
    public static g a() {
        return f7459b;
    }

    public static void a(Throwable r1) {
        if (b(r1) == false) goto L5;
        return;
    L5:
        com.bytedance.crash.monitor.h.b().a(r1);
    }

    public static void a(String r7, String r8, String r9, String r10, Map<String, String> r11) {
        Map<String, String> r5 = (Map) ZeusTransformUtils.wrapperContextForParams(r11, Map.class, "com.obric.aiagent.plugin");
        com.bytedance.crash.monitor.h.b().a(r7, r8, r9, r10, r5, null);
    }

    public static void a(Throwable r1, String r2) {
        if (b(r1) == false) goto L5;
        return;
    L5:
        com.bytedance.crash.monitor.h.b().a(r1, r2);
    }

    public static void a(Throwable r2, String r3, Map<String, String> r4) {
        Map<String, String> r5 = (Map) ZeusTransformUtils.wrapperContextForParams(r4, Map.class, "com.obric.aiagent.plugin");
        if (b(r2) == false) goto L5;
        return;
    L5:
        com.bytedance.crash.monitor.h.b().a(r2, r3, r5);
    }

    public static boolean b(Throwable r2) {
        if (r2 != null) goto L39;
        return true;
    L39:
    L35:
        th = move-exception;
        th.printStackTrace();
        return false;
    L6:
        if (ZeusTransformUtils.instanceOf(r2, ConnectTimeoutException.class) == false) goto L9;
        return true;
    L9:
        if (ZeusTransformUtils.instanceOf(r2, SocketTimeoutException.class) == false) goto L12;
        return true;
    L12:
        if (ZeusTransformUtils.instanceOf(r2, BindException.class) == false) goto L15;
        return true;
    L15:
        if (ZeusTransformUtils.instanceOf(r2, ConnectException.class) == false) goto L18;
        return true;
    L18:
        if (ZeusTransformUtils.instanceOf(r2, NoRouteToHostException.class) == false) goto L21;
        return true;
    L21:
        if (ZeusTransformUtils.instanceOf(r2, PortUnreachableException.class) == false) goto L24;
        return true;
    L24:
        if (ZeusTransformUtils.instanceOf(r2, SocketException.class) == false) goto L27;
        return true;
    L27:
        if (ZeusTransformUtils.instanceOf(r2, UnknownHostException.class) == false) goto L30;
        return true;
    L30:
        if (ZeusTransformUtils.instanceOf(r2, ProtocolException.class) == false) goto L32;
        return true;
    L32:
        if (ZeusTransformUtils.instanceOf(r2, SSLException.class) == false) goto L41;
        return true;
    L41:
        return false;
    }

    public static void c(boolean r0) {
        f7458a = r0;
    }
}
