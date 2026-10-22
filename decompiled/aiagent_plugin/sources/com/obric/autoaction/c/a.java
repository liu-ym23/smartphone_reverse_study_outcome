package com.obric.autoaction.c;

import com.bytedance.crypto.utils.CryptoConst;
import com.bytedance.security.zenmobile.io.SensitiveType;
import com.obric.autogui.common.api.logging.LogUtil;
import com.obric.autogui.common.api.logging.Loog;
import com.obric.autogui.common.b.b;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.h.b.o;
import d.o.d;
import java.security.Key;
import java.security.MessageDigest;
import java.security.spec.AlgorithmParameterSpec;
import java.util.Base64;
import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.spec.GCMParameterSpec;
import javax.crypto.spec.SecretKeySpec;

/* JADX INFO: compiled from: DebugPasscodeVerifier.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f24620a = null;

    static {
        f24620a = new a();
    }

    private a() {
    }

    private final String a(String r6, SecretKey r7) {
        SecretKey r5 = (SecretKey) ZeusTransformUtils.wrapperContextForParams(r7, SecretKey.class, "com.obric.aiagent.plugin");
        Cipher r8 = Cipher.getInstance("AES/GCM/NoPadding");
        byte[] r9 = Base64.getDecoder().decode(r6);
        byte[] r2 = new byte[12];
        System.arraycopy(r9, 0, r2, 0, 12);
        GCMParameterSpec r3 = new GCMParameterSpec(128, r2);
        r8.init(2, (Key) ZeusTransformUtils.preCheckCast(r5, Key.class, "com.obric.aiagent.plugin"), (AlgorithmParameterSpec) ZeusTransformUtils.preCheckCast(r3, AlgorithmParameterSpec.class, "com.obric.aiagent.plugin"));
        byte[] r10 = r8.doFinal(r9, 12, r9.length - 12);
        o.a(r10);
        return new String(r10, d.f38623b);
    }

    private final SecretKey b(String r2) {
        MessageDigest r1 = MessageDigest.getInstance("SHA-256");
        byte[] r3 = r2.getBytes(d.f38623b);
        o.c(r3, "getBytes(...)");
        return (SecretKey) ZeusTransformUtils.preCheckCast(new SecretKeySpec(r1.digest(r3), CryptoConst.ALGORITHM_AES), SecretKey.class, "com.obric.aiagent.plugin");
    }

    public final boolean a(String r4) {
        o.e(r4, SensitiveType.PASSWORD);
        return o.a(a("c+NAla6K2Rdai6WWbz90dzOvW3JlJJ+FM8/ZVmDR0KCGl0taxj+uPwYcxz7/G5okow==", b(r4)), "AuthenticationSuccess");
    L5:
        th = move-exception;
        if (b.f29001a.a() == false) goto L9;
        Loog.INSTANCE.e(LogUtil.INSTANCE.getCLAZZ_TAG(this), "password verification failed: " + th, th);
    L9:
        return false;
    }
}
