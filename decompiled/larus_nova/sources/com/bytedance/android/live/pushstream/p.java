package com.bytedance.android.live.pushstream;

import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.security.android.aopcheck.PolarisFileOutputStreamWrapper;
import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import java.io.File;
import java.io.InputStream;
import java.util.concurrent.Callable;
import kotlin.Unit;
import kotlin.io.CloseableKt;

/* JADX INFO: loaded from: classes47.dex */
public final class p<V> implements Callable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ File f89419a;

    public p(PolarisFileWrapper r100) {
        this.f89419a = r100;
    }

    @Override // java.util.concurrent.Callable
    public final void call() {
        if (this.f89419a.exists() == true) goto L25;
        this.f89419a.createNewFile();
        InputStream r100 = jc1.a.b().getApplicationContext().getAssets().open("audio_metrics_v1.3.model");
        PolarisFileOutputStreamWrapper r101 = new PolarisFileOutputStreamWrapper(this.f89419a);     // Catch: Throwable -> L20
        byte[] r102 = new byte[1024];     // Catch: Throwable -> L15
        int r103 = r100.read(r102);     // Catch: Throwable -> L15
    L9:
        if (r103 == (-1)) goto L11;
        r101.write(r102, 0, r103);     // Catch: Throwable -> L15
        r103 = r100.read(r102);     // Catch: Throwable -> L15
        goto L9
    L11:
        r101.flush();     // Catch: Throwable -> L15
        Unit r104 = Unit.INSTANCE;     // Catch: Throwable -> L15
    L13:
        CloseableKt.closeFinally(r101, null);     // Catch: Throwable -> L20
        CloseableKt.closeFinally(r100, null);
    L15:
        th = move-exception;
        throw th;     // Catch: Throwable -> L17
    L17:
        th = move-exception;
        CloseableKt.closeFinally(r101, th);     // Catch: Throwable -> L20
        throw th;     // Catch: Throwable -> L20
    L20:
        th = move-exception;
        throw th;     // Catch: Throwable -> L22
    L22:
        th = move-exception;
        CloseableKt.closeFinally(r100, th);
        throw th;
    L25:
        ALogger.d("AudioSamiDiagnosisImpl", "createLiveStream: file.exists(): " + this.f89419a.exists() + "file size: " + this.f89419a.length());
    }

    @Override // java.util.concurrent.Callable
    public /* bridge */ /* synthetic */ Object call() {
        call();
        return Unit.INSTANCE;
    }
}
