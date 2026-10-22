package com.baidu.mapauto.auth.verification;

import B0.g;
import android.text.TextUtils;
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
public final class b extends com.baidu.mapauto.auth.base.a<com.baidu.mapauto.auth.proxy.a> {
    public b(int i4, AuthCore.AuthParam authParam, com.baidu.mapauto.auth.proxy.a aVar) {
        super(i4, authParam, aVar);
    }

    @Override // com.baidu.mapauto.auth.base.c
    public final /* bridge */ /* synthetic */ boolean a(int i4, AuthCore.AuthParam authParam, Object obj) {
        return a(authParam, (com.baidu.mapauto.auth.proxy.a) obj);
    }

    public final boolean a(AuthCore.AuthParam authParam, com.baidu.mapauto.auth.proxy.a aVar) {
        Object objOpt;
        LogUtil.getInstance().i("b", "开始检验 sign");
        JSONObject jSONObject = aVar.f7811a;
        boolean zVerify = false;
        if (jSONObject == null) {
            LogUtil.getInstance().e("b", "校验签名失败: 验签结果为空");
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
            LogUtil.getInstance().e("b", "校验签名失败: sign 原数据为空");
            return false;
        }
        try {
            JSONObject jSONObject2 = aVar.f7811a;
            PublicKey publicKeyFromPemString = RSAUtil.getPublicKeyFromPemString(jSONObject2 == null ? null : jSONObject2.optString("pub_key"), false);
            JSONObject jSONObject3 = aVar.f7811a;
            zVerify = RSAUtil.verify(string, publicKeyFromPemString, jSONObject3 == null ? null : jSONObject3.optString(Constants.PARAM_SIGN));
        } catch (Exception e4) {
            LogUtil.getInstance().e("b", e4.toString());
        }
        LogUtil logUtil = LogUtil.getInstance();
        StringBuilder sbW = g.w("校验签名结束: source: ", string, ", pubKey: ");
        JSONObject jSONObject4 = aVar.f7811a;
        sbW.append(jSONObject4 == null ? null : jSONObject4.optString("pub_key"));
        sbW.append(", sign: ");
        JSONObject jSONObject5 = aVar.f7811a;
        sbW.append(jSONObject5 != null ? jSONObject5.optString(Constants.PARAM_SIGN) : null);
        sbW.append(" => 校验结果: ");
        sbW.append(zVerify);
        logUtil.i("b", sbW.toString());
        return zVerify;
    }
}
