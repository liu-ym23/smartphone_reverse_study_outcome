package androidx.datastore.core;

import J0.b;
import J0.f;
import J0.j;
import Xa.c;
import Xa.d;
import Y8.t;
import androidx.datastore.core.SingleProcessDataStore;
import androidx.exifinterface.media.ExifInterface;
import com.stepos.statsapp.v3.lib.plugin.constants.UxipConstants;
import e9.InterfaceC4014c;
import f9.C4063a;
import g9.C4109a;
import g9.InterfaceC4112d;
import kotlin.C4849c;
import kotlin.Metadata;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import p9.p;

/* JADX INFO: Add missing generic type declarations: [T] */
@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0003\u001a\u00020\u0002\"\u0004\b\u0000\u0010\u0000*\b\u0012\u0004\u0012\u00028\u00000\u0001H\u008a@¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {ExifInterface.GPS_DIRECTION_TRUE, "LXa/c;", "LY8/t;", "<anonymous>", "(LXa/c;)V"}, k = 3, mv = {1, 5, 1})
@InterfaceC4112d(c = "androidx.datastore.core.SingleProcessDataStore$data$1", f = "SingleProcessDataStore.kt", l = {117}, m = "invokeSuspend")
/* loaded from: classes.dex */
public final class SingleProcessDataStore$data$1<T> extends SuspendLambda implements p<c<? super T>, InterfaceC4014c<? super t>, Object> {

    /* renamed from: a, reason: collision with root package name */
    public int f13314a;

    /* renamed from: b, reason: collision with root package name */
    public /* synthetic */ Object f13315b;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ SingleProcessDataStore<T> f13316c;

    @Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\u0010\u0004\u001a\u00020\u0003\"\u0004\b\u0000\u0010\u00002\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00028\u00000\u0001H\u008a@¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {ExifInterface.GPS_DIRECTION_TRUE, "LJ0/j;", "it", "", "<anonymous>", "(LJ0/j;)Z"}, k = 3, mv = {1, 5, 1})
    @InterfaceC4112d(c = "androidx.datastore.core.SingleProcessDataStore$data$1$1", f = "SingleProcessDataStore.kt", l = {}, m = "invokeSuspend")
    /* renamed from: androidx.datastore.core.SingleProcessDataStore$data$1$1, reason: invalid class name */
    public static final class AnonymousClass1 extends SuspendLambda implements p<j<T>, InterfaceC4014c<? super Boolean>, Object> {

        /* renamed from: a, reason: collision with root package name */
        public int f13317a;

        /* renamed from: b, reason: collision with root package name */
        public /* synthetic */ Object f13318b;

