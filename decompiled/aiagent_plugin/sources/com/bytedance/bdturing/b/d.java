package com.bytedance.bdturing.b;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.widget.Toast;
import com.bytedance.bdturing.BdTuringConfig;
import com.bytedance.bdturing.VerifyTaskHandler;
import com.bytedance.common.wschannel.WsConstants;
import com.bytedance.crash.general.HardwareInfo;
import com.bytedance.crash.general.RomInfo;
import com.ss.android.socialbase.downloader.constants.MonitorConstants;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import org.json.JSONException;
import org.json.JSONObject;
import os.teatracker.IBdInstall;

/* JADX INFO: compiled from: TwiceVerifyHandler.java */
/* JADX INFO: loaded from: classes.dex */
public class d implements a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private Activity f6524a;

    static /* synthetic */ Activity a(d r0) {
        return r0.f6524a;
    }

    static /* synthetic */ void a(d r2, JSONObject r3, BdTuringConfig r4, Activity r5) {
        r2.a(r3, r4, (Activity) ZeusTransformUtils.wrapperContextForParams(r5, Activity.class, "com.obric.aiagent.plugin"));
    }

    public d(Activity r3) {
        this.f6524a = ZeusTransformUtils.wrapperContext2Activity((Activity) ZeusTransformUtils.wrapperContextForParams(r3, Activity.class, "com.obric.aiagent.plugin"), "com.obric.aiagent.plugin");
    }

    private void a(JSONObject r3, BdTuringConfig r4, Activity r5) {
        Activity r2 = (Activity) ZeusTransformUtils.wrapperContextForParams(r5, Activity.class, "com.obric.aiagent.plugin");
        if (r4 == null) goto L53;
        if (r3.has(IBdInstall.PARAM_APP_NAME) == true) goto L8;
        r3.put(IBdInstall.PARAM_APP_NAME, r4.getAppName());
    L8:
        if (r3.has(WsConstants.KEY_APP_VERSION) == true) goto L11;
        r3.put(WsConstants.KEY_APP_VERSION, r4.getAppVersion());
    L11:
        if (r3.has("version_code") == true) goto L14;
        r3.put("version_code", r4.getAppVersionCode());
    L14:
        if (r3.has("version_name") == true) goto L17;
        r3.put("version_name", r4.getAppVersion());
    L17:
        if (r3.has(WsConstants.KEY_APP_ID) == true) goto L20;
        r3.put(WsConstants.KEY_APP_ID, r4.getAppId());
    L20:
        if (r3.has(WsConstants.KEY_INSTALL_ID) == true) goto L23;
        r3.put(WsConstants.KEY_INSTALL_ID, r4.getInstallId());
    L23:
        if (r3.has("device_id") == true) goto L26;
        r3.put("device_id", r4.getDeviceId());
    L26:
        if (r3.has(HardwareInfo.KEY_HW_VENDOR_MODEL) == true) goto L29;
        r3.put(HardwareInfo.KEY_HW_VENDOR_MODEL, r4.getDeviceModel());
    L29:
        if (r3.has(HardwareInfo.KEY_HW_VENDOR_BRAND) == true) goto L32;
        r3.put(HardwareInfo.KEY_HW_VENDOR_BRAND, r4.getDeviceBrand());
    L32:
        if (r3.has("os_type") == true) goto L35;
        r3.put("os_type", r4.getOsType());
    L35:
        if (r3.has(RomInfo.KEY_ROM_OS_VERSION) == true) goto L38;
        r3.put(RomInfo.KEY_ROM_OS_VERSION, r4.getOsVersion());
    L38:
        if (r3.has("channel") == true) goto L41;
        r3.put("channel", r4.getChannel());
    L41:
        if (r3.has("region") == true) goto L44;
        r3.put("region", r4.getRegionType());
    L44:
        if (r3.has("sdk_version") == true) goto L47;
        r3.put("sdk_version", r4.getSdkVersion());
    L47:
        if (r3.has("language") == true) goto L50;
        r3.put("language", r4.getLanguage());
    L50:
        if (r3.has("locale") == true) goto L53;
        r3.put("locale", r4.getLocale());
    L53:
        if (r3.has("time") == true) goto L56;
        r3.put("time", System.currentTimeMillis());
    L56:
        if (r3.has("device_platform") == true) goto L59;
        r3.put("device_platform", "android");
    L59:
        if (r3.has(HardwareInfo.KEY_HW_DISPLAY_RESOLUTION) == true) goto L63;
        if (r2 == null) goto L64;
        r3.put(HardwareInfo.KEY_HW_DISPLAY_RESOLUTION, com.bytedance.bdturing.utils.d.b(r2));
        return;
    L64:
        return;
    }

    @Override // com.bytedance.bdturing.b.a
    public void b(c r5) {
    L46:
        e = move-exception;
        e.printStackTrace();
        return;
    L3:
        if (r5.f6520b != null) goto L5;
        return;
    L5:
        String r0 = r5.f6520b;     // Catch: JSONException -> L46
        byte r1 = -1;
        switch(r0.hashCode()) {
            case -433891794: goto L30;
            case -431325456: goto L27;
            case -418116003: goto L24;
            case -268991152: goto L21;
            case 103102532: goto L18;
            case 239578933: goto L15;
            case 428780843: goto L12;
            case 1807041893: goto L9;
            default: goto L33;
        };     // Catch: JSONException -> L46
    L33:
        switch(r1) {
            case 0: goto L44;
            case 1: goto L43;
            case 2: goto L41;
            case 3: goto L39;
            case 4: goto L38;
            case 5: goto L37;
            case 6: goto L36;
            case 7: goto L35;
            default: goto L58;
        };
    L35:
        a(r5);     // Catch: JSONException -> L46
        return;
    L36:
        JSONObject r2 = new JSONObject(r5.f6521c);     // Catch: JSONException -> L46
        a(r2.optString("phone_number"), r2.optString("sms_content"));     // Catch: JSONException -> L46
        return;
    L37:
        r5.a(1, null);     // Catch: JSONException -> L46
        return;
    L38:
        a(new JSONObject(r5.f6521c).optString("text"));     // Catch: JSONException -> L46
        return;
    L39:
        b(new JSONObject(r5.f6521c).optString("text"));     // Catch: JSONException -> L46
        return;
    L43:
        JSONObject r3 = new JSONObject(r5.f6521c);     // Catch: JSONException -> L46
        a(r3.optInt(MonitorConstants.STATUS_CODE), r3.optString("message"));     // Catch: JSONException -> L46
        return;
    L44:
        c(r5);     // Catch: JSONException -> L46
        return;
    L58:
        return;
    L41:
        if (com.bytedance.bdturing.twiceverify.c.a().c() == null) goto L55;
        com.bytedance.bdturing.twiceverify.c.a().c().a();     // Catch: JSONException -> L46
        return;
    L55:
        return;
    L9:
        if (r0.equals("second_verify.openSms") == false) goto L33;
        r1 = 6;
        goto L33
    L12:
        if (r0.equals("bytedcert.getSettings") == false) goto L33;
        r1 = 7;
        goto L33
    L15:
        if (r0.equals("second_verify.showLoading") == false) goto L33;
        r1 = 4;
        goto L33
    L18:
        if (r0.equals("second_verify.isSmsAvailable") == false) goto L33;
        r1 = 5;
        goto L33
    L21:
        if (r0.equals("second_verify.hideLoading") == false) goto L33;
        r1 = 2;
        goto L33
    L24:
        if (r0.equals("second_verify.toast") == false) goto L33;
        r1 = 3;
        goto L33
    L27:
        if (r0.equals("second_verify.fetch") == false) goto L33;
        r1 = 0;
        goto L33
    L30:
        if (r0.equals("second_verify.close") == false) goto L33;
        r1 = 1;
        goto L33
    }

    public void a(c r2) {
        if (com.bytedance.bdturing.b.a().b() == null) goto L5;
        JSONObject r1 = com.bytedance.bdturing.b.a().b().getTheme(4);
    L6:
        r2.a(1, r1);
        return;
    L5:
        r1 = null;
        goto L6
    }

    public void a(String r3, String r4) {
        if (this.f6524a == null) goto L6;
        Intent r0 = new Intent("android.intent.action.SENDTO", Uri.parse("smsto:" + r3));
        r0.putExtra("sms_body", r4);
        ZeusTransformUtils.startActivity(this.f6524a, r0, "com.obric.aiagent.plugin");
        return;
    }

    public void a(String r2) {
        if (this.f6524a != null) goto L5;
        return;
    L5:
        if (com.bytedance.bdturing.twiceverify.c.a().c() == null) goto L9;
        com.bytedance.bdturing.twiceverify.c.a().c().a(this.f6524a, r2);
        return;
    }

    public void b(String r2) {
        Activity r1 = this.f6524a;
        if (r1 == null) goto L6;
        Toast.makeText(r1, r2, 0).show();
        return;
    }

    public void a(int r2, String r3) {
        com.bytedance.bdturing.twiceverify.c.a r0 = com.bytedance.bdturing.twiceverify.c.a().e();
        if (r0 != null) goto L5;
        return;
    L5:
        if (r2 != 0) goto L7;
        r0.a();
    L8:
        Activity r1 = this.f6524a;
        if (r1 == null) goto L12;
        r1.finish();
        return;
    L12:
        return;
    L7:
        r0.a(r2, r3);
        goto L8
    }

    public void c(final c r4) {
        final JSONObject r0 = new JSONObject(r4.f6521c);     // Catch: Exception -> L4
        VerifyTaskHandler.a().a(new AnonymousClass1(this, r0, r4));     // Catch: Exception -> L4
        return;
    }
}
