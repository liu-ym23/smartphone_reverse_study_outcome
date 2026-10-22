package androidx.room;

import androidx.room.f;
import androidx.work.impl.WorkDatabase_Impl;
import com.stepos.core.common.util.TraceIdKeys;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.Executor;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineDispatcher;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.ExecutorsKt;
import kotlinx.coroutines.channels.Channel;
import kotlinx.coroutines.channels.ChannelIterator;
import kotlinx.coroutines.channels.ChannelKt;
import kotlinx.coroutines.flow.FlowCollector;
import kotlinx.coroutines.flow.FlowKt;
import q2.r;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
@rb.c(c = "androidx.room.CoroutinesRoom$Companion$createFlow$1", f = "CoroutinesRoom.kt", l = {111}, m = "invokeSuspend")
/* loaded from: classes.dex */
final class CoroutinesRoom$Companion$createFlow$1 extends SuspendLambda implements zb.p<FlowCollector<Object>, qb.b<? super lb.n>, Object> {

    /* renamed from: a, reason: collision with root package name */
    public int f2469a;

    /* renamed from: b, reason: collision with root package name */
    public /* synthetic */ Object f2470b;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ WorkDatabase_Impl f2471c;

    /* renamed from: d, reason: collision with root package name */
    public final /* synthetic */ String[] f2472d;

    /* renamed from: e, reason: collision with root package name */
    public final /* synthetic */ r.a f2473e;

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    @rb.c(c = "androidx.room.CoroutinesRoom$Companion$createFlow$1$1", f = "CoroutinesRoom.kt", l = {137}, m = "invokeSuspend")
    /* renamed from: androidx.room.CoroutinesRoom$Companion$createFlow$1$1, reason: invalid class name */
    public static final class AnonymousClass1 extends SuspendLambda implements zb.p<CoroutineScope, qb.b<? super lb.n>, Object> {

        /* renamed from: a, reason: collision with root package name */
        public int f2474a;

        /* renamed from: b, reason: collision with root package name */
        public /* synthetic */ Object f2475b;

        /* renamed from: c, reason: collision with root package name */
        public final /* synthetic */ WorkDatabase_Impl f2476c;

        /* renamed from: d, reason: collision with root package name */
        public final /* synthetic */ FlowCollector<Object> f2477d;

        /* renamed from: e, reason: collision with root package name */
        public final /* synthetic */ String[] f2478e;
        public final /* synthetic */ r.a h;

        /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
        @rb.c(c = "androidx.room.CoroutinesRoom$Companion$createFlow$1$1$1", f = "CoroutinesRoom.kt", l = {TraceIdKeys.MAX_LENGTH, 130}, m = "invokeSuspend")
        /* renamed from: androidx.room.CoroutinesRoom$Companion$createFlow$1$1$1, reason: invalid class name and collision with other inner class name */
        public static final class C00201 extends SuspendLambda implements zb.p<CoroutineScope, qb.b<? super lb.n>, Object> {

            /* renamed from: a, reason: collision with root package name */
            public ChannelIterator f2479a;

            /* renamed from: b, reason: collision with root package name */
            public int f2480b;

            /* renamed from: c, reason: collision with root package name */
            public final /* synthetic */ WorkDatabase_Impl f2481c;

            /* renamed from: d, reason: collision with root package name */
            public final /* synthetic */ a f2482d;

            /* renamed from: e, reason: collision with root package name */
            public final /* synthetic */ Channel<lb.n> f2483e;
            public final /* synthetic */ r.a h;

            /* renamed from: j, reason: collision with root package name */
            public final /* synthetic */ Channel<Object> f2484j;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public C00201(WorkDatabase_Impl workDatabase_Impl, a aVar, Channel channel, r.a aVar2, Channel channel2, qb.b bVar) {
                super(2, bVar);
                this.f2481c = workDatabase_Impl;
                this.f2482d = aVar;
                this.f2483e = channel;
                this.h = aVar2;
                this.f2484j = channel2;
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final qb.b<lb.n> create(Object obj, qb.b<?> bVar) {
                return new C00201(this.f2481c, this.f2482d, this.f2483e, this.h, this.f2484j, bVar);
            }

            @Override // zb.p
            public final Object invoke(CoroutineScope coroutineScope, qb.b<? super lb.n> bVar) {
                return ((C00201) create(coroutineScope, bVar)).invokeSuspend(lb.n.f10413a);
            }

            /* JADX WARN: Removed duplicated region for block: B:69:0x015a A[Catch: all -> 0x001c, TRY_LEAVE, TryCatch #2 {all -> 0x001c, blocks: (B:7:0x0016, B:64:0x0147, B:67:0x0152, B:69:0x015a, B:14:0x0029, B:63:0x0141), top: B:83:0x000e }] */
            /* JADX WARN: Removed duplicated region for block: B:72:0x0171  */
            /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:70:0x016e -> B:64:0x0147). Please report as a decompilation issue!!! */
            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            /*
                Code decompiled incorrectly, please refer to instructions dump.
                To view partially-correct add '--show-bad-code' argument
            */
            public final java.lang.Object invokeSuspend(java.lang.Object r19) {
                /*
                    Method dump skipped, instructions count: 382
                    To view this dump add '--comments-level debug' option
                */
                throw new UnsupportedOperationException("Method not decompiled: androidx.room.CoroutinesRoom$Companion$createFlow$1.AnonymousClass1.C00201.invokeSuspend(java.lang.Object):java.lang.Object");
            }
        }

