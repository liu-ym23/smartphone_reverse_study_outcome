package com.bytedance.memory.heap;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Process;
import android.text.TextUtils;
import com.bytedance.apm.c;
import com.bytedance.apm.core.MonitorSharedPreferences;
import com.bytedance.memory.b.h;
import com.bytedance.memory.c.b;
import com.bytedance.memory.g.j;
import com.obric.aikernel.sdk.ext.Params;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import org.json.JSONObject;

/* JADX INFO: compiled from: HeapSaver.java */
/* JADX INFO: loaded from: classes.dex */
public class a {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static volatile a f8839e;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private Context f8840a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private volatile boolean f8841b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private volatile HeapDump f8842c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private volatile SharedPreferences f8843d;
    private boolean f;

    static /* synthetic */ HeapDump a(a r0, HeapDump r1) {
        r0.f8842c = r1;
        return r1;
    }

    static /* synthetic */ void a(a r0) {
        r0.p();
    }

    public static a a() {
        if (f8839e != null) goto L15;
        monitor-enter(a.class);
    L11:
        th = move-exception;
        throw th;
    L7:
        if (f8839e != null) goto L9;
        f8839e = new a((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(com.bytedance.memory.a.a.c().getContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin"));     // Catch: Throwable -> L11
    L9:
        monitor-exit(a.class);     // Catch: Throwable -> L11
    L15:
        return f8839e;
    }

    private a(Context r3) {
        Context r4 = (Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.aiagent.plugin");
        this.f8843d = null;
        this.f8840a = ZeusTransformUtils.wrapperContext((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(r4.getApplicationContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin"), "com.obric.aiagent.plugin");
    }

    public boolean b() {
        return this.f;
    }

    public HeapDump c() {
        return this.f8842c;
    }

    private void b(HeapDump r1) {
        this.f8842c = r1;
    }

    public void a(long r2) {
        this.f = true;
        k().edit().putLong("lastDumpTime", r2).commit();
    }

    public long d() {
        return k().getLong("lastDumpTime", 0);
    }

    public void a(boolean r2) {
        k().edit().putBoolean("hasShrink", r2).commit();
    }

    public boolean e() {
        return k().getBoolean("hasShrink", false);
    }

    public void a(String r2) {
        k().edit().putString("latestFilePath", r2).commit();
    }

    public String f() {
        return k().getString("latestFilePath", "");
    }

    public void b(String r2) {
        k().edit().putString("updateVersionCode", r2).commit();
    }

    public String g() {
        return k().getString("updateVersionCode", "");
    }

    public void a(int r2) {
        k().edit().putInt("hprof_type", r2).commit();
    }

    public int h() {
        return k().getInt("hprof_type", 1);
    }

    public long i() {
        if (a().c() == null) goto L6;
        return a().c().currentTime;
    L6:
        return System.currentTimeMillis();
    }

    public boolean j() {
        long r0 = k().getLong("lastDumpTime", 0);
        if ((System.currentTimeMillis() - r0) >= 28800000) goto L5;
        return true;
    L5:
        return false;
    }

    public SharedPreferences k() {
        if (this.f8843d != null) goto L14;
        monitor-enter(this);
    L10:
        th = move-exception;
        throw th;
    L6:
        if (this.f8843d != null) goto L8;
        this.f8843d = MonitorSharedPreferences.getSharedPreferences(this.f8840a, "MemoryWidgetSp" + c.c());     // Catch: Throwable -> L10
    L8:
        monitor-exit(this);     // Catch: Throwable -> L10
    L14:
        return this.f8843d;
    }

    private String o() {
        return k().getString(Params.FILE_PATH, "");
    }

    private void c(String r2) {
        k().edit().putString(Params.FILE_PATH, r2).commit();
    }

    private void p() {
        c("");
    }

    public void l() {
        if (this.f8841b == false) goto L6;
        return;
    L6:
        if (a().e() == false) goto L10;
        com.bytedance.memory.b.c.a("HeapSaver shrink hasShrinked", new Object[0]);
        com.bytedance.memory.h.a.a();
        return;
    L10:
        if (b.i().e() == false) goto L27;
        String r3 = a().g();
        if (b.i().g().length() > 31457280) goto L14;
    L25:
        com.bytedance.memory.b.c.a("HeapSaver shrink return deleteCache. updateVersionCode:" + r3, new Object[0]);
        a().m();
        return;
    L14:
        if (TextUtils.isEmpty(r3) == true) goto L25;
        this.f8841b = true;
        Process.setThreadPriority(10);
        String r4 = c.q().optString("device_id");
        if (a().c() == null) goto L19;
        long r5 = a().c().currentTime;
    L20:
        File r7 = b.i().g();
        String r8 = r7.getName().substring(0, r7.getName().lastIndexOf("."));
        if (com.bytedance.memory.d.a.d("memory_upload_origin") == false) goto L23;
        a(r3, r4, r5, r7, r8);
    L24:
        b.i().h();
        this.f8841b = false;
        Process.setThreadPriority(0);
        com.bytedance.memory.h.a.a();
        return;
    L23:
        a(r3, r4, r5, r7);
        goto L24
    L19:
        r5 = System.currentTimeMillis();
        goto L20
    }

    private void a(String r8, String r9, long r10, File r12) {
        com.bytedance.memory.b.c.a("shrink begin with path %s, length %s ", new Object[]{r12.getPath(), Long.valueOf(r12.length())});
        File r7 = a(r12);
        if (r7 != null) goto L5;
    L14:
        com.bytedance.memory.b.c.a("shrink failed deleteCache", new Object[0]);
        a().m();
        return;
    L5:
        if (r7.length() < 31457280) goto L7;
    L9:
        com.bytedance.memory.b.c.a("shrink succeed", new Object[0]);
        com.bytedance.memory.d.a.a("shrink_compress_begin");
        long r0 = System.currentTimeMillis();
        File r11 = h.a(r7, true);
        com.bytedance.memory.d.a.a("shrink_compress_time", System.currentTimeMillis() - r0);
        com.bytedance.memory.d.a.a("shrink_compress_end");
        com.bytedance.memory.d.a.a("shrink_compress_size", r11.length() / 1024);
        File r13 = new File(r11.getParent(), new SimpleDateFormat("yyyy_MM_dd_HH_mm_ss").format(new Date(r10)) + "_" + r9 + "_" + r8 + "_shrink.zip");
        if (r11.exists() == false) goto L12;
        r11.renameTo(r13);
    L12:
        a().a(true);
        a().a(r13.getAbsolutePath());
        return;
    L7:
        if (a().h() != 2) goto L9;
        goto L9
    }

    private void a(String r5, String r6, long r7, File r9, String r10) {
        File r4 = new File(b.i().d(), "dump.hprof");
        if (r9.getPath().contains("jpg") == false) goto L5;
        r9.renameTo(r4);
    L5:
        File r11 = new File(b.i().c(), r10.replace("dump", new SimpleDateFormat("yyyy_MM_dd_HH_mm_ss").format(new Date(r7))) + "_" + r6 + "_" + r5 + "_origin.zip");
        com.bytedance.memory.d.a.a("origin_compress_begin");
        long r8 = System.currentTimeMillis();
        h.a(r4, r11);
        com.bytedance.memory.b.c.a("compress origin file succeed", new Object[0]);
        com.bytedance.memory.d.a.a("origin_compress_time", System.currentTimeMillis() - r8);
        com.bytedance.memory.d.a.a("origin_compress_end");
        com.bytedance.memory.d.a.a("origin_compress_size", r11.length() / 1024);
        if (r4.exists() == false) goto L8;
        r4.delete();
    L8:
        a().a(1);
        a().a(true);
        a().a(r11.getAbsolutePath());
    }

    private File a(File r4) {
    L7:
        th = move-exception;
        com.bytedance.services.apm.api.a.a(th, "realShrink failed");
        th.printStackTrace();
        return null;
    L4:
        if (r4.exists() == false) goto L12;
        return j.a(r4, new File(b.i().a(), "dump.hprof"));
    L12:
        return null;
    }

    public void m() {
        com.bytedance.memory.b.b.f8771b.a(new AnonymousClass1(this), "HeapSaver-deleteCache");
    }

    public void n() {
        if (this.f8842c == null) goto L5;
        return;
    L5:
        String r0 = o();
        if (TextUtils.isEmpty(r0) == true) goto L9;
        HeapDump r1 = d(r0);
        com.bytedance.memory.b.c.a("cache heapdump %s", new Object[]{r1});
        b(r1);
        return;
    }

    public File a(HeapDump r5) {
        b(r5);
        File r0 = b.i().f();
        if (r0.exists() == false) goto L5;
        r0.delete();
    L5:
        com.bytedance.memory.b.c.a("analyzedHeapFile.getHeapDumpFilePath() %s", new Object[]{r0.getPath()});
        c(r0.getPath());
        JSONObject r1 = new JSONObject();
        FileOutputStream r2 = null;
        a(r5, r1);     // Catch: Throwable -> L12 Exception -> L14
        FileOutputStream r4 = new FileOutputStream(r0);     // Catch: Throwable -> L12 Exception -> L14
        r4.write(r1.toString().getBytes());     // Catch: Exception -> L10 Throwable -> L20
        r4.close();     // Catch: IOException -> L25
    L9:
        return r0;
    L10:
        e = e;
    L16:
        com.bytedance.memory.b.c.a(e, "Could not save leak analysis result to disk.", new Object[0]);     // Catch: Throwable -> L20
        if (r4 != null) goto L28;
    L19:
        return null;
    L28:
        r4.close();     // Catch: IOException -> L26
    L20:
        th = th;
        r2 = r4;
    L22:
        if (r2 != null) goto L32;
    L24:
        throw th;
    L32:
        r2.close();     // Catch: IOException -> L27
        goto L24
    L14:
        e = e;
        r4 = null;
    L12:
        th = th;
        goto L22
    }

    /* JADX WARN: Not initialized variable reg: 2, insn: 0x006c: MOVE (r1 I:??[OBJECT, ARRAY]) = (r2 I:??[OBJECT, ARRAY]), block:B:28:0x006c */
    private HeapDump d(String r6) {
        File r0 = new File(r6);
        FileInputStream r1 = null;
        if (r0.exists() == true) goto L6;
        p();
        return null;
    L6:
        StringBuilder r7 = new StringBuilder();
        FileInputStream r2 = new FileInputStream(r0);     // Catch: Throwable -> L16 Exception -> L18
    L42:
        int r3 = r2.read();     // Catch: Exception -> L14 Throwable -> L27
        if (r3 == (-1)) goto L11;
        r7.append((char) r3);     // Catch: Exception -> L14 Throwable -> L27
        goto L42
    L11:
        JSONObject r4 = new JSONObject(r7.toString());     // Catch: Exception -> L14 Throwable -> L27
        HeapDump r8 = a(r4, new File(r4.optString("heapDumpFilePath")));     // Catch: Exception -> L14 Throwable -> L27
        this.f8842c = r8;     // Catch: Exception -> L14 Throwable -> L27
        r2.close();     // Catch: IOException -> L32
    L13:
        return r8;
    L14:
        e = e;
    L21:
        if (r0.delete() == false) goto L23;
        com.bytedance.memory.b.c.a(e, "Could not read result file %s, deleted it.", new Object[]{r0});     // Catch: Throwable -> L27
    L24:
        if (r2 != null) goto L35;
    L26:
        return null;
    L35:
        r2.close();     // Catch: IOException -> L33
        goto L26
    L23:
        com.bytedance.memory.b.c.a(e, "Could not read result file %s, could not delete it either.", new Object[]{r0});     // Catch: Throwable -> L27
        goto L24
    L27:
        th = th;
        r1 = r2;
    L29:
        if (r1 != null) goto L39;
    L31:
        throw th;
    L39:
        r1.close();     // Catch: IOException -> L34
    L18:
        e = e;
        r2 = null;
    L16:
        th = th;
        goto L29
    }

    private HeapDump a(JSONObject r3, File r4) {
        return HeapDump.newBuilder().a(r4).a(r3.optLong("currentTime")).b(r3.optLong("heapDumpFileSize")).c(r3.optString("referenceName")).b(r3.optBoolean("isDebug")).d(r3.optLong("gcDurationMs")).c(r3.optLong("watchDurationMs")).e(r3.optLong("dumpDurationMs")).a(r3.optString("shrinkFilePath")).a();
    }

    private void a(HeapDump r3, JSONObject r4) {
        r4.put("heapDumpFilePath", r3.heapDumpFile.getPath());
        r4.put("shrinkFilePath", r3.shrinkFilePath);
        r4.put("heapDumpFileSize", r3.heapDumpFile.length());
        r4.put("referenceName", r3.referenceName);
        r4.put("isDebug", r3.isDebug);
        r4.put("gcDurationMs", r3.gcDurationMs);
        r4.put("watchDurationMs", r3.watchDurationMs);
        r4.put("dumpDurationMs", r3.heapDumpDurationMs);
        r4.put("currentTime", r3.currentTime);
    }
}
