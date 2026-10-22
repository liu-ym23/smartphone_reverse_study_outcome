package com.bytedance.android.livesdk.livecommerce.eventcenter;

import com.bytedance.android.ec.core.monitor.ECExceptionMonitor;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.CopyOnWriteArrayList;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes10.dex */
public final class LiveEventCenter implements d {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final Lazy f147750b = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final CopyOnWriteArrayList<d.a> f147751a;

    public static final class a {
        public static d a() {
            return (d) LiveEventCenter.f147750b.getValue();
        }
    }

    static {
        f147750b = LazyKt.lazy(LazyThreadSafetyMode.SYNCHRONIZED, LiveEventCenter$Companion$INSTANCE$2.INSTANCE);
    }

    public LiveEventCenter() {
        this.f147751a = new CopyOnWriteArrayList();
    }

    @Override // com.bytedance.android.livesdk.livecommerce.eventcenter.d
    public final synchronized void a(d.a r100) {
        monitor-enter(this);
        Intrinsics.checkNotNullParameter(r100, "listener");     // Catch: Throwable -> L8
        if (this.f147751a.contains(r100) == false) goto L6;
        this.f147751a.remove(r100);     // Catch: Throwable -> L8
    L6:
        monitor-exit(this);
        return;
    L8:
        th = move-exception;
        throw th;
    }

    @Override // com.bytedance.android.livesdk.livecommerce.eventcenter.d
    public final synchronized void b(d.a r100) {
        monitor-enter(this);
        Intrinsics.checkNotNullParameter(r100, "listener");     // Catch: Throwable -> L8
        if (this.f147751a.contains(r100) == true) goto L6;
        this.f147751a.add(r100);     // Catch: Throwable -> L8
    L6:
        monitor-exit(this);
        return;
    L8:
        th = move-exception;
        throw th;
    }

    @Override // com.bytedance.android.livesdk.livecommerce.eventcenter.d
    public final void sendEvent(String r100, Object r101) {
        Intrinsics.checkNotNullParameter(r100, "eventName");
        if (i.f147814a.contains(r100) == true) goto L5;
        xh.a r102 = xh.c.a("Live");
        Map r103 = MapsKt.mutableMapOf(new Pair[]{TuplesKt.to("eventName", r100), TuplesKt.to("params", r101)});
        xh.b r104 = new xh.b();
        r104.c(null);
        r104.b("LiveEventCenter");
        r104.a(r103);
        r102.f(3, r104);
    L5:
        Iterator r105 = CollectionsKt.toMutableList(this.f147751a).iterator();
    L7:
        if (r105.hasNext() == false) goto L13;
        ((d.a) r105.next()).a(r100, r101);     // Catch: Exception -> L11
    L11:
        e = move-exception;
        ECExceptionMonitor.e(e);
        goto L7
    }
}
