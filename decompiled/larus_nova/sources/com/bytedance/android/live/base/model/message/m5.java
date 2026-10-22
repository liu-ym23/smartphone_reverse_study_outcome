package com.bytedance.android.live.base.model.message;

import com.bytedance.tools.kcp.modelx.runtime.FieldName;
import com.bytedance.tools.kcp.modelx.runtime.internal.decode.FlexModelJsonAdapter;
import com.google.gson.annotations.JsonAdapter;
import java.util.Map;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes45.dex */
@JsonAdapter(FlexModelJsonAdapter.class)
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\b\u000b\n\u0002\u0010\u000e\n\u0002\b\n\n\u0002\u0010\u000b\n\u0002\b\u0006\bg\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u00012\u00020\u0002R$\u0010\n\u001a\u0004\u0018\u00010\u00038&@&X§\u000e¢\u0006\u0012\u0012\u0004\b\b\u0010\t\u001a\u0004\b\u0004\u0010\u0005\"\u0004\b\u0006\u0010\u0007R$\u0010\u000e\u001a\u0004\u0018\u00010\u00038&@&X§\u000e¢\u0006\u0012\u0012\u0004\b\r\u0010\t\u001a\u0004\b\u000b\u0010\u0005\"\u0004\b\f\u0010\u0007R$\u0010\u0015\u001a\u0004\u0018\u00010\u000f8&@&X§\u000e¢\u0006\u0012\u0012\u0004\b\u0014\u0010\t\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013R$\u0010\u0019\u001a\u0004\u0018\u00010\u00038&@&X§\u000e¢\u0006\u0012\u0012\u0004\b\u0018\u0010\t\u001a\u0004\b\u0016\u0010\u0005\"\u0004\b\u0017\u0010\u0007R$\u0010\u001b\u001a\u0004\u0018\u00010\u001a8&@&X§\u000e¢\u0006\u0012\u0012\u0004\b\u001f\u0010\t\u001a\u0004\b\u001b\u0010\u001c\"\u0004\b\u001d\u0010\u001e¨\u0006 "}, d2 = {"Lcom/bytedance/android/live/base/model/message/m5;", "Lvh7/c;", "Lcom/bytedance/android/live/base/model/message/c3;", "", "getNumber", "()Ljava/lang/Long;", "setNumber", "(Ljava/lang/Long;)V", "getNumber$annotations", "()V", "number", "getStatus", "setStatus", "getStatus$annotations", "status", "", "getIcon", "()Ljava/lang/String;", "setIcon", "(Ljava/lang/String;)V", "getIcon$annotations", "icon", "getMType", "setMType", "getMType$annotations", "mType", "", "isKeep", "()Ljava/lang/Boolean;", "setKeep", "(Ljava/lang/Boolean;)V", "isKeep$annotations", "live-business-message-api_saasRelease"}, k = 1, mv = {1, 5, 1})
public interface m5 extends vh7.c<m5>, c3 {

    @JsonAdapter(FlexModelJsonAdapter.class)
    @Metadata(k = 3, mv = {1, 5, 1})
    public static final class a {
    }

    @Override // vh7.c
    /* synthetic */ vh7.e castTo(Class r100);

    @Override // vh7.c
    /* synthetic */ vh7.e castToOrNull(Class r100);

    /* synthetic */ m0 getCommon();

    /* synthetic */ long getConsumeTime();

    /* synthetic */ long getDecodeEndTime();

    /* synthetic */ long getDecodeStartTime();

    /* synthetic */ long getDelayDispatchMs();

    /* synthetic */ long getEnqueueDispatchTime();

    /* synthetic */ int getGeneralMessageType();

    /* synthetic */ long getHttpSendTime();

    @FieldName(name = "icon")
    String getIcon();

    /* synthetic */ int getIntType();

    @FieldName(name = "type")
    Long getMType();

    /* synthetic */ Map<String, String> getMessageExtra();

    /* synthetic */ int getMessageFrom();

    /* synthetic */ long getMessageId();

    /* synthetic */ String getMessageMethod();

    @FieldName(name = "number")
    Long getNumber();

    /* synthetic */ int getPriority();

    /* synthetic */ byte[] getRawPayload();

    /* synthetic */ long getReceiveTime();

    /* synthetic */ long getRoomId();

    @FieldName(name = "status")
    Long getStatus();

    /* synthetic */ long getTimestamp();

    /* synthetic */ String getWRDSKey();

    /* synthetic */ String getWRDSSubKey();

    /* synthetic */ long getWRDSVersion();

    /* synthetic */ boolean isFromFirstRequest();

    /* synthetic */ boolean isGlobalMessage();

    @FieldName(name = "is_keep")
    Boolean isKeep();

    /* synthetic */ boolean isTimeCostCanUse();

    /* synthetic */ boolean isWRDSMessage();

    /* synthetic */ boolean needMonitor();

    /* synthetic */ void setCommon(m0 r100);

    /* synthetic */ void setCommonMessageData(m0 r100);

    /* synthetic */ void setConsumeTime(long r100);

    /* synthetic */ void setDecodeEndTime(long r100);

    /* synthetic */ void setDecodeStartTime(long r100);

    /* synthetic */ void setEnqueueDispatchTime(long r100);

    /* synthetic */ void setGeneralMessageType(int r100);

    /* synthetic */ void setHttpSendTime(long r100);

    @FieldName(name = "icon#setter")
    void setIcon(String r100);

    /* synthetic */ void setIsFromFirstRequest(boolean r100);

    /* synthetic */ void setIsInsert(boolean r100);

    @FieldName(name = "is_keep#setter")
    void setKeep(Boolean r100);

    @FieldName(name = "type#setter")
    void setMType(Long r100);

    /* synthetic */ void setMessageExtra(Map<String, String> r100);

    /* synthetic */ void setMessageFrom(int r100);

    /* synthetic */ void setMessageMethod(String r100);

    @FieldName(name = "number#setter")
    void setNumber(Long r100);

    /* synthetic */ void setRawPayload(byte[] r100);

    /* synthetic */ void setReceiveTime(long r100);

    @FieldName(name = "status#setter")
    void setStatus(Long r100);

    /* synthetic */ void setTimestamp(long r100);

    /* synthetic */ void setWRDSMessage(boolean r100);

    /* synthetic */ void setWRDSSubKey(String r100);

    /* synthetic */ void setWRDSVersion(long r100);
}
