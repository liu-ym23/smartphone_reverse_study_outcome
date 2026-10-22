package androidx.camera.camera2.pipe.compat;

import Ua.M;
import com.stepos.ailauncher.chat.wake.circle.F;
import e9.InterfaceC4014c;
import g9.InterfaceC4112d;
import kotlin.Metadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;

@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"LUa/M;", "LY8/t;", "<anonymous>", "(LUa/M;)V"}, k = 3, mv = {2, 1, 0})
@InterfaceC4112d(c = "androidx.camera.camera2.pipe.compat.Camera2Backend$shutdownAsync$2", f = "Camera2Backend.kt", l = {F.GESTURE_WIDTH_DP, 196}, m = "invokeSuspend", v = 1)
/* loaded from: classes.dex */
public final class Camera2Backend$shutdownAsync$2 extends SuspendLambda implements p9.p<M, InterfaceC4014c<? super Y8.t>, Object> {

    /* renamed from: a, reason: collision with root package name */
    public Object f10239a;

    /* renamed from: b, reason: collision with root package name */
    public Object f10240b;

    /* renamed from: c, reason: collision with root package name */
    public int f10241c;

    /* renamed from: d, reason: collision with root package name */
    public final /* synthetic */ Camera2Backend f10242d;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public Camera2Backend$shutdownAsync$2(Camera2Backend camera2Backend, InterfaceC4014c<? super Camera2Backend$shutdownAsync$2> interfaceC4014c) {
        super(2, interfaceC4014c);
        this.f10242d = camera2Backend;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final InterfaceC4014c<Y8.t> create(Object obj, InterfaceC4014c<?> interfaceC4014c) {
        return new Camera2Backend$shutdownAsync$2(this.f10242d, interfaceC4014c);
    }

    @Override // p9.p
    public final Object invoke(M m10, InterfaceC4014c<? super Y8.t> interfaceC4014c) {
        return ((Camera2Backend$shutdownAsync$2) create(m10, interfaceC4014c)).invokeSuspend(Y8.t.f7040a);
    }

    /* JADX WARN: Code restructure failed: missing block: B:21:0x0072, code lost:
    
        if (r8 == r0) goto L33;
     */
    /* JADX WARN: Code restructure failed: missing block: B:32:0x00c5, code lost:
    
        if (r8.a1(r7) == r0) goto L33;
     */
    /* JADX WARN: Removed duplicated region for block: B:17:0x0043  */
    /* JADX WARN: Removed duplicated region for block: B:28:0x00a1  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:21:0x0072 -> B:23:0x0075). Please report as a decompilation issue!!! */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object invokeSuspend(java.lang.Object r8) throws java.lang.Throwable {
        /*
            r7 = this;
            java.lang.Object r0 = f9.C4063a.g()
            int r1 = r7.f10241c
            r2 = 2
            r3 = 1
            if (r1 == 0) goto L27
            if (r1 == r3) goto L1b
            if (r1 != r2) goto L13
            kotlin.C4849c.b(r8)
            goto Lc8
        L13:
            java.lang.IllegalStateException r7 = new java.lang.IllegalStateException
            java.lang.String r8 = "call to 'resume' before 'invoke' with coroutine"
            r7.<init>(r8)
            throw r7
        L1b:
            java.lang.Object r1 = r7.f10240b
            w.i r1 = (w.InterfaceC5703i) r1
            java.lang.Object r4 = r7.f10239a
            java.util.Iterator r4 = (java.util.Iterator) r4
            kotlin.C4849c.b(r8)
            goto L75
        L27:
            kotlin.C4849c.b(r8)
            androidx.camera.camera2.pipe.compat.Camera2Backend r8 = r7.f10242d
            java.lang.Object r8 = androidx.camera.camera2.pipe.compat.Camera2Backend.m(r8)
            androidx.camera.camera2.pipe.compat.Camera2Backend r1 = r7.f10242d
            monitor-enter(r8)
            java.util.Set r1 = androidx.camera.camera2.pipe.compat.Camera2Backend.k(r1)     // Catch: java.lang.Throwable -> Lcb
            monitor-exit(r8)
            java.util.Iterator r8 = r1.iterator()
            r4 = r8
        L3d:
            boolean r8 = r4.hasNext()
            if (r8 == 0) goto La1
            java.lang.Object r8 = r4.next()
            r1 = r8
            w.i r1 = (w.InterfaceC5703i) r1
            z.k r8 = z.k.f44508a
            boolean r8 = r8.a()
            if (r8 == 0) goto L68
            java.lang.String r8 = "CXCP"
            java.lang.StringBuilder r5 = new java.lang.StringBuilder
            r5.<init>()
            java.lang.String r6 = "Camera2Backend#shutdownAsync: Awaiting closure from "
            r5.append(r6)
            r5.append(r1)
            java.lang.String r5 = r5.toString()
            android.util.Log.d(r8, r5)
        L68:
            r7.f10239a = r4
            r7.f10240b = r1
            r7.f10241c = r3
            java.lang.Object r8 = r1.b(r7)
            if (r8 != r0) goto L75
            goto Lc7
        L75:
            java.lang.Boolean r8 = (java.lang.Boolean) r8
            boolean r8 = r8.booleanValue()
            if (r8 != 0) goto L3d
            z.k r8 = z.k.f44508a
            boolean r8 = r8.d()
            if (r8 == 0) goto L3d
            java.lang.String r8 = "CXCP"
            java.lang.StringBuilder r5 = new java.lang.StringBuilder
            r5.<init>()
            java.lang.String r6 = "Failed to await closure from "
            r5.append(r6)
            r5.append(r1)
            r1 = 33
            r5.append(r1)
            java.lang.String r1 = r5.toString()
            android.util.Log.w(r8, r1)
            goto L3d
        La1:
            z.k r8 = z.k.f44508a
            boolean r8 = r8.a()
            if (r8 == 0) goto Lb0
            java.lang.String r8 = "CXCP"
            java.lang.String r1 = "Camera2Backend#shutdownAsync: Closing all cameras (if any)"
            android.util.Log.d(r8, r1)
        Lb0:
            androidx.camera.camera2.pipe.compat.Camera2Backend r8 = r7.f10242d
            x.X r8 = androidx.camera.camera2.pipe.compat.Camera2Backend.l(r8)
            Ua.Q r8 = r8.a(r3)
            r1 = 0
            r7.f10239a = r1
            r7.f10240b = r1
            r7.f10241c = r2
            java.lang.Object r7 = r8.a1(r7)
            if (r7 != r0) goto Lc8
        Lc7:
            return r0
        Lc8:
            Y8.t r7 = Y8.t.f7040a
            return r7
        Lcb:
            r7 = move-exception
            monitor-exit(r8)
            throw r7
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.camera.camera2.pipe.compat.Camera2Backend$shutdownAsync$2.invokeSuspend(java.lang.Object):java.lang.Object");
    }
}
