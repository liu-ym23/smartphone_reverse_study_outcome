package com.bytedanceos.appstore.datacache;

import com.bytedanceos.common.model.AppInfo;
import com.bytedanceos.common.model.AppInfoKtxKt;
import com.smt.obric.appstore.domain.app.AppInstallActor;
import com.smt.obric.appstore.domain.app.n;
import com.smt.obric.appstore.domain.usecase.app.install.EnqueueAppInstallTaskUseCase;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.c;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 9, 0}, xi = 48)
@DebugMetadata(c = "com.bytedanceos.appstore.datacache.AppStoreCacheKtx$enqueueSysAppAutoUpdate$1", f = "AppStoreCacheKtx.kt", i = {}, l = {65, 66}, m = "invokeSuspend", n = {}, s = {})
public final class AppStoreCacheKtx$enqueueSysAppAutoUpdate$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ AppInfo $appInfo;
    int label;
    final /* synthetic */ AppStoreCacheKtx this$0;

    public AppStoreCacheKtx$enqueueSysAppAutoUpdate$1(AppStoreCacheKtx r10, AppInfo r11, Continuation<? super AppStoreCacheKtx$enqueueSysAppAutoUpdate$1> r12) {
        this.this$0 = r10;
        this.$appInfo = r11;
        super(2, r12);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @NotNull
    public final Continuation<Unit> create(@Nullable Object r10, @NotNull Continuation<?> r11) {
        return new AppStoreCacheKtx$enqueueSysAppAutoUpdate$1(this.this$0, this.$appInfo, r11);
    }

    @Override // kotlin.jvm.functions.Function2
    /* JADX INFO: renamed from: invoke */
    public /* bridge */ /* synthetic */ Object mo0invoke(CoroutineScope r10, Continuation<? super Unit> r11) {
        return invoke2(r10, r11);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @Nullable
    public final Object invokeSuspend(@NotNull Object r12) {
        Object r10 = kotlin.coroutines.intrinsics.a.d();
        int r11 = this.label;
        if (r11 == 0) goto L10;
        if (r11 == 1) goto L9;
        if (r11 != 2) goto L8;
        c.b(r12);
    L17:
        return Unit.f21064a;
    L8:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L9:
        c.b(r12);
    L13:
        EnqueueAppInstallTaskUseCase r13 = new EnqueueAppInstallTaskUseCase(AppInstallActor.f17891n.b());
        he.a r14 = AppInfoKtxKt.newDomainEntity$default(this.$appInfo, null, 1, null);
        AppInfo r15 = this.$appInfo;
        com.smt.obric.appstore.domain.app.entity.a r16 = n.e(r14, r15.mUpdateModel, r15.mSysAppAutoUpdateComplianceMode, null, 4, null);
        this.label = 2;
        if (r13.a(r16, this) != r10) goto L17;
        return r10;
    L10:
        c.b(r12);
        AppStoreCacheKtx r17 = this.this$0;
        this.label = 1;
        if (AppStoreCacheKtx.a(r17, this) != r10) goto L13;
        return r10;
    }

    @Nullable
    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(@NotNull CoroutineScope r10, @Nullable Continuation<? super Unit> r11) {
        return ((AppStoreCacheKtx$enqueueSysAppAutoUpdate$1) create(r10, r11)).invokeSuspend(Unit.f21064a);
    }
}
