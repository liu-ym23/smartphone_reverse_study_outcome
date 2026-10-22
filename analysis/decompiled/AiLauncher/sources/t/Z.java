package t;

import D.C0761b0;
import Z8.C1168p;
import android.hardware.camera2.CameraCharacteristics;
import android.hardware.camera2.params.StreamConfigurationMap;
import android.util.Log;
import android.util.Size;
import com.autonavi.aps.amapapi.config.Const;
import java.util.Comparator;
import kotlin.Metadata;
import r.C5181C;

@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\b\u0006\u001a\u001f\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0001\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u0002H\u0000¢\u0006\u0004\b\u0005\u0010\u0006\u001a\u001b\u0010\b\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0007*\u00020\u0000H\u0002¢\u0006\u0004\b\b\u0010\t\"\u0014\u0010\f\u001a\u00020\u00048\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\n\u0010\u000b¨\u0006\r"}, d2 = {"Lt/v;", "cameraProperties", "Lt/Q;", "displayInfoManager", "Landroid/util/Size;", "c", "(Lt/v;Lt/Q;)Landroid/util/Size;", "", Const.INTENT_KEY_PKGNAME, "(Lt/v;)[Landroid/util/Size;", Const.INTENT_KEY_APIKEY, "Landroid/util/Size;", "DEFAULT_PREVIEW_SIZE", "camera-camera2"}, k = 2, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes.dex */
public final class Z {

    /* renamed from: a, reason: collision with root package name */
    public static final Size f41864a = new Size(640, 480);

    @Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
    public static final class a<T> implements Comparator {
        /* JADX WARN: Multi-variable type inference failed */
        @Override // java.util.Comparator
        public final int compare(T t10, T t11) {
            Size size = (Size) t10;
            Size size2 = (Size) t11;
            return b9.b.d(Long.valueOf(size.getWidth() * size.getHeight()), Long.valueOf(size2.getWidth() * size2.getHeight()));
        }
    }

    public static final Size[] b(InterfaceC5494v interfaceC5494v) {
        androidx.camera.camera2.pipe.g metadata = interfaceC5494v.getMetadata();
        CameraCharacteristics.Key SCALER_STREAM_CONFIGURATION_MAP = CameraCharacteristics.SCALER_STREAM_CONFIGURATION_MAP;
        kotlin.jvm.internal.p.h(SCALER_STREAM_CONFIGURATION_MAP, "SCALER_STREAM_CONFIGURATION_MAP");
        StreamConfigurationMap streamConfigurationMap = (StreamConfigurationMap) metadata.e0(SCALER_STREAM_CONFIGURATION_MAP);
        if (streamConfigurationMap != null) {
            return streamConfigurationMap.getOutputSizes(34);
        }
        C5473b c5473b = C5473b.f41865a;
        if (!C0761b0.g("CXCP")) {
            return null;
        }
        Log.e(C5473b.TRUNCATED_TAG, "Can not retrieve SCALER_STREAM_CONFIGURATION_MAP.");
        return null;
    }

    public static final Size c(InterfaceC5494v cameraProperties, Q displayInfoManager) {
        kotlin.jvm.internal.p.i(cameraProperties, "cameraProperties");
        kotlin.jvm.internal.p.i(displayInfoManager, "displayInfoManager");
        Size[] sizeArrB = b(cameraProperties);
        if (sizeArrB != null && sizeArrB.length != 0) {
            Size[] sizeArrA = C5181C.a(sizeArrB);
            if (sizeArrA.length == 0) {
                C5473b c5473b = C5473b.f41865a;
                if (C0761b0.k("CXCP")) {
                    Log.w(C5473b.TRUNCATED_TAG, "No supported output size list, fallback to current list");
                }
            } else {
                sizeArrB = sizeArrA;
            }
            if (sizeArrB.length > 1) {
                C1168p.I(sizeArrB, new a());
            }
            Size sizeK = displayInfoManager.k();
            long jMin = Math.min(307200L, sizeK.getWidth() * sizeK.getHeight());
            int length = sizeArrB.length;
            Size size = null;
            int i10 = 0;
            while (true) {
                if (i10 >= length) {
                    break;
                }
                Size size2 = sizeArrB[i10];
                long width = size2.getWidth() * size2.getHeight();
                if (width == jMin) {
                    return size2;
                }
                if (width <= jMin) {
                    i10++;
                    size = size2;
                } else if (size != null) {
                    return size;
                }
            }
            return size == null ? sizeArrB[0] : size;
        }
        return f41864a;
    }
}
