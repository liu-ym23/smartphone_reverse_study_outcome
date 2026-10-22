package com.bytedanceos.appstore.utils;

import com.bytedanceos.common.model.AppInfo;
import com.bytedanceos.common.model.AppInfoKtxKt;
import com.smt.obric.appstore.domain.app.AppInstallActor;
import com.smt.obric.appstore.domain.app.n;
import com.smt.obric.appstore.domain.usecase.app.install.EnqueueAppInstallTaskUseCase;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 9, 0}, xi = 48)
@DebugMetadata(c = "com.bytedanceos.appstore.utils.AppStoreCommonUtilKtx$startWiFiDownload$1", f = "AppStoreCommonUtilKtx.kt", i = {}, l = {18}, m = "invokeSuspend", n = {}, s = {})
public final class AppStoreCommonUtilKtx$startWiFiDownload$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ AppInfo $appInfo;
    int label;

    public AppStoreCommonUtilKtx$startWiFiDownload$1(AppInfo r10, Continuation<? super AppStoreCommonUtilKtx$startWiFiDownload$1> r11) {
        this.$appInfo = r10;
        super(2, r11);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @NotNull
    public final Continuation<Unit> create(@Nullable Object r10, @NotNull Continuation<?> r11) {
        return new AppStoreCommonUtilKtx$startWiFiDownload$1(this.$appInfo, r11);
    }

    @Override // kotlin.jvm.functions.Function2
    /* JADX INFO: renamed from: invoke */
    public /* bridge */ /* synthetic */ Object mo0invoke(CoroutineScope r10, Continuation<? super Unit> r11) {
        return invoke2(r10, r11);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @Nullable
    public final Object invokeSuspend(@NotNull Object r11) {
        Object r10 = kotlin.coroutines.intrinsics.a.d();
        int r12 = this.label;
        if (r12 == 0) goto L8;
        if (r12 != 1) goto L7;
        kotlin.c.b(r11);
    L16:
        return Unit.f21064a;
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        kotlin.c.b(r11);
        EnqueueAppInstallTaskUseCase r13 = new EnqueueAppInstallTaskUseCase(AppInstallActor.f17891n.b());
        he.a r14 = AppInfoKtxKt.newDomainEntity$default(this.$appInfo, null, 1, null);
        AppInfo r15 = this.$appInfo;
        int r16 = r15.mUpdateModel;
        if (r16 != 3) goto L11;
        com.smt.obric.appstore.domain.app.entity.a r17 = n.e(r14, r16, r15.mSysAppAutoUpdateComplianceMode, null, 4, null);
    L12:
        this.label = 1;
        if (r13.a(r17, this) != r10) goto L16;
        return r10;
    L11:
        r17 = n.c(r14, true, false, 2, null);
        goto L12
    }

    @Nullable
    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(@NotNull CoroutineScope r10, @Nullable Continuation<? super Unit> r11) {
        return ((AppStoreCommonUtilKtx$startWiFiDownload$1) create(r10, r11)).invokeSuspend(Unit.f21064a);
    }
}
