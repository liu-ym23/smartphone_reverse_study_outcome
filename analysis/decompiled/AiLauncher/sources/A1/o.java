package A1;

import android.graphics.drawable.Drawable;
import coil.decode.DataSource;
import coil.memory.MemoryCache;
import com.autonavi.aps.amapapi.config.Const;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0018\u0018\u00002\u00020\u0001BK\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\u0006\u0010\u0007\u001a\u00020\u0006\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\b\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\n\u0012\b\b\u0002\u0010\r\u001a\u00020\f\u0012\b\b\u0002\u0010\u000e\u001a\u00020\f¢\u0006\u0004\b\u000f\u0010\u0010J\u001a\u0010\u0013\u001a\u00020\f2\b\u0010\u0012\u001a\u0004\u0018\u00010\u0011H\u0096\u0002¢\u0006\u0004\b\u0013\u0010\u0014J\u000f\u0010\u0016\u001a\u00020\u0015H\u0016¢\u0006\u0004\b\u0016\u0010\u0017R\u001a\u0010\u0003\u001a\u00020\u00028\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u0018\u0010\u0019\u001a\u0004\b\u001a\u0010\u001bR\u001a\u0010\u0005\u001a\u00020\u00048\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u001c\u0010\u001d\u001a\u0004\b\u0018\u0010\u001eR\u0017\u0010\u0007\u001a\u00020\u00068\u0006¢\u0006\f\n\u0004\b\u001a\u0010\u001f\u001a\u0004\b\u001c\u0010 R\u0019\u0010\t\u001a\u0004\u0018\u00010\b8\u0006¢\u0006\f\n\u0004\b!\u0010\"\u001a\u0004\b#\u0010$R\u0019\u0010\u000b\u001a\u0004\u0018\u00010\n8\u0006¢\u0006\f\n\u0004\b%\u0010&\u001a\u0004\b'\u0010(R\u0017\u0010\r\u001a\u00020\f8\u0006¢\u0006\f\n\u0004\b)\u0010*\u001a\u0004\b\r\u0010+R\u0017\u0010\u000e\u001a\u00020\f8\u0006¢\u0006\f\n\u0004\b,\u0010*\u001a\u0004\b\u000e\u0010+¨\u0006-"}, d2 = {"LA1/o;", "LA1/h;", "Landroid/graphics/drawable/Drawable;", "drawable", "LA1/g;", "request", "Lcoil/decode/DataSource;", "dataSource", "Lcoil/memory/MemoryCache$Key;", "memoryCacheKey", "", "diskCacheKey", "", "isSampled", "isPlaceholderCached", "<init>", "(Landroid/graphics/drawable/Drawable;LA1/g;Lcoil/decode/DataSource;Lcoil/memory/MemoryCache$Key;Ljava/lang/String;ZZ)V", "", "other", "equals", "(Ljava/lang/Object;)Z", "", "hashCode", "()I", Const.INTENT_KEY_APIKEY, "Landroid/graphics/drawable/Drawable;", "c", "()Landroid/graphics/drawable/Drawable;", Const.INTENT_KEY_PKGNAME, "LA1/g;", "()LA1/g;", "Lcoil/decode/DataSource;", "()Lcoil/decode/DataSource;", Const.INTENT_KEY_UMID, "Lcoil/memory/MemoryCache$Key;", "getMemoryCacheKey", "()Lcoil/memory/MemoryCache$Key;", "e", "Ljava/lang/String;", "getDiskCacheKey", "()Ljava/lang/String;", "f", "Z", "()Z", Const.INTENT_KEY_BACKGROUND_COMMAND, "coil-base_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes.dex */
public final class o extends h {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    public final Drawable drawable;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    public final g request;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    public final DataSource dataSource;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    public final MemoryCache.Key memoryCacheKey;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    public final String diskCacheKey;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    public final boolean isSampled;

    /* renamed from: g, reason: collision with root package name and from kotlin metadata */
    public final boolean isPlaceholderCached;

    public o(Drawable drawable, g gVar, DataSource dataSource, MemoryCache.Key key, String str, boolean z10, boolean z11) {
        super(null);
        this.drawable = drawable;
        this.request = gVar;
        this.dataSource = dataSource;
        this.memoryCacheKey = key;
        this.diskCacheKey = str;
        this.isSampled = z10;
        this.isPlaceholderCached = z11;
    }

    @Override // A1.h
    /* renamed from: a, reason: from getter */
    public g getRequest() {
        return this.request;
    }

    /* renamed from: b, reason: from getter */
    public final DataSource getDataSource() {
        return this.dataSource;
    }

    /* renamed from: c, reason: from getter */
    public Drawable getDrawable() {
        return this.drawable;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof o)) {
            return false;
        }
        o oVar = (o) other;
        return kotlin.jvm.internal.p.d(getDrawable(), oVar.getDrawable()) && kotlin.jvm.internal.p.d(getRequest(), oVar.getRequest()) && this.dataSource == oVar.dataSource && kotlin.jvm.internal.p.d(this.memoryCacheKey, oVar.memoryCacheKey) && kotlin.jvm.internal.p.d(this.diskCacheKey, oVar.diskCacheKey) && this.isSampled == oVar.isSampled && this.isPlaceholderCached == oVar.isPlaceholderCached;
    }

    public int hashCode() {
        int iHashCode = ((((getDrawable().hashCode() * 31) + getRequest().hashCode()) * 31) + this.dataSource.hashCode()) * 31;
        MemoryCache.Key key = this.memoryCacheKey;
        int iHashCode2 = (iHashCode + (key != null ? key.hashCode() : 0)) * 31;
        String str = this.diskCacheKey;
        return ((((iHashCode2 + (str != null ? str.hashCode() : 0)) * 31) + Boolean.hashCode(this.isSampled)) * 31) + Boolean.hashCode(this.isPlaceholderCached);
    }
}
