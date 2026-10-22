package kotlin.collections;

import C7.r;
import J7.c;
import S7.n;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.exifinterface.media.ExifInterface;
import i9.k;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.coroutines.jvm.internal.RestrictedSuspendLambda;

@c(c = "kotlin.collections.SlidingWindowKt$windowedIterator$1", f = "SlidingWindow.kt", l = {34, 40, 49, ConstraintLayout.LayoutParams.Table.LAYOUT_GONE_MARGIN_BASELINE, 58}, m = "invokeSuspend", v = 2)
@Metadata(d1 = {"\u0000\u0012\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0004\u001a\u00020\u0003\"\u0004\b\u0000\u0010\u0000*\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u00020\u0001H\n¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {ExifInterface.GPS_DIRECTION_TRUE, "Li9/k;", "", "LC7/r;", "<anonymous>", "(Li9/k;)V"}, k = 3, mv = {2, 2, 0})
/* loaded from: classes3.dex */
final class SlidingWindowKt$windowedIterator$1 extends RestrictedSuspendLambda implements n {

    /* renamed from: a, reason: collision with root package name */
    public Object f4896a;
    public Iterator b;
    public int c;
    public int d;
    public int e;
    public /* synthetic */ Object f;
    public final /* synthetic */ int g;
    public final /* synthetic */ int h;
    public final /* synthetic */ Iterator i;

    /* renamed from: j, reason: collision with root package name */
    public final /* synthetic */ boolean f4897j;
    public final /* synthetic */ boolean k;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SlidingWindowKt$windowedIterator$1(int i, int i6, Iterator it, boolean z10, boolean z11, H7.c cVar) {
        super(2, cVar);
        this.g = i;
        this.h = i6;
        this.i = it;
        this.f4897j = z10;
        this.k = z11;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final H7.c create(Object obj, H7.c cVar) {
        SlidingWindowKt$windowedIterator$1 slidingWindowKt$windowedIterator$1 = new SlidingWindowKt$windowedIterator$1(this.g, this.h, this.i, this.f4897j, this.k, cVar);
        slidingWindowKt$windowedIterator$1.f = obj;
        return slidingWindowKt$windowedIterator$1;
    }

    @Override // S7.n
    public final Object invoke(Object obj, Object obj2) {
        return ((SlidingWindowKt$windowedIterator$1) create((k) obj, (H7.c) obj2)).invokeSuspend(r.f317a);
    }

    /* JADX WARN: Removed duplicated region for block: B:30:0x009b  */
    /* JADX WARN: Removed duplicated region for block: B:47:0x00fb  */
    /* JADX WARN: Removed duplicated region for block: B:84:0x0172 A[SYNTHETIC] */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object invokeSuspend(java.lang.Object r21) {
        /*
            Method dump skipped, instructions count: 436
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlin.collections.SlidingWindowKt$windowedIterator$1.invokeSuspend(java.lang.Object):java.lang.Object");
    }
}
