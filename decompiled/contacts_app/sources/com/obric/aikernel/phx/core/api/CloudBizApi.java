package com.obric.aikernel.phx.core.api;

import android.os.Bundle;
import com.obric.aikernel.AIKBinder;
import com.obric.aikernel.phx.compat.ParamsCompat;
import com.obric.aikernel.phx.sdk.AIKernelManager;
import com.obric.aikernel.phx.sdk.api.AIKernelApi;
import com.obric.aikernel.sdk.config.RequestParams;
import com.obric.aikernel.sdk.ext.BundleExtKt;
import com.obric.aikernel.sdk.response.Response;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowKt;

/* JADX INFO: compiled from: CloudBizApi.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u0000 \u00122\u00020\u0001:\u0001\u0012B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J#\u0010\u0005\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0007\u0018\u00010\u00062\u0006\u0010\b\u001a\u00020\tH\u0096@ø\u0001\u0000¢\u0006\u0002\u0010\nJ)\u0010\u000b\u001a\u0012\u0012\f\u0012\n\u0012\u0006\u0012\u0004\u0018\u00010\u00070\u0006\u0018\u00010\f2\u0006\u0010\b\u001a\u00020\tH\u0096@ø\u0001\u0000¢\u0006\u0002\u0010\nJ!\u0010\r\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00070\u00062\u0006\u0010\u000e\u001a\u00020\u000fH\u0086@ø\u0001\u0000¢\u0006\u0002\u0010\u0010J'\u0010\u0011\u001a\u0010\u0012\f\u0012\n\u0012\u0006\u0012\u0004\u0018\u00010\u00070\u00060\f2\u0006\u0010\u000e\u001a\u00020\u000fH\u0086@ø\u0001\u0000¢\u0006\u0002\u0010\u0010R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006\u0013"}, d2 = {"Lcom/obric/aikernel/phx/core/api/CloudBizApi;", "Lcom/obric/aikernel/phx/core/api/AbsApi;", "bizName", "", "(Ljava/lang/String;)V", "infer", "Lcom/obric/aikernel/sdk/response/Response;", "", "params", "Lcom/obric/aikernel/sdk/config/RequestParams;", "(Lcom/obric/aikernel/sdk/config/RequestParams;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "inferAsFlow", "Lkotlinx/coroutines/flow/Flow;", "inference", "args", "Landroid/os/Bundle;", "(Landroid/os/Bundle;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "inferenceAsFlow", "Companion", "sdk_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class CloudBizApi extends AbsApi {
    public static final Companion Companion = null;
    private static final String TAG = "CloudBizApi";
    private final String bizName;

    /* JADX INFO: compiled from: CloudBizApi.kt */
    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u0005"}, d2 = {"Lcom/obric/aikernel/phx/core/api/CloudBizApi$Companion;", "", "()V", "TAG", "", "sdk_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker r1) {
            this();
        }

        private Companion() {
        }
    }

    /* JADX INFO: renamed from: com.obric.aikernel.phx.core.api.CloudBizApi$infer$2, reason: invalid class name */
    /* JADX INFO: compiled from: CloudBizApi.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\u0010\u0000\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0002\u0018\u00010\u0001H\u008a@"}, d2 = {"<anonymous>", "Lcom/obric/aikernel/sdk/response/Response;", ""}, k = 3, mv = {1, 7, 1}, xi = 48)
    @DebugMetadata(c = "com.obric.aikernel.phx.core.api.CloudBizApi$infer$2", f = "CloudBizApi.kt", i = {}, l = {20, 20}, m = "invokeSuspend", n = {}, s = {})
    static final class AnonymousClass2 extends SuspendLambda implements Function1<Continuation<? super Response<Object>>, Object> {
        final /* synthetic */ RequestParams $params;
        Object L$0;
        int label;
        final /* synthetic */ CloudBizApi this$0;

        AnonymousClass2(CloudBizApi r1, RequestParams r2, Continuation<? super AnonymousClass2> r3) {
            this.this$0 = r1;
            this.$params = r2;
            super(1, r3);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Continuation<?> r3) {
            return new AnonymousClass2(this.this$0, this.$params, r3);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Object invoke(Continuation<? super Response<Object>> r1) {
            return invoke2(r1);
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final Object invoke2(Continuation<? super Response<Object>> r1) {
            return ((AnonymousClass2) create(r1)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object r7) {
            Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int r1 = this.label;
            if (r1 == 0) goto L10;
            if (r1 == 1) goto L9;
            if (r1 != 2) goto L8;
            ResultKt.throwOnFailure(r7);
        L16:
            return r7;
        L8:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L9:
            CloudBizApi r2 = (CloudBizApi) this.L$0;
            ResultKt.throwOnFailure(r7);
        L13:
            this.L$0 = null;
            this.label = 2;
            r7 = r2.inference((Bundle) r7, this);
            if (r7 != r0) goto L16;
            return r0;
        L10:
            ResultKt.throwOnFailure(r7);
            r2 = this.this$0;
            this.L$0 = r2;
            this.label = 1;
            r7 = ParamsCompat.INSTANCE.startCompat(this.$params, this);
            if (r7 != r0) goto L13;
            return r0;
        }
    }

    /* JADX INFO: renamed from: com.obric.aikernel.phx.core.api.CloudBizApi$inferAsFlow$2, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: CloudBizApi.kt */
    @Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\u0010\u0000\u001a\u0012\u0012\f\u0012\n\u0012\u0006\u0012\u0004\u0018\u00010\u00030\u0002\u0018\u00010\u0001H\u008a@"}, d2 = {"<anonymous>", "Lkotlinx/coroutines/flow/Flow;", "Lcom/obric/aikernel/sdk/response/Response;", ""}, k = 3, mv = {1, 7, 1}, xi = 48)
    @DebugMetadata(c = "com.obric.aikernel.phx.core.api.CloudBizApi$inferAsFlow$2", f = "CloudBizApi.kt", i = {}, l = {25, 25}, m = "invokeSuspend", n = {}, s = {})
    static final class C02282 extends SuspendLambda implements Function1<Continuation<? super Flow<? extends Response<Object>>>, Object> {
        final /* synthetic */ RequestParams $params;
        Object L$0;
        int label;
        final /* synthetic */ CloudBizApi this$0;

        C02282(CloudBizApi r1, RequestParams r2, Continuation<? super C02282> r3) {
            this.this$0 = r1;
            this.$params = r2;
            super(1, r3);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Continuation<?> r3) {
            return new C02282(this.this$0, this.$params, r3);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Object invoke(Continuation<? super Flow<? extends Response<Object>>> r1) {
            return invoke2(r1);
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final Object invoke2(Continuation<? super Flow<Response<Object>>> r1) {
            return ((C02282) create(r1)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object r7) {
            Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int r1 = this.label;
            if (r1 == 0) goto L10;
            if (r1 == 1) goto L9;
            if (r1 != 2) goto L8;
            ResultKt.throwOnFailure(r7);
        L16:
            return r7;
        L8:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L9:
            CloudBizApi r2 = (CloudBizApi) this.L$0;
            ResultKt.throwOnFailure(r7);
        L13:
            this.L$0 = null;
            this.label = 2;
            r7 = r2.inferenceAsFlow((Bundle) r7, this);
            if (r7 != r0) goto L16;
            return r0;
        L10:
            ResultKt.throwOnFailure(r7);
            r2 = this.this$0;
            this.L$0 = r2;
            this.label = 1;
            r7 = ParamsCompat.INSTANCE.startCompat(this.$params, this);
            if (r7 != r0) goto L13;
            return r0;
        }
    }

    /* JADX INFO: renamed from: com.obric.aikernel.phx.core.api.CloudBizApi$inference$1, reason: invalid class name */
    /* JADX INFO: compiled from: CloudBizApi.kt */
    @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
    @DebugMetadata(c = "com.obric.aikernel.phx.core.api.CloudBizApi", f = "CloudBizApi.kt", i = {0, 0}, l = {32, 34}, m = "inference", n = {"this", "args"}, s = {"L$0", "L$1"})
    static final class AnonymousClass1 extends ContinuationImpl {
        Object L$0;
        Object L$1;
        int label;
        /* synthetic */ Object result;
        final /* synthetic */ CloudBizApi this$0;

        AnonymousClass1(CloudBizApi r1, Continuation<? super AnonymousClass1> r2) {
            this.this$0 = r1;
            super(r2);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object r2) {
            this.result = r2;
            this.label |= Integer.MIN_VALUE;
            return this.this$0.inference(null, this);
        }
    }

    /* JADX INFO: renamed from: com.obric.aikernel.phx.core.api.CloudBizApi$inferenceAsFlow$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: CloudBizApi.kt */
    @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
    @DebugMetadata(c = "com.obric.aikernel.phx.core.api.CloudBizApi", f = "CloudBizApi.kt", i = {0, 0}, l = {45}, m = "inferenceAsFlow", n = {"this", "args"}, s = {"L$0", "L$1"})
    static final class C02291 extends ContinuationImpl {
        Object L$0;
        Object L$1;
        int label;
        /* synthetic */ Object result;
        final /* synthetic */ CloudBizApi this$0;

        C02291(CloudBizApi r1, Continuation<? super C02291> r2) {
            this.this$0 = r1;
            super(r2);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object r2) {
            this.result = r2;
            this.label |= Integer.MIN_VALUE;
            return this.this$0.inferenceAsFlow(null, this);
        }
    }

    static {
        Companion = new Companion(null);
    }

    public CloudBizApi(String r2) {
        Intrinsics.checkNotNullParameter(r2, "bizName");
        this.bizName = r2;
    }

    @Override // com.obric.aikernel.phx.sdk.api.IBaseModel
    public Object infer(RequestParams r9, Continuation<? super Response<Object>> r10) {
        return AIKernelApi.wrapApiCall$default(AIKernelManager.INSTANCE.getInstance$sdk_release(), r9, null, new AnonymousClass2(this, r9, null), r10, 2, null);
    }

    @Override // com.obric.aikernel.phx.sdk.api.IBaseModel
    public Object inferAsFlow(RequestParams r9, Continuation<? super Flow<Response<Object>>> r10) {
        return AIKernelApi.wrapApiCall$default(AIKernelManager.INSTANCE.getInstance$sdk_release(), r9, null, new C02282(this, r9, null), r10, 2, null);
    }

    public final Object inference(Bundle r19, Continuation<? super Response<Object>> r20) {
        CloudBizApi r0 = this;
        Bundle r1 = r19;
        if ((r20 instanceof AnonymousClass1) == false) goto L7;
        AnonymousClass1 r3 = (AnonymousClass1) r20;
        if ((r3.label & Integer.MIN_VALUE) == 0) goto L7;
        r3.label -= Integer.MIN_VALUE;
    L8:
        Object r2 = r3.result;
        Object r4 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r5 = r3.label;
        if (r5 == 0) goto L16;
        if (r5 == 1) goto L15;
        if (r5 != 2) goto L14;
        ResultKt.throwOnFailure(r2);
    L26:
        return r2;
    L14:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L15:
        Bundle r6 = (Bundle) r3.L$1;
        CloudBizApi r7 = (CloudBizApi) r3.L$0;
        ResultKt.throwOnFailure(r2);
        r1 = r6;
        r0 = r7;
    L19:
        AIKBinder r8 = (AIKBinder) r2;
        if (r8 == null) goto L22;
        AnonymousClass3 r9 = AnonymousClass3.INSTANCE;
        r3.L$0 = null;
        r3.L$1 = null;
        r3.label = 2;
        r2 = r0.callModelAsResponse(r8, r1, r9, r3);
        if (r2 != r4) goto L26;
        return r4;
    L22:
        return new Response(102, null, null, false, false, null, null, 126, null);
    L16:
        ResultKt.throwOnFailure(r2);
        BundleExtKt.setBizCall(r1, r0.bizName, TAG, "inference").putBoolean("_UseCloud", true);
        r3.L$0 = r0;
        r3.L$1 = r1;
        r3.label = 1;
        r2 = r0.getBinder(r3);
        if (r2 != r4) goto L19;
        return r4;
    L7:
        r3 = new AnonymousClass1(r0, r20);
        goto L8
    }

    public final Object inferenceAsFlow(Bundle r6, Continuation<? super Flow<Response<Object>>> r7) {
        if ((r7 instanceof C02291) == false) goto L7;
        C02291 r0 = (C02291) r7;
        if ((r0.label & Integer.MIN_VALUE) == 0) goto L7;
        r0.label -= Integer.MIN_VALUE;
    L8:
        Object r8 = r0.result;
        Object r1 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r2 = r0.label;
        if (r2 == 0) goto L14;
        if (r2 != 1) goto L13;
        r6 = (Bundle) r0.L$1;
        CloudBizApi this = (CloudBizApi) r0.L$0;
        ResultKt.throwOnFailure(r8);
    L17:
        AIKBinder r9 = (AIKBinder) r8;
        if (r9 == null) goto L20;
        final Flow<Bundle> r5 = this.callModelAsFlow(r9, r6);
        return new CloudBizApi$inferenceAsFlow$$inlined$map$1(r5);
    L20:
        return FlowKt.flow(new CloudBizApi$inferenceAsFlow$binder$1(null));
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r8);
        Bundle r10 = BundleExtKt.setBizCall(r6, this.bizName, TAG, "inferenceAsFlow");
        r10.putBoolean("_UseCloud", true);
        r10.putBoolean("_SC", true);
        r0.L$0 = this;
        r0.L$1 = r6;
        r0.label = 1;
        r8 = getBinder(r0);
        if (r8 != r1) goto L17;
        return r1;
    L7:
        r0 = new C02291(this, r7);
        goto L8
    }
}
