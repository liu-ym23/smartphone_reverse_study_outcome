package com.bytedance.android.livesdk.interactivity.comment.utils;

import com.bytedance.android.live.base.model.message.m0;
import com.bytedance.android.live.base.model.message.v0;
import com.bytedance.android.livesdkapi.message.MessageIdentity;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes9.dex */
public final class l {
    public static final v0 a(long r100, com.bytedance.android.livesdk.chatroom.model.v0 r101) {
        Intrinsics.checkNotNullParameter(r101, "chatResult");
        v0 r102 = (v0) vh7.f.c(v0.class);
        m0 r103 = (m0) vh7.f.c(m0.class);
        r103.setRoomId(r100);
        r103.setShowMsg(true);
        r103.setMessageId(r101.getMsgId());
        r103.setMethod("WebcastEmojiChatMessage");
        r103.setDisplayText(r101.getDisplayText());
        Unit r104 = Unit.INSTANCE;
        r102.setBaseMessage(r103);
        r102.setEmojiContent(r101.getDisplayText());
        r102.setDefaultContent(r101.getContent());
        r102.setUserInfo(r101.getUser());
        r102.setMessageMethod("WebcastEmojiChatMessage");
        MessageIdentity r105 = new MessageIdentity();
        r105.setShowIdentity(r101.getShowIdentity());
        r105.setIdentityLabel(r101.getIdentityLabel());
        r102.setMessageIdentity(r105);
        return r102;
    }
}
