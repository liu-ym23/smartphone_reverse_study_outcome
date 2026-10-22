package com.stepos.core.ota.confirmui;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final /* synthetic */ class c implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f7490a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ InProcessConfirmHost f7491b;

    public /* synthetic */ c(InProcessConfirmHost inProcessConfirmHost, int i10) {
        this.f7490a = i10;
        this.f7491b = inProcessConfirmHost;
    }

    @Override // java.lang.Runnable
    public final void run() {
        int i10 = this.f7490a;
        InProcessConfirmHost inProcessConfirmHost = this.f7491b;
        switch (i10) {
            case 0:
                InProcessConfirmHost.dismissPending$lambda$7(inProcessConfirmHost);
                break;
            default:
                inProcessConfirmHost.dismissPending();
                break;
        }
    }
}
