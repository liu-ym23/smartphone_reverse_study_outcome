package kotlinx.coroutines.flow.internal;

import Ua.M;
import Xa.b;
import Xa.c;
import Y8.t;
import e9.InterfaceC4014c;
import f9.C4063a;
import g9.InterfaceC4112d;
import g9.h;
import kotlin.C4849c;
import kotlin.Metadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.internal.Ref$ObjectRef;
import kotlinx.coroutines.g;
import p9.p;
import p9.q;

@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"LUa/M;", "LY8/t;", "<anonymous>", "(LUa/M;)V"}, k = 3, mv = {2, 2, 0})
@InterfaceC4112d(c = "kotlinx.coroutines.flow.internal.ChannelFlowTransformLatest$flowCollect$3", f = "Merge.kt", l = {23}, m = "invokeSuspend", v = 1)
/* loaded from: classes5.dex */
public final class ChannelFlowTransformLatest$flowCollect$3 extends SuspendLambda implements p<M, InterfaceC4014c<? super t>, Object> {

    /* renamed from: a, reason: collision with root package name */
    public Object f36701a;

    /* renamed from: b, reason: collision with root package name */
    public int f36702b;

    /* renamed from: c, reason: collision with root package name */
    public /* synthetic */ Object f36703c;

    /* renamed from: d, reason: collision with root package name */
    public final /* synthetic */ ChannelFlowTransformLatest<T, R> f36704d;

    /* renamed from: e, reason: collision with root package name */
    public final /* synthetic */ c<R> f36705e;

    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    /* renamed from: kotlinx.coroutines.flow.internal.ChannelFlowTransformLatest$flowCollect$3$1, reason: invalid class name */
    public static final class AnonymousClass1<T> implements c {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Ref$ObjectRef<g> f36706a;

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ M f36707b;

        /* renamed from: c, reason: collision with root package name */
        public final /* synthetic */ ChannelFlowTransformLatest<T, R> f36708c;

        /* renamed from: d, reason: collision with root package name */
        public final /* synthetic */ c<R> f36709d;

