package com.bytedance.android.livesdkapi.depend.model.live;

import com.bytedance.android.live.base.model.user.IBaseUser;
import com.bytedance.android.livesdkapi.feed.constant.OpenFeedConstantKt;
import com.bytedance.tools.kcp.modelx.runtime.FieldName;
import com.bytedance.tools.kcp.modelx.runtime.internal.decode.FlexModelJsonAdapter;
import com.google.gson.annotations.JsonAdapter;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import vh7.c;
import vh7.e;

/* JADX INFO: loaded from: classes12.dex */
@JsonAdapter(FlexModelJsonAdapter.class)
@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\"\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0013\bg\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001R6\u0010\u000b\u001a\u0016\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0002j\n\u0012\u0004\u0012\u00020\u0003\u0018\u0001`\u00048&@&X§\u000e¢\u0006\u0012\u0012\u0004\b\t\u0010\n\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR6\u0010\u0010\u001a\u0016\u0012\u0004\u0012\u00020\f\u0018\u00010\u0002j\n\u0012\u0004\u0012\u00020\f\u0018\u0001`\u00048&@&X§\u000e¢\u0006\u0012\u0012\u0004\b\u000f\u0010\n\u001a\u0004\b\r\u0010\u0006\"\u0004\b\u000e\u0010\bR$\u0010\u0017\u001a\u0004\u0018\u00010\u00118&@&X§\u000e¢\u0006\u0012\u0012\u0004\b\u0016\u0010\n\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015R$\u0010\u001d\u001a\u0004\u0018\u00010\f8&@&X§\u000e¢\u0006\u0012\u0012\u0004\b\u001c\u0010\n\u001a\u0004\b\u0018\u0010\u0019\"\u0004\b\u001a\u0010\u001bR$\u0010!\u001a\u0004\u0018\u00010\f8&@&X§\u000e¢\u0006\u0012\u0012\u0004\b \u0010\n\u001a\u0004\b\u001e\u0010\u0019\"\u0004\b\u001f\u0010\u001bR\"\u0010'\u001a\u00020\u00038&@&X§\u000e¢\u0006\u0012\u0012\u0004\b&\u0010\n\u001a\u0004\b\"\u0010#\"\u0004\b$\u0010%R\"\u0010+\u001a\u00020\u00038&@&X§\u000e¢\u0006\u0012\u0012\u0004\b*\u0010\n\u001a\u0004\b(\u0010#\"\u0004\b)\u0010%R\"\u0010/\u001a\u00020\u00038&@&X§\u000e¢\u0006\u0012\u0012\u0004\b.\u0010\n\u001a\u0004\b,\u0010#\"\u0004\b-\u0010%R\"\u00103\u001a\u00020\u00038&@&X§\u000e¢\u0006\u0012\u0012\u0004\b2\u0010\n\u001a\u0004\b0\u0010#\"\u0004\b1\u0010%RB\u0010;\u001a\"\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0003\u0018\u000104j\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0003\u0018\u0001`58&@&X§\u000e¢\u0006\u0012\u0012\u0004\b:\u0010\n\u001a\u0004\b6\u00107\"\u0004\b8\u00109R\"\u0010B\u001a\u00020<8&@&X§\u000e¢\u0006\u0012\u0012\u0004\bA\u0010\n\u001a\u0004\b=\u0010>\"\u0004\b?\u0010@R\"\u0010F\u001a\u00020\u00038&@&X§\u000e¢\u0006\u0012\u0012\u0004\bE\u0010\n\u001a\u0004\bC\u0010#\"\u0004\bD\u0010%R$\u0010J\u001a\u0004\u0018\u00010\u00118&@&X§\u000e¢\u0006\u0012\u0012\u0004\bI\u0010\n\u001a\u0004\bG\u0010\u0013\"\u0004\bH\u0010\u0015R\"\u0010N\u001a\u00020<8&@&X§\u000e¢\u0006\u0012\u0012\u0004\bM\u0010\n\u001a\u0004\bK\u0010>\"\u0004\bL\u0010@¨\u0006O"}, d2 = {"Lcom/bytedance/android/livesdkapi/depend/model/live/IOfficialChannelInfo;", "Lvh7/c;", "", "", "Lcom/bytedance/revenue/platform/api/core/KmpList;", "getHostAwemeUids", "()Ljava/util/List;", "setHostAwemeUids", "(Ljava/util/List;)V", "getHostAwemeUids$annotations", "()V", "hostAwemeUids", "", "getHostOpenIds", "setHostOpenIds", "getHostOpenIds$annotations", "hostOpenIds", "Lcom/bytedance/android/live/base/model/user/IBaseUser;", "getChannelUser", "()Lcom/bytedance/android/live/base/model/user/IBaseUser;", "setChannelUser", "(Lcom/bytedance/android/live/base/model/user/IBaseUser;)V", "getChannelUser$annotations", "channelUser", "getChannelName", "()Ljava/lang/String;", "setChannelName", "(Ljava/lang/String;)V", "getChannelName$annotations", "channelName", "getChannelIntroduction", "setChannelIntroduction", "getChannelIntroduction$annotations", "channelIntroduction", "getEndTimeStamp", "()J", "setEndTimeStamp", "(J)V", "getEndTimeStamp$annotations", "endTimeStamp", "getForbiddenBeforeEnd", "setForbiddenBeforeEnd", "getForbiddenBeforeEnd$annotations", "forbiddenBeforeEnd", "getMaxEnterTime", "setMaxEnterTime", "getMaxEnterTime$annotations", "maxEnterTime", "getMaxNextTime", "setMaxNextTime", "getMaxNextTime$annotations", "maxNextTime", "", "Lcom/bytedance/revenue/platform/api/core/KmpMap;", "getDelayEnterTime", "()Ljava/util/Map;", "setDelayEnterTime", "(Ljava/util/Map;)V", "getDelayEnterTime$annotations", "delayEnterTime", "", "getHasHostPermission", "()Z", "setHasHostPermission", "(Z)V", "getHasHostPermission$annotations", "hasHostPermission", "getBackupRoomId", "setBackupRoomId", "getBackupRoomId$annotations", "backupRoomId", "getLivingUser", "setLivingUser", "getLivingUser$annotations", "livingUser", "getCanAcceptGift", "setCanAcceptGift", "getCanAcceptGift$annotations", "canAcceptGift", "live-model-api_saasRelease"}, k = 1, mv = {1, 5, 1})
public interface IOfficialChannelInfo extends c<IOfficialChannelInfo> {

