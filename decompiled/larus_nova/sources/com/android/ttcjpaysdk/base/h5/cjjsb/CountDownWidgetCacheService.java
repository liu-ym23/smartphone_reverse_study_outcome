package com.android.ttcjpaysdk.base.h5.cjjsb;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes28.dex */
@Metadata(d1 = {"\u0000'\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003*\u0001\u0004\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0014\u0010\u0006\u001a\u0004\u0018\u00010\u00072\b\u0010\b\u001a\u0004\u0018\u00010\tH\u0016J\"\u0010\n\u001a\u00020\u000b2\b\u0010\b\u001a\u0004\u0018\u00010\t2\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\r\u001a\u00020\u000bH\u0016R\u0010\u0010\u0003\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0005¨\u0006\u000e"}, d2 = {"Lcom/android/ttcjpaysdk/base/h5/cjjsb/CountDownWidgetCacheService;", "Landroid/app/Service;", "()V", "service", "com/android/ttcjpaysdk/base/h5/cjjsb/CountDownWidgetCacheService$service$1", "Lcom/android/ttcjpaysdk/base/h5/cjjsb/CountDownWidgetCacheService$service$1;", "onBind", "Landroid/os/IBinder;", "intent", "Landroid/content/Intent;", "onStartCommand", "", "flags", "startId", "base-context_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class CountDownWidgetCacheService extends Service {
    private final CountDownWidgetCacheService$service$1 service;

    @Override // android.app.Service
    public int onStartCommand(Intent r100, int r101, int r102) {
        return 2;
    }

    /* JADX WARN: Type inference failed for: r0v0, types: [com.android.ttcjpaysdk.base.h5.cjjsb.CountDownWidgetCacheService$service$1] */
    public CountDownWidgetCacheService() {
        this.service = new CountDownWidgetCacheService$service$1();
    }

    @Override // android.app.Service
    public IBinder onBind(Intent r100) {
        return this.service;
    }
}
