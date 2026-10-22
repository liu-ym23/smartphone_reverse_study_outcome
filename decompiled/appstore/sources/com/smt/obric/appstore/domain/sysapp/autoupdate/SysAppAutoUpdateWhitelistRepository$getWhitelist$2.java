package com.smt.obric.appstore.domain.sysapp.autoupdate;

import java.util.Set;
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

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\u0014\n\u0000\n\u0002\u0010#\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\"\n\u0002\u0018\u0002\u0010\u0000\u001a(\u0012\f\u0012\n \u0003*\u0004\u0018\u00010\u00020\u0002\u0018\u0001 \u0003*\u0012\u0012\f\u0012\n \u0003*\u0004\u0018\u00010\u00020\u0002\u0018\u00010\u00040\u0001*\u00020\u0005H\u008a@"}, d2 = {"<anonymous>", "", "", "kotlin.jvm.PlatformType", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 9, 0}, xi = 48)
@DebugMetadata(c = "com.smt.obric.appstore.domain.sysapp.autoupdate.SysAppAutoUpdateWhitelistRepository$getWhitelist$2", f = "SysAppAutoUpdateWhitelistRepository.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
public final class SysAppAutoUpdateWhitelistRepository$getWhitelist$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Set<String>>, Object> {
    int label;
    final /* synthetic */ SysAppAutoUpdateWhitelistRepository this$0;

    public SysAppAutoUpdateWhitelistRepository$getWhitelist$2(SysAppAutoUpdateWhitelistRepository r10, Continuation<? super SysAppAutoUpdateWhitelistRepository$getWhitelist$2> r11) {
        this.this$0 = r10;
        super(2, r11);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @NotNull
    public final Continuation<Unit> create(@Nullable Object r10, @NotNull Continuation<?> r11) {
        return new SysAppAutoUpdateWhitelistRepository$getWhitelist$2(this.this$0, r11);
    }

    @Override // kotlin.jvm.functions.Function2
    /* JADX INFO: renamed from: invoke */
    public /* bridge */ /* synthetic */ Object mo0invoke(CoroutineScope r10, Continuation<? super Set<String>> r11) {
        return invoke2(r10, r11);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @Nullable
    public final Object invokeSuspend(@NotNull Object r10) {
        kotlin.coroutines.intrinsics.a.d();
        if (this.label != 0) goto L7;
        c.b(r10);
        return SysAppAutoUpdateWhitelistRepository.c(this.this$0).getStringSet("whitelist", null);
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }

    @Nullable
    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(@NotNull CoroutineScope r10, @Nullable Continuation<? super Set<String>> r11) {
        return ((SysAppAutoUpdateWhitelistRepository$getWhitelist$2) create(r10, r11)).invokeSuspend(Unit.f21064a);
    }
}
