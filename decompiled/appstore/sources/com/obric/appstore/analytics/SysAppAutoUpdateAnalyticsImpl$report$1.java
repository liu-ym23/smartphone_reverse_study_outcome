package com.obric.appstore.analytics;

import com.bytedanceos.common.toolbox.j;
import com.obric.appstore.network.StoreHttpEngine;
import com.obric.appstore.network.b;
import com.obric.appstore.network.c;
import com.obric.appstore.network.entity.HttpResp;
import com.obric.appstore.network.entity.SysAppAutoUpdateReportReq;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.s;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.a;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Deferred;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import retrofit2.Response;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 9, 0}, xi = 48)
@DebugMetadata(c = "com.obric.appstore.analytics.SysAppAutoUpdateAnalyticsImpl$report$1", f = "SysAppAutoUpdateAnalytics.kt", i = {}, l = {139}, m = "invokeSuspend", n = {}, s = {})
public final class SysAppAutoUpdateAnalyticsImpl$report$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ SysAppAutoUpdateReportReq $param;
    final /* synthetic */ String $reason;
    final /* synthetic */ int $status;
    final /* synthetic */ String $taskStr;
    Object L$0;
    int label;

    public SysAppAutoUpdateAnalyticsImpl$report$1(SysAppAutoUpdateReportReq r10, int r11, String r12, String r13, Continuation<? super SysAppAutoUpdateAnalyticsImpl$report$1> r14) {
        this.$param = r10;
        this.$status = r11;
        this.$reason = r12;
        this.$taskStr = r13;
        super(2, r14);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @NotNull
    public final Continuation<Unit> create(@Nullable Object r10, @NotNull Continuation<?> r11) {
        return new SysAppAutoUpdateAnalyticsImpl$report$1(this.$param, this.$status, this.$reason, this.$taskStr, r11);
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
        if (r12 == 0) goto L12;
        if (r12 != 1) goto L11;
        c r13 = (c) this.L$0;
        kotlin.c.b(r10);     // Catch: Throwable -> L8
    L17:
        b r14 = r13.a((Response) r10);     // Catch: Throwable -> L8
        if ((r14 instanceof com.obric.appstore.network.a) == false) goto L20;
        j.p("[AutoUpdate] SysAppAutoUpdateAnalytics report error, !!! STATUS=(" + this.$status + "), reason=(" + this.$reason + "), code=" + ((com.obric.appstore.network.a) r14).a() + ", task=" + this.$taskStr + ", error=" + ((com.obric.appstore.network.a) r14).b());     // Catch: Throwable -> L8
    L24:
        return Unit.f21064a;
    L20:
        j.n("[AutoUpdate] SysAppAutoUpdateAnalytics report, STATUS=(" + this.$status + "), reason=(" + this.$reason + "), task=" + this.$taskStr);     // Catch: Throwable -> L8
        goto L24
    L11:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L12:
        kotlin.c.b(r10);
        c r15 = c.f10963a;     // Catch: Throwable -> L8
        Deferred<Response<HttpResp<Unit>>> r16 = StoreHttpEngine.f10958b.h().sysAppAutoUpdateReportBatch(s.e(this.$param));     // Catch: Throwable -> L8
        this.L$0 = r15;     // Catch: Throwable -> L8
        this.label = 1;     // Catch: Throwable -> L8
        Object r17 = r16.await(this);     // Catch: Throwable -> L8
        if (r17 != r11) goto L16;
        return r11;
    L16:
        r13 = r15;
        r10 = r17;
    L8:
        th = move-exception;
        j.q("[AutoUpdate] SysAppAutoUpdateAnalytics report error, STATUS=(" + this.$status + "), reason=(" + this.$reason + "), task=" + this.$taskStr + ", error=", th);
        goto L24
    }

    @Nullable
    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(@NotNull CoroutineScope r10, @Nullable Continuation<? super Unit> r11) {
        return ((SysAppAutoUpdateAnalyticsImpl$report$1) create(r10, r11)).invokeSuspend(Unit.f21064a);
    }
}
