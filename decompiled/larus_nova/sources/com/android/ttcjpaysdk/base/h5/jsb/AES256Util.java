package com.android.ttcjpaysdk.base.h5.jsb;

import android.util.Base64;
import com.android.ttcjpaysdk.base.utils.CJBasicCommonUtils;
import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Charsets;

/* JADX INFO: loaded from: classes28.dex */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0012\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\b\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u001c\u0010\u0012\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0013\u001a\u00020\u00072\b\u0010\u0014\u001a\u0004\u0018\u00010\u0004H\u0002J\u0012\u0010\u0012\u001a\u0004\u0018\u00010\u00042\b\u0010\u0014\u001a\u0004\u0018\u00010\u0004J\u001a\u0010\u0015\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0013\u001a\u00020\u00072\u0006\u0010\u0014\u001a\u00020\u0004H\u0002J\u0010\u0010\u0015\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0014\u001a\u00020\u0004R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R#\u0010\u0006\u001a\n \b*\u0004\u0018\u00010\u00070\u00078BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u000b\u0010\f\u001a\u0004\b\t\u0010\nR\u001b\u0010\r\u001a\u00020\u000e8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0011\u0010\f\u001a\u0004\b\u000f\u0010\u0010¨\u0006\u0016"}, d2 = {"Lcom/android/ttcjpaysdk/base/h5/jsb/AES256Util;", "", "()V", "AES", "", "CIPHER_ALGORITHM", "DEFAULT_SECRET_KEY", "", "kotlin.jvm.PlatformType", "getDEFAULT_SECRET_KEY", "()[B", "DEFAULT_SECRET_KEY$delegate", "Lkotlin/Lazy;", "KEY_VI", "Ljavax/crypto/spec/IvParameterSpec;", "getKEY_VI", "()Ljavax/crypto/spec/IvParameterSpec;", "KEY_VI$delegate", "decode", "key", "content", "encode", "base-context_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class AES256Util {
    private static final String AES = "AES";
    private static final String CIPHER_ALGORITHM = "AES/CBC/PKCS5Padding";
    private static final Lazy DEFAULT_SECRET_KEY$delegate = null;
    public static final AES256Util INSTANCE = null;
    private static final Lazy KEY_VI$delegate = null;

    private AES256Util() {
    }

    static {
        INSTANCE = new AES256Util();
        DEFAULT_SECRET_KEY$delegate = LazyKt.lazy(AES256Util$DEFAULT_SECRET_KEY$2.INSTANCE);
        KEY_VI$delegate = LazyKt.lazy(AES256Util$KEY_VI$2.INSTANCE);
    }

    private final byte[] getDEFAULT_SECRET_KEY() {
        return (byte[]) DEFAULT_SECRET_KEY$delegate.getValue();
    }

    private final IvParameterSpec getKEY_VI() {
        return (IvParameterSpec) KEY_VI$delegate.getValue();
    }

    public final String decode(String r100) {
        return decode(getDEFAULT_SECRET_KEY(), r100);
    }

    public final String encode(String r100) {
        Intrinsics.checkNotNullParameter(r100, "content");
        return encode(getDEFAULT_SECRET_KEY(), r100);
    }

    private final String decode(byte[] r100, String r101) {
        SecretKeySpec r102 = new SecretKeySpec(r100, "AES");     // Catch: Exception -> L4
        Cipher r103 = Cipher.getInstance(CIPHER_ALGORITHM);     // Catch: Exception -> L4
        r103.init(2, r102, getKEY_VI());     // Catch: Exception -> L4
        return new String(r103.doFinal(Base64.decode(r101, 2)), Charsets.UTF_8);
    L4:
        e = move-exception;
        CJBasicCommonUtils.reportCatchException("JSBMediaUtil#decode", e);
        CJBasicCommonUtils.logCatch("CJCatch", "JSBMediaUtil#decode", e);
        e.printStackTrace();
        return null;
    }

    private final String encode(byte[] r100, String r101) {
        SecretKeySpec r102 = new SecretKeySpec(r100, "AES");     // Catch: Exception -> L4
        Cipher r103 = Cipher.getInstance(CIPHER_ALGORITHM);     // Catch: Exception -> L4
        r103.init(1, r102, getKEY_VI());     // Catch: Exception -> L4
        return Base64.encodeToString(r103.doFinal(r101.getBytes(Charsets.UTF_8)), 2);
    L4:
        e = move-exception;
        CJBasicCommonUtils.reportCatchException("JSBMediaUtil#encode", e);
        CJBasicCommonUtils.logCatch("CJCatch", "JSBMediaUtil#encode", e);
        e.printStackTrace();
        return null;
    }
}
