package ac4;

import android.app.Activity;
import android.content.Intent;
import android.widget.Toast;
import com.bytedance.bdturing.BdTuringConfig;
import com.bytedance.common.wschannel.WsConstants;
import com.bytedance.mt.protector.impl.UriProtector;
import com.bytedance.sdk.account.platform.api.IGoogleService;
import com.ss.android.ugc.effectmanager.EffectConfiguration;
import org.json.JSONException;
import org.json.JSONObject;
import qb4.c0;

/* JADX INFO: loaded from: classes14.dex */
public class e implements a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Activity f2686a;

    public void c(c r100) {
        throw null;
    }

    public void d(int r100, String r101) {
        throw null;
    }

    public void e() {
    }

    public e(Activity r100) {
        this.f2686a = r100;
    }

    @Override // ac4.a
    public final void a(c r100) {
        String r101 = r100.f2679a;     // Catch: JSONException -> L67
        if (r101 != null) goto L6;
        return;
    L6:
        switch(r101.hashCode()) {
            case -440027648: goto L36;
            case -433891794: goto L33;
            case -431325456: goto L30;
            case -418116003: goto L27;
            case -294538015: goto L24;
            case -268991152: goto L21;
            case 103102532: goto L18;
            case 239578933: goto L15;
            case 428780843: goto L12;
            case 1807041893: goto L9;
            default: goto L38;
        };     // Catch: JSONException -> L67
    L38:
        byte r102 = -1;
    L39:
        JSONObject r103 = null;
        switch(r102) {
            case 0: goto L71;
            case 1: goto L63;
            case 2: goto L61;
            case 3: goto L57;
            case 4: goto L52;
            case 5: goto L51;
            case 6: goto L48;
            case 7: goto L44;
            case 8: goto L43;
            case 9: goto L42;
            default: goto L87;
        };
    L42:
        e();     // Catch: JSONException -> L67
        return;
    L43:
        c(r100);     // Catch: JSONException -> L67
        return;
    L44:
        BdTuringConfig r104 = qb4.b.c.f532315a.f532302a;     // Catch: JSONException -> L67
        if (r104 == null) goto L47;
        r103 = r104.getTheme(4);     // Catch: JSONException -> L67
    L47:
        r100.d(1, r103);     // Catch: JSONException -> L67
        return;
    L48:
        JSONObject r105 = new JSONObject(r100.f2680b);     // Catch: JSONException -> L67
        String r106 = r105.optString(IGoogleService.ResponseKey.PHONE_NUMBER);     // Catch: JSONException -> L67
        String r107 = r105.optString("sms_content");     // Catch: JSONException -> L67
        if (this.f2686a == null) goto L77;
        Intent r108 = new Intent("android.intent.action.SENDTO", UriProtector.parse("smsto:" + r106));     // Catch: JSONException -> L67
        r108.putExtra("sms_body", r107);     // Catch: JSONException -> L67
        this.f2686a.startActivity(r108);     // Catch: JSONException -> L67
        return;
    L77:
        return;
    L51:
        r100.d(1, null);     // Catch: JSONException -> L67
        return;
    L52:
        new JSONObject(r100.f2680b).optString("text");     // Catch: JSONException -> L67
        if (this.f2686a != null) goto L55;
        return;
    L55:
        if (com.bytedance.bdturing.twiceverify.a.a().f202111a == null) goto L81;
        com.bytedance.bdturing.twiceverify.a.a().f202111a.showLoading();     // Catch: JSONException -> L67
        return;
    L81:
        return;
    L57:
        String r109 = new JSONObject(r100.f2680b).optString("text");     // Catch: JSONException -> L67
        Activity r110 = this.f2686a;     // Catch: JSONException -> L67
        if (r110 == null) goto L83;
        Toast.makeText(r110, r109, 0).show();     // Catch: JSONException -> L67
        return;
    L83:
        return;
    L63:
        JSONObject r111 = new JSONObject(r100.f2680b);     // Catch: JSONException -> L67
        d(r111.optInt("status_code"), r111.optString("message"));     // Catch: JSONException -> L67
        return;
    L71:
        c0.a.f532328a.a(new d(this, new JSONObject(r100.f2680b), r100));     // Catch: Exception -> L70
        return;
    L90:
        return;
    L87:
        return;
    L61:
        if (com.bytedance.bdturing.twiceverify.a.a().f202111a == null) goto L85;
        com.bytedance.bdturing.twiceverify.a.a().f202111a.dismissLoading();     // Catch: JSONException -> L67
        return;
    L85:
        return;
    L9:
        if (r101.equals("second_verify.openSms") == false) goto L38;
        r102 = 6;
        goto L39
    L12:
        if (r101.equals("bytedcert.getSettings") == false) goto L38;
        r102 = 7;
        goto L39
    L15:
        if (r101.equals("second_verify.showLoading") == false) goto L38;
        r102 = 4;
        goto L39
    L18:
        if (r101.equals("second_verify.isSmsAvailable") == false) goto L38;
        r102 = 5;
        goto L39
    L21:
        if (r101.equals("second_verify.hideLoading") == false) goto L38;
        r102 = 2;
        goto L39
    L24:
        if (r101.equals("second_verify.h5_available") == false) goto L38;
        r102 = 9;
        goto L39
    L27:
        if (r101.equals("second_verify.toast") == false) goto L38;
        r102 = 3;
        goto L39
    L30:
        if (r101.equals("second_verify.fetch") == false) goto L38;
        r102 = 0;
        goto L39
    L33:
        if (r101.equals("second_verify.close") == false) goto L38;
        r102 = 1;
        goto L39
    L36:
        if (r101.equals("bytedcert.getSdkInfo") == false) goto L38;
        r102 = 8;
    L67:
        e = move-exception;
        e.printStackTrace();
    }

    public static void b(e r100, JSONObject r101, BdTuringConfig r102) throws JSONException {
        r100.getClass();
        if (r102 == null) goto L55;
        if (r101.has("app_name") == true) goto L8;
        r101.put("app_name", r102.getAppName());
    L8:
        if (r101.has("app_version") == true) goto L11;
        r101.put("app_version", r102.getAppVersion());
    L11:
        if (r101.has("version_code") == true) goto L14;
        r101.put("version_code", r102.getAppVersionCode());
    L14:
        if (r101.has("version_name") == true) goto L17;
        r101.put("version_name", r102.getAppVersion());
    L17:
        if (r101.has("aid") == true) goto L20;
        r101.put("aid", r102.getAppId());
    L20:
        if (r101.has(WsConstants.KEY_INSTALL_ID) == true) goto L23;
        r101.put(WsConstants.KEY_INSTALL_ID, r102.getInstallId());
    L23:
        if (r101.has("device_id") == true) goto L26;
        r101.put("device_id", r102.getDeviceId());
    L26:
        if (r101.has("device_model") == true) goto L29;
        r101.put("device_model", r102.getDeviceModel());
    L29:
        if (r101.has("device_brand") == true) goto L32;
        r101.put("device_brand", r102.getDeviceBrand());
    L32:
        if (r101.has("os_type") == true) goto L35;
        r101.put("os_type", r102.getOsType());
    L35:
        if (r101.has("os_version") == true) goto L38;
        r101.put("os_version", r102.getOsVersion());
    L38:
        if (r101.has("channel") == true) goto L41;
        r101.put("channel", r102.getChannel());
    L41:
        if (r101.has(EffectConfiguration.KEY_REGION) == true) goto L46;
        if (r102.getRegionType() == null) goto L46;
        r101.put(EffectConfiguration.KEY_REGION, r102.getRegionType().getName());
    L46:
        if (r101.has("sdk_version") == true) goto L49;
        r101.put("sdk_version", r102.getSdkVersion());
    L49:
        if (r101.has("language") == true) goto L52;
        r101.put("language", r102.getLanguage());
    L52:
        if (r101.has("locale") == true) goto L55;
        r101.put("locale", r102.getLocale());
    L55:
        if (r101.has("time") == true) goto L58;
        r101.put("time", System.currentTimeMillis());
    L58:
        if (r101.has("device_platform") == true) goto L61;
        r101.put("device_platform", "android");
    L61:
        if (r101.has("resolution") == true) goto L64;
        r101.put("resolution", hc4.f.i());
        return;
    }
}
