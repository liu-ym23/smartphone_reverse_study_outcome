package u;

import D.C0761b0;
import Z8.r;
import android.hardware.camera2.CameraAccessException;
import android.hardware.camera2.CameraCharacteristics;
import android.os.Build;
import android.util.Log;
import androidx.camera.core.InitializationException;
import com.autonavi.aps.amapapi.config.Const;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.p;
import t.C5473b;
import w.C5708n;
import w.InterfaceC5705k;

@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J+\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00070\u00062\u0006\u0010\u0005\u001a\u00020\u00042\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006H\u0007¢\u0006\u0004\b\t\u0010\nJ\u001f\u0010\r\u001a\u00020\f2\u0006\u0010\u000b\u001a\u00020\u00072\u0006\u0010\u0005\u001a\u00020\u0004H\u0007¢\u0006\u0004\b\r\u0010\u000e¨\u0006\u000f"}, d2 = {"Lu/a;", "", "<init>", "()V", "Lw/k;", "cameraDevices", "", "", "availableCameraIds", Const.INTENT_KEY_APIKEY, "(Lw/k;Ljava/util/List;)Ljava/util/List;", "cameraId", "", Const.INTENT_KEY_PKGNAME, "(Ljava/lang/String;Lw/k;)Z", "camera-camera2"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* renamed from: u.a, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C5553a {

    /* renamed from: a, reason: collision with root package name */
    public static final C5553a f42360a = new C5553a();

    public static final List<String> a(InterfaceC5705k cameraDevices, List<String> availableCameraIds) {
        p.i(cameraDevices, "cameraDevices");
        p.i(availableCameraIds, "availableCameraIds");
        ArrayList arrayList = new ArrayList();
        for (String str : availableCameraIds) {
            if (p.d(str, "0") || p.d(str, "1")) {
                arrayList.add(str);
            } else if (b(str, cameraDevices)) {
                arrayList.add(str);
            } else {
                C5473b c5473b = C5473b.f41865a;
                if (C0761b0.f("CXCP")) {
                    Log.d(C5473b.TRUNCATED_TAG, "Camera " + str + " is filtered out because its capabilities do not contain REQUEST_AVAILABLE_CAPABILITIES_BACKWARD_COMPATIBLE.");
                }
            }
        }
        return arrayList;
    }

    public static final boolean b(String cameraId, InterfaceC5705k cameraDevices) throws InitializationException {
        p.i(cameraId, "cameraId");
        p.i(cameraDevices, "cameraDevices");
        if (p.d(Build.FINGERPRINT, "robolectric")) {
            C5473b c5473b = C5473b.f41865a;
            if (!C0761b0.f("CXCP")) {
                return true;
            }
            Log.d(C5473b.TRUNCATED_TAG, "isBackwardCompatible method returns true because robolectric build detected.");
            return true;
        }
        try {
            androidx.camera.camera2.pipe.g gVarA = InterfaceC5705k.a(cameraDevices, C5708n.b(cameraId), null, 2, null);
            if (gVarA == null) {
                throw new IllegalStateException("Required value was null.");
            }
            CameraCharacteristics.Key REQUEST_AVAILABLE_CAPABILITIES = CameraCharacteristics.REQUEST_AVAILABLE_CAPABILITIES;
            p.h(REQUEST_AVAILABLE_CAPABILITIES, "REQUEST_AVAILABLE_CAPABILITIES");
            int[] iArr = (int[]) gVarA.e0(REQUEST_AVAILABLE_CAPABILITIES);
            if (iArr != null) {
                return r.P(iArr, 0);
            }
            return false;
        } catch (CameraAccessException e10) {
            C5473b c5473b2 = C5473b.f41865a;
            if (C0761b0.g("CXCP")) {
                Log.e(C5473b.TRUNCATED_TAG, "Error while accessing metadata for cameraID: " + cameraId, e10);
            }
            throw new InitializationException(e10);
        }
    }
}
