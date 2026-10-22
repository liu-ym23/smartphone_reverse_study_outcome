package androidx.camera.camera2.impl;

import Ua.C1060i;
import Ua.C1087w;
import Ua.InterfaceC1083u;
import Ua.M;
import Ua.Q;
import Y8.t;
import androidx.camera.camera2.adapter.CoroutineAdaptersKt;
import androidx.camera.camera2.impl.StillCaptureRequestControl;
import androidx.camera.core.ImageCaptureException;
import androidx.camera.core.impl.l;
import com.autonavi.aps.amapapi.config.Const;
import com.stepos.statsapp.v3.lib.plugin.constants.UxipConstants;
import e9.InterfaceC4014c;
import eb.InterfaceC4021a;
import f9.C4063a;
import g3.InterfaceFutureC4095a;
import g9.C4109a;
import g9.InterfaceC4112d;
import java.util.LinkedList;
import java.util.List;
import kotlin.C4849c;
import kotlin.Metadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.internal.p;
import p9.InterfaceC5074l;
import t.j0;
import t.y0;

@Metadata(d1 = {"\u0000`\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\b\b\u0007\u0018\u00002\u00020\u0001:\u0001!B\u0019\b\u0007\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0006\u0010\u0007J\u000f\u0010\t\u001a\u00020\bH\u0016¢\u0006\u0004\b\t\u0010\nJ9\u0010\u0013\u001a\u0010\u0012\f\u0012\n\u0012\u0006\u0012\u0004\u0018\u00010\u00120\u000b0\u00112\f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\f0\u000b2\u0006\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0010\u001a\u00020\u000e¢\u0006\u0004\b\u0013\u0010\u0014J\u000f\u0010\u0015\u001a\u00020\bH\u0002¢\u0006\u0004\b\u0015\u0010\nJ.\u0010\u001b\u001a\u0010\u0012\f\u0012\n\u0012\u0006\u0012\u0004\u0018\u00010\u00120\u000b0\u001a2\u0006\u0010\u0017\u001a\u00020\u00162\u0006\u0010\u0019\u001a\u00020\u0018H\u0082@¢\u0006\u0004\b\u001b\u0010\u001cJ1\u0010\u001f\u001a\u00020\b*\u0010\u0012\f\u0012\n\u0012\u0006\u0012\u0004\u0018\u00010\u00120\u000b0\u001a2\u0006\u0010\u001d\u001a\u00020\u00162\u0006\u0010\u001e\u001a\u00020\u0018H\u0002¢\u0006\u0004\b\u001f\u0010 R\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b!\u0010\"R\u0014\u0010\u0005\u001a\u00020\u00048\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b#\u0010$R\u0014\u0010(\u001a\u00020%8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b&\u0010'R\u0018\u0010+\u001a\u0004\u0018\u00010\u00188\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b)\u0010*R\u001a\u0010/\u001a\b\u0012\u0004\u0012\u00020\u00160,8\u0002X\u0083\u0004¢\u0006\u0006\n\u0004\b-\u0010.R(\u0010\u0019\u001a\u0004\u0018\u00010\u00182\b\u00100\u001a\u0004\u0018\u00010\u00188V@VX\u0096\u000e¢\u0006\f\u001a\u0004\b1\u00102\"\u0004\b#\u00103¨\u00064"}, d2 = {"Landroidx/camera/camera2/impl/StillCaptureRequestControl;", "Lt/j0;", "Landroidx/camera/camera2/impl/FlashControl;", "flashControl", "Lt/y0;", "threads", "<init>", "(Landroidx/camera/camera2/impl/FlashControl;Lt/y0;)V", "LY8/t;", "reset", "()V", "", "Landroidx/camera/core/impl/l;", "captureConfigs", "", "captureMode", "flashType", "Lg3/a;", "Ljava/lang/Void;", Const.INTENT_KEY_BACKGROUND_NOTIFICATION, "(Ljava/util/List;II)Lg3/a;", "l", "Landroidx/camera/camera2/impl/StillCaptureRequestControl$a;", "request", "Landroidx/camera/camera2/impl/UseCaseCameraRequestControl;", "requestControl", "LUa/Q;", "k", "(Landroidx/camera/camera2/impl/StillCaptureRequestControl$a;Landroidx/camera/camera2/impl/UseCaseCameraRequestControl;Le9/c;)Ljava/lang/Object;", "submittedRequest", "currentRequestControl", Const.INTENT_KEY_BACKGROUND_NOTIFICATION_ID, "(LUa/Q;Landroidx/camera/camera2/impl/StillCaptureRequestControl$a;Landroidx/camera/camera2/impl/UseCaseCameraRequestControl;)V", Const.INTENT_KEY_APIKEY, "Landroidx/camera/camera2/impl/FlashControl;", Const.INTENT_KEY_PKGNAME, "Lt/y0;", "Leb/a;", "c", "Leb/a;", "mutex", Const.INTENT_KEY_UMID, "Landroidx/camera/camera2/impl/UseCaseCameraRequestControl;", "_requestControl", "Ljava/util/LinkedList;", "e", "Ljava/util/LinkedList;", "pendingRequests", UxipConstants.f30680s, Const.INTENT_KEY_BACKGROUND_COMMAND, "()Landroidx/camera/camera2/impl/UseCaseCameraRequestControl;", "(Landroidx/camera/camera2/impl/UseCaseCameraRequestControl;)V", "camera-camera2"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes.dex */
public final class StillCaptureRequestControl implements j0 {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    public final FlashControl flashControl;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    public final y0 threads;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    public final InterfaceC4021a mutex;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    public UseCaseCameraRequestControl _requestControl;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    public final LinkedList<CaptureRequest> pendingRequests;

    @Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\f\b\u0086\b\u0018\u00002\u00020\u0001B;\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\u0006\u0010\u0007\u001a\u00020\u0005\u0012\u0014\u0010\n\u001a\u0010\u0012\f\u0012\n\u0012\u0006\u0012\u0004\u0018\u00010\t0\u00020\b¢\u0006\u0004\b\u000b\u0010\fJ\u0010\u0010\u000e\u001a\u00020\rHÖ\u0001¢\u0006\u0004\b\u000e\u0010\u000fJ\u0010\u0010\u0010\u001a\u00020\u0005HÖ\u0001¢\u0006\u0004\b\u0010\u0010\u0011J\u001a\u0010\u0014\u001a\u00020\u00132\b\u0010\u0012\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u0014\u0010\u0015R\u001d\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u00028\u0006¢\u0006\f\n\u0004\b\u0016\u0010\u0017\u001a\u0004\b\u0016\u0010\u0018R\u0017\u0010\u0006\u001a\u00020\u00058\u0006¢\u0006\f\n\u0004\b\u0019\u0010\u001a\u001a\u0004\b\u0019\u0010\u0011R\u0017\u0010\u0007\u001a\u00020\u00058\u0006¢\u0006\f\n\u0004\b\u001b\u0010\u001a\u001a\u0004\b\u001b\u0010\u0011R%\u0010\n\u001a\u0010\u0012\f\u0012\n\u0012\u0006\u0012\u0004\u0018\u00010\t0\u00020\b8\u0006¢\u0006\f\n\u0004\b\u001c\u0010\u001d\u001a\u0004\b\u001c\u0010\u001e¨\u0006\u001f"}, d2 = {"Landroidx/camera/camera2/impl/StillCaptureRequestControl$a;", "", "", "Landroidx/camera/core/impl/l;", "captureConfigs", "", "captureMode", "flashType", "LUa/u;", "Ljava/lang/Void;", "result", "<init>", "(Ljava/util/List;IILUa/u;)V", "", "toString", "()Ljava/lang/String;", "hashCode", "()I", "other", "", "equals", "(Ljava/lang/Object;)Z", Const.INTENT_KEY_APIKEY, "Ljava/util/List;", "()Ljava/util/List;", Const.INTENT_KEY_PKGNAME, "I", "c", Const.INTENT_KEY_UMID, "LUa/u;", "()LUa/u;", "camera-camera2"}, k = 1, mv = {2, 1, 0}, xi = 48)
    /* renamed from: androidx.camera.camera2.impl.StillCaptureRequestControl$a, reason: from toString */
    public static final /* data */ class CaptureRequest {

        /* renamed from: a, reason: collision with root package name and from kotlin metadata and from toString */
        public final List<l> captureConfigs;

        /* renamed from: b, reason: collision with root package name and from kotlin metadata and from toString */
        public final int captureMode;

        /* renamed from: c, reason: collision with root package name and from kotlin metadata and from toString */
        public final int flashType;

        /* renamed from: d, reason: collision with root package name and from kotlin metadata and from toString */
        public final InterfaceC1083u<List<Void>> result;

        public CaptureRequest(List<l> captureConfigs, int i10, int i11, InterfaceC1083u<List<Void>> result) {
            p.i(captureConfigs, "captureConfigs");
            p.i(result, "result");
            this.captureConfigs = captureConfigs;
            this.captureMode = i10;
            this.flashType = i11;
            this.result = result;
        }

        public final List<l> a() {
            return this.captureConfigs;
        }

        /* renamed from: b, reason: from getter */
        public final int getCaptureMode() {
            return this.captureMode;
        }

        /* renamed from: c, reason: from getter */
        public final int getFlashType() {
            return this.flashType;
        }

        public final InterfaceC1083u<List<Void>> d() {
            return this.result;
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof CaptureRequest)) {
                return false;
            }
            CaptureRequest captureRequest = (CaptureRequest) other;
            return p.d(this.captureConfigs, captureRequest.captureConfigs) && this.captureMode == captureRequest.captureMode && this.flashType == captureRequest.flashType && p.d(this.result, captureRequest.result);
        }

        public int hashCode() {
            return (((((this.captureConfigs.hashCode() * 31) + Integer.hashCode(this.captureMode)) * 31) + Integer.hashCode(this.flashType)) * 31) + this.result.hashCode();
        }

        public String toString() {
            return "CaptureRequest(captureConfigs=" + this.captureConfigs + ", captureMode=" + this.captureMode + ", flashType=" + this.flashType + ", result=" + this.result + ')';
        }
    }

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"LUa/M;", "LY8/t;", "<anonymous>", "(LUa/M;)V"}, k = 3, mv = {2, 1, 0})
    @InterfaceC4112d(c = "androidx.camera.camera2.impl.StillCaptureRequestControl$reset$1", f = "StillCaptureRequestControl.kt", l = {222}, m = "invokeSuspend", v = 1)
    /* renamed from: androidx.camera.camera2.impl.StillCaptureRequestControl$reset$1, reason: invalid class name */
    public static final class AnonymousClass1 extends SuspendLambda implements p9.p<M, InterfaceC4014c<? super t>, Object> {

        /* renamed from: a, reason: collision with root package name */
        public Object f9866a;

        /* renamed from: b, reason: collision with root package name */
        public Object f9867b;

        /* renamed from: c, reason: collision with root package name */
        public int f9868c;

        public AnonymousClass1(InterfaceC4014c<? super AnonymousClass1> interfaceC4014c) {
            super(2, interfaceC4014c);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final InterfaceC4014c<t> create(Object obj, InterfaceC4014c<?> interfaceC4014c) {
            return StillCaptureRequestControl.this.new AnonymousClass1(interfaceC4014c);
        }

        @Override // p9.p
        public final Object invoke(M m10, InterfaceC4014c<? super t> interfaceC4014c) {
            return ((AnonymousClass1) create(m10, interfaceC4014c)).invokeSuspend(t.f7040a);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) throws Throwable {
            InterfaceC4021a interfaceC4021a;
            StillCaptureRequestControl stillCaptureRequestControl;
            InterfaceC1083u<List<Void>> interfaceC1083uD;
            Object objG = C4063a.g();
            int i10 = this.f9868c;
            if (i10 == 0) {
                C4849c.b(obj);
                InterfaceC4021a interfaceC4021a2 = StillCaptureRequestControl.this.mutex;
                StillCaptureRequestControl stillCaptureRequestControl2 = StillCaptureRequestControl.this;
                this.f9866a = interfaceC4021a2;
                this.f9867b = stillCaptureRequestControl2;
                this.f9868c = 1;
                if (interfaceC4021a2.m(null, this) == objG) {
                    return objG;
                }
                interfaceC4021a = interfaceC4021a2;
                stillCaptureRequestControl = stillCaptureRequestControl2;
            } else {
                if (i10 != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                stillCaptureRequestControl = (StillCaptureRequestControl) this.f9867b;
                interfaceC4021a = (InterfaceC4021a) this.f9866a;
                C4849c.b(obj);
            }
            while (!stillCaptureRequestControl.pendingRequests.isEmpty()) {
                try {
                    CaptureRequest captureRequest = (CaptureRequest) stillCaptureRequestControl.pendingRequests.poll();
                    if (captureRequest != null && (interfaceC1083uD = captureRequest.d()) != null) {
                        C4109a.a(interfaceC1083uD.e(new ImageCaptureException(3, "Capture request is cancelled due to a reset", null)));
                    }
                } catch (Throwable th) {
                    interfaceC4021a.l(null);
                    throw th;
                }
            }
            t tVar = t.f7040a;
            interfaceC4021a.l(null);
            return t.f7040a;
        }
    }

    public StillCaptureRequestControl(FlashControl flashControl, y0 threads) {
        p.i(flashControl, "flashControl");
        p.i(threads, "threads");
        this.flashControl = flashControl;
        this.threads = threads;
        this.mutex = eb.f.b(false, 1, null);
        this.pendingRequests = new LinkedList<>();
    }

    public static final t j(StillCaptureRequestControl stillCaptureRequestControl, Q q10, CaptureRequest captureRequest, UseCaseCameraRequestControl useCaseCameraRequestControl, Throwable th) {
        if ((th instanceof ImageCaptureException) && ((ImageCaptureException) th).a() == 3) {
            C1060i.d(stillCaptureRequestControl.threads.getSequentialScope(), null, null, new StillCaptureRequestControl$propagateResultOrEnqueueRequest$1$1(stillCaptureRequestControl, useCaseCameraRequestControl, captureRequest, null), 3, null);
        } else {
            CoroutineAdaptersKt.q(q10, captureRequest.d(), th);
        }
        return t.f7040a;
    }

    @Override // t.j0
    public void b(UseCaseCameraRequestControl useCaseCameraRequestControl) {
        this._requestControl = useCaseCameraRequestControl;
        l();
    }

    /* renamed from: g, reason: from getter */
    public UseCaseCameraRequestControl get_requestControl() {
        return this._requestControl;
    }

    public final InterfaceFutureC4095a<List<Void>> h(List<l> captureConfigs, int captureMode, int flashType) {
        p.i(captureConfigs, "captureConfigs");
        InterfaceC1083u interfaceC1083uC = C1087w.c(null, 1, null);
        C1060i.d(this.threads.getSequentialScope(), null, null, new StillCaptureRequestControl$issueCaptureRequests$1(captureConfigs, captureMode, flashType, interfaceC1083uC, this, null), 3, null);
        InterfaceFutureC4095a<List<Void>> interfaceFutureC4095aI = O.f.i(CoroutineAdaptersKt.i(interfaceC1083uC, null, 1, null));
        p.h(interfaceFutureC4095aI, "nonCancellationPropagating(...)");
        return interfaceFutureC4095aI;
    }

    public final void i(final Q<? extends List<Void>> q10, final CaptureRequest captureRequest, final UseCaseCameraRequestControl useCaseCameraRequestControl) {
        q10.J(new InterfaceC5074l() { // from class: t.e0
            @Override // p9.InterfaceC5074l
            public final Object invoke(Object obj) {
                return StillCaptureRequestControl.j(this.f41882a, q10, captureRequest, useCaseCameraRequestControl, (Throwable) obj);
            }
        });
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object k(androidx.camera.camera2.impl.StillCaptureRequestControl.CaptureRequest r7, androidx.camera.camera2.impl.UseCaseCameraRequestControl r8, e9.InterfaceC4014c<? super Ua.Q<? extends java.util.List<java.lang.Void>>> r9) throws java.lang.Throwable {
        /*
            r6 = this;
            boolean r0 = r9 instanceof androidx.camera.camera2.impl.StillCaptureRequestControl$submitRequest$1
            if (r0 == 0) goto L13
            r0 = r9
            androidx.camera.camera2.impl.StillCaptureRequestControl$submitRequest$1 r0 = (androidx.camera.camera2.impl.StillCaptureRequestControl$submitRequest$1) r0
            int r1 = r0.f9874e
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.f9874e = r1
            goto L18
        L13:
            androidx.camera.camera2.impl.StillCaptureRequestControl$submitRequest$1 r0 = new androidx.camera.camera2.impl.StillCaptureRequestControl$submitRequest$1
            r0.<init>(r6, r9)
        L18:
            java.lang.Object r9 = r0.f9872c
            java.lang.Object r1 = f9.C4063a.g()
            int r2 = r0.f9874e
            java.lang.String r3 = "CXCP"
            r4 = 1
            if (r2 == 0) goto L3c
            if (r2 != r4) goto L34
            java.lang.Object r7 = r0.f9871b
            r8 = r7
            androidx.camera.camera2.impl.UseCaseCameraRequestControl r8 = (androidx.camera.camera2.impl.UseCaseCameraRequestControl) r8
            java.lang.Object r7 = r0.f9870a
            androidx.camera.camera2.impl.StillCaptureRequestControl$a r7 = (androidx.camera.camera2.impl.StillCaptureRequestControl.CaptureRequest) r7
            kotlin.C4849c.b(r9)
            goto L76
        L34:
            java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
            java.lang.String r7 = "call to 'resume' before 'invoke' with coroutine"
            r6.<init>(r7)
            throw r6
        L3c:
            kotlin.C4849c.b(r9)
            t.b r9 = t.C5473b.f41865a
            boolean r9 = D.C0761b0.f(r3)
            if (r9 == 0) goto L67
            java.lang.String r9 = t.C5473b.a()
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            java.lang.String r5 = "StillCaptureRequestControl: submitting "
            r2.append(r5)
            r2.append(r7)
            java.lang.String r5 = " at "
            r2.append(r5)
            r2.append(r8)
            java.lang.String r2 = r2.toString()
            android.util.Log.d(r9, r2)
        L67:
            androidx.camera.camera2.impl.FlashControl r9 = r6.flashControl
            r0.f9870a = r7
            r0.f9871b = r8
            r0.f9874e = r4
            java.lang.Object r9 = r9.h(r0)
            if (r9 != r1) goto L76
            return r1
        L76:
            java.lang.Number r9 = (java.lang.Number) r9
            int r9 = r9.intValue()
            t.b r0 = t.C5473b.f41865a
            boolean r0 = D.C0761b0.f(r3)
            if (r0 == 0) goto L8d
            java.lang.String r0 = t.C5473b.a()
            java.lang.String r1 = "StillCaptureRequestControl: Issuing single capture"
            android.util.Log.d(r0, r1)
        L8d:
            java.util.List r0 = r7.a()
            int r1 = r7.getCaptureMode()
            int r2 = r7.getFlashType()
            java.util.List r8 = r8.e(r0, r1, r2, r9)
            t.y0 r6 = r6.threads
            Ua.M r0 = r6.getSequentialScope()
            androidx.camera.camera2.impl.StillCaptureRequestControl$submitRequest$4 r3 = new androidx.camera.camera2.impl.StillCaptureRequestControl$submitRequest$4
            r6 = 0
            r3.<init>(r8, r7, r6)
            r4 = 3
            r5 = 0
            r1 = 0
            r2 = 0
            Ua.Q r6 = Ua.C1056g.b(r0, r1, r2, r3, r4, r5)
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.camera.camera2.impl.StillCaptureRequestControl.k(androidx.camera.camera2.impl.StillCaptureRequestControl$a, androidx.camera.camera2.impl.UseCaseCameraRequestControl, e9.c):java.lang.Object");
    }

    public final void l() {
        C1060i.d(this.threads.getSequentialScope(), null, null, new StillCaptureRequestControl$trySubmitPendingRequests$1(this, null), 3, null);
    }

    @Override // t.j0
    public void reset() {
        C1060i.d(this.threads.getSequentialScope(), null, null, new AnonymousClass1(null), 3, null);
    }
}
