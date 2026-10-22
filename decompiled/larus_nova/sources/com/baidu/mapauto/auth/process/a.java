package com.baidu.mapauto.auth.process;

import android.content.SharedPreferences;
import android.text.TextUtils;
import com.baidu.mapauto.auth.AuthCore;
import com.baidu.mapauto.auth.base.BaseLicenseAuthDataStandardProcess;
import com.baidu.mapauto.auth.base.d;
import com.baidu.mapauto.auth.util.AESGCMPKCS5PaddingUtil;
import com.baidu.mapauto.auth.util.RSAUtil;
import com.baidu.mshield.x6.EngineImpl;
import com.bytedance.android.live.network.annotation.PbRequest;
import com.bytedance.crash.general.AppInfo;
import com.bytedance.mt.protector.impl.JSONArrayProtectorUtils;
import com.larus.dora.obric.device_management.device_home.DoraObricDeviceHomeViewModel;
import java.security.PublicKey;
import java.util.ArrayList;
import java.util.HashMap;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes39.dex */
public final class a extends BaseLicenseAuthDataStandardProcess<com.baidu.mapauto.auth.proxy.b, com.baidu.mapauto.auth.proxy.a> {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final com.baidu.mapauto.auth.data.license.impl.a f31927b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final com.baidu.mapauto.auth.data.license.impl.b f31928c;

    public a(int r100, com.baidu.mapauto.auth.data.license.impl.a r101, com.baidu.mapauto.auth.data.license.impl.b r102) {
        super(r100);
        this.f31927b = r101;
        this.f31928c = r102;
    }

    @Override // com.baidu.mapauto.auth.base.BaseLicenseAuthDataStandardProcess
    public final /* bridge */ /* synthetic */ boolean b(AuthCore.AuthParam r100, com.baidu.mapauto.auth.base.b r101) {
        return a(r100, (com.baidu.mapauto.auth.proxy.b) r101);
    }

    @Override // com.baidu.mapauto.auth.base.BaseLicenseAuthDataStandardProcess
    public final HashMap a(com.baidu.mapauto.auth.base.b r100) {
        JSONObject r101 = ((com.baidu.mapauto.auth.proxy.b) r100).f31787b;
        if (r101 != null) goto L5;
        JSONArray r102 = null;
    L7:
        if (r102 == null) goto L34;
        int r103 = r102.length();
        HashMap r104 = new HashMap(r103);
        int r105 = 0;
    L10:
        if (r105 >= r103) goto L29;
        JSONObject r106 = r102.optJSONObject(r105);
        if (r106 != null) goto L14;
        String r107 = null;
    L15:
        if (r106 != null) goto L17;
        Integer r108 = null;
    L19:
        if (TextUtils.isEmpty(r107) == true) goto L27;
        if (r108 == null) goto L27;
        if (r108.intValue() != 0) goto L25;
        int r109 = 0;
    L26:
        r104.put(r107, Integer.valueOf(r109));
        goto L27
    L25:
        r109 = 1;
    L27:
        r105 = r105 + 1;
        goto L10
    L17:
        r108 = Integer.valueOf(r106.optInt("status"));
        goto L19
    L14:
        r107 = r106.optString("function");
        goto L15
    L29:
        return r104;
    L34:
        return new HashMap(0);
    L5:
        r102 = r101.optJSONArray("file");
        goto L7
    }

    @Override // com.baidu.mapauto.auth.base.BaseLicenseAuthDataStandardProcess
    public final String b(AuthCore.AuthParam r100) {
        com.baidu.mapauto.auth.data.license.impl.b r101 = this.f31928c;
        if (r101 == null) goto L22;
        String r102 = r100.e();
        String r103 = "";
        if (TextUtils.isEmpty(r101.f31790b) == true) goto L23;
        d r104 = r101.f31789a;
        if (r104 == null) goto L24;
        StringBuilder r105 = new StringBuilder("license_file");
        if (TextUtils.isEmpty(r102) == true) goto L14;
        r105.append("_");
        r105.append(r102);
    L14:
        if (TextUtils.isEmpty(null) == true) goto L16;
        r105.append("_null");
    L16:
        String r106 = r105.toString();
        SharedPreferences r107 = ((com.baidu.mapauto.auth.store.a) r104).f31933a;
        if (r107 == null) goto L21;
        r103 = r107.getString(r106, "");
    L21:
        return AESGCMPKCS5PaddingUtil.decrypt(r103, r101.f31790b);
    L24:
        return "";
    L23:
        return "";
    L22:
        return null;
    }

