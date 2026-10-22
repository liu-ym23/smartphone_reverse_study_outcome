package com.bytedance.android.livesdk.model;

import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes11.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0005\b\u0007\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002R\u001e\u0010\u0003\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u001e\u0010\t\u001a\u00020\n8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000e¨\u0006\u000f"}, d2 = {"Lcom/bytedance/android/livesdk/model/MultiLinkEnlargeTipsConfig;", "", "()V", "firstShowTimestamp", "", "getFirstShowTimestamp", "()J", "setFirstShowTimestamp", "(J)V", "hasClicked", "", "getHasClicked", "()Z", "setHasClicked", "(Z)V", "infrastructure_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class MultiLinkEnlargeTipsConfig {

    @SerializedName("first_show_timestamp")
    private long firstShowTimestamp;

    @SerializedName("has_clicked")
    private boolean hasClicked;

    public MultiLinkEnlargeTipsConfig() {
    }

    public final long getFirstShowTimestamp() {
        return this.firstShowTimestamp;
    }

    public final boolean getHasClicked() {
        return this.hasClicked;
    }

    public final void setFirstShowTimestamp(long r100) {
        this.firstShowTimestamp = r100;
    }

    public final void setHasClicked(boolean r100) {
        this.hasClicked = r100;
    }
}
