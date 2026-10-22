package com.stepos.core.common.cloudconfig;

import a6.e;
import android.content.Context;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final /* synthetic */ class a implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f7373a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Context f7374b;

    public /* synthetic */ a(Context context, int i10) {
        this.f7373a = i10;
        this.f7374b = context;
    }

    @Override // java.lang.Runnable
    public final void run() {
        switch (this.f7373a) {
            case 0:
                CloudConfigManager.startAsync$lambda$4(this.f7374b);
                break;
            default:
                new ThreadPoolExecutor(0, 1, 0L, TimeUnit.MILLISECONDS, new LinkedBlockingQueue()).execute(new e(this.f7374b, 6));
                break;
        }
    }
}
