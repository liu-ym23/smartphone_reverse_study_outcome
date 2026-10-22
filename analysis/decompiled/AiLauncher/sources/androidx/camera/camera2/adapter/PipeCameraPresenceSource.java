package androidx.camera.camera2.adapter;

import D.C0777n;
import K.AbstractC0873b;
import Ua.C1060i;
import Ua.M;
import Xa.b;
import Xa.c;
import Xa.d;
import Y8.t;
import android.content.Context;
import android.hardware.camera2.CameraManager;
import android.util.Log;
import androidx.camera.camera2.adapter.PipeCameraPresenceSource;
import androidx.concurrent.futures.CallbackToFutureAdapter;
import com.autonavi.aps.amapapi.config.Const;
import com.stepos.ailauncher.chat.voice.support.C3081a;
import e9.InterfaceC4014c;
import f9.C4063a;
import g3.InterfaceFutureC4095a;
import g9.InterfaceC4112d;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Metadata;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.jvm.internal.Ref$BooleanRef;
import kotlin.jvm.internal.p;
import kotlinx.coroutines.g;
import w.C5708n;

@Metadata(d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 $2\u00020\u0001:\u0001%B9\u0012\u0012\u0010\u0005\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040\u00030\u0002\u0012\u0006\u0010\u0007\u001a\u00020\u0006\u0012\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\b0\u0003\u0012\u0006\u0010\u000b\u001a\u00020\n¢\u0006\u0004\b\f\u0010\rJ\u000f\u0010\u000f\u001a\u00020\u000eH\u0014¢\u0006\u0004\b\u000f\u0010\u0010J\u000f\u0010\u0011\u001a\u00020\u000eH\u0016¢\u0006\u0004\b\u0011\u0010\u0010J\u001b\u0010\u0014\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00130\u00030\u0012H\u0016¢\u0006\u0004\b\u0014\u0010\u0015R \u0010\u0005\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040\u00030\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u000f\u0010\u0016R\u0014\u0010\u0007\u001a\u00020\u00068\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0011\u0010\u0017R\u0014\u0010\u001b\u001a\u00020\u00188\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0019\u0010\u001aR\u0018\u0010\u001f\u001a\u0004\u0018\u00010\u001c8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u001d\u0010\u001eR\u0014\u0010#\u001a\u00020 8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b!\u0010\"¨\u0006&"}, d2 = {"Landroidx/camera/camera2/adapter/PipeCameraPresenceSource;", "LK/b;", "LXa/b;", "", "Lw/n;", "idFlow", "LUa/M;", "coroutineScope", "", "initialCameraIds", "Landroid/content/Context;", "context", "<init>", "(LXa/b;LUa/M;Ljava/util/List;Landroid/content/Context;)V", "LY8/t;", "f", "()V", Const.INTENT_KEY_BACKGROUND_COMMAND, "Lg3/a;", "LD/n;", Const.INTENT_KEY_PKGNAME, "()Lg3/a;", "LXa/b;", "LUa/M;", "Ljava/util/concurrent/atomic/AtomicBoolean;", Const.INTENT_KEY_BACKGROUND_NOTIFICATION, "Ljava/util/concurrent/atomic/AtomicBoolean;", "isMonitoring", "Lkotlinx/coroutines/g;", Const.INTENT_KEY_BACKGROUND_NOTIFICATION_ID, "Lkotlinx/coroutines/g;", "flowCollectionJob", "Landroid/hardware/camera2/CameraManager;", Const.INTENT_KEY_BACKGROUND_NOTIFICATION_REMOVE, "Landroid/hardware/camera2/CameraManager;", "cameraManager", "k", Const.INTENT_KEY_APIKEY, "camera-camera2"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes.dex */
public final class PipeCameraPresenceSource extends AbstractC0873b {

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    public final b<List<C5708n>> idFlow;

    /* renamed from: g, reason: collision with root package name and from kotlin metadata */
    public final M coroutineScope;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    public final AtomicBoolean isMonitoring;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    public g flowCollectionJob;

    /* renamed from: j, reason: collision with root package name and from kotlin metadata */
    public final CameraManager cameraManager;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public PipeCameraPresenceSource(b<? extends List<C5708n>> idFlow, M coroutineScope, List<String> initialCameraIds, Context context) {
        super(initialCameraIds);
        p.i(idFlow, "idFlow");
        p.i(coroutineScope, "coroutineScope");
        p.i(initialCameraIds, "initialCameraIds");
        p.i(context, "context");
        this.idFlow = idFlow;
        this.coroutineScope = coroutineScope;
        this.isMonitoring = new AtomicBoolean(false);
        Object systemService = context.getSystemService(C3081a.CAMERA_FOCUS);
        p.g(systemService, "null cannot be cast to non-null type android.hardware.camera2.CameraManager");
        this.cameraManager = (CameraManager) systemService;
    }

    public static final Object p(PipeCameraPresenceSource pipeCameraPresenceSource, CallbackToFutureAdapter.a completer) {
        p.i(completer, "completer");
        C1060i.d(pipeCameraPresenceSource.coroutineScope, null, null, new PipeCameraPresenceSource$fetchData$1$1(pipeCameraPresenceSource, completer, null), 3, null);
        return "FetchData for PipeCameraPresence0";
    }

    @Override // K.p0
    public InterfaceFutureC4095a<List<C0777n>> b() {
        InterfaceFutureC4095a<List<C0777n>> interfaceFutureC4095aA = CallbackToFutureAdapter.a(new CallbackToFutureAdapter.b() { // from class: o.H
            @Override // androidx.concurrent.futures.CallbackToFutureAdapter.b
            public final Object a(CallbackToFutureAdapter.a aVar) {
                return PipeCameraPresenceSource.p(this.f37312a, aVar);
            }
        });
        p.h(interfaceFutureC4095aA, "getFuture(...)");
        return interfaceFutureC4095aA;
    }

    @Override // K.AbstractC0873b
    public void f() {
        if (!this.isMonitoring.compareAndSet(false, true)) {
            Log.i("PipePresenceSrc", "Monitoring is already active. Ignoring redundant start call.");
            return;
        }
        Log.i("PipePresenceSrc", "Starting to collect camera ID flow.");
        g gVar = this.flowCollectionJob;
        if (gVar != null) {
            g.Y0(gVar, null, 1, null);
        }
        Ref$BooleanRef ref$BooleanRef = new Ref$BooleanRef();
        ref$BooleanRef.f34815a = true;
        final b<List<C5708n>> bVar = this.idFlow;
        this.flowCollectionJob = d.F(d.g(d.K(new b<List<? extends C0777n>>() { // from class: androidx.camera.camera2.adapter.PipeCameraPresenceSource$startMonitoring$$inlined$map$1

            @Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
            /* renamed from: androidx.camera.camera2.adapter.PipeCameraPresenceSource$startMonitoring$$inlined$map$1$2, reason: invalid class name */
            public static final class AnonymousClass2<T> implements c {

                /* renamed from: a, reason: collision with root package name */
                public final /* synthetic */ c f9331a;

                @InterfaceC4112d(c = "androidx.camera.camera2.adapter.PipeCameraPresenceSource$startMonitoring$$inlined$map$1$2", f = "PipeCameraPresenceSource.kt", l = {50}, m = "emit", v = 1)
                @Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
                /* renamed from: androidx.camera.camera2.adapter.PipeCameraPresenceSource$startMonitoring$$inlined$map$1$2$1, reason: invalid class name */
                public static final class AnonymousClass1 extends ContinuationImpl {

                    /* renamed from: a, reason: collision with root package name */
                    public /* synthetic */ Object f9332a;

                    /* renamed from: b, reason: collision with root package name */
                    public int f9333b;

                    public AnonymousClass1(InterfaceC4014c interfaceC4014c) {
                        super(interfaceC4014c);
                    }

                    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                    public final Object invokeSuspend(Object obj) {
                        this.f9332a = obj;
                        this.f9333b |= Integer.MIN_VALUE;
                        return AnonymousClass2.this.emit(null, this);
                    }
                }

                public AnonymousClass2(c cVar) {
                    this.f9331a = cVar;
                }

                /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
                @Override // Xa.c
                /*
                    Code decompiled incorrectly, please refer to instructions dump.
                    To view partially-correct add '--show-bad-code' argument
                */
                public final java.lang.Object emit(java.lang.Object r9, e9.InterfaceC4014c r10) throws java.lang.Throwable {
                    /*
                        r8 = this;
                        boolean r0 = r10 instanceof androidx.camera.camera2.adapter.PipeCameraPresenceSource$startMonitoring$$inlined$map$1.AnonymousClass2.AnonymousClass1
                        if (r0 == 0) goto L13
                        r0 = r10
                        androidx.camera.camera2.adapter.PipeCameraPresenceSource$startMonitoring$$inlined$map$1$2$1 r0 = (androidx.camera.camera2.adapter.PipeCameraPresenceSource$startMonitoring$$inlined$map$1.AnonymousClass2.AnonymousClass1) r0
                        int r1 = r0.f9333b
                        r2 = -2147483648(0xffffffff80000000, float:-0.0)
                        r3 = r1 & r2
                        if (r3 == 0) goto L13
                        int r1 = r1 - r2
                        r0.f9333b = r1
                        goto L18
                    L13:
                        androidx.camera.camera2.adapter.PipeCameraPresenceSource$startMonitoring$$inlined$map$1$2$1 r0 = new androidx.camera.camera2.adapter.PipeCameraPresenceSource$startMonitoring$$inlined$map$1$2$1
                        r0.<init>(r10)
                    L18:
                        java.lang.Object r10 = r0.f9332a
                        java.lang.Object r1 = f9.C4063a.g()
                        int r2 = r0.f9333b
                        r3 = 1
                        if (r2 == 0) goto L31
                        if (r2 != r3) goto L29
                        kotlin.C4849c.b(r10)
                        goto L80
                    L29:
                        java.lang.IllegalStateException r8 = new java.lang.IllegalStateException
                        java.lang.String r9 = "call to 'resume' before 'invoke' with coroutine"
                        r8.<init>(r9)
                        throw r8
                    L31:
                        kotlin.C4849c.b(r10)
                        Xa.c r8 = r8.f9331a
                        java.util.List r9 = (java.util.List) r9
                        java.lang.Iterable r9 = (java.lang.Iterable) r9
                        java.util.ArrayList r10 = new java.util.ArrayList
                        r10.<init>()
                        java.util.Iterator r9 = r9.iterator()
                    L43:
                        boolean r2 = r9.hasNext()
                        if (r2 == 0) goto L77
                        java.lang.Object r2 = r9.next()
                        w.n r2 = (w.C5708n) r2
                        java.lang.String r2 = r2.getValue()
                        r4 = 6
                        r5 = 0
                        D.n r5 = D.C0777n.a.d(r2, r5, r5, r4, r5)     // Catch: java.lang.Exception -> L5a
                        goto L71
                    L5a:
                        r4 = move-exception
                        java.lang.StringBuilder r6 = new java.lang.StringBuilder
                        r6.<init>()
                        java.lang.String r7 = "Failed to create CameraIdentifier for pipeId: "
                        r6.append(r7)
                        r6.append(r2)
                        java.lang.String r2 = r6.toString()
                        java.lang.String r6 = "PipePresenceSrc"
                        android.util.Log.w(r6, r2, r4)
                    L71:
                        if (r5 == 0) goto L43
                        r10.add(r5)
                        goto L43
                    L77:
                        r0.f9333b = r3
                        java.lang.Object r8 = r8.emit(r10, r0)
                        if (r8 != r1) goto L80
                        return r1
                    L80:
                        Y8.t r8 = Y8.t.f7040a
                        return r8
                    */
                    throw new UnsupportedOperationException("Method not decompiled: androidx.camera.camera2.adapter.PipeCameraPresenceSource$startMonitoring$$inlined$map$1.AnonymousClass2.emit(java.lang.Object, e9.c):java.lang.Object");
                }
            }

            @Override // Xa.b
            public Object collect(c<? super List<? extends C0777n>> cVar, InterfaceC4014c interfaceC4014c) {
                Object objCollect = bVar.collect(new AnonymousClass2(cVar), interfaceC4014c);
                return objCollect == C4063a.g() ? objCollect : t.f7040a;
            }
        }, new PipeCameraPresenceSource$startMonitoring$2(this, ref$BooleanRef, null)), new PipeCameraPresenceSource$startMonitoring$3(this, null)), this.coroutineScope);
    }

    @Override // K.AbstractC0873b
    public void g() {
        Log.i("PipePresenceSrc", "Stopping camera ID flow collection.");
        if (this.isMonitoring.compareAndSet(true, false)) {
            g gVar = this.flowCollectionJob;
            if (gVar != null) {
                g.Y0(gVar, null, 1, null);
            }
            this.flowCollectionJob = null;
        }
    }
}
