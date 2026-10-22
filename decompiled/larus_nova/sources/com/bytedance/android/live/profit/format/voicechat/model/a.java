package com.bytedance.android.live.profit.format.voicechat.model;

import com.bytedance.android.livesdkapi.depend.live.ILiveRoomPlayFragmentConstant;
import com.bytedance.tools.kcp.modelx.runtime.FieldName;
import com.bytedance.tools.kcp.modelx.runtime.internal.decode.FlexModelJsonAdapter;
import com.google.gson.annotations.JsonAdapter;
import com.ss.android.ugc.effectmanager.MobConstants;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes47.dex */
@JsonAdapter(FlexModelJsonAdapter.class)
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\b\b\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\b\bg\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001R\u001a\u0010\u0007\u001a\u00020\u00028&X§\u0004¢\u0006\f\u0012\u0004\b\u0005\u0010\u0006\u001a\u0004\b\u0003\u0010\u0004R\u001a\u0010\n\u001a\u00020\u00028&X§\u0004¢\u0006\f\u0012\u0004\b\t\u0010\u0006\u001a\u0004\b\b\u0010\u0004R\u001a\u0010\u000f\u001a\u00020\u000b8&X§\u0004¢\u0006\f\u0012\u0004\b\u000e\u0010\u0006\u001a\u0004\b\f\u0010\rR\u001a\u0010\u0012\u001a\u00020\u000b8&X§\u0004¢\u0006\f\u0012\u0004\b\u0011\u0010\u0006\u001a\u0004\b\u0010\u0010\rR\u001a\u0010\u0017\u001a\u00020\u00138&X§\u0004¢\u0006\f\u0012\u0004\b\u0016\u0010\u0006\u001a\u0004\b\u0014\u0010\u0015R\u001a\u0010\u001a\u001a\u00020\u00028&X§\u0004¢\u0006\f\u0012\u0004\b\u0019\u0010\u0006\u001a\u0004\b\u0018\u0010\u0004¨\u0006\u001b"}, d2 = {"Lcom/bytedance/android/live/profit/format/voicechat/model/a;", "Lvh7/c;", "", "getGiftId", "()J", "getGiftId$annotations", "()V", "giftId", "getEffectId", "getEffectId$annotations", "effectId", "", "getAuthorName", "()Ljava/lang/String;", "getAuthorName$annotations", "authorName", "getAuthorAvatarUrl", "getAuthorAvatarUrl$annotations", "authorAvatarUrl", "Lcom/bytedance/android/live/profit/format/voicechat/model/c;", "getStartButton", "()Lcom/bytedance/android/live/profit/format/voicechat/model/c;", "getStartButton$annotations", "startButton", "getGiftDiamond", "getGiftDiamond$annotations", "giftDiamond", "liveprofit-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public interface a extends vh7.c<a> {

    /* JADX INFO: renamed from: com.bytedance.android.live.profit.format.voicechat.model.a$a, reason: collision with other inner class name */
    @JsonAdapter(FlexModelJsonAdapter.class)
    @Metadata(bv = {1, 0, 3}, k = 3, mv = {1, 4, 3})
    public static final class C1335a {
    }

    @Override // vh7.c
    /* synthetic */ vh7.e castTo(Class r100);

    @Override // vh7.c
    /* synthetic */ vh7.e castToOrNull(Class r100);

    @FieldName(name = "author_avatar")
    String getAuthorAvatarUrl();

    @FieldName(name = "author_name")
    String getAuthorName();

    @FieldName(name = MobConstants.EFFECT_ID)
    long getEffectId();

    @FieldName(name = "gift_diamond_count")
    long getGiftDiamond();

    @FieldName(name = ILiveRoomPlayFragmentConstant.ENTER_LIVE_GITF_ID)
    long getGiftId();

    @FieldName(name = "start_button")
    c getStartButton();
}
