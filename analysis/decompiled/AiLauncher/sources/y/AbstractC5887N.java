package y;

import A.StreamGraph;
import Ua.CoroutineName;
import Ua.L0;
import Z8.C1173v;
import androidx.camera.camera2.pipe.CameraGraph;
import androidx.camera.camera2.pipe.core.Threads;
import androidx.camera.camera2.pipe.t;
import com.autonavi.aps.amapapi.config.Const;
import java.util.List;
import kotlin.Metadata;
import w.C5711q;
import w.InterfaceC5703i;

@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\b!\u0018\u0000 \u00022\u00020\u0001:\u0001\u0002¨\u0006\u0003"}, d2 = {"Ly/N;", "", Const.INTENT_KEY_APIKEY, "camera-camera2-pipe"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* renamed from: y.N, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public abstract class AbstractC5887N {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);

    @Metadata(d1 = {"\u0000p\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J!\u0010\t\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020\u00042\b\b\u0001\u0010\u0007\u001a\u00020\u0006H\u0007¢\u0006\u0004\b\t\u0010\nJ-\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00120\u00112\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\u000e\u001a\u00020\r2\u0006\u0010\u0010\u001a\u00020\u000fH\u0007¢\u0006\u0004\b\u0013\u0010\u0014J-\u0010\u001d\u001a\u00020\u001c2\u0006\u0010\u0016\u001a\u00020\u00152\f\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u00180\u00172\u0006\u0010\u001b\u001a\u00020\u001aH\u0007¢\u0006\u0004\b\u001d\u0010\u001eJ/\u0010%\u001a\u00020\u000f2\u0006\u0010\u0016\u001a\u00020\u00152\u0006\u0010 \u001a\u00020\u001f2\u0006\u0010\"\u001a\u00020!2\u0006\u0010$\u001a\u00020#H\u0007¢\u0006\u0004\b%\u0010&J\u000f\u0010'\u001a\u00020#H\u0007¢\u0006\u0004\b'\u0010(¨\u0006)"}, d2 = {"Ly/N$a;", "", "<init>", "()V", "Landroidx/camera/camera2/pipe/core/Threads;", "threads", "Lkotlinx/coroutines/g;", "cameraPipeJob", "LUa/M;", Const.INTENT_KEY_APIKEY, "(Landroidx/camera/camera2/pipe/core/Threads;Lkotlinx/coroutines/g;)LUa/M;", "Landroidx/camera/camera2/pipe/CameraGraph$b;", "graphConfig", "Landroidx/camera/camera2/pipe/graph/c;", "listener3A", "Landroidx/camera/camera2/pipe/internal/b;", "frameDistributor", "", "Landroidx/camera/camera2/pipe/t$a;", "c", "(Landroidx/camera/camera2/pipe/CameraGraph$b;Landroidx/camera/camera2/pipe/graph/c;Landroidx/camera/camera2/pipe/internal/b;)Ljava/util/List;", "LA/q;", "streamGraphImpl", "LX8/a;", "Lw/i;", "cameraController", "Lw/q;", "cameraSurfaceManager", "LA/r;", Const.INTENT_KEY_UMID, "(LA/q;LX8/a;Lw/q;)LA/r;", "Landroidx/camera/camera2/pipe/internal/a;", "frameCaptureQueue", "Landroidx/camera/camera2/pipe/g;", "cameraMetadata", "Lz/s;", "systemClockOffsets", Const.INTENT_KEY_PKGNAME, "(LA/q;Landroidx/camera/camera2/pipe/internal/a;Landroidx/camera/camera2/pipe/g;Lz/s;)Landroidx/camera/camera2/pipe/internal/b;", "e", "()Lz/s;", "camera-camera2-pipe"}, k = 1, mv = {2, 1, 0}, xi = 48)
    /* renamed from: y.N$a, reason: from kotlin metadata */
    public static final class Companion {
        public /* synthetic */ Companion(kotlin.jvm.internal.i iVar) {
            this();
        }

        public final Ua.M a(Threads threads, kotlinx.coroutines.g cameraPipeJob) {
            kotlin.jvm.internal.p.i(threads, "threads");
            kotlin.jvm.internal.p.i(cameraPipeJob, "cameraPipeJob");
            return kotlinx.coroutines.d.a(L0.a(cameraPipeJob).plus(threads.getLightweightDispatcher().plus(new CoroutineName("CXCP-Graph"))));
        }

        /* JADX WARN: Removed duplicated region for block: B:8:0x002d  */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public final androidx.camera.camera2.pipe.internal.b b(A.StreamGraph r7, androidx.camera.camera2.pipe.internal.a r8, androidx.camera.camera2.pipe.g r9, z.s r10) {
            /*
                r6 = this;
                java.lang.String r6 = "streamGraphImpl"
                kotlin.jvm.internal.p.i(r7, r6)
                java.lang.String r6 = "frameCaptureQueue"
                kotlin.jvm.internal.p.i(r8, r6)
                java.lang.String r6 = "cameraMetadata"
                kotlin.jvm.internal.p.i(r9, r6)
                java.lang.String r6 = "systemClockOffsets"
                kotlin.jvm.internal.p.i(r10, r6)
                android.hardware.camera2.CameraCharacteristics$Key r6 = android.hardware.camera2.CameraCharacteristics.SENSOR_INFO_TIMESTAMP_SOURCE
                java.lang.String r0 = "SENSOR_INFO_TIMESTAMP_SOURCE"
                kotlin.jvm.internal.p.h(r6, r0)
                java.lang.Object r6 = r9.e0(r6)
                java.lang.Integer r6 = (java.lang.Integer) r6
                if (r6 != 0) goto L24
                goto L2d
            L24:
                int r6 = r6.intValue()
                r9 = 1
                if (r6 != r9) goto L2d
            L2b:
                r3 = r9
                goto L2f
            L2d:
                r9 = 0
                goto L2b
            L2f:
                androidx.camera.camera2.pipe.internal.b r0 = new androidx.camera.camera2.pipe.internal.b
                long r4 = r10.getRealtimeNsToMonotonicNs()
                r1 = r7
                r2 = r8
                r0.<init>(r1, r2, r3, r4)
                return r0
            */
            throw new UnsupportedOperationException("Method not decompiled: y.AbstractC5887N.Companion.b(A.q, androidx.camera.camera2.pipe.internal.a, androidx.camera.camera2.pipe.g, z.s):androidx.camera.camera2.pipe.internal.b");
        }

        public final List<t.a> c(CameraGraph.b graphConfig, androidx.camera.camera2.pipe.graph.c listener3A, androidx.camera.camera2.pipe.internal.b frameDistributor) {
            kotlin.jvm.internal.p.i(graphConfig, "graphConfig");
            kotlin.jvm.internal.p.i(listener3A, "listener3A");
            kotlin.jvm.internal.p.i(frameDistributor, "frameDistributor");
            List<t.a> listS = C1173v.s(listener3A);
            listS.add(listener3A);
            listS.add(frameDistributor);
            listS.addAll(graphConfig.e());
            return listS;
        }

        public final A.r d(StreamGraph streamGraphImpl, X8.a<InterfaceC5703i> cameraController, C5711q cameraSurfaceManager) {
            kotlin.jvm.internal.p.i(streamGraphImpl, "streamGraphImpl");
            kotlin.jvm.internal.p.i(cameraController, "cameraController");
            kotlin.jvm.internal.p.i(cameraSurfaceManager, "cameraSurfaceManager");
            return new A.r(streamGraphImpl, cameraController, cameraSurfaceManager, streamGraphImpl.k0());
        }

        public final z.s e() {
            return z.s.INSTANCE.a();
        }

        public Companion() {
        }
    }
}
