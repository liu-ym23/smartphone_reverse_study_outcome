package com.bytedance.android.livesdkapi.roomplayer;

import android.util.Base64;
import com.alipay.sdk.m.n.a;
import com.bytedance.android.live.player.utils.b;
import com.bytedance.crypto.utils.CryptoConst;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import java.nio.charset.Charset;
import java.util.List;
import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.text.Charsets;
import kotlin.text.StringsKt;
import kotlin.text.Typography;

/* JADX INFO: loaded from: classes12.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010\u0012\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u001c\u0010\u0006\u001a\u00020\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u00042\b\u0010\b\u001a\u0004\u0018\u00010\u0004H\u0002J\u001a\u0010\t\u001a\u00020\u00042\b\u0010\n\u001a\u0004\u0018\u00010\u00042\b\u0010\u000b\u001a\u0004\u0018\u00010\fJ\u001a\u0010\r\u001a\u00020\u00042\b\u0010\u000e\u001a\u0004\u0018\u00010\u00042\b\u0010\u000f\u001a\u0004\u0018\u00010\u0004J\u001a\u0010\u0010\u001a\u00020\u00042\b\u0010\u0011\u001a\u0004\u0018\u00010\u00042\b\u0010\u000f\u001a\u0004\u0018\u00010\u0004J&\u0010\u0012\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00140\u00132\b\u0010\u0011\u001a\u0004\u0018\u00010\u00042\b\u0010\u000f\u001a\u0004\u0018\u00010\u0004R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000¨\u0006\u0015"}, d2 = {"Lcom/bytedance/android/livesdkapi/roomplayer/AESDecryptLiveUrlUtils;", "", "()V", "PREFIX", "", "SPLIT", "build", "url", "params", "decryptAes", "encryptedData", "key", "", "getDecryptPullStreamData", "streamData", "encryptKey", "getDecryptPullUrl", "pullUrl", "getDecryptPullUrlWithResult", "Lkotlin/Pair;", "", "live-player-api_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class AESDecryptLiveUrlUtils {
    public static final AESDecryptLiveUrlUtils INSTANCE = null;
    public static final String PREFIX = "openCipher";
    public static final String SPLIT = "liveEncryptSplit";

    private AESDecryptLiveUrlUtils() {
    }

    static {
        INSTANCE = new AESDecryptLiveUrlUtils();
    }

    private final String build(String r110, String r111) {
        if (r110 != null) goto L5;
    L8:
        boolean r100 = true;
    L9:
        if (r100 == false) goto L14;
        if (r111 != null) goto L13;
        return "";
    L13:
        return r111;
    L14:
        int r101 = StringsKt.indexOf$default(r110, '?', 0, false, 6, null);
        if (r101 < 0) goto L25;
        if (StringsKt.indexOf$default(r110, a.f25612h, r101, false, 4, null) <= 0) goto L28;
        int r102 = r101 + 1;
        if (r110 == null) goto L22;
        return r110.substring(0, r102) + r111 + Typography.amp + r110.substring(r102);
    L22:
        throw new NullPointerException("null cannot be cast to non-null type java.lang.String");
    L28:
        return r110 + Typography.amp + r111;
    L25:
        return r110 + '?' + r111;
    L5:
        if (StringsKt.isBlank(r110) == true) goto L8;
        r100 = false;
        goto L9
    }

    public final String decryptAes(String r100, byte[] r101) {
        if (r100 != null) goto L16;
    L8:
        boolean r102 = true;
    L9:
        if (r102 == true) goto L15;
        if (r101 == null) goto L15;
        Cipher r103 = Cipher.getInstance("AES/ECB/PKCS5Padding");     // Catch: Throwable -> L14
        r103.init(2, new SecretKeySpec(r101, CryptoConst.ALGORITHM_AES));     // Catch: Throwable -> L14
        return new String(r103.doFinal(Base64.decode(r100, 0)), Charsets.UTF_8);
    L14:
        b.c("AESDecryptLiveUrlUtils", "player decrypt url failed");
    L15:
        return "";
    L16:
        if (StringsKt.isBlank(r100) == true) goto L8;
        r102 = false;
        goto L9
    }

    public final String getDecryptPullStreamData(String r110, String r111) {
        boolean r100 = true;
        if (r110 != null) goto L5;
    L8:
        boolean r101 = true;
    L10:
        if (r101 == false) goto L12;
        return "";
    L12:
        if (r111 != null) goto L14;
    L17:
        if (r100 == false) goto L22;
        if (r110 == null) goto L20;
        return r110;
    L20:
        return "";
    L22:
        if (StringsKt.startsWith$default(r110, PREFIX, false, 2, null) == false) goto L28;
        String r112 = StringsKt.replace$default(r110, PREFIX, "", false, 4, null);
        Charset r102 = Charsets.UTF_8;
        if (r111 == null) goto L27;
        r110 = decryptAes(r112, r111.getBytes(r102));
        goto L28
    L27:
        throw new NullPointerException("null cannot be cast to non-null type java.lang.String");
    L28:
        if (r110 != null) goto L31;
        return "";
    L31:
        return r110;
    L14:
        if (r111.length() == 0) goto L17;
        r100 = false;
        goto L17
    L5:
        if (r110.length() == 0) goto L8;
        r101 = false;
        goto L10
    }

    public final String getDecryptPullUrl(String r110, String r111) {
        boolean r100 = true;
        if (r110 != null) goto L5;
    L8:
        boolean r101 = true;
    L10:
        if (r101 == false) goto L12;
        return "";
    L12:
        if (r111 != null) goto L14;
    L17:
        boolean r102 = true;
    L18:
        if (r102 == false) goto L22;
        if (r110 == null) goto L21;
        return r110;
    L21:
        return "";
    L22:
        if (r110 != null) goto L24;
        String r103 = "";
    L26:
        if (StringsKt.startsWith$default(r110, PREFIX, false, 2, null) == true) goto L28;
    L53:
        if (r103 != null) goto L56;
        return "";
    L56:
        return r103;
    L28:
        if (StringsKt.contains$default(r110, SPLIT, false, 2, null) == false) goto L40;
        List r112 = StringsKt.split$default(r110, new String[]{SPLIT}, false, 0, 6, null);
        List r104 = r112;
        if (r104 != null) goto L32;
    L35:
        boolean r105 = true;
    L36:
        if (r105 == true) goto L40;
        if (r112.size() <= 1) goto L40;
        String r106 = (String) ListProtector.get(r112, 0);
        String r113 = (String) ListProtector.get(r112, 1);
        String r107 = r106;
    L41:
        String r108 = StringsKt.replace$default(r107, PREFIX, "", false, 4, null);
        Charset r109 = Charsets.UTF_8;
        if (r111 == null) goto L52;
        r103 = decryptAes(r108, r111.getBytes(r109));
        if (r113 != null) goto L46;
    L49:
        if (r100 == true) goto L53;
        r103 = build(r103, r113);
        goto L53
    L46:
        if (r113.length() == 0) goto L49;
        r100 = false;
        goto L49
    L52:
        throw new NullPointerException("null cannot be cast to non-null type java.lang.String");
    L32:
        if (r104.isEmpty() == true) goto L35;
        r105 = false;
    L40:
        r107 = r103;
        r113 = "";
        goto L41
    L24:
        r103 = r110;
        goto L26
    L14:
        if (r111.length() == 0) goto L17;
        r102 = false;
        goto L18
    L5:
        if (r110.length() == 0) goto L8;
        r101 = false;
        goto L10
    }

    public final Pair<String, Boolean> getDecryptPullUrlWithResult(String r110, String r111) {
        boolean r100 = true;
        boolean r101 = false;
        if (r110 != null) goto L5;
    L8:
        boolean r102 = true;
    L9:
        String r103 = "";
        if (r102 == true) goto L12;
        if (r111 != null) goto L15;
    L18:
        boolean r104 = true;
    L19:
        if (r104 == false) goto L24;
        if (r110 != null) goto L23;
        r110 = "";
    L23:
        return TuplesKt.to(r110, Boolean.FALSE);
    L24:
        if (r110 != null) goto L26;
        String r105 = "";
    L28:
        if (StringsKt.startsWith$default(r110, PREFIX, false, 2, null) == true) goto L30;
        r100 = false;
    L55:
        if (r105 == null) goto L59;
        r103 = r105;
    L59:
        return TuplesKt.to(r103, Boolean.valueOf(r100));
    L30:
        if (StringsKt.contains$default(r110, SPLIT, false, 2, null) == false) goto L42;
        List r112 = StringsKt.split$default(r110, new String[]{SPLIT}, false, 0, 6, null);
        List r106 = r112;
        if (r106 != null) goto L34;
    L37:
        boolean r107 = true;
    L38:
        if (r107 == true) goto L42;
        if (r112.size() <= 1) goto L42;
        String r108 = (String) ListProtector.get(r112, 0);
        String r113 = (String) ListProtector.get(r112, 1);
        String r109 = r108;
    L43:
        String r114 = StringsKt.replace$default(r109, PREFIX, "", false, 4, null);
        Charset r115 = Charsets.UTF_8;
        if (r111 == null) goto L53;
        r105 = decryptAes(r114, r111.getBytes(r115));
        if (r113 != null) goto L48;
    L49:
        r101 = true;
    L50:
        if (r101 == true) goto L55;
        r105 = build(r105, r113);
        goto L55
    L48:
        if (r113.length() != 0) goto L50;
    L53:
        throw new NullPointerException("null cannot be cast to non-null type java.lang.String");
    L34:
        if (r106.isEmpty() == true) goto L37;
        r107 = false;
    L42:
        r109 = r105;
        r113 = "";
        goto L43
    L26:
        r105 = r110;
        goto L28
    L15:
        if (r111.length() == 0) goto L18;
        r104 = false;
        goto L19
    L12:
        return TuplesKt.to("", Boolean.FALSE);
    L5:
        if (r110.length() == 0) goto L8;
        r102 = false;
        goto L9
    }
}
