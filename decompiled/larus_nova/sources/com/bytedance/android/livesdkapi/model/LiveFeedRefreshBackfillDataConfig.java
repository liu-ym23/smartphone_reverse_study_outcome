package com.bytedance.android.livesdkapi.model;

import com.google.gson.annotations.SerializedName;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;

/* JADX INFO: loaded from: classes12.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010$\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002R&\u0010\u0003\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u001e\u0010\n\u001a\u00020\u000b8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR,\u0010\u0010\u001a\u0010\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u000b\u0018\u00010\u00118\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015R\u001e\u0010\u0016\u001a\u00020\u00178\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0018\u0010\u0019\"\u0004\b\u001a\u0010\u001b¨\u0006\u001c"}, d2 = {"Lcom/bytedance/android/livesdkapi/model/LiveFeedRefreshBackfillDataConfig;", "", "()V", "disableReasons", "", "", "getDisableReasons", "()Ljava/util/List;", "setDisableReasons", "(Ljava/util/List;)V", "disableReasonsEnable", "", "getDisableReasonsEnable", "()Z", "setDisableReasonsEnable", "(Z)V", "enableReasons", "", "getEnableReasons", "()Ljava/util/Map;", "setEnableReasons", "(Ljava/util/Map;)V", "enableType", "", "getEnableType", "()I", "setEnableType", "(I)V", "livebase-model_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class LiveFeedRefreshBackfillDataConfig {

    @SerializedName("disable_reasons")
    private List<String> disableReasons;

    @SerializedName("disable_reasons_enable")
    private boolean disableReasonsEnable;

    @SerializedName("enable_reasons")
    private Map<String, Boolean> enableReasons;

    @SerializedName("enable_type")
    private int enableType;

    public LiveFeedRefreshBackfillDataConfig() {
        this.enableType = 2;
        Boolean r100 = Boolean.TRUE;
        this.enableReasons = MapsKt.mapOf(new Pair[]{TuplesKt.to("close_check_homepage_hot", r100), TuplesKt.to("hot_update", r100), TuplesKt.to("close_check_homepage_follow", r100), TuplesKt.to("update_room", r100)});
        this.disableReasons = CollectionsKt.emptyList();
    }

    public final List<String> getDisableReasons() {
        return this.disableReasons;
    }

    public final boolean getDisableReasonsEnable() {
        return this.disableReasonsEnable;
    }

    public final Map<String, Boolean> getEnableReasons() {
        return this.enableReasons;
    }

    public final int getEnableType() {
        return this.enableType;
    }

    public final void setDisableReasons(List<String> r100) {
        this.disableReasons = r100;
    }

    public final void setDisableReasonsEnable(boolean r100) {
        this.disableReasonsEnable = r100;
    }

    public final void setEnableReasons(Map<String, Boolean> r100) {
        this.enableReasons = r100;
    }

    public final void setEnableType(int r100) {
        this.enableType = r100;
    }
}
