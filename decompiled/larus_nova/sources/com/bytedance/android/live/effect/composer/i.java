package com.bytedance.android.live.effect.composer;

import com.bytedance.android.livesdkapi.depend.model.Sticker;
import com.larus.apm.impl.protector.RunnableProtector;

/* JADX INFO: loaded from: classes45.dex */
public final class i implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ Sticker f67949a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ n f67950b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ LiveComposerManagerB$restoreEffect$1 f67951c;

    public i(Sticker r100, n r101, LiveComposerManagerB$restoreEffect$1 r102) {
        this.f67949a = r100;
        this.f67950b = r101;
        this.f67951c = r102;
    }

    @Override // java.lang.Runnable
    public final void run() {
        boolean r100 = y50.c.f566205a;     // Catch: Throwable -> L4
        long r101 = y50.c.g("restore_effect_total_in_room");     // Catch: Throwable -> L4
        this.f67951c.invoke2(this.f67950b, this.f67949a);     // Catch: Throwable -> L4
        y50.c.h("restore_effect_total_in_room", r101);     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L8;
        return;
    L8:
        throw th;
    }
}
