package com.bytedance.android.livesdkapi.depend.model.live;

import com.bytedance.android.live.base.model.user.IBaseUser;
import com.bytedance.android.livesdkapi.depend.live.ILiveRoomPlayFragmentConstant;
import com.bytedance.android.livesdkapi.depend.model.live.episode.IEpisodeExtraInfoBase;
import com.bytedance.tools.kcp.modelx.runtime.FieldName;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes12.dex */
@Metadata(d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0004\bf\u0018\u00002\u00020\u0001R$\u0010\u0002\u001a\u0004\u0018\u00010\u00038&@&X§\u000e¢\u0006\u0012\u0012\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u001c\u0010\n\u001a\u0004\u0018\u00010\u000b8&X§\u0004¢\u0006\f\u0012\u0004\b\f\u0010\u0005\u001a\u0004\b\r\u0010\u000eR\"\u0010\u000f\u001a\u00020\u00108&@&X§\u000e¢\u0006\u0012\u0012\u0004\b\u0011\u0010\u0005\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015R\u001a\u0010\u0016\u001a\u00020\u00178&X§\u0004¢\u0006\f\u0012\u0004\b\u0018\u0010\u0005\u001a\u0004\b\u0016\u0010\u0019R\u001a\u0010\u001a\u001a\u00020\u00178&X§\u0004¢\u0006\f\u0012\u0004\b\u001b\u0010\u0005\u001a\u0004\b\u001a\u0010\u0019R\u001a\u0010\u001c\u001a\u00020\u00178&X§\u0004¢\u0006\f\u0012\u0004\b\u001d\u0010\u0005\u001a\u0004\b\u001c\u0010\u0019R\u001e\u0010\u001e\u001a\u00060\u001fj\u0002` 8&X§\u0004¢\u0006\f\u0012\u0004\b!\u0010\u0005\u001a\u0004\b\"\u0010#R\u001e\u0010$\u001a\u00060\u001fj\u0002` 8&X§\u0004¢\u0006\f\u0012\u0004\b%\u0010\u0005\u001a\u0004\b&\u0010#R\u001c\u0010'\u001a\u0004\u0018\u00010(8&X§\u0004¢\u0006\f\u0012\u0004\b)\u0010\u0005\u001a\u0004\b*\u0010+R*\u0010,\u001a\n\u0018\u00010-j\u0004\u0018\u0001`.8&@&X§\u000e¢\u0006\u0012\u0012\u0004\b/\u0010\u0005\u001a\u0004\b0\u00101\"\u0004\b2\u00103R\u001e\u00104\u001a\u00060\u001fj\u0002` 8&X§\u0004¢\u0006\f\u0012\u0004\b5\u0010\u0005\u001a\u0004\b6\u0010#R\u001c\u00107\u001a\u0004\u0018\u0001088&X§\u0004¢\u0006\f\u0012\u0004\b9\u0010\u0005\u001a\u0004\b:\u0010;¨\u0006<"}, d2 = {"Lcom/bytedance/android/livesdkapi/depend/model/live/IRoomBase;", "", "basisRoomData", "Lcom/bytedance/android/livesdkapi/depend/model/live/IRoomBasisData;", "getBasisRoomData$annotations", "()V", "getBasisRoomData", "()Lcom/bytedance/android/livesdkapi/depend/model/live/IRoomBasisData;", "setBasisRoomData", "(Lcom/bytedance/android/livesdkapi/depend/model/live/IRoomBasisData;)V", "episodeExtra", "Lcom/bytedance/android/livesdkapi/depend/model/live/episode/IEpisodeExtraInfoBase;", "getEpisodeExtra$annotations", "getEpisodeExtra", "()Lcom/bytedance/android/livesdkapi/depend/model/live/episode/IEpisodeExtraInfoBase;", "idStr", "", "getIdStr$annotations", "getIdStr", "()Ljava/lang/String;", "setIdStr", "(Ljava/lang/String;)V", "isLiveTypeAudio", "", "isLiveTypeAudio$annotations", "()Z", "isScreenshot", "isScreenshot$annotations", "isThirdParty", "isThirdParty$annotations", "layout", "", "Lcom/bytedance/revenue/platform/api/core/UnsafeLong;", "getLayout$annotations", "getLayout", "()J", "liveRoomMode", "getLiveRoomMode$annotations", "getLiveRoomMode", "mRoomAuthStatus", "Lcom/bytedance/android/livesdkapi/depend/model/live/IRoomAuthStatus;", "getMRoomAuthStatus$annotations", "getMRoomAuthStatus", "()Lcom/bytedance/android/livesdkapi/depend/model/live/IRoomAuthStatus;", "ownerKt", "Lcom/bytedance/android/live/base/model/user/IBaseUser;", "Lcom/bytedance/android/live/base/model/user/IBaseUserKt;", "getOwnerKt$annotations", "getOwnerKt", "()Lcom/bytedance/android/live/base/model/user/IBaseUser;", "setOwnerKt", "(Lcom/bytedance/android/live/base/model/user/IBaseUser;)V", "roomLayout", "getRoomLayout$annotations", "getRoomLayout", "sceneTypeInfo", "Lcom/bytedance/android/livesdkapi/depend/model/live/IRoomSpecificSceneTypeInfo;", "getSceneTypeInfo$annotations", "getSceneTypeInfo", "()Lcom/bytedance/android/livesdkapi/depend/model/live/IRoomSpecificSceneTypeInfo;", "live-model-api_saasRelease"}, k = 1, mv = {1, 5, 1})
public interface IRoomBase {

