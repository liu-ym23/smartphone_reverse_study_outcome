package com.bytedanceos.appstore.download.service;

import com.bytedanceos.common.model.AppInfo;
import com.bytedanceos.common.model.AppInfoKtxKt;
import com.smt.obric.appstore.domain.app.n;
import com.smt.obric.appstore.domain.usecase.app.install.EnqueueAppInstallTaskUseCase;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.c;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.a;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 9, 0}, xi = 48)
@DebugMetadata(c = "com.bytedanceos.appstore.download.service.AutoUpdateServiceKtx$enqueueWiFiAutoUpdate$1", f = "AutoUpdateServiceKtx.kt", i = {}, l = {24}, m = "invokeSuspend", n = {}, s = {})
public final class AutoUpdateServiceKtx$enqueueWiFiAutoUpdate$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ AppInfo $appInfo;
    int label;
    final /* synthetic */ AutoUpdateServiceKtx this$0;

    public AutoUpdateServiceKtx$enqueueWiFiAutoUpdate$1(AutoUpdateServiceKtx r10, AppInfo r11, Continuation<? super AutoUpdateServiceKtx$enqueueWiFiAutoUpdate$1> r12) {
        this.this$0 = r10;
        this.$appInfo = r11;
        super(2, r12);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @NotNull
    public final Continuation<Unit> create(@Nullable Object r10, @NotNull Continuation<?> r11) {
        return new AutoUpdateServiceKtx$enqueueWiFiAutoUpdate$1(this.this$0, this.$appInfo, r11);
    }

    @Override // kotlin.jvm.functions.Function2
    /* JADX INFO: renamed from: invoke */
    public /* bridge */ /* synthetic */ Object mo0invoke(CoroutineScope r10, Continuation<? super Unit> r11) {
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
    L12:
        return Unit.f21064a;
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        c.b(r10);
        EnqueueAppInstallTaskUseCase r13 = AutoUpdateServiceKtx.a(this.this$0);
        com.smt.obric.appstore.domain.app.entity.a r14 = n.g(AppInfoKtxKt.newDomainEntity$default(this.$appInfo, null, 1, null));
        this.label = 1;
        if (r13.a(r14, this) != r11) goto L12;
        return r11;
    }

    @Nullable
    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(@NotNull CoroutineScope r10, @Nullable Continuation<? super Unit> r11) {
        return ((AutoUpdateServiceKtx$enqueueWiFiAutoUpdate$1) create(r10, r11)).invokeSuspend(Unit.f21064a);
    }
}
