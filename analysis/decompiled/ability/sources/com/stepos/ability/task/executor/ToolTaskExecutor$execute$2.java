package com.stepos.ability.task.executor;

import C7.r;
import S7.n;
import com.stepos.ability.bean.InternalTask;
import com.stepos.ability.bean.Task;
import com.stepos.ability.beaninternal.ability.FunctionCallResult;
import kotlin.Metadata;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import m9.C1724q;
import m9.InterfaceC1733z;
import z4.C2169a;
import z4.C2171c;
import z4.C2172d;
import z4.C2174f;
import z4.C2175g;
import z4.l;
import z4.p;

@J7.c(c = "com.stepos.ability.task.executor.ToolTaskExecutor$execute$2", f = "ToolTaskExecutor.kt", l = {243, 263, 312, 271, 312, 301, 312, 312}, m = "invokeSuspend", v = 1)
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lm9/z;", "LC7/r;", "<anonymous>", "(Lm9/z;)V"}, k = 3, mv = {2, 2, 0})
/* loaded from: classes3.dex */
final class ToolTaskExecutor$execute$2 extends SuspendLambda implements n {

    /* renamed from: a, reason: collision with root package name */
    public Throwable f3299a;
    public int b;
    public final /* synthetic */ g c;
    public final /* synthetic */ String d;
    public final /* synthetic */ S0.b e;
    public final /* synthetic */ C1724q f;
    public final /* synthetic */ InternalTask g;
    public final /* synthetic */ String h;
    public final /* synthetic */ C2171c i;

    /* renamed from: j, reason: collision with root package name */
    public final /* synthetic */ Task f3300j;
    public final /* synthetic */ String k;
    public final /* synthetic */ Long l;
    public final /* synthetic */ Boolean m;
    public final /* synthetic */ int n;

    @J7.c(c = "com.stepos.ability.task.executor.ToolTaskExecutor$execute$2$1", f = "ToolTaskExecutor.kt", l = {291}, m = "invokeSuspend", v = 1)
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lm9/z;", "LC7/r;", "<anonymous>", "(Lm9/z;)V"}, k = 3, mv = {2, 2, 0})
    /* renamed from: com.stepos.ability.task.executor.ToolTaskExecutor$execute$2$1, reason: invalid class name */
    final class AnonymousClass1 extends SuspendLambda implements n {

