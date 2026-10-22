package kotlinx.coroutines.flow;

import C7.r;
import S7.n;
import S7.o;
import androidx.exifinterface.media.ExifInterface;
import kotlin.Metadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;

@J7.c(c = "kotlinx.coroutines.flow.FlowKt__MergeKt$mapLatest$1", f = "Merge.kt", l = {213, 213}, m = "invokeSuspend")
@Metadata(d1 = {"\u0000\u0010\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0005\u001a\u00020\u0004\"\u0004\b\u0000\u0010\u0000\"\u0004\b\u0001\u0010\u0001*\b\u0012\u0004\u0012\u00028\u00000\u00022\u0006\u0010\u0003\u001a\u00028\u0001H\n"}, d2 = {"R", ExifInterface.GPS_DIRECTION_TRUE, "Lp9/d;", "it", "LC7/r;", "<anonymous>"}, k = 3, mv = {2, 0, 0})
/* loaded from: classes4.dex */
final class FlowKt__MergeKt$mapLatest$1 extends SuspendLambda implements o {

    /* renamed from: a, reason: collision with root package name */
    public int f5210a;
    public /* synthetic */ p9.d b;
    public /* synthetic */ Object c;
    public final /* synthetic */ SuspendLambda d;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public FlowKt__MergeKt$mapLatest$1(n nVar, H7.c cVar) {
        super(3, cVar);
        this.d = (SuspendLambda) nVar;
    }

    /* JADX WARN: Type inference failed for: r1v1, types: [S7.n, kotlin.coroutines.jvm.internal.SuspendLambda] */
    @Override // S7.o
    public final Object invoke(Object obj, Object obj2, Object obj3) {
        FlowKt__MergeKt$mapLatest$1 flowKt__MergeKt$mapLatest$1 = new FlowKt__MergeKt$mapLatest$1(this.d, (H7.c) obj3);
        flowKt__MergeKt$mapLatest$1.b = (p9.d) obj;
        flowKt__MergeKt$mapLatest$1.c = obj2;
        return flowKt__MergeKt$mapLatest$1.invokeSuspend(r.f317a);
    }

    /* JADX WARN: Code restructure failed: missing block: B:14:0x003b, code lost:
    
        if (r1.emit(r5, r4) == r0) goto L15;
     */
    /* JADX WARN: Type inference failed for: r3v1, types: [S7.n, kotlin.coroutines.jvm.internal.SuspendLambda] */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object invokeSuspend(java.lang.Object r5) {
        /*
            r4 = this;
            kotlin.coroutines.intrinsics.CoroutineSingletons r0 = kotlin.coroutines.intrinsics.CoroutineSingletons.f4909a
            int r1 = r4.f5210a
            r2 = 2
            r3 = 1
            if (r1 == 0) goto L1e
            if (r1 == r3) goto L18
            if (r1 != r2) goto L10
            kotlin.b.b(r5)
            goto L3e
        L10:
            java.lang.IllegalStateException r4 = new java.lang.IllegalStateException
            java.lang.String r5 = "call to 'resume' before 'invoke' with coroutine"
            r4.<init>(r5)
            throw r4
        L18:
            p9.d r1 = r4.b
            kotlin.b.b(r5)
            goto L32
        L1e:
            kotlin.b.b(r5)
            p9.d r1 = r4.b
            java.lang.Object r5 = r4.c
            r4.b = r1
            r4.f5210a = r3
            kotlin.coroutines.jvm.internal.SuspendLambda r3 = r4.d
            java.lang.Object r5 = r3.invoke(r5, r4)
            if (r5 != r0) goto L32
            goto L3d
        L32:
            r3 = 0
            r4.b = r3
            r4.f5210a = r2
            java.lang.Object r4 = r1.emit(r5, r4)
            if (r4 != r0) goto L3e
        L3d:
            return r0
        L3e:
            C7.r r4 = C7.r.f317a
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.flow.FlowKt__MergeKt$mapLatest$1.invokeSuspend(java.lang.Object):java.lang.Object");
    }
}
