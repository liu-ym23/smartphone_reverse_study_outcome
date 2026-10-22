package com.bytedance.crypto.platform;

import android.content.Context;
import com.bytedance.crypto.fekwrap.FekWrapErrorCode;
import com.bytedance.crypto.fekwrap.FekWrapResult;
import com.bytedance.crypto.modeldist.ModelDistConst;
import com.bytedance.crypto.obfuscated.b;
import com.bytedance.crypto.obfuscated.c;
import com.bytedance.crypto.obfuscated.d;
import com.bytedance.crypto.obfuscated.h;
import com.bytedance.crypto.obfuscated.l;
import com.bytedance.crypto.utils.LogUtils;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Arrays;

/* JADX INFO: loaded from: classes.dex */
public class PlatKeyManager {
    private static final byte[] EMPTY_BYTES = null;
    private static final String TAG = "PlatKeyManager";
    private static volatile PlatKeyManager platKeyManager;

    static {
        EMPTY_BYTES = new byte[0];
    }

    private PlatKeyManager() {
    }

    private static String buildExternalDeviceKeyAlias(String r1) {
        if (isEmpty(r1) == false) goto L7;
        return null;
    L7:
        return r1 + "-" + ModelDistConst.EXTERNAL_DEVICE_KEY_ALIAS;
    }

    public static PlatKeyManager getInstance() {
        if (platKeyManager != null) goto L15;
        monitor-enter(PlatKeyManager.class);
    L11:
        th = move-exception;
        throw th;
    L7:
        if (platKeyManager != null) goto L9;
        platKeyManager = new PlatKeyManager();     // Catch: Throwable -> L11
    L9:
        monitor-exit(PlatKeyManager.class);     // Catch: Throwable -> L11
    L15:
        return platKeyManager;
    }

