package com.baidu.mapauto.auth.verification;

import android.text.TextUtils;
import com.baidu.mapauto.auth.AuthCore;
import com.baidu.mapauto.auth.util.LogUtil;
import com.baidu.mapauto.auth.util.RSAUtil;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import java.security.PrivateKey;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes39.dex */
public final class a extends com.baidu.mapauto.auth.base.a<com.baidu.mapauto.auth.proxy.a> {
    public a(int r100, AuthCore.AuthParam r101, com.baidu.mapauto.auth.proxy.a r102) {
        super(r100, r101, r102);
    }

    @Override // com.baidu.mapauto.auth.base.c
    public final boolean a(int r100, AuthCore.AuthParam r101, Object r102) {
        com.baidu.mapauto.auth.proxy.a r103 = (com.baidu.mapauto.auth.proxy.a) r102;
        LogUtil.getInstance().i(BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "开始检验设备");
        String r104 = r101.e();
        JSONObject r105 = r103.f31931a;
        String r106 = null;
        if (r105 != null) goto L5;
        String r107 = null;
    L7:
        if (TextUtils.equals(r104, r107) == true) goto L9;
        LogUtil.getInstance().e(BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "校验签名失败: 服务名不一致");
        return false;
    L9:
        String r108 = r101.c();
        JSONObject r109 = r103.f31931a;
        if (r109 != null) goto L12;
        String r110 = null;
    L14:
        if (TextUtils.equals(r108, r110) == true) goto L16;
        LogUtil.getInstance().e(BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "校验签名失败: 渠道不一致");
        return false;
    L16:
        if (r100 != 0) goto L44;
        Object r111 = r101.get("private_key");
        if ((r111 instanceof String) == false) goto L20;
        String r112 = (String) r111;
    L22:
        if (TextUtils.isEmpty(r112) == false) goto L24;
        LogUtil.getInstance().e(BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "校验签名失败: 本地私钥为空");
        return false;
    L24:
        PrivateKey r113 = RSAUtil.getPrivateKeyFrom16(r112);
        JSONObject r114 = r103.f31931a;
        if (r114 != null) goto L27;
        String r115 = null;
    L28:
        byte[] r116 = RSAUtil.decryptHexStringBySec(r115, r113);
        JSONObject r117 = r103.f31931a;
        if (r117 == null) goto L32;
        r106 = r117.optString("device_id");
    L32:
        byte[] r118 = RSAUtil.decryptHexStringBySec(r106, r113);
        if (r116 != null) goto L36;
        LogUtil r119 = LogUtil.getInstance();
        String r120 = "校验签名失败: 解析 ak 失败";
    L35:
        r119.e(BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, r120);
        return false;
    L36:
        if (r118 != null) goto L39;
        r119 = LogUtil.getInstance();
        r120 = "校验签名失败: 解析 deviceId 失败";
        goto L35
    L39:
        if (new String(r116).equals(r101.b()) == true) goto L42;
        r119 = LogUtil.getInstance();
        r120 = "校验签名失败: ak 不一致";
        goto L35
    L42:
        if (new String(r118).equals(r101.d()) == true) goto L44;
        r119 = LogUtil.getInstance();
        r120 = "校验签名失败: deviceId 不一致";
        goto L35
    L27:
        r115 = r114.optString("ak");
        goto L28
    L20:
        r112 = null;
    L44:
        LogUtil.getInstance().i(BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "设备校验通过");
        return true;
    L12:
        r110 = r109.optString("channel");
        goto L14
    L5:
        r107 = r105.optString("service");
        goto L7
    }
}
