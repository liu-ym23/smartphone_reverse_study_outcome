package androidx.camera.camera2.pipe.compat;

import A.StreamGraph;
import B.f;
import Ua.C1060i;
import Ua.C1087w;
import Ua.InterfaceC1083u;
import Ua.M;
import Z8.F;
import Z8.Z;
import android.util.Log;
import android.view.Surface;
import androidx.camera.camera2.pipe.CameraGraph;
import androidx.camera.camera2.pipe.compat.Camera2CameraController;
import androidx.camera.camera2.pipe.core.Threads;
import androidx.exifinterface.media.ExifInterface;
import com.autonavi.aps.amapapi.config.Const;
import com.stepos.ailauncher.chat.voice.support.C3081a;
import com.stepos.statsapp.v3.lib.plugin.constants.UxipConstants;
import e9.InterfaceC4014c;
import f9.C4063a;
import g9.InterfaceC4112d;
import java.util.Map;
import java.util.Set;
import kotlin.C4849c;
import kotlin.KotlinNothingValueException;
import kotlin.Metadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.internal.Ref$ObjectRef;
import p9.InterfaceC5074l;
import s.C5423E;
import w.C5706l;
import w.C5708n;
import w.C5711q;
import w.ConcurrentCameraGraphs;
import w.InterfaceC5703i;
import w.Q;
import w.S;
import w.T;
import x.AbstractC5824k0;
import x.C5810d0;
import x.CameraStateClosed;
import x.CameraStateClosing;
import x.CameraStateOpen;
import x.K0;
import x.N;
import x.X;
import x.q0;
import x.r0;
import z.x;

