package com.obric.appstore.analytics;

import com.obric.appstore.network.entity.SysAppAutoUpdateReportReq;
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

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 9, 0}, xi = 48)
@DebugMetadata(c = "com.obric.appstore.analytics.SysAppAutoUpdateAnalyticsImpl$onGetUpdateInfo$1$3$3$1", f = "SysAppAutoUpdateAnalytics.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
public final class SysAppAutoUpdateAnalyticsImpl$onGetUpdateInfo$1$3$3$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ SysAppAutoUpdateReportReq $it;
    int label;

    public SysAppAutoUpdateAnalyticsImpl$onGetUpdateInfo$1$3$3$1(SysAppAutoUpdateReportReq r10, Continuation<? super SysAppAutoUpdateAnalyticsImpl$onGetUpdateInfo$1$3$3$1> r11) {
        this.$it = r10;
        super(2, r11);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @NotNull
    public final Continuation<Unit> create(@Nullable Object r10, @NotNull Continuation<?> r11) {
        return new SysAppAutoUpdateAnalyticsImpl$onGetUpdateInfo$1$3$3$1(this.$it, r11);
    }

    @Override // kotlin.jvm.functions.Function2
    /* JADX INFO: renamed from: invoke */
    public /* bridge */ /* synthetic */ Object mo0invoke(CoroutineScope r10, Continuation<? super Unit> r11) {
        return invoke2(r10, r11);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @Nullable
    public final Object invokeSuspend(@NotNull Object r10) {
        a.d();
        if (this.label != 0) goto L7;
        c.b(r10);
        SysAppAutoUpdateAnalyticsImpl.e(SysAppAutoUpdateAnalyticsImpl.f10521a, this.$it);
        return Unit.f21064a;
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }

    @Nullable
    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(@NotNull CoroutineScope r10, @Nullable Continuation<? super Unit> r11) {
        return ((SysAppAutoUpdateAnalyticsImpl$onGetUpdateInfo$1$3$3$1) create(r10, r11)).invokeSuspend(Unit.f21064a);
    }
}
