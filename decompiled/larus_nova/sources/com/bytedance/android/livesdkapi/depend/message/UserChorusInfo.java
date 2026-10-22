package com.bytedance.android.livesdkapi.depend.message;

import com.bytedance.android.live.base.annotation.ForMain;
import com.bytedance.tools.kcp.modelx.runtime.FieldName;
import com.bytedance.tools.kcp.modelx.runtime.internal.decode.FlexModelJsonAdapter;
import com.google.gson.annotations.JsonAdapter;
import kotlin.Metadata;
import vh7.c;
import vh7.e;

/* JADX INFO: loaded from: classes12.dex */
@JsonAdapter(FlexModelJsonAdapter.class)
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\b\u000b\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0010\u0006\n\u0002\b\u0010\bg\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001R\"\u0010\t\u001a\u00020\u00028&@&X§\u000e¢\u0006\u0012\u0012\u0004\b\u0007\u0010\b\u001a\u0004\b\u0003\u0010\u0004\"\u0004\b\u0005\u0010\u0006R\"\u0010\r\u001a\u00020\u00028&@&X§\u000e¢\u0006\u0012\u0012\u0004\b\f\u0010\b\u001a\u0004\b\n\u0010\u0004\"\u0004\b\u000b\u0010\u0006R$\u0010\u000f\u001a\u0004\u0018\u00010\u000e8&@&X§\u000e¢\u0006\u0012\u0012\u0004\b\u0013\u0010\b\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R$\u0010\u0014\u001a\u0004\u0018\u00010\u000e8&@&X§\u000e¢\u0006\u0012\u0012\u0004\b\u0016\u0010\b\u001a\u0004\b\u0014\u0010\u0010\"\u0004\b\u0015\u0010\u0012R\"\u0010\u001d\u001a\u00020\u00178&@&X§\u000e¢\u0006\u0012\u0012\u0004\b\u001c\u0010\b\u001a\u0004\b\u0018\u0010\u0019\"\u0004\b\u001a\u0010\u001bR\"\u0010\u001e\u001a\u00020\u000e8&@&X§\u000e¢\u0006\u0012\u0012\u0004\b\"\u0010\b\u001a\u0004\b\u001e\u0010\u001f\"\u0004\b \u0010!R\"\u0010&\u001a\u00020\u00178&@&X§\u000e¢\u0006\u0012\u0012\u0004\b%\u0010\b\u001a\u0004\b#\u0010\u0019\"\u0004\b$\u0010\u001b¨\u0006'"}, d2 = {"Lcom/bytedance/android/livesdkapi/depend/message/UserChorusInfo;", "Lvh7/c;", "", "getUserId", "()J", "setUserId", "(J)V", "getUserId$annotations", "()V", "userId", "getOrder", "setOrder", "getOrder$annotations", "order", "", "isNeedPushRtc", "()Ljava/lang/Boolean;", "setNeedPushRtc", "(Ljava/lang/Boolean;)V", "isNeedPushRtc$annotations", "isNeedApproach", "setNeedApproach", "isNeedApproach$annotations", "", "getMidiScore", "()D", "setMidiScore", "(D)V", "getMidiScore$annotations", "midiScore", "isLead", "()Z", "setLead", "(Z)V", "isLead$annotations", "getAverageScore", "setAverageScore", "getAverageScore$annotations", "averageScore", "live-model-api_saasRelease"}, k = 1, mv = {1, 5, 1})
@ForMain
public interface UserChorusInfo extends c<UserChorusInfo> {

    @JsonAdapter(FlexModelJsonAdapter.class)
    @Metadata(k = 3, mv = {1, 5, 1})
    public static final class DefaultImpls {
        @FieldName(name = "average_midi_score")
        public static /* synthetic */ void getAverageScore$annotations() {
        }

        @FieldName(name = "single_segment_midi_score")
        public static /* synthetic */ void getMidiScore$annotations() {
        }

        @FieldName(name = "order")
        public static /* synthetic */ void getOrder$annotations() {
        }

        @FieldName(name = "user_id")
        public static /* synthetic */ void getUserId$annotations() {
        }

        @FieldName(name = "is_lead")
        public static /* synthetic */ void isLead$annotations() {
        }

        @FieldName(name = "need_approach")
        public static /* synthetic */ void isNeedApproach$annotations() {
        }

        @FieldName(name = "need_push_rtc")
        public static /* synthetic */ void isNeedPushRtc$annotations() {
        }
    }

    @Override // vh7.c
    /* synthetic */ e castTo(Class r100);

    @Override // vh7.c
    /* synthetic */ e castToOrNull(Class r100);

    @FieldName(name = "average_midi_score")
    double getAverageScore();

    @FieldName(name = "single_segment_midi_score")
    double getMidiScore();

    @FieldName(name = "order")
    long getOrder();

    @FieldName(name = "user_id")
    long getUserId();

    @FieldName(name = "is_lead")
    boolean isLead();

    @FieldName(name = "need_approach")
    Boolean isNeedApproach();

    @FieldName(name = "need_push_rtc")
    Boolean isNeedPushRtc();

    @FieldName(name = "average_midi_score#setter")
    void setAverageScore(double r100);

    @FieldName(name = "is_lead#setter")
    void setLead(boolean r100);

    @FieldName(name = "single_segment_midi_score#setter")
    void setMidiScore(double r100);

    @FieldName(name = "need_approach#setter")
    void setNeedApproach(Boolean r100);

    @FieldName(name = "need_push_rtc#setter")
    void setNeedPushRtc(Boolean r100);

    @FieldName(name = "order#setter")
    void setOrder(long r100);

    @FieldName(name = "user_id#setter")
    void setUserId(long r100);
}
