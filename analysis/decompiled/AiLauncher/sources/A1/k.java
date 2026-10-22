package A1;

import B1.Size;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.ColorSpace;
import coil.request.CachePolicy;
import coil.size.Scale;
import com.autonavi.aps.amapapi.config.Const;
import com.stepos.launcher.assistant.slidepanel.ConstConfig;
import io.ktor.http.ContentDisposition;
import kotlin.Metadata;
import tb.u;

@Metadata(d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\b\n\u0002\b)\u0018\u00002\u00020\u0001B\u009f\u0001\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0004\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0006\u0012\b\b\u0002\u0010\t\u001a\u00020\b\u0012\b\b\u0002\u0010\u000b\u001a\u00020\n\u0012\b\b\u0002\u0010\r\u001a\u00020\f\u0012\b\b\u0002\u0010\u000e\u001a\u00020\f\u0012\b\b\u0002\u0010\u000f\u001a\u00020\f\u0012\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u0010\u0012\b\b\u0002\u0010\u0013\u001a\u00020\u0012\u0012\b\b\u0002\u0010\u0015\u001a\u00020\u0014\u0012\b\b\u0002\u0010\u0017\u001a\u00020\u0016\u0012\b\b\u0002\u0010\u0019\u001a\u00020\u0018\u0012\b\b\u0002\u0010\u001a\u001a\u00020\u0018\u0012\b\b\u0002\u0010\u001b\u001a\u00020\u0018¢\u0006\u0004\b\u001c\u0010\u001dJ§\u0001\u0010\u001e\u001a\u00020\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u00022\b\b\u0002\u0010\u0005\u001a\u00020\u00042\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00062\b\b\u0002\u0010\t\u001a\u00020\b2\b\b\u0002\u0010\u000b\u001a\u00020\n2\b\b\u0002\u0010\r\u001a\u00020\f2\b\b\u0002\u0010\u000e\u001a\u00020\f2\b\b\u0002\u0010\u000f\u001a\u00020\f2\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u00102\b\b\u0002\u0010\u0013\u001a\u00020\u00122\b\b\u0002\u0010\u0015\u001a\u00020\u00142\b\b\u0002\u0010\u0017\u001a\u00020\u00162\b\b\u0002\u0010\u0019\u001a\u00020\u00182\b\b\u0002\u0010\u001a\u001a\u00020\u00182\b\b\u0002\u0010\u001b\u001a\u00020\u0018¢\u0006\u0004\b\u001e\u0010\u001fJ\u001a\u0010!\u001a\u00020\f2\b\u0010 \u001a\u0004\u0018\u00010\u0001H\u0096\u0002¢\u0006\u0004\b!\u0010\"J\u000f\u0010$\u001a\u00020#H\u0016¢\u0006\u0004\b$\u0010%R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u001e\u0010&\u001a\u0004\b'\u0010(R\u0017\u0010\u0005\u001a\u00020\u00048\u0006¢\u0006\f\n\u0004\b)\u0010*\u001a\u0004\b+\u0010,R\u0019\u0010\u0007\u001a\u0004\u0018\u00010\u00068\u0006¢\u0006\f\n\u0004\b-\u0010.\u001a\u0004\b/\u00100R\u0017\u0010\t\u001a\u00020\b8\u0006¢\u0006\f\n\u0004\b1\u00102\u001a\u0004\b3\u00104R\u0017\u0010\u000b\u001a\u00020\n8\u0006¢\u0006\f\n\u0004\b/\u00105\u001a\u0004\b6\u00107R\u0017\u0010\r\u001a\u00020\f8\u0006¢\u0006\f\n\u0004\b+\u00108\u001a\u0004\b-\u00109R\u0017\u0010\u000e\u001a\u00020\f8\u0006¢\u0006\f\n\u0004\b'\u00108\u001a\u0004\b1\u00109R\u0017\u0010\u000f\u001a\u00020\f8\u0006¢\u0006\f\n\u0004\b:\u00108\u001a\u0004\b;\u00109R\u0019\u0010\u0011\u001a\u0004\u0018\u00010\u00108\u0006¢\u0006\f\n\u0004\b<\u0010=\u001a\u0004\b:\u0010>R\u0017\u0010\u0013\u001a\u00020\u00128\u0006¢\u0006\f\n\u0004\b?\u0010@\u001a\u0004\b?\u0010AR\u0017\u0010\u0015\u001a\u00020\u00148\u0006¢\u0006\f\n\u0004\bB\u0010C\u001a\u0004\bD\u0010ER\u0017\u0010\u0017\u001a\u00020\u00168\u0006¢\u0006\f\n\u0004\bF\u0010G\u001a\u0004\bF\u0010HR\u0017\u0010\u0019\u001a\u00020\u00188\u0006¢\u0006\f\n\u0004\b;\u0010I\u001a\u0004\bJ\u0010KR\u0017\u0010\u001a\u001a\u00020\u00188\u0006¢\u0006\f\n\u0004\b6\u0010I\u001a\u0004\b<\u0010KR\u0017\u0010\u001b\u001a\u00020\u00188\u0006¢\u0006\f\n\u0004\b3\u0010I\u001a\u0004\bB\u0010K¨\u0006L"}, d2 = {"LA1/k;", "", "Landroid/content/Context;", "context", "Landroid/graphics/Bitmap$Config;", "config", "Landroid/graphics/ColorSpace;", "colorSpace", "LB1/g;", ContentDisposition.Parameters.Size, "Lcoil/size/Scale;", ConstConfig.KEY_VIEW_SCALE_PROPERTY, "", "allowInexactSize", "allowRgb565", "premultipliedAlpha", "", "diskCacheKey", "Ltb/u;", "headers", "LA1/q;", "tags", "LA1/l;", "parameters", "Lcoil/request/CachePolicy;", "memoryCachePolicy", "diskCachePolicy", "networkCachePolicy", "<init>", "(Landroid/content/Context;Landroid/graphics/Bitmap$Config;Landroid/graphics/ColorSpace;LB1/g;Lcoil/size/Scale;ZZZLjava/lang/String;Ltb/u;LA1/q;LA1/l;Lcoil/request/CachePolicy;Lcoil/request/CachePolicy;Lcoil/request/CachePolicy;)V", Const.INTENT_KEY_APIKEY, "(Landroid/content/Context;Landroid/graphics/Bitmap$Config;Landroid/graphics/ColorSpace;LB1/g;Lcoil/size/Scale;ZZZLjava/lang/String;Ltb/u;LA1/q;LA1/l;Lcoil/request/CachePolicy;Lcoil/request/CachePolicy;Lcoil/request/CachePolicy;)LA1/k;", "other", "equals", "(Ljava/lang/Object;)Z", "", "hashCode", "()I", "Landroid/content/Context;", Const.INTENT_KEY_BACKGROUND_COMMAND, "()Landroid/content/Context;", Const.INTENT_KEY_PKGNAME, "Landroid/graphics/Bitmap$Config;", "f", "()Landroid/graphics/Bitmap$Config;", "c", "Landroid/graphics/ColorSpace;", "e", "()Landroid/graphics/ColorSpace;", Const.INTENT_KEY_UMID, "LB1/g;", "o", "()LB1/g;", "Lcoil/size/Scale;", "n", "()Lcoil/size/Scale;", "Z", "()Z", Const.INTENT_KEY_BACKGROUND_NOTIFICATION, "m", Const.INTENT_KEY_BACKGROUND_NOTIFICATION_ID, "Ljava/lang/String;", "()Ljava/lang/String;", Const.INTENT_KEY_BACKGROUND_NOTIFICATION_REMOVE, "Ltb/u;", "()Ltb/u;", "k", "LA1/q;", "p", "()LA1/q;", "l", "LA1/l;", "()LA1/l;", "Lcoil/request/CachePolicy;", "getMemoryCachePolicy", "()Lcoil/request/CachePolicy;", "coil-base_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes.dex */
public final class k {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    public final Context context;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    public final Bitmap.Config config;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    public final ColorSpace colorSpace;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    public final Size size;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    public final Scale scale;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    public final boolean allowInexactSize;

    /* renamed from: g, reason: collision with root package name and from kotlin metadata */
    public final boolean allowRgb565;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    public final boolean premultipliedAlpha;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    public final String diskCacheKey;

    /* renamed from: j, reason: collision with root package name and from kotlin metadata */
    public final u headers;

    /* renamed from: k, reason: collision with root package name and from kotlin metadata */
    public final Tags tags;

    /* renamed from: l, reason: collision with root package name and from kotlin metadata */
    public final Parameters parameters;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    public final CachePolicy memoryCachePolicy;

    /* renamed from: n, reason: collision with root package name and from kotlin metadata */
    public final CachePolicy diskCachePolicy;

    /* renamed from: o, reason: collision with root package name and from kotlin metadata */
    public final CachePolicy networkCachePolicy;

    public k(Context context, Bitmap.Config config, ColorSpace colorSpace, Size size, Scale scale, boolean z10, boolean z11, boolean z12, String str, u uVar, Tags tags, Parameters parameters, CachePolicy cachePolicy, CachePolicy cachePolicy2, CachePolicy cachePolicy3) {
        this.context = context;
        this.config = config;
        this.colorSpace = colorSpace;
        this.size = size;
        this.scale = scale;
        this.allowInexactSize = z10;
        this.allowRgb565 = z11;
        this.premultipliedAlpha = z12;
        this.diskCacheKey = str;
        this.headers = uVar;
        this.tags = tags;
        this.parameters = parameters;
        this.memoryCachePolicy = cachePolicy;
        this.diskCachePolicy = cachePolicy2;
        this.networkCachePolicy = cachePolicy3;
    }

    public final k a(Context context, Bitmap.Config config, ColorSpace colorSpace, Size size, Scale scale, boolean allowInexactSize, boolean allowRgb565, boolean premultipliedAlpha, String diskCacheKey, u headers, Tags tags, Parameters parameters, CachePolicy memoryCachePolicy, CachePolicy diskCachePolicy, CachePolicy networkCachePolicy) {
        return new k(context, config, colorSpace, size, scale, allowInexactSize, allowRgb565, premultipliedAlpha, diskCacheKey, headers, tags, parameters, memoryCachePolicy, diskCachePolicy, networkCachePolicy);
    }

    /* renamed from: c, reason: from getter */
    public final boolean getAllowInexactSize() {
        return this.allowInexactSize;
    }

    /* renamed from: d, reason: from getter */
    public final boolean getAllowRgb565() {
        return this.allowRgb565;
    }

    /* renamed from: e, reason: from getter */
    public final ColorSpace getColorSpace() {
        return this.colorSpace;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof k)) {
            return false;
        }
        k kVar = (k) other;
        return kotlin.jvm.internal.p.d(this.context, kVar.context) && this.config == kVar.config && kotlin.jvm.internal.p.d(this.colorSpace, kVar.colorSpace) && kotlin.jvm.internal.p.d(this.size, kVar.size) && this.scale == kVar.scale && this.allowInexactSize == kVar.allowInexactSize && this.allowRgb565 == kVar.allowRgb565 && this.premultipliedAlpha == kVar.premultipliedAlpha && kotlin.jvm.internal.p.d(this.diskCacheKey, kVar.diskCacheKey) && kotlin.jvm.internal.p.d(this.headers, kVar.headers) && kotlin.jvm.internal.p.d(this.tags, kVar.tags) && kotlin.jvm.internal.p.d(this.parameters, kVar.parameters) && this.memoryCachePolicy == kVar.memoryCachePolicy && this.diskCachePolicy == kVar.diskCachePolicy && this.networkCachePolicy == kVar.networkCachePolicy;
    }

    /* renamed from: f, reason: from getter */
    public final Bitmap.Config getConfig() {
        return this.config;
    }

    /* renamed from: g, reason: from getter */
    public final Context getContext() {
        return this.context;
    }

    /* renamed from: h, reason: from getter */
    public final String getDiskCacheKey() {
        return this.diskCacheKey;
    }

    public int hashCode() {
        int iHashCode = ((this.context.hashCode() * 31) + this.config.hashCode()) * 31;
        ColorSpace colorSpace = this.colorSpace;
        int iHashCode2 = (((((((((((iHashCode + (colorSpace != null ? colorSpace.hashCode() : 0)) * 31) + this.size.hashCode()) * 31) + this.scale.hashCode()) * 31) + Boolean.hashCode(this.allowInexactSize)) * 31) + Boolean.hashCode(this.allowRgb565)) * 31) + Boolean.hashCode(this.premultipliedAlpha)) * 31;
        String str = this.diskCacheKey;
        return ((((((((((((iHashCode2 + (str != null ? str.hashCode() : 0)) * 31) + this.headers.hashCode()) * 31) + this.tags.hashCode()) * 31) + this.parameters.hashCode()) * 31) + this.memoryCachePolicy.hashCode()) * 31) + this.diskCachePolicy.hashCode()) * 31) + this.networkCachePolicy.hashCode();
    }

    /* renamed from: i, reason: from getter */
    public final CachePolicy getDiskCachePolicy() {
        return this.diskCachePolicy;
    }

    /* renamed from: j, reason: from getter */
    public final u getHeaders() {
        return this.headers;
    }

    /* renamed from: k, reason: from getter */
    public final CachePolicy getNetworkCachePolicy() {
        return this.networkCachePolicy;
    }

    /* renamed from: l, reason: from getter */
    public final Parameters getParameters() {
        return this.parameters;
    }

    /* renamed from: m, reason: from getter */
    public final boolean getPremultipliedAlpha() {
        return this.premultipliedAlpha;
    }

    /* renamed from: n, reason: from getter */
    public final Scale getScale() {
        return this.scale;
    }

    /* renamed from: o, reason: from getter */
    public final Size getSize() {
        return this.size;
    }

    /* renamed from: p, reason: from getter */
    public final Tags getTags() {
        return this.tags;
    }
}
