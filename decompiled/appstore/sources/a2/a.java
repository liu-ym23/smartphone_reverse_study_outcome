package a2;

import com.bytedance.apm.internal.ApmDelegate;
import com.bytedance.apm.samplers.ISampleCheck;
import v1.c;

/* JADX INFO: loaded from: classes.dex */
public class a implements ISampleCheck {
    public a() {
    }

    @Override // com.bytedance.apm.samplers.ISampleCheck
    public boolean getLogTypeSwitch(String r10) {
        return ApmDelegate.j().k(r10);
    }

    @Override // com.bytedance.apm.samplers.ISampleCheck
    public boolean getMetricSwitch(String r10) {
        return ApmDelegate.j().l(r10);
    }

    @Override // com.bytedance.apm.samplers.ISampleCheck
    public boolean getPerfAllowSwitch(String r10) {
        return c.a().b(r10);
    }

    @Override // com.bytedance.apm.samplers.ISampleCheck
    public boolean getPerfFpsAllowSwitch(String r10, String r11) {
        return c.a().c(r10, r11);
    }

    @Override // com.bytedance.apm.samplers.ISampleCheck
    public boolean getPerfSecondStageSwitch(String r10) {
        return c.a().d(r10);
    }

    @Override // com.bytedance.apm.samplers.ISampleCheck
    public boolean getServiceSwitch(String r10) {
        return ApmDelegate.j().m(r10);
    }
}
