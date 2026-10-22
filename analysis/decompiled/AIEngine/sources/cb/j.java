package cb;

import android.os.Handler;
import android.os.Looper;
import com.tonyodev.fetch2.NetworkType;
import com.tonyodev.fetch2.database.DownloadInfo;
import java.util.LinkedHashMap;
import za.e;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final class j {

    /* renamed from: a, reason: collision with root package name */
    public static final Object f3347a = new Object();

    /* renamed from: b, reason: collision with root package name */
    public static final LinkedHashMap f3348b = new LinkedHashMap();

    /* renamed from: c, reason: collision with root package name */
    public static final Handler f3349c = new Handler(Looper.getMainLooper());

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    public static final class a {

        /* renamed from: a, reason: collision with root package name */
        public final hb.g f3350a;

        /* renamed from: b, reason: collision with root package name */
        public final za.g f3351b;

        /* renamed from: c, reason: collision with root package name */
        public final androidx.lifecycle.b f3352c;

        /* renamed from: d, reason: collision with root package name */
        public final fb.a f3353d;

        /* renamed from: e, reason: collision with root package name */
        public final Handler f3354e;

        /* renamed from: f, reason: collision with root package name */
        public final androidx.appcompat.widget.l f3355f;

        /* renamed from: g, reason: collision with root package name */
        public final v f3356g;
        public final fb.b h;

        public a(hb.g gVar, za.g gVar2, androidx.lifecycle.b bVar, fb.a aVar, Handler uiHandler, androidx.appcompat.widget.l lVar, v vVar, fb.b networkInfoProvider) {
            kotlin.jvm.internal.g.f(uiHandler, "uiHandler");
            kotlin.jvm.internal.g.f(networkInfoProvider, "networkInfoProvider");
            this.f3350a = gVar;
            this.f3351b = gVar2;
            this.f3352c = bVar;
            this.f3353d = aVar;
            this.f3354e = uiHandler;
            this.f3355f = lVar;
            this.f3356g = vVar;
            this.h = networkInfoProvider;
        }

        public final boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof a)) {
                return false;
            }
            a aVar = (a) obj;
            return kotlin.jvm.internal.g.b(this.f3350a, aVar.f3350a) && kotlin.jvm.internal.g.b(this.f3351b, aVar.f3351b) && kotlin.jvm.internal.g.b(this.f3352c, aVar.f3352c) && kotlin.jvm.internal.g.b(this.f3353d, aVar.f3353d) && kotlin.jvm.internal.g.b(this.f3354e, aVar.f3354e) && kotlin.jvm.internal.g.b(this.f3355f, aVar.f3355f) && kotlin.jvm.internal.g.b(this.f3356g, aVar.f3356g) && kotlin.jvm.internal.g.b(this.h, aVar.h);
        }

        public final int hashCode() {
            return this.h.hashCode() + ((this.f3356g.hashCode() + ((this.f3355f.hashCode() + ((this.f3354e.hashCode() + ((this.f3353d.hashCode() + ((this.f3352c.hashCode() + ((this.f3351b.hashCode() - 1336972353) * 31)) * 31)) * 31)) * 31)) * 31)) * 31);
        }

        public final String toString() {
            return "Holder(handlerWrapper=" + this.f3350a + ", fetchDatabaseManagerWrapper=" + this.f3351b + ", downloadProvider=" + this.f3352c + ", groupInfoProvider=" + this.f3353d + ", uiHandler=" + this.f3354e + ", downloadManagerCoordinator=" + this.f3355f + ", listenerCoordinator=" + this.f3356g + ", networkInfoProvider=" + this.h + ")";
        }
    }

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    public static final class b {

        /* renamed from: a, reason: collision with root package name */
        public final ya.b f3357a;

        /* renamed from: b, reason: collision with root package name */
        public final hb.g f3358b;

        /* renamed from: c, reason: collision with root package name */
        public final za.g f3359c;

        /* renamed from: d, reason: collision with root package name */
        public final Handler f3360d;

        /* renamed from: e, reason: collision with root package name */
        public final v f3361e;

        /* renamed from: f, reason: collision with root package name */
        public final fb.b f3362f;

        /* renamed from: g, reason: collision with root package name */
        public final cb.a f3363g;

        /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
        public static final class a implements e.a<DownloadInfo> {
            public a() {
            }

            @Override // za.e.a
            public final void a(DownloadInfo downloadInfo) {
                com.tonyodev.fetch2core.a aVar = b.this.f3357a.f14191m;
                gb.c.d(downloadInfo, "GET");
                gb.c.a(downloadInfo.getId(), aVar.f8231b);
            }
        }

        public b(ya.b bVar, hb.g gVar, za.g gVar2, androidx.lifecycle.b bVar2, fb.a aVar, Handler uiHandler, androidx.appcompat.widget.l lVar, v vVar) {
            kotlin.jvm.internal.g.f(uiHandler, "uiHandler");
            this.f3357a = bVar;
            this.f3358b = gVar;
            this.f3359c = gVar2;
            this.f3360d = uiHandler;
            this.f3361e = vVar;
            stepos.support.v7.app.palette.b bVar3 = new stepos.support.v7.app.palette.b(gVar2, 5);
            fb.b bVar4 = new fb.b(bVar.f14180a);
            this.f3362f = bVar4;
            bb.a aVar2 = new bb.a(bVar.f14185f, bVar.f14182c, bVar.f14183d, bVar.h, bVar4, bVar.f14188j, bVar3, lVar, vVar, bVar.f14189k, bVar.f14191m, bVar.f14181b, aVar, bVar.f14195q, bVar.r);
            db.d dVar = new db.d(gVar, bVar2, aVar2, bVar4, bVar.h, vVar, bVar.f14182c, bVar.f14181b, bVar.f14192n);
            aVar2.f3171t = dVar;
            NetworkType networkType = bVar.f14186g;
            kotlin.jvm.internal.g.f(networkType, "<set-?>");
            dVar.f8446n = networkType;
            this.f3363g = new cb.b(bVar.f14181b, gVar2, aVar2, dVar, bVar.h, bVar.f14187i, bVar.f14185f, bVar.f14189k, vVar, uiHandler, bVar.f14191m, aVar, bVar.f14192n, bVar.f14194p);
            gVar2.k0(new a());
        }
    }

    public static void a(String namespace) {
        int i10;
        kotlin.jvm.internal.g.f(namespace, "namespace");
        synchronized (f3347a) {
            try {
                LinkedHashMap linkedHashMap = f3348b;
                a aVar = (a) linkedHashMap.get(namespace);
                if (aVar != null) {
                    hb.g gVar = aVar.f3350a;
                    synchronized (gVar.f9395a) {
                        try {
                            if (gVar.f9396b) {
                                lb.n nVar = lb.n.f10413a;
                            } else {
                                int i11 = gVar.f9397c;
                                if (i11 != 0) {
                                    gVar.f9397c = i11 - 1;
                                    lb.n nVar2 = lb.n.f10413a;
                                }
                            }
                        } finally {
                        }
                    }
                    hb.g gVar2 = aVar.f3350a;
                    synchronized (gVar2.f9395a) {
                        i10 = !gVar2.f9396b ? gVar2.f9397c : 0;
                    }
                    if (i10 == 0) {
                        aVar.f3350a.a();
                        aVar.f3356g.a();
                        fb.a aVar2 = aVar.f3353d;
                        synchronized (aVar2.f8780b) {
                            aVar2.f8781c.clear();
                            lb.n nVar3 = lb.n.f10413a;
                        }
                        aVar.f3351b.close();
                        aVar.f3355f.k();
                        aVar.h.c();
                        linkedHashMap.remove(namespace);
                    }
                }
                lb.n nVar4 = lb.n.f10413a;
            } catch (Throwable th) {
                throw th;
            }
        }
    }
}
