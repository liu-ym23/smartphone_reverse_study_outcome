package com.bytedance.android.sdk.bdticketguard;

import com.bytedance.mira.hook.proxy.AbsMethodDelegate;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: classes12.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"fail", "", AbsMethodDelegate.TAG_INVOKE}, k = 3, mv = {1, 1, 15})
final class TicketGuardManager$getProviderHeaders$2 extends Lambda implements Function0<Unit> {
    public static final TicketGuardManager$getProviderHeaders$2 INSTANCE = null;

    static {
        INSTANCE = new TicketGuardManager$getProviderHeaders$2();
    }

    public TicketGuardManager$getProviderHeaders$2() {
        super(0);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2() {
        r0.a("TicketGuardManager", "getProviderHeaders: fail");
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ Unit invoke() {
        invoke2();
        return Unit.INSTANCE;
    }
}
