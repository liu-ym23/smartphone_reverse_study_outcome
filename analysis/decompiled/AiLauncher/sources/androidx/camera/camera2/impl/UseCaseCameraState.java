package androidx.camera.camera2.impl;

import D.C0761b0;
import Ua.InterfaceC1083u;
import Y8.t;
import Z8.A;
import Z8.C1165m;
import android.hardware.camera2.CaptureRequest;
import android.util.Log;
import androidx.camera.camera2.pipe.CameraGraph;
import androidx.camera.camera2.pipe.q;
import androidx.camera.camera2.pipe.t;
import com.autonavi.aps.amapapi.config.Const;
import e9.InterfaceC4014c;
import f9.C4063a;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.CancellationException;
import kotlin.Metadata;
import kotlin.jvm.internal.p;
import r.E;
import s.J;
import t.C5473b;
import t.f0;
import w.C5695a;
import w.C5696b;
import w.C5697c;
import w.InterfaceC5704j;
import w.K;
import w.M;
import w.Q;
import w.w;

@Metadata(d1 = {"\u0000¬\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\"\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010%\n\u0002\b\u0003\n\u0002\u0010#\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0007\u0018\u00002\u00020\u0001:\u0002)'B\u0019\b\u0007\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0006\u0010\u0007J\u0092\u0001\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u00180\u00172\u001a\b\u0002\u0010\n\u001a\u0014\u0012\b\u0012\u0006\u0012\u0002\b\u00030\t\u0012\u0004\u0012\u00020\u0001\u0018\u00010\b2\b\b\u0002\u0010\f\u001a\u00020\u000b2\u001a\b\u0002\u0010\u000e\u001a\u0014\u0012\b\u0012\u0006\u0012\u0002\b\u00030\r\u0012\u0004\u0012\u00020\u0001\u0018\u00010\b2\b\b\u0002\u0010\u000f\u001a\u00020\u000b2\u0010\b\u0002\u0010\u0012\u001a\n\u0012\u0004\u0012\u00020\u0011\u0018\u00010\u00102\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u00132\u0010\b\u0002\u0010\u0016\u001a\n\u0012\u0004\u0012\u00020\u0015\u0018\u00010\u0010H\u0086@¢\u0006\u0004\b\u0019\u0010\u001aJ\u0010\u0010\u001b\u001a\u00020\u0018H\u0086@¢\u0006\u0004\b\u001b\u0010\u001cJ\r\u0010\u001d\u001a\u00020\u0018¢\u0006\u0004\b\u001d\u0010\u001eJ\u0010\u0010\u001f\u001a\u00020\u0018H\u0082@¢\u0006\u0004\b\u001f\u0010\u001cJ-\u0010!\u001a\u00020\u0018*\u00020 2\u0018\u0010\n\u001a\u0014\u0012\b\u0012\u0006\u0012\u0002\b\u00030\t\u0012\u0004\u0012\u00020\u0001\u0018\u00010\bH\u0002¢\u0006\u0004\b!\u0010\"J3\u0010%\u001a\u0004\u0018\u00010$*\u0014\u0012\b\u0012\u0006\u0012\u0002\b\u00030\t\u0012\u0004\u0012\u00020\u0001\u0018\u00010\b2\n\u0010#\u001a\u0006\u0012\u0002\b\u00030\tH\u0002¢\u0006\u0004\b%\u0010&R\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b'\u0010(R\u0014\u0010\u0005\u001a\u00020\u00048\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b)\u0010*R\u0014\u0010-\u001a\u00020\u00018\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b+\u0010,R\u001e\u00101\u001a\n\u0012\u0004\u0012\u00020\u0018\u0018\u00010.8\u0002@\u0002X\u0083\u000e¢\u0006\u0006\n\u0004\b/\u00100R\u0014\u00104\u001a\u0002028\u0002X\u0083\u0004¢\u0006\u0006\n\u0004\b\u001d\u00103R\u001c\u00108\u001a\b\u0012\u0004\u0012\u000206058\u0002@\u0002X\u0083\u000e¢\u0006\u0006\n\u0004\b%\u00107R\u0016\u0010:\u001a\u00020\u000b8\u0002@\u0002X\u0083\u000e¢\u0006\u0006\n\u0004\b\u001f\u00109R$\u0010=\u001a\u0012\u0012\b\u0012\u0006\u0012\u0002\b\u00030\t\u0012\u0004\u0012\u00020\u00010;8\u0002X\u0083\u0004¢\u0006\u0006\n\u0004\b\u001b\u0010<R$\u0010>\u001a\u0012\u0012\b\u0012\u0006\u0012\u0002\b\u00030\r\u0012\u0004\u0012\u00020\u00010;8\u0002X\u0083\u0004¢\u0006\u0006\n\u0004\b!\u0010<R\u001a\u0010A\u001a\b\u0012\u0004\u0012\u00020\u00110?8\u0002X\u0083\u0004¢\u0006\u0006\n\u0004\b\u0019\u0010@R\u001a\u0010C\u001a\b\u0012\u0004\u0012\u00020\u00150?8\u0002X\u0083\u0004¢\u0006\u0006\n\u0004\bB\u0010@R\u0018\u0010F\u001a\u0004\u0018\u00010\u00138\u0002@\u0002X\u0083\u000e¢\u0006\u0006\n\u0004\bD\u0010ER\u0018\u0010J\u001a\u0004\u0018\u00010G8\u0002@\u0002X\u0083\u000e¢\u0006\u0006\n\u0004\bH\u0010IR\u0018\u0010N\u001a\u0004\u0018\u00010K8\u0002@\u0002X\u0083\u000e¢\u0006\u0006\n\u0004\bL\u0010MR\u0018\u0010R\u001a\u0004\u0018\u00010O8\u0002@\u0002X\u0083\u000e¢\u0006\u0006\n\u0004\bP\u0010QR\u0018\u0010V\u001a\u00060SR\u00020\u00008\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bT\u0010UR\u0014\u0010X\u001a\u0002028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bW\u00103¨\u0006Y"}, d2 = {"Landroidx/camera/camera2/impl/UseCaseCameraState;", "", "Ls/J;", "useCaseGraphContext", "Lr/E;", "templateParamsOverride", "<init>", "(Ls/J;Lr/E;)V", "", "Landroid/hardware/camera2/CaptureRequest$Key;", "parameters", "", "appendParameters", "Landroidx/camera/camera2/pipe/q$a;", "internalParameters", "appendInternalParameters", "", "Lw/Q;", "streams", "Lw/M;", M5.e.FAIL_TEMPLATE, "Landroidx/camera/camera2/pipe/t$a;", "listeners", "LUa/Q;", "LY8/t;", Const.INTENT_KEY_BACKGROUND_NOTIFICATION_REMOVE, "(Ljava/util/Map;ZLjava/util/Map;ZLjava/util/Set;Lw/M;Ljava/util/Set;Le9/c;)Ljava/lang/Object;", Const.INTENT_KEY_BACKGROUND_NOTIFICATION, "(Le9/c;)Ljava/lang/Object;", "e", "()V", Const.INTENT_KEY_BACKGROUND_COMMAND, "Landroidx/camera/camera2/pipe/CameraGraph$f;", Const.INTENT_KEY_BACKGROUND_NOTIFICATION_ID, "(Landroidx/camera/camera2/pipe/CameraGraph$f;Ljava/util/Map;)V", "key", "", "f", "(Ljava/util/Map;Landroid/hardware/camera2/CaptureRequest$Key;)Ljava/lang/Integer;", Const.INTENT_KEY_APIKEY, "Ls/J;", Const.INTENT_KEY_PKGNAME, "Lr/E;", "c", "Ljava/lang/Object;", "lock", "LUa/u;", Const.INTENT_KEY_UMID, "LUa/u;", "updateSignal", "LOa/c;", "LOa/c;", "submittedRequestCounter", "LZ8/m;", "Landroidx/camera/camera2/impl/UseCaseCameraState$b;", "LZ8/m;", "updateSignals", "Z", "updating", "", "Ljava/util/Map;", "currentParameters", "currentInternalParameters", "", "Ljava/util/Set;", "currentStreams", "k", "currentListeners", "l", "Lw/M;", "currentTemplate", "Lw/a;", "m", "Lw/a;", "lastAeMode", "Lw/b;", "n", "Lw/b;", "lastAfMode", "Lw/c;", "o", "Lw/c;", "lastAwbMode", "Landroidx/camera/camera2/impl/UseCaseCameraState$a;", "p", "Landroidx/camera/camera2/impl/UseCaseCameraState$a;", "requestListener", "q", "pendingSignalCount", "camera-camera2"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes.dex */
public final class UseCaseCameraState {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    public final J useCaseGraphContext;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    public final E templateParamsOverride;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    public final Object lock;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    public InterfaceC1083u<t> updateSignal;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    public final Oa.c submittedRequestCounter;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    public C1165m<RequestSignal> updateSignals;

    /* renamed from: g, reason: collision with root package name and from kotlin metadata */
    public boolean updating;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    public final Map<CaptureRequest.Key<?>, Object> currentParameters;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    public final Map<q.a<?>, Object> currentInternalParameters;

    /* renamed from: j, reason: collision with root package name and from kotlin metadata */
    public final Set<Q> currentStreams;

    /* renamed from: k, reason: collision with root package name and from kotlin metadata */
    public final Set<t.a> currentListeners;

    /* renamed from: l, reason: collision with root package name and from kotlin metadata */
    public M currentTemplate;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    public C5695a lastAeMode;

    /* renamed from: n, reason: collision with root package name and from kotlin metadata */
    public C5696b lastAfMode;

    /* renamed from: o, reason: collision with root package name and from kotlin metadata */
    public C5697c lastAwbMode;

    /* renamed from: p, reason: collision with root package name and from kotlin metadata */
    public final a requestListener;

    /* renamed from: q, reason: collision with root package name and from kotlin metadata */
    public final Oa.c pendingSignalCount;

    @Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0003\n\u0002\b\u0004\b\u0086\u0004\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J'\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\bH\u0016¢\u0006\u0004\b\u000b\u0010\fJ'\u0010\u000f\u001a\u00020\n2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u000e\u001a\u00020\rH\u0016¢\u0006\u0004\b\u000f\u0010\u0010J#\u0010\u0011\u001a\u00020\n2\u0006\u0010\u0005\u001a\u00020\u00042\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\rH\u0002¢\u0006\u0004\b\u0011\u0010\u0012J!\u0010\u0017\u001a\u00020\n*\b\u0012\u0004\u0012\u00020\u00140\u00132\u0006\u0010\u0016\u001a\u00020\u0015H\u0002¢\u0006\u0004\b\u0017\u0010\u0018J)\u0010\u001b\u001a\u00020\n*\b\u0012\u0004\u0012\u00020\u00140\u00132\u0006\u0010\u0016\u001a\u00020\u00152\u0006\u0010\u001a\u001a\u00020\u0019H\u0002¢\u0006\u0004\b\u001b\u0010\u001c¨\u0006\u001d"}, d2 = {"Landroidx/camera/camera2/impl/UseCaseCameraState$a;", "Landroidx/camera/camera2/pipe/t$a;", "<init>", "(Landroidx/camera/camera2/impl/UseCaseCameraState;)V", "Lw/K;", "requestMetadata", "Lw/y;", "frameNumber", "Lw/w;", "totalCaptureResult", "LY8/t;", "N0", "(Lw/K;JLw/w;)V", "Lw/J;", "requestFailure", "Y", "(Lw/K;JLw/J;)V", Const.INTENT_KEY_UMID, "(Lw/K;Lw/J;)V", "LZ8/m;", "Landroidx/camera/camera2/impl/UseCaseCameraState$b;", "", "requestNo", Const.INTENT_KEY_APIKEY, "(LZ8/m;I)V", "", "throwable", "c", "(LZ8/m;ILjava/lang/Throwable;)V", "camera-camera2"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public final class a implements t.a {
        public a() {
        }

        @Override // androidx.camera.camera2.pipe.t.a
        public void N0(K requestMetadata, long frameNumber, w totalCaptureResult) {
            Integer num;
            p.i(requestMetadata, "requestMetadata");
            p.i(totalCaptureResult, "totalCaptureResult");
            if (UseCaseCameraState.this.pendingSignalCount.getValue() == 0 || (num = (Integer) requestMetadata.a(f0.b())) == null) {
                return;
            }
            UseCaseCameraState useCaseCameraState = UseCaseCameraState.this;
            int iIntValue = num.intValue();
            synchronized (useCaseCameraState.lock) {
                a(useCaseCameraState.updateSignals, iIntValue);
                Y8.t tVar = Y8.t.f7040a;
            }
        }

        @Override // androidx.camera.camera2.pipe.t.a
        public void Y(K requestMetadata, long frameNumber, w.J requestFailure) {
            p.i(requestMetadata, "requestMetadata");
            p.i(requestFailure, "requestFailure");
            if (UseCaseCameraState.this.pendingSignalCount.getValue() == 0) {
                return;
            }
            d(requestMetadata, requestFailure);
        }

        public final void a(C1165m<RequestSignal> c1165m, int i10) {
            while (!c1165m.isEmpty() && c1165m.first().getRequestNo() <= i10) {
                c1165m.first().b().complete(Y8.t.f7040a);
                A.M(c1165m);
                UseCaseCameraState.this.pendingSignalCount.b();
            }
        }

        public final void c(C1165m<RequestSignal> c1165m, int i10, Throwable th) {
            while (!c1165m.isEmpty() && c1165m.first().getRequestNo() <= i10) {
                c1165m.first().b().e(th);
                A.M(c1165m);
                UseCaseCameraState.this.pendingSignalCount.b();
            }
        }

        public final void d(K requestMetadata, w.J requestFailure) {
            String str;
            Integer num = (Integer) requestMetadata.a(f0.b());
            if (num != null) {
                UseCaseCameraState useCaseCameraState = UseCaseCameraState.this;
                int iIntValue = num.intValue();
                synchronized (useCaseCameraState.lock) {
                    try {
                        C1165m<RequestSignal> c1165m = useCaseCameraState.updateSignals;
                        StringBuilder sb2 = new StringBuilder();
                        sb2.append("Failed in framework level");
                        if (requestFailure != null) {
                            str = " with CaptureFailure.reason = " + requestFailure.getReason();
                            if (str == null) {
                                str = "";
                            }
                        } else {
                            str = "";
                        }
                        sb2.append(str);
                        c(c1165m, iIntValue, new Throwable(sb2.toString()));
                        Y8.t tVar = Y8.t.f7040a;
                    } catch (Throwable th) {
                        throw th;
                    }
                }
            }
        }
    }

    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\b\b\u0086\b\u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004¢\u0006\u0004\b\u0007\u0010\bJ\u0010\u0010\n\u001a\u00020\tHÖ\u0001¢\u0006\u0004\b\n\u0010\u000bJ\u0010\u0010\f\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\f\u0010\rJ\u001a\u0010\u0010\u001a\u00020\u000f2\b\u0010\u000e\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u0010\u0010\u0011R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0012\u0010\u0013\u001a\u0004\b\u0012\u0010\rR\u001d\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u00048\u0006¢\u0006\f\n\u0004\b\u0014\u0010\u0015\u001a\u0004\b\u0014\u0010\u0016¨\u0006\u0017"}, d2 = {"Landroidx/camera/camera2/impl/UseCaseCameraState$b;", "", "", "requestNo", "LUa/u;", "LY8/t;", "signal", "<init>", "(ILUa/u;)V", "", "toString", "()Ljava/lang/String;", "hashCode", "()I", "other", "", "equals", "(Ljava/lang/Object;)Z", Const.INTENT_KEY_APIKEY, "I", Const.INTENT_KEY_PKGNAME, "LUa/u;", "()LUa/u;", "camera-camera2"}, k = 1, mv = {2, 1, 0}, xi = 48)
    /* renamed from: androidx.camera.camera2.impl.UseCaseCameraState$b, reason: from toString */
    public static final /* data */ class RequestSignal {

        /* renamed from: a, reason: collision with root package name and from kotlin metadata and from toString */
        public final int requestNo;

        /* renamed from: b, reason: collision with root package name and from kotlin metadata and from toString */
        public final InterfaceC1083u<Y8.t> signal;

        public RequestSignal(int i10, InterfaceC1083u<Y8.t> signal) {
            p.i(signal, "signal");
            this.requestNo = i10;
            this.signal = signal;
        }

        /* renamed from: a, reason: from getter */
        public final int getRequestNo() {
            return this.requestNo;
        }

        public final InterfaceC1083u<Y8.t> b() {
            return this.signal;
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof RequestSignal)) {
                return false;
            }
            RequestSignal requestSignal = (RequestSignal) other;
            return this.requestNo == requestSignal.requestNo && p.d(this.signal, requestSignal.signal);
        }

        public int hashCode() {
            return (Integer.hashCode(this.requestNo) * 31) + this.signal.hashCode();
        }

        public String toString() {
            return "RequestSignal(requestNo=" + this.requestNo + ", signal=" + this.signal + ')';
        }
    }

    public UseCaseCameraState(J useCaseGraphContext, E templateParamsOverride) {
        p.i(useCaseGraphContext, "useCaseGraphContext");
        p.i(templateParamsOverride, "templateParamsOverride");
        this.useCaseGraphContext = useCaseGraphContext;
        this.templateParamsOverride = templateParamsOverride;
        this.lock = new Object();
        this.submittedRequestCounter = Oa.b.c(0);
        this.updateSignals = new C1165m<>();
        this.currentParameters = new LinkedHashMap();
        this.currentInternalParameters = new LinkedHashMap();
        this.currentStreams = new LinkedHashSet();
        this.currentListeners = new LinkedHashSet();
        this.requestListener = new a();
        this.pendingSignalCount = Oa.b.c(0);
    }

    public final void e() {
        synchronized (this.lock) {
            try {
                if (this.updating) {
                    this.updating = false;
                    InterfaceC1083u<Y8.t> interfaceC1083u = this.updateSignal;
                    if (interfaceC1083u != null) {
                        interfaceC1083u.e(new CancellationException("UseCaseCameraState closed"));
                    }
                    this.updateSignal = null;
                }
                while (!this.updateSignals.isEmpty()) {
                    this.updateSignals.removeFirst().b().e(new CancellationException("UseCaseCameraState closed"));
                    this.pendingSignalCount.b();
                }
                Y8.t tVar = Y8.t.f7040a;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public final Integer f(Map<CaptureRequest.Key<?>, ? extends Object> map, CaptureRequest.Key<?> key) {
        Object obj = map != null ? map.get(key) : null;
        if (obj instanceof Integer) {
            return (Integer) obj;
        }
        return null;
    }

    /* JADX WARN: Finally extract failed */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:65:0x0152  */
    /* JADX WARN: Removed duplicated region for block: B:77:0x0185  */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0017  */
    /* JADX WARN: Removed duplicated region for block: B:88:0x016d A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Type inference failed for: r0v10, types: [T, Ua.u<Y8.t>] */
    /* JADX WARN: Type inference failed for: r9v11, types: [T, androidx.camera.camera2.pipe.t] */
    /* JADX WARN: Type inference failed for: r9v12, types: [T, Ua.u<Y8.t>] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object g(e9.InterfaceC4014c<? super Y8.t> r19) throws java.lang.Exception {
        /*
            Method dump skipped, instructions count: 403
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.camera.camera2.impl.UseCaseCameraState.g(e9.c):java.lang.Object");
    }

    public final Object h(InterfaceC4014c<? super Y8.t> interfaceC4014c) throws Exception {
        Object objG = g(interfaceC4014c);
        return objG == C4063a.g() ? objG : Y8.t.f7040a;
    }

    public final void i(CameraGraph.f fVar, Map<CaptureRequest.Key<?>, ? extends Object> map) {
        CaptureRequest.Key<?> CONTROL_AE_MODE = CaptureRequest.CONTROL_AE_MODE;
        p.h(CONTROL_AE_MODE, "CONTROL_AE_MODE");
        Integer numF = f(map, CONTROL_AE_MODE);
        C5695a c5695aA = numF != null ? C5695a.INSTANCE.a(numF.intValue()) : null;
        CaptureRequest.Key<?> CONTROL_AF_MODE = CaptureRequest.CONTROL_AF_MODE;
        p.h(CONTROL_AF_MODE, "CONTROL_AF_MODE");
        Integer numF2 = f(map, CONTROL_AF_MODE);
        C5696b c5696bA = numF2 != null ? C5696b.INSTANCE.a(numF2.intValue()) : null;
        CaptureRequest.Key<?> CONTROL_AWB_MODE = CaptureRequest.CONTROL_AWB_MODE;
        p.h(CONTROL_AWB_MODE, "CONTROL_AWB_MODE");
        Integer numF3 = f(map, CONTROL_AWB_MODE);
        C5697c c5697cA = numF3 != null ? C5697c.INSTANCE.a(numF3.intValue()) : null;
        boolean z10 = false;
        boolean z11 = (c5695aA == null || p.d(c5695aA, this.lastAeMode)) ? false : true;
        boolean z12 = (c5696bA == null || p.d(c5696bA, this.lastAfMode)) ? false : true;
        if (c5697cA != null && !p.d(c5697cA, this.lastAwbMode)) {
            z10 = true;
        }
        if (z11 || z12 || z10) {
            C5473b c5473b = C5473b.f41865a;
            if (C0761b0.f("CXCP")) {
                Log.d(C5473b.TRUNCATED_TAG, "UseCaseCameraState: Updating 3A modes: AE(" + c5695aA + ", changed=" + z11 + "), AF(" + c5696bA + ", changed=" + z12 + "), AWB(" + c5697cA + ", changed=" + z10 + ')');
            }
            InterfaceC5704j.g(fVar, c5695aA, c5696bA, c5697cA, null, null, null, 56, null);
            if (c5695aA != null) {
                this.lastAeMode = c5695aA;
            }
            if (c5696bA != null) {
                this.lastAfMode = c5696bA;
            }
            if (c5697cA != null) {
                this.lastAwbMode = c5697cA;
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /* JADX WARN: Type inference failed for: r8v3, types: [T, Ua.u<Y8.t>, java.lang.Object] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object j(java.util.Map<android.hardware.camera2.CaptureRequest.Key<?>, ? extends java.lang.Object> r8, boolean r9, java.util.Map<androidx.camera.camera2.pipe.q.a<?>, ? extends java.lang.Object> r10, boolean r11, java.util.Set<w.Q> r12, w.M r13, java.util.Set<? extends androidx.camera.camera2.pipe.t.a> r14, e9.InterfaceC4014c<? super Ua.Q<Y8.t>> r15) throws java.lang.Throwable {
        /*
            Method dump skipped, instructions count: 237
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.camera.camera2.impl.UseCaseCameraState.j(java.util.Map, boolean, java.util.Map, boolean, java.util.Set, w.M, java.util.Set, e9.c):java.lang.Object");
    }
}
