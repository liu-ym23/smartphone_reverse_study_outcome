package com.bytedance.android.livesdkapi.depend.model.live.episode.main;

import com.bytedance.android.live.base.annotation.ForMain;
import com.bytedance.android.livesdkapi.depend.model.live.episode.Episode;
import com.bytedance.android.livesdkapi.depend.model.live.episode.IEpisode;
import com.bytedance.android.livesdkapi.depend.model.live.episode.ReplayPaidInfo;
import com.bytedance.android.livesdkapi.depend.model.live.matchroom.EpisodeBasicInfo;
import com.bytedance.android.livesdkapi.depend.model.live.pay.PrivilegeInfo;
import com.bytedance.tools.kcp.modelx.runtime.FieldName;
import com.bytedance.tools.kcp.modelx.runtime.internal.decode.FlexModelJsonAdapter;
import com.google.gson.annotations.JsonAdapter;
import java.util.Map;
import kotlin.Metadata;
import vh7.e;

/* JADX INFO: loaded from: classes12.dex */
@JsonAdapter(FlexModelJsonAdapter.class)
@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010$\n\u0002\u0010\b\n\u0002\b\u0007\bg\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u0002J\b\u0010\u0004\u001a\u00020\u0003H\u0016J\b\u0010\u0005\u001a\u00020\u0003H\u0016J\b\u0010\u0006\u001a\u00020\u0003H\u0016J\n\u0010\b\u001a\u0004\u0018\u00010\u0007H\u0016J\n\u0010\t\u001a\u0004\u0018\u00010\u0007H\u0016J\b\u0010\n\u001a\u00020\u0003H\u0016R\u001a\u0010\u0010\u001a\u00020\u000b8&X§\u0004¢\u0006\f\u0012\u0004\b\u000e\u0010\u000f\u001a\u0004\b\f\u0010\rR\u001a\u0010\u0015\u001a\u00020\u00118&X§\u0004¢\u0006\f\u0012\u0004\b\u0014\u0010\u000f\u001a\u0004\b\u0012\u0010\u0013R$\u0010\u001c\u001a\u0004\u0018\u00010\u00168&@&X§\u000e¢\u0006\u0012\u0012\u0004\b\u001b\u0010\u000f\u001a\u0004\b\u0017\u0010\u0018\"\u0004\b\u0019\u0010\u001aR0\u0010$\u001a\u0010\u0012\u0004\u0012\u00020\u001e\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u001d8&@&X§\u000e¢\u0006\u0012\u0012\u0004\b#\u0010\u000f\u001a\u0004\b\u001f\u0010 \"\u0004\b!\u0010\"¨\u0006%"}, d2 = {"Lcom/bytedance/android/livesdkapi/depend/model/live/episode/main/IMainEpisode;", "Lvh7/e;", "Lcom/bytedance/android/livesdkapi/depend/model/live/episode/IEpisode;", "", "isPaidReplay", "isPaidCameraReplay", "isPrivilegeCameraReplay", "Lcom/bytedance/android/livesdkapi/depend/model/live/pay/PrivilegeInfo;", "privilegeCameraReplayInfo", "subscribeReplayInfo", "isPrivilegeClarity", "", "get_ownerUserId", "()J", "get_ownerUserId$annotations", "()V", "_ownerUserId", "", "getOwnerOpenId", "()Ljava/lang/String;", "getOwnerOpenId$annotations", "ownerOpenId", "Lcom/bytedance/android/livesdkapi/depend/model/live/episode/ReplayPaidInfo;", "getReplayPaidInfo", "()Lcom/bytedance/android/livesdkapi/depend/model/live/episode/ReplayPaidInfo;", "setReplayPaidInfo", "(Lcom/bytedance/android/livesdkapi/depend/model/live/episode/ReplayPaidInfo;)V", "getReplayPaidInfo$annotations", "replayPaidInfo", "", "", "getPrivilegeInfo", "()Ljava/util/Map;", "setPrivilegeInfo", "(Ljava/util/Map;)V", "getPrivilegeInfo$annotations", "privilegeInfo", "vs-model_saasRelease"}, k = 1, mv = {1, 4, 3})
@ForMain
public interface IMainEpisode extends e<IEpisode>, IEpisode {

