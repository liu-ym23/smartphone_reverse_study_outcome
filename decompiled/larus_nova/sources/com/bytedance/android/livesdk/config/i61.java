package com.bytedance.android.livesdk.config;

import com.bytedance.android.live.base.model.longpresspanel.ItemConfig;
import com.google.gson.annotations.SerializedName;
import java.util.List;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes8.dex */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\n\u0010\u000bR\u0018\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\u0003\u0010\u0004R\u001e\u0010\u0007\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\u0007\u0010\bR\u001e\u0010\t\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\t\u0010\b¨\u0006\f"}, d2 = {"Lcom/bytedance/android/livesdk/config/i61;", "", "", "style", "Ljava/lang/Integer;", "", "Lcom/bytedance/android/live/base/model/longpresspanel/ItemConfig;", "liveRoomItemList", "Ljava/util/List;", "liveFeedItemList", "<init>", "()V", "liveutility_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class i61 {

    @SerializedName("live_feed_item_list")
    public List<ItemConfig> liveFeedItemList;

    @SerializedName("live_room_item_list")
    public List<ItemConfig> liveRoomItemList;

    @SerializedName("style")
    public Integer style;

    public i61() {
        this.style = 1;
    }
}
