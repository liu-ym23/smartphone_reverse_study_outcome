package com.byted.mgl.merge.service.api.host;

import android.app.Activity;
import android.app.Application;
import com.bytedance.bdp.bdpbase.core.TechType;
import com.bytedance.bdp.bdpbase.service.IBdpService;
import lb4.a;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
public interface IMglHostAppService extends IBdpService {
    Activity getHostActivity();

    Application getHostApplication();

    a getHostInfo();

    String getMglPluginPkg(TechType r100);

    JSONObject getSpecialConfig();
}
