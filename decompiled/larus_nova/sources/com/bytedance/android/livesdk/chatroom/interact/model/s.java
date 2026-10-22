package com.bytedance.android.livesdk.chatroom.interact.model;

import com.bytedance.tools.kcp.modelx.runtime.FieldName;
import com.bytedance.tools.kcp.modelx.runtime.internal.decode.FlexModelJsonAdapter;
import com.google.gson.annotations.JsonAdapter;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes7.dex */
@JsonAdapter(FlexModelJsonAdapter.class)
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0006\bg\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001R\u0014\u0010\u0003\u001a\u00020\u00028gX¦\u0004¢\u0006\u0006\u001a\u0004\b\u0003\u0010\u0004R\u0014\u0010\u0005\u001a\u00020\u00028gX¦\u0004¢\u0006\u0006\u001a\u0004\b\u0005\u0010\u0004R\u0014\u0010\u0006\u001a\u00020\u00028gX¦\u0004¢\u0006\u0006\u001a\u0004\b\u0006\u0010\u0004R\u0014\u0010\u0007\u001a\u00020\u00028gX¦\u0004¢\u0006\u0006\u001a\u0004\b\u0007\u0010\u0004¨\u0006\b"}, d2 = {"Lcom/bytedance/android/livesdk/chatroom/interact/model/s;", "Lvh7/c;", "", "isIsTurnOn", "()Z", "isAcceptMultiAnchorLink", "isAcceptNotFollowerInvite", "isAllowGiftToOtherAnchors", "live-model-api_saasRelease"}, k = 1, mv = {1, 5, 1})
public interface s extends vh7.c<s> {
    @Override // vh7.c
    /* synthetic */ vh7.e castTo(Class r100);

    @Override // vh7.c
    /* synthetic */ vh7.e castToOrNull(Class r100);

    @FieldName(name = "accept_multi_linkmic")
    boolean isAcceptMultiAnchorLink();

    @FieldName(name = "accept_not_follower_invite")
    boolean isAcceptNotFollowerInvite();

    @FieldName(name = "allow_gift_to_other_anchors")
    boolean isAllowGiftToOtherAnchors();

    @FieldName(name = "is_turn_on")
    boolean isIsTurnOn();
}
