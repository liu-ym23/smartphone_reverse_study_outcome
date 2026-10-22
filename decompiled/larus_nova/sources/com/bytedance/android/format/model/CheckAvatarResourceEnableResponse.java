package com.bytedance.android.format.model;

import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes44.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\t\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002R\u001e\u0010\u0003\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u001e\u0010\t\u001a\u00020\n8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000e¨\u0006\u000f"}, d2 = {"Lcom/bytedance/android/format/model/CheckAvatarResourceEnableResponse;", "Ljava/io/Serializable;", "()V", "canEnterLive", "", "getCanEnterLive", "()Z", "setCanEnterLive", "(Z)V", "pollingInterval", "", "getPollingInterval", "()J", "setPollingInterval", "(J)V", "format-api_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class CheckAvatarResourceEnableResponse implements Serializable {

    @SerializedName("can_enter_live")
    private boolean canEnterLive;

    @SerializedName("NextCheckTimeGap")
    private long pollingInterval;

    public CheckAvatarResourceEnableResponse() {
        this.pollingInterval = 2000;
    }

    public final boolean getCanEnterLive() {
        return this.canEnterLive;
    }

    public final long getPollingInterval() {
        return this.pollingInterval;
    }

    public final void setCanEnterLive(boolean r100) {
        this.canEnterLive = r100;
    }

    public final void setPollingInterval(long r100) {
        this.pollingInterval = r100;
    }
}
