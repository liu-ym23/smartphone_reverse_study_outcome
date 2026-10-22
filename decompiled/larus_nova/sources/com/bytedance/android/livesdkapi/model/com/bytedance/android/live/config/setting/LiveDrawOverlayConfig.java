package com.bytedance.android.livesdkapi.model.com.bytedance.android.live.config.setting;

import com.google.gson.annotations.SerializedName;
import java.util.HashSet;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes12.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010\u000b\n\u0002\b\u001a\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002R2\u0010\u0003\u001a\u0016\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u0004j\n\u0012\u0004\u0012\u00020\u0005\u0018\u0001`\u00068\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR2\u0010\u000b\u001a\u0016\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u0004j\n\u0012\u0004\u0012\u00020\u0005\u0018\u0001`\u00068\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\b\"\u0004\b\r\u0010\nR2\u0010\u000e\u001a\u0016\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u0004j\n\u0012\u0004\u0012\u00020\u0005\u0018\u0001`\u00068\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\b\"\u0004\b\u0010\u0010\nR\u001e\u0010\u0011\u001a\u00020\u00128\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016R\u001e\u0010\u0017\u001a\u00020\u00128\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0018\u0010\u0014\"\u0004\b\u0019\u0010\u0016R\u001e\u0010\u001a\u001a\u00020\u00128\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001b\u0010\u0014\"\u0004\b\u001c\u0010\u0016R\u001e\u0010\u001d\u001a\u00020\u00128\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001e\u0010\u0014\"\u0004\b\u001f\u0010\u0016R\u001e\u0010 \u001a\u00020\u00128\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b!\u0010\u0014\"\u0004\b\"\u0010\u0016R\u001e\u0010#\u001a\u00020\u00128\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b$\u0010\u0014\"\u0004\b%\u0010\u0016R\u001e\u0010&\u001a\u00020\u00128\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b'\u0010\u0014\"\u0004\b(\u0010\u0016R2\u0010)\u001a\u0016\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u0004j\n\u0012\u0004\u0012\u00020\u0005\u0018\u0001`\u00068\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b*\u0010\b\"\u0004\b+\u0010\n¨\u0006,"}, d2 = {"Lcom/bytedance/android/livesdkapi/model/com/bytedance/android/live/config/setting/LiveDrawOverlayConfig;", "", "()V", "checkEmptyList", "Ljava/util/HashSet;", "", "Lkotlin/collections/HashSet;", "getCheckEmptyList", "()Ljava/util/HashSet;", "setCheckEmptyList", "(Ljava/util/HashSet;)V", "checkPosList", "getCheckPosList", "setCheckPosList", "checkSizeList", "getCheckSizeList", "setCheckSizeList", "checkViewPagerVisible", "", "getCheckViewPagerVisible", "()Z", "setCheckViewPagerVisible", "(Z)V", "enable", "getEnable", "setEnable", "enableEmptyCheck", "getEnableEmptyCheck", "setEnableEmptyCheck", "enablePosCheck", "getEnablePosCheck", "setEnablePosCheck", "enableSizeCheck", "getEnableSizeCheck", "setEnableSizeCheck", "enableVPItemFreeze", "getEnableVPItemFreeze", "setEnableVPItemFreeze", "localTest", "getLocalTest", "setLocalTest", "whiteList", "getWhiteList", "setWhiteList", "infrastructure_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class LiveDrawOverlayConfig {

    @SerializedName("check_empty_list")
    private HashSet<String> checkEmptyList;

    @SerializedName("check_pos_list")
    private HashSet<String> checkPosList;

    @SerializedName("check_size_list")
    private HashSet<String> checkSizeList;

    @SerializedName("enable_check_viewpager_visible")
    private boolean checkViewPagerVisible;

    @SerializedName("enable")
    private boolean enable;

    @SerializedName("enable_empty_check")
    private boolean enableEmptyCheck;

    @SerializedName("enable_pos_check")
    private boolean enablePosCheck;

    @SerializedName("enable_size_check")
    private boolean enableSizeCheck;

    @SerializedName("enable_vp_item_freeze")
    private boolean enableVPItemFreeze;

    @SerializedName("local_test")
    private boolean localTest;

    @SerializedName("white_list")
    private HashSet<String> whiteList;

    public LiveDrawOverlayConfig() {
    }

    public final HashSet<String> getCheckEmptyList() {
        return this.checkEmptyList;
    }

    public final HashSet<String> getCheckPosList() {
        return this.checkPosList;
    }

    public final HashSet<String> getCheckSizeList() {
        return this.checkSizeList;
    }

    public final boolean getCheckViewPagerVisible() {
        return this.checkViewPagerVisible;
    }

    public final boolean getEnable() {
        return this.enable;
    }

    public final boolean getEnableEmptyCheck() {
        return this.enableEmptyCheck;
    }

    public final boolean getEnablePosCheck() {
        return this.enablePosCheck;
    }

    public final boolean getEnableSizeCheck() {
        return this.enableSizeCheck;
    }

    public final boolean getEnableVPItemFreeze() {
        return this.enableVPItemFreeze;
    }

    public final boolean getLocalTest() {
        return this.localTest;
    }

    public final HashSet<String> getWhiteList() {
        return this.whiteList;
    }

    public final void setCheckEmptyList(HashSet<String> r100) {
        this.checkEmptyList = r100;
    }

    public final void setCheckPosList(HashSet<String> r100) {
        this.checkPosList = r100;
    }

    public final void setCheckSizeList(HashSet<String> r100) {
        this.checkSizeList = r100;
    }

    public final void setCheckViewPagerVisible(boolean r100) {
        this.checkViewPagerVisible = r100;
    }

    public final void setEnable(boolean r100) {
        this.enable = r100;
    }

    public final void setEnableEmptyCheck(boolean r100) {
        this.enableEmptyCheck = r100;
    }

    public final void setEnablePosCheck(boolean r100) {
        this.enablePosCheck = r100;
    }

    public final void setEnableSizeCheck(boolean r100) {
        this.enableSizeCheck = r100;
    }

    public final void setEnableVPItemFreeze(boolean r100) {
        this.enableVPItemFreeze = r100;
    }

    public final void setLocalTest(boolean r100) {
        this.localTest = r100;
    }

    public final void setWhiteList(HashSet<String> r100) {
        this.whiteList = r100;
    }
}
