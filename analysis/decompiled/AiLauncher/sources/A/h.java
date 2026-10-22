package A;

import Y8.t;
import Z8.F;
import android.hardware.camera2.CameraAccessException;
import android.os.Trace;
import android.util.Log;
import androidx.camera.camera2.pipe.l;
import androidx.camera.camera2.pipe.t;
import com.autonavi.aps.amapapi.config.Const;
import com.stepos.ailauncher.foundation.appui.card.provider.alipay.AlipayXuiIsland;
import e9.InterfaceC4014c;
import f9.C4063a;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import s.C5423E;
import w.InputRequest;
import w.K;

@Metadata(d1 = {"\u0000c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010!\n\u0002\b\u0003\n\u0002\b\u0004*\u0001*\u0018\u0000 \n2\u00020\u0001:\u0001\bB#\b\u0002\u0012\u0018\u0010\u0004\u001a\u0014\u0012\u0004\u0012\u00020\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00010\u00030\u0002¢\u0006\u0004\b\u0005\u0010\u0006J\u000f\u0010\b\u001a\u00020\u0007H\u0000¢\u0006\u0004\b\b\u0010\tJ\u000f\u0010\n\u001a\u00020\u0007H\u0000¢\u0006\u0004\b\n\u0010\tJ\u0010\u0010\u000b\u001a\u00020\u0007H\u0080@¢\u0006\u0004\b\u000b\u0010\fJo\u0010\u0018\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\r2\f\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00100\u000f2\u0012\u0010\u0013\u001a\u000e\u0012\u0002\b\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u00122\u0012\u0010\u0014\u001a\u000e\u0012\u0002\b\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u00122\u0012\u0010\u0015\u001a\u000e\u0012\u0002\b\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u00122\f\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00160\u000fH\u0000¢\u0006\u0004\b\u0018\u0010\u0019J\u000f\u0010\u001b\u001a\u00020\u001aH\u0016¢\u0006\u0004\b\u001b\u0010\u001cR&\u0010\u0004\u001a\u0014\u0012\u0004\u0012\u00020\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00010\u00030\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\b\u0010\u001dR\u0014\u0010!\u001a\u00020\u001e8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001f\u0010 R\u0014\u0010%\u001a\u00020\"8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b#\u0010$R\u001e\u0010)\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00030&8\u0002X\u0083\u0004¢\u0006\u0006\n\u0004\b'\u0010(R\u0014\u0010,\u001a\u00020*8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u000b\u0010+¨\u0006-"}, d2 = {"LA/h;", "", "Landroidx/camera/camera2/pipe/m;", "Landroidx/camera/camera2/pipe/l;", "captureSequenceProcessor", "<init>", "(Landroidx/camera/camera2/pipe/m;)V", "LY8/t;", Const.INTENT_KEY_APIKEY, "()V", "f", "e", "(Le9/c;)Ljava/lang/Object;", "", "isRepeating", "", "Landroidx/camera/camera2/pipe/t;", "requests", "", "defaultParameters", "graphParameters", "requiredParameters", "Landroidx/camera/camera2/pipe/t$a;", "listeners", Const.INTENT_KEY_BACKGROUND_COMMAND, "(ZLjava/util/List;Ljava/util/Map;Ljava/util/Map;Ljava/util/Map;Ljava/util/List;)Z", "", "toString", "()Ljava/lang/String;", "Landroidx/camera/camera2/pipe/m;", "", Const.INTENT_KEY_PKGNAME, "I", "debugId", "LOa/a;", "c", "LOa/a;", AlipayXuiIsland.REASON_CLOSED, "", Const.INTENT_KEY_UMID, "Ljava/util/List;", "activeCaptureSequences", "A/h$b", "LA/h$b;", "activeBurstListener", "camera-camera2-pipe"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes.dex */
public final class h {

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    public final androidx.camera.camera2.pipe.m<Object, androidx.camera.camera2.pipe.l<Object>> captureSequenceProcessor;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    public final int debugId;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    public final Oa.a closed;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    public final List<androidx.camera.camera2.pipe.l<?>> activeCaptureSequences;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    public final b activeBurstListener;

    @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u001d\u0010\u0007\u001a\u00020\u00062\u000e\u0010\u0005\u001a\n\u0012\u0002\b\u0003\u0012\u0002\b\u00030\u0004¢\u0006\u0004\b\u0007\u0010\b¨\u0006\t"}, d2 = {"LA/h$a;", "", "<init>", "()V", "Landroidx/camera/camera2/pipe/m;", "captureSequenceProcessor", "LA/h;", Const.INTENT_KEY_APIKEY, "(Landroidx/camera/camera2/pipe/m;)LA/h;", "camera-camera2-pipe"}, k = 1, mv = {2, 1, 0}, xi = 48)
    /* renamed from: A.h$a, reason: from kotlin metadata */
    public static final class Companion {
        public /* synthetic */ Companion(kotlin.jvm.internal.i iVar) {
            this();
        }

        public final h a(androidx.camera.camera2.pipe.m<?, ?> captureSequenceProcessor) {
            kotlin.jvm.internal.p.i(captureSequenceProcessor, "captureSequenceProcessor");
            return new h(captureSequenceProcessor, null);
        }

        public Companion() {
        }
    }

    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u001b\u0010\u0005\u001a\u00020\u00042\n\u0010\u0003\u001a\u0006\u0012\u0002\b\u00030\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"A/h$b", "Landroidx/camera/camera2/pipe/l$a;", "Landroidx/camera/camera2/pipe/l;", "captureSequence", "LY8/t;", Const.INTENT_KEY_APIKEY, "(Landroidx/camera/camera2/pipe/l;)V", "camera-camera2-pipe"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class b implements l.a {
        public b() {
        }

        @Override // androidx.camera.camera2.pipe.l.a
        public void a(androidx.camera.camera2.pipe.l<?> captureSequence) {
            kotlin.jvm.internal.p.i(captureSequence, "captureSequence");
            if (captureSequence.l()) {
                return;
            }
            List list = h.this.activeCaptureSequences;
            h hVar = h.this;
            synchronized (list) {
                hVar.activeCaptureSequences.remove(captureSequence);
            }
        }
    }

    public /* synthetic */ h(androidx.camera.camera2.pipe.m mVar, kotlin.jvm.internal.i iVar) {
        this(mVar);
    }

    public final void a() {
        List<androidx.camera.camera2.pipe.l> listM1;
        synchronized (this.activeCaptureSequences) {
            listM1 = F.m1(this.activeCaptureSequences);
            this.activeCaptureSequences.clear();
        }
        for (androidx.camera.camera2.pipe.l lVar : listM1) {
            androidx.camera.camera2.pipe.n nVar = androidx.camera.camera2.pipe.n.f11059a;
            z.h hVar = z.h.f44503a;
            Trace.beginSection("InvokeInternalListeners");
            int size = lVar.n().size();
            for (int i10 = 0; i10 < size; i10++) {
                K k10 = lVar.n().get(i10);
                int size2 = lVar.o().size();
                for (int i11 = 0; i11 < size2; i11++) {
                    lVar.o().get(i11).G(k10.getRequest());
                }
            }
            z.h hVar2 = z.h.f44503a;
            Trace.endSection();
            Trace.beginSection("InvokeRequestListeners");
            int size3 = lVar.n().size();
            for (int i12 = 0; i12 < size3; i12++) {
                K k11 = lVar.n().get(i12);
                int size4 = k11.getRequest().d().size();
                for (int i13 = 0; i13 < size4; i13++) {
                    k11.getRequest().d().get(i13).G(k11.getRequest());
                }
            }
            z.h hVar3 = z.h.f44503a;
            Trace.endSection();
        }
        this.captureSequenceProcessor.f();
    }

    public final Object e(InterfaceC4014c<? super t> interfaceC4014c) {
        Object objH;
        if (z.k.f44508a.a()) {
            Log.d("CXCP", "Closing " + this);
        }
        return (this.closed.a(false, true) && (objH = this.captureSequenceProcessor.h(interfaceC4014c)) == C4063a.g()) ? objH : t.f7040a;
    }

    public final void f() {
        this.captureSequenceProcessor.stopRepeating();
    }

    public final boolean g(boolean isRepeating, List<androidx.camera.camera2.pipe.t> requests, Map<?, ? extends Object> defaultParameters, Map<?, ? extends Object> graphParameters, Map<?, ? extends Object> requiredParameters, List<? extends t.a> listeners) throws Exception {
        Throwable th;
        boolean z10;
        C.n image;
        kotlin.jvm.internal.p.i(requests, "requests");
        kotlin.jvm.internal.p.i(defaultParameters, "defaultParameters");
        kotlin.jvm.internal.p.i(graphParameters, "graphParameters");
        kotlin.jvm.internal.p.i(requiredParameters, "requiredParameters");
        kotlin.jvm.internal.p.i(listeners, "listeners");
        if (this.closed.b()) {
            if (z.k.f44508a.d()) {
                Log.w("CXCP", "Failed to submit " + requests + ": " + this + " is closed.");
            }
            return false;
        }
        z.h hVar = z.h.f44503a;
        try {
            Trace.beginSection("CXCP#buildCaptureSequence");
            androidx.camera.camera2.pipe.l<?> lVarI = this.captureSequenceProcessor.i(isRepeating, requests, defaultParameters, graphParameters, requiredParameters, this.activeBurstListener, listeners);
            Trace.endSection();
            boolean z11 = true;
            if (lVarI == null) {
                List<androidx.camera.camera2.pipe.t> list = requests;
                if (!(list instanceof Collection) || !list.isEmpty()) {
                    Iterator<T> it = list.iterator();
                    while (it.hasNext()) {
                        if (((androidx.camera.camera2.pipe.t) it.next()).getInputRequest() != null) {
                            for (androidx.camera.camera2.pipe.t tVar : requests) {
                                InputRequest inputRequest = tVar.getInputRequest();
                                if (inputRequest != null && (image = inputRequest.getImage()) != null) {
                                    C5423E.a(image);
                                    Y8.t tVar2 = Y8.t.f7040a;
                                }
                                Iterator<t.a> it2 = tVar.d().iterator();
                                while (it2.hasNext()) {
                                    it2.next().G(tVar);
                                }
                            }
                            return true;
                        }
                    }
                }
                if (z.k.f44508a.d()) {
                    Log.w("CXCP", "Failed to submit " + requests + ": " + this + " failed to build CaptureSequence.");
                }
                return false;
            }
            if (this.closed.b()) {
                if (z.k.f44508a.d()) {
                    Log.w("CXCP", "Failed to submit " + requests + ": " + this + " is closed.");
                }
                return false;
            }
            if (!lVarI.l()) {
                synchronized (this.activeCaptureSequences) {
                    this.activeCaptureSequences.add(lVarI);
                }
            }
            try {
                if (z.k.f44508a.a()) {
                    Log.d("CXCP", this + " submitting " + lVarI);
                }
                androidx.camera.camera2.pipe.n nVar = androidx.camera.camera2.pipe.n.f11059a;
                Trace.beginSection("InvokeInternalListeners");
                int size = lVarI.n().size();
                for (int i10 = 0; i10 < size; i10++) {
                    K k10 = lVarI.n().get(i10);
                    int size2 = lVarI.o().size();
                    for (int i11 = 0; i11 < size2; i11++) {
                        lVarI.o().get(i11).k0(k10);
                    }
                }
                z.h hVar2 = z.h.f44503a;
                Trace.endSection();
                Trace.beginSection("InvokeRequestListeners");
                int size3 = lVarI.n().size();
                for (int i12 = 0; i12 < size3; i12++) {
                    K k11 = lVarI.n().get(i12);
                    int size4 = k11.getRequest().d().size();
                    for (int i13 = 0; i13 < size4; i13++) {
                        k11.getRequest().d().get(i13).k0(k11);
                    }
                }
                z.h hVar3 = z.h.f44503a;
                synchronized (lVarI) {
                    if (this.closed.b()) {
                        if (z.k.f44508a.d()) {
                            Log.w("CXCP", "Failed to submit " + lVarI + ": " + this + " is closed.");
                        }
                        if (!lVarI.l()) {
                            synchronized (this.activeCaptureSequences) {
                                this.activeCaptureSequences.remove(lVarI);
                            }
                            androidx.camera.camera2.pipe.n nVar2 = androidx.camera.camera2.pipe.n.f11059a;
                            Trace.beginSection("InvokeInternalListeners");
                            int size5 = lVarI.n().size();
                            for (int i14 = 0; i14 < size5; i14++) {
                                K k12 = lVarI.n().get(i14);
                                int size6 = lVarI.o().size();
                                for (int i15 = 0; i15 < size6; i15++) {
                                    lVarI.o().get(i15).G(k12.getRequest());
                                }
                            }
                            z.h hVar4 = z.h.f44503a;
                            Trace.endSection();
                            Trace.beginSection("InvokeRequestListeners");
                            int size7 = lVarI.n().size();
                            for (int i16 = 0; i16 < size7; i16++) {
                                K k13 = lVarI.n().get(i16);
                                int size8 = k13.getRequest().d().size();
                                for (int i17 = 0; i17 < size8; i17++) {
                                    k13.getRequest().d().get(i17).G(k13.getRequest());
                                }
                            }
                            z.h hVar5 = z.h.f44503a;
                        }
                        return false;
                    }
                    try {
                        Trace.beginSection("CXCP#submit(CaptureSequence)");
                        Integer numG = this.captureSequenceProcessor.g(lVarI);
                        int iIntValue = numG != null ? numG.intValue() : -1;
                        lVarI.m(iIntValue);
                        if (iIntValue != -1) {
                            androidx.camera.camera2.pipe.n nVar3 = androidx.camera.camera2.pipe.n.f11059a;
                            Trace.beginSection("InvokeInternalListeners");
                            int size9 = lVarI.n().size();
                            for (int i18 = 0; i18 < size9; i18++) {
                                K k14 = lVarI.n().get(i18);
                                int size10 = lVarI.o().size();
                                for (int i19 = 0; i19 < size10; i19++) {
                                    lVarI.o().get(i19).V(k14);
                                }
                            }
                            z.h hVar6 = z.h.f44503a;
                            Trace.endSection();
                            Trace.beginSection("InvokeRequestListeners");
                            int size11 = lVarI.n().size();
                            for (int i20 = 0; i20 < size11; i20++) {
                                K k15 = lVarI.n().get(i20);
                                int size12 = k15.getRequest().d().size();
                                for (int i21 = 0; i21 < size12; i21++) {
                                    k15.getRequest().d().get(i21).V(k15);
                                }
                            }
                            z.h hVar7 = z.h.f44503a;
                            try {
                                if (z.k.f44508a.a()) {
                                    Log.d("CXCP", this + " submitted " + lVarI);
                                }
                                z10 = true;
                            } catch (CameraAccessException unused) {
                                if (!z11 && !lVarI.l()) {
                                    synchronized (this.activeCaptureSequences) {
                                        this.activeCaptureSequences.remove(lVarI);
                                    }
                                    androidx.camera.camera2.pipe.n nVar4 = androidx.camera.camera2.pipe.n.f11059a;
                                    z.h hVar8 = z.h.f44503a;
                                    Trace.beginSection("InvokeInternalListeners");
                                    int size13 = lVarI.n().size();
                                    for (int i22 = 0; i22 < size13; i22++) {
                                        K k16 = lVarI.n().get(i22);
                                        int size14 = lVarI.o().size();
                                        for (int i23 = 0; i23 < size14; i23++) {
                                            lVarI.o().get(i23).G(k16.getRequest());
                                        }
                                    }
                                    z.h hVar9 = z.h.f44503a;
                                    Trace.endSection();
                                    Trace.beginSection("InvokeRequestListeners");
                                    int size15 = lVarI.n().size();
                                    for (int i24 = 0; i24 < size15; i24++) {
                                        K k17 = lVarI.n().get(i24);
                                        int size16 = k17.getRequest().d().size();
                                        for (int i25 = 0; i25 < size16; i25++) {
                                            k17.getRequest().d().get(i25).G(k17.getRequest());
                                        }
                                    }
                                    z.h hVar10 = z.h.f44503a;
                                }
                                return false;
                            } catch (Throwable th2) {
                                th = th2;
                                if (z11 || lVarI.l()) {
                                    throw th;
                                }
                                synchronized (this.activeCaptureSequences) {
                                    this.activeCaptureSequences.remove(lVarI);
                                }
                                androidx.camera.camera2.pipe.n nVar5 = androidx.camera.camera2.pipe.n.f11059a;
                                z.h hVar11 = z.h.f44503a;
                                Trace.beginSection("InvokeInternalListeners");
                                int size17 = lVarI.n().size();
                                for (int i26 = 0; i26 < size17; i26++) {
                                    K k18 = lVarI.n().get(i26);
                                    int size18 = lVarI.o().size();
                                    for (int i27 = 0; i27 < size18; i27++) {
                                        lVarI.o().get(i27).G(k18.getRequest());
                                    }
                                }
                                z.h hVar12 = z.h.f44503a;
                                Trace.endSection();
                                Trace.beginSection("InvokeRequestListeners");
                                int size19 = lVarI.n().size();
                                for (int i28 = 0; i28 < size19; i28++) {
                                    K k19 = lVarI.n().get(i28);
                                    int size20 = k19.getRequest().d().size();
                                    for (int i29 = 0; i29 < size20; i29++) {
                                        k19.getRequest().d().get(i29).G(k19.getRequest());
                                    }
                                }
                                z.h hVar13 = z.h.f44503a;
                                throw th;
                            }
                        } else {
                            if (z.k.f44508a.d()) {
                                Log.w("CXCP", "Failed to submit " + lVarI + ": " + this + " received -1 from submit.");
                            }
                            z10 = false;
                            z11 = false;
                        }
                        if (z10 || lVarI.l()) {
                            return z11;
                        }
                        synchronized (this.activeCaptureSequences) {
                            this.activeCaptureSequences.remove(lVarI);
                        }
                        androidx.camera.camera2.pipe.n nVar6 = androidx.camera.camera2.pipe.n.f11059a;
                        Trace.beginSection("InvokeInternalListeners");
                        int size21 = lVarI.n().size();
                        for (int i30 = 0; i30 < size21; i30++) {
                            K k20 = lVarI.n().get(i30);
                            int size22 = lVarI.o().size();
                            for (int i31 = 0; i31 < size22; i31++) {
                                lVarI.o().get(i31).G(k20.getRequest());
                            }
                        }
                        z.h hVar14 = z.h.f44503a;
                        Trace.endSection();
                        Trace.beginSection("InvokeRequestListeners");
                        int size23 = lVarI.n().size();
                        for (int i32 = 0; i32 < size23; i32++) {
                            K k21 = lVarI.n().get(i32);
                            int size24 = k21.getRequest().d().size();
                            for (int i33 = 0; i33 < size24; i33++) {
                                k21.getRequest().d().get(i33).G(k21.getRequest());
                            }
                        }
                        z.h hVar15 = z.h.f44503a;
                        return z11;
                    } finally {
                    }
                }
            } catch (CameraAccessException unused2) {
                z11 = false;
            } catch (Throwable th3) {
                th = th3;
                z11 = false;
            }
        } finally {
            Trace.endSection();
        }
    }

    public String toString() {
        return "GraphRequestProcessor-" + this.debugId;
    }

    public h(androidx.camera.camera2.pipe.m<? extends Object, androidx.camera.camera2.pipe.l<Object>> mVar) {
        this.captureSequenceProcessor = mVar;
        this.debugId = i.a().d();
        this.closed = Oa.b.a(false);
        this.activeCaptureSequences = new ArrayList();
        this.activeBurstListener = new b();
    }
}
