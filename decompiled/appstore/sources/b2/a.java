package b2;

import com.bytedance.apm.samplers.ISampleCheck;

/* JADX INFO: loaded from: classes.dex */
public class a implements ISampleCheck {
    public a() {
    }

    @Override // com.bytedance.apm.samplers.ISampleCheck
    public boolean getLogTypeSwitch(String r10) {
        return false;
    }

    @Override // com.bytedance.apm.samplers.ISampleCheck
    public boolean getMetricSwitch(String r10) {
        return false;
    }

    @Override // com.bytedance.apm.samplers.ISampleCheck
    public boolean getPerfAllowSwitch(String r10) {
        return false;
    }

    @Override // com.bytedance.apm.samplers.ISampleCheck
    public boolean getPerfFpsAllowSwitch(String r10, String r11) {
        return false;
    }

    @Override // com.bytedance.apm.samplers.ISampleCheck
    public boolean getPerfSecondStageSwitch(String r10) {
        return false;
    }

    @Override // com.bytedance.apm.samplers.ISampleCheck
    public boolean getServiceSwitch(String r10) {
        return false;
    }
}
