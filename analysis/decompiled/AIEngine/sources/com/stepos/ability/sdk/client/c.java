package com.stepos.ability.sdk.client;

import java.util.concurrent.atomic.AtomicBoolean;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final /* synthetic */ class c implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f5568a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ AtomicBoolean f5569b;

    public /* synthetic */ c(AtomicBoolean atomicBoolean, int i10) {
        this.f5568a = i10;
        this.f5569b = atomicBoolean;
    }

    @Override // java.lang.Runnable
    public final void run() {
        switch (this.f5568a) {
            case 0:
                if (this.f5569b.compareAndSet(false, true)) {
                    v5.b.f13381a.a(5, "Ability_".concat("Ability_AgentServiceClient"), "bind timeout", null);
                    d.f5570a.getClass();
                    d.e(false);
                    break;
                }
                break;
            default:
                this.f5569b.set(true);
                break;
        }
    }
}
