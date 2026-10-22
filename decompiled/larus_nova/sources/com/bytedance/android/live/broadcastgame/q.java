package com.bytedance.android.live.broadcastgame;

import com.ss.android.ugc.aweme.debug.LocalTestManager;
import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: classes45.dex */
public final class q<T> implements Consumer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ AudienceMagicBoxBehavior f61762a;

    public q(AudienceMagicBoxBehavior r100) {
        this.f61762a = r100;
    }

    @Override // io.reactivex.functions.Consumer
    public final void accept(Object r100) {
        Throwable r101 = (Throwable) r100;
        AudienceMagicBoxBehavior.b(this.f61762a);
        LocalTestManager.a(new Class[]{wy.a.class});
    }
}
