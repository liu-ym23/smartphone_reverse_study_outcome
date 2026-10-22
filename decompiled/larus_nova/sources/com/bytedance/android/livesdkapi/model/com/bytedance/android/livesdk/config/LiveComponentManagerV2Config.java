package com.bytedance.android.livesdkapi.model.com.bytedance.android.livesdk.config;

import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes12.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b)\n\u0002\u0010\t\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002R\u001e\u0010\u0003\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u001e\u0010\t\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u0006\"\u0004\b\u000b\u0010\bR\u001e\u0010\f\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u0006\"\u0004\b\u000e\u0010\bR\u001e\u0010\u000f\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0006\"\u0004\b\u0011\u0010\bR\u001e\u0010\u0012\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u0006\"\u0004\b\u0014\u0010\bR\u001e\u0010\u0015\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\u0006\"\u0004\b\u0017\u0010\bR\u001e\u0010\u0018\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0019\u0010\u0006\"\u0004\b\u001a\u0010\bR\u001e\u0010\u001b\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001c\u0010\u0006\"\u0004\b\u001d\u0010\bR\u001e\u0010\u001e\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001f\u0010\u0006\"\u0004\b \u0010\bR\u001e\u0010!\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\"\u0010\u0006\"\u0004\b#\u0010\bR\u001e\u0010$\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b%\u0010\u0006\"\u0004\b&\u0010\bR\u001e\u0010'\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b(\u0010\u0006\"\u0004\b)\u0010\bR\u001e\u0010*\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b+\u0010\u0006\"\u0004\b,\u0010\bR\u001e\u0010-\u001a\u00020.8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b/\u00100\"\u0004\b1\u00102¨\u00063"}, d2 = {"Lcom/bytedance/android/livesdkapi/model/com/bytedance/android/livesdk/config/LiveComponentManagerV2Config;", "", "()V", "enable", "", "getEnable", "()Z", "setEnable", "(Z)V", "enableComponentXFragmentTaskFix", "getEnableComponentXFragmentTaskFix", "setEnableComponentXFragmentTaskFix", "enableFragmentReset", "getEnableFragmentReset", "setEnableFragmentReset", "enableFullLog", "getEnableFullLog", "setEnableFullLog", "enableLoadElementFilter", "getEnableLoadElementFilter", "setEnableLoadElementFilter", "enableOtherScene", "getEnableOtherScene", "setEnableOtherScene", "enableRoomScene", "getEnableRoomScene", "setEnableRoomScene", "enableRoomSceneMerge", "getEnableRoomSceneMerge", "setEnableRoomSceneMerge", "enableRoomScenePrioritylevelScheduler", "getEnableRoomScenePrioritylevelScheduler", "setEnableRoomScenePrioritylevelScheduler", "enableRoomSceneScheduler", "getEnableRoomSceneScheduler", "setEnableRoomSceneScheduler", "enableSchedulerRoomEnterCondition", "getEnableSchedulerRoomEnterCondition", "setEnableSchedulerRoomEnterCondition", "enableWhenLoadCheckCanLoad", "getEnableWhenLoadCheckCanLoad", "setEnableWhenLoadCheckCanLoad", "enableWidgetManagerLifecycleDelegate", "getEnableWidgetManagerLifecycleDelegate", "setEnableWidgetManagerLifecycleDelegate", "schedulerLoadResultTimeout", "", "getSchedulerLoadResultTimeout", "()J", "setSchedulerLoadResultTimeout", "(J)V", "infrastructure_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class LiveComponentManagerV2Config {

    @SerializedName("enable")
    private boolean enable;

    @SerializedName("componentx_fragment_task_enable")
    private boolean enableComponentXFragmentTaskFix;

    @SerializedName("fragment_reset_enable")
    private boolean enableFragmentReset;

    @SerializedName("full_log_enable")
    private boolean enableFullLog;

    @SerializedName("load_element_filter_enable")
    private boolean enableLoadElementFilter;

    @SerializedName("other_scene_enable")
    private boolean enableOtherScene;

    @SerializedName("room_scene_enable")
    private boolean enableRoomScene;

    @SerializedName("room_scene_merge_enable")
    private boolean enableRoomSceneMerge;

    @SerializedName("scheduler_prioritylevel_check_enable")
    private boolean enableRoomScenePrioritylevelScheduler;

    @SerializedName("room_scene_scheduler_enable")
    private boolean enableRoomSceneScheduler;

    @SerializedName("scheduler_roomenter_condition")
    private boolean enableSchedulerRoomEnterCondition;

    @SerializedName("double_check_canload_enable")
    private boolean enableWhenLoadCheckCanLoad;

    @SerializedName("widget_manager_lifecycle_delegate_enable")
    private boolean enableWidgetManagerLifecycleDelegate;

    @SerializedName("scheduler_load_result_timeout")
    private long schedulerLoadResultTimeout;

    public LiveComponentManagerV2Config() {
        this.schedulerLoadResultTimeout = 1500;
        this.enableSchedulerRoomEnterCondition = true;
        this.enableRoomScenePrioritylevelScheduler = true;
        this.enableComponentXFragmentTaskFix = true;
    }

    public final boolean getEnable() {
        return this.enable;
    }

    public final boolean getEnableComponentXFragmentTaskFix() {
        return this.enableComponentXFragmentTaskFix;
    }

    public final boolean getEnableFragmentReset() {
        return this.enableFragmentReset;
    }

    public final boolean getEnableFullLog() {
        return this.enableFullLog;
    }

    public final boolean getEnableLoadElementFilter() {
        return this.enableLoadElementFilter;
    }

    public final boolean getEnableOtherScene() {
        return this.enableOtherScene;
    }

    public final boolean getEnableRoomScene() {
        return this.enableRoomScene;
    }

    public final boolean getEnableRoomSceneMerge() {
        return this.enableRoomSceneMerge;
    }

    public final boolean getEnableRoomScenePrioritylevelScheduler() {
        return this.enableRoomScenePrioritylevelScheduler;
    }

    public final boolean getEnableRoomSceneScheduler() {
        return this.enableRoomSceneScheduler;
    }

    public final boolean getEnableSchedulerRoomEnterCondition() {
        return this.enableSchedulerRoomEnterCondition;
    }

    public final boolean getEnableWhenLoadCheckCanLoad() {
        return this.enableWhenLoadCheckCanLoad;
    }

    public final boolean getEnableWidgetManagerLifecycleDelegate() {
        return this.enableWidgetManagerLifecycleDelegate;
    }

    public final long getSchedulerLoadResultTimeout() {
        return this.schedulerLoadResultTimeout;
    }

    public final void setEnable(boolean r100) {
        this.enable = r100;
    }

    public final void setEnableComponentXFragmentTaskFix(boolean r100) {
        this.enableComponentXFragmentTaskFix = r100;
    }

    public final void setEnableFragmentReset(boolean r100) {
        this.enableFragmentReset = r100;
    }

    public final void setEnableFullLog(boolean r100) {
        this.enableFullLog = r100;
    }

    public final void setEnableLoadElementFilter(boolean r100) {
        this.enableLoadElementFilter = r100;
    }

    public final void setEnableOtherScene(boolean r100) {
        this.enableOtherScene = r100;
    }

    public final void setEnableRoomScene(boolean r100) {
        this.enableRoomScene = r100;
    }

    public final void setEnableRoomSceneMerge(boolean r100) {
        this.enableRoomSceneMerge = r100;
    }

    public final void setEnableRoomScenePrioritylevelScheduler(boolean r100) {
        this.enableRoomScenePrioritylevelScheduler = r100;
    }

    public final void setEnableRoomSceneScheduler(boolean r100) {
        this.enableRoomSceneScheduler = r100;
    }

    public final void setEnableSchedulerRoomEnterCondition(boolean r100) {
        this.enableSchedulerRoomEnterCondition = r100;
    }

    public final void setEnableWhenLoadCheckCanLoad(boolean r100) {
        this.enableWhenLoadCheckCanLoad = r100;
    }

    public final void setEnableWidgetManagerLifecycleDelegate(boolean r100) {
        this.enableWidgetManagerLifecycleDelegate = r100;
    }

    public final void setSchedulerLoadResultTimeout(long r100) {
        this.schedulerLoadResultTimeout = r100;
    }
}
