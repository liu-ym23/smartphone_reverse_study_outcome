package com.bytedance.bdturing.setting;

import android.os.Build;
import com.bytedance.crypto.utils.CryptoConst;
import com.obric.capabilitykit.entity.app.EntityType;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.a.i;
import d.h.b.o;
import d.m;
import d.o.ab;
import d.t;
import d.x;
import java.io.ByteArrayInputStream;
import java.io.Closeable;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.nio.charset.Charset;
import java.security.Key;
import java.security.MessageDigest;
import java.security.spec.AlgorithmParameterSpec;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.zip.GZIPInputStream;
import javax.crypto.Cipher;
import javax.crypto.spec.GCMParameterSpec;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import org.json.JSONObject;

/* JADX INFO: compiled from: SettingUpdateRequest.kt */
/* JADX INFO: loaded from: classes.dex */
public final class g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final String f6606a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final Map<String, String> f6607b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final a f6608c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final com.bytedance.bdturing.ttnet.b f6609d;

    /* JADX INFO: compiled from: SettingUpdateRequest.kt */
    public interface a {
        void a(int r1, String r2, long r3);
    }

    public g(String r3, Map<String, String> r4, a r5, com.bytedance.bdturing.ttnet.b r6) {
        Map<String, String> r7 = (Map) ZeusTransformUtils.wrapperContextForParams(r4, Map.class, "com.obric.aiagent.plugin");
        a r8 = (a) ZeusTransformUtils.wrapperContextForParams(r5, a.class, "com.obric.aiagent.plugin");
        com.bytedance.bdturing.ttnet.b r9 = (com.bytedance.bdturing.ttnet.b) ZeusTransformUtils.wrapperContextForParams(r6, com.bytedance.bdturing.ttnet.b.class, "com.obric.aiagent.plugin");
        o.d(r3, "mUrl");
        o.d(r7, "params");
        o.d(r8, "mCallback");
        o.d(r9, "mHttpClient");
        this.f6606a = r3;
        this.f6607b = r7;
        this.f6608c = r8;
        this.f6609d = r9;
    }

    private final m<String, String> b() {
        d.k.c r3 = d.k.d.a(System.nanoTime());
        return new m(ab.a(d.k.e.a(r3), 16), ab.a(d.k.e.a(r3), 16));
    }

    public final void a() {
        long r1 = System.currentTimeMillis();
        String r3 = "";
        byte[] r6 = (byte[]) ZeusTransformUtils.preCheckCast(null, byte[].class, "com.obric.aiagent.plugin");
        byte[] r4 = (byte[]) ZeusTransformUtils.preCheckCast(null, byte[].class, "com.obric.aiagent.plugin");
        m<String, String> r5 = b();
        this.f6607b.put("key", r5.a());
        this.f6607b.put("iv", r5.b());
        m<byte[], byte[]> r7 = a((String) ZeusTransformUtils.preCheckCast(r5.a(), String.class, "com.obric.aiagent.plugin"), (String) ZeusTransformUtils.preCheckCast(r5.b(), String.class, "com.obric.aiagent.plugin"));
        byte[] r8 = (byte[]) ZeusTransformUtils.preCheckCast(r7.a(), byte[].class, "com.obric.aiagent.plugin");
        byte[] r0 = (byte[]) ZeusTransformUtils.preCheckCast(r7.b(), byte[].class, "com.obric.aiagent.plugin");
        String r9 = new JSONObject(this.f6607b).toString();     // Catch: Throwable -> L13 Exception -> L15
        o.b(r9, "JSONObject(params).toString()");     // Catch: Throwable -> L13 Exception -> L15
        Map<String, String> r10 = (Map) ZeusTransformUtils.preCheckCast(new LinkedHashMap(), Map.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L13 Exception -> L15
        r10.put("Content-type", "application/json;tt-data=g");     // Catch: Throwable -> L13 Exception -> L15
        com.bytedance.bdturing.ttnet.b r11 = this.f6609d;     // Catch: Throwable -> L13 Exception -> L15
        String r12 = this.f6606a;     // Catch: Throwable -> L13 Exception -> L15
        Charset r13 = d.o.d.f38623b;     // Catch: Throwable -> L13 Exception -> L15
        if (r9 == null) goto L12;
        byte[] r14 = r9.getBytes(r13);     // Catch: Throwable -> L13 Exception -> L15
        o.b(r14, "(this as java.lang.String).getBytes(charset)");     // Catch: Throwable -> L13 Exception -> L15
        byte[] r15 = r11.post(r12, r10, r14);     // Catch: Throwable -> L13 Exception -> L15
        if (r15 != null) goto L8;
    L10:
        int r16 = EntityType.SIM_CARD;
    L18:
        this.f6608c.a(r16, r3, System.currentTimeMillis() - r1);
        return;
    L8:
        if (r15.length <= 0) goto L10;
        r16 = 200;
        r3 = a(r8, r0, (InputStream) ZeusTransformUtils.preCheckCast(new ByteArrayInputStream(r15), InputStream.class, "com.obric.aiagent.plugin"));     // Catch: Throwable -> L13 Exception -> L15
        goto L18
    L12:
        throw new t("null cannot be cast to non-null type java.lang.String");     // Catch: Throwable -> L13 Exception -> L15
    L15:
        e = move-exception;
        r16 = 500;
        e.printStackTrace();     // Catch: Throwable -> L13
    L13:
        th = move-exception;
        this.f6608c.a(-1, "", System.currentTimeMillis() - r1);
        throw th;
    }

    private final m<byte[], byte[]> a(String r4, String r5) {
        MessageDigest r3 = MessageDigest.getInstance("SHA-256");
        Charset r0 = d.o.d.f38623b;
        if (r4 == null) goto L15;
        byte[] r6 = r4.getBytes(r0);
        o.b(r6, "(this as java.lang.String).getBytes(charset)");
        byte[] r7 = r3.digest(r6);
        MessageDigest r8 = MessageDigest.getInstance(CryptoConst.ALGORITHM_MD5);
        Charset r2 = d.o.d.f38623b;
        if (r5 == null) goto L13;
        byte[] r9 = r5.getBytes(r2);
        o.b(r9, "(this as java.lang.String).getBytes(charset)");
        byte[] r10 = r8.digest(r9);
        if (r10 == null) goto L9;
        byte[] r11 = i.a(r10, 0, 12);
    L11:
        return new m(r7, r11);
    L9:
        r11 = null;
        goto L11
    L13:
        throw new t("null cannot be cast to non-null type java.lang.String");
    L15:
        throw new t("null cannot be cast to non-null type java.lang.String");
    }

    private final String a(byte[] r4, byte[] r5, InputStream r6) {
        if (Build.VERSION.SDK_INT < 19) goto L19;
        if (r4 == null) goto L17;
        if (r5 == null) goto L17;
        SecretKeySpec r3 = new SecretKeySpec(r4, CryptoConst.ALGORITHM_AES);
        GCMParameterSpec r1 = new GCMParameterSpec(128, new IvParameterSpec(r5).getIV());
        Cipher r7 = Cipher.getInstance("AES/GCM/NoPadding");
        r7.init(2, (Key) ZeusTransformUtils.preCheckCast(r3, Key.class, "com.obric.aiagent.plugin"), (AlgorithmParameterSpec) ZeusTransformUtils.preCheckCast(r1, AlgorithmParameterSpec.class, "com.obric.aiagent.plugin"));
        Closeable r8 = (Closeable) ZeusTransformUtils.preCheckCast(new GZIPInputStream((InputStream) ZeusTransformUtils.preCheckCast(new ByteArrayInputStream(r7.doFinal(d.f.b.a(r6))), InputStream.class, "com.obric.aiagent.plugin")), Closeable.class, "com.obric.aiagent.plugin");
        Throwable r9 = (Throwable) ZeusTransformUtils.preCheckCast(null, Throwable.class, "com.obric.aiagent.plugin");
        String r10 = d.f.t.a((Reader) ZeusTransformUtils.preCheckCast(new InputStreamReader((InputStream) ZeusTransformUtils.preCheckCast((GZIPInputStream) ZeusTransformUtils.preCheckCast(r8, GZIPInputStream.class, "com.obric.aiagent.plugin"), InputStream.class, "com.obric.aiagent.plugin")), Reader.class, "com.obric.aiagent.plugin"));     // Catch: Throwable -> L11
        x r11 = x.f38692a;     // Catch: Throwable -> L11
        d.f.c.a(r8, r9);
        return r10;
    L11:
        th = move-exception;
        throw th;     // Catch: Throwable -> L13
    L13:
        th = move-exception;
        d.f.c.a(r8, th);
        throw th;
    L17:
        return d.f.t.a((Reader) ZeusTransformUtils.preCheckCast(new InputStreamReader(r6), Reader.class, "com.obric.aiagent.plugin"));
    L19:
        throw ((Throwable) ZeusTransformUtils.preCheckCast(new SecurityException("Below Android 4.4 or API 19 is not supported."), Throwable.class, "com.obric.aiagent.plugin"));
    }
}
