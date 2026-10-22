package com.stepos.statsapp.v3.lib.plugin.emitter.remote;

import android.os.RemoteException;
import android.util.Log;
import com.stepos.statsapp.v3.lib.plugin.IVccOfflineStatsCallback;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes3.dex */
class V3OfflineEmitter$VccOfflineStatsCallback extends IVccOfflineStatsCallback.Stub {
    final /* synthetic */ d this$0;

    private V3OfflineEmitter$VccOfflineStatsCallback(d dVar) {
        this.this$0 = dVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void lambda$onRealBulkInsertEvents$1(List list) {
        Log.d("V3OfflineEmitter", "onRealBulkInsertEvents thread:" + Thread.currentThread().getName());
        Iterator it = list.iterator();
        while (it.hasNext()) {
            this.this$0.f.f1385a.edit().remove(String.valueOf((Long) it.next()));
        }
        if (list.isEmpty()) {
            return;
        }
        this.this$0.f.f1385a.edit().commit();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void lambda$onRealInsertEvent$0(long j5) {
        Log.d("V3OfflineEmitter", "onRealInsertEvent thread:" + Thread.currentThread().getName());
        this.this$0.f.f1385a.edit().remove(String.valueOf(j5)).commit();
    }

    @Override // com.stepos.statsapp.v3.lib.plugin.IVccOfflineStatsCallback
    public void onRealBulkInsertEvents(String str, List list) throws RemoteException {
        W5.c.a("V3OfflineEmitter", "onRealBulkInsertEvents, eventIds:" + Arrays.toString(list.toArray()));
        this.this$0.e.execute(new b(0, this, list));
    }

    @Override // com.stepos.statsapp.v3.lib.plugin.IVccOfflineStatsCallback
    public void onRealInsertEvent(String str, final long j5) throws RemoteException {
        W5.c.a("V3OfflineEmitter", "onRealInsertEvent2Remote, eventId:" + j5);
        this.this$0.e.execute(new Runnable() { // from class: com.stepos.statsapp.v3.lib.plugin.emitter.remote.a
            @Override // java.lang.Runnable
            public final void run() {
                this.f3969a.lambda$onRealInsertEvent$0(j5);
            }
        });
    }

    @Override // com.stepos.statsapp.v3.lib.plugin.IVccOfflineStatsCallback
    public void onRealInsertH5Event(String str, long j5) throws RemoteException {
    }

    public /* synthetic */ V3OfflineEmitter$VccOfflineStatsCallback(d dVar, c cVar) {
        this(dVar);
    }
}
