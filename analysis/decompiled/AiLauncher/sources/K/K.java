package K;

import D.C0761b0;
import D.C0777n;
import D.InterfaceC0779p;
import K.InterfaceC0897u;
import K.K;
import K.p0;
import Z8.C1173v;
import Z8.C1174w;
import android.view.AbstractC1404w;
import androidx.camera.core.CameraState;
import androidx.camera.core.impl.CameraInternal;
import androidx.camera.core.impl.CameraValidator;
import androidx.exifinterface.media.ExifInterface;
import com.autonavi.aps.amapapi.config.Const;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.Executor;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Metadata;
import p9.InterfaceC5074l;

@Metadata(d1 = {"\u0000¬\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\"\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010%\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u0000 k2\u00020\u0001:\u0003>@<B\u0017\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0006\u0010\u0007J\u001d\u0010\f\u001a\u00020\u000b2\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\t0\bH\u0002¢\u0006\u0004\b\f\u0010\rJ+\u0010\u0011\u001a\u00020\u000b2\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\t0\u000e2\f\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\t0\u000eH\u0002¢\u0006\u0004\b\u0011\u0010\u0012J\u0017\u0010\u0015\u001a\u00020\u000b2\u0006\u0010\u0014\u001a\u00020\u0013H\u0002¢\u0006\u0004\b\u0015\u0010\u0016J\u0017\u0010\u0019\u001a\u00020\u000b2\u0006\u0010\u0018\u001a\u00020\u0017H\u0002¢\u0006\u0004\b\u0019\u0010\u001aJ\u000f\u0010\u001b\u001a\u00020\u000bH\u0002¢\u0006\u0004\b\u001b\u0010\u001cJ%\u0010 \u001a\u00020\u000b2\u0006\u0010\u001e\u001a\u00020\u001d2\f\u0010\u001f\u001a\b\u0012\u0004\u0012\u00020\t0\bH\u0002¢\u0006\u0004\b \u0010!J\u0017\u0010\"\u001a\u00020\u000b2\u0006\u0010\u0014\u001a\u00020\u0013H\u0002¢\u0006\u0004\b\"\u0010\u0016J\u000f\u0010#\u001a\u00020\u000bH\u0002¢\u0006\u0004\b#\u0010\u001cJ\u001d\u0010%\u001a\u00020\u000b2\f\u0010$\u001a\b\u0012\u0004\u0012\u00020\t0\u000eH\u0002¢\u0006\u0004\b%\u0010&J\u001d\u0010(\u001a\u00020\u000b2\f\u0010'\u001a\b\u0012\u0004\u0012\u00020\t0\u000eH\u0002¢\u0006\u0004\b(\u0010&J%\u0010/\u001a\u00020\u000b2\u0006\u0010*\u001a\u00020)2\u0006\u0010,\u001a\u00020+2\u0006\u0010.\u001a\u00020-¢\u0006\u0004\b/\u00100J\r\u00101\u001a\u00020\u000b¢\u0006\u0004\b1\u0010\u001cJ\u0015\u00104\u001a\u00020\u000b2\u0006\u00103\u001a\u000202¢\u0006\u0004\b4\u00105J\u001d\u00108\u001a\u00020\u000b2\u0006\u00103\u001a\u0002062\u0006\u00107\u001a\u00020\u0002¢\u0006\u0004\b8\u00109J\u0015\u0010:\u001a\u00020\u000b2\u0006\u00103\u001a\u000206¢\u0006\u0004\b:\u0010;R\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b<\u0010=R\u0014\u0010\u0005\u001a\u00020\u00048\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b>\u0010?R\u0014\u0010B\u001a\u00020\u00018\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b@\u0010AR\u0014\u0010D\u001a\u00020\u00018\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bC\u0010AR\u001c\u0010H\u001a\b\u0012\u0002\b\u0003\u0018\u00010E8\u0002@\u0002X\u0083\u000e¢\u0006\u0006\n\u0004\bF\u0010GR\u0018\u0010,\u001a\u0004\u0018\u00010+8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bI\u0010JR\u0018\u0010.\u001a\u0004\u0018\u00010-8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bK\u0010LR$\u0010P\u001a\u0010\u0012\n\u0012\b\u0012\u0004\u0012\u00020\t0\b\u0018\u00010M8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bN\u0010OR\u0018\u0010*\u001a\u0004\u0018\u00010)8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bQ\u0010RR\u0018\u0010V\u001a\u00060SR\u00020\u00008\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bT\u0010UR\u001c\u0010Y\u001a\b\u0012\u0004\u0012\u00020\t0\b8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bW\u0010XR\u0014\u0010]\u001a\u00020Z8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b[\u0010\\R\u001a\u0010a\u001a\b\u0012\u0004\u0012\u0002020^8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b_\u0010`R\u001a\u0010d\u001a\b\u0012\u0004\u0012\u00020b0^8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bc\u0010`R&\u0010j\u001a\u0014\u0012\u0004\u0012\u00020\u0013\u0012\n\u0012\b\u0012\u0004\u0012\u00020g0f0e8\u0002X\u0083\u0004¢\u0006\u0006\n\u0004\bh\u0010i¨\u0006l"}, d2 = {"LK/K;", "", "Ljava/util/concurrent/Executor;", "backgroundExecutor", "Ljava/util/concurrent/ScheduledExecutorService;", "scheduledExecutor", "<init>", "(Ljava/util/concurrent/Executor;Ljava/util/concurrent/ScheduledExecutorService;)V", "", "LD/n;", "newFilteredIdentifiers", "LY8/t;", ExifInterface.LONGITUDE_EAST, "(Ljava/util/List;)V", "", "addedCameras", "removedCameras", "D", "(Ljava/util/Set;Ljava/util/Set;)V", "", "systemCameraId", "y", "(Ljava/lang/String;)V", "LK/v;", "cameraInfoInternal", "M", "(LK/v;)V", ExifInterface.GPS_DIRECTION_TRUE, "()V", "", "attemptsLeft", "initialIds", "J", "(ILjava/util/List;)V", "H", "w", "addedIds", "z", "(Ljava/util/Set;)V", "removedIds", "B", "Landroidx/camera/core/impl/CameraValidator;", "cameraValidator", "LK/u;", "cameraFactory", "LK/N;", "cameraRepository", "R", "(Landroidx/camera/core/impl/CameraValidator;LK/u;LK/N;)V", "Q", "LK/c0;", "listener", "v", "(LK/c0;)V", "LD/p;", "executor", "t", "(LD/p;Ljava/util/concurrent/Executor;)V", "F", "(LD/p;)V", Const.INTENT_KEY_APIKEY, "Ljava/util/concurrent/Executor;", Const.INTENT_KEY_PKGNAME, "Ljava/util/concurrent/ScheduledExecutorService;", "c", "Ljava/lang/Object;", "observerLock", Const.INTENT_KEY_UMID, "retryLock", "Ljava/util/concurrent/ScheduledFuture;", "e", "Ljava/util/concurrent/ScheduledFuture;", "retryScanFuture", "f", "LK/u;", Const.INTENT_KEY_BACKGROUND_COMMAND, "LK/N;", "LK/p0;", Const.INTENT_KEY_BACKGROUND_NOTIFICATION, "LK/p0;", "sourcePresenceObservable", Const.INTENT_KEY_BACKGROUND_NOTIFICATION_ID, "Landroidx/camera/core/impl/CameraValidator;", "LK/K$c;", Const.INTENT_KEY_BACKGROUND_NOTIFICATION_REMOVE, "LK/K$c;", "sourceObserver", "k", "Ljava/util/List;", "currentFilteredIds", "Ljava/util/concurrent/atomic/AtomicBoolean;", "l", "Ljava/util/concurrent/atomic/AtomicBoolean;", "isMonitoring", "Ljava/util/concurrent/CopyOnWriteArrayList;", "m", "Ljava/util/concurrent/CopyOnWriteArrayList;", "dependentInternalListeners", "LK/K$b;", "n", "publicApiListeners", "", "Landroidx/lifecycle/z;", "Landroidx/camera/core/CameraState;", "o", "Ljava/util/Map;", "cameraStateObservers", "p", "camera-core"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes.dex */
public final class K {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    public final Executor backgroundExecutor;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    public final ScheduledExecutorService scheduledExecutor;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    public final Object observerLock;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    public final Object retryLock;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    public ScheduledFuture<?> retryScanFuture;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    public InterfaceC0897u cameraFactory;

    /* renamed from: g, reason: collision with root package name and from kotlin metadata */
    public N cameraRepository;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    public p0<List<C0777n>> sourcePresenceObservable;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    public CameraValidator cameraValidator;

    /* renamed from: j, reason: collision with root package name and from kotlin metadata */
    public final c sourceObserver;

    /* renamed from: k, reason: collision with root package name and from kotlin metadata */
    public volatile List<C0777n> currentFilteredIds;

    /* renamed from: l, reason: collision with root package name and from kotlin metadata */
    public final AtomicBoolean isMonitoring;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    public final CopyOnWriteArrayList<InterfaceC0876c0> dependentInternalListeners;

    /* renamed from: n, reason: collision with root package name and from kotlin metadata */
    public final CopyOnWriteArrayList<ListenerWrapper> publicApiListeners;

    /* renamed from: o, reason: collision with root package name and from kotlin metadata */
    public final Map<String, android.view.z<CameraState>> cameraStateObservers;

    @Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\t\b\u0082\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\t\u001a\u00020\bHÖ\u0001¢\u0006\u0004\b\t\u0010\nJ\u0010\u0010\f\u001a\u00020\u000bHÖ\u0001¢\u0006\u0004\b\f\u0010\rJ\u001a\u0010\u0010\u001a\u00020\u000f2\b\u0010\u000e\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u0010\u0010\u0011R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0012\u0010\u0013\u001a\u0004\b\u0014\u0010\u0015R\u0017\u0010\u0005\u001a\u00020\u00048\u0006¢\u0006\f\n\u0004\b\u0014\u0010\u0016\u001a\u0004\b\u0012\u0010\u0017¨\u0006\u0018"}, d2 = {"LK/K$b;", "", "LD/p;", "listener", "Ljava/util/concurrent/Executor;", "executor", "<init>", "(LD/p;Ljava/util/concurrent/Executor;)V", "", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "other", "", "equals", "(Ljava/lang/Object;)Z", Const.INTENT_KEY_APIKEY, "LD/p;", Const.INTENT_KEY_PKGNAME, "()LD/p;", "Ljava/util/concurrent/Executor;", "()Ljava/util/concurrent/Executor;", "camera-core"}, k = 1, mv = {2, 1, 0}, xi = 48)
    /* renamed from: K.K$b, reason: from toString */
    public static final /* data */ class ListenerWrapper {

        /* renamed from: a, reason: collision with root package name and from kotlin metadata and from toString */
        public final InterfaceC0779p listener;

        /* renamed from: b, reason: collision with root package name and from kotlin metadata and from toString */
        public final Executor executor;

        public ListenerWrapper(InterfaceC0779p listener, Executor executor) {
            kotlin.jvm.internal.p.i(listener, "listener");
            kotlin.jvm.internal.p.i(executor, "executor");
            this.listener = listener;
            this.executor = executor;
        }

        /* renamed from: a, reason: from getter */
        public final Executor getExecutor() {
            return this.executor;
        }

        /* renamed from: b, reason: from getter */
        public final InterfaceC0779p getListener() {
            return this.listener;
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof ListenerWrapper)) {
                return false;
            }
            ListenerWrapper listenerWrapper = (ListenerWrapper) other;
            return kotlin.jvm.internal.p.d(this.listener, listenerWrapper.listener) && kotlin.jvm.internal.p.d(this.executor, listenerWrapper.executor);
        }

        public int hashCode() {
            return (this.listener.hashCode() * 31) + this.executor.hashCode();
        }

        public String toString() {
            return "ListenerWrapper(listener=" + this.listener + ", executor=" + this.executor + ')';
        }
    }

    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0003\n\u0002\b\u0004\b\u0082\u0004\u0018\u00002\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\u00020\u0001B\u0007¢\u0006\u0004\b\u0004\u0010\u0005J\u001f\u0010\b\u001a\u00020\u00072\u000e\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0002H\u0016¢\u0006\u0004\b\b\u0010\tJ\u0017\u0010\f\u001a\u00020\u00072\u0006\u0010\u000b\u001a\u00020\nH\u0016¢\u0006\u0004\b\f\u0010\r¨\u0006\u000e"}, d2 = {"LK/K$c;", "LK/p0$a;", "", "LD/n;", "<init>", "(LK/K;)V", "rawCameraIdentifiers", "LY8/t;", Const.INTENT_KEY_PKGNAME, "(Ljava/util/List;)V", "", "t", "onError", "(Ljava/lang/Throwable;)V", "camera-core"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public final class c implements p0.a<List<? extends C0777n>> {
        public c() {
        }

        @Override // K.p0.a
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public void a(List<C0777n> rawCameraIdentifiers) {
            InterfaceC0897u interfaceC0897u;
            N n10;
            CameraValidator cameraValidator;
            List<String> listM;
            if (!K.this.isMonitoring.get() || (interfaceC0897u = K.this.cameraFactory) == null || (n10 = K.this.cameraRepository) == null || (cameraValidator = K.this.cameraValidator) == null) {
                return;
            }
            if (rawCameraIdentifiers != null) {
                List<C0777n> list = rawCameraIdentifiers;
                listM = new ArrayList<>(C1174w.x(list, 10));
                Iterator<T> it = list.iterator();
                while (it.hasNext()) {
                    listM.add(((C0777n) it.next()).b());
                }
            } else {
                listM = C1173v.m();
            }
            if (interfaceC0897u instanceof InterfaceC0897u.a) {
                try {
                    List list2 = K.this.currentFilteredIds;
                    List<String> listD = ((InterfaceC0897u.a) interfaceC0897u).d(listM);
                    kotlin.jvm.internal.p.h(listD, "getAvailableCameraIds(...)");
                    List<String> list3 = listD;
                    ArrayList arrayList = new ArrayList(C1174w.x(list3, 10));
                    for (String str : list3) {
                        kotlin.jvm.internal.p.f(str);
                        arrayList.add(C0777n.a.d(str, null, null, 6, null));
                    }
                    Set<C0777n> setM = Z8.Z.m(Z8.F.r1(list2), Z8.F.r1(arrayList));
                    if (!setM.isEmpty()) {
                        LinkedHashSet<CameraInternal> linkedHashSetM = n10.m();
                        kotlin.jvm.internal.p.h(linkedHashSetM, "getCameras(...)");
                        if (cameraValidator.b(linkedHashSetM, setM)) {
                            C0761b0.o("CameraPresencePrvdr", "Camera removal update invalid. Aborting.");
                            return;
                        }
                    }
                } catch (Exception e10) {
                    C0761b0.p("CameraPresencePrvdr", "Failed to interrogate camera factory. Falling back to full update.", e10);
                }
            }
            try {
                interfaceC0897u.e(listM);
                Set<String> setC = interfaceC0897u.c();
                kotlin.jvm.internal.p.h(setC, "getAvailableCameraIds(...)");
                Set<String> set = setC;
                ArrayList arrayList2 = new ArrayList(C1174w.x(set, 10));
                for (String str2 : set) {
                    kotlin.jvm.internal.p.f(str2);
                    arrayList2.add(C0777n.a.d(str2, null, null, 6, null));
                }
                if (kotlin.jvm.internal.p.d(arrayList2, K.this.currentFilteredIds)) {
                    return;
                }
                K.this.E(arrayList2);
            } catch (Exception e11) {
                C0761b0.p("CameraPresencePrvdr", "CameraFactory failed to update. The camera list may be stale until the next update.", e11);
            }
        }

        @Override // K.p0.a
        public void onError(Throwable t10) {
            kotlin.jvm.internal.p.i(t10, "t");
            if (K.this.isMonitoring.get()) {
                C0761b0.d("CameraPresencePrvdr", "Error from source camera presence observable. Triggering refresh.", t10);
                p0 p0Var = K.this.sourcePresenceObservable;
                if (p0Var != null) {
                    p0Var.b();
                }
            }
        }
    }

    public K(Executor backgroundExecutor, ScheduledExecutorService scheduledExecutor) {
        kotlin.jvm.internal.p.i(backgroundExecutor, "backgroundExecutor");
        kotlin.jvm.internal.p.i(scheduledExecutor, "scheduledExecutor");
        this.backgroundExecutor = backgroundExecutor;
        this.scheduledExecutor = scheduledExecutor;
        this.observerLock = new Object();
        this.retryLock = new Object();
        this.sourceObserver = new c();
        this.currentFilteredIds = C1173v.m();
        this.isMonitoring = new AtomicBoolean(false);
        this.dependentInternalListeners = new CopyOnWriteArrayList<>();
        this.publicApiListeners = new CopyOnWriteArrayList<>();
        this.cameraStateObservers = new LinkedHashMap();
    }

    public static final void A(ListenerWrapper listenerWrapper, Set set) {
        listenerWrapper.getListener().b(set);
    }

    public static final void C(ListenerWrapper listenerWrapper, Set set) {
        listenerWrapper.getListener().a(set);
    }

    public static final boolean G(InterfaceC0779p interfaceC0779p, ListenerWrapper listenerWrapper) {
        return kotlin.jvm.internal.p.d(listenerWrapper.getListener(), interfaceC0779p);
    }

    public static final void I(CameraInternal cameraInternal, android.view.z zVar) {
        cameraInternal.getCameraInfo().y().j(zVar);
    }

    public static final void K(final K k10, final List list, final int i10) {
        k10.backgroundExecutor.execute(new Runnable() { // from class: K.A
            @Override // java.lang.Runnable
            public final void run() {
                K.L(this.f3850a, list, i10);
            }
        });
    }

    public static final void L(K k10, List list, int i10) {
        if (k10.isMonitoring.get() && kotlin.jvm.internal.p.d(k10.currentFilteredIds, list)) {
            C0761b0.a("CameraPresencePrvdr", "Triggering refresh. Attempts left: " + i10);
            p0<List<C0777n>> p0Var = k10.sourcePresenceObservable;
            if (p0Var != null) {
                p0Var.b();
            }
            k10.J(i10 - 1, list);
        }
    }

    public static final void N(final K k10, String str, CameraState cameraState) {
        if (!k10.isMonitoring.get()) {
            C0761b0.a("CameraPresencePrvdr", "Ignore camera state change handling since already stop monitoring");
            return;
        }
        if (cameraState.b() != null) {
            StringBuilder sb2 = new StringBuilder();
            sb2.append("Camera ");
            sb2.append(str);
            sb2.append(" state changed to ");
            sb2.append(cameraState.c());
            sb2.append(" with error: ");
            CameraState.a aVarB = cameraState.b();
            sb2.append(aVarB != null ? Integer.valueOf(aVarB.d()) : null);
            sb2.append(". Triggering refresh.");
            C0761b0.o("CameraPresencePrvdr", sb2.toString());
            k10.backgroundExecutor.execute(new Runnable() { // from class: K.H
                @Override // java.lang.Runnable
                public final void run() {
                    K.O(this.f3888a);
                }
            });
        }
    }

    public static final void O(K k10) {
        k10.T();
    }

    public static final void P(InterfaceC0898v interfaceC0898v, android.view.z zVar) {
        interfaceC0898v.y().f(zVar);
    }

    public static final void S(K k10) {
        Iterator<T> it = k10.currentFilteredIds.iterator();
        while (it.hasNext()) {
            k10.y(((C0777n) it.next()).b());
        }
    }

    public static final void u(K k10, InterfaceC0779p interfaceC0779p) {
        Set<C0777n> setR1 = Z8.F.r1(k10.currentFilteredIds);
        if (setR1.isEmpty()) {
            return;
        }
        interfaceC0779p.b(setR1);
    }

    public static final void x(List list, android.view.z zVar, String str) {
        Object next;
        AbstractC1404w<CameraState> abstractC1404wY;
        try {
            Iterator it = list.iterator();
            while (true) {
                if (!it.hasNext()) {
                    next = null;
                    break;
                } else {
                    next = it.next();
                    if (kotlin.jvm.internal.p.d(((InterfaceC0898v) next).h(), str)) {
                        break;
                    }
                }
            }
            InterfaceC0898v interfaceC0898v = (InterfaceC0898v) next;
            if (interfaceC0898v == null || (abstractC1404wY = interfaceC0898v.y()) == null) {
                return;
            }
            abstractC1404wY.j(zVar);
        } catch (IllegalArgumentException unused) {
        }
    }

    public final void B(final Set<C0777n> removedIds) {
        for (final ListenerWrapper listenerWrapper : this.publicApiListeners) {
            listenerWrapper.getExecutor().execute(new Runnable() { // from class: K.y
                @Override // java.lang.Runnable
                public final void run() {
                    K.C(listenerWrapper, removedIds);
                }
            });
        }
    }

    public final void D(Set<C0777n> addedCameras, Set<C0777n> removedCameras) {
        if (!addedCameras.isEmpty()) {
            C0761b0.e("CameraPresencePrvdr", "Notifying " + addedCameras.size() + " cameras added.");
            z(addedCameras);
        }
        if (removedCameras.isEmpty()) {
            return;
        }
        C0761b0.e("CameraPresencePrvdr", "Notifying " + removedCameras.size() + " cameras removed.");
        B(removedCameras);
    }

    public final void E(List<C0777n> newFilteredIdentifiers) {
        List listM1 = Z8.F.m1(this.currentFilteredIds);
        if (kotlin.jvm.internal.p.d(newFilteredIdentifiers, listM1)) {
            return;
        }
        synchronized (this.retryLock) {
            try {
                if (this.retryScanFuture != null) {
                    C0761b0.a("CameraPresencePrvdr", "Camera list updated. Cancelling any pending retries.");
                    ScheduledFuture<?> scheduledFuture = this.retryScanFuture;
                    kotlin.jvm.internal.p.f(scheduledFuture);
                    scheduledFuture.cancel(false);
                    this.retryScanFuture = null;
                }
                Y8.t tVar = Y8.t.f7040a;
            } catch (Throwable th) {
                throw th;
            }
        }
        List list = listM1;
        Set setR1 = Z8.F.r1(list);
        List<C0777n> list2 = newFilteredIdentifiers;
        Set setR12 = Z8.F.r1(list2);
        Set<C0777n> setM = Z8.Z.m(setR12, setR1);
        Set<C0777n> setM2 = Z8.Z.m(setR1, setR12);
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList(C1174w.x(list2, 10));
        Iterator<T> it = list2.iterator();
        while (it.hasNext()) {
            arrayList2.add(((C0777n) it.next()).b());
        }
        try {
            Iterator<T> it2 = setM2.iterator();
            while (it2.hasNext()) {
                H(((C0777n) it2.next()).b());
            }
            N n10 = this.cameraRepository;
            if (n10 != null) {
                C0761b0.a("CameraPresencePrvdr", "Updating CameraRepository...");
                n10.f(arrayList2);
                arrayList.add(n10);
                C0761b0.a("CameraPresencePrvdr", "CameraRepository updated successfully.");
            }
            if (!this.dependentInternalListeners.isEmpty()) {
                C0761b0.a("CameraPresencePrvdr", "Updating " + this.dependentInternalListeners.size() + " dependent listeners...");
                for (InterfaceC0876c0 interfaceC0876c0 : this.dependentInternalListeners) {
                    interfaceC0876c0.f(arrayList2);
                    kotlin.jvm.internal.p.f(interfaceC0876c0);
                    arrayList.add(interfaceC0876c0);
                }
            }
            this.currentFilteredIds = newFilteredIdentifiers;
            Iterator<T> it3 = setM.iterator();
            while (it3.hasNext()) {
                y(((C0777n) it3.next()).b());
            }
            D(setM, setM2);
        } catch (Exception e10) {
            C0761b0.d("CameraPresencePrvdr", "A core module failed to update. Rolling back changes.", e10);
            ArrayList arrayList3 = new ArrayList(C1174w.x(list, 10));
            Iterator it4 = list.iterator();
            while (it4.hasNext()) {
                arrayList3.add(((C0777n) it4.next()).b());
            }
            for (InterfaceC0876c0 interfaceC0876c02 : Z8.B.V(arrayList)) {
                try {
                    interfaceC0876c02.f(arrayList3);
                } catch (Exception e11) {
                    C0761b0.d("CameraPresencePrvdr", "Failed to rollback listener: " + interfaceC0876c02, e11);
                }
            }
            Iterator<T> it5 = setM2.iterator();
            while (it5.hasNext()) {
                y(((C0777n) it5.next()).b());
            }
            Iterator<T> it6 = setM.iterator();
            while (it6.hasNext()) {
                H(((C0777n) it6.next()).b());
            }
        }
    }

    public final void F(final InterfaceC0779p listener) {
        kotlin.jvm.internal.p.i(listener, "listener");
        Z8.A.L(this.publicApiListeners, new InterfaceC5074l() { // from class: K.G
            @Override // p9.InterfaceC5074l
            public final Object invoke(Object obj) {
                return Boolean.valueOf(K.G(listener, (K.ListenerWrapper) obj));
            }
        });
    }

    public final void H(String systemCameraId) {
        synchronized (this.observerLock) {
            final android.view.z<CameraState> zVarRemove = this.cameraStateObservers.remove(systemCameraId);
            N n10 = this.cameraRepository;
            if (zVarRemove != null && n10 != null) {
                try {
                    final CameraInternal cameraInternalL = n10.l(systemCameraId);
                    kotlin.jvm.internal.p.h(cameraInternalL, "getCamera(...)");
                    N.a.d().execute(new Runnable() { // from class: K.B
                        @Override // java.lang.Runnable
                        public final void run() {
                            K.I(cameraInternalL, zVarRemove);
                        }
                    });
                    C0761b0.a("CameraPresencePrvdr", "Removed state observer for: " + systemCameraId);
                } catch (IllegalArgumentException unused) {
                }
            }
            Y8.t tVar = Y8.t.f7040a;
        }
    }

    public final void J(final int attemptsLeft, final List<C0777n> initialIds) {
        if (attemptsLeft > 0 && this.isMonitoring.get()) {
            this.retryScanFuture = this.scheduledExecutor.schedule(new Runnable() { // from class: K.J
                @Override // java.lang.Runnable
                public final void run() {
                    K.K(this.f3892a, initialIds, attemptsLeft);
                }
            }, attemptsLeft == 3 ? 0L : 400L, TimeUnit.MILLISECONDS);
        } else if (attemptsLeft <= 0) {
            C0761b0.o("CameraPresencePrvdr", "Exhausted all retries for camera list refresh.");
        }
    }

    public final void M(final InterfaceC0898v cameraInfoInternal) {
        final String strH = cameraInfoInternal.h();
        kotlin.jvm.internal.p.h(strH, "getCameraId(...)");
        if (this.isMonitoring.get()) {
            synchronized (this.observerLock) {
                if (this.cameraStateObservers.containsKey(strH)) {
                    return;
                }
                final android.view.z<CameraState> zVar = new android.view.z() { // from class: K.E
                    @Override // android.view.z
                    public final void a(Object obj) {
                        K.N(this.f3877a, strH, (CameraState) obj);
                    }
                };
                N.a.d().execute(new Runnable() { // from class: K.F
                    @Override // java.lang.Runnable
                    public final void run() {
                        K.P(cameraInfoInternal, zVar);
                    }
                });
                this.cameraStateObservers.put(strH, zVar);
                C0761b0.a("CameraPresencePrvdr", "Registered state observer for camera: " + strH);
                Y8.t tVar = Y8.t.f7040a;
            }
        }
    }

    public final void Q() {
        if (!this.isMonitoring.getAndSet(false)) {
            C0761b0.a("CameraPresencePrvdr", "Shutdown called when not monitoring. Ignoring.");
            return;
        }
        C0761b0.e("CameraPresencePrvdr", "Shutting down CameraPresenceProvider monitoring.");
        synchronized (this.retryLock) {
            try {
                ScheduledFuture<?> scheduledFuture = this.retryScanFuture;
                if (scheduledFuture != null) {
                    scheduledFuture.cancel(false);
                }
                this.retryScanFuture = null;
                Y8.t tVar = Y8.t.f7040a;
            } catch (Throwable th) {
                throw th;
            }
        }
        p0<List<C0777n>> p0Var = this.sourcePresenceObservable;
        if (p0Var != null) {
            p0Var.c(this.sourceObserver);
        }
        w();
        this.cameraValidator = null;
        this.dependentInternalListeners.clear();
        this.publicApiListeners.clear();
        this.currentFilteredIds = C1173v.m();
        this.cameraFactory = null;
        this.cameraRepository = null;
    }

    public final void R(CameraValidator cameraValidator, InterfaceC0897u cameraFactory, N cameraRepository) {
        kotlin.jvm.internal.p.i(cameraValidator, "cameraValidator");
        kotlin.jvm.internal.p.i(cameraFactory, "cameraFactory");
        kotlin.jvm.internal.p.i(cameraRepository, "cameraRepository");
        if (this.isMonitoring.compareAndSet(false, true)) {
            C0761b0.e("CameraPresencePrvdr", "Starting CameraPresenceProvider monitoring.");
            this.cameraValidator = cameraValidator;
            Set<String> setC = cameraFactory.c();
            kotlin.jvm.internal.p.h(setC, "getAvailableCameraIds(...)");
            Set<String> set = setC;
            ArrayList arrayList = new ArrayList(C1174w.x(set, 10));
            for (String str : set) {
                kotlin.jvm.internal.p.f(str);
                arrayList.add(C0777n.a.d(str, null, null, 6, null));
            }
            this.currentFilteredIds = arrayList;
            this.cameraFactory = cameraFactory;
            this.cameraRepository = cameraRepository;
            this.sourcePresenceObservable = cameraFactory.b();
            this.backgroundExecutor.execute(new Runnable() { // from class: K.z
                @Override // java.lang.Runnable
                public final void run() {
                    K.S(this.f4023a);
                }
            });
            p0<List<C0777n>> p0Var = this.sourcePresenceObservable;
            if (p0Var != null) {
                p0Var.a(N.a.f(this.backgroundExecutor), this.sourceObserver);
            }
        }
    }

    public final void T() {
        synchronized (this.retryLock) {
            try {
                ScheduledFuture<?> scheduledFuture = this.retryScanFuture;
                if (scheduledFuture != null) {
                    scheduledFuture.cancel(false);
                }
                C0761b0.a("CameraPresencePrvdr", "Starting new refresh-with-retries sequence.");
                J(3, this.currentFilteredIds);
                Y8.t tVar = Y8.t.f7040a;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public final void t(final InterfaceC0779p listener, Executor executor) {
        kotlin.jvm.internal.p.i(listener, "listener");
        kotlin.jvm.internal.p.i(executor, "executor");
        this.publicApiListeners.add(new ListenerWrapper(listener, executor));
        executor.execute(new Runnable() { // from class: K.D
            @Override // java.lang.Runnable
            public final void run() {
                K.u(this.f3872a, listener);
            }
        });
    }

    public final void v(InterfaceC0876c0 listener) {
        kotlin.jvm.internal.p.i(listener, "listener");
        this.dependentInternalListeners.add(listener);
    }

    public final void w() {
        synchronized (this.observerLock) {
            if (this.cameraStateObservers.isEmpty()) {
                return;
            }
            Map mapA = kotlin.collections.a.A(this.cameraStateObservers);
            this.cameraStateObservers.clear();
            Y8.t tVar = Y8.t.f7040a;
            N n10 = this.cameraRepository;
            if (n10 != null) {
                LinkedHashSet<CameraInternal> linkedHashSetM = n10.m();
                kotlin.jvm.internal.p.h(linkedHashSetM, "getCameras(...)");
                final ArrayList arrayList = new ArrayList();
                for (CameraInternal cameraInternal : linkedHashSetM) {
                    InterfaceC0898v interfaceC0898vI = cameraInternal != null ? cameraInternal.getCameraInfo() : null;
                    if (interfaceC0898vI != null) {
                        arrayList.add(interfaceC0898vI);
                    }
                }
                C0761b0.a("CameraPresencePrvdr", "Clearing all " + mapA.size() + " state observers.");
                for (Map.Entry entry : mapA.entrySet()) {
                    final String str = (String) entry.getKey();
                    final android.view.z zVar = (android.view.z) entry.getValue();
                    N.a.d().execute(new Runnable() { // from class: K.I
                        @Override // java.lang.Runnable
                        public final void run() {
                            K.x(arrayList, zVar, str);
                        }
                    });
                }
            }
        }
    }

    public final void y(String systemCameraId) {
        N n10 = this.cameraRepository;
        if (n10 == null) {
            return;
        }
        try {
            CameraInternal cameraInternalL = n10.l(systemCameraId);
            kotlin.jvm.internal.p.h(cameraInternalL, "getCamera(...)");
            InterfaceC0898v interfaceC0898vI = cameraInternalL.getCameraInfo();
            kotlin.jvm.internal.p.h(interfaceC0898vI, "getCameraInfoInternal(...)");
            M(interfaceC0898vI);
        } catch (IllegalArgumentException unused) {
            C0761b0.o("CameraPresencePrvdr", "CameraInternal not found for " + systemCameraId + ". Cannot setup state observer.");
        }
    }

    public final void z(final Set<C0777n> addedIds) {
        for (final ListenerWrapper listenerWrapper : this.publicApiListeners) {
            listenerWrapper.getExecutor().execute(new Runnable() { // from class: K.C
                @Override // java.lang.Runnable
                public final void run() {
                    K.A(listenerWrapper, addedIds);
                }
            });
        }
    }
}
