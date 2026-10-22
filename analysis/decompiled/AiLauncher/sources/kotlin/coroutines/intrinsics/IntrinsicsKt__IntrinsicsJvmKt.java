package kotlin.coroutines.intrinsics;

import Y8.t;
import androidx.exifinterface.media.ExifInterface;
import com.autonavi.aps.amapapi.config.Const;
import e9.InterfaceC4014c;
import g9.f;
import kotlin.C4849c;
import kotlin.Metadata;
import kotlin.coroutines.EmptyCoroutineContext;
import kotlin.coroutines.d;
import kotlin.coroutines.jvm.internal.BaseContinuationImpl;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.RestrictedContinuationImpl;
import kotlin.jvm.internal.p;
import kotlin.jvm.internal.z;
import p9.InterfaceC5074l;
import p9.q;

@Metadata(d1 = {"\u0000(\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\u001aS\u0010\u0007\u001a\u0004\u0018\u00010\u0004\"\u0004\b\u0000\u0010\u0000\"\u0004\b\u0001\u0010\u0001*\u001e\b\u0001\u0012\u0004\u0012\u00028\u0000\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00010\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u00040\u00022\u0006\u0010\u0005\u001a\u00028\u00002\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00028\u00010\u0003H\u0001¢\u0006\u0004\b\u0007\u0010\b\u001ag\u0010\f\u001a\u0004\u0018\u00010\u0004\"\u0004\b\u0000\u0010\u0000\"\u0004\b\u0001\u0010\t\"\u0004\b\u0002\u0010\u0001*$\b\u0001\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00020\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u00040\n2\u0006\u0010\u0005\u001a\u00028\u00002\u0006\u0010\u000b\u001a\u00028\u00012\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00028\u00020\u0003H\u0001¢\u0006\u0004\b\f\u0010\r\u001aC\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u000f0\u0003\"\u0004\b\u0000\u0010\u0001*\u0018\b\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u00040\u000e2\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00028\u00000\u0003H\u0007¢\u0006\u0004\b\u0010\u0010\u0011\u001aW\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u000f0\u0003\"\u0004\b\u0000\u0010\u0000\"\u0004\b\u0001\u0010\u0001*\u001e\b\u0001\u0012\u0004\u0012\u00028\u0000\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00010\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u00040\u00022\u0006\u0010\u0005\u001a\u00028\u00002\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00028\u00010\u0003H\u0007¢\u0006\u0004\b\u0012\u0010\u0013\u001a%\u0010\u0014\u001a\b\u0012\u0004\u0012\u00028\u00000\u0003\"\u0004\b\u0000\u0010\u0001*\b\u0012\u0004\u0012\u00028\u00000\u0003H\u0007¢\u0006\u0004\b\u0014\u0010\u0015\u001a)\u0010\u0016\u001a\b\u0012\u0004\u0012\u00028\u00000\u0003\"\u0004\b\u0000\u0010\u00012\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00028\u00000\u0003H\u0002¢\u0006\u0004\b\u0016\u0010\u0015¨\u0006\u0017"}, d2 = {"R", ExifInterface.GPS_DIRECTION_TRUE, "Lkotlin/Function2;", "Le9/c;", "", "receiver", "completion", "e", "(Lp9/p;Ljava/lang/Object;Le9/c;)Ljava/lang/Object;", "P", "Lkotlin/Function3;", "param", "f", "(Lp9/q;Ljava/lang/Object;Ljava/lang/Object;Le9/c;)Ljava/lang/Object;", "Lkotlin/Function1;", "LY8/t;", Const.INTENT_KEY_APIKEY, "(Lp9/l;Le9/c;)Le9/c;", Const.INTENT_KEY_PKGNAME, "(Lp9/p;Ljava/lang/Object;Le9/c;)Le9/c;", Const.INTENT_KEY_UMID, "(Le9/c;)Le9/c;", "c", "kotlin-stdlib"}, k = 5, mv = {2, 2, 0}, xi = 49, xs = "kotlin/coroutines/intrinsics/IntrinsicsKt")
/* loaded from: classes4.dex */
public class IntrinsicsKt__IntrinsicsJvmKt {
    /* JADX WARN: Multi-variable type inference failed */
    public static <T> InterfaceC4014c<t> a(final InterfaceC5074l<? super InterfaceC4014c<? super T>, ? extends Object> interfaceC5074l, InterfaceC4014c<? super T> completion) {
        p.i(interfaceC5074l, "<this>");
        p.i(completion, "completion");
        final InterfaceC4014c<?> interfaceC4014cA = f.a(completion);
        if (interfaceC5074l instanceof BaseContinuationImpl) {
            return ((BaseContinuationImpl) interfaceC5074l).create(interfaceC4014cA);
        }
        final d context = interfaceC4014cA.getContext();
        return context == EmptyCoroutineContext.f34779a ? new RestrictedContinuationImpl(interfaceC4014cA, interfaceC5074l) { // from class: kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsJvmKt$createCoroutineUnintercepted$$inlined$createCoroutineFromSuspendFunction$IntrinsicsKt__IntrinsicsJvmKt$1

            /* renamed from: a, reason: collision with root package name and from kotlin metadata */
            public int label;

            /* renamed from: b, reason: collision with root package name */
            public final /* synthetic */ InterfaceC5074l f34785b;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(interfaceC4014cA);
                this.f34785b = interfaceC5074l;
                p.g(interfaceC4014cA, "null cannot be cast to non-null type kotlin.coroutines.Continuation<kotlin.Any?>");
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public Object invokeSuspend(Object result) throws Throwable {
                int i10 = this.label;
                if (i10 == 0) {
                    this.label = 1;
                    C4849c.b(result);
                    p.g(this.f34785b, "null cannot be cast to non-null type kotlin.Function1<kotlin.coroutines.Continuation<T of kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsJvmKt.createCoroutineUnintercepted>, kotlin.Any?>");
                    return ((InterfaceC5074l) z.g(this.f34785b, 1)).invoke(this);
                }
                if (i10 != 1) {
                    throw new IllegalStateException("This coroutine had already completed");
                }
                this.label = 2;
                C4849c.b(result);
                return result;
            }
        } : new ContinuationImpl(interfaceC4014cA, context, interfaceC5074l) { // from class: kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsJvmKt$createCoroutineUnintercepted$$inlined$createCoroutineFromSuspendFunction$IntrinsicsKt__IntrinsicsJvmKt$2

            /* renamed from: a, reason: collision with root package name and from kotlin metadata */
            public int label;

            /* renamed from: b, reason: collision with root package name */
            public final /* synthetic */ InterfaceC5074l f34787b;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(interfaceC4014cA, context);
                this.f34787b = interfaceC5074l;
                p.g(interfaceC4014cA, "null cannot be cast to non-null type kotlin.coroutines.Continuation<kotlin.Any?>");
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public Object invokeSuspend(Object result) throws Throwable {
                int i10 = this.label;
                if (i10 == 0) {
                    this.label = 1;
                    C4849c.b(result);
                    p.g(this.f34787b, "null cannot be cast to non-null type kotlin.Function1<kotlin.coroutines.Continuation<T of kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsJvmKt.createCoroutineUnintercepted>, kotlin.Any?>");
                    return ((InterfaceC5074l) z.g(this.f34787b, 1)).invoke(this);
                }
                if (i10 != 1) {
                    throw new IllegalStateException("This coroutine had already completed");
                }
                this.label = 2;
                C4849c.b(result);
                return result;
            }
        };
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static <R, T> InterfaceC4014c<t> b(final p9.p<? super R, ? super InterfaceC4014c<? super T>, ? extends Object> pVar, final R r10, InterfaceC4014c<? super T> completion) {
        p.i(pVar, "<this>");
        p.i(completion, "completion");
        final InterfaceC4014c<?> interfaceC4014cA = f.a(completion);
        if (pVar instanceof BaseContinuationImpl) {
            return ((BaseContinuationImpl) pVar).create(r10, interfaceC4014cA);
        }
        final d context = interfaceC4014cA.getContext();
        return context == EmptyCoroutineContext.f34779a ? new RestrictedContinuationImpl(interfaceC4014cA, pVar, r10) { // from class: kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsJvmKt$createCoroutineUnintercepted$$inlined$createCoroutineFromSuspendFunction$IntrinsicsKt__IntrinsicsJvmKt$3

            /* renamed from: a, reason: collision with root package name and from kotlin metadata */
            public int label;

            /* renamed from: b, reason: collision with root package name */
            public final /* synthetic */ p9.p f34789b;

            /* renamed from: c, reason: collision with root package name */
            public final /* synthetic */ Object f34790c;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(interfaceC4014cA);
                this.f34789b = pVar;
                this.f34790c = r10;
                p.g(interfaceC4014cA, "null cannot be cast to non-null type kotlin.coroutines.Continuation<kotlin.Any?>");
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public Object invokeSuspend(Object result) throws Throwable {
                int i10 = this.label;
                if (i10 == 0) {
                    this.label = 1;
                    C4849c.b(result);
                    p.g(this.f34789b, "null cannot be cast to non-null type kotlin.Function2<R of kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsJvmKt.createCoroutineUnintercepted, kotlin.coroutines.Continuation<T of kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsJvmKt.createCoroutineUnintercepted>, kotlin.Any?>");
                    return ((p9.p) z.g(this.f34789b, 2)).invoke(this.f34790c, this);
                }
                if (i10 != 1) {
                    throw new IllegalStateException("This coroutine had already completed");
                }
                this.label = 2;
                C4849c.b(result);
                return result;
            }
        } : new ContinuationImpl(interfaceC4014cA, context, pVar, r10) { // from class: kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsJvmKt$createCoroutineUnintercepted$$inlined$createCoroutineFromSuspendFunction$IntrinsicsKt__IntrinsicsJvmKt$4

            /* renamed from: a, reason: collision with root package name and from kotlin metadata */
            public int label;

            /* renamed from: b, reason: collision with root package name */
            public final /* synthetic */ p9.p f34792b;

            /* renamed from: c, reason: collision with root package name */
            public final /* synthetic */ Object f34793c;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(interfaceC4014cA, context);
                this.f34792b = pVar;
                this.f34793c = r10;
                p.g(interfaceC4014cA, "null cannot be cast to non-null type kotlin.coroutines.Continuation<kotlin.Any?>");
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public Object invokeSuspend(Object result) throws Throwable {
                int i10 = this.label;
                if (i10 == 0) {
                    this.label = 1;
                    C4849c.b(result);
                    p.g(this.f34792b, "null cannot be cast to non-null type kotlin.Function2<R of kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsJvmKt.createCoroutineUnintercepted, kotlin.coroutines.Continuation<T of kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsJvmKt.createCoroutineUnintercepted>, kotlin.Any?>");
                    return ((p9.p) z.g(this.f34792b, 2)).invoke(this.f34793c, this);
                }
                if (i10 != 1) {
                    throw new IllegalStateException("This coroutine had already completed");
                }
                this.label = 2;
                C4849c.b(result);
                return result;
            }
        };
    }

    public static final <T> InterfaceC4014c<T> c(final InterfaceC4014c<? super T> interfaceC4014c) {
        final d context = interfaceC4014c.getContext();
        return context == EmptyCoroutineContext.f34779a ? new RestrictedContinuationImpl(interfaceC4014c) { // from class: kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsJvmKt$createSimpleCoroutineForSuspendFunction$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(interfaceC4014c);
                p.g(interfaceC4014c, "null cannot be cast to non-null type kotlin.coroutines.Continuation<kotlin.Any?>");
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public Object invokeSuspend(Object result) throws Throwable {
                C4849c.b(result);
                return result;
            }
        } : new ContinuationImpl(interfaceC4014c, context) { // from class: kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsJvmKt$createSimpleCoroutineForSuspendFunction$2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(interfaceC4014c, context);
                p.g(interfaceC4014c, "null cannot be cast to non-null type kotlin.coroutines.Continuation<kotlin.Any?>");
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public Object invokeSuspend(Object result) throws Throwable {
                C4849c.b(result);
                return result;
            }
        };
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static <T> InterfaceC4014c<T> d(InterfaceC4014c<? super T> interfaceC4014c) {
        InterfaceC4014c<T> interfaceC4014c2;
        p.i(interfaceC4014c, "<this>");
        ContinuationImpl continuationImpl = interfaceC4014c instanceof ContinuationImpl ? (ContinuationImpl) interfaceC4014c : null;
        return (continuationImpl == null || (interfaceC4014c2 = (InterfaceC4014c<T>) continuationImpl.intercepted()) == null) ? interfaceC4014c : interfaceC4014c2;
    }

    public static <R, T> Object e(p9.p<? super R, ? super InterfaceC4014c<? super T>, ? extends Object> pVar, R r10, InterfaceC4014c<? super T> completion) {
        p.i(pVar, "<this>");
        p.i(completion, "completion");
        return ((p9.p) z.g(pVar, 2)).invoke(r10, c(f.a(completion)));
    }

    public static <R, P, T> Object f(q<? super R, ? super P, ? super InterfaceC4014c<? super T>, ? extends Object> qVar, R r10, P p10, InterfaceC4014c<? super T> completion) {
        p.i(qVar, "<this>");
        p.i(completion, "completion");
        return ((q) z.g(qVar, 3)).invoke(r10, p10, c(f.a(completion)));
    }
}
