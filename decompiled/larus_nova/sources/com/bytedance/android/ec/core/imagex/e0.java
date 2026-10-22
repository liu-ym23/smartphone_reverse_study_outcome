package com.bytedance.android.ec.core.imagex;

import com.bytedance.pitaya.api.feature.FeatureCoreFactory;
import com.bytedance.pitaya.api.feature.IFeatureCore;
import com.bytedance.pitaya.api.feature.IKVStore;
import com.larus.apm.impl.protector.RunnableProtector;

/* JADX INFO: loaded from: classes43.dex */
public final class e0 implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ String f44667a;

    public e0(String r100) {
        this.f44667a = r100;
    }

    @Override // java.lang.Runnable
    public final void run() {
    L17:
        IFeatureCore r100 = j0.f44683a;     // Catch: Throwable -> L12
        if (j0.f44683a != null) goto L5;
    L6:
        j0.f44683a = FeatureCoreFactory.INSTANCE.getFeatureCore(this.f44667a);     // Catch: Throwable -> L12
        IFeatureCore r101 = j0.f44683a;     // Catch: Throwable -> L12
        if (r101 == null) goto L9;
        IKVStore r102 = r101.createInMemoryKVStore("ecom_home_fast_scroll_recognize");     // Catch: Throwable -> L12
    L10:
        j0.f44684b = r102;     // Catch: Throwable -> L12
        goto L17
    L9:
        r102 = null;
        goto L10
    L5:
        if (j0.f44684b == null) goto L6;
        return;
    L12:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L16;
        return;
    L16:
        throw th;
    }
}
