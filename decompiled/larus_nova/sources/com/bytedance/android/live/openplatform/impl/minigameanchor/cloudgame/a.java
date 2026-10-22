package com.bytedance.android.live.openplatform.impl.minigameanchor.cloudgame;

import android.graphics.Rect;
import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: classes46.dex */
public final class a<T> implements Consumer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ LiveMgXplayRtcContextService f85172a;

    public a(LiveMgXplayRtcContextService r100) {
        this.f85172a = r100;
    }

    @Override // io.reactivex.functions.Consumer
    public final void accept(Object r100) {
        Rect r101 = (Rect) r100;
        ei6.a r102 = this.f85172a.f85162b;
        if (r102 == null) goto L8;
        vi6.a r103 = r102.v();
        if (r103 == null) goto L9;
        r103.f();
        return;
    L9:
        return;
    }
}
