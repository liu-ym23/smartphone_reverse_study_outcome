package com.bytedance.android.livesdkapi.message;

import com.bytedance.security.android.aopcheck.reporter.ReportConstant;
import com.bytedance.tools.kcp.modelx.runtime.internal.decode.FlexModelJsonAdapter;
import com.google.gson.annotations.JsonAdapter;
import java.util.Map;
import kotlin.Metadata;
import py.k;
import vh7.c;
import vh7.e;

/* JADX INFO: loaded from: classes12.dex */
@JsonAdapter(FlexModelJsonAdapter.class)
@Metadata(d1 = {"\u0000`\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0014\n\u0002\u0018\u0002\n\u0002\b\b\bg\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u00012\u00020\u0002R\u0016\u0010\u0006\u001a\u0004\u0018\u00010\u00038&X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0004\u0010\u0005R\u0016\u0010\n\u001a\u0004\u0018\u00010\u00078&X¦\u0004¢\u0006\u0006\u001a\u0004\b\b\u0010\tR\u001c\u0010\u0010\u001a\u00020\u000b8&@&X¦\u000e¢\u0006\f\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\u001c\u0010\u0013\u001a\u00020\u000b8&@&X¦\u000e¢\u0006\f\u001a\u0004\b\u0011\u0010\r\"\u0004\b\u0012\u0010\u000fR\u001c\u0010\u0019\u001a\u00020\u00148&@&X¦\u000e¢\u0006\f\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018R\"\u0010\u001e\u001a\u0010\u0012\u0004\u0012\u00020\u001b\u0012\u0004\u0012\u00020\u001b\u0018\u00010\u001a8&X¦\u0004¢\u0006\u0006\u001a\u0004\b\u001c\u0010\u001dR\u0016\u0010\"\u001a\u0004\u0018\u00010\u001f8&X¦\u0004¢\u0006\u0006\u001a\u0004\b \u0010!R\u0016\u0010&\u001a\u0004\u0018\u00010#8&X¦\u0004¢\u0006\u0006\u001a\u0004\b$\u0010%R\"\u0010(\u001a\u0010\u0012\u0004\u0012\u00020\u001b\u0012\u0004\u0012\u00020\u001b\u0018\u00010\u001a8&X¦\u0004¢\u0006\u0006\u001a\u0004\b'\u0010\u001dR\u0014\u0010+\u001a\u00020#8&X¦\u0004¢\u0006\u0006\u001a\u0004\b)\u0010*R\u0014\u0010,\u001a\u00020#8&X¦\u0004¢\u0006\u0006\u001a\u0004\b,\u0010*R\u0016\u00100\u001a\u0004\u0018\u00010-8&X¦\u0004¢\u0006\u0006\u001a\u0004\b.\u0010/R\u0016\u00104\u001a\u0004\u0018\u0001018&X¦\u0004¢\u0006\u0006\u001a\u0004\b2\u00103R\u0014\u00105\u001a\u00020\u00148&X¦\u0004¢\u0006\u0006\u001a\u0004\b5\u0010\u0016R\u0014\u00107\u001a\u00020\u00148&X¦\u0004¢\u0006\u0006\u001a\u0004\b6\u0010\u0016R\u001c\u00108\u001a\u00020\u00148&@&X¦\u000e¢\u0006\f\u001a\u0004\b8\u0010\u0016\"\u0004\b9\u0010\u0018R\u001c\u0010:\u001a\u00020\u00148&@&X¦\u000e¢\u0006\f\u001a\u0004\b:\u0010\u0016\"\u0004\b;\u0010\u0018R\u0014\u0010<\u001a\u00020\u00148&X¦\u0004¢\u0006\u0006\u001a\u0004\b<\u0010\u0016R\u0014\u0010>\u001a\u00020\u00148&X¦\u0004¢\u0006\u0006\u001a\u0004\b=\u0010\u0016R\"\u0010@\u001a\u0010\u0012\u0004\u0012\u00020\u001b\u0012\u0004\u0012\u00020\u001b\u0018\u00010\u001a8&X¦\u0004¢\u0006\u0006\u001a\u0004\b?\u0010\u001dR\u0014\u0010B\u001a\u00020\u00148&X¦\u0004¢\u0006\u0006\u001a\u0004\bA\u0010\u0016R\u0016\u0010E\u001a\u0004\u0018\u00010\u001b8&X¦\u0004¢\u0006\u0006\u001a\u0004\bC\u0010DR\u0016\u0010I\u001a\u0004\u0018\u00010F8&X¦\u0004¢\u0006\u0006\u001a\u0004\bG\u0010HR\u0014\u0010K\u001a\u00020\u00148&X¦\u0004¢\u0006\u0006\u001a\u0004\bJ\u0010\u0016R\u0014\u0010M\u001a\u00020\u00148&X¦\u0004¢\u0006\u0006\u001a\u0004\bL\u0010\u0016¨\u0006N"}, d2 = {"Lcom/bytedance/android/livesdkapi/message/IPublicAreaCommon;", "Lvh7/c;", "Lcom/bytedance/android/livesdkapi/message/IRtcRoomMessage;", "Lpy/k;", "getUserLabel", "()Lpy/k;", "userLabel", "Lcom/bytedance/android/livesdkapi/message/SuffixText;", "getSuffixText", "()Lcom/bytedance/android/livesdkapi/message/SuffixText;", "suffixText", "", "getActionType", "()I", "setActionType", "(I)V", ReportConstant.COMMON_ACTION_TYPE, "getIndividualPriority", "setIndividualPriority", "individualPriority", "", "getForbidProfile", "()Z", "setForbidProfile", "(Z)V", "forbidProfile", "", "", "getIndividualStrategyResult", "()Ljava/util/Map;", "individualStrategyResult", "Lcom/bytedance/android/livesdkapi/message/PersonalizedDisplayInfo;", "getPersonalizedInfo", "()Lcom/bytedance/android/livesdkapi/message/PersonalizedDisplayInfo;", "personalizedInfo", "", "getForceInsertionPriority", "()Ljava/lang/Long;", "forceInsertionPriority", "getTrackingParams", "trackingParams", "getSupportPin", "()J", "supportPin", "isSelected", "Lcom/bytedance/android/livesdkapi/message/HoverInfo;", "getHoverInfo", "()Lcom/bytedance/android/livesdkapi/message/HoverInfo;", "hoverInfo", "Lcom/bytedance/android/livesdkapi/message/ChatMentionInfo;", "getChatMentionInfo", "()Lcom/bytedance/android/livesdkapi/message/ChatMentionInfo;", "chatMentionInfo", "isLikeComment", "getBatchRefresh", "batchRefresh", "isFirstAggregateHistoryMessage", "setFirstAggregateHistoryMessage", "isFirstFetchBatchMsg", "setFirstFetchBatchMsg", "isAiMsg", "getShouldLogLightInteractMob", "shouldLogLightInteractMob", "getLightInteractMobParams", "lightInteractMobParams", "getHasTailButton", "hasTailButton", "getDefaultClickSchemaUrl", "()Ljava/lang/String;", "defaultClickSchemaUrl", "Lcom/bytedance/android/livesdkapi/message/BottomPinInfo;", "getBottomPinInfo", "()Lcom/bytedance/android/livesdkapi/message/BottomPinInfo;", "bottomPinInfo", "getForceInsert", "forceInsert", "getWithUserFeatureLabel", "withUserFeatureLabel", "live-model-api_saasRelease"}, k = 1, mv = {1, 5, 1})
public interface IPublicAreaCommon extends c<IPublicAreaCommon>, IRtcRoomMessage {
    @Override // vh7.c
    /* synthetic */ e castTo(Class r100);

