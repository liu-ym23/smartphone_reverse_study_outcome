package com.bytedance.android.livesdk.message.model;

import com.bytedance.tools.kcp.modelx.runtime.FieldName;
import com.bytedance.tools.kcp.modelx.runtime.internal.decode.FlexModelJsonAdapter;
import com.google.gson.annotations.JsonAdapter;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes11.dex */
@JsonAdapter(FlexModelJsonAdapter.class)
@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\t\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010 \n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u000e\n\u0002\u0010$\n\u0002\b\n\bg\u0018\u0000 82\b\u0012\u0004\u0012\u00020\u00000\u00012\u00060\u0002j\u0002`\u00032\u00020\u0004:\u00019R\u0014\u0010\b\u001a\u00020\u00058&X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0006\u0010\u0007R\u0014\u0010\f\u001a\u00020\t8&X¦\u0004¢\u0006\u0006\u001a\u0004\b\n\u0010\u000bR\u0014\u0010\u000e\u001a\u00020\u00058&X¦\u0004¢\u0006\u0006\u001a\u0004\b\r\u0010\u0007R\u0014\u0010\u0010\u001a\u00020\u00058&X¦\u0004¢\u0006\u0006\u001a\u0004\b\u000f\u0010\u0007R\u0014\u0010\u0012\u001a\u00020\u00058&X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0011\u0010\u0007R\u0016\u0010\u0016\u001a\u0004\u0018\u00010\u00138&X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0014\u0010\u0015R\u0014\u0010\u0018\u001a\u00020\t8&X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0017\u0010\u000bR\u0016\u0010\u001a\u001a\u0004\u0018\u00010\u00138&X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0019\u0010\u0015R\u001a\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020\t0\u001b8&X¦\u0004¢\u0006\u0006\u001a\u0004\b\u001c\u0010\u001dR\u0016\u0010 \u001a\u0004\u0018\u00010\u00138&X¦\u0004¢\u0006\u0006\u001a\u0004\b\u001f\u0010\u0015R\u001a\u0010&\u001a\u00020!8&X§\u0004¢\u0006\f\u0012\u0004\b$\u0010%\u001a\u0004\b\"\u0010#R\u001a\u0010)\u001a\u00020\u00058&X§\u0004¢\u0006\f\u0012\u0004\b(\u0010%\u001a\u0004\b'\u0010\u0007R\u001a\u0010,\u001a\u00020\u00058&X§\u0004¢\u0006\f\u0012\u0004\b+\u0010%\u001a\u0004\b*\u0010\u0007R\u001c\u0010/\u001a\u0004\u0018\u00010\u00138&X§\u0004¢\u0006\f\u0012\u0004\b.\u0010%\u001a\u0004\b-\u0010\u0015R(\u00104\u001a\u0010\u0012\u0004\u0012\u00020\u0013\u0012\u0004\u0012\u00020\u0013\u0018\u0001008&X§\u0004¢\u0006\f\u0012\u0004\b3\u0010%\u001a\u0004\b1\u00102R\u001a\u00107\u001a\u00020\u00058&X§\u0004¢\u0006\f\u0012\u0004\b6\u0010%\u001a\u0004\b5\u0010\u0007¨\u0006:"}, d2 = {"Lcom/bytedance/android/livesdk/message/model/na;", "Lvh7/c;", "Lyh6/c;", "Lcom/bytedance/android/livesdk/message/model/RevenueImMessage;", "Lcom/bytedance/android/live/base/model/message/t;", "", "getLotteryId", "()J", "lotteryId", "", "getLotteryStatus", "()I", "lotteryStatus", "getLotteryStartTime", "lotteryStartTime", "getLotteryDrawTime", "lotteryDrawTime", "getLotteryCurrentTime", "lotteryCurrentTime", "", "getLotteryRulePageScheme", "()Ljava/lang/String;", "lotteryRulePageScheme", "getPrizeType", "prizeType", "getLotteryAuditFailureReason", "lotteryAuditFailureReason", "", "getConditionsType", "()Ljava/util/List;", "conditionsType", "getUiConfig", "uiConfig", "", "getUseNewDrawInteraction", "()Z", "getUseNewDrawInteraction$annotations", "()V", "useNewDrawInteraction", "getPrizeCount", "getPrizeCount$annotations", "prizeCount", "getLuckyCount", "getLuckyCount$annotations", "luckyCount", "getServerBizData", "getServerBizData$annotations", "serverBizData", "", "getExtra", "()Ljava/util/Map;", "getExtra$annotations", "extra", "getMaxRandomDelayDurationByMs", "getMaxRandomDelayDurationByMs$annotations", "maxRandomDelayDurationByMs", "Companion", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "revenue-base_saasRelease"}, k = 1, mv = {1, 5, 1})
public interface na extends vh7.c<na>, yh6.c, com.bytedance.android.live.base.model.message.t {
    public static final a Companion = null;
    public static final int STATUS_CANCELED = 3;
    public static final int STATUS_FINISHED = 2;
    public static final int STATUS_ONGOING = 1;
    public static final int STATUS_REJECTED = 5;
    public static final int STATUS_REVIEWING = 4;

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ a f153672a = null;

        public a() {
        }

        static {
            f153672a = new a();
        }
    }

    @JsonAdapter(FlexModelJsonAdapter.class)
    @Metadata(k = 3, mv = {1, 5, 1})
    public static final class b {
    }

    static {
        Companion = a.f153672a;
    }

    @Override // com.bytedance.android.live.base.model.message.t
    /* synthetic */ boolean canText();

    @Override // vh7.c
    /* synthetic */ vh7.e castTo(Class r100);

    @Override // vh7.c
    /* synthetic */ vh7.e castToOrNull(Class r100);

    @Override // com.bytedance.android.live.base.model.message.t
    /* synthetic */ boolean currUserIsAnchor();

    @Override // com.bytedance.android.live.base.model.message.t
    /* synthetic */ com.bytedance.android.live.base.model.message.m0 getBaseMessage();

    @Override // yh6.c
    /* synthetic */ com.bytedance.android.live.base.model.message.m0 getCommonData();

    List<Integer> getConditionsType();

    @Override // com.bytedance.android.live.base.model.message.t
    /* synthetic */ long getConsumeTime();

    @Override // tlc.d
    /* synthetic */ long getDelayDispatchMs();

    @FieldName(name = "extra")
    Map<String, String> getExtra();

    @Override // tlc.d
    /* synthetic */ int getGeneralMessageType();

    @Override // com.bytedance.android.live.base.model.message.t
    /* synthetic */ long getHttpSendTime();

    @Override // tlc.d, com.bytedance.android.livesdkapi.message.IExternalLiveMessage
    /* synthetic */ int getIntType();

    /* synthetic */ long getLocalTimestamp();

    String getLotteryAuditFailureReason();

    long getLotteryCurrentTime();

    long getLotteryDrawTime();

    long getLotteryId();

    String getLotteryRulePageScheme();

    long getLotteryStartTime();

    int getLotteryStatus();

    @FieldName(name = "lucky_count")
    long getLuckyCount();

    @FieldName(name = "max_random_delay_duration_by_ms")
    long getMaxRandomDelayDurationByMs();

    @Override // com.bytedance.android.live.base.model.message.t
    /* synthetic */ Map<String, String> getMessageExtra();

    @Override // tlc.d
    /* synthetic */ int getMessageFrom();

    @Override // tlc.d
    /* synthetic */ long getMessageId();

    @Override // tlc.d
    /* synthetic */ String getMessageMethod();

    /* synthetic */ int getPriority();

    @FieldName(name = "prize_count")
    long getPrizeCount();

    int getPrizeType();

    @Override // com.bytedance.android.live.base.model.message.t
    /* synthetic */ byte[] getRawPayload();

    @Override // com.bytedance.android.live.base.model.message.t
    /* synthetic */ long getReceiveTime();

    @Override // tlc.d
    /* synthetic */ long getRoomId();

    @FieldName(name = "server_biz_data")
    String getServerBizData();

    @Override // com.bytedance.android.live.base.model.message.t
    /* synthetic */ long getTimestamp();

    String getUiConfig();

    @FieldName(name = "use_new_draw_interaction")
    boolean getUseNewDrawInteraction();

    @Override // xlc.b
    /* synthetic */ String getWRDSKey();

    @Override // xlc.b
    /* synthetic */ String getWRDSSubKey();

    @Override // xlc.b
    /* synthetic */ long getWRDSVersion();

    @Override // com.bytedance.android.live.base.model.message.t
    /* synthetic */ boolean isCurrentRoom(long r100);

    @Override // com.bytedance.android.live.base.model.message.t
    /* synthetic */ boolean isFirstHistoryMessage();

    @Override // tlc.d
    /* synthetic */ boolean isFromFirstRequest();

    @Override // com.bytedance.android.live.base.model.message.t
    /* synthetic */ boolean isFromOtherIntercomRoom();

    @Override // tlc.d
    /* synthetic */ boolean isGlobalMessage();

    @Override // com.bytedance.android.live.base.model.message.t
    /* synthetic */ boolean isInsert();

    @Override // com.bytedance.android.live.base.model.message.t
    /* synthetic */ boolean isTooMuchMsg();

    @Override // xlc.b
    /* synthetic */ boolean isWRDSMessage();

    @Override // tlc.d
    /* synthetic */ boolean needMonitor();

    /* synthetic */ void setBaseMessage(com.bytedance.android.live.base.model.message.m0 r100);

    /* synthetic */ void setCommonData(com.bytedance.android.live.base.model.message.m0 r100);

    @Override // tlc.d
    /* synthetic */ void setConsumeTime(long r100);

    @Override // tlc.d
    /* synthetic */ void setDecodeEndTime(long r100);

    @Override // tlc.d
    /* synthetic */ void setDecodeStartTime(long r100);

    @Override // tlc.d
    /* synthetic */ void setEnqueueDispatchTime(long r100);

    @Override // tlc.d
    /* synthetic */ void setHttpSendTime(long r100);

    @Override // com.bytedance.android.live.base.model.message.t
    /* synthetic */ void setIsFirstHistoryMessage(boolean r100);

    @Override // tlc.d
    /* synthetic */ void setIsFromFirstRequest(boolean r100);

    @Override // tlc.d
    /* synthetic */ void setIsInsert(boolean r100);

    /* synthetic */ void setLocalInsertMsg(boolean r100);

    @Override // tlc.d
    /* synthetic */ void setMessageMethod(String r100);

    @Override // tlc.d
    /* synthetic */ void setReceiveTime(long r100);

    @Override // com.bytedance.android.live.base.model.message.t
    /* synthetic */ void setTooMuchMsg(boolean r100);

    @Override // xlc.b
    /* synthetic */ void setWRDSMessage(boolean r100);

    @Override // xlc.b
    /* synthetic */ void setWRDSSubKey(String r100);

    @Override // xlc.b
    /* synthetic */ void setWRDSVersion(long r100);

    @Override // com.bytedance.android.live.base.model.message.t
    /* synthetic */ boolean supportDisplayText();
}
