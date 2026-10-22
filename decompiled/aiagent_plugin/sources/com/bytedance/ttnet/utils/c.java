package com.bytedance.ttnet.utils;

import com.bytedance.frameworks.baselib.network.http.i.j;
import com.bytedance.retrofit2.af;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.List;
import org.json.JSONObject;

/* JADX INFO: compiled from: RequestTicketUtil.java */
/* JADX INFO: loaded from: classes.dex */
public class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static b f11530a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static a f11531b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static volatile boolean f11532c = true;

    /* JADX INFO: compiled from: RequestTicketUtil.java */
    public interface a {
        void a(String r1, com.bytedance.ttnet.d.b r2);
    }

    /* JADX INFO: compiled from: RequestTicketUtil.java */
    public interface b {
        void a(String r1, String r2, int r3, boolean r4, JSONObject r5);

        void a(String r1, String r2, String r3, com.bytedance.ttnet.d.b r4);
    }

    static {
    }

    public static void a(String r2, List<com.bytedance.retrofit2.b.b> r3, af r4) {
        List r5 = (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.aiagent.plugin");
        if (f11532c == true) goto L5;
        return;
    L5:
        r4.N();
        String r0 = null;
        if (j.a(r2).getHost().endsWith(com.bytedance.ttnet.b.a()) == false) goto L10;
        r0 = String.valueOf(System.currentTimeMillis());     // Catch: Throwable -> L14
    L10:
        if (com.bytedance.common.utility.j.a(r0) == true) goto L12;
        r5.add(new com.bytedance.retrofit2.b.b("X-SS-REQ-TICKET", r0));     // Catch: Throwable -> L14
    L12:
        r4.O();
    }

    public static void a(String r1, String r2, String r3, com.bytedance.ttnet.d.b r4) {
        b r0 = f11530a;
        if (r0 == null) goto L6;
        r0.a(r1, r2, r3, r4);
        return;
    }

    public static void a(String r6, String r7, int r8, boolean r9, JSONObject r10) {
        b r0 = f11530a;
        if (r0 == null) goto L6;
        r0.a(r6, r7, r8, r9, r10);
        return;
    }

    public static b a() {
        return f11530a;
    }

    public static void a(b r2) {
        f11530a = (b) ZeusTransformUtils.wrapperContextForParams(r2, b.class, "com.obric.aiagent.plugin");
    }

    public static a b() {
        return f11531b;
    }

    public static void a(boolean r0) {
        f11532c = r0;
    }
}
