package com.bytedance.android.livesdk.chatroom.model.interact;

import com.bytedance.android.gamecp.business.instantplay.InstantPlayContext;
import com.bytedance.bdp.appbase.base.event.BdpAppEventConstant;
import com.bytedance.tools.kcp.modelx.runtime.FieldName;
import com.bytedance.tools.kcp.modelx.runtime.internal.decode.FlexModelJsonAdapter;
import com.google.gson.annotations.JsonAdapter;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes7.dex */
@JsonAdapter(FlexModelJsonAdapter.class)
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010\b\n\u0002\b\b\bg\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001R\u001a\u0010\u0007\u001a\u00020\u00028&X§\u0004¢\u0006\f\u0012\u0004\b\u0005\u0010\u0006\u001a\u0004\b\u0003\u0010\u0004R\u001a\u0010\f\u001a\u00020\b8&X§\u0004¢\u0006\f\u0012\u0004\b\u000b\u0010\u0006\u001a\u0004\b\t\u0010\nR\u001a\u0010\u000f\u001a\u00020\b8&X§\u0004¢\u0006\f\u0012\u0004\b\u000e\u0010\u0006\u001a\u0004\b\r\u0010\nR\u001a\u0010\u0014\u001a\u00020\u00108&X§\u0004¢\u0006\f\u0012\u0004\b\u0013\u0010\u0006\u001a\u0004\b\u0011\u0010\u0012R\u001a\u0010\u0017\u001a\u00020\u00108&X§\u0004¢\u0006\f\u0012\u0004\b\u0016\u0010\u0006\u001a\u0004\b\u0015\u0010\u0012¨\u0006\u0018"}, d2 = {"Lcom/bytedance/android/livesdk/chatroom/model/interact/k0;", "Lvh7/c;", "", "getPlayId", "()J", "getPlayId$annotations", "()V", "playId", "", "getGameId", "()Ljava/lang/String;", "getGameId$annotations", "gameId", "getGameCategory", "getGameCategory$annotations", "gameCategory", "", "getRunningType", "()I", "getRunningType$annotations", "runningType", "getPublicStreamType", "getPublicStreamType$annotations", "publicStreamType", "live-model-api_saasRelease"}, k = 1, mv = {1, 5, 1})
public interface k0 extends vh7.c<k0> {

    @JsonAdapter(FlexModelJsonAdapter.class)
    @Metadata(k = 3, mv = {1, 5, 1})
    public static final class a {
    }

    @Override // vh7.c
    /* synthetic */ vh7.e castTo(Class r100);

    @Override // vh7.c
    /* synthetic */ vh7.e castToOrNull(Class r100);

    @FieldName(name = BdpAppEventConstant.PARAMS_GAME_CATEGORY)
    String getGameCategory();

    @FieldName(name = "game_id")
    String getGameId();

    @FieldName(name = InstantPlayContext.PLAY_ID)
    long getPlayId();

    @FieldName(name = "public_stream_type")
    int getPublicStreamType();

    @FieldName(name = "running_type")
    int getRunningType();
}
