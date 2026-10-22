package androidx.camera.camera2.pipe.internal;

import Ua.M;
import Ua.Q;
import Y8.t;
import androidx.exifinterface.media.ExifInterface;
import e9.InterfaceC4014c;
import g9.InterfaceC4112d;
import kotlin.Metadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import p9.p;
import z.z;

/* JADX INFO: Add missing generic type declarations: [T] */
@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0002\u001a\u00028\u0000\"\u0004\b\u0000\u0010\u0000*\u00020\u0001H\n"}, d2 = {ExifInterface.GPS_DIRECTION_TRUE, "LUa/M;", "<anonymous>"}, k = 3, mv = {2, 1, 0})
@InterfaceC4112d(c = "androidx.camera.camera2.pipe.internal.GraphSessionLock$withTokenInAsync$1", f = "GraphSessionLock.kt", l = {105, 64, 67}, m = "invokeSuspend", v = 1)
/* loaded from: classes.dex */
public final class GraphSessionLock$withTokenInAsync$1<T> extends SuspendLambda implements p<M, InterfaceC4014c<? super T>, Object> {

    /* renamed from: a, reason: collision with root package name */
    public Object f10999a;

    /* renamed from: b, reason: collision with root package name */
    public Object f11000b;

    /* renamed from: c, reason: collision with root package name */
    public int f11001c;

    /* renamed from: d, reason: collision with root package name */
    public /* synthetic */ Object f11002d;

    /* renamed from: e, reason: collision with root package name */
    public final /* synthetic */ GraphSessionLock f11003e;

    /* renamed from: f, reason: collision with root package name */
    public final /* synthetic */ p<z, InterfaceC4014c<? super Q<? extends T>>, Object> f11004f;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public GraphSessionLock$withTokenInAsync$1(GraphSessionLock graphSessionLock, p<? super z, ? super InterfaceC4014c<? super Q<? extends T>>, ? extends Object> pVar, InterfaceC4014c<? super GraphSessionLock$withTokenInAsync$1> interfaceC4014c) {
        super(2, interfaceC4014c);
        this.f11003e = graphSessionLock;
        this.f11004f = pVar;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final InterfaceC4014c<t> create(Object obj, InterfaceC4014c<?> interfaceC4014c) {
        GraphSessionLock$withTokenInAsync$1 graphSessionLock$withTokenInAsync$1 = new GraphSessionLock$withTokenInAsync$1(this.f11003e, this.f11004f, interfaceC4014c);
        graphSessionLock$withTokenInAsync$1.f11002d = obj;
        return graphSessionLock$withTokenInAsync$1;
    }

    @Override // p9.p
    public final Object invoke(M m10, InterfaceC4014c<? super T> interfaceC4014c) {
        return ((GraphSessionLock$withTokenInAsync$1) create(m10, interfaceC4014c)).invokeSuspend(t.f7040a);
    }

    /* JADX WARN: Removed duplicated region for block: B:24:0x0082 A[RETURN] */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object invokeSuspend(java.lang.Object r10) throws java.lang.Throwable {
        /*
            r9 = this;
            java.lang.Object r0 = f9.C4063a.g()
            int r1 = r9.f11001c
            r2 = 3
            r3 = 2
            r4 = 1
            r5 = 0
            if (r1 == 0) goto L37
            if (r1 == r4) goto L26
            if (r1 == r3) goto L1e
            if (r1 != r2) goto L16
            kotlin.C4849c.b(r10)
            return r10
        L16:
            java.lang.IllegalStateException r9 = new java.lang.IllegalStateException
            java.lang.String r10 = "call to 'resume' before 'invoke' with coroutine"
            r9.<init>(r10)
            throw r9
        L1e:
            java.lang.Object r1 = r9.f11002d
            Ua.M r1 = (Ua.M) r1
            kotlin.C4849c.b(r10)
            goto L72
        L26:
            java.lang.Object r1 = r9.f11000b
            androidx.camera.camera2.pipe.internal.GraphSessionLock r1 = (androidx.camera.camera2.pipe.internal.GraphSessionLock) r1
            java.lang.Object r4 = r9.f10999a
            eb.a r4 = (eb.InterfaceC4021a) r4
            java.lang.Object r6 = r9.f11002d
            Ua.M r6 = (Ua.M) r6
            kotlin.C4849c.b(r10)
            r10 = r6
            goto L54
        L37:
            kotlin.C4849c.b(r10)
            java.lang.Object r10 = r9.f11002d
            Ua.M r10 = (Ua.M) r10
            androidx.camera.camera2.pipe.internal.GraphSessionLock r1 = r9.f11003e
            eb.a r6 = androidx.camera.camera2.pipe.internal.GraphSessionLock.b(r1)
            r9.f11002d = r10
            r9.f10999a = r6
            r9.f11000b = r1
            r9.f11001c = r4
            java.lang.Object r4 = androidx.camera.camera2.pipe.core.MutexesKt.a(r6, r9)
            if (r4 != r0) goto L53
            goto L81
        L53:
            r4 = r6
        L54:
            z.l r6 = new z.l
            r6.<init>(r4)
            androidx.camera.camera2.pipe.internal.GraphSessionLock$withTokenInAsync$1$deferred$1 r4 = new androidx.camera.camera2.pipe.internal.GraphSessionLock$withTokenInAsync$1$deferred$1
            p9.p<z.z, e9.c<? super Ua.Q<? extends T>>, java.lang.Object> r7 = r9.f11004f
            r4.<init>(r7, r5)
            r9.f11002d = r10
            r9.f10999a = r5
            r9.f11000b = r5
            r9.f11001c = r3
            java.lang.Object r1 = androidx.camera.camera2.pipe.internal.GraphSessionLock.c(r1, r6, r4, r9)
            if (r1 != r0) goto L6f
            goto L81
        L6f:
            r8 = r1
            r1 = r10
            r10 = r8
        L72:
            Ua.Q r10 = (Ua.Q) r10
            kotlinx.coroutines.d.g(r1)
            r9.f11002d = r5
            r9.f11001c = r2
            java.lang.Object r9 = r10.a1(r9)
            if (r9 != r0) goto L82
        L81:
            return r0
        L82:
            return r9
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.camera.camera2.pipe.internal.GraphSessionLock$withTokenInAsync$1.invokeSuspend(java.lang.Object):java.lang.Object");
    }
}
