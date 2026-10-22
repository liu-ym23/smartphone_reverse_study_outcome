package com.bytedance.common.utility;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.ByteArrayOutputStream;
import java.util.Map;
import java.util.zip.GZIPOutputStream;

/* JADX INFO: compiled from: NetworkClient.java */
/* JADX INFO: loaded from: classes.dex */
public abstract class g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static g f6724a;

    /* JADX INFO: compiled from: NetworkClient.java */
    public static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public boolean f6725a;

        public a() {
        }
    }

    public abstract String a(String r1, Map<String, String> r2, a r3);

    public abstract String a(String r1, byte[] r2, Map<String, String> r3, a r4);

    public byte[] b(String r1, byte[] r2, Map<String, String> r3, a r4) {
        Map r0 = (Map) ZeusTransformUtils.wrapperContextForParams(r3, Map.class, "com.obric.aiagent.plugin");
        return null;
    }

    public g() {
    }

    static {
        f6724a = new e();
    }

    public static void a(g r1) {
        if (r1 != null) goto L4;
        return;
    L4:
        if (r1 == f6724a) goto L8;
        f6724a = r1;
        return;
    }

    public static g a() {
        return f6724a;
    }

    public static byte[] a(byte[] r3) {
        GZIPOutputStream r0 = null;
        ByteArrayOutputStream r1 = new ByteArrayOutputStream(8192);     // Catch: Throwable -> L9
        GZIPOutputStream r2 = new GZIPOutputStream(r1);     // Catch: Throwable -> L9
        r2.write(r3);     // Catch: Throwable -> L7
        r2.close();     // Catch: Throwable -> L7
        return r1.toByteArray();
    L7:
        th = th;
        r0 = r2;
    L10:
        if (r0 == null) goto L12;
        r0.close();
    L12:
        throw th;
    L9:
        th = th;
        goto L10
    }
}
