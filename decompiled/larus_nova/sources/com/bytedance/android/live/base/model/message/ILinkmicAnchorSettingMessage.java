package com.bytedance.android.live.base.model.message;

import com.bytedance.tools.kcp.modelx.runtime.FieldName;
import com.bytedance.tools.kcp.modelx.runtime.internal.decode.FlexModelJsonAdapter;
import com.google.gson.annotations.JsonAdapter;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes45.dex */
@JsonAdapter(FlexModelJsonAdapter.class)
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\bg\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u00012\u00020\u0002R2\u0010\f\u001a\u0012\u0012\u0004\u0012\u00020\u00040\u0003j\b\u0012\u0004\u0012\u00020\u0004`\u00058&@&X§\u000e¢\u0006\u0012\u0012\u0004\b\n\u0010\u000b\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\t¨\u0006\r"}, d2 = {"Lcom/bytedance/android/live/base/model/message/ILinkmicAnchorSettingMessage;", "Lvh7/c;", "Lcom/bytedance/android/live/base/model/message/c3;", "", "Lcom/bytedance/android/livesdk/chatroom/interact/model/y;", "Lcom/bytedance/revenue/platform/api/core/KmpList;", "getSetting", "()Ljava/util/List;", "setSetting", "(Ljava/util/List;)V", "getSetting$annotations", "()V", "setting", "live-business-message-api_saasRelease"}, k = 1, mv = {1, 5, 1})
public interface ILinkmicAnchorSettingMessage extends vh7.c<ILinkmicAnchorSettingMessage>, c3 {

    @JsonAdapter(FlexModelJsonAdapter.class)
    @Metadata(k = 3, mv = {1, 5, 1})
    public static final class a {
    }

    @Override // vh7.c
    /* synthetic */ vh7.e castTo(Class r100);

    @Override // vh7.c
    /* synthetic */ vh7.e castToOrNull(Class r100);

    @Override // com.bytedance.android.live.base.model.message.c3
    /* synthetic */ m0 getCommon();

    @Override // com.bytedance.android.live.base.model.message.d3
    /* synthetic */ long getConsumeTime();

    @Override // com.bytedance.android.live.base.model.message.d3
    /* synthetic */ long getDecodeEndTime();

    @Override // com.bytedance.android.live.base.model.message.d3
    /* synthetic */ long getDecodeStartTime();

    @Override // tlc.d
    /* synthetic */ long getDelayDispatchMs();

    @Override // com.bytedance.android.live.base.model.message.d3
    /* synthetic */ long getEnqueueDispatchTime();

    @Override // tlc.d
    /* synthetic */ int getGeneralMessageType();

    @Override // com.bytedance.android.live.base.model.message.d3
    /* synthetic */ long getHttpSendTime();

    @Override // tlc.d, com.bytedance.android.livesdkapi.message.IExternalLiveMessage
    /* synthetic */ int getIntType();

    /* synthetic */ Map<String, String> getMessageExtra();

    @Override // tlc.d
    /* synthetic */ int getMessageFrom();

    @Override // tlc.d
    /* synthetic */ long getMessageId();

    @Override // tlc.d
    /* synthetic */ String getMessageMethod();

    /* synthetic */ int getPriority();

    @Override // com.bytedance.android.live.base.model.message.d3
    /* synthetic */ byte[] getRawPayload();

    @Override // com.bytedance.android.live.base.model.message.d3
    /* synthetic */ long getReceiveTime();

    @Override // tlc.d
    /* synthetic */ long getRoomId();

    @FieldName(name = "settings")
    List<com.bytedance.android.livesdk.chatroom.interact.model.y> getSetting();

    /* synthetic */ long getTimestamp();

    @Override // xlc.b
    /* synthetic */ String getWRDSKey();

    @Override // xlc.b
    /* synthetic */ String getWRDSSubKey();

    @Override // xlc.b
    /* synthetic */ long getWRDSVersion();

    @Override // tlc.d
    /* synthetic */ boolean isFromFirstRequest();

    @Override // tlc.d
    /* synthetic */ boolean isGlobalMessage();

    @Override // com.bytedance.android.live.base.model.message.d3
    /* synthetic */ boolean isTimeCostCanUse();

    @Override // xlc.b
    /* synthetic */ boolean isWRDSMessage();

    @Override // tlc.d
    /* synthetic */ boolean needMonitor();

    /* synthetic */ void setCommon(m0 r100);

    @Override // com.bytedance.android.live.base.model.message.d3
    /* synthetic */ void setCommonMessageData(m0 r100);

    @Override // tlc.d
    /* synthetic */ void setConsumeTime(long r100);

    @Override // tlc.d
    /* synthetic */ void setDecodeEndTime(long r100);

    @Override // tlc.d
    /* synthetic */ void setDecodeStartTime(long r100);

    @Override // tlc.d
    /* synthetic */ void setEnqueueDispatchTime(long r100);

    @Override // com.bytedance.android.live.base.model.message.d3
    /* synthetic */ void setGeneralMessageType(int r100);

    @Override // tlc.d
    /* synthetic */ void setHttpSendTime(long r100);

    @Override // tlc.d
    /* synthetic */ void setIsFromFirstRequest(boolean r100);

    @Override // tlc.d
    /* synthetic */ void setIsInsert(boolean r100);

    @Override // com.bytedance.android.live.base.model.message.d3
    /* synthetic */ void setMessageExtra(Map<String, String> r100);

    @Override // com.bytedance.android.live.base.model.message.d3
    /* synthetic */ void setMessageFrom(int r100);

    @Override // tlc.d
    /* synthetic */ void setMessageMethod(String r100);

    @Override // com.bytedance.android.live.base.model.message.d3
    /* synthetic */ void setRawPayload(byte[] r100);

    @Override // tlc.d
    /* synthetic */ void setReceiveTime(long r100);

    @FieldName(name = "settings#setter")
    void setSetting(List<? extends com.bytedance.android.livesdk.chatroom.interact.model.y> r100);

    @Override // com.bytedance.android.live.base.model.message.d3
    /* synthetic */ void setTimestamp(long r100);

    @Override // xlc.b
    /* synthetic */ void setWRDSMessage(boolean r100);

    @Override // xlc.b
    /* synthetic */ void setWRDSSubKey(String r100);

    @Override // xlc.b
    /* synthetic */ void setWRDSVersion(long r100);
}
