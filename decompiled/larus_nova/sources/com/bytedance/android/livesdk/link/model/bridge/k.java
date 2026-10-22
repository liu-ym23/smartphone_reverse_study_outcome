package com.bytedance.android.livesdk.link.model.bridge;

import com.bytedance.android.live.base.model.user.IBaseUser;
import com.bytedance.android.livesdkapi.depend.model.live.linker.ICityEffect;
import com.bytedance.android.livesdkapi.depend.model.live.linker.IMatchEffect;
import com.bytedance.tools.kcp.modelx.runtime.FieldName;
import com.bytedance.tools.kcp.modelx.runtime.internal.decode.FlexModelJsonAdapter;
import com.google.gson.annotations.JsonAdapter;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes10.dex */
@JsonAdapter(FlexModelJsonAdapter.class)
@Metadata(d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0010\t\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\t\bg\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u00012\u00020\u0002J\b\u0010\u0004\u001a\u00020\u0003H&J\b\u0010\u0006\u001a\u00020\u0005H&J\b\u0010\u0007\u001a\u00020\u0005H&R\u0016\u0010\u000b\u001a\u0004\u0018\u00010\b8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\t\u0010\nR\u001c\u0010\u0010\u001a\u00020\u00058&@&X¦\u000e¢\u0006\f\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\u001e\u0010\u0016\u001a\u0004\u0018\u00010\u00118&@&X¦\u000e¢\u0006\f\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015R\u001e\u0010\u001c\u001a\u0004\u0018\u00010\u00178&@&X¦\u000e¢\u0006\f\u001a\u0004\b\u0018\u0010\u0019\"\u0004\b\u001a\u0010\u001bR\u001c\u0010\"\u001a\u00020\u001d8&@&X¦\u000e¢\u0006\f\u001a\u0004\b\u001e\u0010\u001f\"\u0004\b \u0010!R\u001c\u0010#\u001a\u00020\u001d8&@&X¦\u000e¢\u0006\f\u001a\u0004\b#\u0010\u001f\"\u0004\b$\u0010!R$\u0010,\u001a\u0004\u0018\u00010%8&@&X§\u000e¢\u0006\u0012\u0012\u0004\b*\u0010+\u001a\u0004\b&\u0010'\"\u0004\b(\u0010)R$\u00103\u001a\u0004\u0018\u00010-8&@&X§\u000e¢\u0006\u0012\u0012\u0004\b2\u0010+\u001a\u0004\b.\u0010/\"\u0004\b0\u00101R\u001e\u00109\u001a\u0004\u0018\u0001048&@&X¦\u000e¢\u0006\f\u001a\u0004\b5\u00106\"\u0004\b7\u00108R\u0016\u0010<\u001a\u0004\u0018\u00010\u00038&X¦\u0004¢\u0006\u0006\u001a\u0004\b:\u0010;¨\u0006="}, d2 = {"Lcom/bytedance/android/livesdk/link/model/bridge/k;", "Lvh7/c;", "", "", "toSimpleString", "", "getPkRole", "getAnchorAuthRole", "Lcom/bytedance/android/live/base/model/user/IBaseUser;", "getBaseUser", "()Lcom/bytedance/android/live/base/model/user/IBaseUser;", "baseUser", "getApplyType", "()I", "setApplyType", "(I)V", "applyType", "Lcom/bytedance/android/livesdkapi/depend/model/live/linker/IMatchEffect;", "getMatchEffect", "()Lcom/bytedance/android/livesdkapi/depend/model/live/linker/IMatchEffect;", "setMatchEffect", "(Lcom/bytedance/android/livesdkapi/depend/model/live/linker/IMatchEffect;)V", "matchEffect", "Lcom/bytedance/android/livesdkapi/depend/model/live/linker/ICityEffect;", "getCityEffect", "()Lcom/bytedance/android/livesdkapi/depend/model/live/linker/ICityEffect;", "setCityEffect", "(Lcom/bytedance/android/livesdkapi/depend/model/live/linker/ICityEffect;)V", "cityEffect", "", "getShowCityEffect", "()Z", "setShowCityEffect", "(Z)V", "showCityEffect", "isJoinUser", "setJoinUser", "", "getKSongUid", "()Ljava/lang/Long;", "setKSongUid", "(Ljava/lang/Long;)V", "getKSongUid$annotations", "()V", "kSongUid", "Lcom/bytedance/android/live/liveinteract/plantform/model/g0;", "getMicPosTagInfo", "()Lcom/bytedance/android/live/liveinteract/plantform/model/g0;", "setMicPosTagInfo", "(Lcom/bytedance/android/live/liveinteract/plantform/model/g0;)V", "getMicPosTagInfo$annotations", "micPosTagInfo", "Lcom/bytedance/android/live/liveinteract/multianchor/model/c;", "getListUserExtra", "()Lcom/bytedance/android/live/liveinteract/multianchor/model/c;", "setListUserExtra", "(Lcom/bytedance/android/live/liveinteract/multianchor/model/c;)V", "listUserExtra", "getInteractId", "()Ljava/lang/String;", "interactId", "live-model-api_saasRelease"}, k = 1, mv = {1, 5, 1})
public interface k extends vh7.c<k> {

