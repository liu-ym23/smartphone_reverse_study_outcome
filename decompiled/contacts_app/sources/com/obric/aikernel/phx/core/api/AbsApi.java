package com.obric.aikernel.phx.core.api;

import android.os.Bundle;
import androidx.exifinterface.media.ExifInterface;
import com.obric.aikernel.AIKBinder;
import com.obric.aikernel.core.data.IdlKeys;
import com.obric.aikernel.core.log.AIKLog;
import com.obric.aikernel.phx.compat.ParamsCompat;
import com.obric.aikernel.phx.core.conn.BinderMonitor;
import com.obric.aikernel.phx.sdk.AIKernelManager;
import com.obric.aikernel.phx.sdk.api.AIKernelApi;
import com.obric.aikernel.phx.sdk.api.IBaseModel;
import com.obric.aikernel.sdk.ExtsKt;
import com.obric.aikernel.sdk.config.RequestParams;
import com.obric.aikernel.sdk.ext.BundleExtKt;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.DebugProbesKt;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlinx.coroutines.CancellableContinuationImpl;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.channels.ProduceKt;
import kotlinx.coroutines.channels.ProducerScope;
import kotlinx.coroutines.channels.SendChannel;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowKt;

/* JADX INFO: compiled from: AbsApi.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\b&\u0018\u0000 \u00192\u00020\u0001:\u0001\u0019B\u0005¢\u0006\u0002\u0010\u0002J\u001c\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u00042\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u0005J;\u0010\t\u001a\u0002H\n\"\u0004\b\u0000\u0010\n2\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u00052\u0012\u0010\u000b\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u0002H\n0\fH\u0086@ø\u0001\u0000¢\u0006\u0002\u0010\rJ\u0013\u0010\u000e\u001a\u0004\u0018\u00010\u0007H\u0096@ø\u0001\u0000¢\u0006\u0002\u0010\u000fJ&\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u00052\f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00050\u0013H\u0002J!\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\u0016\u001a\u00020\u0017H\u0086@ø\u0001\u0000¢\u0006\u0002\u0010\u0018\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006\u001a"}, d2 = {"Lcom/obric/aikernel/phx/core/api/AbsApi;", "Lcom/obric/aikernel/phx/sdk/api/IBaseModel;", "()V", "callModelAsFlow", "Lkotlinx/coroutines/flow/Flow;", "Landroid/os/Bundle;", "binder", "Lcom/obric/aikernel/AIKBinder;", "args", "callModelAsResponse", ExifInterface.GPS_DIRECTION_TRUE, "block", "Lkotlin/Function1;", "(Lcom/obric/aikernel/AIKBinder;Landroid/os/Bundle;Lkotlin/jvm/functions/Function1;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getBinder", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "sendFlowCallMethod", "", "self", "Lkotlinx/coroutines/channels/ProducerScope;", "unload", "", "name", "", "(Lcom/obric/aikernel/AIKBinder;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Companion", "sdk_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public abstract class AbsApi implements IBaseModel {
    public static final Companion Companion = null;
    private static final String TAG = "AbsApi";

    /* JADX INFO: compiled from: AbsApi.kt */
    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u0005"}, d2 = {"Lcom/obric/aikernel/phx/core/api/AbsApi$Companion;", "", "()V", "TAG", "", "sdk_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker r1) {
            this();
        }

        private Companion() {
        }
    }

    /* JADX INFO: renamed from: com.obric.aikernel.phx.core.api.AbsApi$callModelAsFlow$1, reason: invalid class name */
    /* JADX INFO: compiled from: AbsApi.kt */
    @Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\b\u0012\u0004\u0012\u00020\u00030\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/channels/ProducerScope;", "Landroid/os/Bundle;"}, k = 3, mv = {1, 7, 1}, xi = 48)
    @DebugMetadata(c = "com.obric.aikernel.phx.core.api.AbsApi$callModelAsFlow$1", f = "AbsApi.kt", i = {}, l = {44}, m = "invokeSuspend", n = {}, s = {})
    static final class AnonymousClass1 extends SuspendLambda implements Function2<ProducerScope<? super Bundle>, Continuation<? super Unit>, Object> {
        final /* synthetic */ Bundle $args;
        final /* synthetic */ AIKBinder $binder;
        private /* synthetic */ Object L$0;
        int label;
        final /* synthetic */ AbsApi this$0;

        AnonymousClass1(AIKBinder r1, AbsApi r2, Bundle r3, Continuation<? super AnonymousClass1> r4) {
            this.$binder = r1;
            this.this$0 = r2;
            this.$args = r3;
            super(2, r4);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object r4, Continuation<?> r5) {
            AnonymousClass1 r0 = new AnonymousClass1(this.$binder, this.this$0, this.$args, r5);
            r0.L$0 = r4;
            return r0;
        }

        @Override // kotlin.jvm.functions.Function2
        public /* bridge */ /* synthetic */ Object invoke(ProducerScope<? super Bundle> r1, Continuation<? super Unit> r2) {
            return invoke2(r1, r2);
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final Object invoke2(ProducerScope<? super Bundle> r1, Continuation<? super Unit> r2) {
            return ((AnonymousClass1) create(r1, r2)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object r7) {
            Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int r1 = this.label;
            if (r1 == 0) goto L8;
            if (r1 != 1) goto L7;
            ResultKt.throwOnFailure(r7);
        L16:
            return Unit.INSTANCE;
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L8:
            ResultKt.throwOnFailure(r7);
            final ProducerScope r8 = (ProducerScope) this.L$0;
            AIKLog.INSTANCE.i(AbsApi.TAG, "start callModelAsFlow...");
            final Job r2 = BinderMonitor.INSTANCE.monitorTransact(r8.getCoroutineContext(), this.$binder, new AbsApi$callModelAsFlow$1$monitorTask$1(r8));
            if (AbsApi.access$sendFlowCallMethod(this.this$0, this.$binder, this.$args, r8) == true) goto L12;
            if (r2 == null) goto L16;
            Job.DefaultImpls.cancel$default(r2, null, 1, null);
            goto L16
        L12:
            this.label = 1;
            if (ProduceKt.awaitClose(r8, new C00721(r2), this) != r0) goto L16;
            return r0;
        }
    }

    /* JADX INFO: renamed from: com.obric.aikernel.phx.core.api.AbsApi$callModelAsResponse$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: AbsApi.kt */
    @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
    @DebugMetadata(c = "com.obric.aikernel.phx.core.api.AbsApi", f = "AbsApi.kt", i = {0, 0, 0, 0, 0}, l = {122}, m = "callModelAsResponse", n = {"binder", "args", "block", "ctx", "monitorTask"}, s = {"L$0", "L$1", "L$2", "L$3", "L$4"})
    static final class C02251<T> extends ContinuationImpl {
        Object L$0;
        Object L$1;
        Object L$2;
        Object L$3;
        Object L$4;
        int label;
        /* synthetic */ Object result;
        final /* synthetic */ AbsApi this$0;

        C02251(AbsApi r1, Continuation<? super C02251> r2) {
            this.this$0 = r1;
            super(r2);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object r2) {
            this.result = r2;
            this.label |= Integer.MIN_VALUE;
            return this.this$0.callModelAsResponse(null, null, null, this);
        }
    }

    /* JADX INFO: renamed from: com.obric.aikernel.phx.core.api.AbsApi$unload$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: AbsApi.kt */
    @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
    @DebugMetadata(c = "com.obric.aikernel.phx.core.api.AbsApi", f = "AbsApi.kt", i = {0}, l = {109}, m = "unload", n = {"name"}, s = {"L$0"})
    static final class C02271 extends ContinuationImpl {
        Object L$0;
        Object L$1;
        int label;
        /* synthetic */ Object result;
        final /* synthetic */ AbsApi this$0;

        C02271(AbsApi r1, Continuation<? super C02271> r2) {
            this.this$0 = r1;
            super(r2);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object r2) {
            this.result = r2;
            this.label |= Integer.MIN_VALUE;
            return this.this$0.unload(null, null, this);
        }
    }

    static {
        Companion = new Companion(null);
    }

    public Object getBinder(Continuation<? super AIKBinder> r1) {
        return getBinder$suspendImpl(this, r1);
    }

    public AbsApi() {
    }

    public static final /* synthetic */ boolean access$sendFlowCallMethod(AbsApi r0, AIKBinder r1, Bundle r2, ProducerScope r3) {
        return r0.sendFlowCallMethod(r1, r2, r3);
    }

    @Override // com.obric.aikernel.phx.sdk.api.IBaseModel, java.lang.AutoCloseable
    public void close() {
        IBaseModel.DefaultImpls.close(this);
    }

    public final Flow<Bundle> callModelAsFlow(AIKBinder r3, Bundle r4) {
        Intrinsics.checkNotNullParameter(r3, "binder");
        Intrinsics.checkNotNullParameter(r4, "args");
        return FlowKt.callbackFlow(new AnonymousClass1(r3, this, r4, null));
    }

    public final <T> Object callModelAsResponse(AIKBinder r8, Bundle r9, Function1<? super Bundle, ? extends T> r10, Continuation<? super T> r11) {
        if ((r11 instanceof C02251) == false) goto L7;
        C02251 r0 = (C02251) r11;
        if ((r0.label & Integer.MIN_VALUE) == 0) goto L7;
        r0.label -= Integer.MIN_VALUE;
    L8:
        Object r7 = r0.result;
        Object r12 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r1 = r0.label;
        if (r1 == 0) goto L14;
        if (r1 != 1) goto L13;
        Ref.ObjectRef r13 = (Ref.ObjectRef) r0.L$4;
        CoroutineContext r14 = (CoroutineContext) r0.L$3;
        r10 = (Function1) r0.L$2;
        Bundle r15 = (Bundle) r0.L$1;
        AIKBinder r16 = (AIKBinder) r0.L$0;
        ResultKt.throwOnFailure(r7);
    L25:
        Bundle r17 = (Bundle) r7;
        Job r18 = (Job) r13.element;
        if (r18 == null) goto L29;
        Job.DefaultImpls.cancel$default(r18, null, 1, null);
    L29:
        return r10.invoke(r17);
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r7);
        AIKLog.INSTANCE.v(TAG, "start callModelAsResponse " + r9.getString("_M") + ", traceid=" + r9.getString(IdlKeys.Args_TraceId));
        CoroutineContext r19 = r0.getContext();
        Ref.ObjectRef r2 = new Ref.ObjectRef();
        r0.L$0 = r8;
        r0.L$1 = r9;
        r0.L$2 = r10;
        r0.L$3 = r19;
        r0.L$4 = r2;
        r0.label = 1;
        C02251 r3 = r0;
        CancellableContinuationImpl r4 = new CancellableContinuationImpl(IntrinsicsKt.intercepted(r3), 1);
        r4.initCancellability();
        final CancellableContinuationImpl r5 = r4;
        r2.element = (T) BinderMonitor.INSTANCE.monitorTransact(r19, r8, new AbsApi$callModelAsResponse$responseBundle$1$1(r5));     // Catch: Throwable -> L17
        r8.callModel(r9, new AbsApi$callModelAsResponse$responseBundle$1$2(r5));     // Catch: Throwable -> L17
    L19:
        r7 = r4.getResult();
        if (r7 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L22;
        DebugProbesKt.probeCoroutineSuspended(r3);
    L22:
        if (r7 != r12) goto L24;
        return r12;
    L24:
        r13 = r2;
    L17:
        th = move-exception;
        ExtsKt.resume(r5, BundleExtKt.setErr(new Bundle(), 102, th.getMessage()));
    L7:
        r0 = new C02251(this, r11);
        goto L8
    }

    static /* synthetic */ Object getBinder$suspendImpl(AbsApi r6, Continuation<? super AIKBinder> r7) {
        return AIKernelApi.getBinder$default(AIKernelManager.INSTANCE.getInstance$sdk_release(), 0, r7, 1, null);
    }

    private final boolean sendFlowCallMethod(AIKBinder r3, Bundle r4, final ProducerScope<? super Bundle> r5) {
        AIKLog.INSTANCE.i(TAG, "start callModelAsFlow " + r4.getString("_M"));
        r3.callModel(r4, new BinderC02261(r5));     // Catch: Throwable -> L5
        return true;
    L5:
        th = move-exception;
        r5.mo2321trySendJP2dKIU(BundleExtKt.setErr(new Bundle(), 102, th.getMessage()));
        SendChannel.DefaultImpls.close$default(r5, null, 1, null);
        return false;
    }

    public final Object unload(AIKBinder r12, final String r13, Continuation<? super Unit> r14) {
        if ((r14 instanceof C02271) == false) goto L7;
        C02271 r0 = (C02271) r14;
        if ((r0.label & Integer.MIN_VALUE) == 0) goto L7;
        r0.label -= Integer.MIN_VALUE;
    L8:
        Object r11 = r0.result;
        Object r15 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r1 = r0.label;
        if (r1 == 0) goto L14;
        if (r1 != 1) goto L13;
        r12 = (AIKBinder) r0.L$1;
        r13 = (String) r0.L$0;
        ResultKt.throwOnFailure(r11);
    L17:
        r12.callModel(BundleExtKt.commonParams$default((Bundle) r11, r13, IdlKeys.Method_UnloadPackage, "_CallBiz", null, TAG, "unload", null, false, 200, null), new AnonymousClass2(r13));
        return Unit.INSTANCE;
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r11);
        ParamsCompat r16 = ParamsCompat.INSTANCE;
        RequestParams r2 = new RequestParams(null, null, 3, null);
        r0.L$0 = r13;
        r0.L$1 = r12;
        r0.label = 1;
        r11 = r16.startCompat(r2, r0);
        if (r11 != r15) goto L17;
        return r15;
    L7:
        r0 = new C02271(this, r14);
        goto L8
    }
}
