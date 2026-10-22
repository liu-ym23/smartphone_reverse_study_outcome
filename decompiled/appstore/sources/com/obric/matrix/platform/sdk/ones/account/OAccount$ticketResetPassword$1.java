package com.obric.matrix.platform.sdk.ones.account;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.q;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "", "service", "Lcom/obric/matrix/platform/sdk/ones/account/IAccountService;", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
final class OAccount$ticketResetPassword$1 extends Lambda implements Function1<IAccountService, Unit> {
    final /* synthetic */ Function2<Integer, String, Unit> $onFailed;
    final /* synthetic */ Function0<Unit> $onSuccess;
    final /* synthetic */ String $password;
    final /* synthetic */ String $ticket;

    /* JADX WARN: Multi-variable type inference failed */
    public OAccount$ticketResetPassword$1(String r10, String r11, Function0<Unit> r12, Function2<? super Integer, ? super String, Unit> r13) {
        this.$ticket = r10;
        this.$password = r11;
        this.$onSuccess = r12;
        this.$onFailed = r13;
        super(1);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(IAccountService r10) {
        invoke2(r10);
        return Unit.f21064a;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(@NotNull IAccountService r11) {
        q.g(r11, "service");
        r11.ticketResetPassword(this.$ticket, this.$password, new OAccount.AsyncResultCallback("ticketResetPassword", this.$onSuccess, this.$onFailed, null, 8, null));
    }
}
