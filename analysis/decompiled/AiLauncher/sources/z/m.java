package z;

import android.content.Context;
import android.os.Build;
import android.os.Trace;
import com.autonavi.aps.amapapi.config.Const;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\b\b\u0001\u0018\u00002\u00020\u0001B\u0013\b\u0007\u0012\b\b\u0001\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\u000f\u0010\u0007\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\u0007\u0010\bR\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0007\u0010\tR\u0016\u0010\f\u001a\u00020\u00068\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\n\u0010\u000bR\u0011\u0010\r\u001a\u00020\u00068F¢\u0006\u0006\u001a\u0004\b\n\u0010\b¨\u0006\u000e"}, d2 = {"Lz/m;", "", "Landroid/content/Context;", "cameraPipeContext", "<init>", "(Landroid/content/Context;)V", "", Const.INTENT_KEY_APIKEY, "()Z", "Landroid/content/Context;", Const.INTENT_KEY_PKGNAME, "Z", "_hasCameraPermission", "hasCameraPermission", "camera-camera2-pipe"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes.dex */
public final class m {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    public final Context cameraPipeContext;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    public volatile boolean _hasCameraPermission;

    public m(Context cameraPipeContext) {
        kotlin.jvm.internal.p.i(cameraPipeContext, "cameraPipeContext");
        this.cameraPipeContext = cameraPipeContext;
    }

    public final boolean a() {
        if (kotlin.jvm.internal.p.d(Build.FINGERPRINT, "robolectric")) {
            return true;
        }
        if (!this._hasCameraPermission) {
            h hVar = h.f44503a;
            Trace.beginSection("CXCP#checkCameraPermission");
            if (this.cameraPipeContext.checkSelfPermission("android.permission.CAMERA") == 0) {
                this._hasCameraPermission = true;
            }
            Trace.endSection();
        }
        return this._hasCameraPermission;
    }

    public final boolean b() {
        return a();
    }
}
