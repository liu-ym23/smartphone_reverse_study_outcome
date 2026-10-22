package com.bytedance.android.service.manager.push.monitor;

import android.content.Context;
import java.util.List;
import org.json.JSONObject;
import z67.b;

/* JADX INFO: loaded from: classes3.dex */
public interface IPushSdkMonitorService extends b {
    public static final int ALLIANCE_USE_NEW_LOCAL_PUSH_API = 4096;
    public static final int ALLIANCE_USE_NEW_RED_BADGE_API = 256;
    public static final int BADGE_OPERATE_TYPE_ADD_NUMBER = 3;
    public static final int BADGE_OPERATE_TYPE_GET_NUMBER = 2;
    public static final int BADGE_OPERATE_TYPE_REDUCE_NUMBER = 4;
    public static final int BADGE_OPERATE_TYPE_SET_NUMBER = 1;
    public static final int ONLINE_USE_NEW_LOCAL_PUSH_API = 16;
    public static final int ONLINE_USE_NEW_RED_BADGE_API = 1;
    public static final int PROFILE_ID_OPERATE_TYPE_REMOVE = 2;
    public static final int PROFILE_ID_OPERATE_TYPE_SET = 1;

    boolean curIsDau();

    boolean curIsTransmit();

    void initOnApplication(Context r100);

    void onActivityDepthsDeviceStatus(JSONObject r100);

    void onActivityStartResult(boolean r100, int r101, String r102, String r103, String r104, long r105, String r106);

    void onActivityStartReturnValue(String r100, JSONObject r101, int r102);

    void onBadgeOperateFailed(int r100, Integer r101, String r102);

    void onBadgeOperateSuccess(int r100, Integer r101);

    void onContentRequest(String r100, int r101, int r102);

    void onContentShow(String r100, String r101, int r102);

    void onInvalidMrDepths(Context r100, List<String> r101);

    void onKeepAliveFrom(String r100, String r101, int r102);

    void onLaunchEvent(boolean r100, boolean r101, long r102, long r103, int r104, int r105, String r106);

    void onMessageArrive(long r100);

    void onMessageShow(long r100, long r101);

    void onProcessStartEvent(boolean r100, boolean r101, long r102, long r103, int r104, int r105, String r106, boolean r110);

    void onProfileIdOperateResult(int r100, int r101, int r102, long r103, String r104);

    @Override // z67.b
    /* synthetic */ void onRequestFailed(String r100, String r101, String r102, String r103, long r104);

    @Override // z67.b
    /* synthetic */ void onRequestFailed(String r100, String r101, String r102, String r103, long r104, JSONObject r105);

    @Override // z67.b
    /* synthetic */ void onRequestSuccess(String r100, String r101, String r102, long r103);

    @Override // z67.b
    /* synthetic */ void onRequestSuccess(String r100, String r101, String r102, long r103, JSONObject r104);

    void onTokenRetry(int r100, String r101);

    void onTokenRetryResult(int r100, boolean r101, String r102);

    void onTransmitStrategyRequest();
}
