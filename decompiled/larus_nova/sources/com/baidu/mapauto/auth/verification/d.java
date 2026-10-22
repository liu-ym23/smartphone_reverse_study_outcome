package com.baidu.mapauto.auth.verification;

import android.text.TextUtils;
import com.baidu.mapauto.auth.AuthCore;
import com.baidu.mapauto.auth.util.LogUtil;
import com.baidu.mapauto.auth.util.RSAUtil;
import java.security.PublicKey;
import java.util.Iterator;
import java.util.TreeSet;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes39.dex */
public final class d extends com.baidu.mapauto.auth.base.a<com.baidu.mapauto.auth.proxy.c> {
    public d(int r100, AuthCore.AuthParam r101, com.baidu.mapauto.auth.proxy.c r102) {
        super(r100, r101, r102);
    }

    @Override // com.baidu.mapauto.auth.base.c
    public final /* bridge */ /* synthetic */ boolean a(int r100, AuthCore.AuthParam r101, Object r102) {
        return a(r101, (com.baidu.mapauto.auth.proxy.c) r102);
    }

    public final boolean a(AuthCore.AuthParam r110, com.baidu.mapauto.auth.proxy.c r111) {
        LogUtil.getInstance().i("d", "开始检验 sign");
        JSONObject r112 = r111.f31932a;
        boolean r100 = false;
        if (r112 != null) goto L6;
        LogUtil.getInstance().e("d", "校验签名失败: 验签结果为空");
        return false;
    L6:
        Iterator<String> r101 = r112.keys();
        TreeSet r102 = new TreeSet();
    L8:
        if (r101.hasNext() == false) goto L10;
        r102.add(r101.next());
        goto L8
    L10:
        StringBuilder r103 = new StringBuilder();
        Iterator r104 = r102.iterator();
    L12:
        if (r104.hasNext() == false) goto L35;
        String r105 = (String) r104.next();
        if ("pub_key".equals(r105) == false) goto L16;
    L19:
        boolean r106 = true;
    L20:
        if (r106 == true) goto L12;
        Object r107 = r112.opt(r105);
        if (r107 == null) goto L12;
        if ((r107 instanceof JSONArray) == true) goto L27;
        r103.append(r107);
        goto L12
    L27:
        JSONArray r108 = (JSONArray) r107;
        int r109 = r108.length();
        int r113 = 0;
    L28:
        if (r113 >= r109) goto L12;
        String r114 = r108.optString(r113);
        if (TextUtils.isEmpty(r114) == true) goto L33;
        r103.append(r114);
    L33:
        r113 = r113 + 1;
        goto L28
    L16:
        if ("sign".equals(r105) == true) goto L19;
        r106 = false;
        goto L20
    L35:
        String r115 = r103.toString();
        if (TextUtils.isEmpty(r115) == false) goto L39;
        LogUtil.getInstance().e("d", "校验签名失败: sign 原数据为空");
        return false;
    L39:
        String r116 = null;
        JSONObject r117 = r111.f31932a;     // Catch: Exception -> L50
        if (r117 != null) goto L43;
        String r118 = null;
    L44:
        PublicKey r119 = RSAUtil.getPublicKeyFromPemString(r118, false);     // Catch: Exception -> L50
        JSONObject r120 = r111.f31932a;     // Catch: Exception -> L50
        if (r120 != null) goto L47;
        String r121 = null;
    L48:
        r100 = RSAUtil.verify(r115, r119, r121);     // Catch: Exception -> L50
    L52:
        LogUtil r122 = LogUtil.getInstance();
        StringBuilder r123 = new StringBuilder("校验签名结束: source: ");
        r123.append(r115);
        r123.append(", pubKey: ");
        JSONObject r124 = r111.f31932a;
        if (r124 != null) goto L55;
        String r125 = null;
    L56:
        r123.append(r125);
        r123.append(", sign: ");
        JSONObject r126 = r111.f31932a;
        if (r126 == null) goto L60;
        r116 = r126.optString("sign");
    L60:
        r123.append(r116);
        r123.append(" => 校验结果: ");
        r123.append(r100);
        r122.i("d", r123.toString());
        return r100;
    L55:
        r125 = r124.optString("pub_key");
        goto L56
    L47:
        r121 = r120.optString("sign");     // Catch: Exception -> L50
        goto L48
    L43:
        r118 = r117.optString("pub_key");     // Catch: Exception -> L50
    L50:
        e = move-exception;
        LogUtil.getInstance().e("d", e.toString());
        goto L52
    }
}