        /* renamed from: c, reason: collision with root package name */
        public final /* synthetic */ j<T> f13319c;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass1(j<T> jVar, InterfaceC4014c<? super AnonymousClass1> interfaceC4014c) {
            super(2, interfaceC4014c);
            this.f13319c = jVar;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final InterfaceC4014c<t> create(Object obj, InterfaceC4014c<?> interfaceC4014c) {
            AnonymousClass1 anonymousClass1 = new AnonymousClass1(this.f13319c, interfaceC4014c);
            anonymousClass1.f13318b = obj;
            return anonymousClass1;
        }

        @Override // p9.p
        /* renamed from: f, reason: merged with bridge method [inline-methods] */
        public final Object invoke(j<T> jVar, InterfaceC4014c<? super Boolean> interfaceC4014c) {
            return ((AnonymousClass1) create(jVar, interfaceC4014c)).invokeSuspend(t.f7040a);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) throws Throwable {
            C4063a.g();
            if (this.f13317a != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            C4849c.b(obj);
            j<T> jVar = (j) this.f13318b;
            j<T> jVar2 = this.f13319c;
            boolean z10 = false;
            if (!(jVar2 instanceof b) && !(jVar2 instanceof f) && jVar == jVar2) {
                z10 = true;
            }
            return C4109a.a(z10);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SingleProcessDataStore$data$1(SingleProcessDataStore<T> singleProcessDataStore, InterfaceC4014c<? super SingleProcessDataStore$data$1> interfaceC4014c) {
        super(2, interfaceC4014c);
        this.f13316c = singleProcessDataStore;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final InterfaceC4014c<t> create(Object obj, InterfaceC4014c<?> interfaceC4014c) {
        SingleProcessDataStore$data$1 singleProcessDataStore$data$1 = new SingleProcessDataStore$data$1(this.f13316c, interfaceC4014c);
        singleProcessDataStore$data$1.f13315b = obj;
        return singleProcessDataStore$data$1;
    }

    @Override // p9.p
    public final Object invoke(c<? super T> cVar, InterfaceC4014c<? super t> interfaceC4014c) {
        return ((SingleProcessDataStore$data$1) create(cVar, interfaceC4014c)).invokeSuspend(t.f7040a);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) throws Throwable {
        Object objG = C4063a.g();
        int i10 = this.f13314a;
        if (i10 == 0) {
            C4849c.b(obj);
            c cVar = (c) this.f13315b;
            j jVar = (j) this.f13316c.downstreamFlow.getValue();
            if (!(jVar instanceof b)) {
                this.f13316c.actor.e(new SingleProcessDataStore.b.a(jVar));
            }
            final Xa.b bVarT = d.t(this.f13316c.downstreamFlow, new AnonymousClass1(jVar, null));
            Xa.b<T> bVar = new Xa.b<T>() { // from class: androidx.datastore.core.SingleProcessDataStore$data$1$invokeSuspend$$inlined$map$1

                @Metadata(d1 = {"\u0000\u0013\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00028\u00000\u0001J\u001b\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0002\u001a\u00028\u0000H\u0096@ø\u0001\u0000¢\u0006\u0004\b\u0004\u0010\u0005\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006\u0006"}, d2 = {"kotlinx/coroutines/flow/FlowKt__CollectKt$collect$3", "LXa/c;", UxipConstants.f30680s, "LY8/t;", "emit", "(Ljava/lang/Object;Le9/c;)Ljava/lang/Object;", "kotlinx-coroutines-core"}, k = 1, mv = {1, 5, 1}, xi = 48)
                /* renamed from: androidx.datastore.core.SingleProcessDataStore$data$1$invokeSuspend$$inlined$map$1$2, reason: invalid class name */
                public static final class AnonymousClass2 implements c<j<T>> {

                    /* renamed from: a, reason: collision with root package name */
                    public final /* synthetic */ c f13299a;

                    @InterfaceC4112d(c = "androidx.datastore.core.SingleProcessDataStore$data$1$invokeSuspend$$inlined$map$1$2", f = "SingleProcessDataStore.kt", l = {137}, m = "emit")
                    @Metadata(k = 3, mv = {1, 5, 1}, xi = 48)
                    /* renamed from: androidx.datastore.core.SingleProcessDataStore$data$1$invokeSuspend$$inlined$map$1$2$1, reason: invalid class name */
                    public static final class AnonymousClass1 extends ContinuationImpl {

                        /* renamed from: a, reason: collision with root package name */
                        public /* synthetic */ Object f13300a;

                        /* renamed from: b, reason: collision with root package name */
                        public int f13301b;

                        public AnonymousClass1(InterfaceC4014c interfaceC4014c) {
                            super(interfaceC4014c);
                        }

                        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                        public final Object invokeSuspend(Object obj) {
                            this.f13300a = obj;
                            this.f13301b |= Integer.MIN_VALUE;
                            return AnonymousClass2.this.emit(null, this);
                        }
                    }

                    public AnonymousClass2(c cVar) {
                        this.f13299a = cVar;
                    }

                    /* JADX WARN: Multi-variable type inference failed */
                    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
                    @Override // Xa.c
                    /*
                        Code decompiled incorrectly, please refer to instructions dump.
                        To view partially-correct add '--show-bad-code' argument
                    */
                    public java.lang.Object emit(java.lang.Object r5, e9.InterfaceC4014c r6) throws java.lang.Throwable {
                        /*
                            r4 = this;
                            boolean r0 = r6 instanceof androidx.datastore.core.SingleProcessDataStore$data$1$invokeSuspend$$inlined$map$1.AnonymousClass2.AnonymousClass1
                            if (r0 == 0) goto L13
                            r0 = r6
                            androidx.datastore.core.SingleProcessDataStore$data$1$invokeSuspend$$inlined$map$1$2$1 r0 = (androidx.datastore.core.SingleProcessDataStore$data$1$invokeSuspend$$inlined$map$1.AnonymousClass2.AnonymousClass1) r0
                            int r1 = r0.f13301b
                            r2 = -2147483648(0xffffffff80000000, float:-0.0)
                            r3 = r1 & r2
                            if (r3 == 0) goto L13
                            int r1 = r1 - r2
                            r0.f13301b = r1
                            goto L18
                        L13:
                            androidx.datastore.core.SingleProcessDataStore$data$1$invokeSuspend$$inlined$map$1$2$1 r0 = new androidx.datastore.core.SingleProcessDataStore$data$1$invokeSuspend$$inlined$map$1$2$1
                            r0.<init>(r6)
                        L18:
                            java.lang.Object r6 = r0.f13300a
                            java.lang.Object r1 = f9.C4063a.g()
                            int r2 = r0.f13301b
                            r3 = 1
                            if (r2 == 0) goto L31
                            if (r2 != r3) goto L29
                            kotlin.C4849c.b(r6)
                            goto L53
                        L29:
                            java.lang.IllegalStateException r4 = new java.lang.IllegalStateException
                            java.lang.String r5 = "call to 'resume' before 'invoke' with coroutine"
                            r4.<init>(r5)
                            throw r4
                        L31:
                            kotlin.C4849c.b(r6)
                            Xa.c r4 = r4.f13299a
                            J0.j r5 = (J0.j) r5
                            boolean r6 = r5 instanceof J0.h
                            if (r6 != 0) goto L6f
                            boolean r6 = r5 instanceof J0.f
                            if (r6 != 0) goto L68
                            boolean r6 = r5 instanceof J0.b
                            if (r6 == 0) goto L56
                            J0.b r5 = (J0.b) r5
                            java.lang.Object r5 = r5.b()
                            r0.f13301b = r3
                            java.lang.Object r4 = r4.emit(r5, r0)
                            if (r4 != r1) goto L53
                            return r1
                        L53:
                            Y8.t r4 = Y8.t.f7040a
                            return r4
                        L56:
                            boolean r4 = r5 instanceof J0.k
                            if (r4 == 0) goto L62
                            java.lang.IllegalStateException r4 = new java.lang.IllegalStateException
                            java.lang.String r5 = "This is a bug in DataStore. Please file a bug at: https://issuetracker.google.com/issues/new?component=907884&template=1466542"
                            r4.<init>(r5)
                            throw r4
                        L62:
                            kotlin.NoWhenBranchMatchedException r4 = new kotlin.NoWhenBranchMatchedException
                            r4.<init>()
                            throw r4
                        L68:
                            J0.f r5 = (J0.f) r5
                            java.lang.Throwable r4 = r5.getFinalException()
                            throw r4
                        L6f:
                            J0.h r5 = (J0.h) r5
                            java.lang.Throwable r4 = r5.getReadException()
                            throw r4
                        */
                        throw new UnsupportedOperationException("Method not decompiled: androidx.datastore.core.SingleProcessDataStore$data$1$invokeSuspend$$inlined$map$1.AnonymousClass2.emit(java.lang.Object, e9.c):java.lang.Object");
                    }
                }

                @Override // Xa.b
                public Object collect(c cVar2, InterfaceC4014c interfaceC4014c) {
                    Object objCollect = bVarT.collect(new AnonymousClass2(cVar2), interfaceC4014c);
                    return objCollect == C4063a.g() ? objCollect : t.f7040a;
                }
            };
            this.f13314a = 1;
            if (d.v(cVar, bVar, this) == objG) {
                return objG;
            }
        } else {
            if (i10 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            C4849c.b(obj);
        }
        return t.f7040a;
    }
}
