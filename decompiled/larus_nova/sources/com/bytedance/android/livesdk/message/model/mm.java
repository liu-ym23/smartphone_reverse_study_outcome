package com.bytedance.android.livesdk.message.model;

import com.bytedance.android.live.base.model.ImageModel;
import com.bytedance.android.livesdkapi.depend.message.MessageType;
import com.bytedance.bdp.appbase.base.event.BdpAppEventConstant;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes11.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\f\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0016\u0010\u0017R\"\u0010\u0003\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\"\u0010\t\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\t\u0010\u0004\u001a\u0004\b\n\u0010\u0006\"\u0004\b\u000b\u0010\bR$\u0010\r\u001a\u0004\u0018\u00010\f8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R\"\u0010\u0013\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0013\u0010\u0004\u001a\u0004\b\u0014\u0010\u0006\"\u0004\b\u0015\u0010\b¨\u0006\u0018"}, d2 = {"Lcom/bytedance/android/livesdk/message/model/mm;", "Lcom/bytedance/android/livesdk/message/model/o0;", "", "_burstTimeRemainSeconds", "J", "get_burstTimeRemainSeconds", "()J", "set_burstTimeRemainSeconds", "(J)V", "_multiple", "get_multiple", "set_multiple", "Lcom/bytedance/android/live/base/model/ImageModel;", "_propertyIcon", "Lcom/bytedance/android/live/base/model/ImageModel;", "get_propertyIcon", "()Lcom/bytedance/android/live/base/model/ImageModel;", "set_propertyIcon", "(Lcom/bytedance/android/live/base/model/ImageModel;)V", "_propertyDefinitionId", "get_propertyDefinitionId", "set_propertyDefinitionId", "<init>", "()V", "livemessage-api_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class mm extends o0 {

    @SerializedName("burst_time_remain_seconds")
    private long _burstTimeRemainSeconds;

    @SerializedName(BdpAppEventConstant.MULTIPLE)
    private long _multiple;

    @SerializedName("property_definition_id")
    private long _propertyDefinitionId;

    @SerializedName("property_icon")
    private ImageModel _propertyIcon;

    public mm() {
        this.type = MessageType.TURN_TABLE_BURST_V2;
    }
}
