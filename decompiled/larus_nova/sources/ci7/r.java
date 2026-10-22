package ci7;

import android.content.ContentResolver;
import android.content.Context;
import android.content.SharedPreferences;
import android.database.Cursor;
import android.net.Uri;
import android.os.Build;
import android.text.TextUtils;
import com.bytedance.mt.protector.impl.UriProtector;
import com.bytedance.ug.sdk.deeplink.IZlinkDepend;
import com.bytedance.ug.sdk.deeplink.interfaces.INetwork;
import com.huawei.hms.android.SystemUtils;
import com.ss.android.downloadlib.constants.EventConstants;
import com.ss.android.socialbase.appdownloader.util.RomUtils;
import java.util.HashMap;
import java.util.Locale;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
public final class r {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final AtomicBoolean f23881a;

    public static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final r f23882a = null;

        static {
            f23882a = new r();
        }
    }

    public r() {
        this.f23881a = new AtomicBoolean(false);
    }

    public final void a(Context r210) {
        String r100 = "0";
        String r101 = "null";
        if (r210 != null) goto L5;
        return;
    L5:
        Context r102 = r210.getApplicationContext();
        boolean r103 = mi7.b.f514088a;
        String r104 = Build.MANUFACTURER;
        if (r104 != null) goto L8;
    L12:
        boolean r105 = false;
    L13:
        if (r105 == true) goto L16;
        return;
    L16:
        if (mi7.b.a(r102) == true) goto L19;
        return;
    L19:
        if (this.f23881a.getAndSet(true) == false) goto L21;
        return;
    L21:
        mi7.g r106 = mi7.g.a(r102);
        if (r106 != null) goto L24;
    L28:
        boolean r110 = false;
    L29:
        if (r110 == false) goto L31;
        return;
    L31:
        ContentResolver r111 = r102.getContentResolver();
        if (r111 != null) goto L34;
        return;
    L34:
        String[] r112 = {r102.getPackageName()};
        Uri r107 = UriProtector.parse("content://com.huawei.appmarket.commondata/item/5");
        f06.c r113 = new f06.c();
        String r211 = null;
        Object[] r114 = {r107, null, null, r112, null};
        f06.b r212 = new f06.b();
        f06.d r115 = r113.b(240004, "android/content/ContentResolver", "query", r111, r114, "android.database.Cursor", r212);
        if (r115.f474982a == false) goto L37;
        r113.a(240004, "android/content/ContentResolver", "query", r111, r114, null, r212, false);
        Cursor r108 = (Cursor) r115.f474983b;
    L38:
        Cursor r109 = r108;
        if (r109 != null) goto L89;
        return;
    L89:
        r109.moveToFirst();     // Catch: Throwable -> L53 Exception -> L55
        String r116 = r109.getString(0);     // Catch: Throwable -> L53 Exception -> L55
        String r117 = r109.getString(1);     // Catch: Exception -> L51 Throwable -> L53
        r100 = r109.getString(2);     // Catch: Exception -> L49 Throwable -> L53
        if (r109.getColumnCount() <= 4) goto L48;
        r101 = r109.getString(4);     // Catch: Exception -> L49 Throwable -> L53
    L48:
        r109.close();
    L59:
        IZlinkDepend r118 = p.a();
        if (r118 == null) goto L62;
        String r119 = r118.getAppId();
        String r120 = r118.getDeviceId();
    L63:
        Uri.Builder r121 = UriProtector.parse("https://zlink.ugsdk.cn/ug/ad/display/store_referrer").buildUpon();
        r121.appendQueryParameter("referrer", r116);
        r121.appendQueryParameter("click_time", r117);
        r121.appendQueryParameter(EventConstants.ExtraJson.KEY_INSTALL_TIME, r100);
        r121.appendQueryParameter("track_id", r101);
        r121.appendQueryParameter("ad_platform", RomUtils.BRAND_HUAWEI);
        r121.appendQueryParameter("app_id", r119);
        r121.appendQueryParameter("device_id", r120);
        String r122 = r121.toString();
        INetwork r123 = (INetwork) z.a(INetwork.class);
        long r124 = System.currentTimeMillis();
        if (r123 != null) goto L68;
        mi7.e.a("HuaWeiReferrerHelper", "the INetwork is null so the request couldn't be sent !");     // Catch: Throwable -> L66
    L91:
    L72:
        if (TextUtils.isEmpty(r211) == true) goto L80;
        this.f23881a.set(true);
        b(r116, r124, true);
        if (r106 != null) goto L76;
        return;
    L76:
        if (mi7.g.f514094a != null) goto L78;
        return;
    L78:
        if (TextUtils.isEmpty("hw_referrer_upload") == true) goto L96;
        SharedPreferences.Editor r125 = mi7.g.f514094a.edit();
        r125.putBoolean("hw_referrer_upload", true);
        r125.apply();
        return;
    L96:
        return;
    L80:
        this.f23881a.set(false);
        b(r116, r124, false);
        mi7.e.a("HuaWeiReferrerHelper", "the network request return by the response is null !");
        return;
    L68:
        r211 = mi7.f.b(r122, new HashMap());     // Catch: Throwable -> L66
    L66:
        th = move-exception;
        th.printStackTrace();
        mi7.e.a("HuaWeiReferrerHelper", "the network request occurs exception and the exception is : " + th.getMessage());
        goto L72
    L62:
        r119 = "";
        r120 = "";
    L49:
        e = e;
        String r126 = r116;
        String r127 = r100;
        r100 = r117;
    L57:
        e.printStackTrace();     // Catch: Throwable -> L53
        mi7.e.a("HuaWeiReferrerHelper", "The cursor operation occurs exception and exception is : " + e.getMessage());     // Catch: Throwable -> L53
        r109.close();
        r117 = r100;
        r100 = r127;
        r116 = r126;
    L51:
        e = e;
        r126 = r116;
        r127 = "0";
    L55:
        e = e;
        r127 = "0";
        r126 = "null";
    L53:
        th = move-exception;
        r109.close();
        throw th;
    L37:
        r108 = r111.query(r107, null, null, r112, null);
        r113.a(240004, "android/content/ContentResolver", "query", r111, r114, r108, r212, true);
        goto L38
    L24:
        if (mi7.g.f514094a == null) goto L28;
        if (TextUtils.isEmpty("hw_referrer_upload") == true) goto L28;
        r110 = mi7.g.f514094a.getBoolean("hw_referrer_upload", false);
        goto L29
    L8:
        if (r104.toUpperCase(Locale.getDefault()).contains(SystemUtils.PRODUCT_HUAWEI) == false) goto L10;
    L11:
        r105 = true;
        goto L13
    L10:
        if (r104.toUpperCase(Locale.getDefault()).contains(SystemUtils.PRODUCT_HONOR) == false) goto L12;
        goto L11
    }

    public static void b(String r100, long r101, boolean r102) {
        long r103 = System.currentTimeMillis() - r101;
        JSONObject r104 = new JSONObject();
        int r105 = 0;
        if (TextUtils.isEmpty(r100) == true) goto L6;
        int r106 = 1;
    L7:
        JSONObject r107 = r104.put("param_valid", r106);     // Catch: JSONException -> L12
        if (r102 == false) goto L10;
        r105 = 1;
    L10:
        r107.put("result", r105).put("time_consume", r103);     // Catch: JSONException -> L12
    L14:
        mi7.c.a("zlink_huawei_refer_result", r104);
        return;
    L6:
        r106 = 0;
    L12:
        e = move-exception;
        e.printStackTrace();
        goto L14
    }
}
