package com.bytedance.android.livesdkapi.model.com.bytedance.android.livesdk.config;

import com.bytedance.android.live.core.setting.LiveInfraSettingKeys;
import com.bytedance.android.livehostapi.foundation.IMiddleWareHostContext;
import com.bytedance.android.livesdk.config.hc0;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import com.bytedance.android.livesdkapi.distribution.IExternalConfigJudger;
import com.bytedance.android.livesdkapi.model.com.bytedance.android.live.core.framework.LiveInteractionFrameworkOptHelper;
import com.bytedance.ies.sdk.widgets.DataCenter;
import jc1.k;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes12.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0010\t\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0006\u0010\u0005\u001a\u00020\u0006J\u0006\u0010\u0007\u001a\u00020\bJ\u0006\u0010\t\u001a\u00020\u0006J\u0006\u0010\n\u001a\u00020\u0006J\u0006\u0010\u000b\u001a\u00020\u0006J\u0006\u0010\f\u001a\u00020\u0006J\u0006\u0010\r\u001a\u00020\u0006J\u0006\u0010\u000e\u001a\u00020\u0006J\u001a\u0010\u000e\u001a\u00020\u00062\b\u0010\u000f\u001a\u0004\u0018\u00010\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0012J\u0006\u0010\u0013\u001a\u00020\u0006J\u001a\u0010\u0014\u001a\u00020\u00062\b\u0010\u000f\u001a\u0004\u0018\u00010\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0012J\u0015\u0010\u0015\u001a\u00020\u00062\b\u0010\u0016\u001a\u0004\u0018\u00010\u0006¢\u0006\u0002\u0010\u0017J\u0006\u0010\u0018\u001a\u00020\u0006J\u0006\u0010\u0019\u001a\u00020\u0006J\u0006\u0010\u001a\u001a\u00020\u0006J\u0006\u0010\u001b\u001a\u00020\u0006J\u0006\u0010\u001c\u001a\u00020\u0006J\u0006\u0010\u001d\u001a\u00020\u0006J\u0006\u0010\u001e\u001a\u00020\u001fJ\u0006\u0010 \u001a\u00020!J\u0006\u0010\"\u001a\u00020!J\u0006\u0010#\u001a\u00020!J\b\u0010$\u001a\u0004\u0018\u00010%J\u0006\u0010&\u001a\u00020\u0006J\b\u0010'\u001a\u00020\u0006H\u0002J\u0006\u0010(\u001a\u00020\u0006J\u0006\u0010)\u001a\u00020\u0006J\u0006\u0010*\u001a\u00020\u0006J\u0006\u0010+\u001a\u00020\u001fJ\u0006\u0010,\u001a\u00020\u0006R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006-"}, d2 = {"Lcom/bytedance/android/livesdkapi/model/com/bytedance/android/livesdk/config/MultiRoomConfig;", "", "()V", "multiRoomConfig", "Lcom/bytedance/android/livesdkapi/model/com/bytedance/android/livesdk/config/MultiRoomData;", "blockPreloadOnAnr", "", "blockPreloadOnJavaUsedPct", "", "blockPreloadOnPrefSerious", "disableLandscape", "disableSearch", "disableVsOrMic", "enableBackendOpt", "enableComponentCache", "room", "Lcom/bytedance/android/livesdkapi/depend/model/live/IRoom;", "dataCenter", "Lcom/bytedance/ies/sdk/widgets/DataCenter;", "enableComponentCacheFullLog", "enableComponentPreload", "enableRev", "isAnchor", "(Ljava/lang/Boolean;)Z", "enableRoomPreload", "fastGiftRev", "fixJump", "fixLeak", "fixSameRoom", "fixWidgetGetter", "getBackendDataExpiredTime", "", "getPreEnterRoomStage", "", "getPreRequestRoomBackendStage", "getPreRequestRoomPreloadStage", "getPreloadOpt", "Lcom/bytedance/android/livesdkapi/model/com/bytedance/android/livesdk/config/PreloadOpt;", "isBlockPreloadAtPrefPoor", "isPad", "isPostPreloadTask", "isUseNewRoomController", "isUseScopeRxBus", "postDelayTime", "useRecommendDataForPreload", "infrastructure_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class MultiRoomConfig {
    public static final MultiRoomConfig INSTANCE = null;
    private static final MultiRoomData multiRoomConfig = null;

    private MultiRoomConfig() {
    }

    public final boolean disableLandscape() {
        return true;
    }

    public final boolean disableVsOrMic() {
        return true;
    }

    static {
        INSTANCE = new MultiRoomConfig();
        multiRoomConfig = hc0.f120361a.getValue();
    }

    private final boolean isPad() {
        IMiddleWareHostContext r100 = (IMiddleWareHostContext) k.f(IMiddleWareHostContext.class);
        if (r100 == null) goto L5;
        String r101 = r100.getDevicePlatform();
    L7:
        return Intrinsics.areEqual("Android_Pad", r101);
    L5:
        r101 = null;
        goto L7
    }

    public final boolean blockPreloadOnAnr() {
        return multiRoomConfig.getBlockPreloadOnAnr();
    }

    public final float blockPreloadOnJavaUsedPct() {
        return multiRoomConfig.getBlockPreloadOnJavaUsedPct();
    }

    public final boolean blockPreloadOnPrefSerious() {
        return multiRoomConfig.getBlockPreloadOnPrefSerious();
    }

    public final boolean disableSearch() {
        return multiRoomConfig.getDisableSearch();
    }

    public final boolean enableRoomPreload() {
        MultiRoomData r100 = multiRoomConfig;
        if (r100.getEnable() == true) goto L5;
    L13:
        return false;
    L5:
        if (r100.getEnableRoomPreload() == false) goto L13;
        if (LiveInteractionFrameworkOptHelper.INSTANCE.enable() == false) goto L13;
        if (isPad() == true) goto L13;
        if (ComponentManagerABHelper.INSTANCE.isLiveRoomNewManager() == false) goto L13;
        return true;
    }

    public final long getBackendDataExpiredTime() {
        return multiRoomConfig.getBackendDataExpiredTime();
    }

    public final int getPreEnterRoomStage() {
        return multiRoomConfig.getPreEnterRoomStage();
    }

    public final int getPreRequestRoomBackendStage() {
        return multiRoomConfig.getPreRequestRoomBackendStage();
    }

    public final int getPreRequestRoomPreloadStage() {
        return multiRoomConfig.getPreRequestRoomPreloadStage();
    }

    public final boolean isBlockPreloadAtPrefPoor() {
        return multiRoomConfig.isBlockPreloadAtPrefPoor();
    }

    public final boolean isPostPreloadTask() {
        return multiRoomConfig.getPostPreloadTask();
    }

    public final long postDelayTime() {
        return multiRoomConfig.getPostDelayTime();
    }

    public final boolean useRecommendDataForPreload() {
        return multiRoomConfig.getUseRecommendDataForPreload();
    }

    public final boolean enableBackendOpt() {
        if (enableRoomPreload() == true) goto L5;
    L7:
        return false;
    L5:
        if (multiRoomConfig.getBackendOpt() == false) goto L7;
        return true;
    }

    public final boolean enableComponentCache() {
        if (enableRoomPreload() == true) goto L5;
    L7:
        return false;
    L5:
        if (LiveInfraSettingKeys.LIVE_COMPONENT_CACHE_CONFIG.getValue().getEnable() == false) goto L7;
        return true;
    }

    public final boolean enableComponentCacheFullLog() {
        if (enableRoomPreload() == true) goto L5;
    L7:
        return false;
    L5:
        if (LiveInfraSettingKeys.LIVE_COMPONENT_CACHE_CONFIG.getValue().getEnableFullLog() == false) goto L7;
        return true;
    }

    public final boolean fastGiftRev() {
        if (enableRoomPreload() == true) goto L5;
    L7:
        return false;
    L5:
        if (multiRoomConfig.getEnableFastGiftRev() == false) goto L7;
        return true;
    }

    public final boolean fixJump() {
        if (enableRoomPreload() == true) goto L5;
    L7:
        return false;
    L5:
        if (LiveInfraSettingKeys.LIVE_MULTI_ROOM_FIX_JUMP_EVENT.getValue().booleanValue() == false) goto L7;
        return true;
    }

    public final boolean fixLeak() {
        if (enableRoomPreload() == true) goto L5;
    L7:
        return false;
    L5:
        if (multiRoomConfig.getDisposeRxBus() == false) goto L7;
        return true;
    }

    public final boolean fixSameRoom() {
        if (enableRoomPreload() == true) goto L5;
    L7:
        return false;
    L5:
        if (LiveInfraSettingKeys.LIVE_FIX_SAME_ROOM.getValue().booleanValue() == false) goto L7;
        return true;
    }

    public final boolean fixWidgetGetter() {
        if (enableRoomPreload() == true) goto L5;
    L7:
        return false;
    L5:
        if (LiveInfraSettingKeys.LIVE_COMPONENT_CACHE_FIX_GET_WIDGET.getValue().booleanValue() == false) goto L7;
        return true;
    }

    public final PreloadOpt getPreloadOpt() {
        if (enableRoomPreload() == false) goto L10;
        MultiRoomData r100 = multiRoomConfig;
        PreloadOpt r101 = r100.getPreloadOpt();
        if (r101 != null) goto L7;
        return null;
    L7:
        if (r101.getEnable() == true) goto L9;
        return null;
    L9:
        return r100.getPreloadOpt();
    L10:
        return null;
    }

    public final boolean isUseNewRoomController() {
        if (enableRoomPreload() == true) goto L5;
    L7:
        return false;
    L5:
        if (multiRoomConfig.isUseNewRoomController() == false) goto L7;
        return true;
    }

    public final boolean isUseScopeRxBus() {
        if (enableRoomPreload() == true) goto L5;
    L7:
        return false;
    L5:
        if (multiRoomConfig.isUseScopeRxBus() == false) goto L7;
        return true;
    }

    public final boolean enableRev(Boolean r100) {
        if (Intrinsics.areEqual(r100, Boolean.FALSE) == true) goto L5;
    L9:
        return false;
    L5:
        if (enableRoomPreload() == false) goto L9;
        if (multiRoomConfig.getEnableRev() == false) goto L9;
        return true;
    }

    public final boolean enableComponentCache(IRoom r100, DataCenter r101) {
        if (enableComponentPreload(r100, r101) == true) goto L5;
    L14:
        return false;
    L5:
        if (LiveInfraSettingKeys.LIVE_COMPONENT_CACHE_CONFIG.getValue().getEnable() == false) goto L14;
        if (disableSearch() == false) goto L16;
        if (r101 == null) goto L17;
        IExternalConfigJudger r102 = (IExternalConfigJudger) r101.get("data_live_exter_config_judger", null);
        if (r102 != null) goto L12;
        return true;
    L12:
        if (r102.isInExternalMode() == true) goto L14;
        return true;
    L17:
        return true;
    L16:
        return true;
    }

    public final boolean enableComponentPreload(IRoom r100, DataCenter r101) {
        if (enableRoomPreload() == true) goto L5;
    L22:
        return false;
    L5:
        if (r100 != null) goto L7;
    L8:
        if (r100 != null) goto L10;
    L11:
        Boolean r102 = null;
        if (r101 == null) goto L14;
        Boolean r103 = (Boolean) r101.get("data_is_portrait", Boolean.TRUE);
    L15:
        Boolean r104 = Boolean.FALSE;
        if ((!Intrinsics.areEqual(r103, r104)) == false) goto L22;
        if (r101 == null) goto L20;
        r102 = (Boolean) r101.get("data_is_anchor", r104);
    L20:
        if ((!Intrinsics.areEqual(r102, Boolean.TRUE)) == false) goto L22;
        return true;
    L14:
        r103 = null;
        goto L15
    L10:
        if (r100.isMergeVSRoom() == true) goto L22;
    L7:
        if (r100.isMediaRoom() == true) goto L22;
        goto L8
    }
}
