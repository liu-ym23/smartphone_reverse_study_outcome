package s;

import D.C0761b0;
import K.O;
import K.V;
import Ua.C1071n0;
import Ua.CoroutineName;
import Ua.L0;
import android.hardware.camera2.CameraCharacteristics;
import android.hardware.camera2.params.StreamConfigurationMap;
import android.util.Log;
import androidx.camera.camera2.pipe.DoNotDisturbException;
import com.autonavi.aps.amapapi.config.Const;
import java.util.concurrent.Executor;
import kotlin.Metadata;
import o.C4992y;
import o.Q;
import o.X;
import p.InterfaceC5024f;
import t.C5473b;
import t.InterfaceC5494v;
import t.N;
import t.y0;
import v.C5644a;
import w.InterfaceC5705k;

@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\b'\u0018\u0000 \u00022\u00020\u0001:\u0001\u0002¨\u0006\u0003"}, d2 = {"Ls/o;", "", Const.INTENT_KEY_APIKEY, "camera-camera2"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes.dex */
public abstract class o {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);

    @Metadata(d1 = {"\u0000r\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u001f\u0010\t\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0007¢\u0006\u0004\b\t\u0010\nJ)\u0010\u0011\u001a\u00020\u00102\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\r\u001a\u00020\b2\b\b\u0001\u0010\u000f\u001a\u00020\u000eH\u0007¢\u0006\u0004\b\u0011\u0010\u0012J!\u0010\u0017\u001a\u0004\u0018\u00010\u00162\u0006\u0010\u0014\u001a\u00020\u00132\u0006\u0010\u0015\u001a\u00020\u0004H\u0007¢\u0006\u0004\b\u0017\u0010\u0018J\u0017\u0010\u001a\u001a\u00020\u00192\u0006\u0010\u0015\u001a\u00020\u0004H\u0007¢\u0006\u0004\b\u001a\u0010\u001bJ\u001b\u0010\u001e\u001a\u0004\u0018\u00010\u001d2\b\u0010\u001c\u001a\u0004\u0018\u00010\u0016H\u0007¢\u0006\u0004\b\u001e\u0010\u001fJ\u0017\u0010#\u001a\u00020\"2\u0006\u0010!\u001a\u00020 H\u0007¢\u0006\u0004\b#\u0010$J!\u0010)\u001a\u00020(2\b\b\u0001\u0010%\u001a\u00020\u00192\u0006\u0010'\u001a\u00020&H\u0007¢\u0006\u0004\b)\u0010*¨\u0006+"}, d2 = {"Ls/o$a;", "", "<init>", "()V", "Ls/m;", "cameraConfig", "LK/O;", "cameraThreadConfig", "Lt/y0;", "f", "(Ls/m;LK/O;)Lt/y0;", "Lp/f;", "compat", "threads", "Lt/N;", "requestListener", "Lv/a;", Const.INTENT_KEY_APIKEY, "(Lp/f;Lt/y0;Lt/N;)Lv/a;", "Landroidx/camera/camera2/pipe/h;", "cameraPipe", "config", "Landroidx/camera/camera2/pipe/g;", "c", "(Landroidx/camera/camera2/pipe/h;Ls/m;)Landroidx/camera/camera2/pipe/g;", "", Const.INTENT_KEY_PKGNAME, "(Ls/m;)Ljava/lang/String;", "cameraMetadata", "Landroid/hardware/camera2/params/StreamConfigurationMap;", "e", "(Landroidx/camera/camera2/pipe/g;)Landroid/hardware/camera2/params/StreamConfigurationMap;", "Lt/v;", "cameraProperties", "Lo/Q;", Const.INTENT_KEY_BACKGROUND_COMMAND, "(Lt/v;)Lo/Q;", "cameraIdString", "Landroidx/camera/camera2/compat/quirk/a;", "cameraQuirks", "LK/V;", Const.INTENT_KEY_UMID, "(Ljava/lang/String;Landroidx/camera/camera2/compat/quirk/a;)LK/V;", "camera-camera2"}, k = 1, mv = {2, 1, 0}, xi = 48)
    /* renamed from: s.o$a, reason: from kotlin metadata */
    public static final class Companion {
        public /* synthetic */ Companion(kotlin.jvm.internal.i iVar) {
            this();
        }

        public final C5644a a(InterfaceC5024f compat, y0 threads, N requestListener) {
            kotlin.jvm.internal.p.i(compat, "compat");
            kotlin.jvm.internal.p.i(threads, "threads");
            kotlin.jvm.internal.p.i(requestListener, "requestListener");
            return C5644a.INSTANCE.a(compat, threads, requestListener);
        }

        public final String b(m config) {
            kotlin.jvm.internal.p.i(config, "config");
            return config.getCameraId();
        }

        public final androidx.camera.camera2.pipe.g c(androidx.camera.camera2.pipe.h cameraPipe, m config) {
            kotlin.jvm.internal.p.i(cameraPipe, "cameraPipe");
            kotlin.jvm.internal.p.i(config, "config");
            try {
                return InterfaceC5705k.a(cameraPipe.a(), config.getCameraId(), null, 2, null);
            } catch (DoNotDisturbException unused) {
                C5473b c5473b = C5473b.f41865a;
                if (C0761b0.g("CXCP")) {
                    Log.e(C5473b.TRUNCATED_TAG, "Failed to inject camera metadata: Do Not Disturb mode is on.");
                }
                return null;
            }
        }

        public final V d(String cameraIdString, androidx.camera.camera2.compat.quirk.a cameraQuirks) {
            kotlin.jvm.internal.p.i(cameraIdString, "cameraIdString");
            kotlin.jvm.internal.p.i(cameraQuirks, "cameraQuirks");
            return new C4992y(cameraIdString, cameraQuirks.b());
        }

        public final StreamConfigurationMap e(androidx.camera.camera2.pipe.g cameraMetadata) {
            if (cameraMetadata == null) {
                return null;
            }
            CameraCharacteristics.Key SCALER_STREAM_CONFIGURATION_MAP = CameraCharacteristics.SCALER_STREAM_CONFIGURATION_MAP;
            kotlin.jvm.internal.p.h(SCALER_STREAM_CONFIGURATION_MAP, "SCALER_STREAM_CONFIGURATION_MAP");
            return (StreamConfigurationMap) cameraMetadata.e0(SCALER_STREAM_CONFIGURATION_MAP);
        }

        public final y0 f(m cameraConfig, O cameraThreadConfig) {
            kotlin.jvm.internal.p.i(cameraConfig, "cameraConfig");
            kotlin.jvm.internal.p.i(cameraThreadConfig, "cameraThreadConfig");
            Executor executorB = cameraThreadConfig.b();
            kotlin.jvm.internal.p.h(executorB, "getCameraExecutor(...)");
            Executor executorB2 = cameraThreadConfig.b();
            kotlin.jvm.internal.p.h(executorB2, "getCameraExecutor(...)");
            Ua.I iB = C1071n0.b(executorB2);
            return new y0(kotlinx.coroutines.d.a(L0.b(null, 1, null).plus(iB).plus(new CoroutineName("CXCP-UseCase-" + cameraConfig.getCameraId()))), executorB, iB);
        }

        public final Q g(InterfaceC5494v cameraProperties) {
            kotlin.jvm.internal.p.i(cameraProperties, "cameraProperties");
            return new X(cameraProperties);
        }

        public Companion() {
        }
    }
}