        /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
        /* renamed from: androidx.room.CoroutinesRoom$Companion$createFlow$1$1$a */
        public static final class a extends f.c {

            /* renamed from: b, reason: collision with root package name */
            public final /* synthetic */ Channel<lb.n> f2485b;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public a(String[] strArr, Channel<lb.n> channel) {
                super(strArr);
                this.f2485b = channel;
            }

            @Override // androidx.room.f.c
            public final void a(Set<String> set) {
                this.f2485b.mo149trySendJP2dKIU(lb.n.f10413a);
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass1(WorkDatabase_Impl workDatabase_Impl, FlowCollector flowCollector, String[] strArr, r.a aVar, qb.b bVar) {
            super(2, bVar);
            this.f2476c = workDatabase_Impl;
            this.f2477d = flowCollector;
            this.f2478e = strArr;
            this.h = aVar;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final qb.b<lb.n> create(Object obj, qb.b<?> bVar) {
            AnonymousClass1 anonymousClass1 = new AnonymousClass1(this.f2476c, this.f2477d, this.f2478e, this.h, bVar);
            anonymousClass1.f2475b = obj;
            return anonymousClass1;
        }

        @Override // zb.p
        public final Object invoke(CoroutineScope coroutineScope, qb.b<? super lb.n> bVar) {
            return ((AnonymousClass1) create(coroutineScope, bVar)).invokeSuspend(lb.n.f10413a);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            CoroutineSingletons coroutineSingletons = CoroutineSingletons.f10059a;
            int i10 = this.f2474a;
            if (i10 == 0) {
                kotlin.c.b(obj);
                CoroutineScope coroutineScope = (CoroutineScope) this.f2475b;
                Channel channelChannel$default = ChannelKt.Channel$default(-1, null, null, 6, null);
                a aVar = new a(this.f2478e, channelChannel$default);
                channelChannel$default.mo149trySendJP2dKIU(lb.n.f10413a);
                WorkDatabase_Impl workDatabase_Impl = this.f2476c;
                Map<String, Object> map = workDatabase_Impl.f2499j;
                Object objFrom = map.get("QueryDispatcher");
                if (objFrom == null) {
                    Executor executor = workDatabase_Impl.f2492b;
                    if (executor == null) {
                        kotlin.jvm.internal.g.l("internalQueryExecutor");
                        throw null;
                    }
                    objFrom = ExecutorsKt.from(executor);
                    map.put("QueryDispatcher", objFrom);
                }
                kotlin.jvm.internal.g.d(objFrom, "null cannot be cast to non-null type kotlinx.coroutines.CoroutineDispatcher");
                Channel channelChannel$default2 = ChannelKt.Channel$default(0, null, null, 7, null);
                BuildersKt__Builders_commonKt.launch$default(coroutineScope, (CoroutineDispatcher) objFrom, null, new C00201(workDatabase_Impl, aVar, channelChannel$default, this.h, channelChannel$default2, null), 2, null);
                this.f2474a = 1;
                if (FlowKt.emitAll(this.f2477d, channelChannel$default2, this) == coroutineSingletons) {
                    return coroutineSingletons;
                }
            } else {
                if (i10 != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                kotlin.c.b(obj);
            }
            return lb.n.f10413a;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public CoroutinesRoom$Companion$createFlow$1(WorkDatabase_Impl workDatabase_Impl, String[] strArr, r.a aVar, qb.b bVar) {
        super(2, bVar);
        this.f2471c = workDatabase_Impl;
        this.f2472d = strArr;
        this.f2473e = aVar;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final qb.b<lb.n> create(Object obj, qb.b<?> bVar) {
        CoroutinesRoom$Companion$createFlow$1 coroutinesRoom$Companion$createFlow$1 = new CoroutinesRoom$Companion$createFlow$1(this.f2471c, this.f2472d, this.f2473e, bVar);
        coroutinesRoom$Companion$createFlow$1.f2470b = obj;
        return coroutinesRoom$Companion$createFlow$1;
    }

    @Override // zb.p
    public final Object invoke(FlowCollector<Object> flowCollector, qb.b<? super lb.n> bVar) {
        return ((CoroutinesRoom$Companion$createFlow$1) create(flowCollector, bVar)).invokeSuspend(lb.n.f10413a);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        CoroutineSingletons coroutineSingletons = CoroutineSingletons.f10059a;
        int i10 = this.f2469a;
        if (i10 == 0) {
            kotlin.c.b(obj);
            AnonymousClass1 anonymousClass1 = new AnonymousClass1(this.f2471c, (FlowCollector) this.f2470b, this.f2472d, this.f2473e, null);
            this.f2469a = 1;
            if (CoroutineScopeKt.coroutineScope(anonymousClass1, this) == coroutineSingletons) {
                return coroutineSingletons;
            }
        } else {
            if (i10 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            kotlin.c.b(obj);
        }
        return lb.n.f10413a;
    }
}
