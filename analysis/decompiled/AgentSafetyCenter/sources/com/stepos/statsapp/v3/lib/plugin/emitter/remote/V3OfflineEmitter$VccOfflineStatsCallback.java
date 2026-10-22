package com.stepos.statsapp.v3.lib.plugin.emitter.remote;

import android.util.Log;
import com.stepos.statsapp.v3.lib.plugin.IVccOfflineStatsCallback;
import java.lang.invoke.VarHandle;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ThreadPoolExecutor;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
class V3OfflineEmitter$VccOfflineStatsCallback extends IVccOfflineStatsCallback.Stub {
    final /* synthetic */ f this$0;

    private V3OfflineEmitter$VccOfflineStatsCallback(f fVar) {
        this.this$0 = fVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void lambda$onRealBulkInsertEvents$1(List list) {
        Log.d("V3OfflineEmitter", "onRealBulkInsertEvents thread:" + Thread.currentThread().getName());
        Iterator it = list.iterator();
        while (it.hasNext()) {
            this.this$0.f2835f.f13291a.edit().remove(String.valueOf((Long) it.next()));
        }
        if (list.isEmpty()) {
            return;
        }
        this.this$0.f2835f.f13291a.edit().commit();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void lambda$onRealInsertEvent$0(long j10) {
        Log.d("V3OfflineEmitter", "onRealInsertEvent thread:" + Thread.currentThread().getName());
        this.this$0.f2835f.f13291a.edit().remove(String.valueOf(j10)).commit();
    }

    @Override // com.stepos.statsapp.v3.lib.plugin.IVccOfflineStatsCallback
    public void onRealBulkInsertEvents(String str, List list) {
        ua.c.a("V3OfflineEmitter", "onRealBulkInsertEvents, eventIds:" + Arrays.toString(list.toArray()));
        ThreadPoolExecutor threadPoolExecutor = this.this$0.f2834e;
        d dVar = new d(0);
        dVar.f2827f = this;
        dVar.f2828g = list;
        VarHandle.storeStoreFence();
        threadPoolExecutor.execute(dVar);
    }

    @Override // com.stepos.statsapp.v3.lib.plugin.IVccOfflineStatsCallback
    public void onRealInsertEvent(String str, long j10) {
        ua.c.a("V3OfflineEmitter", "onRealInsertEvent2Remote, eventId:" + j10);
        ThreadPoolExecutor threadPoolExecutor = this.this$0.f2834e;
        c cVar = new c();
        cVar.f2824c = this;
        cVar.f2825f = j10;
        VarHandle.storeStoreFence();
        threadPoolExecutor.execute(cVar);
    }

    public /* synthetic */ V3OfflineEmitter$VccOfflineStatsCallback(f fVar, e eVar) {
        this(fVar);
    }

    @Override // com.stepos.statsapp.v3.lib.plugin.IVccOfflineStatsCallback
    public void onRealInsertH5Event(String str, long j10) {
    }
}
