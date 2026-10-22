package com.bytedance.android.livesdk.chatroom.model.interact;

import com.bytedance.tools.kcp.modelx.runtime.internal.decode.FlexModelJsonAdapter;
import com.google.gson.annotations.JsonAdapter;
import java.util.List;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes7.dex */
@JsonAdapter(FlexModelJsonAdapter.class)
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\bg\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u00012\u00020\u0002J\u0018\u0010\u0007\u001a\u00020\u00062\u000e\u0010\u0005\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003H&R\u001c\u0010\t\u001a\u00020\b8&@&X¦\u000e¢\u0006\f\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\fR0\u0010\u0005\u001a\u0016\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003j\n\u0012\u0004\u0012\u00020\u0004\u0018\u0001`\r8&@&X¦\u000e¢\u0006\f\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011¨\u0006\u0012"}, d2 = {"Lcom/bytedance/android/livesdk/chatroom/model/interact/n;", "Lvh7/c;", "", "", "Lcom/bytedance/android/livesdk/chatroom/interact/model/y;", "settings", "", "setSettingsExt", "", "isTurnOn", "()I", "setTurnOn", "(I)V", "Lcom/bytedance/revenue/platform/api/core/KmpList;", "getSettings", "()Ljava/util/List;", "setSettings", "(Ljava/util/List;)V", "multilink-base_saasRelease"}, k = 1, mv = {1, 5, 1})
public interface n extends vh7.c<n> {
    @Override // vh7.c
    /* synthetic */ vh7.e castTo(Class r100);

    @Override // vh7.c
    /* synthetic */ vh7.e castToOrNull(Class r100);

    /* synthetic */ boolean getAcceptNeedVerified();

    /* synthetic */ boolean getAudioChatAcceptNeedVerified();

    /* synthetic */ boolean getAudioChatOnlyAcceptFollowerApply();

    /* synthetic */ boolean getIntimateChatAcceptNeedVerified();

    /* synthetic */ boolean getIntimateChatOnlyJoinThroughInvitation();

    /* synthetic */ boolean getIntimateOnlyAcceptFollowerApply();

    List<com.bytedance.android.livesdk.chatroom.interact.model.y> getSettings();

    /* synthetic */ boolean getVideoTalkOnlyAcceptFollower();

    int isTurnOn();

    /* synthetic */ void setAcceptNeedVerified(boolean r100);

    /* synthetic */ void setAudioChatAcceptNeedVerified(boolean r100);

    /* synthetic */ void setAudioChatOnlyAcceptFollowerApply(boolean r100);

    /* synthetic */ void setIntimateChatAcceptNeedVerified(boolean r100);

    /* synthetic */ void setIntimateChatOnlyJoinThroughInvitation(boolean r100);

    /* synthetic */ void setIntimateOnlyAcceptFollowerApply(boolean r100);

    void setSettings(List<? extends com.bytedance.android.livesdk.chatroom.interact.model.y> r100);

    void setSettingsExt(List<? extends com.bytedance.android.livesdk.chatroom.interact.model.y> r100);

    void setTurnOn(int r100);

    /* synthetic */ void setVideoTalkOnlyAcceptFollower(boolean r100);
}
