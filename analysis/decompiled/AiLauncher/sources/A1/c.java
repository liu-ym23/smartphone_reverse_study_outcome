package A1;

import E1.b;
import Ua.I;
import android.graphics.Bitmap;
import android.view.Lifecycle;
import coil.request.CachePolicy;
import coil.size.Precision;
import coil.size.Scale;
import com.autonavi.aps.amapapi.config.Const;
import com.stepos.launcher.assistant.slidepanel.ConstConfig;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\b\n\u0002\b$\u0018\u00002\u00020\u0001B\u009d\u0001\u0012\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006\u0012\b\u0010\t\u001a\u0004\u0018\u00010\b\u0012\b\u0010\n\u001a\u0004\u0018\u00010\b\u0012\b\u0010\u000b\u001a\u0004\u0018\u00010\b\u0012\b\u0010\f\u001a\u0004\u0018\u00010\b\u0012\b\u0010\u000e\u001a\u0004\u0018\u00010\r\u0012\b\u0010\u0010\u001a\u0004\u0018\u00010\u000f\u0012\b\u0010\u0012\u001a\u0004\u0018\u00010\u0011\u0012\b\u0010\u0014\u001a\u0004\u0018\u00010\u0013\u0012\b\u0010\u0015\u001a\u0004\u0018\u00010\u0013\u0012\b\u0010\u0017\u001a\u0004\u0018\u00010\u0016\u0012\b\u0010\u0018\u001a\u0004\u0018\u00010\u0016\u0012\b\u0010\u0019\u001a\u0004\u0018\u00010\u0016¢\u0006\u0004\b\u001a\u0010\u001bJ\u001a\u0010\u001d\u001a\u00020\u00132\b\u0010\u001c\u001a\u0004\u0018\u00010\u0001H\u0096\u0002¢\u0006\u0004\b\u001d\u0010\u001eJ\u000f\u0010 \u001a\u00020\u001fH\u0016¢\u0006\u0004\b \u0010!R\u0019\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006¢\u0006\f\n\u0004\b\"\u0010#\u001a\u0004\b$\u0010%R\u0019\u0010\u0005\u001a\u0004\u0018\u00010\u00048\u0006¢\u0006\f\n\u0004\b&\u0010'\u001a\u0004\b(\u0010)R\u0019\u0010\u0007\u001a\u0004\u0018\u00010\u00068\u0006¢\u0006\f\n\u0004\b*\u0010+\u001a\u0004\b,\u0010-R\u0019\u0010\t\u001a\u0004\u0018\u00010\b8\u0006¢\u0006\f\n\u0004\b.\u0010/\u001a\u0004\b0\u00101R\u0019\u0010\n\u001a\u0004\u0018\u00010\b8\u0006¢\u0006\f\n\u0004\b2\u0010/\u001a\u0004\b3\u00101R\u0019\u0010\u000b\u001a\u0004\u0018\u00010\b8\u0006¢\u0006\f\n\u0004\b3\u0010/\u001a\u0004\b.\u00101R\u0019\u0010\f\u001a\u0004\u0018\u00010\b8\u0006¢\u0006\f\n\u0004\b0\u0010/\u001a\u0004\b4\u00101R\u0019\u0010\u000e\u001a\u0004\u0018\u00010\r8\u0006¢\u0006\f\n\u0004\b$\u00105\u001a\u0004\b6\u00107R\u0019\u0010\u0010\u001a\u0004\u0018\u00010\u000f8\u0006¢\u0006\f\n\u0004\b8\u00109\u001a\u0004\b:\u0010;R\u0019\u0010\u0012\u001a\u0004\u0018\u00010\u00118\u0006¢\u0006\f\n\u0004\b<\u0010=\u001a\u0004\b*\u0010>R\u0019\u0010\u0014\u001a\u0004\u0018\u00010\u00138\u0006¢\u0006\f\n\u0004\b:\u0010?\u001a\u0004\b\"\u0010@R\u0019\u0010\u0015\u001a\u0004\u0018\u00010\u00138\u0006¢\u0006\f\n\u0004\b,\u0010?\u001a\u0004\b&\u0010@R\u0019\u0010\u0017\u001a\u0004\u0018\u00010\u00168\u0006¢\u0006\f\n\u0004\b(\u0010A\u001a\u0004\b8\u0010BR\u0019\u0010\u0018\u001a\u0004\u0018\u00010\u00168\u0006¢\u0006\f\n\u0004\b4\u0010A\u001a\u0004\b2\u0010BR\u0019\u0010\u0019\u001a\u0004\u0018\u00010\u00168\u0006¢\u0006\f\n\u0004\b6\u0010A\u001a\u0004\b<\u0010B¨\u0006C"}, d2 = {"LA1/c;", "", "Landroidx/lifecycle/Lifecycle;", "lifecycle", "LB1/h;", "sizeResolver", "Lcoil/size/Scale;", ConstConfig.KEY_VIEW_SCALE_PROPERTY, "LUa/I;", "interceptorDispatcher", "fetcherDispatcher", "decoderDispatcher", "transformationDispatcher", "LE1/b$a;", "transitionFactory", "Lcoil/size/Precision;", "precision", "Landroid/graphics/Bitmap$Config;", "bitmapConfig", "", "allowHardware", "allowRgb565", "Lcoil/request/CachePolicy;", "memoryCachePolicy", "diskCachePolicy", "networkCachePolicy", "<init>", "(Landroidx/lifecycle/Lifecycle;LB1/h;Lcoil/size/Scale;LUa/I;LUa/I;LUa/I;LUa/I;LE1/b$a;Lcoil/size/Precision;Landroid/graphics/Bitmap$Config;Ljava/lang/Boolean;Ljava/lang/Boolean;Lcoil/request/CachePolicy;Lcoil/request/CachePolicy;Lcoil/request/CachePolicy;)V", "other", "equals", "(Ljava/lang/Object;)Z", "", "hashCode", "()I", Const.INTENT_KEY_APIKEY, "Landroidx/lifecycle/Lifecycle;", Const.INTENT_KEY_BACKGROUND_NOTIFICATION, "()Landroidx/lifecycle/Lifecycle;", Const.INTENT_KEY_PKGNAME, "LB1/h;", "m", "()LB1/h;", "c", "Lcoil/size/Scale;", "l", "()Lcoil/size/Scale;", Const.INTENT_KEY_UMID, "LUa/I;", Const.INTENT_KEY_BACKGROUND_COMMAND, "()LUa/I;", "e", "f", "n", "LE1/b$a;", "o", "()LE1/b$a;", Const.INTENT_KEY_BACKGROUND_NOTIFICATION_ID, "Lcoil/size/Precision;", "k", "()Lcoil/size/Precision;", Const.INTENT_KEY_BACKGROUND_NOTIFICATION_REMOVE, "Landroid/graphics/Bitmap$Config;", "()Landroid/graphics/Bitmap$Config;", "Ljava/lang/Boolean;", "()Ljava/lang/Boolean;", "Lcoil/request/CachePolicy;", "()Lcoil/request/CachePolicy;", "coil-base_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes.dex */
public final class c {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    public final Lifecycle lifecycle;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    public final B1.h sizeResolver;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    public final Scale scale;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    public final I interceptorDispatcher;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    public final I fetcherDispatcher;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    public final I decoderDispatcher;

    /* renamed from: g, reason: collision with root package name and from kotlin metadata */
    public final I transformationDispatcher;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    public final b.a transitionFactory;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    public final Precision precision;

    /* renamed from: j, reason: collision with root package name and from kotlin metadata */
    public final Bitmap.Config bitmapConfig;

    /* renamed from: k, reason: collision with root package name and from kotlin metadata */
    public final Boolean allowHardware;

    /* renamed from: l, reason: collision with root package name and from kotlin metadata */
    public final Boolean allowRgb565;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    public final CachePolicy memoryCachePolicy;

    /* renamed from: n, reason: collision with root package name and from kotlin metadata */
    public final CachePolicy diskCachePolicy;

    /* renamed from: o, reason: collision with root package name and from kotlin metadata */
    public final CachePolicy networkCachePolicy;

    public c(Lifecycle lifecycle, B1.h hVar, Scale scale, I i10, I i11, I i12, I i13, b.a aVar, Precision precision, Bitmap.Config config, Boolean bool, Boolean bool2, CachePolicy cachePolicy, CachePolicy cachePolicy2, CachePolicy cachePolicy3) {
        this.lifecycle = lifecycle;
        this.sizeResolver = hVar;
        this.scale = scale;
        this.interceptorDispatcher = i10;
        this.fetcherDispatcher = i11;
        this.decoderDispatcher = i12;
        this.transformationDispatcher = i13;
        this.transitionFactory = aVar;
        this.precision = precision;
        this.bitmapConfig = config;
        this.allowHardware = bool;
        this.allowRgb565 = bool2;
        this.memoryCachePolicy = cachePolicy;
        this.diskCachePolicy = cachePolicy2;
        this.networkCachePolicy = cachePolicy3;
    }

    /* renamed from: a, reason: from getter */
    public final Boolean getAllowHardware() {
        return this.allowHardware;
    }

    /* renamed from: b, reason: from getter */
    public final Boolean getAllowRgb565() {
        return this.allowRgb565;
    }

    /* renamed from: c, reason: from getter */
    public final Bitmap.Config getBitmapConfig() {
        return this.bitmapConfig;
    }

    /* renamed from: d, reason: from getter */
    public final I getDecoderDispatcher() {
        return this.decoderDispatcher;
    }

    /* renamed from: e, reason: from getter */
    public final CachePolicy getDiskCachePolicy() {
        return this.diskCachePolicy;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof c)) {
            return false;
        }
        c cVar = (c) other;
        return kotlin.jvm.internal.p.d(this.lifecycle, cVar.lifecycle) && kotlin.jvm.internal.p.d(this.sizeResolver, cVar.sizeResolver) && this.scale == cVar.scale && kotlin.jvm.internal.p.d(this.interceptorDispatcher, cVar.interceptorDispatcher) && kotlin.jvm.internal.p.d(this.fetcherDispatcher, cVar.fetcherDispatcher) && kotlin.jvm.internal.p.d(this.decoderDispatcher, cVar.decoderDispatcher) && kotlin.jvm.internal.p.d(this.transformationDispatcher, cVar.transformationDispatcher) && kotlin.jvm.internal.p.d(this.transitionFactory, cVar.transitionFactory) && this.precision == cVar.precision && this.bitmapConfig == cVar.bitmapConfig && kotlin.jvm.internal.p.d(this.allowHardware, cVar.allowHardware) && kotlin.jvm.internal.p.d(this.allowRgb565, cVar.allowRgb565) && this.memoryCachePolicy == cVar.memoryCachePolicy && this.diskCachePolicy == cVar.diskCachePolicy && this.networkCachePolicy == cVar.networkCachePolicy;
    }

    /* renamed from: f, reason: from getter */
    public final I getFetcherDispatcher() {
        return this.fetcherDispatcher;
    }

    /* renamed from: g, reason: from getter */
    public final I getInterceptorDispatcher() {
        return this.interceptorDispatcher;
    }

    /* renamed from: h, reason: from getter */
    public final Lifecycle getLifecycle() {
        return this.lifecycle;
    }

    public int hashCode() {
        Lifecycle lifecycle = this.lifecycle;
        int iHashCode = (lifecycle != null ? lifecycle.hashCode() : 0) * 31;
        B1.h hVar = this.sizeResolver;
        int iHashCode2 = (iHashCode + (hVar != null ? hVar.hashCode() : 0)) * 31;
        Scale scale = this.scale;
        int iHashCode3 = (iHashCode2 + (scale != null ? scale.hashCode() : 0)) * 31;
        I i10 = this.interceptorDispatcher;
        int iHashCode4 = (iHashCode3 + (i10 != null ? i10.hashCode() : 0)) * 31;
        I i11 = this.fetcherDispatcher;
        int iHashCode5 = (iHashCode4 + (i11 != null ? i11.hashCode() : 0)) * 31;
        I i12 = this.decoderDispatcher;
        int iHashCode6 = (iHashCode5 + (i12 != null ? i12.hashCode() : 0)) * 31;
        I i13 = this.transformationDispatcher;
        int iHashCode7 = (iHashCode6 + (i13 != null ? i13.hashCode() : 0)) * 31;
        b.a aVar = this.transitionFactory;
        int iHashCode8 = (iHashCode7 + (aVar != null ? aVar.hashCode() : 0)) * 31;
        Precision precision = this.precision;
        int iHashCode9 = (iHashCode8 + (precision != null ? precision.hashCode() : 0)) * 31;
        Bitmap.Config config = this.bitmapConfig;
        int iHashCode10 = (iHashCode9 + (config != null ? config.hashCode() : 0)) * 31;
        Boolean bool = this.allowHardware;
        int iHashCode11 = (iHashCode10 + (bool != null ? bool.hashCode() : 0)) * 31;
        Boolean bool2 = this.allowRgb565;
        int iHashCode12 = (iHashCode11 + (bool2 != null ? bool2.hashCode() : 0)) * 31;
        CachePolicy cachePolicy = this.memoryCachePolicy;
        int iHashCode13 = (iHashCode12 + (cachePolicy != null ? cachePolicy.hashCode() : 0)) * 31;
        CachePolicy cachePolicy2 = this.diskCachePolicy;
        int iHashCode14 = (iHashCode13 + (cachePolicy2 != null ? cachePolicy2.hashCode() : 0)) * 31;
        CachePolicy cachePolicy3 = this.networkCachePolicy;
        return iHashCode14 + (cachePolicy3 != null ? cachePolicy3.hashCode() : 0);
    }

    /* renamed from: i, reason: from getter */
    public final CachePolicy getMemoryCachePolicy() {
        return this.memoryCachePolicy;
    }

    /* renamed from: j, reason: from getter */
    public final CachePolicy getNetworkCachePolicy() {
        return this.networkCachePolicy;
    }

    /* renamed from: k, reason: from getter */
    public final Precision getPrecision() {
        return this.precision;
    }

    /* renamed from: l, reason: from getter */
    public final Scale getScale() {
        return this.scale;
    }

    /* renamed from: m, reason: from getter */
    public final B1.h getSizeResolver() {
        return this.sizeResolver;
    }

    /* renamed from: n, reason: from getter */
    public final I getTransformationDispatcher() {
        return this.transformationDispatcher;
    }

    /* renamed from: o, reason: from getter */
    public final b.a getTransitionFactory() {
        return this.transitionFactory;
    }
}
