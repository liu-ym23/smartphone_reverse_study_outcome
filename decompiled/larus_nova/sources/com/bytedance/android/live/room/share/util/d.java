package com.bytedance.android.live.room.share.util;

import android.text.TextUtils;
import com.bytedance.android.livehostapi.business.base.IBaseHostShare;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import java.util.List;
import java.util.Map;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes47.dex */
public final class d {
    static {
    }

    @JvmStatic
    public static final int b(String r100) {
        if (TextUtils.isEmpty(r100) == true) goto L149;
        if (r100 != null) goto L8;
        return -1;
    L8:
        switch(r100.hashCode()) {
            case -2116720984: goto L92;
            case -1837180097: goto L89;
            case -1436108013: goto L86;
            case -1374807695: goto L83;
            case -1374788756: goto L80;
            case -1322993519: goto L77;
            case -1295234920: goto L74;
            case -1194195335: goto L71;
            case -1134307907: goto L68;
            case -929929834: goto L65;
            case -916346253: goto L62;
            case -816556504: goto L59;
            case -791575966: goto L56;
            case 3616: goto L53;
            case 3765: goto L50;
            case 114009: goto L47;
            case 3016245: goto L44;
            case 3321844: goto L41;
            case 3357525: goto L38;
            case 3731178: goto L35;
            case 28903346: goto L32;
            case 96619420: goto L29;
            case 108102557: goto L26;
            case 112200956: goto L23;
            case 113011944: goto L20;
            case 497130182: goto L17;
            case 1355475581: goto L14;
            case 1934780818: goto L11;
            default: goto L151;
        };
    L151:
        return -1;
    L11:
        if (r100.equals("whatsapp") == false) goto L95;
        return 12;
    L95:
        return -1;
    L14:
        if (r100.equals("weixin_moment") == false) goto L97;
    L66:
        return 2;
    L97:
        return -1;
    L17:
        if (r100.equals("facebook") == false) goto L98;
        return 8;
    L98:
        return -1;
    L20:
        if (r100.equals("weibo") == false) goto L100;
        return 3;
    L100:
        return -1;
    L23:
        if (r100.equals(IBaseHostShare.VIBER) == false) goto L102;
        return 26;
    L102:
        return -1;
    L26:
        if (r100.equals("qzone") == false) goto L104;
        return 4;
    L104:
        return -1;
    L29:
        if (r100.equals("email") == false) goto L106;
        return 25;
    L106:
        return -1;
    L32:
        if (r100.equals("instagram") == false) goto L108;
        return 10;
    L108:
        return -1;
    L35:
        if (r100.equals(IBaseHostShare.ZALO) == false) goto L110;
        return 30;
    L110:
        return -1;
    L38:
        if (r100.equals("more") == false) goto L112;
        return 20;
    L112:
        return -1;
    L41:
        if (r100.equals("line") == false) goto L114;
        return 15;
    L114:
        return -1;
    L44:
        if (r100.equals(IBaseHostShare.BAND) == false) goto L116;
        return 22;
    L116:
        return -1;
    L47:
        if (r100.equals("sms") == false) goto L118;
        return 21;
    L118:
        return -1;
    L50:
        if (r100.equals("vk") == false) goto L120;
        return 29;
    L120:
        return -1;
    L53:
        if (r100.equals("qq") == false) goto L122;
        return 5;
    L122:
        return -1;
    L56:
        if (r100.equals("weixin") == false) goto L124;
        return 1;
    L124:
        return -1;
    L59:
        if (r100.equals(IBaseHostShare.INSTAGROM_STORY) == false) goto L126;
        return 11;
    L126:
        return -1;
    L62:
        if (r100.equals("twitter") == false) goto L128;
        return 9;
    L128:
        return -1;
    L65:
        if (r100.equals("weixin_moments") == true) goto L66;
        return -1;
    L68:
        if (r100.equals("toutiao") == false) goto L132;
        return 6;
    L132:
        return -1;
    L71:
        if (r100.equals(IBaseHostShare.KAKAO_STORY) == false) goto L134;
        return 17;
    L134:
        return -1;
    L74:
        if (r100.equals(IBaseHostShare.SNAPCHAT_STORY) == false) goto L136;
        return 19;
    L136:
        return -1;
    L77:
        if (r100.equals("chat_merge") == false) goto L138;
        return 112;
    L138:
        return -1;
    L80:
        if (r100.equals(IBaseHostShare.NAVER_CAFE) == false) goto L140;
        return 23;
    L140:
        return -1;
    L83:
        if (r100.equals(IBaseHostShare.NAVER_BLOG) == false) goto L142;
        return 24;
    L142:
        return -1;
    L86:
        if (r100.equals("messenger") == false) goto L144;
        return 13;
    L144:
        return -1;
    L89:
        if (r100.equals(IBaseHostShare.WHATS_APP_STATUS) == false) goto L146;
        return 31;
    L146:
        return -1;
    L92:
        if (r100.equals("kakao_talk") == false) goto L148;
        return 16;
    L148:
        return -1;
    L149:
        return -1;
    }

    @JvmStatic
    public static final boolean a(String r100, Map<String, ? extends List<String>> r101) {
        if (Intrinsics.areEqual(r100, "qr_code") == false) goto L20;
        String r102 = null;
        if (r101 == null) goto L9;
        List<String> r103 = r101.get("qrcode_alert_platform");
        if (r103 == null) goto L9;
        String r104 = (String) ListProtector.get(r103, 0);
    L11:
        if (TextUtils.isEmpty(r104) == true) goto L21;
        if (r101 == null) goto L17;
        List<String> r105 = r101.get("code");
        if (r105 == null) goto L17;
        r102 = (String) ListProtector.get(r105, 0);
    L17:
        if (TextUtils.equals(r102, "0") == false) goto L22;
        return true;
    L22:
        return false;
    L21:
        return false;
    L9:
        r104 = null;
        goto L11
    L20:
        return false;
    }
}
