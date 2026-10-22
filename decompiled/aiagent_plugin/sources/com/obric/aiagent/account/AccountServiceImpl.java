package com.obric.aiagent.account;

import com.obric.aiagent.assistant.idl.IFlowAppIntentIDL;
import com.obric.aiagent.assistant.idl.r;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.h.b.aa;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: compiled from: AccountServiceImpl.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class AccountServiceImpl implements IAccountService {
    private final CopyOnWriteArrayList<a> accountStatusCallbacks;
    private final AtomicBoolean isLogin;

    public AccountServiceImpl() {
        this.accountStatusCallbacks = new CopyOnWriteArrayList();
        this.isLogin = new AtomicBoolean(false);
    }

    @Override // com.obric.aiagent.account.IAccountService
    public Boolean isLogin() {
        IFlowAppIntentIDL r0 = r.a(aa.b(IFlowAppIntentIDL.class));
        if (r0 == null) goto L5;
        boolean r1 = r0.isLogin();
    L7:
        return Boolean.valueOf(r1);
    L5:
        r1 = false;
        goto L7
    }

    @Override // com.obric.aiagent.account.IAccountService
    public void registerAccountStatusCallback(a r3) {
        a r4 = (a) ZeusTransformUtils.wrapperContextForParams(r3, a.class, "com.obric.aiagent.plugin");
        CopyOnWriteArrayList<a> r2 = this.accountStatusCallbacks;
        if (r4 != null) goto L5;
        return;
    L5:
        r2.add(r4);
    }

    @Override // com.obric.aiagent.account.IAccountService
    public void unregisterAccountStatusCallback(a r3) {
        a r4 = (a) ZeusTransformUtils.wrapperContextForParams(r3, a.class, "com.obric.aiagent.plugin");
        CopyOnWriteArrayList<a> r2 = this.accountStatusCallbacks;
        if (r4 != null) goto L5;
        return;
    L5:
        r2.remove(r4);
    }

    @Override // com.obric.aiagent.account.IAccountService
    public void notifyAccountStatusChanged(boolean r4) {
        this.isLogin.set(r4);
        Iterator r3 = ((Iterable) ZeusTransformUtils.preCheckCast(this.accountStatusCallbacks, Iterable.class, "com.obric.aiagent.plugin")).iterator();
    L4:
        if (r3.hasNext() == false) goto L9;
        a r0 = (a) ZeusTransformUtils.preCheckCast(r3.next(), a.class, "com.obric.aiagent.plugin");
        if (r4 == true) goto L7;
        r0.a();
        goto L4
    L7:
        r0.b();
        goto L4
    }
}
