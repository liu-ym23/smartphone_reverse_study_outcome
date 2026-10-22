package com.bytedance.android.live.browser.jsbridge.upload;

import android.util.Base64;
import com.bytedance.security.android.aopcheck.PolarisFileInputStreamWrapper;
import java.util.concurrent.Callable;
import kotlin.io.CloseableKt;

/* JADX INFO: loaded from: classes45.dex */
public final class v<V> implements Callable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ x f64091a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ String f64092b;

    public v(x r100, String r101) {
        this.f64091a = r100;
        this.f64092b = r101;
    }

    @Override // java.util.concurrent.Callable
    public final String call() {
        x r100 = this.f64091a;
        String r101 = this.f64092b;
        r100.getClass();
        PolarisFileInputStreamWrapper r102 = new PolarisFileInputStreamWrapper(r101);
        byte[] r103 = new byte[r102.available()];     // Catch: Throwable -> L6
        r102.read(r103);     // Catch: Throwable -> L6
        String r104 = Base64.encodeToString(r103, 2);     // Catch: Throwable -> L6
        CloseableKt.closeFinally(r102, null);
        return r104;
    L6:
        th = move-exception;
        throw th;     // Catch: Throwable -> L8
    L8:
        th = move-exception;
        CloseableKt.closeFinally(r102, th);
        throw th;
    }

    @Override // java.util.concurrent.Callable
    public /* bridge */ /* synthetic */ Object call() {
        return call();
    }
}
