package androidx.camera.camera2.adapter;

import D.C0761b0;
import K.C0895s;
import K.InterfaceC0898v;
import K.z0;
import Oa.a;
import Oa.b;
import Ua.C1060i;
import Ua.M;
import Y8.t;
import Z8.F;
import android.util.Log;
import androidx.camera.camera2.impl.g;
import androidx.camera.camera2.pipe.CameraGraph;
import androidx.camera.core.UseCase;
import androidx.camera.core.impl.CameraInternal;
import androidx.camera.core.impl.h;
import com.autonavi.aps.amapapi.config.Const;
import e9.InterfaceC4014c;
import f9.C4063a;
import g3.InterfaceFutureC4095a;
import g9.InterfaceC4112d;
import java.util.Collection;
import kotlin.C4849c;
import kotlin.Metadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import o.C4979k;
import o.C4981m;
import p9.p;
import s.m;
import t.C5473b;
import t.y0;
import w.C5708n;
import x5.d;

@Metadata(d1 = {"\u0000\u0094\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u001f\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0007\u0018\u00002\u00020\u0001B9\b\u0007\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\u0006\u0010\u0007\u001a\u00020\u0006\u0012\u0006\u0010\t\u001a\u00020\b\u0012\u0006\u0010\u000b\u001a\u00020\n\u0012\u0006\u0010\r\u001a\u00020\f¢\u0006\u0004\b\u000e\u0010\u000fJ\u0017\u0010\u0013\u001a\u00020\u00122\u0006\u0010\u0011\u001a\u00020\u0010H\u0000¢\u0006\u0004\b\u0013\u0010\u0014J\u0011\u0010\u0016\u001a\u0004\u0018\u00010\u0015H\u0000¢\u0006\u0004\b\u0016\u0010\u0017J\u0017\u0010\u001a\u001a\u00020\u00122\u0006\u0010\u0019\u001a\u00020\u0018H\u0000¢\u0006\u0004\b\u001a\u0010\u001bJ\u0017\u0010\u001d\u001a\u00020\u00122\u0006\u0010\u001c\u001a\u00020\u0010H\u0016¢\u0006\u0004\b\u001d\u0010\u0014J\u0017\u0010\u001f\u001a\u00020\u00122\u0006\u0010\u001e\u001a\u00020\u0010H\u0016¢\u0006\u0004\b\u001f\u0010\u0014J\u0015\u0010\"\u001a\b\u0012\u0004\u0012\u00020!0 H\u0016¢\u0006\u0004\b\"\u0010#J\u000f\u0010$\u001a\u00020\u0006H\u0016¢\u0006\u0004\b$\u0010%J\u000f\u0010&\u001a\u00020\bH\u0016¢\u0006\u0004\b&\u0010'J\u001d\u0010+\u001a\u00020\u00122\f\u0010*\u001a\b\u0012\u0004\u0012\u00020)0(H\u0016¢\u0006\u0004\b+\u0010,J\u001d\u0010.\u001a\u00020\u00122\f\u0010-\u001a\b\u0012\u0004\u0012\u00020)0(H\u0016¢\u0006\u0004\b.\u0010,J\u0017\u00100\u001a\u00020\u00122\u0006\u0010/\u001a\u00020)H\u0016¢\u0006\u0004\b0\u00101J\u0017\u00102\u001a\u00020\u00122\u0006\u0010/\u001a\u00020)H\u0016¢\u0006\u0004\b2\u00101J\u0017\u00103\u001a\u00020\u00122\u0006\u0010/\u001a\u00020)H\u0016¢\u0006\u0004\b3\u00101J\u0017\u00104\u001a\u00020\u00122\u0006\u0010/\u001a\u00020)H\u0016¢\u0006\u0004\b4\u00101J\u000f\u00106\u001a\u000205H\u0016¢\u0006\u0004\b6\u00107J\u0019\u00109\u001a\u00020\u00122\b\u00108\u001a\u0004\u0018\u000105H\u0016¢\u0006\u0004\b9\u0010:J\u000f\u0010;\u001a\u00020\u0012H\u0016¢\u0006\u0004\b;\u0010<J\u000f\u0010=\u001a\u00020\u0010H\u0016¢\u0006\u0004\b=\u0010>J\u000f\u0010@\u001a\u00020?H\u0016¢\u0006\u0004\b@\u0010AR\u0014\u0010\u0005\u001a\u00020\u00048\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bB\u0010CR\u0014\u0010\u0007\u001a\u00020\u00068\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b0\u0010DR\u0014\u0010\t\u001a\u00020\b8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b2\u0010ER\u0014\u0010\u000b\u001a\u00020\n8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b&\u0010FR\u0014\u0010\r\u001a\u00020\f8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b6\u0010GR\u0014\u0010J\u001a\u00020H8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001f\u0010IR\u0016\u0010L\u001a\u0002058\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b+\u0010KR\u0014\u0010O\u001a\u00020M8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b.\u0010NR\u0018\u0010R\u001a\u0004\u0018\u00010P8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b$\u0010QR\u0014\u0010V\u001a\u00020S8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bT\u0010U¨\u0006W"}, d2 = {"Landroidx/camera/camera2/adapter/CameraInternalAdapter;", "Landroidx/camera/core/impl/CameraInternal;", "Ls/m;", "config", "Landroidx/camera/camera2/impl/g;", "useCaseManager", "LK/v;", "cameraInfo", "Landroidx/camera/core/impl/h;", "cameraController", "Lt/y0;", "threads", "Lo/m;", "cameraStateAdapter", "<init>", "(Ls/m;Landroidx/camera/camera2/impl/g;LK/v;Landroidx/camera/core/impl/h;Lt/y0;Lo/m;)V", "", "createImmediately", "LY8/t;", "x", "(Z)V", "Landroidx/camera/camera2/pipe/CameraGraph$b;", "v", "()Landroidx/camera/camera2/pipe/CameraGraph$b;", "Landroidx/camera/camera2/pipe/CameraGraph;", "cameraGraph", "w", "(Landroidx/camera/camera2/pipe/CameraGraph;)V", "isPrimary", "q", d.EXTRA_ENABLED, "f", "Lg3/a;", "Ljava/lang/Void;", "release", "()Lg3/a;", Const.INTENT_KEY_BACKGROUND_NOTIFICATION_ID, "()LK/v;", Const.INTENT_KEY_UMID, "()Landroidx/camera/core/impl/h;", "", "Landroidx/camera/core/UseCase;", "useCasesToAdd", Const.INTENT_KEY_BACKGROUND_COMMAND, "(Ljava/util/Collection;)V", "useCasesToRemove", Const.INTENT_KEY_BACKGROUND_NOTIFICATION, "useCase", Const.INTENT_KEY_PKGNAME, "(Landroidx/camera/core/UseCase;)V", "c", "k", "l", "Landroidx/camera/core/impl/g;", "e", "()Landroidx/camera/core/impl/g;", "cameraConfig", "m", "(Landroidx/camera/core/impl/g;)V", "o", "()V", "n", "()Z", "", "toString", "()Ljava/lang/String;", Const.INTENT_KEY_APIKEY, "Landroidx/camera/camera2/impl/g;", "LK/v;", "Landroidx/camera/core/impl/h;", "Lt/y0;", "Lo/m;", "Lw/n;", "Ljava/lang/String;", "cameraId", "Landroidx/camera/core/impl/g;", "coreCameraConfig", "", "I", "debugId", "LK/z0;", "LK/z0;", "sessionProcessor", "LOa/a;", Const.INTENT_KEY_BACKGROUND_NOTIFICATION_REMOVE, "LOa/a;", "isRemoved", "camera-camera2"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes.dex */
public final class CameraInternalAdapter implements CameraInternal {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    public final g useCaseManager;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    public final InterfaceC0898v cameraInfo;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    public final h cameraController;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    public final y0 threads;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    public final C4981m cameraStateAdapter;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    public final String cameraId;

    /* renamed from: g, reason: collision with root package name and from kotlin metadata */
    public androidx.camera.core.impl.g coreCameraConfig;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    public final int debugId;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    public z0 sessionProcessor;

    /* renamed from: j, reason: collision with root package name and from kotlin metadata */
    public final a isRemoved;

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"LUa/M;", "LY8/t;", "<anonymous>", "(LUa/M;)V"}, k = 3, mv = {2, 1, 0})
    @InterfaceC4112d(c = "androidx.camera.camera2.adapter.CameraInternalAdapter$release$1", f = "CameraInternalAdapter.kt", l = {96}, m = "invokeSuspend", v = 1)
    /* renamed from: androidx.camera.camera2.adapter.CameraInternalAdapter$release$1, reason: invalid class name */
    public static final class AnonymousClass1 extends SuspendLambda implements p<M, InterfaceC4014c<? super t>, Object> {

        /* renamed from: a, reason: collision with root package name */
        public int f9318a;

        public AnonymousClass1(InterfaceC4014c<? super AnonymousClass1> interfaceC4014c) {
            super(2, interfaceC4014c);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final InterfaceC4014c<t> create(Object obj, InterfaceC4014c<?> interfaceC4014c) {
            return CameraInternalAdapter.this.new AnonymousClass1(interfaceC4014c);
        }

        @Override // p9.p
        public final Object invoke(M m10, InterfaceC4014c<? super t> interfaceC4014c) {
            return ((AnonymousClass1) create(m10, interfaceC4014c)).invokeSuspend(t.f7040a);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) throws Throwable {
            Object objG = C4063a.g();
            int i10 = this.f9318a;
            if (i10 == 0) {
                C4849c.b(obj);
                g gVar = CameraInternalAdapter.this.useCaseManager;
                this.f9318a = 1;
                if (gVar.k(this) == objG) {
                    return objG;
                }
            } else {
                if (i10 != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                C4849c.b(obj);
            }
            kotlinx.coroutines.d.e(CameraInternalAdapter.this.threads.getScope(), null, 1, null);
            return t.f7040a;
        }
    }

    public CameraInternalAdapter(m config, g useCaseManager, InterfaceC0898v cameraInfo, h cameraController, y0 threads, C4981m cameraStateAdapter) {
        kotlin.jvm.internal.p.i(config, "config");
        kotlin.jvm.internal.p.i(useCaseManager, "useCaseManager");
        kotlin.jvm.internal.p.i(cameraInfo, "cameraInfo");
        kotlin.jvm.internal.p.i(cameraController, "cameraController");
        kotlin.jvm.internal.p.i(threads, "threads");
        kotlin.jvm.internal.p.i(cameraStateAdapter, "cameraStateAdapter");
        this.useCaseManager = useCaseManager;
        this.cameraInfo = cameraInfo;
        this.cameraController = cameraController;
        this.threads = threads;
        this.cameraStateAdapter = cameraStateAdapter;
        this.cameraId = config.getCameraId();
        androidx.camera.core.impl.g gVarA = C0895s.a();
        kotlin.jvm.internal.p.h(gVarA, "defaultConfig(...)");
        this.coreCameraConfig = gVarA;
        this.debugId = C4979k.a().d();
        this.isRemoved = b.a(false);
        C5473b c5473b = C5473b.f41865a;
        if (C0761b0.f("CXCP")) {
            Log.d(C5473b.TRUNCATED_TAG, "Created " + this + " for " + ((Object) C5708n.f(this.cameraId)));
        }
    }

    @Override // androidx.camera.core.UseCase.b
    public void b(UseCase useCase) {
        kotlin.jvm.internal.p.i(useCase, "useCase");
        this.useCaseManager.f(useCase);
    }

    @Override // androidx.camera.core.UseCase.b
    public void c(UseCase useCase) {
        kotlin.jvm.internal.p.i(useCase, "useCase");
        this.useCaseManager.S(useCase);
    }

    @Override // androidx.camera.core.impl.CameraInternal
    /* renamed from: d, reason: from getter */
    public h getCameraController() {
        return this.cameraController;
    }

    @Override // androidx.camera.core.impl.CameraInternal
    /* renamed from: e, reason: from getter */
    public androidx.camera.core.impl.g getCoreCameraConfig() {
        return this.coreCameraConfig;
    }

    @Override // androidx.camera.core.impl.CameraInternal
    public void f(boolean enabled) {
        this.useCaseManager.K(enabled);
    }

    @Override // androidx.camera.core.impl.CameraInternal
    public void g(Collection<UseCase> useCasesToAdd) {
        kotlin.jvm.internal.p.i(useCasesToAdd, "useCasesToAdd");
        this.useCaseManager.i(F.m1(useCasesToAdd));
    }

    @Override // androidx.camera.core.impl.CameraInternal
    public void h(Collection<UseCase> useCasesToRemove) {
        kotlin.jvm.internal.p.i(useCasesToRemove, "useCasesToRemove");
        this.useCaseManager.r(F.m1(useCasesToRemove));
    }

    @Override // androidx.camera.core.impl.CameraInternal
    /* renamed from: i, reason: from getter */
    public InterfaceC0898v getCameraInfo() {
        return this.cameraInfo;
    }

    @Override // androidx.camera.core.UseCase.b
    public void k(UseCase useCase) {
        kotlin.jvm.internal.p.i(useCase, "useCase");
        this.useCaseManager.H(useCase);
    }

    @Override // androidx.camera.core.UseCase.b
    public void l(UseCase useCase) {
        kotlin.jvm.internal.p.i(useCase, "useCase");
        this.useCaseManager.p(useCase);
    }

    @Override // androidx.camera.core.impl.CameraInternal
    public void m(androidx.camera.core.impl.g cameraConfig) {
        androidx.camera.core.impl.g gVarA;
        if (cameraConfig == null) {
            gVarA = C0895s.a();
            kotlin.jvm.internal.p.h(gVarA, "defaultConfig(...)");
        } else {
            gVarA = cameraConfig;
        }
        this.coreCameraConfig = gVarA;
        z0 z0VarT = cameraConfig != null ? cameraConfig.T(null) : null;
        this.sessionProcessor = z0VarT;
        this.useCaseManager.N(z0VarT);
    }

    @Override // androidx.camera.core.impl.CameraInternal
    public boolean n() {
        return this.isRemoved.b();
    }

    @Override // androidx.camera.core.impl.CameraInternal
    public void o() {
        C5473b c5473b = C5473b.f41865a;
        if (C0761b0.f("CXCP")) {
            Log.d(C5473b.TRUNCATED_TAG, this + " received removed signal. Cleaning up.");
        }
        if (this.isRemoved.a(false, true)) {
            C1060i.d(this.threads.getScope(), null, null, new CameraInternalAdapter$onRemoved$2(this, null), 3, null);
        }
    }

    @Override // androidx.camera.core.impl.CameraInternal
    public void q(boolean isPrimary) {
        this.useCaseManager.M(isPrimary);
    }

    @Override // androidx.camera.core.impl.CameraInternal
    public InterfaceFutureC4095a<Void> release() {
        return CoroutineAdaptersKt.j(C1060i.d(this.threads.getScope(), null, null, new AnonymousClass1(null), 3, null), null, 1, null);
    }

    public String toString() {
        return "CameraInternalAdapter<" + ((Object) C5708n.f(this.cameraId)) + '(' + this.debugId + ")>";
    }

    public final CameraGraph.b v() {
        return this.useCaseManager.w();
    }

    public final void w(CameraGraph cameraGraph) {
        kotlin.jvm.internal.p.i(cameraGraph, "cameraGraph");
        this.useCaseManager.I(cameraGraph);
    }

    public final void x(boolean createImmediately) {
        this.useCaseManager.L(createImmediately);
    }
}
