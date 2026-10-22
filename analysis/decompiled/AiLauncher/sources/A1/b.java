package A1;

import E1.b;
import Ua.I;
import Ua.Y;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import coil.request.CachePolicy;
import coil.size.Precision;
import com.autonavi.aps.amapapi.config.Const;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\b\n\u0002\b!\u0018\u00002\u00020\u0001B£\u0001\u0012\b\b\u0002\u0010\u0003\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0002\u0012\b\b\u0002\u0010\b\u001a\u00020\u0007\u0012\b\b\u0002\u0010\n\u001a\u00020\t\u0012\b\b\u0002\u0010\f\u001a\u00020\u000b\u0012\b\b\u0002\u0010\u000e\u001a\u00020\r\u0012\b\b\u0002\u0010\u000f\u001a\u00020\r\u0012\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u0010\u0012\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u0010\u0012\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u0010\u0012\b\b\u0002\u0010\u0015\u001a\u00020\u0014\u0012\b\b\u0002\u0010\u0016\u001a\u00020\u0014\u0012\b\b\u0002\u0010\u0017\u001a\u00020\u0014¢\u0006\u0004\b\u0018\u0010\u0019J©\u0001\u0010\u001a\u001a\u00020\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u00022\b\b\u0002\u0010\u0004\u001a\u00020\u00022\b\b\u0002\u0010\u0005\u001a\u00020\u00022\b\b\u0002\u0010\u0006\u001a\u00020\u00022\b\b\u0002\u0010\b\u001a\u00020\u00072\b\b\u0002\u0010\n\u001a\u00020\t2\b\b\u0002\u0010\f\u001a\u00020\u000b2\b\b\u0002\u0010\u000e\u001a\u00020\r2\b\b\u0002\u0010\u000f\u001a\u00020\r2\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u00102\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u00102\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u00102\b\b\u0002\u0010\u0015\u001a\u00020\u00142\b\b\u0002\u0010\u0016\u001a\u00020\u00142\b\b\u0002\u0010\u0017\u001a\u00020\u0014¢\u0006\u0004\b\u001a\u0010\u001bJ\u001a\u0010\u001d\u001a\u00020\r2\b\u0010\u001c\u001a\u0004\u0018\u00010\u0001H\u0096\u0002¢\u0006\u0004\b\u001d\u0010\u001eJ\u000f\u0010 \u001a\u00020\u001fH\u0016¢\u0006\u0004\b \u0010!R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u001a\u0010\"\u001a\u0004\b#\u0010$R\u0017\u0010\u0004\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b%\u0010\"\u001a\u0004\b&\u0010$R\u0017\u0010\u0005\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b'\u0010\"\u001a\u0004\b(\u0010$R\u0017\u0010\u0006\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b)\u0010\"\u001a\u0004\b*\u0010$R\u0017\u0010\b\u001a\u00020\u00078\u0006¢\u0006\f\n\u0004\b+\u0010,\u001a\u0004\b-\u0010.R\u0017\u0010\n\u001a\u00020\t8\u0006¢\u0006\f\n\u0004\b(\u0010/\u001a\u0004\b0\u00101R\u0017\u0010\f\u001a\u00020\u000b8\u0006¢\u0006\f\n\u0004\b2\u00103\u001a\u0004\b+\u00104R\u0017\u0010\u000e\u001a\u00020\r8\u0006¢\u0006\f\n\u0004\b5\u00106\u001a\u0004\b'\u00107R\u0017\u0010\u000f\u001a\u00020\r8\u0006¢\u0006\f\n\u0004\b8\u00106\u001a\u0004\b)\u00107R\u0019\u0010\u0011\u001a\u0004\u0018\u00010\u00108\u0006¢\u0006\f\n\u0004\b&\u00109\u001a\u0004\b:\u0010;R\u0019\u0010\u0012\u001a\u0004\u0018\u00010\u00108\u0006¢\u0006\f\n\u0004\b#\u00109\u001a\u0004\b5\u0010;R\u0019\u0010\u0013\u001a\u0004\u0018\u00010\u00108\u0006¢\u0006\f\n\u0004\b<\u00109\u001a\u0004\b8\u0010;R\u0017\u0010\u0015\u001a\u00020\u00148\u0006¢\u0006\f\n\u0004\b=\u0010>\u001a\u0004\b<\u0010?R\u0017\u0010\u0016\u001a\u00020\u00148\u0006¢\u0006\f\n\u0004\b:\u0010>\u001a\u0004\b2\u0010?R\u0017\u0010\u0017\u001a\u00020\u00148\u0006¢\u0006\f\n\u0004\b0\u0010>\u001a\u0004\b=\u0010?¨\u0006@"}, d2 = {"LA1/b;", "", "LUa/I;", "interceptorDispatcher", "fetcherDispatcher", "decoderDispatcher", "transformationDispatcher", "LE1/b$a;", "transitionFactory", "Lcoil/size/Precision;", "precision", "Landroid/graphics/Bitmap$Config;", "bitmapConfig", "", "allowHardware", "allowRgb565", "Landroid/graphics/drawable/Drawable;", "placeholder", "error", "fallback", "Lcoil/request/CachePolicy;", "memoryCachePolicy", "diskCachePolicy", "networkCachePolicy", "<init>", "(LUa/I;LUa/I;LUa/I;LUa/I;LE1/b$a;Lcoil/size/Precision;Landroid/graphics/Bitmap$Config;ZZLandroid/graphics/drawable/Drawable;Landroid/graphics/drawable/Drawable;Landroid/graphics/drawable/Drawable;Lcoil/request/CachePolicy;Lcoil/request/CachePolicy;Lcoil/request/CachePolicy;)V", Const.INTENT_KEY_APIKEY, "(LUa/I;LUa/I;LUa/I;LUa/I;LE1/b$a;Lcoil/size/Precision;Landroid/graphics/Bitmap$Config;ZZLandroid/graphics/drawable/Drawable;Landroid/graphics/drawable/Drawable;Landroid/graphics/drawable/Drawable;Lcoil/request/CachePolicy;Lcoil/request/CachePolicy;Lcoil/request/CachePolicy;)LA1/b;", "other", "equals", "(Ljava/lang/Object;)Z", "", "hashCode", "()I", "LUa/I;", "k", "()LUa/I;", Const.INTENT_KEY_PKGNAME, Const.INTENT_KEY_BACKGROUND_NOTIFICATION_REMOVE, "c", "f", Const.INTENT_KEY_UMID, "p", "e", "LE1/b$a;", "q", "()LE1/b$a;", "Lcoil/size/Precision;", "o", "()Lcoil/size/Precision;", Const.INTENT_KEY_BACKGROUND_COMMAND, "Landroid/graphics/Bitmap$Config;", "()Landroid/graphics/Bitmap$Config;", Const.INTENT_KEY_BACKGROUND_NOTIFICATION, "Z", "()Z", Const.INTENT_KEY_BACKGROUND_NOTIFICATION_ID, "Landroid/graphics/drawable/Drawable;", "n", "()Landroid/graphics/drawable/Drawable;", "l", "m", "Lcoil/request/CachePolicy;", "()Lcoil/request/CachePolicy;", "coil-base_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes.dex */
public final class b {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    public final I interceptorDispatcher;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    public final I fetcherDispatcher;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    public final I decoderDispatcher;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    public final I transformationDispatcher;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    public final b.a transitionFactory;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    public final Precision precision;

    /* renamed from: g, reason: collision with root package name and from kotlin metadata */
    public final Bitmap.Config bitmapConfig;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    public final boolean allowHardware;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    public final boolean allowRgb565;

    /* renamed from: j, reason: collision with root package name and from kotlin metadata */
    public final Drawable placeholder;

    /* renamed from: k, reason: collision with root package name and from kotlin metadata */
    public final Drawable error;

    /* renamed from: l, reason: collision with root package name and from kotlin metadata */
    public final Drawable fallback;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    public final CachePolicy memoryCachePolicy;

    /* renamed from: n, reason: collision with root package name and from kotlin metadata */
    public final CachePolicy diskCachePolicy;

    /* renamed from: o, reason: collision with root package name and from kotlin metadata */
    public final CachePolicy networkCachePolicy;

    public b() {
        this(null, null, null, null, null, null, null, false, false, null, null, null, null, null, null, 32767, null);
    }

    public final b a(I interceptorDispatcher, I fetcherDispatcher, I decoderDispatcher, I transformationDispatcher, b.a transitionFactory, Precision precision, Bitmap.Config bitmapConfig, boolean allowHardware, boolean allowRgb565, Drawable placeholder, Drawable error, Drawable fallback, CachePolicy memoryCachePolicy, CachePolicy diskCachePolicy, CachePolicy networkCachePolicy) {
        return new b(interceptorDispatcher, fetcherDispatcher, decoderDispatcher, transformationDispatcher, transitionFactory, precision, bitmapConfig, allowHardware, allowRgb565, placeholder, error, fallback, memoryCachePolicy, diskCachePolicy, networkCachePolicy);
    }

    /* renamed from: c, reason: from getter */
    public final boolean getAllowHardware() {
        return this.allowHardware;
    }

    /* renamed from: d, reason: from getter */
    public final boolean getAllowRgb565() {
        return this.allowRgb565;
    }

    /* renamed from: e, reason: from getter */
    public final Bitmap.Config getBitmapConfig() {
        return this.bitmapConfig;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof b)) {
            return false;
        }
        b bVar = (b) other;
        return kotlin.jvm.internal.p.d(this.interceptorDispatcher, bVar.interceptorDispatcher) && kotlin.jvm.internal.p.d(this.fetcherDispatcher, bVar.fetcherDispatcher) && kotlin.jvm.internal.p.d(this.decoderDispatcher, bVar.decoderDispatcher) && kotlin.jvm.internal.p.d(this.transformationDispatcher, bVar.transformationDispatcher) && kotlin.jvm.internal.p.d(this.transitionFactory, bVar.transitionFactory) && this.precision == bVar.precision && this.bitmapConfig == bVar.bitmapConfig && this.allowHardware == bVar.allowHardware && this.allowRgb565 == bVar.allowRgb565 && kotlin.jvm.internal.p.d(this.placeholder, bVar.placeholder) && kotlin.jvm.internal.p.d(this.error, bVar.error) && kotlin.jvm.internal.p.d(this.fallback, bVar.fallback) && this.memoryCachePolicy == bVar.memoryCachePolicy && this.diskCachePolicy == bVar.diskCachePolicy && this.networkCachePolicy == bVar.networkCachePolicy;
    }

    /* renamed from: f, reason: from getter */
    public final I getDecoderDispatcher() {
        return this.decoderDispatcher;
    }

    /* renamed from: g, reason: from getter */
    public final CachePolicy getDiskCachePolicy() {
        return this.diskCachePolicy;
    }

    /* renamed from: h, reason: from getter */
    public final Drawable getError() {
        return this.error;
    }

    public int hashCode() {
        int iHashCode = ((((((((((((((((this.interceptorDispatcher.hashCode() * 31) + this.fetcherDispatcher.hashCode()) * 31) + this.decoderDispatcher.hashCode()) * 31) + this.transformationDispatcher.hashCode()) * 31) + this.transitionFactory.hashCode()) * 31) + this.precision.hashCode()) * 31) + this.bitmapConfig.hashCode()) * 31) + Boolean.hashCode(this.allowHardware)) * 31) + Boolean.hashCode(this.allowRgb565)) * 31;
        Drawable drawable = this.placeholder;
        int iHashCode2 = (iHashCode + (drawable != null ? drawable.hashCode() : 0)) * 31;
        Drawable drawable2 = this.error;
        int iHashCode3 = (iHashCode2 + (drawable2 != null ? drawable2.hashCode() : 0)) * 31;
        Drawable drawable3 = this.fallback;
        return ((((((iHashCode3 + (drawable3 != null ? drawable3.hashCode() : 0)) * 31) + this.memoryCachePolicy.hashCode()) * 31) + this.diskCachePolicy.hashCode()) * 31) + this.networkCachePolicy.hashCode();
    }

    /* renamed from: i, reason: from getter */
    public final Drawable getFallback() {
        return this.fallback;
    }

    /* renamed from: j, reason: from getter */
    public final I getFetcherDispatcher() {
        return this.fetcherDispatcher;
    }

    /* renamed from: k, reason: from getter */
    public final I getInterceptorDispatcher() {
        return this.interceptorDispatcher;
    }

    /* renamed from: l, reason: from getter */
    public final CachePolicy getMemoryCachePolicy() {
        return this.memoryCachePolicy;
    }

    /* renamed from: m, reason: from getter */
    public final CachePolicy getNetworkCachePolicy() {
        return this.networkCachePolicy;
    }

    /* renamed from: n, reason: from getter */
    public final Drawable getPlaceholder() {
        return this.placeholder;
    }

    /* renamed from: o, reason: from getter */
    public final Precision getPrecision() {
        return this.precision;
    }

    /* renamed from: p, reason: from getter */
    public final I getTransformationDispatcher() {
        return this.transformationDispatcher;
    }

    /* renamed from: q, reason: from getter */
    public final b.a getTransitionFactory() {
        return this.transitionFactory;
    }

    public b(I i10, I i11, I i12, I i13, b.a aVar, Precision precision, Bitmap.Config config, boolean z10, boolean z11, Drawable drawable, Drawable drawable2, Drawable drawable3, CachePolicy cachePolicy, CachePolicy cachePolicy2, CachePolicy cachePolicy3) {
        this.interceptorDispatcher = i10;
        this.fetcherDispatcher = i11;
        this.decoderDispatcher = i12;
        this.transformationDispatcher = i13;
        this.transitionFactory = aVar;
        this.precision = precision;
        this.bitmapConfig = config;
        this.allowHardware = z10;
        this.allowRgb565 = z11;
        this.placeholder = drawable;
        this.error = drawable2;
        this.fallback = drawable3;
        this.memoryCachePolicy = cachePolicy;
        this.diskCachePolicy = cachePolicy2;
        this.networkCachePolicy = cachePolicy3;
    }

    public /* synthetic */ b(I i10, I i11, I i12, I i13, b.a aVar, Precision precision, Bitmap.Config config, boolean z10, boolean z11, Drawable drawable, Drawable drawable2, Drawable drawable3, CachePolicy cachePolicy, CachePolicy cachePolicy2, CachePolicy cachePolicy3, int i14, kotlin.jvm.internal.i iVar) {
        this((i14 & 1) != 0 ? Y.c().getImmediate() : i10, (i14 & 2) != 0 ? Y.b() : i11, (i14 & 4) != 0 ? Y.b() : i12, (i14 & 8) != 0 ? Y.b() : i13, (i14 & 16) != 0 ? b.a.f2337b : aVar, (i14 & 32) != 0 ? Precision.AUTOMATIC : precision, (i14 & 64) != 0 ? F1.j.f() : config, (i14 & 128) != 0 ? true : z10, (i14 & 256) != 0 ? false : z11, (i14 & 512) != 0 ? null : drawable, (i14 & 1024) != 0 ? null : drawable2, (i14 & 2048) == 0 ? drawable3 : null, (i14 & 4096) != 0 ? CachePolicy.ENABLED : cachePolicy, (i14 & com.stepos.agentframework.chatui.longtext.b.THRESHOLD) != 0 ? CachePolicy.ENABLED : cachePolicy2, (i14 & 16384) != 0 ? CachePolicy.ENABLED : cachePolicy3);
    }
}
