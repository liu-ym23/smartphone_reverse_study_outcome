package kotlinx.coroutines.flow;

import C7.r;
import S7.o;
import androidx.exifinterface.media.ExifInterface;
import kotlin.Metadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.internal.Ref$LongRef;
import kotlin.jvm.internal.Ref$ObjectRef;
import m9.InterfaceC1733z;

@J7.c(c = "kotlinx.coroutines.flow.FlowKt__DelayKt$debounceInternal$1", f = "Delay.kt", l = {215, 415}, m = "invokeSuspend")
@Metadata(d1 = {"\u0000\u0014\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0005\u001a\u00020\u0004\"\u0004\b\u0000\u0010\u0000*\u00020\u00012\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00028\u00000\u0002H\n¢\u0006\u0004\b\u0005\u0010\u0006"}, d2 = {ExifInterface.GPS_DIRECTION_TRUE, "Lm9/z;", "Lp9/d;", "downstream", "LC7/r;", "<anonymous>", "(Lm9/z;Lp9/d;)V"}, k = 3, mv = {2, 0, 0})
/* loaded from: classes4.dex */
final class FlowKt__DelayKt$debounceInternal$1 extends SuspendLambda implements o {

    /* renamed from: a, reason: collision with root package name */
    public Ref$ObjectRef f5199a;
    public Ref$LongRef b;
    public int c;
    public /* synthetic */ Object d;
    public /* synthetic */ Object e;
    public final /* synthetic */ R3.f f;
    public final /* synthetic */ p9.c g;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FlowKt__DelayKt$debounceInternal$1(R3.f fVar, p9.c cVar, H7.c cVar2) {
        super(3, cVar2);
        this.f = fVar;
        this.g = cVar;
    }

    @Override // S7.o
    public final Object invoke(Object obj, Object obj2, Object obj3) {
        FlowKt__DelayKt$debounceInternal$1 flowKt__DelayKt$debounceInternal$1 = new FlowKt__DelayKt$debounceInternal$1(this.f, this.g, (H7.c) obj3);
        flowKt__DelayKt$debounceInternal$1.d = (InterfaceC1733z) obj;
        flowKt__DelayKt$debounceInternal$1.e = (p9.d) obj2;
        return flowKt__DelayKt$debounceInternal$1.invokeSuspend(r.f317a);
    }

    /* JADX WARN: Code restructure failed: missing block: B:23:0x00a1, code lost:
    
        if (r7.emit(r8, r12) == r0) goto L37;
     */
    /* JADX WARN: Code restructure failed: missing block: B:36:0x00f3, code lost:
    
        if (r7.d(r12) == r0) goto L37;
     */
    /* JADX WARN: Code restructure failed: missing block: B:40:0x001a, code lost:
    
        if (r7.e(r12) == r0) goto L37;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:14:0x006d  */
    /* JADX WARN: Removed duplicated region for block: B:26:0x00a6 A[PHI: r1 r5 r6 r7
      0x00a6: PHI (r1v3 kotlin.jvm.internal.Ref$LongRef) = (r1v5 kotlin.jvm.internal.Ref$LongRef), (r1v7 kotlin.jvm.internal.Ref$LongRef), (r1v7 kotlin.jvm.internal.Ref$LongRef) binds: [B:25:0x00a4, B:15:0x0074, B:18:0x008c] A[DONT_GENERATE, DONT_INLINE]
      0x00a6: PHI (r5v2 kotlin.jvm.internal.Ref$ObjectRef) = 
      (r5v4 kotlin.jvm.internal.Ref$ObjectRef)
      (r5v5 kotlin.jvm.internal.Ref$ObjectRef)
      (r5v5 kotlin.jvm.internal.Ref$ObjectRef)
     binds: [B:25:0x00a4, B:15:0x0074, B:18:0x008c] A[DONT_GENERATE, DONT_INLINE]
      0x00a6: PHI (r6v3 java.lang.Object) = (r6v16 java.lang.Object), (r6v17 java.lang.Object), (r6v18 java.lang.Object) binds: [B:25:0x00a4, B:15:0x0074, B:18:0x008c] A[DONT_GENERATE, DONT_INLINE]
      0x00a6: PHI (r7v3 p9.d) = (r7v5 p9.d), (r7v6 p9.d), (r7v6 p9.d) binds: [B:25:0x00a4, B:15:0x0074, B:18:0x008c] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Removed duplicated region for block: B:31:0x00c0  */
    /* JADX WARN: Removed duplicated region for block: B:34:0x00ea  */
    /* JADX WARN: Removed duplicated region for block: B:35:0x00ef  */
    /* JADX WARN: Removed duplicated region for block: B:38:0x00f6  */
    /* JADX WARN: Type inference failed for: r5v10, types: [o9.n] */
    /* JADX WARN: Type inference failed for: r5v3, types: [java.lang.Object, o9.n] */
    /* JADX WARN: Type inference failed for: r5v6 */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object invokeSuspend(java.lang.Object r13) {
        /*
            Method dump skipped, instructions count: 249
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.flow.FlowKt__DelayKt$debounceInternal$1.invokeSuspend(java.lang.Object):java.lang.Object");
    }
}
