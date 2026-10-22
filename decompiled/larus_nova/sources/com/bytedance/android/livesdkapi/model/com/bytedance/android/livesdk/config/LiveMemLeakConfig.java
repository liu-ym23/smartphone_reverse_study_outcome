package com.bytedance.android.livesdkapi.model.com.bytedance.android.livesdk.config;

import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes12.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\bG\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002R\u001e\u0010\u0003\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u001e\u0010\t\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u0006\"\u0004\b\u000b\u0010\bR\u001e\u0010\f\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u0006\"\u0004\b\u000e\u0010\bR\u001e\u0010\u000f\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0006\"\u0004\b\u0011\u0010\bR\u001e\u0010\u0012\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u0006\"\u0004\b\u0014\u0010\bR\u001e\u0010\u0015\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\u0006\"\u0004\b\u0017\u0010\bR\u001e\u0010\u0018\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0019\u0010\u0006\"\u0004\b\u001a\u0010\bR\u001e\u0010\u001b\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001c\u0010\u0006\"\u0004\b\u001d\u0010\bR\u001e\u0010\u001e\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001f\u0010\u0006\"\u0004\b \u0010\bR\u001e\u0010!\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\"\u0010\u0006\"\u0004\b#\u0010\bR\u001e\u0010$\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b%\u0010\u0006\"\u0004\b&\u0010\bR\u001e\u0010'\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b(\u0010\u0006\"\u0004\b)\u0010\bR\u001e\u0010*\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b+\u0010\u0006\"\u0004\b,\u0010\bR\u001e\u0010-\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b.\u0010\u0006\"\u0004\b/\u0010\bR\u001e\u00100\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b1\u0010\u0006\"\u0004\b2\u0010\bR\u001e\u00103\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b4\u0010\u0006\"\u0004\b5\u0010\bR\u001e\u00106\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b7\u0010\u0006\"\u0004\b8\u0010\bR\u001e\u00109\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b:\u0010\u0006\"\u0004\b;\u0010\bR\u001e\u0010<\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b=\u0010\u0006\"\u0004\b>\u0010\bR\u001e\u0010?\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b@\u0010\u0006\"\u0004\bA\u0010\bR\u001e\u0010B\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bC\u0010\u0006\"\u0004\bD\u0010\bR\u001e\u0010E\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bF\u0010\u0006\"\u0004\bG\u0010\bR\u001e\u0010H\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bI\u0010\u0006\"\u0004\bJ\u0010\b¨\u0006K"}, d2 = {"Lcom/bytedance/android/livesdkapi/model/com/bytedance/android/livesdk/config/LiveMemLeakConfig;", "", "()V", "fixAudioLeak", "", "getFixAudioLeak", "()Z", "setFixAudioLeak", "(Z)V", "fixDataCenter", "getFixDataCenter", "setFixDataCenter", "fixInteractStore", "getFixInteractStore", "setFixInteractStore", "fixPlayerData", "getFixPlayerData", "setFixPlayerData", "fixPublicScreen", "getFixPublicScreen", "setFixPublicScreen", "fixPublicScreenV2", "getFixPublicScreenV2", "setFixPublicScreenV2", "fixRemoveService", "getFixRemoveService", "setFixRemoveService", "fixScopeManage", "getFixScopeManage", "setFixScopeManage", "fixShareCompositeWidgetCallback", "getFixShareCompositeWidgetCallback", "setFixShareCompositeWidgetCallback", "fixTimonObserver", "getFixTimonObserver", "setFixTimonObserver", "fixUserInfo", "getFixUserInfo", "setFixUserInfo", "fixWidgetCallback", "getFixWidgetCallback", "setFixWidgetCallback", "openFixAbilityCenter", "getOpenFixAbilityCenter", "setOpenFixAbilityCenter", "openFixPlayerV1", "getOpenFixPlayerV1", "setOpenFixPlayerV1", "openFixPlayerV2", "getOpenFixPlayerV2", "setOpenFixPlayerV2", "openFixV1", "getOpenFixV1", "setOpenFixV1", "openFixV2", "getOpenFixV2", "setOpenFixV2", "openFixV3", "getOpenFixV3", "setOpenFixV3", "openFixV4", "getOpenFixV4", "setOpenFixV4", "openFixV5", "getOpenFixV5", "setOpenFixV5", "openFixV6", "getOpenFixV6", "setOpenFixV6", "openFixV7", "getOpenFixV7", "setOpenFixV7", "openFixer", "getOpenFixer", "setOpenFixer", "infrastructure_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class LiveMemLeakConfig {

    @SerializedName("fix_audio_leak")
    private boolean fixAudioLeak;

    @SerializedName("fix_data_center")
    private boolean fixDataCenter;

    @SerializedName("fix_interact_store")
    private boolean fixInteractStore;

    @SerializedName("fix_player_data")
    private boolean fixPlayerData;

    @SerializedName("fix_public_screen")
    private boolean fixPublicScreen;

    @SerializedName("fix_public_screen_v2")
    private boolean fixPublicScreenV2;

    @SerializedName("fix_remove_service")
    private boolean fixRemoveService;

    @SerializedName("fix_scope_manager")
    private boolean fixScopeManage;

    @SerializedName("fix_share_composite_widget_callback")
    private boolean fixShareCompositeWidgetCallback;

    @SerializedName("fix_timon_observer")
    private boolean fixTimonObserver;

    @SerializedName("fix_user_info")
    private boolean fixUserInfo;

    @SerializedName("fix_widget_callback")
    private boolean fixWidgetCallback;

    @SerializedName("open_fix_ability_center")
    private boolean openFixAbilityCenter;

    @SerializedName("open_fix_player_v1")
    private boolean openFixPlayerV1;

    @SerializedName("open_fix_player_v2")
    private boolean openFixPlayerV2;

    @SerializedName("open_fix_v1")
    private boolean openFixV1;

    @SerializedName("open_fix_v2")
    private boolean openFixV2;

    @SerializedName("open_fix_v3")
    private boolean openFixV3;

    @SerializedName("open_fix_v4")
    private boolean openFixV4;

    @SerializedName("open_fix_v5")
    private boolean openFixV5;

    @SerializedName("open_fix_v6")
    private boolean openFixV6;

    @SerializedName("open_fix_v7")
    private boolean openFixV7;

    @SerializedName("open_fixer")
    private boolean openFixer;

    public LiveMemLeakConfig() {
        this.openFixV7 = true;
        this.openFixPlayerV1 = true;
        this.fixRemoveService = true;
        this.fixAudioLeak = true;
        this.fixPlayerData = true;
    }

    public final boolean getFixAudioLeak() {
        return this.fixAudioLeak;
    }

    public final boolean getFixDataCenter() {
        return this.fixDataCenter;
    }

    public final boolean getFixInteractStore() {
        return this.fixInteractStore;
    }

    public final boolean getFixPlayerData() {
        return this.fixPlayerData;
    }

    public final boolean getFixPublicScreen() {
        return this.fixPublicScreen;
    }

    public final boolean getFixPublicScreenV2() {
        return this.fixPublicScreenV2;
    }

    public final boolean getFixRemoveService() {
        return this.fixRemoveService;
    }

    public final boolean getFixScopeManage() {
        return this.fixScopeManage;
    }

    public final boolean getFixShareCompositeWidgetCallback() {
        return this.fixShareCompositeWidgetCallback;
    }

    public final boolean getFixTimonObserver() {
        return this.fixTimonObserver;
    }

    public final boolean getFixUserInfo() {
        return this.fixUserInfo;
    }

    public final boolean getFixWidgetCallback() {
        return this.fixWidgetCallback;
    }

    public final boolean getOpenFixAbilityCenter() {
        return this.openFixAbilityCenter;
    }

    public final boolean getOpenFixPlayerV1() {
        return this.openFixPlayerV1;
    }

    public final boolean getOpenFixPlayerV2() {
        return this.openFixPlayerV2;
    }

    public final boolean getOpenFixV1() {
        return this.openFixV1;
    }

    public final boolean getOpenFixV2() {
        return this.openFixV2;
    }

    public final boolean getOpenFixV3() {
        return this.openFixV3;
    }

    public final boolean getOpenFixV4() {
        return this.openFixV4;
    }

    public final boolean getOpenFixV5() {
        return this.openFixV5;
    }

    public final boolean getOpenFixV6() {
        return this.openFixV6;
    }

    public final boolean getOpenFixV7() {
        return this.openFixV7;
    }

    public final boolean getOpenFixer() {
        return this.openFixer;
    }

    public final void setFixAudioLeak(boolean r100) {
        this.fixAudioLeak = r100;
    }

    public final void setFixDataCenter(boolean r100) {
        this.fixDataCenter = r100;
    }

    public final void setFixInteractStore(boolean r100) {
        this.fixInteractStore = r100;
    }

    public final void setFixPlayerData(boolean r100) {
        this.fixPlayerData = r100;
    }

    public final void setFixPublicScreen(boolean r100) {
        this.fixPublicScreen = r100;
    }

    public final void setFixPublicScreenV2(boolean r100) {
        this.fixPublicScreenV2 = r100;
    }

    public final void setFixRemoveService(boolean r100) {
        this.fixRemoveService = r100;
    }

    public final void setFixScopeManage(boolean r100) {
        this.fixScopeManage = r100;
    }

    public final void setFixShareCompositeWidgetCallback(boolean r100) {
        this.fixShareCompositeWidgetCallback = r100;
    }

    public final void setFixTimonObserver(boolean r100) {
        this.fixTimonObserver = r100;
    }

    public final void setFixUserInfo(boolean r100) {
        this.fixUserInfo = r100;
    }

    public final void setFixWidgetCallback(boolean r100) {
        this.fixWidgetCallback = r100;
    }

    public final void setOpenFixAbilityCenter(boolean r100) {
        this.openFixAbilityCenter = r100;
    }

    public final void setOpenFixPlayerV1(boolean r100) {
        this.openFixPlayerV1 = r100;
    }

    public final void setOpenFixPlayerV2(boolean r100) {
        this.openFixPlayerV2 = r100;
    }

    public final void setOpenFixV1(boolean r100) {
        this.openFixV1 = r100;
    }

    public final void setOpenFixV2(boolean r100) {
        this.openFixV2 = r100;
    }

    public final void setOpenFixV3(boolean r100) {
        this.openFixV3 = r100;
    }

    public final void setOpenFixV4(boolean r100) {
        this.openFixV4 = r100;
    }

    public final void setOpenFixV5(boolean r100) {
        this.openFixV5 = r100;
    }

    public final void setOpenFixV6(boolean r100) {
        this.openFixV6 = r100;
    }

    public final void setOpenFixV7(boolean r100) {
        this.openFixV7 = r100;
    }

    public final void setOpenFixer(boolean r100) {
        this.openFixer = r100;
    }
}
