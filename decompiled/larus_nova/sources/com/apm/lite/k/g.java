package com.apm.lite.k;

import com.apm.lite.nativecrash.NativeImpl;
import com.apm.lite.runtime.ConfigManager;
import com.bytedance.security.android.aopcheck.PolarisFileReaderWrapper;
import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import com.bytedance.security.android.aopcheck.PolarisFileWriterWrapper;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;

/* JADX INFO: loaded from: classes39.dex */
public final class g {
    public static void b() {
        ConfigManager r100 = com.apm.lite.e.f29913e;     // Catch: Throwable -> L33
        int r101 = r100.getLogcatDumpCount();     // Catch: Throwable -> L33
        int r102 = r100.getLogcatLevel();     // Catch: Throwable -> L33
        a(com.apm.lite.e.f(), r101, r102);     // Catch: Throwable -> L33
        if (com.apm.lite.e.f29920l == false) goto L44;
        PolarisFileWrapper r103 = new PolarisFileWrapper(n.f(com.apm.lite.e.f29909a), "maps.txt");     // Catch: Throwable -> L33
        if (r103.exists() == true) goto L10;
        r103.getParentFile().mkdirs();     // Catch: Throwable -> L33
        r103.createNewFile();     // Catch: IOException -> L32 Throwable -> L33
    L9:
        NativeImpl.dumpMaps(r103.getAbsolutePath());     // Catch: Throwable -> L33
    L10:
        PolarisFileWrapper r104 = new PolarisFileWrapper(n.f(com.apm.lite.e.f29909a), "fds.txt");     // Catch: Throwable -> L33
        if (r104.exists() == true) goto L16;
        r104.getParentFile().mkdirs();     // Catch: Throwable -> L33
        r104.createNewFile();     // Catch: IOException -> L31 Throwable -> L33
    L15:
        NativeImpl.dumpFds(r104.getAbsolutePath());     // Catch: Throwable -> L33
    L16:
        PolarisFileWrapper r105 = new PolarisFileWrapper(n.f(com.apm.lite.e.f29909a), "meminfo.txt");     // Catch: Throwable -> L33
        if (r105.exists() == true) goto L22;
        r105.getParentFile().mkdirs();     // Catch: Throwable -> L33
        r105.createNewFile();     // Catch: IOException -> L30 Throwable -> L33
    L21:
        NativeImpl.dumpMemInfo(r105.getAbsolutePath());     // Catch: Throwable -> L33
    L22:
        PolarisFileWrapper r106 = new PolarisFileWrapper(n.f(com.apm.lite.e.f29909a), "threads.txt");     // Catch: Throwable -> L33
        if (r106.exists() == true) goto L45;
        r106.getParentFile().mkdirs();     // Catch: Throwable -> L33
        r106.createNewFile();     // Catch: IOException -> L29 Throwable -> L33
    L27:
        NativeImpl.dumpThreads(r106.getAbsolutePath());     // Catch: Throwable -> L33
        return;
    L45:
        return;
    L44:
        return;
    }

    public static PolarisFileWrapper c() {
        PolarisFileWrapper r100 = new PolarisFileWrapper(n.f(com.apm.lite.e.f29909a), "anr_trace.txt");
        if (r100.exists() == false) goto L5;
        return r100;
    L5:
        int r101 = r1.a.f535545a;
        int r102 = 0;
        boolean r103 = true;
        if (r1.a.a(new String[]{"custom_event_settings", "npth_simple_setting", "anr_with_traces_txt"}) == 1) goto L9;
        r103 = false;
    L9:
        if (r103 == true) goto L11;
        return r100;
    L11:
        PolarisFileWrapper r104 = new PolarisFileWrapper("/data/anr/traces.txt");
        if (r104.exists() == true) goto L14;
        return r100;
    L14:
        BufferedReader r105 = null;
        BufferedWriter r106 = null;
        BufferedWriter r107 = null;
        BufferedReader r108 = null;
        r100.getParentFile().mkdirs();     // Catch: Throwable -> L30 IOException -> L34
        BufferedReader r109 = new BufferedReader(new PolarisFileReaderWrapper(r104));     // Catch: Throwable -> L30 IOException -> L34
    L43:
        BufferedWriter r110 = new BufferedWriter(new PolarisFileWriterWrapper(r100));     // Catch: Throwable -> L27 IOException -> L38
    L39:
        String r111 = r109.readLine();     // Catch: Throwable -> L24 IOException -> L26
        if (r111 == null) goto L23;
        r110.write(r111);     // Catch: Throwable -> L24 IOException -> L26
        r110.write(10);     // Catch: Throwable -> L24 IOException -> L26
        r102 = r102 + r111.length();
        if (r102 < 1048576) goto L39;
    L23:
        j.a(r109);
    L36:
        j.a(r110);
        return r100;
    L26:
        r106 = r110;
    L24:
        th = th;
        r107 = r110;
    L28:
        BufferedWriter r112 = r107;
        r105 = r109;
    L32:
        j.a(r105);
        j.a(r112);
        throw th;
    L27:
        th = th;
    L29:
        r110 = r106;
        r108 = r109;
    L35:
        j.a(r108);
    L34:
        r110 = null;
    L30:
        th = th;
        r112 = null;
        goto L32
    }

    public static PolarisFileWrapper a(String r100, int r101, int r102) {
        PolarisFileWrapper r103 = new PolarisFileWrapper(n.b(com.apm.lite.e.f29909a, r100), "logcat.txt");
        if (r103.exists() == true) goto L5;
    L7:
        r103.getParentFile().mkdirs();
        r103.createNewFile();     // Catch: IOException -> L11
    L9:
        NativeImpl.dumpLogcat(r103.getAbsolutePath(), String.valueOf(r101), String.valueOf(r102));
        return r103;
    L5:
        if (r103.length() <= 0) goto L7;
        return r103;
    }
}
