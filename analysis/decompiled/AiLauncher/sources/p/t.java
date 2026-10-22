package p;

import D.C0761b0;
import Ua.Q;
import android.graphics.Rect;
import android.hardware.camera2.CameraCharacteristics;
import android.os.Build;
import android.util.Log;
import android.util.Range;
import androidx.camera.camera2.impl.UseCaseCameraRequestControl;
import com.autonavi.aps.amapapi.config.Const;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import r.C5186d;
import t.C5473b;
import t.InterfaceC5494v;

@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\n\bf\u0018\u00002\u00020\u0001:\u0001\u000fJ%\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00070\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H&¢\u0006\u0004\b\b\u0010\tJ\u001d\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00070\u00062\u0006\u0010\u0005\u001a\u00020\u0004H&¢\u0006\u0004\b\n\u0010\u000bR\u0014\u0010\u000e\u001a\u00020\u00028&X¦\u0004¢\u0006\u0006\u001a\u0004\b\f\u0010\rR\u0014\u0010\u0010\u001a\u00020\u00028&X¦\u0004¢\u0006\u0006\u001a\u0004\b\u000f\u0010\rø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001¨\u0006\u0011À\u0006\u0001"}, d2 = {"Lp/t;", "", "", "zoomRatio", "Landroidx/camera/camera2/impl/UseCaseCameraRequestControl;", "requestControl", "LUa/Q;", "LY8/t;", "c", "(FLandroidx/camera/camera2/impl/UseCaseCameraRequestControl;)LUa/Q;", Const.INTENT_KEY_PKGNAME, "(Landroidx/camera/camera2/impl/UseCaseCameraRequestControl;)LUa/Q;", Const.INTENT_KEY_UMID, "()F", "minZoomRatio", Const.INTENT_KEY_APIKEY, "maxZoomRatio", "camera-camera2"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes.dex */
public interface t {

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\b'\u0018\u0000 \u00022\u00020\u0001:\u0001\u0002¨\u0006\u0003"}, d2 = {"Lp/t$a;", "", Const.INTENT_KEY_APIKEY, "camera-camera2"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static abstract class a {

        /* renamed from: a, reason: collision with root package name and from kotlin metadata */
        public static final Companion INSTANCE = new Companion(null);

        @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0017\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0007¢\u0006\u0004\b\u0007\u0010\b¨\u0006\t"}, d2 = {"Lp/t$a$a;", "", "<init>", "()V", "Lt/v;", "cameraProperties", "Lp/t;", Const.INTENT_KEY_APIKEY, "(Lt/v;)Lp/t;", "camera-camera2"}, k = 1, mv = {2, 1, 0}, xi = 48)
        /* renamed from: p.t$a$a, reason: collision with other inner class name and from kotlin metadata */
        public static final class Companion {
            public /* synthetic */ Companion(kotlin.jvm.internal.i iVar) {
                this();
            }

            public final t a(InterfaceC5494v cameraProperties) {
                kotlin.jvm.internal.p.i(cameraProperties, "cameraProperties");
                if (kotlin.jvm.internal.p.d("robolectric", Build.FINGERPRINT)) {
                    List<CameraCharacteristics.Key<Rect>> listA = p.INSTANCE.a();
                    if (!(listA instanceof Collection) || !listA.isEmpty()) {
                        Iterator<T> it = listA.iterator();
                        while (it.hasNext()) {
                            CameraCharacteristics.Key key = (CameraCharacteristics.Key) it.next();
                            C5473b c5473b = C5473b.f41865a;
                            if (C0761b0.k("CXCP")) {
                                Log.w(C5473b.TRUNCATED_TAG, "Failed to read " + key + " for zoom features.");
                            }
                            androidx.camera.camera2.pipe.g metadata = cameraProperties.getMetadata();
                            kotlin.jvm.internal.p.f(key);
                            if (metadata.e0(key) == null) {
                                return new p(cameraProperties);
                            }
                        }
                    }
                } else {
                    Range<Float> rangeA = C5186d.a(cameraProperties.getMetadata());
                    if (rangeA != null) {
                        return new C5019a(cameraProperties, rangeA);
                    }
                }
                return new C5026h(cameraProperties);
            }

            public Companion() {
            }
        }
    }

    /* renamed from: a */
    float getMaxZoomRatio();

    Q<Y8.t> b(UseCaseCameraRequestControl requestControl);

    Q<Y8.t> c(float zoomRatio, UseCaseCameraRequestControl requestControl);

    /* renamed from: d */
    float getMinZoomRatio();
}
