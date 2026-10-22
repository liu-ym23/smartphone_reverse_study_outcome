package com.stepos.statsapp.v3.lib.plugin.emitter.remote;

import android.util.Log;
import com.stepos.core.ota.confirm.InteractiveSessionRegistry;
import com.stepos.statsapp.v3.lib.plugin.emitter.EmitterConfig;
import com.stepos.statsapp.v3.lib.plugin.emitter.remote.f;
import com.stepos.statsapp.v3.lib.plugin.payload.TrackerPayload;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Map;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final /* synthetic */ class a implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ V3OfflineEmitter f8022a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ boolean f8023b;

    public /* synthetic */ a(V3OfflineEmitter v3OfflineEmitter, boolean z) {
        this.f8022a = v3OfflineEmitter;
        this.f8023b = z;
    }

    @Override // java.lang.Runnable
    public final void run() {
        Log.d("V3OfflineEmitter", "addCachedEventsToRemote thread:" + Thread.currentThread().getName());
        ta.c.a("V3OfflineEmitter", "addCachedEventsToRemote begin");
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        V3OfflineEmitter v3OfflineEmitter = this.f8022a;
        sa.a aVar = v3OfflineEmitter.f8018f;
        for (Map.Entry<String, ?> entry : aVar.f11898a.getAll().entrySet()) {
            String key = entry.getKey();
            try {
                long j10 = Integer.parseInt(key);
                TrackerPayload trackerPayloadFromString = TrackerPayload.fromString((String) entry.getValue());
                if (trackerPayloadFromString != null) {
                    if (!this.f8023b) {
                        Object obj = trackerPayloadFromString.getHeaderMap().get("time");
                        if (obj instanceof Long) {
                            long jCurrentTimeMillis = System.currentTimeMillis() - ((Long) obj).longValue();
                            if (jCurrentTimeMillis < 0 || jCurrentTimeMillis >= InteractiveSessionRegistry.DEFAULT_TTL_MS) {
                            }
                        }
                    }
                    arrayList.add(Long.valueOf(j10));
                    arrayList2.add(trackerPayloadFromString);
                }
            } catch (Exception e10) {
                ta.c.b("V3OfflineEmitter", e10.getMessage());
                aVar.f11898a.edit().remove(key).apply();
            }
        }
        EmitterConfig emitterConfig = v3OfflineEmitter.f8004b;
        int i10 = 0;
        for (int i11 = 0; i11 < arrayList.size(); i11++) {
            if (i11 != 0 && i11 % 10 == 0) {
                i10++;
                int i12 = i11 - 10;
                f.b.f8038a.b(v3OfflineEmitter.f8003a, v3OfflineEmitter.h, emitterConfig.getAppId(), emitterConfig.getChannel(), arrayList.subList(i12, i11), arrayList2.subList(i12, i11));
                ta.c.a("V3OfflineEmitter", "addCachedEventToRemote 1, eventIds:" + Arrays.toString(arrayList.subList(i12, i11).toArray()));
            }
        }
        int i13 = i10 * 10;
        if (i13 < arrayList.size()) {
            int size = arrayList.size();
            f.b.f8038a.b(v3OfflineEmitter.f8003a, v3OfflineEmitter.h, emitterConfig.getAppId(), emitterConfig.getChannel(), arrayList.subList(i13, size), arrayList2.subList(i13, size));
            ta.c.a("V3OfflineEmitter", "addCachedEventToRemote 2, eventIds:" + Arrays.toString(arrayList.subList(i13, size).toArray()));
        }
        ta.c.a("V3OfflineEmitter", "addCachedEventsToRemote end");
    }
}
