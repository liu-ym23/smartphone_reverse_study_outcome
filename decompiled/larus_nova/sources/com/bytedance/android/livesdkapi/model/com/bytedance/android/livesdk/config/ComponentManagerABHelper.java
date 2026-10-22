package com.bytedance.android.livesdkapi.model.com.bytedance.android.livesdk.config;

import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes12.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u000e\n\u0002\u0010\t\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0006\u0010\n\u001a\u00020\u000bJ\u0006\u0010\f\u001a\u00020\u000bJ\u0006\u0010\r\u001a\u00020\u000bJ\u0006\u0010\u000e\u001a\u00020\u000bJ\u0006\u0010\u000f\u001a\u00020\u000bJ\u0006\u0010\u0010\u001a\u00020\u000bJ\u0006\u0010\u0011\u001a\u00020\u000bJ\u0006\u0010\u0012\u001a\u00020\u000bJ\u0006\u0010\u0013\u001a\u00020\u000bJ\u0006\u0010\u0014\u001a\u00020\u000bJ\u0006\u0010\u0015\u001a\u00020\u000bJ\u0006\u0010\u0016\u001a\u00020\u000bJ\u0006\u0010\u0017\u001a\u00020\u000bJ\u0006\u0010\u0018\u001a\u00020\u000bJ\u0006\u0010\u0019\u001a\u00020\u001aR#\u0010\u0003\u001a\n \u0005*\u0004\u0018\u00010\u00040\u00048BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u001b"}, d2 = {"Lcom/bytedance/android/livesdkapi/model/com/bytedance/android/livesdk/config/ComponentManagerABHelper;", "", "()V", "config", "Lcom/bytedance/android/livesdkapi/model/com/bytedance/android/livesdk/config/LiveComponentManagerV2Config;", "kotlin.jvm.PlatformType", "getConfig", "()Lcom/bytedance/android/livesdkapi/model/com/bytedance/android/livesdk/config/LiveComponentManagerV2Config;", "config$delegate", "Lkotlin/Lazy;", "enable", "", "enableComponentXFragmentTaskFix", "enableFilterWhenLoadElement", "enableFragmentReset", "enableFullLog", "enableOtherScene", "enableRoomScene", "enableRoomSceneMerge", "enableRoomSceneScheduler", "enableRoomSceneSchedulerPrioritylevelCheck", "enableSchedulerRoomEnterCondition", "enableWhenLoadCheckCanLoad", "enableWidgetManagerLifecycleDelegate", "isLiveRoomNewManager", "schedulerLoadResultTimeout", "", "infrastructure_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class ComponentManagerABHelper {
    public static final ComponentManagerABHelper INSTANCE = null;
    private static final Lazy config$delegate = null;

    private ComponentManagerABHelper() {
    }

    private final LiveComponentManagerV2Config getConfig() {
        return (LiveComponentManagerV2Config) config$delegate.getValue();
    }

    static {
        INSTANCE = new ComponentManagerABHelper();
        config$delegate = LazyKt.lazy(ComponentManagerABHelper$config$2.INSTANCE);
    }

    public final boolean enable() {
        return getConfig().getEnable();
    }

    public final boolean enableComponentXFragmentTaskFix() {
        return getConfig().getEnableComponentXFragmentTaskFix();
    }

    public final boolean enableFilterWhenLoadElement() {
        if (enable() == true) goto L5;
    L7:
        return false;
    L5:
        if (getConfig().getEnableLoadElementFilter() == false) goto L7;
        return true;
    }

    public final boolean enableFragmentReset() {
        return getConfig().getEnableFragmentReset();
    }

    public final boolean enableFullLog() {
        if (enable() == true) goto L5;
    L7:
        return false;
    L5:
        if (getConfig().getEnableFullLog() == false) goto L7;
        return true;
    }

    public final boolean enableOtherScene() {
        if (enable() == true) goto L5;
    L7:
        return false;
    L5:
        if (getConfig().getEnableOtherScene() == false) goto L7;
        return true;
    }

    public final boolean enableRoomScene() {
        if (enable() == true) goto L5;
    L7:
        return false;
    L5:
        if (getConfig().getEnableRoomScene() == false) goto L7;
        return true;
    }

    public final boolean enableRoomSceneMerge() {
        if (enable() == true) goto L5;
    L7:
        return false;
    L5:
        if (getConfig().getEnableRoomSceneMerge() == false) goto L7;
        return true;
    }

    public final boolean enableRoomSceneScheduler() {
        if (enable() == true) goto L5;
    L7:
        return false;
    L5:
        if (getConfig().getEnableRoomSceneScheduler() == false) goto L7;
        return true;
    }

    public final boolean enableRoomSceneSchedulerPrioritylevelCheck() {
        if (enable() == true) goto L5;
    L7:
        return false;
    L5:
        if (getConfig().getEnableRoomScenePrioritylevelScheduler() == false) goto L7;
        return true;
    }

    public final boolean enableSchedulerRoomEnterCondition() {
        if (enableRoomSceneScheduler() == true) goto L5;
    L7:
        return false;
    L5:
        if (getConfig().getEnableSchedulerRoomEnterCondition() == false) goto L7;
        return true;
    }

    public final boolean enableWhenLoadCheckCanLoad() {
        if (enable() == true) goto L5;
    L7:
        return false;
    L5:
        if (getConfig().getEnableWhenLoadCheckCanLoad() == false) goto L7;
        return true;
    }

    public final boolean enableWidgetManagerLifecycleDelegate() {
        if (enable() == true) goto L5;
    L7:
        return false;
    L5:
        if (getConfig().getEnableWidgetManagerLifecycleDelegate() == false) goto L7;
        return true;
    }

    public final boolean isLiveRoomNewManager() {
        if (enable() == true) goto L5;
    L9:
        return false;
    L5:
        if (enableRoomScene() == false) goto L9;
        if (enableRoomSceneMerge() == false) goto L9;
        return true;
    }

    public final long schedulerLoadResultTimeout() {
        return getConfig().getSchedulerLoadResultTimeout();
    }
}
