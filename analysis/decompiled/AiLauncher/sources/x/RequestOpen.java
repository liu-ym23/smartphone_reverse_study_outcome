package x;

import androidx.camera.camera2.pipe.compat.VirtualCameraState;
import com.autonavi.aps.amapapi.config.Const;
import java.util.List;
import kotlin.Metadata;
import p9.InterfaceC5074l;
import w.C5708n;

@Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u0014\b\u0080\b\u0018\u00002\u00020\u0001BA\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004\u0012\u0006\u0010\b\u001a\u00020\u0007\u0012\u0006\u0010\n\u001a\u00020\t\u0012\u0012\u0010\r\u001a\u000e\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\t0\u000b¢\u0006\u0004\b\u000e\u0010\u000fJ\u0010\u0010\u0011\u001a\u00020\u0010HÖ\u0001¢\u0006\u0004\b\u0011\u0010\u0012J\u0010\u0010\u0014\u001a\u00020\u0013HÖ\u0001¢\u0006\u0004\b\u0014\u0010\u0015J\u001a\u0010\u0018\u001a\u00020\t2\b\u0010\u0017\u001a\u0004\u0018\u00010\u0016HÖ\u0003¢\u0006\u0004\b\u0018\u0010\u0019R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u001a\u0010\u001b\u001a\u0004\b\u001c\u0010\u001dR\u001d\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u00048\u0006¢\u0006\f\n\u0004\b\u001c\u0010\u001e\u001a\u0004\b\u001a\u0010\u001fR\u0017\u0010\b\u001a\u00020\u00078\u0006¢\u0006\f\n\u0004\b \u0010!\u001a\u0004\b\"\u0010#R\u0017\u0010\n\u001a\u00020\t8\u0006¢\u0006\f\n\u0004\b$\u0010%\u001a\u0004\b$\u0010&R#\u0010\r\u001a\u000e\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\t0\u000b8\u0006¢\u0006\f\n\u0004\b'\u0010(\u001a\u0004\b \u0010)¨\u0006*"}, d2 = {"Lx/E0;", "Lx/j0;", "Landroidx/camera/camera2/pipe/compat/VirtualCameraState;", "virtualCamera", "", "Lw/n;", "sharedCameraIds", "LA/e;", "graphListener", "", "isPrewarm", "Lkotlin/Function1;", "LY8/t;", "isForegroundObserver", "<init>", "(Landroidx/camera/camera2/pipe/compat/VirtualCameraState;Ljava/util/List;LA/e;ZLp9/l;)V", "", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "", "other", "equals", "(Ljava/lang/Object;)Z", Const.INTENT_KEY_APIKEY, "Landroidx/camera/camera2/pipe/compat/VirtualCameraState;", Const.INTENT_KEY_PKGNAME, "()Landroidx/camera/camera2/pipe/compat/VirtualCameraState;", "Ljava/util/List;", "()Ljava/util/List;", "c", "LA/e;", "getGraphListener", "()LA/e;", Const.INTENT_KEY_UMID, "Z", "()Z", "e", "Lp9/l;", "()Lp9/l;", "camera-camera2-pipe"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* renamed from: x.E0, reason: from toString */
/* loaded from: classes.dex */
public final /* data */ class RequestOpen extends AbstractC5822j0 {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata and from toString */
    public final VirtualCameraState virtualCamera;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata and from toString */
    public final List<C5708n> sharedCameraIds;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata and from toString */
    public final A.e graphListener;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata and from toString */
    public final boolean isPrewarm;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata and from toString */
    public final InterfaceC5074l<Y8.t, Boolean> isForegroundObserver;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public RequestOpen(VirtualCameraState virtualCamera, List<C5708n> sharedCameraIds, A.e graphListener, boolean z10, InterfaceC5074l<? super Y8.t, Boolean> isForegroundObserver) {
        super(null);
        kotlin.jvm.internal.p.i(virtualCamera, "virtualCamera");
        kotlin.jvm.internal.p.i(sharedCameraIds, "sharedCameraIds");
        kotlin.jvm.internal.p.i(graphListener, "graphListener");
        kotlin.jvm.internal.p.i(isForegroundObserver, "isForegroundObserver");
        this.virtualCamera = virtualCamera;
        this.sharedCameraIds = sharedCameraIds;
        this.graphListener = graphListener;
        this.isPrewarm = z10;
        this.isForegroundObserver = isForegroundObserver;
    }

    public final List<C5708n> a() {
        return this.sharedCameraIds;
    }

    /* renamed from: b, reason: from getter */
    public final VirtualCameraState getVirtualCamera() {
        return this.virtualCamera;
    }

    public final InterfaceC5074l<Y8.t, Boolean> c() {
        return this.isForegroundObserver;
    }

    /* renamed from: d, reason: from getter */
    public final boolean getIsPrewarm() {
        return this.isPrewarm;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof RequestOpen)) {
            return false;
        }
        RequestOpen requestOpen = (RequestOpen) other;
        return kotlin.jvm.internal.p.d(this.virtualCamera, requestOpen.virtualCamera) && kotlin.jvm.internal.p.d(this.sharedCameraIds, requestOpen.sharedCameraIds) && kotlin.jvm.internal.p.d(this.graphListener, requestOpen.graphListener) && this.isPrewarm == requestOpen.isPrewarm && kotlin.jvm.internal.p.d(this.isForegroundObserver, requestOpen.isForegroundObserver);
    }

    public int hashCode() {
        return (((((((this.virtualCamera.hashCode() * 31) + this.sharedCameraIds.hashCode()) * 31) + this.graphListener.hashCode()) * 31) + Boolean.hashCode(this.isPrewarm)) * 31) + this.isForegroundObserver.hashCode();
    }

    public String toString() {
        return "RequestOpen(virtualCamera=" + this.virtualCamera + ", sharedCameraIds=" + this.sharedCameraIds + ", graphListener=" + this.graphListener + ", isPrewarm=" + this.isPrewarm + ", isForegroundObserver=" + this.isForegroundObserver + ')';
    }
}