@Metadata(d1 = {"\u0000ö\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\"\n\u0002\u0010\u0000\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0001\u0018\u0000 *2\u00020\u0001:\u0002@JB\u0091\u0001\b\u0007\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\u0006\u0010\u0007\u001a\u00020\u0006\u0012\u0006\u0010\t\u001a\u00020\b\u0012\u0006\u0010\u000b\u001a\u00020\n\u0012\u0006\u0010\r\u001a\u00020\f\u0012\u0006\u0010\u000f\u001a\u00020\u000e\u0012\u0006\u0010\u0011\u001a\u00020\u0010\u0012\u0006\u0010\u0013\u001a\u00020\u0012\u0012\u0006\u0010\u0015\u001a\u00020\u0014\u0012\u0006\u0010\u0017\u001a\u00020\u0016\u0012\u0006\u0010\u0019\u001a\u00020\u0018\u0012\u0006\u0010\u001b\u001a\u00020\u001a\u0012\u0006\u0010\u001d\u001a\u00020\u001c\u0012\u0006\u0010\u001f\u001a\u00020\u001e\u0012\u0006\u0010!\u001a\u00020 \u0012\u0006\u0010#\u001a\u00020\"¢\u0006\u0004\b$\u0010%J\u000f\u0010'\u001a\u00020&H\u0003¢\u0006\u0004\b'\u0010(J\u000f\u0010)\u001a\u00020&H\u0003¢\u0006\u0004\b)\u0010(J\u000f\u0010*\u001a\u00020&H\u0003¢\u0006\u0004\b*\u0010(J\u0017\u0010-\u001a\u00020&2\u0006\u0010,\u001a\u00020+H\u0002¢\u0006\u0004\b-\u0010.J\u0010\u0010/\u001a\u00020&H\u0082@¢\u0006\u0004\b/\u00100J\u0017\u00103\u001a\u00020&2\u0006\u00102\u001a\u000201H\u0002¢\u0006\u0004\b3\u00104J#\u00109\u001a\u00020&2\b\u00106\u001a\u0004\u0018\u0001052\b\u00108\u001a\u0004\u0018\u000107H\u0003¢\u0006\u0004\b9\u0010:J\u000f\u0010<\u001a\u00020;H\u0003¢\u0006\u0004\b<\u0010=J\u000f\u0010>\u001a\u00020&H\u0016¢\u0006\u0004\b>\u0010(J\u000f\u0010?\u001a\u00020&H\u0016¢\u0006\u0004\b?\u0010(J\u0010\u0010@\u001a\u00020;H\u0096@¢\u0006\u0004\b@\u00100J#\u0010E\u001a\u00020&2\u0012\u0010D\u001a\u000e\u0012\u0004\u0012\u00020B\u0012\u0004\u0012\u00020C0AH\u0016¢\u0006\u0004\bE\u0010FJ\u000f\u0010H\u001a\u00020GH\u0016¢\u0006\u0004\bH\u0010IR\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bJ\u0010KR\u0014\u0010\u0005\u001a\u00020\u00048\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b@\u0010LR\u0014\u0010\u0007\u001a\u00020\u00068\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bE\u0010MR\u0014\u0010\t\u001a\u00020\b8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bN\u0010OR\u0014\u0010\u000b\u001a\u00020\n8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bP\u0010QR\u0014\u0010\r\u001a\u00020\f8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bR\u0010SR\u0014\u0010\u000f\u001a\u00020\u000e8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bT\u0010UR\u0014\u0010\u0011\u001a\u00020\u00108\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bV\u0010WR\u0014\u0010\u0013\u001a\u00020\u00128\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bX\u0010YR\u0014\u0010\u0015\u001a\u00020\u00148\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bZ\u0010[R\u0014\u0010\u0017\u001a\u00020\u00168\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\\\u0010]R\u0014\u0010\u0019\u001a\u00020\u00188\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b^\u0010_R\u0014\u0010\u001b\u001a\u00020\u001a8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b`\u0010aR\u001a\u0010\u001d\u001a\u00020\u001c8\u0016X\u0096\u0004¢\u0006\f\n\u0004\bb\u0010c\u001a\u0004\bd\u0010eR\u0014\u0010\u001f\u001a\u00020\u001e8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bf\u0010gR\u0014\u0010!\u001a\u00020 8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bh\u0010iR\u0014\u0010m\u001a\u00020j8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bk\u0010lR\u0016\u0010p\u001a\u00020;8\u0002@\u0002X\u0083\u000e¢\u0006\u0006\n\u0004\bn\u0010oR(\u0010y\u001a\u00020q8\u0000@\u0000X\u0081\u000e¢\u0006\u0018\n\u0004\br\u0010s\u0012\u0004\bx\u0010(\u001a\u0004\bt\u0010u\"\u0004\bv\u0010wR\u0016\u0010{\u001a\u00020+8\u0002@\u0002X\u0083\u000e¢\u0006\u0006\n\u0004\b/\u0010zR\u0018\u0010~\u001a\u0004\u0018\u00010|8\u0002@\u0002X\u0083\u000e¢\u0006\u0006\n\u0004\b9\u0010}R\u001b\u0010\u0082\u0001\u001a\u0004\u0018\u00010\u007f8\u0002@\u0002X\u0083\u000e¢\u0006\b\n\u0006\b\u0080\u0001\u0010\u0081\u0001R\u001b\u0010\u0085\u0001\u001a\u0005\u0018\u00010\u0083\u00018\u0002@\u0002X\u0083\u000e¢\u0006\u0007\n\u0005\bd\u0010\u0084\u0001R\u001a\u0010\u0089\u0001\u001a\u0005\u0018\u00010\u0086\u00018\u0002X\u0082\u0004¢\u0006\b\n\u0006\b\u0087\u0001\u0010\u0088\u0001R\u001d\u0010\u008c\u0001\u001a\t\u0012\u0004\u0012\u00020&0\u008a\u00018\u0002X\u0082\u0004¢\u0006\u0007\n\u0005\bt\u0010\u008b\u0001R\u001a\u0010\u008e\u0001\u001a\u0004\u0018\u0001078\u0002@\u0002X\u0082\u000e¢\u0006\u0007\n\u0005\b<\u0010\u008d\u0001R\u001b\u0010\u0091\u0001\u001a\u0004\u0018\u0001058\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b\u008f\u0001\u0010\u0090\u0001R&\u0010\u0093\u0001\u001a\u0010\u0012\u0004\u0012\u00020B\u0012\u0004\u0012\u00020C\u0018\u00010A8\u0002@\u0002X\u0082\u000e¢\u0006\u0007\n\u0005\b-\u0010\u0092\u0001R\u001b\u0010\u0094\u0001\u001a\u0005\u0018\u00010\u0083\u00018\u0002@\u0002X\u0082\u000e¢\u0006\u0007\n\u0005\b3\u0010\u0084\u0001R\u001b\u0010\u0095\u0001\u001a\u0005\u0018\u00010\u0083\u00018\u0002@\u0002X\u0082\u000e¢\u0006\u0007\n\u0005\b)\u0010\u0084\u0001R\u001c\u0010\u0097\u0001\u001a\u0005\u0018\u00010\u0083\u00018\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b\u0096\u0001\u0010\u0084\u0001R\u0017\u0010\u0099\u0001\u001a\u00030\u0098\u00018VX\u0096\u0004¢\u0006\u0007\u001a\u0005\b\u0087\u0001\u0010IR(\u0010\u009c\u0001\u001a\u00020;2\u0007\u0010\u009a\u0001\u001a\u00020;8V@VX\u0096\u000e¢\u0006\u000e\u001a\u0005\b\u008f\u0001\u0010=\"\u0005\bV\u0010\u009b\u0001¨\u0006\u009d\u0001"}, d2 = {"Landroidx/camera/camera2/pipe/compat/Camera2CameraController;", "Lw/i;", "LUa/M;", "scope", "Landroidx/camera/camera2/pipe/core/Threads;", "threads", "Lw/S;", "strictMode", "Landroidx/camera/camera2/pipe/CameraGraph$b;", "graphConfig", "LA/e;", "graphListener", "Lw/T;", "surfaceTracker", "LB/f;", "cameraStatusMonitor", "Landroidx/camera/camera2/pipe/compat/r;", "captureSessionFactory", "Lx/N;", "captureSequenceProcessorFactory", "Lx/X;", "camera2DeviceManager", "Lw/q;", "cameraSurfaceManager", "Lx/d0;", "camera2Quirks", "Lz/w;", "timeSource", "Landroidx/camera/camera2/pipe/e;", "cameraGraphId", "Landroidx/camera/camera2/pipe/compat/Camera2CameraController$b;", "shutdownListener", "LA/q;", "streamGraph", "Lx/r0;", "concurrentSessionSequencers", "<init>", "(LUa/M;Landroidx/camera/camera2/pipe/core/Threads;Lw/S;Landroidx/camera/camera2/pipe/CameraGraph$b;LA/e;Lw/T;LB/f;Landroidx/camera/camera2/pipe/compat/r;Lx/N;Lx/X;Lw/q;Lx/d0;Lz/w;Landroidx/camera/camera2/pipe/e;Landroidx/camera/camera2/pipe/compat/Camera2CameraController$b;LA/q;Lx/r0;)V", "LY8/t;", "G", "()V", "D", "F", "LB/f$a;", "cameraStatus", "B", "(LB/f$a;)V", "t", "(Le9/c;)Ljava/lang/Object;", "Lx/l0;", "cameraState", "C", "(Lx/l0;)V", "Landroidx/camera/camera2/pipe/compat/CaptureSessionState;", "session", "Lx/K0;", C3081a.CAMERA_FOCUS, "u", "(Landroidx/camera/camera2/pipe/compat/CaptureSessionState;Lx/K0;)V", "", "z", "()Z", "start", "close", Const.INTENT_KEY_PKGNAME, "", "Lw/Q;", "Landroid/view/Surface;", "surfaceMap", "c", "(Ljava/util/Map;)V", "", "toString", "()Ljava/lang/String;", Const.INTENT_KEY_APIKEY, "LUa/M;", "Landroidx/camera/camera2/pipe/core/Threads;", "Lw/S;", Const.INTENT_KEY_UMID, "Landroidx/camera/camera2/pipe/CameraGraph$b;", "e", "LA/e;", "f", "Lw/T;", Const.INTENT_KEY_BACKGROUND_COMMAND, "LB/f;", Const.INTENT_KEY_BACKGROUND_NOTIFICATION, "Landroidx/camera/camera2/pipe/compat/r;", Const.INTENT_KEY_BACKGROUND_NOTIFICATION_ID, "Lx/N;", Const.INTENT_KEY_BACKGROUND_NOTIFICATION_REMOVE, "Lx/X;", "k", "Lw/q;", "l", "Lx/d0;", "m", "Lz/w;", "n", "Landroidx/camera/camera2/pipe/e;", "w", "()Landroidx/camera/camera2/pipe/e;", "o", "Landroidx/camera/camera2/pipe/compat/Camera2CameraController$b;", "p", "LA/q;", "", "q", "Ljava/lang/Object;", "lock", "r", "Z", "_isForeground", "Lw/i$a;", "s", "Lw/i$a;", "y", "()Lw/i$a;", "setControllerState$camera_camera2_pipe", "(Lw/i$a;)V", "getControllerState$camera_camera2_pipe$annotations", "controllerState", "LB/f$a;", "cameraAvailability", "Lw/l;", "Lw/l;", "lastCameraError", "Lz/x;", "v", "Lz/x;", "lastCameraPrioritiesChangedTs", "Lkotlinx/coroutines/g;", "Lkotlinx/coroutines/g;", "restartJob", "Lx/q0;", "x", "Lx/q0;", "concurrentSessionSequencer", "LUa/u;", "LUa/u;", "closedDeferred", "Lx/K0;", "currentCamera", ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, "Landroidx/camera/camera2/pipe/compat/CaptureSessionState;", "currentSession", "Ljava/util/Map;", "currentSurfaceMap", "currentCameraStateJob", "cameraAvailabilityJob", ExifInterface.LONGITUDE_EAST, "cameraPrioritiesJob", "Lw/n;", "cameraId", UxipConstants.f30680s, "(Z)V", "isForeground", "camera-camera2-pipe"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes.dex */
public final class Camera2CameraController implements InterfaceC5703i {

    /* renamed from: F, reason: collision with root package name and from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);

    /* renamed from: G, reason: collision with root package name */
    public static final long f10266G = z.i.c(200000000);

    /* renamed from: A, reason: collision with root package name and from kotlin metadata */
    public CaptureSessionState currentSession;

    /* renamed from: B, reason: collision with root package name and from kotlin metadata */
    public Map<Q, ? extends Surface> currentSurfaceMap;

    /* renamed from: C, reason: collision with root package name and from kotlin metadata */
    public kotlinx.coroutines.g currentCameraStateJob;

    /* renamed from: D, reason: collision with root package name and from kotlin metadata */
    public kotlinx.coroutines.g cameraAvailabilityJob;

    /* renamed from: E, reason: collision with root package name and from kotlin metadata */
    public kotlinx.coroutines.g cameraPrioritiesJob;

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    public final M scope;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    public final Threads threads;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    public final S strictMode;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    public final CameraGraph.b graphConfig;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    public final A.e graphListener;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    public final T surfaceTracker;

    /* renamed from: g, reason: collision with root package name and from kotlin metadata */
    public final B.f cameraStatusMonitor;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    public final r captureSessionFactory;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    public final N captureSequenceProcessorFactory;

    /* renamed from: j, reason: collision with root package name and from kotlin metadata */
    public final X camera2DeviceManager;

    /* renamed from: k, reason: collision with root package name and from kotlin metadata */
    public final C5711q cameraSurfaceManager;

    /* renamed from: l, reason: collision with root package name and from kotlin metadata */
    public final C5810d0 camera2Quirks;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    public final z.w timeSource;

    /* renamed from: n, reason: collision with root package name and from kotlin metadata */
    public final androidx.camera.camera2.pipe.e cameraGraphId;

    /* renamed from: o, reason: collision with root package name and from kotlin metadata */
    public final b shutdownListener;

    /* renamed from: p, reason: collision with root package name and from kotlin metadata */
    public final StreamGraph streamGraph;

    /* renamed from: q, reason: collision with root package name and from kotlin metadata */
    public final Object lock;

    /* renamed from: r, reason: collision with root package name and from kotlin metadata */
    public boolean _isForeground;

    /* renamed from: s, reason: collision with root package name and from kotlin metadata */
    public InterfaceC5703i.a controllerState;

    /* renamed from: t, reason: collision with root package name and from kotlin metadata */
    public f.a cameraAvailability;

    /* renamed from: u, reason: collision with root package name and from kotlin metadata */
    public C5706l lastCameraError;

    /* renamed from: v, reason: collision with root package name and from kotlin metadata */
    public x lastCameraPrioritiesChangedTs;

    /* renamed from: w, reason: collision with root package name and from kotlin metadata */
    public kotlinx.coroutines.g restartJob;

    /* renamed from: x, reason: collision with root package name and from kotlin metadata */
    public final q0 concurrentSessionSequencer;

    /* renamed from: y, reason: collision with root package name and from kotlin metadata */
    public final InterfaceC1083u<Y8.t> closedDeferred;

    /* renamed from: z, reason: collision with root package name and from kotlin metadata */
    public K0 currentCamera;

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"LUa/M;", "LY8/t;", "<anonymous>", "(LUa/M;)V"}, k = 3, mv = {2, 1, 0})
    @InterfaceC4112d(c = "androidx.camera.camera2.pipe.compat.Camera2CameraController$1", f = "Camera2CameraController.kt", l = {124}, m = "invokeSuspend", v = 1)
    /* renamed from: androidx.camera.camera2.pipe.compat.Camera2CameraController$1, reason: invalid class name */
    public static final class AnonymousClass1 extends SuspendLambda implements p9.p<M, InterfaceC4014c<? super Y8.t>, Object> {

        /* renamed from: a, reason: collision with root package name */
        public int f10298a;

        @Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
        /* renamed from: androidx.camera.camera2.pipe.compat.Camera2CameraController$1$a */
        public static final class a<T> implements Xa.c {

            /* renamed from: a, reason: collision with root package name */
            public final /* synthetic */ Camera2CameraController f10300a;

            public a(Camera2CameraController camera2CameraController) {
                this.f10300a = camera2CameraController;
            }

            @Override // Xa.c
            /* renamed from: b, reason: merged with bridge method [inline-methods] */
            public final Object emit(f.a aVar, InterfaceC4014c<? super Y8.t> interfaceC4014c) {
                if (aVar instanceof f.a.CameraAvailable) {
                    if (!C5708n.d(((f.a.CameraAvailable) aVar).getCamera(), this.f10300a.x())) {
                        throw new IllegalStateException("Check failed.");
                    }
                    this.f10300a.B(aVar);
                } else if (aVar instanceof f.a.CameraUnavailable) {
                    if (!C5708n.d(((f.a.CameraUnavailable) aVar).getCamera(), this.f10300a.x())) {
                        throw new IllegalStateException("Check failed.");
                    }
                    this.f10300a.B(aVar);
                }
                return Y8.t.f7040a;
            }
        }

        public AnonymousClass1(InterfaceC4014c<? super AnonymousClass1> interfaceC4014c) {
            super(2, interfaceC4014c);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final InterfaceC4014c<Y8.t> create(Object obj, InterfaceC4014c<?> interfaceC4014c) {
            return Camera2CameraController.this.new AnonymousClass1(interfaceC4014c);
        }

        @Override // p9.p
        public final Object invoke(M m10, InterfaceC4014c<? super Y8.t> interfaceC4014c) {
            return ((AnonymousClass1) create(m10, interfaceC4014c)).invokeSuspend(Y8.t.f7040a);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) throws Throwable {
            Object objG = C4063a.g();
            int i10 = this.f10298a;
            if (i10 == 0) {
                C4849c.b(obj);
                Xa.t<f.a> tVarB0 = Camera2CameraController.this.cameraStatusMonitor.b0();
                a aVar = new a(Camera2CameraController.this);
                this.f10298a = 1;
                if (tVarB0.collect(aVar, this) == objG) {
                    return objG;
                }
            } else {
                if (i10 != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                C4849c.b(obj);
            }
            throw new KotlinNothingValueException();
        }
    }

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"LUa/M;", "LY8/t;", "<anonymous>", "(LUa/M;)V"}, k = 3, mv = {2, 1, 0})
    @InterfaceC4112d(c = "androidx.camera.camera2.pipe.compat.Camera2CameraController$2", f = "Camera2CameraController.kt", l = {140}, m = "invokeSuspend", v = 1)
    /* renamed from: androidx.camera.camera2.pipe.compat.Camera2CameraController$2, reason: invalid class name */
    public static final class AnonymousClass2 extends SuspendLambda implements p9.p<M, InterfaceC4014c<? super Y8.t>, Object> {

        /* renamed from: a, reason: collision with root package name */
        public int f10301a;

        @Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
        /* renamed from: androidx.camera.camera2.pipe.compat.Camera2CameraController$2$a */
        public static final class a<T> implements Xa.c {

            /* renamed from: a, reason: collision with root package name */
            public final /* synthetic */ Camera2CameraController f10303a;

            public a(Camera2CameraController camera2CameraController) {
                this.f10303a = camera2CameraController;
            }

            @Override // Xa.c
            /* renamed from: b, reason: merged with bridge method [inline-methods] */
            public final Object emit(Y8.t tVar, InterfaceC4014c<? super Y8.t> interfaceC4014c) {
                this.f10303a.B(f.a.b.f1400a);
                return Y8.t.f7040a;
            }
        }

        public AnonymousClass2(InterfaceC4014c<? super AnonymousClass2> interfaceC4014c) {
            super(2, interfaceC4014c);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final InterfaceC4014c<Y8.t> create(Object obj, InterfaceC4014c<?> interfaceC4014c) {
            return Camera2CameraController.this.new AnonymousClass2(interfaceC4014c);
        }

        @Override // p9.p
        public final Object invoke(M m10, InterfaceC4014c<? super Y8.t> interfaceC4014c) {
            return ((AnonymousClass2) create(m10, interfaceC4014c)).invokeSuspend(Y8.t.f7040a);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) throws Throwable {
            Object objG = C4063a.g();
            int i10 = this.f10301a;
            if (i10 == 0) {
                C4849c.b(obj);
                Xa.o<Y8.t> oVarO = Camera2CameraController.this.cameraStatusMonitor.O();
                a aVar = new a(Camera2CameraController.this);
                this.f10301a = 1;
                if (oVarO.collect(aVar, this) == objG) {
                    return objG;
                }
            } else {
                if (i10 != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                C4849c.b(obj);
            }
            throw new KotlinNothingValueException();
        }
    }

    @Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J;\u0010\u000e\u001a\u00020\r2\u0006\u0010\u0005\u001a\u00020\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u00062\u0006\u0010\t\u001a\u00020\b2\b\u0010\u000b\u001a\u0004\u0018\u00010\n2\u0006\u0010\f\u001a\u00020\nH\u0001¢\u0006\u0004\b\u000e\u0010\u000fR\u0014\u0010\u0011\u001a\u00020\u00108\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u0011\u0010\u0012R\u0014\u0010\u0014\u001a\u00020\u00138\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u0014\u0010\u0015R\u0014\u0010\u0017\u001a\u00020\u00168\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0017\u0010\u0012¨\u0006\u0018"}, d2 = {"Landroidx/camera/camera2/pipe/compat/Camera2CameraController$a;", "", "<init>", "()V", "Lw/i$a;", "controllerState", "Lw/l;", "lastCameraError", "LB/f$a;", "cameraAvailability", "Lz/x;", "lastCameraPrioritiesChangedTs", "currentTs", "", Const.INTENT_KEY_APIKEY, "(Lw/i$a;Lw/l;LB/f$a;Lz/x;J)Z", "", "RESTART_TIMEOUT_WHEN_ENABLED_MS", "J", "", "MS_TO_NS", "I", "Lz/i;", "PRIORITIES_CHANGED_THRESHOLD_NS", "camera-camera2-pipe"}, k = 1, mv = {2, 1, 0}, xi = 48)
    /* renamed from: androidx.camera.camera2.pipe.compat.Camera2CameraController$a, reason: from kotlin metadata */
    public static final class Companion {
        public /* synthetic */ Companion(kotlin.jvm.internal.i iVar) {
            this();
        }

        /* JADX WARN: Removed duplicated region for block: B:10:0x0026  */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public final boolean a(w.InterfaceC5703i.a r4, w.C5706l r5, B.f.a r6, z.x r7, long r8) {
            /*
                r3 = this;
                java.lang.String r3 = "controllerState"
                kotlin.jvm.internal.p.i(r4, r3)
                java.lang.String r3 = "cameraAvailability"
                kotlin.jvm.internal.p.i(r6, r3)
                boolean r3 = r6 instanceof B.f.a.CameraAvailable
                r6 = 1
                r0 = 0
                if (r3 == 0) goto L26
                w.l$a r3 = w.C5706l.INSTANCE
                int r3 = r3.e()
                if (r5 != 0) goto L1a
                r3 = r0
                goto L22
            L1a:
                int r1 = r5.getValue()
                boolean r3 = w.C5706l.r(r1, r3)
            L22:
                if (r3 != 0) goto L26
                r3 = r6
                goto L27
            L26:
                r3 = r0
            L27:
                if (r7 != 0) goto L2b
            L29:
                r7 = r0
                goto L3f
            L2b:
                long r1 = r7.getValue()
                long r8 = r8 - r1
                long r7 = z.i.c(r8)
                long r1 = androidx.camera.camera2.pipe.compat.Camera2CameraController.m()
                int r7 = z.i.b(r7, r1)
                if (r7 > 0) goto L29
                r7 = r6
            L3f:
                w.i$a$c r8 = w.InterfaceC5703i.a.c.f43001a
                boolean r8 = kotlin.jvm.internal.p.d(r4, r8)
                if (r8 == 0) goto L4c
                if (r3 != 0) goto L4b
                if (r7 == 0) goto L7d
            L4b:
                return r6
            L4c:
                w.i$a$d r7 = w.InterfaceC5703i.a.d.f43002a
                boolean r4 = kotlin.jvm.internal.p.d(r4, r7)
                if (r4 == 0) goto L7d
                if (r3 == 0) goto L7d
                w.l$a r3 = w.C5706l.INSTANCE
                int r4 = r3.m()
                if (r5 != 0) goto L60
                r4 = r0
                goto L68
            L60:
                int r7 = r5.getValue()
                boolean r4 = w.C5706l.r(r7, r4)
            L68:
                if (r4 != 0) goto L7d
                int r3 = r3.o()
                if (r5 != 0) goto L72
                r3 = r0
                goto L7a
            L72:
                int r4 = r5.getValue()
                boolean r3 = w.C5706l.r(r4, r3)
            L7a:
                if (r3 != 0) goto L7d
                return r6
            L7d:
                return r0
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.camera.camera2.pipe.compat.Camera2CameraController.Companion.a(w.i$a, w.l, B.f$a, z.x, long):boolean");
        }

        public Companion() {
        }
    }

    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b`\u0018\u00002\u00020\u0001J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0005\u0010\u0006ø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001¨\u0006\u0007À\u0006\u0001"}, d2 = {"Landroidx/camera/camera2/pipe/compat/Camera2CameraController$b;", "", "Lw/i;", "cameraController", "LY8/t;", Const.INTENT_KEY_BACKGROUND_NOTIFICATION_ID, "(Lw/i;)V", "camera-camera2-pipe"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public interface b {
        void i(InterfaceC5703i cameraController);
    }

    @Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
    public static final class c<T> implements Xa.c {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Ref$ObjectRef<CaptureSessionState> f10307a;

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ Camera2CameraController f10308b;

        public c(Ref$ObjectRef<CaptureSessionState> ref$ObjectRef, Camera2CameraController camera2CameraController) {
            this.f10307a = ref$ObjectRef;
            this.f10308b = camera2CameraController;
        }

        @Override // Xa.c
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public final Object emit(AbstractC5824k0 abstractC5824k0, InterfaceC4014c<? super Y8.t> interfaceC4014c) {
            if (abstractC5824k0 instanceof CameraStateOpen) {
                this.f10307a.f34820a.z(((CameraStateOpen) abstractC5824k0).getCameraDevice());
            } else if (abstractC5824k0 instanceof CameraStateClosing) {
                this.f10307a.f34820a.A();
            } else if (abstractC5824k0 instanceof CameraStateClosed) {
                this.f10307a.f34820a.A();
                this.f10308b.C((CameraStateClosed) abstractC5824k0);
            }
            return Y8.t.f7040a;
        }
    }

    public Camera2CameraController(M scope, Threads threads, S strictMode, CameraGraph.b graphConfig, A.e graphListener, T surfaceTracker, B.f cameraStatusMonitor, r captureSessionFactory, N captureSequenceProcessorFactory, X camera2DeviceManager, C5711q cameraSurfaceManager, C5810d0 camera2Quirks, z.w timeSource, androidx.camera.camera2.pipe.e cameraGraphId, b shutdownListener, StreamGraph streamGraph, r0 concurrentSessionSequencers) {
        kotlin.jvm.internal.p.i(scope, "scope");
        kotlin.jvm.internal.p.i(threads, "threads");
        kotlin.jvm.internal.p.i(strictMode, "strictMode");
        kotlin.jvm.internal.p.i(graphConfig, "graphConfig");
        kotlin.jvm.internal.p.i(graphListener, "graphListener");
        kotlin.jvm.internal.p.i(surfaceTracker, "surfaceTracker");
        kotlin.jvm.internal.p.i(cameraStatusMonitor, "cameraStatusMonitor");
        kotlin.jvm.internal.p.i(captureSessionFactory, "captureSessionFactory");
        kotlin.jvm.internal.p.i(captureSequenceProcessorFactory, "captureSequenceProcessorFactory");
        kotlin.jvm.internal.p.i(camera2DeviceManager, "camera2DeviceManager");
        kotlin.jvm.internal.p.i(cameraSurfaceManager, "cameraSurfaceManager");
        kotlin.jvm.internal.p.i(camera2Quirks, "camera2Quirks");
        kotlin.jvm.internal.p.i(timeSource, "timeSource");
        kotlin.jvm.internal.p.i(cameraGraphId, "cameraGraphId");
        kotlin.jvm.internal.p.i(shutdownListener, "shutdownListener");
        kotlin.jvm.internal.p.i(streamGraph, "streamGraph");
        kotlin.jvm.internal.p.i(concurrentSessionSequencers, "concurrentSessionSequencers");
        this.scope = scope;
        this.threads = threads;
        this.strictMode = strictMode;
        this.graphConfig = graphConfig;
        this.graphListener = graphListener;
        this.surfaceTracker = surfaceTracker;
        this.cameraStatusMonitor = cameraStatusMonitor;
        this.captureSessionFactory = captureSessionFactory;
        this.captureSequenceProcessorFactory = captureSequenceProcessorFactory;
        this.camera2DeviceManager = camera2DeviceManager;
        this.cameraSurfaceManager = cameraSurfaceManager;
        this.camera2Quirks = camera2Quirks;
        this.timeSource = timeSource;
        this.cameraGraphId = cameraGraphId;
        this.shutdownListener = shutdownListener;
        this.streamGraph = streamGraph;
        this.lock = new Object();
        this._isForeground = true;
        this.controllerState = InterfaceC5703i.a.f.f43004a;
        this.cameraAvailability = new f.a.CameraUnavailable(x(), null);
        ConcurrentCameraGraphs concurrentCameraGraphs = graphConfig.getConcurrentCameraGraphs();
        this.concurrentSessionSequencer = concurrentCameraGraphs != null ? concurrentSessionSequencers.a(getCameraGraphId(), concurrentCameraGraphs) : null;
        this.closedDeferred = C1087w.c(null, 1, null);
        this.cameraAvailabilityJob = C1060i.d(scope, null, null, new AnonymousClass1(null), 3, null);
        this.cameraPrioritiesJob = C1060i.d(scope, null, null, new AnonymousClass2(null), 3, null);
    }

    public static final boolean E(Camera2CameraController camera2CameraController, Y8.t tVar) {
        kotlin.jvm.internal.p.i(tVar, "<unused var>");
        return camera2CameraController.A();
    }

    public static final Y8.t v(Camera2CameraController camera2CameraController, Throwable th) {
        synchronized (camera2CameraController.lock) {
            try {
                camera2CameraController.controllerState = InterfaceC5703i.a.C0545a.f42999a;
                if (z.k.f44508a.a()) {
                    Log.d("CXCP", camera2CameraController + " is closed");
                }
                Y8.t tVar = Y8.t.f7040a;
            } catch (Throwable th2) {
                throw th2;
            }
        }
        camera2CameraController.shutdownListener.i(camera2CameraController);
        InterfaceC1083u<Y8.t> interfaceC1083u = camera2CameraController.closedDeferred;
        Y8.t tVar2 = Y8.t.f7040a;
        interfaceC1083u.complete(tVar2);
        kotlinx.coroutines.d.e(camera2CameraController.scope, null, 1, null);
        return tVar2;
    }

    public boolean A() {
        boolean z10;
        synchronized (this.lock) {
            z10 = this._isForeground;
        }
        return z10;
    }

    public final void B(f.a cameraStatus) {
        if (z.k.f44508a.a()) {
            Log.d("CXCP", this + " (" + ((Object) C5708n.f(x())) + ") camera status changed: " + cameraStatus);
        }
        synchronized (this.lock) {
            try {
                if (z()) {
                    return;
                }
                if ((cameraStatus instanceof f.a.CameraAvailable) || (cameraStatus instanceof f.a.CameraUnavailable)) {
                    this.cameraAvailability = cameraStatus;
                } else if (cameraStatus instanceof f.a.b) {
                    this.lastCameraPrioritiesChangedTs = x.a(this.timeSource.a());
                }
                G();
                Y8.t tVar = Y8.t.f7040a;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public final void C(CameraStateClosed cameraState) {
        synchronized (this.lock) {
            try {
                if (z()) {
                    return;
                }
                if (cameraState.getCameraErrorCode() != null) {
                    this.lastCameraError = cameraState.getCameraErrorCode();
                    if (C5706l.t(cameraState.getCameraErrorCode().getValue())) {
                        this.controllerState = InterfaceC5703i.a.c.f43001a;
                        if (z.k.f44508a.a()) {
                            Log.d("CXCP", this + " is disconnected");
                        }
                    } else {
                        this.controllerState = InterfaceC5703i.a.d.f43002a;
                        if (z.k.f44508a.a()) {
                            Log.d("CXCP", this + " encountered error: " + ((Object) C5706l.u(cameraState.getCameraErrorCode().getValue())));
                        }
                    }
                } else {
                    this.controllerState = InterfaceC5703i.a.f.f43004a;
                }
                this.surfaceTracker.b();
                G();
                Y8.t tVar = Y8.t.f7040a;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public final void D() {
        Set<C5708n> setD;
        if (z()) {
            if (z.k.f44508a.c()) {
                Log.i("CXCP", "Ignoring start(): " + this + " is already closed");
                return;
            }
            return;
        }
        InterfaceC5703i.a aVar = this.controllerState;
        InterfaceC5703i.a.e eVar = InterfaceC5703i.a.e.f43003a;
        if (kotlin.jvm.internal.p.d(aVar, eVar)) {
            if (z.k.f44508a.d()) {
                Log.w("CXCP", "Ignoring start(): " + this + " is already started");
                return;
            }
            return;
        }
        this.lastCameraError = null;
        String camera = this.graphConfig.getCamera();
        ConcurrentCameraGraphs concurrentCameraGraphs = this.graphConfig.getConcurrentCameraGraphs();
        if (concurrentCameraGraphs == null || (setD = concurrentCameraGraphs.b()) == null) {
            setD = Z8.X.d(C5708n.a(camera));
        }
        K0 k0C = this.camera2DeviceManager.c(camera, F.m1(Z.n(setD, C5708n.a(camera))), this.graphListener, false, new InterfaceC5074l() { // from class: x.z
            @Override // p9.InterfaceC5074l
            public final Object invoke(Object obj) {
                return Boolean.valueOf(Camera2CameraController.E(this.f43458a, (Y8.t) obj));
            }
        });
        if (k0C == null) {
            if (z.k.f44508a.b()) {
                Log.e("CXCP", "Failed to start " + this + ": Open request submission failed");
                return;
            }
            return;
        }
        if (this.currentCamera != null) {
            throw new IllegalStateException("Check failed.");
        }
        if (this.currentSession != null) {
            throw new IllegalStateException("Check failed.");
        }
        this.currentCamera = k0C;
        CaptureSessionState captureSessionState = new CaptureSessionState(this.graphListener, this.captureSessionFactory, this.captureSequenceProcessorFactory, this.cameraSurfaceManager, this.timeSource, this.graphConfig.getFlags(), this.concurrentSessionSequencer, this.streamGraph, this.strictMode, this.threads, this.scope);
        this.currentSession = captureSessionState;
        Map<Q, ? extends Surface> map = this.currentSurfaceMap;
        if (map != null) {
            captureSessionState.u(map);
        }
        this.controllerState = eVar;
        if (z.k.f44508a.a()) {
            Log.d("CXCP", "Started " + this);
        }
        kotlinx.coroutines.g gVar = this.currentCameraStateJob;
        if (gVar != null) {
            kotlinx.coroutines.g.Y0(gVar, null, 1, null);
        }
        this.currentCameraStateJob = C1060i.d(this.scope, null, null, new Camera2CameraController$startLocked$5(this, null), 3, null);
    }

    public final void F() {
        if (z()) {
            if (z.k.f44508a.d()) {
                Log.w("CXCP", "Ignoring stop(): " + this + " is already closed");
                return;
            }
            return;
        }
        InterfaceC5703i.a aVar = this.controllerState;
        InterfaceC5703i.a.g gVar = InterfaceC5703i.a.g.f43005a;
        if (kotlin.jvm.internal.p.d(aVar, gVar) || kotlin.jvm.internal.p.d(this.controllerState, InterfaceC5703i.a.f.f43004a)) {
            if (z.k.f44508a.d()) {
                Log.w("CXCP", "Ignoring stop(): " + this + " already stopping or stopped");
                return;
            }
            return;
        }
        K0 k02 = this.currentCamera;
        CaptureSessionState captureSessionState = this.currentSession;
        this.currentCamera = null;
        this.currentSession = null;
        this.controllerState = gVar;
        if (z.k.f44508a.a()) {
            Log.d("CXCP", "Stopping " + this);
        }
        u(captureSessionState, k02);
    }

    public final void G() {
        long jA = this.timeSource.a();
        if (INSTANCE.a(this.controllerState, this.lastCameraError, this.cameraAvailability, this.lastCameraPrioritiesChangedTs, jA)) {
            long j10 = this.graphConfig.getFlags().getEnableRestartDelays() ? 700L : 0L;
            kotlinx.coroutines.g gVar = this.restartJob;
            if (gVar != null) {
                kotlinx.coroutines.g.Y0(gVar, null, 1, null);
            }
            this.restartJob = C1060i.d(this.scope, null, null, new Camera2CameraController$tryRestart$2(j10, this, null), 3, null);
            return;
        }
        if (z.k.f44508a.a()) {
            Log.d("CXCP", this + ": Not restarting. Controller state = " + getControllerState() + ", last camera error = " + this.lastCameraError + ", camera availability = " + this.cameraAvailability + ", last camera priorities changed = " + this.lastCameraPrioritiesChangedTs + ", current timestamp = " + ((Object) x.f(jA)) + '.');
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    @Override // w.InterfaceC5703i
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public java.lang.Object b(e9.InterfaceC4014c<? super java.lang.Boolean> r7) throws java.lang.Throwable {
        /*
            r6 = this;
            boolean r0 = r7 instanceof androidx.camera.camera2.pipe.compat.Camera2CameraController$awaitClosed$1
            if (r0 == 0) goto L13
            r0 = r7
            androidx.camera.camera2.pipe.compat.Camera2CameraController$awaitClosed$1 r0 = (androidx.camera.camera2.pipe.compat.Camera2CameraController$awaitClosed$1) r0
            int r1 = r0.f10306c
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.f10306c = r1
            goto L18
        L13:
            androidx.camera.camera2.pipe.compat.Camera2CameraController$awaitClosed$1 r0 = new androidx.camera.camera2.pipe.compat.Camera2CameraController$awaitClosed$1
            r0.<init>(r6, r7)
        L18:
            java.lang.Object r7 = r0.f10304a
            java.lang.Object r1 = f9.C4063a.g()
            int r2 = r0.f10306c
            r3 = 1
            if (r2 == 0) goto L32
            if (r2 != r3) goto L2a
            kotlin.C4849c.b(r7)
            goto Lc0
        L2a:
            java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
            java.lang.String r7 = "call to 'resume' before 'invoke' with coroutine"
            r6.<init>(r7)
            throw r6
        L32:
            kotlin.C4849c.b(r7)
            z.k r7 = z.k.f44508a
            boolean r2 = r7.a()
            if (r2 == 0) goto L53
            java.lang.String r2 = "CXCP"
            java.lang.StringBuilder r4 = new java.lang.StringBuilder
            r4.<init>()
            r4.append(r6)
            java.lang.String r5 = "#awaitClosed"
            r4.append(r5)
            java.lang.String r4 = r4.toString()
            android.util.Log.d(r2, r4)
        L53:
            java.lang.Object r2 = r6.lock
            monitor-enter(r2)
            w.i$a r4 = r6.controllerState     // Catch: java.lang.Throwable -> L7d
            w.i$a$a r5 = w.InterfaceC5703i.a.C0545a.f42999a     // Catch: java.lang.Throwable -> L7d
            boolean r4 = kotlin.jvm.internal.p.d(r4, r5)     // Catch: java.lang.Throwable -> L7d
            if (r4 == 0) goto L85
            boolean r7 = r7.a()     // Catch: java.lang.Throwable -> L7d
            if (r7 == 0) goto L7f
            java.lang.String r7 = "CXCP"
            java.lang.StringBuilder r0 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L7d
            r0.<init>()     // Catch: java.lang.Throwable -> L7d
            r0.append(r6)     // Catch: java.lang.Throwable -> L7d
            java.lang.String r6 = "#awaitClosed: Controller is already closed."
            r0.append(r6)     // Catch: java.lang.Throwable -> L7d
            java.lang.String r6 = r0.toString()     // Catch: java.lang.Throwable -> L7d
            android.util.Log.d(r7, r6)     // Catch: java.lang.Throwable -> L7d
            goto L7f
        L7d:
            r6 = move-exception
            goto Lc5
        L7f:
            java.lang.Boolean r6 = g9.C4109a.a(r3)     // Catch: java.lang.Throwable -> L7d
            monitor-exit(r2)
            return r6
        L85:
            w.i$a r4 = r6.controllerState     // Catch: java.lang.Throwable -> L7d
            w.i$a$b r5 = w.InterfaceC5703i.a.b.f43000a     // Catch: java.lang.Throwable -> L7d
            boolean r4 = kotlin.jvm.internal.p.d(r4, r5)     // Catch: java.lang.Throwable -> L7d
            if (r4 != 0) goto Lb2
            boolean r7 = r7.d()     // Catch: java.lang.Throwable -> L7d
            if (r7 == 0) goto Lab
            java.lang.String r7 = "CXCP"
            java.lang.StringBuilder r0 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L7d
            r0.<init>()     // Catch: java.lang.Throwable -> L7d
            r0.append(r6)     // Catch: java.lang.Throwable -> L7d
            java.lang.String r6 = "#awaitClosed: Controller isn't closing!"
            r0.append(r6)     // Catch: java.lang.Throwable -> L7d
            java.lang.String r6 = r0.toString()     // Catch: java.lang.Throwable -> L7d
            android.util.Log.w(r7, r6)     // Catch: java.lang.Throwable -> L7d
        Lab:
            r6 = 0
            java.lang.Boolean r6 = g9.C4109a.a(r6)     // Catch: java.lang.Throwable -> L7d
            monitor-exit(r2)
            return r6
        Lb2:
            Y8.t r7 = Y8.t.f7040a     // Catch: java.lang.Throwable -> L7d
            monitor-exit(r2)
            Ua.u<Y8.t> r6 = r6.closedDeferred
            r0.f10306c = r3
            java.lang.Object r6 = r6.a1(r0)
            if (r6 != r1) goto Lc0
            return r1
        Lc0:
            java.lang.Boolean r6 = g9.C4109a.a(r3)
            return r6
        Lc5:
            monitor-exit(r2)
            throw r6
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.camera.camera2.pipe.compat.Camera2CameraController.b(e9.c):java.lang.Object");
    }

    @Override // w.InterfaceC5703i
    public void c(Map<Q, ? extends Surface> surfaceMap) {
        kotlin.jvm.internal.p.i(surfaceMap, "surfaceMap");
        synchronized (this.lock) {
            if (z()) {
                return;
            }
            this.currentSurfaceMap = surfaceMap;
            CaptureSessionState captureSessionState = this.currentSession;
            if (captureSessionState != null) {
                captureSessionState.u(surfaceMap);
            }
        }
    }

    @Override // w.InterfaceC5703i
    public void close() {
        synchronized (this.lock) {
            try {
                if (z()) {
                    return;
                }
                this.controllerState = InterfaceC5703i.a.b.f43000a;
                z.k kVar = z.k.f44508a;
                if (kVar.a()) {
                    Log.d("CXCP", "Closed " + this);
                }
                K0 k02 = this.currentCamera;
                CaptureSessionState captureSessionState = this.currentSession;
                this.currentCamera = null;
                this.currentSession = null;
                kotlinx.coroutines.g gVar = this.restartJob;
                if (gVar != null) {
                    kotlinx.coroutines.g.Y0(gVar, null, 1, null);
                }
                kotlinx.coroutines.g gVar2 = this.currentCameraStateJob;
                if (gVar2 != null) {
                    kotlinx.coroutines.g.Y0(gVar2, null, 1, null);
                }
                this.currentCameraStateJob = null;
                kotlinx.coroutines.g gVar3 = this.cameraAvailabilityJob;
                if (gVar3 != null) {
                    kotlinx.coroutines.g.Y0(gVar3, null, 1, null);
                }
                this.cameraAvailabilityJob = null;
                kotlinx.coroutines.g gVar4 = this.cameraPrioritiesJob;
                if (gVar4 != null) {
                    kotlinx.coroutines.g.Y0(gVar4, null, 1, null);
                }
                this.cameraPrioritiesJob = null;
                C5423E.a(this.cameraStatusMonitor);
                u(captureSessionState, k02);
                if (this.graphConfig.getFlags().getCloseCameraDeviceOnClose() || this.camera2Quirks.c(x())) {
                    if (kVar.a()) {
                        Log.d("CXCP", "Quirk: Closing " + ((Object) C5708n.f(x())) + " during " + this + "#close");
                    }
                    this.camera2DeviceManager.b(x());
                }
                Y8.t tVar = Y8.t.f7040a;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // w.InterfaceC5703i
    public void h(boolean z10) {
        synchronized (this.lock) {
            this._isForeground = z10;
            Y8.t tVar = Y8.t.f7040a;
        }
    }

    @Override // w.InterfaceC5703i
    public void start() {
        synchronized (this.lock) {
            D();
            Y8.t tVar = Y8.t.f7040a;
        }
    }

    /* JADX WARN: Type inference failed for: r3v0, types: [T, androidx.camera.camera2.pipe.compat.CaptureSessionState] */
    public final Object t(InterfaceC4014c<? super Y8.t> interfaceC4014c) {
        K0 k02;
        ?? r32;
        Ref$ObjectRef ref$ObjectRef = new Ref$ObjectRef();
        synchronized (this.lock) {
            k02 = this.currentCamera;
            r32 = this.currentSession;
            ref$ObjectRef.f34820a = r32;
            Y8.t tVar = Y8.t.f7040a;
        }
        if (k02 == null || r32 == 0) {
            return Y8.t.f7040a;
        }
        Object objCollect = k02.getState().collect(new c(ref$ObjectRef, this), interfaceC4014c);
        return objCollect == C4063a.g() ? objCollect : Y8.t.f7040a;
    }

    public String toString() {
        return "Camera2CameraController(" + getCameraGraphId() + ')';
    }

    public final void u(CaptureSessionState session, K0 camera) {
        kotlinx.coroutines.g gVarD = C1060i.d(this.scope, null, null, new Camera2CameraController$detachSessionAndCamera$job$1(session, camera, null), 3, null);
        if (kotlin.jvm.internal.p.d(this.controllerState, InterfaceC5703i.a.b.f43000a)) {
            gVarD.J(new InterfaceC5074l() { // from class: x.y
                @Override // p9.InterfaceC5074l
                public final Object invoke(Object obj) {
                    return Camera2CameraController.v(this.f43456a, (Throwable) obj);
                }
            });
        }
    }

    /* renamed from: w, reason: from getter */
    public androidx.camera.camera2.pipe.e getCameraGraphId() {
        return this.cameraGraphId;
    }

    public String x() {
        return this.graphConfig.getCamera();
    }

    /* renamed from: y, reason: from getter */
    public final InterfaceC5703i.a getControllerState() {
        return this.controllerState;
    }

    public final boolean z() {
        return kotlin.jvm.internal.p.d(this.controllerState, InterfaceC5703i.a.b.f43000a) || kotlin.jvm.internal.p.d(this.controllerState, InterfaceC5703i.a.C0545a.f42999a);
    }
}
