package com.bytedance.android.livesdk.link.model;

import com.bytedance.android.livesdkapi.depend.live.ILiveRoomPlayFragmentConstant;
import com.bytedance.tools.kcp.modelx.runtime.FieldName;
import com.bytedance.tools.kcp.modelx.runtime.internal.decode.FlexModelJsonAdapter;
import com.google.gson.annotations.JsonAdapter;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes10.dex */
@JsonAdapter(FlexModelJsonAdapter.class)
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\u000b\bg\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001R\"\u0010\t\u001a\u00020\u00028&@&X§\u000e¢\u0006\u0012\u0012\u0004\b\u0007\u0010\b\u001a\u0004\b\u0003\u0010\u0004\"\u0004\b\u0005\u0010\u0006R&\u0010\u0011\u001a\u00060\nj\u0002`\u000b8&@&X§\u000e¢\u0006\u0012\u0012\u0004\b\u0010\u0010\b\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\"\u0010\u0018\u001a\u00020\u00128&@&X§\u000e¢\u0006\u0012\u0012\u0004\b\u0017\u0010\b\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016R\"\u0010\u001c\u001a\u00020\u00028&@&X§\u000e¢\u0006\u0012\u0012\u0004\b\u001b\u0010\b\u001a\u0004\b\u0019\u0010\u0004\"\u0004\b\u001a\u0010\u0006¨\u0006\u001d"}, d2 = {"Lcom/bytedance/android/livesdk/link/model/ea;", "Lvh7/c;", "", "getGiftId", "()J", "setGiftId", "(J)V", "getGiftId$annotations", "()V", "giftId", "Lpy/k;", "Lcom/bytedance/android/live/api/IImageModelKt;", "getGiftIcon", "()Lpy/k;", "setGiftIcon", "(Lpy/k;)V", "getGiftIcon$annotations", "giftIcon", "", "getGiftName", "()Ljava/lang/String;", "setGiftName", "(Ljava/lang/String;)V", "getGiftName$annotations", "giftName", "getScore", "setScore", "getScore$annotations", com.bytedance.android.ec.core.event.a.KEY_SCORE, "revenue-model_saasRelease"}, k = 1, mv = {1, 5, 1})
public interface ea extends vh7.c<ea> {

    @JsonAdapter(FlexModelJsonAdapter.class)
    @Metadata(k = 3, mv = {1, 5, 1})
    public static final class a {
    }

    @Override // vh7.c
    /* synthetic */ vh7.e castTo(Class r100);

    @Override // vh7.c
    /* synthetic */ vh7.e castToOrNull(Class r100);

    @FieldName(name = "gift_icon")
    py.k getGiftIcon();

    @FieldName(name = ILiveRoomPlayFragmentConstant.ENTER_LIVE_GITF_ID)
    long getGiftId();

    @FieldName(name = "gift_name")
    String getGiftName();

    @FieldName(name = com.bytedance.android.ec.core.event.a.KEY_SCORE)
    long getScore();

    @FieldName(name = "gift_icon#setter")
    void setGiftIcon(py.k r100);

    @FieldName(name = "gift_id#setter")
    void setGiftId(long r100);

    @FieldName(name = "gift_name#setter")
    void setGiftName(String r100);

    @FieldName(name = "score#setter")
    void setScore(long r100);
}
