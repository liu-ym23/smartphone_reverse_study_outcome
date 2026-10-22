package com.stepos.base.ability;

import android.content.Context;
import android.os.SystemClock;
import android.util.Log;
import b7.j;
import b7.k;
import b7.n;
import b7.p;
import b7.s;
import com.stepos.base.model.ModelReleaseReason;
import com.stepos.base.protocol.ProtocolType;
import com.stepos.base.strategy.OrchestrationRejectedException;
import com.stepos.core.common.telemetry.FailStage;
import com.stepos.core.model.manager.ModelCacheImpl;
import com.stepos.core.ota.OtaEngine;
import e7.f;
import h7.e;
import java.io.File;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CancellationException;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Result;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.internal.Ref$BooleanRef;
import kotlin.jvm.internal.Ref$ObjectRef;
import kotlin.jvm.internal.g;
import kotlin.jvm.internal.i;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowCollector;
import kotlinx.coroutines.flow.FlowKt;
import mb.m;
import org.json.JSONObject;
import qb.b;
import s6.b;
import v6.c;
import v6.d;
import zb.q;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public abstract class AbilityBase<AbilityInput extends c, AbilityOutput extends d> implements p6.d<AbilityInput, AbilityOutput> {
    public static final a Companion = new a();
    private static volatile a7.a logBridge;
    private final String TAG;
    private final p6.a abilityConfig;
    private final List<n> acquiredHandles;
    private Map<String, String> bundleProperties;

    /* renamed from: id, reason: collision with root package name */
    private final String f6122id;
    private Exception initError;
    private final lb.d modelCache$delegate;
    private final List<k> modelConfigs;
    private final List<p> modelProtocols;
    private final lb.d orchestrator$delegate;
    private final lb.d protocolManager$delegate;

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    public static final class a {
    }

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    @rb.c(c = "com.stepos.base.ability.AbilityBase$doCloudInfer$2", f = "AbilityBase.kt", l = {434, 434}, m = "invokeSuspend")
    /* renamed from: com.stepos.base.ability.AbilityBase$doCloudInfer$2, reason: invalid class name */
    public static final class AnonymousClass2 extends SuspendLambda implements zb.p<FlowCollector<? super Result<? extends AbilityOutput>>, b<? super lb.n>, Object> {

        /* renamed from: a, reason: collision with root package name */
        public int f6123a;

        /* renamed from: b, reason: collision with root package name */
        public /* synthetic */ Object f6124b;

        /* renamed from: c, reason: collision with root package name */
        public final /* synthetic */ AbilityBase<AbilityInput, AbilityOutput> f6125c;

        /* renamed from: d, reason: collision with root package name */
        public final /* synthetic */ AbilityInput f6126d;

        /* renamed from: e, reason: collision with root package name */
        public final /* synthetic */ Object f6127e;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass2(AbilityBase<AbilityInput, AbilityOutput> abilityBase, AbilityInput abilityinput, Object obj, b<? super AnonymousClass2> bVar) {
            super(2, bVar);
            this.f6125c = abilityBase;
            this.f6126d = abilityinput;
            this.f6127e = obj;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final b<lb.n> create(Object obj, b<?> bVar) {
            AnonymousClass2 anonymousClass2 = new AnonymousClass2(this.f6125c, this.f6126d, this.f6127e, bVar);
            anonymousClass2.f6124b = obj;
            return anonymousClass2;
        }

        @Override // zb.p
        public final Object invoke(Object obj, b<? super lb.n> bVar) {
            return ((AnonymousClass2) create((FlowCollector) obj, bVar)).invokeSuspend(lb.n.f10413a);
        }

        /* JADX WARN: Code restructure failed: missing block: B:14:0x004b, code lost:
        
            if (r1.emit(r3, r5) == r0) goto L15;
         */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public final java.lang.Object invokeSuspend(java.lang.Object r6) {
            /*
                r5 = this;
                kotlin.coroutines.intrinsics.CoroutineSingletons r0 = kotlin.coroutines.intrinsics.CoroutineSingletons.f10059a
                int r1 = r5.f6123a
                r2 = 2
                r3 = 1
                if (r1 == 0) goto L24
                if (r1 == r3) goto L18
                if (r1 != r2) goto L10
                kotlin.c.b(r6)
                goto L4e
            L10:
                java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
                java.lang.String r6 = "call to 'resume' before 'invoke' with coroutine"
                r5.<init>(r6)
                throw r5
            L18:
                java.lang.Object r1 = r5.f6124b
                kotlinx.coroutines.flow.FlowCollector r1 = (kotlinx.coroutines.flow.FlowCollector) r1
                kotlin.c.b(r6)
                kotlin.Result r6 = (kotlin.Result) r6
                java.lang.Object r6 = r6.f9987a
                goto L3d
            L24:
                kotlin.c.b(r6)
                java.lang.Object r6 = r5.f6124b
                r1 = r6
                kotlinx.coroutines.flow.FlowCollector r1 = (kotlinx.coroutines.flow.FlowCollector) r1
                r5.f6124b = r1
                r5.f6123a = r3
                com.stepos.base.ability.AbilityBase<AbilityInput extends v6.c, AbilityOutput extends v6.d> r6 = r5.f6125c
                AbilityInput extends v6.c r3 = r5.f6126d
                java.lang.Object r4 = r5.f6127e
                java.lang.Object r6 = r6.mo17doCloudInfer0E7RQCE(r3, r4, r5)
                if (r6 != r0) goto L3d
                goto L4d
            L3d:
                kotlin.Result r3 = new kotlin.Result
                r3.<init>(r6)
                r6 = 0
                r5.f6124b = r6
                r5.f6123a = r2
                java.lang.Object r5 = r1.emit(r3, r5)
                if (r5 != r0) goto L4e
            L4d:
                return r0
            L4e:
                lb.n r5 = lb.n.f10413a
                return r5
            */
            throw new UnsupportedOperationException("Method not decompiled: com.stepos.base.ability.AbilityBase.AnonymousClass2.invokeSuspend(java.lang.Object):java.lang.Object");
        }
    }

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    @rb.c(c = "com.stepos.base.ability.AbilityBase$doFlowCloudInfer$2", f = "AbilityBase.kt", l = {456, 456}, m = "invokeSuspend")
    /* renamed from: com.stepos.base.ability.AbilityBase$doFlowCloudInfer$2, reason: invalid class name and case insensitive filesystem */
    public static final class C02832 extends SuspendLambda implements zb.p<FlowCollector<? super Result<? extends AbilityOutput>>, b<? super lb.n>, Object> {

        /* renamed from: a, reason: collision with root package name */
        public int f6128a;

        /* renamed from: b, reason: collision with root package name */
        public /* synthetic */ Object f6129b;

        /* renamed from: c, reason: collision with root package name */
        public final /* synthetic */ AbilityBase<AbilityInput, AbilityOutput> f6130c;

        /* renamed from: d, reason: collision with root package name */
        public final /* synthetic */ AbilityInput f6131d;

        /* renamed from: e, reason: collision with root package name */
        public final /* synthetic */ Object f6132e;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C02832(AbilityBase<AbilityInput, AbilityOutput> abilityBase, AbilityInput abilityinput, Object obj, b<? super C02832> bVar) {
            super(2, bVar);
            this.f6130c = abilityBase;
            this.f6131d = abilityinput;
            this.f6132e = obj;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final b<lb.n> create(Object obj, b<?> bVar) {
            C02832 c02832 = new C02832(this.f6130c, this.f6131d, this.f6132e, bVar);
            c02832.f6129b = obj;
            return c02832;
        }

        @Override // zb.p
        public final Object invoke(Object obj, b<? super lb.n> bVar) {
            return ((C02832) create((FlowCollector) obj, bVar)).invokeSuspend(lb.n.f10413a);
        }

        /* JADX WARN: Code restructure failed: missing block: B:14:0x004b, code lost:
        
            if (r1.emit(r3, r5) == r0) goto L15;
         */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public final java.lang.Object invokeSuspend(java.lang.Object r6) {
            /*
                r5 = this;
                kotlin.coroutines.intrinsics.CoroutineSingletons r0 = kotlin.coroutines.intrinsics.CoroutineSingletons.f10059a
                int r1 = r5.f6128a
                r2 = 2
                r3 = 1
                if (r1 == 0) goto L24
                if (r1 == r3) goto L18
                if (r1 != r2) goto L10
                kotlin.c.b(r6)
                goto L4e
            L10:
                java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
                java.lang.String r6 = "call to 'resume' before 'invoke' with coroutine"
                r5.<init>(r6)
                throw r5
            L18:
                java.lang.Object r1 = r5.f6129b
                kotlinx.coroutines.flow.FlowCollector r1 = (kotlinx.coroutines.flow.FlowCollector) r1
                kotlin.c.b(r6)
                kotlin.Result r6 = (kotlin.Result) r6
                java.lang.Object r6 = r6.f9987a
                goto L3d
            L24:
                kotlin.c.b(r6)
                java.lang.Object r6 = r5.f6129b
                r1 = r6
                kotlinx.coroutines.flow.FlowCollector r1 = (kotlinx.coroutines.flow.FlowCollector) r1
                r5.f6129b = r1
                r5.f6128a = r3
                com.stepos.base.ability.AbilityBase<AbilityInput extends v6.c, AbilityOutput extends v6.d> r6 = r5.f6130c
                AbilityInput extends v6.c r3 = r5.f6131d
                java.lang.Object r4 = r5.f6132e
                java.lang.Object r6 = r6.mo17doCloudInfer0E7RQCE(r3, r4, r5)
                if (r6 != r0) goto L3d
                goto L4d
            L3d:
                kotlin.Result r3 = new kotlin.Result
                r3.<init>(r6)
                r6 = 0
                r5.f6129b = r6
                r5.f6128a = r2
                java.lang.Object r5 = r1.emit(r3, r5)
                if (r5 != r0) goto L4e
            L4d:
                return r0
            L4e:
                lb.n r5 = lb.n.f10413a
                return r5
            */
            throw new UnsupportedOperationException("Method not decompiled: com.stepos.base.ability.AbilityBase.C02832.invokeSuspend(java.lang.Object):java.lang.Object");
        }
    }

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    @rb.c(c = "com.stepos.base.ability.AbilityBase$doInfer$2", f = "AbilityBase.kt", l = {422, 422}, m = "invokeSuspend")
    /* renamed from: com.stepos.base.ability.AbilityBase$doInfer$2, reason: invalid class name and case insensitive filesystem */
    public static final class C02842 extends SuspendLambda implements zb.p<FlowCollector<? super Result<? extends AbilityOutput>>, b<? super lb.n>, Object> {

        /* renamed from: a, reason: collision with root package name */
        public int f6133a;

        /* renamed from: b, reason: collision with root package name */
        public /* synthetic */ Object f6134b;

        /* renamed from: c, reason: collision with root package name */
        public final /* synthetic */ AbilityBase<AbilityInput, AbilityOutput> f6135c;

        /* renamed from: d, reason: collision with root package name */
        public final /* synthetic */ AbilityInput f6136d;

        /* renamed from: e, reason: collision with root package name */
        public final /* synthetic */ Object f6137e;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C02842(AbilityBase<AbilityInput, AbilityOutput> abilityBase, AbilityInput abilityinput, Object obj, b<? super C02842> bVar) {
            super(2, bVar);
            this.f6135c = abilityBase;
            this.f6136d = abilityinput;
            this.f6137e = obj;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final b<lb.n> create(Object obj, b<?> bVar) {
            C02842 c02842 = new C02842(this.f6135c, this.f6136d, this.f6137e, bVar);
            c02842.f6134b = obj;
            return c02842;
        }

        @Override // zb.p
        public final Object invoke(Object obj, b<? super lb.n> bVar) {
            return ((C02842) create((FlowCollector) obj, bVar)).invokeSuspend(lb.n.f10413a);
        }

        /* JADX WARN: Code restructure failed: missing block: B:14:0x004b, code lost:
        
            if (r1.emit(r3, r5) == r0) goto L15;
         */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public final java.lang.Object invokeSuspend(java.lang.Object r6) {
            /*
                r5 = this;
                kotlin.coroutines.intrinsics.CoroutineSingletons r0 = kotlin.coroutines.intrinsics.CoroutineSingletons.f10059a
                int r1 = r5.f6133a
                r2 = 2
                r3 = 1
                if (r1 == 0) goto L24
                if (r1 == r3) goto L18
                if (r1 != r2) goto L10
                kotlin.c.b(r6)
                goto L4e
            L10:
                java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
                java.lang.String r6 = "call to 'resume' before 'invoke' with coroutine"
                r5.<init>(r6)
                throw r5
            L18:
                java.lang.Object r1 = r5.f6134b
                kotlinx.coroutines.flow.FlowCollector r1 = (kotlinx.coroutines.flow.FlowCollector) r1
                kotlin.c.b(r6)
                kotlin.Result r6 = (kotlin.Result) r6
                java.lang.Object r6 = r6.f9987a
                goto L3d
            L24:
                kotlin.c.b(r6)
                java.lang.Object r6 = r5.f6134b
                r1 = r6
                kotlinx.coroutines.flow.FlowCollector r1 = (kotlinx.coroutines.flow.FlowCollector) r1
                r5.f6134b = r1
                r5.f6133a = r3
                com.stepos.base.ability.AbilityBase<AbilityInput extends v6.c, AbilityOutput extends v6.d> r6 = r5.f6135c
                AbilityInput extends v6.c r3 = r5.f6136d
                java.lang.Object r4 = r5.f6137e
                java.lang.Object r6 = r6.mo18doInfer0E7RQCE(r3, r4, r5)
                if (r6 != r0) goto L3d
                goto L4d
            L3d:
                kotlin.Result r3 = new kotlin.Result
                r3.<init>(r6)
                r6 = 0
                r5.f6134b = r6
                r5.f6133a = r2
                java.lang.Object r5 = r1.emit(r3, r5)
                if (r5 != r0) goto L4e
            L4d:
                return r0
            L4e:
                lb.n r5 = lb.n.f10413a
                return r5
            */
            throw new UnsupportedOperationException("Method not decompiled: com.stepos.base.ability.AbilityBase.C02842.invokeSuspend(java.lang.Object):java.lang.Object");
        }
    }

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    @rb.c(c = "com.stepos.base.ability.AbilityBase", f = "AbilityBase.kt", l = {451}, m = "doInfer-0E7RQCE$suspendImpl")
    /* renamed from: com.stepos.base.ability.AbilityBase$doInfer$3, reason: invalid class name */
    public static final class AnonymousClass3<AbilityInput extends c, AbilityOutput extends d> extends ContinuationImpl {

        /* renamed from: a, reason: collision with root package name */
        public /* synthetic */ Object f6138a;

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ AbilityBase<AbilityInput, AbilityOutput> f6139b;

        /* renamed from: c, reason: collision with root package name */
        public int f6140c;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass3(AbilityBase<AbilityInput, AbilityOutput> abilityBase, b<? super AnonymousClass3> bVar) {
            super(bVar);
            this.f6139b = abilityBase;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.f6138a = obj;
            this.f6140c |= Integer.MIN_VALUE;
            Object objM15doInfer0E7RQCE$suspendImpl = AbilityBase.m15doInfer0E7RQCE$suspendImpl(this.f6139b, null, null, this);
            return objM15doInfer0E7RQCE$suspendImpl == CoroutineSingletons.f10059a ? objM15doInfer0E7RQCE$suspendImpl : new Result(objM15doInfer0E7RQCE$suspendImpl);
        }
    }

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    @rb.c(c = "com.stepos.base.ability.AbilityBase", f = "AbilityBase.kt", l = {329, 330, 336, 357, 358}, m = "executeByDecision")
    /* renamed from: com.stepos.base.ability.AbilityBase$executeByDecision$1, reason: invalid class name */
    public static final class AnonymousClass1 extends ContinuationImpl {

        /* renamed from: a, reason: collision with root package name */
        public AbilityBase f6145a;

        /* renamed from: b, reason: collision with root package name */
        public c f6146b;

        /* renamed from: c, reason: collision with root package name */
        public Object f6147c;

        /* renamed from: d, reason: collision with root package name */
        public /* synthetic */ Object f6148d;

        /* renamed from: e, reason: collision with root package name */
        public final /* synthetic */ AbilityBase<AbilityInput, AbilityOutput> f6149e;
        public int h;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass1(AbilityBase<AbilityInput, AbilityOutput> abilityBase, b<? super AnonymousClass1> bVar) {
            super(bVar);
            this.f6149e = abilityBase;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.f6148d = obj;
            this.h |= Integer.MIN_VALUE;
            return this.f6149e.executeByDecision(null, null, null, this);
        }
    }

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    @rb.c(c = "com.stepos.base.ability.AbilityBase$executeByDecision$5", f = "AbilityBase.kt", l = {341}, m = "invokeSuspend")
    /* renamed from: com.stepos.base.ability.AbilityBase$executeByDecision$5, reason: invalid class name */
    public static final class AnonymousClass5 extends SuspendLambda implements zb.p<FlowCollector<? super Result<? extends AbilityOutput>>, b<? super lb.n>, Object> {

        /* renamed from: a, reason: collision with root package name */
        public int f6156a;

        /* renamed from: b, reason: collision with root package name */
        public /* synthetic */ Object f6157b;

        /* renamed from: c, reason: collision with root package name */
        public final /* synthetic */ e.d f6158c;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass5(e.d dVar, b bVar) {
            super(2, bVar);
            this.f6158c = dVar;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final b<lb.n> create(Object obj, b<?> bVar) {
            AnonymousClass5 anonymousClass5 = new AnonymousClass5(this.f6158c, bVar);
            anonymousClass5.f6157b = obj;
            return anonymousClass5;
        }

        @Override // zb.p
        public final Object invoke(Object obj, b<? super lb.n> bVar) {
            return ((AnonymousClass5) create((FlowCollector) obj, bVar)).invokeSuspend(lb.n.f10413a);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            CoroutineSingletons coroutineSingletons = CoroutineSingletons.f10059a;
            int i10 = this.f6156a;
            if (i10 == 0) {
                kotlin.c.b(obj);
                FlowCollector flowCollector = (FlowCollector) this.f6157b;
                e.d dVar = this.f6158c;
                Result result = new Result(kotlin.c.a(new OrchestrationRejectedException(dVar.f9372b, dVar.f9371a)));
                this.f6156a = 1;
                if (flowCollector.emit(result, this) == coroutineSingletons) {
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

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    @rb.c(c = "com.stepos.base.ability.AbilityBase", f = "AbilityBase.kt", l = {230, 235}, m = "infer")
    /* renamed from: com.stepos.base.ability.AbilityBase$infer$1, reason: invalid class name and case insensitive filesystem */
    public static final class C02851 extends ContinuationImpl {

        /* renamed from: a, reason: collision with root package name */
        public AbilityBase f6165a;

        /* renamed from: b, reason: collision with root package name */
        public Object f6166b;

        /* renamed from: c, reason: collision with root package name */
        public Object f6167c;

        /* renamed from: d, reason: collision with root package name */
        public long f6168d;

        /* renamed from: e, reason: collision with root package name */
        public /* synthetic */ Object f6169e;
        public final /* synthetic */ AbilityBase<AbilityInput, AbilityOutput> h;

        /* renamed from: j, reason: collision with root package name */
        public int f6170j;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C02851(AbilityBase<AbilityInput, AbilityOutput> abilityBase, b<? super C02851> bVar) {
            super(bVar);
            this.h = abilityBase;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.f6169e = obj;
            this.f6170j |= Integer.MIN_VALUE;
            return this.h.infer(null, null, this);
        }
    }

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    @rb.c(c = "com.stepos.base.ability.AbilityBase$infer$3", f = "AbilityBase.kt", l = {}, m = "invokeSuspend")
    /* renamed from: com.stepos.base.ability.AbilityBase$infer$3, reason: invalid class name and case insensitive filesystem */
    public static final class C02863 extends SuspendLambda implements zb.p<Result<? extends AbilityOutput>, b<? super lb.n>, Object> {

        /* renamed from: a, reason: collision with root package name */
        public /* synthetic */ Object f6171a;

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ Ref$ObjectRef<Throwable> f6172b;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C02863(Ref$ObjectRef<Throwable> ref$ObjectRef, b<? super C02863> bVar) {
            super(2, bVar);
            this.f6172b = ref$ObjectRef;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final b<lb.n> create(Object obj, b<?> bVar) {
            C02863 c02863 = new C02863(this.f6172b, bVar);
            c02863.f6171a = obj;
            return c02863;
        }

        @Override // zb.p
        public final Object invoke(Object obj, b<? super lb.n> bVar) {
            return ((C02863) create(new Result(((Result) obj).f9987a), bVar)).invokeSuspend(lb.n.f10413a);
        }

        /* JADX WARN: Type inference failed for: r2v4, types: [T, java.lang.Throwable] */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            CoroutineSingletons coroutineSingletons = CoroutineSingletons.f10059a;
            kotlin.c.b(obj);
            ?? B = Result.b(((Result) this.f6171a).f9987a);
            if (B != 0) {
                this.f6172b.f10076a = B;
            }
            return lb.n.f10413a;
        }
    }

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    @rb.c(c = "com.stepos.base.ability.AbilityBase$infer$4", f = "AbilityBase.kt", l = {}, m = "invokeSuspend")
    /* renamed from: com.stepos.base.ability.AbilityBase$infer$4, reason: invalid class name */
    public static final class AnonymousClass4 extends SuspendLambda implements q<FlowCollector<? super Result<? extends AbilityOutput>>, Throwable, b<? super lb.n>, Object> {

        /* renamed from: a, reason: collision with root package name */
        public /* synthetic */ FlowCollector f6173a;

        /* renamed from: b, reason: collision with root package name */
        public /* synthetic */ Throwable f6174b;

        /* renamed from: c, reason: collision with root package name */
        public final /* synthetic */ long f6175c;

        /* renamed from: d, reason: collision with root package name */
        public final /* synthetic */ e f6176d;

        /* renamed from: e, reason: collision with root package name */
        public final /* synthetic */ Ref$ObjectRef<Throwable> f6177e;
        public final /* synthetic */ AbilityBase<AbilityInput, AbilityOutput> h;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass4(long j10, e eVar, Ref$ObjectRef<Throwable> ref$ObjectRef, AbilityBase<AbilityInput, AbilityOutput> abilityBase, b<? super AnonymousClass4> bVar) {
            super(3, bVar);
            this.f6175c = j10;
            this.f6176d = eVar;
            this.f6177e = ref$ObjectRef;
            this.h = abilityBase;
        }

        @Override // zb.q
        public final Object invoke(Object obj, Throwable th, b<? super lb.n> bVar) {
            Ref$ObjectRef<Throwable> ref$ObjectRef = this.f6177e;
            AbilityBase<AbilityInput, AbilityOutput> abilityBase = this.h;
            AnonymousClass4 anonymousClass4 = new AnonymousClass4(this.f6175c, this.f6176d, ref$ObjectRef, abilityBase, bVar);
            anonymousClass4.f6173a = (FlowCollector) obj;
            anonymousClass4.f6174b = th;
            return anonymousClass4.invokeSuspend(lb.n.f10413a);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            String str;
            String str2;
            Object objA;
            CoroutineSingletons coroutineSingletons = CoroutineSingletons.f10059a;
            kotlin.c.b(obj);
            Throwable th = this.f6174b;
            AbilityBase.Companion.getClass();
            a7.a aVar = AbilityBase.logBridge;
            if (aVar == null) {
                return lb.n.f10413a;
            }
            long jElapsedRealtimeNanos = (SystemClock.elapsedRealtimeNanos() - this.f6175c) / 1000000;
            e eVar = this.f6176d;
            if (eVar instanceof e.c) {
                str = "LOCAL";
            } else if (eVar instanceof e.a) {
                str = "CLOUD";
            } else if (eVar instanceof e.b) {
                str = "HYBRID";
            } else {
                if (!(eVar instanceof e.d)) {
                    throw new NoWhenBranchMatchedException();
                }
                str = "REJECT";
            }
            boolean z = th instanceof CancellationException;
            Ref$ObjectRef<Throwable> ref$ObjectRef = this.f6177e;
            if (z) {
                str2 = "CANCELLED";
            } else {
                str2 = "FAILED";
                if (th == null && ref$ObjectRef.f10076a == null) {
                    str2 = "SUCCESS";
                }
            }
            if (th == null) {
                th = ref$ObjectRef.f10076a;
            }
            OrchestrationRejectedException orchestrationRejectedException = th instanceof OrchestrationRejectedException ? (OrchestrationRejectedException) th : null;
            int i10 = orchestrationRejectedException != null ? orchestrationRejectedException.f6394a : 0;
            AbilityBase<AbilityInput, AbilityOutput> abilityBase = this.h;
            k kVar = (k) kotlin.collections.a.v0(((AbilityBase) abilityBase).modelConfigs);
            String str3 = kVar != null ? kVar.f3090a : "-";
            try {
                aVar.i(((AbilityBase) abilityBase).TAG, "[INFER-AUDIT] ability=" + abilityBase.getId() + " modelId=" + str3 + " loc=" + str + " status=" + str2 + " e2eMs=" + jElapsedRealtimeNanos + " err=" + i10);
                objA = lb.n.f10413a;
            } catch (Throwable th2) {
                objA = kotlin.c.a(th2);
            }
            Throwable thB = Result.b(objA);
            if (thB != null) {
                a0.a.A("logBridge.i threw: ", thB.getMessage(), ((AbilityBase) abilityBase).TAG);
            }
            return lb.n.f10413a;
        }
    }

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    @rb.c(c = "com.stepos.base.ability.AbilityBase", f = "AbilityBase.kt", l = {302}, m = "makeAndRecordDecision")
    /* renamed from: com.stepos.base.ability.AbilityBase$makeAndRecordDecision$1, reason: invalid class name and case insensitive filesystem */
    public static final class C02871 extends ContinuationImpl {

        /* renamed from: a, reason: collision with root package name */
        public AbilityBase f6178a;

        /* renamed from: b, reason: collision with root package name */
        public Object f6179b;

        /* renamed from: c, reason: collision with root package name */
        public /* synthetic */ Object f6180c;

        /* renamed from: d, reason: collision with root package name */
        public final /* synthetic */ AbilityBase<AbilityInput, AbilityOutput> f6181d;

        /* renamed from: e, reason: collision with root package name */
        public int f6182e;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C02871(AbilityBase<AbilityInput, AbilityOutput> abilityBase, b<? super C02871> bVar) {
            super(bVar);
            this.f6181d = abilityBase;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.f6180c = obj;
            this.f6182e |= Integer.MIN_VALUE;
            return this.f6181d.makeAndRecordDecision(null, null, this);
        }
    }

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    @rb.c(c = "com.stepos.base.ability.AbilityBase", f = "AbilityBase.kt", l = {277}, m = "planExecution$suspendImpl")
    /* renamed from: com.stepos.base.ability.AbilityBase$planExecution$1, reason: invalid class name and case insensitive filesystem */
    public static final class C02881<AbilityInput extends c, AbilityOutput extends d> extends ContinuationImpl {

        /* renamed from: a, reason: collision with root package name */
        public AbilityBase f6183a;

        /* renamed from: b, reason: collision with root package name */
        public c f6184b;

        /* renamed from: c, reason: collision with root package name */
        public long f6185c;

        /* renamed from: d, reason: collision with root package name */
        public /* synthetic */ Object f6186d;

        /* renamed from: e, reason: collision with root package name */
        public final /* synthetic */ AbilityBase<AbilityInput, AbilityOutput> f6187e;
        public int h;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C02881(AbilityBase<AbilityInput, AbilityOutput> abilityBase, b<? super C02881> bVar) {
            super(bVar);
            this.f6187e = abilityBase;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.f6186d = obj;
            this.h |= Integer.MIN_VALUE;
            return AbilityBase.planExecution$suspendImpl(this.f6187e, null, null, 0L, this);
        }
    }

    public AbilityBase(String id2, p6.a abilityConfig) {
        g.f(id2, "id");
        g.f(abilityConfig, "abilityConfig");
        this.f6122id = id2;
        this.abilityConfig = abilityConfig;
        this.TAG = "AbilityBase";
        this.modelConfigs = abilityConfig.f11419d;
        this.modelProtocols = abilityConfig.f11420e;
        this.bundleProperties = kotlin.collections.b.d0();
        this.acquiredHandles = new ArrayList();
        this.protocolManager$delegate = kotlin.b.b(new com.stepos.cpuset.b(12));
        this.orchestrator$delegate = kotlin.b.b(new b6.g(this, 17));
        this.modelCache$delegate = kotlin.b.b(new com.stepos.cpuset.b(13));
    }

    public static <AbilityInput extends c, AbilityOutput extends d> Object acquire$suspendImpl(AbilityBase<AbilityInput, AbilityOutput> abilityBase, b<? super Boolean> bVar) {
        Context context = l7.a.f10344a;
        if (context != null) {
            return abilityBase.internalPrepare(context, bVar);
        }
        throw new IllegalStateException("ContextHolder must be initialized before use!");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Object doCloudInfer(AbilityInput abilityinput, List<k> list, Object obj, b<? super Flow<? extends Result<? extends AbilityOutput>>> bVar) {
        return supportsStreaming() ? doFlowCloudInfer(abilityinput, obj, bVar) : FlowKt.flow(new AnonymousClass2(this, abilityinput, obj, null));
    }

    public static /* synthetic */ Object doCloudInfer$default(AbilityBase abilityBase, c cVar, List list, Object obj, b bVar, int i10, Object obj2) {
        if (obj2 != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: doCloudInfer");
        }
        if ((i10 & 4) != 0) {
            obj = null;
        }
        return abilityBase.doCloudInfer(cVar, list, obj, bVar);
    }

    /* renamed from: doCloudInfer-0E7RQCE$default, reason: not valid java name */
    public static /* synthetic */ Object m13doCloudInfer0E7RQCE$default(AbilityBase abilityBase, c cVar, Object obj, b bVar, int i10, Object obj2) {
        if (obj2 != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: doCloudInfer-0E7RQCE");
        }
        if ((i10 & 2) != 0) {
            obj = null;
        }
        return abilityBase.mo17doCloudInfer0E7RQCE(cVar, obj, bVar);
    }

    /* renamed from: doCloudInfer-0E7RQCE$suspendImpl, reason: not valid java name */
    public static <AbilityInput extends c, AbilityOutput extends d> Object m14doCloudInfer0E7RQCE$suspendImpl(AbilityBase<AbilityInput, AbilityOutput> abilityBase, AbilityInput abilityinput, Object obj, b<? super Result<? extends AbilityOutput>> bVar) {
        return kotlin.c.a(new UnsupportedOperationException(ai.onnxruntime.a.k("Cloud inference not supported for ability: ", abilityBase.getId())));
    }

    public static /* synthetic */ Object doFlowCloudInfer$default(AbilityBase abilityBase, c cVar, Object obj, b bVar, int i10, Object obj2) {
        if (obj2 != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: doFlowCloudInfer");
        }
        if ((i10 & 2) != 0) {
            obj = null;
        }
        return abilityBase.doFlowCloudInfer(cVar, obj, bVar);
    }

    public static /* synthetic */ <AbilityInput extends c, AbilityOutput extends d> Object doFlowCloudInfer$suspendImpl(AbilityBase<AbilityInput, AbilityOutput> abilityBase, AbilityInput abilityinput, Object obj, b<? super Flow<? extends Result<? extends AbilityOutput>>> bVar) {
        return FlowKt.flow(new C02832(abilityBase, abilityinput, obj, null));
    }

    public static /* synthetic */ Object doFlowInfer$default(AbilityBase abilityBase, c cVar, Object obj, b bVar, int i10, Object obj2) {
        if (obj2 != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: doFlowInfer");
        }
        if ((i10 & 2) != 0) {
            obj = null;
        }
        return abilityBase.doFlowInfer(cVar, obj, bVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Object doInfer(AbilityInput abilityinput, List<k> list, Object obj, b<? super Flow<? extends Result<? extends AbilityOutput>>> bVar) {
        return supportsStreaming() ? doFlowInfer(abilityinput, obj, bVar) : FlowKt.flow(new C02842(this, abilityinput, obj, null));
    }

    public static /* synthetic */ Object doInfer$default(AbilityBase abilityBase, c cVar, List list, Object obj, b bVar, int i10, Object obj2) {
        if (obj2 != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: doInfer");
        }
        if ((i10 & 4) != 0) {
            obj = null;
        }
        return abilityBase.doInfer(cVar, list, obj, bVar);
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /* renamed from: doInfer-0E7RQCE$suspendImpl, reason: not valid java name */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static <AbilityInput extends v6.c, AbilityOutput extends v6.d> java.lang.Object m15doInfer0E7RQCE$suspendImpl(com.stepos.base.ability.AbilityBase<AbilityInput, AbilityOutput> r3, AbilityInput r4, java.lang.Object r5, qb.b<? super kotlin.Result<? extends AbilityOutput>> r6) {
        /*
            boolean r5 = r6 instanceof com.stepos.base.ability.AbilityBase.AnonymousClass3
            if (r5 == 0) goto L13
            r5 = r6
            com.stepos.base.ability.AbilityBase$doInfer$3 r5 = (com.stepos.base.ability.AbilityBase.AnonymousClass3) r5
            int r0 = r5.f6140c
            r1 = -2147483648(0xffffffff80000000, float:-0.0)
            r2 = r0 & r1
            if (r2 == 0) goto L13
            int r0 = r0 - r1
            r5.f6140c = r0
            goto L18
        L13:
            com.stepos.base.ability.AbilityBase$doInfer$3 r5 = new com.stepos.base.ability.AbilityBase$doInfer$3
            r5.<init>(r3, r6)
        L18:
            java.lang.Object r6 = r5.f6138a
            kotlin.coroutines.intrinsics.CoroutineSingletons r0 = kotlin.coroutines.intrinsics.CoroutineSingletons.f10059a
            int r1 = r5.f6140c
            r2 = 1
            if (r1 == 0) goto L33
            if (r1 != r2) goto L2b
            kotlin.c.b(r6)
            kotlin.Result r6 = (kotlin.Result) r6
            java.lang.Object r3 = r6.f9987a
            return r3
        L2b:
            java.lang.IllegalStateException r3 = new java.lang.IllegalStateException
            java.lang.String r4 = "call to 'resume' before 'invoke' with coroutine"
            r3.<init>(r4)
            throw r3
        L33:
            kotlin.c.b(r6)
            r5.f6140c = r2
            java.lang.Object r3 = r3.mo19doInfergIAlus(r4, r5)
            if (r3 != r0) goto L3f
            return r0
        L3f:
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stepos.base.ability.AbilityBase.m15doInfer0E7RQCE$suspendImpl(com.stepos.base.ability.AbilityBase, v6.c, java.lang.Object, qb.b):java.lang.Object");
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code restructure failed: missing block: B:60:0x010f, code lost:
    
        ai.onnxruntime.a.x("Model ", r5, " missing or not ready in cache", r9.TAG);
     */
    /* JADX WARN: Code restructure failed: missing block: B:69:0x0140, code lost:
    
        if (r10 == r1) goto L70;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /* renamed from: ensureLocalModelsReady-IoAF18A, reason: not valid java name */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object m16ensureLocalModelsReadyIoAF18A(qb.b<? super kotlin.Result<lb.n>> r10) {
        /*
            Method dump skipped, instructions count: 369
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stepos.base.ability.AbilityBase.m16ensureLocalModelsReadyIoAF18A(qb.b):java.lang.Object");
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code restructure failed: missing block: B:35:0x009d, code lost:
    
        if (r13 == r1) goto L64;
     */
    /* JADX WARN: Code restructure failed: missing block: B:63:0x010b, code lost:
    
        if (r13 == r1) goto L64;
     */
    /* JADX WARN: Removed duplicated region for block: B:34:0x008d  */
    /* JADX WARN: Removed duplicated region for block: B:39:0x00a3  */
    /* JADX WARN: Removed duplicated region for block: B:62:0x00fb  */
    /* JADX WARN: Removed duplicated region for block: B:67:0x0111  */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object executeByDecision(AbilityInput r10, java.lang.Object r11, h7.e r12, qb.b<? super kotlinx.coroutines.flow.Flow<? extends kotlin.Result<? extends AbilityOutput>>> r13) {
        /*
            Method dump skipped, instructions count: 289
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stepos.base.ability.AbilityBase.executeByDecision(v6.c, java.lang.Object, h7.e, qb.b):java.lang.Object");
    }

    public static final a7.a getLogBridge() {
        Companion.getClass();
        return logBridge;
    }

    private final h7.d getOrchestrator() {
        return (h7.d) this.orchestrator$delegate.getValue();
    }

    public static /* synthetic */ Object internalRelease$default(AbilityBase abilityBase, ModelReleaseReason modelReleaseReason, b bVar, int i10, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: internalRelease");
        }
        if ((i10 & 1) != 0) {
            modelReleaseReason = ModelReleaseReason.f6321b;
        }
        return abilityBase.internalRelease(modelReleaseReason, bVar);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v0, types: [kotlin.Result$Failure] */
    /* JADX WARN: Type inference failed for: r1v7, types: [java.util.LinkedHashMap, java.util.Map] */
    private final Map<String, String> loadBundleProperties(String str) {
        Object objA;
        JSONObject jSONObjectOptJSONObject;
        File fileResolveBundleConfigFile = resolveBundleConfigFile(str);
        if (fileResolveBundleConfigFile == null) {
            return kotlin.collections.b.d0();
        }
        try {
            jSONObjectOptJSONObject = new JSONObject(wb.d.Z(fileResolveBundleConfigFile, gc.a.f9106b)).optJSONObject("properties");
        } catch (Throwable th) {
            objA = kotlin.c.a(th);
        }
        if (jSONObjectOptJSONObject == null) {
            return kotlin.collections.b.d0();
        }
        objA = new LinkedHashMap();
        Iterator<String> itKeys = jSONObjectOptJSONObject.keys();
        g.e(itKeys, "keys(...)");
        while (itKeys.hasNext()) {
            String next = itKeys.next();
            objA.put(next, jSONObjectOptJSONObject.getString(next));
        }
        Throwable thB = Result.b(objA);
        Map<String, String> mapD0 = objA;
        if (thB != null) {
            Log.w(this.TAG, "loadBundleProperties failed for " + str + ": " + thB.getMessage());
            mapD0 = kotlin.collections.b.d0();
        }
        return mapD0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object makeAndRecordDecision(AbilityInput r6, java.lang.Object r7, qb.b<? super h7.e> r8) {
        /*
            r5 = this;
            boolean r0 = r8 instanceof com.stepos.base.ability.AbilityBase.C02871
            if (r0 == 0) goto L13
            r0 = r8
            com.stepos.base.ability.AbilityBase$makeAndRecordDecision$1 r0 = (com.stepos.base.ability.AbilityBase.C02871) r0
            int r1 = r0.f6182e
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.f6182e = r1
            goto L18
        L13:
            com.stepos.base.ability.AbilityBase$makeAndRecordDecision$1 r0 = new com.stepos.base.ability.AbilityBase$makeAndRecordDecision$1
            r0.<init>(r5, r8)
        L18:
            java.lang.Object r8 = r0.f6180c
            kotlin.coroutines.intrinsics.CoroutineSingletons r1 = kotlin.coroutines.intrinsics.CoroutineSingletons.f10059a
            int r2 = r0.f6182e
            r3 = 1
            if (r2 == 0) goto L33
            if (r2 != r3) goto L2b
            java.lang.Object r7 = r0.f6179b
            com.stepos.base.ability.AbilityBase r5 = r0.f6178a
            kotlin.c.b(r8)
            goto L4f
        L2b:
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
            java.lang.String r6 = "call to 'resume' before 'invoke' with coroutine"
            r5.<init>(r6)
            throw r5
        L33:
            kotlin.c.b(r8)
            h7.d r8 = r5.getOrchestrator()
            java.lang.String r2 = r5.getId()
            h7.b r4 = r5.getExecutionConstraints(r6)
            r0.f6178a = r5
            r0.f6179b = r7
            r0.f6182e = r3
            java.lang.Object r8 = r8.makeDecision(r6, r2, r4, r0)
            if (r8 != r1) goto L4f
            return r1
        L4f:
            h7.e r8 = (h7.e) r8
            if (r7 == 0) goto L70
            r5.recordFillOrchestrationDecision(r7, r8)     // Catch: java.lang.Exception -> L57
            goto L63
        L57:
            r6 = move-exception
            java.lang.String r5 = r5.TAG
            java.lang.String r6 = r6.getMessage()
            java.lang.String r0 = "Failed to fill orchestration decision to record: "
            a0.a.A(r0, r6, r5)
        L63:
            boolean r5 = r7 instanceof j7.d
            if (r5 == 0) goto L6a
            j7.d r7 = (j7.d) r7
            goto L6b
        L6a:
            r7 = 0
        L6b:
            if (r7 == 0) goto L70
            r7.setRoutingDecision(r8)
        L70:
            return r8
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stepos.base.ability.AbilityBase.makeAndRecordDecision(v6.c, java.lang.Object, qb.b):java.lang.Object");
    }

    /* JADX WARN: Removed duplicated region for block: B:18:0x003f  */
    /* JADX WARN: Removed duplicated region for block: B:21:0x0053  */
    /* JADX WARN: Removed duplicated region for block: B:48:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private final void mergeBundleDescriptor(b7.k r27) {
        /*
            Method dump skipped, instructions count: 238
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stepos.base.ability.AbilityBase.mergeBundleDescriptor(b7.k):void");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final b7.b modelCache_delegate$lambda$2() {
        ModelCacheImpl modelCacheImpl = j.f3087b;
        if (modelCacheImpl != null) {
            return modelCacheImpl;
        }
        throw new IllegalStateException("IModelCache not registered. Call ModelCacheHolder.register() at application startup.");
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static <AbilityInput extends v6.c, AbilityOutput extends v6.d> java.lang.Object planExecution$suspendImpl(com.stepos.base.ability.AbilityBase<AbilityInput, AbilityOutput> r4, AbilityInput r5, java.lang.Object r6, long r7, qb.b<? super h7.c> r9) {
        /*
            boolean r0 = r9 instanceof com.stepos.base.ability.AbilityBase.C02881
            if (r0 == 0) goto L13
            r0 = r9
            com.stepos.base.ability.AbilityBase$planExecution$1 r0 = (com.stepos.base.ability.AbilityBase.C02881) r0
            int r1 = r0.h
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.h = r1
            goto L18
        L13:
            com.stepos.base.ability.AbilityBase$planExecution$1 r0 = new com.stepos.base.ability.AbilityBase$planExecution$1
            r0.<init>(r4, r9)
        L18:
            java.lang.Object r9 = r0.f6186d
            kotlin.coroutines.intrinsics.CoroutineSingletons r1 = kotlin.coroutines.intrinsics.CoroutineSingletons.f10059a
            int r2 = r0.h
            r3 = 1
            if (r2 == 0) goto L35
            if (r2 != r3) goto L2d
            long r7 = r0.f6185c
            v6.c r5 = r0.f6184b
            com.stepos.base.ability.AbilityBase r4 = r0.f6183a
            kotlin.c.b(r9)
            goto L47
        L2d:
            java.lang.IllegalStateException r4 = new java.lang.IllegalStateException
            java.lang.String r5 = "call to 'resume' before 'invoke' with coroutine"
            r4.<init>(r5)
            throw r4
        L35:
            kotlin.c.b(r9)
            r0.f6183a = r4
            r0.f6184b = r5
            r0.f6185c = r7
            r0.h = r3
            java.lang.Object r9 = r4.makeAndRecordDecision(r5, r6, r0)
            if (r9 != r1) goto L47
            return r1
        L47:
            h7.e r9 = (h7.e) r9
            boolean r6 = r9 instanceof h7.e.a
            if (r6 == 0) goto L52
            long r4 = r4.cloudExecutionTimeoutMs(r5)
            goto L56
        L52:
            long r4 = r4.localExecutionTimeoutMs(r5, r7)
        L56:
            h7.c r6 = new h7.c
            r6.<init>(r9, r4)
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stepos.base.ability.AbilityBase.planExecution$suspendImpl(com.stepos.base.ability.AbilityBase, v6.c, java.lang.Object, long, qb.b):java.lang.Object");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final e7.e protocolManager_delegate$lambda$0() {
        return new e7.e();
    }

    private final void recordFillInputInfo(Object obj, AbilityInput abilityinput) throws IllegalAccessException, NoSuchFieldException, SecurityException, IllegalArgumentException {
        try {
            Class<?> cls = obj.getClass();
            Field declaredField = cls.getDeclaredField("abilityId");
            if (declaredField != null) {
                declaredField.setAccessible(true);
                declaredField.set(obj, getId());
            }
            Field declaredField2 = cls.getDeclaredField("inputType");
            if (declaredField2 != null) {
                declaredField2.setAccessible(true);
                String strC = i.a(abilityinput.getClass()).c();
                if (strC == null) {
                    strC = "Unknown";
                }
                declaredField2.set(obj, strC);
            }
            Field declaredField3 = cls.getDeclaredField("inputSize");
            if (declaredField3 != null) {
                declaredField3.setAccessible(true);
                abilityinput.getClass();
                declaredField3.set(obj, 0L);
            }
        } catch (Exception e10) {
            a0.a.A("Failed to fill record via reflection: ", e10.getMessage(), this.TAG);
        }
    }

    private final void recordFillOrchestrationDecision(Object obj, e eVar) {
        String str;
        String str2;
        j7.d dVar = obj instanceof j7.d ? (j7.d) obj : null;
        if (dVar == null) {
            return;
        }
        boolean z = eVar instanceof e.c;
        if (z) {
            str = "LOCAL";
        } else if (eVar instanceof e.a) {
            str = "CLOUD";
        } else if (eVar instanceof e.b) {
            str = "HYBRID";
        } else {
            if (!(eVar instanceof e.d)) {
                throw new NoWhenBranchMatchedException();
            }
            str = FailStage.UNKNOWN;
        }
        dVar.setExecutionLocationName(str);
        if (z) {
            str2 = ((e.c) eVar).f9370a;
        } else if (eVar instanceof e.a) {
            str2 = ((e.a) eVar).f9369b;
        } else if (eVar instanceof e.b) {
            str2 = null;
        } else {
            if (!(eVar instanceof e.d)) {
                throw new NoWhenBranchMatchedException();
            }
            str2 = ((e.d) eVar).f9371a;
        }
        dVar.setOrchestrationReason(str2);
    }

    public static <AbilityInput extends c, AbilityOutput extends d> Object release$suspendImpl(AbilityBase<AbilityInput, AbilityOutput> abilityBase, ModelReleaseReason modelReleaseReason, b<? super lb.n> bVar) {
        Object objInternalRelease = abilityBase.internalRelease(modelReleaseReason, bVar);
        return objInternalRelease == CoroutineSingletons.f10059a ? objInternalRelease : lb.n.f10413a;
    }

    private final File resolveBundleConfigFile(String str) {
        File file = new File(str);
        if (file.isFile() && g.b(file.getName(), "bundle_config.json")) {
            return file;
        }
        if (!file.isDirectory() && (file = file.getParentFile()) == null) {
            return null;
        }
        File file2 = new File(file, "bundle_config.json");
        if (file2.isFile()) {
            return file2;
        }
        return null;
    }

    private final k resolveEffectiveModelConfig(k kVar) {
        if (!kVar.f3098j && jd.b.f9768a != null) {
            String strWireSharedRuntime$lambda$11 = OtaEngine.wireSharedRuntime$lambda$11(getId(), kVar.f3091b);
            if (!g.b(strWireSharedRuntime$lambda$11, kVar.f3091b)) {
                return k.a(kVar, strWireSharedRuntime$lambda$11, null, null, 16381);
            }
        }
        return kVar;
    }

    public static final void setLogBridge(a7.a aVar) {
        Companion.getClass();
        logBridge = aVar;
    }

    @Override // p6.d
    public Object acquire(b<? super Boolean> bVar) {
        return acquire$suspendImpl(this, bVar);
    }

    public h7.d buildOrchestrator() {
        return h7.a.f9361a;
    }

    @Override // p6.d
    public boolean cancel() {
        return stopInfer();
    }

    public long cloudExecutionTimeoutMs(AbilityInput input) {
        g.f(input, "input");
        return b.a.a(0L).f11896c;
    }

    @Override // p6.d
    public void completeInput(String inferId) {
        g.f(inferId, "inferId");
        throw new UnsupportedOperationException(ai.onnxruntime.a.k("completeInput not supported by ability: ", getId()));
    }

    public AbilityOutput defaultOutput() {
        g.d(null, "null cannot be cast to non-null type AbilityOutput of com.stepos.base.ability.AbilityBase");
        return null;
    }

    /* renamed from: doCloudInfer-0E7RQCE, reason: not valid java name */
    public Object mo17doCloudInfer0E7RQCE(AbilityInput abilityinput, Object obj, qb.b<? super Result<? extends AbilityOutput>> bVar) {
        return m14doCloudInfer0E7RQCE$suspendImpl(this, abilityinput, obj, bVar);
    }

    public Object doFlowCloudInfer(AbilityInput abilityinput, Object obj, qb.b<? super Flow<? extends Result<? extends AbilityOutput>>> bVar) {
        return doFlowCloudInfer$suspendImpl(this, abilityinput, obj, bVar);
    }

    public abstract Object doFlowInfer(AbilityInput abilityinput, Object obj, qb.b<? super Flow<? extends Result<? extends AbilityOutput>>> bVar);

    /* renamed from: doInfer-0E7RQCE, reason: not valid java name */
    public Object mo18doInfer0E7RQCE(AbilityInput abilityinput, Object obj, qb.b<? super Result<? extends AbilityOutput>> bVar) {
        return m15doInfer0E7RQCE$suspendImpl(this, abilityinput, obj, bVar);
    }

    /* renamed from: doInfer-gIAlu-s, reason: not valid java name */
    public abstract Object mo19doInfergIAlus(AbilityInput abilityinput, qb.b<? super Result<? extends AbilityOutput>> bVar);

    @Override // p6.d
    public Object execute(String action, Object obj) {
        g.f(action, "action");
        if (!action.equals("getProperty")) {
            throw new UnsupportedOperationException(ai.onnxruntime.a.l("execute '", action, "' not supported by ability: ", getId()));
        }
        String str = obj instanceof String ? (String) obj : null;
        if (str == null) {
            str = "";
        }
        return getProperty(str);
    }

    @Override // p6.d
    public p6.a getAbilityConfig() {
        return this.abilityConfig;
    }

    public h7.b getExecutionConstraints(c input) {
        g.f(input, "input");
        h7.b bVar = h7.b.f9362d;
        return h7.b.f9362d;
    }

    @Override // p6.d
    public String getId() {
        return this.f6122id;
    }

    public final b7.b getModelCache() {
        return (b7.b) this.modelCache$delegate.getValue();
    }

    public String getProperty(String name) {
        g.f(name, "name");
        return this.bundleProperties.get(name);
    }

    public final e7.e getProtocolManager() {
        return (e7.e) this.protocolManager$delegate.getValue();
    }

    @Override // p6.d
    public boolean getSupportsFeedInput() {
        return false;
    }

    /* JADX WARN: Code restructure failed: missing block: B:30:0x009f, code lost:
    
        if (r0 == r5) goto L35;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:36:0x00be  */
    /* JADX WARN: Removed duplicated region for block: B:7:0x001b  */
    @Override // p6.d
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object infer(AbilityInput r17, java.lang.Object r18, qb.b<? super kotlinx.coroutines.flow.Flow<? extends kotlin.Result<? extends AbilityOutput>>> r19) {
        /*
            Method dump skipped, instructions count: 216
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stepos.base.ability.AbilityBase.infer(v6.c, java.lang.Object, qb.b):java.lang.Object");
    }

    public final Object internalPrepare(Context context, qb.b<? super Boolean> bVar) {
        if (!this.acquiredHandles.isEmpty()) {
            Log.d(this.TAG, "internalPrepare: already prepared (" + this.acquiredHandles.size() + " handles), skip re-acquire");
            return Boolean.TRUE;
        }
        this.initError = null;
        Log.d(this.TAG, "internalPrepare: modelConfigs.size=" + this.modelConfigs.size() + ", modelProtocols.size=" + this.modelProtocols.size());
        try {
            int i10 = 0;
            for (Object obj : this.modelConfigs) {
                int i11 = i10 + 1;
                if (i10 < 0) {
                    m.f0();
                    throw null;
                }
                k kVarResolveEffectiveModelConfig = resolveEffectiveModelConfig((k) obj);
                Log.d(this.TAG, "internalPrepare: index=" + i10 + ", modelConfig=" + kVarResolveEffectiveModelConfig.f3091b);
                Map<String, String> mapLoadBundleProperties = loadBundleProperties(kVarResolveEffectiveModelConfig.f3091b);
                if (!mapLoadBundleProperties.isEmpty()) {
                    this.bundleProperties = kotlin.collections.b.j0(this.bundleProperties, mapLoadBundleProperties);
                    Log.d(this.TAG, "internalPrepare: loaded " + mapLoadBundleProperties.size() + " bundle properties from " + kVarResolveEffectiveModelConfig.f3091b);
                }
                mergeBundleDescriptor(kVarResolveEffectiveModelConfig);
                if (kVarResolveEffectiveModelConfig.f3098j) {
                    Log.d(this.TAG, "internalPrepare: mock model, skip loading: " + kVarResolveEffectiveModelConfig.f3090a);
                } else {
                    ModelCacheImpl modelCacheImpl = s.f3120b;
                    if (modelCacheImpl == null) {
                        throw new IllegalStateException("VersionedModelCache not available");
                    }
                    n nVarAcquire = modelCacheImpl.acquire(kVarResolveEffectiveModelConfig.f3090a);
                    this.acquiredHandles.add(nVarAcquire);
                    b7.a iModel = nVarAcquire.f3109c.getIModel();
                    if (i10 < this.modelProtocols.size()) {
                        ProtocolType protocolType = (ProtocolType) kotlin.collections.a.u0(this.modelProtocols.get(i10).f3116c);
                        if (protocolType == null) {
                            protocolType = ProtocolType.f6378a;
                        }
                        Log.d(this.TAG, "internalPrepare: binding protocol type=" + protocolType);
                        e7.b bVarA = f.a(iModel, protocolType);
                        if (bVarA == null) {
                            bVarA = null;
                        }
                        if (bVarA != null) {
                            getProtocolManager().a(bVarA);
                            Log.d(this.TAG, "internalPrepare: protocol added: " + bVarA.getClass().getSimpleName());
                        } else {
                            Log.w(this.TAG, "internalPrepare: bindProtocol returned null");
                        }
                    } else {
                        Log.w(this.TAG, "internalPrepare: no protocol for model at index " + i10);
                    }
                }
                i10 = i11;
            }
            Log.d(this.TAG, "internalPrepare: completed, protocolManager has " + getProtocolManager().f8613a.size() + " protocols");
            return Boolean.TRUE;
        } catch (Exception e10) {
            Log.e(this.TAG, "internalPrepare: " + e10.getMessage(), e10);
            this.initError = e10;
            Iterator<T> it = this.acquiredHandles.iterator();
            while (it.hasNext()) {
                try {
                    ((n) it.next()).close();
                    lb.n nVar = lb.n.f10413a;
                } catch (Throwable th) {
                    kotlin.c.a(th);
                }
            }
            this.acquiredHandles.clear();
            e7.e protocolManager = getProtocolManager();
            protocolManager.f8613a.clear();
            protocolManager.f8614b.clear();
            return Boolean.FALSE;
        }
    }

    public final Object internalRelease(ModelReleaseReason modelReleaseReason, qb.b<? super lb.n> bVar) {
        Iterator<T> it = this.acquiredHandles.iterator();
        while (it.hasNext()) {
            try {
                ((n) it.next()).a(modelReleaseReason);
            } catch (Exception e10) {
                Log.e(this.TAG, "Error closing handle: " + e10.getMessage(), e10);
            }
        }
        this.acquiredHandles.clear();
        e7.e protocolManager = getProtocolManager();
        protocolManager.f8613a.clear();
        protocolManager.f8614b.clear();
        return lb.n.f10413a;
    }

    @Override // p6.d
    public boolean isModelHeld() {
        return !this.acquiredHandles.isEmpty();
    }

    @Override // p6.d
    public String loadError() {
        Exception exc = this.initError;
        if (exc != null) {
            return exc.getMessage();
        }
        return null;
    }

    @Override // p6.d
    public Throwable loadFailure() {
        return this.initError;
    }

    public long localExecutionTimeoutMs(AbilityInput input, long j10) {
        g.f(input, "input");
        return j10;
    }

    @Override // p6.d
    public void onFeedInput(String inferId, Object input) {
        g.f(inferId, "inferId");
        g.f(input, "input");
        throw new UnsupportedOperationException(ai.onnxruntime.a.k("feedInput not supported by ability: ", getId()));
    }

    @Override // p6.d
    public Object planExecution(AbilityInput abilityinput, Object obj, long j10, qb.b<? super h7.c> bVar) {
        return planExecution$suspendImpl(this, abilityinput, obj, j10, bVar);
    }

    @Override // p6.d
    public Object release(ModelReleaseReason modelReleaseReason, qb.b<? super lb.n> bVar) {
        return release$suspendImpl(this, modelReleaseReason, bVar);
    }

    public boolean stopInfer() {
        Object objA;
        if (getProtocolManager().f8613a.isEmpty()) {
            return false;
        }
        Ref$BooleanRef ref$BooleanRef = new Ref$BooleanRef();
        for (e7.b bVar : kotlin.collections.b.n0(getProtocolManager().f8613a).values()) {
            b7.a aVar = bVar instanceof b7.a ? (b7.a) bVar : null;
            if (aVar != null) {
                try {
                    objA = Boolean.valueOf(aVar.cancel());
                } catch (Throwable th) {
                    objA = kotlin.c.a(th);
                }
                Object obj = Boolean.FALSE;
                if (objA instanceof Result.Failure) {
                    objA = obj;
                }
                ref$BooleanRef.f10073a = ((Boolean) objA).booleanValue() || ref$BooleanRef.f10073a;
            }
        }
        return ref$BooleanRef.f10073a;
    }
}
