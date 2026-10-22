package com.bytedance.android.service.manager.alive.monitor;

import android.content.Context;
import com.bytedance.android.push.service.manager.annotation.ExternalService;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
@ExternalService
public interface AliveMonitorService {
    boolean curProcessIsFirstProcess(Context r100);

    JSONObject getProcessStartInfoObject(Context r100);

    boolean hasHookActivityManagerSuccess(Context r100);

    boolean hasHookActivityTaskManagerSuccess(Context r100);

    void monitorAssociationStart(Context r100);

    void monitorAssociationStart(Context r100, IMonitorCallback r101);

    void onUserActive();

    void startDetectProcessLaunchReason(Context r100);
}
