package com.baidu.mapauto.auth.process;

import android.content.SharedPreferences;
import android.text.TextUtils;
import ch.qos.logback.core.joran.action.Action;
import com.baidu.mapauto.auth.AuthCore;
import com.baidu.mapauto.auth.base.BaseLicenseAuthDataStandardProcess;
import com.baidu.mapauto.auth.proxy.c;
import com.baidu.mapauto.auth.proxy.d;
import com.baidu.mapauto.auth.util.AESECBPKCS5PaddingUtil;
import com.baidu.mapauto.auth.util.RSAUtil;
import com.baidu.mshield.x6.EngineImpl;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.PublicKey;
import java.util.ArrayList;
import java.util.HashMap;
import javax.crypto.NoSuchPaddingException;
import org.json.JSONArray;
import org.json.JSONObject;

/* loaded from: classes.dex */
public final class b extends BaseLicenseAuthDataStandardProcess<d, c> {

    /* renamed from: b, reason: collision with root package name */
    public final com.baidu.mapauto.auth.data.license.impl.a f7809b;

    /* renamed from: c, reason: collision with root package name */
    public final com.baidu.mapauto.auth.data.license.impl.b f7810c;

    public b(int i4, com.baidu.mapauto.auth.data.license.impl.a aVar, com.baidu.mapauto.auth.data.license.impl.b bVar) {
        super(i4);
        this.f7809b = aVar;
        this.f7810c = bVar;
    }

    @Override // com.baidu.mapauto.auth.base.BaseLicenseAuthDataStandardProcess
    public final String b(AuthCore.AuthParam authParam) {
        com.baidu.mapauto.auth.base.d dVar;
        com.baidu.mapauto.auth.data.license.impl.b bVar = this.f7810c;
        if (bVar == null) {
            return null;
        }
        String strE = authParam.e();
        if (TextUtils.isEmpty(bVar.f7670b) || (dVar = bVar.f7669a) == null) {
            return "";
        }
        StringBuilder sb = new StringBuilder("license_function");
        if (!TextUtils.isEmpty(strE)) {
            sb.append("_");
            sb.append(strE);
        }
        String string = sb.toString();
        SharedPreferences sharedPreferences = ((com.baidu.mapauto.auth.store.a) dVar).f7813a;
        return AESECBPKCS5PaddingUtil.decrypt(sharedPreferences != null ? sharedPreferences.getString(string, "") : "", bVar.f7670b);
    }

    @Override // com.baidu.mapauto.auth.base.BaseLicenseAuthDataStandardProcess
    public final com.baidu.mapauto.auth.net.b c(AuthCore.AuthParam authParam) throws Exception {
        com.baidu.mapauto.auth.data.license.impl.a aVar = this.f7809b;
        if (aVar == null) {
            return null;
        }
        String strB = authParam.b();
        String strC = authParam.c();
        String strE = authParam.e();
        Object obj = authParam.get("public_key");
        String str = obj instanceof String ? (String) obj : null;
        Object obj2 = authParam.get("function_name");
        String str2 = obj2 instanceof String ? (String) obj2 : null;
        String strD = authParam.d();
        Object obj3 = authParam.get(AuthCore.AuthParam.KEY_EXTRA_OS_VERSION);
        String str3 = obj3 instanceof String ? (String) obj3 : null;
        Object obj4 = authParam.get(AuthCore.AuthParam.KEY_EXTRA_MODEL);
        String str4 = obj4 instanceof String ? (String) obj4 : null;
        Object obj5 = authParam.get(AuthCore.AuthParam.KEY_EXTRA_APP_VERSION);
        String str5 = obj5 instanceof String ? (String) obj5 : null;
        Object obj6 = authParam.get(AuthCore.AuthParam.KEY_EXTRA_CUID);
        String str6 = obj6 instanceof String ? (String) obj6 : null;
        Object obj7 = authParam.get("sdk_version_name");
        String str7 = obj7 instanceof String ? (String) obj7 : null;
        Object obj8 = authParam.get("sdk_version_code");
        if (obj8 instanceof Integer) {
            ((Integer) obj8).getClass();
        }
        com.baidu.mapauto.auth.net.base.a aVar2 = aVar.f7668a;
        if (aVar2 != null) {
            HashMap map = new HashMap(13);
            PublicKey publicKeyFromPemString = RSAUtil.getPublicKeyFromPemString("MIIBCgKCAQEAz4ZBbWFih8n59i6cwKDW9aBQqMstCa0LgmkArRZ2WZgDLXFo9BBZAmcLqdgDUzm8yV7fB8isBDruyC3ADKSvWyJt5xQBGFiMkuEKvvnmbT4WEotwUu9Id3Xt0tPzefSixulhQ4UcaBNzPs2bU+1pphbsr2Rv4PdpMs66jZ8r5UF4H6fwAQwqRmhTKhSvkLvkhQ1nyxel/98nszHZRgKXTLv1EPafr290WJo24G+f6kEvGfK+gN87WCat8ftRZL7zeZSNLMDA5oqfjRKMZYg9eg6k0JWnAqUcY1MsLrQw7tFPkLlEVpd8rigfq0zPNZRrf1xdTCcnofpGD+WAH2nTIwIDAQAB", false);
            if (publicKeyFromPemString != null) {
                map.put("ak", RSAUtil.encryptToHexStringPub(strB, publicKeyFromPemString));
                map.put("channel", strC);
                map.put("service_name", strE);
                map.put("pk", str);
                if (!TextUtils.isEmpty(str2)) {
                    map.put("function_name", str2);
                }
                if (!TextUtils.isEmpty(strD)) {
                    map.put("device_id", RSAUtil.encryptToHexStringPub(strD, publicKeyFromPemString));
                }
                if (!TextUtils.isEmpty(str3)) {
                    map.put("os_version", str3);
                }
                if (!TextUtils.isEmpty(str4)) {
                    map.put("model", str4);
                }
                if (!TextUtils.isEmpty(str5)) {
                    map.put("app_version", str5);
                }
                if (!TextUtils.isEmpty(str6)) {
                    map.put(EngineImpl.KEY_CUID, str6);
                }
                if (!TextUtils.isEmpty(str7)) {
                    map.put("sdk_version", str7);
                }
                return ((com.baidu.mapauto.auth.net.a) aVar2).a("/license/permission/verify", map);
            }
        }
        return null;
    }

