package t;

import D.C0761b0;
import android.util.Log;
import androidx.camera.camera2.impl.UseCaseCameraRequestControl;
import com.autonavi.aps.amapapi.config.Const;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0007\u0018\u00002\u00020\u0001B\t\b\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u000f\u0010\u0005\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0005\u0010\u0003J\r\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\u0007\u0010\bR$\u0010\u000f\u001a\u0004\u0018\u00010\t8\u0016@\u0016X\u0096\u000e¢\u0006\u0012\n\u0004\b\u0007\u0010\n\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\u0014\u0010\u0012\u001a\u00020\u00108\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\r\u0010\u0011¨\u0006\u0013"}, d2 = {"Lt/z0;", "Lt/j0;", "<init>", "()V", "LY8/t;", "reset", "", Const.INTENT_KEY_APIKEY, "()Z", "Landroidx/camera/camera2/impl/UseCaseCameraRequestControl;", "Landroidx/camera/camera2/impl/UseCaseCameraRequestControl;", "getRequestControl", "()Landroidx/camera/camera2/impl/UseCaseCameraRequestControl;", Const.INTENT_KEY_PKGNAME, "(Landroidx/camera/camera2/impl/UseCaseCameraRequestControl;)V", "requestControl", "LOa/c;", "LOa/c;", "videoUsage", "camera-camera2"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes.dex */
public final class z0 implements j0 {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    public UseCaseCameraRequestControl requestControl;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    public final Oa.c videoUsage = Oa.b.c(0);

    public final boolean a() {
        int value = this.videoUsage.getValue();
        C5473b c5473b = C5473b.f41865a;
        if (C0761b0.f("CXCP")) {
            Log.d(C5473b.TRUNCATED_TAG, "isInVideoUsage: videoUsage = " + value);
        }
        return value > 0;
    }

    @Override // t.j0
    public void b(UseCaseCameraRequestControl useCaseCameraRequestControl) {
        this.requestControl = useCaseCameraRequestControl;
    }

    @Override // t.j0
    public void reset() {
        this.videoUsage.e(0);
        C5473b c5473b = C5473b.f41865a;
        if (C0761b0.f("CXCP")) {
            Log.d(C5473b.TRUNCATED_TAG, "reset: videoUsage = 0");
        }
    }
}
