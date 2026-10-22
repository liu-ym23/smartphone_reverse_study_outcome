package com.bytedance.android.live.liveinteract.revenue.adventure.linkcore;

import androidx.lifecycle.MutableLiveData;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.livesdkapi.LiveCommonConstants;
import com.bytedance.android.livesdkapi.roomplayer.ILivePlayerClient;
import com.bytedance.android.livesdkapi.roomplayer.IRoomEventHub;
import com.larus.apm.impl.protector.RunnableProtector;

/* JADX INFO: loaded from: classes46.dex */
public final class j implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ h f77953a;

    public j(h r100) {
        this.f77953a = r100;
    }

    @Override // java.lang.Runnable
    public final void run() {
        ALogger.i("AdventureMediaManager", LiveCommonConstants.REASON_ON_DEDTROY);     // Catch: Throwable -> L10
        ILivePlayerClient r100 = this.f77953a.f77949a;     // Catch: Throwable -> L10
        if (r100 == null) goto L13;
        IRoomEventHub r101 = r100.getEventHub();     // Catch: Throwable -> L10
        if (r101 == null) goto L17;
        MutableLiveData<Boolean> r102 = r101.getPlayerMute();     // Catch: Throwable -> L10
        if (r102 == null) goto L18;
        this.f77953a.getClass();     // Catch: Throwable -> L10
        r102.removeObserver(h.b.f77950a);     // Catch: Throwable -> L10
        return;
    L18:
        return;
    L17:
        return;
    L13:
        return;
    L10:
        th = move-exception;
        if (RunnableProtector.intercept(th) == true) goto L19;
        throw th;
    }
}
