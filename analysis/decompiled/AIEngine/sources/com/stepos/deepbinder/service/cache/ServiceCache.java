package com.stepos.deepbinder.service.cache;

import android.os.IBinder;
import android.util.Pair;
import com.stepos.core.ability.c;
import com.stepos.deepbinder.core.api.IRecycle;
import com.stepos.deepbinder.core.log.IPCLog;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.jvm.internal.g;
import lb.n;
import mb.q;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final class ServiceCache {

    /* renamed from: b, reason: collision with root package name */
    public static final a f7640b = new a();

    /* renamed from: c, reason: collision with root package name */
    public static volatile ServiceCache f7641c;

    /* renamed from: a, reason: collision with root package name */
    public final ConcurrentHashMap<Pair<Integer, String>, b> f7642a = new ConcurrentHashMap<>();

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    @f.a
    public static final class ProxyProcessBinderDeathRecipient implements IBinder.DeathRecipient {
        public static final a Companion = new a();
        private static final String TAG = "ProxyProcessBinderDeathRecipient";
        private final IBinder binder;
        private final int pid;

        /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
        public static final class a {
        }

        public ProxyProcessBinderDeathRecipient(IBinder binder, int i10) {
            g.f(binder, "binder");
            this.binder = binder;
            this.pid = i10;
        }

        @Override // android.os.IBinder.DeathRecipient
        public void binderDied() {
            try {
                this.binder.unlinkToDeath(this, 0);
                synchronized (ProxyProcessBinderDeathRecipient.class) {
                    ServiceCache serviceCacheA = ServiceCache.f7640b.a();
                    int i10 = this.pid;
                    Set<Map.Entry<Pair<Integer, String>, b>> setEntrySet = serviceCacheA.f7642a.entrySet();
                    g.e(setEntrySet, "<get-entries>(...)");
                    q.h0(setEntrySet, new c(i10, serviceCacheA));
                    n nVar = n.f10413a;
                }
            } catch (Throwable th) {
                IPCLog.INSTANCE.w(TAG, "[binderDied]", th);
            }
        }
    }

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    public static final class a {
        public final ServiceCache a() {
            ServiceCache serviceCache;
            ServiceCache serviceCache2 = ServiceCache.f7641c;
            if (serviceCache2 != null) {
                return serviceCache2;
            }
            synchronized (this) {
                serviceCache = ServiceCache.f7641c;
                if (serviceCache == null) {
                    serviceCache = new ServiceCache();
                    ServiceCache.f7641c = serviceCache;
                }
            }
            return serviceCache;
        }
    }

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    public static final class b {

        /* renamed from: a, reason: collision with root package name */
        public String f7643a;

        /* renamed from: b, reason: collision with root package name */
        public String f7644b;

        /* renamed from: c, reason: collision with root package name */
        public boolean f7645c;

        /* renamed from: d, reason: collision with root package name */
        public String f7646d;

        /* renamed from: e, reason: collision with root package name */
        public IBinder f7647e;

        /* renamed from: f, reason: collision with root package name */
        public Object f7648f;

        /* renamed from: g, reason: collision with root package name */
        public Class<?> f7649g;

        public final boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof b)) {
                return false;
            }
            b bVar = (b) obj;
            return g.b(this.f7643a, bVar.f7643a) && g.b(this.f7644b, bVar.f7644b) && this.f7645c == bVar.f7645c && g.b(this.f7646d, bVar.f7646d) && g.b(this.f7647e, bVar.f7647e) && g.b(this.f7648f, bVar.f7648f) && g.b(this.f7649g, bVar.f7649g);
        }

        public final int hashCode() {
            String str = this.f7643a;
            int iHashCode = (str == null ? 0 : str.hashCode()) * 31;
            String str2 = this.f7644b;
            int iF = ai.onnxruntime.a.f((iHashCode + (str2 == null ? 0 : str2.hashCode())) * 31, 31, this.f7645c);
            String str3 = this.f7646d;
            int iHashCode2 = (iF + (str3 == null ? 0 : str3.hashCode())) * 31;
            IBinder iBinder = this.f7647e;
            int iHashCode3 = (iHashCode2 + (iBinder == null ? 0 : iBinder.hashCode())) * 31;
            Object obj = this.f7648f;
            int iHashCode4 = (iHashCode3 + (obj == null ? 0 : obj.hashCode())) * 31;
            Class<?> cls = this.f7649g;
            return iHashCode4 + (cls != null ? cls.hashCode() : 0);
        }

        public final String toString() {
            return "ServiceContext(callerPackageName=" + this.f7643a + ", callerProcessName=" + this.f7644b + ", isSingleton=" + this.f7645c + ", methodId=" + this.f7646d + ", proxyStateBinder=" + this.f7647e + ", service=" + this.f7648f + ", serviceClass=" + this.f7649g + ')';
        }
    }

    public static void b(b bVar) {
        if (bVar == null || bVar.f7645c) {
            return;
        }
        Object obj = bVar.f7648f;
        IRecycle iRecycle = obj instanceof IRecycle ? (IRecycle) obj : null;
        if (iRecycle != null) {
            iRecycle.onRecycle();
        }
        bVar.f7649g = null;
        bVar.f7648f = null;
        bVar.f7643a = null;
        bVar.f7646d = null;
        bVar.f7647e = null;
    }

    /* JADX WARN: Removed duplicated region for block: B:24:0x004c A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void a(int r4, java.lang.String r5, com.stepos.deepbinder.service.cache.ServiceCache.b r6) {
        /*
            r3 = this;
            java.lang.String r0 = "key"
            kotlin.jvm.internal.g.f(r5, r0)
            java.lang.String r0 = "context"
            kotlin.jvm.internal.g.f(r6, r0)
            android.util.Pair r0 = new android.util.Pair
            java.lang.Integer r1 = java.lang.Integer.valueOf(r4)
            r0.<init>(r1, r5)
            java.util.concurrent.ConcurrentHashMap<android.util.Pair<java.lang.Integer, java.lang.String>, com.stepos.deepbinder.service.cache.ServiceCache$b> r3 = r3.f7642a
            java.util.Set r5 = r3.keySet()
            java.lang.String r1 = "<get-keys>(...)"
            kotlin.jvm.internal.g.e(r5, r1)
            java.lang.Iterable r5 = (java.lang.Iterable) r5
            boolean r1 = r5 instanceof java.util.Collection
            if (r1 == 0) goto L2e
            r1 = r5
            java.util.Collection r1 = (java.util.Collection) r1
            boolean r1 = r1.isEmpty()
            if (r1 == 0) goto L2e
            goto L4c
        L2e:
            java.util.Iterator r5 = r5.iterator()
        L32:
            boolean r1 = r5.hasNext()
            if (r1 == 0) goto L4c
            java.lang.Object r1 = r5.next()
            android.util.Pair r1 = (android.util.Pair) r1
            java.lang.Object r1 = r1.first
            java.lang.Integer r1 = (java.lang.Integer) r1
            if (r1 != 0) goto L45
            goto L32
        L45:
            int r1 = r1.intValue()
            if (r1 != r4) goto L32
            goto L6a
        L4c:
            android.os.IBinder r5 = r6.f7647e     // Catch: java.lang.Throwable -> L5a
            if (r5 == 0) goto L6a
            com.stepos.deepbinder.service.cache.ServiceCache$ProxyProcessBinderDeathRecipient r1 = new com.stepos.deepbinder.service.cache.ServiceCache$ProxyProcessBinderDeathRecipient     // Catch: java.lang.Throwable -> L5a
            r1.<init>(r5, r4)     // Catch: java.lang.Throwable -> L5a
            r4 = 0
            r5.linkToDeath(r1, r4)     // Catch: java.lang.Throwable -> L5a
            goto L6a
        L5a:
            r4 = move-exception
            com.stepos.deepbinder.core.log.IPCLog r5 = com.stepos.deepbinder.core.log.IPCLog.INSTANCE
            java.lang.String r1 = "exception"
            java.lang.Object[] r4 = new java.lang.Object[]{r1, r4}
            java.lang.String r1 = "ServiceCache"
            java.lang.String r2 = "[putService][linkToDeath]"
            r5.w(r1, r2, r4)
        L6a:
            r3.put(r0, r6)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stepos.deepbinder.service.cache.ServiceCache.a(int, java.lang.String, com.stepos.deepbinder.service.cache.ServiceCache$b):void");
    }

    public final void c(int i10, long[] jArr) {
        IPCLog.INSTANCE.d("ServiceCache", "removeService " + jArr, new Object[0]);
        for (long j10 : jArr) {
            b(this.f7642a.remove(new Pair(Integer.valueOf(i10), String.valueOf(j10))));
        }
    }
}