        /* renamed from: a, reason: collision with root package name */
        public int f3301a;
        public final /* synthetic */ g b;
        public final /* synthetic */ String c;
        public final /* synthetic */ C2171c d;
        public final /* synthetic */ InternalTask e;
        public final /* synthetic */ S0.b f;
        public final /* synthetic */ String g;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass1(g gVar, String str, C2171c c2171c, InternalTask internalTask, S0.b bVar, String str2, H7.c cVar) {
            super(2, cVar);
            this.b = gVar;
            this.c = str;
            this.d = c2171c;
            this.e = internalTask;
            this.f = bVar;
            this.g = str2;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final H7.c create(Object obj, H7.c cVar) {
            return new AnonymousClass1(this.b, this.c, this.d, this.e, this.f, this.g, cVar);
        }

        @Override // S7.n
        public final Object invoke(Object obj, Object obj2) {
            return ((AnonymousClass1) create((InterfaceC1733z) obj, (H7.c) obj2)).invokeSuspend(r.f317a);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            C2174f c2174f;
            g gVar = this.b;
            C2169a c2169a = gVar.k;
            CoroutineSingletons coroutineSingletons = CoroutineSingletons.f4909a;
            int i = this.f3301a;
            if (i == 0) {
                kotlin.b.b(obj);
                C2172d c2172d = gVar.f3314j;
                C2175g c2175g = gVar.h;
                String str = this.c;
                c2169a.a(c2172d, c2175g, str);
                C2174f c2174f2 = (C2174f) c2169a.f6955a.get(str);
                C2171c c2171c = this.d;
                if (c2174f2 == null) {
                    String str2 = c2171c.b;
                    String str3 = c2171c.c;
                    c2174f = new C2174f(false, str, str2, str3, c2171c.d, null, null, c2171c.h, str3, null);
                } else {
                    c2174f = c2174f2;
                }
                C2174f c2174fA = C2174f.a(c2174f, null, null, null, null, 1022);
                p pVar = ((l) this.f).f6968r;
                FunctionCallResult.Companion companion = FunctionCallResult.INSTANCE;
                int i6 = pVar.f6971a;
                String str4 = pVar.b;
                FunctionCallResult functionCallResultError = companion.error(i6, str4, str4, null, null);
                this.f3301a = 1;
                if (gVar.b(this.e, functionCallResultError, this.g, c2171c, c2174fA, this) == coroutineSingletons) {
                    return coroutineSingletons;
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                kotlin.b.b(obj);
            }
            return r.f317a;
        }
    }

    @J7.c(c = "com.stepos.ability.task.executor.ToolTaskExecutor$execute$2$2", f = "ToolTaskExecutor.kt", l = {}, m = "invokeSuspend", v = 1)
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lm9/z;", "LC7/r;", "<anonymous>", "(Lm9/z;)V"}, k = 3, mv = {2, 2, 0})
    /* renamed from: com.stepos.ability.task.executor.ToolTaskExecutor$execute$2$2, reason: invalid class name */
    final class AnonymousClass2 extends SuspendLambda implements n {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ g f3302a;
        public final /* synthetic */ String b;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass2(g gVar, String str, H7.c cVar) {
            super(2, cVar);
            this.f3302a = gVar;
            this.b = str;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final H7.c create(Object obj, H7.c cVar) {
            return new AnonymousClass2(this.f3302a, this.b, cVar);
        }

        @Override // S7.n
        public final Object invoke(Object obj, Object obj2) {
            AnonymousClass2 anonymousClass2 = (AnonymousClass2) create((InterfaceC1733z) obj, (H7.c) obj2);
            r rVar = r.f317a;
            anonymousClass2.invokeSuspend(rVar);
            return rVar;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            CoroutineSingletons coroutineSingletons = CoroutineSingletons.f4909a;
            kotlin.b.b(obj);
            g gVar = this.f3302a;
            C2172d c2172d = gVar.f3314j;
            String str = this.b;
            c2172d.b(str);
            gVar.h.a(str);
            return r.f317a;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ToolTaskExecutor$execute$2(g gVar, String str, S0.b bVar, C1724q c1724q, InternalTask internalTask, String str2, C2171c c2171c, Task task, String str3, Long l, Boolean bool, int i, H7.c cVar) {
        super(2, cVar);
        this.c = gVar;
        this.d = str;
        this.e = bVar;
        this.f = c1724q;
        this.g = internalTask;
        this.h = str2;
        this.i = c2171c;
        this.f3300j = task;
        this.k = str3;
        this.l = l;
        this.m = bool;
        this.n = i;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final H7.c create(Object obj, H7.c cVar) {
        return new ToolTaskExecutor$execute$2(this.c, this.d, this.e, this.f, this.g, this.h, this.i, this.f3300j, this.k, this.l, this.m, this.n, cVar);
    }

    @Override // S7.n
    public final Object invoke(Object obj, Object obj2) {
        return ((ToolTaskExecutor$execute$2) create((InterfaceC1733z) obj, (H7.c) obj2)).invokeSuspend(r.f317a);
    }

    /* JADX WARN: Code restructure failed: missing block: B:51:0x00d8, code lost:
    
        if (m9.AbstractC1683A.w(r0, r2, r7) != r9) goto L101;
     */
    /* JADX WARN: Code restructure failed: missing block: B:87:0x018c, code lost:
    
        if (m9.AbstractC1683A.w(r0, r2, r7) != r9) goto L101;
     */
    /* JADX WARN: Code restructure failed: missing block: B:99:0x01c2, code lost:
    
        if (m9.AbstractC1683A.w(r0, r2, r7) != r9) goto L101;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:106:0x01dc A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:131:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:50:0x00c7 A[PHI: r1 r7 r12
      0x00c7: PHI (r1v32 com.stepos.ability.task.executor.g) = (r1v40 com.stepos.ability.task.executor.g), (r1v41 com.stepos.ability.task.executor.g) binds: [B:48:0x00c3, B:18:0x0047] A[DONT_GENERATE, DONT_INLINE]
      0x00c7: PHI (r7v25 com.stepos.ability.task.executor.ToolTaskExecutor$execute$2) = 
      (r7v24 com.stepos.ability.task.executor.ToolTaskExecutor$execute$2)
      (r7v0 com.stepos.ability.task.executor.ToolTaskExecutor$execute$2)
     binds: [B:48:0x00c3, B:18:0x0047] A[DONT_GENERATE, DONT_INLINE]
      0x00c7: PHI (r12v25 java.lang.String) = (r12v24 java.lang.String), (r12v0 java.lang.String) binds: [B:48:0x00c3, B:18:0x0047] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Removed duplicated region for block: B:79:0x014e  */
    /* JADX WARN: Removed duplicated region for block: B:86:0x017c A[PHI: r1 r7 r8 r12
      0x017c: PHI (r1v18 com.stepos.ability.task.executor.g) = (r1v35 com.stepos.ability.task.executor.g), (r1v36 com.stepos.ability.task.executor.g) binds: [B:84:0x0179, B:9:0x002b] A[DONT_GENERATE, DONT_INLINE]
      0x017c: PHI (r7v13 com.stepos.ability.task.executor.ToolTaskExecutor$execute$2) = 
      (r7v7 com.stepos.ability.task.executor.ToolTaskExecutor$execute$2)
      (r7v0 com.stepos.ability.task.executor.ToolTaskExecutor$execute$2)
     binds: [B:84:0x0179, B:9:0x002b] A[DONT_GENERATE, DONT_INLINE]
      0x017c: PHI (r8v10 ??) = (r8v5 ??), (r8v12 ??) binds: [B:84:0x0179, B:9:0x002b] A[DONT_GENERATE, DONT_INLINE]
      0x017c: PHI (r12v13 java.lang.String) = (r12v7 java.lang.String), (r12v0 java.lang.String) binds: [B:84:0x0179, B:9:0x002b] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Removed duplicated region for block: B:98:0x01b2 A[PHI: r1 r7 r8 r11 r12
      0x01b2: PHI (r1v15 ??) = (r1v39 ??), (r1v34 ??) binds: [B:96:0x01af, B:15:0x003a] A[DONT_GENERATE, DONT_INLINE]
      0x01b2: PHI (r7v11 com.stepos.ability.task.executor.ToolTaskExecutor$execute$2) = 
      (r7v9 com.stepos.ability.task.executor.ToolTaskExecutor$execute$2)
      (r7v0 com.stepos.ability.task.executor.ToolTaskExecutor$execute$2)
     binds: [B:96:0x01af, B:15:0x003a] A[DONT_GENERATE, DONT_INLINE]
      0x01b2: PHI (r8v8 java.lang.String) = (r8v17 java.lang.String), (r8v18 java.lang.String) binds: [B:96:0x01af, B:15:0x003a] A[DONT_GENERATE, DONT_INLINE]
      0x01b2: PHI (r11v5 com.stepos.ability.task.executor.g) = (r11v4 com.stepos.ability.task.executor.g), (r11v16 com.stepos.ability.task.executor.g) binds: [B:96:0x01af, B:15:0x003a] A[DONT_GENERATE, DONT_INLINE]
      0x01b2: PHI (r12v11 java.lang.String) = (r12v9 java.lang.String), (r12v0 java.lang.String) binds: [B:96:0x01af, B:15:0x003a] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Type inference failed for: r1v0, types: [com.stepos.ability.task.executor.g] */
    /* JADX WARN: Type inference failed for: r1v1 */
    /* JADX WARN: Type inference failed for: r1v13, types: [java.lang.Throwable] */
    /* JADX WARN: Type inference failed for: r1v15, types: [H7.c, java.lang.Throwable] */
    /* JADX WARN: Type inference failed for: r1v16 */
    /* JADX WARN: Type inference failed for: r1v17 */
    /* JADX WARN: Type inference failed for: r1v19 */
    /* JADX WARN: Type inference failed for: r1v2 */
    /* JADX WARN: Type inference failed for: r1v20 */
    /* JADX WARN: Type inference failed for: r1v21 */
    /* JADX WARN: Type inference failed for: r1v24 */
    /* JADX WARN: Type inference failed for: r1v25 */
    /* JADX WARN: Type inference failed for: r1v27 */
    /* JADX WARN: Type inference failed for: r1v28 */
    /* JADX WARN: Type inference failed for: r1v3 */
    /* JADX WARN: Type inference failed for: r1v34 */
    /* JADX WARN: Type inference failed for: r1v37 */
    /* JADX WARN: Type inference failed for: r1v38 */
    /* JADX WARN: Type inference failed for: r1v39 */
    /* JADX WARN: Type inference failed for: r1v4 */
    /* JADX WARN: Type inference failed for: r1v45 */
    /* JADX WARN: Type inference failed for: r1v46 */
    /* JADX WARN: Type inference failed for: r1v5 */
    /* JADX WARN: Type inference failed for: r1v6 */
    /* JADX WARN: Type inference failed for: r1v7 */
    /* JADX WARN: Type inference failed for: r1v8, types: [com.stepos.ability.commoninternal.ITag, com.stepos.ability.task.executor.g] */
    /* JADX WARN: Type inference failed for: r1v9, types: [H7.c] */
    /* JADX WARN: Type inference failed for: r8v10, types: [H7.c, java.lang.Throwable] */
    /* JADX WARN: Type inference failed for: r8v12 */
    /* JADX WARN: Type inference failed for: r8v5 */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object invokeSuspend(java.lang.Object r27) throws java.lang.Throwable {
        /*
            Method dump skipped, instructions count: 500
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stepos.ability.task.executor.ToolTaskExecutor$execute$2.invokeSuspend(java.lang.Object):java.lang.Object");
    }
}
