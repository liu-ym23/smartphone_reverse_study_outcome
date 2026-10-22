package com.stepos.ability.runtime;

import C7.r;
import J7.c;
import S7.n;
import kotlin.Metadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import m9.InterfaceC1733z;
import o9.InterfaceC1779e;

@c(c = "com.stepos.ability.runtime.RuntimeManager$setup$1", f = "RuntimeManager.kt", l = {105, 115}, m = "invokeSuspend", v = 1)
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lm9/z;", "LC7/r;", "<anonymous>", "(Lm9/z;)V"}, k = 3, mv = {2, 2, 0})
/* loaded from: classes3.dex */
final class RuntimeManager$setup$1 extends SuspendLambda implements n {

    /* renamed from: a, reason: collision with root package name */
    public InterfaceC1779e f3224a;
    public int b;
    public /* synthetic */ Object c;
    public final /* synthetic */ b d;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public RuntimeManager$setup$1(b bVar, H7.c cVar) {
        super(2, cVar);
        this.d = bVar;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final H7.c create(Object obj, H7.c cVar) {
        RuntimeManager$setup$1 runtimeManager$setup$1 = new RuntimeManager$setup$1(this.d, cVar);
        runtimeManager$setup$1.c = obj;
        return runtimeManager$setup$1;
    }

    @Override // S7.n
    public final Object invoke(Object obj, Object obj2) {
        return ((RuntimeManager$setup$1) create((InterfaceC1733z) obj, (H7.c) obj2)).invokeSuspend(r.f317a);
    }

    /* JADX WARN: Path cross not found for [B:19:0x003d, B:22:0x0051], limit reached: 39 */
    /* JADX WARN: Removed duplicated region for block: B:39:0x0056 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:29:0x0082 -> B:15:0x0031). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:30:0x0092 -> B:15:0x0031). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:32:0x00bc -> B:15:0x0031). Please report as a decompilation issue!!! */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object invokeSuspend(java.lang.Object r11) {
        /*
            r10 = this;
            java.lang.Object r0 = r10.c
            m9.z r0 = (m9.InterfaceC1733z) r0
            kotlin.coroutines.intrinsics.CoroutineSingletons r1 = kotlin.coroutines.intrinsics.CoroutineSingletons.f4909a
            int r2 = r10.b
            r3 = 2
            r4 = 1
            if (r2 == 0) goto L24
            if (r2 == r4) goto L1e
            if (r2 != r3) goto L16
            o9.e r2 = r10.f3224a
            kotlin.b.b(r11)
            goto L31
        L16:
            java.lang.IllegalStateException r10 = new java.lang.IllegalStateException
            java.lang.String r11 = "call to 'resume' before 'invoke' with coroutine"
            r10.<init>(r11)
            throw r10
        L1e:
            o9.e r2 = r10.f3224a
            kotlin.b.b(r11)
            goto L51
        L24:
            kotlin.b.b(r11)
            com.stepos.ability.runtime.b r11 = r10.d
            kotlinx.coroutines.channels.a r11 = r11.h
            if (r11 != 0) goto L30
            C7.r r10 = C7.r.f317a
            return r10
        L30:
            r2 = r11
        L31:
            boolean r11 = m9.AbstractC1683A.l(r0)
            if (r11 == 0) goto Lc2
            com.stepos.ability.runtime.b r11 = r10.d
            boolean r11 = r11.d
            if (r11 == 0) goto L51
            java.lang.String r11 = "RuntimeManager"
            java.lang.String r5 = "Scheduler: wait."
            android.util.Log.i(r11, r5)
            r10.c = r0
            r10.f3224a = r2
            r10.b = r4
            java.lang.Object r11 = r2.u(r10)
            if (r11 != r1) goto L51
            goto Lbe
        L51:
            com.stepos.ability.runtime.b r11 = r10.d
            java.util.PriorityQueue r5 = r11.f
            monitor-enter(r5)
            java.util.PriorityQueue r11 = r11.f     // Catch: java.lang.Throwable -> Lbf
            java.lang.Object r11 = r11.poll()     // Catch: java.lang.Throwable -> Lbf
            com.stepos.ability.runtime.model.CoroutinePriorityTask r11 = (com.stepos.ability.runtime.model.CoroutinePriorityTask) r11     // Catch: java.lang.Throwable -> Lbf
            monitor-exit(r5)
            if (r11 == 0) goto Lab
            java.lang.String r5 = "RuntimeManager"
            com.stepos.ability.beaninternal.ability.AbilityTask r6 = r11.getBaseTask()
            java.lang.String r6 = r6.getTaskCode()
            java.lang.StringBuilder r7 = new java.lang.StringBuilder
            java.lang.String r8 = "Scheduler: start. task: "
            r7.<init>(r8)
            r7.append(r6)
            java.lang.String r6 = r7.toString()
            android.util.Log.i(r5, r6)
            com.stepos.ability.runtime.b r5 = r10.d
            s9.c r6 = r5.g
            if (r6 != 0) goto L92
            java.lang.String r5 = "RuntimeManager"
            com.stepos.ability.beaninternal.ability.AbilityTask r11 = r11.getBaseTask()
            java.lang.String r11 = r11.getTaskCode()
            java.lang.String r6 = "launchTask called but scope is null. task="
            androidx.constraintlayout.core.dsl.a.w(r6, r11, r5)
            goto L31
        L92:
            com.stepos.ability.runtime.RuntimeManager$launchTask$job$1 r7 = new com.stepos.ability.runtime.RuntimeManager$launchTask$job$1
            r8 = 0
            r7.<init>(r11, r5, r8)
            r9 = 3
            m9.q0 r6 = m9.AbstractC1683A.n(r6, r8, r7, r9)
            java.util.concurrent.ConcurrentHashMap r5 = r5.e
            com.stepos.ability.beaninternal.ability.AbilityTask r11 = r11.getBaseTask()
            java.lang.String r11 = r11.getTaskCode()
            r5.put(r11, r6)
            goto L31
        Lab:
            java.lang.String r11 = "RuntimeManager"
            java.lang.String r5 = "Scheduler: wait."
            android.util.Log.i(r11, r5)
            r10.c = r0
            r10.f3224a = r2
            r10.b = r3
            java.lang.Object r11 = r2.u(r10)
            if (r11 != r1) goto L31
        Lbe:
            return r1
        Lbf:
            r10 = move-exception
            monitor-exit(r5)
            throw r10
        Lc2:
            C7.r r10 = C7.r.f317a
            return r10
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stepos.ability.runtime.RuntimeManager$setup$1.invokeSuspend(java.lang.Object):java.lang.Object");
    }
}
