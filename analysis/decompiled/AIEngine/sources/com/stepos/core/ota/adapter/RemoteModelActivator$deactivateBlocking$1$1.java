package com.stepos.core.ota.adapter;

import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.TimeoutKt;
import lb.n;
import qb.b;
import rb.c;
import zb.p;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
@c(c = "com.stepos.core.ota.adapter.RemoteModelActivator$deactivateBlocking$1$1", f = "RemoteModelActivator.kt", l = {95}, m = "invokeSuspend")
/* loaded from: classes.dex */
public final class RemoteModelActivator$deactivateBlocking$1$1 extends SuspendLambda implements p<CoroutineScope, b<? super Boolean>, Object> {
    final /* synthetic */ String $otaId;
    final /* synthetic */ RemoteModelActivator $this_runCatching;
    final /* synthetic */ long $timeoutMs;
    int label;

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    @c(c = "com.stepos.core.ota.adapter.RemoteModelActivator$deactivateBlocking$1$1$1", f = "RemoteModelActivator.kt", l = {95}, m = "invokeSuspend")
    /* renamed from: com.stepos.core.ota.adapter.RemoteModelActivator$deactivateBlocking$1$1$1, reason: invalid class name */
    public static final class AnonymousClass1 extends SuspendLambda implements p<CoroutineScope, b<? super Boolean>, Object> {
        final /* synthetic */ String $otaId;
        final /* synthetic */ RemoteModelActivator $this_runCatching;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass1(RemoteModelActivator remoteModelActivator, String str, b<? super AnonymousClass1> bVar) {
            super(2, bVar);
            this.$this_runCatching = remoteModelActivator;
            this.$otaId = str;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final b<n> create(Object obj, b<?> bVar) {
            return new AnonymousClass1(this.$this_runCatching, this.$otaId, bVar);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            CoroutineSingletons coroutineSingletons = CoroutineSingletons.f10059a;
            int i10 = this.label;
            if (i10 != 0) {
                if (i10 != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                kotlin.c.b(obj);
                return obj;
            }
            kotlin.c.b(obj);
            RemoteModelActivator remoteModelActivator = this.$this_runCatching;
            String str = this.$otaId;
            this.label = 1;
            Object objDeactivate = remoteModelActivator.deactivate(str, this);
            return objDeactivate == coroutineSingletons ? coroutineSingletons : objDeactivate;
        }

        @Override // zb.p
        public final Object invoke(CoroutineScope coroutineScope, b<? super Boolean> bVar) {
            return ((AnonymousClass1) create(coroutineScope, bVar)).invokeSuspend(n.f10413a);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public RemoteModelActivator$deactivateBlocking$1$1(long j10, RemoteModelActivator remoteModelActivator, String str, b<? super RemoteModelActivator$deactivateBlocking$1$1> bVar) {
        super(2, bVar);
        this.$timeoutMs = j10;
        this.$this_runCatching = remoteModelActivator;
        this.$otaId = str;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final b<n> create(Object obj, b<?> bVar) {
        return new RemoteModelActivator$deactivateBlocking$1$1(this.$timeoutMs, this.$this_runCatching, this.$otaId, bVar);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        CoroutineSingletons coroutineSingletons = CoroutineSingletons.f10059a;
        int i10 = this.label;
        if (i10 == 0) {
            kotlin.c.b(obj);
            long j10 = this.$timeoutMs;
            AnonymousClass1 anonymousClass1 = new AnonymousClass1(this.$this_runCatching, this.$otaId, null);
            this.label = 1;
            obj = TimeoutKt.withTimeoutOrNull(j10, anonymousClass1, this);
            if (obj == coroutineSingletons) {
                return coroutineSingletons;
            }
        } else {
            if (i10 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            kotlin.c.b(obj);
        }
        Boolean bool = (Boolean) obj;
        return Boolean.valueOf(bool != null ? bool.booleanValue() : false);
    }

    @Override // zb.p
    public final Object invoke(CoroutineScope coroutineScope, b<? super Boolean> bVar) {
        return ((RemoteModelActivator$deactivateBlocking$1$1) create(coroutineScope, bVar)).invokeSuspend(n.f10413a);
    }
}
