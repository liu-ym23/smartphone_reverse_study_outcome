package com.bytedance.android.sdk.bdticketguard;

import android.content.Context;
import com.bytedance.sdk.account.ticketguard.AccountTicketGuardHelper;

/* JADX INFO: loaded from: classes3.dex */
public interface b1 {
    com.bytedance.sdk.account.ticketguard.e a();

    Context getApplicationContext();

    AccountTicketGuardHelper.TicketGuardInitParamImpl.b getLogger();

    AccountTicketGuardHelper.TicketGuardInitParamImpl.a getMonitor();
}
