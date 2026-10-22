package androidx.camera.camera2.impl;

import D.C0761b0;
import M.n;
import Ua.C1060i;
import Ua.C1087w;
import Ua.InterfaceC1083u;
import Ua.Q;
import Y8.t;
import android.hardware.camera2.CaptureResult;
import android.os.Build;
import android.util.Log;
import android.view.y;
import androidx.camera.camera2.pipe.t;
import androidx.camera.core.CameraControl$OperationCanceledException;
import androidx.camera.core.UseCase;
import androidx.camera.core.impl.SessionConfig;
import com.autonavi.aps.amapapi.config.Const;
import com.stepos.ailauncher.chat.voicewakeup.VoiceWakeupReceiver;
import com.stepos.statsapp.v3.lib.plugin.constants.UxipConstants;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import kotlin.Metadata;
import kotlin.jvm.internal.p;
import p9.InterfaceC5074l;
import t.C5473b;
import t.N;
import t.j0;
import t.y0;
import w.K;
import w.w;
import w.x;

@Metadata(d1 = {"\u0000~\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u001e\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0014\b\u0007\u0018\u00002\u00020\u0001B+\b\u0007\u0012\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\u0006\u0010\u0007\u001a\u00020\u0006\u0012\u0006\u0010\t\u001a\u00020\b¢\u0006\u0004\b\n\u0010\u000bJ\u000f\u0010\r\u001a\u00020\fH\u0016¢\u0006\u0004\b\r\u0010\u000eJ\u001b\u0010\u0012\u001a\u00020\f2\f\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00100\u000f¢\u0006\u0004\b\u0012\u0010\u0013J%\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\f0\u00172\u0006\u0010\u0015\u001a\u00020\u00142\b\b\u0002\u0010\u0016\u001a\u00020\u0014¢\u0006\u0004\b\u0018\u0010\u0019J\u0019\u0010\u001c\u001a\u00020\u001b*\b\u0012\u0004\u0012\u00020\u00100\u001aH\u0002¢\u0006\u0004\b\u001c\u0010\u001dJ\u000f\u0010\u001e\u001a\u00020\fH\u0002¢\u0006\u0004\b\u001e\u0010\u000eJ+\u0010#\u001a\b\u0012\u0004\u0012\u00020\f0\u001f*\b\u0012\u0004\u0012\u00020\f0\u001f2\n\u0010\"\u001a\u00060 j\u0002`!H\u0002¢\u0006\u0004\b#\u0010$J!\u0010(\u001a\u00020\f*\b\u0012\u0004\u0012\u00020&0%2\u0006\u0010'\u001a\u00020&H\u0002¢\u0006\u0004\b(\u0010)R\u0016\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b*\u0010+R\u0014\u0010\u0005\u001a\u00020\u00048\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b,\u0010-R\u0014\u0010\u0007\u001a\u00020\u00068\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b.\u0010/R\u0014\u0010\t\u001a\u00020\b8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b0\u00101R\u0018\u00105\u001a\u0004\u0018\u0001028\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b3\u00104R\u0014\u00108\u001a\u00020\u00148\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b6\u00107R\u0016\u0010:\u001a\u00020\u00148\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b9\u00107R\"\u0010>\u001a\u0010\u0012\f\u0012\n ;*\u0004\u0018\u00010&0&0%8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b<\u0010=R\u0014\u0010B\u001a\u00020?8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b@\u0010AR\u001e\u0010E\u001a\n\u0012\u0004\u0012\u00020\f\u0018\u00010\u001f8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bC\u0010DR0\u0010M\u001a\n\u0012\u0004\u0012\u00020\u0014\u0018\u00010\u00178\u0000@\u0000X\u0081\u000e¢\u0006\u0018\n\u0004\bF\u0010G\u0012\u0004\bL\u0010\u000e\u001a\u0004\bH\u0010I\"\u0004\bJ\u0010KR(\u0010R\u001a\u0004\u0018\u0001022\b\u0010N\u001a\u0004\u0018\u0001028V@VX\u0096\u000e¢\u0006\f\u001a\u0004\bO\u0010P\"\u0004\b,\u0010Q¨\u0006S"}, d2 = {"Landroidx/camera/camera2/impl/LowLightBoostControl;", "Lt/j0;", "Landroidx/camera/camera2/pipe/g;", "cameraMetadata", "Landroidx/camera/camera2/impl/State3AControl;", "state3AControl", "Lt/y0;", "threads", "Lt/N;", "comboRequestListener", "<init>", "(Landroidx/camera/camera2/pipe/g;Landroidx/camera/camera2/impl/State3AControl;Lt/y0;Lt/N;)V", "LY8/t;", "reset", "()V", "", "Landroidx/camera/core/UseCase;", "useCases", "q", "(Ljava/util/List;)V", "", "lowLightBoost", "cancelPreviousTask", "LUa/Q;", "s", "(ZZ)LUa/Q;", "", "Landroidx/camera/core/impl/SessionConfig;", "p", "(Ljava/util/Collection;)Landroidx/camera/core/impl/SessionConfig;", "u", "LUa/u;", "Ljava/lang/Exception;", "Lkotlin/Exception;", "exception", "m", "(LUa/u;Ljava/lang/Exception;)LUa/u;", "Landroidx/lifecycle/y;", "", VoiceWakeupReceiver.EXTRA_STATE, "r", "(Landroidx/lifecycle/y;I)V", Const.INTENT_KEY_APIKEY, "Landroidx/camera/camera2/pipe/g;", Const.INTENT_KEY_PKGNAME, "Landroidx/camera/camera2/impl/State3AControl;", "c", "Lt/y0;", Const.INTENT_KEY_UMID, "Lt/N;", "Landroidx/camera/camera2/impl/UseCaseCameraRequestControl;", "e", "Landroidx/camera/camera2/impl/UseCaseCameraRequestControl;", "_requestControl", "f", "Z", "isLowLightBoostSupported", Const.INTENT_KEY_BACKGROUND_COMMAND, "isLowLightBoostOn", "kotlin.jvm.PlatformType", Const.INTENT_KEY_BACKGROUND_NOTIFICATION, "Landroidx/lifecycle/y;", "_lowLightBoostState", "Ljava/util/concurrent/atomic/AtomicInteger;", Const.INTENT_KEY_BACKGROUND_NOTIFICATION_ID, "Ljava/util/concurrent/atomic/AtomicInteger;", "lowLightBoostStateAtomic", Const.INTENT_KEY_BACKGROUND_NOTIFICATION_REMOVE, "LUa/u;", "_updateSignal", "k", "LUa/Q;", "n", "()LUa/Q;", "setCheckFrameRateJob$camera_camera2", "(LUa/Q;)V", "getCheckFrameRateJob$camera_camera2$annotations", "checkFrameRateJob", UxipConstants.f30680s, "o", "()Landroidx/camera/camera2/impl/UseCaseCameraRequestControl;", "(Landroidx/camera/camera2/impl/UseCaseCameraRequestControl;)V", "requestControl", "camera-camera2"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes.dex */
public final class LowLightBoostControl implements j0 {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    public final androidx.camera.camera2.pipe.g cameraMetadata;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    public final State3AControl state3AControl;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    public final y0 threads;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    public final N comboRequestListener;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    public UseCaseCameraRequestControl _requestControl;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    public final boolean isLowLightBoostSupported;

    /* renamed from: g, reason: collision with root package name and from kotlin metadata */
    public boolean isLowLightBoostOn;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    public final y<Integer> _lowLightBoostState;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    public final AtomicInteger lowLightBoostStateAtomic;

    /* renamed from: j, reason: collision with root package name and from kotlin metadata */
    public InterfaceC1083u<t> _updateSignal;

    /* renamed from: k, reason: collision with root package name and from kotlin metadata */
    public Q<Boolean> checkFrameRateJob;

    @Metadata(d1 = {"\u0000#\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J'\u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\t\u0010\n¨\u0006\u000b"}, d2 = {"androidx/camera/camera2/impl/LowLightBoostControl$a", "Landroidx/camera/camera2/pipe/t$a;", "Lw/K;", "requestMetadata", "Lw/y;", "frameNumber", "Lw/w;", "totalCaptureResult", "LY8/t;", "N0", "(Lw/K;JLw/w;)V", "camera-camera2"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class a implements t.a {
        public a() {
        }

        @Override // androidx.camera.camera2.pipe.t.a
        public void N0(K requestMetadata, long frameNumber, w totalCaptureResult) {
            p.i(requestMetadata, "requestMetadata");
            p.i(totalCaptureResult, "totalCaptureResult");
            if (Build.VERSION.SDK_INT < 35 || LowLightBoostControl.this._requestControl == null || !LowLightBoostControl.this.isLowLightBoostOn) {
                return;
            }
            x metadata = totalCaptureResult.getMetadata();
            CaptureResult.Key CONTROL_LOW_LIGHT_BOOST_STATE = CaptureResult.CONTROL_LOW_LIGHT_BOOST_STATE;
            p.h(CONTROL_LOW_LIGHT_BOOST_STATE, "CONTROL_LOW_LIGHT_BOOST_STATE");
            Integer num = (Integer) metadata.U(CONTROL_LOW_LIGHT_BOOST_STATE);
            if (num != null) {
                LowLightBoostControl lowLightBoostControl = LowLightBoostControl.this;
                lowLightBoostControl.r(lowLightBoostControl._lowLightBoostState, num.intValue() != 1 ? 0 : 1);
            }
        }
    }

    @Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
    public static final class b implements InterfaceC5074l<Throwable, Y8.t> {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ InterfaceC1083u<Y8.t> f9812a;

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ LowLightBoostControl f9813b;

        public b(InterfaceC1083u<Y8.t> interfaceC1083u, LowLightBoostControl lowLightBoostControl) {
            this.f9812a = interfaceC1083u;
            this.f9813b = lowLightBoostControl;
        }

        public final void a(Throwable th) {
            if (p.d(this.f9812a, this.f9813b._updateSignal)) {
                this.f9813b._updateSignal = null;
            }
        }

        @Override // p9.InterfaceC5074l
        public /* bridge */ /* synthetic */ Y8.t invoke(Throwable th) {
            a(th);
            return Y8.t.f7040a;
        }
    }

    public LowLightBoostControl(androidx.camera.camera2.pipe.g gVar, State3AControl state3AControl, y0 threads, N comboRequestListener) {
        p.i(state3AControl, "state3AControl");
        p.i(threads, "threads");
        p.i(comboRequestListener, "comboRequestListener");
        this.cameraMetadata = gVar;
        this.state3AControl = state3AControl;
        this.threads = threads;
        this.comboRequestListener = comboRequestListener;
        boolean z10 = false;
        if (gVar != null && androidx.camera.camera2.pipe.g.INSTANCE.f(gVar)) {
            z10 = true;
        }
        this.isLowLightBoostSupported = z10;
        this._lowLightBoostState = new y<>(-1);
        this.lowLightBoostStateAtomic = new AtomicInteger(-1);
        if (z10) {
            comboRequestListener.s(new a(), threads.getSequentialExecutor());
        }
    }

    public static /* synthetic */ Q t(LowLightBoostControl lowLightBoostControl, boolean z10, boolean z11, int i10, Object obj) {
        if ((i10 & 2) != 0) {
            z11 = true;
        }
        return lowLightBoostControl.s(z10, z11);
    }

    @Override // t.j0
    public void b(UseCaseCameraRequestControl useCaseCameraRequestControl) {
        this._requestControl = useCaseCameraRequestControl;
        if (this.isLowLightBoostOn) {
            if (useCaseCameraRequestControl != null) {
                s(true, false);
            } else {
                r(this._lowLightBoostState, 0);
            }
        }
    }

    public final InterfaceC1083u<Y8.t> m(InterfaceC1083u<Y8.t> interfaceC1083u, Exception exc) {
        interfaceC1083u.e(exc);
        return interfaceC1083u;
    }

    public final Q<Boolean> n() {
        return this.checkFrameRateJob;
    }

    /* renamed from: o, reason: from getter */
    public UseCaseCameraRequestControl get_requestControl() {
        return this._requestControl;
    }

    public final SessionConfig p(Collection<? extends UseCase> collection) {
        SessionConfig.g gVar = new SessionConfig.g();
        Iterator<T> it = collection.iterator();
        while (it.hasNext()) {
            gVar.b(((UseCase) it.next()).z());
        }
        SessionConfig sessionConfigC = gVar.c();
        p.h(sessionConfigC, "build(...)");
        return sessionConfigC;
    }

    public final void q(List<? extends UseCase> useCases) {
        p.i(useCases, "useCases");
        if (this.isLowLightBoostSupported) {
            if (useCases.isEmpty()) {
                this.checkFrameRateJob = C1087w.a(Boolean.FALSE);
            } else {
                this.checkFrameRateJob = C1060i.b(this.threads.getSequentialScope(), null, null, new LowLightBoostControl$onSessionConfigChanged$1(this, useCases, null), 3, null);
            }
        }
    }

    public final void r(y<Integer> yVar, int i10) {
        if (this.lowLightBoostStateAtomic.getAndSet(i10) != i10) {
            if (n.d()) {
                yVar.k(Integer.valueOf(i10));
            } else {
                yVar.i(Integer.valueOf(i10));
            }
        }
    }

    @Override // t.j0
    public void reset() {
        u();
        t(this, false, false, 2, null);
    }

    public final Q<Y8.t> s(boolean lowLightBoost, boolean cancelPreviousTask) {
        C5473b c5473b = C5473b.f41865a;
        if (C0761b0.f("CXCP")) {
            Log.d(C5473b.TRUNCATED_TAG, "LowLightBoostControl#setLowLightBoostAsync: lowLightBoost = " + lowLightBoost);
        }
        InterfaceC1083u<Y8.t> interfaceC1083uC = C1087w.c(null, 1, null);
        if (!this.isLowLightBoostSupported) {
            return m(interfaceC1083uC, new IllegalStateException("Low Light Boost is not supported!"));
        }
        C1060i.d(this.threads.getSequentialScope(), null, null, new LowLightBoostControl$setLowLightBoostAsync$$inlined$confineLaunch$1(null, this, interfaceC1083uC, lowLightBoost, cancelPreviousTask), 3, null);
        return interfaceC1083uC;
    }

    public final void u() {
        InterfaceC1083u<Y8.t> interfaceC1083u = this._updateSignal;
        if (interfaceC1083u != null) {
            m(interfaceC1083u, new CameraControl$OperationCanceledException("There is a new enableLowLightBoost being set"));
        }
        this._updateSignal = null;
    }
}
