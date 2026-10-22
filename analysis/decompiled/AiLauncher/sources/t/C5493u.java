package t;

import com.autonavi.aps.amapapi.config.Const;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0007\u0018\u00002\u00020\u0001B\u001b\b\u0007\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004¢\u0006\u0004\b\u0006\u0010\u0007R\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\b\u0010\tR\u0016\u0010\u0005\u001a\u0004\u0018\u00010\u00048\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\n\u0010\u000bR\u001a\u0010\u000f\u001a\u00020\u00048\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\f\u0010\u000b\u001a\u0004\b\r\u0010\u000eR\u0014\u0010\u0013\u001a\u00020\u00108VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0011\u0010\u0012¨\u0006\u0014"}, d2 = {"Lt/u;", "Lt/v;", "Ls/m;", "cameraConfig", "Landroidx/camera/camera2/pipe/g;", "cameraMetadata", "<init>", "(Ls/m;Landroidx/camera/camera2/pipe/g;)V", Const.INTENT_KEY_APIKEY, "Ls/m;", Const.INTENT_KEY_PKGNAME, "Landroidx/camera/camera2/pipe/g;", "c", "getMetadata", "()Landroidx/camera/camera2/pipe/g;", "metadata", "Lw/n;", Const.INTENT_KEY_BACKGROUND_COMMAND, "()Ljava/lang/String;", "cameraId", "camera-camera2"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* renamed from: t.u, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C5493u implements InterfaceC5494v {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    public final s.m cameraConfig;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    public final androidx.camera.camera2.pipe.g cameraMetadata;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    public final androidx.camera.camera2.pipe.g metadata;

    public C5493u(s.m cameraConfig, androidx.camera.camera2.pipe.g gVar) {
        kotlin.jvm.internal.p.i(cameraConfig, "cameraConfig");
        this.cameraConfig = cameraConfig;
        this.cameraMetadata = gVar;
        kotlin.jvm.internal.p.f(gVar);
        this.metadata = gVar;
    }

    @Override // t.InterfaceC5494v
    public String g() {
        return this.cameraConfig.getCameraId();
    }

    @Override // t.InterfaceC5494v
    public androidx.camera.camera2.pipe.g getMetadata() {
        return this.metadata;
    }
}
