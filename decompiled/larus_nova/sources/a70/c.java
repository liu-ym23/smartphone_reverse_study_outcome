package a70;

import com.bytedance.android.live.core.setting.d6;
import com.huawei.hms.support.hianalytics.HiAnalyticsConstant;
import kotlin.jvm.JvmStatic;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes45.dex */
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f1986a = 0;

    static {
    }

    @JvmStatic
    public static final void a(int r100, String r101, String r102, Long r103, int r104, int r110, String r111) {
        JSONObject r105 = new JSONObject();
        r105.put("status_code", r100);
        r105.put("data_type", r101);
        r105.put(HiAnalyticsConstant.BI_KEY_UPDATE_TYPE, r102);
        JSONObject r106 = new JSONObject();
        if (r103 == null) goto L5;
        r106.put("update_time", r103.longValue());
    L5:
        JSONObject r107 = new JSONObject();
        r107.put("update_size", r104);
        r107.put("delete_size", r110);
        r107.put("msg", r111);
        d6.d("ttlive_setting_update_v2", r105, r106, r107);
        b.e("_SLADAR", "statusCode = " + r100 + ", dataType = " + r101 + ", updateType = " + r102 + ", time = " + r103 + ", updateSize = " + r104 + ",  deleteSize = " + r110 + ", msg = " + r111);
    }
}
