package com.bytedance.reparo.core.d;

import android.app.Application;
import android.os.SystemClock;
import com.bytedance.reparo.core.e;
import com.bytedance.reparo.core.g;
import com.bytedance.reparo.core.g.i;
import com.bytedance.reparo.core.j;
import com.bytedance.thanos.hdiff.HDifferHelper;
import com.ss.android.socialbase.downloader.constants.DownloadConstants;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.File;
import java.io.IOException;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Iterator;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;

/* JADX INFO: compiled from: PatchInstaller.java */
/* JADX INFO: loaded from: classes.dex */
public class a {
    private static final String TAG = "PatchInstaller";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private Application f9170a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private File f9171b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private File f9172c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private e f9173d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private com.bytedance.reparo.core.g.a f9174e;
    private g f;

    /* JADX INFO: renamed from: com.bytedance.reparo.core.d.a$a, reason: collision with other inner class name */
    /* JADX INFO: compiled from: PatchInstaller.java */
    public static class C0212a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public File f9175a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public boolean f9176b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public File f9177c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public boolean f9178d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public boolean f9179e;
        public File f;

        public C0212a() {
        }
    }

    /* JADX INFO: compiled from: PatchInstaller.java */
    public interface b {
        void a(com.bytedance.reparo.core.b.e r1);

        void a(C0212a r1);
    }

    private boolean a(File r1) {
        return true;
    }

    public a(Application r3, File r4, File r5, e r6, com.bytedance.reparo.core.g.a r7, g r8) {
        Application r9 = (Application) ZeusTransformUtils.wrapperContextForParams(r3, Application.class, "com.obric.aiagent.plugin");
        com.bytedance.reparo.core.g.a r10 = (com.bytedance.reparo.core.g.a) ZeusTransformUtils.wrapperContextForParams(r7, com.bytedance.reparo.core.g.a.class, "com.obric.aiagent.plugin");
        this.f9170a = r9;
        this.f9171b = r4;
        this.f9172c = r5;
        this.f9173d = r6;
        this.f9174e = r10;
        this.f = r8;
    }

    public void a(b r11) {
        b r12 = (b) ZeusTransformUtils.wrapperContextForParams(r11, b.class, "com.obric.aiagent.plugin");
    L21:
        th = move-exception;
        j.b(TAG, "", th);
        a(r12, new com.bytedance.reparo.core.b.e("install failed. ", th));
        return;
    L4:
        if (com.bytedance.reparo.core.a.b.b.b(this.f9171b) == true) goto L7;
        j.c(TAG, String.format("patch file %s not exists. install skipped.", new Object[]{this.f9171b.getAbsolutePath()}));     // Catch: Throwable -> L21
        a(r12, new com.bytedance.reparo.core.b.e(String.format("patch file %s not exists. install skipped.", new Object[]{this.f9171b.getAbsolutePath()})));     // Catch: Throwable -> L21
        return;
    L7:
        long r5 = SystemClock.elapsedRealtime();     // Catch: Throwable -> L21
        j.b(TAG, "start install " + this.f9171b.getName());     // Catch: Throwable -> L21
        if (a(this.f9171b) == true) goto L11;
        a(r12, new com.bytedance.reparo.core.b.e("patch's signature is illegal.", 1));     // Catch: Throwable -> L21
        return;
    L11:
        com.bytedance.reparo.core.a.b.b.delete(this.f9172c);     // Catch: Throwable -> L21
        com.bytedance.reparo.core.g.g r0 = new com.bytedance.reparo.core.g.g(this.f9171b, this.f9174e, this.f9172c, this.f9173d);     // Catch: Throwable -> L21
        r0.b();     // Catch: Throwable -> L21
        a(this.f9170a, r0, this.f9173d);     // Catch: Throwable -> L21
        j.b(TAG, String.format("install " + this.f9171b.getName() + " success, cost %s milliseconds", new Object[]{String.valueOf(SystemClock.elapsedRealtime() - r5)}));     // Catch: Throwable -> L21
        if (r12 == null) goto L25;
        C0212a r2 = new C0212a();     // Catch: Throwable -> L21
        r2.f9175a = this.f9172c;     // Catch: Throwable -> L21
        if (r0.f() == false) goto L17;
        r2.f9176b = true;     // Catch: Throwable -> L21
        r2.f9177c = r0.g();     // Catch: Throwable -> L21
    L17:
        if (r0.e() == false) goto L19;
        r2.f9178d = true;     // Catch: Throwable -> L21
        r2.f9179e = r0.d().a();     // Catch: Throwable -> L21
        r2.f = r0.c();     // Catch: Throwable -> L21
    L19:
        r12.a(r2);     // Catch: Throwable -> L21
        return;
    }

    private void a(b r3, com.bytedance.reparo.core.b.e r4) {
        b r5 = (b) ZeusTransformUtils.wrapperContextForParams(r3, b.class, "com.obric.aiagent.plugin");
        com.bytedance.reparo.core.a.b.b.delete(this.f9172c);
        if (r5 == null) goto L6;
        r5.a(r4);
        return;
    }

    private void a(Application r6, com.bytedance.reparo.core.g.g r7, e r8) {
        Application r9 = (Application) ZeusTransformUtils.wrapperContextForParams(r6, Application.class, "com.obric.aiagent.plugin");
        if (r8.f9181b == true) goto L7;
        j.c(TAG, "haven't enable so fix feature, install so libraries skipped.");
        return;
    L7:
        if (r7.e() == true) goto L10;
        j.b(TAG, String.format("patch %s don't have any so libraries, install so libraries skipped.", new Object[]{this.f9171b.getName()}));
        return;
    L10:
        com.bytedance.reparo.core.g.j r10 = r7.d();
        if (r10 != null) goto L13;
    L47:
        j.c(TAG, String.format("target abi %s so list is empty, install so libraries failed.", new Object[]{r7.a()}));
        return;
    L13:
        if (r10.b() == 0) goto L47;
        if (com.bytedance.reparo.core.a.b.b.b(r7.c()) == true) goto L19;
        j.c(TAG, "so-info.txt not exit, install so libraries failed.");
        return;
    L19:
        HashMap<String, i> r11 = r10.c();
        ZipFile r12 = new ZipFile(new File(r9.getApplicationInfo().sourceDir));     // Catch: IOException -> L44
        Enumeration<? extends ZipEntry> r13 = r12.entries();     // Catch: IOException -> L44
    L22:
        if (r13.hasMoreElements() == false) goto L36;
        ZipEntry r0 = (ZipEntry) ZeusTransformUtils.preCheckCast(r13.nextElement(), ZipEntry.class, "com.obric.aiagent.plugin");     // Catch: IOException -> L44
        if (r0.getName().contains(DownloadConstants.VULNERABILITY_PATH) == true) goto L22;
        if (r0.getName().endsWith(".so") == false) goto L22;
        i r2 = (i) ZeusTransformUtils.preCheckCast(r11.get(r0.getName()), i.class, "com.obric.aiagent.plugin");     // Catch: IOException -> L44
        if (r2 == null) goto L22;
        r11.remove(r0.getName());     // Catch: IOException -> L44
        if (r2.f == true) goto L34;
        a(r2);     // Catch: IOException -> L44
        goto L22
    L34:
        a(r2, r12, r0);     // Catch: IOException -> L44
        goto L22
    L36:
        r12.close();     // Catch: IOException -> L44
        if (r11.isEmpty() == true) goto L43;
        Iterator<i> r14 = r11.values().iterator();     // Catch: IOException -> L44
    L39:
        if (r14.hasNext() == false) goto L67;
        a((i) ZeusTransformUtils.preCheckCast(r14.next(), i.class, "com.obric.aiagent.plugin"));     // Catch: IOException -> L44
        goto L39
    L67:
        return;
    L43:
        return;
    L44:
        e = move-exception;
        throw new com.bytedance.reparo.core.b.e("install so libraries failed.", e);
    }

    private void a(i r4, ZipFile r5, ZipEntry r6) {
        File r0 = this.f.a(this.f9172c, r6.getName());
        com.bytedance.reparo.core.a.b.b.a(r5.getInputStream(r6), r0);     // Catch: IOException -> L9
        File r3 = this.f.a(this.f9172c, r4);
        com.bytedance.reparo.core.a.b.b.delete(r3);
        com.bytedance.reparo.core.a.b.b.a(r3);
        if (HDifferHelper.a(r0.getAbsolutePath(), r4.f9241d.getAbsolutePath(), r3.getAbsolutePath()) != 0) goto L8;
        return;
    L8:
        throw new com.bytedance.reparo.core.b.e(String.format("patch source so %s and diff so %s failed.", new Object[]{r0.getAbsolutePath(), r4.f9241d.getAbsolutePath()}));
    L9:
        e = move-exception;
        throw new com.bytedance.reparo.core.b.e(String.format("write source %s so file failed. ", new Object[]{r6.getName()}), e);
    }

    private void a(i r5) {
        File r4 = this.f.a(this.f9172c, r5);
        com.bytedance.reparo.core.a.b.b.a(r5.f9241d, r4);     // Catch: IOException -> L5
        return;
    L5:
        e = move-exception;
        throw new com.bytedance.reparo.core.b.e(String.format("copy so file %s to %s failed.", new Object[]{r5.f9240c, r4.getAbsolutePath()}), e);
    }
}
