package com.bytedance.android.livesdk.link.model;

import com.bytedance.android.live.base.model.user.IBaseUser;
import com.bytedance.android.livesdkapi.depend.model.live.linker.ICityEffect;
import com.bytedance.android.livesdkapi.depend.model.live.linker.IMatchEffect;
import com.bytedance.tools.kcp.modelx.runtime.FieldName;
import com.bytedance.tools.kcp.modelx.runtime.internal.decode.FlexModelJsonAdapter;
import com.google.gson.annotations.JsonAdapter;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes10.dex */
@JsonAdapter(FlexModelJsonAdapter.class)
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\bf\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u00032\u00020\u0002¨\u0006\u0004"}, d2 = {"Lcom/bytedance/android/livesdk/link/model/p;", "Lvh7/e;", "Lcom/bytedance/android/livesdk/link/model/bridge/k;", "", "revenue-model_saasRelease"}, k = 1, mv = {1, 5, 1})
public interface p extends vh7.e<com.bytedance.android.livesdk.link.model.bridge.k>, com.bytedance.android.livesdk.link.model.bridge.k {

    @JsonAdapter(FlexModelJsonAdapter.class)
    @Metadata(k = 3, mv = {1, 5, 1})
    public static final class a {
    }

    @Override // com.bytedance.android.livesdk.link.model.bridge.k, vh7.c
    /* synthetic */ vh7.e castTo(Class r100);

    @Override // com.bytedance.android.livesdk.link.model.bridge.k, vh7.c
    /* synthetic */ vh7.e castToOrNull(Class r100);

    /* synthetic */ int getAnchorAuthRole();

    /* synthetic */ int getApplyType();

    /* synthetic */ IBaseUser getBaseUser();

    /* synthetic */ ICityEffect getCityEffect();

    /* synthetic */ com.bytedance.android.livesdk.link.model.bridge.k1 getContent();

    /* synthetic */ String getExtra();

    @Override // vh7.e
    /* synthetic */ Object getFlexInstance();

    /* synthetic */ String getInteractId();

    @FieldName(name = "k_song_uid")
    /* synthetic */ Long getKSongUid();

    /* synthetic */ long getLinkMicId();

    /* synthetic */ String getLinkMicIdStr();

    /* synthetic */ String getLinkMicUniqueIdStr();

    /* synthetic */ int getLinkType();

    /* synthetic */ com.bytedance.android.live.liveinteract.multianchor.model.c getListUserExtra();

    /* synthetic */ IMatchEffect getMatchEffect();

    /* synthetic */ long getMcStatus();

    @FieldName(name = "mic_pos_tag_info")
    /* synthetic */ com.bytedance.android.live.liveinteract.plantform.model.g0 getMicPosTagInfo();

    /* synthetic */ long getModifyTime();

    /* synthetic */ int getPkRole();

    /* synthetic */ int getRoleType();

    /* synthetic */ boolean getShowCityEffect();

    /* synthetic */ int getSilenceStatus();

    /* synthetic */ int getStatus();

    /* synthetic */ IBaseUser getUser();

    /* synthetic */ int getUserPosition();

    /* synthetic */ long isBackground();

    /* synthetic */ boolean isJoinUser();

    /* synthetic */ void setApplyType(int r100);

    /* synthetic */ void setBackground(long r100);

    /* synthetic */ void setCityEffect(ICityEffect r100);

    /* synthetic */ void setContent(com.bytedance.android.livesdk.link.model.bridge.k1 r100);

    /* synthetic */ void setExtra(String r100);

    /* synthetic */ void setJoinUser(boolean r100);

    @FieldName(name = "k_song_uid#setter")
    /* synthetic */ void setKSongUid(Long r100);

    /* synthetic */ void setLinkMicIdStr(String r100);

    /* synthetic */ void setLinkMicUniqueIdStr(String r100);

    /* synthetic */ void setLinkType(int r100);

    /* synthetic */ void setListUserExtra(com.bytedance.android.live.liveinteract.multianchor.model.c r100);

    /* synthetic */ void setMatchEffect(IMatchEffect r100);

    /* synthetic */ void setMcStatus(long r100);

    @FieldName(name = "mic_pos_tag_info#setter")
    /* synthetic */ void setMicPosTagInfo(com.bytedance.android.live.liveinteract.plantform.model.g0 r100);

    /* synthetic */ void setModifyTime(long r100);

    /* synthetic */ void setRoleType(int r100);

    /* synthetic */ void setShowCityEffect(boolean r100);

    /* synthetic */ void setSilenceStatus(int r100);

    /* synthetic */ void setStatus(int r100);

    /* synthetic */ void setUser(IBaseUser r100);

    /* synthetic */ void setUserPosition(int r100);

    /* synthetic */ String toSimpleString();
}
