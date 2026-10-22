package p;

import Ua.C1087w;
import Ua.InterfaceC1083u;
import Ua.Q;
import androidx.camera.camera2.adapter.CoroutineAdaptersKt;
import androidx.camera.camera2.impl.UseCaseCameraRequestControl;
import androidx.camera.camera2.impl.a;
import androidx.camera.core.CameraControl$OperationCanceledException;
import androidx.camera.core.impl.Config;
import com.autonavi.aps.amapapi.config.Const;
import kotlin.Metadata;
import t.O;
import v.C5649f;
import w.K;
import w.w;

@Metadata(d1 = {"\u0000b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\t\b\u0007\u0018\u00002\u00020\u0001B\t\b\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0017\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0007\u0010\bJ\u000f\u0010\t\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\t\u0010\nJ\u000f\u0010\u000b\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\u000b\u0010\u0003J\u000f\u0010\f\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\f\u0010\u0003J)\u0010\u0013\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00120\u00112\b\u0010\u000e\u001a\u0004\u0018\u00010\r2\u0006\u0010\u0010\u001a\u00020\u000fH\u0016¢\u0006\u0004\b\u0013\u0010\u0014J'\u0010\u001b\u001a\u00020\u00062\u0006\u0010\u0016\u001a\u00020\u00152\u0006\u0010\u0018\u001a\u00020\u00172\u0006\u0010\u001a\u001a\u00020\u0019H\u0016¢\u0006\u0004\b\u001b\u0010\u001cJ-\u0010 \u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00120\u001d*\n\u0012\u0006\u0012\u0004\u0018\u00010\u00120\u001d2\b\b\u0002\u0010\u001f\u001a\u00020\u001eH\u0002¢\u0006\u0004\b \u0010!R\u0014\u0010$\u001a\u00020\"8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b \u0010#R\u0014\u0010%\u001a\u00020\"8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0007\u0010#R\u0016\u0010)\u001a\u00020&8\u0002@\u0002X\u0083\u000e¢\u0006\u0006\n\u0004\b'\u0010(R \u0010,\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0012\u0018\u00010\u001d8\u0002@\u0002X\u0083\u000e¢\u0006\u0006\n\u0004\b*\u0010+R \u0010.\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0012\u0018\u00010\u001d8\u0002@\u0002X\u0083\u000e¢\u0006\u0006\n\u0004\b-\u0010+¨\u0006/"}, d2 = {"Lp/g;", "Lp/f;", "<init>", "()V", "Lv/f;", "bundle", "LY8/t;", Const.INTENT_KEY_PKGNAME, "(Lv/f;)V", "U", "()Lv/f;", "n", "l", "Landroidx/camera/camera2/impl/UseCaseCameraRequestControl;", "requestControl", "", "cancelPreviousTask", "LUa/Q;", "Ljava/lang/Void;", "J", "(Landroidx/camera/camera2/impl/UseCaseCameraRequestControl;Z)LUa/Q;", "Lw/K;", "requestMetadata", "Lw/y;", "frameNumber", "Lw/w;", "result", "g0", "(Lw/K;JLw/w;)V", "LUa/u;", "", "msg", Const.INTENT_KEY_APIKEY, "(LUa/u;Ljava/lang/String;)LUa/u;", "", "Ljava/lang/Object;", "lock", "updateSignalLock", "Landroidx/camera/camera2/impl/a$a;", "c", "Landroidx/camera/camera2/impl/a$a;", "configBuilder", Const.INTENT_KEY_UMID, "LUa/u;", "updateSignal", "e", "pendingSignal", "camera-camera2"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* renamed from: p.g, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C5025g implements InterfaceC5024f {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    public final Object lock = new Object();

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    public final Object updateSignalLock = new Object();

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    public a.C0131a configBuilder = new a.C0131a();

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    public InterfaceC1083u<Void> updateSignal;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    public InterfaceC1083u<Void> pendingSignal;

    public static /* synthetic */ InterfaceC1083u c(C5025g c5025g, InterfaceC1083u interfaceC1083u, String str, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            str = "Camera2CameraControl was updated with new options.";
        }
        return c5025g.a(interfaceC1083u, str);
    }

    @Override // p.InterfaceC5024f
    public Q<Void> J(UseCaseCameraRequestControl requestControl, boolean cancelPreviousTask) {
        androidx.camera.camera2.impl.a aVarC;
        InterfaceC1083u<Void> interfaceC1083uC = C1087w.c(null, 1, null);
        synchronized (this.lock) {
            aVarC = this.configBuilder.c();
        }
        synchronized (this.updateSignalLock) {
            try {
                if (requestControl != null) {
                    if (cancelPreviousTask) {
                        InterfaceC1083u<Void> interfaceC1083u = this.updateSignal;
                        if (interfaceC1083u != null) {
                            c(this, interfaceC1083u, null, 1, null);
                        }
                    } else {
                        InterfaceC1083u<Void> interfaceC1083u2 = this.updateSignal;
                        if (interfaceC1083u2 != null) {
                            CoroutineAdaptersKt.s(interfaceC1083uC, interfaceC1083u2);
                        }
                    }
                    this.updateSignal = interfaceC1083uC;
                    requestControl.n(aVarC, Z8.Q.f(Y8.j.a("Camera2CameraControl.tag", Integer.valueOf(interfaceC1083uC.hashCode()))));
                } else {
                    InterfaceC1083u<Void> interfaceC1083u3 = this.pendingSignal;
                    if (interfaceC1083u3 != null) {
                        c(this, interfaceC1083u3, null, 1, null);
                    }
                    this.pendingSignal = interfaceC1083uC;
                    Y8.t tVar = Y8.t.f7040a;
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return interfaceC1083uC;
    }

    @Override // p.InterfaceC5024f
    public C5649f U() {
        C5649f c5649fB;
        synchronized (this.lock) {
            c5649fB = C5649f.a.INSTANCE.b(this.configBuilder.c()).b();
        }
        return c5649fB;
    }

    public final InterfaceC1083u<Void> a(InterfaceC1083u<Void> interfaceC1083u, String str) {
        interfaceC1083u.e(new CameraControl$OperationCanceledException(str));
        return interfaceC1083u;
    }

    @Override // p.InterfaceC5024f
    public void b(C5649f bundle) {
        kotlin.jvm.internal.p.i(bundle, "bundle");
        synchronized (this.lock) {
            try {
                for (Config.a<?> aVar : bundle.e()) {
                    kotlin.jvm.internal.p.g(aVar, "null cannot be cast to non-null type androidx.camera.core.impl.Config.Option<kotlin.Any>");
                    this.configBuilder.a().q(aVar, Config.OptionPriority.ALWAYS_OVERRIDE, bundle.a(aVar));
                }
                Y8.t tVar = Y8.t.f7040a;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // androidx.camera.camera2.pipe.t.a
    public void g0(K requestMetadata, long frameNumber, w result) {
        kotlin.jvm.internal.p.i(requestMetadata, "requestMetadata");
        kotlin.jvm.internal.p.i(result, "result");
        synchronized (this.updateSignalLock) {
            try {
                InterfaceC1083u<Void> interfaceC1083u = this.updateSignal;
                if (interfaceC1083u != null && O.a(requestMetadata, "Camera2CameraControl.tag", Integer.valueOf(interfaceC1083u.hashCode()))) {
                    interfaceC1083u.complete(null);
                    this.updateSignal = null;
                    InterfaceC1083u<Void> interfaceC1083u2 = this.pendingSignal;
                    if (interfaceC1083u2 != null) {
                        interfaceC1083u2.complete(null);
                        this.pendingSignal = null;
                    }
                }
                Y8.t tVar = Y8.t.f7040a;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // p.InterfaceC5024f
    public void l() {
        synchronized (this.updateSignalLock) {
            try {
                InterfaceC1083u<Void> interfaceC1083u = this.updateSignal;
                if (interfaceC1083u != null) {
                    this.updateSignal = null;
                    a(interfaceC1083u, "The camera control has became inactive.");
                }
                InterfaceC1083u<Void> interfaceC1083u2 = this.pendingSignal;
                if (interfaceC1083u2 != null) {
                    this.pendingSignal = null;
                    a(interfaceC1083u2, "The camera control has became inactive.");
                }
                Y8.t tVar = Y8.t.f7040a;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // p.InterfaceC5024f
    public void n() {
        synchronized (this.lock) {
            this.configBuilder = new a.C0131a();
            Y8.t tVar = Y8.t.f7040a;
        }
    }
}
