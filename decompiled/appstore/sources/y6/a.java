package y6;

import android.content.Context;
import android.os.PowerManager;
import com.bytedance.apm.battery.config.BatteryTypeInf;
import com.bytedance.watson.assist.api.IAssistStat;
import u6.b;

/* JADX INFO: loaded from: classes.dex */
public class a extends b {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public PowerManager f26130c;

    public a(Context r10, IAssistStat r11) {
        super(r10, r11);
        this.f26130c = (PowerManager) this.f24886a.getSystemService(BatteryTypeInf.BATTERY_POWER_LOCK);
    }

    public int c() {
        PowerManager r10 = this.f26130c;
        if (r10 != null) goto L5;
        return -1;
    L5:
        return r10.getCurrentThermalStatus();
    }
}
