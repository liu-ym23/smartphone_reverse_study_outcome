package com.stepos.ability.manager.sync;

import C7.r;
import J7.c;
import S7.n;
import android.content.Context;
import kotlin.Metadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import m9.InterfaceC1733z;

@c(c = "com.stepos.ability.manager.sync.AbilitySyncCoordinator$scheduleCloudSync$1", f = "AbilitySyncCoordinator.kt", l = {319, 321}, m = "invokeSuspend", v = 1)
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lm9/z;", "LC7/r;", "<anonymous>", "(Lm9/z;)V"}, k = 3, mv = {2, 2, 0})
/* loaded from: classes3.dex */
final class AbilitySyncCoordinator$scheduleCloudSync$1 extends SuspendLambda implements n {

    /* renamed from: a, reason: collision with root package name */
    public int f3158a;
    public final /* synthetic */ long b;
    public final /* synthetic */ a c;
    public final /* synthetic */ Context d;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AbilitySyncCoordinator$scheduleCloudSync$1(long j5, a aVar, Context context, H7.c cVar) {
        super(2, cVar);
        this.b = j5;
        this.c = aVar;
        this.d = context;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final H7.c create(Object obj, H7.c cVar) {
        return new AbilitySyncCoordinator$scheduleCloudSync$1(this.b, this.c, this.d, cVar);
    }

    @Override // S7.n
    public final Object invoke(Object obj, Object obj2) {
        return ((AbilitySyncCoordinator$scheduleCloudSync$1) create((InterfaceC1733z) obj, (H7.c) obj2)).invokeSuspend(r.f317a);
    }

    /* JADX WARN: Code restructure failed: missing block: B:16:0x003a, code lost:
    
        if (com.stepos.ability.manager.sync.a.a(r8.c, r8.d, r8) == r0) goto L17;
     */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object invokeSuspend(java.lang.Object r9) {
        /*
            r8 = this;
            kotlin.coroutines.intrinsics.CoroutineSingletons r0 = kotlin.coroutines.intrinsics.CoroutineSingletons.f4909a
            int r1 = r8.f3158a
            r2 = 2
            r3 = 1
            if (r1 == 0) goto L1c
            if (r1 == r3) goto L18
            if (r1 != r2) goto L10
            kotlin.b.b(r9)
            goto L3d
        L10:
            java.lang.IllegalStateException r8 = new java.lang.IllegalStateException
            java.lang.String r9 = "call to 'resume' before 'invoke' with coroutine"
            r8.<init>(r9)
            throw r8
        L18:
            kotlin.b.b(r9)
            goto L30
        L1c:
            kotlin.b.b(r9)
            r4 = 0
            long r6 = r8.b
            int r9 = (r6 > r4 ? 1 : (r6 == r4 ? 0 : -1))
            if (r9 <= 0) goto L30
            r8.f3158a = r3
            java.lang.Object r9 = kotlinx.coroutines.a.f(r6, r8)
            if (r9 != r0) goto L30
            goto L3c
        L30:
            r8.f3158a = r2
            com.stepos.ability.manager.sync.a r9 = r8.c
            android.content.Context r1 = r8.d
            java.lang.Object r8 = com.stepos.ability.manager.sync.a.a(r9, r1, r8)
            if (r8 != r0) goto L3d
        L3c:
            return r0
        L3d:
            C7.r r8 = C7.r.f317a
            return r8
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stepos.ability.manager.sync.AbilitySyncCoordinator$scheduleCloudSync$1.invokeSuspend(java.lang.Object):java.lang.Object");
    }
}
