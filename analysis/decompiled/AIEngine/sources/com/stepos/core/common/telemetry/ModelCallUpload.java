package com.stepos.core.common.telemetry;

import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.SupervisorKt;
import lb.n;
import zb.p;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final class ModelCallUpload {
    public static final ModelCallUpload INSTANCE = new ModelCallUpload();
    private static final CoroutineScope telemetryScope = CoroutineScopeKt.CoroutineScope(SupervisorKt.SupervisorJob$default(null, 1, null).plus(Dispatchers.getIO()));
    private static volatile ModelCallUploader delegate = LogcatModelCallUploader.INSTANCE;

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    @rb.c(c = "com.stepos.core.common.telemetry.ModelCallUpload$onDownlink$1", f = "ModelCallUpload.kt", l = {}, m = "invokeSuspend")
    /* renamed from: com.stepos.core.common.telemetry.ModelCallUpload$onDownlink$1, reason: invalid class name */
    public static final class AnonymousClass1 extends SuspendLambda implements p<CoroutineScope, qb.b<? super n>, Object> {
        final /* synthetic */ ModelCallRecord $record;
        private /* synthetic */ Object L$0;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass1(ModelCallRecord modelCallRecord, qb.b<? super AnonymousClass1> bVar) {
            super(2, bVar);
            this.$record = modelCallRecord;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final qb.b<n> create(Object obj, qb.b<?> bVar) {
            AnonymousClass1 anonymousClass1 = new AnonymousClass1(this.$record, bVar);
            anonymousClass1.L$0 = obj;
            return anonymousClass1;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            CoroutineSingletons coroutineSingletons = CoroutineSingletons.f10059a;
            if (this.label != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            kotlin.c.b(obj);
            ModelCallEventBus.INSTANCE.post(this.$record);
            try {
                ModelCallUpload.delegate.onDownlink(this.$record);
                n nVar = n.f10413a;
            } catch (Throwable th) {
                kotlin.c.a(th);
            }
            return n.f10413a;
        }

        @Override // zb.p
        public final Object invoke(CoroutineScope coroutineScope, qb.b<? super n> bVar) {
            return ((AnonymousClass1) create(coroutineScope, bVar)).invokeSuspend(n.f10413a);
        }
    }

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    @rb.c(c = "com.stepos.core.common.telemetry.ModelCallUpload$onFirstCall$1", f = "ModelCallUpload.kt", l = {}, m = "invokeSuspend")
    /* renamed from: com.stepos.core.common.telemetry.ModelCallUpload$onFirstCall$1, reason: invalid class name and case insensitive filesystem */
    public static final class C03721 extends SuspendLambda implements p<CoroutineScope, qb.b<? super n>, Object> {
        final /* synthetic */ ModelCallRecord $record;
        private /* synthetic */ Object L$0;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C03721(ModelCallRecord modelCallRecord, qb.b<? super C03721> bVar) {
            super(2, bVar);
            this.$record = modelCallRecord;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final qb.b<n> create(Object obj, qb.b<?> bVar) {
            C03721 c03721 = new C03721(this.$record, bVar);
            c03721.L$0 = obj;
            return c03721;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            CoroutineSingletons coroutineSingletons = CoroutineSingletons.f10059a;
            if (this.label != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            kotlin.c.b(obj);
            try {
                ModelCallUpload.delegate.onFirstCall(this.$record);
                n nVar = n.f10413a;
            } catch (Throwable th) {
                kotlin.c.a(th);
            }
            return n.f10413a;
        }

        @Override // zb.p
        public final Object invoke(CoroutineScope coroutineScope, qb.b<? super n> bVar) {
            return ((C03721) create(coroutineScope, bVar)).invokeSuspend(n.f10413a);
        }
    }

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    @rb.c(c = "com.stepos.core.common.telemetry.ModelCallUpload$onUplink$1", f = "ModelCallUpload.kt", l = {}, m = "invokeSuspend")
    /* renamed from: com.stepos.core.common.telemetry.ModelCallUpload$onUplink$1, reason: invalid class name and case insensitive filesystem */
    public static final class C03731 extends SuspendLambda implements p<CoroutineScope, qb.b<? super n>, Object> {
        final /* synthetic */ ModelCallRecord $record;
        private /* synthetic */ Object L$0;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C03731(ModelCallRecord modelCallRecord, qb.b<? super C03731> bVar) {
            super(2, bVar);
            this.$record = modelCallRecord;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final qb.b<n> create(Object obj, qb.b<?> bVar) {
            C03731 c03731 = new C03731(this.$record, bVar);
            c03731.L$0 = obj;
            return c03731;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            CoroutineSingletons coroutineSingletons = CoroutineSingletons.f10059a;
            if (this.label != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            kotlin.c.b(obj);
            try {
                ModelCallUpload.delegate.onUplink(this.$record);
                n nVar = n.f10413a;
            } catch (Throwable th) {
                kotlin.c.a(th);
            }
            return n.f10413a;
        }

        @Override // zb.p
        public final Object invoke(CoroutineScope coroutineScope, qb.b<? super n> bVar) {
            return ((C03731) create(coroutineScope, bVar)).invokeSuspend(n.f10413a);
        }
    }

    private ModelCallUpload() {
    }

    public final void install(ModelCallUploader uploader) {
        kotlin.jvm.internal.g.f(uploader, "uploader");
        delegate = uploader;
    }

    public final void onDownlink(ModelCallRecord record) {
        kotlin.jvm.internal.g.f(record, "record");
        BuildersKt__Builders_commonKt.launch$default(telemetryScope, null, null, new AnonymousClass1(record, null), 3, null);
    }

    public final void onFirstCall(ModelCallRecord record) {
        kotlin.jvm.internal.g.f(record, "record");
        BuildersKt__Builders_commonKt.launch$default(telemetryScope, null, null, new C03721(record, null), 3, null);
    }

    public final void onUplink(ModelCallRecord record) {
        kotlin.jvm.internal.g.f(record, "record");
        BuildersKt__Builders_commonKt.launch$default(telemetryScope, null, null, new C03731(record, null), 3, null);
    }
}
