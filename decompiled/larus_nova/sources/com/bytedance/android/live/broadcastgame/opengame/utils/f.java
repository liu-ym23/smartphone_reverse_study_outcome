package com.bytedance.android.live.broadcastgame.opengame.utils;

import android.util.Base64;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.common.utility.DigestUtils;
import com.bytedance.crypto.utils.CryptoConst;
import java.nio.charset.Charset;
import java.security.MessageDigest;
import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import kotlin.text.Charsets;

/* JADX INFO: loaded from: classes45.dex */
public final class f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f61156a = 0;

    static {
    }

    public static String a(String r110) {
        Intrinsics.checkNotNullParameter(r110, "roomId");
        StringBuilder r100 = new StringBuilder();
        int r101 = RangesKt.coerceAtLeast(32, r110.length());
        int r102 = 1;
        int r103 = 1;
    L3:
        if (r102 > r101) goto L38;
        String r104 = "";
        if (r102 > 32) goto L7;
        String r105 = "7f5fb48cb16bac939c1ac077077d8ad8".substring(r102 - 1, RangesKt.coerceAtMost(32, (r102 * 2) - 1));
    L9:
        if (r102 > r110.length()) goto L11;
        r104 = r110.substring(r102 - 1, RangesKt.coerceAtMost(r110.length(), (r102 * 2) - 1));
    L11:
        boolean r106 = false;
        if ((r103 % 2) != 1) goto L26;
        if (r104.length() <= 0) goto L16;
        boolean r107 = true;
    L17:
        if (r107 == false) goto L20;
        r100.insert(0, r104);
    L20:
        if (r105.length() <= 0) goto L22;
        boolean r108 = true;
    L23:
        if (r108 == false) goto L36;
        r100.insert(0, r105);
    L36:
        r103 = r103 + 1;
        r102 = r102 * 2;
        goto L3
    L22:
        r108 = false;
        goto L23
    L16:
        r107 = false;
        goto L17
    L26:
        if (r105.length() <= 0) goto L28;
        boolean r109 = true;
    L29:
        if (r109 == false) goto L32;
        r100.append(r105);
    L32:
        if (r104.length() <= 0) goto L34;
        r106 = true;
    L34:
        if (r106 == false) goto L36;
        r100.append(r104);
        goto L36
    L28:
        r109 = false;
        goto L29
    L7:
        r105 = "";
        goto L9
    L38:
        return DigestUtils.md5Hex(r100.toString());
    }

    public static String b(String r100, long r101, String r102) {
        Intrinsics.checkNotNullParameter(r100, "cipherText");
        Intrinsics.checkNotNullParameter(r102, "crypt");
        byte[] r103 = Base64.decode(r100, 0);     // Catch: Exception -> L9
        IvParameterSpec r104 = new IvParameterSpec(DigestUtils.hexStringToBytes(a(String.valueOf(r101))));     // Catch: Exception -> L9
        byte[] r105 = Base64.decode(r102, 0);     // Catch: Exception -> L9
        Charset r106 = Charsets.UTF_8;     // Catch: Exception -> L9
        String r107 = new String(r105, r106).concat(new String(Base64.decode("OGJjNmMyYWFhOWE5ZjE3ZDlkZTllY2E1OTZkOTA3ZjI=", 0), r106));     // Catch: Exception -> L9
        MessageDigest r108 = MessageDigest.getInstance("MD5");     // Catch: Exception -> L9
        if (r107 == null) goto L8;
        SecretKeySpec r109 = new SecretKeySpec(r108.digest(r107.getBytes(r106)), CryptoConst.ALGORITHM_AES);     // Catch: Exception -> L9
        Cipher r110 = Cipher.getInstance("AES/CBC/PKCS5Padding");     // Catch: Exception -> L9
        r110.init(2, r109, r104);     // Catch: Exception -> L9
        return new String(r110.doFinal(r103), r106);
    L8:
        throw new NullPointerException("null cannot be cast to non-null type java.lang.String");     // Catch: Exception -> L9
    L9:
        e = move-exception;
        e.printStackTrace();
        ALogger.e("OPEN_LIVE_GAME", "DecryptUtil.decrypt() :\n " + e);
        return null;
    }
}
