package P;

import D.C0761b0;
import Y8.t;
import androidx.camera.core.ImageCapture;
import com.autonavi.aps.amapapi.config.Const;
import kotlin.Metadata;
import kotlin.jvm.internal.p;

@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0006\b\u0000\u0018\u0000 \u000f2\u00020\u0001:\u0001\nB\u0013\b\u0002\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0001¢\u0006\u0004\b\u0003\u0010\u0004J\u001f\u0010\n\u001a\u00020\t2\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\n\u0010\u000bJ\u000f\u0010\f\u001a\u00020\tH\u0016¢\u0006\u0004\b\f\u0010\rJ\r\u0010\u000e\u001a\u00020\t¢\u0006\u0004\b\u000e\u0010\rJ\u000f\u0010\u000f\u001a\u00020\tH\u0002¢\u0006\u0004\b\u000f\u0010\rJ\u000f\u0010\u0010\u001a\u00020\tH\u0002¢\u0006\u0004\b\u0010\u0010\rR\u0016\u0010\u0002\u001a\u0004\u0018\u00010\u00018\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\n\u0010\u0011R\u0014\u0010\u0015\u001a\u00020\u00128\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0013\u0010\u0014R\u0016\u0010\u0019\u001a\u00020\u00168\u0002@\u0002X\u0083\u000e¢\u0006\u0006\n\u0004\b\u0017\u0010\u0018R\u0018\u0010\u001b\u001a\u0004\u0018\u00010\u00078\u0002@\u0002X\u0083\u000e¢\u0006\u0006\n\u0004\b\u0010\u0010\u001a¨\u0006\u001c"}, d2 = {"LP/g;", "Landroidx/camera/core/ImageCapture$h;", "screenFlash", "<init>", "(Landroidx/camera/core/ImageCapture$h;)V", "", "expirationTimeMillis", "Landroidx/camera/core/ImageCapture$i;", "screenFlashListener", "LY8/t;", Const.INTENT_KEY_APIKEY, "(JLandroidx/camera/core/ImageCapture$i;)V", "clear", "()V", "f", "e", Const.INTENT_KEY_UMID, "Landroidx/camera/core/ImageCapture$h;", "", Const.INTENT_KEY_PKGNAME, "Ljava/lang/Object;", "lock", "", "c", "Z", "isClearScreenFlashPending", "Landroidx/camera/core/ImageCapture$i;", "pendingListener", "camera-core"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes.dex */
public final class g implements ImageCapture.h {

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    public final ImageCapture.h screenFlash;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    public final Object lock;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    public boolean isClearScreenFlashPending;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    public ImageCapture.i pendingListener;

    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0019\u0010\u0007\u001a\u00020\u00062\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0007¢\u0006\u0004\b\u0007\u0010\bR\u0014\u0010\n\u001a\u00020\t8\u0002X\u0082T¢\u0006\u0006\n\u0004\b\n\u0010\u000b¨\u0006\f"}, d2 = {"LP/g$a;", "", "<init>", "()V", "Landroidx/camera/core/ImageCapture$h;", "screenFlash", "LP/g;", Const.INTENT_KEY_APIKEY, "(Landroidx/camera/core/ImageCapture$h;)LP/g;", "", "TAG", "Ljava/lang/String;", "camera-core"}, k = 1, mv = {2, 1, 0}, xi = 48)
    /* renamed from: P.g$a, reason: from kotlin metadata */
    public static final class Companion {
        public /* synthetic */ Companion(kotlin.jvm.internal.i iVar) {
            this();
        }

        public final g a(ImageCapture.h screenFlash) {
            return new g(screenFlash, null);
        }

        public Companion() {
        }
    }

    public /* synthetic */ g(ImageCapture.h hVar, kotlin.jvm.internal.i iVar) {
        this(hVar);
    }

    public static final void c(g gVar) {
        synchronized (gVar.lock) {
            try {
                if (gVar.pendingListener == null) {
                    C0761b0.o("ScreenFlashWrapper", "apply: pendingListener is null!");
                }
                gVar.e();
                t tVar = t.f7040a;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public static final g g(ImageCapture.h hVar) {
        return INSTANCE.a(hVar);
    }

    @Override // androidx.camera.core.ImageCapture.h
    public void a(long expirationTimeMillis, ImageCapture.i screenFlashListener) {
        p.i(screenFlashListener, "screenFlashListener");
        synchronized (this.lock) {
            this.isClearScreenFlashPending = true;
            this.pendingListener = screenFlashListener;
            t tVar = t.f7040a;
        }
        ImageCapture.h hVar = this.screenFlash;
        if (hVar != null) {
            hVar.a(expirationTimeMillis, new ImageCapture.i() { // from class: P.f
                @Override // androidx.camera.core.ImageCapture.i
                public final void a() {
                    g.c(this.f5331a);
                }
            });
        } else {
            C0761b0.c("ScreenFlashWrapper", "apply: screenFlash is null!");
            e();
        }
    }

    @Override // androidx.camera.core.ImageCapture.h
    public void clear() {
        d();
    }

    public final void d() {
        synchronized (this.lock) {
            try {
                if (this.isClearScreenFlashPending) {
                    ImageCapture.h hVar = this.screenFlash;
                    if (hVar != null) {
                        hVar.clear();
                    } else {
                        C0761b0.c("ScreenFlashWrapper", "completePendingScreenFlashClear: screenFlash is null!");
                    }
                } else {
                    C0761b0.o("ScreenFlashWrapper", "completePendingScreenFlashClear: none pending!");
                }
                this.isClearScreenFlashPending = false;
                t tVar = t.f7040a;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public final void e() {
        synchronized (this.lock) {
            try {
                ImageCapture.i iVar = this.pendingListener;
                if (iVar != null) {
                    iVar.a();
                }
                this.pendingListener = null;
                t tVar = t.f7040a;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public final void f() {
        e();
        d();
    }

    public g(ImageCapture.h hVar) {
        this.screenFlash = hVar;
        this.lock = new Object();
    }
}