    @Override // vh7.c
    /* synthetic */ e castToOrNull(Class r100);

    int getActionType();

    boolean getBatchRefresh();

    BottomPinInfo getBottomPinInfo();

    ChatMentionInfo getChatMentionInfo();

    String getDefaultClickSchemaUrl();

    boolean getForbidProfile();

    boolean getForceInsert();

    Long getForceInsertionPriority();

    boolean getHasTailButton();

    HoverInfo getHoverInfo();

    int getIndividualPriority();

    Map<String, String> getIndividualStrategyResult();

    Map<String, String> getLightInteractMobParams();

    PersonalizedDisplayInfo getPersonalizedInfo();

    boolean getShouldLogLightInteractMob();

    SuffixText getSuffixText();

    long getSupportPin();

    Map<String, String> getTrackingParams();

    k getUserLabel();

    boolean getWithUserFeatureLabel();

    boolean isAiMsg();

    boolean isFirstAggregateHistoryMessage();

    boolean isFirstFetchBatchMsg();

    boolean isLikeComment();

    long isSelected();

    void setActionType(int r100);

    void setFirstAggregateHistoryMessage(boolean r100);

    void setFirstFetchBatchMsg(boolean r100);

    void setForbidProfile(boolean r100);

    void setIndividualPriority(int r100);
}
