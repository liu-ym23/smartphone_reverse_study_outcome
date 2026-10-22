package com.bytedance.reparo;

import android.os.SystemClock;
import android.text.TextUtils;
import com.bytedance.reparo.core.m;
import com.bytedance.reparo.model.PatchFetchInfo;
import java.io.File;

/* JADX INFO: compiled from: PatchUpdateTask.java */
/* JADX INFO: loaded from: classes.dex */
public class e implements Runnable {
    private static final String TAG = "PatchUpdateTask";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private PatchFetchInfo f9351a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private c f9352b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private long f9353c;

    static /* synthetic */ void a(e r0, com.bytedance.reparo.core.b.c r1, File r2) {
        r0.a(r1, r2);
    }

    static /* synthetic */ void a(e r0, File r1) {
        r0.a(r1);
    }

    e(PatchFetchInfo r1, c r2) {
        this.f9351a = r1;
        this.f9352b = r2;
    }

    @Override // java.lang.Runnable
    public void run() {
        b();
        a();     // Catch: Throwable -> L5
        return;
    L5:
        th = move-exception;
        com.bytedance.reparo.c.e.a(TAG, "something wrong", th);
    }

    private void a() {
        final File r0 = c();
        new com.bytedance.reparo.b.a().a(this.f9351a.getUrl(), r0, new AnonymousClass1(this, r0));
    }

    private void b() {
        this.f9353c = SystemClock.elapsedRealtime();
    }

    private void a(File r5) {
        if (TextUtils.equals(this.f9351a.getMd5(), com.bytedance.reparo.core.a.b.a.a(r5)) == true) goto L6;
        a(new com.bytedance.reparo.core.b.c("md5 not match, update skipped.", 1), r5);
        return;
    L6:
        com.bytedance.reparo.c.e.a(TAG, "download success, save into " + r5.getAbsolutePath());
        com.bytedance.reparo.c.c.a(TAG, this.f9351a, r5, this.f9353c);
        m.a().update(this.f9351a.convertToUpdateRequest(r5));
    }

    private void a(com.bytedance.reparo.core.b.c r4, File r5) {
        com.bytedance.reparo.c.c.a(TAG, this.f9351a, r4, this.f9353c);
        com.bytedance.reparo.c.e.a(TAG, "download failed. ", r4);
        com.bytedance.reparo.core.a.b.b.delete(r5);
    }

    private File c() {
        return this.f9352b.a(String.valueOf(this.f9351a.getVersionCode()), this.f9351a.getHostAppVersion() + "-" + this.f9351a.getVersionCode() + "-" + System.currentTimeMillis() + "-" + this.f9351a.getMd5() + ".patch");
    }
}
