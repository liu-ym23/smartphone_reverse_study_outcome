package androidx.room.coroutines;

import C7.r;
import H7.d;
import H7.e;
import H7.f;
import J7.c;
import S7.n;
import androidx.exifinterface.media.ExifInterface;
import kotlin.Metadata;
import kotlin.b;
import kotlin.coroutines.EmptyCoroutineContext;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.internal.k;
import kotlinx.coroutines.CoroutineStart;
import m9.AbstractC1683A;
import m9.C1704W;
import m9.C1724q;
import m9.InterfaceC1723p;
import m9.InterfaceC1733z;

@Metadata(d1 = {"\u0000\u0016\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0004\u001a9\u0010\u0006\u001a\u00028\u0000\"\u0004\b\u0000\u0010\u00002\"\u0010\u0005\u001a\u001e\b\u0001\u0012\u0004\u0012\u00020\u0002\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u00040\u0001H\u0000¢\u0006\u0004\b\u0006\u0010\u0007¨\u0006\b"}, d2 = {ExifInterface.GPS_DIRECTION_TRUE, "Lkotlin/Function2;", "Lm9/z;", "LH7/c;", "", "block", "runBlockingUninterruptible", "(LS7/n;)Ljava/lang/Object;", "room-runtime"}, k = 2, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class RunBlockingUninterruptible_androidKt {

    @c(c = "androidx.room.coroutines.RunBlockingUninterruptible_androidKt$runBlockingUninterruptible$1", f = "RunBlockingUninterruptible.android.kt", l = {}, m = "invokeSuspend")
    @Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0002\u001a\u00028\u0000\"\u0004\b\u0000\u0010\u0000*\u00020\u0001H\n"}, d2 = {ExifInterface.GPS_DIRECTION_TRUE, "Lm9/z;", "<anonymous>"}, k = 3, mv = {2, 1, 0})
    /* renamed from: androidx.room.coroutines.RunBlockingUninterruptible_androidKt$runBlockingUninterruptible$1, reason: invalid class name */
    public static final class AnonymousClass1 extends SuspendLambda implements n {
        final /* synthetic */ n $block;
        private /* synthetic */ Object L$0;
        int label;

        @c(c = "androidx.room.coroutines.RunBlockingUninterruptible_androidKt$runBlockingUninterruptible$1$1", f = "RunBlockingUninterruptible.android.kt", l = {52}, m = "invokeSuspend")
        @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lm9/z;", "LC7/r;", "<anonymous>", "(Lm9/z;)V"}, k = 3, mv = {2, 1, 0})
        /* renamed from: androidx.room.coroutines.RunBlockingUninterruptible_androidKt$runBlockingUninterruptible$1$1, reason: invalid class name and collision with other inner class name */
        public static final class C01311 extends SuspendLambda implements n {
            final /* synthetic */ n $block;
            final /* synthetic */ InterfaceC1723p $deferred;
            private /* synthetic */ Object L$0;
            int label;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public C01311(InterfaceC1723p interfaceC1723p, n nVar, H7.c<? super C01311> cVar) {
                super(2, cVar);
                this.$deferred = interfaceC1723p;
                this.$block = nVar;
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final H7.c<r> create(Object obj, H7.c<?> cVar) {
                C01311 c01311 = new C01311(this.$deferred, this.$block, cVar);
                c01311.L$0 = obj;
                return c01311;
            }

            /* JADX WARN: Removed duplicated region for block: B:22:0x0041  */
            /* JADX WARN: Removed duplicated region for block: B:23:0x0045  */
            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            /*
                Code decompiled incorrectly, please refer to instructions dump.
                To view partially-correct add '--show-bad-code' argument
            */
            public final java.lang.Object invokeSuspend(java.lang.Object r5) {
                /*
                    r4 = this;
                    kotlin.coroutines.intrinsics.CoroutineSingletons r0 = kotlin.coroutines.intrinsics.CoroutineSingletons.f4909a
                    int r1 = r4.label
                    r2 = 1
                    if (r1 == 0) goto L1b
                    if (r1 != r2) goto L13
                    java.lang.Object r4 = r4.L$0
                    m9.p r4 = (m9.InterfaceC1723p) r4
                    kotlin.b.b(r5)     // Catch: java.lang.Throwable -> L11
                    goto L39
                L11:
                    r5 = move-exception
                    goto L35
                L13:
                    java.lang.IllegalStateException r4 = new java.lang.IllegalStateException
                    java.lang.String r5 = "call to 'resume' before 'invoke' with coroutine"
                    r4.<init>(r5)
                    throw r4
                L1b:
                    kotlin.b.b(r5)
                    java.lang.Object r5 = r4.L$0
                    m9.z r5 = (m9.InterfaceC1733z) r5
                    m9.p r1 = r4.$deferred
                    S7.n r3 = r4.$block
                    r4.L$0 = r1     // Catch: java.lang.Throwable -> L33
                    r4.label = r2     // Catch: java.lang.Throwable -> L33
                    java.lang.Object r5 = r3.invoke(r5, r4)     // Catch: java.lang.Throwable -> L33
                    if (r5 != r0) goto L31
                    return r0
                L31:
                    r4 = r1
                    goto L39
                L33:
                    r5 = move-exception
                    r4 = r1
                L35:
                    kotlin.Result$Failure r5 = kotlin.b.a(r5)
                L39:
                    java.lang.Throwable r0 = kotlin.Result.a(r5)
                    m9.q r4 = (m9.C1724q) r4
                    if (r0 != 0) goto L45
                    r4.U(r5)
                    goto L48
                L45:
                    r4.g0(r0)
                L48:
                    C7.r r4 = C7.r.f317a
                    return r4
                */
                throw new UnsupportedOperationException("Method not decompiled: androidx.room.coroutines.RunBlockingUninterruptible_androidKt.AnonymousClass1.C01311.invokeSuspend(java.lang.Object):java.lang.Object");
            }

            @Override // S7.n
            public final Object invoke(InterfaceC1733z interfaceC1733z, H7.c<? super r> cVar) {
                return ((C01311) create(interfaceC1733z, cVar)).invokeSuspend(r.f317a);
            }
        }

        @c(c = "androidx.room.coroutines.RunBlockingUninterruptible_androidKt$runBlockingUninterruptible$1$2", f = "RunBlockingUninterruptible.android.kt", l = {58}, m = "invokeSuspend")
        @Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0002\u001a\u00028\u0000\"\u0004\b\u0000\u0010\u0000*\u00020\u0001H\n"}, d2 = {ExifInterface.GPS_DIRECTION_TRUE, "Lm9/z;", "<anonymous>"}, k = 3, mv = {2, 1, 0})
        /* renamed from: androidx.room.coroutines.RunBlockingUninterruptible_androidKt$runBlockingUninterruptible$1$2, reason: invalid class name */
        public static final class AnonymousClass2 extends SuspendLambda implements n {
            final /* synthetic */ InterfaceC1723p $deferred;
            int label;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public AnonymousClass2(InterfaceC1723p interfaceC1723p, H7.c<? super AnonymousClass2> cVar) {
                super(2, cVar);
                this.$deferred = interfaceC1723p;
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final H7.c<r> create(Object obj, H7.c<?> cVar) {
                return new AnonymousClass2(this.$deferred, cVar);
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Object invokeSuspend(Object obj) {
                CoroutineSingletons coroutineSingletons = CoroutineSingletons.f4909a;
                int i = this.label;
                if (i != 0) {
                    if (i != 1) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    b.b(obj);
                    return obj;
                }
                b.b(obj);
                InterfaceC1723p interfaceC1723p = this.$deferred;
                this.label = 1;
                Object objZ = ((C1724q) interfaceC1723p).z(this);
                return objZ == coroutineSingletons ? coroutineSingletons : objZ;
            }

            @Override // S7.n
            public final Object invoke(InterfaceC1733z interfaceC1733z, H7.c<? super T> cVar) {
                return ((AnonymousClass2) create(interfaceC1733z, cVar)).invokeSuspend(r.f317a);
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass1(n nVar, H7.c<? super AnonymousClass1> cVar) {
            super(2, cVar);
            this.$block = nVar;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final H7.c<r> create(Object obj, H7.c<?> cVar) {
            AnonymousClass1 anonymousClass1 = new AnonymousClass1(this.$block, cVar);
            anonymousClass1.L$0 = obj;
            return anonymousClass1;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            CoroutineSingletons coroutineSingletons = CoroutineSingletons.f4909a;
            if (this.label != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            b.b(obj);
            f fVar = ((InterfaceC1733z) this.L$0).getCoroutineContext().get(d.f758a);
            k.c(fVar);
            e eVar = (e) fVar;
            C1724q c1724q = new C1724q();
            AbstractC1683A.m(C1704W.f5321a, eVar, CoroutineStart.d, new C01311(c1724q, this.$block, null));
            while (!c1724q.r()) {
                try {
                    return AbstractC1683A.r(eVar, new AnonymousClass2(c1724q, null));
                } catch (InterruptedException unused) {
                }
            }
            return c1724q.J();
        }

        @Override // S7.n
        public final Object invoke(InterfaceC1733z interfaceC1733z, H7.c<? super T> cVar) {
            return ((AnonymousClass1) create(interfaceC1733z, cVar)).invokeSuspend(r.f317a);
        }
    }

    public static final <T> T runBlockingUninterruptible(n block) {
        k.f(block, "block");
        Thread.interrupted();
        return (T) AbstractC1683A.r(EmptyCoroutineContext.f4908a, new AnonymousClass1(block, null));
    }
}
