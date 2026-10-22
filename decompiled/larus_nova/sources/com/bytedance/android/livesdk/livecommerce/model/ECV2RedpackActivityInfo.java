package com.bytedance.android.livesdk.livecommerce.model;

import com.bytedance.android.tools.pbadapter.annotation.ProtoMessage;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes10.dex */
@ProtoMessage("live.RedpackActivityInfo")
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\n\b\u0007\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002R\u0014\u0010\u0003\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0005\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u0006\u001a\u00020\u00078\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\b\u001a\u00020\u00078\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\t\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\n\u001a\u00020\u00078\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u000b\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\f\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\r\u001a\u00020\u000e8\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u000f\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0010\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0011\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0012\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u0013\u001a\u00020\u00078\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u0014\u001a\u00020\u00078\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u0015\u001a\u00020\u000e8\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u0016\u001a\u00020\u00078\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u0017\u001a\u00020\u00078\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000¨\u0006\u0018"}, d2 = {"Lcom/bytedance/android/livesdk/livecommerce/model/ECV2RedpackActivityInfo;", "", "()V", "authorAvatarUrl", "", "authorName", "endApplyTime", "", "maxAmount", "pendantBackgroundUrl", "preHeatTime", "redPacketActivityId", "redPacketActivityName", "redPacketType", "", "redpackAfterBackgroundUrl", "redpackAfterBeltUrl", "redpackFrontBackgroundUrl", "redpackLabel", "scatterTime", "serverTime", "showType", "startApplyTime", "totalAmount", "livecommerce_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class ECV2RedpackActivityInfo {

    @SerializedName("author_avatar_url")
    public String authorAvatarUrl;

    @SerializedName("author_name")
    public String authorName;

    @SerializedName("end_apply_time")
    public long endApplyTime;

    @SerializedName("max_amount")
    public long maxAmount;

    @SerializedName("pendant_background_url")
    public String pendantBackgroundUrl;

    @SerializedName("preheat_time")
    public long preHeatTime;

    @SerializedName("redpack_activity_id")
    public String redPacketActivityId;

    @SerializedName("redpack_activity_name")
    public String redPacketActivityName;

    @SerializedName("redpack_type")
    public int redPacketType;

    @SerializedName("redpack_after_background_url")
    public String redpackAfterBackgroundUrl;

    @SerializedName("redpack_after_belt_url")
    public String redpackAfterBeltUrl;

    @SerializedName("redpack_front_background_url")
    public String redpackFrontBackgroundUrl;

    @SerializedName("redpack_label")
    public String redpackLabel;

    @SerializedName("scatter_time")
    public long scatterTime;

    @SerializedName("server_time")
    public long serverTime;

    @SerializedName("show_type")
    public int showType;

    @SerializedName("start_apply_time")
    public long startApplyTime;

    @SerializedName("total_amount")
    public long totalAmount;

    public ECV2RedpackActivityInfo() {
        this.showType = 1;
    }
}
