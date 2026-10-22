package com.bytedance.android.livesdkapi.depend.model.broadcast;

import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes12.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002R \u0010\u0003\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\b¨\u0006\t"}, d2 = {"Lcom/bytedance/android/livesdkapi/depend/model/broadcast/InteractionItemDotInfo;", "", "()V", "itemDot", "Lcom/bytedance/android/livesdkapi/depend/model/broadcast/ItemDotInfo;", "getItemDot", "()Lcom/bytedance/android/livesdkapi/depend/model/broadcast/ItemDotInfo;", "setItemDot", "(Lcom/bytedance/android/livesdkapi/depend/model/broadcast/ItemDotInfo;)V", "livebase-model_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class InteractionItemDotInfo {

    @SerializedName("dot_info")
    private ItemDotInfo itemDot;

    public InteractionItemDotInfo() {
    }

    public final ItemDotInfo getItemDot() {
        return this.itemDot;
    }

    public final void setItemDot(ItemDotInfo r100) {
        this.itemDot = r100;
    }
}
