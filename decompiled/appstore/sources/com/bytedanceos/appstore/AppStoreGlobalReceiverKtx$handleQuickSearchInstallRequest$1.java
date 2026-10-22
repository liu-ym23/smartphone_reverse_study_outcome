package com.bytedanceos.appstore;

import android.net.NetworkInfo;
import com.bytedanceos.common.model.AppInfo;
import com.bytedanceos.common.model.AppInfoKtxKt;
import com.bytedanceos.common.privacy.PrivacyUtils;
import com.bytedanceos.common.toolbox.j;
import com.smt.obric.appstore.domain.app.AppInstallActor;
import com.smt.obric.appstore.domain.app.n;
import com.smt.obric.appstore.domain.usecase.app.install.EnqueueAppInstallTaskUseCase;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.q;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.flow.SharedFlow;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 9, 0}, xi = 48)
@DebugMetadata(c = "com.bytedanceos.appstore.AppStoreGlobalReceiverKtx$handleQuickSearchInstallRequest$1", f = "AppStoreGlobalReceiverKtx.kt", i = {}, l = {46, 73}, m = "invokeSuspend", n = {}, s = {})
public final class AppStoreGlobalReceiverKtx$handleQuickSearchInstallRequest$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ AppInfo $appInfo;
    final /* synthetic */ int $status;
    final /* synthetic */ boolean $waitUserAgreement;
    int label;

    public AppStoreGlobalReceiverKtx$handleQuickSearchInstallRequest$1(boolean r10, int r11, AppInfo r12, Continuation<? super AppStoreGlobalReceiverKtx$handleQuickSearchInstallRequest$1> r13) {
        this.$waitUserAgreement = r10;
        this.$status = r11;
        this.$appInfo = r12;
        super(2, r13);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @NotNull
    public final Continuation<Unit> create(@Nullable Object r10, @NotNull Continuation<?> r11) {
        return new AppStoreGlobalReceiverKtx$handleQuickSearchInstallRequest$1(this.$waitUserAgreement, this.$status, this.$appInfo, r11);
    }

    @Override // kotlin.jvm.functions.Function2
    /* JADX INFO: renamed from: invoke */
    public /* bridge */ /* synthetic */ Object mo0invoke(CoroutineScope r10, Continuation<? super Unit> r11) {
        return invoke2(r10, r11);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @Nullable
    public final Object invokeSuspend(@NotNull Object r10) {
        Object r11 = kotlin.coroutines.intrinsics.a.d();
        int r12 = this.label;
        if (r12 == 0) goto L10;
        if (r12 == 1) goto L9;
        if (r12 != 2) goto L8;
        kotlin.c.b(r10);
    L38:
        return Unit.f21064a;
    L8:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L9:
        kotlin.c.b(r10);
    L15:
        PrivacyUtils.a r13 = (PrivacyUtils.a) r10;
        if (q.b(r13, PrivacyUtils.a.C0130a.f9906a) == false) goto L19;
        j.n("[AppStatus] handleQuickSearchInstallRequest: on PrivacyPolicyUserInteraction.Agree");
    L26:
        if (this.$status != 1) goto L36;
        NetworkInfo r14 = com.bytedanceos.common.toolbox.e.t();
        if (r14 != null) goto L30;
    L32:
        boolean r15 = false;
    L33:
        EnqueueAppInstallTaskUseCase r16 = new EnqueueAppInstallTaskUseCase(AppInstallActor.f17891n.b());
        com.smt.obric.appstore.domain.app.entity.a r17 = n.c(AppInfoKtxKt.newDomainEntity$default(this.$appInfo, null, 1, null), !r15, false, 2, null);
        this.label = 2;
        if (r16.a(r17, this) != r11) goto L38;
        return r11;
    L30:
        if (r14.getType() != 0) goto L32;
        r15 = true;
        goto L33
    L36:
        j.p("[AppStatus] handleQuickSearchInstallRequest: unknown status:" + this.$status);
        goto L38
    L19:
        if (q.b(r13, PrivacyUtils.a.b.f9907a) == false) goto L22;
        j.n("[AppStatus] handleQuickSearchInstallRequest: on PrivacyPolicyUserInteraction.Cancel");
        return Unit.f21064a;
    L22:
        if (r13 != null) goto L26;
        j.n("[AppStatus] handleQuickSearchInstallRequest: on PrivacyPolicyUserInteraction.null");
        return Unit.f21064a;
    L10:
        kotlin.c.b(r10);
        if (this.$waitUserAgreement == false) goto L26;
        j.n("[AppStatus] handleQuickSearchInstallRequest: waitUserAgreement");
        SharedFlow r18 = PrivacyUtils.f9901a.l();
        this.label = 1;
        r10 = kotlinx.coroutines.flow.c.w(r18, this);
        if (r10 != r11) goto L15;
        return r11;
    }

    @Nullable
    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(@NotNull CoroutineScope r10, @Nullable Continuation<? super Unit> r11) {
        return ((AppStoreGlobalReceiverKtx$handleQuickSearchInstallRequest$1) create(r10, r11)).invokeSuspend(Unit.f21064a);
    }
}
