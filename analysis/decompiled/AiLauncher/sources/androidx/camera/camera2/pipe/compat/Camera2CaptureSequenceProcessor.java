package androidx.camera.camera2.pipe.compat;

import Z8.F;
import android.hardware.camera2.CaptureRequest;
import android.hardware.camera2.TotalCaptureResult;
import android.os.Trace;
import android.util.Log;
import android.view.Surface;
import androidx.camera.camera2.pipe.core.Threads;
import com.autonavi.aps.amapapi.config.Const;
import e9.InterfaceC4014c;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import s.C5423E;
import w.G;
import w.P;
import w.Q;
import w.S;
import x.InterfaceC5814f0;
import x.M;
import x.O;

@Metadata(d1 = {"\u0000\u009a\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010%\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0019\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0000\u0018\u0000 42\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001:\u0001BBa\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\u0006\u0010\u0007\u001a\u00020\u0006\u0012\u0006\u0010\t\u001a\u00020\b\u0012\u0012\u0010\r\u001a\u000e\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\f0\n\u0012\u0012\u0010\u000f\u001a\u000e\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\f0\n\u0012\u0006\u0010\u0011\u001a\u00020\u0010\u0012\u0006\u0010\u0013\u001a\u00020\u0012\u0012\b\b\u0002\u0010\u0015\u001a\u00020\u0014¢\u0006\u0004\b\u0016\u0010\u0017Jy\u0010$\u001a\u0004\u0018\u00010\u00032\u0006\u0010\u0018\u001a\u00020\u00142\f\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u001a0\u00192\u0012\u0010\u001d\u001a\u000e\u0012\u0002\b\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u001c0\n2\u0012\u0010\u001e\u001a\u000e\u0012\u0002\b\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u001c0\n2\u0012\u0010\u001f\u001a\u000e\u0012\u0002\b\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u001c0\n2\u0006\u0010!\u001a\u00020 2\f\u0010#\u001a\b\u0012\u0004\u0012\u00020\"0\u0019H\u0016¢\u0006\u0004\b$\u0010%J\u0019\u0010(\u001a\u0004\u0018\u00010'2\u0006\u0010&\u001a\u00020\u0003H\u0016¢\u0006\u0004\b(\u0010)J\u000f\u0010+\u001a\u00020*H\u0016¢\u0006\u0004\b+\u0010,J\u000f\u0010-\u001a\u00020*H\u0016¢\u0006\u0004\b-\u0010,J\u0010\u0010.\u001a\u00020*H\u0096@¢\u0006\u0004\b.\u0010/J\u000f\u00100\u001a\u00020*H\u0000¢\u0006\u0004\b0\u0010,J\u000f\u00102\u001a\u000201H\u0016¢\u0006\u0004\b2\u00103J\u0017\u00104\u001a\u00020*2\u0006\u0010&\u001a\u00020\u0003H\u0002¢\u0006\u0004\b4\u00105J%\u00106\u001a\u00020\u00142\f\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u001a0\u00192\u0006\u0010\u0005\u001a\u00020\u0004H\u0002¢\u0006\u0004\b6\u00107JY\u0010;\u001a\u00020\u00142\f\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u001a0\u00192\u0012\u00109\u001a\u000e\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\u000b082\u0012\u0010:\u001a\u000e\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\u000e082\u0012\u0010\r\u001a\u000e\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\f08H\u0002¢\u0006\u0004\b;\u0010<J!\u0010@\u001a\u0004\u0018\u00010?2\u0006\u0010=\u001a\u00020\u001a2\u0006\u0010>\u001a\u00020\bH\u0002¢\u0006\u0004\b@\u0010AR\u0014\u0010\u0005\u001a\u00020\u00048\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bB\u0010CR\u0014\u0010\u0007\u001a\u00020\u00068\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bD\u0010ER\u0014\u0010\t\u001a\u00020\b8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bF\u0010GR \u0010\r\u001a\u000e\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\f0\n8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bH\u0010IR \u0010\u000f\u001a\u000e\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\f0\n8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bJ\u0010IR\u0014\u0010\u0011\u001a\u00020\u00108\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b+\u0010KR\u0014\u0010\u0013\u001a\u00020\u00128\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bL\u0010MR\u0014\u0010\u0015\u001a\u00020\u00148\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b.\u0010NR\u0014\u0010P\u001a\u00020'8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bO\u0010GR\u0014\u0010S\u001a\u00020\u001c8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bQ\u0010RR\u0016\u0010U\u001a\u00020\u00148\u0002@\u0002X\u0083\u000e¢\u0006\u0006\n\u0004\bT\u0010NR\u0018\u0010X\u001a\u0004\u0018\u00010\u00038\u0002@\u0002X\u0083\u000e¢\u0006\u0006\n\u0004\bV\u0010WR\u0016\u0010\\\u001a\u0004\u0018\u00010Y8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bZ\u0010[¨\u0006]"}, d2 = {"Landroidx/camera/camera2/pipe/compat/Camera2CaptureSequenceProcessor;", "Landroidx/camera/camera2/pipe/m;", "Landroid/hardware/camera2/CaptureRequest;", "Lx/M;", "Landroidx/camera/camera2/pipe/compat/o;", "session", "Landroidx/camera/camera2/pipe/core/Threads;", "threads", "Lw/M;", M5.e.FAIL_TEMPLATE, "", "Lw/Q;", "Landroid/view/Surface;", "streamToSurfaceMap", "Lw/G;", "outputToSurfaceMap", "Landroidx/camera/camera2/pipe/v;", "streamGraph", "Lw/S;", "strictMode", "", "awaitRepeatingRequestOnDisconnect", "<init>", "(Landroidx/camera/camera2/pipe/compat/o;Landroidx/camera/camera2/pipe/core/Threads;ILjava/util/Map;Ljava/util/Map;Landroidx/camera/camera2/pipe/v;Lw/S;ZLkotlin/jvm/internal/i;)V", "isRepeating", "", "Landroidx/camera/camera2/pipe/t;", "requests", "", "defaultParameters", "graphParameters", "requiredParameters", "Landroidx/camera/camera2/pipe/l$a;", "sequenceListener", "Landroidx/camera/camera2/pipe/t$a;", "listeners", "o", "(ZLjava/util/List;Ljava/util/Map;Ljava/util/Map;Ljava/util/Map;Landroidx/camera/camera2/pipe/l$a;Ljava/util/List;)Lx/M;", "captureSequence", "", "s", "(Lx/M;)Ljava/lang/Integer;", "LY8/t;", "f", "()V", "stopRepeating", Const.INTENT_KEY_BACKGROUND_NOTIFICATION, "(Le9/c;)Ljava/lang/Object;", "r", "", "toString", "()Ljava/lang/String;", "n", "(Lx/M;)V", "t", "(Ljava/util/List;Landroidx/camera/camera2/pipe/compat/o;)Z", "", "surfaceToStreamMap", "surfaceToOutputMap", "q", "(Ljava/util/List;Ljava/util/Map;Ljava/util/Map;Ljava/util/Map;)Z", "request", "requestTemplate", "Landroid/hardware/camera2/CaptureRequest$Builder;", "p", "(Landroidx/camera/camera2/pipe/t;I)Landroid/hardware/camera2/CaptureRequest$Builder;", Const.INTENT_KEY_APIKEY, "Landroidx/camera/camera2/pipe/compat/o;", Const.INTENT_KEY_PKGNAME, "Landroidx/camera/camera2/pipe/core/Threads;", "c", "I", Const.INTENT_KEY_UMID, "Ljava/util/Map;", "e", "Landroidx/camera/camera2/pipe/v;", Const.INTENT_KEY_BACKGROUND_COMMAND, "Lw/S;", "Z", Const.INTENT_KEY_BACKGROUND_NOTIFICATION_ID, "debugId", Const.INTENT_KEY_BACKGROUND_NOTIFICATION_REMOVE, "Ljava/lang/Object;", "lock", "k", "disconnected", "l", "Lx/M;", "lastSingleRepeatingRequestSequence", "LC/o;", "m", "LC/o;", "imageWriter", "camera-camera2-pipe"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes.dex */
public final class Camera2CaptureSequenceProcessor implements androidx.camera.camera2.pipe.m<CaptureRequest, M> {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    public final o session;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    public final Threads threads;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    public final int template;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    public final Map<Q, Surface> streamToSurfaceMap;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    public final Map<G, Surface> outputToSurfaceMap;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    public final androidx.camera.camera2.pipe.v streamGraph;

    /* renamed from: g, reason: collision with root package name and from kotlin metadata */
    public final S strictMode;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    public final boolean awaitRepeatingRequestOnDisconnect;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    public final int debugId;

    /* renamed from: j, reason: collision with root package name and from kotlin metadata */
    public final Object lock;

    /* renamed from: k, reason: collision with root package name and from kotlin metadata */
    public boolean disconnected;

    /* renamed from: l, reason: collision with root package name and from kotlin metadata */
    public M lastSingleRepeatingRequestSequence;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    public final C.o imageWriter;

    public /* synthetic */ Camera2CaptureSequenceProcessor(o oVar, Threads threads, int i10, Map map, Map map2, androidx.camera.camera2.pipe.v vVar, S s10, boolean z10, kotlin.jvm.internal.i iVar) {
        this(oVar, threads, i10, map, map2, vVar, s10, z10);
    }

    @Override // androidx.camera.camera2.pipe.m
    public void f() {
        synchronized (this.lock) {
            try {
                if (z.k.f44508a.a()) {
                    Log.d("CXCP", this + "#abortCaptures");
                }
                this.session.f();
                Y8.t tVar = Y8.t.f7040a;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // androidx.camera.camera2.pipe.m
    public Object h(InterfaceC4014c<? super Y8.t> interfaceC4014c) {
        r();
        return Y8.t.f7040a;
    }

    public final void n(M captureSequence) {
        z.k kVar = z.k.f44508a;
        if (kVar.a()) {
            Log.d("CXCP", "Waiting for the last repeating request sequence: " + captureSequence);
        }
        if (((Y8.t) this.threads.n(2000L, new Camera2CaptureSequenceProcessor$awaitRepeatingRequestStarted$2(captureSequence, null))) == null && kVar.b()) {
            Log.e("CXCP", this + "#close: awaitStarted on last repeating request timed out, lastSingleRepeatingRequestSequence = " + captureSequence);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:103:0x0273  */
    /* JADX WARN: Removed duplicated region for block: B:109:0x0288 A[LOOP:3: B:81:0x0204->B:109:0x0288, LOOP_END] */
    /* JADX WARN: Removed duplicated region for block: B:111:0x0294  */
    /* JADX WARN: Removed duplicated region for block: B:113:0x02d5  */
    /* JADX WARN: Removed duplicated region for block: B:141:0x0292 A[EDGE_INSN: B:141:0x0292->B:110:0x0292 BREAK  A[LOOP:3: B:81:0x0204->B:109:0x0288], SYNTHETIC] */
    @Override // androidx.camera.camera2.pipe.m
    /* renamed from: o, reason: merged with bridge method [inline-methods] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public x.M i(boolean r28, java.util.List<androidx.camera.camera2.pipe.t> r29, java.util.Map<?, ? extends java.lang.Object> r30, java.util.Map<?, ? extends java.lang.Object> r31, java.util.Map<?, ? extends java.lang.Object> r32, androidx.camera.camera2.pipe.l.a r33, java.util.List<? extends androidx.camera.camera2.pipe.t.a> r34) {
        /*
            Method dump skipped, instructions count: 904
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.camera.camera2.pipe.compat.Camera2CaptureSequenceProcessor.i(boolean, java.util.List, java.util.Map, java.util.Map, java.util.Map, androidx.camera.camera2.pipe.l$a, java.util.List):x.M");
    }

    public final CaptureRequest.Builder p(androidx.camera.camera2.pipe.t request, int requestTemplate) {
        CaptureRequest.Builder builderJ;
        if (request.getInputRequest() != null) {
            TotalCaptureResult totalCaptureResult = (TotalCaptureResult) request.getInputRequest().getFrameInfo().R0(kotlin.jvm.internal.t.b(TotalCaptureResult.class));
            if (totalCaptureResult == null) {
                throw new IllegalStateException(("Failed to unwrap FrameInfo " + request.getInputRequest().getFrameInfo() + " as TotalCaptureResult").toString());
            }
            builderJ = this.session.getDevice().D0(totalCaptureResult);
        } else {
            builderJ = this.session.getDevice().J(requestTemplate);
        }
        if (builderJ != null) {
            return builderJ;
        }
        if (request.getInputRequest() != null) {
            if (z.k.f44508a.c()) {
                Log.i("CXCP", "Failed to create a ReprocessingCaptureRequest.Builder from " + request.getInputRequest().getFrameInfo() + '!');
            }
        } else if (z.k.f44508a.c()) {
            Log.i("CXCP", "Failed to create a CaptureRequest.Builder from " + ((Object) w.M.g(requestTemplate)) + '!');
        }
        return null;
    }

    public final boolean q(List<androidx.camera.camera2.pipe.t> requests, Map<Surface, Q> surfaceToStreamMap, Map<Surface, G> surfaceToOutputMap, Map<Q, Surface> streamToSurfaceMap) {
        if (requests.isEmpty()) {
            throw new IllegalStateException("build(...) should never be called with an empty request list!");
        }
        for (androidx.camera.camera2.pipe.t tVar : requests) {
            Iterator<Q> it = tVar.f().iterator();
            boolean z10 = false;
            while (it.hasNext()) {
                int value = it.next().getValue();
                if (!streamToSurfaceMap.containsKey(Q.a(value))) {
                    Surface surface = this.streamToSurfaceMap.get(Q.a(value));
                    if (surface != null) {
                        surfaceToStreamMap.put(surface, Q.a(value));
                        streamToSurfaceMap.put(Q.a(value), surface);
                        androidx.camera.camera2.pipe.k kVarB = this.streamGraph.b(value);
                        if (kVarB == null) {
                            throw new IllegalStateException("Required value was null.");
                        }
                        for (androidx.camera.camera2.pipe.s sVar : kVarB.b()) {
                            Surface surface2 = this.outputToSurfaceMap.get(G.a(sVar.getId()));
                            if (surface2 == null) {
                                throw new IllegalStateException("Required value was null.");
                            }
                            surfaceToOutputMap.put(surface2, G.a(sVar.getId()));
                        }
                    } else {
                        continue;
                    }
                }
                z10 = true;
            }
            if (!z10) {
                if (z.k.f44508a.c()) {
                    Log.i("CXCP", "  Failed to bind any surfaces for " + tVar + '!');
                }
                return false;
            }
            if (!z10) {
                throw new IllegalStateException("Check failed.");
            }
        }
        return true;
    }

    public final void r() {
        M m10;
        z.h hVar = z.h.f44503a;
        try {
            Trace.beginSection(this + "#disconnect");
            synchronized (this.lock) {
                try {
                    if (this.disconnected) {
                        m10 = null;
                    } else {
                        this.disconnected = true;
                        C.o oVar = this.imageWriter;
                        if (oVar != null) {
                            C5423E.a(oVar);
                        }
                        Surface inputSurface = this.session.getInputSurface();
                        if (inputSurface != null) {
                            inputSurface.release();
                        }
                        m10 = this.lastSingleRepeatingRequestSequence;
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
            if (this.awaitRepeatingRequestOnDisconnect && m10 != null) {
                n(m10);
            }
            Y8.t tVar = Y8.t.f7040a;
        } finally {
            Trace.endSection();
        }
    }

    @Override // androidx.camera.camera2.pipe.m
    /* renamed from: s, reason: merged with bridge method [inline-methods] */
    public Integer g(M captureSequence) {
        Integer numT;
        kotlin.jvm.internal.p.i(captureSequence, "captureSequence");
        synchronized (this.lock) {
            if (this.disconnected) {
                if (z.k.f44508a.d()) {
                    Log.w("CXCP", this + " disconnected. " + captureSequence + " won't be submitted");
                }
                return null;
            }
            if (captureSequence.i().size() != 1 || (this.session instanceof InterfaceC5814f0)) {
                numT = captureSequence.getRepeating() ? this.session.T(captureSequence.i(), captureSequence) : this.session.p(captureSequence.i(), captureSequence);
            } else if (captureSequence.getRepeating()) {
                if (this.awaitRepeatingRequestOnDisconnect) {
                    this.lastSingleRepeatingRequestSequence = captureSequence;
                }
                numT = this.session.q0(captureSequence.i().get(0), captureSequence);
            } else {
                numT = this.session.F0(captureSequence.i().get(0), captureSequence);
            }
            return numT;
        }
    }

    @Override // androidx.camera.camera2.pipe.m
    public void stopRepeating() {
        synchronized (this.lock) {
            try {
                if (z.k.f44508a.a()) {
                    Log.d("CXCP", this + "#stopRepeating");
                }
                this.session.stopRepeating();
                Y8.t tVar = Y8.t.f7040a;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:116:0x0175 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:120:? A[LOOP:2: B:57:0x0106->B:120:?, LOOP_END, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:127:0x00b0 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:130:? A[LOOP:4: B:15:0x003b->B:130:?, LOOP_END, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:39:0x00aa  */
    /* JADX WARN: Removed duplicated region for block: B:79:0x016f  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final boolean t(java.util.List<androidx.camera.camera2.pipe.t> r14, androidx.camera.camera2.pipe.compat.o r15) {
        /*
            Method dump skipped, instructions count: 527
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.camera.camera2.pipe.compat.Camera2CaptureSequenceProcessor.t(java.util.List, androidx.camera.camera2.pipe.compat.o):boolean");
    }

    public String toString() {
        return "Camera2CaptureSequenceProcessor-" + this.debugId;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public Camera2CaptureSequenceProcessor(o session, Threads threads, int i10, Map<Q, ? extends Surface> streamToSurfaceMap, Map<G, ? extends Surface> outputToSurfaceMap, androidx.camera.camera2.pipe.v streamGraph, S strictMode, boolean z10) {
        kotlin.jvm.internal.p.i(session, "session");
        kotlin.jvm.internal.p.i(threads, "threads");
        kotlin.jvm.internal.p.i(streamToSurfaceMap, "streamToSurfaceMap");
        kotlin.jvm.internal.p.i(outputToSurfaceMap, "outputToSurfaceMap");
        kotlin.jvm.internal.p.i(streamGraph, "streamGraph");
        kotlin.jvm.internal.p.i(strictMode, "strictMode");
        this.session = session;
        this.threads = threads;
        this.template = i10;
        this.streamToSurfaceMap = streamToSurfaceMap;
        this.outputToSurfaceMap = outputToSurfaceMap;
        this.streamGraph = streamGraph;
        this.strictMode = strictMode;
        this.awaitRepeatingRequestOnDisconnect = z10;
        this.debugId = O.b().d();
        this.lock = new Object();
        C.o oVarA = null;
        if (!streamGraph.l().isEmpty()) {
            androidx.camera.camera2.pipe.p pVar = (androidx.camera.camera2.pipe.p) F.q0(streamGraph.l());
            Surface inputSurface = session.getInputSurface();
            if (inputSurface == null) {
                throw new IllegalStateException("inputSurface is required to create instance of imageWriter.");
            }
            try {
                oVarA = C.b.INSTANCE.a(inputSurface, pVar.getId(), pVar.getMaxImages(), P.c(pVar.getFormat()), threads.i());
            } catch (RuntimeException e10) {
                if (z.k.f44508a.b()) {
                    Log.e("CXCP", "Failed to create ImageWriter for session " + this.session + "! Reprocessing will not be supported!", e10);
                }
            }
            if (oVarA != null && z.k.f44508a.a()) {
                Log.d("CXCP", "Created ImageWriter " + oVarA + " for session " + this.session);
            }
        }
        this.imageWriter = oVarA;
    }
}
