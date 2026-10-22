package androidx.collection;

import C7.r;
import J7.c;
import S7.n;
import androidx.exifinterface.media.ExifInterface;
import i9.k;
import kotlin.Metadata;
import kotlin.coroutines.jvm.internal.RestrictedSuspendLambda;

@c(c = "androidx.collection.MutableKeys$iterator$1$iterator$1", f = "ScatterMap.kt", l = {1622}, m = "invokeSuspend")
@Metadata(d1 = {"\u0000\u0014\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0005\u001a\u00020\u0004\"\u0004\b\u0000\u0010\u0000\"\u0004\b\u0001\u0010\u0001*\b\u0012\u0004\u0012\u00020\u00030\u0002H\u008a@¢\u0006\u0004\b\u0005\u0010\u0006"}, d2 = {"K", ExifInterface.GPS_MEASUREMENT_INTERRUPTED, "Li9/k;", "", "LC7/r;", "<anonymous>", "(Li9/k;)V"}, k = 3, mv = {1, 9, 0})
/* loaded from: classes.dex */
public final class MutableKeys$iterator$1$iterator$1 extends RestrictedSuspendLambda implements n {
    int I$0;
    int I$1;
    int I$2;
    int I$3;
    long J$0;
    private /* synthetic */ Object L$0;
    Object L$1;
    int label;
    final /* synthetic */ MutableKeys<K, V> this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public MutableKeys$iterator$1$iterator$1(MutableKeys<K, V> mutableKeys, H7.c<? super MutableKeys$iterator$1$iterator$1> cVar) {
        super(2, cVar);
        this.this$0 = mutableKeys;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final H7.c<r> create(Object obj, H7.c<?> cVar) {
        MutableKeys$iterator$1$iterator$1 mutableKeys$iterator$1$iterator$1 = new MutableKeys$iterator$1$iterator$1(this.this$0, cVar);
        mutableKeys$iterator$1$iterator$1.L$0 = obj;
        return mutableKeys$iterator$1$iterator$1;
    }

    @Override // S7.n
    public final Object invoke(k kVar, H7.c<? super r> cVar) {
        return ((MutableKeys$iterator$1$iterator$1) create(kVar, cVar)).invokeSuspend(r.f317a);
    }

    /* JADX WARN: Removed duplicated region for block: B:13:0x0052  */
    /* JADX WARN: Removed duplicated region for block: B:15:0x0066  */
    /* JADX WARN: Removed duplicated region for block: B:20:0x0090  */
    /* JADX WARN: Removed duplicated region for block: B:23:0x0098  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:12:0x0050 -> B:22:0x0096). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:13:0x0052 -> B:14:0x0064). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:16:0x006d -> B:19:0x008d). Please report as a decompilation issue!!! */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object invokeSuspend(java.lang.Object r20) {
        /*
            r19 = this;
            r0 = r19
            kotlin.coroutines.intrinsics.CoroutineSingletons r1 = kotlin.coroutines.intrinsics.CoroutineSingletons.f4909a
            int r2 = r0.label
            r3 = 0
            r4 = 8
            r5 = 1
            if (r2 == 0) goto L2d
            if (r2 != r5) goto L25
            int r2 = r0.I$3
            int r6 = r0.I$2
            long r7 = r0.J$0
            int r9 = r0.I$1
            int r10 = r0.I$0
            java.lang.Object r11 = r0.L$1
            long[] r11 = (long[]) r11
            java.lang.Object r12 = r0.L$0
            i9.k r12 = (i9.k) r12
            kotlin.b.b(r20)
            goto L8d
        L25:
            java.lang.IllegalStateException r0 = new java.lang.IllegalStateException
            java.lang.String r1 = "call to 'resume' before 'invoke' with coroutine"
            r0.<init>(r1)
            throw r0
        L2d:
            kotlin.b.b(r20)
            java.lang.Object r2 = r0.L$0
            i9.k r2 = (i9.k) r2
            androidx.collection.MutableKeys<K, V> r6 = r0.this$0
            androidx.collection.MutableScatterMap r6 = androidx.collection.MutableKeys.access$getParent$p(r6)
            long[] r6 = r6.metadata
            int r7 = r6.length
            int r7 = r7 + (-2)
            if (r7 < 0) goto L9b
            r8 = r3
        L42:
            r9 = r6[r8]
            long r11 = ~r9
            r13 = 7
            long r11 = r11 << r13
            long r11 = r11 & r9
            r13 = -9187201950435737472(0x8080808080808080, double:-2.937446524422997E-306)
            long r11 = r11 & r13
            int r11 = (r11 > r13 ? 1 : (r11 == r13 ? 0 : -1))
            if (r11 == 0) goto L96
            int r11 = r8 - r7
            int r11 = ~r11
            int r11 = r11 >>> 31
            int r11 = 8 - r11
            r12 = r11
            r11 = r6
            r6 = r12
            r12 = r2
            r2 = r3
            r17 = r9
            r10 = r7
            r9 = r8
            r7 = r17
        L64:
            if (r2 >= r6) goto L90
            r13 = 255(0xff, double:1.26E-321)
            long r13 = r13 & r7
            r15 = 128(0x80, double:6.3E-322)
            int r13 = (r13 > r15 ? 1 : (r13 == r15 ? 0 : -1))
            if (r13 >= 0) goto L8d
            int r3 = r9 << 3
            int r3 = r3 + r2
            java.lang.Integer r4 = new java.lang.Integer
            r4.<init>(r3)
            r0.L$0 = r12
            r0.L$1 = r11
            r0.I$0 = r10
            r0.I$1 = r9
            r0.J$0 = r7
            r0.I$2 = r6
            r0.I$3 = r2
            r0.label = r5
            r12.a(r0, r4)
            kotlin.coroutines.intrinsics.CoroutineSingletons r0 = kotlin.coroutines.intrinsics.CoroutineSingletons.f4909a
            return r1
        L8d:
            long r7 = r7 >> r4
            int r2 = r2 + r5
            goto L64
        L90:
            if (r6 != r4) goto L9b
            r8 = r9
            r7 = r10
            r6 = r11
            r2 = r12
        L96:
            if (r8 == r7) goto L9b
            int r8 = r8 + 1
            goto L42
        L9b:
            C7.r r0 = C7.r.f317a
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.collection.MutableKeys$iterator$1$iterator$1.invokeSuspend(java.lang.Object):java.lang.Object");
    }
}
