package com.stepos.ability.sdk.client;

import android.os.IBinder;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final /* synthetic */ class a implements IBinder.DeathRecipient {
    @Override // android.os.IBinder.DeathRecipient
    public final void binderDied() {
        v5.b.f13381a.a(5, "Ability_".concat("Ability_AgentServiceClient"), "binder died — clearing state", null);
        d.f5572c = null;
        d.f5576g = false;
    }
}
