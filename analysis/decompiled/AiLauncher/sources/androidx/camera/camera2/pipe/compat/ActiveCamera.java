package androidx.camera.camera2.pipe.compat;

import La.C0951a;
import Ua.C1060i;
import Ua.M;
import androidx.camera.camera2.pipe.compat.ActiveCamera;
import androidx.camera.camera2.pipe.core.WakeLock;
import com.autonavi.aps.amapapi.config.Const;
import e9.InterfaceC4014c;
import f9.C4063a;
import g9.C4109a;
import g9.InterfaceC4112d;
import java.util.Set;
import kotlin.C4849c;
import kotlin.Metadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import p9.InterfaceC5063a;
import p9.InterfaceC5074l;
import w.C5708n;
import x.AbstractC5824k0;
import x.CameraStateClosed;
import x.CameraStateClosing;
import x.K0;
import z.z;

@Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\"\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u000e\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0000\u0018\u00002\u00020\u0001B9\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004\u0012\u0006\u0010\b\u001a\u00020\u0007\u0012\u0012\u0010\u000b\u001a\u000e\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020\n0\t¢\u0006\u0004\b\f\u0010\rJ\u000f\u0010\u000f\u001a\u0004\u0018\u00010\u000e¢\u0006\u0004\b\u000f\u0010\u0010J\"\u0010\u0014\u001a\u00020\n2\u0006\u0010\u0012\u001a\u00020\u00112\b\u0010\u0013\u001a\u0004\u0018\u00010\u000eH\u0086@¢\u0006\u0004\b\u0014\u0010\u0015J\r\u0010\u0016\u001a\u00020\n¢\u0006\u0004\b\u0016\u0010\u0017J\u0010\u0010\u0018\u001a\u00020\nH\u0086@¢\u0006\u0004\b\u0018\u0010\u0019J\u000f\u0010\u001b\u001a\u00020\u001aH\u0016¢\u0006\u0004\b\u001b\u0010\u001cR\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001d\u0010\u001eR \u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u00048\u0000X\u0080\u0004¢\u0006\f\n\u0004\b\u001f\u0010 \u001a\u0004\b!\u0010\"R\u0018\u0010%\u001a\u0004\u0018\u00010\u00118\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b#\u0010$R\u0014\u0010(\u001a\u00020&8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u000f\u0010'R\u0011\u0010*\u001a\u00020\u00058F¢\u0006\u0006\u001a\u0004\b)\u0010\u001c¨\u0006+"}, d2 = {"Landroidx/camera/camera2/pipe/compat/ActiveCamera;", "", "Landroidx/camera/camera2/pipe/compat/AndroidCameraState;", "androidCameraState", "", "Lw/n;", "allCameraIds", "LUa/M;", "scope", "Lkotlin/Function1;", "LY8/t;", "closeCallback", "<init>", "(Landroidx/camera/camera2/pipe/compat/AndroidCameraState;Ljava/util/Set;LUa/M;Lp9/l;)V", "Lz/z;", Const.INTENT_KEY_UMID, "()Lz/z;", "Landroidx/camera/camera2/pipe/compat/VirtualCameraState;", "virtualCameraState", M5.b.CREDENTIAL_TOKEN, Const.INTENT_KEY_BACKGROUND_COMMAND, "(Landroidx/camera/camera2/pipe/compat/VirtualCameraState;Lz/z;Le9/c;)Ljava/lang/Object;", "f", "()V", "e", "(Le9/c;)Ljava/lang/Object;", "", "toString", "()Ljava/lang/String;", Const.INTENT_KEY_APIKEY, "Landroidx/camera/camera2/pipe/compat/AndroidCameraState;", Const.INTENT_KEY_PKGNAME, "Ljava/util/Set;", Const.INTENT_KEY_BACKGROUND_NOTIFICATION, "()Ljava/util/Set;", "c", "Landroidx/camera/camera2/pipe/compat/VirtualCameraState;", "current", "Landroidx/camera/camera2/pipe/core/WakeLock;", "Landroidx/camera/camera2/pipe/core/WakeLock;", "wakelock", Const.INTENT_KEY_BACKGROUND_NOTIFICATION_ID, "cameraId", "camera-camera2-pipe"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes.dex */
public final class ActiveCamera {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    public final AndroidCameraState androidCameraState;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    public final Set<C5708n> allCameraIds;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    public VirtualCameraState current;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    public final WakeLock wakelock;

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"LUa/M;", "LY8/t;", "<anonymous>", "(LUa/M;)V"}, k = 3, mv = {2, 1, 0})
    @InterfaceC4112d(c = "androidx.camera.camera2.pipe.compat.ActiveCamera$1", f = "Camera2DeviceManager.kt", l = {137}, m = "invokeSuspend", v = 1)
    /* renamed from: androidx.camera.camera2.pipe.compat.ActiveCamera$1, reason: invalid class name */
    public static final class AnonymousClass1 extends SuspendLambda implements p9.p<M, InterfaceC4014c<? super Y8.t>, Object> {

        /* renamed from: a, reason: collision with root package name */
        public int f10182a;

        @Metadata(d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Lx/k0;", "it", "", "<anonymous>", "(Lx/k0;)Z"}, k = 3, mv = {2, 1, 0})
        @InterfaceC4112d(c = "androidx.camera.camera2.pipe.compat.ActiveCamera$1$1", f = "Camera2DeviceManager.kt", l = {}, m = "invokeSuspend", v = 1)
        /* renamed from: androidx.camera.camera2.pipe.compat.ActiveCamera$1$1, reason: invalid class name and collision with other inner class name */
        public static final class C01351 extends SuspendLambda implements p9.p<AbstractC5824k0, InterfaceC4014c<? super Boolean>, Object> {

            /* renamed from: a, reason: collision with root package name */
            public int f10184a;

            /* renamed from: b, reason: collision with root package name */
            public /* synthetic */ Object f10185b;

            public C01351(InterfaceC4014c<? super C01351> interfaceC4014c) {
                super(2, interfaceC4014c);
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final InterfaceC4014c<Y8.t> create(Object obj, InterfaceC4014c<?> interfaceC4014c) {
                C01351 c01351 = new C01351(interfaceC4014c);
                c01351.f10185b = obj;
                return c01351;
            }

            @Override // p9.p
            /* renamed from: f, reason: merged with bridge method [inline-methods] */
            public final Object invoke(AbstractC5824k0 abstractC5824k0, InterfaceC4014c<? super Boolean> interfaceC4014c) {
                return ((C01351) create(abstractC5824k0, interfaceC4014c)).invokeSuspend(Y8.t.f7040a);
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Object invokeSuspend(Object obj) throws Throwable {
                C4063a.g();
                if (this.f10184a != 0) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                C4849c.b(obj);
                AbstractC5824k0 abstractC5824k0 = (AbstractC5824k0) this.f10185b;
                return C4109a.a((abstractC5824k0 instanceof CameraStateClosing) || (abstractC5824k0 instanceof CameraStateClosed));
            }
        }

        public AnonymousClass1(InterfaceC4014c<? super AnonymousClass1> interfaceC4014c) {
            super(2, interfaceC4014c);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final InterfaceC4014c<Y8.t> create(Object obj, InterfaceC4014c<?> interfaceC4014c) {
            return ActiveCamera.this.new AnonymousClass1(interfaceC4014c);
        }

        @Override // p9.p
        public final Object invoke(M m10, InterfaceC4014c<? super Y8.t> interfaceC4014c) {
            return ((AnonymousClass1) create(m10, interfaceC4014c)).invokeSuspend(Y8.t.f7040a);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) throws Throwable {
            Object objG = C4063a.g();
            int i10 = this.f10182a;
            if (i10 == 0) {
                C4849c.b(obj);
                Xa.t<AbstractC5824k0> tVarL = ActiveCamera.this.androidCameraState.l();
                C01351 c01351 = new C01351(null);
                this.f10182a = 1;
                if (Xa.d.z(tVarL, c01351, this) == objG) {
                    return objG;
                }
            } else {
                if (i10 != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                C4849c.b(obj);
            }
            ActiveCamera.this.wakelock.i();
            return Y8.t.f7040a;
        }
    }

    public ActiveCamera(AndroidCameraState androidCameraState, Set<C5708n> allCameraIds, M scope, final InterfaceC5074l<? super ActiveCamera, Y8.t> closeCallback) {
        kotlin.jvm.internal.p.i(androidCameraState, "androidCameraState");
        kotlin.jvm.internal.p.i(allCameraIds, "allCameraIds");
        kotlin.jvm.internal.p.i(scope, "scope");
        kotlin.jvm.internal.p.i(closeCallback, "closeCallback");
        this.androidCameraState = androidCameraState;
        this.allCameraIds = allCameraIds;
        this.wakelock = new WakeLock(scope, 1000L, true, new InterfaceC5063a() { // from class: x.a
            @Override // p9.InterfaceC5063a
            public final Object invoke() {
                return ActiveCamera.j(closeCallback, this);
            }
        });
        C1060i.d(scope, null, null, new AnonymousClass1(null), 3, null);
    }

    public static final Y8.t j(InterfaceC5074l interfaceC5074l, ActiveCamera activeCamera) {
        interfaceC5074l.invoke(activeCamera);
        return Y8.t.f7040a;
    }

    public final z d() {
        return this.wakelock.h();
    }

    public final Object e(InterfaceC4014c<? super Y8.t> interfaceC4014c) {
        Object objE = this.androidCameraState.e(interfaceC4014c);
        return objE == C4063a.g() ? objE : Y8.t.f7040a;
    }

    public final void f() {
        this.wakelock.i();
        this.androidCameraState.f();
    }

    public final Object g(VirtualCameraState virtualCameraState, z zVar, InterfaceC4014c<? super Y8.t> interfaceC4014c) {
        VirtualCameraState virtualCameraState2 = this.current;
        this.current = virtualCameraState;
        if (virtualCameraState2 != null) {
            K0.a(virtualCameraState2, null, 1, null);
        }
        Object objF = virtualCameraState.f(this.androidCameraState.l(), zVar, interfaceC4014c);
        return objF == C4063a.g() ? objF : Y8.t.f7040a;
    }

    public final Set<C5708n> h() {
        return this.allCameraIds;
    }

    public final String i() {
        return this.androidCameraState.getCameraId();
    }

    public String toString() {
        StringBuilder sb2 = new StringBuilder();
        sb2.append("ActiveCamera(cameraId=");
        sb2.append((Object) C5708n.f(i()));
        sb2.append(")@");
        String string = Integer.toString(super.hashCode(), C0951a.a(16));
        kotlin.jvm.internal.p.h(string, "toString(...)");
        sb2.append(string);
        return sb2.toString();
    }
}