    @Override // com.baidu.mapauto.auth.base.BaseLicenseAuthDataStandardProcess
    public final com.baidu.mapauto.auth.net.b c(AuthCore.AuthParam r110) throws Exception {
        com.baidu.mapauto.auth.data.license.impl.a r100 = this.f31927b;
        if (r100 == null) goto L72;
        String r101 = r110.b();
        String r102 = r110.c();
        String r103 = r110.e();
        Object r104 = r110.get("public_key");
        if ((r104 instanceof String) == false) goto L7;
        String r105 = (String) r104;
    L8:
        Object r106 = r110.get("function_name");
        if ((r106 instanceof String) == false) goto L11;
        String r107 = (String) r106;
    L12:
        String r111 = r110.d();
        Object r112 = r110.get(AuthCore.AuthParam.KEY_EXTRA_OS_VERSION);
        if ((r112 instanceof String) == false) goto L15;
        String r113 = (String) r112;
    L16:
        Object r114 = r110.get(AuthCore.AuthParam.KEY_EXTRA_MODEL);
        if ((r114 instanceof String) == false) goto L19;
        String r115 = (String) r114;
    L20:
        Object r116 = r110.get(AuthCore.AuthParam.KEY_EXTRA_MODE);
        if ((r116 instanceof String) == false) goto L23;
        String r117 = (String) r116;
    L24:
        Object r118 = r110.get(AuthCore.AuthParam.KEY_EXTRA_APP_VERSION);
        if ((r118 instanceof String) == false) goto L27;
        String r119 = (String) r118;
    L28:
        Object r120 = r110.get(AuthCore.AuthParam.KEY_EXTRA_CUID);
        if ((r120 instanceof String) == false) goto L31;
        String r121 = (String) r120;
    L32:
        Object r108 = r110.get(AppInfo.KEY_NPTH_VERSION_NAME);
        if ((r108 instanceof String) == false) goto L35;
        String r109 = (String) r108;
    L37:
        if (r110.get("need_active") != null) goto L39;
        int r122 = 1;
    L40:
        Object r123 = r110.get("sdk_version_code");
        if ((r123 instanceof Integer) == false) goto L43;
        ((Integer) r123).intValue();
    L43:
        com.baidu.mapauto.auth.net.base.a r124 = r100.f31788a;
        if (r124 == null) goto L48;
        HashMap r125 = new HashMap(13);
        PublicKey r126 = RSAUtil.getPublicKeyFromPemString("MIIBCgKCAQEAz4ZBbWFih8n59i6cwKDW9aBQqMstCa0LgmkArRZ2WZgDLXFo9BBZAmcLqdgDUzm8yV7fB8isBDruyC3ADKSvWyJt5xQBGFiMkuEKvvnmbT4WEotwUu9Id3Xt0tPzefSixulhQ4UcaBNzPs2bU+1pphbsr2Rv4PdpMs66jZ8r5UF4H6fwAQwqRmhTKhSvkLvkhQ1nyxel/98nszHZRgKXTLv1EPafr290WJo24G+f6kEvGfK+gN87WCat8ftRZL7zeZSNLMDA5oqfjRKMZYg9eg6k0JWnAqUcY1MsLrQw7tFPkLlEVpd8rigfq0zPNZRrf1xdTCcnofpGD+WAH2nTIwIDAQAB", false);
        if (r126 == null) goto L48;
        r125.put("ak", RSAUtil.encryptToHexStringPub(r101, r126));
        r125.put("channel", r102);
        r125.put("service_name", r103);
        r125.put(PbRequest.SwitchType.PK, r105);
        r125.put("device_id", RSAUtil.encryptToHexStringPub(r111, r126));
        if (TextUtils.isEmpty(r107) == true) goto L53;
        r125.put("function_name", r107);
    L53:
        if (TextUtils.isEmpty(r113) == true) goto L56;
        r125.put("os_version", r113);
    L56:
        if (TextUtils.isEmpty(r117) == true) goto L59;
        r125.put("mode", r117);
    L59:
        if (TextUtils.isEmpty(r115) == true) goto L62;
        r125.put(DoraObricDeviceHomeViewModel.PARAM_PRODUCT_MODEL, r115);
    L62:
        if (TextUtils.isEmpty(r119) == true) goto L65;
        r125.put("app_version", r119);
    L65:
        if (TextUtils.isEmpty(r121) == true) goto L68;
        r125.put(EngineImpl.KEY_CUID, r121);
    L68:
        if (TextUtils.isEmpty(r109) == true) goto L70;
        r125.put("sdk_version", r109);
    L70:
        r125.put("need_active", Integer.valueOf(r122));
        return ((com.baidu.mapauto.auth.net.a) r124).a("/license/device/file", r125);
    L48:
        return null;
    L39:
        r122 = ((Integer) r110.get("need_active")).intValue();
        goto L40
    L35:
        r109 = null;
        goto L37
    L31:
        r121 = null;
        goto L32
    L27:
        r119 = null;
        goto L28
    L23:
        r117 = null;
        goto L24
    L19:
        r115 = null;
        goto L20
    L15:
        r113 = null;
        goto L16
    L11:
        r107 = null;
        goto L12
    L7:
        r105 = null;
        goto L8
    L72:
        return null;
    }

