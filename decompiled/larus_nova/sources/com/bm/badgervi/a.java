package com.bm.badgervi;

import android.os.IBinder;

/* JADX INFO: loaded from: classes39.dex */
class a extends com.bm.vivoid.b {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final /* synthetic */ BadgerVIService f33676b;

    public a(BadgerVIService r100) {
        this.f33676b = r100;
    }

    @Override // com.bm.vivoid.c
    public boolean a(IBinder r100, IBinder r101) {
        BadgerVIService.b(this.f33676b, r100);     // Catch: Exception -> L5
        BadgerVIService.c(this.f33676b, r100, r101);     // Catch: Exception -> L5
        return true;
    L5:
        e = move-exception;
        e.getMessage();
        return false;
    }
}
