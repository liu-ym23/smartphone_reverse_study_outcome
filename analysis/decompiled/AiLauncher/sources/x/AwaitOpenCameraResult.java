package x;

import androidx.camera.camera2.pipe.compat.AndroidCameraState;
import com.autonavi.aps.amapapi.config.Const;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\t\b\u0080\b\u0018\u00002\u00020\u0001B\u001f\u0012\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0004¢\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\t\u001a\u00020\bHÖ\u0001¢\u0006\u0004\b\t\u0010\nJ\u0010\u0010\f\u001a\u00020\u000bHÖ\u0001¢\u0006\u0004\b\f\u0010\rJ\u001a\u0010\u0010\u001a\u00020\u000f2\b\u0010\u000e\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u0010\u0010\u0011R\u0019\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006¢\u0006\f\n\u0004\b\u0012\u0010\u0013\u001a\u0004\b\u0014\u0010\u0015R\u0019\u0010\u0005\u001a\u0004\u0018\u00010\u00048\u0006¢\u0006\f\n\u0004\b\u0014\u0010\u0016\u001a\u0004\b\u0012\u0010\u0017¨\u0006\u0018"}, d2 = {"Lx/x;", "", "Landroidx/camera/camera2/pipe/compat/p;", "cameraDeviceWrapper", "Landroidx/camera/camera2/pipe/compat/AndroidCameraState;", "androidCameraState", "<init>", "(Landroidx/camera/camera2/pipe/compat/p;Landroidx/camera/camera2/pipe/compat/AndroidCameraState;)V", "", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "other", "", "equals", "(Ljava/lang/Object;)Z", Const.INTENT_KEY_APIKEY, "Landroidx/camera/camera2/pipe/compat/p;", Const.INTENT_KEY_PKGNAME, "()Landroidx/camera/camera2/pipe/compat/p;", "Landroidx/camera/camera2/pipe/compat/AndroidCameraState;", "()Landroidx/camera/camera2/pipe/compat/AndroidCameraState;", "camera-camera2-pipe"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* renamed from: x.x, reason: case insensitive filesystem and from toString */
/* loaded from: classes.dex */
public final /* data */ class AwaitOpenCameraResult {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata and from toString */
    public final androidx.camera.camera2.pipe.compat.p cameraDeviceWrapper;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata and from toString */
    public final AndroidCameraState androidCameraState;

    /* JADX WARN: Multi-variable type inference failed */
    public AwaitOpenCameraResult() {
        this(null, 0 == true ? 1 : 0, 3, 0 == true ? 1 : 0);
    }

    /* renamed from: a, reason: from getter */
    public final AndroidCameraState getAndroidCameraState() {
        return this.androidCameraState;
    }

    /* renamed from: b, reason: from getter */
    public final androidx.camera.camera2.pipe.compat.p getCameraDeviceWrapper() {
        return this.cameraDeviceWrapper;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof AwaitOpenCameraResult)) {
            return false;
        }
        AwaitOpenCameraResult awaitOpenCameraResult = (AwaitOpenCameraResult) other;
        return kotlin.jvm.internal.p.d(this.cameraDeviceWrapper, awaitOpenCameraResult.cameraDeviceWrapper) && kotlin.jvm.internal.p.d(this.androidCameraState, awaitOpenCameraResult.androidCameraState);
    }

    public int hashCode() {
        androidx.camera.camera2.pipe.compat.p pVar = this.cameraDeviceWrapper;
        int iHashCode = (pVar == null ? 0 : pVar.hashCode()) * 31;
        AndroidCameraState androidCameraState = this.androidCameraState;
        return iHashCode + (androidCameraState != null ? androidCameraState.hashCode() : 0);
    }

    public String toString() {
        return "AwaitOpenCameraResult(cameraDeviceWrapper=" + this.cameraDeviceWrapper + ", androidCameraState=" + this.androidCameraState + ')';
    }

    public AwaitOpenCameraResult(androidx.camera.camera2.pipe.compat.p pVar, AndroidCameraState androidCameraState) {
        this.cameraDeviceWrapper = pVar;
        this.androidCameraState = androidCameraState;
    }

    public /* synthetic */ AwaitOpenCameraResult(androidx.camera.camera2.pipe.compat.p pVar, AndroidCameraState androidCameraState, int i10, kotlin.jvm.internal.i iVar) {
        this((i10 & 1) != 0 ? null : pVar, (i10 & 2) != 0 ? null : androidCameraState);
    }
}