    @Override // com.baidu.mapauto.auth.base.BaseLicenseAuthDataStandardProcess
    public final com.baidu.mapauto.auth.base.b a(String r100) {
        return new com.baidu.mapauto.auth.proxy.b(r100);
    }

    public final boolean a(AuthCore.AuthParam r110, com.baidu.mapauto.auth.proxy.b r111) {
        com.baidu.mapauto.auth.data.license.impl.b r100 = this.f31928c;
        if (r100 == null) goto L75;
        String r101 = r110.e();
        String r112 = "";
        if (TextUtils.isEmpty(r100.f31790b) == true) goto L21;
        d r102 = r100.f31789a;
        if (r102 == null) goto L21;
        StringBuilder r113 = new StringBuilder("license_file");
        if (TextUtils.isEmpty(r101) == true) goto L14;
        r113.append("_");
        r113.append(r101);
    L14:
        if (TextUtils.isEmpty(null) == true) goto L16;
        r113.append("_null");
    L16:
        String r103 = r113.toString();
        SharedPreferences r104 = ((com.baidu.mapauto.auth.store.a) r102).f31933a;
        if (r104 == null) goto L20;
        r112 = r104.getString(r103, "");
    L20:
        r112 = AESGCMPKCS5PaddingUtil.decrypt(r112, r100.f31790b);
    L21:
        if (r112 != null) goto L82;
    L55:
        String r105 = r110.e();
        String r106 = r111.f31786a;
        if (TextUtils.isEmpty(r100.f31790b) == false) goto L59;
    L72:
        return false;
    L59:
        if (r100.f31789a == null) goto L72;
        if (TextUtils.isEmpty(r106) == true) goto L64;
        r106 = AESGCMPKCS5PaddingUtil.encrypt(r106, r100.f31790b);
    L64:
        d r107 = r100.f31789a;
        StringBuilder r108 = new StringBuilder("license_file");
        if (TextUtils.isEmpty(r105) == true) goto L68;
        r108.append("_");
        r108.append(r105);
    L68:
        if (TextUtils.isEmpty(null) == true) goto L70;
        r108.append("_null");
    L70:
        String r109 = r108.toString();
        SharedPreferences.Editor r114 = ((com.baidu.mapauto.auth.store.a) r107).f31934b;
        if (r114 == null) goto L72;
        return r114.putString(r109, r106).commit();
    L82:
        JSONObject r115 = new JSONObject(r112);     // Catch: JSONException -> L25
    L26:
        JSONObject r116 = r111.f31787b;
        if (r116 == null) goto L55;
        if (r115 == null) goto L55;
        JSONArray r117 = r116.optJSONArray("file");
        if (r117 == null) goto L55;
        if (r117.length() <= 0) goto L55;
        JSONArray r118 = r115.optJSONArray("file");
        if (r118 == null) goto L55;
        if (r118.length() <= 0) goto L55;
        JSONObject r119 = r111.f31787b;     // Catch: JSONException -> L54
        int r120 = r117.length();     // Catch: JSONException -> L77
        int r121 = 0;
    L39:
        if (r121 >= r118.length()) goto L52;
        String r122 = JSONArrayProtectorUtils.getJSONObject(r118, r121).optString("function");     // Catch: JSONException -> L77
        int r123 = 0;
    L42:
        if (r123 >= r120) goto L47;
        if (JSONArrayProtectorUtils.getJSONObject(r117, r123).optString("function").equals(r122) == false) goto L45;
        r123 = r123 + 1;     // Catch: JSONException -> L77
        goto L42
    L45:
        JSONObject r124 = JSONArrayProtectorUtils.getJSONObject(r118, r121);     // Catch: JSONException -> L77
        boolean r125 = true;
    L48:
        if (r125 == false) goto L51;
        if (r124 == null) goto L51;
        r117.put(r124);     // Catch: JSONException -> L77
    L51:
        r121 = r121 + 1;
        goto L39
    L47:
        r124 = null;
        r125 = false;
    L52:
        r119.put("file", r117);     // Catch: JSONException -> L54
        r111.f31786a = r111.f31787b.toString();     // Catch: JSONException -> L54
    L25:
        r115 = null;
        goto L26
    L75:
        return false;
    }

