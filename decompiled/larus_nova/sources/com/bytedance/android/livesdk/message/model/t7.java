package com.bytedance.android.livesdk.message.model;

import com.bytedance.android.live.base.annotation.ForMain;
import com.bytedance.tools.kcp.modelx.runtime.FieldName;
import com.bytedance.tools.kcp.modelx.runtime.internal.decode.FlexModelJsonAdapter;
import com.google.gson.annotations.JsonAdapter;
import com.ss.android.ugc.route_monitor.impl.route_out.control.bean.ControlRule;
import com.ss.ugc.live.sdk.message.stream.IStreamMessage;
import java.util.List;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes11.dex */
@JsonAdapter(FlexModelJsonAdapter.class)
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0007\bg\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u00012\u00060\u0002j\u0002`\u00032\u00020\u0004R \u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00060\u00058&X§\u0004¢\u0006\f\u0012\u0004\b\t\u0010\n\u001a\u0004\b\u0007\u0010\bR$\u0010\u0012\u001a\u0004\u0018\u00010\f8&@&X§\u000e¢\u0006\u0012\u0012\u0004\b\u0011\u0010\n\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010¨\u0006\u0013"}, d2 = {"Lcom/bytedance/android/livesdk/message/model/t7;", "Lvh7/c;", "Lyh6/c;", "Lcom/bytedance/android/livesdk/message/model/RevenueImMessage;", "Lcom/ss/ugc/live/sdk/message/stream/IStreamMessage;", "", "Lcom/bytedance/android/livesdk/gift/model/v0;", "getGroupContainerList", "()Ljava/util/List;", "getGroupContainerList$annotations", "()V", "groupContainerList", "", "getExtraData", "()Ljava/lang/String;", "setExtraData", "(Ljava/lang/String;)V", "getExtraData$annotations", ControlRule.KEY_EXTRA_DATA, "revenue-base_saasRelease"}, k = 1, mv = {1, 5, 1})
@ForMain
public interface t7 extends vh7.c<t7>, yh6.c, IStreamMessage {

    @JsonAdapter(FlexModelJsonAdapter.class)
    @Metadata(k = 3, mv = {1, 5, 1})
    public static final class a {
    }

    @Override // vh7.c
    /* synthetic */ vh7.e castTo(Class r100);

    @Override // vh7.c
    /* synthetic */ vh7.e castToOrNull(Class r100);

    @Override // yh6.c
    /* synthetic */ com.bytedance.android.live.base.model.message.m0 getCommonData();

    @Override // tlc.d
    /* synthetic */ long getDelayDispatchMs();

    /* synthetic */ IStreamMessage.DelayMode getDelayMode();

    @FieldName(name = "extra")
    String getExtraData();

    @Override // tlc.d
    /* synthetic */ int getGeneralMessageType();

    @FieldName(name = "data")
    List<com.bytedance.android.livesdk.gift.model.v0> getGroupContainerList();

    @Override // tlc.d, com.bytedance.android.livesdkapi.message.IExternalLiveMessage
    /* synthetic */ int getIntType();

    @Override // tlc.d
    /* synthetic */ int getMessageFrom();

    @Override // tlc.d
    /* synthetic */ long getMessageId();

    @Override // tlc.d
    /* synthetic */ String getMessageMethod();

    /* synthetic */ int getPriority();

    /* synthetic */ long getProcessAtSeiTs();

    @Override // tlc.d
    /* synthetic */ long getRoomId();

    /* synthetic */ long getServerDelay();

    /* synthetic */ long getTargetSei();

    /* synthetic */ boolean ignoreCondition();

    @Override // tlc.d
    /* synthetic */ boolean isFromFirstRequest();

    @Override // tlc.d
    /* synthetic */ boolean isGlobalMessage();

    /* synthetic */ boolean isStreamMessage();

    @Override // tlc.d
    /* synthetic */ boolean needMonitor();

    /* synthetic */ void setCommonData(com.bytedance.android.live.base.model.message.m0 r100);

    @Override // tlc.d
    /* synthetic */ void setConsumeTime(long r100);

    @Override // tlc.d
    /* synthetic */ void setDecodeEndTime(long r100);

    @Override // tlc.d
    /* synthetic */ void setDecodeStartTime(long r100);

    @Override // tlc.d
    /* synthetic */ void setEnqueueDispatchTime(long r100);

    @FieldName(name = "extra#setter")
    void setExtraData(String r100);

    @Override // tlc.d
    /* synthetic */ void setHttpSendTime(long r100);

    @Override // tlc.d
    /* synthetic */ void setIsFromFirstRequest(boolean r100);

    @Override // tlc.d
    /* synthetic */ void setIsInsert(boolean r100);

    @Override // tlc.d
    /* synthetic */ void setMessageMethod(String r100);

    @Override // tlc.d
    /* synthetic */ void setReceiveTime(long r100);
}