    @JsonAdapter(FlexModelJsonAdapter.class)
    @Metadata(bv = {1, 0, 3}, k = 3, mv = {1, 4, 3})
    public static final class DefaultImpls {
        @FieldName(name = "owner_open_id")
        public static /* synthetic */ void getOwnerOpenId$annotations() {
        }

        @FieldName(name = "privilege_info")
        public static /* synthetic */ void getPrivilegeInfo$annotations() {
        }

        @FieldName(name = "paid_live")
        public static /* synthetic */ void getReplayPaidInfo$annotations() {
        }

        @FieldName(name = "owner_user_id")
        public static /* synthetic */ void get_ownerUserId$annotations() {
        }

        public static boolean isPaidCameraReplay(IMainEpisode r100) {
            ReplayPaidInfo r101 = r100.getReplayPaidInfo();
            if (r101 != null) goto L5;
        L7:
            return false;
        L5:
            if (r101.isPaidCamera() != true) goto L7;
            return true;
        }

        public static boolean isPaidReplay(IMainEpisode r100) {
            ReplayPaidInfo r101 = r100.getReplayPaidInfo();
            if (r101 == null) goto L7;
            if (r101.isPaidEpisode() != true) goto L7;
            return true;
        L7:
            if (r100.isPrivilegeCameraReplay() == false) goto L9;
            return true;
        L9:
            if (r100.subscribeReplayInfo() != null) goto L15;
            return false;
        L15:
            return true;
        }

        public static boolean isPrivilegeCameraReplay(IMainEpisode r100) {
            Object r101 = r100.getFlexInstance();
            EpisodeBasicInfo r102 = null;
            if ((r101 instanceof Episode) == true) goto L5;
            r101 = null;
        L5:
            Episode r103 = (Episode) r101;
            if (r103 == null) goto L9;
            r102 = r103.episodeBasicInfo;
        L9:
            if (r100.getPrivilegeInfo() != null) goto L11;
        L16:
            return false;
        L11:
            if (r100.privilegeCameraReplayInfo() == null) goto L16;
            if (r102 == null) goto L16;
            if (r102.isReplayCamera() == false) goto L16;
            return true;
        }

        public static boolean isPrivilegeClarity(IMainEpisode r100) {
            Map<Integer, PrivilegeInfo> r101 = r100.getPrivilegeInfo();
            if (r101 == null) goto L5;
            PrivilegeInfo r102 = r101.get(4);
        L6:
            if (r102 == null) goto L8;
            return true;
        L8:
            return false;
        L5:
            r102 = null;
            goto L6
        }

        public static PrivilegeInfo privilegeCameraReplayInfo(IMainEpisode r100) {
            Map<Integer, PrivilegeInfo> r101 = r100.getPrivilegeInfo();
            if (r101 != null) goto L7;
            return null;
        L7:
            return r101.get(6);
        }

        public static PrivilegeInfo subscribeReplayInfo(IMainEpisode r100) {
            Map<Integer, PrivilegeInfo> r101 = r100.getPrivilegeInfo();
            if (r101 != null) goto L7;
            return null;
        L7:
            return r101.get(101);
        }
    }

    @Override // com.bytedance.android.livesdkapi.depend.model.live.episode.IEpisode, vh7.c
    /* synthetic */ e castTo(Class r100);

    @Override // com.bytedance.android.livesdkapi.depend.model.live.episode.IEpisode, vh7.c
    /* synthetic */ e castToOrNull(Class r100);

    @Override // vh7.e
    /* synthetic */ Object getFlexInstance();

    @FieldName(name = "owner_open_id")
    String getOwnerOpenId();

    @FieldName(name = "privilege_info")
    Map<Integer, PrivilegeInfo> getPrivilegeInfo();

    @FieldName(name = "paid_live")
    ReplayPaidInfo getReplayPaidInfo();

    @FieldName(name = "owner_user_id")
    long get_ownerUserId();

    boolean isPaidCameraReplay();

    boolean isPaidReplay();

    boolean isPrivilegeCameraReplay();

    boolean isPrivilegeClarity();

    PrivilegeInfo privilegeCameraReplayInfo();

    @FieldName(name = "privilege_info#setter")
    void setPrivilegeInfo(Map<Integer, PrivilegeInfo> r100);

    @FieldName(name = "paid_live#setter")
    void setReplayPaidInfo(ReplayPaidInfo r100);

    PrivilegeInfo subscribeReplayInfo();
}
