package android.llama.cpp;

import androidx.appcompat.widget.y0;
import cb.i;
import com.stepos.core.ota.downloader.Fetch2DownloadEngine$bridgeListener$1;
import com.stepos.deepbinder.service.cache.ServiceCache;
import com.tonyodev.fetch2.Download;
import java.lang.reflect.Constructor;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import kotlin.jvm.internal.g;
import mb.y;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final /* synthetic */ class b implements zb.a {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f186a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Object f187b;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ Object f188c;

    public /* synthetic */ b(int i10, Object obj, Object obj2) {
        this.f186a = i10;
        this.f187b = obj;
        this.f188c = obj2;
    }

    @Override // zb.a
    public final Object invoke() {
        switch (this.f186a) {
            case 0:
                break;
            case 1:
                cb.c cVar = (cb.c) this.f187b;
                i iVar = (i) this.f188c;
                hb.c cVar2 = iVar.f3341f;
                try {
                    List<Download> list = (List) cVar.invoke();
                    for (Download download : list) {
                        cVar2.a("Cancelled download " + download);
                        iVar.f3342g.f3409i.onCancelled(download);
                    }
                    iVar.f3339d.post(new y0(list, 4));
                } catch (Exception e10) {
                    cVar2.b("Fetch with namespace " + iVar.f3336a + " error", e10);
                    y.x(e10.getMessage());
                }
                break;
            case 2:
                ((i) this.f187b).f3340e.r0((Fetch2DownloadEngine$bridgeListener$1) this.f188c);
                break;
            case 3:
                i iVar2 = (i) this.f187b;
                hb.c cVar3 = iVar2.f3341f;
                try {
                    ArrayList arrayListO = iVar2.f3340e.O(((Integer) this.f188c).intValue());
                    int size = arrayListO.size();
                    int i10 = 0;
                    while (i10 < size) {
                        Object obj = arrayListO.get(i10);
                        i10++;
                        Download download2 = (Download) obj;
                        cVar3.a("Paused download " + download2);
                        iVar2.f3342g.f3409i.onPaused(download2);
                    }
                    iVar2.f3339d.post(new y0(arrayListO, 4));
                } catch (Exception e11) {
                    cVar3.b("Fetch with namespace " + iVar2.f3336a + " error", e11);
                    y.x(e11.getMessage());
                }
                break;
            case 4:
                break;
            case 5:
                break;
            case 6:
                break;
            case 7:
                break;
            case 8:
                db.d dVar = (db.d) this.f187b;
                String str = (String) this.f188c;
                if (!dVar.f8448p && !dVar.f8447o && g.b(dVar.f8443k, str)) {
                    dVar.K();
                }
                break;
            case 9:
                break;
            case 10:
                z9.b bVar = (z9.b) this.f187b;
                Object[] objArr = (Object[]) this.f188c;
                ServiceCache.b bVar2 = bVar.f14286g;
                g.c(bVar2);
                if (bVar2.f7648f == null) {
                    Object obj2 = bVar.f14287i ? bVar.f14288j : null;
                    ServiceCache.b bVar3 = bVar.f14286g;
                    g.c(bVar3);
                    bVar3.f7648f = bVar.f14289k.invoke(obj2, Arrays.copyOf(objArr, objArr.length));
                    ServiceCache serviceCacheA = ServiceCache.f7640b.a();
                    String name = bVar.f14280a.getServiceWrapper().getName();
                    ServiceCache.b bVar4 = bVar.f14286g;
                    g.c(bVar4);
                    serviceCacheA.a(-1, name, bVar4);
                    break;
                }
                break;
            default:
                z9.d dVar2 = (z9.d) this.f187b;
                Object[] objArr2 = (Object[]) this.f188c;
                ServiceCache serviceCacheA2 = ServiceCache.f7640b.a();
                int pid = dVar2.f14280a.getCallerData().getPid();
                String strValueOf = String.valueOf(dVar2.h);
                Constructor<?> constructor = dVar2.f14292i;
                int parameterCount = constructor.getParameterCount();
                int[] iArr = dVar2.f14293j;
                int i11 = 0;
                if (iArr.length != 0) {
                    Object[] objArr3 = new Object[parameterCount];
                    while (i11 < parameterCount) {
                        int i12 = iArr[i11];
                        objArr3[i11] = (i12 < 0 || i12 >= objArr2.length) ? null : objArr2[i12];
                        i11++;
                    }
                    objArr2 = objArr3;
                } else if (objArr2.length < parameterCount) {
                    Object[] objArr4 = new Object[parameterCount];
                    while (i11 < parameterCount) {
                        objArr4[i11] = i11 < objArr2.length ? objArr2[i11] : null;
                        i11++;
                    }
                    objArr2 = objArr4;
                }
                Object objNewInstance = objArr2.length == 0 ? constructor.newInstance(null) : constructor.newInstance(Arrays.copyOf(objArr2, objArr2.length));
                ServiceCache.b bVar5 = dVar2.f14286g;
                g.c(bVar5);
                bVar5.f7648f = objNewInstance;
                ServiceCache.b bVar6 = dVar2.f14286g;
                g.c(bVar6);
                serviceCacheA2.a(pid, strValueOf, bVar6);
                break;
        }
        return null;
    }
}
