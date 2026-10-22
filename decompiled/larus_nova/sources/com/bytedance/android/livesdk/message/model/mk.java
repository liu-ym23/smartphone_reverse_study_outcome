package com.bytedance.android.livesdk.message.model;

import com.bytedance.tools.kcp.modelx.runtime.FieldName;
import com.bytedance.tools.kcp.modelx.runtime.internal.decode.FlexModelJsonAdapter;
import com.google.gson.annotations.JsonAdapter;
import java.util.Map;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes11.dex */
@JsonAdapter(FlexModelJsonAdapter.class)
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u000f\n\u0002\u0010\t\n\u0002\b\n\n\u0002\u0010\u000b\n\u0002\b\u0012\bg\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u00012\u00020\u0002R$\u0010\n\u001a\u0004\u0018\u00010\u00038&@&X§\u000e¢\u0006\u0012\u0012\u0004\b\b\u0010\t\u001a\u0004\b\u0004\u0010\u0005\"\u0004\b\u0006\u0010\u0007R$\u0010\u000e\u001a\u0004\u0018\u00010\u00038&@&X§\u000e¢\u0006\u0012\u0012\u0004\b\r\u0010\t\u001a\u0004\b\u000b\u0010\u0005\"\u0004\b\f\u0010\u0007R$\u0010\u0012\u001a\u0004\u0018\u00010\u00038&@&X§\u000e¢\u0006\u0012\u0012\u0004\b\u0011\u0010\t\u001a\u0004\b\u000f\u0010\u0005\"\u0004\b\u0010\u0010\u0007R\"\u0010\u0019\u001a\u00020\u00138&@&X§\u000e¢\u0006\u0012\u0012\u0004\b\u0018\u0010\t\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017R\"\u0010\u001d\u001a\u00020\u00138&@&X§\u000e¢\u0006\u0012\u0012\u0004\b\u001c\u0010\t\u001a\u0004\b\u001a\u0010\u0015\"\u0004\b\u001b\u0010\u0017R\"\u0010$\u001a\u00020\u001e8&@&X§\u000e¢\u0006\u0012\u0012\u0004\b#\u0010\t\u001a\u0004\b\u001f\u0010 \"\u0004\b!\u0010\"R\"\u0010%\u001a\u00020\u001e8&@&X§\u000e¢\u0006\u0012\u0012\u0004\b'\u0010\t\u001a\u0004\b%\u0010 \"\u0004\b&\u0010\"R\"\u0010+\u001a\u00020\u00138&@&X§\u000e¢\u0006\u0012\u0012\u0004\b*\u0010\t\u001a\u0004\b(\u0010\u0015\"\u0004\b)\u0010\u0017R\"\u0010/\u001a\u00020\u00138&@&X§\u000e¢\u0006\u0012\u0012\u0004\b.\u0010\t\u001a\u0004\b,\u0010\u0015\"\u0004\b-\u0010\u0017¨\u00060"}, d2 = {"Lcom/bytedance/android/livesdk/message/model/mk;", "Lvh7/c;", "Lcom/bytedance/android/live/base/model/message/c3;", "", "getDisplayShort", "()Ljava/lang/String;", "setDisplayShort", "(Ljava/lang/String;)V", "getDisplayShort$annotations", "()V", "displayShort", "getDisplayMiddle", "setDisplayMiddle", "getDisplayMiddle$annotations", "displayMiddle", "getDisplayLong", "setDisplayLong", "getDisplayLong$annotations", "displayLong", "", "getDisplayValue", "()J", "setDisplayValue", "(J)V", "getDisplayValue$annotations", "displayValue", "getDisplayVersion", "setDisplayVersion", "getDisplayVersion$annotations", "displayVersion", "", "getIncremental", "()Z", "setIncremental", "(Z)V", "getIncremental$annotations", "incremental", "is_hidden", "set_hidden", "is_hidden$annotations", "getDisplayType", "setDisplayType", "getDisplayType$annotations", "displayType", "getTotal", "setTotal", "getTotal$annotations", "total", "live-business-message-api_saasRelease"}, k = 1, mv = {1, 5, 1})
public interface mk extends vh7.c<mk>, com.bytedance.android.live.base.model.message.c3 {

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

    @FieldName(name = "display_long")
    String getDisplayLong();

    @FieldName(name = "display_middle")
    String getDisplayMiddle();

    @FieldName(name = "display_short")
    String getDisplayShort();

    @FieldName(name = "display_type")
    long getDisplayType();

    @FieldName(name = "display_value")
    long getDisplayValue();

    @FieldName(name = "display_version")
    long getDisplayVersion();

    /* synthetic */ long getEnqueueDispatchTime();

    /* synthetic */ int getGeneralMessageType();

    /* synthetic */ long getHttpSendTime();

    @FieldName(name = "incremental")
    boolean getIncremental();

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

    @FieldName(name = "total")
    long getTotal();

    /* synthetic */ String getWRDSKey();

    /* synthetic */ String getWRDSSubKey();

    /* synthetic */ long getWRDSVersion();

    /* synthetic */ boolean isFromFirstRequest();

    /* synthetic */ boolean isGlobalMessage();

    /* synthetic */ boolean isTimeCostCanUse();

    /* synthetic */ boolean isWRDSMessage();

    @FieldName(name = "is_hidden")
    boolean is_hidden();

    /* synthetic */ boolean needMonitor();

    /* synthetic */ void setCommon(com.bytedance.android.live.base.model.message.m0 r100);

    /* synthetic */ void setCommonMessageData(com.bytedance.android.live.base.model.message.m0 r100);

    /* synthetic */ void setConsumeTime(long r100);

    /* synthetic */ void setDecodeEndTime(long r100);

    /* synthetic */ void setDecodeStartTime(long r100);

    @FieldName(name = "display_long#setter")
    void setDisplayLong(String r100);

    @FieldName(name = "display_middle#setter")
    void setDisplayMiddle(String r100);

    @FieldName(name = "display_short#setter")
    void setDisplayShort(String r100);

    @FieldName(name = "display_type#setter")
    void setDisplayType(long r100);

    @FieldName(name = "display_value#setter")
    void setDisplayValue(long r100);

    @FieldName(name = "display_version#setter")
    void setDisplayVersion(long r100);

    /* synthetic */ void setEnqueueDispatchTime(long r100);

    /* synthetic */ void setGeneralMessageType(int r100);

    /* synthetic */ void setHttpSendTime(long r100);

    @FieldName(name = "incremental#setter")
    void setIncremental(boolean r100);

    /* synthetic */ void setIsFromFirstRequest(boolean r100);

    /* synthetic */ void setIsInsert(boolean r100);

    /* synthetic */ void setMessageExtra(Map<String, String> r100);

    /* synthetic */ void setMessageFrom(int r100);

    /* synthetic */ void setMessageMethod(String r100);

    /* synthetic */ void setRawPayload(byte[] r100);

    /* synthetic */ void setReceiveTime(long r100);

    /* synthetic */ void setTimestamp(long r100);

    @FieldName(name = "total#setter")
    void setTotal(long r100);

    /* synthetic */ void setWRDSMessage(boolean r100);

    /* synthetic */ void setWRDSSubKey(String r100);

    /* synthetic */ void setWRDSVersion(long r100);

    @FieldName(name = "is_hidden#setter")
    void set_hidden(boolean r100);
}
