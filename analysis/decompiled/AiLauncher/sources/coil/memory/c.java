package coil.memory;

import A1.k;
import A1.n;
import A1.o;
import B1.Size;
import B1.c;
import F1.j;
import F1.q;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import coil.decode.DataSource;
import coil.intercept.EngineInterceptor;
import coil.intercept.a;
import coil.memory.MemoryCache;
import coil.size.Scale;
import com.autonavi.aps.amapapi.config.Const;
import com.stepos.launcher.assistant.slidepanel.ConstConfig;
import io.ktor.http.ContentDisposition;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.p;
import v9.C5685n;

@Metadata(d1 = {"\u0000r\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u000e\n\u0002\b\u0003\b\u0000\u0018\u0000 \u001e2\u00020\u0001:\u0001\u001aB!\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006¢\u0006\u0004\b\b\u0010\tJ/\u0010\u0012\u001a\u0004\u0018\u00010\u00112\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\f\u001a\u00020\u00012\u0006\u0010\u000e\u001a\u00020\r2\u0006\u0010\u0010\u001a\u00020\u000f¢\u0006\u0004\b\u0012\u0010\u0013J/\u0010\u001a\u001a\u0004\u0018\u00010\u00192\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0014\u001a\u00020\u00112\u0006\u0010\u0016\u001a\u00020\u00152\u0006\u0010\u0018\u001a\u00020\u0017¢\u0006\u0004\b\u001a\u0010\u001bJ7\u0010\u001e\u001a\u00020\u001d2\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0014\u001a\u00020\u00112\u0006\u0010\u001c\u001a\u00020\u00192\u0006\u0010\u0016\u001a\u00020\u00152\u0006\u0010\u0018\u001a\u00020\u0017H\u0001¢\u0006\u0004\b\u001e\u0010\u001fJ'\u0010\"\u001a\u00020\u001d2\b\u0010\u0014\u001a\u0004\u0018\u00010\u00112\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010!\u001a\u00020 ¢\u0006\u0004\b\"\u0010#J-\u0010'\u001a\u00020&2\u0006\u0010%\u001a\u00020$2\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0014\u001a\u00020\u00112\u0006\u0010\u001c\u001a\u00020\u0019¢\u0006\u0004\b'\u0010(J7\u0010)\u001a\u00020\u001d2\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0014\u001a\u00020\u00112\u0006\u0010\u001c\u001a\u00020\u00192\u0006\u0010\u0016\u001a\u00020\u00152\u0006\u0010\u0018\u001a\u00020\u0017H\u0002¢\u0006\u0004\b)\u0010\u001fR\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001a\u0010*R\u0014\u0010\u0005\u001a\u00020\u00048\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b+\u0010,R\u0018\u0010/\u001a\u00020\u001d*\u00020\u00198BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b-\u0010.R\u001a\u00102\u001a\u0004\u0018\u000100*\u00020\u00198BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b+\u00101¨\u00063"}, d2 = {"Lcoil/memory/c;", "", "Lcoil/c;", "imageLoader", "LA1/n;", "requestService", "LF1/q;", "logger", "<init>", "(Lcoil/c;LA1/n;LF1/q;)V", "LA1/g;", "request", "mappedData", "LA1/k;", "options", "Lcoil/b;", "eventListener", "Lcoil/memory/MemoryCache$Key;", "f", "(LA1/g;Ljava/lang/Object;LA1/k;Lcoil/b;)Lcoil/memory/MemoryCache$Key;", "cacheKey", "LB1/g;", ContentDisposition.Parameters.Size, "Lcoil/size/Scale;", ConstConfig.KEY_VIEW_SCALE_PROPERTY, "Lcoil/memory/MemoryCache$b;", Const.INTENT_KEY_APIKEY, "(LA1/g;Lcoil/memory/MemoryCache$Key;LB1/g;Lcoil/size/Scale;)Lcoil/memory/MemoryCache$b;", "cacheValue", "", "c", "(LA1/g;Lcoil/memory/MemoryCache$Key;Lcoil/memory/MemoryCache$b;LB1/g;Lcoil/size/Scale;)Z", "Lcoil/intercept/EngineInterceptor$b;", "result", Const.INTENT_KEY_BACKGROUND_NOTIFICATION, "(Lcoil/memory/MemoryCache$Key;LA1/g;Lcoil/intercept/EngineInterceptor$b;)Z", "Lcoil/intercept/a$a;", "chain", "LA1/o;", Const.INTENT_KEY_BACKGROUND_COMMAND, "(Lcoil/intercept/a$a;LA1/g;Lcoil/memory/MemoryCache$Key;Lcoil/memory/MemoryCache$b;)LA1/o;", "e", "Lcoil/c;", Const.INTENT_KEY_PKGNAME, "LA1/n;", Const.INTENT_KEY_UMID, "(Lcoil/memory/MemoryCache$b;)Z", "isSampled", "", "(Lcoil/memory/MemoryCache$b;)Ljava/lang/String;", "diskCacheKey", "coil-base_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes.dex */
public final class c {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    public final coil.c imageLoader;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    public final n requestService;

    public c(coil.c cVar, n nVar, q qVar) {
        this.imageLoader = cVar;
        this.requestService = nVar;
    }

    public final MemoryCache.Value a(A1.g request, MemoryCache.Key cacheKey, Size size, Scale scale) {
        if (!request.getMemoryCachePolicy().getReadEnabled()) {
            return null;
        }
        MemoryCache memoryCacheB = this.imageLoader.b();
        MemoryCache.Value valueA = memoryCacheB != null ? memoryCacheB.a(cacheKey) : null;
        if (valueA == null || !c(request, cacheKey, valueA, size, scale)) {
            return null;
        }
        return valueA;
    }

    public final String b(MemoryCache.Value value) {
        Object obj = value.b().get("coil#disk_cache_key");
        if (obj instanceof String) {
            return (String) obj;
        }
        return null;
    }

    public final boolean c(A1.g request, MemoryCache.Key cacheKey, MemoryCache.Value cacheValue, Size size, Scale scale) {
        if (this.requestService.c(request, F1.a.c(cacheValue.getBitmap()))) {
            return e(request, cacheKey, cacheValue, size, scale);
        }
        return false;
    }

    public final boolean d(MemoryCache.Value value) {
        Object obj = value.b().get("coil#is_sampled");
        Boolean bool = obj instanceof Boolean ? (Boolean) obj : null;
        if (bool != null) {
            return bool.booleanValue();
        }
        return false;
    }

    public final boolean e(A1.g request, MemoryCache.Key cacheKey, MemoryCache.Value cacheValue, Size size, Scale scale) {
        double d10;
        boolean zD = d(cacheValue);
        if (B1.b.a(size)) {
            return !zD;
        }
        String str = cacheKey.getExtras().get("coil#transformation_size");
        if (str != null) {
            return p.d(str, size.toString());
        }
        int width = cacheValue.getBitmap().getWidth();
        int height = cacheValue.getBitmap().getHeight();
        B1.c cVarD = size.d();
        int i10 = cVarD instanceof c.a ? ((c.a) cVarD).px : Integer.MAX_VALUE;
        B1.c cVarC = size.c();
        int i11 = cVarC instanceof c.a ? ((c.a) cVarC).px : Integer.MAX_VALUE;
        double dC = u1.c.c(width, height, i10, i11, scale);
        boolean zA = F1.h.a(request);
        if (!zA) {
            d10 = 1.0d;
            if ((!j.s(i10) && Math.abs(i10 - width) > 1) || (!j.s(i11) && Math.abs(i11 - height) > 1)) {
            }
        }
        double dH = C5685n.h(dC, 1.0d);
        d10 = 1.0d;
        if (Math.abs(i10 - (width * dH)) <= 1.0d || Math.abs(i11 - (dH * height)) <= 1.0d) {
            return true;
        }
        if (dC == d10 || zA) {
            return dC <= d10 || !zD;
        }
        return false;
    }

    public final MemoryCache.Key f(A1.g request, Object mappedData, k options, coil.b eventListener) {
        MemoryCache.Key memoryCacheKey = request.getMemoryCacheKey();
        if (memoryCacheKey != null) {
            return memoryCacheKey;
        }
        eventListener.q(request, mappedData);
        String strF = this.imageLoader.getComponents().f(mappedData, options);
        eventListener.h(request, strF);
        if (strF == null) {
            return null;
        }
        List<D1.b> listO = request.O();
        Map<String, String> mapC = request.getParameters().c();
        if (listO.isEmpty() && mapC.isEmpty()) {
            return new MemoryCache.Key(strF, null, 2, null);
        }
        Map mapC2 = kotlin.collections.a.C(mapC);
        if (!listO.isEmpty()) {
            List<D1.b> listO2 = request.O();
            int size = listO2.size();
            for (int i10 = 0; i10 < size; i10++) {
                mapC2.put("coil#transformation_" + i10, listO2.get(i10).getCacheKey());
            }
            mapC2.put("coil#transformation_size", options.getSize().toString());
        }
        return new MemoryCache.Key(strF, mapC2);
    }

    public final o g(a.InterfaceC0199a chain, A1.g request, MemoryCache.Key cacheKey, MemoryCache.Value cacheValue) {
        return new o(new BitmapDrawable(request.getContext().getResources(), cacheValue.getBitmap()), request, DataSource.MEMORY_CACHE, cacheKey, b(cacheValue), d(cacheValue), j.t(chain));
    }

    public final boolean h(MemoryCache.Key cacheKey, A1.g request, EngineInterceptor.b result) {
        MemoryCache memoryCacheB;
        Bitmap bitmap;
        if (request.getMemoryCachePolicy().getWriteEnabled() && (memoryCacheB = this.imageLoader.b()) != null && cacheKey != null) {
            Drawable drawableE = result.getDrawable();
            BitmapDrawable bitmapDrawable = drawableE instanceof BitmapDrawable ? (BitmapDrawable) drawableE : null;
            if (bitmapDrawable != null && (bitmap = bitmapDrawable.getBitmap()) != null) {
                LinkedHashMap linkedHashMap = new LinkedHashMap();
                linkedHashMap.put("coil#is_sampled", Boolean.valueOf(result.getIsSampled()));
                String strD = result.getDiskCacheKey();
                if (strD != null) {
                    linkedHashMap.put("coil#disk_cache_key", strD);
                }
                memoryCacheB.b(cacheKey, new MemoryCache.Value(bitmap, linkedHashMap));
                return true;
            }
        }
        return false;
    }
}
