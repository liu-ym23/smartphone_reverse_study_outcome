package c9a;

import com.bytedance.crash.general.RomInfo;
import com.larus.dora.obric.device_management.device_home.DoraObricDeviceHomeViewModel;
import com.monitor.cloudmessage.utils.c;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes32.dex */
public final class a {
    public static JSONObject a() {
        JSONObject r100 = new JSONObject();
        r100.put("used_memory", ((Runtime.getRuntime().totalMemory() / 1024) / 1024) + "MB");     // Catch: JSONException -> L8
        r100.put("total_memory", ((Runtime.getRuntime().maxMemory() / 1024) / 1024) + "MB");     // Catch: JSONException -> L8
        r100.put("sd_all_size", c.b()[0] + "MB");     // Catch: JSONException -> L8
        r100.put("sd_avail_size", c.b()[1] + "MB");     // Catch: JSONException -> L8
        String r101 = "";
        String[] r102 = c.a();     // Catch: JSONException -> L8
        int r103 = r102.length;     // Catch: JSONException -> L8
        int r104 = 0;
    L4:
        if (r104 >= r103) goto L6;
        r101 = r101 + r102[r104] + tb2.c.DEFAULT_TEXT;     // Catch: JSONException -> L8
        r104 = r104 + 1;     // Catch: JSONException -> L8
        goto L4
    L6:
        r100.put("cpu_info", r101);     // Catch: JSONException -> L8
        r100.put(RomInfo.KEY_ROM_KERNEL_VERSION, c.c()[0]);     // Catch: JSONException -> L8
        r100.put("firmware_version", c.c()[1]);     // Catch: JSONException -> L8
        r100.put(DoraObricDeviceHomeViewModel.PARAM_PRODUCT_MODEL, c.c()[2]);     // Catch: JSONException -> L8
        r100.put("system_version", c.c()[3]);     // Catch: JSONException -> L8
    L7:
        return r100;
    }
}
