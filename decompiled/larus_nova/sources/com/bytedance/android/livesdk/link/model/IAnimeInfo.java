package com.bytedance.android.livesdk.link.model;

import com.bytedance.android.livesdkapi.depend.live.ILiveRoomPlayFragmentConstant;
import com.bytedance.tools.kcp.modelx.runtime.FieldName;
import com.bytedance.tools.kcp.modelx.runtime.internal.decode.FlexModelJsonAdapter;
import com.google.gson.annotations.JsonAdapter;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes10.dex */
@JsonAdapter(FlexModelJsonAdapter.class)
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0011\n\u0002\u0010\b\n\u0002\b\b\bg\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001R\u001c\u0010\u0007\u001a\u0004\u0018\u00010\u00028&X§\u0004¢\u0006\f\u0012\u0004\b\u0005\u0010\u0006\u001a\u0004\b\u0003\u0010\u0004R\u001c\u0010\n\u001a\u0004\u0018\u00010\u00028&X§\u0004¢\u0006\f\u0012\u0004\b\t\u0010\u0006\u001a\u0004\b\b\u0010\u0004R\u001c\u0010\r\u001a\u0004\u0018\u00010\u00028&X§\u0004¢\u0006\f\u0012\u0004\b\f\u0010\u0006\u001a\u0004\b\u000b\u0010\u0004R\u001c\u0010\u0010\u001a\u0004\u0018\u00010\u00028&X§\u0004¢\u0006\f\u0012\u0004\b\u000f\u0010\u0006\u001a\u0004\b\u000e\u0010\u0004R\u001c\u0010\u0013\u001a\u0004\u0018\u00010\u00028&X§\u0004¢\u0006\f\u0012\u0004\b\u0012\u0010\u0006\u001a\u0004\b\u0011\u0010\u0004R\u001a\u0010\u0018\u001a\u00020\u00148&X§\u0004¢\u0006\f\u0012\u0004\b\u0017\u0010\u0006\u001a\u0004\b\u0015\u0010\u0016R\u001a\u0010\u001b\u001a\u00020\u00148&X§\u0004¢\u0006\f\u0012\u0004\b\u001a\u0010\u0006\u001a\u0004\b\u0019\u0010\u0016¨\u0006\u001c"}, d2 = {"Lcom/bytedance/android/livesdk/link/model/IAnimeInfo;", "Lvh7/c;", "", "getNormalBarUrl", "()Ljava/lang/String;", "getNormalBarUrl$annotations", "()V", "normalBarUrl", "getBuffBarUrl", "getBuffBarUrl$annotations", "buffBarUrl", "getStealTowerBarUrl", "getStealTowerBarUrl$annotations", "stealTowerBarUrl", "getCurBarUrl", "getCurBarUrl$annotations", "curBarUrl", "getCurAuraUrl", "getCurAuraUrl$annotations", "curAuraUrl", "", "getBarType", "()I", "getBarType$annotations", "barType", "getAuraType", "getAuraType$annotations", "auraType", "revenue-model_saasRelease"}, k = 1, mv = {1, 5, 1})
public interface IAnimeInfo extends vh7.c<IAnimeInfo> {

    @JsonAdapter(FlexModelJsonAdapter.class)
    @Metadata(k = 3, mv = {1, 5, 1})
    public static final class a {
    }

    @Override // vh7.c
    /* synthetic */ vh7.e castTo(Class r100);

    @Override // vh7.c
    /* synthetic */ vh7.e castToOrNull(Class r100);

    @FieldName(name = "aura_type")
    int getAuraType();

    @FieldName(name = ILiveRoomPlayFragmentConstant.EXTRA_BAR_TYPE)
    int getBarType();

    @FieldName(name = "buff_bar_url")
    String getBuffBarUrl();

    @FieldName(name = "cur_aura_url")
    String getCurAuraUrl();

    @FieldName(name = "cur_bar_url")
    String getCurBarUrl();

    @FieldName(name = "normal_bar_url")
    String getNormalBarUrl();

    @FieldName(name = "steal_tower_bar_url")
    String getStealTowerBarUrl();
}