        @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"LUa/M;", "LY8/t;", "<anonymous>", "(LUa/M;)V"}, k = 3, mv = {2, 2, 0})
        @InterfaceC4112d(c = "kotlinx.coroutines.flow.internal.ChannelFlowTransformLatest$flowCollect$3$1$2", f = "Merge.kt", l = {30}, m = "invokeSuspend", v = 1)
        /* renamed from: kotlinx.coroutines.flow.internal.ChannelFlowTransformLatest$flowCollect$3$1$2, reason: invalid class name */
        public static final class AnonymousClass2 extends SuspendLambda implements p<M, InterfaceC4014c<? super t>, Object> {

            /* renamed from: a, reason: collision with root package name */
            public int f36710a;

            /* renamed from: b, reason: collision with root package name */
            public final /* synthetic */ ChannelFlowTransformLatest<T, R> f36711b;

            /* renamed from: c, reason: collision with root package name */
            public final /* synthetic */ c<R> f36712c;

            /* renamed from: d, reason: collision with root package name */
            public final /* synthetic */ T f36713d;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            public AnonymousClass2(ChannelFlowTransformLatest<T, R> channelFlowTransformLatest, c<? super R> cVar, T t10, InterfaceC4014c<? super AnonymousClass2> interfaceC4014c) {
                super(2, interfaceC4014c);
                this.f36711b = channelFlowTransformLatest;
                this.f36712c = cVar;
                this.f36713d = t10;
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final InterfaceC4014c<t> create(Object obj, InterfaceC4014c<?> interfaceC4014c) {
                return new AnonymousClass2(this.f36711b, this.f36712c, this.f36713d, interfaceC4014c);
            }

            @Override // p9.p
            public final Object invoke(M m10, InterfaceC4014c<? super t> interfaceC4014c) {
                return ((AnonymousClass2) create(m10, interfaceC4014c)).invokeSuspend(t.f7040a);
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Object invokeSuspend(Object obj) throws Throwable {
                Object objG = C4063a.g();
                int i10 = this.f36710a;
                if (i10 == 0) {
                    C4849c.b(obj);
                    q qVar = this.f36711b.transform;
                    Object obj2 = this.f36712c;
                    T t10 = this.f36713d;
                    this.f36710a = 1;
                    if (qVar.invoke(obj2, t10, this) == objG) {
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

        /* JADX WARN: Multi-variable type inference failed */
        public AnonymousClass1(Ref$ObjectRef<g> ref$ObjectRef, M m10, ChannelFlowTransformLatest<T, R> channelFlowTransformLatest, c<? super R> cVar) {
            this.f36706a = ref$ObjectRef;
            this.f36707b = m10;
            this.f36708c = channelFlowTransformLatest;
            this.f36709d = cVar;
        }

        /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
        @Override // Xa.c
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public final java.lang.Object emit(T r7, e9.InterfaceC4014c<? super Y8.t> r8) throws java.lang.Throwable {
            /*
                r6 = this;
                boolean r0 = r8 instanceof kotlinx.coroutines.flow.internal.ChannelFlowTransformLatest$flowCollect$3$1$emit$1
                if (r0 == 0) goto L13
                r0 = r8
                kotlinx.coroutines.flow.internal.ChannelFlowTransformLatest$flowCollect$3$1$emit$1 r0 = (kotlinx.coroutines.flow.internal.ChannelFlowTransformLatest$flowCollect$3$1$emit$1) r0
                int r1 = r0.f36720g
                r2 = -2147483648(0xffffffff80000000, float:-0.0)
                r3 = r1 & r2
                if (r3 == 0) goto L13
                int r1 = r1 - r2
                r0.f36720g = r1
                goto L18
            L13:
                kotlinx.coroutines.flow.internal.ChannelFlowTransformLatest$flowCollect$3$1$emit$1 r0 = new kotlinx.coroutines.flow.internal.ChannelFlowTransformLatest$flowCollect$3$1$emit$1
                r0.<init>(r6, r8)
            L18:
                java.lang.Object r8 = r0.f36718e
                java.lang.Object r1 = f9.C4063a.g()
                int r2 = r0.f36720g
                r3 = 1
                if (r2 == 0) goto L3b
                if (r2 != r3) goto L33
                java.lang.Object r7 = r0.f36716c
                kotlinx.coroutines.g r7 = (kotlinx.coroutines.g) r7
                java.lang.Object r7 = r0.f36715b
                kotlinx.coroutines.g r7 = (kotlinx.coroutines.g) r7
                java.lang.Object r7 = r0.f36714a
                kotlin.C4849c.b(r8)
                goto L64
            L33:
                java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
                java.lang.String r7 = "call to 'resume' before 'invoke' with coroutine"
                r6.<init>(r7)
                throw r6
            L3b:
                kotlin.C4849c.b(r8)
                kotlin.jvm.internal.Ref$ObjectRef<kotlinx.coroutines.g> r8 = r6.f36706a
                T r8 = r8.f34820a
                kotlinx.coroutines.g r8 = (kotlinx.coroutines.g) r8
                if (r8 == 0) goto L64
                kotlinx.coroutines.flow.internal.ChildCancelledException r2 = new kotlinx.coroutines.flow.internal.ChildCancelledException
                r2.<init>()
                r8.i(r2)
                r0.f36714a = r7
                r0.f36715b = r8
                java.lang.Object r2 = g9.h.a(r8)
                r0.f36716c = r2
                r2 = 0
                r0.f36717d = r2
                r0.f36720g = r3
                java.lang.Object r8 = r8.T0(r0)
                if (r8 != r1) goto L64
                return r1
            L64:
                kotlin.jvm.internal.Ref$ObjectRef<kotlinx.coroutines.g> r8 = r6.f36706a
                Ua.M r0 = r6.f36707b
                kotlinx.coroutines.CoroutineStart r2 = kotlinx.coroutines.CoroutineStart.UNDISPATCHED
                kotlinx.coroutines.flow.internal.ChannelFlowTransformLatest$flowCollect$3$1$2 r3 = new kotlinx.coroutines.flow.internal.ChannelFlowTransformLatest$flowCollect$3$1$2
                kotlinx.coroutines.flow.internal.ChannelFlowTransformLatest<T, R> r1 = r6.f36708c
                Xa.c<R> r6 = r6.f36709d
                r4 = 0
                r3.<init>(r1, r6, r7, r4)
                r4 = 1
                r5 = 0
                r1 = 0
                kotlinx.coroutines.g r6 = Ua.C1056g.d(r0, r1, r2, r3, r4, r5)
                r8.f34820a = r6
                Y8.t r6 = Y8.t.f7040a
                return r6
            */
            throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.flow.internal.ChannelFlowTransformLatest$flowCollect$3.AnonymousClass1.emit(java.lang.Object, e9.c):java.lang.Object");
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public ChannelFlowTransformLatest$flowCollect$3(ChannelFlowTransformLatest<T, R> channelFlowTransformLatest, c<? super R> cVar, InterfaceC4014c<? super ChannelFlowTransformLatest$flowCollect$3> interfaceC4014c) {
        super(2, interfaceC4014c);
        this.f36704d = channelFlowTransformLatest;
        this.f36705e = cVar;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final InterfaceC4014c<t> create(Object obj, InterfaceC4014c<?> interfaceC4014c) {
        ChannelFlowTransformLatest$flowCollect$3 channelFlowTransformLatest$flowCollect$3 = new ChannelFlowTransformLatest$flowCollect$3(this.f36704d, this.f36705e, interfaceC4014c);
        channelFlowTransformLatest$flowCollect$3.f36703c = obj;
        return channelFlowTransformLatest$flowCollect$3;
    }

    @Override // p9.p
    public final Object invoke(M m10, InterfaceC4014c<? super t> interfaceC4014c) {
        return ((ChannelFlowTransformLatest$flowCollect$3) create(m10, interfaceC4014c)).invokeSuspend(t.f7040a);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) throws Throwable {
        M m10 = (M) this.f36703c;
        Object objG = C4063a.g();
        int i10 = this.f36702b;
        if (i10 == 0) {
            C4849c.b(obj);
            Ref$ObjectRef ref$ObjectRef = new Ref$ObjectRef();
            ChannelFlowTransformLatest<T, R> channelFlowTransformLatest = this.f36704d;
            b<S> bVar = channelFlowTransformLatest.flow;
            AnonymousClass1 anonymousClass1 = new AnonymousClass1(ref$ObjectRef, m10, channelFlowTransformLatest, this.f36705e);
            this.f36703c = h.a(m10);
            this.f36701a = h.a(ref$ObjectRef);
            this.f36702b = 1;
            if (bVar.collect(anonymousClass1, this) == objG) {
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
