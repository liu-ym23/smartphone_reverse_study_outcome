package androidx.camera.camera2.pipe.compat;

import Ua.C1060i;
import Ua.M;
import Z8.F;
import Z8.Z;
import android.os.Trace;
import android.util.Log;
import android.view.Surface;
import androidx.camera.camera2.pipe.CameraGraph;
import androidx.camera.camera2.pipe.compat.o;
import androidx.camera.camera2.pipe.core.Threads;
import androidx.exifinterface.media.ExifInterface;
import com.autonavi.aps.amapapi.config.Const;
import com.stepos.ailauncher.chat.voicewakeup.VoiceWakeupReceiver;
import com.stepos.statsapp.v3.lib.plugin.constants.UxipConstants;
import h9.InterfaceC4149a;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.CountDownLatch;
import kotlin.Metadata;
import s.C5423E;
import w.AbstractC5689A;
import w.C5706l;
import w.C5711q;
import w.G;
import w.Q;
import w.S;
import x.N;
import x.p0;
import x.q0;
import x.w0;
import z.x;
import z.y;

@Metadata(d1 = {"\u0000î\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0012\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0010\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010%\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\b\u0000\u0018\u0000 *2\u00020\u0001:\u0004\u0089\u0001B7Ba\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\u0006\u0010\u0007\u001a\u00020\u0006\u0012\u0006\u0010\t\u001a\u00020\b\u0012\u0006\u0010\u000b\u001a\u00020\n\u0012\u0006\u0010\r\u001a\u00020\f\u0012\b\u0010\u000f\u001a\u0004\u0018\u00010\u000e\u0012\u0006\u0010\u0011\u001a\u00020\u0010\u0012\u0006\u0010\u0013\u001a\u00020\u0012\u0012\u0006\u0010\u0015\u001a\u00020\u0014\u0012\u0006\u0010\u0017\u001a\u00020\u0016¢\u0006\u0004\b\u0018\u0010\u0019J\u0019\u0010\u001d\u001a\u00020\u001c2\b\u0010\u001b\u001a\u0004\u0018\u00010\u001aH\u0002¢\u0006\u0004\b\u001d\u0010\u001eJ\u0019\u0010!\u001a\u00020\u001c2\b\b\u0002\u0010 \u001a\u00020\u001fH\u0002¢\u0006\u0004\b!\u0010\"J\u0010\u0010#\u001a\u00020\u001cH\u0082@¢\u0006\u0004\b#\u0010$J7\u0010*\u001a\u00020\u001c2\u0012\u0010(\u001a\u000e\u0012\u0004\u0012\u00020&\u0012\u0004\u0012\u00020'0%2\u0012\u0010)\u001a\u000e\u0012\u0004\u0012\u00020&\u0012\u0004\u0012\u00020'0%H\u0003¢\u0006\u0004\b*\u0010+J!\u0010-\u001a\u00020\u001c2\u0012\u0010,\u001a\u000e\u0012\u0004\u0012\u00020&\u0012\u0004\u0012\u00020'0%¢\u0006\u0004\b-\u0010.J\u0017\u0010/\u001a\u00020\u001c2\u0006\u0010\u001b\u001a\u00020\u001aH\u0016¢\u0006\u0004\b/\u0010\u001eJ\u0017\u00100\u001a\u00020\u001c2\u0006\u0010\u001b\u001a\u00020\u001aH\u0016¢\u0006\u0004\b0\u0010\u001eJ\u0017\u00101\u001a\u00020\u001c2\u0006\u0010\u001b\u001a\u00020\u001aH\u0016¢\u0006\u0004\b1\u0010\u001eJ\u0017\u00102\u001a\u00020\u001c2\u0006\u0010\u001b\u001a\u00020\u001aH\u0016¢\u0006\u0004\b2\u0010\u001eJ\u0017\u00103\u001a\u00020\u001c2\u0006\u0010\u001b\u001a\u00020\u001aH\u0016¢\u0006\u0004\b3\u0010\u001eJ\u0017\u00104\u001a\u00020\u001c2\u0006\u0010\u001b\u001a\u00020\u001aH\u0016¢\u0006\u0004\b4\u0010\u001eJ\u000f\u00105\u001a\u00020\u001cH\u0016¢\u0006\u0004\b5\u00106J\u000f\u00107\u001a\u00020\u001cH\u0016¢\u0006\u0004\b7\u00106J\r\u00108\u001a\u00020\u001c¢\u0006\u0004\b8\u00106J\r\u00109\u001a\u00020\u001c¢\u0006\u0004\b9\u00106J\u0019\u0010<\u001a\u00020\u001c2\b\b\u0002\u0010;\u001a\u00020:H\u0000¢\u0006\u0004\b<\u0010=J\u000f\u0010?\u001a\u00020>H\u0016¢\u0006\u0004\b?\u0010@R\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b7\u0010AR\u0014\u0010\u0005\u001a\u00020\u00048\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bB\u0010CR\u0014\u0010\u0007\u001a\u00020\u00068\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b3\u0010DR\u0014\u0010\t\u001a\u00020\b8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b1\u0010ER\u0014\u0010\u000b\u001a\u00020\n8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b2\u0010FR\u0014\u0010\r\u001a\u00020\f8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bG\u0010HR\u0016\u0010\u000f\u001a\u0004\u0018\u00010\u000e8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bI\u0010JR\u0014\u0010\u0011\u001a\u00020\u00108\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b5\u0010KR\u0014\u0010\u0013\u001a\u00020\u00128\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b/\u0010LR\u0014\u0010\u0015\u001a\u00020\u00148\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b4\u0010MR\u0014\u0010\u0017\u001a\u00020\u00168\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b0\u0010NR\u0014\u0010R\u001a\u00020O8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bP\u0010QR\u0014\u0010V\u001a\u00020S8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bT\u0010UR\u001a\u0010Z\u001a\b\u0012\u0004\u0012\u00020\u001f0W8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bX\u0010YRT\u0010_\u001aB\u0012\f\u0012\n \\*\u0004\u0018\u00010&0&\u0012\f\u0012\n \\*\u0004\u0018\u00010'0' \\* \u0012\f\u0012\n \\*\u0004\u0018\u00010&0&\u0012\f\u0012\n \\*\u0004\u0018\u00010'0'\u0018\u00010%0[8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b]\u0010^RT\u0010b\u001aB\u0012\f\u0012\n \\*\u0004\u0018\u00010`0`\u0012\f\u0012\n \\*\u0004\u0018\u00010'0' \\* \u0012\f\u0012\n \\*\u0004\u0018\u00010`0`\u0012\f\u0012\n \\*\u0004\u0018\u00010'0'\u0018\u00010%0[8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\ba\u0010^R\u0018\u0010f\u001a\u0004\u0018\u00010c8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bd\u0010eR\u0016\u0010j\u001a\u0004\u0018\u00010g8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bh\u0010iR\u0018\u0010n\u001a\u0004\u0018\u00010k8\u0002@\u0002X\u0083\u000e¢\u0006\u0006\n\u0004\bl\u0010mR\u0018\u0010q\u001a\u0004\u0018\u00010o8\u0002@\u0002X\u0083\u000e¢\u0006\u0006\n\u0004\b\u001d\u0010pR$\u0010s\u001a\u0010\u0012\u0004\u0012\u00020&\u0012\u0004\u0012\u00020r\u0018\u00010%8\u0002@\u0002X\u0083\u000e¢\u0006\u0006\n\u0004\b-\u0010^R$\u0010t\u001a\u0010\u0012\u0004\u0012\u00020&\u0012\u0004\u0012\u00020'\u0018\u00010%8\u0002@\u0002X\u0083\u000e¢\u0006\u0006\n\u0004\b8\u0010^R\u0016\u0010w\u001a\u00020u8\u0002@\u0002X\u0083\u000e¢\u0006\u0006\n\u0004\b!\u0010vR\u0014\u0010{\u001a\u00020x8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\by\u0010zR\u0016\u0010}\u001a\u00020\u001f8\u0002@\u0002X\u0083\u000e¢\u0006\u0006\n\u0004\b<\u0010|R\u0014\u0010\u007f\u001a\u00020x8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b~\u0010zR%\u0010\u0080\u0001\u001a\u0010\u0012\u0004\u0012\u00020&\u0012\u0004\u0012\u00020'\u0018\u00010%8\u0002@\u0002X\u0083\u000e¢\u0006\u0006\n\u0004\b9\u0010^R'\u0010\u0083\u0001\u001a\u0014\u0012\u0004\u0012\u00020'\u0012\n\u0012\b0\u0081\u0001j\u0003`\u0082\u00010[8\u0002X\u0083\u0004¢\u0006\u0006\n\u0004\b#\u0010^R-\u0010\u0088\u0001\u001a\u0004\u0018\u00010k2\t\u0010\u0084\u0001\u001a\u0004\u0018\u00010k8F@FX\u0086\u000e¢\u0006\u000f\u001a\u0006\b\u0085\u0001\u0010\u0086\u0001\"\u0005\b~\u0010\u0087\u0001¨\u0006\u008a\u0001"}, d2 = {"Landroidx/camera/camera2/pipe/compat/CaptureSessionState;", "Landroidx/camera/camera2/pipe/compat/o$a;", "LA/e;", "graphListener", "Landroidx/camera/camera2/pipe/compat/r;", "captureSessionFactory", "Lx/N;", "captureSequenceProcessorFactory", "Lw/q;", "cameraSurfaceManager", "Lz/w;", "timeSource", "Landroidx/camera/camera2/pipe/CameraGraph$d;", "cameraGraphFlags", "Lx/q0;", "concurrentSessionSequencer", "Landroidx/camera/camera2/pipe/v;", "streamGraph", "Lw/S;", "strictMode", "Landroidx/camera/camera2/pipe/core/Threads;", "threads", "LUa/M;", "scope", "<init>", "(LA/e;Landroidx/camera/camera2/pipe/compat/r;Lx/N;Lw/q;Lz/w;Landroidx/camera/camera2/pipe/CameraGraph$d;Lx/q0;Landroidx/camera/camera2/pipe/v;Lw/S;Landroidx/camera/camera2/pipe/core/Threads;LUa/M;)V", "Landroidx/camera/camera2/pipe/compat/o;", "session", "LY8/t;", "t", "(Landroidx/camera/camera2/pipe/compat/o;)V", "", "retryAllowed", "w", "(Z)V", "B", "(Le9/c;)Ljava/lang/Object;", "", "Lw/Q;", "Landroid/view/Surface;", "oldSurfaceMap", "newSurfaceMap", "C", "(Ljava/util/Map;Ljava/util/Map;)V", "surfaces", "u", "(Ljava/util/Map;)V", Const.INTENT_KEY_BACKGROUND_NOTIFICATION_ID, "k", Const.INTENT_KEY_UMID, "e", "c", Const.INTENT_KEY_BACKGROUND_NOTIFICATION_REMOVE, Const.INTENT_KEY_BACKGROUND_NOTIFICATION, "()V", Const.INTENT_KEY_APIKEY, "v", ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, "", "delayMs", "y", "(J)V", "", "toString", "()Ljava/lang/String;", "LA/e;", Const.INTENT_KEY_PKGNAME, "Landroidx/camera/camera2/pipe/compat/r;", "Lx/N;", "Lw/q;", "Lz/w;", "f", "Landroidx/camera/camera2/pipe/CameraGraph$d;", Const.INTENT_KEY_BACKGROUND_COMMAND, "Lx/q0;", "Landroidx/camera/camera2/pipe/v;", "Lw/S;", "Landroidx/camera/camera2/pipe/core/Threads;", "LUa/M;", "", "l", "I", "debugId", "", "m", "Ljava/lang/Object;", "lock", "LOa/e;", "n", "LOa/e;", "finalized", "", "kotlin.jvm.PlatformType", "o", "Ljava/util/Map;", "activeStreamSurfaceMap", "Lw/G;", "p", "activeOutputSurfaceMap", "Lz/x;", "q", "Lz/x;", "sessionCreatingTimestamp", "Landroidx/camera/camera2/pipe/compat/SessionSequencer;", "r", "Landroidx/camera/camera2/pipe/compat/SessionSequencer;", "sessionSequencer", "Landroidx/camera/camera2/pipe/compat/p;", "s", "Landroidx/camera/camera2/pipe/compat/p;", "_cameraDevice", "Landroidx/camera/camera2/pipe/compat/CaptureSessionState$b;", "Landroidx/camera/camera2/pipe/compat/CaptureSessionState$b;", "cameraCaptureSession", "Lx/w0;", "pendingOutputMap", "pendingSurfaceMap", "Landroidx/camera/camera2/pipe/compat/CaptureSessionState$State;", "Landroidx/camera/camera2/pipe/compat/CaptureSessionState$State;", VoiceWakeupReceiver.EXTRA_STATE, "Ljava/util/concurrent/CountDownLatch;", "x", "Ljava/util/concurrent/CountDownLatch;", "sessionDisconnected", "Z", "hasAttemptedCaptureSession", "z", "captureSessionAttemptCompleted", "_surfaceMap", "Ljava/lang/AutoCloseable;", "Lkotlin/AutoCloseable;", "_surfaceTokenMap", UxipConstants.f30680s, "getCameraDevice", "()Landroidx/camera/camera2/pipe/compat/p;", "(Landroidx/camera/camera2/pipe/compat/p;)V", "cameraDevice", "State", "camera-camera2-pipe"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes.dex */
public final class CaptureSessionState implements o.a {

    /* renamed from: A, reason: collision with root package name and from kotlin metadata */
    public Map<Q, ? extends Surface> _surfaceMap;

    /* renamed from: B, reason: collision with root package name and from kotlin metadata */
    public final Map<Surface, AutoCloseable> _surfaceTokenMap;

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    public final A.e graphListener;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    public final r captureSessionFactory;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    public final N captureSequenceProcessorFactory;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    public final C5711q cameraSurfaceManager;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    public final z.w timeSource;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    public final CameraGraph.Flags cameraGraphFlags;

    /* renamed from: g, reason: collision with root package name and from kotlin metadata */
    public final q0 concurrentSessionSequencer;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    public final androidx.camera.camera2.pipe.v streamGraph;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    public final S strictMode;

    /* renamed from: j, reason: collision with root package name and from kotlin metadata */
    public final Threads threads;

    /* renamed from: k, reason: collision with root package name and from kotlin metadata */
    public final M scope;

    /* renamed from: l, reason: collision with root package name and from kotlin metadata */
    public final int debugId;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    public final Object lock;

    /* renamed from: n, reason: collision with root package name and from kotlin metadata */
    public final Oa.e<Boolean> finalized;

    /* renamed from: o, reason: collision with root package name and from kotlin metadata */
    public final Map<Q, Surface> activeStreamSurfaceMap;

    /* renamed from: p, reason: collision with root package name and from kotlin metadata */
    public final Map<G, Surface> activeOutputSurfaceMap;

    /* renamed from: q, reason: collision with root package name and from kotlin metadata */
    public x sessionCreatingTimestamp;

    /* renamed from: r, reason: collision with root package name and from kotlin metadata */
    public final SessionSequencer sessionSequencer;

    /* renamed from: s, reason: collision with root package name and from kotlin metadata */
    public p _cameraDevice;

    /* renamed from: t, reason: collision with root package name and from kotlin metadata */
    public ConfiguredCameraCaptureSession cameraCaptureSession;

    /* renamed from: u, reason: collision with root package name and from kotlin metadata */
    public Map<Q, ? extends w0> pendingOutputMap;

    /* renamed from: v, reason: collision with root package name and from kotlin metadata */
    public Map<Q, ? extends Surface> pendingSurfaceMap;

    /* renamed from: w, reason: collision with root package name and from kotlin metadata */
    public State state;

    /* renamed from: x, reason: collision with root package name and from kotlin metadata */
    public final CountDownLatch sessionDisconnected;

    /* renamed from: y, reason: collision with root package name and from kotlin metadata */
    public boolean hasAttemptedCaptureSession;

    /* renamed from: z, reason: collision with root package name and from kotlin metadata */
    public final CountDownLatch captureSessionAttemptCompleted;

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* JADX WARN: Unknown enum class pattern. Please report as an issue! */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\b\b\u0082\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\b¨\u0006\t"}, d2 = {"Landroidx/camera/camera2/pipe/compat/CaptureSessionState$State;", "", "<init>", "(Ljava/lang/String;I)V", "PENDING", "CREATING", "CREATED", "CLOSING", "CLOSED", "camera-camera2-pipe"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class State {
        private static final /* synthetic */ InterfaceC4149a $ENTRIES;
        private static final /* synthetic */ State[] $VALUES;
        public static final State PENDING = new State("PENDING", 0);
        public static final State CREATING = new State("CREATING", 1);
        public static final State CREATED = new State("CREATED", 2);
        public static final State CLOSING = new State("CLOSING", 3);
        public static final State CLOSED = new State("CLOSED", 4);

        private static final /* synthetic */ State[] $values() {
            return new State[]{PENDING, CREATING, CREATED, CLOSING, CLOSED};
        }

        static {
            State[] stateArr$values = $values();
            $VALUES = stateArr$values;
            $ENTRIES = kotlin.enums.a.a(stateArr$values);
        }

        private State(String str, int i10) {
        }

        public static InterfaceC4149a<State> getEntries() {
            return $ENTRIES;
        }

        public static State valueOf(String str) {
            return (State) Enum.valueOf(State.class, str);
        }

        public static State[] values() {
            return (State[]) $VALUES.clone();
        }
    }

    @Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\f\b\u0082\b\u0018\u00002\u00020\u0001B!\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006¢\u0006\u0004\b\b\u0010\tJ\u0010\u0010\u000b\u001a\u00020\nHÖ\u0001¢\u0006\u0004\b\u000b\u0010\fJ\u0010\u0010\u000e\u001a\u00020\rHÖ\u0001¢\u0006\u0004\b\u000e\u0010\u000fJ\u001a\u0010\u0012\u001a\u00020\u00112\b\u0010\u0010\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u0012\u0010\u0013R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0014\u0010\u0015\u001a\u0004\b\u0016\u0010\u0017R\u0017\u0010\u0005\u001a\u00020\u00048\u0006¢\u0006\f\n\u0004\b\u0018\u0010\u0019\u001a\u0004\b\u0018\u0010\u001aR\u0019\u0010\u0007\u001a\u0004\u0018\u00010\u00068\u0006¢\u0006\f\n\u0004\b\u0016\u0010\u001b\u001a\u0004\b\u0014\u0010\u001c¨\u0006\u001d"}, d2 = {"Landroidx/camera/camera2/pipe/compat/CaptureSessionState$b;", "", "Landroidx/camera/camera2/pipe/compat/o;", "session", "LA/h;", "processor", "Landroidx/camera/camera2/pipe/compat/Camera2CaptureSequenceProcessor;", "captureSequenceProcessor", "<init>", "(Landroidx/camera/camera2/pipe/compat/o;LA/h;Landroidx/camera/camera2/pipe/compat/Camera2CaptureSequenceProcessor;)V", "", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "other", "", "equals", "(Ljava/lang/Object;)Z", Const.INTENT_KEY_APIKEY, "Landroidx/camera/camera2/pipe/compat/o;", "c", "()Landroidx/camera/camera2/pipe/compat/o;", Const.INTENT_KEY_PKGNAME, "LA/h;", "()LA/h;", "Landroidx/camera/camera2/pipe/compat/Camera2CaptureSequenceProcessor;", "()Landroidx/camera/camera2/pipe/compat/Camera2CaptureSequenceProcessor;", "camera-camera2-pipe"}, k = 1, mv = {2, 1, 0}, xi = 48)
    /* renamed from: androidx.camera.camera2.pipe.compat.CaptureSessionState$b, reason: from toString */
    public static final /* data */ class ConfiguredCameraCaptureSession {

        /* renamed from: a, reason: collision with root package name and from kotlin metadata and from toString */
        public final o session;

        /* renamed from: b, reason: collision with root package name and from kotlin metadata and from toString */
        public final A.h processor;

        /* renamed from: c, reason: collision with root package name and from kotlin metadata and from toString */
        public final Camera2CaptureSequenceProcessor captureSequenceProcessor;

        public ConfiguredCameraCaptureSession(o session, A.h processor, Camera2CaptureSequenceProcessor camera2CaptureSequenceProcessor) {
            kotlin.jvm.internal.p.i(session, "session");
            kotlin.jvm.internal.p.i(processor, "processor");
            this.session = session;
            this.processor = processor;
            this.captureSequenceProcessor = camera2CaptureSequenceProcessor;
        }

        /* renamed from: a, reason: from getter */
        public final Camera2CaptureSequenceProcessor getCaptureSequenceProcessor() {
            return this.captureSequenceProcessor;
        }

        /* renamed from: b, reason: from getter */
        public final A.h getProcessor() {
            return this.processor;
        }

        /* renamed from: c, reason: from getter */
        public final o getSession() {
            return this.session;
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof ConfiguredCameraCaptureSession)) {
                return false;
            }
            ConfiguredCameraCaptureSession configuredCameraCaptureSession = (ConfiguredCameraCaptureSession) other;
            return kotlin.jvm.internal.p.d(this.session, configuredCameraCaptureSession.session) && kotlin.jvm.internal.p.d(this.processor, configuredCameraCaptureSession.processor) && kotlin.jvm.internal.p.d(this.captureSequenceProcessor, configuredCameraCaptureSession.captureSequenceProcessor);
        }

        public int hashCode() {
            int iHashCode = ((this.session.hashCode() * 31) + this.processor.hashCode()) * 31;
            Camera2CaptureSequenceProcessor camera2CaptureSequenceProcessor = this.captureSequenceProcessor;
            return iHashCode + (camera2CaptureSequenceProcessor == null ? 0 : camera2CaptureSequenceProcessor.hashCode());
        }

        public String toString() {
            return "ConfiguredCameraCaptureSession(session=" + this.session + ", processor=" + this.processor + ", captureSequenceProcessor=" + this.captureSequenceProcessor + ')';
        }
    }

    public CaptureSessionState(A.e graphListener, r captureSessionFactory, N captureSequenceProcessorFactory, C5711q cameraSurfaceManager, z.w timeSource, CameraGraph.Flags cameraGraphFlags, q0 q0Var, androidx.camera.camera2.pipe.v streamGraph, S strictMode, Threads threads, M scope) {
        kotlin.jvm.internal.p.i(graphListener, "graphListener");
        kotlin.jvm.internal.p.i(captureSessionFactory, "captureSessionFactory");
        kotlin.jvm.internal.p.i(captureSequenceProcessorFactory, "captureSequenceProcessorFactory");
        kotlin.jvm.internal.p.i(cameraSurfaceManager, "cameraSurfaceManager");
        kotlin.jvm.internal.p.i(timeSource, "timeSource");
        kotlin.jvm.internal.p.i(cameraGraphFlags, "cameraGraphFlags");
        kotlin.jvm.internal.p.i(streamGraph, "streamGraph");
        kotlin.jvm.internal.p.i(strictMode, "strictMode");
        kotlin.jvm.internal.p.i(threads, "threads");
        kotlin.jvm.internal.p.i(scope, "scope");
        this.graphListener = graphListener;
        this.captureSessionFactory = captureSessionFactory;
        this.captureSequenceProcessorFactory = captureSequenceProcessorFactory;
        this.cameraSurfaceManager = cameraSurfaceManager;
        this.timeSource = timeSource;
        this.cameraGraphFlags = cameraGraphFlags;
        this.concurrentSessionSequencer = q0Var;
        this.streamGraph = streamGraph;
        this.strictMode = strictMode;
        this.threads = threads;
        this.scope = scope;
        this.debugId = p0.a().d();
        this.lock = new Object();
        this.finalized = Oa.b.g(Boolean.FALSE);
        this.activeStreamSurfaceMap = Collections.synchronizedMap(new HashMap());
        this.activeOutputSurfaceMap = Collections.synchronizedMap(new HashMap());
        this.sessionSequencer = q0Var != null ? new SessionSequencer(q0Var) : null;
        this.state = State.PENDING;
        this.sessionDisconnected = new CountDownLatch(1);
        this.captureSessionAttemptCompleted = new CountDownLatch(1);
        this._surfaceTokenMap = new LinkedHashMap();
    }

    public static /* synthetic */ void x(CaptureSessionState captureSessionState, boolean z10, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            z10 = true;
        }
        captureSessionState.w(z10);
    }

    /* JADX WARN: Removed duplicated region for block: B:19:0x003a  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void A() {
        /*
            r8 = this;
            r8.v()
            java.lang.Object r0 = r8.lock
            monitor-enter(r0)
            androidx.camera.camera2.pipe.compat.CaptureSessionState$State r1 = r8.state     // Catch: java.lang.Throwable -> L38
            androidx.camera.camera2.pipe.compat.CaptureSessionState$State r2 = androidx.camera.camera2.pipe.compat.CaptureSessionState.State.CLOSED     // Catch: java.lang.Throwable -> L38
            r3 = 0
            if (r1 == r2) goto L3a
            androidx.camera.camera2.pipe.compat.p r1 = r8._cameraDevice     // Catch: java.lang.Throwable -> L38
            r5 = 1
            if (r1 == 0) goto L3b
            boolean r1 = r8.hasAttemptedCaptureSession     // Catch: java.lang.Throwable -> L38
            if (r1 != 0) goto L18
            goto L3b
        L18:
            androidx.camera.camera2.pipe.CameraGraph$d r1 = r8.cameraGraphFlags     // Catch: java.lang.Throwable -> L38
            int r1 = r1.getFinalizeSessionOnCloseBehavior()     // Catch: java.lang.Throwable -> L38
            androidx.camera.camera2.pipe.CameraGraph$d$a$a r6 = androidx.camera.camera2.pipe.CameraGraph.Flags.a.INSTANCE     // Catch: java.lang.Throwable -> L38
            int r7 = r6.a()     // Catch: java.lang.Throwable -> L38
            boolean r7 = androidx.camera.camera2.pipe.CameraGraph.Flags.a.e(r1, r7)     // Catch: java.lang.Throwable -> L38
            if (r7 == 0) goto L2b
            goto L3b
        L2b:
            int r6 = r6.c()     // Catch: java.lang.Throwable -> L38
            boolean r1 = androidx.camera.camera2.pipe.CameraGraph.Flags.a.e(r1, r6)     // Catch: java.lang.Throwable -> L38
            if (r1 == 0) goto L3a
            r3 = 2000(0x7d0, double:9.88E-321)
            goto L3b
        L38:
            r8 = move-exception
            goto L49
        L3a:
            r5 = 0
        L3b:
            r1 = 0
            r8._cameraDevice = r1     // Catch: java.lang.Throwable -> L38
            r8.state = r2     // Catch: java.lang.Throwable -> L38
            Y8.t r1 = Y8.t.f7040a     // Catch: java.lang.Throwable -> L38
            monitor-exit(r0)
            if (r5 == 0) goto L48
            r8.y(r3)
        L48:
            return
        L49:
            monitor-exit(r0)
            throw r8
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.camera.camera2.pipe.compat.CaptureSessionState.A():void");
    }

    /* JADX WARN: Removed duplicated region for block: B:41:0x00aa  */
    /* JADX WARN: Removed duplicated region for block: B:51:0x00f9  */
    /* JADX WARN: Removed duplicated region for block: B:52:0x00fe  */
    /* JADX WARN: Removed duplicated region for block: B:57:0x012b  */
    /* JADX WARN: Removed duplicated region for block: B:62:0x014f  */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /* JADX WARN: Type inference failed for: r5v1, types: [T, java.util.Map<w.Q, ? extends android.view.Surface>] */
    /* JADX WARN: Type inference failed for: r5v2, types: [T, androidx.camera.camera2.pipe.compat.p] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object B(e9.InterfaceC4014c<? super Y8.t> r8) throws java.lang.Throwable {
        /*
            Method dump skipped, instructions count: 634
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.camera.camera2.pipe.compat.CaptureSessionState.B(e9.c):java.lang.Object");
    }

    public final void C(Map<Q, ? extends Surface> oldSurfaceMap, Map<Q, ? extends Surface> newSurfaceMap) throws Exception {
        Set setR1 = F.r1(oldSurfaceMap.values());
        Set setR12 = F.r1(newSurfaceMap.values());
        for (Surface surface : Z.m(setR1, setR12)) {
            AutoCloseable autoCloseableRemove = this._surfaceTokenMap.remove(surface);
            if (autoCloseableRemove != null) {
                C5423E.a(autoCloseableRemove);
            } else {
                autoCloseableRemove = null;
            }
            if (autoCloseableRemove == null) {
                throw new IllegalStateException(("Surface " + surface + " doesn't have a matching surface token!").toString());
            }
        }
        for (Surface surface2 : Z.m(setR12, setR1)) {
            this._surfaceTokenMap.put(surface2, this.cameraSurfaceManager.d(surface2));
        }
    }

    @Override // x.I0
    public void a() {
        if (this.finalized.a(Boolean.FALSE, Boolean.TRUE)) {
            if (z.k.f44508a.a()) {
                Log.d("CXCP", this + " session finalizing");
            }
            z.h hVar = z.h.f44503a;
            Trace.beginSection(this + "#onSessionFinalized");
            A();
            y(0L);
            Trace.endSection();
        }
    }

    @Override // androidx.camera.camera2.pipe.compat.o.a
    public void c(o session) {
        kotlin.jvm.internal.p.i(session, "session");
        if (z.k.f44508a.a()) {
            Log.d("CXCP", this + " Ready");
        }
    }

    @Override // androidx.camera.camera2.pipe.compat.o.a
    public void d(o session) {
        kotlin.jvm.internal.p.i(session, "session");
        if (z.k.f44508a.d()) {
            Log.w("CXCP", this + " Configuration Failed");
        }
        z.h hVar = z.h.f44503a;
        Trace.beginSection(this + "#onConfigureFailed");
        this.graphListener.c(new AbstractC5689A.a(C5706l.INSTANCE.m(), false, null));
        A();
        this.captureSessionAttemptCompleted.countDown();
        SessionSequencer sessionSequencer = this.sessionSequencer;
        if (sessionSequencer != null) {
            sessionSequencer.b();
        }
        Trace.endSection();
    }

    @Override // androidx.camera.camera2.pipe.compat.o.a
    public void e(o session) {
        kotlin.jvm.internal.p.i(session, "session");
        if (z.k.f44508a.a()) {
            Log.d("CXCP", this + " Configured");
        }
        z.h hVar = z.h.f44503a;
        Trace.beginSection(this + "#configure");
        t(session);
        this.captureSessionAttemptCompleted.countDown();
        SessionSequencer sessionSequencer = this.sessionSequencer;
        if (sessionSequencer != null) {
            sessionSequencer.b();
        }
        Trace.endSection();
    }

    @Override // x.I0
    public void h() {
        if (z.k.f44508a.a()) {
            Log.d("CXCP", this + " session disconnecting");
        }
        z.h hVar = z.h.f44503a;
        Trace.beginSection(this + "#onSessionDisconnected");
        v();
        try {
            Trace.beginSection(this + "#onSessionDisconnected Await");
            this.sessionDisconnected.await();
            Y8.t tVar = Y8.t.f7040a;
            Trace.endSection();
        } finally {
            Trace.endSection();
        }
    }

    @Override // androidx.camera.camera2.pipe.compat.o.a
    public void i(o session) {
        kotlin.jvm.internal.p.i(session, "session");
        if (z.k.f44508a.a()) {
            Log.d("CXCP", this + " Active");
        }
    }

    @Override // androidx.camera.camera2.pipe.compat.o.a
    public void j(o session) {
        kotlin.jvm.internal.p.i(session, "session");
        if (z.k.f44508a.a()) {
            Log.d("CXCP", this + " CaptureQueueEmpty");
        }
    }

    @Override // androidx.camera.camera2.pipe.compat.o.a
    public void k(o session) {
        kotlin.jvm.internal.p.i(session, "session");
        if (z.k.f44508a.a()) {
            Log.d("CXCP", this + " Closed");
        }
        z.h hVar = z.h.f44503a;
        Trace.beginSection(this + "#onClosed");
        A();
        this.captureSessionAttemptCompleted.countDown();
        SessionSequencer sessionSequencer = this.sessionSequencer;
        if (sessionSequencer != null) {
            sessionSequencer.b();
        }
        Trace.endSection();
    }

    public final void t(o session) {
        synchronized (this.lock) {
            try {
                ConfiguredCameraCaptureSession configuredCameraCaptureSession = this.cameraCaptureSession;
                if (configuredCameraCaptureSession == null && session != null) {
                    N n10 = this.captureSequenceProcessorFactory;
                    Map<Q, Surface> activeStreamSurfaceMap = this.activeStreamSurfaceMap;
                    kotlin.jvm.internal.p.h(activeStreamSurfaceMap, "activeStreamSurfaceMap");
                    Map<G, Surface> activeOutputSurfaceMap = this.activeOutputSurfaceMap;
                    kotlin.jvm.internal.p.h(activeOutputSurfaceMap, "activeOutputSurfaceMap");
                    androidx.camera.camera2.pipe.m<?, ?> mVarA = n10.a(session, activeStreamSurfaceMap, activeOutputSurfaceMap);
                    configuredCameraCaptureSession = mVarA instanceof Camera2CaptureSequenceProcessor ? new ConfiguredCameraCaptureSession(session, A.h.INSTANCE.a(mVarA), (Camera2CaptureSequenceProcessor) mVarA) : new ConfiguredCameraCaptureSession(session, A.h.INSTANCE.a(mVarA), null);
                    this.cameraCaptureSession = configuredCameraCaptureSession;
                }
                if (this.state == State.CREATED && configuredCameraCaptureSession != null) {
                    boolean z10 = (this.pendingOutputMap == null || this.pendingSurfaceMap == null) ? false : true;
                    Y8.t tVar = Y8.t.f7040a;
                    if (z10) {
                        w(false);
                    }
                    synchronized (this.lock) {
                        try {
                            if (z.k.f44508a.c()) {
                                y yVar = y.f44525a;
                                long jA = this.timeSource.a();
                                x xVar = this.sessionCreatingTimestamp;
                                kotlin.jvm.internal.p.f(xVar);
                                long jC = z.i.c(jA - xVar.getValue());
                                StringBuilder sb2 = new StringBuilder();
                                sb2.append("Configured ");
                                sb2.append(this);
                                sb2.append(" in ");
                                String str = String.format(null, "%.3f ms", Arrays.copyOf(new Object[]{Double.valueOf(jC / 1000000.0d)}, 1));
                                kotlin.jvm.internal.p.h(str, "format(...)");
                                sb2.append(str);
                                Log.i("CXCP", sb2.toString());
                            }
                            this.graphListener.f(configuredCameraCaptureSession.getProcessor());
                        } catch (Throwable th) {
                            throw th;
                        }
                    }
                }
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }

    public String toString() {
        return "CaptureSessionState-" + this.debugId;
    }

    public final void u(Map<Q, ? extends Surface> surfaces) {
        kotlin.jvm.internal.p.i(surfaces, "surfaces");
        synchronized (this.lock) {
            try {
                State state = this.state;
                if (state != State.CLOSING && state != State.CLOSED) {
                    Map<Q, ? extends Surface> mapI = this._surfaceMap;
                    if (mapI == null) {
                        mapI = kotlin.collections.a.i();
                    }
                    C(mapI, surfaces);
                    this._surfaceMap = surfaces;
                    Map<Q, ? extends w0> map = this.pendingOutputMap;
                    if (map != null && this.pendingSurfaceMap == null) {
                        LinkedHashMap linkedHashMap = new LinkedHashMap();
                        for (Map.Entry<Q, ? extends Surface> entry : surfaces.entrySet()) {
                            if (map.containsKey(entry.getKey())) {
                                linkedHashMap.put(entry.getKey(), entry.getValue());
                            }
                        }
                        if (linkedHashMap.size() == map.size()) {
                            this.pendingSurfaceMap = linkedHashMap;
                            C1060i.d(this.scope, null, null, new CaptureSessionState$configureSurfaceMap$1$1(this, null), 3, null);
                        }
                    }
                    C1060i.d(this.scope, null, null, new CaptureSessionState$configureSurfaceMap$1$2(this, null), 3, null);
                }
                Y8.t tVar = Y8.t.f7040a;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public final void v() {
        synchronized (this.lock) {
            try {
                State state = this.state;
                State state2 = State.CLOSING;
                if (state != state2 && state != State.CLOSED) {
                    this.state = state2;
                    ConfiguredCameraCaptureSession configuredCameraCaptureSession = this.cameraCaptureSession;
                    boolean z10 = false;
                    if (configuredCameraCaptureSession != null) {
                        this.cameraCaptureSession = null;
                    } else {
                        if (this.cameraGraphFlags.getCloseCaptureSessionOnDisconnect() && this.hasAttemptedCaptureSession) {
                            z10 = true;
                        }
                        configuredCameraCaptureSession = null;
                    }
                    Y8.t tVar = Y8.t.f7040a;
                    SessionSequencer sessionSequencer = this.sessionSequencer;
                    if (sessionSequencer != null) {
                        sessionSequencer.b();
                    }
                    if (z10) {
                        z.k kVar = z.k.f44508a;
                        if (kVar.a()) {
                            Log.d("CXCP", "Waiting for CameraCaptureSession configuration");
                        }
                        if (((Y8.t) this.threads.n(3000L, new CaptureSessionState$disconnect$3(this, null))) == null && kVar.b()) {
                            Log.e("CXCP", "Waiting for CameraCaptureSession configuration timed out");
                        }
                        synchronized (this.lock) {
                            configuredCameraCaptureSession = this.cameraCaptureSession;
                            this.cameraCaptureSession = null;
                        }
                    }
                    z.h hVar = z.h.f44503a;
                    Trace.beginSection(this.graphListener + "#onGraphStopping");
                    this.graphListener.a();
                    Trace.endSection();
                    if (configuredCameraCaptureSession != null) {
                        A.h processor = configuredCameraCaptureSession.getProcessor();
                        z.k kVar2 = z.k.f44508a;
                        if (kVar2.a()) {
                            Log.d("CXCP", this + " Shutdown");
                        }
                        Trace.beginSection(this + "#shutdown");
                        if (this.cameraGraphFlags.getAbortCapturesOnStop() && ((Y8.t) this.threads.n(2000L, new CaptureSessionState$disconnect$9(this, processor, null))) == null && kVar2.b()) {
                            Log.e("CXCP", "Failed to abort captures in 2000ms");
                        }
                        Trace.beginSection(this + "#disconnect");
                        Camera2CaptureSequenceProcessor captureSequenceProcessor = configuredCameraCaptureSession.getCaptureSequenceProcessor();
                        if (captureSequenceProcessor != null) {
                            captureSequenceProcessor.r();
                        }
                        Trace.endSection();
                        if (this.cameraGraphFlags.getCloseCaptureSessionOnDisconnect() && ((Y8.t) this.threads.n(3000L, new CaptureSessionState$disconnect$12(this, configuredCameraCaptureSession, null))) == null && kVar2.b()) {
                            Log.e("CXCP", "Failed to close the capture session in 3000ms");
                        }
                        Trace.beginSection(this.graphListener + "#onGraphStopped");
                        this.graphListener.e(processor);
                        Trace.endSection();
                        Trace.endSection();
                    } else {
                        Trace.beginSection(this.graphListener + "#onGraphStopped");
                        this.graphListener.e(null);
                        Trace.endSection();
                    }
                    this.sessionDisconnected.countDown();
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public final void w(boolean retryAllowed) {
        ConfiguredCameraCaptureSession configuredCameraCaptureSession;
        Map<Q, ? extends w0> map;
        Map<Q, ? extends Surface> map2;
        boolean z10;
        synchronized (this.lock) {
            configuredCameraCaptureSession = this.cameraCaptureSession;
            map = this.pendingOutputMap;
            map2 = this.pendingSurfaceMap;
            Y8.t tVar = Y8.t.f7040a;
        }
        if (configuredCameraCaptureSession == null || map == null || map2 == null) {
            return;
        }
        z.h hVar = z.h.f44503a;
        Trace.beginSection(this + "#finalizeOutputConfigurations");
        y yVar = y.f44525a;
        long jA = this.timeSource.a();
        for (Map.Entry<Q, ? extends w0> entry : map.entrySet()) {
            int value = entry.getKey().getValue();
            w0 value2 = entry.getValue();
            Surface surface = map2.get(Q.a(value));
            if (surface == null) {
                throw new IllegalStateException("Required value was null.");
            }
            value2.n(surface);
        }
        LinkedHashSet linkedHashSet = new LinkedHashSet();
        Iterator<Map.Entry<Q, ? extends w0>> it = map.entrySet().iterator();
        while (it.hasNext()) {
            linkedHashSet.add(it.next().getValue());
        }
        configuredCameraCaptureSession.getSession().f0(F.m1(linkedHashSet));
        synchronized (this.lock) {
            try {
                if (this.state == State.CREATED) {
                    this.activeStreamSurfaceMap.putAll(map2);
                    Iterator<Map.Entry<Q, ? extends Surface>> it2 = map2.entrySet().iterator();
                    while (true) {
                        z10 = true;
                        if (it2.hasNext()) {
                            Map.Entry<Q, ? extends Surface> next = it2.next();
                            int value3 = next.getKey().getValue();
                            Surface value4 = next.getValue();
                            androidx.camera.camera2.pipe.k kVarB = this.streamGraph.b(value3);
                            if (kVarB == null) {
                                throw new IllegalStateException("Required value was null.");
                            }
                            if (kVarB.b().size() != 1) {
                                throw new IllegalStateException("Cannot finalize a multi-output stream!");
                            }
                            Map<G, Surface> activeOutputSurfaceMap = this.activeOutputSurfaceMap;
                            kotlin.jvm.internal.p.h(activeOutputSurfaceMap, "activeOutputSurfaceMap");
                            activeOutputSurfaceMap.put(G.a(((androidx.camera.camera2.pipe.s) F.X0(kVarB.b())).getId()), value4);
                        } else if (z.k.f44508a.c()) {
                            y yVar2 = y.f44525a;
                            long jC = z.i.c(this.timeSource.a() - jA);
                            StringBuilder sb2 = new StringBuilder();
                            sb2.append("Finalized ");
                            ArrayList arrayList = new ArrayList(map.size());
                            Iterator<Map.Entry<Q, ? extends w0>> it3 = map.entrySet().iterator();
                            while (it3.hasNext()) {
                                arrayList.add(Q.a(it3.next().getKey().getValue()));
                            }
                            sb2.append(arrayList);
                            sb2.append(" for ");
                            sb2.append(this);
                            sb2.append(" in ");
                            y yVar3 = y.f44525a;
                            String str = String.format(null, "%.3f ms", Arrays.copyOf(new Object[]{Double.valueOf(jC / 1000000.0d)}, 1));
                            kotlin.jvm.internal.p.h(str, "format(...)");
                            sb2.append(str);
                            Log.i("CXCP", sb2.toString());
                        }
                    }
                } else {
                    z10 = false;
                }
                Y8.t tVar2 = Y8.t.f7040a;
            } catch (Throwable th) {
                throw th;
            }
        }
        if (z10 && retryAllowed) {
            this.graphListener.d(configuredCameraCaptureSession.getProcessor());
        }
        z.h hVar2 = z.h.f44503a;
        Trace.endSection();
    }

    public final void y(long delayMs) {
        List listM1;
        if (delayMs != 0) {
            C1060i.d(this.scope, null, null, new CaptureSessionState$finalizeSession$1(delayMs, this, null), 3, null);
            return;
        }
        if (z.k.f44508a.a()) {
            Log.d("CXCP", "Finalizing " + this);
        }
        synchronized (this.lock) {
            listM1 = F.m1(this._surfaceTokenMap.values());
            this._surfaceTokenMap.clear();
        }
        Iterator it = listM1.iterator();
        while (it.hasNext()) {
            C5423E.a((AutoCloseable) it.next());
        }
    }

    public final void z(p pVar) {
        synchronized (this.lock) {
            try {
                State state = this.state;
                if (state != State.CLOSING && state != State.CLOSED) {
                    this._cameraDevice = pVar;
                    if (pVar != null) {
                        C1060i.d(this.scope, null, null, new CaptureSessionState$cameraDevice$2$1(this, null), 3, null);
                    }
                    Y8.t tVar = Y8.t.f7040a;
                }
            } finally {
            }
        }
    }
}
