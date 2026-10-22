package com.stepos.core.ota.downloader;

import com.tonyodev.fetch2.Download;
import com.tonyodev.fetch2.Error;
import com.tonyodev.fetch2core.DownloadBlock;
import java.util.List;
import kotlin.jvm.internal.g;
import lb.n;
import zb.l;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final class Fetch2DownloadEngine$bridgeListener$1 implements ya.f {
    final /* synthetic */ Fetch2DownloadEngine this$0;

    public Fetch2DownloadEngine$bridgeListener$1(Fetch2DownloadEngine fetch2DownloadEngine) {
        this.this$0 = fetch2DownloadEngine;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final n onAdded$lambda$0(Fetch2DownloadEngine fetch2DownloadEngine, Download download, DownloadListener it) {
        g.f(it, "it");
        it.onAdded(fetch2DownloadEngine.toTask(download));
        return n.f10413a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final n onCancelled$lambda$10(Fetch2DownloadEngine fetch2DownloadEngine, Download download, DownloadListener it) {
        g.f(it, "it");
        it.onCancelled(fetch2DownloadEngine.toTask(download));
        return n.f10413a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final n onCompleted$lambda$6(Fetch2DownloadEngine fetch2DownloadEngine, Download download, DownloadListener it) {
        g.f(it, "it");
        it.onCompleted(fetch2DownloadEngine.toTask(download));
        return n.f10413a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final n onDeleted$lambda$12(Fetch2DownloadEngine fetch2DownloadEngine, Download download, DownloadListener it) {
        g.f(it, "it");
        it.onDeleted(fetch2DownloadEngine.toTask(download));
        return n.f10413a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final n onDownloadBlockUpdated$lambda$4(Fetch2DownloadEngine fetch2DownloadEngine, Download download, DownloadListener it) {
        g.f(it, "it");
        it.onDownloadBlockUpdated(fetch2DownloadEngine.toTask(download));
        return n.f10413a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final n onError$lambda$7(Fetch2DownloadEngine fetch2DownloadEngine, Download download, Throwable th, Error error, DownloadListener it) {
        g.f(it, "it");
        DownloadTask task = fetch2DownloadEngine.toTask(download);
        if (th == null) {
            th = new RuntimeException(error.name());
        }
        it.onError(task, th);
        return n.f10413a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final n onPaused$lambda$8(Fetch2DownloadEngine fetch2DownloadEngine, Download download, DownloadListener it) {
        g.f(it, "it");
        it.onPaused(fetch2DownloadEngine.toTask(download));
        return n.f10413a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final n onProgress$lambda$5(Fetch2DownloadEngine fetch2DownloadEngine, Download download, long j10, long j11, DownloadListener it) {
        g.f(it, "it");
        it.onProgress(fetch2DownloadEngine.toTask(download), j10, j11);
        return n.f10413a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final n onQueued$lambda$1(Fetch2DownloadEngine fetch2DownloadEngine, Download download, boolean z, DownloadListener it) {
        g.f(it, "it");
        it.onQueued(fetch2DownloadEngine.toTask(download), z);
        return n.f10413a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final n onRemoved$lambda$11(Fetch2DownloadEngine fetch2DownloadEngine, Download download, DownloadListener it) {
        g.f(it, "it");
        it.onRemoved(fetch2DownloadEngine.toTask(download));
        return n.f10413a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final n onResumed$lambda$9(Fetch2DownloadEngine fetch2DownloadEngine, Download download, DownloadListener it) {
        g.f(it, "it");
        it.onResumed(fetch2DownloadEngine.toTask(download));
        return n.f10413a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final n onStarted$lambda$3(Fetch2DownloadEngine fetch2DownloadEngine, Download download, DownloadListener it) {
        g.f(it, "it");
        it.onStarted(fetch2DownloadEngine.toTask(download));
        return n.f10413a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final n onWaitingNetwork$lambda$2(Fetch2DownloadEngine fetch2DownloadEngine, Download download, DownloadListener it) {
        g.f(it, "it");
        it.onWaitingNetwork(fetch2DownloadEngine.toTask(download));
        return n.f10413a;
    }

    @Override // ya.f
    public void onAdded(Download download) {
        g.f(download, "download");
        Fetch2DownloadEngine fetch2DownloadEngine = this.this$0;
        fetch2DownloadEngine.notify(new c(fetch2DownloadEngine, download, 2));
    }

    @Override // ya.f
    public void onCancelled(Download download) {
        g.f(download, "download");
        Fetch2DownloadEngine fetch2DownloadEngine = this.this$0;
        fetch2DownloadEngine.notify(new c(fetch2DownloadEngine, download, 3));
    }

    @Override // ya.f
    public void onCompleted(Download download) {
        g.f(download, "download");
        Fetch2DownloadEngine fetch2DownloadEngine = this.this$0;
        fetch2DownloadEngine.notify(new d(fetch2DownloadEngine, download, 2));
    }

    @Override // ya.f
    public void onDeleted(Download download) {
        g.f(download, "download");
        Fetch2DownloadEngine fetch2DownloadEngine = this.this$0;
        fetch2DownloadEngine.notify(new d(fetch2DownloadEngine, download, 3));
    }

    @Override // ya.f
    public void onDownloadBlockUpdated(Download download, DownloadBlock downloadBlock, int i10) {
        g.f(download, "download");
        g.f(downloadBlock, "downloadBlock");
        Fetch2DownloadEngine fetch2DownloadEngine = this.this$0;
        fetch2DownloadEngine.notify(new c(fetch2DownloadEngine, download, 0));
    }

    @Override // ya.f
    public void onError(final Download download, final Error error, final Throwable th) {
        g.f(download, "download");
        g.f(error, "error");
        final Fetch2DownloadEngine fetch2DownloadEngine = this.this$0;
        fetch2DownloadEngine.notify(new l() { // from class: com.stepos.core.ota.downloader.f
            @Override // zb.l
            public final Object invoke(Object obj) {
                return Fetch2DownloadEngine$bridgeListener$1.onError$lambda$7(fetch2DownloadEngine, download, th, error, (DownloadListener) obj);
            }
        });
    }

    @Override // ya.f
    public void onPaused(Download download) {
        g.f(download, "download");
        Fetch2DownloadEngine fetch2DownloadEngine = this.this$0;
        fetch2DownloadEngine.notify(new c(fetch2DownloadEngine, download, 1));
    }

    @Override // ya.f
    public void onProgress(final Download download, final long j10, final long j11) {
        g.f(download, "download");
        final Fetch2DownloadEngine fetch2DownloadEngine = this.this$0;
        fetch2DownloadEngine.notify(new l() { // from class: com.stepos.core.ota.downloader.e
            @Override // zb.l
            public final Object invoke(Object obj) {
                return Fetch2DownloadEngine$bridgeListener$1.onProgress$lambda$5(fetch2DownloadEngine, download, j10, j11, (DownloadListener) obj);
            }
        });
    }

    @Override // ya.f
    public void onQueued(Download download, boolean z) {
        g.f(download, "download");
        Fetch2DownloadEngine fetch2DownloadEngine = this.this$0;
        fetch2DownloadEngine.notify(new com.stepos.core.model.manager.e(fetch2DownloadEngine, download, z));
    }

    public void onRemoved(Download download) {
        g.f(download, "download");
        Fetch2DownloadEngine fetch2DownloadEngine = this.this$0;
        fetch2DownloadEngine.notify(new c(fetch2DownloadEngine, download, 4));
    }

    @Override // ya.f
    public void onResumed(Download download) {
        g.f(download, "download");
        Fetch2DownloadEngine fetch2DownloadEngine = this.this$0;
        fetch2DownloadEngine.notify(new c(fetch2DownloadEngine, download, 5));
    }

    @Override // ya.f
    public void onStarted(Download download, List<? extends DownloadBlock> downloadBlocks, int i10) {
        g.f(download, "download");
        g.f(downloadBlocks, "downloadBlocks");
        Fetch2DownloadEngine fetch2DownloadEngine = this.this$0;
        fetch2DownloadEngine.notify(new d(fetch2DownloadEngine, download, 1));
    }

    @Override // ya.f
    public void onWaitingNetwork(Download download) {
        g.f(download, "download");
        Fetch2DownloadEngine fetch2DownloadEngine = this.this$0;
        fetch2DownloadEngine.notify(new d(fetch2DownloadEngine, download, 0));
    }
}
