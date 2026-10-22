package com.bytedance.android.livesdkapi.depend.model.live.episode;

import com.bytedance.android.live.base.model.user.IBaseUser;
import com.bytedance.android.livesdkapi.depend.model.live.IRoomAuthStatus;
import com.bytedance.tools.kcp.modelx.runtime.internal.decode.FlexModelJsonAdapter;
import com.google.gson.annotations.JsonAdapter;
import java.util.List;
import kotlin.Metadata;
import vh7.c;
import vh7.e;

/* JADX INFO: loaded from: classes12.dex */
@JsonAdapter(FlexModelJsonAdapter.class)
@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u000e\n\u0002\b\u0004\bg\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001R\u001e\u0010\u0007\u001a\u0004\u0018\u00010\u00028&@&X¦\u000e¢\u0006\f\u001a\u0004\b\u0003\u0010\u0004\"\u0004\b\u0005\u0010\u0006R\u0016\u0010\u000b\u001a\u0004\u0018\u00010\b8&X¦\u0004¢\u0006\u0006\u001a\u0004\b\t\u0010\nR\u0014\u0010\u000f\u001a\u00020\f8&X¦\u0004¢\u0006\u0006\u001a\u0004\b\r\u0010\u000eR\u001c\u0010\u0014\u001a\n\u0012\u0004\u0012\u00020\u0011\u0018\u00010\u00108&X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0012\u0010\u0013R\u0014\u0010\u0018\u001a\u00020\u00158&X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0016\u0010\u0017R\u001c\u0010\u001c\u001a\u00020\f8&@&X¦\u000e¢\u0006\f\u001a\u0004\b\u0019\u0010\u000e\"\u0004\b\u001a\u0010\u001bR\u0014\u0010\u001e\u001a\u00020\f8&X¦\u0004¢\u0006\u0006\u001a\u0004\b\u001d\u0010\u000eR\u0014\u0010\"\u001a\u00020\u001f8&X¦\u0004¢\u0006\u0006\u001a\u0004\b \u0010!¨\u0006#"}, d2 = {"Lcom/bytedance/android/livesdkapi/depend/model/live/episode/IEpisode;", "Lvh7/c;", "Lcom/bytedance/android/livesdkapi/depend/model/live/IRoomAuthStatus;", "getRoomAuthStatus", "()Lcom/bytedance/android/livesdkapi/depend/model/live/IRoomAuthStatus;", "setRoomAuthStatus", "(Lcom/bytedance/android/livesdkapi/depend/model/live/IRoomAuthStatus;)V", "roomAuthStatus", "Lcom/bytedance/android/live/base/model/user/IBaseUser;", "getOwnerExt", "()Lcom/bytedance/android/live/base/model/user/IBaseUser;", "ownerExt", "", "getRoomIdExt", "()J", "roomIdExt", "", "Lcom/bytedance/android/livesdkapi/depend/model/live/episode/IVSToolbarConfigData;", "getPannelToolbarList", "()Ljava/util/List;", "pannelToolbarList", "Lcom/bytedance/android/livesdkapi/depend/model/live/episode/VSGiftPannel;", "getGiftPanel", "()Lcom/bytedance/android/livesdkapi/depend/model/live/episode/VSGiftPannel;", "giftPanel", "getId", "setId", "(J)V", "id", "getIdExt", "idExt", "", "getSeasonIdFlex", "()Ljava/lang/String;", "seasonIdFlex", "vs-model_saasRelease"}, k = 1, mv = {1, 4, 3})
public interface IEpisode extends c<IEpisode> {
    @Override // vh7.c
    /* synthetic */ e castTo(Class r100);

    @Override // vh7.c
    /* synthetic */ e castToOrNull(Class r100);

    VSGiftPannel getGiftPanel();

    long getId();

    long getIdExt();

    IBaseUser getOwnerExt();

    List<IVSToolbarConfigData> getPannelToolbarList();

    IRoomAuthStatus getRoomAuthStatus();

    long getRoomIdExt();

    String getSeasonIdFlex();

    void setId(long r100);

    void setRoomAuthStatus(IRoomAuthStatus r100);
}
