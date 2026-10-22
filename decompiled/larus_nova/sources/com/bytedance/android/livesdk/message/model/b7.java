package com.bytedance.android.livesdk.message.model;

import com.bytedance.tools.kcp.modelx.runtime.FieldName;
import com.bytedance.tools.kcp.modelx.runtime.internal.decode.FlexModelJsonAdapter;
import com.google.gson.annotations.JsonAdapter;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import java.util.Map;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes11.dex */
@JsonAdapter(FlexModelJsonAdapter.class)
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\t\bg\u0018\u0000  2\b\u0012\u0004\u0012\u00020\u00000\u00012\u00020\u0002:\u0001!R\"\u0010\n\u001a\u00020\u00038&@&X§\u000e¢\u0006\u0012\u0012\u0004\b\b\u0010\t\u001a\u0004\b\u0004\u0010\u0005\"\u0004\b\u0006\u0010\u0007R$\u0010\u0011\u001a\u0004\u0018\u00010\u000b8&@&X§\u000e¢\u0006\u0012\u0012\u0004\b\u0010\u0010\t\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR$\u0010\u0018\u001a\u0004\u0018\u00010\u00128&@&X§\u000e¢\u0006\u0012\u0012\u0004\b\u0017\u0010\t\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016R$\u0010\u001f\u001a\u0004\u0018\u00010\u00198&@&X§\u000e¢\u0006\u0012\u0012\u0004\b\u001e\u0010\t\u001a\u0004\b\u001a\u0010\u001b\"\u0004\b\u001c\u0010\u001d¨\u0006\""}, d2 = {"Lcom/bytedance/android/livesdk/message/model/b7;", "Lvh7/c;", "Lcom/bytedance/android/live/base/model/message/c3;", "", "getAction", "()I", "setAction", "(I)V", "getAction$annotations", "()V", "action", "Lcom/bytedance/android/livesdk/message/model/m1;", "getBottomRightCardData", "()Lcom/bytedance/android/livesdk/message/model/m1;", "setBottomRightCardData", "(Lcom/bytedance/android/livesdk/message/model/m1;)V", "getBottomRightCardData$annotations", "bottomRightCardData", "Lcom/bytedance/android/livesdk/message/model/k1;", "getBizPinArea", "()Lcom/bytedance/android/livesdk/message/model/k1;", "setBizPinArea", "(Lcom/bytedance/android/livesdk/message/model/k1;)V", "getBizPinArea$annotations", "bizPinArea", "Lcom/bytedance/android/livesdk/message/model/i3;", "getCommonCard", "()Lcom/bytedance/android/livesdk/message/model/i3;", "setCommonCard", "(Lcom/bytedance/android/livesdk/message/model/i3;)V", "getCommonCard$annotations", "commonCard", "ActionType", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "live-business-message-api_saasRelease"}, k = 1, mv = {1, 5, 1})
public interface b7 extends vh7.c<b7>, com.bytedance.android.live.base.model.message.c3 {
    public static final a ActionType = null;
    public static final int Destroy = 2;
    public static final int Recreate = 3;
    public static final int Refresh = 1;
    public static final int UnknownMessageType = 0;

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ a f153626a = null;

        public a() {
        }

        static {
            f153626a = new a();
        }
    }

    @JsonAdapter(FlexModelJsonAdapter.class)
    @Metadata(k = 3, mv = {1, 5, 1})
    public static final class b {
    }

    static {
        ActionType = a.f153626a;
    }

    @Override // vh7.c
    /* synthetic */ vh7.e castTo(Class r100);

    @Override // vh7.c
    /* synthetic */ vh7.e castToOrNull(Class r100);

    @FieldName(name = "message_type")
    int getAction();

    @FieldName(name = "biz_pin_area")
    k1 getBizPinArea();

    @FieldName(name = "bottom_right_card_data")
    m1 getBottomRightCardData();

    /* synthetic */ com.bytedance.android.live.base.model.message.m0 getCommon();

    @FieldName(name = "common_card_area")
    i3 getCommonCard();

    /* synthetic */ long getConsumeTime();

    /* synthetic */ long getDecodeEndTime();

    /* synthetic */ long getDecodeStartTime();

    /* synthetic */ long getDelayDispatchMs();

    /* synthetic */ long getEnqueueDispatchTime();

    /* synthetic */ int getGeneralMessageType();

    /* synthetic */ long getHttpSendTime();

    /* synthetic */ int getIntType();

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

    @FieldName(name = "message_type#setter")
    void setAction(int r100);

    @FieldName(name = "biz_pin_area#setter")
    void setBizPinArea(k1 r100);

    @FieldName(name = "bottom_right_card_data#setter")
    void setBottomRightCardData(m1 r100);

    /* synthetic */ void setCommon(com.bytedance.android.live.base.model.message.m0 r100);

    @FieldName(name = "common_card_area#setter")
    void setCommonCard(i3 r100);

    /* synthetic */ void setCommonMessageData(com.bytedance.android.live.base.model.message.m0 r100);

    /* synthetic */ void setConsumeTime(long r100);

    /* synthetic */ void setDecodeEndTime(long r100);

    /* synthetic */ void setDecodeStartTime(long r100);

    /* synthetic */ void setEnqueueDispatchTime(long r100);

    /* synthetic */ void setGeneralMessageType(int r100);

    /* synthetic */ void setHttpSendTime(long r100);

    /* synthetic */ void setIsFromFirstRequest(boolean r100);

    /* synthetic */ void setIsInsert(boolean r100);

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
