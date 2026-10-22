package com.bytedance.android.live.liveinteract.service;

import android.os.Bundle;
import io.reactivex.disposables.Disposable;
import zg1.h1;

/* JADX INFO: loaded from: classes46.dex */
public final class c implements gd0.e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public ny.a f78606a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public Disposable f78607b;

    public c() {
    }

    public static final void a(c r100) {
        r100.getClass();
        h1 r101 = new h1(6);
        Bundle r102 = new Bundle();
        r102.putBoolean("DATA_BOOLEAN_SKIP_INTERCEPTOR", true);
        r101.f571839d = r102;
        xs2.b.a().post(r101);
    }
}
