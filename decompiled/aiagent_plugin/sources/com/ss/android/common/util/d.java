package com.ss.android.common.util;

import android.util.Pair;
import com.bytedance.common.utility.Logger;
import com.bytedance.common.utility.i;
import com.bytedance.common.utility.j;
import com.bytedance.frameworks.baselib.network.http.i.l;
import com.bytedance.retrofit2.e.g;
import com.bytedance.security.zenmobile.io.SensitiveType;
import com.bytedance.ttnet.INetworkApi;
import com.ss.android.socialbase.downloader.utils.DownloadHelper;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.ByteArrayOutputStream;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.zip.Deflater;
import java.util.zip.GZIPOutputStream;

/* JADX INFO: compiled from: NetworkUtils.java */
/* JADX INFO: loaded from: classes4.dex */
public class d {
    private static final String TAG = "NetworkUtils";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final String[] f37289a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static volatile boolean f37290b = true;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static volatile boolean f37291c = false;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static volatile boolean f37292d = false;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static volatile int f37293e;

    static {
        f37289a = new String[]{"mac_address", "oaid", "openudid", "uuid", SensitiveType.IMEI};
        f37293e = -1;
    }

    @Deprecated
    public static String a(int r9, String r10, byte[] r11, i.a r12, String r13) {
        if (j.a(r10) == false) goto L5;
        return null;
    L5:
        Pair<byte[], String> r14 = a(r11, r12);
        if (r14 != null) goto L8;
        return null;
    L8:
        byte[] r15 = (byte[]) ZeusTransformUtils.preCheckCast(r14.first, byte[].class, "com.obric.aiagent.plugin");
        String r16 = (String) ZeusTransformUtils.preCheckCast(r14.second, String.class, "com.obric.aiagent.plugin");
        ArrayList r8 = new ArrayList();
        if (r16 == null) goto L11;
        r8.add(new com.bytedance.retrofit2.b.b(DownloadHelper.CONTENT_ENCODING, r16));
    L11:
        if (r13 != null) goto L13;
    L15:
        LinkedHashMap r6 = new LinkedHashMap();
        Pair<String, String> r17 = l.a(r10, r6);
        if (r17 != null) goto L18;
        return null;
    L18:
        String r18 = (String) ZeusTransformUtils.preCheckCast(r17.first, String.class, "com.obric.aiagent.plugin");
        String r5 = (String) ZeusTransformUtils.preCheckCast(r17.second, String.class, "com.obric.aiagent.plugin");
        INetworkApi r3 = (INetworkApi) ZeusTransformUtils.preCheckCast(com.bytedance.ttnet.utils.d.a(r18, INetworkApi.class), INetworkApi.class, "com.obric.aiagent.plugin");
        if (r3 != null) goto L21;
        return null;
    L21:
        return (String) ZeusTransformUtils.preCheckCast(r3.postBody(r9, r5, r6, new g(null, r15, new String[0]), r8).a().f(), String.class, "com.obric.aiagent.plugin");
    L13:
        if (r13.length() <= 0) goto L15;
        r8.add(new com.bytedance.retrofit2.b.b(DownloadHelper.CONTENT_TYPE, r13));
        goto L15
    }

    public static Pair<byte[], String> a(byte[] r6, i.a r7) {
        String r0 = null;
        if (r6 != null) goto L6;
        new Pair(r6, null);
    L6:
        if (r6 != null) goto L38;
        int r2 = 0;
    L10:
        if (i.a.f6731b != r7) goto L24;
        if (r2 <= 128) goto L24;
        ByteArrayOutputStream r8 = new ByteArrayOutputStream(8192);     // Catch: Throwable -> L32
        GZIPOutputStream r1 = new GZIPOutputStream(r8);     // Catch: Throwable -> L32
        r1.write(r6);     // Catch: Throwable -> L16
        r1.close();     // Catch: Throwable -> L32
        r6 = r8.toByteArray();     // Catch: Throwable -> L32
        r0 = DownloadHelper.GZIP;
    L35:
        return new Pair(r6, r0);
    L16:
        th = move-exception;
        Logger.w(TAG, "compress with gzip exception: " + th);     // Catch: Throwable -> L20
        Pair<byte[], String> r9 = new Pair(r6, null);     // Catch: Throwable -> L20
        r1.close();     // Catch: Throwable -> L32
        return r9;
    L20:
        th = move-exception;
        r1.close();     // Catch: Throwable -> L32
        throw th;     // Catch: Throwable -> L32
    L32:
        th = move-exception;
        th.printStackTrace();
    L24:
        if (i.a.f6732c != r7) goto L35;
        if (r2 <= 128) goto L35;
        ByteArrayOutputStream r10 = new ByteArrayOutputStream(8192);     // Catch: Throwable -> L32
        Deflater r3 = new Deflater();     // Catch: Throwable -> L32
        r3.setInput(r6);     // Catch: Throwable -> L32
        r3.finish();     // Catch: Throwable -> L32
        byte[] r4 = new byte[8192];     // Catch: Throwable -> L32
    L28:
        if (r3.finished() == true) goto L30;
        r10.write(r4, 0, r3.deflate(r4));     // Catch: Throwable -> L32
        goto L28
    L30:
        r3.end();     // Catch: Throwable -> L32
        r6 = r10.toByteArray();     // Catch: Throwable -> L32
        r0 = "deflate";
        goto L35
    L38:
        r2 = r6.length;     // Catch: Throwable -> L32
        goto L10
    }
}
