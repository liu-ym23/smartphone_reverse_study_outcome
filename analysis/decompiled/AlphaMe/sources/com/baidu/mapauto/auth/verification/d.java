package com.baidu.mapauto.auth.verification;

import B0.g;
import android.text.TextUtils;
import ch.qos.logback.core.rolling.helper.DateTokenConverter;
import com.baidu.mapauto.auth.AuthCore;
import com.baidu.mapauto.auth.util.LogUtil;
import com.baidu.mapauto.auth.util.RSAUtil;
import com.stepos.activeview.utils.Constants;
import java.security.PublicKey;
import java.util.Iterator;
import java.util.TreeSet;
import org.json.JSONArray;
import org.json.JSONObject;

/* loaded from: classes.dex */
public final class d extends com.baidu.mapauto.auth.base.a<com.baidu.mapauto.auth.proxy.c> {
    public d(int i4, AuthCore.AuthParam authParam, com.baidu.mapauto.auth.proxy.c cVar) {
        super(i4, authParam, cVar);
    }

    @Override // com.baidu.mapauto.auth.base.c
    public final /* bridge */ /* synthetic */ boolean a(int i4, AuthCore.AuthParam authParam, Object obj) {
        return a(authParam, (com.baidu.mapauto.auth.proxy.c) obj);
    }

    public final boolean a(AuthCore.AuthParam authParam, com.baidu.mapauto.auth.proxy.c cVar) {
        Object objOpt;
        LogUtil.getInstance().i(DateTokenConverter.CONVERTER_KEY, "开始检验 sign");
        JSONObject jSONObject = cVar.f7812a;
        boolean zVerify = false;
        if (jSONObject == null) {
            LogUtil.getInstance().e(DateTokenConverter.CONVERTER_KEY, "校验签名失败: 验签结果为空");
            return false;
        }
        Iterator<String> itKeys = jSONObject.keys();
        TreeSet treeSet = new TreeSet();
        while (itKeys.hasNext()) {
            treeSet.add(itKeys.next());
        }
        StringBuilder sb = new StringBuilder();
        Iterator it = treeSet.iterator();
        while (it.hasNext()) {
            String str = (String) it.next();
            if (!"pub_key".equals(str) && !Constants.PARAM_SIGN.equals(str) && (objOpt = jSONObject.opt(str)) != null) {
                if (objOpt instanceof JSONArray) {
                    JSONArray jSONArray = (JSONArray) objOpt;
                    int length = jSONArray.length();
                    for (int i4 = 0; i4 < length; i4++) {
                        String strOptString = jSONArray.optString(i4);
                        if (!TextUtils.isEmpty(strOptString)) {
                            sb.append(strOptString);
                        }
                    }
                } else {
                    sb.append(objOpt);
                }
            }
        }
        String string = sb.toString();
        if (TextUtils.isEmpty(string)) {
            LogUtil.getInstance().e(DateTokenConverter.CONVERTER_KEY, "校验签名失败: sign 原数据为空");
            return false;
        }
        try {
            JSONObject jSONObject2 = cVar.f7812a;
            PublicKey publicKeyFromPemString = RSAUtil.getPublicKeyFromPemString(jSONObject2 == null ? null : jSONObject2.optString("pub_key"), false);
            JSONObject jSONObject3 = cVar.f7812a;
            zVerify = RSAUtil.verify(string, publicKeyFromPemString, jSONObject3 == null ? null : jSONObject3.optString(Constants.PARAM_SIGN));
        } catch (Exception e4) {
            LogUtil.getInstance().e(DateTokenConverter.CONVERTER_KEY, e4.toString());
        }
        LogUtil logUtil = LogUtil.getInstance();
        StringBuilder sbW = g.w("校验签名结束: source: ", string, ", pubKey: ");
        JSONObject jSONObject4 = cVar.f7812a;
        sbW.append(jSONObject4 == null ? null : jSONObject4.optString("pub_key"));
        sbW.append(", sign: ");
        JSONObject jSONObject5 = cVar.f7812a;
        sbW.append(jSONObject5 != null ? jSONObject5.optString(Constants.PARAM_SIGN) : null);
        sbW.append(" => 校验结果: ");
        sbW.append(zVerify);
        logUtil.i(DateTokenConverter.CONVERTER_KEY, sbW.toString());
        return zVerify;
    }
}
