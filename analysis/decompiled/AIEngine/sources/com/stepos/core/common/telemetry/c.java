package com.stepos.core.common.telemetry;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final /* synthetic */ class c implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f7387a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ zb.a f7388b;

    public /* synthetic */ c(int i10, zb.a aVar) {
        this.f7387a = i10;
        this.f7388b = aVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        int i10 = this.f7387a;
        zb.a aVar = this.f7388b;
        switch (i10) {
            case 0:
                DelayedFreqSampler.scheduleAfter$lambda$4$lambda$3(aVar);
                break;
            default:
                aVar.invoke();
                break;
        }
    }
}
