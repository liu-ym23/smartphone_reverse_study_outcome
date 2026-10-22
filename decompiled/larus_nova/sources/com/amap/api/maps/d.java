package com.amap.api.maps;

/* JADX INFO: loaded from: classes28.dex */
class d implements AMap.CancelableCallback {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ Runnable f28636a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final /* synthetic */ Runnable f28637b;

    @Override // com.amap.api.maps.AMap.CancelableCallback
    public void onCancel() {
        this.f28637b.run();
    }

    @Override // com.amap.api.maps.AMap.CancelableCallback
    public void onFinish() {
        this.f28636a.run();
    }

    public d(AMap r100, Runnable r101, Runnable r102) {
        this.f28636a = r101;
        this.f28637b = r102;
    }
}
