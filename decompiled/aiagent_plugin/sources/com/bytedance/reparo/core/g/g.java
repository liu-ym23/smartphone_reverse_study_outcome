package com.bytedance.reparo.core.g;

import android.text.TextUtils;
import com.ss.android.socialbase.downloader.constants.DownloadConstants;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.File;
import java.io.IOException;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;

/* JADX INFO: compiled from: PatchFileParser.java */
/* JADX INFO: loaded from: classes.dex */
public class g {
    private static final String TAG = "PatchFileParser";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private com.bytedance.reparo.core.e f9226a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private File f9227b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private a f9228c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private File f9229d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private File f9230e;
    private File f;
    private Map<String, j> g;

    public g(File r3, a r4, File r5, com.bytedance.reparo.core.e r6) {
        a r7 = (a) ZeusTransformUtils.wrapperContextForParams(r4, a.class, "com.obric.aiagent.plugin");
        this.g = new HashMap();
        this.f9227b = r3;
        this.f9228c = r7;
        this.f9229d = r5;
        this.f9226a = r6;
        this.f9230e = new File(r5, "so-info.txt");
        this.f = new File(r5, "java");
    }

    public String a() {
        return this.f9228c.a();
    }

    public void b() {
        ZipFile r0 = new ZipFile(this.f9227b);     // Catch: IOException -> L11
        Enumeration<? extends ZipEntry> r1 = r0.entries();     // Catch: IOException -> L11
    L4:
        if (r1.hasMoreElements() == false) goto L9;
        ZipEntry r2 = (ZipEntry) ZeusTransformUtils.preCheckCast(r1.nextElement(), ZipEntry.class, "com.obric.aiagent.plugin");     // Catch: IOException -> L11
        if (r2.getName().contains(DownloadConstants.VULNERABILITY_PATH) == true) goto L4;
        a(r0, r2);     // Catch: IOException -> L11
        goto L4
    L9:
        r0.close();     // Catch: IOException -> L11
        h();     // Catch: IOException -> L11
        return;
    L11:
        e = move-exception;
        throw new com.bytedance.reparo.core.b.g(e.getMessage(), e, 400);
    }

    private void h() {
        List<k.a> r0 = k.a(this.f9230e);
        if (r0 != null) goto L5;
        return;
    L5:
        if (r0.size() == 0) goto L28;
        Iterator<k.a> r1 = r0.iterator();
    L9:
        if (r1.hasNext() == false) goto L29;
        final k.a r2 = (k.a) ZeusTransformUtils.preCheckCast(r1.next(), k.a.class, "com.obric.aiagent.plugin");
        Iterator<String> r3 = this.g.keySet().iterator();
    L12:
        if (r3.hasNext() == false) goto L9;
        String r4 = (String) ZeusTransformUtils.preCheckCast(r3.next(), String.class, "com.obric.aiagent.plugin");
        j r5 = (j) ZeusTransformUtils.preCheckCast(this.g.get(r4), j.class, "com.obric.aiagent.plugin");
        if (r5 == null) goto L12;
        i r6 = r5.a(new AnonymousClass1(this, r2));
        if (r6 == null) goto L12;
        r6.f = r2.f9249b;
        goto L12
    L29:
        return;
    }

    private void a(ZipFile r3, ZipEntry r4) {
        if (this.f9226a.f9181b == false) goto L13;
        if (r4.getName().endsWith(".so") == false) goto L9;
        d(r3, r4);
        return;
    L9:
        if (TextUtils.equals(r4.getName(), "so-info.txt") == false) goto L13;
        b(r3, r4);
        return;
    L13:
        if (TextUtils.equals(r4.getName(), "patch_classes_methods.txt") == false) goto L15;
    L20:
        c(r3, r4);
        return;
    L15:
        if (TextUtils.equals(r4.getName(), "added_classes.txt") == true) goto L20;
        if (r4.getName().startsWith("deoptimize_methods") == true) goto L20;
        if (r4.getName().endsWith(".dex") == true) goto L20;
    }

    private void b(ZipFile r2, ZipEntry r3) {
        com.bytedance.reparo.core.a.b.b.a(r2.getInputStream(r3), this.f9230e);     // Catch: IOException -> L4
        return;
    L4:
        e = move-exception;
        throw new com.bytedance.reparo.core.b.g("parse so-info.txt failed. ", e, 401);
    }

    private void c(ZipFile r5, ZipEntry r6) {
        if (r6.getSize() > 0) goto L10;
        return;
    L10:
        com.bytedance.reparo.core.a.b.b.a(r5.getInputStream(r6), new File(this.f, r6.getName()));     // Catch: IOException -> L7
        return;
    L7:
        e = move-exception;
        throw new com.bytedance.reparo.core.b.g("parse " + r6.getName() + " failed.", e, 402);
    }

    private void d(ZipFile r5, ZipEntry r6) {
        String r0 = this.f9228c.a();
        i r1 = j.a(r6.getName());
        r1.f9242e = r6.getCrc();
    L11:
        e = move-exception;
        throw new com.bytedance.reparo.core.b.g("parse patch so entry failed. ", e, 403);
    L4:
        if (TextUtils.equals(r0, r1.f9238a) == false) goto L6;
        r1.f9241d = com.bytedance.reparo.core.a.b.b.a(r5.getInputStream(r6), new File(this.f9229d, r6.getName()));     // Catch: IOException -> L11
    L6:
        j r7 = (j) ZeusTransformUtils.preCheckCast(this.g.get(r1.f9238a), j.class, "com.obric.aiagent.plugin");     // Catch: IOException -> L11
        if (r7 != null) goto L9;
        r7 = new j(r1.f9238a);     // Catch: IOException -> L11
        this.g.put(r1.f9238a, r7);     // Catch: IOException -> L11
    L9:
        r7.a(r1);     // Catch: IOException -> L11
    }

    public File c() {
        return this.f9230e;
    }

    public j d() {
        return (j) ZeusTransformUtils.preCheckCast(this.g.get(this.f9228c.a()), j.class, "com.obric.aiagent.plugin");
    }

    public boolean e() {
        return !this.g.isEmpty();
    }

    public boolean f() {
        return !com.bytedance.reparo.core.a.b.b.d(this.f);
    }

    public File g() {
        return this.f;
    }
}
