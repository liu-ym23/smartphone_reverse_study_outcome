package com.obric.aiagent.account;

/* JADX INFO: compiled from: IAccountService.kt */
/* JADX INFO: loaded from: classes2.dex */
public interface IAccountService {
    Boolean isLogin();

    void notifyAccountStatusChanged(boolean r1);

    void registerAccountStatusCallback(a r1);

    void unregisterAccountStatusCallback(a r1);
}
