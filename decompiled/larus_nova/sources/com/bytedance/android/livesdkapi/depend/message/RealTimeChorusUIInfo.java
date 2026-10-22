package com.bytedance.android.livesdkapi.depend.message;

import com.bytedance.android.live.base.annotation.ForMain;
import com.bytedance.tools.kcp.modelx.runtime.FieldName;
import com.bytedance.tools.kcp.modelx.runtime.internal.decode.FlexModelJsonAdapter;
import com.google.gson.annotations.JsonAdapter;
import com.ss.android.socialbase.downloader.constants.MonitorConstants;
import java.util.List;
import java.util.Map;
import kotlin.Deprecated;
import kotlin.Metadata;
import vh7.c;
import vh7.e;

/* JADX INFO: loaded from: classes12.dex */
@JsonAdapter(FlexModelJsonAdapter.class)
@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\b\u000b\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0016\bg\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001R$\u0010\t\u001a\u0004\u0018\u00010\u00028&@&X§\u000e¢\u0006\u0012\u0012\u0004\b\u0007\u0010\b\u001a\u0004\b\u0003\u0010\u0004\"\u0004\b\u0005\u0010\u0006R$\u0010\r\u001a\u0004\u0018\u00010\u00028&@&X§\u000e¢\u0006\u0012\u0012\u0004\b\f\u0010\b\u001a\u0004\b\n\u0010\u0004\"\u0004\b\u000b\u0010\u0006RB\u0010\u0016\u001a\"\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u000f\u0018\u00010\u000ej\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u000f\u0018\u0001`\u00108&@&X§\u000e¢\u0006\u0012\u0012\u0004\b\u0015\u0010\b\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014RB\u0010\u001b\u001a\"\u0012\u0004\u0012\u00020\u0017\u0012\u0004\u0012\u00020\u000f\u0018\u00010\u000ej\u0010\u0012\u0004\u0012\u00020\u0017\u0012\u0004\u0012\u00020\u000f\u0018\u0001`\u00108&@&X§\u000e¢\u0006\u0012\u0012\u0004\b\u001a\u0010\b\u001a\u0004\b\u0018\u0010\u0012\"\u0004\b\u0019\u0010\u0014R$\u0010\u001d\u001a\u0004\u0018\u00010\u001c8&@&X§\u000e¢\u0006\u0012\u0012\u0004\b!\u0010\b\u001a\u0004\b\u001d\u0010\u001e\"\u0004\b\u001f\u0010 R&\u0010(\u001a\u00060\u0002j\u0002`\"8&@&X§\u000e¢\u0006\u0012\u0012\u0004\b'\u0010\b\u001a\u0004\b#\u0010$\"\u0004\b%\u0010&R2\u00100\u001a\u0012\u0012\u0004\u0012\u00020\u00020)j\b\u0012\u0004\u0012\u00020\u0002`*8&@&X§\u000e¢\u0006\u0012\u0012\u0004\b/\u0010\b\u001a\u0004\b+\u0010,\"\u0004\b-\u0010.R2\u00104\u001a\u0012\u0012\u0004\u0012\u00020\u00170)j\b\u0012\u0004\u0012\u00020\u0017`*8&@&X§\u000e¢\u0006\u0012\u0012\u0004\b3\u0010\b\u001a\u0004\b1\u0010,\"\u0004\b2\u0010.R$\u0010:\u001a\u0004\u0018\u00010\u00178&@&X§\u000e¢\u0006\u0012\u0012\u0004\b9\u0010\b\u001a\u0004\b5\u00106\"\u0004\b7\u00108R\"\u0010;\u001a\u00020\u001c8&@&X§\u000e¢\u0006\u0012\u0012\u0004\b?\u0010\b\u001a\u0004\b;\u0010<\"\u0004\b=\u0010>¨\u0006@"}, d2 = {"Lcom/bytedance/android/livesdkapi/depend/message/RealTimeChorusUIInfo;", "Lvh7/c;", "", "getChorusID", "()Ljava/lang/Long;", "setChorusID", "(Ljava/lang/Long;)V", "getChorusID$annotations", "()V", "chorusID", "getSegment", "setSegment", "getSegment$annotations", MonitorConstants.SEGMENT, "", "Lcom/bytedance/android/livesdkapi/depend/message/UserChorusInfo;", "Lcom/bytedance/revenue/platform/api/core/KmpMap;", "getUserInfo", "()Ljava/util/Map;", "setUserInfo", "(Ljava/util/Map;)V", "getUserInfo$annotations", "userInfo", "", "getOpenUserInfo", "setOpenUserInfo", "getOpenUserInfo$annotations", "openUserInfo", "", "isAnchorJoined", "()Ljava/lang/Boolean;", "setAnchorJoined", "(Ljava/lang/Boolean;)V", "isAnchorJoined$annotations", "Lcom/bytedance/revenue/platform/api/core/UnsafeLong;", "getChorusMode", "()J", "setChorusMode", "(J)V", "getChorusMode$annotations", "chorusMode", "", "Lcom/bytedance/revenue/platform/api/core/KmpList;", "getChorusLeader", "()Ljava/util/List;", "setChorusLeader", "(Ljava/util/List;)V", "getChorusLeader$annotations", "chorusLeader", "getChorusLeaderIdStr", "setChorusLeaderIdStr", "getChorusLeaderIdStr$annotations", "chorusLeaderIdStr", "getChorusIdStr", "()Ljava/lang/String;", "setChorusIdStr", "(Ljava/lang/String;)V", "getChorusIdStr$annotations", "chorusIdStr", "isChorusChatMode", "()Z", "setChorusChatMode", "(Z)V", "isChorusChatMode$annotations", "live-model-api_saasRelease"}, k = 1, mv = {1, 5, 1})
@ForMain
public interface RealTimeChorusUIInfo extends c<RealTimeChorusUIInfo> {

