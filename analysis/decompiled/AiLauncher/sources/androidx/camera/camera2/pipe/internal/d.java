package androidx.camera.camera2.pipe.internal;

import C.g;
import Y8.t;
import Z8.F;
import androidx.camera.camera2.pipe.internal.f;
import androidx.exifinterface.media.ExifInterface;
import com.autonavi.aps.amapapi.config.Const;
import com.stepos.ailauncher.foundation.appui.card.provider.alipay.AlipayXuiIsland;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.i;
import kotlin.jvm.internal.p;
import w.H;
import w.r;
import w.y;

@Metadata(d1 = {"\u0000x\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\t\n\u0002\u0010\u0000\n\u0002\b\u000e\n\u0002\u0010!\n\u0002\b\u0003\n\u0002\u0010%\n\u0002\b\u0003\b\u0000\u0018\u0000*\u0004\b\u0000\u0010\u00012\u00060\u0002j\u0002`\u0003:\u0002+\u001dB'\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0004\u0012\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00028\u00000\u0006\u0012\u0006\u0010\t\u001a\u00020\b¢\u0006\u0004\b\n\u0010\u000bJ3\u0010\u0015\u001a\u00020\u00142\u0006\u0010\r\u001a\u00020\f2\u0006\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0011\u001a\u00020\u00102\f\u0010\u0013\u001a\b\u0012\u0004\u0012\u00028\u00000\u0012¢\u0006\u0004\b\u0015\u0010\u0016J#\u0010\u001a\u001a\u00020\u00142\u0006\u0010\u0017\u001a\u00020\u00102\f\u0010\u0019\u001a\b\u0012\u0004\u0012\u00028\u00000\u0018¢\u0006\u0004\b\u001a\u0010\u001bJ\u0015\u0010\u001d\u001a\u00020\u00142\u0006\u0010\u001c\u001a\u00020\f¢\u0006\u0004\b\u001d\u0010\u001eJ\u000f\u0010\u001f\u001a\u00020\u0014H\u0016¢\u0006\u0004\b\u001f\u0010 J)\u0010$\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000!0#2\f\u0010\"\u001a\b\u0012\u0004\u0012\u00028\u00000!H\u0003¢\u0006\u0004\b$\u0010%J3\u0010)\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000!0#2\u0006\u0010'\u001a\u00020&2\u0006\u0010(\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u0010H\u0002¢\u0006\u0004\b)\u0010*R\u0014\u0010\u0005\u001a\u00020\u00048\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b+\u0010,R\u001a\u0010\u0007\u001a\b\u0012\u0004\u0012\u00028\u00000\u00068\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001d\u0010-R\u0014\u0010\t\u001a\u00020\b8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b.\u0010/R\u0014\u00103\u001a\u0002008\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b1\u00102R\u0016\u00105\u001a\u00020&8\u0002@\u0002X\u0083\u000e¢\u0006\u0006\n\u0004\b\u001a\u00104R\u0016\u00108\u001a\u00020\u00108\u0002@\u0002X\u0083\u000e¢\u0006\u0006\n\u0004\b6\u00107R\u0016\u00109\u001a\u00020\u00108\u0002@\u0002X\u0083\u000e¢\u0006\u0006\n\u0004\b\u0015\u00107R\u0016\u0010;\u001a\u00020\f8\u0002@\u0002X\u0083\u000e¢\u0006\u0006\n\u0004\b:\u00107R\u0016\u0010<\u001a\u00020\u00108\u0002@\u0002X\u0083\u000e¢\u0006\u0006\n\u0004\b$\u00107R\u0016\u0010>\u001a\u00020\u00108\u0002@\u0002X\u0083\u000e¢\u0006\u0006\n\u0004\b=\u00107R \u0010B\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000!0?8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b@\u0010AR&\u0010E\u001a\u0014\u0012\u0004\u0012\u00020\u0010\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u00180C8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b)\u0010D¨\u0006F"}, d2 = {"Landroidx/camera/camera2/pipe/internal/d;", ExifInterface.GPS_DIRECTION_TRUE, "Ljava/lang/AutoCloseable;", "Lkotlin/AutoCloseable;", "", "maximumCachedOutputs", "LC/g;", "outputFinalizer", "Landroidx/camera/camera2/pipe/internal/e;", "outputMatcher", "<init>", "(ILC/g;Landroidx/camera/camera2/pipe/internal/e;)V", "Lw/y;", "cameraFrameNumber", "Lw/r;", "cameraTimestamp", "", "cameraOutputNumber", "Landroidx/camera/camera2/pipe/internal/d$a;", "outputListener", "LY8/t;", Const.INTENT_KEY_BACKGROUND_COMMAND, "(JJJLandroidx/camera/camera2/pipe/internal/d$a;)V", "outputNumber", "Landroidx/camera/camera2/pipe/internal/f;", "outputResult", "e", "(JLjava/lang/Object;)V", "frameNumber", Const.INTENT_KEY_PKGNAME, "(J)V", "close", "()V", "Landroidx/camera/camera2/pipe/internal/d$b;", "output", "", Const.INTENT_KEY_BACKGROUND_NOTIFICATION_ID, "(Landroidx/camera/camera2/pipe/internal/d$b;)Ljava/util/List;", "", "isOutOfOrder", "cameraOutputSequence", "l", "(ZJJ)Ljava/util/List;", Const.INTENT_KEY_APIKEY, "I", "LC/g;", "c", "Landroidx/camera/camera2/pipe/internal/e;", "", Const.INTENT_KEY_UMID, "Ljava/lang/Object;", "lock", "Z", AlipayXuiIsland.REASON_CLOSED, "f", "J", "cameraOutputSequenceNumbers", "newestCameraOutputNumber", Const.INTENT_KEY_BACKGROUND_NOTIFICATION, "newestFrameNumber", "lastFailedFrameNumber", Const.INTENT_KEY_BACKGROUND_NOTIFICATION_REMOVE, "lastFailedCameraOutputNumber", "", "k", "Ljava/util/List;", "startedOutputs", "", "Ljava/util/Map;", "availableOutputs", "camera-camera2-pipe"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes.dex */
public final class d<T> implements AutoCloseable {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    public final int maximumCachedOutputs;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    public final g<T> outputFinalizer;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    public final e outputMatcher;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    public final Object lock;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    public boolean closed;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    public long cameraOutputSequenceNumbers;

    /* renamed from: g, reason: collision with root package name and from kotlin metadata */
    public long newestCameraOutputNumber;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    public long newestFrameNumber;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    public long lastFailedFrameNumber;

    /* renamed from: j, reason: collision with root package name and from kotlin metadata */
    public long lastFailedCameraOutputNumber;

    /* renamed from: k, reason: collision with root package name and from kotlin metadata */
    public final List<StartedOutput<T>> startedOutputs;

    /* renamed from: l, reason: collision with root package name and from kotlin metadata */
    public final Map<Long, f<T>> availableOutputs;

    @Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b`\u0018\u0000*\u0004\b\u0001\u0010\u00012\u00020\u0002J=\u0010\r\u001a\u00020\f2\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\t\u001a\u00020\u00072\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00028\u00010\nH&¢\u0006\u0004\b\r\u0010\u000eø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001¨\u0006\u000fÀ\u0006\u0001"}, d2 = {"Landroidx/camera/camera2/pipe/internal/d$a;", ExifInterface.GPS_DIRECTION_TRUE, "", "Lw/y;", "cameraFrameNumber", "Lw/r;", "cameraTimestamp", "", "cameraOutputSequence", "outputNumber", "Landroidx/camera/camera2/pipe/internal/f;", "outputResult", "LY8/t;", Const.INTENT_KEY_APIKEY, "(JJJJLjava/lang/Object;)V", "camera-camera2-pipe"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public interface a<T> {
        void a(long cameraFrameNumber, long cameraTimestamp, long cameraOutputSequence, long outputNumber, Object outputResult);
    }

    @Metadata(d1 = {"\u0000Z\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0082\b\u0018\u0000*\u0004\b\u0001\u0010\u00012\u00020\u0002B=\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\u0006\u0010\b\u001a\u00020\u0007\u0012\u0006\u0010\n\u001a\u00020\t\u0012\u0006\u0010\u000b\u001a\u00020\t\u0012\f\u0010\r\u001a\b\u0012\u0004\u0012\u00028\u00010\f¢\u0006\u0004\b\u000e\u0010\u000fJ\u0015\u0010\u0013\u001a\u00020\u00122\u0006\u0010\u0011\u001a\u00020\u0010¢\u0006\u0004\b\u0013\u0010\u0014J#\u0010\u0018\u001a\u00020\u00122\u0006\u0010\u0015\u001a\u00020\t2\f\u0010\u0017\u001a\b\u0012\u0004\u0012\u00028\u00010\u0016¢\u0006\u0004\b\u0018\u0010\u0019J\u0010\u0010\u001b\u001a\u00020\u001aHÖ\u0001¢\u0006\u0004\b\u001b\u0010\u001cJ\u0010\u0010\u001e\u001a\u00020\u001dHÖ\u0001¢\u0006\u0004\b\u001e\u0010\u001fJ\u001a\u0010!\u001a\u00020\u00032\b\u0010 \u001a\u0004\u0018\u00010\u0002HÖ\u0003¢\u0006\u0004\b!\u0010\"R\u0017\u0010\u0004\u001a\u00020\u00038\u0006¢\u0006\f\n\u0004\b\u0018\u0010#\u001a\u0004\b$\u0010%R\u0017\u0010\u0006\u001a\u00020\u00058\u0006¢\u0006\f\n\u0004\b\u0013\u0010&\u001a\u0004\b'\u0010(R\u0017\u0010\b\u001a\u00020\u00078\u0006¢\u0006\f\n\u0004\b'\u0010&\u001a\u0004\b)\u0010(R\u0017\u0010\n\u001a\u00020\t8\u0006¢\u0006\f\n\u0004\b*\u0010&\u001a\u0004\b+\u0010(R\u0017\u0010\u000b\u001a\u00020\t8\u0006¢\u0006\f\n\u0004\b+\u0010&\u001a\u0004\b*\u0010(R\u001a\u0010\r\u001a\b\u0012\u0004\u0012\u00028\u00010\f8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b$\u0010,R\u0014\u00100\u001a\u00020-8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b.\u0010/¨\u00061"}, d2 = {"Landroidx/camera/camera2/pipe/internal/d$b;", ExifInterface.GPS_DIRECTION_TRUE, "", "", "isOutOfOrder", "Lw/y;", "cameraFrameNumber", "Lw/r;", "cameraTimestamp", "", "cameraOutputSequence", "cameraOutputNumber", "Landroidx/camera/camera2/pipe/internal/d$a;", "outputListener", "<init>", "(ZJJJJLandroidx/camera/camera2/pipe/internal/d$a;Lkotlin/jvm/internal/i;)V", "Lw/H;", "failureReason", "LY8/t;", Const.INTENT_KEY_PKGNAME, "(I)V", "outputNumber", "Landroidx/camera/camera2/pipe/internal/f;", "outputResult", Const.INTENT_KEY_APIKEY, "(JLjava/lang/Object;)V", "", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "other", "equals", "(Ljava/lang/Object;)Z", "Z", "f", "()Z", "J", "c", "()J", "getCameraTimestamp-LS1Wq50", Const.INTENT_KEY_UMID, "e", "Landroidx/camera/camera2/pipe/internal/d$a;", "LOa/a;", Const.INTENT_KEY_BACKGROUND_COMMAND, "LOa/a;", "complete", "camera-camera2-pipe"}, k = 1, mv = {2, 1, 0}, xi = 48)
    /* renamed from: androidx.camera.camera2.pipe.internal.d$b, reason: from toString */
    public static final /* data */ class StartedOutput<T> {

        /* renamed from: a, reason: collision with root package name and from kotlin metadata and from toString */
        public final boolean isOutOfOrder;

        /* renamed from: b, reason: collision with root package name and from kotlin metadata and from toString */
        public final long cameraFrameNumber;

        /* renamed from: c, reason: collision with root package name and from kotlin metadata and from toString */
        public final long cameraTimestamp;

        /* renamed from: d, reason: collision with root package name and from kotlin metadata and from toString */
        public final long cameraOutputSequence;

        /* renamed from: e, reason: collision with root package name and from kotlin metadata and from toString */
        public final long cameraOutputNumber;

        /* renamed from: f, reason: collision with root package name and from kotlin metadata and from toString */
        public final a<T> outputListener;

        /* renamed from: g, reason: collision with root package name and from kotlin metadata */
        public final Oa.a complete;

        public /* synthetic */ StartedOutput(boolean z10, long j10, long j11, long j12, long j13, a aVar, i iVar) {
            this(z10, j10, j11, j12, j13, aVar);
        }

        public final void a(long outputNumber, Object outputResult) {
            if (this.complete.a(false, true)) {
                this.outputListener.a(this.cameraFrameNumber, this.cameraTimestamp, this.cameraOutputSequence, outputNumber, outputResult);
                return;
            }
            throw new IllegalStateException(("Output " + this.cameraOutputSequence + " at " + ((Object) y.f(this.cameraFrameNumber)) + " for " + outputNumber + " was completed multiple times!").toString());
        }

        public final void b(int failureReason) {
            f.Companion companion = f.INSTANCE;
            a(-1L, f.c(H.f(failureReason)));
        }

        /* renamed from: c, reason: from getter */
        public final long getCameraFrameNumber() {
            return this.cameraFrameNumber;
        }

        /* renamed from: d, reason: from getter */
        public final long getCameraOutputNumber() {
            return this.cameraOutputNumber;
        }

        /* renamed from: e, reason: from getter */
        public final long getCameraOutputSequence() {
            return this.cameraOutputSequence;
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof StartedOutput)) {
                return false;
            }
            StartedOutput startedOutput = (StartedOutput) other;
            return this.isOutOfOrder == startedOutput.isOutOfOrder && y.d(this.cameraFrameNumber, startedOutput.cameraFrameNumber) && r.b(this.cameraTimestamp, startedOutput.cameraTimestamp) && this.cameraOutputSequence == startedOutput.cameraOutputSequence && this.cameraOutputNumber == startedOutput.cameraOutputNumber && p.d(this.outputListener, startedOutput.outputListener);
        }

        /* renamed from: f, reason: from getter */
        public final boolean getIsOutOfOrder() {
            return this.isOutOfOrder;
        }

        public int hashCode() {
            return (((((((((Boolean.hashCode(this.isOutOfOrder) * 31) + y.e(this.cameraFrameNumber)) * 31) + r.c(this.cameraTimestamp)) * 31) + Long.hashCode(this.cameraOutputSequence)) * 31) + Long.hashCode(this.cameraOutputNumber)) * 31) + this.outputListener.hashCode();
        }

        public String toString() {
            return "StartedOutput(isOutOfOrder=" + this.isOutOfOrder + ", cameraFrameNumber=" + ((Object) y.f(this.cameraFrameNumber)) + ", cameraTimestamp=" + ((Object) r.d(this.cameraTimestamp)) + ", cameraOutputSequence=" + this.cameraOutputSequence + ", cameraOutputNumber=" + this.cameraOutputNumber + ", outputListener=" + this.outputListener + ')';
        }

        public StartedOutput(boolean z10, long j10, long j11, long j12, long j13, a<T> outputListener) {
            p.i(outputListener, "outputListener");
            this.isOutOfOrder = z10;
            this.cameraFrameNumber = j10;
            this.cameraTimestamp = j11;
            this.cameraOutputSequence = j12;
            this.cameraOutputNumber = j13;
            this.outputListener = outputListener;
            this.complete = Oa.b.a(false);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public d(int i10, g<? super T> outputFinalizer, e outputMatcher) {
        p.i(outputFinalizer, "outputFinalizer");
        p.i(outputMatcher, "outputMatcher");
        this.maximumCachedOutputs = i10;
        this.outputFinalizer = outputFinalizer;
        this.outputMatcher = outputMatcher;
        this.lock = new Object();
        this.cameraOutputSequenceNumbers = 1L;
        this.newestCameraOutputNumber = Long.MIN_VALUE;
        this.newestFrameNumber = y.b(Long.MIN_VALUE);
        this.lastFailedFrameNumber = Long.MIN_VALUE;
        this.lastFailedCameraOutputNumber = Long.MIN_VALUE;
        this.startedOutputs = new ArrayList();
        this.availableOutputs = new LinkedHashMap();
    }

    public final void b(long frameNumber) {
        synchronized (this.lock) {
            try {
                if (this.closed) {
                    return;
                }
                this.lastFailedFrameNumber = frameNumber;
                Iterator<T> it = this.startedOutputs.iterator();
                StartedOutput startedOutput = null;
                boolean z10 = false;
                StartedOutput startedOutput2 = null;
                while (true) {
                    if (it.hasNext()) {
                        T next = it.next();
                        if (y.d(((StartedOutput) next).getCameraFrameNumber(), frameNumber)) {
                            if (z10) {
                                break;
                            }
                            z10 = true;
                            startedOutput2 = next;
                        }
                    } else if (!z10) {
                    }
                }
                startedOutput2 = null;
                StartedOutput startedOutput3 = startedOutput2;
                if (startedOutput3 != null) {
                    this.lastFailedCameraOutputNumber = startedOutput3.getCameraOutputNumber();
                    this.startedOutputs.remove(startedOutput3);
                    t tVar = t.f7040a;
                    startedOutput = startedOutput3;
                }
                if (startedOutput != null) {
                    startedOutput.b(H.INSTANCE.c());
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // java.lang.AutoCloseable
    public void close() {
        synchronized (this.lock) {
            if (this.closed) {
                return;
            }
            this.closed = true;
            List listP1 = F.p1(this.availableOutputs.values());
            this.availableOutputs.clear();
            List listP12 = F.p1(this.startedOutputs);
            this.startedOutputs.clear();
            t tVar = t.f7040a;
            Iterator it = listP1.iterator();
            while (it.hasNext()) {
                Object result = ((f) it.next()).getResult();
                g<T> gVar = this.outputFinalizer;
                if (!f.e(result)) {
                    result = null;
                }
                gVar.a(result);
            }
            Iterator it2 = listP12.iterator();
            while (it2.hasNext()) {
                ((StartedOutput) it2.next()).b(H.INSTANCE.b());
            }
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void e(long outputNumber, Object outputResult) {
        f<T> fVarB;
        List<StartedOutput<T>> listI;
        T next;
        synchronized (this.lock) {
            try {
                if (this.closed || this.outputMatcher.b(this.lastFailedCameraOutputNumber, outputNumber)) {
                    fVarB = f.b(outputResult);
                } else {
                    Iterator<T> it = this.startedOutputs.iterator();
                    while (true) {
                        if (!it.hasNext()) {
                            next = (T) null;
                            break;
                        } else {
                            next = it.next();
                            if (this.outputMatcher.b(((StartedOutput) next).getCameraOutputNumber(), outputNumber)) {
                                break;
                            }
                        }
                    }
                    StartedOutput<T> startedOutput = next;
                    if (startedOutput != null) {
                        listI = i(startedOutput);
                        startedOutput.a(outputNumber, outputResult);
                        this.startedOutputs.remove(startedOutput);
                        fVarB = null;
                    } else {
                        this.availableOutputs.put(Long.valueOf(outputNumber), f.b(outputResult));
                        if (this.availableOutputs.size() > this.maximumCachedOutputs) {
                            fVarB = this.availableOutputs.remove(Long.valueOf(((Number) F.p0(this.availableOutputs.keySet())).longValue()));
                        } else {
                            fVarB = null;
                            listI = null;
                        }
                    }
                    t tVar = t.f7040a;
                }
                listI = null;
                t tVar2 = t.f7040a;
            } catch (Throwable th) {
                throw th;
            }
        }
        f<T> fVar = fVarB;
        if (fVar != null) {
            Object result = fVar.getResult();
            Object obj = f.e(result) ? result : null;
            if (obj != null) {
                this.outputFinalizer.a(obj);
            }
        }
        if (listI != null) {
            Iterator<T> it2 = listI.iterator();
            while (it2.hasNext()) {
                ((StartedOutput) it2.next()).b(H.INSTANCE.d());
            }
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:110:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:72:0x0163  */
    /* JADX WARN: Removed duplicated region for block: B:78:0x0185  */
    /* JADX WARN: Removed duplicated region for block: B:85:0x019a  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void g(long r20, long r22, long r24, androidx.camera.camera2.pipe.internal.d.a<T> r26) {
        /*
            Method dump skipped, instructions count: 480
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.camera.camera2.pipe.internal.d.g(long, long, long, androidx.camera.camera2.pipe.internal.d$a):void");
    }

    public final List<StartedOutput<T>> i(StartedOutput<T> output) {
        return l(output.getIsOutOfOrder(), output.getCameraOutputSequence(), output.getCameraOutputNumber());
    }

    public final List<StartedOutput<T>> l(boolean isOutOfOrder, long cameraOutputSequence, long cameraOutputNumber) {
        List<StartedOutput<T>> list = this.startedOutputs;
        ArrayList arrayList = new ArrayList();
        for (T t10 : list) {
            StartedOutput startedOutput = (StartedOutput) t10;
            if (startedOutput.getIsOutOfOrder() == isOutOfOrder && startedOutput.getCameraOutputSequence() < cameraOutputSequence && startedOutput.getCameraOutputNumber() < cameraOutputNumber) {
                arrayList.add(t10);
            }
        }
        this.startedOutputs.removeAll(arrayList);
        return arrayList;
    }

    public /* synthetic */ d(int i10, g gVar, e eVar, int i11, i iVar) {
        this((i11 & 1) != 0 ? 3 : i10, gVar, eVar);
    }
}
