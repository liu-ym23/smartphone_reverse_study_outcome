package com.stepos.statsapp.v3.lib.plugin.emitter.remote;

import android.os.RemoteException;
import android.util.Log;
import com.stepos.statsapp.v3.lib.plugin.IVccOfflineStatsCallback;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes.dex */
class V3OfflineEmitter$VccOfflineStatsCallback extends IVccOfflineStatsCallback.Stub {
    final /* synthetic */ e this$0;

    private V3OfflineEmitter$VccOfflineStatsCallback(e eVar) {
        this.this$0 = eVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void lambda$onRealBulkInsertEvents$1(List list) {
        Log.d("V3OfflineEmitter", "onRealBulkInsertEvents thread:" + Thread.currentThread().getName());
        Iterator it = list.iterator();
        while (it.hasNext()) {
            this.this$0.f12331f.f1791a.edit().remove(String.valueOf((Long) it.next()));
        }
        if (list.isEmpty()) {
            return;
        }
        this.this$0.f12331f.f1791a.edit().commit();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void lambda$onRealInsertEvent$0(long j4) {
        Log.d("V3OfflineEmitter", "onRealInsertEvent thread:" + Thread.currentThread().getName());
        this.this$0.f12331f.f1791a.edit().remove(String.valueOf(j4)).commit();
    }

    @Override // com.stepos.statsapp.v3.lib.plugin.IVccOfflineStatsCallback
    public void onRealBulkInsertEvents(String str, final List list) throws RemoteException {
        T2.d.a("V3OfflineEmitter", "onRealBulkInsertEvents, eventIds:" + Arrays.toString(list.toArray()));
        this.this$0.f12330e.execute(new Runnable() { // from class: com.stepos.statsapp.v3.lib.plugin.emitter.remote.c
            @Override // java.lang.Runnable
            public final void run() {
                this.f12323a.lambda$onRealBulkInsertEvents$1(list);
            }
        });
    }

    @Override // com.stepos.statsapp.v3.lib.plugin.IVccOfflineStatsCallback
    public void onRealInsertEvent(String str, final long j4) throws RemoteException {
        T2.d.a("V3OfflineEmitter", "onRealInsertEvent2Remote, eventId:" + j4);
        this.this$0.f12330e.execute(new Runnable() { // from class: com.stepos.statsapp.v3.lib.plugin.emitter.remote.b
            @Override // java.lang.Runnable
            public final void run() {
                this.f12321a.lambda$onRealInsertEvent$0(j4);
            }
        });
    }

    @Override // com.stepos.statsapp.v3.lib.plugin.IVccOfflineStatsCallback
    public void onRealInsertH5Event(String str, long j4) throws RemoteException {
    }

    public /* synthetic */ V3OfflineEmitter$VccOfflineStatsCallback(e eVar, d dVar) {
        this(eVar);
    }
}
