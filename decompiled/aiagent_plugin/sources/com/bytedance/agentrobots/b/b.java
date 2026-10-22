package com.bytedance.agentrobots.b;

import android.util.Log;
import com.obric.aiagent.apm.impl.BuildConfig;
import com.obric.autogui.effects.VDPlayerEffectProviderImpl;
import com.ss.android.socialbase.downloader.constants.DownloadConstants;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.charset.StandardCharsets;
import java.util.Base64;
import me.ele.lancet.base.annotations.Skip;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: compiled from: AuditFieldEncryptor.java */
/* JADX INFO: loaded from: classes.dex */
public class b {
    private static final String TAG = "AuditFieldEncryptor";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final String[] f4005a = null;

    /* JADX INFO: compiled from: AuditFieldEncryptor.java */
    private static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final byte[] f4006a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final byte[] f4007b;

        a(byte[] r1, byte[] r2) {
            this.f4006a = r1;
            this.f4007b = r2;
        }
    }

    static {
        f4005a = new String[]{"action_args", DownloadConstants.QUERY_KEY};
    }

    public static void a(JSONObject r8) {
        if (r8 != null) goto L5;
        return;
    L5:
        String[] r1 = f4005a;
        int r2 = r1.length;
        int r3 = 0;
    L6:
        if (r3 >= r2) goto L33;
        String r4 = r1[r3];
        if (r8.has(r4) == false) goto L32;
        if (r8.isNull(r4) == true) goto L32;
        String r5 = a(r8, r4);     // Catch: Exception -> L30
        if (r5 == null) goto L32;
        if (r5.isEmpty() == true) goto L32;
        a r6 = a(r5.getBytes(StandardCharsets.UTF_8));     // Catch: Exception -> L30
        if (r6 != null) goto L20;
    L28:
        a(TAG, "encryptSensitiveFields: encrypt failed for " + r4 + ", keeping plaintext");     // Catch: Exception -> L30
        goto L32
    L20:
        if (r6.f4006a == null) goto L28;
        r8.put(r4, Base64.getEncoder().encodeToString(r6.f4006a));     // Catch: Exception -> L30
        if (r6.f4007b != null) goto L25;
    L27:
        a(TAG, "encryptSensitiveFields: missing DEK cipher for " + r4);     // Catch: Exception -> L30
        goto L32
    L25:
        if (r6.f4007b.length <= 0) goto L27;
        r8.put(b(r4), Base64.getEncoder().encodeToString(r6.f4007b));     // Catch: Exception -> L30
    L30:
        e = move-exception;
        a(TAG, "encryptSensitiveFields: failed for " + r4, e);
    L32:
        r3 = r3 + 1;
        goto L6
    }

    public static String b(JSONObject r3) {
        if (r3 != null) goto L10;
        return null;
    L10:
        JSONObject r1 = new JSONObject(r3.toString());     // Catch: Exception -> L7
        c(r1);     // Catch: Exception -> L7
        d(r1);     // Catch: Exception -> L7
        a(r1);     // Catch: Exception -> L7
        return r1.toString();
    L7:
        e = move-exception;
        a(TAG, "encryptFullJson failed", e);
        return null;
    }

    static void c(JSONObject r2) {
        if (r2 != null) goto L4;
        return;
    L4:
        r2.remove(VDPlayerEffectProviderImpl.KEY_THOUGHT);
        a(r2, "agent_decision", VDPlayerEffectProviderImpl.KEY_THOUGHT);
    }

    private static void d(JSONObject r1) {
        if (r1 != null) goto L4;
        return;
    L4:
        r1.remove("query_dek_cipher_base64");
        r1.remove("action_args_dek_cipher_base64");
    }

    static String a(String r1) {
        if (r1 != null) goto L4;
        return r1;
    L4:
        if (r1.isEmpty() == true) goto L12;
        JSONObject r0 = new JSONObject(r1);     // Catch: Exception -> L8
        c(r0);     // Catch: Exception -> L8
        return r0.toString();
    L13:
        return r1;
    L12:
        return r1;
    }

    private static void a(JSONObject r4, String r5, String r6) {
        Object r0 = r4.opt(r5);
        if (ZeusTransformUtils.instanceOf(r0, JSONObject.class) == false) goto L7;
        ((JSONObject) ZeusTransformUtils.preCheckCast(r0, JSONObject.class, "com.obric.aiagent.plugin")).remove(r6);
        return;
    L7:
        if (ZeusTransformUtils.instanceOf(r0, String.class) == true) goto L9;
        return;
    L9:
        if (((String) ZeusTransformUtils.preCheckCast(r0, String.class, "com.obric.aiagent.plugin")).isEmpty() == true) goto L17;
        JSONObject r1 = new JSONObject((String) ZeusTransformUtils.preCheckCast(r0, String.class, "com.obric.aiagent.plugin"));     // Catch: Exception -> L13
        r1.remove(r6);     // Catch: Exception -> L13
        r4.put(r5, r1.toString());     // Catch: Exception -> L13
        return;
    L18:
        return;
    }

    private static String a(JSONObject r1, String r2) {
        Object r3 = r1.get(r2);
        if (ZeusTransformUtils.instanceOf(r3, JSONObject.class) == false) goto L7;
        return ((JSONObject) ZeusTransformUtils.preCheckCast(r3, JSONObject.class, "com.obric.aiagent.plugin")).toString();
    L7:
        if (ZeusTransformUtils.instanceOf(r3, JSONArray.class) == false) goto L11;
        return ((JSONArray) ZeusTransformUtils.preCheckCast(r3, JSONArray.class, "com.obric.aiagent.plugin")).toString();
    L11:
        return r3.toString();
    }

    private static a a(byte[] r6) {
        ByteArrayInputStream r2 = new ByteArrayInputStream(r6);     // Catch: Exception -> L12
        ByteArrayOutputStream r3 = new ByteArrayOutputStream();     // Catch: Exception -> L12
        Object r4 = a();     // Catch: Exception -> L12
        Object r7 = a(r4, r6, r2, r3);     // Catch: Exception -> L12
        if (ZeusTransformUtils.instanceOf(r7, Number.class) == false) goto L6;
        int r8 = ((Number) ZeusTransformUtils.preCheckCast(r7, Number.class, "com.obric.aiagent.plugin")).intValue();     // Catch: Exception -> L12
    L7:
        if (r8 == 0) goto L10;
        b(TAG, "EnvelopeCrypto encrypt failed: " + r8);     // Catch: Exception -> L12
        return null;
    L10:
        byte[] r9 = r3.toByteArray();     // Catch: Exception -> L12
        return new a(r9, a(r4, r9));
    L6:
        r8 = -1;
    L12:
        e = move-exception;
        b(TAG, "EnvelopeCrypto encrypt exception", e);
        return null;
    }

    private static byte[] a(Object r7, byte[] r8) {
        if (r7 == null) goto L15;
        if (r8 == null) goto L15;
        if (r8.length == 0) goto L15;
        Object r9 = r7.getClass().getMethod("extractDEKCipher", new Class[]{InputStream.class}).invoke(r7, new Object[]{new ByteArrayInputStream(r8)});     // Catch: Exception -> L13
        if ((r9 instanceof byte[]) == false) goto L18;
        return (byte[]) ZeusTransformUtils.preCheckCast(r9, byte[].class, "com.obric.aiagent.plugin");
    L18:
        return null;
    L13:
        e = move-exception;
        b(TAG, "EnvelopeCrypto extractDEKCipher exception", e);
    L15:
        return null;
    }

    private static String b(String r1) {
        if (DownloadConstants.QUERY_KEY.equals(r1) == false) goto L7;
        return "query_dek_cipher_base64";
    L7:
        if ("action_args".equals(r1) == false) goto L11;
        return "action_args_dek_cipher_base64";
    L11:
        return r1 + "_dek_cipher_base64";
    }

    private static Object a(Object r15, byte[] r16, ByteArrayInputStream r17, ByteArrayOutputStream r18) {
        return r15.getClass().getMethod("encrypt", new Class[]{byte[].class, byte[].class, Long.TYPE, InputStream.class, OutputStream.class}).invoke(r15, new Object[]{b(), "ocean_securityserver".getBytes(StandardCharsets.UTF_8), Long.valueOf(r16.length), r17, r18});
    L6:
        return r15.getClass().getMethod("encrypt", new Class[]{byte[].class, byte[].class, Integer.TYPE, InputStream.class, OutputStream.class}).invoke(r15, new Object[]{b(), "ocean_securityserver".getBytes(StandardCharsets.UTF_8), Integer.valueOf(r16.length), r17, r18});
    }

    private static Object a() {
        Object r0 = ZeusTransformUtils.forName("com.bytedance.crypto.envelope.EnvelopeCrypto", "com.obric.aiagent.plugin").getMethod("getInstance", new Class[0]).invoke(null, new Object[0]);
        if (r0 == null) goto L6;
        return r0;
    L6:
        throw new IllegalStateException("EnvelopeCrypto.getInstance() returned null");
    }

    private static byte[] b() {
        return Base64.getDecoder().decode("MFkwEwYHKoZIzj0CAQYIKoZIzj0DAQcDQgAEUDCNTMDYvo3NzYph0tzWV8yhMo51ICoUNIgv7HwRMvs638BLpQoihcT8Mf/r0vsfm3zPHlSnig5NsbgSkSqOZw==");
    L4:
        e = move-exception;
        a(TAG, "resolveBizPubkey: invalid Base64", e);
        return new byte[0];
    }

    @Skip({BuildConfig.LIBRARY_PACKAGE_NAME})
    public static int a(String r1, String r2) {
        if (com.obric.aiagent.apm.impl.a.a() == false) goto L5;
        return 0;
    L5:
        return Log.w(r1, r2);
    }

    @Skip({BuildConfig.LIBRARY_PACKAGE_NAME})
    public static int a(String r1, String r2, Throwable r3) {
        if (com.obric.aiagent.apm.impl.a.a() == false) goto L5;
        return 0;
    L5:
        return Log.w(r1, r2, r3);
    }

    @Skip({BuildConfig.LIBRARY_PACKAGE_NAME})
    public static int b(String r0, String r1) {
        return Log.e(r0, r1);
    }

    @Skip({BuildConfig.LIBRARY_PACKAGE_NAME})
    public static int b(String r0, String r1, Throwable r2) {
        return Log.e(r0, r1, r2);
    }
}
