package androidx.datastore.core;

import C7.r;
import J7.c;
import S7.n;
import androidx.datastore.core.SingleProcessDataStore;
import androidx.exifinterface.media.ExifInterface;
import kotlin.Metadata;
import kotlin.b;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlinx.coroutines.flow.i;
import p9.d;
import p9.g;
import p9.v;

@c(c = "androidx.datastore.core.SingleProcessDataStore$data$1", f = "SingleProcessDataStore.kt", l = {117}, m = "invokeSuspend")
@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0003\u001a\u00020\u0002\"\u0004\b\u0000\u0010\u0000*\b\u0012\u0004\u0012\u00028\u00000\u0001H\u008a@¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {ExifInterface.GPS_DIRECTION_TRUE, "Lp9/d;", "LC7/r;", "<anonymous>", "(Lp9/d;)V"}, k = 3, mv = {1, 5, 1})
/* loaded from: classes2.dex */
public final class SingleProcessDataStore$data$1 extends SuspendLambda implements n {
    private /* synthetic */ Object L$0;
    int label;
    final /* synthetic */ SingleProcessDataStore<T> this$0;

    @c(c = "androidx.datastore.core.SingleProcessDataStore$data$1$1", f = "SingleProcessDataStore.kt", l = {}, m = "invokeSuspend")
    @Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u00022\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0004H\u008a@"}, d2 = {"<anonymous>", "", ExifInterface.GPS_DIRECTION_TRUE, "it", "Landroidx/datastore/core/State;"}, k = 3, mv = {1, 5, 1}, xi = 48)
    /* renamed from: androidx.datastore.core.SingleProcessDataStore$data$1$1, reason: invalid class name */
    public static final class AnonymousClass1 extends SuspendLambda implements n {
        final /* synthetic */ State<T> $currentDownStreamFlowState;
        /* synthetic */ Object L$0;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass1(State<T> state, H7.c<? super AnonymousClass1> cVar) {
            super(2, cVar);
            this.$currentDownStreamFlowState = state;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final H7.c<r> create(Object obj, H7.c<?> cVar) {
            AnonymousClass1 anonymousClass1 = new AnonymousClass1(this.$currentDownStreamFlowState, cVar);
            anonymousClass1.L$0 = obj;
            return anonymousClass1;
        }

        @Override // S7.n
        public final Object invoke(State<T> state, H7.c<? super Boolean> cVar) {
            return ((AnonymousClass1) create(state, cVar)).invokeSuspend(r.f317a);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            CoroutineSingletons coroutineSingletons = CoroutineSingletons.f4909a;
            if (this.label != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            b.b(obj);
            State state = (State) this.L$0;
            State state2 = this.$currentDownStreamFlowState;
            boolean z10 = false;
            if (!(state2 instanceof Data) && !(state2 instanceof Final) && state == state2) {
                z10 = true;
            }
            return Boolean.valueOf(z10);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SingleProcessDataStore$data$1(SingleProcessDataStore<T> singleProcessDataStore, H7.c<? super SingleProcessDataStore$data$1> cVar) {
        super(2, cVar);
        this.this$0 = singleProcessDataStore;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final H7.c<r> create(Object obj, H7.c<?> cVar) {
        SingleProcessDataStore$data$1 singleProcessDataStore$data$1 = new SingleProcessDataStore$data$1(this.this$0, cVar);
        singleProcessDataStore$data$1.L$0 = obj;
        return singleProcessDataStore$data$1;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) throws Throwable {
        CoroutineSingletons coroutineSingletons = CoroutineSingletons.f4909a;
        int i = this.label;
        r rVar = r.f317a;
        if (i != 0) {
            if (i != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            b.b(obj);
            return rVar;
        }
        b.b(obj);
        d dVar = (d) this.L$0;
        State state = (State) ((i) ((SingleProcessDataStore) this.this$0).downstreamFlow).getValue();
        if (!(state instanceof Data)) {
            ((SingleProcessDataStore) this.this$0).actor.offer(new SingleProcessDataStore.Message.Read(state));
        }
        final g gVar = new g((p9.c) ((SingleProcessDataStore) this.this$0).downstreamFlow, (n) new AnonymousClass1(state, null));
        p9.c cVar = new p9.c() { // from class: androidx.datastore.core.SingleProcessDataStore$data$1$invokeSuspend$$inlined$map$1

            @Metadata(d1 = {"\u0000\u0013\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00028\u00000\u0001J\u001b\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0002\u001a\u00028\u0000H\u0096@ø\u0001\u0000¢\u0006\u0004\b\u0004\u0010\u0005\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006\u0006"}, d2 = {"kotlinx/coroutines/flow/FlowKt__CollectKt$collect$3", "Lp9/d;", "value", "LC7/r;", "emit", "(Ljava/lang/Object;LH7/c;)Ljava/lang/Object;", "kotlinx-coroutines-core"}, k = 1, mv = {1, 5, 1}, xi = 48)
            /* renamed from: androidx.datastore.core.SingleProcessDataStore$data$1$invokeSuspend$$inlined$map$1$2, reason: invalid class name */
            public static final class AnonymousClass2 implements d {
                final /* synthetic */ d $this_unsafeFlow$inlined;

                @c(c = "androidx.datastore.core.SingleProcessDataStore$data$1$invokeSuspend$$inlined$map$1$2", f = "SingleProcessDataStore.kt", l = {137}, m = "emit")
                @Metadata(k = 3, mv = {1, 5, 1}, xi = 48)
                /* renamed from: androidx.datastore.core.SingleProcessDataStore$data$1$invokeSuspend$$inlined$map$1$2$1, reason: invalid class name */
                public static final class AnonymousClass1 extends ContinuationImpl {
                    Object L$0;
                    int label;
                    /* synthetic */ Object result;

                    public AnonymousClass1(H7.c cVar) {
                        super(cVar);
                    }

                    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                    public final Object invokeSuspend(Object obj) {
                        this.result = obj;
                        this.label |= Integer.MIN_VALUE;
                        return AnonymousClass2.this.emit(null, this);
                    }
                }

                public AnonymousClass2(d dVar) {
                    this.$this_unsafeFlow$inlined = dVar;
                }

                /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
                @Override // p9.d
                /*
                    Code decompiled incorrectly, please refer to instructions dump.
                    To view partially-correct add '--show-bad-code' argument
                */
                public java.lang.Object emit(java.lang.Object r5, H7.c r6) throws java.lang.Throwable {
                    /*
                        r4 = this;
                        boolean r0 = r6 instanceof androidx.datastore.core.SingleProcessDataStore$data$1$invokeSuspend$$inlined$map$1.AnonymousClass2.AnonymousClass1
                        if (r0 == 0) goto L13
                        r0 = r6
                        androidx.datastore.core.SingleProcessDataStore$data$1$invokeSuspend$$inlined$map$1$2$1 r0 = (androidx.datastore.core.SingleProcessDataStore$data$1$invokeSuspend$$inlined$map$1.AnonymousClass2.AnonymousClass1) r0
                        int r1 = r0.label
                        r2 = -2147483648(0xffffffff80000000, float:-0.0)
                        r3 = r1 & r2
                        if (r3 == 0) goto L13
                        int r1 = r1 - r2
                        r0.label = r1
                        goto L18
                    L13:
                        androidx.datastore.core.SingleProcessDataStore$data$1$invokeSuspend$$inlined$map$1$2$1 r0 = new androidx.datastore.core.SingleProcessDataStore$data$1$invokeSuspend$$inlined$map$1$2$1
                        r0.<init>(r6)
                    L18:
                        java.lang.Object r6 = r0.result
                        kotlin.coroutines.intrinsics.CoroutineSingletons r1 = kotlin.coroutines.intrinsics.CoroutineSingletons.f4909a
                        int r2 = r0.label
                        r3 = 1
                        if (r2 == 0) goto L2f
                        if (r2 != r3) goto L27
                        kotlin.b.b(r6)
                        goto L51
                    L27:
                        java.lang.IllegalStateException r4 = new java.lang.IllegalStateException
                        java.lang.String r5 = "call to 'resume' before 'invoke' with coroutine"
                        r4.<init>(r5)
                        throw r4
                    L2f:
                        kotlin.b.b(r6)
                        p9.d r4 = r4.$this_unsafeFlow$inlined
                        androidx.datastore.core.State r5 = (androidx.datastore.core.State) r5
                        boolean r6 = r5 instanceof androidx.datastore.core.ReadException
                        if (r6 != 0) goto L6d
                        boolean r6 = r5 instanceof androidx.datastore.core.Final
                        if (r6 != 0) goto L66
                        boolean r6 = r5 instanceof androidx.datastore.core.Data
                        if (r6 == 0) goto L54
                        androidx.datastore.core.Data r5 = (androidx.datastore.core.Data) r5
                        java.lang.Object r5 = r5.getValue()
                        r0.label = r3
                        java.lang.Object r4 = r4.emit(r5, r0)
                        if (r4 != r1) goto L51
                        return r1
                    L51:
                        C7.r r4 = C7.r.f317a
                        return r4
                    L54:
                        boolean r4 = r5 instanceof androidx.datastore.core.UnInitialized
                        if (r4 == 0) goto L60
                        java.lang.IllegalStateException r4 = new java.lang.IllegalStateException
                        java.lang.String r5 = "This is a bug in DataStore. Please file a bug at: https://issuetracker.google.com/issues/new?component=907884&template=1466542"
                        r4.<init>(r5)
                        throw r4
                    L60:
                        kotlin.NoWhenBranchMatchedException r4 = new kotlin.NoWhenBranchMatchedException
                        r4.<init>()
                        throw r4
                    L66:
                        androidx.datastore.core.Final r5 = (androidx.datastore.core.Final) r5
                        java.lang.Throwable r4 = r5.getFinalException()
                        throw r4
                    L6d:
                        androidx.datastore.core.ReadException r5 = (androidx.datastore.core.ReadException) r5
                        java.lang.Throwable r4 = r5.getReadException()
                        throw r4
                    */
                    throw new UnsupportedOperationException("Method not decompiled: androidx.datastore.core.SingleProcessDataStore$data$1$invokeSuspend$$inlined$map$1.AnonymousClass2.emit(java.lang.Object, H7.c):java.lang.Object");
                }
            }

            @Override // p9.c
            public Object collect(d dVar2, H7.c cVar2) {
                Object objCollect = gVar.collect(new AnonymousClass2(dVar2), cVar2);
                return objCollect == CoroutineSingletons.f4909a ? objCollect : r.f317a;
            }
        };
        this.label = 1;
        if (dVar instanceof v) {
            throw ((v) dVar).f5569a;
        }
        Object objCollect = cVar.collect(dVar, this);
        if (objCollect != coroutineSingletons) {
            objCollect = rVar;
        }
        return objCollect == coroutineSingletons ? coroutineSingletons : rVar;
    }

    @Override // S7.n
    public final Object invoke(d dVar, H7.c<? super r> cVar) {
        return ((SingleProcessDataStore$data$1) create(dVar, cVar)).invokeSuspend(r.f317a);
    }
}
