package coil.memory;

import android.graphics.Bitmap;
import androidx.collection.l;
import coil.memory.MemoryCache;
import com.autonavi.aps.amapapi.config.Const;
import com.stepos.statsapp.v3.lib.plugin.constants.UxipConstants;
import io.ktor.http.ContentDisposition;
import java.util.Map;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000G\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\b\b*\u0001\u001c\b\u0000\u0018\u00002\u00020\u0001:\u0001\u000bB\u0017\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0006\u0010\u0007J\u0019\u0010\u000b\u001a\u0004\u0018\u00010\n2\u0006\u0010\t\u001a\u00020\bH\u0016¢\u0006\u0004\b\u000b\u0010\fJ3\u0010\u0014\u001a\u00020\u00132\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\u000e\u001a\u00020\r2\u0012\u0010\u0012\u001a\u000e\u0012\u0004\u0012\u00020\u0010\u0012\u0004\u0012\u00020\u00110\u000fH\u0016¢\u0006\u0004\b\u0014\u0010\u0015J\u000f\u0010\u0016\u001a\u00020\u0013H\u0016¢\u0006\u0004\b\u0016\u0010\u0017J\u0017\u0010\u0019\u001a\u00020\u00132\u0006\u0010\u0018\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0019\u0010\u001aR\u0014\u0010\u0005\u001a\u00020\u00048\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u000b\u0010\u001bR\u0014\u0010\u001e\u001a\u00020\u001c8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0014\u0010\u001dR\u0014\u0010!\u001a\u00020\u00028VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u001f\u0010 R\u0014\u0010\u0003\u001a\u00020\u00028VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\"\u0010 ¨\u0006#"}, d2 = {"Lcoil/memory/e;", "Lcoil/memory/g;", "", "maxSize", "Lcoil/memory/h;", "weakMemoryCache", "<init>", "(ILcoil/memory/h;)V", "Lcoil/memory/MemoryCache$Key;", "key", "Lcoil/memory/MemoryCache$b;", Const.INTENT_KEY_APIKEY, "(Lcoil/memory/MemoryCache$Key;)Lcoil/memory/MemoryCache$b;", "Landroid/graphics/Bitmap;", "bitmap", "", "", "", "extras", "LY8/t;", Const.INTENT_KEY_PKGNAME, "(Lcoil/memory/MemoryCache$Key;Landroid/graphics/Bitmap;Ljava/util/Map;)V", "clearMemory", "()V", "level", "trimMemory", "(I)V", "Lcoil/memory/h;", "coil/memory/e$b", "Lcoil/memory/e$b;", "cache", "e", "()I", ContentDisposition.Parameters.Size, Const.INTENT_KEY_UMID, "coil-base_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes.dex */
public final class e implements g {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    public final h weakMemoryCache;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    public final b cache;

    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\r\b\u0002\u0018\u00002\u00020\u0001B+\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0012\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00010\u0004\u0012\u0006\u0010\b\u001a\u00020\u0007¢\u0006\u0004\b\t\u0010\nR\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u000b\u0010\f\u001a\u0004\b\u000b\u0010\rR#\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00010\u00048\u0006¢\u0006\f\n\u0004\b\u000e\u0010\u000f\u001a\u0004\b\u000e\u0010\u0010R\u0017\u0010\b\u001a\u00020\u00078\u0006¢\u0006\f\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u0011\u0010\u0013¨\u0006\u0014"}, d2 = {"Lcoil/memory/e$a;", "", "Landroid/graphics/Bitmap;", "bitmap", "", "", "extras", "", ContentDisposition.Parameters.Size, "<init>", "(Landroid/graphics/Bitmap;Ljava/util/Map;I)V", Const.INTENT_KEY_APIKEY, "Landroid/graphics/Bitmap;", "()Landroid/graphics/Bitmap;", Const.INTENT_KEY_PKGNAME, "Ljava/util/Map;", "()Ljava/util/Map;", "c", "I", "()I", "coil-base_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class a {

        /* renamed from: a, reason: collision with root package name and from kotlin metadata */
        public final Bitmap bitmap;

        /* renamed from: b, reason: collision with root package name and from kotlin metadata */
        public final Map<String, Object> extras;

        /* renamed from: c, reason: collision with root package name and from kotlin metadata */
        public final int size;

        public a(Bitmap bitmap, Map<String, ? extends Object> map, int i10) {
            this.bitmap = bitmap;
            this.extras = map;
            this.size = i10;
        }

        /* renamed from: a, reason: from getter */
        public final Bitmap getBitmap() {
            return this.bitmap;
        }

        public final Map<String, Object> b() {
            return this.extras;
        }

        /* renamed from: c, reason: from getter */
        public final int getSize() {
            return this.size;
        }
    }

    @Metadata(d1 = {"\u0000-\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001J\u001f\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0003H\u0014¢\u0006\u0004\b\u0007\u0010\bJ1\u0010\u000e\u001a\u00020\r2\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u000b\u001a\u00020\u00032\b\u0010\f\u001a\u0004\u0018\u00010\u0003H\u0014¢\u0006\u0004\b\u000e\u0010\u000f¨\u0006\u0010"}, d2 = {"coil/memory/e$b", "Landroidx/collection/l;", "Lcoil/memory/MemoryCache$Key;", "Lcoil/memory/e$a;", "key", UxipConstants.f30680s, "", Const.INTENT_KEY_PKGNAME, "(Lcoil/memory/MemoryCache$Key;Lcoil/memory/e$a;)I", "", "evicted", "oldValue", "newValue", "LY8/t;", Const.INTENT_KEY_APIKEY, "(ZLcoil/memory/MemoryCache$Key;Lcoil/memory/e$a;Lcoil/memory/e$a;)V", "coil-base_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class b extends l<MemoryCache.Key, a> {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ e f15797a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(int i10, e eVar) {
            super(i10);
            this.f15797a = eVar;
        }

        @Override // androidx.collection.l
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void entryRemoved(boolean evicted, MemoryCache.Key key, a oldValue, a newValue) {
            this.f15797a.weakMemoryCache.b(key, oldValue.getBitmap(), oldValue.b(), oldValue.getSize());
        }

        @Override // androidx.collection.l
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public int sizeOf(MemoryCache.Key key, a value) {
            return value.getSize();
        }
    }

    public e(int i10, h hVar) {
        this.weakMemoryCache = hVar;
        this.cache = new b(i10, this);
    }

    @Override // coil.memory.g
    public MemoryCache.Value a(MemoryCache.Key key) {
        a aVar = this.cache.get(key);
        if (aVar != null) {
            return new MemoryCache.Value(aVar.getBitmap(), aVar.b());
        }
        return null;
    }

    @Override // coil.memory.g
    public void b(MemoryCache.Key key, Bitmap bitmap, Map<String, ? extends Object> extras) {
        int iA = F1.a.a(bitmap);
        if (iA <= d()) {
            this.cache.put(key, new a(bitmap, extras, iA));
        } else {
            this.cache.remove(key);
            this.weakMemoryCache.b(key, bitmap, extras, iA);
        }
    }

    @Override // coil.memory.g
    public void clearMemory() {
        this.cache.evictAll();
    }

    public int d() {
        return this.cache.maxSize();
    }

    public int e() {
        return this.cache.size();
    }

    @Override // coil.memory.g
    public void trimMemory(int level) {
        if (level >= 40) {
            clearMemory();
        } else {
            if (10 > level || level >= 20) {
                return;
            }
            this.cache.trimToSize(e() / 2);
        }
    }
}
