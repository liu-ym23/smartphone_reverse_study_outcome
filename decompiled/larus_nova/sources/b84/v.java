package b84;

import android.os.Build;
import android.text.TextUtils;
import com.bytedance.android.livesdkapi.app.AppConstants;
import com.ss.android.socialbase.appdownloader.util.RomUtils;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
public final class v extends d {
    public v() {
        super(true, false);
    }

    @Override // b84.d
    public final boolean a(JSONObject r110) throws JSONException {
        StringBuilder r100 = new StringBuilder(16);
        boolean r101 = false;
        if (i84.p.j() == false) goto L6;
        r100.append("MIUI-");
    L39:
        r100.append(Build.VERSION.INCREMENTAL);
        r110.put("rom", r100.toString());
        String r102 = "";
        if (i84.p.j() == false) goto L45;
        if (i84.p.j() == false) goto L94;
        r102 = "miui_" + i84.p.d("ro.miui.ui.version.name") + "_" + Build.VERSION.INCREMENTAL;
    L94:
        if (TextUtils.isEmpty(r102) == true) goto L96;
        r110.put("rom_version", r102);
    L96:
        return true;
    L45:
        if (i84.p.g() == true) goto L47;
        String r103 = i84.p.d(com.alipay.sdk.m.c.a.f25238a);
        if (r103 != null) goto L52;
    L56:
        String r104 = "";
    L58:
        if (TextUtils.isEmpty(r104) == true) goto L61;
    L59:
        r102 = r104;
        goto L94
    L61:
        if ((!TextUtils.isEmpty(i84.p.d("ro.vivo.os.build.display.id"))) == false) goto L64;
        r102 = i84.p.d("ro.vivo.os.build.display.id") + "_" + i84.p.d("ro.vivo.product.version");
        goto L94
    L64:
        if (i84.p.h() == false) goto L70;
        r104 = Build.DISPLAY;
        if (r104 == null) goto L94;
        if (r104.toLowerCase().contains("flyme") == false) goto L94;
    L70:
        r104 = Build.DISPLAY;
        if (TextUtils.isEmpty(r104) == false) goto L73;
    L75:
        boolean r105 = false;
    L76:
        if (r105 == false) goto L78;
        r102 = r104 + "_" + i84.p.d("ro.gn.sv.version");
        goto L94
    L78:
        String r106 = Build.MANUFACTURER + Build.BRAND;
        if (TextUtils.isEmpty(r106) == true) goto L86;
        String r107 = r106.toLowerCase();
        if (r107.contains(AppConstants.CHANNEL_360) == false) goto L84;
    L85:
        r101 = true;
        goto L86
    L84:
        if (r107.contains("qiku") == true) goto L85;
    L86:
        if (r101 == false) goto L89;
        r102 = i84.p.d("ro.build.uiversion") + "_" + r104;
        goto L94
    L89:
        if ((!TextUtils.isEmpty(i84.p.d("ro.letv.release.version"))) == false) goto L92;
        r102 = "eui_" + i84.p.d("ro.letv.release.version") + "_" + r104;
    L92:
        if (TextUtils.isEmpty(r102) == true) goto L59;
    L73:
        if (r104.toLowerCase().contains("amigo") == false) goto L75;
        r105 = true;
        goto L76
    L52:
        if (r103.toLowerCase().contains("emotionui") == false) goto L54;
    L55:
        r104 = r103 + "_" + Build.DISPLAY;
        goto L58
    L54:
        if (r103.toLowerCase().contains("magicui") == false) goto L56;
    L47:
        if (i84.p.g() == false) goto L94;
        r102 = "coloros_" + i84.p.d("ro.build.version.opporom") + "_" + Build.DISPLAY;
        goto L94
    L6:
        if (i84.p.h() == false) goto L8;
        r100.append("FLYME-");
        goto L39
    L8:
        String r108 = i84.p.d(com.alipay.sdk.m.c.a.f25238a);
        if (TextUtils.isEmpty(r108) == false) goto L11;
        String r109 = i84.p.d(com.alipay.sdk.m.c.a.f25238a);
    L13:
        if (TextUtils.isEmpty(r109) == false) goto L15;
    L19:
        String r111 = Build.BRAND;
        if (TextUtils.isEmpty(r111) == false) goto L22;
    L23:
        String r112 = Build.MANUFACTURER;
        if (TextUtils.isEmpty(r112) == false) goto L26;
    L28:
        boolean r113 = false;
    L29:
        if (r113 == false) goto L31;
    L34:
        boolean r114 = true;
    L35:
        if (r114 == false) goto L39;
        r100.append("EMUI-");
        if (TextUtils.isEmpty(r108) == true) goto L39;
        r100.append(r108);
        r100.append("-");
        goto L39
    L31:
        if (i84.p.i() == true) goto L34;
        r114 = false;
        goto L35
    L26:
        if (r112.toLowerCase().startsWith(RomUtils.BRAND_HUAWEI) == false) goto L28;
    L27:
        r113 = true;
        goto L29
    L22:
        if (r111.toLowerCase().startsWith(RomUtils.BRAND_HUAWEI) == true) goto L27;
    L15:
        if (r109.toLowerCase().contains("emotionui") == true) goto L34;
        if (r109.toLowerCase().contains("magicui") == false) goto L19;
    L11:
        r109 = r108;
        goto L13
    }
}