    @JsonAdapter(FlexModelJsonAdapter.class)
    @Metadata(k = 3, mv = {1, 5, 1})
    public static final class DefaultImpls {
        @FieldName(name = "backup_room_id")
        public static /* synthetic */ void getBackupRoomId$annotations() {
        }

        @FieldName(name = "host_can_accept_gift")
        public static /* synthetic */ void getCanAcceptGift$annotations() {
        }

        @FieldName(name = "channel_intro")
        public static /* synthetic */ void getChannelIntroduction$annotations() {
        }

        @FieldName(name = OpenFeedConstantKt.KEY_CHANNEL_NAME)
        public static /* synthetic */ void getChannelName$annotations() {
        }

        @FieldName(name = "channel_user")
        public static /* synthetic */ void getChannelUser$annotations() {
        }

        @FieldName(name = "delay_enter_time")
        public static /* synthetic */ void getDelayEnterTime$annotations() {
        }

        @FieldName(name = "end_timestamp")
        public static /* synthetic */ void getEndTimeStamp$annotations() {
        }

        @FieldName(name = "forbidden_before_end")
        public static /* synthetic */ void getForbiddenBeforeEnd$annotations() {
        }

        @FieldName(name = "host_permission")
        public static /* synthetic */ void getHasHostPermission$annotations() {
        }

        @FieldName(name = "host_uids")
        public static /* synthetic */ void getHostAwemeUids$annotations() {
        }

        @FieldName(name = "host_open_ids")
        public static /* synthetic */ void getHostOpenIds$annotations() {
        }

        @FieldName(name = "living_user")
        public static /* synthetic */ void getLivingUser$annotations() {
        }

        @FieldName(name = "max_enter_time")
        public static /* synthetic */ void getMaxEnterTime$annotations() {
        }

        @FieldName(name = "max_next_time")
        public static /* synthetic */ void getMaxNextTime$annotations() {
        }
    }

    @Override // vh7.c
    /* synthetic */ e castTo(Class r100);

    @Override // vh7.c
    /* synthetic */ e castToOrNull(Class r100);

    @FieldName(name = "backup_room_id")
    long getBackupRoomId();

    @FieldName(name = "host_can_accept_gift")
    boolean getCanAcceptGift();

    @FieldName(name = "channel_intro")
    String getChannelIntroduction();

    @FieldName(name = OpenFeedConstantKt.KEY_CHANNEL_NAME)
    String getChannelName();

    @FieldName(name = "channel_user")
    IBaseUser getChannelUser();

    @FieldName(name = "delay_enter_time")
    Map<Long, Long> getDelayEnterTime();

    @FieldName(name = "end_timestamp")
    long getEndTimeStamp();

    @FieldName(name = "forbidden_before_end")
    long getForbiddenBeforeEnd();

    @FieldName(name = "host_permission")
    boolean getHasHostPermission();

    @FieldName(name = "host_uids")
    List<Long> getHostAwemeUids();

    @FieldName(name = "host_open_ids")
    List<String> getHostOpenIds();

    @FieldName(name = "living_user")
    IBaseUser getLivingUser();

    @FieldName(name = "max_enter_time")
    long getMaxEnterTime();

    @FieldName(name = "max_next_time")
    long getMaxNextTime();

    @FieldName(name = "backup_room_id#setter")
    void setBackupRoomId(long r100);

    @FieldName(name = "host_can_accept_gift#setter")
    void setCanAcceptGift(boolean r100);

    @FieldName(name = "channel_intro#setter")
    void setChannelIntroduction(String r100);

    @FieldName(name = "channel_name#setter")
    void setChannelName(String r100);

    @FieldName(name = "channel_user#setter")
    void setChannelUser(IBaseUser r100);

    @FieldName(name = "delay_enter_time#setter")
    void setDelayEnterTime(Map<Long, Long> r100);

    @FieldName(name = "end_timestamp#setter")
    void setEndTimeStamp(long r100);

    @FieldName(name = "forbidden_before_end#setter")
    void setForbiddenBeforeEnd(long r100);

    @FieldName(name = "host_permission#setter")
    void setHasHostPermission(boolean r100);

    @FieldName(name = "host_uids#setter")
    void setHostAwemeUids(List<Long> r100);

    @FieldName(name = "host_open_ids#setter")
    void setHostOpenIds(List<String> r100);

    @FieldName(name = "living_user#setter")
    void setLivingUser(IBaseUser r100);

    @FieldName(name = "max_enter_time#setter")
    void setMaxEnterTime(long r100);

    @FieldName(name = "max_next_time#setter")
    void setMaxNextTime(long r100);
}
