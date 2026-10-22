package com.stepos.core.ability.speech;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final /* synthetic */ class n implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f7317a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ zb.a f7318b;

    public /* synthetic */ n(int i10, zb.a aVar) {
        this.f7317a = i10;
        this.f7318b = aVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        int i10 = this.f7317a;
        zb.a aVar = this.f7318b;
        switch (i10) {
            case 0:
                aVar.invoke();
                break;
            case 1:
                aVar.invoke();
                break;
            default:
                TtsStreamCallbackExecutor.execute$lambda$3(aVar);
                break;
        }
    }
}
