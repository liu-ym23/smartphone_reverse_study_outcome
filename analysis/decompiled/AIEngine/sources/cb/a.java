package cb;

import com.stepos.core.ota.downloader.Fetch2DownloadEngine$bridgeListener$1;
import com.tonyodev.fetch2.Download;
import java.io.Closeable;
import java.util.ArrayList;
import java.util.List;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public interface a extends Closeable {
    ArrayList B0(List list);

    ArrayList O(int i10);

    boolean Z(boolean z);

    ArrayList cancelGroup(int i10);

    List<Download> deleteGroup(int i10);

    List<Download> getDownloadsInGroup(int i10);

    void h(ya.f fVar);

    void r0(Fetch2DownloadEngine$bridgeListener$1 fetch2DownloadEngine$bridgeListener$1);

    ArrayList resumeGroup(int i10);

    void t0();
}
