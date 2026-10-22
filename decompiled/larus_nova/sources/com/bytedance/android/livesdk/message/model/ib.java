package com.bytedance.android.livesdk.message.model;

import com.bytedance.tools.kcp.modelx.runtime.FieldName;
import com.bytedance.tools.kcp.modelx.runtime.internal.decode.FlexModelJsonAdapter;
import com.google.gson.annotations.JsonAdapter;
import java.util.Map;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes11.dex */
@JsonAdapter(FlexModelJsonAdapter.class)
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\f\bg\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u00012\u00020\u0002R$\u0010\n\u001a\u0004\u0018\u00010\u00038&@&X§\u000e¢\u0006\u0012\u0012\u0004\b\b\u0010\t\u001a\u0004\b\u0004\u0010\u0005\"\u0004\b\u0006\u0010\u0007R$\u0010\u000e\u001a\u0004\u0018\u00010\u00038&@&X§\u000e¢\u0006\u0012\u0012\u0004\b\r\u0010\t\u001a\u0004\b\u000b\u0010\u0005\"\u0004\b\f\u0010\u0007¨\u0006\u000f"}, d2 = {"Lcom/bytedance/android/livesdk/message/model/ib;", "Lvh7/c;", "Lcom/bytedance/android/live/base/model/message/c3;", "", "getMTopLeftUrl", "()Ljava/lang/String;", "setMTopLeftUrl", "(Ljava/lang/String;)V", "getMTopLeftUrl$annotations", "()V", "mTopLeftUrl", "getMBottomRightUrl", "setMBottomRightUrl", "getMBottomRightUrl$annotations", "mBottomRightUrl", "live-business-message-api_saasRelease"}, k = 1, mv = {1, 5, 1})
public interface ib extends vh7.c<ib>, com.bytedance.android.live.base.model.message.c3 {

    @JsonAdapter(FlexModelJsonAdapter.class)
    @Metadata(k = 3, mv = {1, 5, 1})
    public static final class a {
    }

    @Override // vh7.c
    /* synthetic */ vh7.e castTo(Class r100);

    @Override // vh7.c
    /* synthetic */ vh7.e castToOrNull(Class r100);

    /* synthetic */ com.bytedance.android.live.base.model.message.m0 getCommon();

    /* synthetic */ long getConsumeTime();

    /* synthetic */ long getDecodeEndTime();

    /* synthetic */ long getDecodeStartTime();

    /* synthetic */ long getDelayDispatchMs();

    /* synthetic */ long getEnqueueDispatchTime();

    /* synthetic */ int getGeneralMessageType();

    /* synthetic */ long getHttpSendTime();

    /* synthetic */ int getIntType();

    @FieldName(name = "buttom_right")
    String getMBottomRightUrl();

    @FieldName(name = "top_left")
    String getMTopLeftUrl();

    /* synthetic */ Map<String, String> getMessageExtra();

    /* synthetic */ int getMessageFrom();

    /* synthetic */ long getMessageId();

    /* synthetic */ String getMessageMethod();

    /* synthetic */ int getPriority();

    /* synthetic */ byte[] getRawPayload();

    /* synthetic */ long getReceiveTime();

    /* synthetic */ long getRoomId();

    /* synthetic */ long getTimestamp();

    /* synthetic */ String getWRDSKey();

    /* synthetic */ String getWRDSSubKey();

    /* synthetic */ long getWRDSVersion();

    /* synthetic */ boolean isFromFirstRequest();

    /* synthetic */ boolean isGlobalMessage();

    /* synthetic */ boolean isTimeCostCanUse();

    /* synthetic */ boolean isWRDSMessage();

    /* synthetic */ boolean needMonitor();

    /* synthetic */ void setCommon(com.bytedance.android.live.base.model.message.m0 r100);

    /* synthetic */ void setCommonMessageData(com.bytedance.android.live.base.model.message.m0 r100);

    /* synthetic */ void setConsumeTime(long r100);

    /* synthetic */ void setDecodeEndTime(long r100);

    /* synthetic */ void setDecodeStartTime(long r100);

    /* synthetic */ void setEnqueueDispatchTime(long r100);

    /* synthetic */ void setGeneralMessageType(int r100);

    /* synthetic */ void setHttpSendTime(long r100);

    /* synthetic */ void setIsFromFirstRequest(boolean r100);

    /* synthetic */ void setIsInsert(boolean r100);

    @FieldName(name = "buttom_right#setter")
    void setMBottomRightUrl(String r100);

    @FieldName(name = "top_left#setter")
    void setMTopLeftUrl(String r100);

    /* synthetic */ void setMessageExtra(Map<String, String> r100);

    /* synthetic */ void setMessageFrom(int r100);

    /* synthetic */ void setMessageMethod(String r100);

    /* synthetic */ void setRawPayload(byte[] r100);

    /* synthetic */ void setReceiveTime(long r100);

    /* synthetic */ void setTimestamp(long r100);

    /* synthetic */ void setWRDSMessage(boolean r100);

    /* synthetic */ void setWRDSSubKey(String r100);

    /* synthetic */ void setWRDSVersion(long r100);
}
