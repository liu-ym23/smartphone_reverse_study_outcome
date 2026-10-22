package com.baidu.mapauto.auth.process;

import android.content.SharedPreferences;
import android.text.TextUtils;
import com.baidu.mapauto.auth.AuthCore;
import com.baidu.mapauto.auth.base.BaseLicenseAuthDataStandardProcess;
import com.baidu.mapauto.auth.proxy.c;
import com.baidu.mapauto.auth.proxy.d;
import com.baidu.mapauto.auth.util.AESGCMPKCS5PaddingUtil;
import com.baidu.mapauto.auth.util.RSAUtil;
import com.baidu.mshield.x6.EngineImpl;
import com.bytedance.android.live.network.annotation.PbRequest;
import com.bytedance.crash.general.AppInfo;
import com.larus.dora.obric.device_management.device_home.DoraObricDeviceHomeViewModel;
import java.security.PublicKey;
import java.util.ArrayList;
import java.util.HashMap;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes39.dex */
public final class b extends BaseLicenseAuthDataStandardProcess<d, c> {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final com.baidu.mapauto.auth.data.license.impl.a f31929b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final com.baidu.mapauto.auth.data.license.impl.b f31930c;

    public b(int r100, com.baidu.mapauto.auth.data.license.impl.a r101, com.baidu.mapauto.auth.data.license.impl.b r102) {
        super(r100);
        this.f31929b = r101;
        this.f31930c = r102;
    }

    @Override // com.baidu.mapauto.auth.base.BaseLicenseAuthDataStandardProcess
    public final /* bridge */ /* synthetic */ boolean b(AuthCore.AuthParam r100, com.baidu.mapauto.auth.base.b r101) {
        return a(r100, (d) r101);
    }

    @Override // com.baidu.mapauto.auth.base.BaseLicenseAuthDataStandardProcess
    public final HashMap a(com.baidu.mapauto.auth.base.b r100) {
        JSONObject r101 = ((d) r100).f31787b;
        if (r101 != null) goto L5;
        JSONObject r102 = null;
    L7:
        if (r102 == null) goto L24;
        JSONArray r103 = r102.optJSONArray("functions");
        if (r103 == null) goto L25;
        int r104 = r103.length();
        HashMap r105 = new HashMap(r104);
        int r106 = 0;
    L13:
        if (r106 >= r104) goto L20;
        String r107 = r103.optString(r106);
        if (TextUtils.isEmpty(r107) == true) goto L18;
        r105.put(r107, 0);
    L18:
        r106 = r106 + 1;
        goto L13
    L20:
        return r105;
    L25:
        return new HashMap(0);
    L24:
        return new HashMap(0);
    L5:
        r102 = r101.optJSONObject("file");
        goto L7
    }

    @Override // com.baidu.mapauto.auth.base.BaseLicenseAuthDataStandardProcess
    public final String b(AuthCore.AuthParam r100) {
        com.baidu.mapauto.auth.data.license.impl.b r101 = this.f31930c;
        if (r101 == null) goto L19;
        String r102 = r100.e();
        String r103 = "";
        if (TextUtils.isEmpty(r101.f31790b) == true) goto L21;
        com.baidu.mapauto.auth.base.d r104 = r101.f31789a;
        if (r104 == null) goto L22;
        StringBuilder r105 = new StringBuilder("license_function");
        if (TextUtils.isEmpty(r102) == true) goto L13;
        r105.append("_");
        r105.append(r102);
    L13:
        String r106 = r105.toString();
        SharedPreferences r107 = ((com.baidu.mapauto.auth.store.a) r104).f31933a;
        if (r107 == null) goto L18;
        r103 = r107.getString(r106, "");
    L18:
        return AESGCMPKCS5PaddingUtil.decrypt(r103, r101.f31790b);
    L22:
        return "";
    L21:
        return "";
    L19:
        return null;
    }

    @Override // com.baidu.mapauto.auth.base.BaseLicenseAuthDataStandardProcess
    public final com.baidu.mapauto.auth.net.b c(AuthCore.AuthParam r110) throws Exception {
        com.baidu.mapauto.auth.data.license.impl.a r100 = this.f31929b;
        if (r100 == null) goto L75;
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
        if (TextUtils.isEmpty(r107) == true) goto L53;
        r125.put("function_name", r107);
    L53:
        if (TextUtils.isEmpty(r111) == true) goto L56;
        r125.put("device_id", RSAUtil.encryptToHexStringPub(r111, r126));
    L56:
        if (TextUtils.isEmpty(r113) == true) goto L59;
        r125.put("os_version", r113);
    L59:
        if (TextUtils.isEmpty(r117) == true) goto L62;
        r125.put("mode", r117);
    L62:
        if (TextUtils.isEmpty(r115) == true) goto L65;
        r125.put(DoraObricDeviceHomeViewModel.PARAM_PRODUCT_MODEL, r115);
    L65:
        if (TextUtils.isEmpty(r119) == true) goto L68;
        r125.put("app_version", r119);
    L68:
        if (TextUtils.isEmpty(r121) == true) goto L71;
        r125.put(EngineImpl.KEY_CUID, r121);
    L71:
        if (TextUtils.isEmpty(r109) == true) goto L73;
        r125.put("sdk_version", r109);
    L73:
        r125.put("need_active", Integer.valueOf(r122));
        return ((com.baidu.mapauto.auth.net.a) r124).a("/license/permission/verify", r125);
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
    L75:
        return null;
    }

    @Override // com.baidu.mapauto.auth.base.BaseLicenseAuthDataStandardProcess
    public final com.baidu.mapauto.auth.base.b a(String r100) {
        return new d(r100);
    }

    public final boolean a(AuthCore.AuthParam r100, d r101) {
        com.baidu.mapauto.auth.data.license.impl.b r102 = this.f31930c;
        if (r102 == null) goto L21;
        String r103 = r100.e();
        String r104 = r101.f31786a;
        if (TextUtils.isEmpty(r102.f31790b) == false) goto L8;
        return false;
    L8:
        if (r102.f31789a != null) goto L11;
        return false;
    L11:
        if (TextUtils.isEmpty(r104) == true) goto L13;
        r104 = AESGCMPKCS5PaddingUtil.encrypt(r104, r102.f31790b);
    L13:
        com.baidu.mapauto.auth.base.d r105 = r102.f31789a;
        StringBuilder r106 = new StringBuilder("license_function");
        if (TextUtils.isEmpty(r103) == true) goto L16;
        r106.append("_");
        r106.append(r103);
    L16:
        String r107 = r106.toString();
        SharedPreferences.Editor r108 = ((com.baidu.mapauto.auth.store.a) r105).f31934b;
        if (r108 != null) goto L20;
        return false;
    L20:
        return r108.putString(r107, r104).commit();
    L21:
        return false;
    }

    @Override // com.baidu.mapauto.auth.base.BaseLicenseAuthDataStandardProcess
    public final ArrayList a(int r100, AuthCore.AuthParam r101, com.baidu.mapauto.auth.base.b r102) {
        ArrayList r103 = new ArrayList(2);
        JSONObject r104 = ((d) r102).f31787b;
        if (r104 != null) goto L5;
        JSONObject r105 = null;
    L6:
        c r106 = new c(r105);
        r103.add(new com.baidu.mapauto.auth.verification.d(r100, r101, r106));
        r103.add(new com.baidu.mapauto.auth.verification.c(r100, r101, r106));
        return r103;
    L5:
        r105 = r104.optJSONObject("file");
        goto L6
    }
}
