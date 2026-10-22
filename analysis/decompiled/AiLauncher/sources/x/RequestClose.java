package x;

import androidx.camera.camera2.pipe.compat.ActiveCamera;
import com.autonavi.aps.amapapi.config.Const;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0006\b\u0080\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\u0010\u0010\u0007\u001a\u00020\u0006HÖ\u0001¢\u0006\u0004\b\u0007\u0010\bJ\u0010\u0010\n\u001a\u00020\tHÖ\u0001¢\u0006\u0004\b\n\u0010\u000bJ\u001a\u0010\u000f\u001a\u00020\u000e2\b\u0010\r\u001a\u0004\u0018\u00010\fHÖ\u0003¢\u0006\u0004\b\u000f\u0010\u0010R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u0011\u0010\u0013¨\u0006\u0014"}, d2 = {"Lx/B0;", "Lx/j0;", "Landroidx/camera/camera2/pipe/compat/ActiveCamera;", "activeCamera", "<init>", "(Landroidx/camera/camera2/pipe/compat/ActiveCamera;)V", "", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "", "other", "", "equals", "(Ljava/lang/Object;)Z", Const.INTENT_KEY_APIKEY, "Landroidx/camera/camera2/pipe/compat/ActiveCamera;", "()Landroidx/camera/camera2/pipe/compat/ActiveCamera;", "camera-camera2-pipe"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* renamed from: x.B0, reason: from toString */
/* loaded from: classes.dex */
public final /* data */ class RequestClose extends AbstractC5822j0 {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata and from toString */
    public final ActiveCamera activeCamera;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public RequestClose(ActiveCamera activeCamera) {
        super(null);
        kotlin.jvm.internal.p.i(activeCamera, "activeCamera");
        this.activeCamera = activeCamera;
    }

    /* renamed from: a, reason: from getter */
    public final ActiveCamera getActiveCamera() {
        return this.activeCamera;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        return (other instanceof RequestClose) && kotlin.jvm.internal.p.d(this.activeCamera, ((RequestClose) other).activeCamera);
    }

    public int hashCode() {
        return this.activeCamera.hashCode();
    }

    public String toString() {
        return "RequestClose(activeCamera=" + this.activeCamera + ')';
    }
}
