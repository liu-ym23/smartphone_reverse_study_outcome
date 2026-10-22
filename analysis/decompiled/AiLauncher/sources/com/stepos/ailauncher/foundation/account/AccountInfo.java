package com.stepos.ailauncher.foundation.account;

import com.autonavi.aps.amapapi.config.Const;
import kotlin.Metadata;
import kotlin.jvm.internal.p;

@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0006\b\u0086\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0004\u001a\u00020\u0002¢\u0006\u0004\b\u0005\u0010\u0006J$\u0010\u0007\u001a\u00020\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u00022\b\b\u0002\u0010\u0004\u001a\u00020\u0002HÆ\u0001¢\u0006\u0004\b\u0007\u0010\bJ\u0010\u0010\t\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\t\u0010\nJ\u0010\u0010\f\u001a\u00020\u000bHÖ\u0001¢\u0006\u0004\b\f\u0010\rJ\u001a\u0010\u0010\u001a\u00020\u000f2\b\u0010\u000e\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u0010\u0010\u0011R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0012\u001a\u0004\b\u0013\u0010\nR\u0017\u0010\u0004\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0004\u0010\u0012\u001a\u0004\b\u0014\u0010\n¨\u0006\u0015"}, d2 = {"Lcom/stepos/ailauncher/foundation/account/a;", "", "", "accountId", M5.b.CREDENTIAL_TOKEN, "<init>", "(Ljava/lang/String;Ljava/lang/String;)V", Const.INTENT_KEY_APIKEY, "(Ljava/lang/String;Ljava/lang/String;)Lcom/stepos/ailauncher/foundation/account/a;", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "other", "", "equals", "(Ljava/lang/Object;)Z", "Ljava/lang/String;", "c", Const.INTENT_KEY_UMID, "foundation_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* renamed from: com.stepos.ailauncher.foundation.account.a, reason: from toString */
/* loaded from: classes3.dex */
public final /* data */ class AccountInfo {
    private final String accountId;
    private final String token;

    public AccountInfo(String accountId, String token) {
        p.i(accountId, "accountId");
        p.i(token, "token");
        this.accountId = accountId;
        this.token = token;
    }

    public static /* synthetic */ AccountInfo b(AccountInfo accountInfo, String str, String str2, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            str = accountInfo.accountId;
        }
        if ((i10 & 2) != 0) {
            str2 = accountInfo.token;
        }
        return accountInfo.a(str, str2);
    }

    public final AccountInfo a(String accountId, String token) {
        p.i(accountId, "accountId");
        p.i(token, "token");
        return new AccountInfo(accountId, token);
    }

    /* renamed from: c, reason: from getter */
    public final String getAccountId() {
        return this.accountId;
    }

    /* renamed from: d, reason: from getter */
    public final String getToken() {
        return this.token;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof AccountInfo)) {
            return false;
        }
        AccountInfo accountInfo = (AccountInfo) other;
        return p.d(this.accountId, accountInfo.accountId) && p.d(this.token, accountInfo.token);
    }

    public int hashCode() {
        return (this.accountId.hashCode() * 31) + this.token.hashCode();
    }

    public String toString() {
        return "AccountInfo(accountId=" + this.accountId + ", token=" + this.token + ")";
    }
}
