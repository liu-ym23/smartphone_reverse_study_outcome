package com.stepos.ailauncher.foundation.account;

import Ua.M;
import Ua.U;
import Y8.t;
import com.stepos.ailauncher.contract.model.AccountStatus;
import com.stepos.ailauncher.foundation.account.AccountStatusServiceImpl;
import e9.InterfaceC4014c;
import f9.C4063a;
import g9.InterfaceC4112d;
import h8.C4148a;
import kotlin.C4849c;
import kotlin.Metadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import p9.p;

@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"LUa/M;", "LY8/t;", "<anonymous>", "(LUa/M;)V"}, k = 3, mv = {2, 2, 0})
@InterfaceC4112d(c = "com.stepos.ailauncher.foundation.account.AccountStatusServiceImpl$installSafetyValve$1", f = "AccountStatusServiceImpl.kt", l = {201}, m = "invokeSuspend", v = 1)
/* loaded from: classes3.dex */
public final class AccountStatusServiceImpl$installSafetyValve$1 extends SuspendLambda implements p<M, InterfaceC4014c<? super t>, Object> {
    final /* synthetic */ AccountStatusServiceImpl.Snapshot $captured;
    final /* synthetic */ Long $durationMs;
    final /* synthetic */ String $uid;
    int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AccountStatusServiceImpl$installSafetyValve$1(Long l10, AccountStatusServiceImpl.Snapshot snapshot, String str, InterfaceC4014c<? super AccountStatusServiceImpl$installSafetyValve$1> interfaceC4014c) {
        super(2, interfaceC4014c);
        this.$durationMs = l10;
        this.$captured = snapshot;
        this.$uid = str;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final InterfaceC4014c<t> create(Object obj, InterfaceC4014c<?> interfaceC4014c) {
        return new AccountStatusServiceImpl$installSafetyValve$1(this.$durationMs, this.$captured, this.$uid, interfaceC4014c);
    }

    @Override // p9.p
    public final Object invoke(M m10, InterfaceC4014c<? super t> interfaceC4014c) {
        return ((AccountStatusServiceImpl$installSafetyValve$1) create(m10, interfaceC4014c)).invokeSuspend(t.f7040a);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) throws Throwable {
        Object objG = C4063a.g();
        int i10 = this.label;
        if (i10 == 0) {
            C4849c.b(obj);
            long jLongValue = this.$durationMs.longValue();
            this.label = 1;
            if (U.a(jLongValue, this) == objG) {
                return objG;
            }
        } else {
            if (i10 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            C4849c.b(obj);
        }
        if (AccountStatusServiceImpl.snapshot == this.$captured) {
            String str = this.$uid;
            AccountStatus.Available available = AccountStatus.Available.INSTANCE;
            AccountStatusServiceImpl.snapshot = new AccountStatusServiceImpl.Snapshot(str, available);
            AccountStatusServiceImpl._status.setValue(available);
            C4148a.k("AccountStatusService", "safety valve auto-unban uid=" + this.$uid + " durationMs=" + this.$durationMs, false, 4, null);
        }
        return t.f7040a;
    }
}
