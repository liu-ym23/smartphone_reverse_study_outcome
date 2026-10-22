package androidx.camera.camera2.impl;

import D.C0761b0;
import Ua.C1087w;
import Ua.InterfaceC1083u;
import Ua.Q;
import Y8.t;
import android.util.Log;
import androidx.camera.camera2.adapter.CoroutineAdaptersKt;
import androidx.camera.camera2.impl.FlashControl;
import androidx.camera.camera2.impl.f;
import androidx.camera.core.CameraControl$OperationCanceledException;
import androidx.camera.core.ImageCapture;
import com.autonavi.aps.amapapi.config.Const;
import com.stepos.statsapp.v3.lib.plugin.constants.UxipConstants;
import kotlin.Metadata;
import kotlin.jvm.internal.p;
import p9.InterfaceC5074l;
import r.H;
import t.C5473b;
import t.C5492t;
import t.InterfaceC5494v;
import t.j0;
import t.y0;

@Metadata(d1 = {"\u0000d\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\t\n\u0002\b\u0010\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0002\b\t\b\u0007\u0018\u00002\u00020\u0001B1\b\u0007\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\u0006\u0010\u0007\u001a\u00020\u0006\u0012\u0006\u0010\t\u001a\u00020\b\u0012\u0006\u0010\u000b\u001a\u00020\n¢\u0006\u0004\b\f\u0010\rJ\u000f\u0010\u000f\u001a\u00020\u000eH\u0016¢\u0006\u0004\b\u000f\u0010\u0010J%\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u000e0\u00152\u0006\u0010\u0012\u001a\u00020\u00112\b\b\u0002\u0010\u0014\u001a\u00020\u0013¢\u0006\u0004\b\u0016\u0010\u0017J\u0017\u0010\u001a\u001a\u00020\u000e2\b\u0010\u0019\u001a\u0004\u0018\u00010\u0018¢\u0006\u0004\b\u001a\u0010\u001bJ\u0010\u0010\u001c\u001a\u00020\u000eH\u0086@¢\u0006\u0004\b\u001c\u0010\u001dJ\u0010\u0010\u001e\u001a\u00020\u000eH\u0086@¢\u0006\u0004\b\u001e\u0010\u001dJ\u0010\u0010\u001f\u001a\u00020\u0011H\u0086@¢\u0006\u0004\b\u001f\u0010\u001dJ\u000f\u0010 \u001a\u00020\u000eH\u0002¢\u0006\u0004\b \u0010\u0010J\u001e\u0010#\u001a\b\u0012\u0004\u0012\u00020\u000e0\u00152\u0006\u0010\"\u001a\u00020!H\u0082@¢\u0006\u0004\b#\u0010$J\u0017\u0010%\u001a\n\u0012\u0004\u0012\u00020\u000e\u0018\u00010\u0015H\u0002¢\u0006\u0004\b%\u0010&J\u0017\u0010'\u001a\n\u0012\u0004\u0012\u00020\u000e\u0018\u00010\u0015H\u0002¢\u0006\u0004\b'\u0010&R\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b(\u0010)R\u0014\u0010\u0005\u001a\u00020\u00048\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b*\u0010+R\u0014\u0010\u0007\u001a\u00020\u00068\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b,\u0010-R\u0014\u0010\t\u001a\u00020\b8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b.\u0010/R\u0014\u0010\u000b\u001a\u00020\n8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b0\u00101R\u0018\u00104\u001a\u0004\u0018\u0001028\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b#\u00103R\u001c\u00108\u001a\u00020\u00118\u0002@\u0002X\u0082\u000e¢\u0006\f\n\u0004\b5\u00106\u0012\u0004\b7\u0010\u0010R*\u0010\u0012\u001a\u00020\u00112\u0006\u00109\u001a\u00020\u00118F@BX\u0086\u000e¢\u0006\u0012\n\u0004\b\u001f\u00106\u0012\u0004\b<\u0010\u0010\u001a\u0004\b:\u0010;R\u0018\u0010>\u001a\u0004\u0018\u00010\u00188\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b:\u0010=R(\u0010\u0019\u001a\u0004\u0018\u00010\u00182\b\u00109\u001a\u0004\u0018\u00010\u00188F@BX\u0086\u000e¢\u0006\f\n\u0004\b?\u0010=\u001a\u0004\b@\u0010AR\u001e\u0010D\u001a\n\u0012\u0004\u0012\u00020\u000e\u0018\u00010B8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b@\u0010CR0\u0010G\u001a\b\u0012\u0004\u0012\u00020\u000e0\u00152\f\u00109\u001a\b\u0012\u0004\u0012\u00020\u000e0\u00158F@BX\u0086\u000e¢\u0006\f\n\u0004\bE\u0010F\u001a\u0004\bE\u0010&R(\u0010J\u001a\u0004\u0018\u0001022\b\u00109\u001a\u0004\u0018\u0001028V@VX\u0096\u000e¢\u0006\f\u001a\u0004\b?\u0010H\"\u0004\b*\u0010I¨\u0006K"}, d2 = {"Landroidx/camera/camera2/impl/FlashControl;", "Lt/j0;", "Lt/v;", "cameraProperties", "Landroidx/camera/camera2/impl/State3AControl;", "state3AControl", "Lt/y0;", "threads", "Landroidx/camera/camera2/impl/f;", "torchControl", "Lr/H;", "useFlashModeTorchFor3aUpdate", "<init>", "(Lt/v;Landroidx/camera/camera2/impl/State3AControl;Lt/y0;Landroidx/camera/camera2/impl/f;Lr/H;)V", "LY8/t;", "reset", "()V", "", "flashMode", "", "cancelPreviousTask", "LUa/Q;", "o", "(IZ)LUa/Q;", "Landroidx/camera/core/ImageCapture$h;", "screenFlash", "q", "(Landroidx/camera/core/ImageCapture$h;)V", "t", "(Le9/c;)Ljava/lang/Object;", "v", Const.INTENT_KEY_BACKGROUND_NOTIFICATION, "u", "", "timeoutMillis", "f", "(JLe9/c;)Ljava/lang/Object;", "m", "()LUa/Q;", "r", Const.INTENT_KEY_APIKEY, "Lt/v;", Const.INTENT_KEY_PKGNAME, "Landroidx/camera/camera2/impl/State3AControl;", "c", "Lt/y0;", Const.INTENT_KEY_UMID, "Landroidx/camera/camera2/impl/f;", "e", "Lr/H;", "Landroidx/camera/camera2/impl/UseCaseCameraRequestControl;", "Landroidx/camera/camera2/impl/UseCaseCameraRequestControl;", "_requestControl", Const.INTENT_KEY_BACKGROUND_COMMAND, "I", "get_flashMode$annotations", "_flashMode", UxipConstants.f30680s, Const.INTENT_KEY_BACKGROUND_NOTIFICATION_ID, "()I", "getFlashMode$annotations", "Landroidx/camera/core/ImageCapture$h;", "_screenFlash", Const.INTENT_KEY_BACKGROUND_NOTIFICATION_REMOVE, "k", "()Landroidx/camera/core/ImageCapture$h;", "LUa/u;", "LUa/u;", "_updateSignal", "l", "LUa/Q;", "updateSignal", "()Landroidx/camera/camera2/impl/UseCaseCameraRequestControl;", "(Landroidx/camera/camera2/impl/UseCaseCameraRequestControl;)V", "requestControl", "camera-camera2"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes.dex */
public final class FlashControl implements j0 {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    public final InterfaceC5494v cameraProperties;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    public final State3AControl state3AControl;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    public final y0 threads;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    public final f torchControl;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    public final H useFlashModeTorchFor3aUpdate;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    public UseCaseCameraRequestControl _requestControl;

    /* renamed from: g, reason: collision with root package name and from kotlin metadata */
    public volatile int _flashMode;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    public int flashMode;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    public volatile ImageCapture.h _screenFlash;

    /* renamed from: j, reason: collision with root package name and from kotlin metadata */
    public ImageCapture.h screenFlash;

    /* renamed from: k, reason: collision with root package name and from kotlin metadata */
    public InterfaceC1083u<t> _updateSignal;

    /* renamed from: l, reason: collision with root package name and from kotlin metadata */
    public Q<t> updateSignal;

    public FlashControl(InterfaceC5494v cameraProperties, State3AControl state3AControl, y0 threads, f torchControl, H useFlashModeTorchFor3aUpdate) {
        p.i(cameraProperties, "cameraProperties");
        p.i(state3AControl, "state3AControl");
        p.i(threads, "threads");
        p.i(torchControl, "torchControl");
        p.i(useFlashModeTorchFor3aUpdate, "useFlashModeTorchFor3aUpdate");
        this.cameraProperties = cameraProperties;
        this.state3AControl = state3AControl;
        this.threads = threads;
        this.torchControl = torchControl;
        this.useFlashModeTorchFor3aUpdate = useFlashModeTorchFor3aUpdate;
        this._flashMode = 2;
        this.flashMode = this._flashMode;
        this.screenFlash = this._screenFlash;
        this.updateSignal = C1087w.a(t.f7040a);
    }

    public static final void g(InterfaceC1083u interfaceC1083u) {
        interfaceC1083u.complete(t.f7040a);
    }

    public static final t n(Throwable th) {
        C5473b c5473b = C5473b.f41865a;
        if (C0761b0.f("CXCP")) {
            Log.d(C5473b.TRUNCATED_TAG, "setExternalFlashAeModeAsync: state3AControl.updateSignal completed");
        }
        return t.f7040a;
    }

    public static /* synthetic */ Q p(FlashControl flashControl, int i10, boolean z10, int i11, Object obj) {
        if ((i11 & 2) != 0) {
            z10 = true;
        }
        return flashControl.o(i10, z10);
    }

    public static final t s(Throwable th) {
        C5473b c5473b = C5473b.f41865a;
        if (C0761b0.f("CXCP")) {
            Log.d(C5473b.TRUNCATED_TAG, "setTorchIfRequired: torch control completed");
        }
        return t.f7040a;
    }

    @Override // t.j0
    public void b(UseCaseCameraRequestControl useCaseCameraRequestControl) {
        this._requestControl = useCaseCameraRequestControl;
        o(this._flashMode, false);
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object f(long r12, e9.InterfaceC4014c<? super Ua.Q<Y8.t>> r14) throws java.lang.Throwable {
        /*
            r11 = this;
            boolean r0 = r14 instanceof androidx.camera.camera2.impl.FlashControl$applyScreenFlash$1
            if (r0 == 0) goto L13
            r0 = r14
            androidx.camera.camera2.impl.FlashControl$applyScreenFlash$1 r0 = (androidx.camera.camera2.impl.FlashControl$applyScreenFlash$1) r0
            int r1 = r0.f9773e
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.f9773e = r1
            goto L18
        L13:
            androidx.camera.camera2.impl.FlashControl$applyScreenFlash$1 r0 = new androidx.camera.camera2.impl.FlashControl$applyScreenFlash$1
            r0.<init>(r11, r14)
        L18:
            java.lang.Object r14 = r0.f9771c
            java.lang.Object r1 = f9.C4063a.g()
            int r2 = r0.f9773e
            r3 = 0
            r4 = 1
            if (r2 == 0) goto L39
            if (r2 != r4) goto L31
            long r12 = r0.f9769a
            java.lang.Object r0 = r0.f9770b
            Ua.u r0 = (Ua.InterfaceC1083u) r0
            kotlin.C4849c.b(r14)
            r8 = r11
            goto L60
        L31:
            java.lang.IllegalStateException r11 = new java.lang.IllegalStateException
            java.lang.String r12 = "call to 'resume' before 'invoke' with coroutine"
            r11.<init>(r12)
            throw r11
        L39:
            kotlin.C4849c.b(r14)
            Ua.u r14 = Ua.C1087w.c(r3, r4, r3)
            t.U r9 = new t.U
            r9.<init>()
            Ua.A0 r2 = Ua.Y.c()
            androidx.camera.camera2.impl.FlashControl$applyScreenFlash$2 r5 = new androidx.camera.camera2.impl.FlashControl$applyScreenFlash$2
            r10 = 0
            r8 = r11
            r6 = r12
            r5.<init>(r6, r8, r9, r10)
            r0.f9770b = r14
            r0.f9769a = r6
            r0.f9773e = r4
            java.lang.Object r11 = Ua.C1056g.j(r2, r5, r0)
            if (r11 != r1) goto L5e
            return r1
        L5e:
            r0 = r14
            r12 = r6
        L60:
            t.y0 r11 = r8.threads
            Ua.M r4 = r11.getScope()
            androidx.camera.camera2.impl.FlashControl$applyScreenFlash$3 r7 = new androidx.camera.camera2.impl.FlashControl$applyScreenFlash$3
            r7.<init>(r0, r12, r3)
            r8 = 3
            r9 = 0
            r5 = 0
            r6 = 0
            Ua.Q r11 = Ua.C1056g.b(r4, r5, r6, r7, r8, r9)
            return r11
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.camera.camera2.impl.FlashControl.f(long, e9.c):java.lang.Object");
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object h(e9.InterfaceC4014c<? super java.lang.Integer> r6) throws java.lang.Throwable {
        /*
            r5 = this;
            boolean r0 = r6 instanceof androidx.camera.camera2.impl.FlashControl$awaitFlashModeUpdate$1
            if (r0 == 0) goto L13
            r0 = r6
            androidx.camera.camera2.impl.FlashControl$awaitFlashModeUpdate$1 r0 = (androidx.camera.camera2.impl.FlashControl$awaitFlashModeUpdate$1) r0
            int r1 = r0.f9784d
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.f9784d = r1
            goto L18
        L13:
            androidx.camera.camera2.impl.FlashControl$awaitFlashModeUpdate$1 r0 = new androidx.camera.camera2.impl.FlashControl$awaitFlashModeUpdate$1
            r0.<init>(r5, r6)
        L18:
            java.lang.Object r6 = r0.f9782b
            java.lang.Object r1 = f9.C4063a.g()
            int r2 = r0.f9784d
            java.lang.String r3 = "CXCP"
            r4 = 1
            if (r2 == 0) goto L35
            if (r2 != r4) goto L2d
            int r5 = r0.f9781a
            kotlin.C4849c.b(r6)
            goto L5d
        L2d:
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
            java.lang.String r6 = "call to 'resume' before 'invoke' with coroutine"
            r5.<init>(r6)
            throw r5
        L35:
            kotlin.C4849c.b(r6)
            t.b r6 = t.C5473b.f41865a
            boolean r6 = D.C0761b0.f(r3)
            if (r6 == 0) goto L49
            java.lang.String r6 = t.C5473b.a()
            java.lang.String r2 = "FlashControl: Waiting for any ongoing update to be completed"
            android.util.Log.d(r6, r2)
        L49:
            int r6 = r5.get_flashMode()
            Ua.Q r5 = r5.l()
            r0.f9781a = r6
            r0.f9784d = r4
            java.lang.Object r5 = r5.T0(r0)
            if (r5 != r1) goto L5c
            return r1
        L5c:
            r5 = r6
        L5d:
            t.b r6 = t.C5473b.f41865a
            boolean r6 = D.C0761b0.f(r3)
            if (r6 == 0) goto L7d
            java.lang.String r6 = t.C5473b.a()
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.lang.String r1 = "awaitFlashModeUpdate: initialFlashMode = "
            r0.append(r1)
            r0.append(r5)
            java.lang.String r0 = r0.toString()
            android.util.Log.d(r6, r0)
        L7d:
            java.lang.Integer r5 = g9.C4109a.f(r5)
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.camera.camera2.impl.FlashControl.h(e9.c):java.lang.Object");
    }

    /* renamed from: i, reason: from getter */
    public final int get_flashMode() {
        return this._flashMode;
    }

    /* renamed from: j, reason: from getter */
    public UseCaseCameraRequestControl get_requestControl() {
        return this._requestControl;
    }

    /* renamed from: k, reason: from getter */
    public final ImageCapture.h get_screenFlash() {
        return this._screenFlash;
    }

    public final Q<t> l() {
        InterfaceC1083u<t> interfaceC1083u = this._updateSignal;
        if (interfaceC1083u == null) {
            return C1087w.a(t.f7040a);
        }
        p.f(interfaceC1083u);
        return interfaceC1083u;
    }

    public final Q<t> m() {
        boolean zH = C5492t.h(this.cameraProperties.getMetadata());
        C5473b c5473b = C5473b.f41865a;
        if (C0761b0.f("CXCP")) {
            Log.d(C5473b.TRUNCATED_TAG, "setExternalFlashAeModeAsync: isExternalFlashAeModeSupported = " + zH);
        }
        if (!zH) {
            return null;
        }
        Q<t> qU = this.state3AControl.u(true);
        if (C0761b0.f("CXCP")) {
            Log.d(C5473b.TRUNCATED_TAG, "setExternalFlashAeModeAsync: need to wait for state3AControl.updateSignal");
        }
        qU.J(new InterfaceC5074l() { // from class: t.V
            @Override // p9.InterfaceC5074l
            public final Object invoke(Object obj) {
                return FlashControl.n((Throwable) obj);
            }
        });
        return qU;
    }

    public final Q<t> o(int flashMode, boolean cancelPreviousTask) {
        C5473b c5473b = C5473b.f41865a;
        if (C0761b0.f("CXCP")) {
            Log.d(C5473b.TRUNCATED_TAG, "setFlashAsync: flashMode = " + flashMode + ", requestControl = " + get_requestControl());
        }
        InterfaceC1083u<t> interfaceC1083uC = C1087w.c(null, 1, null);
        if (get_requestControl() == null) {
            interfaceC1083uC.e(new CameraControl$OperationCanceledException("Camera is not active."));
            return interfaceC1083uC;
        }
        this._flashMode = flashMode;
        if (cancelPreviousTask) {
            u();
        } else {
            InterfaceC1083u<t> interfaceC1083u = this._updateSignal;
            if (interfaceC1083u != null) {
                CoroutineAdaptersKt.s(interfaceC1083uC, interfaceC1083u);
            }
        }
        this._updateSignal = interfaceC1083uC;
        CoroutineAdaptersKt.s(this.state3AControl.r(flashMode), interfaceC1083uC);
        return interfaceC1083uC;
    }

    public final void q(ImageCapture.h screenFlash) {
        this._screenFlash = screenFlash;
    }

    public final Q<t> r() {
        boolean zA = this.useFlashModeTorchFor3aUpdate.a();
        C5473b c5473b = C5473b.f41865a;
        if (C0761b0.f("CXCP")) {
            Log.d(C5473b.TRUNCATED_TAG, "setTorchIfRequired: shouldUseFlashModeTorch = " + zA);
        }
        if (!zA) {
            return null;
        }
        Q<t> qN = f.n(this.torchControl, f.a.INSTANCE.c(), false, true, 2, null);
        if (C0761b0.f("CXCP")) {
            Log.d(C5473b.TRUNCATED_TAG, "setTorchIfRequired: need to wait for torch control to be completed");
        }
        qN.J(new InterfaceC5074l() { // from class: t.T
            @Override // p9.InterfaceC5074l
            public final Object invoke(Object obj) {
                return FlashControl.s((Throwable) obj);
            }
        });
        return qN;
    }

    @Override // t.j0
    public void reset() {
        this._flashMode = 2;
        this._screenFlash = null;
        u();
        p(this, 2, false, 2, null);
    }

    /* JADX WARN: Code restructure failed: missing block: B:27:0x0088, code lost:
    
        if (kotlinx.coroutines.AwaitKt.a(r4, r0) == r1) goto L28;
     */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object t(e9.InterfaceC4014c<? super Y8.t> r8) throws java.lang.Throwable {
        /*
            r7 = this;
            boolean r0 = r8 instanceof androidx.camera.camera2.impl.FlashControl$startScreenFlashCaptureTasks$1
            if (r0 == 0) goto L13
            r0 = r8
            androidx.camera.camera2.impl.FlashControl$startScreenFlashCaptureTasks$1 r0 = (androidx.camera.camera2.impl.FlashControl$startScreenFlashCaptureTasks$1) r0
            int r1 = r0.f9789e
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.f9789e = r1
            goto L18
        L13:
            androidx.camera.camera2.impl.FlashControl$startScreenFlashCaptureTasks$1 r0 = new androidx.camera.camera2.impl.FlashControl$startScreenFlashCaptureTasks$1
            r0.<init>(r7, r8)
        L18:
            java.lang.Object r8 = r0.f9787c
            java.lang.Object r1 = f9.C4063a.g()
            int r2 = r0.f9789e
            r3 = 2
            r4 = 1
            if (r2 == 0) goto L40
            if (r2 == r4) goto L34
            if (r2 != r3) goto L2c
            kotlin.C4849c.b(r8)
            goto L8b
        L2c:
            java.lang.IllegalStateException r7 = new java.lang.IllegalStateException
            java.lang.String r8 = "call to 'resume' before 'invoke' with coroutine"
            r7.<init>(r8)
            throw r7
        L34:
            java.lang.Object r2 = r0.f9786b
            java.util.List r2 = (java.util.List) r2
            java.lang.Object r4 = r0.f9785a
            java.util.List r4 = (java.util.List) r4
            kotlin.C4849c.b(r8)
            goto L5e
        L40:
            kotlin.C4849c.b(r8)
            java.util.ArrayList r2 = new java.util.ArrayList
            r2.<init>()
            java.util.concurrent.TimeUnit r8 = java.util.concurrent.TimeUnit.SECONDS
            r5 = 3
            long r5 = r8.toMillis(r5)
            r0.f9785a = r2
            r0.f9786b = r2
            r0.f9789e = r4
            java.lang.Object r8 = r7.f(r5, r0)
            if (r8 != r1) goto L5d
            goto L8a
        L5d:
            r4 = r2
        L5e:
            r2.add(r8)
            Ua.Q r8 = r7.m()
            if (r8 == 0) goto L6e
            boolean r8 = r4.add(r8)
            g9.C4109a.a(r8)
        L6e:
            Ua.Q r7 = r7.r()
            if (r7 == 0) goto L7b
            boolean r7 = r4.add(r7)
            g9.C4109a.a(r7)
        L7b:
            java.util.Collection r4 = (java.util.Collection) r4
            r7 = 0
            r0.f9785a = r7
            r0.f9786b = r7
            r0.f9789e = r3
            java.lang.Object r7 = kotlinx.coroutines.AwaitKt.a(r4, r0)
            if (r7 != r1) goto L8b
        L8a:
            return r1
        L8b:
            Y8.t r7 = Y8.t.f7040a
            return r7
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.camera.camera2.impl.FlashControl.t(e9.c):java.lang.Object");
    }

    public final void u() {
        InterfaceC1083u<t> interfaceC1083u = this._updateSignal;
        if (interfaceC1083u != null) {
            interfaceC1083u.e(new CameraControl$OperationCanceledException("There is a new flash mode being set or camera was closed"));
        }
        this._updateSignal = null;
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object v(e9.InterfaceC4014c<? super Y8.t> r7) throws java.lang.Throwable {
        /*
            r6 = this;
            boolean r0 = r7 instanceof androidx.camera.camera2.impl.FlashControl$stopScreenFlashCaptureTasks$1
            if (r0 == 0) goto L13
            r0 = r7
            androidx.camera.camera2.impl.FlashControl$stopScreenFlashCaptureTasks$1 r0 = (androidx.camera.camera2.impl.FlashControl$stopScreenFlashCaptureTasks$1) r0
            int r1 = r0.f9792c
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.f9792c = r1
            goto L18
        L13:
            androidx.camera.camera2.impl.FlashControl$stopScreenFlashCaptureTasks$1 r0 = new androidx.camera.camera2.impl.FlashControl$stopScreenFlashCaptureTasks$1
            r0.<init>(r6, r7)
        L18:
            java.lang.Object r7 = r0.f9790a
            java.lang.Object r1 = f9.C4063a.g()
            int r2 = r0.f9792c
            r3 = 1
            if (r2 == 0) goto L31
            if (r2 != r3) goto L29
            kotlin.C4849c.b(r7)
            goto L47
        L29:
            java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
            java.lang.String r7 = "call to 'resume' before 'invoke' with coroutine"
            r6.<init>(r7)
            throw r6
        L31:
            kotlin.C4849c.b(r7)
            Ua.A0 r7 = Ua.Y.c()
            androidx.camera.camera2.impl.FlashControl$stopScreenFlashCaptureTasks$2 r2 = new androidx.camera.camera2.impl.FlashControl$stopScreenFlashCaptureTasks$2
            r4 = 0
            r2.<init>(r6, r4)
            r0.f9792c = r3
            java.lang.Object r7 = Ua.C1056g.j(r7, r2, r0)
            if (r7 != r1) goto L47
            return r1
        L47:
            t.v r7 = r6.cameraProperties
            androidx.camera.camera2.pipe.g r7 = r7.getMetadata()
            boolean r7 = t.C5492t.h(r7)
            if (r7 == 0) goto L59
            androidx.camera.camera2.impl.State3AControl r7 = r6.state3AControl
            r0 = 0
            r7.u(r0)
        L59:
            r.H r7 = r6.useFlashModeTorchFor3aUpdate
            boolean r7 = r7.a()
            if (r7 == 0) goto L70
            androidx.camera.camera2.impl.f r0 = r6.torchControl
            androidx.camera.camera2.impl.f$a$a r6 = androidx.camera.camera2.impl.f.a.INSTANCE
            int r1 = r6.a()
            r4 = 2
            r5 = 0
            r2 = 0
            r3 = 1
            androidx.camera.camera2.impl.f.n(r0, r1, r2, r3, r4, r5)
        L70:
            Y8.t r6 = Y8.t.f7040a
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.camera.camera2.impl.FlashControl.v(e9.c):java.lang.Object");
    }
}
