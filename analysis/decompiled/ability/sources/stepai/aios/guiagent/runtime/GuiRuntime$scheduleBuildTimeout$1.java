package stepai.aios.guiagent.runtime;

import C7.r;
import Ca.C0205d;
import J7.c;
import S7.n;
import kotlin.Metadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import m9.InterfaceC1733z;

@c(c = "stepai.aios.guiagent.runtime.GuiRuntime$scheduleBuildTimeout$1", f = "GuiRuntime.kt", l = {475, 477, 478}, m = "invokeSuspend", v = 1)
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lm9/z;", "LC7/r;", "<anonymous>", "(Lm9/z;)V"}, k = 3, mv = {2, 2, 0})
/* loaded from: classes4.dex */
final class GuiRuntime$scheduleBuildTimeout$1 extends SuspendLambda implements n {

    /* renamed from: a, reason: collision with root package name */
    public int f6124a;
    public /* synthetic */ Object b;
    public final /* synthetic */ long c;
    public final /* synthetic */ C0205d d;
    public final /* synthetic */ a e;
    public final /* synthetic */ String f;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public GuiRuntime$scheduleBuildTimeout$1(long j5, C0205d c0205d, a aVar, String str, H7.c cVar) {
        super(2, cVar);
        this.c = j5;
        this.d = c0205d;
        this.e = aVar;
        this.f = str;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final H7.c create(Object obj, H7.c cVar) {
        GuiRuntime$scheduleBuildTimeout$1 guiRuntime$scheduleBuildTimeout$1 = new GuiRuntime$scheduleBuildTimeout$1(this.c, this.d, this.e, this.f, cVar);
        guiRuntime$scheduleBuildTimeout$1.b = obj;
        return guiRuntime$scheduleBuildTimeout$1;
    }

    @Override // S7.n
    public final Object invoke(Object obj, Object obj2) {
        return ((GuiRuntime$scheduleBuildTimeout$1) create((InterfaceC1733z) obj, (H7.c) obj2)).invokeSuspend(r.f317a);
    }

    /* JADX WARN: Code restructure failed: missing block: B:30:0x007b, code lost:
    
        if (stepai.aios.guiagent.runtime.a.a(r3, r11.f, r5, "Task build timeout", 2000, r11) != r1) goto L32;
     */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object invokeSuspend(java.lang.Object r12) {
        /*
            r11 = this;
            java.lang.Object r0 = r11.b
            m9.z r0 = (m9.InterfaceC1733z) r0
            kotlin.coroutines.intrinsics.CoroutineSingletons r1 = kotlin.coroutines.intrinsics.CoroutineSingletons.f4909a
            int r2 = r11.f6124a
            stepai.aios.guiagent.runtime.a r3 = r11.e
            Ca.d r5 = r11.d
            r4 = 3
            r6 = 2
            r7 = 1
            r8 = 0
            if (r2 == 0) goto L2f
            if (r2 == r7) goto L2b
            if (r2 == r6) goto L24
            if (r2 != r4) goto L1c
            kotlin.b.b(r12)
            goto L7e
        L1c:
            java.lang.IllegalStateException r11 = new java.lang.IllegalStateException
            java.lang.String r12 = "call to 'resume' before 'invoke' with coroutine"
            r11.<init>(r12)
            throw r11
        L24:
            kotlin.b.b(r12)     // Catch: java.lang.Throwable -> L28
            goto L63
        L28:
            r0 = move-exception
            r12 = r0
            goto L69
        L2b:
            kotlin.b.b(r12)
            goto L3f
        L2f:
            kotlin.b.b(r12)
            r11.b = r0
            r11.f6124a = r7
            long r9 = r11.c
            java.lang.Object r12 = kotlinx.coroutines.a.f(r9, r11)
            if (r12 != r1) goto L3f
            goto L7d
        L3f:
            java.util.concurrent.atomic.AtomicBoolean r12 = r5.e
            boolean r12 = r12.get()
            if (r12 != 0) goto L7e
            java.util.concurrent.atomic.AtomicBoolean r12 = r5.f
            boolean r12 = r12.get()
            if (r12 != 0) goto L7e
            java.lang.String r12 = r11.f
            stepai.aios.guiagent.pipeline.b r0 = r3.g     // Catch: java.lang.Throwable -> L28
            java.lang.String r2 = "Task build timeout"
            r11.b = r8     // Catch: java.lang.Throwable -> L28
            r11.f6124a = r6     // Catch: java.lang.Throwable -> L28
            r0.getClass()     // Catch: java.lang.Throwable -> L28
            java.lang.Object r12 = stepai.aios.guiagent.pipeline.b.K(r0, r12, r2, r11)     // Catch: java.lang.Throwable -> L28
            if (r12 != r1) goto L63
            goto L7d
        L63:
            java.lang.Boolean r12 = (java.lang.Boolean) r12     // Catch: java.lang.Throwable -> L28
            r12.getClass()     // Catch: java.lang.Throwable -> L28
            goto L6c
        L69:
            kotlin.b.a(r12)
        L6c:
            r11.b = r8
            r11.f6124a = r4
            java.lang.String r4 = r11.f
            java.lang.String r6 = "Task build timeout"
            r7 = 2000(0x7d0, double:9.88E-321)
            r9 = r11
            java.lang.Object r11 = stepai.aios.guiagent.runtime.a.a(r3, r4, r5, r6, r7, r9)
            if (r11 != r1) goto L7e
        L7d:
            return r1
        L7e:
            C7.r r11 = C7.r.f317a
            return r11
        */
        throw new UnsupportedOperationException("Method not decompiled: stepai.aios.guiagent.runtime.GuiRuntime$scheduleBuildTimeout$1.invokeSuspend(java.lang.Object):java.lang.Object");
    }
}
