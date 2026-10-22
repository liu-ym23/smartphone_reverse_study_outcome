package com.bytedance.android.livesdk.chatroom.replay.interactionmsg.danmaku.send.presenter;

import android.view.View;
import com.bytedance.android.livesdk.chatroom.replay.interactionmsg.danmaku.send.PanelType;
import com.bytedance.android.livesdk.chatroom.replay.interactionmsg.danmaku.send.VSInputPanelLayout;
import io.reactivex.functions.Consumer;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes7.dex */
public final class d<T> implements Consumer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ InputDanmuTextPresenter f109132a;

    public d(InputDanmuTextPresenter r100) {
        this.f109132a = r100;
    }

    @Override // io.reactivex.functions.Consumer
    public final void accept(Object r100) {
        PanelType r101 = (PanelType) r100;
        if (this.f109132a.h().getCurrentPanelType() != r101) goto L5;
        this.f109132a.h().b(PanelType.KEYBOARD, InputDanmuTextPresenter.n(this.f109132a));
        return;
    L5:
        PanelType r102 = PanelType.EMOJI;
        if (r101 != r102) goto L11;
        VSInputPanelLayout r103 = this.f109132a.h();
        r103.getClass();
        Intrinsics.checkNotNullParameter(r102, "panelType");
        View r104 = r103.f109078d.get(r102);
        if (r104 == null) goto L10;
        r104.setTag("click_emoji_icon");
    L10:
        this.f109132a.h().b(r102, InputDanmuTextPresenter.n(this.f109132a));
        return;
    L11:
        this.f109132a.h().b(r101, InputDanmuTextPresenter.n(this.f109132a));
    }
}
