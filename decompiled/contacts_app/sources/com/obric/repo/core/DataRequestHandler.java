package com.obric.repo.core;

import androidx.exifinterface.media.ExifInterface;
import com.obric.capabilitykit.common.Ext;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineDispatcher;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.DelayKt;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.TimeoutKt;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowCollector;
import kotlinx.coroutines.flow.FlowKt;

/* JADX INFO: compiled from: DataRequestHandler.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000Z\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0006\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J;\u0010\u0003\u001a\b\u0012\u0004\u0012\u0002H\u00050\u0004\"\u0004\b\u0000\u0010\u00052\u001c\u0010\u0006\u001a\u0018\b\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00050\b\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u0007H\u0086@ø\u0001\u0000¢\u0006\u0002\u0010\tJM\u0010\n\u001a\b\u0012\u0004\u0012\u0002H\u00050\u0004\"\u0004\b\u0000\u0010\u00052\u001c\u0010\u0006\u001a\u0018\b\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00050\b\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u00072\u0006\u0010\u000b\u001a\u00020\f2\b\b\u0002\u0010\r\u001a\u00020\u000eH\u0086@ø\u0001\u0000¢\u0006\u0002\u0010\u000fJZ\u0010\u0010\u001a\u00020\u0011\"\u0004\b\u0000\u0010\u00052\u001c\u0010\u0006\u001a\u0018\b\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00050\b\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u00072\u0012\u0010\u0012\u001a\u000e\u0012\u0004\u0012\u0002H\u0005\u0012\u0004\u0012\u00020\u00130\u00072\u0012\u0010\u0014\u001a\u000e\u0012\u0004\u0012\u00020\u0015\u0012\u0004\u0012\u00020\u00130\u0007ø\u0001\u0000¢\u0006\u0002\u0010\u0016J>\u0010\u0017\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00050\u00040\u0018\"\u0004\b\u0000\u0010\u00052\u001c\u0010\u0006\u001a\u0018\b\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00050\b\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u0007ø\u0001\u0000¢\u0006\u0002\u0010\u0019Jb\u0010\u001a\u001a\u00020\u0013\"\u0004\b\u0000\u0010\u00052\u0006\u0010\u001b\u001a\u00020\u001c2\u001c\u0010\u0006\u001a\u0018\b\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00050\b\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u00072\u0012\u0010\u0012\u001a\u000e\u0012\u0004\u0012\u0002H\u0005\u0012\u0004\u0012\u00020\u00130\u00072\u0012\u0010\u0014\u001a\u000e\u0012\u0004\u0012\u00020\u0015\u0012\u0004\u0012\u00020\u00130\u0007ø\u0001\u0000¢\u0006\u0002\u0010\u001dJO\u0010\u001e\u001a\b\u0012\u0004\u0012\u0002H\u00050\u0004\"\u0004\b\u0000\u0010\u00052\u001c\u0010\u0006\u001a\u0018\b\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00050\b\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u00072\b\b\u0002\u0010\u001f\u001a\u00020 2\b\b\u0002\u0010!\u001a\u00020\u000eH\u0086@ø\u0001\u0000¢\u0006\u0002\u0010\"JE\u0010#\u001a\b\u0012\u0004\u0012\u0002H\u00050\u0004\"\u0004\b\u0000\u0010\u00052\u001c\u0010\u0006\u001a\u0018\b\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00050\b\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u00072\b\b\u0002\u0010$\u001a\u00020\u000eH\u0086@ø\u0001\u0000¢\u0006\u0002\u0010%\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006&"}, d2 = {"Lcom/obric/repo/core/DataRequestHandler;", "", "()V", "executeRequest", "Lcom/obric/repo/core/Result;", ExifInterface.GPS_DIRECTION_TRUE, Ext.KEY_REQUEST, "Lkotlin/Function1;", "Lkotlin/coroutines/Continuation;", "(Lkotlin/jvm/functions/Function1;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "executeRequestWithCache", "cacheKey", "", "cacheTimeMs", "", "(Lkotlin/jvm/functions/Function1;Ljava/lang/String;JLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "executeRequestWithCancelable", "Lkotlinx/coroutines/Job;", "onSuccess", "", "onError", "Lcom/obric/repo/core/Result$Error;", "(Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;)Lkotlinx/coroutines/Job;", "executeRequestWithFlow", "Lkotlinx/coroutines/flow/Flow;", "(Lkotlin/jvm/functions/Function1;)Lkotlinx/coroutines/flow/Flow;", "executeRequestWithLifecycle", "lifecycleScope", "Lkotlinx/coroutines/CoroutineScope;", "(Lkotlinx/coroutines/CoroutineScope;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;)V", "executeRequestWithRetry", "maxRetries", "", "delayMs", "(Lkotlin/jvm/functions/Function1;IJLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "executeRequestWithTimeout", "timeoutMs", "(Lkotlin/jvm/functions/Function1;JLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "app_QssiCnRelease"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class DataRequestHandler {
    public static final DataRequestHandler INSTANCE = null;

    /* JADX INFO: renamed from: com.obric.repo.core.DataRequestHandler$executeRequest$1, reason: invalid class name */
    /* JADX INFO: compiled from: DataRequestHandler.kt */
    @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
    @DebugMetadata(c = "com.obric.repo.core.DataRequestHandler", f = "DataRequestHandler.kt", i = {}, l = {27}, m = "executeRequest", n = {}, s = {})
    static final class AnonymousClass1<T> extends ContinuationImpl {
        int label;
        /* synthetic */ Object result;
        final /* synthetic */ DataRequestHandler this$0;

        AnonymousClass1(DataRequestHandler r1, Continuation<? super AnonymousClass1> r2) {
            this.this$0 = r1;
            super(r2);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object r2) {
            this.result = r2;
            this.label |= Integer.MIN_VALUE;
            return this.this$0.executeRequest(null, this);
        }
    }

    /* JADX INFO: renamed from: com.obric.repo.core.DataRequestHandler$executeRequestWithCache$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: DataRequestHandler.kt */
    @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
    @DebugMetadata(c = "com.obric.repo.core.DataRequestHandler", f = "DataRequestHandler.kt", i = {0}, l = {158}, m = "executeRequestWithCache", n = {"cacheKey"}, s = {"L$0"})
    static final class C03811<T> extends ContinuationImpl {
        Object L$0;
        int label;
        /* synthetic */ Object result;
        final /* synthetic */ DataRequestHandler this$0;

        C03811(DataRequestHandler r1, Continuation<? super C03811> r2) {
            this.this$0 = r1;
            super(r2);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object r7) {
            this.result = r7;
            this.label |= Integer.MIN_VALUE;
            return this.this$0.executeRequestWithCache(null, null, 0, this);
        }
    }

    /* JADX INFO: renamed from: com.obric.repo.core.DataRequestHandler$executeRequestWithCancelable$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: DataRequestHandler.kt */
    @Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\u00020\u0003H\u008a@"}, d2 = {"<anonymous>", "", ExifInterface.GPS_DIRECTION_TRUE, "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 8, 0}, xi = 48)
    @DebugMetadata(c = "com.obric.repo.core.DataRequestHandler$executeRequestWithCancelable$1", f = "DataRequestHandler.kt", i = {}, l = {70}, m = "invokeSuspend", n = {}, s = {})
    static final class C03821 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ Function1<Result.Error, Unit> $onError;
        final /* synthetic */ Function1<T, Unit> $onSuccess;
        final /* synthetic */ Function1<Continuation<? super T>, Object> $request;
        int label;

        /* JADX WARN: Multi-variable type inference failed */
        C03821(Function1<? super Continuation<? super T>, ? extends Object> r1, Function1<? super T, Unit> r2, Function1<? super Result.Error, Unit> r3, Continuation<? super C03821> r4) {
            this.$request = r1;
            this.$onSuccess = r2;
            this.$onError = r3;
            super(2, r4);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
            return new C03821(this.$request, this.$onSuccess, this.$onError, r4);
        }

        @Override // kotlin.jvm.functions.Function2
        public /* bridge */ /* synthetic */ Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
            return invoke2(r1, r2);
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final Object invoke2(CoroutineScope r1, Continuation<? super Unit> r2) {
            return ((C03821) create(r1, r2)).invokeSuspend(Unit.INSTANCE);
        }

        /* JADX WARN: Type inference incomplete: some casts might be missing */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object r5) {
            Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int r1 = this.label;
            if (r1 == 0) goto L8;
            if (r1 != 1) goto L7;
            ResultKt.throwOnFailure(r5);
        L11:
            Result r6 = (Result) r5;
            if ((r6 instanceof Result.Success) == false) goto L15;
            this.$onSuccess.invoke((T) ((Result.Success) r6).getData());
        L18:
            return Unit.INSTANCE;
        L15:
            if ((r6 instanceof Result.Error) == false) goto L18;
            this.$onError.invoke((Result.Error) r6);
            goto L18
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L8:
            ResultKt.throwOnFailure(r5);
            this.label = 1;
            r5 = DataRequestHandler.INSTANCE.executeRequest(this.$request, this);
            if (r5 != r0) goto L11;
            return r0;
        }
    }

    /* JADX INFO: Add missing generic type declarations: [T] */
    /* JADX INFO: renamed from: com.obric.repo.core.DataRequestHandler$executeRequestWithFlow$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: DataRequestHandler.kt */
    @Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00020\u00040\u0003H\u008a@"}, d2 = {"<anonymous>", "", ExifInterface.GPS_DIRECTION_TRUE, "Lkotlinx/coroutines/flow/FlowCollector;", "Lcom/obric/repo/core/Result;"}, k = 3, mv = {1, 8, 0}, xi = 48)
    @DebugMetadata(c = "com.obric.repo.core.DataRequestHandler$executeRequestWithFlow$1", f = "DataRequestHandler.kt", i = {0}, l = {87, 88}, m = "invokeSuspend", n = {"$this$flow"}, s = {"L$0"})
    static final class C03831<T> extends SuspendLambda implements Function2<FlowCollector<? super Result<? extends T>>, Continuation<? super Unit>, Object> {
        final /* synthetic */ Function1<Continuation<? super T>, Object> $request;
        private /* synthetic */ Object L$0;
        int label;

        /* JADX WARN: Multi-variable type inference failed */
        C03831(Function1<? super Continuation<? super T>, ? extends Object> r1, Continuation<? super C03831> r2) {
            this.$request = r1;
            super(2, r2);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object r2, Continuation<?> r3) {
            C03831 r0 = new C03831(this.$request, r3);
            r0.L$0 = r2;
            return r0;
        }

        @Override // kotlin.jvm.functions.Function2
        public /* bridge */ /* synthetic */ Object invoke(Object r1, Continuation<? super Unit> r2) {
            return invoke((FlowCollector) r1, r2);
        }

        public final Object invoke(FlowCollector<? super Result<? extends T>> r1, Continuation<? super Unit> r2) {
            return ((C03831) create(r1, r2)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object r7) {
            Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int r1 = this.label;
            if (r1 == 0) goto L10;
            if (r1 == 1) goto L9;
            if (r1 != 2) goto L8;
            ResultKt.throwOnFailure(r7);
        L17:
            return Unit.INSTANCE;
        L8:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L9:
            FlowCollector r2 = (FlowCollector) this.L$0;
            ResultKt.throwOnFailure(r7);
        L13:
            this.L$0 = null;
            this.label = 2;
            if (r2.emit((Result) r7, this) != r0) goto L17;
            return r0;
        L10:
            ResultKt.throwOnFailure(r7);
            r2 = (FlowCollector) this.L$0;
            this.L$0 = r2;
            this.label = 1;
            r7 = DataRequestHandler.INSTANCE.executeRequest(this.$request, this);
            if (r7 != r0) goto L13;
            return r0;
        }
    }

    /* JADX INFO: renamed from: com.obric.repo.core.DataRequestHandler$executeRequestWithLifecycle$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: DataRequestHandler.kt */
    @Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\u00020\u0003H\u008a@"}, d2 = {"<anonymous>", "", ExifInterface.GPS_DIRECTION_TRUE, "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 8, 0}, xi = 48)
    @DebugMetadata(c = "com.obric.repo.core.DataRequestHandler$executeRequestWithLifecycle$1", f = "DataRequestHandler.kt", i = {}, l = {49}, m = "invokeSuspend", n = {}, s = {})
    static final class C03841 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ Function1<Result.Error, Unit> $onError;
        final /* synthetic */ Function1<T, Unit> $onSuccess;
        final /* synthetic */ Function1<Continuation<? super T>, Object> $request;
        int label;

        /* JADX WARN: Multi-variable type inference failed */
        C03841(Function1<? super Continuation<? super T>, ? extends Object> r1, Function1<? super T, Unit> r2, Function1<? super Result.Error, Unit> r3, Continuation<? super C03841> r4) {
            this.$request = r1;
            this.$onSuccess = r2;
            this.$onError = r3;
            super(2, r4);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
            return new C03841(this.$request, this.$onSuccess, this.$onError, r4);
        }

        @Override // kotlin.jvm.functions.Function2
        public /* bridge */ /* synthetic */ Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
            return invoke2(r1, r2);
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final Object invoke2(CoroutineScope r1, Continuation<? super Unit> r2) {
            return ((C03841) create(r1, r2)).invokeSuspend(Unit.INSTANCE);
        }

        /* JADX WARN: Type inference incomplete: some casts might be missing */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object r5) {
            Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int r1 = this.label;
            if (r1 == 0) goto L8;
            if (r1 != 1) goto L7;
            ResultKt.throwOnFailure(r5);
        L11:
            Result r6 = (Result) r5;
            if ((r6 instanceof Result.Success) == false) goto L15;
            this.$onSuccess.invoke((T) ((Result.Success) r6).getData());
        L18:
            return Unit.INSTANCE;
        L15:
            if ((r6 instanceof Result.Error) == false) goto L18;
            this.$onError.invoke((Result.Error) r6);
            goto L18
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L8:
            ResultKt.throwOnFailure(r5);
            this.label = 1;
            r5 = DataRequestHandler.INSTANCE.executeRequest(this.$request, this);
            if (r5 != r0) goto L11;
            return r0;
        }
    }

    /* JADX INFO: renamed from: com.obric.repo.core.DataRequestHandler$executeRequestWithRetry$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: DataRequestHandler.kt */
    @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
    @DebugMetadata(c = "com.obric.repo.core.DataRequestHandler", f = "DataRequestHandler.kt", i = {0, 0, 0, 0, 1, 1, 1}, l = {109, 115}, m = "executeRequestWithRetry", n = {Ext.KEY_REQUEST, "delayMs", "actualRetries", "attempt", Ext.KEY_REQUEST, "delayMs", "actualRetries"}, s = {"L$0", "J$0", "I$0", "I$2", "L$0", "J$0", "I$0"})
    static final class C03851<T> extends ContinuationImpl {
        int I$0;
        int I$1;
        int I$2;
        long J$0;
        Object L$0;
        int label;
        /* synthetic */ Object result;
        final /* synthetic */ DataRequestHandler this$0;

        C03851(DataRequestHandler r1, Continuation<? super C03851> r2) {
            this.this$0 = r1;
            super(r2);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object r7) {
            this.result = r7;
            this.label |= Integer.MIN_VALUE;
            return this.this$0.executeRequestWithRetry(null, 0, 0, this);
        }
    }

    /* JADX INFO: Add missing generic type declarations: [T] */
    /* JADX INFO: renamed from: com.obric.repo.core.DataRequestHandler$executeRequestWithTimeout$2, reason: invalid class name */
    /* JADX INFO: compiled from: DataRequestHandler.kt */
    @Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\u00020\u0003H\u008a@"}, d2 = {"<anonymous>", "Lcom/obric/repo/core/Result;", ExifInterface.GPS_DIRECTION_TRUE, "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 8, 0}, xi = 48)
    @DebugMetadata(c = "com.obric.repo.core.DataRequestHandler$executeRequestWithTimeout$2", f = "DataRequestHandler.kt", i = {}, l = {134}, m = "invokeSuspend", n = {}, s = {})
    static final class AnonymousClass2<T> extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Result<? extends T>>, Object> {
        final /* synthetic */ Function1<Continuation<? super T>, Object> $request;
        int label;

        /* JADX WARN: Multi-variable type inference failed */
        AnonymousClass2(Function1<? super Continuation<? super T>, ? extends Object> r1, Continuation<? super AnonymousClass2> r2) {
            this.$request = r1;
            super(2, r2);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object r1, Continuation<?> r2) {
            return new AnonymousClass2(this.$request, r2);
        }

        @Override // kotlin.jvm.functions.Function2
        public /* bridge */ /* synthetic */ Object invoke(CoroutineScope r1, Object r2) {
            return invoke(r1, (Continuation) r2);
        }

        public final Object invoke(CoroutineScope r1, Continuation<? super Result<? extends T>> r2) {
            return ((AnonymousClass2) create(r1, r2)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object r5) {
            Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int r1 = this.label;
            if (r1 == 0) goto L8;
            if (r1 != 1) goto L7;
            ResultKt.throwOnFailure(r5);
        L11:
            return r5;
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L8:
            ResultKt.throwOnFailure(r5);
            this.label = 1;
            r5 = DataRequestHandler.INSTANCE.executeRequest(this.$request, this);
            if (r5 != r0) goto L11;
            return r0;
        }
    }

    static {
        INSTANCE = new DataRequestHandler();
    }

    private DataRequestHandler() {
    }

    public final <T> Object executeRequest(Function1<? super Continuation<? super T>, ? extends Object> r6, Continuation<? super Result<? extends T>> r7) {
        if ((r7 instanceof AnonymousClass1) == false) goto L7;
        AnonymousClass1 r0 = (AnonymousClass1) r7;
        if ((r0.label & Integer.MIN_VALUE) == 0) goto L7;
        r0.label -= Integer.MIN_VALUE;
    L8:
        Object r8 = r0.result;
        Object r1 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r2 = r0.label;
        if (r2 == 0) goto L15;
        if (r2 != 1) goto L14;
        ResultKt.throwOnFailure(r8);     // Catch: Throwable -> L21
    L19:
        Object r5 = kotlin.Result.m803constructorimpl(new Result.Success(r8));     // Catch: Throwable -> L21
    L23:
        Throwable r9 = kotlin.Result.m806exceptionOrNullimpl(r5);
        if (r9 != null) goto L27;
        return r5;
    L27:
        return new Result.Error(null, null, r9);
    L14:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L15:
        ResultKt.throwOnFailure(r8);
        kotlin.Result.Companion r10 = kotlin.Result.Companion;     // Catch: Throwable -> L21
        DataRequestHandler r11 = this;     // Catch: Throwable -> L21
        CoroutineDispatcher r12 = Dispatchers.getIO();     // Catch: Throwable -> L21
        DataRequestHandler$executeRequest$2$result$1 r13 = new DataRequestHandler$executeRequest$2$result$1(r6, null);     // Catch: Throwable -> L21
        r0.label = 1;     // Catch: Throwable -> L21
        r8 = BuildersKt.withContext(r12, r13, r0);     // Catch: Throwable -> L21
        if (r8 != r1) goto L19;
        return r1;
    L21:
        th = move-exception;
        kotlin.Result.Companion r14 = kotlin.Result.Companion;
        r5 = kotlin.Result.m803constructorimpl(ResultKt.createFailure(th));
    L7:
        r0 = new AnonymousClass1(this, r7);
        goto L8
    }

    public final <T> void executeRequestWithLifecycle(CoroutineScope r7, Function1<? super Continuation<? super T>, ? extends Object> r8, Function1<? super T, Unit> r9, Function1<? super Result.Error, Unit> r10) {
        Intrinsics.checkNotNullParameter(r7, "lifecycleScope");
        Intrinsics.checkNotNullParameter(r8, Ext.KEY_REQUEST);
        Intrinsics.checkNotNullParameter(r9, "onSuccess");
        Intrinsics.checkNotNullParameter(r10, "onError");
        BuildersKt.launch$default(r7, null, null, new C03841(r8, r9, r10, null), 3, null);
    }

    public final <T> Job executeRequestWithCancelable(Function1<? super Continuation<? super T>, ? extends Object> r7, Function1<? super T, Unit> r8, Function1<? super Result.Error, Unit> r9) {
        Intrinsics.checkNotNullParameter(r7, Ext.KEY_REQUEST);
        Intrinsics.checkNotNullParameter(r8, "onSuccess");
        Intrinsics.checkNotNullParameter(r9, "onError");
        return BuildersKt.launch$default(CoroutineScopeKt.CoroutineScope(Dispatchers.getMain()), null, null, new C03821(r7, r8, r9, null), 3, null);
    }

    public final <T> Flow<Result<T>> executeRequestWithFlow(Function1<? super Continuation<? super T>, ? extends Object> r2) {
        Intrinsics.checkNotNullParameter(r2, Ext.KEY_REQUEST);
        return FlowKt.flowOn(FlowKt.flow(new C03831(r2, null)), Dispatchers.getMain());
    }

    public static /* synthetic */ Object executeRequestWithRetry$default(DataRequestHandler r6, Function1 r7, int r8, long r9, Continuation r11, int r12, Object r13) {
        if ((r12 & 2) == 0) goto L5;
        r8 = 3;
    L5:
        int r2 = r8;
        if ((r12 & 4) == 0) goto L9;
        r9 = 1000;
    L9:
        return r6.executeRequestWithRetry(r7, r2, r9, r11);
    }

    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:33:0x00ab -> B:43:0x00d8). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:41:0x00cc -> B:42:0x00d2). Please report as a decompilation issue!!! */
    public final <T> Object executeRequestWithRetry(Function1<? super Continuation<? super T>, ? extends Object> r10, int r11, long r12, Continuation<? super Result<? extends T>> r14) {
        if ((r14 instanceof C03851) == false) goto L7;
        C03851 r0 = (C03851) r14;
        if ((r0.label & Integer.MIN_VALUE) == 0) goto L7;
        r0.label -= Integer.MIN_VALUE;
    L8:
        Object r9 = r0.result;
        Object r15 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r1 = r0.label;
        if (r1 == 0) goto L20;
        if (r1 == 1) goto L15;
        if (r1 != 2) goto L14;
        int r13 = r0.I$1;
        int r16 = r0.I$0;
        long r17 = r0.J$0;
        Function1<? super Continuation<? super T>, ? extends Object> r2 = (Function1) r0.L$0;
        ResultKt.throwOnFailure(r9);
    L42:
        Function1<? super Continuation<? super T>, ? extends Object> r18 = r2;
        int r7 = r16;
        int r19 = r13;
        C03851 r110 = r0;
        long r3 = r17;
        int r111 = r7;
    L43:
        int r112 = r19 + 1;
        long r8 = r3;
        r0 = r110;
    L21:
        int r113 = r112;
        Object r114 = r15;
        long r115 = r8;
        if (r113 >= r111) goto L45;
        kotlin.Result.Companion r4 = kotlin.Result.Companion;     // Catch: Throwable -> L29
        CoroutineDispatcher r5 = Dispatchers.getIO();     // Catch: Throwable -> L29
        DataRequestHandler$executeRequestWithRetry$2$1$result$1 r6 = new DataRequestHandler$executeRequestWithRetry$2$1$result$1(r18, null);     // Catch: Throwable -> L29
        r0.L$0 = r18;     // Catch: Throwable -> L29
        r0.J$0 = r115;     // Catch: Throwable -> L29
        r0.I$0 = r111;     // Catch: Throwable -> L29
        r0.I$1 = r113;     // Catch: Throwable -> L29
        r0.I$2 = r113;     // Catch: Throwable -> L29
        r0.label = 1;     // Catch: Throwable -> L29
        Object r20 = BuildersKt.withContext(r5, r6, r0);     // Catch: Throwable -> L29
        if (r20 != r114) goto L26;
        return r114;
    L26:
        long r21 = r115;
        Function1<? super Continuation<? super T>, ? extends Object> r116 = r18;
        r15 = r114;
        r9 = r20;
        r19 = r113;
    L27:
        return new Result.Success(r9);
    L18:
        Throwable th = th;
        C03851 r22 = r0;
        Object r23 = r15;
        long r24 = r21;
        Function1<? super Continuation<? super T>, ? extends Object> r25 = r116;
        r115 = r24;
    L31:
        kotlin.Result.Companion r26 = kotlin.Result.Companion;
        Throwable r27 = kotlin.Result.m806exceptionOrNullimpl(kotlin.Result.m803constructorimpl(ResultKt.createFailure(th)));
        if (r27 != null) goto L35;
        r110 = r22;
        r18 = r25;
        r15 = r23;
        r3 = r115;
        goto L43
    L35:
        if (r113 == (r111 - 1)) goto L37;
        r22.L$0 = r25;
        r22.J$0 = r115;
        r22.I$0 = r111;
        r22.I$1 = r19;
        r22.label = 2;
        if (DelayKt.delay(r115, r22) != r23) goto L41;
        return r23;
    L41:
        r13 = r19;
        r16 = r111;
        r17 = r115;
        r15 = r23;
        r0 = r22;
        r2 = r25;
        goto L42
    L37:
        return new Result.Error(null, null, r27);
    L29:
        th = move-exception;
        r25 = r18;
        th = th;
        r22 = r0;
        r23 = r114;
        r19 = r113;
        goto L31
    L45:
        throw new IllegalStateException("Max retries exceeded");
    L14:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L15:
        r113 = r0.I$2;
        r19 = r0.I$1;
        r111 = r0.I$0;
        r21 = r0.J$0;
        r116 = (Function1) r0.L$0;
        ResultKt.throwOnFailure(r9);     // Catch: Throwable -> L18
        goto L27
    L20:
        ResultKt.throwOnFailure(r9);
        int r28 = Math.max(1, r11);
        r112 = 0;
        r8 = r12;
        r111 = r28;
        r18 = r10;
    L7:
        r0 = new C03851(this, r14);
        goto L8
    }

    public static /* synthetic */ Object executeRequestWithTimeout$default(DataRequestHandler r0, Function1 r1, long r2, Continuation r4, int r5, Object r6) {
        if ((r5 & 2) == 0) goto L6;
        r2 = 10000;
    L6:
        return r0.executeRequestWithTimeout(r1, r2, r4);
    }

    public final <T> Object executeRequestWithTimeout(Function1<? super Continuation<? super T>, ? extends Object> r2, long r3, Continuation<? super Result<? extends T>> r5) {
        return TimeoutKt.withTimeout(r3, new AnonymousClass2(r2, null), r5);
    }

    public static /* synthetic */ Object executeRequestWithCache$default(DataRequestHandler r6, Function1 r7, String r8, long r9, Continuation r11, int r12, Object r13) {
        if ((r12 & 4) == 0) goto L6;
        r9 = 300000;
    L6:
        return r6.executeRequestWithCache(r7, r8, r9, r11);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final <T> Object executeRequestWithCache(Function1<? super Continuation<? super T>, ? extends Object> r5, String r6, long r7, Continuation<? super Result<? extends T>> r9) {
        if ((r9 instanceof C03811) == false) goto L7;
        C03811 r0 = (C03811) r9;
        if ((r0.label & Integer.MIN_VALUE) == 0) goto L7;
        r0.label -= Integer.MIN_VALUE;
    L8:
        Object r10 = r0.result;
        Object r1 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r2 = r0.label;
        if (r2 == 0) goto L14;
        if (r2 != 1) goto L13;
        r6 = (String) r0.L$0;
        ResultKt.throwOnFailure(r10);
    L23:
        Result r11 = (Result) r10;
        if ((r11 instanceof Result.Success) == false) goto L26;
        CacheManager.INSTANCE.put(r6, ((Result.Success) r11).getData());
    L26:
        return r11;
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r10);
        Object r12 = CacheManager.INSTANCE.get(r6);
        if (r12 != null) goto L17;
    L20:
        r0.L$0 = r6;
        r0.label = 1;
        r10 = executeRequest(r5, r0);
        if (r10 != r1) goto L23;
        return r1;
    L17:
        if (CacheManager.INSTANCE.isExpired(r6, r7) == true) goto L20;
        return new Result.Success(r12);
    L7:
        r0 = new C03811(this, r9);
        goto L8
    }
}
