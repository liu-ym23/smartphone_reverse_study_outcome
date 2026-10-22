package b84;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import com.bytedance.bdinstall.o0;

/* JADX INFO: loaded from: classes3.dex */
public final class t {
    public static void a(Context r110, com.bytedance.bdinstall.u r111, o0 r112) {
        SharedPreferences r113 = i84.a.a(r110, r112);
        SharedPreferences r114 = r111.a(r112);
        boolean r100 = false;
        if (r113.getBoolean("dr_install_migrate", false) == false) goto L5;
        return;
    L5:
        SharedPreferences r115 = r112.c();
        String r101 = r115.getString("device_id", null);
        String r102 = r115.getString("bd_did", null);
        String r103 = r115.getString("install_id", null);
        String r116 = r115.getString("ssid", null);
        SharedPreferences.Editor r117 = r114.edit();
        if (TextUtils.isEmpty(r101) == true) goto L9;
        r117.putString("device_id", r101);
        r100 = true;
    L9:
        if (TextUtils.isEmpty(r102) == true) goto L12;
        r117.putString("bd_did", r102);
        r100 = true;
    L12:
        if (TextUtils.isEmpty(r103) == true) goto L15;
        r117.putString("install_id", r103);
        r100 = true;
    L15:
        if (TextUtils.isEmpty(r116) == true) goto L17;
        r117.putString("ssid", r116);
        r100 = true;
    L17:
        if (r100 == false) goto L19;
        r117.apply();
    L19:
        r113.edit().putBoolean("dr_install_migrate", true).apply();
    }
}
