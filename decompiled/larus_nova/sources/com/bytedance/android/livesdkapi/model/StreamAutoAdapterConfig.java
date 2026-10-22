package com.bytedance.android.livesdkapi.model;

import com.google.gson.annotations.SerializedName;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes12.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0010\u0007\n\u0002\b\u000b\b\u0007\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002R\u001c\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u00048\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0016\u0010\b\u001a\u00020\t8\u0006X\u0087D¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0016\u0010\f\u001a\u00020\t8\u0006X\u0087D¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000bR\u0016\u0010\u000e\u001a\u00020\t8\u0006X\u0087D¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u000bR\u0016\u0010\u0010\u001a\u00020\u00118\u0006X\u0087D¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u0016\u0010\u0014\u001a\u00020\t8\u0006X\u0087D¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u000bR\u0016\u0010\u0016\u001a\u00020\t8\u0006X\u0087D¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u000bR\u0016\u0010\u0018\u001a\u00020\t8\u0006X\u0087D¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u000bR\u0016\u0010\u001a\u001a\u00020\u00118\u0006X\u0087D¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u0013¨\u0006\u001c"}, d2 = {"Lcom/bytedance/android/livesdkapi/model/StreamAutoAdapterConfig;", "", "()V", "blackPanelList", "", "", "getBlackPanelList", "()Ljava/util/List;", "canScrollIntercept", "", "getCanScrollIntercept", "()Z", "disableAnimator", "getDisableAnimator", "enable", "getEnable", "headSafeDistance", "", "getHeadSafeDistance", "()F", "interceptFold", "getInterceptFold", "searchSceneFix", "getSearchSceneFix", "statusControllerOpt", "getStatusControllerOpt", "uiOptimizeDp", "getUiOptimizeDp", "live-model-api_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class StreamAutoAdapterConfig {

    @SerializedName("black_list")
    private final List<String> blackPanelList;

    @SerializedName("can_scroll_intercept")
    private final boolean canScrollIntercept;

    @SerializedName("disable_animator")
    private final boolean disableAnimator;

    @SerializedName("enable")
    private final boolean enable;

    @SerializedName("head_safe_distance")
    private final float headSafeDistance;

    @SerializedName("intercept_fold_screen")
    private final boolean interceptFold;

    @SerializedName("search_scene_fix")
    private final boolean searchSceneFix;

    @SerializedName("status_controller_opt")
    private final boolean statusControllerOpt;

    @SerializedName("ui_optimize_dp")
    private final float uiOptimizeDp;

    public StreamAutoAdapterConfig() {
        this.enable = true;
        this.headSafeDistance = 0.04f;
        this.blackPanelList = new ArrayList();
        this.uiOptimizeDp = 10.0f;
        this.searchSceneFix = true;
        this.interceptFold = true;
        this.canScrollIntercept = true;
    }

    public final List<String> getBlackPanelList() {
        return this.blackPanelList;
    }

    public final boolean getCanScrollIntercept() {
        return this.canScrollIntercept;
    }

    public final boolean getDisableAnimator() {
        return this.disableAnimator;
    }

    public final boolean getEnable() {
        return this.enable;
    }

    public final float getHeadSafeDistance() {
        return this.headSafeDistance;
    }

    public final boolean getInterceptFold() {
        return this.interceptFold;
    }

    public final boolean getSearchSceneFix() {
        return this.searchSceneFix;
    }

    public final boolean getStatusControllerOpt() {
        return this.statusControllerOpt;
    }

    public final float getUiOptimizeDp() {
        return this.uiOptimizeDp;
    }
}
