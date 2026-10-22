package com.bytedance.android.service.manager.alliance;

import android.app.Application;
import android.content.Context;
import com.bytedance.android.push.service.manager.annotation.ExternalService;
import org.json.JSONObject;
import p67.a;

/* JADX INFO: loaded from: classes3.dex */
@ExternalService
public interface IAllianceService {
    public static final String CONTENT_TYPE_BADGE = "badge";
    public static final String CONTENT_TYPE_LOCAL_PUSH = "local_push";
    public static final String LAUNCH_FROM_SIGNAL = "signal";
    public static final String PATH_GET_COMPOSE = "get_compose";
    public static final String PATH_POST_COMPOSE = "post_compose";

    boolean allowStartOthersProcessFromSmp();

    boolean allowSyncInSmpWhenProcessIsolate();

    boolean depthsInMainProcess(Context r100);

    void doAfterProcessIsolationProtected(Runnable r100);

    ICommonInstrumentation getInstrumentationService();

    boolean hasWaked();

    String isRiskDevice(Context r100, a r101);

    boolean isRiskDevice(Context r100, boolean r101);

    boolean isStartByAlliance(Context r100);

    IsSupportWakeUp isSupportWakeUp(Context r100);

    void onApplicationInit(String r100, Context r101);

    void onAttachBaseContext(Application r100);

    void onBackgroundProcessAlive(String r100);

    void onEventV3(boolean r100, String r101, JSONObject r102);

    void onEventV3WithHttp(boolean r100, String r101, JSONObject r102);

    void onInitOnProcessIsolationProtectedMode();

    void onMainProcessStart();

    void onSmpProcessStart(Context r100, Object r101, String r102, SmpProcessInitCallback r103);

    void onWorkerApplicationStart();

    void reportEventByHttpNow(Context r100, String r101, JSONObject r102);

    void startClientAccountRetryTask(String r100);

    void updateSettings(Context r100, JSONObject r101);

    boolean verifySign(String r100, String r101);

    void wakeUpTargetPartner(JSONObject r100);
}
