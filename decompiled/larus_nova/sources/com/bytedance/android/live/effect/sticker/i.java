package com.bytedance.android.live.effect.sticker;

import com.bytedance.android.livesdkapi.depend.model.Sticker;
import com.larus.apm.impl.protector.RunnableProtector;
import java.util.ArrayList;
import java.util.Iterator;

/* JADX INFO: loaded from: classes45.dex */
public final class i implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ LiveStickerDownloadHelper f68195a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ com.bytedance.android.live.effect.api.l.b f68196b;

    public i(LiveStickerDownloadHelper r100, com.bytedance.android.live.effect.api.l.b r101, Sticker r102) {
        this.f68195a = r100;
        this.f68196b = r101;
    }

    @Override // java.lang.Runnable
    public final void run() {
        com.bytedance.android.live.effect.api.l.b r100 = this.f68196b;     // Catch: Throwable -> L10
        if (r100 == null) goto L5;
        r100.b();     // Catch: Throwable -> L10
    L5:
        Iterator r101 = ((ArrayList) this.f68195a.f68139b).iterator();     // Catch: Throwable -> L10
    L6:
        if (r101.hasNext() == false) goto L18;
        ((com.bytedance.android.live.effect.api.l.b) r101.next()).b();     // Catch: Throwable -> L10
        goto L6
    L18:
        return;
    L10:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L14;
        return;
    L14:
        throw th;
    }
}
