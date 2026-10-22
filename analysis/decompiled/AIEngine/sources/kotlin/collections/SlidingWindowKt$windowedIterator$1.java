package kotlin.collections;

import com.stepos.deepbinder.core.exception.ErrorCodes;
import fc.k;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.jvm.internal.RestrictedSuspendLambda;
import kotlin.jvm.internal.g;
import lb.n;
import mb.w;
import rb.c;
import zb.p;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
@c(c = "kotlin.collections.SlidingWindowKt$windowedIterator$1", f = "SlidingWindow.kt", l = {34, 40, ErrorCodes.PRE_SERVICE_METHOD_INTERCEPT_ERROR, 55, 58}, m = "invokeSuspend")
/* loaded from: classes.dex */
final class SlidingWindowKt$windowedIterator$1 extends RestrictedSuspendLambda implements p<k<? super List<Object>>, qb.b<? super n>, Object> {

    /* renamed from: a, reason: collision with root package name */
    public Object f10004a;

    /* renamed from: b, reason: collision with root package name */
    public Iterator f10005b;

    /* renamed from: c, reason: collision with root package name */
    public int f10006c;

    /* renamed from: d, reason: collision with root package name */
    public int f10007d;

    /* renamed from: e, reason: collision with root package name */
    public /* synthetic */ Object f10008e;
    public final /* synthetic */ Iterator<Object> h;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SlidingWindowKt$windowedIterator$1(Iterator it, qb.b bVar) {
        super(2, bVar);
        this.h = it;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final qb.b<n> create(Object obj, qb.b<?> bVar) {
        SlidingWindowKt$windowedIterator$1 slidingWindowKt$windowedIterator$1 = new SlidingWindowKt$windowedIterator$1(this.h, bVar);
        slidingWindowKt$windowedIterator$1.f10008e = obj;
        return slidingWindowKt$windowedIterator$1;
    }

    @Override // zb.p
    public final Object invoke(k<? super List<Object>> kVar, qb.b<? super n> bVar) {
        return ((SlidingWindowKt$windowedIterator$1) create(kVar, bVar)).invokeSuspend(n.f10413a);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        k kVar;
        ArrayList arrayList;
        Iterator<Object> it;
        int i10;
        w wVar;
        k kVar2;
        Object[] array;
        CoroutineSingletons coroutineSingletons = CoroutineSingletons.f10059a;
        int i11 = this.f10007d;
        if (i11 == 0) {
            kotlin.c.b(obj);
            kVar = (k) this.f10008e;
            arrayList = new ArrayList(2);
            it = this.h;
            i10 = 0;
        } else {
            if (i11 != 1) {
                if (i11 == 2) {
                    kotlin.c.b(obj);
                } else {
                    if (i11 == 3) {
                        Iterator it2 = this.f10005b;
                        w wVar2 = (w) this.f10004a;
                        k kVar3 = (k) this.f10008e;
                        kotlin.c.b(obj);
                        wVar2.b();
                        while (true) {
                            int i12 = wVar2.f10565b;
                            Object[] objArr = wVar2.f10564a;
                            if (!it2.hasNext()) {
                                wVar = wVar2;
                                kVar2 = kVar3;
                                break;
                            }
                            Object next = it2.next();
                            if (wVar2.a() == i12) {
                                throw new IllegalStateException("ring buffer is full");
                            }
                            int i13 = wVar2.f10566c;
                            int i14 = wVar2.f10567d;
                            objArr[(i13 + i14) % i12] = next;
                            wVar2.f10567d = i14 + 1;
                            if (wVar2.a() == i12) {
                                if (wVar2.f10567d >= 2) {
                                    ArrayList arrayList2 = new ArrayList(wVar2);
                                    this.f10008e = kVar3;
                                    this.f10004a = wVar2;
                                    this.f10005b = it2;
                                    this.f10007d = 3;
                                    kVar3.a(arrayList2, this);
                                    CoroutineSingletons coroutineSingletons2 = CoroutineSingletons.f10059a;
                                    return coroutineSingletons;
                                }
                                int i15 = i12 + (i12 >> 1) + 1;
                                if (i15 > 2) {
                                    i15 = 2;
                                }
                                if (wVar2.f10566c == 0) {
                                    array = Arrays.copyOf(objArr, i15);
                                    g.e(array, "copyOf(...)");
                                } else {
                                    array = wVar2.toArray(new Object[i15]);
                                }
                                wVar2 = new w(array, wVar2.f10567d);
                            }
                        }
                    } else if (i11 != 4) {
                        if (i11 != 5) {
                            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                        }
                        kotlin.c.b(obj);
                    } else {
                        wVar = (w) this.f10004a;
                        kVar2 = (k) this.f10008e;
                        kotlin.c.b(obj);
                        wVar.b();
                    }
                    if (wVar.f10567d > 2) {
                        ArrayList arrayList3 = new ArrayList(wVar);
                        this.f10008e = kVar2;
                        this.f10004a = wVar;
                        this.f10005b = null;
                        this.f10007d = 4;
                        kVar2.a(arrayList3, this);
                        CoroutineSingletons coroutineSingletons3 = CoroutineSingletons.f10059a;
                        return coroutineSingletons;
                    }
                    if (!wVar.isEmpty()) {
                        this.f10008e = null;
                        this.f10004a = null;
                        this.f10005b = null;
                        this.f10007d = 5;
                        kVar2.a(wVar, this);
                        CoroutineSingletons coroutineSingletons4 = CoroutineSingletons.f10059a;
                        return coroutineSingletons;
                    }
                }
                return n.f10413a;
            }
            i10 = this.f10006c;
            it = this.f10005b;
            kVar = (k) this.f10008e;
            kotlin.c.b(obj);
            arrayList = new ArrayList(2);
        }
        k kVar4 = kVar;
        Iterator<Object> it3 = it;
        int i16 = i10;
        while (it3.hasNext()) {
            Object next2 = it3.next();
            if (i10 > 0) {
                i10--;
            } else {
                arrayList.add(next2);
                if (arrayList.size() == 2) {
                    this.f10008e = kVar4;
                    this.f10004a = arrayList;
                    this.f10005b = it3;
                    this.f10006c = i16;
                    this.f10007d = 1;
                    kVar4.a(arrayList, this);
                    CoroutineSingletons coroutineSingletons5 = CoroutineSingletons.f10059a;
                    return coroutineSingletons;
                }
            }
        }
        if (!arrayList.isEmpty()) {
            this.f10008e = null;
            this.f10004a = null;
            this.f10005b = null;
            this.f10007d = 2;
            kVar4.a(arrayList, this);
            CoroutineSingletons coroutineSingletons6 = CoroutineSingletons.f10059a;
            return coroutineSingletons;
        }
        return n.f10413a;
    }
}
