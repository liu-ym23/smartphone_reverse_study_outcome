package com.stepos.ability.monitor;

import C7.r;
import J7.c;
import S7.n;
import kotlin.Metadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import m9.InterfaceC1733z;

@c(c = "com.stepos.ability.monitor.MonitorImpl$startUploadLoop$1", f = "MonitorImpl.kt", l = {91}, m = "invokeSuspend", v = 1)
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lm9/z;", "LC7/r;", "<anonymous>", "(Lm9/z;)V"}, k = 3, mv = {2, 2, 0})
/* loaded from: classes3.dex */
final class MonitorImpl$startUploadLoop$1 extends SuspendLambda implements n {

    /* renamed from: a, reason: collision with root package name */
    public int f3206a;
    public /* synthetic */ Object b;
    public final /* synthetic */ a c;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public MonitorImpl$startUploadLoop$1(a aVar, H7.c cVar) {
        super(2, cVar);
        this.c = aVar;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final H7.c create(Object obj, H7.c cVar) {
        MonitorImpl$startUploadLoop$1 monitorImpl$startUploadLoop$1 = new MonitorImpl$startUploadLoop$1(this.c, cVar);
        monitorImpl$startUploadLoop$1.b = obj;
        return monitorImpl$startUploadLoop$1;
    }

    @Override // S7.n
    public final Object invoke(Object obj, Object obj2) {
        return ((MonitorImpl$startUploadLoop$1) create((InterfaceC1733z) obj, (H7.c) obj2)).invokeSuspend(r.f317a);
    }

    /* JADX WARN: Removed duplicated region for block: B:11:0x0022  */
    /* JADX WARN: Removed duplicated region for block: B:17:0x003a  */
    /* JADX WARN: Removed duplicated region for block: B:27:0x005e  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:12:0x002c -> B:14:0x002f). Please report as a decompilation issue!!! */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object invokeSuspend(java.lang.Object r7) {
        /*
            r6 = this;
            java.lang.Object r0 = r6.b
            m9.z r0 = (m9.InterfaceC1733z) r0
            kotlin.coroutines.intrinsics.CoroutineSingletons r1 = kotlin.coroutines.intrinsics.CoroutineSingletons.f4909a
            int r2 = r6.f3206a
            r3 = 1
            if (r2 == 0) goto L19
            if (r2 != r3) goto L11
            kotlin.b.b(r7)
            goto L2f
        L11:
            java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
            java.lang.String r7 = "call to 'resume' before 'invoke' with coroutine"
            r6.<init>(r7)
            throw r6
        L19:
            kotlin.b.b(r7)
        L1c:
            boolean r7 = m9.AbstractC1683A.l(r0)
            if (r7 == 0) goto L5e
            r6.b = r0
            r6.f3206a = r3
            r4 = 30000(0x7530, double:1.4822E-319)
            java.lang.Object r7 = kotlinx.coroutines.a.f(r4, r6)
            if (r7 != r1) goto L2f
            return r1
        L2f:
            com.stepos.ability.monitor.a r7 = r6.c
            java.util.concurrent.ConcurrentLinkedQueue r7 = r7.f3207a
            boolean r2 = r7.isEmpty()
            if (r2 == 0) goto L3a
            goto L1c
        L3a:
            java.util.ArrayList r2 = new java.util.ArrayList
            r2.<init>()
        L3f:
            int r4 = r2.size()
            r5 = 100
            if (r4 >= r5) goto L54
            java.lang.Object r4 = r7.poll()
            com.stepos.ability.monitor.model.MonitorRecordItem r4 = (com.stepos.ability.monitor.model.MonitorRecordItem) r4
            if (r4 != 0) goto L50
            goto L54
        L50:
            r2.add(r4)
            goto L3f
        L54:
            boolean r7 = r2.isEmpty()
            if (r7 != 0) goto L1c
            com.stepos.ability.monitor.a.a(r2)
            goto L1c
        L5e:
            C7.r r6 = C7.r.f317a
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stepos.ability.monitor.MonitorImpl$startUploadLoop$1.invokeSuspend(java.lang.Object):java.lang.Object");
    }
}
