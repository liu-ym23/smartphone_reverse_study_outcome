package com.bytedance.android.livesdk.announcement.highlight;

import com.bytedance.android.livesdk.announcement.u0;
import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: classes7.dex */
public final class g<T> implements Consumer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ AnnouncementHighlightAnchorServiceWidget f103477a;

    public g(AnnouncementHighlightAnchorServiceWidget r100) {
        this.f103477a = r100;
    }

    @Override // io.reactivex.functions.Consumer
    public final void accept(Object r100) {
        int r101 = u0.f103594a;
        u0.a.a(this.f103477a.context);
        int r102 = c0.f103470a;
        c0.c(com.bytedance.android.live.broadcastgame.api.openplatform.h.a((Throwable) r100));
    }
}
