package androidx.camera.camera2.pipe;

import android.hardware.camera2.CameraCharacteristics;
import android.hardware.camera2.CaptureRequest;
import android.os.Build;
import androidx.camera.camera2.pipe.q;
import androidx.exifinterface.media.ExifInterface;
import com.autonavi.aps.amapapi.config.Const;
import com.stepos.ailauncher.chat.voice.support.C3081a;
import java.util.Set;
import kotlin.Metadata;
import w.C5708n;
import w.InterfaceC5707m;
import w.InterfaceC5709o;
import w.InterfaceC5710p;
import w.U;
import x.C5829o;
import x.C5830p;
import x.C5835v;

@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\"\n\u0002\u0018\u0002\n\u0002\b\n\bg\u0018\u0000  2\u00020\u00012\u00020\u0002:\u0001!J&\u0010\u0006\u001a\u0004\u0018\u00018\u0000\"\u0004\b\u0000\u0010\u00032\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00028\u00000\u0004H¦\u0002¢\u0006\u0004\b\u0006\u0010\u0007J+\u0010\t\u001a\u00028\u0000\"\u0004\b\u0000\u0010\u00032\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00028\u00000\u00042\u0006\u0010\b\u001a\u00028\u0000H&¢\u0006\u0004\b\t\u0010\nJ\u0017\u0010\r\u001a\u00020\u00002\u0006\u0010\f\u001a\u00020\u000bH&¢\u0006\u0004\b\r\u0010\u000eJ\u0017\u0010\u0012\u001a\u00020\u00112\u0006\u0010\u0010\u001a\u00020\u000fH&¢\u0006\u0004\b\u0012\u0010\u0013R\u0014\u0010\u0016\u001a\u00020\u000b8&X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0014\u0010\u0015R\u001e\u0010\u001b\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00180\u00178&X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0019\u0010\u001aR\u001a\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\u000b0\u00178&X¦\u0004¢\u0006\u0006\u001a\u0004\b\u001c\u0010\u001aR\u001a\u0010\u001f\u001a\b\u0012\u0004\u0012\u00020\u000f0\u00178&X¦\u0004¢\u0006\u0006\u001a\u0004\b\u001e\u0010\u001aø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001¨\u0006\"À\u0006\u0001"}, d2 = {"Landroidx/camera/camera2/pipe/g;", "Landroidx/camera/camera2/pipe/q;", "Lw/U;", ExifInterface.GPS_DIRECTION_TRUE, "Landroid/hardware/camera2/CameraCharacteristics$Key;", "key", "e0", "(Landroid/hardware/camera2/CameraCharacteristics$Key;)Ljava/lang/Object;", "default", "h1", "(Landroid/hardware/camera2/CameraCharacteristics$Key;Ljava/lang/Object;)Ljava/lang/Object;", "Lw/n;", "cameraId", "v0", "(Ljava/lang/String;)Landroidx/camera/camera2/pipe/g;", "", "extension", "Lw/m;", "b1", "(I)Lw/m;", Const.INTENT_KEY_PKGNAME, "()Ljava/lang/String;", C3081a.CAMERA_FOCUS, "", "Landroid/hardware/camera2/CaptureRequest$Key;", "l1", "()Ljava/util/Set;", "sessionKeys", "I0", "physicalCameraIds", "g0", "supportedExtensions", "p0", Const.INTENT_KEY_APIKEY, "camera-camera2-pipe"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes.dex */
public interface g extends q, U {

    /* renamed from: p0, reason: collision with root package name and from kotlin metadata */
    public static final Companion INSTANCE = Companion.f10773a;

    @Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0015\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u000e\n\u0002\u0010\b\n\u0002\b\b\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R&\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00050\u00048\u0006X\u0087\u0004¢\u0006\u0012\n\u0004\b\u0006\u0010\u0007\u0012\u0004\b\n\u0010\u0003\u001a\u0004\b\b\u0010\tR&\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\f0\u00048\u0006X\u0087\u0004¢\u0006\u0012\n\u0004\b\r\u0010\u0007\u0012\u0004\b\u000f\u0010\u0003\u001a\u0004\b\u000e\u0010\tR&\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00110\u00048\u0006X\u0087\u0004¢\u0006\u0012\n\u0004\b\u0012\u0010\u0007\u0012\u0004\b\u0014\u0010\u0003\u001a\u0004\b\u0013\u0010\tR\"\u0010\u001d\u001a\u00020\u00168\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0017\u0010\u0018\u001a\u0004\b\u0019\u0010\u001a\"\u0004\b\u001b\u0010\u001cR\u0015\u0010!\u001a\u00020\u0016*\u00020\u001e8G¢\u0006\u0006\u001a\u0004\b\u001f\u0010 R\u0015\u0010\"\u001a\u00020\u0016*\u00020\u001e8G¢\u0006\u0006\u001a\u0004\b\u0006\u0010 R\u0015\u0010&\u001a\u00020#*\u00020\u001e8G¢\u0006\u0006\u001a\u0004\b$\u0010%R\u0015\u0010(\u001a\u00020#*\u00020\u001e8G¢\u0006\u0006\u001a\u0004\b'\u0010%R\u0015\u0010*\u001a\u00020#*\u00020\u001e8G¢\u0006\u0006\u001a\u0004\b)\u0010%R\u0015\u0010,\u001a\u00020#*\u00020\u001e8G¢\u0006\u0006\u001a\u0004\b+\u0010%R\u0015\u0010-\u001a\u00020#*\u00020\u001e8G¢\u0006\u0006\u001a\u0004\b\u0017\u0010%R\u0015\u0010/\u001a\u00020#*\u00020\u001e8G¢\u0006\u0006\u001a\u0004\b.\u0010%R\u0015\u00101\u001a\u00020#*\u00020\u001e8G¢\u0006\u0006\u001a\u0004\b0\u0010%R\u0015\u00104\u001a\u000202*\u00020\u001e8G¢\u0006\u0006\u001a\u0004\b\u0012\u00103R\u0015\u00105\u001a\u000202*\u00020\u001e8G¢\u0006\u0006\u001a\u0004\b\r\u00103R\u0015\u00107\u001a\u00020#*\u00020\u001e8G¢\u0006\u0006\u001a\u0004\b6\u0010%R\u0015\u00109\u001a\u00020#*\u00020\u001e8G¢\u0006\u0006\u001a\u0004\b8\u0010%¨\u0006:"}, d2 = {"Landroidx/camera/camera2/pipe/g$a;", "", "<init>", "()V", "Landroidx/camera/camera2/pipe/q$a;", "Lw/p;", Const.INTENT_KEY_PKGNAME, "Landroidx/camera/camera2/pipe/q$a;", "getCAMERA_STREAM_CONFIGURATION_MAP", "()Landroidx/camera/camera2/pipe/q$a;", "getCAMERA_STREAM_CONFIGURATION_MAP$annotations", "CAMERA_STREAM_CONFIGURATION_MAP", "Lw/o;", "c", "getCAMERA_MULTI_RESOLUTION_STREAM_CONFIGURATION_MAP", "getCAMERA_MULTI_RESOLUTION_STREAM_CONFIGURATION_MAP$annotations", "CAMERA_MULTI_RESOLUTION_STREAM_CONFIGURATION_MAP", "Landroidx/camera/camera2/pipe/c;", Const.INTENT_KEY_UMID, "getCAMERA_AVAILABLE_COLOR_SPACE_PROFILES", "getCAMERA_AVAILABLE_COLOR_SPACE_PROFILES$annotations", "CAMERA_AVAILABLE_COLOR_SPACE_PROFILES", "", "e", "[I", "getEMPTY_INT_ARRAY", "()[I", "setEMPTY_INT_ARRAY", "([I)V", "EMPTY_INT_ARRAY", "Landroidx/camera/camera2/pipe/g;", Const.INTENT_KEY_APIKEY, "(Landroidx/camera/camera2/pipe/g;)[I", "availableCapabilities", "availableVideoStabilizationModes", "", "k", "(Landroidx/camera/camera2/pipe/g;)Z", "isHardwareLevelExternal", "l", "isHardwareLevelLegacy", "m", "isHardwareLevelLimited", Const.INTENT_KEY_BACKGROUND_NOTIFICATION, "supportsPrivateReprocessing", "supportsAutoFocusTrigger", Const.INTENT_KEY_BACKGROUND_NOTIFICATION_REMOVE, "supportsZoomOverride", Const.INTENT_KEY_BACKGROUND_NOTIFICATION_ID, "supportsTorchStrength", "", "(Landroidx/camera/camera2/pipe/g;)I", "maxTorchStrengthLevel", "defaultTorchStrengthLevel", "f", "supportsLowLightBoost", Const.INTENT_KEY_BACKGROUND_COMMAND, "supportsPreviewStabilization", "camera-camera2-pipe"}, k = 1, mv = {2, 1, 0}, xi = 48)
    /* renamed from: androidx.camera.camera2.pipe.g$a, reason: from kotlin metadata */
    public static final class Companion {

        /* renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ Companion f10773a = new Companion();

        /* renamed from: b, reason: collision with root package name and from kotlin metadata */
        public static final q.a<InterfaceC5710p> CAMERA_STREAM_CONFIGURATION_MAP;

        /* renamed from: c, reason: collision with root package name and from kotlin metadata */
        public static final q.a<InterfaceC5709o> CAMERA_MULTI_RESOLUTION_STREAM_CONFIGURATION_MAP;

        /* renamed from: d, reason: collision with root package name and from kotlin metadata */
        public static final q.a<c> CAMERA_AVAILABLE_COLOR_SPACE_PROFILES;

        /* renamed from: e, reason: collision with root package name and from kotlin metadata */
        public static int[] EMPTY_INT_ARRAY;

        static {
            q.a.Companion c0142a = q.a.INSTANCE;
            CAMERA_STREAM_CONFIGURATION_MAP = c0142a.a("androidx.camera.camera2.pipe.scalar.streamConfigurationMap", kotlin.jvm.internal.t.b(InterfaceC5710p.class));
            CAMERA_MULTI_RESOLUTION_STREAM_CONFIGURATION_MAP = c0142a.a("androidx.camera.camera2.pipe.scalar.multiResolutionStreamConfigurationMap", kotlin.jvm.internal.t.b(InterfaceC5709o.class));
            CAMERA_AVAILABLE_COLOR_SPACE_PROFILES = c0142a.a("androidx.camera.camera2.pipe.request.availableColorSpaceProfilesMap", kotlin.jvm.internal.t.b(c.class));
            EMPTY_INT_ARRAY = new int[0];
        }

        public final int[] a(g gVar) {
            kotlin.jvm.internal.p.i(gVar, "<this>");
            CameraCharacteristics.Key REQUEST_AVAILABLE_CAPABILITIES = CameraCharacteristics.REQUEST_AVAILABLE_CAPABILITIES;
            kotlin.jvm.internal.p.h(REQUEST_AVAILABLE_CAPABILITIES, "REQUEST_AVAILABLE_CAPABILITIES");
            int[] iArr = (int[]) gVar.e0(REQUEST_AVAILABLE_CAPABILITIES);
            return iArr == null ? EMPTY_INT_ARRAY : iArr;
        }

        public final int[] b(g gVar) {
            kotlin.jvm.internal.p.i(gVar, "<this>");
            CameraCharacteristics.Key CONTROL_AVAILABLE_VIDEO_STABILIZATION_MODES = CameraCharacteristics.CONTROL_AVAILABLE_VIDEO_STABILIZATION_MODES;
            kotlin.jvm.internal.p.h(CONTROL_AVAILABLE_VIDEO_STABILIZATION_MODES, "CONTROL_AVAILABLE_VIDEO_STABILIZATION_MODES");
            int[] iArr = (int[]) gVar.e0(CONTROL_AVAILABLE_VIDEO_STABILIZATION_MODES);
            return iArr == null ? EMPTY_INT_ARRAY : iArr;
        }

        public final int c(g gVar) {
            kotlin.jvm.internal.p.i(gVar, "<this>");
            if (Build.VERSION.SDK_INT >= 35) {
                return C5835v.b(gVar);
            }
            return 1;
        }

        public final int d(g gVar) {
            kotlin.jvm.internal.p.i(gVar, "<this>");
            if (Build.VERSION.SDK_INT >= 35) {
                return C5835v.c(gVar);
            }
            return 1;
        }

        public final boolean e(g gVar) {
            kotlin.jvm.internal.p.i(gVar, "<this>");
            CameraCharacteristics.Key LENS_INFO_MINIMUM_FOCUS_DISTANCE = CameraCharacteristics.LENS_INFO_MINIMUM_FOCUS_DISTANCE;
            kotlin.jvm.internal.p.h(LENS_INFO_MINIMUM_FOCUS_DISTANCE, "LENS_INFO_MINIMUM_FOCUS_DISTANCE");
            Float f10 = (Float) gVar.e0(LENS_INFO_MINIMUM_FOCUS_DISTANCE);
            if (f10 != null) {
                return f10.floatValue() > 0.0f;
            }
            CameraCharacteristics.Key CONTROL_AF_AVAILABLE_MODES = CameraCharacteristics.CONTROL_AF_AVAILABLE_MODES;
            kotlin.jvm.internal.p.h(CONTROL_AF_AVAILABLE_MODES, "CONTROL_AF_AVAILABLE_MODES");
            int[] iArr = (int[]) gVar.e0(CONTROL_AF_AVAILABLE_MODES);
            if (iArr == null) {
                return false;
            }
            return Z8.r.P(iArr, 1) || Z8.r.P(iArr, 2) || Z8.r.P(iArr, 4) || Z8.r.P(iArr, 3);
        }

        public final boolean f(g gVar) {
            kotlin.jvm.internal.p.i(gVar, "<this>");
            CameraCharacteristics.Key CONTROL_AE_AVAILABLE_MODES = CameraCharacteristics.CONTROL_AE_AVAILABLE_MODES;
            kotlin.jvm.internal.p.h(CONTROL_AE_AVAILABLE_MODES, "CONTROL_AE_AVAILABLE_MODES");
            int[] iArr = (int[]) gVar.e0(CONTROL_AE_AVAILABLE_MODES);
            if (iArr == null) {
                return false;
            }
            return Z8.r.P(iArr, 6);
        }

        public final boolean g(g gVar) {
            kotlin.jvm.internal.p.i(gVar, "<this>");
            return C5829o.f43431a.f(gVar);
        }

        public final boolean h(g gVar) {
            kotlin.jvm.internal.p.i(gVar, "<this>");
            return Z8.r.P(a(gVar), 4);
        }

        public final boolean i(g gVar) {
            kotlin.jvm.internal.p.i(gVar, "<this>");
            return Build.VERSION.SDK_INT >= 35 && C5835v.d(gVar);
        }

        public final boolean j(g gVar) {
            kotlin.jvm.internal.p.i(gVar, "<this>");
            return C5830p.c(gVar);
        }

        public final boolean k(g gVar) {
            kotlin.jvm.internal.p.i(gVar, "<this>");
            CameraCharacteristics.Key INFO_SUPPORTED_HARDWARE_LEVEL = CameraCharacteristics.INFO_SUPPORTED_HARDWARE_LEVEL;
            kotlin.jvm.internal.p.h(INFO_SUPPORTED_HARDWARE_LEVEL, "INFO_SUPPORTED_HARDWARE_LEVEL");
            Integer num = (Integer) gVar.e0(INFO_SUPPORTED_HARDWARE_LEVEL);
            return num != null && num.intValue() == 4;
        }

        public final boolean l(g gVar) {
            kotlin.jvm.internal.p.i(gVar, "<this>");
            CameraCharacteristics.Key INFO_SUPPORTED_HARDWARE_LEVEL = CameraCharacteristics.INFO_SUPPORTED_HARDWARE_LEVEL;
            kotlin.jvm.internal.p.h(INFO_SUPPORTED_HARDWARE_LEVEL, "INFO_SUPPORTED_HARDWARE_LEVEL");
            Integer num = (Integer) gVar.e0(INFO_SUPPORTED_HARDWARE_LEVEL);
            return num != null && num.intValue() == 2;
        }

        public final boolean m(g gVar) {
            kotlin.jvm.internal.p.i(gVar, "<this>");
            CameraCharacteristics.Key INFO_SUPPORTED_HARDWARE_LEVEL = CameraCharacteristics.INFO_SUPPORTED_HARDWARE_LEVEL;
            kotlin.jvm.internal.p.h(INFO_SUPPORTED_HARDWARE_LEVEL, "INFO_SUPPORTED_HARDWARE_LEVEL");
            Integer num = (Integer) gVar.e0(INFO_SUPPORTED_HARDWARE_LEVEL);
            return num != null && num.intValue() == 0;
        }
    }

    Set<C5708n> I0();

    String b();

    InterfaceC5707m b1(int extension);

    <T> T e0(CameraCharacteristics.Key<T> key);

    Set<Integer> g0();

    <T> T h1(CameraCharacteristics.Key<T> key, T t10);

    Set<CaptureRequest.Key<?>> l1();

    g v0(String cameraId);
}
