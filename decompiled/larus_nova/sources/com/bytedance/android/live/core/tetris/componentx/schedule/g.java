package com.bytedance.android.live.core.tetris.componentx.schedule;

import com.bytedance.android.live.core.log.ALogger;
import com.larus.apm.impl.protector.RunnableProtector;
import kotlin.collections.CollectionsKt;

/* JADX INFO: loaded from: classes45.dex */
public final class g implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ i f65602a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ long f65603b;

    public g(i r100, long r101) {
        this.f65602a = r100;
        this.f65603b = r101;
    }

    public final void a() {
        String r100 = this.f65602a.f65605b;
        StringBuilder r101 = new StringBuilder("loadedbatch = ");
        i r102 = this.f65602a;
        if (r102.f65606c.isEmpty() == false) goto L5;
        Integer r103 = null;
    L6:
        r101.append(r103);
        r101.append(" ____  loadingbatch = ");
        r101.append(this.f65602a.f65607d);
        r101.append(" __  batchLoadDelayTime = ");
        r101.append(this.f65603b);
        ALogger.i(r100, r101.toString());
        b r104 = this.f65602a.b();
        if (r104 == null) goto L10;
        r104.b(this.f65602a.f65607d, BatchTogetherConditionManager.BatchLoadConditionType.END_DELAY_TIME);
        return;
    L10:
        return;
    L5:
        r103 = (Integer) CollectionsKt.last(r102.f65606c.keySet());
        goto L6
    }

    @Override // java.lang.Runnable
    public final void run() {
        a();     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L8;
        return;
    L8:
        throw th;
    }
}
