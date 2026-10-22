package com.stepos.core.ota.downloader;

import ad.n;
import android.content.Context;
import android.os.Handler;
import androidx.appcompat.widget.l;
import cb.i;
import cb.j;
import cb.v;
import cb.w;
import com.stepos.core.common.log.AIEngineLogger;
import com.stepos.core.common.log.LogModule;
import com.tonyodev.fetch2.Download;
import com.tonyodev.fetch2.Error;
import com.tonyodev.fetch2.NetworkType;
import com.tonyodev.fetch2.PrioritySort;
import com.tonyodev.fetch2.Request;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;
import kotlin.collections.EmptyList;
import kotlin.jvm.internal.Ref$ObjectRef;
import kotlin.jvm.internal.g;
import mb.m;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final class Fetch2DownloadEngine implements DownloadEngine {
    public static final Companion Companion = new Companion(null);
    private static final long PROGRESS_REPORTING_INTERVAL_MS = 500;
    private final String TAG;
    private final Fetch2DownloadEngine$bridgeListener$1 bridgeListener;
    private final ya.a fetch;
    private final CopyOnWriteArrayList<DownloadListener> listeners;

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    public static final class Companion {
        public /* synthetic */ Companion(kotlin.jvm.internal.e eVar) {
            this();
        }

        private Companion() {
        }
    }

    public Fetch2DownloadEngine(Context context) {
        j.b bVar;
        g.f(context, "context");
        this.TAG = "Fetch2DownloadEngine";
        this.listeners = new CopyOnWriteArrayList<>();
        Fetch2DownloadEngine$bridgeListener$1 fetch2DownloadEngine$bridgeListener$1 = new Fetch2DownloadEngine$bridgeListener$1(this);
        this.bridgeListener = fetch2DownloadEngine$bridgeListener$1;
        n.a aVar = new n.a();
        TimeUnit timeUnit = TimeUnit.SECONDS;
        aVar.b(30L, timeUnit);
        aVar.c(120L, timeUnit);
        aVar.f143d.add(new ThrottleInterceptor());
        n nVar = new n(aVar);
        Context appContext = context.getApplicationContext();
        NetworkType networkType = gb.b.f9098b;
        hb.c cVar = gb.b.f9104i;
        ya.c cVar2 = gb.b.h;
        g.e(appContext, "appContext");
        com.tonyodev.fetch2core.a aVar2 = new com.tonyodev.fetch2core.a(appContext, appContext.getFilesDir().getAbsoluteFile() + "/_fetchData/temp");
        PrioritySort prioritySort = gb.b.f9102f;
        jb.a aVar3 = new jb.a(nVar);
        int i10 = 1;
        if (cVar != null) {
            cVar.f9386a = true;
            if (g.b((String) cVar.f9387b, "fetch2")) {
                cVar.f9387b = "ota_model_download";
            }
        } else {
            cVar.f9386a = true;
        }
        ya.b bVar2 = new ya.b(appContext, aVar3, networkType, cVar, cVar2, aVar2, prioritySort);
        synchronized (j.f3347a) {
            try {
                LinkedHashMap linkedHashMap = j.f3348b;
                j.a aVar4 = (j.a) linkedHashMap.get("ota_model_download");
                int i11 = 2;
                if (aVar4 != null) {
                    bVar = new j.b(bVar2, aVar4.f3350a, aVar4.f3351b, aVar4.f3352c, aVar4.f3353d, aVar4.f3354e, aVar4.f3355f, aVar4.f3356g);
                } else {
                    hb.g gVar = new hb.g();
                    w wVar = new w();
                    ab.b bVar3 = new ab.b(i10, i11, i10);
                    int i12 = 3;
                    ab.c cVar3 = new ab.c(i11, i12, i11);
                    int i13 = 4;
                    ab.b bVar4 = new ab.b(i12, i13, i11);
                    int i14 = 5;
                    int i15 = 0;
                    int i16 = 6;
                    za.g gVar2 = new za.g(new za.f(appContext, cVar, new ab.a[]{bVar3, cVar3, bVar4, new ab.c(i13, i14, i15), new ab.b(i14, i16, i15), new ab.c(i16, 7, 1)}, wVar, new com.tonyodev.fetch2core.a(appContext, appContext.getFilesDir().getAbsoluteFile() + "/_fetchData/temp")));
                    androidx.lifecycle.b bVar5 = new androidx.lifecycle.b(gVar2, i16);
                    l lVar = new l(2);
                    fb.a aVar5 = new fb.a(bVar5);
                    Handler handler = j.f3349c;
                    v vVar = new v(aVar5, bVar5, handler);
                    bVar = new j.b(bVar2, gVar, gVar2, bVar5, aVar5, handler, lVar, vVar);
                    linkedHashMap.put("ota_model_download", new j.a(gVar, gVar2, bVar5, aVar5, handler, lVar, vVar, bVar.f3362f));
                }
                hb.g gVar3 = bVar.f3358b;
                synchronized (gVar3.f9395a) {
                    try {
                        if (!gVar3.f9396b) {
                            gVar3.f9397c++;
                        }
                        lb.n nVar2 = lb.n.f10413a;
                    } finally {
                    }
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        ya.b bVar6 = bVar.f3357a;
        String str = bVar6.f14181b;
        hb.g gVar4 = bVar.f3358b;
        i iVar = new i(str, bVar6, gVar4, bVar.f3360d, bVar.f3363g, bVar6.h, bVar.f3361e, bVar.f3359c);
        this.fetch = iVar;
        synchronized (iVar.f3343i) {
            iVar.c();
            gVar4.b(new android.llama.cpp.b(2, iVar, fetch2DownloadEngine$bridgeListener$1));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void enqueue$lambda$1(Fetch2DownloadEngine fetch2DownloadEngine, zb.l lVar, DownloadRequest downloadRequest, Request updated) {
        g.f(updated, "updated");
        AIEngineLogger.d(LogModule.OTA, fetch2DownloadEngine.TAG, a0.a.g("enqueue ok: id=", updated.getId(), " url=", updated.getUrl()));
        if (lVar != null) {
            lVar.invoke(new DownloadRequest(updated.getUrl(), updated.getFile(), updated.getGroupId(), downloadRequest.getAllowCellular(), updated.getId()));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void enqueue$lambda$2(Fetch2DownloadEngine fetch2DownloadEngine, zb.l lVar, Error error) {
        g.f(error, "error");
        AIEngineLogger.e(LogModule.OTA, fetch2DownloadEngine.TAG, "enqueue error: " + error.name());
        if (lVar != null) {
            lVar.invoke(new RuntimeException(ai.onnxruntime.a.k("Fetch2 enqueue error: ", error.name())));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Type inference failed for: r0v1, types: [T, java.util.ArrayList, java.util.Collection] */
    public static final void getDownloadsInGroup$lambda$4(Ref$ObjectRef ref$ObjectRef, CountDownLatch countDownLatch, Fetch2DownloadEngine fetch2DownloadEngine, List downloads) {
        g.f(downloads, "downloads");
        ?? arrayList = new ArrayList(m.Z(downloads, 10));
        Iterator it = downloads.iterator();
        while (it.hasNext()) {
            arrayList.add(fetch2DownloadEngine.toTask((Download) it.next()));
        }
        ref$ObjectRef.f10076a = arrayList;
        countDownLatch.countDown();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void notify(zb.l<? super DownloadListener, lb.n> lVar) {
        Iterator<DownloadListener> it = this.listeners.iterator();
        g.e(it, "iterator(...)");
        while (it.hasNext()) {
            DownloadListener next = it.next();
            try {
                g.c(next);
                lVar.invoke(next);
            } catch (Exception e10) {
                AIEngineLogger.e(LogModule.OTA, this.TAG, "listener error", e10);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final DownloadTask toTask(Download download) {
        return new DownloadTask(download.getId(), download.getGroup(), download.getUrl(), download.getFile(), download.getDownloaded(), download.getTotal(), download.getCreated());
    }

    @Override // com.stepos.core.ota.downloader.DownloadEngine
    public DownloadEngine addListener(DownloadListener listener) {
        g.f(listener, "listener");
        this.listeners.add(listener);
        return this;
    }

    @Override // com.stepos.core.ota.downloader.DownloadEngine
    public void cancelGroup(int i10) {
        this.fetch.cancelGroup(i10);
    }

    @Override // com.stepos.core.ota.downloader.DownloadEngine
    public void deleteGroup(int i10) {
        this.fetch.deleteGroup(i10);
    }

    @Override // com.stepos.core.ota.downloader.DownloadEngine
    public void enqueue(DownloadRequest request, zb.l<? super DownloadRequest, lb.n> lVar, zb.l<? super Throwable, lb.n> lVar2) {
        g.f(request, "request");
        Request request2 = new Request(request.getUrl(), request.getFile());
        request2.setGroupId(request.getGroupId());
        request2.setNetworkType(request.getAllowCellular() ? NetworkType.f8175d : NetworkType.f8176e);
        this.fetch.a(request2, new a(this, lVar, request), new b(this, lVar2));
    }

    /* JADX WARN: Type inference failed for: r3v0, types: [T, kotlin.collections.EmptyList] */
    @Override // com.stepos.core.ota.downloader.DownloadEngine
    public List<DownloadTask> getDownloadsInGroup(int i10) {
        CountDownLatch countDownLatch = new CountDownLatch(1);
        Ref$ObjectRef ref$ObjectRef = new Ref$ObjectRef();
        ref$ObjectRef.f10076a = EmptyList.f10001a;
        try {
            this.fetch.b(i10, new cb.e(ref$ObjectRef, countDownLatch, this, 2));
            if (!countDownLatch.await(2L, TimeUnit.SECONDS)) {
                AIEngineLogger.w(LogModule.OTA, this.TAG, "getDownloadsInGroup: timeout for " + i10);
            }
        } catch (Exception e10) {
            AIEngineLogger.e(LogModule.OTA, this.TAG, "getDownloadsInGroup error", e10);
        }
        return (List) ref$ObjectRef.f10076a;
    }

    @Override // com.stepos.core.ota.downloader.DownloadEngine
    public void pauseGroup(int i10) {
        this.fetch.pauseGroup(i10);
    }

    @Override // com.stepos.core.ota.downloader.DownloadEngine
    public void release() {
        this.fetch.h(this.bridgeListener);
        this.fetch.close();
    }

    @Override // com.stepos.core.ota.downloader.DownloadEngine
    public void removeListener(DownloadListener listener) {
        g.f(listener, "listener");
        this.listeners.remove(listener);
    }

    @Override // com.stepos.core.ota.downloader.DownloadEngine
    public void resumeGroup(int i10) {
        this.fetch.resumeGroup(i10);
    }
}
