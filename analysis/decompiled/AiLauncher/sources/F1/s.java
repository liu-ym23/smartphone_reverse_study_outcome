package F1;

import android.content.ComponentCallbacks2;
import android.content.Context;
import android.content.res.Configuration;
import coil.RealImageLoader;
import com.autonavi.aps.amapapi.config.Const;
import io.ktor.http.ContentType;
import java.lang.ref.WeakReference;
import kotlin.Metadata;
import z1.C6055e;
import z1.InterfaceC6056f;

@Metadata(d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u000b\b\u0000\u0018\u0000 -2\u00020\u00012\u00020\u0002:\u0001\u0016B\u000f\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0004\b\u0005\u0010\u0006J\r\u0010\b\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ\r\u0010\n\u001a\u00020\u0007¢\u0006\u0004\b\n\u0010\tJ\u0017\u0010\r\u001a\u00020\u00072\u0006\u0010\f\u001a\u00020\u000bH\u0016¢\u0006\u0004\b\r\u0010\u000eJ\u0017\u0010\u0011\u001a\u00020\u00072\u0006\u0010\u0010\u001a\u00020\u000fH\u0016¢\u0006\u0004\b\u0011\u0010\u0012J\u000f\u0010\u0013\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\u0013\u0010\tJ\u0017\u0010\u0016\u001a\u00020\u00072\u0006\u0010\u0015\u001a\u00020\u0014H\u0016¢\u0006\u0004\b\u0016\u0010\u0017J\u000f\u0010\u0018\u001a\u00020\u0007H\u0002¢\u0006\u0004\b\u0018\u0010\tR.\u0010\u0004\u001a\u0010\u0012\f\u0012\n \u001a*\u0004\u0018\u00010\u00030\u00030\u00198\u0006X\u0087\u0004¢\u0006\u0012\n\u0004\b\u0016\u0010\u001b\u0012\u0004\b\u001e\u0010\t\u001a\u0004\b\u001c\u0010\u001dR\u0018\u0010\"\u001a\u0004\u0018\u00010\u001f8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b \u0010!R\u0018\u0010%\u001a\u0004\u0018\u00010#8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\b\u0010$R(\u0010+\u001a\u00020\u00148\u0006@\u0006X\u0087\u000e¢\u0006\u0018\n\u0004\b\u0018\u0010&\u0012\u0004\b*\u0010\t\u001a\u0004\b'\u0010(\"\u0004\b)\u0010\u0017R\u0016\u0010,\u001a\u00020\u00148\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\n\u0010&R\u0011\u0010\u0015\u001a\u00020\u00148F¢\u0006\u0006\u001a\u0004\b \u0010(¨\u0006."}, d2 = {"LF1/s;", "Landroid/content/ComponentCallbacks2;", "Lz1/f$a;", "Lcoil/RealImageLoader;", "imageLoader", "<init>", "(Lcoil/RealImageLoader;)V", "LY8/t;", "c", "()V", "e", "Landroid/content/res/Configuration;", "newConfig", "onConfigurationChanged", "(Landroid/content/res/Configuration;)V", "", "level", "onTrimMemory", "(I)V", "onLowMemory", "", "isOnline", Const.INTENT_KEY_APIKEY, "(Z)V", Const.INTENT_KEY_UMID, "Ljava/lang/ref/WeakReference;", "kotlin.jvm.PlatformType", "Ljava/lang/ref/WeakReference;", "getImageLoader", "()Ljava/lang/ref/WeakReference;", "getImageLoader$annotations", "Landroid/content/Context;", Const.INTENT_KEY_PKGNAME, "Landroid/content/Context;", ContentType.Application.TYPE, "Lz1/f;", "Lz1/f;", "networkObserver", "Z", "getShutdown", "()Z", "setShutdown", "getShutdown$annotations", "shutdown", "_isOnline", "f", "coil-base_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes.dex */
public final class s implements ComponentCallbacks2, InterfaceC6056f.a {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    public final WeakReference<RealImageLoader> imageLoader;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    public Context application;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    public InterfaceC6056f networkObserver;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    public boolean shutdown;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    public boolean _isOnline = true;

    public s(RealImageLoader realImageLoader) {
        this.imageLoader = new WeakReference<>(realImageLoader);
    }

    @Override // z1.InterfaceC6056f.a
    public synchronized void a(boolean isOnline) {
        try {
            RealImageLoader realImageLoader = this.imageLoader.get();
            if (realImageLoader != null) {
                realImageLoader.i();
                this._isOnline = isOnline;
            } else {
                e();
            }
        } catch (Throwable th) {
            throw th;
        }
    }

    public final synchronized boolean b() {
        d();
        return this._isOnline;
    }

    public final synchronized void c() {
        try {
            RealImageLoader realImageLoader = this.imageLoader.get();
            if (realImageLoader == null) {
                e();
            } else if (this.application == null) {
                Context context = realImageLoader.getContext();
                this.application = context;
                context.registerComponentCallbacks(this);
            }
        } catch (Throwable th) {
            throw th;
        }
    }

    public final synchronized void d() {
        InterfaceC6056f c6055e;
        try {
            RealImageLoader realImageLoader = this.imageLoader.get();
            if (realImageLoader == null) {
                e();
            } else if (this.networkObserver == null) {
                if (realImageLoader.getOptions().getNetworkObserverEnabled()) {
                    Context context = realImageLoader.getContext();
                    realImageLoader.i();
                    c6055e = z1.g.a(context, this, null);
                } else {
                    c6055e = new C6055e();
                }
                this.networkObserver = c6055e;
                this._isOnline = c6055e.a();
            }
        } catch (Throwable th) {
            throw th;
        }
    }

    public final synchronized void e() {
        try {
            if (this.shutdown) {
                return;
            }
            this.shutdown = true;
            Context context = this.application;
            if (context != null) {
                context.unregisterComponentCallbacks(this);
            }
            InterfaceC6056f interfaceC6056f = this.networkObserver;
            if (interfaceC6056f != null) {
                interfaceC6056f.shutdown();
            }
            this.imageLoader.clear();
        } catch (Throwable th) {
            throw th;
        }
    }

    @Override // android.content.ComponentCallbacks
    public synchronized void onConfigurationChanged(Configuration newConfig) {
        if (this.imageLoader.get() == null) {
            e();
        }
    }

    @Override // android.content.ComponentCallbacks
    public synchronized void onLowMemory() {
        onTrimMemory(80);
    }

    @Override // android.content.ComponentCallbacks2
    public synchronized void onTrimMemory(int level) {
        try {
            RealImageLoader realImageLoader = this.imageLoader.get();
            if (realImageLoader != null) {
                realImageLoader.i();
                realImageLoader.n(level);
            } else {
                e();
            }
        } catch (Throwable th) {
            throw th;
        }
    }
}
