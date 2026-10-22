package b84;

import android.os.Build;
import com.bytedance.crash.general.HardwareInfo;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
public final class e extends d {
    public e() {
        super(true, false);
    }

    @Override // b84.d
    public final boolean a(JSONObject r100) throws JSONException, SecurityException {
        r100.put("os", "Android");
        r100.put("os_version", Build.VERSION.RELEASE);
        r100.put("os_api", Build.VERSION.SDK_INT);
        String r101 = Build.BRAND;
        if (r101.equals("Pico") == false) goto L5;
        Object r102 = i84.p.b();
    L6:
        r100.put("device_model", r102);
        r100.put("device_brand", r101);
        r100.put("device_manufacturer", Build.MANUFACTURER);
        r100.put(HardwareInfo.KEY_HW_CPU_ABI, Build.CPU_ABI);
        return true;
    L5:
        r102 = Build.MODEL;
        goto L6
    }
}