    private static boolean isEmpty(String r0) {
        if (r0 != null) goto L4;
    L7:
        return true;
    L4:
        if (r0.isEmpty() == true) goto L7;
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r6v13 */
    /* JADX WARN: Type inference failed for: r6v23 */
    /* JADX WARN: Type inference failed for: r6v5 */
    /* JADX WARN: Type inference failed for: r6v6, types: [byte[]] */
    public FekWrapResult decryptAndWrapFEK(Context r6, String r7, int r8, String r9) {
        Context r5 = (Context) ZeusTransformUtils.wrapperContextForParams(r6, Context.class, "com.obric.aiagent.plugin");
        byte[] r10 = h.a();
        r10.getClass();
        if (r9 != null) goto L5;
    L6:
        r9 = "secure_loader_model_wrap_key";
    L7:
        byte[] r1 = null;
        if (r5 == null) goto L23;
        if (r7 == null) goto L23;
    L21:
        IllegalArgumentException e2 = e;
        r10 = 0;
    L61:
        LogUtils.e("PlatKeyManagerImpl", "decryptAndWrapFEK encode failed: " + e2.getMessage());     // Catch: Throwable -> L67
        FekWrapResult r11 = h.a(FekWrapErrorCode.SLFK_BLOB_ENCODE_FAILED, r9);     // Catch: Throwable -> L67
        if (r1 == null) goto L64;
        Arrays.fill(r1, (byte) 0);
    L64:
        if (r10 == 0) goto L73;
        Arrays.fill(r10, (byte) 0);
    L73:
        return r11;
    L19:
        Exception e3 = e;
        r10 = 0;
    L56:
        LogUtils.e("PlatKeyManagerImpl", "decryptAndWrapFEK failed: " + e3.getMessage());     // Catch: Throwable -> L67
        r11 = h.a(-100, r9);     // Catch: Throwable -> L67
        if (r1 == null) goto L59;
        Arrays.fill(r1, (byte) 0);
    L59:
        if (r10 == 0) goto L73;
        Arrays.fill(r10, (byte) 0);
    L17:
        th = th;
        r10 = 0;
    L68:
        if (r1 == null) goto L70;
        Arrays.fill(r1, (byte) 0);
    L70:
        if (r10 == 0) goto L72;
        Arrays.fill(r10, (byte) 0);
    L72:
        throw th;
    L11:
        if (r7.isEmpty() == true) goto L23;
        if (c.a(r9) == false) goto L23;
        int r3 = 0;
    L24:
        if (r3 != 0) goto L78;
        h.a r12 = r10.a(r5, r7, r8);     // Catch: Throwable -> L17 Exception -> L19 IllegalArgumentException -> L21
        int r13 = r12.f7857a;     // Catch: Throwable -> L17 Exception -> L19 IllegalArgumentException -> L21
        if (r13 != 0) goto L79;
        byte[] r14 = r12.f7858b;     // Catch: Throwable -> L17 Exception -> L19 IllegalArgumentException -> L21
        if (r14 == null) goto L46;
    L54:
        e = move-exception;
        r1 = r14;
        e2 = e;
        r10 = 0;
    L52:
        e = move-exception;
        r1 = r14;
        e3 = e;
        r10 = 0;
    L50:
        th = move-exception;
        r1 = r14;
        th = th;
        r10 = 0;
        goto L68
    L32:
        if (r14.length != 32) goto L46;
        byte[] r2 = l.a(1, r9);     // Catch: Throwable -> L50 Exception -> L52 IllegalArgumentException -> L54
        b.a r15 = b.a(r9, r14, r2);     // Catch: Throwable -> L50 Exception -> L52 IllegalArgumentException -> L54
        int r16 = r15.f7839a;     // Catch: Throwable -> L50 Exception -> L52 IllegalArgumentException -> L54
        if (r16 == 0) goto L40;
        FekWrapResult r17 = h.a(r16, r9);     // Catch: Throwable -> L50 Exception -> L52 IllegalArgumentException -> L54
        Arrays.fill(r14, (byte) 0);
        if (r2 == null) goto L81;
        Arrays.fill(r2, (byte) 0);
    L81:
        return r17;
    L40:
        FekWrapResult r18 = new FekWrapResult(0, r9, l.a(1, r15.f7840b, r15.f7841c));     // Catch: Throwable -> L50 Exception -> L52 IllegalArgumentException -> L54
        Arrays.fill(r14, (byte) 0);
        if (r2 == null) goto L80;
        Arrays.fill(r2, (byte) 0);
    L80:
        return r18;
    L46:
        r17 = h.a(FekWrapErrorCode.FEK_RECOVER_INVALID_LENGTH, r9);     // Catch: Throwable -> L50 Exception -> L52 IllegalArgumentException -> L54
        if (r14 == null) goto L81;
        Arrays.fill(r14, (byte) 0);
        goto L81
    L79:
        return h.a(r13, r9);
    L78:
        return h.a(r3, r9);
    L23:
        r3 = -2;
    L67:
        th = th;
        goto L68
    L5:
        if (r9.isEmpty() == false) goto L7;
        goto L6
    }

    public int decryptModelFile(Context r2, InputStream r3, OutputStream r4, String r5) {
        Context r1 = (Context) ZeusTransformUtils.wrapperContextForParams(r2, Context.class, "com.obric.aiagent.plugin");
        h.a().getClass();
        return d.a().a(r1, r3, r4, r5);
    }

    public int decryptModelFileV2(Context r2, InputStream r3, OutputStream r4, String r5, String r6) {
        Context r1 = (Context) ZeusTransformUtils.wrapperContextForParams(r2, Context.class, "com.obric.aiagent.plugin");
        String r7 = buildExternalDeviceKeyAlias(r6);
        if (r7 != null) goto L6;
        LogUtils.e(TAG, "secAppId is null or empty");
        return -2;
    L6:
        h.a().getClass();
        d.a().getClass();
        if (r1 == null) goto L17;
        if (r3 == null) goto L17;
        if (r4 == null) goto L17;
        if (r5 == null) goto L17;
        if (r5.isEmpty() == true) goto L17;
        if (r7.isEmpty() == true) goto L17;
        return c.a(r1, r3, r4, r5, r7);
    L17:
        LogUtils.e("ModelDistributionManagerImpl", "Invalid input params.");
        return -2;
    }

    public String reEncryptFEK(Context r2, String r3, int r4) {
        Context r1 = (Context) ZeusTransformUtils.wrapperContextForParams(r2, Context.class, "com.obric.aiagent.plugin");
        return h.a().a(r1, r3, r4, ModelDistConst.EXTERNAL_DEVICE_KEY_ALIAS);
    }

    public String reEncryptFEKV2(Context r2, String r3, int r4, String r5) {
        Context r1 = (Context) ZeusTransformUtils.wrapperContextForParams(r2, Context.class, "com.obric.aiagent.plugin");
        if (isEmpty(r5) == false) goto L7;
        return null;
    L7:
        return h.a().a(r1, r3, r4, buildExternalDeviceKeyAlias(r5));
    }

    public byte[] decryptModelFile(Context r2, InputStream r3, String r4) {
        Context r1 = (Context) ZeusTransformUtils.wrapperContextForParams(r2, Context.class, "com.obric.aiagent.plugin");
        h.a().getClass();
        d.a().getClass();
        if (r1 == null) goto L10;
        if (r3 == null) goto L10;
        if (r4 == null) goto L10;
        if (r4.isEmpty() == true) goto L10;
        return c.a(r1, r3, r4, ModelDistConst.EXTERNAL_DEVICE_KEY_ALIAS);
    L10:
        LogUtils.e("ModelDistributionManagerImpl", "Invalid input params.");
        return new byte[0];
    }

    public byte[] decryptModelFileV2(Context r2, InputStream r3, String r4, String r5) {
        Context r1 = (Context) ZeusTransformUtils.wrapperContextForParams(r2, Context.class, "com.obric.aiagent.plugin");
        String r6 = buildExternalDeviceKeyAlias(r5);
        if (r6 != null) goto L6;
        LogUtils.e(TAG, "secAppId is null or empty");
        return EMPTY_BYTES;
    L6:
        h.a().getClass();
        d.a().getClass();
        if (r1 == null) goto L16;
        if (r3 == null) goto L16;
        if (r4 == null) goto L16;
        if (r4.isEmpty() == true) goto L16;
        if (r6.isEmpty() == true) goto L16;
        return c.a(r1, r3, r4, r6);
    L16:
        LogUtils.e("ModelDistributionManagerImpl", "Invalid input params.");
        return new byte[0];
    }
}
