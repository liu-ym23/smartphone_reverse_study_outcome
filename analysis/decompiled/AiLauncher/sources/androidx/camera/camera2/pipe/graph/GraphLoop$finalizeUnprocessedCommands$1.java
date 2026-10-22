package androidx.camera.camera2.pipe.graph;

import Ua.M;
import Y8.t;
import e9.InterfaceC4014c;
import g9.InterfaceC4112d;
import kotlin.Metadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import p9.p;

@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"LUa/M;", "LY8/t;", "<anonymous>", "(LUa/M;)V"}, k = 3, mv = {2, 1, 0})
@InterfaceC4112d(c = "androidx.camera.camera2.pipe.graph.GraphLoop$finalizeUnprocessedCommands$1", f = "GraphLoop.kt", l = {630, 631}, m = "invokeSuspend", v = 1)
/* loaded from: classes.dex */
public final class GraphLoop$finalizeUnprocessedCommands$1 extends SuspendLambda implements p<M, InterfaceC4014c<? super t>, Object> {

    /* renamed from: a, reason: collision with root package name */
    public int f10874a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ b f10875b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public GraphLoop$finalizeUnprocessedCommands$1(b bVar, InterfaceC4014c<? super GraphLoop$finalizeUnprocessedCommands$1> interfaceC4014c) {
        super(2, interfaceC4014c);
        this.f10875b = bVar;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final InterfaceC4014c<t> create(Object obj, InterfaceC4014c<?> interfaceC4014c) {
        return new GraphLoop$finalizeUnprocessedCommands$1(this.f10875b, interfaceC4014c);
    }

    @Override // p9.p
    public final Object invoke(M m10, InterfaceC4014c<? super t> interfaceC4014c) {
        return ((GraphLoop$finalizeUnprocessedCommands$1) create(m10, interfaceC4014c)).invokeSuspend(t.f7040a);
    }

    /* JADX WARN: Code restructure failed: missing block: B:18:0x0044, code lost:
    
        if (r5.e(r4) == r0) goto L19;
     */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object invokeSuspend(java.lang.Object r5) throws java.lang.Throwable {
        /*
            r4 = this;
            java.lang.Object r0 = f9.C4063a.g()
            int r1 = r4.f10874a
            r2 = 2
            r3 = 1
            if (r1 == 0) goto L1e
            if (r1 == r3) goto L1a
            if (r1 != r2) goto L12
            kotlin.C4849c.b(r5)
            goto L47
        L12:
            java.lang.IllegalStateException r4 = new java.lang.IllegalStateException
            java.lang.String r5 = "call to 'resume' before 'invoke' with coroutine"
            r4.<init>(r5)
            throw r4
        L1a:
            kotlin.C4849c.b(r5)
            goto L34
        L1e:
            kotlin.C4849c.b(r5)
            androidx.camera.camera2.pipe.graph.b r5 = r4.f10875b
            androidx.camera.camera2.pipe.graph.b$g r5 = (androidx.camera.camera2.pipe.graph.b.g) r5
            A.h r5 = r5.getOld()
            if (r5 == 0) goto L34
            r4.f10874a = r3
            java.lang.Object r5 = r5.e(r4)
            if (r5 != r0) goto L34
            goto L46
        L34:
            androidx.camera.camera2.pipe.graph.b r5 = r4.f10875b
            androidx.camera.camera2.pipe.graph.b$g r5 = (androidx.camera.camera2.pipe.graph.b.g) r5
            A.h r5 = r5.getNew()
            if (r5 == 0) goto L47
            r4.f10874a = r2
            java.lang.Object r4 = r5.e(r4)
            if (r4 != r0) goto L47
        L46:
            return r0
        L47:
            Y8.t r4 = Y8.t.f7040a
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.camera.camera2.pipe.graph.GraphLoop$finalizeUnprocessedCommands$1.invokeSuspend(java.lang.Object):java.lang.Object");
    }
}
