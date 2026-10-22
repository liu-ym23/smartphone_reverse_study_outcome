package ya;

import com.tonyodev.fetch2core.Downloader;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import mb.x;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final class c implements com.tonyodev.fetch2core.c {

    /* renamed from: a, reason: collision with root package name */
    public final Downloader.FileDownloaderType f14196a = Downloader.FileDownloaderType.f8203a;

    /* renamed from: b, reason: collision with root package name */
    public final Map<Downloader.a, ib.a> f14197b;

    public c() {
        Map<Downloader.a, ib.a> mapSynchronizedMap = Collections.synchronizedMap(new HashMap());
        kotlin.jvm.internal.g.e(mapSynchronizedMap, "synchronizedMap(...)");
        this.f14197b = mapSynchronizedMap;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:99:0x028e  */
    @Override // com.tonyodev.fetch2core.Downloader
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final com.tonyodev.fetch2core.Downloader.a D0(com.tonyodev.fetch2core.Downloader.b r28, hb.h r29) throws java.lang.NumberFormatException {
        /*
            Method dump skipped, instructions count: 725
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: ya.c.D0(com.tonyodev.fetch2core.Downloader$b, hb.h):com.tonyodev.fetch2core.Downloader$a");
    }

    @Override // com.tonyodev.fetch2core.Downloader
    public final void E(Downloader.a aVar) {
        Map<Downloader.a, ib.a> map = this.f14197b;
        if (map.containsKey(aVar)) {
            ib.a aVar2 = map.get(aVar);
            map.remove(aVar);
            if (aVar2 != null) {
                aVar2.a();
            }
        }
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public final void close() {
        Map<Downloader.a, ib.a> map = this.f14197b;
        try {
            Iterator<T> it = map.entrySet().iterator();
            while (it.hasNext()) {
                ((ib.a) ((Map.Entry) it.next()).getValue()).a();
            }
            map.clear();
        } catch (Exception unused) {
        }
    }

    @Override // com.tonyodev.fetch2core.Downloader
    public final Downloader.FileDownloaderType q0(Downloader.b bVar, Set<? extends Downloader.FileDownloaderType> supportedFileDownloaderTypes) {
        kotlin.jvm.internal.g.f(supportedFileDownloaderTypes, "supportedFileDownloaderTypes");
        return this.f14196a;
    }

    @Override // com.tonyodev.fetch2core.Downloader
    public final Set<Downloader.FileDownloaderType> y0(Downloader.b bVar) {
        try {
            return com.tonyodev.fetch2core.b.n(bVar, this);
        } catch (Exception unused) {
            return x.U(this.f14196a);
        }
    }

    @Override // com.tonyodev.fetch2core.Downloader
    public final void G(Downloader.b bVar) {
    }

    @Override // com.tonyodev.fetch2core.Downloader
    public final void L(Downloader.b bVar) {
    }

    @Override // com.tonyodev.fetch2core.Downloader
    public final void W(Downloader.b bVar) {
    }
}
