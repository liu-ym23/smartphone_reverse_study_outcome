package com.bytedance.android.livesdk.config;

import com.google.gson.annotations.SerializedName;
import java.util.List;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes8.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\n\b\u0007\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002R\u001e\u0010\u0003\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR&\u0010\t\u001a\n\u0012\u0004\u0012\u00020\u000b\u0018\u00010\n8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\u001a\u0010\u0010\u001a\u00020\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0006\"\u0004\b\u0011\u0010\bR&\u0010\u0012\u001a\n\u0012\u0004\u0012\u00020\u000b\u0018\u00010\n8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\r\"\u0004\b\u0014\u0010\u000f¨\u0006\u0015"}, d2 = {"Lcom/bytedance/android/livesdk/config/LiveTeaDynamicConfig;", "", "()V", "enable", "", "getEnable", "()Z", "setEnable", "(Z)V", "eventAllowList", "", "", "getEventAllowList", "()Ljava/util/List;", "setEventAllowList", "(Ljava/util/List;)V", "isTrackAll", "setTrackAll", "paramBlockList", "getParamBlockList", "setParamBlockList", "infrastructure_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class LiveTeaDynamicConfig {

    @SerializedName("enable")
    private boolean enable;

    @SerializedName("event_allow_list")
    private List<String> eventAllowList;
    private boolean isTrackAll;

    @SerializedName("param_block_list")
    private List<String> paramBlockList;

    public LiveTeaDynamicConfig() {
        List<String> r100 = this.eventAllowList;
        if (r100 != null) goto L5;
    L8:
        boolean r101 = true;
    L9:
        this.isTrackAll = r101;
        return;
    L5:
        if (r100.isEmpty() == true) goto L8;
        r101 = false;
        goto L9
    }

    public final boolean getEnable() {
        return this.enable;
    }

    public final List<String> getEventAllowList() {
        return this.eventAllowList;
    }

    public final List<String> getParamBlockList() {
        return this.paramBlockList;
    }

    public final boolean isTrackAll() {
        return this.isTrackAll;
    }

    public final void setEnable(boolean r100) {
        this.enable = r100;
    }

    public final void setEventAllowList(List<String> r100) {
        this.eventAllowList = r100;
    }

    public final void setParamBlockList(List<String> r100) {
        this.paramBlockList = r100;
    }

    public final void setTrackAll(boolean r100) {
        this.isTrackAll = r100;
    }
}
