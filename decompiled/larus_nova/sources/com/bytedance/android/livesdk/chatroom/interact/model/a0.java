package com.bytedance.android.livesdk.chatroom.interact.model;

import com.bytedance.android.livesdk.chatroom.model.interact.m1;
import com.bytedance.tools.kcp.modelx.runtime.internal.decode.FlexModelJsonAdapter;
import com.google.gson.annotations.JsonAdapter;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes7.dex */
@JsonAdapter(FlexModelJsonAdapter.class)
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0006\bg\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001R\u001c\u0010\u0007\u001a\u00020\u00028&@&X¦\u000e¢\u0006\f\u001a\u0004\b\u0003\u0010\u0004\"\u0004\b\u0005\u0010\u0006R\u001c\u0010\r\u001a\u00020\b8&@&X¦\u000e¢\u0006\f\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\fR\u001c\u0010\u0010\u001a\u00020\b8&@&X¦\u000e¢\u0006\f\u001a\u0004\b\u000e\u0010\n\"\u0004\b\u000f\u0010\fR\u001c\u0010\u0013\u001a\u00020\b8&@&X¦\u000e¢\u0006\f\u001a\u0004\b\u0011\u0010\n\"\u0004\b\u0012\u0010\fR\u0016\u0010\u0017\u001a\u0004\u0018\u00010\u00148&X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0015\u0010\u0016R\u001e\u0010\u001d\u001a\u0004\u0018\u00010\u00188&@&X¦\u000e¢\u0006\f\u001a\u0004\b\u0019\u0010\u001a\"\u0004\b\u001b\u0010\u001c¨\u0006\u001e"}, d2 = {"Lcom/bytedance/android/livesdk/chatroom/interact/model/a0;", "Lvh7/c;", "", "getBattleDuration", "()J", "setBattleDuration", "(J)V", "battleDuration", "", "getAcceptInvite", "()Z", "setAcceptInvite", "(Z)V", "acceptInvite", "getOnlyAcceptFollowingInvite", "setOnlyAcceptFollowingInvite", "onlyAcceptFollowingInvite", "getAcceptInviteLessThanThreeUser", "setAcceptInviteLessThanThreeUser", "acceptInviteLessThanThreeUser", "Lcom/bytedance/android/livesdk/chatroom/model/interact/m1;", "getRoomBattleThemeParam", "()Lcom/bytedance/android/livesdk/chatroom/model/interact/m1;", "roomBattleThemeParam", "", "getIntroContent", "()Ljava/lang/String;", "setIntroContent", "(Ljava/lang/String;)V", "introContent", "live-model-api_saasRelease"}, k = 1, mv = {1, 5, 1})
public interface a0 extends vh7.c<a0> {
    @Override // vh7.c
    /* synthetic */ vh7.e castTo(Class r100);

    @Override // vh7.c
    /* synthetic */ vh7.e castToOrNull(Class r100);

    boolean getAcceptInvite();

    boolean getAcceptInviteLessThanThreeUser();

    long getBattleDuration();

    String getIntroContent();

    boolean getOnlyAcceptFollowingInvite();

    m1 getRoomBattleThemeParam();

    void setAcceptInvite(boolean r100);

    void setAcceptInviteLessThanThreeUser(boolean r100);

    void setBattleDuration(long r100);

    void setIntroContent(String r100);

    void setOnlyAcceptFollowingInvite(boolean r100);
}
