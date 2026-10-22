package com.bytedance.android.livesdk.performance.aapleasure;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.Observer;
import com.bytedance.android.live.strategy.api.IStrategyService;
import com.larus.apm.impl.protector.RunnableProtector;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: loaded from: classes11.dex */
public final class e implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ f f154433a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Map f154434b;

    public static final class a<T> implements Observer {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ e f154435a;

        public a(e r100) {
            this.f154435a = r100;
        }

        @Override // androidx.lifecycle.Observer
        public final void onChanged(Object r100) {
            this.f154435a.f154433a.f154439d.clear();
            ConcurrentHashMap<String, Object> r101 = this.f154435a.f154433a.f154439d;
            r101.putAll((Map) r100);
            this.f154435a.f154433a.a(0);
        }
    }

    public e(f r100, Map r101) {
        this.f154433a = r100;
        this.f154434b = r101;
    }

    @Override // java.lang.Runnable
    public final void run() {
        IStrategyService r100 = (IStrategyService) jc1.k.f(IStrategyService.class);     // Catch: Throwable -> L8
        if (r100 == null) goto L11;
        LiveData r101 = IStrategyService.a.a(r100, this.f154433a.f154440e, this.f154434b, false, 12);     // Catch: Throwable -> L8
        if (r101 == null) goto L15;
        r101.observeForever(new a(this));     // Catch: Throwable -> L8
        return;
    L15:
        return;
    L11:
        return;
    L8:
        th = move-exception;
        if (RunnableProtector.intercept(th) == true) goto L16;
        throw th;
    }
}
