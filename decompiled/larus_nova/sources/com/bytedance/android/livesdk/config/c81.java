package com.bytedance.android.livesdk.config;

import com.bytedance.android.livehostapi.TTLiveSDK;
import com.bytedance.android.livesdkapi.init.LiveInitAssistant;
import com.bytedance.android.livesdkapi.init.LiveInitializeSettingConfig;
import com.google.gson.annotations.SerializedName;
import java.util.List;

/* JADX INFO: loaded from: classes8.dex */
public class c81 {

    @SerializedName("launch_task_delay_time")
    private long launchTaskDelayTime;

    @SerializedName("enable_feed_opt")
    private boolean mEnableFeedOpt;

    @SerializedName("enable_launcher_opt")
    private boolean mEnableLauncherOpt;

    @SerializedName("enable_service_opt")
    private boolean mEnableServiceOpt;

    @SerializedName("enable_setting_opt")
    private boolean mEnableSettingOpt;

    @SerializedName("no_delay_task_time_infos")
    private List<a> noDelayTaskTimeInfos;

    public static class a {

        @SerializedName("end")
        public int end;

        @SerializedName("start")
        public int start;

        @SerializedName("task_id")
        public int taskId;

        public a() {
        }
    }

    public c81() {
    }

    public final long a() {
        if (d() == true) goto L7;
        return 0;
    L7:
        return this.launchTaskDelayTime;
    }

    public final boolean d() {
        if (TTLiveSDK.hostService().appContext().userFirstLaunch() == false) goto L5;
        boolean r100 = true;
    L7:
        if (r100 == false) goto L19;
        LiveInitAssistant r101 = LiveInitAssistant.INSTANCE;
        LiveInitializeSettingConfig r102 = r101.optimizeConfig();
        if (r102.getSdkLaunchTaskOpt() == false) goto L16;
        int r103 = r102.getThreadPoolSize();
        if (r101.getInitExecutor() == null) goto L14;
        r103 = r101.getInitThreadSize();
    L14:
        if (r103 <= 1) goto L16;
        boolean r104 = true;
    L17:
        if (r104 == true) goto L19;
        return true;
    L16:
        r104 = false;
    L19:
        return false;
    L5:
        r100 = this.mEnableLauncherOpt;
        goto L7
    }

    public final boolean f() {
        if (TTLiveSDK.hostService().appContext().userFirstLaunch() == false) goto L7;
        return true;
    L7:
        return this.mEnableSettingOpt;
    }

    public final List<a> b() {
        return this.noDelayTaskTimeInfos;
    }

    public final boolean c() {
        return this.mEnableFeedOpt;
    }

    public final boolean e() {
        return this.mEnableServiceOpt;
    }
}
