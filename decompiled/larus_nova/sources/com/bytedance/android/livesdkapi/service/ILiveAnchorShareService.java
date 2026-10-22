package com.bytedance.android.livesdkapi.service;

import android.os.Bundle;
import com.bytedance.android.live.base.IService;
import com.bytedance.android.live.utility.ServiceLookup;
import com.ss.android.ugc.route_monitor.impl.route_out.control.bean.ControlRule;
import java.util.Map;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes12.dex */
@ServiceLookup("com.bytedance.android.livesdk.service.LiveAnchorShareService")
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010%\n\u0000\bg\u0018\u00002\u00020\u0001J\u0012\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H'J\u0012\u0010\u0006\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H'J\u0014\u0010\u0007\u001a\u0004\u0018\u00010\b2\b\u0010\t\u001a\u0004\u0018\u00010\bH'J0\u0010\n\u001a\u00020\u00032\u0006\u0010\u000b\u001a\u00020\u00052\b\u0010\f\u001a\u0004\u0018\u00010\u00052\u0014\u0010\r\u001a\u0010\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u000eH'¨\u0006\u000f"}, d2 = {"Lcom/bytedance/android/livesdkapi/service/ILiveAnchorShareService;", "Lcom/bytedance/android/live/base/IService;", "onMiniAppResume", "", "appId", "", "onMiniAppStop", "onShareMiniApp", "Landroid/os/Bundle;", ControlRule.KEY_EXTRA_DATA, "reportEvent", "eventName", "schema", "extra", "", "livesdkapi_saasRelease"}, k = 1, mv = {1, 4, 3})
public interface ILiveAnchorShareService extends IService {
    void onMiniAppResume(String r100);

    void onMiniAppStop(String r100);

    Bundle onShareMiniApp(Bundle r100);

    void reportEvent(String r100, String r101, Map<String, String> r102);
}
