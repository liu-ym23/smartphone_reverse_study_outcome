package com.uxsense.user;

import S7.k;

/* loaded from: classes3.dex */
public final /* synthetic */ class a implements k {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f4215a;
    public final /* synthetic */ AccountEntry b;

    public /* synthetic */ a(AccountEntry accountEntry, int i) {
        this.f4215a = i;
        this.b = accountEntry;
    }

    @Override // S7.k
    public final Object invoke(Object obj) {
        int i = this.f4215a;
        AccountEntry accountEntry = this.b;
        AccountEntry accountEntry2 = (AccountEntry) obj;
        switch (i) {
            case 0:
                return ApexAccountManager.notifyAccountLogin$lambda$13$lambda$12(accountEntry, accountEntry2);
            default:
                return ApexAccountManager.notifyAccountUpdated$lambda$21$lambda$20(accountEntry, accountEntry2);
        }
    }
}
