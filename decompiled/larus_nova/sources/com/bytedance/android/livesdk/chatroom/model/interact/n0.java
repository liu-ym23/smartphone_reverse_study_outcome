package com.bytedance.android.livesdk.chatroom.model.interact;

import com.bytedance.android.gamecp.business.instantplay.InstantPlayContext;
import com.bytedance.tools.kcp.modelx.runtime.FieldName;
import com.bytedance.tools.kcp.modelx.runtime.internal.decode.FlexModelJsonAdapter;
import com.google.gson.annotations.JsonAdapter;
import java.util.List;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes7.dex */
@JsonAdapter(FlexModelJsonAdapter.class)
@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0007\bg\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001R\u001a\u0010\u0007\u001a\u00020\u00028&X§\u0004¢\u0006\f\u0012\u0004\b\u0005\u0010\u0006\u001a\u0004\b\u0003\u0010\u0004R \u0010\r\u001a\b\u0012\u0004\u0012\u00020\t0\b8&X§\u0004¢\u0006\f\u0012\u0004\b\f\u0010\u0006\u001a\u0004\b\n\u0010\u000bR\u001a\u0010\u000f\u001a\u00020\u000e8&X§\u0004¢\u0006\f\u0012\u0004\b\u0011\u0010\u0006\u001a\u0004\b\u000f\u0010\u0010R \u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00120\b8&X§\u0004¢\u0006\f\u0012\u0004\b\u0014\u0010\u0006\u001a\u0004\b\u0013\u0010\u000bR\u001c\u0010\u001a\u001a\u0004\u0018\u00010\u00168&X§\u0004¢\u0006\f\u0012\u0004\b\u0019\u0010\u0006\u001a\u0004\b\u0017\u0010\u0018R\"\u0010!\u001a\u00020\u001b8&@&X§\u000e¢\u0006\u0012\u0012\u0004\b \u0010\u0006\u001a\u0004\b\u001c\u0010\u001d\"\u0004\b\u001e\u0010\u001f¨\u0006\""}, d2 = {"Lcom/bytedance/android/livesdk/chatroom/model/interact/n0;", "Lvh7/c;", "", "getPlayId", "()J", "getPlayId$annotations", "()V", "playId", "", "Lcom/bytedance/android/livesdk/chatroom/model/interact/q0;", "getPlayerInfo", "()Ljava/util/List;", "getPlayerInfo$annotations", "playerInfo", "", "isGiftOpen", "()Z", "isGiftOpen$annotations", "Lcom/bytedance/android/livesdk/chatroom/model/interact/l0;", "getStarGifts", "getStarGifts$annotations", "starGifts", "Lcom/bytedance/android/livesdk/chatroom/model/interact/s1;", "getPerformanceInfo", "()Lcom/bytedance/android/livesdk/chatroom/model/interact/s1;", "getPerformanceInfo$annotations", "performanceInfo", "", "getDressId", "()Ljava/lang/String;", "setDressId", "(Ljava/lang/String;)V", "getDressId$annotations", "dressId", "live-model-api_saasRelease"}, k = 1, mv = {1, 5, 1})
public interface n0 extends vh7.c<n0> {

    @JsonAdapter(FlexModelJsonAdapter.class)
    @Metadata(k = 3, mv = {1, 5, 1})
    public static final class a {
    }

    @Override // vh7.c
    /* synthetic */ vh7.e castTo(Class r100);

    @Override // vh7.c
    /* synthetic */ vh7.e castToOrNull(Class r100);

    @FieldName(name = "dress_id")
    String getDressId();

    @FieldName(name = "performance_info")
    s1 getPerformanceInfo();

    @FieldName(name = InstantPlayContext.PLAY_ID)
    long getPlayId();

    @FieldName(name = "player_info")
    List<q0> getPlayerInfo();

    @FieldName(name = "star_gifts")
    List<l0> getStarGifts();

    @FieldName(name = "is_gift_open")
    boolean isGiftOpen();

    @FieldName(name = "dress_id#setter")
    void setDressId(String r100);
}
