package jb;

import ad.n;
import ad.t;
import android.util.Log;
import com.tonyodev.fetch2core.Downloader;
import com.tonyodev.fetch2core.Extras;
import com.tonyodev.fetch2core.b;
import java.io.InputStream;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import kotlin.jvm.internal.g;
import mb.x;
import okhttp3.Response;
import okhttp3.h;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final class a implements Downloader<n, h> {

    /* renamed from: a, reason: collision with root package name */
    public final Downloader.FileDownloaderType f9762a = Downloader.FileDownloaderType.f8203a;

    /* renamed from: b, reason: collision with root package name */
    public final Map<Downloader.a, Response> f9763b;

    /* renamed from: c, reason: collision with root package name */
    public volatile n f9764c;

    public a(n nVar) {
        Map<Downloader.a, Response> mapSynchronizedMap = Collections.synchronizedMap(new HashMap());
        g.e(mapSynchronizedMap, "synchronizedMap(...)");
        this.f9763b = mapSynchronizedMap;
        this.f9764c = nVar;
    }

    @Override // com.tonyodev.fetch2core.Downloader
    public final Downloader.a D0(Downloader.b bVar, hb.h interruptMonitor) {
        g.f(interruptMonitor, "interruptMonitor");
        n client = this.f9764c;
        g.f(client, "client");
        h.a aVar = new h.a();
        aVar.e(bVar.f8212a);
        aVar.c(bVar.f8215d, null);
        for (Map.Entry entry : bVar.f8213b.entrySet()) {
            aVar.a((String) entry.getKey(), (String) entry.getValue());
        }
        h hVar = new h(aVar);
        if (hVar.a("Referer") == null) {
            String strM = b.m(bVar.f8212a);
            h.a aVarB = hVar.b();
            aVarB.a("Referer", strM);
            hVar = new h(aVarB);
        }
        Response responseD = this.f9764c.a(hVar).d();
        TreeMap treeMapF = responseD.h.f();
        int i10 = responseD.f10891d;
        if ((i10 == 302 || i10 == 301 || i10 == 303) && b.k(treeMapF, "Location") != null) {
            n client2 = this.f9764c;
            b.k(treeMapF, "Location");
            String url = bVar.f8212a;
            LinkedHashMap linkedHashMap = bVar.f8213b;
            String file = bVar.f8214c;
            String str = bVar.f8215d;
            Extras extras = bVar.f8216e;
            g.f(url, "url");
            g.f(file, "file");
            g.f(extras, "extras");
            g.f(client2, "client");
            h.a aVar2 = new h.a();
            aVar2.e(url);
            aVar2.c(str, null);
            for (Map.Entry entry2 : linkedHashMap.entrySet()) {
                aVar2.a((String) entry2.getKey(), (String) entry2.getValue());
            }
            h hVar2 = new h(aVar2);
            if (hVar2.a("Referer") == null) {
                String strM2 = b.m(bVar.f8212a);
                h.a aVarB2 = hVar2.b();
                aVarB2.a("Referer", strM2);
                hVar2 = new h(aVarB2);
            }
            try {
                responseD.close();
            } catch (Exception e10) {
                Log.d(e10.getMessage(), "Failed executing request.");
            }
            responseD = this.f9764c.a(hVar2).d();
            treeMapF = responseD.h.f();
            i10 = responseD.f10891d;
        }
        Response response = responseD;
        TreeMap treeMap = treeMapF;
        int i11 = i10;
        boolean z = response.r;
        long jF = b.f(treeMap);
        t tVar = response.f10893j;
        InputStream inputStreamF0 = tVar != null ? tVar.w().F0() : null;
        String strD = z ? null : b.d(inputStreamF0);
        String strK = b.k(kotlin.collections.b.o0(treeMap), "Content-MD5");
        if (strK == null) {
            strK = "";
        }
        Downloader.a aVar3 = new Downloader.a(i11, z, jF, inputStreamF0, bVar, strK, treeMap, b.a(i11, treeMap), strD);
        this.f9763b.put(aVar3, response);
        return aVar3;
    }

    @Override // com.tonyodev.fetch2core.Downloader
    public final void E(Downloader.a aVar) {
        Map<Downloader.a, Response> map = this.f9763b;
        if (map.containsKey(aVar)) {
            Response response = map.get(aVar);
            map.remove(aVar);
            if (response != null) {
                try {
                    response.close();
                } catch (Exception e10) {
                    e10.printStackTrace();
                }
            }
        }
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public final void close() {
        Map<Downloader.a, Response> map = this.f9763b;
        Iterator<T> it = map.entrySet().iterator();
        while (it.hasNext()) {
            Response response = (Response) ((Map.Entry) it.next()).getValue();
            if (response != null) {
                try {
                    response.close();
                } catch (Exception e10) {
                    e10.printStackTrace();
                }
            }
        }
        map.clear();
    }

    @Override // com.tonyodev.fetch2core.Downloader
    public final Downloader.FileDownloaderType q0(Downloader.b bVar, Set<? extends Downloader.FileDownloaderType> supportedFileDownloaderTypes) {
        g.f(supportedFileDownloaderTypes, "supportedFileDownloaderTypes");
        return this.f9762a;
    }

    @Override // com.tonyodev.fetch2core.Downloader
    public final Set<Downloader.FileDownloaderType> y0(Downloader.b bVar) {
        Downloader.FileDownloaderType fileDownloaderType = Downloader.FileDownloaderType.f8203a;
        Downloader.FileDownloaderType fileDownloaderType2 = this.f9762a;
        if (fileDownloaderType2 == fileDownloaderType) {
            return x.U(fileDownloaderType2);
        }
        try {
            return b.n(bVar, this);
        } catch (Exception unused) {
            return x.U(fileDownloaderType2);
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
