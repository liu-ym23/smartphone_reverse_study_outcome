package x;

import androidx.camera.camera2.pipe.compat.AndroidCameraState;
import com.autonavi.aps.amapapi.config.Const;
import kotlin.Metadata;
import w.C5706l;

@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\t\b\u0080\b\u0018\u00002\u00020\u0001B\u001f\u0012\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0004¢\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\t\u001a\u00020\bHÖ\u0001¢\u0006\u0004\b\t\u0010\nJ\u0010\u0010\f\u001a\u00020\u000bHÖ\u0001¢\u0006\u0004\b\f\u0010\rJ\u001a\u0010\u0010\u001a\u00020\u000f2\b\u0010\u000e\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u0010\u0010\u0011R\u0019\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006¢\u0006\f\n\u0004\b\u0012\u0010\u0013\u001a\u0004\b\u0012\u0010\u0014R\u0019\u0010\u0005\u001a\u0004\u0018\u00010\u00048\u0006¢\u0006\f\n\u0004\b\u0015\u0010\u0016\u001a\u0004\b\u0015\u0010\u0017¨\u0006\u0018"}, d2 = {"Lx/v0;", "", "Landroidx/camera/camera2/pipe/compat/AndroidCameraState;", "cameraState", "Lw/l;", "errorCode", "<init>", "(Landroidx/camera/camera2/pipe/compat/AndroidCameraState;Lw/l;Lkotlin/jvm/internal/i;)V", "", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "other", "", "equals", "(Ljava/lang/Object;)Z", Const.INTENT_KEY_APIKEY, "Landroidx/camera/camera2/pipe/compat/AndroidCameraState;", "()Landroidx/camera/camera2/pipe/compat/AndroidCameraState;", Const.INTENT_KEY_PKGNAME, "Lw/l;", "()Lw/l;", "camera-camera2-pipe"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* renamed from: x.v0, reason: from toString */
/* loaded from: classes.dex */
public final /* data */ class OpenCameraResult {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata and from toString */
    public final AndroidCameraState cameraState;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata and from toString */
    public final C5706l errorCode;

    public /* synthetic */ OpenCameraResult(AndroidCameraState androidCameraState, C5706l c5706l, kotlin.jvm.internal.i iVar) {
        this(androidCameraState, c5706l);
    }

    /* renamed from: a, reason: from getter */
    public final AndroidCameraState getCameraState() {
        return this.cameraState;
    }

    /* renamed from: b, reason: from getter */
    public final C5706l getErrorCode() {
        return this.errorCode;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof OpenCameraResult)) {
            return false;
        }
        OpenCameraResult openCameraResult = (OpenCameraResult) other;
        return kotlin.jvm.internal.p.d(this.cameraState, openCameraResult.cameraState) && kotlin.jvm.internal.p.d(this.errorCode, openCameraResult.errorCode);
    }

    public int hashCode() {
        AndroidCameraState androidCameraState = this.cameraState;
        int iHashCode = (androidCameraState == null ? 0 : androidCameraState.hashCode()) * 31;
        C5706l c5706l = this.errorCode;
        return iHashCode + (c5706l != null ? C5706l.s(c5706l.getValue()) : 0);
    }

    public String toString() {
        return "OpenCameraResult(cameraState=" + this.cameraState + ", errorCode=" + this.errorCode + ')';
    }

    public OpenCameraResult(AndroidCameraState androidCameraState, C5706l c5706l) {
        this.cameraState = androidCameraState;
        this.errorCode = c5706l;
    }

    public /* synthetic */ OpenCameraResult(AndroidCameraState androidCameraState, C5706l c5706l, int i10, kotlin.jvm.internal.i iVar) {
        this((i10 & 1) != 0 ? null : androidCameraState, (i10 & 2) != 0 ? null : c5706l, null);
    }
}
