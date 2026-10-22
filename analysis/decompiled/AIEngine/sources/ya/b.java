package ya;

import android.content.Context;
import com.stepos.core.ota.confirm.InteractiveSessionRegistry;
import com.tonyodev.fetch2.NetworkType;
import com.tonyodev.fetch2.PrioritySort;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final class b {

    /* renamed from: a, reason: collision with root package name */
    public final Context f14180a;

    /* renamed from: b, reason: collision with root package name */
    public final String f14181b;

    /* renamed from: c, reason: collision with root package name */
    public final int f14182c;

    /* renamed from: d, reason: collision with root package name */
    public final long f14183d;

    /* renamed from: e, reason: collision with root package name */
    public final boolean f14184e;

    /* renamed from: f, reason: collision with root package name */
    public final jb.a f14185f;

    /* renamed from: g, reason: collision with root package name */
    public final NetworkType f14186g;
    public final hb.c h;

    /* renamed from: i, reason: collision with root package name */
    public final boolean f14187i;

    /* renamed from: j, reason: collision with root package name */
    public final boolean f14188j;

    /* renamed from: k, reason: collision with root package name */
    public final com.tonyodev.fetch2core.c f14189k;

    /* renamed from: l, reason: collision with root package name */
    public final boolean f14190l;

    /* renamed from: m, reason: collision with root package name */
    public final com.tonyodev.fetch2core.a f14191m;

    /* renamed from: n, reason: collision with root package name */
    public final PrioritySort f14192n;

    /* renamed from: o, reason: collision with root package name */
    public final long f14193o;

    /* renamed from: p, reason: collision with root package name */
    public final boolean f14194p;

    /* renamed from: q, reason: collision with root package name */
    public final int f14195q;
    public final boolean r;

    public b() {
        throw null;
    }

    public b(Context context, jb.a aVar, NetworkType networkType, hb.c cVar, com.tonyodev.fetch2core.c cVar2, com.tonyodev.fetch2core.a aVar2, PrioritySort prioritySort) {
        this.f14180a = context;
        this.f14181b = "ota_model_download";
        this.f14182c = 6;
        this.f14183d = 500L;
        this.f14184e = true;
        this.f14185f = aVar;
        this.f14186g = networkType;
        this.h = cVar;
        this.f14187i = true;
        this.f14188j = true;
        this.f14189k = cVar2;
        this.f14190l = true;
        this.f14191m = aVar2;
        this.f14192n = prioritySort;
        this.f14193o = InteractiveSessionRegistry.DEFAULT_TTL_MS;
        this.f14194p = true;
        this.f14195q = -1;
        this.r = true;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!b.class.equals(obj != null ? obj.getClass() : null)) {
            return false;
        }
        kotlin.jvm.internal.g.d(obj, "null cannot be cast to non-null type com.tonyodev.fetch2.FetchConfiguration");
        b bVar = (b) obj;
        return kotlin.jvm.internal.g.b(this.f14180a, bVar.f14180a) && kotlin.jvm.internal.g.b(this.f14181b, bVar.f14181b) && this.f14182c == bVar.f14182c && this.f14183d == bVar.f14183d && this.f14184e == bVar.f14184e && kotlin.jvm.internal.g.b(this.f14185f, bVar.f14185f) && this.f14186g == bVar.f14186g && kotlin.jvm.internal.g.b(this.h, bVar.h) && this.f14187i == bVar.f14187i && this.f14188j == bVar.f14188j && kotlin.jvm.internal.g.b(this.f14189k, bVar.f14189k) && this.f14190l == bVar.f14190l && kotlin.jvm.internal.g.b(this.f14191m, bVar.f14191m) && this.f14192n == bVar.f14192n && this.f14193o == bVar.f14193o && this.f14194p == bVar.f14194p && this.f14195q == bVar.f14195q && this.r == bVar.r;
    }

    public final int hashCode() {
        return Boolean.hashCode(this.r) + ai.onnxruntime.a.d(this.f14195q, ai.onnxruntime.a.f(a0.a.c((this.f14192n.hashCode() + ((this.f14191m.hashCode() + ai.onnxruntime.a.f(ai.onnxruntime.a.f((this.f14189k.hashCode() + ai.onnxruntime.a.f(ai.onnxruntime.a.f((this.h.hashCode() + ((this.f14186g.hashCode() + ((this.f14185f.hashCode() + ai.onnxruntime.a.f(a0.a.c((v1.d.a(this.f14180a.hashCode() * 31, 31, this.f14181b) + this.f14182c) * 31, this.f14183d, 31), 31, this.f14184e)) * 31)) * 31)) * 31, 31, this.f14187i), 31, this.f14188j)) * 31, 31, false), 31, this.f14190l)) * 31)) * 31, this.f14193o, 31), 31, this.f14194p), 31);
    }

    public final String toString() {
        StringBuilder sb2 = new StringBuilder("FetchConfiguration(appContext=");
        sb2.append(this.f14180a);
        sb2.append(", namespace='");
        sb2.append(this.f14181b);
        sb2.append("', concurrentLimit=");
        com.stepos.core.ota.d.s(sb2, this.f14182c, ", progressReportingIntervalMillis=", this.f14183d);
        sb2.append(", loggingEnabled=");
        sb2.append(this.f14184e);
        sb2.append(", httpDownloader=");
        sb2.append(this.f14185f);
        sb2.append(", globalNetworkType=");
        sb2.append(this.f14186g);
        sb2.append(", logger=");
        sb2.append(this.h);
        sb2.append(", autoStart=");
        sb2.append(this.f14187i);
        sb2.append(", retryOnNetworkGain=");
        sb2.append(this.f14188j);
        sb2.append(", fileServerDownloader=");
        sb2.append(this.f14189k);
        sb2.append(", hashCheckingEnabled=false, fileExistChecksEnabled=");
        sb2.append(this.f14190l);
        sb2.append(", storageResolver=");
        sb2.append(this.f14191m);
        sb2.append(", fetchNotificationManager=null, fetchDatabaseManager=null, backgroundHandler=null, prioritySort=");
        sb2.append(this.f14192n);
        a0.a.s(this.f14193o, ", internetCheckUrl=null, activeDownloadsCheckInterval=", ", createFileOnEnqueue=", sb2);
        sb2.append(this.f14194p);
        sb2.append(", preAllocateFileOnCreation=");
        sb2.append(this.r);
        sb2.append(", maxAutoRetryAttempts=");
        return ai.onnxruntime.a.j(", fetchHandler=null)", this.f14195q, sb2);
    }
}
