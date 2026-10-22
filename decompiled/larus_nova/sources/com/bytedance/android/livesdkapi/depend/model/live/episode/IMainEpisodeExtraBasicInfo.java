package com.bytedance.android.livesdkapi.depend.model.live.episode;

import com.bytedance.android.live.base.annotation.ForMain;
import com.bytedance.android.live.base.model.user.IBaseUser;
import com.bytedance.tools.kcp.modelx.runtime.FieldName;
import com.bytedance.tools.kcp.modelx.runtime.internal.decode.FlexModelJsonAdapter;
import com.google.gson.annotations.JsonAdapter;
import com.huawei.hms.push.constant.RemoteMessageConst;
import java.util.List;
import kotlin.Metadata;
import vh7.e;

/* JADX INFO: loaded from: classes12.dex */
@JsonAdapter(FlexModelJsonAdapter.class)
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\b\bg\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u0002R\u001a\u0010\b\u001a\u00020\u00038&X§\u0004¢\u0006\f\u0012\u0004\b\u0006\u0010\u0007\u001a\u0004\b\u0004\u0010\u0005R \u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\n0\t8&X§\u0004¢\u0006\f\u0012\u0004\b\r\u0010\u0007\u001a\u0004\b\u000b\u0010\fR \u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\n0\t8&X§\u0004¢\u0006\f\u0012\u0004\b\u0010\u0010\u0007\u001a\u0004\b\u000f\u0010\f¨\u0006\u0012"}, d2 = {"Lcom/bytedance/android/livesdkapi/depend/model/live/episode/IMainEpisodeExtraBasicInfo;", "Lvh7/e;", "Lcom/bytedance/android/livesdkapi/depend/model/live/episode/IEpisodeExtraBasicInfo;", "", "getVisibility", "()I", "getVisibility$annotations", "()V", RemoteMessageConst.Notification.VISIBILITY, "", "Lcom/bytedance/android/live/base/model/user/IBaseUser;", "getVisibilityAvailableUserList", "()Ljava/util/List;", "getVisibilityAvailableUserList$annotations", "visibilityAvailableUserList", "getVisibilityUnavailableUserList", "getVisibilityUnavailableUserList$annotations", "visibilityUnavailableUserList", "vs-model_saasRelease"}, k = 1, mv = {1, 4, 3})
@ForMain
public interface IMainEpisodeExtraBasicInfo extends e<IEpisodeExtraBasicInfo>, IEpisodeExtraBasicInfo {

    @JsonAdapter(FlexModelJsonAdapter.class)
    @Metadata(bv = {1, 0, 3}, k = 3, mv = {1, 4, 3})
    public static final class DefaultImpls {
        @FieldName(name = RemoteMessageConst.Notification.VISIBILITY)
        public static /* synthetic */ void getVisibility$annotations() {
        }

        @FieldName(name = "visibility_available_users")
        public static /* synthetic */ void getVisibilityAvailableUserList$annotations() {
        }

        @FieldName(name = "visibility_unavailable_users")
        public static /* synthetic */ void getVisibilityUnavailableUserList$annotations() {
        }
    }

    @Override // com.bytedance.android.livesdkapi.depend.model.live.episode.IEpisodeExtraBasicInfo, vh7.c
    /* synthetic */ e castTo(Class r100);

    @Override // com.bytedance.android.livesdkapi.depend.model.live.episode.IEpisodeExtraBasicInfo, vh7.c
    /* synthetic */ e castToOrNull(Class r100);

    @Override // vh7.e
    /* synthetic */ Object getFlexInstance();

    @FieldName(name = RemoteMessageConst.Notification.VISIBILITY)
    int getVisibility();

    @FieldName(name = "visibility_available_users")
    List<IBaseUser> getVisibilityAvailableUserList();

    @FieldName(name = "visibility_unavailable_users")
    List<IBaseUser> getVisibilityUnavailableUserList();
}
