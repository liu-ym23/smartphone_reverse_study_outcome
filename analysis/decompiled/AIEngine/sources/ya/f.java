package ya;

import com.tonyodev.fetch2.Download;
import com.tonyodev.fetch2.Error;
import com.tonyodev.fetch2core.DownloadBlock;
import java.util.List;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public interface f {
    void onAdded(Download download);

    void onCancelled(Download download);

    void onCompleted(Download download);

    void onDeleted(Download download);

    void onDownloadBlockUpdated(Download download, DownloadBlock downloadBlock, int i10);

    void onError(Download download, Error error, Throwable th);

    void onPaused(Download download);

    void onProgress(Download download, long j10, long j11);

    void onQueued(Download download, boolean z);

    void onResumed(Download download);

    void onStarted(Download download, List<? extends DownloadBlock> list, int i10);

    void onWaitingNetwork(Download download);
}
