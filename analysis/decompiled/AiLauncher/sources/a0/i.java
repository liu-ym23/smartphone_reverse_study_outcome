package a0;

import D.A;
import D.C0759a0;
import D.C0777n;
import D.InterfaceC0771h;
import D.InterfaceC0776m;
import D.InterfaceC0778o;
import D.InterfaceC0779p;
import D.o0;
import K.C0877d;
import K.C0895s;
import K.InterfaceC0898v;
import K.K;
import K.X;
import Y8.t;
import Z8.r;
import a0.k;
import android.content.Context;
import android.view.LifecycleOwner;
import androidx.camera.core.CameraSelector;
import androidx.camera.core.CameraX;
import androidx.camera.core.UseCase;
import androidx.camera.core.f;
import androidx.camera.core.impl.CameraInternal;
import androidx.camera.core.internal.CameraUseCaseAdapter;
import androidx.exifinterface.media.ExifInterface;
import com.autonavi.aps.amapapi.config.Const;
import g3.InterfaceFutureC4095a;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ScheduledExecutorService;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.jvm.internal.p;
import kotlin.jvm.internal.y;
import m.InterfaceC4887a;
import o1.C4996a;
import p9.InterfaceC5074l;

@Metadata(d1 = {"\u0000Ä\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\"\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0010\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010%\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u0006\b\u0001\u0018\u00002\u00020\u00012\u00020\u0002B\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\u000f\u0010\u0006\u001a\u00020\u0005H\u0003¢\u0006\u0004\b\u0006\u0010\u0004J#\u0010\u000b\u001a\u00020\u00052\b\u0010\b\u001a\u0004\u0018\u00010\u00072\b\u0010\n\u001a\u0004\u0018\u00010\tH\u0003¢\u0006\u0004\b\u000b\u0010\fJG\u0010\u0018\u001a\u00020\u00172\u0006\u0010\u000e\u001a\u00020\r2\u0006\u0010\u0010\u001a\u00020\u000f2\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u000f2\b\b\u0002\u0010\u0013\u001a\u00020\u00122\b\b\u0002\u0010\u0014\u001a\u00020\u00122\u0006\u0010\u0016\u001a\u00020\u0015H\u0002¢\u0006\u0004\b\u0018\u0010\u0019J7\u0010\u001b\u001a\u0010\u0012\u0004\u0012\u00020\u000f\u0012\u0006\u0012\u0004\u0018\u00010\u000f0\u001a2\u0006\u0010\u0016\u001a\u00020\u00152\u0006\u0010\u0010\u001a\u00020\u000f2\b\u0010\u0011\u001a\u0004\u0018\u00010\u000fH\u0002¢\u0006\u0004\b\u001b\u0010\u001cJ\u001f\u0010!\u001a\u00020 2\u0006\u0010\u001d\u001a\u00020\u000f2\u0006\u0010\u001f\u001a\u00020\u001eH\u0002¢\u0006\u0004\b!\u0010\"J)\u0010(\u001a\b\u0012\u0004\u0012\u00020'0&2\u0006\u0010#\u001a\u00020\t2\n\b\u0002\u0010%\u001a\u0004\u0018\u00010$H\u0000¢\u0006\u0004\b(\u0010)J\u0017\u0010*\u001a\u00020\u00052\u0006\u0010%\u001a\u00020$H\u0000¢\u0006\u0004\b*\u0010+J\u001f\u0010.\u001a\b\u0012\u0004\u0012\u00020'0&2\b\b\u0002\u0010-\u001a\u00020,H\u0000¢\u0006\u0004\b.\u0010/J'\u00103\u001a\u00020\u00052\u0016\u00102\u001a\f\u0012\b\b\u0001\u0012\u0004\u0018\u00010100\"\u0004\u0018\u000101H\u0017¢\u0006\u0004\b3\u00104J\u000f\u00105\u001a\u00020\u0005H\u0017¢\u0006\u0004\b5\u0010\u0004J7\u00106\u001a\u00020\u00172\u0006\u0010\u000e\u001a\u00020\r2\u0006\u0010\u001d\u001a\u00020\u000f2\u0016\u00102\u001a\f\u0012\b\b\u0001\u0012\u0004\u0018\u00010100\"\u0004\u0018\u000101H\u0017¢\u0006\u0004\b6\u00107J\u0017\u00108\u001a\u00020\u001e2\u0006\u0010\u001d\u001a\u00020\u000fH\u0016¢\u0006\u0004\b8\u00109J\u001d\u0010=\u001a\u00020\u00052\f\u0010<\u001a\b\u0012\u0004\u0012\u00020;0:H\u0017¢\u0006\u0004\b=\u0010>J\u001d\u0010@\u001a\u00020\u00052\f\u0010?\u001a\b\u0012\u0004\u0012\u00020;0:H\u0017¢\u0006\u0004\b@\u0010>R\u0014\u0010B\u001a\u00020\u00018\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b@\u0010AR*\u0010J\u001a\u0004\u0018\u00010C8\u0000@\u0000X\u0081\u000e¢\u0006\u0018\n\u0004\b=\u0010D\u0012\u0004\bI\u0010\u0004\u001a\u0004\bE\u0010F\"\u0004\bG\u0010HR\u001e\u0010M\u001a\n\u0012\u0004\u0012\u00020'\u0018\u00010&8\u0002@\u0002X\u0083\u000e¢\u0006\u0006\n\u0004\bK\u0010LR$\u0010P\u001a\u0010\u0012\f\u0012\n N*\u0004\u0018\u00010'0'0&8\u0002@\u0002X\u0083\u000e¢\u0006\u0006\n\u0004\bO\u0010LR\u0018\u0010S\u001a\u0004\u0018\u00010\u00078\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bQ\u0010RR\u0018\u0010W\u001a\u0004\u0018\u00010T8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bU\u0010VR*\u0010#\u001a\u0004\u0018\u00010\t8\u0000@\u0000X\u0081\u000e¢\u0006\u0018\n\u0004\bX\u0010Y\u0012\u0004\b^\u0010\u0004\u001a\u0004\bZ\u0010[\"\u0004\b\\\u0010]R \u0010c\u001a\u000e\u0012\u0004\u0012\u00020;\u0012\u0004\u0012\u00020`0_8\u0002X\u0083\u0004¢\u0006\u0006\n\u0004\ba\u0010bR$\u0010i\u001a\u0012\u0012\u0004\u0012\u00020e0dj\b\u0012\u0004\u0012\u00020e`f8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bg\u0010hR\u0014\u0010l\u001a\u00020,8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\bj\u0010kR$\u0010n\u001a\u00020m2\u0006\u0010n\u001a\u00020m8B@BX\u0082\u000e¢\u0006\f\u001a\u0004\bo\u0010p\"\u0004\bq\u0010r¨\u0006s"}, d2 = {"La0/i;", "", "LD/p;", "<init>", "()V", "LY8/t;", "K", "Landroidx/camera/core/CameraX;", "newCameraX", "Landroid/content/Context;", "newContext", ExifInterface.LONGITUDE_EAST, "(Landroidx/camera/core/CameraX;Landroid/content/Context;)V", "Landroidx/lifecycle/LifecycleOwner;", "lifecycleOwner", "Landroidx/camera/core/CameraSelector;", "primaryCameraSelector", "secondaryCameraSelector", "LD/A;", "primaryCompositionSettings", "secondaryCompositionSettings", "LD/o0;", "sessionConfig", "LD/h;", "r", "(Landroidx/lifecycle/LifecycleOwner;Landroidx/camera/core/CameraSelector;Landroidx/camera/core/CameraSelector;LD/A;LD/A;LD/o0;)LD/h;", "Lkotlin/Pair;", "y", "(LD/o0;Landroidx/camera/core/CameraSelector;Landroidx/camera/core/CameraSelector;)Lkotlin/Pair;", "cameraSelector", "LD/o;", "cameraInfo", "Landroidx/camera/core/impl/g;", "u", "(Landroidx/camera/core/CameraSelector;LD/o;)Landroidx/camera/core/impl/g;", "context", "Landroidx/camera/core/f;", "cameraXConfig", "Lg3/a;", "Ljava/lang/Void;", "z", "(Landroid/content/Context;Landroidx/camera/core/f;)Lg3/a;", "t", "(Landroidx/camera/core/f;)V", "", "clearConfigProvider", "I", "(Z)Lg3/a;", "", "Landroidx/camera/core/UseCase;", "useCases", "L", "([Landroidx/camera/core/UseCase;)V", "M", "q", "(Landroidx/lifecycle/LifecycleOwner;Landroidx/camera/core/CameraSelector;[Landroidx/camera/core/UseCase;)LD/h;", "v", "(Landroidx/camera/core/CameraSelector;)LD/o;", "", "LD/n;", "addedCameraIds", Const.INTENT_KEY_PKGNAME, "(Ljava/util/Set;)V", "removedCameraIds", Const.INTENT_KEY_APIKEY, "Ljava/lang/Object;", "lock", "Landroidx/camera/core/f$b;", "Landroidx/camera/core/f$b;", "x", "()Landroidx/camera/core/f$b;", "H", "(Landroidx/camera/core/f$b;)V", "getCameraXConfigProvider$camera_lifecycle$annotations", "cameraXConfigProvider", "c", "Lg3/a;", "cameraXInitializeFuture", "kotlin.jvm.PlatformType", Const.INTENT_KEY_UMID, "cameraXShutdownFuture", "e", "Landroidx/camera/core/CameraX;", "cameraX", "La0/k;", "f", "La0/k;", "lifecycleCameraRepository", Const.INTENT_KEY_BACKGROUND_COMMAND, "Landroid/content/Context;", "getContext$camera_lifecycle", "()Landroid/content/Context;", "setContext$camera_lifecycle", "(Landroid/content/Context;)V", "getContext$camera_lifecycle$annotations", "", "LK/d;", Const.INTENT_KEY_BACKGROUND_NOTIFICATION, "Ljava/util/Map;", "cameraInfoMap", "Ljava/util/HashSet;", "La0/k$a;", "Lkotlin/collections/HashSet;", Const.INTENT_KEY_BACKGROUND_NOTIFICATION_ID, "Ljava/util/HashSet;", "lifecycleCameraKeys", "F", "()Z", "isInitialized", "", "cameraOperatingMode", "w", "()I", "G", "(I)V", "camera-lifecycle"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes.dex */
public final class i implements InterfaceC0779p {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    public final Object lock = new Object();

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    public f.b cameraXConfigProvider;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    public InterfaceFutureC4095a<Void> cameraXInitializeFuture;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    public InterfaceFutureC4095a<Void> cameraXShutdownFuture;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    public CameraX cameraX;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    public k lifecycleCameraRepository;

    /* renamed from: g, reason: collision with root package name and from kotlin metadata */
    public Context context;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    public final Map<C0777n, C0877d> cameraInfoMap;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    public final HashSet<k.a> lifecycleCameraKeys;

    @Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
    public static final class a implements f.b {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ androidx.camera.core.f f7805a;

        public a(androidx.camera.core.f fVar) {
            this.f7805a = fVar;
        }

        @Override // androidx.camera.core.f.b
        public final androidx.camera.core.f getCameraXConfig() {
            return this.f7805a;
        }
    }

    @Metadata(d1 = {"\u0000\u001f\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0003\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u0001J\u0019\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0006J\u0017\u0010\t\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\t\u0010\n¨\u0006\u000b"}, d2 = {"a0/i$b", "LO/c;", "Ljava/lang/Void;", "void", "LY8/t;", "c", "(Ljava/lang/Void;)V", "", "t", Const.INTENT_KEY_PKGNAME, "(Ljava/lang/Throwable;)V", "camera-lifecycle"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class b implements O.c<Void> {
        public b() {
        }

        @Override // O.c
        public void b(Throwable t10) {
            p.i(t10, "t");
            i.this.I(false);
        }

        @Override // O.c
        /* renamed from: c, reason: merged with bridge method [inline-methods] */
        public void a(Void r12) {
        }
    }

    public i() {
        InterfaceFutureC4095a<Void> interfaceFutureC4095aH = O.f.h(null);
        p.h(interfaceFutureC4095aH, "immediateFuture(...)");
        this.cameraXShutdownFuture = interfaceFutureC4095aH;
        this.cameraInfoMap = new HashMap();
        this.lifecycleCameraKeys = new HashSet<>();
    }

    public static final InterfaceFutureC4095a A(CameraX cameraX, Void r12) {
        return cameraX.m();
    }

    public static final InterfaceFutureC4095a B(InterfaceC5074l interfaceC5074l, Object obj) {
        return (InterfaceFutureC4095a) interfaceC5074l.invoke(obj);
    }

    public static final Void C(i iVar, CameraX cameraX, Context context, Void r32) {
        iVar.E(cameraX, M.e.f(context));
        return r32;
    }

    public static final Void D(InterfaceC5074l interfaceC5074l, Object obj) {
        return (Void) interfaceC5074l.invoke(obj);
    }

    public static final void J(i iVar) {
        if (iVar.F()) {
            iVar.M();
            k kVar = iVar.lifecycleCameraRepository;
            p.f(kVar);
            kVar.i(iVar.lifecycleCameraKeys);
        }
    }

    public static /* synthetic */ InterfaceC0771h s(i iVar, LifecycleOwner lifecycleOwner, CameraSelector cameraSelector, CameraSelector cameraSelector2, A DEFAULT, A DEFAULT2, o0 o0Var, int i10, Object obj) {
        if ((i10 & 4) != 0) {
            cameraSelector2 = null;
        }
        CameraSelector cameraSelector3 = cameraSelector2;
        if ((i10 & 8) != 0) {
            DEFAULT = A.f1988d;
            p.h(DEFAULT, "DEFAULT");
        }
        A a10 = DEFAULT;
        if ((i10 & 16) != 0) {
            DEFAULT2 = A.f1988d;
            p.h(DEFAULT2, "DEFAULT");
        }
        return iVar.r(lifecycleOwner, cameraSelector, cameraSelector3, a10, DEFAULT2, o0Var);
    }

    public final void E(CameraX newCameraX, Context newContext) {
        K kH;
        synchronized (this.lock) {
            this.cameraX = newCameraX;
            this.context = newContext;
            if (newCameraX != null && (kH = newCameraX.h()) != null) {
                ScheduledExecutorService scheduledExecutorServiceD = N.a.d();
                p.h(scheduledExecutorServiceD, "mainThreadExecutor(...)");
                kH.t(this, scheduledExecutorServiceD);
                t tVar = t.f7040a;
            }
        }
    }

    public final boolean F() {
        return this.cameraX != null;
    }

    public final void G(int i10) {
        if (F()) {
            CameraX cameraX = this.cameraX;
            p.f(cameraX);
            cameraX.i().g().h(i10);
        }
    }

    public final void H(f.b bVar) {
        this.cameraXConfigProvider = bVar;
    }

    public final InterfaceFutureC4095a<Void> I(boolean clearConfigProvider) {
        InterfaceFutureC4095a<Void> interfaceFutureC4095aH;
        M.n.f(new Runnable() { // from class: a0.h
            @Override // java.lang.Runnable
            public final void run() {
                i.J(this.f7795a);
            }
        });
        if (F()) {
            CameraX cameraX = this.cameraX;
            p.f(cameraX);
            cameraX.h().F(this);
            CameraX cameraX2 = this.cameraX;
            p.f(cameraX2);
            interfaceFutureC4095aH = cameraX2.s();
        } else {
            interfaceFutureC4095aH = O.f.h(null);
        }
        p.f(interfaceFutureC4095aH);
        synchronized (this.lock) {
            if (clearConfigProvider) {
                try {
                    this.cameraXConfigProvider = null;
                } catch (Throwable th) {
                    throw th;
                }
            }
            this.cameraXInitializeFuture = null;
            this.cameraXShutdownFuture = interfaceFutureC4095aH;
            this.cameraInfoMap.clear();
            this.lifecycleCameraKeys.clear();
            t tVar = t.f7040a;
        }
        K();
        return interfaceFutureC4095aH;
    }

    public final void K() {
        E(null, null);
    }

    public void L(UseCase... useCases) {
        p.i(useCases, "useCases");
        C4996a.a("CX:unbind");
        try {
            M.n.b();
            if (w() == 2) {
                throw new UnsupportedOperationException("Unbind UseCase is not supported in concurrent camera mode, call unbindAll() first.");
            }
            k kVar = this.lifecycleCameraRepository;
            p.f(kVar);
            kVar.m(new C0759a0(r.V(useCases), null, null, 6, null), this.lifecycleCameraKeys);
            t tVar = t.f7040a;
        } finally {
            C4996a.b();
        }
    }

    public void M() {
        C4996a.a("CX:unbindAll");
        try {
            M.n.b();
            G(0);
            k kVar = this.lifecycleCameraRepository;
            p.f(kVar);
            kVar.n(this.lifecycleCameraKeys);
            t tVar = t.f7040a;
        } finally {
            C4996a.b();
        }
    }

    @Override // D.InterfaceC0779p
    public void a(Set<C0777n> removedCameraIds) {
        p.i(removedCameraIds, "removedCameraIds");
        M.n.b();
        synchronized (this.lock) {
            try {
                for (C0777n c0777n : removedCameraIds) {
                    Set<C0777n> setKeySet = this.cameraInfoMap.keySet();
                    ArrayList arrayList = new ArrayList();
                    for (Object obj : setKeySet) {
                        if (p.d(((C0777n) obj).a(), c0777n.a())) {
                            arrayList.add(obj);
                        }
                    }
                    Iterator it = arrayList.iterator();
                    while (it.hasNext()) {
                        this.cameraInfoMap.remove((C0777n) it.next());
                    }
                }
                t tVar = t.f7040a;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // D.InterfaceC0779p
    public void b(Set<C0777n> addedCameraIds) {
        p.i(addedCameraIds, "addedCameraIds");
    }

    public InterfaceC0771h q(LifecycleOwner lifecycleOwner, CameraSelector cameraSelector, UseCase... useCases) {
        p.i(lifecycleOwner, "lifecycleOwner");
        p.i(cameraSelector, "cameraSelector");
        p.i(useCases, "useCases");
        C4996a.a("CX:bindToLifecycle");
        try {
            if (w() == 2) {
                throw new UnsupportedOperationException("bindToLifecycle for single camera is not supported in concurrent camera mode, call unbindAll() first");
            }
            G(1);
            return s(this, lifecycleOwner, cameraSelector, null, null, null, new C0759a0(r.V(useCases), null, null, 6, null), 28, null);
        } finally {
            C4996a.b();
        }
    }

    public final InterfaceC0771h r(LifecycleOwner lifecycleOwner, CameraSelector primaryCameraSelector, CameraSelector secondaryCameraSelector, A primaryCompositionSettings, A secondaryCompositionSettings, o0 sessionConfig) {
        CameraInternal cameraInternal;
        C0877d c0877d;
        C4996a.a("CX:bindToLifecycle-internal");
        try {
            M.n.b();
            Pair pairY = y(sessionConfig, primaryCameraSelector, secondaryCameraSelector);
            CameraSelector cameraSelector = (CameraSelector) pairY.a();
            CameraSelector cameraSelector2 = (CameraSelector) pairY.b();
            CameraX cameraX = this.cameraX;
            p.f(cameraX);
            CameraInternal cameraInternalG = cameraSelector.g(cameraX.j().m());
            p.h(cameraInternalG, "select(...)");
            cameraInternalG.q(true);
            InterfaceC0778o interfaceC0778oV = v(cameraSelector);
            p.g(interfaceC0778oV, "null cannot be cast to non-null type androidx.camera.core.impl.AdapterCameraInfo");
            C0877d c0877d2 = (C0877d) interfaceC0778oV;
            if (cameraSelector2 != null) {
                CameraX cameraX2 = this.cameraX;
                p.f(cameraX2);
                CameraInternal cameraInternalG2 = cameraSelector2.g(cameraX2.j().m());
                cameraInternalG2.q(false);
                InterfaceC0778o interfaceC0778oV2 = v(cameraSelector2);
                p.g(interfaceC0778oV2, "null cannot be cast to non-null type androidx.camera.core.impl.AdapterCameraInfo");
                c0877d = (C0877d) interfaceC0778oV2;
                cameraInternal = cameraInternalG2;
            } else {
                cameraInternal = null;
                c0877d = null;
            }
            C0777n c0777nE = C0777n.a.e(c0877d2, c0877d);
            k kVar = this.lifecycleCameraRepository;
            p.f(kVar);
            c cVarC = kVar.c(lifecycleOwner, c0777nE);
            k kVar2 = this.lifecycleCameraRepository;
            p.f(kVar2);
            Collection<c> collectionE = kVar2.e();
            for (UseCase useCase : sessionConfig.m()) {
                for (c cVar : collectionE) {
                    p.h(cVar, "next(...)");
                    c cVar2 = cVar;
                    if (cVar2.u(useCase) && !p.d(cVar2.s(), lifecycleOwner)) {
                        y yVar = y.f34840a;
                        String str = String.format("Use case %s already bound to a different lifecycle.", Arrays.copyOf(new Object[]{useCase}, 1));
                        p.h(str, "format(...)");
                        throw new IllegalStateException(str);
                    }
                }
            }
            if (cVarC == null) {
                k kVar3 = this.lifecycleCameraRepository;
                p.f(kVar3);
                CameraX cameraX3 = this.cameraX;
                p.f(cameraX3);
                CameraUseCaseAdapter cameraUseCaseAdapterB = cameraX3.k().b(cameraInternalG, cameraInternal, c0877d2, c0877d, primaryCompositionSettings, secondaryCompositionSettings);
                CameraX cameraX4 = this.cameraX;
                p.f(cameraX4);
                cVarC = kVar3.b(lifecycleOwner, cameraUseCaseAdapterB, cameraX4.n());
            }
            if (sessionConfig.m().isEmpty()) {
                p.f(cVarC);
            } else {
                k kVar4 = this.lifecycleCameraRepository;
                p.f(kVar4);
                p.f(cVarC);
                CameraX cameraX5 = this.cameraX;
                p.f(cameraX5);
                kVar4.a(cVarC, sessionConfig, cameraX5.i().g());
                this.lifecycleCameraKeys.add(k.a.a(lifecycleOwner, c0777nE));
            }
            return cVarC;
        } finally {
            C4996a.b();
        }
    }

    public final void t(androidx.camera.core.f cameraXConfig) {
        p.i(cameraXConfig, "cameraXConfig");
        C4996a.a("CX:configureInstanceInternal");
        try {
            synchronized (this.lock) {
                B0.h.f(cameraXConfig);
                B0.h.i(getCameraXConfigProvider() == null, "CameraX has already been configured. To use a different configuration, shutdown() must be called.");
                H(new a(cameraXConfig));
                t tVar = t.f7040a;
            }
        } finally {
            C4996a.b();
        }
    }

    public final androidx.camera.core.impl.g u(CameraSelector cameraSelector, InterfaceC0778o cameraInfo) {
        Iterator<InterfaceC0776m> it = cameraSelector.c().iterator();
        p.h(it, "iterator(...)");
        androidx.camera.core.impl.g gVar = null;
        while (it.hasNext()) {
            InterfaceC0776m next = it.next();
            p.h(next, "next(...)");
            InterfaceC0776m interfaceC0776m = next;
            if (!p.d(interfaceC0776m.a(), InterfaceC0776m.f2140a)) {
                K.r rVarA = X.a(interfaceC0776m.a());
                Context context = this.context;
                p.f(context);
                androidx.camera.core.impl.g gVarA = rVarA.a(cameraInfo, context);
                if (gVarA == null) {
                    continue;
                } else {
                    if (gVar != null) {
                        throw new IllegalArgumentException("Cannot apply multiple extended camera configs at the same time.");
                    }
                    gVar = gVarA;
                }
            }
        }
        return gVar == null ? C0895s.a() : gVar;
    }

    public InterfaceC0778o v(CameraSelector cameraSelector) {
        Object c0877d;
        p.i(cameraSelector, "cameraSelector");
        C4996a.a("CX:getCameraInfo");
        try {
            CameraX cameraX = this.cameraX;
            p.f(cameraX);
            InterfaceC0898v interfaceC0898vI = cameraSelector.g(cameraX.j().m()).i();
            p.h(interfaceC0898vI, "getCameraInfoInternal(...)");
            androidx.camera.core.impl.g gVarU = u(cameraSelector, interfaceC0898vI);
            String strH = interfaceC0898vI.h();
            p.h(strH, "getCameraId(...)");
            C0777n c0777nB = C0777n.a.b(strH, null, gVarU.a0());
            synchronized (this.lock) {
                try {
                    c0877d = this.cameraInfoMap.get(c0777nB);
                    if (c0877d == null) {
                        c0877d = new C0877d(interfaceC0898vI, gVarU);
                        this.cameraInfoMap.put(c0777nB, c0877d);
                    }
                    t tVar = t.f7040a;
                } catch (Throwable th) {
                    throw th;
                }
            }
            return (C0877d) c0877d;
        } finally {
            C4996a.b();
        }
    }

    public final int w() {
        if (!F()) {
            return 0;
        }
        CameraX cameraX = this.cameraX;
        p.f(cameraX);
        return cameraX.i().g().e();
    }

    /* renamed from: x, reason: from getter */
    public final f.b getCameraXConfigProvider() {
        return this.cameraXConfigProvider;
    }

    public final Pair<CameraSelector, CameraSelector> y(o0 sessionConfig, CameraSelector primaryCameraSelector, CameraSelector secondaryCameraSelector) {
        InterfaceC0776m cameraFilter = sessionConfig.getCameraFilter();
        if (cameraFilter == null) {
            return Y8.j.a(primaryCameraSelector, secondaryCameraSelector);
        }
        CameraSelector cameraSelectorB = CameraSelector.a.c(primaryCameraSelector).a(cameraFilter).b();
        p.h(cameraSelectorB, "build(...)");
        return Y8.j.a(cameraSelectorB, secondaryCameraSelector != null ? CameraSelector.a.c(secondaryCameraSelector).a(cameraFilter).b() : null);
    }

    public final InterfaceFutureC4095a<Void> z(final Context context, androidx.camera.core.f cameraXConfig) {
        p.i(context, "context");
        synchronized (this.lock) {
            this.lifecycleCameraRepository = j.a(M.e.e(context));
            InterfaceFutureC4095a<Void> interfaceFutureC4095a = this.cameraXInitializeFuture;
            if (interfaceFutureC4095a != null) {
                p.g(interfaceFutureC4095a, "null cannot be cast to non-null type com.google.common.util.concurrent.ListenableFuture<java.lang.Void>");
                return interfaceFutureC4095a;
            }
            if (cameraXConfig != null) {
                t(cameraXConfig);
            }
            final CameraX cameraX = new CameraX(context, this.cameraXConfigProvider);
            O.d dVarB = O.d.b(this.cameraXShutdownFuture);
            final InterfaceC5074l interfaceC5074l = new InterfaceC5074l() { // from class: a0.d
                @Override // p9.InterfaceC5074l
                public final Object invoke(Object obj) {
                    return i.A(cameraX, (Void) obj);
                }
            };
            O.d dVarF = dVarB.f(new O.a() { // from class: a0.e
                @Override // O.a
                public final InterfaceFutureC4095a apply(Object obj) {
                    return i.B(interfaceC5074l, obj);
                }
            }, N.a.a());
            final InterfaceC5074l interfaceC5074l2 = new InterfaceC5074l() { // from class: a0.f
                @Override // p9.InterfaceC5074l
                public final Object invoke(Object obj) {
                    return i.C(this.f7791a, cameraX, context, (Void) obj);
                }
            };
            O.d dVarE = dVarF.e(new InterfaceC4887a() { // from class: a0.g
                @Override // m.InterfaceC4887a
                public final Object apply(Object obj) {
                    return i.D(interfaceC5074l2, obj);
                }
            }, N.a.a());
            p.h(dVarE, "transform(...)");
            this.cameraXInitializeFuture = dVarE;
            O.f.b(dVarE, new b(), N.a.a());
            InterfaceFutureC4095a<Void> interfaceFutureC4095aI = O.f.i(dVarE);
            p.h(interfaceFutureC4095aI, "nonCancellationPropagating(...)");
            return interfaceFutureC4095aI;
        }
    }
}
