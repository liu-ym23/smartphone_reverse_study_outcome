package af3;

import com.bytedance.android.ec.common.api.inflow.AnchorBenefitToast;
import com.bytedance.mt.protector.impl.JSONArrayProtectorUtils;
import com.bytedance.mt.protector.impl.JSONObjectProtectorUtils;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes13.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final JSONObject f3143a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final JSONObject f3144b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final JSONObject f3145c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final boolean f3146d;

    public final String a() {
        JSONObject r100 = b(this.f3144b, "data");
        if (r100 != null) goto L24;
    L9:
        JSONArray r101 = new JSONArray();
    L11:
        if (r101.length() > 0) goto L22;
        return "";
    L22:
        JSONObject r102 = b(JSONArrayProtectorUtils.getJSONObject(r101, 0), AnchorBenefitToast.TYPE_COUPON);     // Catch: Exception -> L21
        if (r102 == null) goto L26;
        String r103 = d(r102, "toast");     // Catch: Exception -> L21
        if (r103 != null) goto L20;
        return "";
    L20:
        return r103;
    L26:
        return "";
    L28:
        return "";
    L24:
        r101 = JSONObjectProtectorUtils.getJSONArray(r100, "benefitInfos");     // Catch: Exception -> L7
    L8:
        if (r101 != null) goto L11;
    L7:
        r101 = new JSONArray();
        goto L8
    }

    public a(String r100) {
        Intrinsics.checkNotNullParameter(r100, "rawData");
        this.f3143a = new JSONObject();
        this.f3144b = new JSONObject();
        this.f3145c = new JSONObject();
        System.currentTimeMillis();     // Catch: Exception -> L17
        JSONObject r101 = new JSONObject(r100);     // Catch: Exception -> L17
        this.f3143a = r101;     // Catch: Exception -> L17
        JSONObject r102 = JSONObjectProtectorUtils.getJSONObject(r101, "extra");     // Catch: Exception -> L17
        this.f3145c = r102;     // Catch: Exception -> L17
        boolean r103 = JSONObjectProtectorUtils.getBoolean(r102, "popup_data_is_valid");     // Catch: Exception -> L6
    L7:
        if (r103 == true) goto L23;
        return;
    L23:
        int r104 = JSONObjectProtectorUtils.getInt(this.f3145c, "native_open_ab");     // Catch: Exception -> L11
    L13:
        if (r104 != 1) goto L15;
        this.f3144b = new JSONObject(JSONObjectProtectorUtils.getString(JSONObjectProtectorUtils.getJSONObject(JSONArrayProtectorUtils.getJSONObject(JSONObjectProtectorUtils.getJSONArray(r101, "popup_data"), 0), "biz_params_map"), "mall_popup"));     // Catch: Exception -> L17
    L15:
        this.f3146d = true;     // Catch: Exception -> L17
        System.currentTimeMillis();     // Catch: Exception -> L17
        return;
    L11:
        r104 = 0;
    L6:
        r103 = false;
    L17:
        this.f3146d = false;
    }

    public final String c(f r100) {
        JSONObject r101 = this.f3143a;
        JSONObject r102 = new JSONObject();
        if (r100 == null) goto L5;
        int r103 = r100.f3164a;
    L6:
        r102.put("result_code", r103);
        if (r100 == null) goto L10;
        String r104 = r100.f3165b;
        if (r104 == null) goto L10;
    L11:
        r102.put("message", r104);
        Unit r105 = Unit.INSTANCE;
        r101.put("native_open_dialog_result", r102);
        return this.f3143a.toString();
    L10:
        r104 = "";
        goto L11
    L5:
        r103 = 0;
        goto L6
    }

    public static JSONObject b(JSONObject r100, String r101) {
        return JSONObjectProtectorUtils.getJSONObject(r100, r101);
    L4:
        return null;
    }

    public static String d(JSONObject r100, String r101) {
        return JSONObjectProtectorUtils.getString(r100, r101);
    L4:
        return "";
    }
}
