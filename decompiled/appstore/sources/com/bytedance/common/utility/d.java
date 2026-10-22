package com.bytedance.common.utility;

import android.util.Pair;
import java.io.ByteArrayOutputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.zip.GZIPOutputStream;

/* JADX INFO: loaded from: classes.dex */
public abstract class d {
    private static final int BYTE_ARRAY_OUTPUT_STREAM_SIZE = 8192;
    private static d sDefault;

    public static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public boolean f6858a;

        public a() {
        }
    }

    static {
        sDefault = new b();
    }

    public d() {
    }

    public static byte[] compressWithgzip(byte[] r10) throws Exception {
        GZIPOutputStream r11 = null;
        ByteArrayOutputStream r12 = new ByteArrayOutputStream(8192);     // Catch: Throwable -> L7
        GZIPOutputStream r13 = new GZIPOutputStream(r12);     // Catch: Throwable -> L7
        r13.write(r10);     // Catch: Throwable -> L9
        r13.close();     // Catch: Throwable -> L9
        return r12.toByteArray();
    L9:
        th = th;
        r11 = r13;
    L11:
        if (r11 == null) goto L13;
        r11.close();
    L13:
        throw th;
    L7:
        th = th;
        goto L11
    }

    public static d getDefault() {
        return sDefault;
    }

    public static void setDefault(d r10) {
        if (r10 != null) goto L4;
        return;
    L4:
        if (r10 == sDefault) goto L8;
        sDefault = r10;
        return;
    }

    public String get(String r10) throws Exception {
        a r11 = new a();
        r11.f6858a = true;
        return get(r10, null, r11);
    }

    public abstract String get(String r10, Map r11, a r12);

    public String post(String r10, List<Pair<String, String>> r11) throws CommonHttpException {
        a r12 = new a();
        r12.f6858a = true;
        return post(r10, r11, null, r12);
    }

    public abstract String post(String r10, List r11, Map r12, a r13);

    public abstract String post(String r10, byte[] r11, Map r12, a r13);

    public String post(String r10, byte[] r11, boolean r12, String r13, boolean r14) throws CommonHttpException {
        HashMap r15 = new HashMap();
        if (r12 == false) goto L10;
        r11 = compressWithgzip(r11);     // Catch: Exception -> L6
        r15.put("Content-Encoding", "gzip");     // Catch: Exception -> L6
    L6:
        e = move-exception;
        throw new CommonHttpException(0, e.getMessage());
    L10:
        if (e.b(r13) == true) goto L12;
        r15.put("Content-Type", r13);
    L12:
        a r16 = new a();
        r16.f6858a = r14;
        return post(r10, r11, r15, r16);
    }
}
