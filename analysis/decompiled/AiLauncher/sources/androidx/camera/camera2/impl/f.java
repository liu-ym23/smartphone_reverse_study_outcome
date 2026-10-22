package androidx.camera.camera2.impl;

import D.C0761b0;
import M.n;
import Ua.C1087w;
import Ua.InterfaceC1083u;
import Ua.Q;
import Y8.t;
import android.os.Build;
import android.util.Log;
import android.view.AbstractC1404w;
import android.view.y;
import androidx.camera.camera2.adapter.CoroutineAdaptersKt;
import androidx.camera.camera2.pipe.g;
import androidx.camera.core.CameraControl$OperationCanceledException;
import com.autonavi.aps.amapapi.config.Const;
import com.stepos.statsapp.v3.lib.plugin.constants.UxipConstants;
import java.util.LinkedHashMap;
import kotlin.Metadata;
import kotlin.jvm.internal.i;
import kotlin.jvm.internal.p;
import p.C5023e;
import p9.InterfaceC5074l;
import r.C5192j;
import t.C5473b;
import t.InterfaceC5494v;
import t.j0;
import t.y0;
import w.C5695a;
import w.Result3A;

@Metadata(d1 = {"\u0000h\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0011\n\u0002\u0018\u0002\n\u0002\b\u001f\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0007\u0018\u00002\u00020\u0001:\u0001.B!\b\u0007\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\u0006\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\b\u0010\tJ\u000f\u0010\u000b\u001a\u00020\nH\u0002¢\u0006\u0004\b\u000b\u0010\fJ+\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\n0\r*\b\u0012\u0004\u0012\u00020\n0\r2\n\u0010\u0010\u001a\u00060\u000ej\u0002`\u000fH\u0002¢\u0006\u0004\b\u0011\u0010\u0012J!\u0010\u0016\u001a\u00020\n*\b\u0012\u0004\u0012\u00020\u00140\u00132\u0006\u0010\u0015\u001a\u00020\u0014H\u0002¢\u0006\u0004\b\u0016\u0010\u0017J\u000f\u0010\u0018\u001a\u00020\nH\u0016¢\u0006\u0004\b\u0018\u0010\fJ/\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020\n0\u001d2\u0006\u0010\u001a\u001a\u00020\u00192\b\b\u0002\u0010\u001b\u001a\u00020\u00192\b\b\u0002\u0010\u001c\u001a\u00020\u0019¢\u0006\u0004\b\u001e\u0010\u001fJ1\u0010\"\u001a\b\u0012\u0004\u0012\u00020\n0\u001d2\u0006\u0010!\u001a\u00020 2\b\b\u0002\u0010\u001b\u001a\u00020\u00192\b\b\u0002\u0010\u001c\u001a\u00020\u0019H\u0000¢\u0006\u0004\b\"\u0010#J\u001d\u0010%\u001a\b\u0012\u0004\u0012\u00020\n0\u001d2\u0006\u0010$\u001a\u00020\u0014H\u0002¢\u0006\u0004\b%\u0010&J\u000f\u0010'\u001a\u00020\nH\u0002¢\u0006\u0004\b'\u0010\fJ\u000f\u0010(\u001a\u00020\nH\u0002¢\u0006\u0004\b(\u0010\fJ\u0017\u0010)\u001a\u00020\n2\u0006\u0010!\u001a\u00020 H\u0002¢\u0006\u0004\b)\u0010*J\u0017\u0010,\u001a\u00020\u00192\u0006\u0010+\u001a\u00020 H\u0002¢\u0006\u0004\b,\u0010-R\u0014\u0010\u0005\u001a\u00020\u00048\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b.\u0010/R\u0014\u0010\u0007\u001a\u00020\u00068\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b0\u00101R\u0018\u00105\u001a\u0004\u0018\u0001028\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b3\u00104R\u0014\u00108\u001a\u00020\u00198\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b6\u00107R*\u0010?\u001a\u0004\u0018\u00010 8\u0000@\u0000X\u0081\u000e¢\u0006\u0018\n\u0004\b\u0011\u00109\u0012\u0004\b>\u0010\f\u001a\u0004\b:\u0010;\"\u0004\b<\u0010=R\"\u0010C\u001a\u0010\u0012\f\u0012\n @*\u0004\u0018\u00010\u00140\u00140\u00138\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bA\u0010BR\u0014\u0010E\u001a\u00020\u00198\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bD\u00107R\u0014\u0010H\u001a\u00020\u00148\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bF\u0010GR\u0014\u0010I\u001a\u00020\u00148\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b,\u0010GR\"\u0010J\u001a\u0010\u0012\f\u0012\n @*\u0004\u0018\u00010\u00140\u00140\u00138\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0016\u0010BR\u001e\u0010L\u001a\n\u0012\u0004\u0012\u00020\n\u0018\u00010\r8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u001e\u0010KR\u001e\u0010N\u001a\n\u0012\u0004\u0012\u00020\n\u0018\u00010\r8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bM\u0010KR(\u0010Q\u001a\u0004\u0018\u0001022\b\u0010\u0015\u001a\u0004\u0018\u0001028V@VX\u0096\u000e¢\u0006\f\u001a\u0004\bA\u0010O\"\u0004\b0\u0010PR\u0017\u0010T\u001a\b\u0012\u0004\u0012\u00020\u00140R8F¢\u0006\u0006\u001a\u0004\bD\u0010SR\u0017\u0010U\u001a\b\u0012\u0004\u0012\u00020\u00140R8F¢\u0006\u0006\u001a\u0004\bF\u0010S¨\u0006V"}, d2 = {"Landroidx/camera/camera2/impl/f;", "Lt/j0;", "Lt/v;", "cameraProperties", "Landroidx/camera/camera2/impl/State3AControl;", "state3AControl", "Lt/y0;", "threads", "<init>", "(Lt/v;Landroidx/camera/camera2/impl/State3AControl;Lt/y0;)V", "LY8/t;", "p", "()V", "LUa/u;", "Ljava/lang/Exception;", "Lkotlin/Exception;", "exception", "e", "(LUa/u;Ljava/lang/Exception;)LUa/u;", "Landroidx/lifecycle/y;", "", UxipConstants.f30680s, Const.INTENT_KEY_BACKGROUND_NOTIFICATION_REMOVE, "(Landroidx/lifecycle/y;I)V", "reset", "", "torch", "cancelPreviousTask", "ignoreFlashUnitAvailability", "LUa/Q;", "k", "(ZZZ)LUa/Q;", "Landroidx/camera/camera2/impl/f$a;", "mode", "m", "(IZZ)LUa/Q;", "level", "t", "(I)LUa/Q;", "q", "r", "s", "(I)V", "torchState", Const.INTENT_KEY_BACKGROUND_NOTIFICATION_ID, "(I)Z", Const.INTENT_KEY_APIKEY, "Landroidx/camera/camera2/impl/State3AControl;", Const.INTENT_KEY_PKGNAME, "Lt/y0;", "Landroidx/camera/camera2/impl/UseCaseCameraRequestControl;", "c", "Landroidx/camera/camera2/impl/UseCaseCameraRequestControl;", "_requestControl", Const.INTENT_KEY_UMID, "Z", "hasFlashUnit", "Landroidx/camera/camera2/impl/f$a;", "getTorchMode-MnUA4hI$camera_camera2", "()Landroidx/camera/camera2/impl/f$a;", "setTorchMode-UuNXre8$camera_camera2", "(Landroidx/camera/camera2/impl/f$a;)V", "getTorchMode-MnUA4hI$camera_camera2$annotations", "torchMode", "kotlin.jvm.PlatformType", "f", "Landroidx/lifecycle/y;", "_torchState", Const.INTENT_KEY_BACKGROUND_COMMAND, "isTorchStrengthSupported", Const.INTENT_KEY_BACKGROUND_NOTIFICATION, "I", "defaultTorchStrength", "maxTorchStrength", "_torchStrength", "LUa/u;", "_updateTorchStateSignal", "l", "_updateTorchStrengthSignal", "()Landroidx/camera/camera2/impl/UseCaseCameraRequestControl;", "(Landroidx/camera/camera2/impl/UseCaseCameraRequestControl;)V", "requestControl", "Landroidx/lifecycle/w;", "()Landroidx/lifecycle/w;", "torchStateLiveData", "torchStrengthLiveData", "camera-camera2"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes.dex */
public final class f implements j0 {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    public final State3AControl state3AControl;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    public final y0 threads;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    public UseCaseCameraRequestControl _requestControl;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    public final boolean hasFlashUnit;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    public a torchMode;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    public final y<Integer> _torchState;

    /* renamed from: g, reason: collision with root package name and from kotlin metadata */
    public final boolean isTorchStrengthSupported;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    public final int defaultTorchStrength;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    public final int maxTorchStrength;

    /* renamed from: j, reason: collision with root package name and from kotlin metadata */
    public final y<Integer> _torchStrength;

    /* renamed from: k, reason: collision with root package name and from kotlin metadata */
    public InterfaceC1083u<t> _updateTorchStateSignal;

    /* renamed from: l, reason: collision with root package name and from kotlin metadata */
    public InterfaceC1083u<t> _updateTorchStrengthSignal;

    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\b\b\u0081@\u0018\u0000 \u00122\u00020\u0001:\u0001\u000eB\u0011\b\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\u0010\u0010\u0007\u001a\u00020\u0006HÖ\u0001¢\u0006\u0004\b\u0007\u0010\bJ\u0010\u0010\t\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\t\u0010\u0005J\u001a\u0010\f\u001a\u00020\u000b2\b\u0010\n\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\f\u0010\rR\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u000e\u0010\u000f\u001a\u0004\b\u0010\u0010\u0011\u0088\u0001\u0003\u0092\u0001\u00020\u0002¨\u0006\u0013"}, d2 = {"Landroidx/camera/camera2/impl/f$a;", "", "", UxipConstants.f30680s, "e", "(I)I", "", Const.INTENT_KEY_BACKGROUND_NOTIFICATION_ID, "(I)Ljava/lang/String;", Const.INTENT_KEY_BACKGROUND_NOTIFICATION, "other", "", "f", "(ILjava/lang/Object;)Z", Const.INTENT_KEY_APIKEY, "I", "getValue", "()I", Const.INTENT_KEY_PKGNAME, "camera-camera2"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class a {

        /* renamed from: b, reason: collision with root package name and from kotlin metadata */
        public static final Companion INSTANCE = new Companion(null);

        /* renamed from: c, reason: collision with root package name */
        public static final int f10096c = e(0);

        /* renamed from: d, reason: collision with root package name */
        public static final int f10097d = e(1);

        /* renamed from: e, reason: collision with root package name */
        public static final int f10098e = e(2);

        /* renamed from: a, reason: collision with root package name and from kotlin metadata */
        public final int value;

        @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\t\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u0017\u0010\u0005\u001a\u00020\u00048\u0006¢\u0006\f\n\u0004\b\u0005\u0010\u0006\u001a\u0004\b\u0007\u0010\bR\u0017\u0010\t\u001a\u00020\u00048\u0006¢\u0006\f\n\u0004\b\t\u0010\u0006\u001a\u0004\b\n\u0010\bR\u0017\u0010\u000b\u001a\u00020\u00048\u0006¢\u0006\f\n\u0004\b\u000b\u0010\u0006\u001a\u0004\b\f\u0010\b¨\u0006\r"}, d2 = {"Landroidx/camera/camera2/impl/f$a$a;", "", "<init>", "()V", "Landroidx/camera/camera2/impl/f$a;", "OFF", "I", Const.INTENT_KEY_APIKEY, "()I", "ON", Const.INTENT_KEY_PKGNAME, "USED_AS_FLASH", "c", "camera-camera2"}, k = 1, mv = {2, 1, 0}, xi = 48)
        /* renamed from: androidx.camera.camera2.impl.f$a$a, reason: collision with other inner class name and from kotlin metadata */
        public static final class Companion {
            public /* synthetic */ Companion(i iVar) {
                this();
            }

            public final int a() {
                return a.f10096c;
            }

            public final int b() {
                return a.f10097d;
            }

            public final int c() {
                return a.f10098e;
            }

            public Companion() {
            }
        }

        public /* synthetic */ a(int i10) {
            this.value = i10;
        }

        public static final /* synthetic */ a d(int i10) {
            return new a(i10);
        }

        public static int e(int i10) {
            return i10;
        }

        public static boolean f(int i10, Object obj) {
            return (obj instanceof a) && i10 == ((a) obj).getValue();
        }

        public static final boolean g(int i10, int i11) {
            return i10 == i11;
        }

        public static int h(int i10) {
            return Integer.hashCode(i10);
        }

        public static String i(int i10) {
            return "TorchMode(value=" + i10 + ')';
        }

        public boolean equals(Object obj) {
            return f(this.value, obj);
        }

        public int hashCode() {
            return h(this.value);
        }

        /* renamed from: j, reason: from getter */
        public final /* synthetic */ int getValue() {
            return this.value;
        }

        public String toString() {
            return i(this.value);
        }
    }

    public f(InterfaceC5494v cameraProperties, State3AControl state3AControl, y0 threads) {
        p.i(cameraProperties, "cameraProperties");
        p.i(state3AControl, "state3AControl");
        p.i(threads, "threads");
        this.state3AControl = state3AControl;
        this.threads = threads;
        this.hasFlashUnit = C5192j.b(cameraProperties, false, 1, null);
        this._torchState = new y<>(0);
        g.Companion companion = androidx.camera.camera2.pipe.g.INSTANCE;
        this.isTorchStrengthSupported = companion.i(cameraProperties.getMetadata());
        int iC = companion.c(cameraProperties.getMetadata());
        this.defaultTorchStrength = iC;
        this.maxTorchStrength = companion.d(cameraProperties.getMetadata());
        this._torchStrength = new y<>(Integer.valueOf(iC));
    }

    private final InterfaceC1083u<t> e(InterfaceC1083u<t> interfaceC1083u, Exception exc) {
        interfaceC1083u.e(exc);
        return interfaceC1083u;
    }

    private final void j(y<Integer> yVar, int i10) {
        if (n.d()) {
            yVar.k(Integer.valueOf(i10));
        } else {
            yVar.i(Integer.valueOf(i10));
        }
    }

    public static /* synthetic */ Q l(f fVar, boolean z10, boolean z11, boolean z12, int i10, Object obj) {
        if ((i10 & 2) != 0) {
            z11 = true;
        }
        if ((i10 & 4) != 0) {
            z12 = false;
        }
        return fVar.k(z10, z11, z12);
    }

    public static /* synthetic */ Q n(f fVar, int i10, boolean z10, boolean z11, int i11, Object obj) {
        if ((i11 & 2) != 0) {
            z10 = true;
        }
        if ((i11 & 4) != 0) {
            z11 = false;
        }
        return fVar.m(i10, z10, z11);
    }

    public static final t o(Result3A it) {
        p.i(it, "it");
        return t.f7040a;
    }

    private final void p() {
        q();
        r();
    }

    public static final t u(f fVar, Throwable th) {
        fVar._updateTorchStrengthSignal = null;
        return t.f7040a;
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x001c  */
    @Override // t.j0
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void b(androidx.camera.camera2.impl.UseCaseCameraRequestControl r8) {
        /*
            r7 = this;
            r7._requestControl = r8
            androidx.camera.camera2.impl.f$a r8 = r7.torchMode
            if (r8 == 0) goto L26
            androidx.lifecycle.w r8 = r7.g()
            java.lang.Object r8 = r8.e()
            java.lang.Integer r8 = (java.lang.Integer) r8
            if (r8 != 0) goto L13
            goto L1c
        L13:
            int r8 = r8.intValue()
            r0 = 1
            if (r8 != r0) goto L1c
        L1a:
            r2 = r0
            goto L1e
        L1c:
            r0 = 0
            goto L1a
        L1e:
            r5 = 4
            r6 = 0
            r3 = 0
            r4 = 0
            r1 = r7
            l(r1, r2, r3, r4, r5, r6)
        L26:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.camera.camera2.impl.f.b(androidx.camera.camera2.impl.UseCaseCameraRequestControl):void");
    }

    /* renamed from: f, reason: from getter */
    public UseCaseCameraRequestControl get_requestControl() {
        return this._requestControl;
    }

    public final AbstractC1404w<Integer> g() {
        return this._torchState;
    }

    public final AbstractC1404w<Integer> h() {
        return this._torchStrength;
    }

    public final boolean i(int torchState) {
        return !a.g(torchState, a.INSTANCE.a());
    }

    public final Q<t> k(boolean torch, boolean cancelPreviousTask, boolean ignoreFlashUnitAvailability) {
        return m(torch ? a.INSTANCE.b() : a.INSTANCE.a(), cancelPreviousTask, ignoreFlashUnitAvailability);
    }

    public final Q<t> m(int mode, boolean cancelPreviousTask, boolean ignoreFlashUnitAvailability) {
        int iC;
        Q<Result3A> qJ;
        C5473b c5473b = C5473b.f41865a;
        if (C0761b0.f("CXCP")) {
            Log.d(C5473b.TRUNCATED_TAG, "TorchControl#setTorchAsync: torch mode = " + ((Object) a.i(mode)));
        }
        InterfaceC1083u<t> interfaceC1083uC = C1087w.c(null, 1, null);
        if (!ignoreFlashUnitAvailability && !this.hasFlashUnit) {
            return e(interfaceC1083uC, new IllegalStateException("No flash unit"));
        }
        UseCaseCameraRequestControl useCaseCameraRequestControl = get_requestControl();
        if (useCaseCameraRequestControl == null) {
            e(interfaceC1083uC, new CameraControl$OperationCanceledException("Camera is not active."));
            return interfaceC1083uC;
        }
        s(mode);
        if (cancelPreviousTask) {
            q();
        } else {
            InterfaceC1083u<t> interfaceC1083u = this._updateTorchStateSignal;
            if (interfaceC1083u != null) {
                CoroutineAdaptersKt.s(interfaceC1083uC, interfaceC1083u);
            }
        }
        this._updateTorchStateSignal = interfaceC1083uC;
        this.state3AControl.s(i(mode) ? 1 : null);
        C5695a.Companion companion = C5695a.INSTANCE;
        C5695a c5695aA = companion.a(this.state3AControl.p());
        if (c5695aA != null) {
            iC = c5695aA.getValue();
        } else {
            if (C0761b0.k("CXCP")) {
                Log.w(C5473b.TRUNCATED_TAG, "TorchControl#setTorchAsync: Failed to convert ae mode of value " + this.state3AControl.p() + " with AeMode.fromIntOrNull, fallback to AeMode.ON");
            }
            iC = companion.c();
        }
        if (i(mode)) {
            if (a.g(mode, a.INSTANCE.b())) {
                Integer numE = h().e();
                if (numE != null) {
                    t(numE.intValue());
                }
            } else {
                t(this.defaultTorchStrength);
            }
            qJ = useCaseCameraRequestControl.g();
        } else {
            qJ = useCaseCameraRequestControl.j(iC);
        }
        CoroutineAdaptersKt.t(qJ, interfaceC1083uC, new InterfaceC5074l() { // from class: t.g0
            @Override // p9.InterfaceC5074l
            public final Object invoke(Object obj) {
                return androidx.camera.camera2.impl.f.o((Result3A) obj);
            }
        });
        return interfaceC1083uC;
    }

    public final void q() {
        InterfaceC1083u<t> interfaceC1083u = this._updateTorchStateSignal;
        if (interfaceC1083u != null) {
            e(interfaceC1083u, new CameraControl$OperationCanceledException("There is a new enableTorch being set"));
        }
        this._updateTorchStateSignal = null;
    }

    public final void r() {
        InterfaceC1083u<t> interfaceC1083u = this._updateTorchStrengthSignal;
        if (interfaceC1083u != null) {
            e(interfaceC1083u, new CameraControl$OperationCanceledException("There is a new torch strength being set"));
        }
        this._updateTorchStrengthSignal = null;
    }

    @Override // t.j0
    public void reset() {
        p();
        if (this.torchMode != null) {
            s(a.INSTANCE.a());
            l(this, false, false, false, 6, null);
            this.torchMode = null;
        }
    }

    public final void s(int mode) {
        this.torchMode = a.d(mode);
        j(this._torchState, a.g(mode, a.INSTANCE.b()) ? 1 : 0);
    }

    public final Q<t> t(int level) {
        Q qD;
        InterfaceC1083u<t> interfaceC1083uC = C1087w.c(null, 1, null);
        if (Build.VERSION.SDK_INT < 35 || !this.isTorchStrengthSupported) {
            e(interfaceC1083uC, new UnsupportedOperationException("Configuring torch strength is not supported on the device."));
            return interfaceC1083uC;
        }
        if (this._updateTorchStrengthSignal != null) {
            r();
        }
        this._updateTorchStrengthSignal = interfaceC1083uC;
        interfaceC1083uC.J(new InterfaceC5074l() { // from class: t.h0
            @Override // p9.InterfaceC5074l
            public final Object invoke(Object obj) {
                return androidx.camera.camera2.impl.f.u(this.f41897a, (Throwable) obj);
            }
        });
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        C5023e.a(linkedHashMap, level);
        UseCaseCameraRequestControl useCaseCameraRequestControl = get_requestControl();
        if (useCaseCameraRequestControl == null || (qD = UseCaseCameraRequestControl.d(useCaseCameraRequestControl, linkedHashMap, null, null, 6, null)) == null) {
            e(interfaceC1083uC, new CameraControl$OperationCanceledException("Camera is not active."));
            return interfaceC1083uC;
        }
        CoroutineAdaptersKt.s(qD, interfaceC1083uC);
        t tVar = t.f7040a;
        return interfaceC1083uC;
    }
}
