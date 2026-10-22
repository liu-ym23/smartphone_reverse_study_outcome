package com.bytedance.android.livesdk.livecommerce.model;

import com.bytedance.android.tools.pbadapter.annotation.ProtoMessage;
import com.google.gson.annotations.SerializedName;
import com.larus.avlink.aiproactive.AiProactiveTaskViewModel;
import java.util.List;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes10.dex */
@ProtoMessage("live.LotteryInfoList")
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\b\n\u0000\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\b\u0003\b\u0007\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002R\u0014\u0010\u0003\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0005\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0006\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0007\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\b\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\t\u001a\u00020\n8\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u000b\u001a\u00020\f8\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\r\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u000e\u001a\u00020\f8\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\u000f\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u00108\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u0011\u001a\u00020\f8\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0012\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000¨\u0006\u0013"}, d2 = {"Lcom/bytedance/android/livesdk/livecommerce/model/ECV2LotteryInfoList;", "", "()V", "activityId", "", "buttonLabel", "elasticTitle", "extraInfo", "jumpUrl", "lotteryType", "", "openTime", "", "resultLabel", "taskType", "text", "", "userActivityStatus", "winRecordId", "livecommerce_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class ECV2LotteryInfoList {

    @SerializedName("activity_id")
    public String activityId;

    @SerializedName("button_label")
    public String buttonLabel;

    @SerializedName("elastic_title")
    public String elasticTitle;

    @SerializedName("extra_info")
    public String extraInfo;

    @SerializedName("jump_url")
    public String jumpUrl;

    @SerializedName("lottery_type")
    public int lotteryType;

    @SerializedName("open_time")
    public long openTime;

    @SerializedName("result_label")
    public String resultLabel;

    @SerializedName(AiProactiveTaskViewModel.PARAM_TASK_TYPE)
    public long taskType;

    @SerializedName("text")
    public List<String> text;

    @SerializedName("user_activity_status")
    public long userActivityStatus;

    @SerializedName("win_record_id")
    public String winRecordId;

    public ECV2LotteryInfoList() {
    }
}
