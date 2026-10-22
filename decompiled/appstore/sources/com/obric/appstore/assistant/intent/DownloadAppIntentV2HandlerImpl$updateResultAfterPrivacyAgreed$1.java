package com.obric.appstore.assistant.intent;

import com.bytedanceos.common.ad.common.AdConstant;
import com.bytedanceos.common.privacy.PrivacyUtils;
import com.bytedanceos.common.toolbox.j;
import com.obric.capabilitykit.AtomicCapabilitySdk;
import com.obric.capabilitykit.common.Ext;
import com.obric.capabilitykit.common.intent.IntentResult;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.c;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.a;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.q;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.TimeoutKt;
import kotlinx.coroutines.flow.SharedFlow;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 9, 0}, xi = 48)
@DebugMetadata(c = "com.obric.appstore.assistant.intent.DownloadAppIntentV2HandlerImpl$updateResultAfterPrivacyAgreed$1", f = "DownloadAppIntentV2HandlerImpl.kt", i = {}, l = {117}, m = "invokeSuspend", n = {}, s = {})
public final class DownloadAppIntentV2HandlerImpl$updateResultAfterPrivacyAgreed$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ Map<String, String> $ext;
    final /* synthetic */ Long $questionId;
    int label;

    /* JADX INFO: renamed from: com.obric.appstore.assistant.intent.DownloadAppIntentV2HandlerImpl$updateResultAfterPrivacyAgreed$1$1, reason: invalid class name */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0001*\u00020\u0000H\u008a@¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "Lcom/bytedanceos/common/privacy/PrivacyUtils$a;", "<anonymous>", "(Lkotlinx/coroutines/CoroutineScope;)Lcom/bytedanceos/common/privacy/PrivacyUtils$a;"}, k = 3, mv = {1, 9, 0})
    @DebugMetadata(c = "com.obric.appstore.assistant.intent.DownloadAppIntentV2HandlerImpl$updateResultAfterPrivacyAgreed$1$1", f = "DownloadAppIntentV2HandlerImpl.kt", i = {}, l = {118}, m = "invokeSuspend", n = {}, s = {})
    public static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super PrivacyUtils.a>, Object> {
        int label;

        public AnonymousClass1(Continuation<? super AnonymousClass1> r10) {
            super(2, r10);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @NotNull
        public final Continuation<Unit> create(@Nullable Object r10, @NotNull Continuation<?> r11) {
            return new AnonymousClass1(r11);
        }

        @Override // kotlin.jvm.functions.Function2
        /* JADX INFO: renamed from: invoke */
        public /* bridge */ /* synthetic */ Object mo0invoke(CoroutineScope r10, Continuation<? super PrivacyUtils.a> r11) {
            return invoke2(r10, r11);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @Nullable
        public final Object invokeSuspend(@NotNull Object r10) {
            Object r11 = a.d();
            int r12 = this.label;
            if (r12 == 0) goto L8;
            if (r12 != 1) goto L7;
            c.b(r10);
        L11:
            return r10;
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L8:
            c.b(r10);
            SharedFlow r13 = PrivacyUtils.f9901a.l();
            this.label = 1;
            r10 = kotlinx.coroutines.flow.c.w(r13, this);
            if (r10 != r11) goto L11;
            return r11;
        }

        @Nullable
        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final Object invoke2(@NotNull CoroutineScope r10, @Nullable Continuation<? super PrivacyUtils.a> r11) {
            return ((AnonymousClass1) create(r10, r11)).invokeSuspend(Unit.f21064a);
        }
    }

    public DownloadAppIntentV2HandlerImpl$updateResultAfterPrivacyAgreed$1(Long r10, Map<String, String> r11, Continuation<? super DownloadAppIntentV2HandlerImpl$updateResultAfterPrivacyAgreed$1> r12) {
        this.$questionId = r10;
        this.$ext = r11;
        super(2, r12);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @NotNull
    public final Continuation<Unit> create(@Nullable Object r10, @NotNull Continuation<?> r11) {
        return new DownloadAppIntentV2HandlerImpl$updateResultAfterPrivacyAgreed$1(this.$questionId, this.$ext, r11);
    }

    @Override // kotlin.jvm.functions.Function2
    /* JADX INFO: renamed from: invoke */
    public /* bridge */ /* synthetic */ Object mo0invoke(CoroutineScope r10, Continuation<? super Unit> r11) {
        return invoke2(r10, r11);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @Nullable
    public final Object invokeSuspend(@NotNull Object r15) {
        Object r10 = a.d();
        int r11 = this.label;
        if (r11 == 0) goto L8;
        if (r11 != 1) goto L7;
        c.b(r15);
    L11:
        PrivacyUtils.a r16 = (PrivacyUtils.a) r15;
        if (q.b(r16, PrivacyUtils.a.C0130a.f9906a) == false) goto L15;
        j.n("[AI_Intent] [DownloadApp][V2] update result after privacy agreed");
        AtomicCapabilitySdk r12 = AtomicCapabilitySdk.INSTANCE;
        ConcurrentHashMap r13 = new ConcurrentHashMap();
        r13.put(Ext.KEY_PRIVACY_STATEMENT_AGREED, "1");
        Unit r17 = Unit.f21064a;
        r12.updateIntentResult(new IntentResult(0, null, null, null, false, false, 0, null, null, r13, 510, null), this.$questionId.longValue(), false, this.$ext);
    L20:
        return Unit.f21064a;
    L15:
        if (q.b(r16, PrivacyUtils.a.b.f9907a) == false) goto L17;
        j.n("[AI_Intent] [DownloadApp][V2] privacy agreement canceled");
        goto L20
    L17:
        if (r16 != null) goto L20;
        j.n("[AI_Intent] [DownloadApp][V2] privacy agreement interaction is null");
        goto L20
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        c.b(r15);
        AnonymousClass1 r18 = new AnonymousClass1(null);
        this.label = 1;
        r15 = TimeoutKt.d(AdConstant.SPLASH_AD_INTERVAL, r18, this);
        if (r15 != r10) goto L11;
        return r10;
    }

    @Nullable
    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(@NotNull CoroutineScope r10, @Nullable Continuation<? super Unit> r11) {
        return ((DownloadAppIntentV2HandlerImpl$updateResultAfterPrivacyAgreed$1) create(r10, r11)).invokeSuspend(Unit.f21064a);
    }
}
