package com.bytedance.reparo.b;

import android.text.TextUtils;
import com.bytedance.reparo.c.e;
import com.bytedance.reparo.core.a.b.b;
import com.bytedance.reparo.core.b.c;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;
import okhttp3.ab;
import okhttp3.ad;
import okhttp3.z;

/* JADX INFO: compiled from: PatchDownloader.java */
/* JADX INFO: loaded from: classes.dex */
public class a {
    private static final String TAG = "PatchDownloader";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private z f9101a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private InterfaceC0206a f9102b;

    /* JADX INFO: renamed from: com.bytedance.reparo.b.a$a, reason: collision with other inner class name */
    /* JADX INFO: compiled from: PatchDownloader.java */
    public interface InterfaceC0206a {
        void a(c r1);

        void a(File r1);
    }

    public a() {
        this.f9101a = a();
    }

    private z a() {
        z.a r3 = new z.a();
        r3.a(60000, TimeUnit.MILLISECONDS);
        r3.b(60000, TimeUnit.MILLISECONDS);
        r3.b(true);
        return r3.E();
    }

    public void a(String r3, File r4, InterfaceC0206a r5) {
        InterfaceC0206a r6 = (InterfaceC0206a) ZeusTransformUtils.wrapperContextForParams(r5, InterfaceC0206a.class, "com.obric.aiagent.plugin");
        if (TextUtils.isEmpty(r3) == false) goto L5;
        return;
    L5:
        e.a(TAG, "start to download, will save to " + r4.getAbsolutePath());
        this.f9102b = r6;
        ad r7 = this.f9101a.a(new ab.a().a(r3).b()).b();     // Catch: IOException -> L13
        if (r7.n() == true) goto L10;
        a(new c(r7.g().f()));     // Catch: IOException -> L13
        return;
    L10:
        b.a(r7.g().e(), r4);     // Catch: IOException -> L13
        a(r4);
        return;
    L13:
        e = move-exception;
        e.printStackTrace();
        a(new c("down load " + r3 + " failed.", e));
    }

    private void a(c r1) {
        InterfaceC0206a r0 = this.f9102b;
        if (r0 == null) goto L6;
        r0.a(r1);
        return;
    }

    private void a(File r1) {
        InterfaceC0206a r0 = this.f9102b;
        if (r0 == null) goto L6;
        r0.a(r1);
        return;
    }
}
