package com.bytedance.android.live.broadcastgame.opengame.behavior;

import com.bytedance.android.live.core.log.ALogger;
import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: classes45.dex */
public final class u<T> implements Consumer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ MiniGameToolbarBehavior f59793a;

    public u(MiniGameToolbarBehavior r100) {
        this.f59793a = r100;
    }

    @Override // io.reactivex.functions.Consumer
    public final void accept(Object r100) {
        Throwable r101 = (Throwable) r100;
        StringBuilder r102 = new StringBuilder("runConfigIconAnim fail error:");
        r102.append(r101.getMessage());
        r102.append(' ');
        Throwable r103 = r101.getCause();
        if (r103 == null) goto L5;
        String r104 = r103.getMessage();
    L6:
        r102.append(r104);
        ALogger.d("MiniGameToolbarAnim", r102.toString());
        this.f59793a.a();
        return;
    L5:
        r104 = null;
        goto L6
    }
}
