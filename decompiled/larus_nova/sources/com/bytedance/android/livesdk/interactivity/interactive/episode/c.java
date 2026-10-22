package com.bytedance.android.livesdk.interactivity.interactive.episode;

import com.bytedance.ies.sdk.widgets.KVData;
import com.larus.apm.impl.protector.RunnableProtector;

/* JADX INFO: loaded from: classes9.dex */
public final class c implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ EpisodeInteractiveDialog f137401a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ KVData f137402b;

    public c(EpisodeInteractiveDialog r100, KVData r101) {
        this.f137401a = r100;
        this.f137402b = r101;
    }

    @Override // java.lang.Runnable
    public final void run() {
        KVData r100 = this.f137402b;     // Catch: Throwable -> L11
        if (r100 == null) goto L14;
        String r101 = r100.getKey();     // Catch: Throwable -> L11
        if (r101.hashCode() == 364236116) goto L8;
        return;
    L8:
        if (r101.equals("data_live_screen_orientation_change") == false) goto L19;
        EpisodeInteractiveDialog r102 = this.f137401a;     // Catch: Throwable -> L11
        int r103 = EpisodeInteractiveDialog.f137368l;     // Catch: Throwable -> L11
        r102.b();     // Catch: Throwable -> L11
        return;
    L19:
        return;
    L14:
        return;
    L11:
        th = move-exception;
        if (RunnableProtector.intercept(th) == true) goto L20;
        throw th;
    }
}
