package kotlinx.coroutines.flow.internal;

import C7.r;
import S7.n;
import S7.o;
import java.util.concurrent.atomic.AtomicInteger;
import kotlin.Metadata;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import m9.InterfaceC1733z;
import o9.InterfaceC1779e;

@J7.c(c = "kotlinx.coroutines.flow.internal.CombineKt$combineInternal$2", f = "Combine.kt", l = {51, 73, 76}, m = "invokeSuspend")
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lm9/z;", "LC7/r;", "<anonymous>", "(Lm9/z;)V"}, k = 3, mv = {2, 0, 0})
/* loaded from: classes4.dex */
final class CombineKt$combineInternal$2 extends SuspendLambda implements n {

    /* renamed from: a, reason: collision with root package name */
    public InterfaceC1779e f5237a;
    public byte[] b;
    public int c;
    public int d;
    public int e;
    public /* synthetic */ Object f;
    public final /* synthetic */ p9.c[] g;
    public final /* synthetic */ o h;
    public final /* synthetic */ p9.d i;

    @J7.c(c = "kotlinx.coroutines.flow.internal.CombineKt$combineInternal$2$1", f = "Combine.kt", l = {28}, m = "invokeSuspend")
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lm9/z;", "LC7/r;", "<anonymous>", "(Lm9/z;)V"}, k = 3, mv = {2, 0, 0})
    /* renamed from: kotlinx.coroutines.flow.internal.CombineKt$combineInternal$2$1, reason: invalid class name */
    final class AnonymousClass1 extends SuspendLambda implements n {

        /* renamed from: a, reason: collision with root package name */
        public int f5238a;
        public final /* synthetic */ p9.c[] b;
        public final /* synthetic */ int c;
        public final /* synthetic */ AtomicInteger d;
        public final /* synthetic */ kotlinx.coroutines.channels.a e;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass1(p9.c[] cVarArr, int i, AtomicInteger atomicInteger, kotlinx.coroutines.channels.a aVar, H7.c cVar) {
            super(2, cVar);
            this.b = cVarArr;
            this.c = i;
            this.d = atomicInteger;
            this.e = aVar;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final H7.c create(Object obj, H7.c cVar) {
            return new AnonymousClass1(this.b, this.c, this.d, this.e, cVar);
        }

        @Override // S7.n
        public final Object invoke(Object obj, Object obj2) {
            return ((AnonymousClass1) create((InterfaceC1733z) obj, (H7.c) obj2)).invokeSuspend(r.f317a);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            CoroutineSingletons coroutineSingletons = CoroutineSingletons.f4909a;
            int i = this.f5238a;
            AtomicInteger atomicInteger = this.d;
            kotlinx.coroutines.channels.a aVar = this.e;
            try {
                if (i == 0) {
                    kotlin.b.b(obj);
                    p9.c[] cVarArr = this.b;
                    int i6 = this.c;
                    p9.c cVar = cVarArr[i6];
                    f fVar = new f(aVar, i6);
                    this.f5238a = 1;
                    if (cVar.collect(fVar, this) == coroutineSingletons) {
                        return coroutineSingletons;
                    }
                } else {
                    if (i != 1) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    kotlin.b.b(obj);
                }
                if (atomicInteger.decrementAndGet() == 0) {
                    aVar.s(null);
                }
                return r.f317a;
            } finally {
                if (atomicInteger.decrementAndGet() == 0) {
                    aVar.s(null);
                }
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public CombineKt$combineInternal$2(H7.c cVar, o oVar, p9.d dVar, p9.c[] cVarArr) {
        super(2, cVar);
        this.g = cVarArr;
        this.h = oVar;
        this.i = dVar;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final H7.c create(Object obj, H7.c cVar) {
        CombineKt$combineInternal$2 combineKt$combineInternal$2 = new CombineKt$combineInternal$2(cVar, this.h, this.i, this.g);
        combineKt$combineInternal$2.f = obj;
        return combineKt$combineInternal$2;
    }

    @Override // S7.n
    public final Object invoke(Object obj, Object obj2) {
        return ((CombineKt$combineInternal$2) create((InterfaceC1733z) obj, (H7.c) obj2)).invokeSuspend(r.f317a);
    }

    /* JADX WARN: Code restructure failed: missing block: B:36:0x007c, code lost:
    
        if (r4 != 0) goto L18;
     */
    /* JADX WARN: Path cross not found for [B:32:0x00bb, B:30:0x00ac], limit reached: 38 */
    /* JADX WARN: Path cross not found for [B:33:0x00bd, B:18:0x007c], limit reached: 38 */
    /* JADX WARN: Removed duplicated region for block: B:25:0x009c A[LOOP:0: B:25:0x009c->B:38:?, LOOP_START, PHI: r4 r10
      0x009c: PHI (r4v3 int) = (r4v2 int), (r4v4 int) binds: [B:22:0x0097, B:38:?] A[DONT_GENERATE, DONT_INLINE]
      0x009c: PHI (r10v4 D7.D) = (r10v3 D7.D), (r10v10 D7.D) binds: [B:22:0x0097, B:38:?] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:34:0x00d1 -> B:18:0x007c). Please report as a decompilation issue!!! */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object invokeSuspend(java.lang.Object r18) {
        /*
            Method dump skipped, instructions count: 212
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.flow.internal.CombineKt$combineInternal$2.invokeSuspend(java.lang.Object):java.lang.Object");
    }
}
