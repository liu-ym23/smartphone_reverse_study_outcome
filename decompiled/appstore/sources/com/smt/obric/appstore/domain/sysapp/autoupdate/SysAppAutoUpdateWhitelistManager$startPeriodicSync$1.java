package com.smt.obric.appstore.domain.sysapp.autoupdate;

import com.bytedanceos.common.ad.common.AdConstant;
import com.bytedanceos.common.toolbox.j;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.c;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.DelayKt;
import kotlinx.coroutines.d0;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 9, 0}, xi = 48)
@DebugMetadata(c = "com.smt.obric.appstore.domain.sysapp.autoupdate.SysAppAutoUpdateWhitelistManager$startPeriodicSync$1", f = "SysAppAutoUpdateWhitelistManager.kt", i = {0}, l = {74}, m = "invokeSuspend", n = {"$this$launch"}, s = {"L$0"})
public final class SysAppAutoUpdateWhitelistManager$startPeriodicSync$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    private /* synthetic */ Object L$0;
    int label;

    public SysAppAutoUpdateWhitelistManager$startPeriodicSync$1(Continuation<? super SysAppAutoUpdateWhitelistManager$startPeriodicSync$1> r10) {
        super(2, r10);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @NotNull
    public final Continuation<Unit> create(@Nullable Object r10, @NotNull Continuation<?> r11) {
        SysAppAutoUpdateWhitelistManager$startPeriodicSync$1 r12 = new SysAppAutoUpdateWhitelistManager$startPeriodicSync$1(r11);
        r12.L$0 = r10;
        return r12;
    }

    @Override // kotlin.jvm.functions.Function2
    /* JADX INFO: renamed from: invoke */
    public /* bridge */ /* synthetic */ Object mo0invoke(CoroutineScope r10, Continuation<? super Unit> r11) {
        return invoke2(r10, r11);
    }

    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:12:0x0034 -> B:14:0x0037). Please report as a decompilation issue!!! */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @Nullable
    public final Object invokeSuspend(@NotNull Object r10) {
        Object r11 = kotlin.coroutines.intrinsics.a.d();
        int r12 = this.label;
        if (r12 == 0) goto L8;
        if (r12 != 1) goto L7;
        CoroutineScope r13 = (CoroutineScope) this.L$0;
        c.b(r10);
    L14:
        j.n("[SysAppAutoUpdateWhitelistManager] periodic sync");
        SysAppAutoUpdateWhitelistManager.b(SysAppAutoUpdateWhitelistManager.f18107a);
    L10:
        if (d0.f(r13) == false) goto L16;
        this.L$0 = r13;
        this.label = 1;
        if (DelayKt.b(AdConstant.SPLASH_AD_INTERVAL, this) != r11) goto L14;
        return r11;
    L16:
        return Unit.f21064a;
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        c.b(r10);
        r13 = (CoroutineScope) this.L$0;
        goto L10
    }

    @Nullable
    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(@NotNull CoroutineScope r10, @Nullable Continuation<? super Unit> r11) {
        return ((SysAppAutoUpdateWhitelistManager$startPeriodicSync$1) create(r10, r11)).invokeSuspend(Unit.f21064a);
    }
}
