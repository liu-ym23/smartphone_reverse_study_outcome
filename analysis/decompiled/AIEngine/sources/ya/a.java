package ya;

import cb.i;
import com.tonyodev.fetch2.Request;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public interface a {
    i a(Request request, com.stepos.core.ota.downloader.a aVar, com.stepos.core.ota.downloader.b bVar);

    i b(int i10, cb.e eVar);

    i cancelGroup(int i10);

    void close();

    i deleteGroup(int i10);

    i h(f fVar);

    i pauseGroup(int i10);

    i resumeGroup(int i10);
}
