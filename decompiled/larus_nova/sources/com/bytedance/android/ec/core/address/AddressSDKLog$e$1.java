package com.bytedance.android.ec.core.address;

import com.bytedance.android.ec.core.monitor.ECExceptionMonitor;
import com.bytedance.mira.hook.proxy.AbsMethodDelegate;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: classes43.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", AbsMethodDelegate.TAG_INVOKE}, k = 3, mv = {1, 4, 3})
final class AddressSDKLog$e$1 extends Lambda implements Function0<Unit> {
    final /* synthetic */ long $logTime;
    final /* synthetic */ String $msg;
    final /* synthetic */ Throwable $throwable;

    public AddressSDKLog$e$1(String r100, long r101, Throwable r102) {
        this.$msg = r100;
        this.$logTime = r101;
        this.$throwable = r102;
        super(0);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2() {
        Result.Companion r100 = Result.Companion;     // Catch: Throwable -> L4
        dm.a.a("AddressSdk").b(this.$msg + " log_time=" + this.$logTime, this.$throwable);     // Catch: Throwable -> L4
        Object r101 = Result.m9449constructorimpl(Unit.INSTANCE);     // Catch: Throwable -> L4
    L6:
        Throwable r102 = Result.m9452exceptionOrNullimpl(r101);
        if (r102 == null) goto L12;
        ECExceptionMonitor.e(r102);
        return;
    L12:
        return;
    L4:
        th = move-exception;
        Result.Companion r103 = Result.Companion;
        r101 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L6
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ Unit invoke() {
        invoke2();
        return Unit.INSTANCE;
    }
}