    @Override // com.baidu.mapauto.auth.base.BaseLicenseAuthDataStandardProcess
    public final com.baidu.mapauto.auth.base.b a(String str) {
        return new d(str);
    }

    @Override // com.baidu.mapauto.auth.base.BaseLicenseAuthDataStandardProcess
    public final ArrayList a(int i4, AuthCore.AuthParam authParam, com.baidu.mapauto.auth.base.b bVar) {
        ArrayList arrayList = new ArrayList(2);
        JSONObject jSONObject = ((d) bVar).f7667b;
        c cVar = new c(jSONObject == null ? null : jSONObject.optJSONObject(Action.FILE_ATTRIBUTE));
        arrayList.add(new com.baidu.mapauto.auth.verification.d(i4, authParam, cVar));
        arrayList.add(new com.baidu.mapauto.auth.verification.c(i4, authParam, cVar));
        return arrayList;
    }

    @Override // com.baidu.mapauto.auth.base.BaseLicenseAuthDataStandardProcess
    public final boolean a(AuthCore.AuthParam authParam, d dVar) throws NoSuchPaddingException, NoSuchAlgorithmException, InvalidKeyException {
        com.baidu.mapauto.auth.data.license.impl.b bVar = this.f7810c;
        if (bVar == null) {
            return false;
        }
        String strE = authParam.e();
        String strEncrypt = dVar.f7666a;
        if (TextUtils.isEmpty(bVar.f7670b) || bVar.f7669a == null) {
            return false;
        }
        if (!TextUtils.isEmpty(strEncrypt)) {
            strEncrypt = AESECBPKCS5PaddingUtil.encrypt(strEncrypt, bVar.f7670b);
        }
        com.baidu.mapauto.auth.base.d dVar2 = bVar.f7669a;
        StringBuilder sb = new StringBuilder("license_function");
        if (!TextUtils.isEmpty(strE)) {
            sb.append("_");
            sb.append(strE);
        }
        String string = sb.toString();
        SharedPreferences.Editor editor = ((com.baidu.mapauto.auth.store.a) dVar2).f7814b;
        if (editor == null) {
            return false;
        }
        return editor.putString(string, strEncrypt).commit();
    }

    @Override // com.baidu.mapauto.auth.base.BaseLicenseAuthDataStandardProcess
    public final HashMap b(com.baidu.mapauto.auth.base.b bVar) {
        JSONObject jSONObject = ((d) bVar).f7667b;
        JSONObject jSONObjectOptJSONObject = jSONObject == null ? null : jSONObject.optJSONObject(Action.FILE_ATTRIBUTE);
        if (jSONObjectOptJSONObject == null) {
            return new HashMap(0);
        }
        JSONArray jSONArrayOptJSONArray = jSONObjectOptJSONObject.optJSONArray("functions");
        if (jSONArrayOptJSONArray == null) {
            return new HashMap(0);
        }
        int length = jSONArrayOptJSONArray.length();
        HashMap map = new HashMap(length);
        for (int i4 = 0; i4 < length; i4++) {
            String strOptString = jSONArrayOptJSONArray.optString(i4);
            if (!TextUtils.isEmpty(strOptString)) {
                map.put(strOptString, 0);
            }
        }
        return map;
    }
}
