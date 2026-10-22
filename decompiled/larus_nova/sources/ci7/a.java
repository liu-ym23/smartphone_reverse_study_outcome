package ci7;

import android.app.Application;
import android.content.SharedPreferences;
import android.net.Uri;
import android.os.Build;
import android.text.TextUtils;
import com.bytedance.mt.protector.impl.UriProtector;
import com.bytedance.ug.sdk.deeplink.IZlinkDepend;
import com.bytedance.ug.sdk.deeplink.interfaces.IExecutor;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes22.dex */
public final class a {
    public static String a(String r110, String r111, JSONObject r112) {
        JSONObject r100 = null;
        if (TextUtils.isEmpty(r110) == true) goto L6;
        JSONObject r101 = new JSONObject();
        mi7.d.a(r101, "multi_scheme", r110);
    L9:
        String r113 = "";
        if (r101 != null) goto L12;
        return "";
    L12:
        IZlinkDepend r102 = p.a();
        if (r102 == null) goto L15;
        mi7.d.a(r101, "zlink_update_version_code", String.valueOf(r102.getUpdateVersionCode()));
    L15:
        byte[] r103 = r101.toString().getBytes();
        Uri.Builder r104 = UriProtector.parse("https://zlink.toutiao.com/api/cb_d").buildUpon();
        if (r104 == null) goto L21;
        r104.appendQueryParameter("device_platform", "android");
        r104.appendQueryParameter("os_version", Build.VERSION.RELEASE);
        r104.appendQueryParameter("sdk_version", "1.2.5-alpha.0");
        if (r102 == null) goto L20;
        r104.appendQueryParameter("app_id", r102.getAppId());
        r104.appendQueryParameter("device_id", r102.getDeviceId());
    L20:
        String r105 = r104.toString();
    L22:
        Application r106 = l.a();
        List<WeakReference<ki7.b>> r107 = ki7.c.f503641a;
        long r108 = ki7.d.b(r106).optLong("clipboard_verify_timeout", 0);
        long r114 = System.currentTimeMillis();
        String r109 = mi7.f.c(r105, new HashMap(), r103, r108, r112);
        long r115 = System.currentTimeMillis() - r114;
        if (TextUtils.isEmpty("total_duration") == true) goto L30;
        r112.put("total_duration", r115);     // Catch: JSONException -> L27
    L27:
        e = move-exception;
        e.printStackTrace();
    L30:
        if (TextUtils.isEmpty("clipboard_verify_timeout") == true) goto L37;
        r112.put("clipboard_verify_timeout", r108);     // Catch: JSONException -> L34
    L34:
        e = move-exception;
        e.printStackTrace();
    L37:
        if (TextUtils.isEmpty(r109) == true) goto L39;
        r100 = new JSONObject(r109);     // Catch: JSONException -> L48
    L50:
        if (r100 == null) goto L74;
        int r116 = r100.optInt("code", -1);
        if (r116 != 0) goto L61;
        JSONObject r117 = r100.optJSONObject("data");
        if (r117 == null) goto L84;
        r113 = r117.optString("scheme");
    L84:
        JSONObject r118 = new JSONObject();     // Catch: Exception -> L60
        r118.put("scheme", r113);     // Catch: Exception -> L60
        mi7.k.c("request scheme success", "clipboard_invoke", r118, mi7.m.f514108a);     // Catch: Exception -> L60
    L70:
        if (TextUtils.isEmpty(r111) == true) goto L73;
        int r119 = e.f23861a;
        e.a(l.a());
    L73:
        mi7.d.a(r112, "code", String.valueOf(r116));
        mi7.d.a(r112, "scheme", r113);
        goto L74
    L61:
        String r120 = r100.optString("message");
        JSONObject r121 = new JSONObject();     // Catch: Exception -> L75
        r121.put("code", r116);     // Catch: Exception -> L75
        r121.put("message", r120);     // Catch: Exception -> L75
        mi7.j r122 = new mi7.j("clipboard_invoke", "request scheme error", r121, mi7.m.f514108a);     // Catch: Exception -> L75
        IExecutor r123 = (IExecutor) z.a(IExecutor.class);     // Catch: Exception -> L75
        if (r123 == null) goto L68;
        r123.executeWithSingleThread(r122);     // Catch: Throwable -> L66
    L66:
        th = move-exception;
        th.printStackTrace();     // Catch: Exception -> L75
    L68:
        mi7.e.a("ClipboardSecurityUtils", "the request of clipboard check is failed, the message is : " + r120);
    L74:
        return r113;
    L48:
        e = move-exception;
        e.printStackTrace();
        goto L50
    L39:
        if (TextUtils.isEmpty(r111) == true) goto L74;
        int r124 = e.f23861a;
        mi7.g.a(l.a()).getClass();
        if (mi7.g.f514094a == null) goto L74;
        if (TextUtils.isEmpty("KEY_LAST_CB_D_EEROR_TTCB_CONTENT") == true) goto L74;
        SharedPreferences.Editor r125 = mi7.g.f514094a.edit();
        r125.putString("KEY_LAST_CB_D_EEROR_TTCB_CONTENT", r111);
        r125.apply();
        goto L74
    L21:
        r105 = "";
        goto L22
    L6:
        if (TextUtils.isEmpty(r111) == true) goto L8;
        r101 = new JSONObject();
        mi7.d.a(r101, "cb", r111);
        goto L9
    L8:
        r101 = null;
        goto L9
    }
}
