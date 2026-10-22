package com.bytedance.android.livesdk.config;

import com.google.gson.annotations.SerializedName;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes8.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\b\b\u0007\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002R$\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR$\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00050\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\u0007\"\u0004\b\f\u0010\t¨\u0006\r"}, d2 = {"Lcom/bytedance/android/livesdk/config/LivePanelConfig;", "", "()V", "listenerBlockList", "", "", "getListenerBlockList", "()Ljava/util/List;", "setListenerBlockList", "(Ljava/util/List;)V", "panelBlockList", "getPanelBlockList", "setPanelBlockList", "liveutility_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class LivePanelConfig {

    @SerializedName("listener_block_list")
    private List<String> listenerBlockList;

    @SerializedName("panel_block_list")
    private List<String> panelBlockList;

    public LivePanelConfig() {
        this.panelBlockList = CollectionsKt.emptyList();
        this.listenerBlockList = CollectionsKt.emptyList();
    }

    public final List<String> getListenerBlockList() {
        return this.listenerBlockList;
    }

    public final List<String> getPanelBlockList() {
        return this.panelBlockList;
    }

    public final void setListenerBlockList(List<String> r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.listenerBlockList = r100;
    }

    public final void setPanelBlockList(List<String> r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.panelBlockList = r100;
    }
}
