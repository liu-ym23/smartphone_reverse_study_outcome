package androidx.collection;

import C7.r;
import J7.c;
import S7.n;
import androidx.collection.MutableOrderedSetWrapper;
import androidx.exifinterface.media.ExifInterface;
import i9.k;
import kotlin.Metadata;
import kotlin.b;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.jvm.internal.RestrictedSuspendLambda;

@c(c = "androidx.collection.MutableOrderedSetWrapper$iterator$1$iterator$1", f = "OrderedScatterSet.kt", l = {1489}, m = "invokeSuspend")
@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0003\u001a\u00020\u0002\"\u0004\b\u0000\u0010\u0000*\b\u0012\u0004\u0012\u00028\u00000\u0001H\u008a@¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {ExifInterface.LONGITUDE_EAST, "Li9/k;", "LC7/r;", "<anonymous>", "(Li9/k;)V"}, k = 3, mv = {1, 9, 0})
/* loaded from: classes.dex */
public final class MutableOrderedSetWrapper$iterator$1$iterator$1 extends RestrictedSuspendLambda implements n {
    int I$0;
    private /* synthetic */ Object L$0;
    Object L$1;
    Object L$2;
    Object L$3;
    int label;
    final /* synthetic */ MutableOrderedSetWrapper<E> this$0;
    final /* synthetic */ MutableOrderedSetWrapper.AnonymousClass1 this$1;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public MutableOrderedSetWrapper$iterator$1$iterator$1(MutableOrderedSetWrapper<E> mutableOrderedSetWrapper, MutableOrderedSetWrapper.AnonymousClass1 anonymousClass1, H7.c<? super MutableOrderedSetWrapper$iterator$1$iterator$1> cVar) {
        super(2, cVar);
        this.this$0 = mutableOrderedSetWrapper;
        this.this$1 = anonymousClass1;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final H7.c<r> create(Object obj, H7.c<?> cVar) {
        MutableOrderedSetWrapper$iterator$1$iterator$1 mutableOrderedSetWrapper$iterator$1$iterator$1 = new MutableOrderedSetWrapper$iterator$1$iterator$1(this.this$0, this.this$1, cVar);
        mutableOrderedSetWrapper$iterator$1$iterator$1.L$0 = obj;
        return mutableOrderedSetWrapper$iterator$1$iterator$1;
    }

    @Override // S7.n
    public final Object invoke(k kVar, H7.c<? super r> cVar) {
        return ((MutableOrderedSetWrapper$iterator$1$iterator$1) create(kVar, cVar)).invokeSuspend(r.f317a);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        k kVar;
        MutableOrderedSetWrapper.AnonymousClass1 anonymousClass1;
        MutableOrderedSetWrapper mutableOrderedSetWrapper;
        long[] jArr;
        int i;
        CoroutineSingletons coroutineSingletons = CoroutineSingletons.f4909a;
        int i6 = this.label;
        if (i6 == 0) {
            b.b(obj);
            kVar = (k) this.L$0;
            MutableOrderedScatterSet mutableOrderedScatterSet = ((MutableOrderedSetWrapper) this.this$0).parent;
            anonymousClass1 = this.this$1;
            mutableOrderedSetWrapper = this.this$0;
            jArr = mutableOrderedScatterSet.nodes;
            i = mutableOrderedScatterSet.tail;
        } else {
            if (i6 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            i = this.I$0;
            jArr = (long[]) this.L$3;
            mutableOrderedSetWrapper = (MutableOrderedSetWrapper) this.L$2;
            anonymousClass1 = (MutableOrderedSetWrapper.AnonymousClass1) this.L$1;
            kVar = (k) this.L$0;
            b.b(obj);
        }
        if (i == Integer.MAX_VALUE) {
            return r.f317a;
        }
        int i10 = (int) ((jArr[i] >> 31) & SieveCacheKt.NodeLinkMask);
        anonymousClass1.setCurrent(i);
        Object obj2 = mutableOrderedSetWrapper.parent.elements[i];
        this.L$0 = kVar;
        this.L$1 = anonymousClass1;
        this.L$2 = mutableOrderedSetWrapper;
        this.L$3 = jArr;
        this.I$0 = i10;
        this.label = 1;
        kVar.a(this, obj2);
        return coroutineSingletons;
    }
}