    @Metadata(k = 3, mv = {1, 5, 1})
    public static final class DefaultImpls {
        @FieldName(name = "basis")
        public static /* synthetic */ void getBasisRoomData$annotations() {
        }

        @FieldName(name = "episode_extra")
        public static /* synthetic */ void getEpisodeExtra$annotations() {
        }

        @FieldName(name = "id_str")
        public static /* synthetic */ void getIdStr$annotations() {
        }

        @FieldName(name = "layout")
        public static /* synthetic */ void getLayout$annotations() {
        }

        @FieldName(name = "live_room_mode")
        public static /* synthetic */ void getLiveRoomMode$annotations() {
        }

        @FieldName(name = "room_auth")
        public static /* synthetic */ void getMRoomAuthStatus$annotations() {
        }

        @FieldName(name = "owner")
        public static /* synthetic */ void getOwnerKt$annotations() {
        }

        @FieldName(name = ILiveRoomPlayFragmentConstant.EXTRA_ROOM_LAYOUT)
        public static /* synthetic */ void getRoomLayout$annotations() {
        }

        @FieldName(name = "scene_type_info")
        public static /* synthetic */ void getSceneTypeInfo$annotations() {
        }

        @FieldName(name = "live_type_audio")
        public static /* synthetic */ void isLiveTypeAudio$annotations() {
        }

        @FieldName(name = "live_type_screenshot")
        public static /* synthetic */ void isScreenshot$annotations() {
        }

        @FieldName(name = "live_type_third_party")
        public static /* synthetic */ void isThirdParty$annotations() {
        }
    }

    IRoomBasisData getBasisRoomData();

    IEpisodeExtraInfoBase getEpisodeExtra();

    String getIdStr();

    long getLayout();

    long getLiveRoomMode();

    IRoomAuthStatus getMRoomAuthStatus();

    IBaseUser getOwnerKt();

    long getRoomLayout();

    IRoomSpecificSceneTypeInfo getSceneTypeInfo();

    boolean isLiveTypeAudio();

    boolean isScreenshot();

    boolean isThirdParty();

    void setBasisRoomData(IRoomBasisData r100);

    void setIdStr(String r100);

    void setOwnerKt(IBaseUser r100);
}
