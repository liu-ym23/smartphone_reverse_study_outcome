package com.bytedance.reparo.core.g;

import android.app.Application;
import android.os.Build;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.File;
import java.io.IOException;
import java.util.Enumeration;
import java.util.HashSet;
import java.util.Set;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;

/* JADX INFO: compiled from: AbiHelperImpl.java */
/* JADX INFO: loaded from: classes.dex */
public class b implements a {
    private static final String TAG = "AbiHelper";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private Application f9211a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private String f9212b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private int f9213c;

    public b(Application r3) {
        Application r4 = (Application) ZeusTransformUtils.wrapperContextForParams(r3, Application.class, "com.obric.aiagent.plugin");
        this.f9213c = -1;
        this.f9211a = r4;
    }

    @Override // com.bytedance.reparo.core.g.a
    public String a() {
        if (this.f9212b != null) goto L6;
        this.f9212b = c();
        com.bytedance.reparo.core.j.b(TAG, "parse host abi : " + this.f9212b);
    L6:
        return this.f9212b;
    }

    private String c() {
        ZipFile r6 = new ZipFile(new File(this.f9211a.getApplicationInfo().sourceDir));     // Catch: IOException -> L18
        Set<String> r1 = a(r6);     // Catch: IOException -> L18
        r6.close();     // Catch: IOException -> L18
        int r3 = 0;
        if (Build.VERSION.SDK_INT < 21) goto L6;
        String[] r7 = Build.SUPPORTED_ABIS;     // Catch: IOException -> L18
    L8:
        if (r1.isEmpty() == true) goto L10;
        int r2 = r7.length;     // Catch: IOException -> L18
    L12:
        if (r3 >= r2) goto L17;
        String r4 = r7[r3];     // Catch: IOException -> L18
        if (r1.contains(r4) == true) goto L15;
        r3 = r3 + 1;
        goto L12
    L15:
        return r4;
    L17:
        return "unknown_host_abi";
    L10:
        return r7[0];
    L6:
        r7 = new String[]{Build.CPU_ABI, Build.CPU_ABI2};     // Catch: IOException -> L18
    L18:
        e = move-exception;
        e.printStackTrace();
        com.bytedance.reparo.core.j.b(TAG, "parse host abi failed. ", e);
        return "unknown_host_abi";
    }

    private static Set<String> a(ZipFile r4) {
        Enumeration<? extends ZipEntry> r5 = r4.entries();
        HashSet r0 = new HashSet();
    L4:
        if (r5.hasMoreElements() == false) goto L8;
        String r1 = ((ZipEntry) ZeusTransformUtils.preCheckCast(r5.nextElement(), ZipEntry.class, "com.obric.aiagent.plugin")).getName();
        if (r1.endsWith(".so") == false) goto L4;
        r0.add(r1.split("/")[1]);
        goto L4
    L8:
        return r0;
    }

    @Override // com.bytedance.reparo.core.g.a
    public int b() {
        if (this.f9213c != (-1)) goto L6;
        this.f9213c = d();
    L6:
        return this.f9213c;
    }

    private int d() {
        ZipFile r0 = new ZipFile(new File(this.f9211a.getApplicationInfo().sourceDir));     // Catch: IOException -> L10
        Set<String> r1 = a(r0);     // Catch: IOException -> L10
        r0.close();     // Catch: IOException -> L10
        if (a(r1) == false) goto L6;
        int r2 = 1;
    L7:
        if (b(r1) == true) goto L16;
        return r2;
    L16:
        return r2 | 2;
    L6:
        r2 = 0;
    L10:
        e = move-exception;
        e.printStackTrace();
        com.bytedance.reparo.core.j.b(TAG, "parse host abi failed. ", e);
        return -1;
    }

    private boolean a(Set<String> r2) {
        Set r1 = (Set) ZeusTransformUtils.wrapperContextForParams(r2, Set.class, "com.obric.aiagent.plugin");
        if (r1.contains("armeabi") == false) goto L5;
    L10:
        return true;
    L5:
        if (r1.contains("armeabi-v7a") == true) goto L10;
        if (r1.contains("x86") == true) goto L10;
        return false;
    }

    private boolean b(Set<String> r2) {
        Set r1 = (Set) ZeusTransformUtils.wrapperContextForParams(r2, Set.class, "com.obric.aiagent.plugin");
        if (r1.contains("arm64-v8a") == false) goto L5;
    L8:
        return true;
    L5:
        if (r1.contains("x86_64") == true) goto L8;
        return false;
    }
}
