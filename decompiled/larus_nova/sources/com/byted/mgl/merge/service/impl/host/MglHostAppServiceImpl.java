package com.byted.mgl.merge.service.impl.host;

import android.app.Activity;
import android.app.Application;
import android.os.SystemClock;
import com.byted.mgl.merge.service.api.host.IMglHostAppService;
import com.bytedance.bdp.bdpbase.core.TechType;
import lb4.a;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
public class MglHostAppServiceImpl implements IMglHostAppService {
    private final long mStartUpTime;

    @Override // com.byted.mgl.merge.service.api.host.IMglHostAppService
    public Activity getHostActivity() {
        return null;
    }

    @Override // com.byted.mgl.merge.service.api.host.IMglHostAppService
    public Application getHostApplication() {
        return null;
    }

    @Override // com.byted.mgl.merge.service.api.host.IMglHostAppService
    public String getMglPluginPkg(TechType r100) {
        return null;
    }

    @Override // com.byted.mgl.merge.service.api.host.IMglHostAppService
    public JSONObject getSpecialConfig() {
        return null;
    }

    @Override // com.byted.mgl.merge.service.api.host.IMglHostAppService
    public a getHostInfo() {
        return new AnonymousClass1(this);
    }

    public MglHostAppServiceImpl() {
        this.mStartUpTime = SystemClock.elapsedRealtime();
    }

    public static /* synthetic */ long access$000(MglHostAppServiceImpl r100) {
        return r100.mStartUpTime;
    }
}
