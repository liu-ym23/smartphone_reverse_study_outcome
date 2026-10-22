package com.baidu.mapauto.auth.verification;

import android.text.TextUtils;
import com.baidu.mapauto.auth.AuthCore;
import com.baidu.mapauto.auth.util.LogUtil;
import com.baidu.mapauto.auth.util.RSAUtil;
import java.security.PrivateKey;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes39.dex */
public final class c extends com.baidu.mapauto.auth.base.a<com.baidu.mapauto.auth.proxy.c> {
    public c(int r100, AuthCore.AuthParam r101, com.baidu.mapauto.auth.proxy.c r102) {
        super(r100, r101, r102);
    }

    @Override // com.baidu.mapauto.auth.base.c
    public final boolean a(int r100, AuthCore.AuthParam r101, Object r102) {
        com.baidu.mapauto.auth.proxy.c r103 = (com.baidu.mapauto.auth.proxy.c) r102;
        LogUtil.getInstance().i("c", "开始检验设备");
        String r104 = r101.e();
        JSONObject r105 = r103.f31932a;
        String r106 = null;
        if (r105 != null) goto L5;
        String r107 = null;
    L7:
        if (TextUtils.equals(r104, r107) == true) goto L9;
        LogUtil.getInstance().e("c", "校验签名失败: 服务名不一致");
        return false;
    L9:
        String r108 = r101.c();
        JSONObject r109 = r103.f31932a;
        if (r109 != null) goto L12;
        String r110 = null;
    L14:
        if (TextUtils.equals(r108, r110) == true) goto L16;
        LogUtil.getInstance().e("c", "校验签名失败: 渠道不一致");
        return false;
    L16:
        if (r100 != 0) goto L35;
        Object r111 = r101.get("private_key");
        if ((r111 instanceof String) == false) goto L20;
        String r112 = (String) r111;
    L22:
        if (TextUtils.isEmpty(r112) == false) goto L24;
        LogUtil.getInstance().e("c", "校验签名失败: 本地私钥为空");
        return false;
    L24:
        PrivateKey r113 = RSAUtil.getPrivateKeyFrom16(r112);
        JSONObject r114 = r103.f31932a;
        if (r114 == null) goto L28;
        r106 = r114.optString("ak");
    L28:
        byte[] r115 = RSAUtil.decryptHexStringBySec(r106, r113);
        if (r115 != null) goto L33;
        LogUtil r116 = LogUtil.getInstance();
        String r117 = "校验签名失败: 解析 ak 失败";
    L31:
        r116.e("c", r117);
        return false;
    L33:
        if (new String(r115).equals(r101.b()) == true) goto L35;
        r116 = LogUtil.getInstance();
        r117 = "校验签名失败: ak 不一致";
        goto L31
    L20:
        r112 = null;
    L35:
        LogUtil.getInstance().i("c", "设备校验通过");
        return true;
    L12:
        r110 = r109.optString("channel");
        goto L14
    L5:
        r107 = r105.optString("service");
        goto L7
    }
}
