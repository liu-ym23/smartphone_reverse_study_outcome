package com.amap.api.mapcore.util;

import com.amap.api.maps.AMapException;

/* JADX INFO: loaded from: classes28.dex */
class g1 extends a9 {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final /* synthetic */ f1 f27296b;

    @Override // com.amap.api.mapcore.util.a9
    public void runTask() {
        f1.b(this.f27296b);     // Catch: Throwable -> L20 AMapException -> L23
        e1.a r100 = new e1(f1.c(this.f27296b)).c();     // Catch: c5 -> L17 Throwable -> L20 AMapException -> L23
        if (r100 != null) goto L6;
        return;
    L6:
        if (r100.f27196a == false) goto L27;
        String r101 = r100.f27198c;     // Catch: Throwable -> L20 AMapException -> L23
        if (r101 != null) goto L11;
    L15:
        f1.a(this.f27296b, r100);     // Catch: Throwable -> L20 AMapException -> L23
        return;
    L11:
        if (r101.isEmpty() == true) goto L15;
        if (r101.equals(f1.f27223p) == false) goto L15;
        return;
    L27:
        return;
    L17:
        e = move-exception;
        throw new AMapException(e.a());     // Catch: Throwable -> L20 AMapException -> L23
    L20:
        th = move-exception;
        t6.a(th, "OfflineDownloadManager", "fetchAndUpdateCityListFromNetwork");
        return;
    }

    public g1(f1 r100) {
        this.f27296b = r100;
    }
}
