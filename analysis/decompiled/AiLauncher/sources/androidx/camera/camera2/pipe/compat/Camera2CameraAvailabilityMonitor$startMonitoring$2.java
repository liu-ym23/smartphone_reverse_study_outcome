package androidx.camera.camera2.pipe.compat;

import Ua.C1060i;
import Ua.InterfaceC1083u;
import Ua.L0;
import Ua.M;
import android.util.Log;
import androidx.camera.camera2.pipe.compat.n;
import com.autonavi.aps.amapapi.config.Const;
import e9.InterfaceC4014c;
import f9.C4063a;
import g9.InterfaceC4112d;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;
import kotlin.C4849c;
import kotlin.Metadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import w.C5708n;

@Metadata(d1 = {"\u00003\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0018\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0096@¢\u0006\u0004\b\u0005\u0010\u0006J\u000f\u0010\b\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\b\u0010\tR\u0014\u0010\r\u001a\u00020\n8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u000b\u0010\fR \u0010\u0012\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00070\u000f0\u000e8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0010\u0010\u0011¨\u0006\u0013"}, d2 = {"androidx/camera/camera2/pipe/compat/Camera2CameraAvailabilityMonitor$startMonitoring$2", "Landroidx/camera/camera2/pipe/compat/n$a;", "", "timeoutMillis", "", "c0", "(JLe9/c;)Ljava/lang/Object;", "LY8/t;", "close", "()V", "LUa/M;", Const.INTENT_KEY_APIKEY, "LUa/M;", "scope", "Ljava/util/concurrent/CopyOnWriteArrayList;", "LUa/u;", Const.INTENT_KEY_PKGNAME, "Ljava/util/concurrent/CopyOnWriteArrayList;", "listeners", "camera-camera2-pipe"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes.dex */
public final class Camera2CameraAvailabilityMonitor$startMonitoring$2 implements n.a {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    public final M scope;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    public final CopyOnWriteArrayList<InterfaceC1083u<Y8.t>> listeners;

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"LUa/M;", "LY8/t;", "<anonymous>", "(LUa/M;)V"}, k = 3, mv = {2, 1, 0})
    @InterfaceC4112d(c = "androidx.camera.camera2.pipe.compat.Camera2CameraAvailabilityMonitor$startMonitoring$2$1", f = "RetryingCameraStateOpener.kt", l = {170}, m = "invokeSuspend", v = 1)
    /* renamed from: androidx.camera.camera2.pipe.compat.Camera2CameraAvailabilityMonitor$startMonitoring$2$1, reason: invalid class name */
    public static final class AnonymousClass1 extends SuspendLambda implements p9.p<M, InterfaceC4014c<? super Y8.t>, Object> {

        /* renamed from: a, reason: collision with root package name */
        public int f10253a;

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ Camera2CameraAvailabilityMonitor f10254b;

        /* renamed from: c, reason: collision with root package name */
        public final /* synthetic */ String f10255c;

        /* renamed from: d, reason: collision with root package name */
        public final /* synthetic */ Camera2CameraAvailabilityMonitor$startMonitoring$2 f10256d;

        @Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
        /* renamed from: androidx.camera.camera2.pipe.compat.Camera2CameraAvailabilityMonitor$startMonitoring$2$1$a */
        public static final class a<T> implements Xa.c {

            /* renamed from: a, reason: collision with root package name */
            public final /* synthetic */ String f10257a;

            /* renamed from: b, reason: collision with root package name */
            public final /* synthetic */ Camera2CameraAvailabilityMonitor$startMonitoring$2 f10258b;

            public a(String str, Camera2CameraAvailabilityMonitor$startMonitoring$2 camera2CameraAvailabilityMonitor$startMonitoring$2) {
                this.f10257a = str;
                this.f10258b = camera2CameraAvailabilityMonitor$startMonitoring$2;
            }

            public final Object b(String str, InterfaceC4014c<? super Y8.t> interfaceC4014c) {
                if (C5708n.d(str, this.f10257a)) {
                    if (z.k.f44508a.a()) {
                        Log.d("CXCP", ((Object) C5708n.f(str)) + " has become available! Notifying listeners...");
                    }
                    Iterator it = this.f10258b.listeners.iterator();
                    kotlin.jvm.internal.p.h(it, "iterator(...)");
                    while (it.hasNext()) {
                        ((InterfaceC1083u) it.next()).complete(Y8.t.f7040a);
                    }
                }
                return Y8.t.f7040a;
            }

            @Override // Xa.c
            public /* bridge */ /* synthetic */ Object emit(Object obj, InterfaceC4014c interfaceC4014c) {
                return b(((C5708n) obj).getValue(), interfaceC4014c);
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass1(Camera2CameraAvailabilityMonitor camera2CameraAvailabilityMonitor, String str, Camera2CameraAvailabilityMonitor$startMonitoring$2 camera2CameraAvailabilityMonitor$startMonitoring$2, InterfaceC4014c<? super AnonymousClass1> interfaceC4014c) {
            super(2, interfaceC4014c);
            this.f10254b = camera2CameraAvailabilityMonitor;
            this.f10255c = str;
            this.f10256d = camera2CameraAvailabilityMonitor$startMonitoring$2;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final InterfaceC4014c<Y8.t> create(Object obj, InterfaceC4014c<?> interfaceC4014c) {
            return new AnonymousClass1(this.f10254b, this.f10255c, this.f10256d, interfaceC4014c);
        }

        @Override // p9.p
        public final Object invoke(M m10, InterfaceC4014c<? super Y8.t> interfaceC4014c) {
            return ((AnonymousClass1) create(m10, interfaceC4014c)).invokeSuspend(Y8.t.f7040a);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) throws Throwable {
            Object objG = C4063a.g();
            int i10 = this.f10253a;
            if (i10 == 0) {
                C4849c.b(obj);
                Xa.b bVar = this.f10254b.availableCameraFlow;
                a aVar = new a(this.f10255c, this.f10256d);
                this.f10253a = 1;
                if (bVar.collect(aVar, this) == objG) {
                    return objG;
                }
            } else {
                if (i10 != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                C4849c.b(obj);
            }
            return Y8.t.f7040a;
        }
    }

    public Camera2CameraAvailabilityMonitor$startMonitoring$2(Camera2CameraAvailabilityMonitor camera2CameraAvailabilityMonitor, String str) {
        M mA = kotlinx.coroutines.d.a(camera2CameraAvailabilityMonitor.threads.getBackgroundDispatcher().plus(L0.a(camera2CameraAvailabilityMonitor.cameraPipeJob)));
        this.scope = mA;
        this.listeners = new CopyOnWriteArrayList<>();
        C1060i.d(mA, null, null, new AnonymousClass1(camera2CameraAvailabilityMonitor, str, this, null), 3, null);
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    @Override // androidx.camera.camera2.pipe.compat.n.a
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public java.lang.Object c0(long r6, e9.InterfaceC4014c<? super java.lang.Boolean> r8) throws java.lang.Throwable {
        /*
            r5 = this;
            boolean r0 = r8 instanceof androidx.camera.camera2.pipe.compat.Camera2CameraAvailabilityMonitor$startMonitoring$2$awaitAvailableCamera$1
            if (r0 == 0) goto L13
            r0 = r8
            androidx.camera.camera2.pipe.compat.Camera2CameraAvailabilityMonitor$startMonitoring$2$awaitAvailableCamera$1 r0 = (androidx.camera.camera2.pipe.compat.Camera2CameraAvailabilityMonitor$startMonitoring$2$awaitAvailableCamera$1) r0
            int r1 = r0.f10262d
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.f10262d = r1
            goto L18
        L13:
            androidx.camera.camera2.pipe.compat.Camera2CameraAvailabilityMonitor$startMonitoring$2$awaitAvailableCamera$1 r0 = new androidx.camera.camera2.pipe.compat.Camera2CameraAvailabilityMonitor$startMonitoring$2$awaitAvailableCamera$1
            r0.<init>(r5, r8)
        L18:
            java.lang.Object r8 = r0.f10260b
            java.lang.Object r1 = f9.C4063a.g()
            int r2 = r0.f10262d
            r3 = 1
            if (r2 == 0) goto L35
            if (r2 != r3) goto L2d
            java.lang.Object r6 = r0.f10259a
            Ua.u r6 = (Ua.InterfaceC1083u) r6
            kotlin.C4849c.b(r8)
            goto L53
        L2d:
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
            java.lang.String r6 = "call to 'resume' before 'invoke' with coroutine"
            r5.<init>(r6)
            throw r5
        L35:
            kotlin.C4849c.b(r8)
            r8 = 0
            Ua.u r2 = Ua.C1087w.c(r8, r3, r8)
            java.util.concurrent.CopyOnWriteArrayList<Ua.u<Y8.t>> r4 = r5.listeners
            r4.add(r2)
            androidx.camera.camera2.pipe.compat.Camera2CameraAvailabilityMonitor$startMonitoring$2$awaitAvailableCamera$success$1 r4 = new androidx.camera.camera2.pipe.compat.Camera2CameraAvailabilityMonitor$startMonitoring$2$awaitAvailableCamera$success$1
            r4.<init>(r2, r8)
            r0.f10259a = r2
            r0.f10262d = r3
            java.lang.Object r8 = kotlinx.coroutines.TimeoutKt.e(r6, r4, r0)
            if (r8 != r1) goto L52
            return r1
        L52:
            r6 = r2
        L53:
            if (r8 == 0) goto L56
            goto L57
        L56:
            r3 = 0
        L57:
            java.util.concurrent.CopyOnWriteArrayList<Ua.u<Y8.t>> r5 = r5.listeners
            r5.remove(r6)
            java.lang.Boolean r5 = g9.C4109a.a(r3)
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.camera.camera2.pipe.compat.Camera2CameraAvailabilityMonitor$startMonitoring$2.c0(long, e9.c):java.lang.Object");
    }

    @Override // java.lang.AutoCloseable
    public void close() {
        kotlinx.coroutines.d.e(this.scope, null, 1, null);
    }
}
