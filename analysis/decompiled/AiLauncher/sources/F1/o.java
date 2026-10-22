package F1;

import coil.decode.ExifOrientationPolicy;
import com.autonavi.aps.amapapi.config.Const;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000f\b\u0000\u0018\u00002\u00020\u0001B9\u0012\b\b\u0002\u0010\u0003\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0006\u0012\b\b\u0002\u0010\t\u001a\u00020\b¢\u0006\u0004\b\n\u0010\u000bR\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\f\u0010\r\u001a\u0004\b\f\u0010\u000eR\u0017\u0010\u0004\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u000f\u0010\r\u001a\u0004\b\u0010\u0010\u000eR\u0017\u0010\u0005\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0011\u0010\r\u001a\u0004\b\u0012\u0010\u000eR\u0017\u0010\u0007\u001a\u00020\u00068\u0006¢\u0006\f\n\u0004\b\u0010\u0010\u0013\u001a\u0004\b\u0011\u0010\u0014R\u0017\u0010\t\u001a\u00020\b8\u0006¢\u0006\f\n\u0004\b\u0012\u0010\u0015\u001a\u0004\b\u000f\u0010\u0016¨\u0006\u0017"}, d2 = {"LF1/o;", "", "", "addLastModifiedToFileCacheKey", "networkObserverEnabled", "respectCacheHeaders", "", "bitmapFactoryMaxParallelism", "Lcoil/decode/ExifOrientationPolicy;", "bitmapFactoryExifOrientationPolicy", "<init>", "(ZZZILcoil/decode/ExifOrientationPolicy;)V", Const.INTENT_KEY_APIKEY, "Z", "()Z", Const.INTENT_KEY_PKGNAME, Const.INTENT_KEY_UMID, "c", "e", "I", "()I", "Lcoil/decode/ExifOrientationPolicy;", "()Lcoil/decode/ExifOrientationPolicy;", "coil-base_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes.dex */
public final class o {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    public final boolean addLastModifiedToFileCacheKey;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    public final boolean networkObserverEnabled;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    public final boolean respectCacheHeaders;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    public final int bitmapFactoryMaxParallelism;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    public final ExifOrientationPolicy bitmapFactoryExifOrientationPolicy;

    public o(boolean z10, boolean z11, boolean z12, int i10, ExifOrientationPolicy exifOrientationPolicy) {
        this.addLastModifiedToFileCacheKey = z10;
        this.networkObserverEnabled = z11;
        this.respectCacheHeaders = z12;
        this.bitmapFactoryMaxParallelism = i10;
        this.bitmapFactoryExifOrientationPolicy = exifOrientationPolicy;
    }

    /* renamed from: a, reason: from getter */
    public final boolean getAddLastModifiedToFileCacheKey() {
        return this.addLastModifiedToFileCacheKey;
    }

    /* renamed from: b, reason: from getter */
    public final ExifOrientationPolicy getBitmapFactoryExifOrientationPolicy() {
        return this.bitmapFactoryExifOrientationPolicy;
    }

    /* renamed from: c, reason: from getter */
    public final int getBitmapFactoryMaxParallelism() {
        return this.bitmapFactoryMaxParallelism;
    }

    /* renamed from: d, reason: from getter */
    public final boolean getNetworkObserverEnabled() {
        return this.networkObserverEnabled;
    }

    /* renamed from: e, reason: from getter */
    public final boolean getRespectCacheHeaders() {
        return this.respectCacheHeaders;
    }

    public /* synthetic */ o(boolean z10, boolean z11, boolean z12, int i10, ExifOrientationPolicy exifOrientationPolicy, int i11, kotlin.jvm.internal.i iVar) {
        this((i11 & 1) != 0 ? true : z10, (i11 & 2) != 0 ? true : z11, (i11 & 4) != 0 ? true : z12, (i11 & 8) != 0 ? 4 : i10, (i11 & 16) != 0 ? ExifOrientationPolicy.RESPECT_PERFORMANCE : exifOrientationPolicy);
    }
}
