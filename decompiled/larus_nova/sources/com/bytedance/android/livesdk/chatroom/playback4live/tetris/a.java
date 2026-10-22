package com.bytedance.android.livesdk.chatroom.playback4live.tetris;

import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.room.api.IVisibilityControlService;
import com.bytedance.android.live.room.api.visibilitycontrol.LiveVisibilityControlContext;
import io.reactivex.functions.Consumer;
import kotlin.Unit;

/* JADX INFO: loaded from: classes7.dex */
public final class a<T> implements Consumer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ LivePlaybackTetris f107611a;

    public a(LivePlaybackTetris r100) {
        this.f107611a = r100;
    }

    @Override // io.reactivex.functions.Consumer
    public final void accept(Object r100) {
        Unit r101 = (Unit) r100;
        ALogger.d(LiveVisibilityControlContext.timerTag, "PlayerProgressBarTetris.kt # resetTimer # timer done, setPlayBackTetrisVisibleValue false");
        IVisibilityControlService r102 = this.f107611a.a0();
        if (r102 == null) goto L8;
        LiveVisibilityControlContext r103 = r102.provideContext();
        if (r103 == null) goto L9;
        r103.setPlaybackVisibleValue(false);
        return;
    L9:
        return;
    }
}
