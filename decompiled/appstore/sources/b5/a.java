package b5;

import com.bytedance.apm.constant.PerfConsts;
import com.bytedance.framwork.core.sdklib.config.IMonitorConfigure;
import com.bytedanceos.common.ad.common.AdConstant;
import java.util.List;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public class a implements IMonitorConfigure {
    public a() {
    }

    @Override // com.bytedance.framwork.core.sdklib.config.IMonitorConfigure
    public long getMonitorLogMaxSaveCount() {
        return PerfConsts.DEFAULT_SERIOUS_BLOCK_INTERVAL_MS;
    }

    @Override // com.bytedance.framwork.core.sdklib.config.IMonitorConfigure
    public boolean getRemoveSwitch() {
        return false;
    }

    @Override // com.bytedance.framwork.core.sdklib.config.IMonitorConfigure
    public boolean isLogSendSwitch() {
        return true;
    }

    @Override // com.bytedance.framwork.core.sdklib.config.IMonitorConfigure
    public int reportCount() {
        return 100;
    }

    @Override // com.bytedance.framwork.core.sdklib.config.IMonitorConfigure
    public int reportFailRepeatBaseTime() {
        return 15;
    }

    @Override // com.bytedance.framwork.core.sdklib.config.IMonitorConfigure
    public int reportFailRepeatCount() {
        return 4;
    }

    @Override // com.bytedance.framwork.core.sdklib.config.IMonitorConfigure
    public int reportInterval() {
        return 120;
    }

    @Override // com.bytedance.framwork.core.sdklib.config.IMonitorConfigure
    public JSONObject reportJsonHeaderInfo() {
        return null;
    }

    @Override // com.bytedance.framwork.core.sdklib.config.IMonitorConfigure
    public List reportUrl(String r10) {
        return null;
    }

    @Override // com.bytedance.framwork.core.sdklib.config.IMonitorConfigure
    public long stopMoreChannelInterval() {
        return AdConstant.SPLASH_AD_INTERVAL;
    }
}
