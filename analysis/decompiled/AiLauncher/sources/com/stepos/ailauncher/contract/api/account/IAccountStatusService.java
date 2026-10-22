package com.stepos.ailauncher.contract.api.account;

import Xa.t;
import com.stepos.ailauncher.contract.model.AccountStatus;
import e9.InterfaceC4014c;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J\u0018\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H¦@¢\u0006\u0004\b\u0005\u0010\u0006J\u0019\u0010\u0007\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0007\u0010\bJ(\u0010\f\u001a\u00020\u000b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\t\u001a\u00020\u00022\u0006\u0010\n\u001a\u00020\u0002H¦@¢\u0006\u0004\b\f\u0010\rJ\u000f\u0010\u000f\u001a\u00020\u000eH&¢\u0006\u0004\b\u000f\u0010\u0010R\u001a\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00040\u00118&X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0005\u0010\u0012¨\u0006\u0014À\u0006\u0003"}, d2 = {"Lcom/stepos/ailauncher/contract/api/account/IAccountStatusService;", "", "", "uid", "Lcom/stepos/ailauncher/contract/model/AccountStatus;", "getStatus", "(Ljava/lang/String;Le9/c;)Ljava/lang/Object;", "peekStatus", "(Ljava/lang/String;)Lcom/stepos/ailauncher/contract/model/AccountStatus;", "reason", "screenCode", "LY8/t;", "notifyAccountSignal", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Le9/c;)Ljava/lang/Object;", "", "serverNow", "()J", "LXa/t;", "()LXa/t;", "status", "contract_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes3.dex */
public interface IAccountStatusService {
    t<AccountStatus> getStatus();

    Object getStatus(String str, InterfaceC4014c<? super AccountStatus> interfaceC4014c);

    Object notifyAccountSignal(String str, String str2, String str3, InterfaceC4014c<? super Y8.t> interfaceC4014c);

    AccountStatus peekStatus(String uid);

    long serverNow();
}
