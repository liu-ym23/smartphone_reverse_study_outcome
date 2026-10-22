package com.bytedance.android.live.liveinteract.digitavatar.videoavatar;

import com.bytedance.android.live.liveinteract.digitavatar.DigitAvatarContext;
import com.bytedance.kmp.live.livelink.api.model.VideoShowMode;
import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: classes46.dex */
public final class r<T> implements Consumer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ o f72757a;

    public r(o r100) {
        this.f72757a = r100;
    }

    @Override // io.reactivex.functions.Consumer
    public final void accept(Object r100) {
        com.bytedance.android.livesdk.chatroom.viewmodel.j r101 = (com.bytedance.android.livesdk.chatroom.viewmodel.j) r100;
        if (this.f72757a.f72742l == VideoShowMode.DIGIT_AVATAR) goto L10;
        DigitAvatarContext r102 = DigitAvatarContext.Companion.getContext();
        if (r102 == null) goto L11;
        com.bytedance.live.datacontext.m<Boolean> r103 = r102.getUsedAvatarThisLinkRound();
        if (r103 == null) goto L12;
        r103.setValue(Boolean.FALSE);
        return;
    L12:
        return;
    L11:
        return;
    }
}
