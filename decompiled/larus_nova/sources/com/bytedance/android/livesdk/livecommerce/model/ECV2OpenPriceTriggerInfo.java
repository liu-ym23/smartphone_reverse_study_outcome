package com.bytedance.android.livesdk.livecommerce.model;

import com.bytedance.android.tools.pbadapter.annotation.ProtoMessage;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes10.dex */
@ProtoMessage("live.OpenPriceTriggerInfo")
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\b\u0010\tR\u0016\u0010\u0003\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\u0003\u0010\u0004R\u0018\u0010\u0006\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\u0006\u0010\u0007¨\u0006\n"}, d2 = {"Lcom/bytedance/android/livesdk/livecommerce/model/ECV2OpenPriceTriggerInfo;", "", "", "triggerType", "I", "Lcom/bytedance/android/livesdk/livecommerce/model/ECV2DelayParam;", "delayParam", "Lcom/bytedance/android/livesdk/livecommerce/model/ECV2DelayParam;", "<init>", "()V", "livecommerce_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class ECV2OpenPriceTriggerInfo {

    @SerializedName("delay_param")
    public ECV2DelayParam delayParam;

    @SerializedName("trigger_type")
    public int triggerType;

    public ECV2OpenPriceTriggerInfo() {
    }
}