    @JsonAdapter(FlexModelJsonAdapter.class)
    @Metadata(k = 3, mv = {1, 5, 1})
    public static final class a {
    }

    @Override // vh7.c
    /* synthetic */ vh7.e castTo(Class r100);

    @Override // vh7.c
    /* synthetic */ vh7.e castToOrNull(Class r100);

    int getAnchorAuthRole();

    int getApplyType();

    IBaseUser getBaseUser();

    ICityEffect getCityEffect();

    /* synthetic */ k1 getContent();

    /* synthetic */ String getExtra();

    String getInteractId();

    @FieldName(name = "k_song_uid")
    Long getKSongUid();

    /* synthetic */ long getLinkMicId();

    /* synthetic */ String getLinkMicIdStr();

    /* synthetic */ String getLinkMicUniqueIdStr();

    /* synthetic */ int getLinkType();

    com.bytedance.android.live.liveinteract.multianchor.model.c getListUserExtra();

    IMatchEffect getMatchEffect();

    /* synthetic */ long getMcStatus();

    @FieldName(name = "mic_pos_tag_info")
    com.bytedance.android.live.liveinteract.plantform.model.g0 getMicPosTagInfo();

    /* synthetic */ long getModifyTime();

    int getPkRole();

    /* synthetic */ int getRoleType();

    boolean getShowCityEffect();

    /* synthetic */ int getSilenceStatus();

    /* synthetic */ int getStatus();

    /* synthetic */ IBaseUser getUser();

    /* synthetic */ int getUserPosition();

    /* synthetic */ long isBackground();

    boolean isJoinUser();

    void setApplyType(int r100);

    /* synthetic */ void setBackground(long r100);

    void setCityEffect(ICityEffect r100);

    /* synthetic */ void setContent(k1 r100);

    /* synthetic */ void setExtra(String r100);

    void setJoinUser(boolean r100);

    @FieldName(name = "k_song_uid#setter")
    void setKSongUid(Long r100);

    /* synthetic */ void setLinkMicIdStr(String r100);

    /* synthetic */ void setLinkMicUniqueIdStr(String r100);

    /* synthetic */ void setLinkType(int r100);

    void setListUserExtra(com.bytedance.android.live.liveinteract.multianchor.model.c r100);

    void setMatchEffect(IMatchEffect r100);

    /* synthetic */ void setMcStatus(long r100);

    @FieldName(name = "mic_pos_tag_info#setter")
    void setMicPosTagInfo(com.bytedance.android.live.liveinteract.plantform.model.g0 r100);

    /* synthetic */ void setModifyTime(long r100);

    /* synthetic */ void setRoleType(int r100);

    void setShowCityEffect(boolean r100);

    /* synthetic */ void setSilenceStatus(int r100);

    /* synthetic */ void setStatus(int r100);

    /* synthetic */ void setUser(IBaseUser r100);

    /* synthetic */ void setUserPosition(int r100);

    String toSimpleString();
}
