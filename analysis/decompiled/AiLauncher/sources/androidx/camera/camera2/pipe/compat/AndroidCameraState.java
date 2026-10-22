package androidx.camera.camera2.pipe.compat;

import android.hardware.camera2.CameraDevice;
import android.os.Trace;
import android.util.Log;
import androidx.camera.camera2.pipe.core.Threads;
import androidx.camera.camera2.pipe.f;
import com.autonavi.aps.amapapi.config.Const;
import com.stepos.ailauncher.chat.voicewakeup.VoiceWakeupReceiver;
import e9.InterfaceC4014c;
import f9.C4063a;
import java.util.Arrays;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;
import kotlin.Metadata;
import w.C5706l;
import w.C5708n;
import x.AbstractC5824k0;
import x.C5810d0;
import x.CameraStateClosed;
import x.CameraStateClosing;
import x.CameraStateOpen;
import x.L0;
import x.W;
import x.o0;
import z.x;
import z.y;

@Metadata(d1 = {"\u0000¸\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u0003\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0019\n\u0002\u0010\u0000\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0000\u0018\u00002\u00020\u0001:\u0001EBo\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\u0006\u0010\u0007\u001a\u00020\u0006\u0012\u0006\u0010\t\u001a\u00020\b\u0012\u0006\u0010\u000b\u001a\u00020\n\u0012\u0006\u0010\r\u001a\u00020\f\u0012\u0006\u0010\u000f\u001a\u00020\u000e\u0012\u0006\u0010\u0011\u001a\u00020\u0010\u0012\u0006\u0010\u0013\u001a\u00020\u0012\u0012\u0006\u0010\u0015\u001a\u00020\u0014\u0012\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\u0001\u0012\n\b\u0002\u0010\u0018\u001a\u0004\u0018\u00010\u0017¢\u0006\u0004\b\u0019\u0010\u001aJ\r\u0010\u001c\u001a\u00020\u001b¢\u0006\u0004\b\u001c\u0010\u001dJ\u0010\u0010\u001e\u001a\u00020\u001bH\u0086@¢\u0006\u0004\b\u001e\u0010\u001fJ\u0017\u0010#\u001a\u00020\"2\u0006\u0010!\u001a\u00020 H\u0000¢\u0006\u0004\b#\u0010$J\u0017\u0010'\u001a\u00020\u001b2\u0006\u0010&\u001a\u00020%H\u0016¢\u0006\u0004\b'\u0010(J\u0017\u0010)\u001a\u00020\u001b2\u0006\u0010&\u001a\u00020%H\u0016¢\u0006\u0004\b)\u0010(J\u001f\u0010+\u001a\u00020\u001b2\u0006\u0010&\u001a\u00020%2\u0006\u0010*\u001a\u00020\u0006H\u0016¢\u0006\u0004\b+\u0010,J\u0017\u0010-\u001a\u00020\u001b2\u0006\u0010&\u001a\u00020%H\u0016¢\u0006\u0004\b-\u0010(J\u0017\u0010.\u001a\u00020\u001b2\u0006\u0010&\u001a\u00020%H\u0000¢\u0006\u0004\b.\u0010(J\u0017\u00101\u001a\u00020\u001b2\u0006\u00100\u001a\u00020/H\u0000¢\u0006\u0004\b1\u00102J\u000f\u00104\u001a\u000203H\u0016¢\u0006\u0004\b4\u00105J\u001f\u00108\u001a\u00020\u001b2\u0006\u00100\u001a\u00020/2\u0006\u00107\u001a\u000206H\u0002¢\u0006\u0004\b8\u00109J!\u0010<\u001a\u00020\u001b2\b\u0010&\u001a\u0004\u0018\u00010%2\u0006\u0010;\u001a\u00020:H\u0002¢\u0006\u0004\b<\u0010=J\u0017\u0010@\u001a\u00020?2\u0006\u0010>\u001a\u00020:H\u0002¢\u0006\u0004\b@\u0010AJ%\u0010B\u001a\u00020\"*\u00020\u00102\u0006\u0010\u0003\u001a\u00020\u00022\b\u00107\u001a\u0004\u0018\u000106H\u0002¢\u0006\u0004\bB\u0010CJ%\u0010D\u001a\u00020\"*\u00020\u00102\u0006\u0010\u0003\u001a\u00020\u00022\b\u00107\u001a\u0004\u0018\u000106H\u0002¢\u0006\u0004\bD\u0010CR\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\bE\u0010F\u001a\u0004\bG\u00105R\u0017\u0010\u0005\u001a\u00020\u00048\u0006¢\u0006\f\n\u0004\bH\u0010I\u001a\u0004\bJ\u0010KR\u0014\u0010\u0007\u001a\u00020\u00068\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bL\u0010MR\u0014\u0010\t\u001a\u00020\b8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b#\u0010NR\u0014\u0010\u000b\u001a\u00020\n8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001e\u0010OR\u0014\u0010\r\u001a\u00020\f8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001c\u0010PR\u0014\u0010\u000f\u001a\u00020\u000e8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b<\u0010QR\u0014\u0010\u0011\u001a\u00020\u00108\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b1\u0010RR\u0014\u0010\u0013\u001a\u00020\u00128\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b8\u0010SR\u0014\u0010\u0015\u001a\u00020\u00148\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b@\u0010TR\u0016\u0010\u0016\u001a\u0004\u0018\u00010\u00018\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bG\u0010UR\u0016\u0010\u0018\u001a\u0004\u0018\u00010\u00178\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bV\u0010WR\u0014\u0010X\u001a\u00020\u00068\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b.\u0010MR\u0014\u0010[\u001a\u00020Y8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bD\u0010ZR\u0016\u0010]\u001a\u00020\"8\u0002@\u0002X\u0083\u000e¢\u0006\u0006\n\u0004\bB\u0010\\R\u0018\u0010`\u001a\u0004\u0018\u00010:8\u0002@\u0002X\u0083\u000e¢\u0006\u0006\n\u0004\b^\u0010_R\u0016\u0010b\u001a\u00020\"8\u0002@\u0002X\u0083\u000e¢\u0006\u0006\n\u0004\ba\u0010\\R\u0014\u0010f\u001a\u00020c8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bd\u0010eR\u0014\u0010h\u001a\u00020\b8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bg\u0010NR\u0018\u0010k\u001a\u0004\u0018\u00010\b8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bi\u0010jR\u001a\u0010p\u001a\b\u0012\u0004\u0012\u00020m0l8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bn\u0010oR\u0017\u0010s\u001a\b\u0012\u0004\u0012\u00020m0q8F¢\u0006\u0006\u001a\u0004\bV\u0010r¨\u0006t"}, d2 = {"Landroidx/camera/camera2/pipe/compat/AndroidCameraState;", "Landroid/hardware/camera2/CameraDevice$StateCallback;", "Lw/n;", "cameraId", "Landroidx/camera/camera2/pipe/g;", "metadata", "", "attemptNumber", "Lz/x;", "attemptTimestampNanos", "Lz/w;", "timeSource", "LB/c;", "cameraErrorListener", "Lx/W;", "camera2DeviceCloser", "Lx/d0;", "camera2Quirks", "Landroidx/camera/camera2/pipe/core/Threads;", "threads", "Landroidx/camera/camera2/pipe/compat/j;", "audioRestrictionController", "interopCameraDeviceStateCallback", "Landroidx/camera/camera2/pipe/f$b;", "interopCaptureSessionListener", "<init>", "(Ljava/lang/String;Landroidx/camera/camera2/pipe/g;IJLz/w;LB/c;Lx/W;Lx/d0;Landroidx/camera/camera2/pipe/core/Threads;Landroidx/camera/camera2/pipe/compat/j;Landroid/hardware/camera2/CameraDevice$StateCallback;Landroidx/camera/camera2/pipe/f$b;Lkotlin/jvm/internal/i;)V", "LY8/t;", "f", "()V", "e", "(Le9/c;)Ljava/lang/Object;", "", "timeoutMillis", "", Const.INTENT_KEY_UMID, "(J)Z", "Landroid/hardware/camera2/CameraDevice;", "cameraDevice", "onOpened", "(Landroid/hardware/camera2/CameraDevice;)V", "onDisconnected", "errorCode", "onError", "(Landroid/hardware/camera2/CameraDevice;I)V", "onClosed", "m", "", "throwable", Const.INTENT_KEY_BACKGROUND_NOTIFICATION, "(Ljava/lang/Throwable;)V", "", "toString", "()Ljava/lang/String;", "Lw/l;", "cameraError", Const.INTENT_KEY_BACKGROUND_NOTIFICATION_ID, "(Ljava/lang/Throwable;I)V", "Landroidx/camera/camera2/pipe/compat/AndroidCameraState$a;", "closeRequest", Const.INTENT_KEY_BACKGROUND_COMMAND, "(Landroid/hardware/camera2/CameraDevice;Landroidx/camera/camera2/pipe/compat/AndroidCameraState$a;)V", "closingInfo", "Lx/l0;", Const.INTENT_KEY_BACKGROUND_NOTIFICATION_REMOVE, "(Landroidx/camera/camera2/pipe/compat/AndroidCameraState$a;)Lx/l0;", "o", "(Lx/d0;Ljava/lang/String;Lw/l;)Z", "n", Const.INTENT_KEY_APIKEY, "Ljava/lang/String;", "k", Const.INTENT_KEY_PKGNAME, "Landroidx/camera/camera2/pipe/g;", "getMetadata", "()Landroidx/camera/camera2/pipe/g;", "c", "I", "J", "Lz/w;", "LB/c;", "Lx/W;", "Lx/d0;", "Landroidx/camera/camera2/pipe/core/Threads;", "Landroidx/camera/camera2/pipe/compat/j;", "Landroid/hardware/camera2/CameraDevice$StateCallback;", "l", "Landroidx/camera/camera2/pipe/f$b;", "debugId", "", "Ljava/lang/Object;", "lock", "Z", "opening", "p", "Landroidx/camera/camera2/pipe/compat/AndroidCameraState$a;", "pendingClose", "q", "shouldDelayFinalizing", "Ljava/util/concurrent/CountDownLatch;", "r", "Ljava/util/concurrent/CountDownLatch;", "cameraDeviceClosed", "s", "requestTimestampNanos", "t", "Lz/x;", "openTimestampNanos", "LXa/k;", "Lx/k0;", "u", "LXa/k;", "_state", "LXa/t;", "()LXa/t;", VoiceWakeupReceiver.EXTRA_STATE, "camera-camera2-pipe"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes.dex */
public final class AndroidCameraState extends CameraDevice.StateCallback {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    public final String cameraId;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    public final androidx.camera.camera2.pipe.g metadata;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    public final int attemptNumber;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    public final long attemptTimestampNanos;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    public final z.w timeSource;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    public final B.c cameraErrorListener;

    /* renamed from: g, reason: collision with root package name and from kotlin metadata */
    public final W camera2DeviceCloser;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    public final C5810d0 camera2Quirks;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    public final Threads threads;

    /* renamed from: j, reason: collision with root package name and from kotlin metadata */
    public final j audioRestrictionController;

    /* renamed from: k, reason: collision with root package name and from kotlin metadata */
    public final CameraDevice.StateCallback interopCameraDeviceStateCallback;

    /* renamed from: l, reason: collision with root package name and from kotlin metadata */
    public final f.b interopCaptureSessionListener;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    public final int debugId;

    /* renamed from: n, reason: collision with root package name and from kotlin metadata */
    public final Object lock;

    /* renamed from: o, reason: collision with root package name and from kotlin metadata */
    public boolean opening;

    /* renamed from: p, reason: collision with root package name and from kotlin metadata */
    public ClosingInfo pendingClose;

    /* renamed from: q, reason: collision with root package name and from kotlin metadata */
    public boolean shouldDelayFinalizing;

    /* renamed from: r, reason: collision with root package name and from kotlin metadata */
    public final CountDownLatch cameraDeviceClosed;

    /* renamed from: s, reason: collision with root package name and from kotlin metadata */
    public final long requestTimestampNanos;

    /* renamed from: t, reason: collision with root package name and from kotlin metadata */
    public x openTimestampNanos;

    /* renamed from: u, reason: collision with root package name and from kotlin metadata */
    public final Xa.k<AbstractC5824k0> _state;

    @Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0003\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u000f\b\u0082\b\u0018\u00002\u00020\u0001B1\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0004\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\b¢\u0006\u0004\b\n\u0010\u000bJ\u0010\u0010\r\u001a\u00020\fHÖ\u0001¢\u0006\u0004\b\r\u0010\u000eJ\u0010\u0010\u0010\u001a\u00020\u000fHÖ\u0001¢\u0006\u0004\b\u0010\u0010\u0011J\u001a\u0010\u0014\u001a\u00020\u00132\b\u0010\u0012\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u0014\u0010\u0015R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0016\u0010\u0017\u001a\u0004\b\u0018\u0010\u0019R\u0017\u0010\u0005\u001a\u00020\u00048\u0006¢\u0006\f\n\u0004\b\u001a\u0010\u001b\u001a\u0004\b\u0016\u0010\u001cR\u0019\u0010\u0007\u001a\u0004\u0018\u00010\u00068\u0006¢\u0006\f\n\u0004\b\u001d\u0010\u001e\u001a\u0004\b\u001a\u0010\u001fR\u0019\u0010\t\u001a\u0004\u0018\u00010\b8\u0006¢\u0006\f\n\u0004\b\u0018\u0010 \u001a\u0004\b\u001d\u0010!¨\u0006\""}, d2 = {"Landroidx/camera/camera2/pipe/compat/AndroidCameraState$a;", "", "Landroidx/camera/camera2/pipe/compat/ClosedReason;", "reason", "Lz/x;", "closingTimestamp", "Lw/l;", "errorCode", "", "exception", "<init>", "(Landroidx/camera/camera2/pipe/compat/ClosedReason;JLw/l;Ljava/lang/Throwable;Lkotlin/jvm/internal/i;)V", "", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "other", "", "equals", "(Ljava/lang/Object;)Z", Const.INTENT_KEY_APIKEY, "Landroidx/camera/camera2/pipe/compat/ClosedReason;", Const.INTENT_KEY_UMID, "()Landroidx/camera/camera2/pipe/compat/ClosedReason;", Const.INTENT_KEY_PKGNAME, "J", "()J", "c", "Lw/l;", "()Lw/l;", "Ljava/lang/Throwable;", "()Ljava/lang/Throwable;", "camera-camera2-pipe"}, k = 1, mv = {2, 1, 0}, xi = 48)
    /* renamed from: androidx.camera.camera2.pipe.compat.AndroidCameraState$a, reason: from toString */
    public static final /* data */ class ClosingInfo {

        /* renamed from: a, reason: collision with root package name and from kotlin metadata and from toString */
        public final ClosedReason reason;

        /* renamed from: b, reason: collision with root package name and from kotlin metadata and from toString */
        public final long closingTimestamp;

        /* renamed from: c, reason: collision with root package name and from kotlin metadata and from toString */
        public final C5706l errorCode;

        /* renamed from: d, reason: collision with root package name and from kotlin metadata and from toString */
        public final Throwable exception;

        public /* synthetic */ ClosingInfo(ClosedReason closedReason, long j10, C5706l c5706l, Throwable th, kotlin.jvm.internal.i iVar) {
            this(closedReason, j10, c5706l, th);
        }

        /* renamed from: a, reason: from getter */
        public final long getClosingTimestamp() {
            return this.closingTimestamp;
        }

        /* renamed from: b, reason: from getter */
        public final C5706l getErrorCode() {
            return this.errorCode;
        }

        /* renamed from: c, reason: from getter */
        public final Throwable getException() {
            return this.exception;
        }

        /* renamed from: d, reason: from getter */
        public final ClosedReason getReason() {
            return this.reason;
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof ClosingInfo)) {
                return false;
            }
            ClosingInfo closingInfo = (ClosingInfo) other;
            return this.reason == closingInfo.reason && x.d(this.closingTimestamp, closingInfo.closingTimestamp) && kotlin.jvm.internal.p.d(this.errorCode, closingInfo.errorCode) && kotlin.jvm.internal.p.d(this.exception, closingInfo.exception);
        }

        public int hashCode() {
            int iHashCode = ((this.reason.hashCode() * 31) + x.e(this.closingTimestamp)) * 31;
            C5706l c5706l = this.errorCode;
            int iS = (iHashCode + (c5706l == null ? 0 : C5706l.s(c5706l.getValue()))) * 31;
            Throwable th = this.exception;
            return iS + (th != null ? th.hashCode() : 0);
        }

        public String toString() {
            return "ClosingInfo(reason=" + this.reason + ", closingTimestamp=" + ((Object) x.f(this.closingTimestamp)) + ", errorCode=" + this.errorCode + ", exception=" + this.exception + ')';
        }

        public ClosingInfo(ClosedReason reason, long j10, C5706l c5706l, Throwable th) {
            kotlin.jvm.internal.p.i(reason, "reason");
            this.reason = reason;
            this.closingTimestamp = j10;
            this.errorCode = c5706l;
            this.exception = th;
        }

        /* JADX WARN: Illegal instructions before constructor call */
        public /* synthetic */ ClosingInfo(ClosedReason closedReason, long j10, C5706l c5706l, Throwable th, int i10, kotlin.jvm.internal.i iVar) {
            if ((i10 & 2) != 0) {
                y yVar = y.f44525a;
                j10 = new z.t().a();
            }
            this(closedReason, j10, (i10 & 4) != 0 ? null : c5706l, (i10 & 8) != 0 ? null : th, null);
        }
    }

    public /* synthetic */ AndroidCameraState(String str, androidx.camera.camera2.pipe.g gVar, int i10, long j10, z.w wVar, B.c cVar, W w10, C5810d0 c5810d0, Threads threads, j jVar, CameraDevice.StateCallback stateCallback, f.b bVar, kotlin.jvm.internal.i iVar) {
        this(str, gVar, i10, j10, wVar, cVar, w10, c5810d0, threads, jVar, stateCallback, bVar);
    }

    public final boolean d(long timeoutMillis) {
        return this.cameraDeviceClosed.await(timeoutMillis, TimeUnit.MILLISECONDS);
    }

    public final Object e(InterfaceC4014c<? super Y8.t> interfaceC4014c) {
        Object objZ = Xa.d.z(l(), new AndroidCameraState$awaitClosed$2(null), interfaceC4014c);
        return objZ == C4063a.g() ? objZ : Y8.t.f7040a;
    }

    public final void f() {
        AbstractC5824k0 value = this._state.getValue();
        p cameraDevice = value instanceof CameraStateOpen ? ((CameraStateOpen) value).getCameraDevice() : null;
        g(cameraDevice != null ? (CameraDevice) cameraDevice.R0(kotlin.jvm.internal.t.b(CameraDevice.class)) : null, new ClosingInfo(ClosedReason.APP_CLOSED, 0L, null, null, 14, null));
    }

    /* JADX WARN: Removed duplicated region for block: B:15:0x0028  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void g(android.hardware.camera2.CameraDevice r11, androidx.camera.camera2.pipe.compat.AndroidCameraState.ClosingInfo r12) {
        /*
            r10 = this;
            Xa.k<x.k0> r0 = r10._state
            java.lang.Object r0 = r0.getValue()
            x.k0 r0 = (x.AbstractC5824k0) r0
            boolean r1 = r0 instanceof x.CameraStateOpen
            r2 = 0
            if (r1 == 0) goto L15
            x.n0 r0 = (x.CameraStateOpen) r0
            androidx.camera.camera2.pipe.compat.p r0 = r0.getCameraDevice()
            r4 = r0
            goto L16
        L15:
            r4 = r2
        L16:
            java.lang.Object r1 = r10.lock
            monitor-enter(r1)
            androidx.camera.camera2.pipe.compat.AndroidCameraState$a r0 = r10.pendingClose     // Catch: java.lang.Throwable -> L24
            if (r0 != 0) goto L28
            r10.pendingClose = r12     // Catch: java.lang.Throwable -> L24
            boolean r0 = r10.opening     // Catch: java.lang.Throwable -> L24
            if (r0 != 0) goto L28
            goto L29
        L24:
            r0 = move-exception
            r10 = r0
            goto L9d
        L28:
            r12 = r2
        L29:
            monitor-exit(r1)
            if (r12 == 0) goto L9c
            w.l r0 = r12.getErrorCode()
            if (r0 == 0) goto L4a
            androidx.camera.camera2.pipe.compat.ClosedReason r0 = r12.getReason()
            androidx.camera.camera2.pipe.compat.ClosedReason r1 = androidx.camera.camera2.pipe.compat.ClosedReason.CAMERA2_EXCEPTION
            if (r0 == r1) goto L4a
            B.c r0 = r10.cameraErrorListener
            java.lang.String r1 = r10.cameraId
            w.l r3 = r12.getErrorCode()
            int r3 = r3.getValue()
            r5 = 0
            r0.a(r1, r3, r5)
        L4a:
            Xa.k<x.k0> r0 = r10._state
            x.m0 r1 = new x.m0
            w.l r3 = r12.getErrorCode()
            r1.<init>(r3, r2)
            r0.setValue(r1)
            androidx.camera.camera2.pipe.compat.ClosedReason r0 = r12.getReason()
            androidx.camera.camera2.pipe.compat.ClosedReason r1 = androidx.camera.camera2.pipe.compat.ClosedReason.CAMERA2_CLOSED
            if (r0 == r1) goto L92
            x.d0 r0 = r10.camera2Quirks
            java.lang.String r1 = r10.cameraId
            w.l r2 = r12.getErrorCode()
            boolean r8 = r10.o(r0, r1, r2)
            if (r8 == 0) goto L7c
            java.lang.Object r1 = r10.lock
            monitor-enter(r1)
            r0 = 1
            r10.shouldDelayFinalizing = r0     // Catch: java.lang.Throwable -> L78
            Y8.t r0 = Y8.t.f7040a     // Catch: java.lang.Throwable -> L78
            monitor-exit(r1)
            goto L7c
        L78:
            r0 = move-exception
            r10 = r0
            monitor-exit(r1)
            throw r10
        L7c:
            x.W r3 = r10.camera2DeviceCloser
            androidx.camera.camera2.pipe.compat.j r7 = r10.audioRestrictionController
            x.d0 r0 = r10.camera2Quirks
            java.lang.String r1 = r10.cameraId
            w.l r2 = r12.getErrorCode()
            boolean r9 = r10.n(r0, r1, r2)
            r6 = r10
            r5 = r11
            r3.a(r4, r5, r6, r7, r8, r9)
            goto L93
        L92:
            r6 = r10
        L93:
            Xa.k<x.k0> r10 = r6._state
            x.l0 r11 = r6.j(r12)
            r10.setValue(r11)
        L9c:
            return
        L9d:
            monitor-exit(r1)
            throw r10
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.camera.camera2.pipe.compat.AndroidCameraState.g(android.hardware.camera2.CameraDevice, androidx.camera.camera2.pipe.compat.AndroidCameraState$a):void");
    }

    public final void h(Throwable throwable) {
        kotlin.jvm.internal.p.i(throwable, "throwable");
        C5706l.Companion companion = C5706l.INSTANCE;
        int iC = companion.c(throwable);
        if (C5706l.r(iC, companion.p())) {
            return;
        }
        i(throwable, iC);
    }

    public final void i(Throwable throwable, int cameraError) {
        g(null, new ClosingInfo(ClosedReason.CAMERA2_EXCEPTION, 0L, C5706l.o(cameraError), throwable, 2, null));
    }

    public final CameraStateClosed j(ClosingInfo closingInfo) {
        y yVar = y.f44525a;
        long jA = this.timeSource.a();
        x xVar = this.openTimestampNanos;
        long closingTimestamp = closingInfo.getClosingTimestamp();
        z.i iVarA = xVar != null ? z.i.a(z.i.c(xVar.getValue() - this.attemptTimestampNanos)) : null;
        z.i iVarA2 = xVar != null ? z.i.a(z.i.c(xVar.getValue() - this.requestTimestampNanos)) : null;
        z.i iVarA3 = xVar != null ? z.i.a(z.i.c(closingTimestamp - xVar.getValue())) : null;
        long jC = z.i.c(jA - closingTimestamp);
        return new CameraStateClosed(this.cameraId, closingInfo.getReason(), Integer.valueOf(this.attemptNumber - 1), iVarA, closingInfo.getException(), iVarA2, iVarA3, z.i.a(jC), closingInfo.getErrorCode(), null);
    }

    /* renamed from: k, reason: from getter */
    public final String getCameraId() {
        return this.cameraId;
    }

    public final Xa.t<AbstractC5824k0> l() {
        return this._state;
    }

    public final void m(CameraDevice cameraDevice) {
        kotlin.jvm.internal.p.i(cameraDevice, "cameraDevice");
        z.h hVar = z.h.f44503a;
        Trace.beginSection(((Object) C5708n.f(getCameraId())) + "#onFinalized");
        if (z.k.f44508a.a()) {
            Log.d("CXCP", this + ": onFinalized");
        }
        g(cameraDevice, new ClosingInfo(ClosedReason.CAMERA2_CLOSED, 0L, null, null, 14, null));
        CameraDevice.StateCallback stateCallback = this.interopCameraDeviceStateCallback;
        if (stateCallback != null) {
            stateCallback.onClosed(cameraDevice);
        }
        Trace.endSection();
    }

    public final boolean n(C5810d0 c5810d0, String str, C5706l c5706l) {
        return c5810d0.d(str) && c5706l == null;
    }

    public final boolean o(C5810d0 c5810d0, String str, C5706l c5706l) {
        return n(c5810d0, str, c5706l) && c5810d0.c(str);
    }

    @Override // android.hardware.camera2.CameraDevice.StateCallback
    public void onClosed(CameraDevice cameraDevice) {
        kotlin.jvm.internal.p.i(cameraDevice, "cameraDevice");
        if (!kotlin.jvm.internal.p.d(cameraDevice.getId(), this.cameraId)) {
            throw new IllegalStateException("Check failed.");
        }
        z.k kVar = z.k.f44508a;
        if (kVar.a()) {
            Log.d("CXCP", ((Object) C5708n.f(getCameraId())) + ": onClosed");
        }
        this.cameraDeviceClosed.countDown();
        synchronized (this.lock) {
            if (!this.shouldDelayFinalizing) {
                Y8.t tVar = Y8.t.f7040a;
                m(cameraDevice);
                return;
            }
            if (kVar.c()) {
                Log.i("CXCP", this + "#onClosed: Delaying finalizing.");
            }
        }
    }

    @Override // android.hardware.camera2.CameraDevice.StateCallback
    public void onDisconnected(CameraDevice cameraDevice) {
        kotlin.jvm.internal.p.i(cameraDevice, "cameraDevice");
        if (!kotlin.jvm.internal.p.d(cameraDevice.getId(), this.cameraId)) {
            throw new IllegalStateException("Check failed.");
        }
        z.h hVar = z.h.f44503a;
        Trace.beginSection(((Object) C5708n.f(getCameraId())) + "#onDisconnected");
        if (z.k.f44508a.a()) {
            Log.d("CXCP", ((Object) C5708n.f(getCameraId())) + ": onDisconnected");
        }
        this.cameraDeviceClosed.countDown();
        g(cameraDevice, new ClosingInfo(ClosedReason.CAMERA2_DISCONNECTED, 0L, C5706l.o(C5706l.INSTANCE.f()), null, 10, null));
        CameraDevice.StateCallback stateCallback = this.interopCameraDeviceStateCallback;
        if (stateCallback != null) {
            stateCallback.onDisconnected(cameraDevice);
        }
        Trace.endSection();
    }

    @Override // android.hardware.camera2.CameraDevice.StateCallback
    public void onError(CameraDevice cameraDevice, int errorCode) {
        kotlin.jvm.internal.p.i(cameraDevice, "cameraDevice");
        if (!kotlin.jvm.internal.p.d(cameraDevice.getId(), this.cameraId)) {
            throw new IllegalStateException("Check failed.");
        }
        z.h hVar = z.h.f44503a;
        Trace.beginSection(((Object) C5708n.f(getCameraId())) + "#onError-" + errorCode);
        if (z.k.f44508a.a()) {
            Log.d("CXCP", ((Object) C5708n.f(getCameraId())) + ": onError " + errorCode);
        }
        this.cameraDeviceClosed.countDown();
        g(cameraDevice, new ClosingInfo(ClosedReason.CAMERA2_ERROR, 0L, C5706l.o(C5706l.INSTANCE.a(errorCode)), null, 10, null));
        CameraDevice.StateCallback stateCallback = this.interopCameraDeviceStateCallback;
        if (stateCallback != null) {
            stateCallback.onError(cameraDevice, errorCode);
        }
        Trace.endSection();
    }

    @Override // android.hardware.camera2.CameraDevice.StateCallback
    public void onOpened(CameraDevice cameraDevice) {
        ClosingInfo closingInfo;
        ClosingInfo closingInfo2;
        String string;
        kotlin.jvm.internal.p.i(cameraDevice, "cameraDevice");
        if (!kotlin.jvm.internal.p.d(cameraDevice.getId(), this.cameraId)) {
            throw new IllegalStateException("Check failed.");
        }
        y yVar = y.f44525a;
        long jA = this.timeSource.a();
        this.openTimestampNanos = x.a(jA);
        z.h hVar = z.h.f44503a;
        Trace.beginSection(((Object) C5708n.f(getCameraId())) + "#onOpened");
        if (z.k.f44508a.c()) {
            long jC = z.i.c(jA - this.requestTimestampNanos);
            long jC2 = z.i.c(jA - this.attemptTimestampNanos);
            if (this.attemptNumber == 1) {
                StringBuilder sb2 = new StringBuilder();
                sb2.append("Opened ");
                sb2.append((Object) C5708n.f(getCameraId()));
                sb2.append(" in ");
                String str = String.format(null, "%.3f ms", Arrays.copyOf(new Object[]{Double.valueOf(jC / 1000000.0d)}, 1));
                kotlin.jvm.internal.p.h(str, "format(...)");
                sb2.append(str);
                string = sb2.toString();
            } else {
                StringBuilder sb3 = new StringBuilder();
                sb3.append("Opened ");
                sb3.append((Object) C5708n.f(getCameraId()));
                sb3.append(" in ");
                String str2 = String.format(null, "%.3f ms", Arrays.copyOf(new Object[]{Double.valueOf(jC / 1000000.0d)}, 1));
                kotlin.jvm.internal.p.h(str2, "format(...)");
                sb3.append(str2);
                sb3.append(" (");
                String str3 = String.format(null, "%.3f ms", Arrays.copyOf(new Object[]{Double.valueOf(jC2 / 1000000.0d)}, 1));
                kotlin.jvm.internal.p.h(str3, "format(...)");
                sb3.append(str3);
                sb3.append(" total) after ");
                sb3.append(this.attemptNumber);
                sb3.append(" attempts.");
                string = sb3.toString();
            }
            Log.i("CXCP", string);
        }
        synchronized (this.lock) {
            closingInfo = this.pendingClose;
            if (closingInfo == null) {
                this.opening = true;
            }
        }
        CameraDevice.StateCallback stateCallback = this.interopCameraDeviceStateCallback;
        if (stateCallback != null) {
            stateCallback.onOpened(cameraDevice);
        }
        if (closingInfo != null) {
            W.b(this.camera2DeviceCloser, null, cameraDevice, this, this.audioRestrictionController, o(this.camera2Quirks, this.cameraId, closingInfo.getErrorCode()), n(this.camera2Quirks, this.cameraId, closingInfo.getErrorCode()), 1, null);
            return;
        }
        AndroidCameraDevice aVar = new AndroidCameraDevice(this.metadata, cameraDevice, this.cameraId, this.cameraErrorListener, this.interopCaptureSessionListener, this.threads, null);
        this.audioRestrictionController.a(aVar);
        this._state.setValue(new CameraStateOpen(aVar));
        synchronized (this.lock) {
            this.opening = false;
            closingInfo2 = this.pendingClose;
        }
        if (closingInfo2 != null) {
            this._state.setValue(new CameraStateClosing(closingInfo2.getErrorCode(), null));
            this.camera2DeviceCloser.a(aVar, cameraDevice, this, this.audioRestrictionController, o(this.camera2Quirks, this.cameraId, closingInfo2.getErrorCode()), n(this.camera2Quirks, this.cameraId, closingInfo2.getErrorCode()));
            this._state.setValue(j(closingInfo2));
        }
        Trace.endSection();
    }

    public String toString() {
        return "CameraState-" + this.debugId;
    }

    public AndroidCameraState(String cameraId, androidx.camera.camera2.pipe.g metadata, int i10, long j10, z.w timeSource, B.c cameraErrorListener, W camera2DeviceCloser, C5810d0 camera2Quirks, Threads threads, j audioRestrictionController, CameraDevice.StateCallback stateCallback, f.b bVar) {
        kotlin.jvm.internal.p.i(cameraId, "cameraId");
        kotlin.jvm.internal.p.i(metadata, "metadata");
        kotlin.jvm.internal.p.i(timeSource, "timeSource");
        kotlin.jvm.internal.p.i(cameraErrorListener, "cameraErrorListener");
        kotlin.jvm.internal.p.i(camera2DeviceCloser, "camera2DeviceCloser");
        kotlin.jvm.internal.p.i(camera2Quirks, "camera2Quirks");
        kotlin.jvm.internal.p.i(threads, "threads");
        kotlin.jvm.internal.p.i(audioRestrictionController, "audioRestrictionController");
        this.cameraId = cameraId;
        this.metadata = metadata;
        this.attemptNumber = i10;
        this.attemptTimestampNanos = j10;
        this.timeSource = timeSource;
        this.cameraErrorListener = cameraErrorListener;
        this.camera2DeviceCloser = camera2DeviceCloser;
        this.camera2Quirks = camera2Quirks;
        this.threads = threads;
        this.audioRestrictionController = audioRestrictionController;
        this.interopCameraDeviceStateCallback = stateCallback;
        this.interopCaptureSessionListener = bVar;
        this.debugId = L0.a().d();
        this.lock = new Object();
        this.cameraDeviceClosed = new CountDownLatch(1);
        this._state = Xa.u.a(o0.f43432a);
        if (z.k.f44508a.c()) {
            Log.i("CXCP", "Opening " + ((Object) C5708n.f(getCameraId())));
        }
        if (i10 != 1) {
            y yVar = y.f44525a;
            j10 = timeSource.a();
        }
        this.requestTimestampNanos = j10;
    }
}
