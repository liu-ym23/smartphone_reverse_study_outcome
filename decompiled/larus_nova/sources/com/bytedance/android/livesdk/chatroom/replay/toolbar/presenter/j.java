package com.bytedance.android.livesdk.chatroom.replay.toolbar.presenter;

import com.bytedance.android.live.core.log.ALogger;
import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: classes7.dex */
public final class j<T> implements Consumer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ ReplayPortraitBottomToolbarPresenter f110165a;

    public j(ReplayPortraitBottomToolbarPresenter r100) {
        this.f110165a = r100;
    }

    @Override // io.reactivex.functions.Consumer
    public final void accept(Object r100) {
        Long r101 = (Long) r100;
        if (this.f110165a.f110136m == true) goto L6;
        ALogger.w("VS_TOOLBAR", "do onApplyButtonCountForMetricsZero in fallback after 400 ms");
        this.f110165a.l("fallback");
        return;
    }
}