    @JsonAdapter(FlexModelJsonAdapter.class)
    @Metadata(k = 3, mv = {1, 5, 1})
    public static final class DefaultImpls {
        @FieldName(name = "chorus_id")
        public static /* synthetic */ void getChorusID$annotations() {
        }

        @FieldName(name = "chorus_id_str")
        public static /* synthetic */ void getChorusIdStr$annotations() {
        }

        @FieldName(name = "chorus_leader")
        public static /* synthetic */ void getChorusLeader$annotations() {
        }

        @FieldName(name = "chorus_leader_str")
        public static /* synthetic */ void getChorusLeaderIdStr$annotations() {
        }

        @FieldName(name = "chorus_mode")
        public static /* synthetic */ void getChorusMode$annotations() {
        }

        @FieldName(name = "open_user_infos")
        @Deprecated(message = "use userInfoString，同构保留字段")
        public static /* synthetic */ void getOpenUserInfo$annotations() {
        }

        @FieldName(name = MonitorConstants.SEGMENT)
        public static /* synthetic */ void getSegment$annotations() {
        }

        @FieldName(name = "user_infos")
        @Deprecated(message = "use userInfoString，同构保留字段")
        public static /* synthetic */ void getUserInfo$annotations() {
        }

        @FieldName(name = "is_anchor_joined_chorus")
        public static /* synthetic */ void isAnchorJoined$annotations() {
        }

        @FieldName(name = "is_chorus_chat_mode")
        public static /* synthetic */ void isChorusChatMode$annotations() {
        }
    }

    @Override // vh7.c
    /* synthetic */ e castTo(Class r100);

    @Override // vh7.c
    /* synthetic */ e castToOrNull(Class r100);

    @FieldName(name = "chorus_id")
    Long getChorusID();

    @FieldName(name = "chorus_id_str")
    String getChorusIdStr();

    @FieldName(name = "chorus_leader")
    List<Long> getChorusLeader();

    @FieldName(name = "chorus_leader_str")
    List<String> getChorusLeaderIdStr();

    @FieldName(name = "chorus_mode")
    long getChorusMode();

    @FieldName(name = "open_user_infos")
    Map<String, UserChorusInfo> getOpenUserInfo();

    @FieldName(name = MonitorConstants.SEGMENT)
    Long getSegment();

    @FieldName(name = "user_infos")
    Map<Long, UserChorusInfo> getUserInfo();

    @FieldName(name = "is_anchor_joined_chorus")
    Boolean isAnchorJoined();

    @FieldName(name = "is_chorus_chat_mode")
    boolean isChorusChatMode();

    @FieldName(name = "is_anchor_joined_chorus#setter")
    void setAnchorJoined(Boolean r100);

    @FieldName(name = "is_chorus_chat_mode#setter")
    void setChorusChatMode(boolean r100);

    @FieldName(name = "chorus_id#setter")
    void setChorusID(Long r100);

    @FieldName(name = "chorus_id_str#setter")
    void setChorusIdStr(String r100);

    @FieldName(name = "chorus_leader#setter")
    void setChorusLeader(List<Long> r100);

    @FieldName(name = "chorus_leader_str#setter")
    void setChorusLeaderIdStr(List<String> r100);

    @FieldName(name = "chorus_mode#setter")
    void setChorusMode(long r100);

    @FieldName(name = "open_user_infos#setter")
    void setOpenUserInfo(Map<String, ? extends UserChorusInfo> r100);

    @FieldName(name = "segment#setter")
    void setSegment(Long r100);

    @FieldName(name = "user_infos#setter")
    void setUserInfo(Map<Long, ? extends UserChorusInfo> r100);
}
