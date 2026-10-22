package u;

import M.o;
import android.graphics.Rect;
import android.hardware.camera2.CameraCharacteristics;
import android.util.Log;
import android.util.Size;
import android.util.SizeF;
import com.autonavi.aps.amapapi.config.Const;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.p;
import w.C5708n;
import w.InterfaceC5705k;

@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0007\n\u0002\u0010\b\n\u0002\b\u0007\b\u0007\u0018\u00002\u00020\u0001B\u0011\b\u0007\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\u0019\u0010\t\u001a\u0004\u0018\u00010\b2\u0006\u0010\u0007\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\t\u0010\nJ\u0013\u0010\u000b\u001a\u00020\b*\u00020\u0006H\u0002¢\u0006\u0004\b\u000b\u0010\fJ\u0013\u0010\r\u001a\u00020\b*\u00020\u0006H\u0002¢\u0006\u0004\b\r\u0010\fJ\u001f\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u000e\u001a\u00020\b2\u0006\u0010\u000f\u001a\u00020\bH\u0003¢\u0006\u0004\b\u0011\u0010\u0012J\u0013\u0010\u0013\u001a\u00020\u0010*\u00020\u0006H\u0002¢\u0006\u0004\b\u0013\u0010\u0014J\u0013\u0010\u0015\u001a\u00020\u0010*\u00020\u0006H\u0002¢\u0006\u0004\b\u0015\u0010\u0014R\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\t\u0010\u0016¨\u0006\u0017"}, d2 = {"Lu/k;", "Lu/j;", "Lw/k;", "cameraDevices", "<init>", "(Lw/k;)V", "Landroidx/camera/camera2/pipe/g;", "cameraMetadata", "", Const.INTENT_KEY_APIKEY, "(Landroidx/camera/camera2/pipe/g;)Ljava/lang/Float;", Const.INTENT_KEY_UMID, "(Landroidx/camera/camera2/pipe/g;)F", "f", "focalLength", "sensorLength", "", Const.INTENT_KEY_PKGNAME, "(FF)I", "e", "(Landroidx/camera/camera2/pipe/g;)I", "c", "Lw/k;", "camera-camera2"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* renamed from: u.k, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C5563k implements InterfaceC5562j {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    public final InterfaceC5705k cameraDevices;

    public C5563k(InterfaceC5705k cameraDevices) {
        p.i(cameraDevices, "cameraDevices");
        this.cameraDevices = cameraDevices;
    }

    @Override // u.InterfaceC5562j
    public Float a(androidx.camera.camera2.pipe.g cameraMetadata) {
        p.i(cameraMetadata, "cameraMetadata");
        try {
            return Float.valueOf(c(cameraMetadata) / e(cameraMetadata));
        } catch (Exception e10) {
            if (!z.k.f44508a.b()) {
                return null;
            }
            Log.e("CXCP", "Failed to get the intrinsic zoom ratio", e10);
            return null;
        }
    }

    public final int b(float focalLength, float sensorLength) {
        B0.h.b(focalLength > 0.0f, "Focal length should be positive.");
        B0.h.b(sensorLength > 0.0f, "Sensor length should be positive.");
        int degrees = (int) Math.toDegrees(2 * Math.atan(sensorLength / (2 * focalLength)));
        B0.h.c(degrees, 0, 360, "The provided focal length and sensor length result in an invalid view angle degrees.");
        return degrees;
    }

    public final int c(androidx.camera.camera2.pipe.g gVar) throws IllegalStateException {
        try {
            Object objG = B0.h.g(InterfaceC5705k.g(this.cameraDevices, null, 1, null), "Failed to get available camera IDs");
            p.h(objG, "checkNotNull(...)");
            Iterator it = ((List) objG).iterator();
            while (it.hasNext()) {
                String value = ((C5708n) it.next()).getValue();
                Object objG2 = B0.h.g(InterfaceC5705k.a(this.cameraDevices, value, null, 2, null), "Failed to get CameraMetadata for " + ((Object) C5708n.f(value)));
                p.h(objG2, "checkNotNull(...)");
                androidx.camera.camera2.pipe.g gVar2 = (androidx.camera.camera2.pipe.g) objG2;
                CameraCharacteristics.Key LENS_FACING = CameraCharacteristics.LENS_FACING;
                p.h(LENS_FACING, "LENS_FACING");
                Object objG3 = B0.h.g(gVar2.e0(LENS_FACING), "Failed to get CameraCharacteristics.LENS_FACING for " + ((Object) C5708n.f(value)));
                p.h(objG3, "checkNotNull(...)");
                int iIntValue = ((Number) objG3).intValue();
                p.h(LENS_FACING, "LENS_FACING");
                Object objG4 = B0.h.g(gVar.e0(LENS_FACING), "Failed to get the required LENS_FACING for " + ((Object) C5708n.f(gVar.b())));
                p.h(objG4, "checkNotNull(...)");
                if (iIntValue == ((Number) objG4).intValue()) {
                    return b(d(gVar2), f(gVar2));
                }
            }
            throw new IllegalStateException("Could not find the default camera for " + ((Object) C5708n.f(gVar.b())));
        } catch (Exception e10) {
            throw new IllegalStateException("Failed to get a valid view angle", e10);
        }
    }

    public final float d(androidx.camera.camera2.pipe.g gVar) {
        CameraCharacteristics.Key LENS_INFO_AVAILABLE_FOCAL_LENGTHS = CameraCharacteristics.LENS_INFO_AVAILABLE_FOCAL_LENGTHS;
        p.h(LENS_INFO_AVAILABLE_FOCAL_LENGTHS, "LENS_INFO_AVAILABLE_FOCAL_LENGTHS");
        Object objG = B0.h.g(gVar.e0(LENS_INFO_AVAILABLE_FOCAL_LENGTHS), "The focal lengths can not be empty.");
        p.h(objG, "checkNotNull(...)");
        float[] fArr = (float[]) objG;
        B0.h.i(!(fArr.length == 0), "The focal lengths can not be empty.");
        return fArr[0];
    }

    public final int e(androidx.camera.camera2.pipe.g gVar) throws IllegalStateException {
        try {
            return b(d(gVar), f(gVar));
        } catch (Exception e10) {
            throw new IllegalStateException("Failed to get a valid view angle", e10);
        }
    }

    public final float f(androidx.camera.camera2.pipe.g gVar) {
        CameraCharacteristics.Key SENSOR_INFO_PHYSICAL_SIZE = CameraCharacteristics.SENSOR_INFO_PHYSICAL_SIZE;
        p.h(SENSOR_INFO_PHYSICAL_SIZE, "SENSOR_INFO_PHYSICAL_SIZE");
        Object objG = B0.h.g(gVar.e0(SENSOR_INFO_PHYSICAL_SIZE), "The sensor size can't be null.");
        p.h(objG, "checkNotNull(...)");
        SizeF sizeFN = (SizeF) objG;
        CameraCharacteristics.Key SENSOR_INFO_ACTIVE_ARRAY_SIZE = CameraCharacteristics.SENSOR_INFO_ACTIVE_ARRAY_SIZE;
        p.h(SENSOR_INFO_ACTIVE_ARRAY_SIZE, "SENSOR_INFO_ACTIVE_ARRAY_SIZE");
        Object objG2 = B0.h.g(gVar.e0(SENSOR_INFO_ACTIVE_ARRAY_SIZE), "The sensor orientation can't be null.");
        p.h(objG2, "checkNotNull(...)");
        CameraCharacteristics.Key SENSOR_INFO_PIXEL_ARRAY_SIZE = CameraCharacteristics.SENSOR_INFO_PIXEL_ARRAY_SIZE;
        p.h(SENSOR_INFO_PIXEL_ARRAY_SIZE, "SENSOR_INFO_PIXEL_ARRAY_SIZE");
        Object objG3 = B0.h.g(gVar.e0(SENSOR_INFO_PIXEL_ARRAY_SIZE), "The active array size can't be null.");
        p.h(objG3, "checkNotNull(...)");
        Size sizeM = (Size) objG3;
        CameraCharacteristics.Key SENSOR_ORIENTATION = CameraCharacteristics.SENSOR_ORIENTATION;
        p.h(SENSOR_ORIENTATION, "SENSOR_ORIENTATION");
        Object objG4 = B0.h.g(gVar.e0(SENSOR_ORIENTATION), "The pixel array size can't be null.");
        p.h(objG4, "checkNotNull(...)");
        int iIntValue = ((Number) objG4).intValue();
        Size sizeL = o.l((Rect) objG2);
        p.h(sizeL, "rectToSize(...)");
        if (o.h(iIntValue)) {
            sizeFN = o.n(sizeFN);
            p.h(sizeFN, "reverseSizeF(...)");
            sizeL = o.m(sizeL);
            p.h(sizeL, "reverseSize(...)");
            sizeM = o.m(sizeM);
            p.h(sizeM, "reverseSize(...)");
        }
        return (sizeFN.getWidth() * sizeL.getWidth()) / sizeM.getWidth();
    }
}
