package com.stepos.ability.sdk.client;

import android.os.IBinder;

/* loaded from: classes3.dex */
public final /* synthetic */ class b implements IBinder.DeathRecipient {
    @Override // android.os.IBinder.DeathRecipient
    public final void binderDied() {
        AgentServiceClient.binderDeathRecipient$lambda$0();
    }
}
