package androidx.camera.camera2.pipe.internal;

import B.j;
import C.q;
import C.r;
import Ua.C1087w;
import Ua.InterfaceC1083u;
import Z8.C1172u;
import Z8.C1174w;
import Z8.F;
import androidx.camera.camera2.pipe.internal.d;
import androidx.camera.camera2.pipe.internal.f;
import androidx.camera.camera2.pipe.k;
import androidx.camera.camera2.pipe.s;
import androidx.exifinterface.media.ExifInterface;
import com.autonavi.aps.amapapi.config.Const;
import com.stepos.ailauncher.chat.voicewakeup.VoiceWakeupReceiver;
import h9.InterfaceC4149a;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArrayList;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.i;
import kotlin.jvm.internal.p;
import s.C5423E;
import w.H;
import w.InterfaceC5714u;
import w.K;
import w.Q;
import w.v;
import w.w;

@Metadata(d1 = {"\u0000\u0080\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\"\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0000\u0018\u0000 >2\u00020\u0001:\u0005?\u0010 &\u001cB-\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\u0006\u0010\u0007\u001a\u00020\u0006\u0012\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\t0\b¢\u0006\u0004\b\u000b\u0010\fJ\u0015\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u000e\u001a\u00020\r¢\u0006\u0004\b\u0010\u0010\u0011J\r\u0010\u0012\u001a\u00020\u000f¢\u0006\u0004\b\u0012\u0010\u0013J\u0015\u0010\u0016\u001a\u00020\u000f2\u0006\u0010\u0015\u001a\u00020\u0014¢\u0006\u0004\b\u0016\u0010\u0017J\u000f\u0010\u0019\u001a\u00020\u0018H\u0016¢\u0006\u0004\b\u0019\u0010\u001aJ\u000f\u0010\u001b\u001a\u00020\u000fH\u0002¢\u0006\u0004\b\u001b\u0010\u0013R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u001c\u0010\u001d\u001a\u0004\b\u001e\u0010\u001fR\u0017\u0010\u0005\u001a\u00020\u00048\u0006¢\u0006\f\n\u0004\b \u0010!\u001a\u0004\b\"\u0010#R\u0017\u0010\u0007\u001a\u00020\u00068\u0006¢\u0006\f\n\u0004\b\u0010\u0010!\u001a\u0004\b$\u0010#R\u0017\u0010(\u001a\u00020%8\u0006¢\u0006\f\n\u0004\b&\u0010!\u001a\u0004\b'\u0010#R\u001b\u0010,\u001a\u00060)R\u00020\u00008\u0006¢\u0006\f\n\u0004\b\"\u0010*\u001a\u0004\b&\u0010+R!\u00102\u001a\f\u0012\b\u0012\u00060.R\u00020\u00000-8\u0006¢\u0006\f\n\u0004\b/\u00100\u001a\u0004\b/\u00101R\u001a\u00106\u001a\b\u0012\u0004\u0012\u000204038\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001b\u00105R\u0014\u00109\u001a\u0002078\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0012\u00108R\u001a\u0010=\u001a\b\u0012\u0004\u0012\u00020;0:8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0016\u0010<¨\u0006@"}, d2 = {"Landroidx/camera/camera2/pipe/internal/FrameState;", "", "Lw/K;", "requestMetadata", "Lw/y;", "frameNumber", "Lw/r;", "frameTimestamp", "", "Landroidx/camera/camera2/pipe/k;", "imageStreams", "<init>", "(Lw/K;JJLjava/util/Set;Lkotlin/jvm/internal/i;)V", "Lw/u$a;", "listener", "LY8/t;", "c", "(Lw/u$a;)V", Const.INTENT_KEY_BACKGROUND_NOTIFICATION, "()V", "Lw/Q;", "streamId", Const.INTENT_KEY_BACKGROUND_NOTIFICATION_ID, "(I)V", "", "toString", "()Ljava/lang/String;", Const.INTENT_KEY_BACKGROUND_COMMAND, Const.INTENT_KEY_APIKEY, "Lw/K;", "getRequestMetadata", "()Lw/K;", Const.INTENT_KEY_PKGNAME, "J", "e", "()J", "getFrameTimestamp-LS1Wq50", "Lw/v;", Const.INTENT_KEY_UMID, "getFrameId-OMxQvVY", "frameId", "Landroidx/camera/camera2/pipe/internal/FrameState$b;", "Landroidx/camera/camera2/pipe/internal/FrameState$b;", "()Landroidx/camera/camera2/pipe/internal/FrameState$b;", "frameInfoOutput", "", "Landroidx/camera/camera2/pipe/internal/FrameState$d;", "f", "Ljava/util/List;", "()Ljava/util/List;", "imageOutputs", "LOa/e;", "Landroidx/camera/camera2/pipe/internal/FrameState$State;", "LOa/e;", VoiceWakeupReceiver.EXTRA_STATE, "LOa/c;", "LOa/c;", "remainingStreamCount", "Ljava/util/concurrent/CopyOnWriteArrayList;", "LB/j;", "Ljava/util/concurrent/CopyOnWriteArrayList;", "listenerStates", Const.INTENT_KEY_BACKGROUND_NOTIFICATION_REMOVE, "State", "camera-camera2-pipe"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes.dex */
public final class FrameState {

    /* renamed from: j, reason: collision with root package name and from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);

    /* renamed from: k, reason: collision with root package name */
    public static final Oa.d f10969k = Oa.b.e(0);

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    public final K requestMetadata;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    public final long frameNumber;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    public final long frameTimestamp;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    public final long frameId;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    public final b frameInfoOutput;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    public final List<d> imageOutputs;

    /* renamed from: g, reason: collision with root package name and from kotlin metadata */
    public final Oa.e<State> state;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    public final Oa.c remainingStreamCount;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    public final CopyOnWriteArrayList<j> listenerStates;

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* JADX WARN: Unknown enum class pattern. Please report as an issue! */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0007\b\u0082\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007¨\u0006\b"}, d2 = {"Landroidx/camera/camera2/pipe/internal/FrameState$State;", "", "<init>", "(Ljava/lang/String;I)V", "STARTED", "FRAME_INFO_COMPLETE", "STREAM_RESULTS_COMPLETE", "COMPLETE", "camera-camera2-pipe"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class State {
        private static final /* synthetic */ InterfaceC4149a $ENTRIES;
        private static final /* synthetic */ State[] $VALUES;
        public static final State STARTED = new State("STARTED", 0);
        public static final State FRAME_INFO_COMPLETE = new State("FRAME_INFO_COMPLETE", 1);
        public static final State STREAM_RESULTS_COMPLETE = new State("STREAM_RESULTS_COMPLETE", 2);
        public static final State COMPLETE = new State("COMPLETE", 3);

        private static final /* synthetic */ State[] $values() {
            return new State[]{STARTED, FRAME_INFO_COMPLETE, STREAM_RESULTS_COMPLETE, COMPLETE};
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

    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u000f\u0010\u0005\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u0005\u0010\u0006R\u0014\u0010\b\u001a\u00020\u00078\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\b\u0010\t¨\u0006\n"}, d2 = {"Landroidx/camera/camera2/pipe/internal/FrameState$a;", "", "<init>", "()V", "Lw/v;", Const.INTENT_KEY_PKGNAME, "()J", "LOa/d;", "frameIds", "LOa/d;", "camera-camera2-pipe"}, k = 1, mv = {2, 1, 0}, xi = 48)
    /* renamed from: androidx.camera.camera2.pipe.internal.FrameState$a, reason: from kotlin metadata */
    public static final class Companion {
        public /* synthetic */ Companion(i iVar) {
            this();
        }

        public final long b() {
            return v.a(FrameState.f10969k.c());
        }

        public Companion() {
        }
    }

    @Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0086\u0004\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u00012\b\u0012\u0004\u0012\u00020\u00020\u0003B\u0007¢\u0006\u0004\b\u0004\u0010\u0005J=\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\f\u001a\u00020\n2\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00020\rH\u0016¢\u0006\u0004\b\u0010\u0010\u0011J\u000f\u0010\u0012\u001a\u00020\u000fH\u0014¢\u0006\u0004\b\u0012\u0010\u0013¨\u0006\u0014"}, d2 = {"Landroidx/camera/camera2/pipe/internal/FrameState$b;", "Landroidx/camera/camera2/pipe/internal/FrameState$c;", "Lw/w;", "Landroidx/camera/camera2/pipe/internal/d$a;", "<init>", "(Landroidx/camera/camera2/pipe/internal/FrameState;)V", "Lw/y;", "cameraFrameNumber", "Lw/r;", "cameraTimestamp", "", "cameraOutputSequence", "outputNumber", "Landroidx/camera/camera2/pipe/internal/f;", "outputResult", "LY8/t;", Const.INTENT_KEY_APIKEY, "(JJJJLjava/lang/Object;)V", Const.INTENT_KEY_UMID, "()V", "camera-camera2-pipe"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public final class b extends c<w> implements d.a<w> {
        public b() {
        }

        @Override // androidx.camera.camera2.pipe.internal.d.a
        public void a(long cameraFrameNumber, long cameraTimestamp, long cameraOutputSequence, long outputNumber, Object outputResult) {
            c().complete(f.b(outputResult));
            FrameState.this.h();
        }

        @Override // androidx.camera.camera2.pipe.internal.FrameState.c
        public void d() {
        }
    }

    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b \u0018\u0000*\b\b\u0000\u0010\u0002*\u00020\u00012\u00020\u0001B\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\r\u0010\u0006\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0004J\u000f\u0010\u0007\u001a\u00020\u0005H$¢\u0006\u0004\b\u0007\u0010\u0004R\u0014\u0010\u000b\u001a\u00020\b8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\t\u0010\nR&\u0010\u0011\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\r0\f8\u0004X\u0084\u0004¢\u0006\f\n\u0004\b\u0006\u0010\u000e\u001a\u0004\b\u000f\u0010\u0010¨\u0006\u0012"}, d2 = {"Landroidx/camera/camera2/pipe/internal/FrameState$c;", "", ExifInterface.GPS_DIRECTION_TRUE, "<init>", "()V", "LY8/t;", Const.INTENT_KEY_PKGNAME, Const.INTENT_KEY_UMID, "LOa/c;", Const.INTENT_KEY_APIKEY, "LOa/c;", "count", "LUa/u;", "Landroidx/camera/camera2/pipe/internal/f;", "LUa/u;", "c", "()LUa/u;", "internalResult", "camera-camera2-pipe"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static abstract class c<T> {

        /* renamed from: a, reason: collision with root package name and from kotlin metadata */
        public final Oa.c count = Oa.b.c(1);

        /* renamed from: b, reason: collision with root package name and from kotlin metadata */
        public final InterfaceC1083u<f<T>> internalResult = C1087w.c(null, 1, null);

        public final void b() {
            if (this.count.b() == 0) {
                f.Companion companion = f.INSTANCE;
                this.internalResult.complete(f.b(f.c(H.f(H.INSTANCE.e()))));
                d();
            }
        }

        public final InterfaceC1083u<f<T>> c() {
            return this.internalResult;
        }

        public abstract void d();
    }

    @Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000b\b\u0086\u0004\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u00012\b\u0012\u0004\u0012\u00020\u00040\u0003B\u001f\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\u0006\u0010\b\u001a\u00020\u0007\u0012\u0006\u0010\n\u001a\u00020\t¢\u0006\u0004\b\u000b\u0010\fJ=\u0010\u0017\u001a\u00020\u00162\u0006\u0010\u000e\u001a\u00020\r2\u0006\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u0012\u001a\u00020\u00112\u0006\u0010\u0013\u001a\u00020\u00112\f\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00040\u0014H\u0016¢\u0006\u0004\b\u0017\u0010\u0018J\u000f\u0010\u0019\u001a\u00020\u0016H\u0014¢\u0006\u0004\b\u0019\u0010\u001aR\u0017\u0010\u0006\u001a\u00020\u00058\u0006¢\u0006\f\n\u0004\b\u001b\u0010\u001c\u001a\u0004\b\u001d\u0010\u001eR\u0017\u0010\b\u001a\u00020\u00078\u0006¢\u0006\f\n\u0004\b\u0019\u0010\u001c\u001a\u0004\b\u001f\u0010\u001eR\u0014\u0010\n\u001a\u00020\t8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001f\u0010 ¨\u0006!"}, d2 = {"Landroidx/camera/camera2/pipe/internal/FrameState$d;", "Landroidx/camera/camera2/pipe/internal/FrameState$c;", "LC/r;", "Landroidx/camera/camera2/pipe/internal/d$a;", "LC/q;", "Lw/Q;", "streamId", "Lw/G;", "outputId", "LOa/c;", "remainingOutputResults", "<init>", "(Landroidx/camera/camera2/pipe/internal/FrameState;IILOa/c;Lkotlin/jvm/internal/i;)V", "Lw/y;", "cameraFrameNumber", "Lw/r;", "cameraTimestamp", "", "cameraOutputSequence", "outputNumber", "Landroidx/camera/camera2/pipe/internal/f;", "outputResult", "LY8/t;", Const.INTENT_KEY_APIKEY, "(JJJJLjava/lang/Object;)V", Const.INTENT_KEY_UMID, "()V", "c", "I", "f", "()I", "e", "LOa/c;", "camera-camera2-pipe"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public final class d extends c<r> implements d.a<q> {

        /* renamed from: c, reason: collision with root package name and from kotlin metadata */
        public final int streamId;

        /* renamed from: d, reason: collision with root package name and from kotlin metadata */
        public final int outputId;

        /* renamed from: e, reason: collision with root package name and from kotlin metadata */
        public final Oa.c remainingOutputResults;

        /* renamed from: f, reason: collision with root package name */
        public final /* synthetic */ FrameState f10985f;

        public /* synthetic */ d(FrameState frameState, int i10, int i11, Oa.c cVar, i iVar) {
            this(frameState, i10, i11, cVar);
        }

        @Override // androidx.camera.camera2.pipe.internal.d.a
        public void a(long cameraFrameNumber, long cameraTimestamp, long cameraOutputSequence, long outputNumber, Object outputResult) throws Exception {
            q qVar = (q) (f.e(outputResult) ? outputResult : null);
            if (qVar != null) {
                r rVarA = r.INSTANCE.a(qVar);
                if (!c().complete(f.b(f.c(rVarA)))) {
                    C5423E.a(rVarA);
                }
            } else {
                c().complete(f.b(f.c(H.f(f.e(outputResult) ? H.INSTANCE.a() : outputResult == null ? H.INSTANCE.e() : ((H) outputResult).getValue()))));
            }
            if (this.remainingOutputResults.b() == 0) {
                Iterator it = this.f10985f.listenerStates.iterator();
                p.h(it, "iterator(...)");
                while (it.hasNext()) {
                    ((j) it.next()).c(this.streamId);
                }
                this.f10985f.i(this.streamId);
            }
        }

        @Override // androidx.camera.camera2.pipe.internal.FrameState.c
        public void d() throws Exception {
            f.Companion companion = f.INSTANCE;
            InterfaceC1083u<f<r>> interfaceC1083uC = c();
            Object obj = null;
            if (interfaceC1083uC.g() && !interfaceC1083uC.isCancelled()) {
                Object result = interfaceC1083uC.m().getResult();
                if (f.e(result)) {
                    obj = result;
                }
            }
            r rVar = (r) obj;
            if (rVar != null) {
                C5423E.a(rVar);
            }
        }

        /* renamed from: e, reason: from getter */
        public final int getOutputId() {
            return this.outputId;
        }

        /* renamed from: f, reason: from getter */
        public final int getStreamId() {
            return this.streamId;
        }

        public d(FrameState frameState, int i10, int i11, Oa.c remainingOutputResults) {
            p.i(remainingOutputResults, "remainingOutputResults");
            this.f10985f = frameState;
            this.streamId = i10;
            this.outputId = i11;
            this.remainingOutputResults = remainingOutputResults;
        }
    }

    @Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
    public static final /* synthetic */ class e {

        /* renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f10986a;

        static {
            int[] iArr = new int[State.values().length];
            try {
                iArr[State.STARTED.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[State.FRAME_INFO_COMPLETE.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[State.STREAM_RESULTS_COMPLETE.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                iArr[State.COMPLETE.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            f10986a = iArr;
        }
    }

    public /* synthetic */ FrameState(K k10, long j10, long j11, Set set, i iVar) {
        this(k10, j10, j11, set);
    }

    public final void c(InterfaceC5714u.a listener) {
        p.i(listener, "listener");
        j jVar = new j(listener);
        this.listenerStates.add(jVar);
        int i10 = e.f10986a[this.state.c().ordinal()];
        if (i10 == 1) {
            jVar.e(this.frameNumber, this.frameTimestamp);
            return;
        }
        if (i10 == 2) {
            jVar.b(this.frameNumber, this.frameTimestamp);
        } else if (i10 == 3) {
            jVar.d(this.frameNumber, this.frameTimestamp);
        } else {
            if (i10 != 4) {
                throw new NoWhenBranchMatchedException();
            }
            jVar.a(this.frameNumber, this.frameTimestamp);
        }
    }

    /* renamed from: d, reason: from getter */
    public final b getFrameInfoOutput() {
        return this.frameInfoOutput;
    }

    /* renamed from: e, reason: from getter */
    public final long getFrameNumber() {
        return this.frameNumber;
    }

    public final List<d> f() {
        return this.imageOutputs;
    }

    public final void g() {
        Iterator<j> it = this.listenerStates.iterator();
        p.h(it, "iterator(...)");
        while (it.hasNext()) {
            it.next().a(this.frameNumber, this.frameTimestamp);
        }
    }

    public final void h() {
        State stateC;
        State state;
        Oa.e<State> eVar = this.state;
        do {
            stateC = eVar.c();
            State state2 = stateC;
            int i10 = e.f10986a[state2.ordinal()];
            if (i10 == 1) {
                state = State.FRAME_INFO_COMPLETE;
            } else {
                if (i10 != 3) {
                    throw new IllegalStateException("Unexpected frame state for " + this + "! State is " + state2 + ' ');
                }
                state = State.COMPLETE;
            }
        } while (!eVar.a(stateC, state));
        Iterator<j> it = this.listenerStates.iterator();
        p.h(it, "iterator(...)");
        while (it.hasNext()) {
            it.next().b(this.frameNumber, this.frameTimestamp);
        }
        if (state == State.COMPLETE) {
            g();
        }
    }

    public final void i(int streamId) {
        State stateC;
        State state;
        if (this.remainingStreamCount.b() != 0) {
            return;
        }
        Oa.e<State> eVar = this.state;
        do {
            stateC = eVar.c();
            State state2 = stateC;
            int i10 = e.f10986a[state2.ordinal()];
            if (i10 == 1) {
                state = State.STREAM_RESULTS_COMPLETE;
            } else {
                if (i10 != 2) {
                    throw new IllegalStateException("Unexpected frame state for " + this + "! State is " + state2 + ' ');
                }
                state = State.COMPLETE;
            }
        } while (!eVar.a(stateC, state));
        Iterator<j> it = this.listenerStates.iterator();
        p.h(it, "iterator(...)");
        while (it.hasNext()) {
            it.next().d(this.frameNumber, this.frameTimestamp);
        }
        if (state == State.COMPLETE) {
            g();
        }
    }

    public String toString() {
        return "Frame-" + ((Object) v.b(this.frameId)) + '(' + this.frameNumber + '@' + this.frameTimestamp + ')';
    }

    public FrameState(K requestMetadata, long j10, long j11, Set<k> imageStreams) {
        Object next;
        p.i(requestMetadata, "requestMetadata");
        p.i(imageStreams, "imageStreams");
        this.requestMetadata = requestMetadata;
        this.frameNumber = j10;
        this.frameTimestamp = j11;
        this.frameId = INSTANCE.b();
        this.frameInfoOutput = new b();
        List listC = C1172u.c();
        Iterator<Q> it = requestMetadata.d().keySet().iterator();
        while (it.hasNext()) {
            int value = it.next().getValue();
            Iterator<T> it2 = imageStreams.iterator();
            while (true) {
                if (it2.hasNext()) {
                    next = it2.next();
                    if (Q.d(((k) next).getId(), value)) {
                        break;
                    }
                } else {
                    next = null;
                    break;
                }
            }
            k kVar = (k) next;
            if (kVar != null) {
                List<s> listB = kVar.b();
                Oa.c cVarC = Oa.b.c(listB.size());
                int size = listB.size();
                for (int i10 = 0; i10 < size; i10++) {
                    listC.add(new d(this, value, listB.get(i10).getId(), cVarC, null));
                }
            }
        }
        List<d> listA = C1172u.a(listC);
        this.imageOutputs = listA;
        this.state = Oa.b.g(State.STARTED);
        List<d> list = listA;
        ArrayList arrayList = new ArrayList(C1174w.x(list, 10));
        Iterator<T> it3 = list.iterator();
        while (it3.hasNext()) {
            arrayList.add(Q.a(((d) it3.next()).getStreamId()));
        }
        this.remainingStreamCount = Oa.b.c(F.g0(arrayList).size());
        this.listenerStates = new CopyOnWriteArrayList<>();
    }
}
