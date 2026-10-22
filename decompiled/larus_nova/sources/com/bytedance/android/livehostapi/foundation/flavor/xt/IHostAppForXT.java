package com.bytedance.android.livehostapi.foundation.flavor.xt;

import android.app.Activity;
import android.content.Context;
import com.bytedance.android.live.base.IService;
import com.bytedance.android.livehostapi.foundation.base.IBaseHostApp;
import com.bytedance.android.livehostapi.foundation.depend.IHostAppMonitorListener;
import com.bytedance.android.livehostapi.foundation.depend.OnBindPhoneListener;
import java.util.List;

/* JADX INFO: loaded from: classes7.dex */
public interface IHostAppForXT extends IService, IBaseHostApp {
    public static final int BROADCAST_PREVIEW_CLASS = 18;
    public static final int BROADCAST_RES_DOWNLOAD_ACTIVITY_CLASS = 17;
    public static final int GIFT_AD_ACTIVITY_CLASS = 1;
    public static final int LIVE_BG_BROADCAST_ACTIVITY_CLASS = 6;
    public static final int LIVE_BILLING_ACTIVITY_CLASS = 21;
    public static final int LIVE_BROADCAST_ACTIVITY_CLASS = 5;
    public static final int LIVE_BROADCAST_BEFORE_ACTIVITY_CLASS = 16;
    public static final int START_LIVE_ACTIVITY_CLASS = 7;
    public static final int VERIFY_ACTIVITY_CLASS = 8;
    public static final int XG_LIVE_FEED_CLASS = 34;
    public static final int XT_MEDIA_BROADCAST_ACTIVITY_CLASS = 20;
    public static final int XT_MEDIA_BROADCAST_CONFIG_ACTIVITY_CLASS = 19;

    public @interface ActivityType {
    }

    void centerToast(Context r100, String r101, int r102);

    void centerToast(Context r100, String r101, int r102, boolean r103);

    List<Class> getAllLiveActivity();

    String getAudioAccessibilityServiceName();

    String getBgBroadcastServiceName();

    Activity getCurrentActivity();

    Class getHostActivity(int r100);

    Class getLiveActivityClass();

    Activity getTopActivity();

    void registerLiveLifeCycleListener(IHostAppMonitorListener r100);

    boolean shouldUseScopedStorage();

    void startBindMobileFullFragment(Activity r100, String r101, String r102, OnBindPhoneListener r103);

    void systemToast(Context r100, String r101, int r102);
}