    @Override // com.baidu.mapauto.auth.base.BaseLicenseAuthDataStandardProcess
    public final void a(AuthCore.AuthParam r100, com.baidu.mapauto.auth.base.b r101) throws BaseLicenseAuthDataStandardProcess.ProcessException {
        com.baidu.mapauto.auth.proxy.b r102 = (com.baidu.mapauto.auth.proxy.b) r101;
        JSONObject r103 = r102.f31787b;
        String r104 = null;
        if (r103 != null) goto L5;
        JSONArray r105 = null;
    L6:
        if (r105 != null) goto L8;
    L10:
        JSONObject r106 = r102.f31787b;
        if (r106 != null) goto L13;
        JSONArray r107 = null;
    L14:
        if (r107 == null) goto L60;
        int r108 = r107.length();
        int r109 = 0;
        if (r108 == 1) goto L37;
        if (r108 <= 1) goto L45;
        Object r110 = r100.get("function_name");
        if ((r110 instanceof String) == false) goto L22;
        String r111 = (String) r110;
    L24:
        if (TextUtils.isEmpty(r111) == false) goto L57;
        HashMap r112 = new HashMap();
    L26:
        if (r109 >= r108) goto L35;
        JSONObject r113 = r107.optJSONObject(r109);
        if (r113 != null) goto L30;
        String r114 = null;
    L31:
        if (r113 != null) goto L33;
        Integer r115 = null;
    L34:
        r112.put(r114, r115);
        r109 = r109 + 1;
        goto L26
    L33:
        r115 = Integer.valueOf(r113.optInt("error_code"));
        goto L34
    L30:
        r114 = r113.optString("function");
        goto L31
    L35:
        BaseLicenseAuthDataStandardProcess.ProcessException r116 = new BaseLicenseAuthDataStandardProcess.ProcessException(-1007, "所申请一个或多个LICENSE授权错误");
        r116.setErrors(r112);
        throw r116;
    L57:
        return;
    L22:
        r111 = null;
        goto L24
    L45:
        return;
    L37:
        JSONObject r117 = r107.optJSONObject(0);
        if (r117 != null) goto L40;
        Integer r118 = null;
    L41:
        if (r118 != null) goto L44;
        return;
    L44:
        if (r118.intValue() == 0) goto L58;
        if (r117 == null) goto L50;
        r104 = r117.optString("error_msg");
    L50:
        if (TextUtils.isEmpty(r104) == false) goto L53;
        r104 = "没有权限";
    L53:
        throw new BaseLicenseAuthDataStandardProcess.ProcessException(r118.intValue(), r104);
    L58:
        return;
    L40:
        r118 = Integer.valueOf(r117.optInt("error_code"));
        goto L41
    L60:
        return;
    L13:
        r107 = r106.optJSONArray("errors");
        goto L14
    L8:
        if (r105.length() <= 0) goto L10;
        return;
    L5:
        r105 = r103.optJSONArray("file");
        goto L6
    }

    @Override // com.baidu.mapauto.auth.base.BaseLicenseAuthDataStandardProcess
    public final ArrayList a(int r100, AuthCore.AuthParam r101, com.baidu.mapauto.auth.base.b r102) {
        JSONObject r103 = ((com.baidu.mapauto.auth.proxy.b) r102).f31787b;
        if (r103 != null) goto L5;
        JSONArray r104 = null;
    L6:
        int r105 = 0;
        if (r104 == null) goto L21;
        int r106 = r104.length();
        ArrayList r107 = new ArrayList((r106 * 2) + 1);
    L10:
        if (r105 >= r106) goto L17;
        JSONObject r108 = r104.optJSONObject(r105);
        if (r108 == null) goto L15;
        com.baidu.mapauto.auth.proxy.a r109 = new com.baidu.mapauto.auth.proxy.a(r108);
        r107.add(new com.baidu.mapauto.auth.verification.a(r100, r101, r109));
        r107.add(new com.baidu.mapauto.auth.verification.b(r100, r101, r109));
    L15:
        r105 = r105 + 1;
        goto L10
    L17:
        return r107;
    L21:
        return new ArrayList(0);
    L5:
        r104 = r103.optJSONArray("file");
        goto L6
    }
}
