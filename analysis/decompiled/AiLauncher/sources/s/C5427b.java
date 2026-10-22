package s;

import K.O;
import android.content.Context;
import com.autonavi.aps.amapapi.config.Const;
import kotlin.Metadata;
import t.C5491s;
import t.Q;

@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0002\b\t\b\u0007\u0018\u00002\u00020\u0001B7\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\u0006\u0010\u0007\u001a\u00020\u0006\u0012\u0006\u0010\t\u001a\u00020\b\u0012\u0006\u0010\u000b\u001a\u00020\n\u0012\u0006\u0010\r\u001a\u00020\f¢\u0006\u0004\b\u000e\u0010\u000fJ\u000f\u0010\u0010\u001a\u00020\u0002H\u0007¢\u0006\u0004\b\u0010\u0010\u0011J\u000f\u0010\u0012\u001a\u00020\u0004H\u0007¢\u0006\u0004\b\u0012\u0010\u0013J\u000f\u0010\u0014\u001a\u00020\u0006H\u0007¢\u0006\u0004\b\u0014\u0010\u0015J\u000f\u0010\u0016\u001a\u00020\bH\u0007¢\u0006\u0004\b\u0016\u0010\u0017J\u000f\u0010\u0018\u001a\u00020\nH\u0007¢\u0006\u0004\b\u0018\u0010\u0019J\u000f\u0010\u001a\u001a\u00020\fH\u0007¢\u0006\u0004\b\u001a\u0010\u001bJ\u0017\u0010\u001d\u001a\u00020\u001c2\u0006\u0010\u0003\u001a\u00020\u0002H\u0007¢\u0006\u0004\b\u001d\u0010\u001eR\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0016\u0010\u001fR\u0014\u0010\u0005\u001a\u00020\u00048\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0018\u0010 R\u0014\u0010\u0007\u001a\u00020\u00068\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0014\u0010!R\u0014\u0010\t\u001a\u00020\b8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0012\u0010\"R\u0014\u0010\u000b\u001a\u00020\n8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001a\u0010#R\u0014\u0010\r\u001a\u00020\f8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0010\u0010$¨\u0006%"}, d2 = {"Ls/b;", "", "Landroid/content/Context;", "context", "LK/O;", "cameraThreadConfig", "Landroidx/camera/camera2/pipe/h;", "cameraPipe", "Lt/s;", "camera2InteropCallbacks", "LE/a;", "cameraCoordinator", "Landroidx/camera/core/f;", "cameraXConfig", "<init>", "(Landroid/content/Context;LK/O;Landroidx/camera/camera2/pipe/h;Lt/s;LE/a;Landroidx/camera/core/f;)V", "f", "()Landroid/content/Context;", Const.INTENT_KEY_UMID, "()LK/O;", "c", "()Landroidx/camera/camera2/pipe/h;", Const.INTENT_KEY_APIKEY, "()Lt/s;", Const.INTENT_KEY_PKGNAME, "()LE/a;", "e", "()Landroidx/camera/core/f;", "Lt/Q;", Const.INTENT_KEY_BACKGROUND_COMMAND, "(Landroid/content/Context;)Lt/Q;", "Landroid/content/Context;", "LK/O;", "Landroidx/camera/camera2/pipe/h;", "Lt/s;", "LE/a;", "Landroidx/camera/core/f;", "camera-camera2"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* renamed from: s.b, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C5427b {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    public final Context context;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    public final O cameraThreadConfig;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    public final androidx.camera.camera2.pipe.h cameraPipe;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    public final C5491s camera2InteropCallbacks;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    public final E.a cameraCoordinator;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    public final androidx.camera.core.f cameraXConfig;

    public C5427b(Context context, O cameraThreadConfig, androidx.camera.camera2.pipe.h cameraPipe, C5491s camera2InteropCallbacks, E.a cameraCoordinator, androidx.camera.core.f cameraXConfig) {
        kotlin.jvm.internal.p.i(context, "context");
        kotlin.jvm.internal.p.i(cameraThreadConfig, "cameraThreadConfig");
        kotlin.jvm.internal.p.i(cameraPipe, "cameraPipe");
        kotlin.jvm.internal.p.i(camera2InteropCallbacks, "camera2InteropCallbacks");
        kotlin.jvm.internal.p.i(cameraCoordinator, "cameraCoordinator");
        kotlin.jvm.internal.p.i(cameraXConfig, "cameraXConfig");
        this.context = context;
        this.cameraThreadConfig = cameraThreadConfig;
        this.cameraPipe = cameraPipe;
        this.camera2InteropCallbacks = camera2InteropCallbacks;
        this.cameraCoordinator = cameraCoordinator;
        this.cameraXConfig = cameraXConfig;
    }

    /* renamed from: a, reason: from getter */
    public final C5491s getCamera2InteropCallbacks() {
        return this.camera2InteropCallbacks;
    }

    /* renamed from: b, reason: from getter */
    public final E.a getCameraCoordinator() {
        return this.cameraCoordinator;
    }

    /* renamed from: c, reason: from getter */
    public final androidx.camera.camera2.pipe.h getCameraPipe() {
        return this.cameraPipe;
    }

    /* renamed from: d, reason: from getter */
    public final O getCameraThreadConfig() {
        return this.cameraThreadConfig;
    }

    /* renamed from: e, reason: from getter */
    public final androidx.camera.core.f getCameraXConfig() {
        return this.cameraXConfig;
    }

    /* renamed from: f, reason: from getter */
    public final Context getContext() {
        return this.context;
    }

    public final Q g(Context context) {
        kotlin.jvm.internal.p.i(context, "context");
        return Q.INSTANCE.a(context);
    }
}
