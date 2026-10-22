package com.bytedance.android.monitorV2;

import android.app.Application;
import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import com.larus.apm.impl.protector.RunnableProtector;
import java.io.File;

/* JADX INFO: loaded from: classes12.dex */
public final class f implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ g f163038a;

    public final void a() {
        Application r100 = this.f163038a.f163040a;
        if (r100 == null) goto L20;
        File r101 = com.bytedance.android.monitorV2.util.g.a(r100, "monitor_data_switch");     // Catch: Throwable -> L15
        PolarisFileWrapper r102 = new PolarisFileWrapper(r101, "is_debug");     // Catch: Throwable -> L15
        if (r102.isFile() == true) goto L7;
    L9:
        PolarisFileWrapper r103 = new PolarisFileWrapper(r101, "is_output_file");     // Catch: Throwable -> L15
        if (r103.isFile() == true) goto L12;
        return;
    L12:
        if (r103.exists() == false) goto L22;
        hz2.a.f487669a = true;     // Catch: Throwable -> L15
        Application r104 = g.e().f163040a;     // Catch: Throwable -> L15
        return;
    L22:
        return;
    L7:
        if (r102.exists() == false) goto L9;
        Application r105 = g.e().f163040a;     // Catch: Throwable -> L15
        nz2.b.f521375a = true;     // Catch: Throwable -> L15
    L15:
        th = move-exception;
        com.bytedance.android.monitorV2.util.f.b(th);
        return;
    }

    @Override // java.lang.Runnable
    public final void run() {
        a();     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L8;
        return;
    L8:
        throw th;
    }

    public f(g r100) {
        this.f163038a = r100;
    }
}
