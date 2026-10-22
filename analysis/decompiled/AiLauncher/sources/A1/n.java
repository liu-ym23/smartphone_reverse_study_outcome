package A1;

import B1.Size;
import B1.c;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.view.Lifecycle;
import android.view.View;
import coil.request.CachePolicy;
import coil.request.NullRequestDataException;
import coil.size.Scale;
import com.autonavi.aps.amapapi.config.Const;
import io.ktor.http.ContentDisposition;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000b\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0003\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0000\u0018\u00002\u00020\u0001B!\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006¢\u0006\u0004\b\b\u0010\tJ\u001d\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\r\u001a\u00020\f¢\u0006\u0004\b\u000f\u0010\u0010J\u001d\u0010\u0015\u001a\u00020\u00142\u0006\u0010\u0011\u001a\u00020\n2\u0006\u0010\u0013\u001a\u00020\u0012¢\u0006\u0004\b\u0015\u0010\u0016J\u001d\u0010\u001a\u001a\u00020\u00192\u0006\u0010\u0011\u001a\u00020\n2\u0006\u0010\u0018\u001a\u00020\u0017¢\u0006\u0004\b\u001a\u0010\u001bJ\u001d\u0010\u001f\u001a\u00020\u001e2\u0006\u0010\u0011\u001a\u00020\n2\u0006\u0010\u001d\u001a\u00020\u001c¢\u0006\u0004\b\u001f\u0010 J\u0015\u0010\"\u001a\u00020\u00192\u0006\u0010!\u001a\u00020\u0019¢\u0006\u0004\b\"\u0010#J\u0017\u0010$\u001a\u00020\u001e2\u0006\u0010!\u001a\u00020\u0019H\u0003¢\u0006\u0004\b$\u0010%J\u001f\u0010&\u001a\u00020\u001e2\u0006\u0010\u0011\u001a\u00020\n2\u0006\u0010\u0018\u001a\u00020\u0017H\u0002¢\u0006\u0004\b&\u0010'J\u0017\u0010(\u001a\u00020\u001e2\u0006\u0010\u0011\u001a\u00020\nH\u0002¢\u0006\u0004\b(\u0010)R\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0015\u0010*R\u0014\u0010\u0005\u001a\u00020\u00048\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b$\u0010+R\u0014\u0010.\u001a\u00020,8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001f\u0010-¨\u0006/"}, d2 = {"LA1/n;", "", "Lcoil/c;", "imageLoader", "LF1/s;", "systemCallbacks", "LF1/q;", "logger", "<init>", "(Lcoil/c;LF1/s;LF1/q;)V", "LA1/g;", "initialRequest", "Lkotlinx/coroutines/g;", "job", "LA1/m;", Const.INTENT_KEY_BACKGROUND_COMMAND, "(LA1/g;Lkotlinx/coroutines/g;)LA1/m;", "request", "", "throwable", "LA1/e;", Const.INTENT_KEY_APIKEY, "(LA1/g;Ljava/lang/Throwable;)LA1/e;", "LB1/g;", ContentDisposition.Parameters.Size, "LA1/k;", "f", "(LA1/g;LB1/g;)LA1/k;", "Landroid/graphics/Bitmap$Config;", "requestedConfig", "", "c", "(LA1/g;Landroid/graphics/Bitmap$Config;)Z", "options", Const.INTENT_KEY_BACKGROUND_NOTIFICATION, "(LA1/k;)LA1/k;", Const.INTENT_KEY_PKGNAME, "(LA1/k;)Z", Const.INTENT_KEY_UMID, "(LA1/g;LB1/g;)Z", "e", "(LA1/g;)Z", "Lcoil/c;", "LF1/s;", "LF1/n;", "LF1/n;", "hardwareBitmapService", "coil-base_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes.dex */
public final class n {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    public final coil.c imageLoader;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    public final F1.s systemCallbacks;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    public final F1.n hardwareBitmapService;

    public n(coil.c cVar, F1.s sVar, F1.q qVar) {
        this.imageLoader = cVar;
        this.systemCallbacks = sVar;
        this.hardwareBitmapService = F1.f.a(qVar);
    }

    public final e a(g request, Throwable throwable) {
        Drawable drawableT;
        if (!(throwable instanceof NullRequestDataException) || (drawableT = request.u()) == null) {
            drawableT = request.t();
        }
        return new e(drawableT, request, throwable);
    }

    public final boolean b(k options) {
        return !F1.a.d(options.getConfig()) || this.hardwareBitmapService.getAllowHardware();
    }

    public final boolean c(g request, Bitmap.Config requestedConfig) {
        if (!F1.a.d(requestedConfig)) {
            return true;
        }
        if (!request.getAllowHardware()) {
            return false;
        }
        C1.c target = request.getTarget();
        if (target instanceof C1.d) {
            View view = ((C1.d) target).getView();
            if (view.isAttachedToWindow() && !view.isHardwareAccelerated()) {
                return false;
            }
        }
        return true;
    }

    public final boolean d(g request, Size size) {
        if (F1.a.d(request.getBitmapConfig())) {
            return c(request, request.getBitmapConfig()) && this.hardwareBitmapService.b(size);
        }
        return true;
    }

    public final boolean e(g request) {
        return request.O().isEmpty() || Z8.r.R(F1.j.o(), request.getBitmapConfig());
    }

    public final k f(g request, Size size) {
        Bitmap.Config bitmapConfig = (e(request) && d(request, size)) ? request.getBitmapConfig() : Bitmap.Config.ARGB_8888;
        B1.c cVarD = size.d();
        c.b bVar = c.b.f1417a;
        return new k(request.getContext(), bitmapConfig, request.getColorSpace(), size, (kotlin.jvm.internal.p.d(cVarD, bVar) || kotlin.jvm.internal.p.d(size.c(), bVar)) ? Scale.FIT : request.getCom.stepos.launcher.assistant.slidepanel.ConstConfig.KEY_VIEW_SCALE_PROPERTY java.lang.String(), F1.h.a(request), request.getAllowRgb565() && request.O().isEmpty() && bitmapConfig != Bitmap.Config.ALPHA_8, request.getPremultipliedAlpha(), request.getDiskCacheKey(), request.getHeaders(), request.getTags(), request.getParameters(), request.getMemoryCachePolicy(), request.getDiskCachePolicy(), request.getNetworkCachePolicy());
    }

    public final m g(g initialRequest, kotlinx.coroutines.g job) {
        Lifecycle lifecycle = initialRequest.getLifecycle();
        C1.c target = initialRequest.getTarget();
        return target instanceof C1.d ? new s(this.imageLoader, initialRequest, (C1.d) target, lifecycle, job) : new a(lifecycle, job);
    }

    public final k h(k options) {
        boolean z10;
        Bitmap.Config config = options.getConfig();
        CachePolicy networkCachePolicy = options.getNetworkCachePolicy();
        boolean z11 = true;
        if (b(options)) {
            z10 = false;
        } else {
            config = Bitmap.Config.ARGB_8888;
            z10 = true;
        }
        Bitmap.Config config2 = config;
        if (!options.getNetworkCachePolicy().getReadEnabled() || this.systemCallbacks.b()) {
            z11 = z10;
        } else {
            networkCachePolicy = CachePolicy.DISABLED;
        }
        return z11 ? options.a((16381 & 1) != 0 ? options.context : null, (16381 & 2) != 0 ? options.config : config2, (16381 & 4) != 0 ? options.colorSpace : null, (16381 & 8) != 0 ? options.size : null, (16381 & 16) != 0 ? options.com.stepos.launcher.assistant.slidepanel.ConstConfig.KEY_VIEW_SCALE_PROPERTY java.lang.String : null, (16381 & 32) != 0 ? options.allowInexactSize : false, (16381 & 64) != 0 ? options.allowRgb565 : false, (16381 & 128) != 0 ? options.premultipliedAlpha : false, (16381 & 256) != 0 ? options.diskCacheKey : null, (16381 & 512) != 0 ? options.headers : null, (16381 & 1024) != 0 ? options.tags : null, (16381 & 2048) != 0 ? options.parameters : null, (16381 & 4096) != 0 ? options.memoryCachePolicy : null, (16381 & com.stepos.agentframework.chatui.longtext.b.THRESHOLD) != 0 ? options.diskCachePolicy : null, (16381 & 16384) != 0 ? options.networkCachePolicy : networkCachePolicy) : options;
    }
}
