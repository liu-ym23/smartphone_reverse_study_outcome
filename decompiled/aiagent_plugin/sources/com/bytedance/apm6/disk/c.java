package com.bytedance.apm6.disk;

import android.app.Application;
import android.app.usage.StorageStats;
import android.app.usage.StorageStatsManager;
import android.content.Context;
import android.os.Build;
import android.os.Environment;
import android.os.storage.StorageManager;
import android.os.storage.StorageVolume;
import android.text.TextUtils;
import android.util.Log;
import android.util.Pair;
import com.bytedance.apm.g.f;
import com.bytedance.apm.util.y;
import com.bytedance.common.wschannel.WsConstants;
import com.bytedance.crash.dumper.Scraps;
import com.ss.android.socialbase.downloader.constants.DownloadConstants;
import com.ss.android.socialbase.downloader.constants.MonitorConstants;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.File;
import java.lang.reflect.Method;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.UUID;
import me.ele.lancet.base.annotations.Skip;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: DiskStatistics.java */
/* JADX INFO: loaded from: classes.dex */
public class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static c f5297a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private String f5298b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private String f5299c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private String f5300d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private String f5301e;
    private volatile boolean f;
    private List<String> g;
    private List<String> h;
    private List<String> i;
    private boolean j;
    private com.bytedance.apm6.disk.a.a k;
    private long l;
    private long m;
    private long n;
    private long o;
    private f p;

    /* JADX INFO: renamed from: com.bytedance.apm6.disk.c$1, reason: invalid class name */
    /* JADX INFO: compiled from: DiskStatistics.java */
    static /* synthetic */ class AnonymousClass1 {
    }

    /* JADX INFO: compiled from: DiskStatistics.java */
    private class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public String f5302a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public long f5303b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public float f5304c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public boolean f5305d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public String f5306e;
        public List<a> f;
        final /* synthetic */ c g;

        private a(c r1) {
            this.g = r1;
            this.f5306e = "normal";
            this.f = new ArrayList();
        }

        /* synthetic */ a(c r1, AnonymousClass1 r2) {
            this(r1);
        }

        public JSONObject a() {
            JSONObject r0 = new JSONObject();
            r0.put(DownloadConstants.PATH_KEY, b());     // Catch: JSONException -> L11
            r0.put(MonitorConstants.SIZE, this.f5303b);     // Catch: JSONException -> L11
            r0.put("size_rate", this.f5304c);     // Catch: JSONException -> L11
            r0.put("is_folder", this.f5305d);     // Catch: JSONException -> L11
            r0.put("report_type", this.f5306e);     // Catch: JSONException -> L11
            if (this.f.isEmpty() == true) goto L13;
            JSONArray r1 = new JSONArray();     // Catch: JSONException -> L11
            Iterator<a> r5 = this.f.iterator();     // Catch: JSONException -> L11
        L7:
            if (r5.hasNext() == false) goto L9;
            r1.put(((a) ZeusTransformUtils.preCheckCast(r5.next(), a.class, "com.obric.aiagent.plugin")).a());     // Catch: JSONException -> L11
            goto L7
        L9:
            r0.put("next_disk", r1);     // Catch: JSONException -> L11
        L13:
            return r0;
        L11:
            e = move-exception;
            e.printStackTrace();
            goto L13
        }

        private String b() {
            String r0 = this.f5302a;
            String r1 = c.a(this.g, r0);
            if (r1 == null) goto L6;
            r0 = r1;
        L6:
            if (r0.contains(c.a(this.g)) == false) goto L9;
            return r0.replace(c.a(this.g), "internal");
        L9:
            if (r0.contains(c.b(this.g)) == true) goto L11;
            return r0;
        L11:
            return r0.replace(c.b(this.g), "external");
        }
    }

    /* JADX INFO: compiled from: DiskStatistics.java */
    private class b implements Comparable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public long f5307a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ c f5308b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private String f5309c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private int f5310d;

        static /* synthetic */ String a(b r0) {
            return r0.f5309c;
        }

        public b(c r1) {
            this.f5308b = r1;
        }

        public b(c r1, String r2, long r3, int r5) {
            this.f5308b = r1;
            this.f5309c = r2;
            this.f5307a = r3;
            this.f5310d = r5;
        }

        public JSONObject a() {
            JSONObject r0 = new JSONObject();     // Catch: Exception -> L6
            r0.put("name", b());     // Catch: Exception -> L6
            r0.put(MonitorConstants.SIZE, this.f5307a);     // Catch: Exception -> L6
            int r4 = this.f5310d;     // Catch: Exception -> L6
            if (r4 <= 0) goto L5;
            r0.put("num", r4);     // Catch: Exception -> L6
        L5:
            return r0;
        L6:
            return null;
        }

        @Override // java.lang.Comparable
        public int compareTo(Object r4) {
            b r5 = (b) ZeusTransformUtils.preCheckCast(r4, b.class, "com.obric.aiagent.plugin");
            long r0 = this.f5307a;
            long r3 = r5.f5307a;
            if (r0 != r3) goto L7;
            return 0;
        L7:
            if (r0 <= r3) goto L10;
            return 1;
        L10:
            return -1;
        }

        private String b() {
            String r0 = this.f5309c;
            String r1 = c.a(this.f5308b, r0);
            if (r1 == null) goto L6;
            r0 = r1;
        L6:
            if (r0.contains(c.a(this.f5308b)) == false) goto L9;
            return r0.replace(c.a(this.f5308b), "internal");
        L9:
            if (r0.contains(c.b(this.f5308b)) == true) goto L11;
            return r0;
        L11:
            return r0.replace(c.b(this.f5308b), "external");
        }
    }

    /* JADX INFO: renamed from: com.bytedance.apm6.disk.c$c, reason: collision with other inner class name */
    /* JADX INFO: compiled from: DiskStatistics.java */
    private class C0130c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public C0130c f5311a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public long f5312b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ c f5313c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private String f5314d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private int f5315e;
        private int f;
        private boolean g;
        private long h;
        private boolean i;

        private C0130c(c r1) {
            this.f5313c = r1;
        }

        /* synthetic */ C0130c(c r1, AnonymousClass1 r2) {
            this(r1);
        }

        static /* synthetic */ int a(C0130c r0, int r1) {
            r0.f5315e = r1;
            return r1;
        }

        static /* synthetic */ long a(C0130c r0, long r1) {
            r0.h = r1;
            return r1;
        }

        static /* synthetic */ String a(C0130c r0) {
            return r0.f5314d;
        }

        static /* synthetic */ String a(C0130c r0, String r1) {
            r0.f5314d = r1;
            return r1;
        }

        static /* synthetic */ boolean a(C0130c r0, boolean r1) {
            r0.g = r1;
            return r1;
        }

        static /* synthetic */ int b(C0130c r2) {
            int r0 = r2.f5315e;
            r2.f5315e = r0 - 1;
            return r0;
        }

        static /* synthetic */ boolean c(C0130c r0) {
            return r0.g;
        }

        public boolean a() {
            if (this.f != this.f5315e) goto L5;
            return true;
        L5:
            return false;
        }

        public void a(long r9, y<b> r11, y<b> r12) {
            this.f5312b += r9;
            this.f++;
            if (this.f5311a != null) goto L5;
            return;
        L5:
            if (a() == true) goto L7;
            return;
        L7:
            if (this.i == false) goto L10;
            this.f5311a.i = true;
        L10:
            if (this.f5312b >= c.c(this.f5313c).c()) goto L12;
        L17:
            this.f5311a.a(this.f5312b, r11, r12);
            if (this.g == true) goto L20;
            return;
        L20:
            if (this.f5313c.a(this.f5312b) == false) goto L26;
            c r1 = this.f5313c;
            String r2 = this.f5314d;
            long r3 = this.f5312b;
            int r5 = this.f5315e;
            r11.a(new d(r1, r2, r3, r5, r5));
            return;
        L26:
            return;
        L12:
            if (this.i == true) goto L17;
            if (c.a(this.f5313c, this.f5312b) == true) goto L16;
            r12.a(new b(this.f5313c, this.f5314d, this.f5312b, this.f5315e));
        L16:
            this.f5311a.i = true;
            goto L17
        }
    }

    /* JADX INFO: compiled from: DiskStatistics.java */
    private class d extends b {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public long f5316c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        final /* synthetic */ c f5317d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private final String f5318e;
        private int f;
        private long g;

        public d(c r1, String r2, long r3, int r5, long r6) {
            this.f5317d = r1;
            super(r1);
            this.f5318e = r2;
            this.f5316c = r3;
            this.f = r5;
            this.g = r6;
        }

        @Override // com.bytedance.apm6.disk.c.b
        public JSONObject a() {
            JSONObject r0 = new JSONObject();     // Catch: Exception -> L7
            r0.put("name", b());     // Catch: Exception -> L7
            r0.put(MonitorConstants.SIZE, this.f5316c);     // Catch: Exception -> L7
            int r1 = this.f;     // Catch: Exception -> L7
            if (r1 <= 0) goto L5;
            r0.put("num", r1);     // Catch: Exception -> L7
        L5:
            r0.put("outdate_interval", this.g);     // Catch: Exception -> L7
            return r0;
        L7:
            return null;
        }

        @Override // com.bytedance.apm6.disk.c.b, java.lang.Comparable
        public int compareTo(Object r4) {
            d r5 = (d) ZeusTransformUtils.preCheckCast(r4, d.class, "com.obric.aiagent.plugin");
            long r0 = this.g;
            long r3 = r5.g;
            if (r0 != r3) goto L7;
            return 0;
        L7:
            if (r0 <= r3) goto L10;
            return 1;
        L10:
            return -1;
        }

        private String b() {
            String r0 = this.f5318e;
            String r1 = c.a(this.f5317d, r0);
            if (r1 == null) goto L6;
            r0 = r1;
        L6:
            if (r0.contains(c.a(this.f5317d)) == false) goto L9;
            return r0.replace(c.a(this.f5317d), "internal");
        L9:
            if (r0.contains(c.b(this.f5317d)) == true) goto L11;
            return r0;
        L11:
            return r0.replace(c.b(this.f5317d), "external");
        }
    }

    private boolean b(long r3) {
        if (r3 >= 0) goto L5;
    L8:
        return true;
    L5:
        if (r3 > 17179869184L) goto L8;
        return false;
    }

    boolean a(long r3) {
        if (r3 >= 104857600) goto L5;
    L7:
        return false;
    L5:
        if (r3 > 17179869184L) goto L7;
        return true;
    }

    static /* synthetic */ String a(c r0) {
        return r0.f5298b;
    }

    static /* synthetic */ String a(c r0, String r1) {
        return r0.a(r1);
    }

    static /* synthetic */ boolean a(c r0, long r1) {
        return r0.b(r1);
    }

    static /* synthetic */ String b(c r0) {
        return r0.f5300d;
    }

    static /* synthetic */ com.bytedance.apm6.disk.a.a c(c r0) {
        return r0.k;
    }

    static {
        f5297a = new c();
    }

    private c() {
        this.f = false;
        this.l = 0;
        this.m = 0;
        this.n = 0;
        this.o = 0;
    }

    public static c a() {
        return f5297a;
    }

    com.bytedance.apm6.disk.b a(com.bytedance.apm6.disk.a.a r3) {
        if (r3 != null) goto L6;
        return null;
    L6:
        if (this.f == false) goto L8;
        return null;
    L8:
        this.k = r3;
        f();
        this.g = b(r3.j());
        this.h = b(r3.i());
        this.i = b(r3.k());
        return b();
    }

    public void a(f r3) {
        this.p = (f) ZeusTransformUtils.wrapperContextForParams(r3, f.class, "com.obric.aiagent.plugin");
    }

    private com.bytedance.apm6.disk.b b() {
        ArrayList r0 = new ArrayList();
        a(new File(this.f5298b), r0);
        a(new File(this.f5300d), r0);
        ArrayList r1 = new ArrayList();
        Iterator<a> r2 = r0.iterator();
    L4:
        if (r2.hasNext() == false) goto L13;
        a r3 = (a) ZeusTransformUtils.preCheckCast(r2.next(), a.class, "com.obric.aiagent.plugin");
        boolean r5 = true;
        Iterator<a> r6 = r3.f.iterator();
    L7:
        if (r6.hasNext() == false) goto L11;
        if (((a) ZeusTransformUtils.preCheckCast(r6.next(), a.class, "com.obric.aiagent.plugin")).f5305d == false) goto L7;
        r5 = false;
    L11:
        if (r5 == false) goto L4;
        r1.remove(r3);
        goto L4
    L13:
        r0.removeAll(r1);
        if (com.bytedance.apm6.foundation.context.a.u() == false) goto L19;
        Iterator<a> r4 = r0.iterator();
    L17:
        if (r4.hasNext() == false) goto L19;
        com.bytedance.apm6.util.c.b.a("APM-Disk", "diskInfoNodes:" + ((a) ZeusTransformUtils.preCheckCast(r4.next(), a.class, "com.obric.aiagent.plugin")).a());
    L19:
        y<b> r7 = new y(this.k.f());
        y<b> r8 = new y(this.k.g());
        y<b> r11 = new y(this.k.e());
        List<String> r12 = new ArrayList();
        r12.add(this.f5298b);
        r12.add(this.f5299c);
        a(a(this.f5298b, r7, r8, r11, r12));
        r12.clear();
        r12.add(this.f5301e);
        r12.add(this.f5300d);
        a(a(this.f5300d, r7, r8, r11, r12));
        if (com.bytedance.apm6.foundation.context.a.u() == false) goto L34;
        Iterator r9 = r7.a().iterator();
    L23:
        if (r9.hasNext() == false) goto L25;
        com.bytedance.apm6.util.c.b.a("APM-Disk", "fileListTopK:" + ((b) ZeusTransformUtils.preCheckCast(r9.next(), b.class, "com.obric.aiagent.plugin")).a());
        goto L23
    L25:
        Iterator r10 = r8.a().iterator();
    L27:
        if (r10.hasNext() == false) goto L29;
        com.bytedance.apm6.util.c.b.a("APM-Disk", "dirListTopK:" + ((b) ZeusTransformUtils.preCheckCast(r10.next(), b.class, "com.obric.aiagent.plugin")).a());
        goto L27
    L29:
        Iterator r13 = r11.a().iterator();
    L31:
        if (r13.hasNext() == false) goto L33;
        com.bytedance.apm6.util.c.b.a("APM-Disk", "outdatedListTopK:" + ((b) ZeusTransformUtils.preCheckCast(r13.next(), b.class, "com.obric.aiagent.plugin")).a());
        goto L31
    L33:
        com.bytedance.apm6.util.c.b.a("APM-Disk", "insideDataSize:" + this.l + " outsideDataSize:" + this.m + " insideCacheSize:" + this.n + " outsideCacheSize:" + this.o);
    L34:
        c(r0);
        return a(r7, r8, r11, r0);
    }

    private void a(List<C0130c> r5) {
        List r6 = (List) ZeusTransformUtils.wrapperContextForParams(r5, List.class, "com.obric.aiagent.plugin");
        if (com.bytedance.apm6.util.f.a(r6) == false) goto L5;
        return;
    L5:
        Iterator r7 = r6.iterator();
    L7:
        if (r7.hasNext() == false) goto L20;
        C0130c r0 = (C0130c) ZeusTransformUtils.preCheckCast(r7.next(), C0130c.class, "com.obric.aiagent.plugin");
        if (TextUtils.equals(C0130c.a(r0), this.f5298b) == true) goto L10;
        if (TextUtils.equals(C0130c.a(r0), this.f5300d) == true) goto L13;
        if (TextUtils.equals(C0130c.a(r0), this.f5299c) == true) goto L16;
        if (TextUtils.equals(C0130c.a(r0), this.f5301e) == false) goto L7;
        this.o = r0.f5312b;
        goto L7
    L16:
        this.n = r0.f5312b;
        goto L7
    L13:
        this.m = r0.f5312b;
        goto L7
    L10:
        this.l = r0.f5312b;
        goto L7
    }

    private com.bytedance.apm6.disk.b a(y<b> r31, y<b> r32, y<b> r33, List<a> r34) {
        List<a> r2 = (List) ZeusTransformUtils.wrapperContextForParams(r34, List.class, "com.obric.aiagent.plugin");
        long r10 = this.l + this.m;     // Catch: Throwable -> L15
        long r5 = this.n + this.o;     // Catch: Throwable -> L15
        long r14 = Environment.getDataDirectory().getTotalSpace() + Environment.getRootDirectory().getTotalSpace();     // Catch: Throwable -> L15
        long r16 = Environment.getDataDirectory().getFreeSpace();     // Catch: Throwable -> L15
        long r12 = Math.min(r10, 17179869184L);     // Catch: Throwable -> L15
        long r6 = Math.min(r5, 17179869184L);     // Catch: Throwable -> L15
        if (r12 >= 0) goto L7;
        return null;
    L7:
        if (this.p == null) goto L9;
        this.p.a(this.k.b(), r12, b(r31), b(r32), b(r33));     // Catch: Throwable -> L15
    L9:
        Pair<Long, Long> r7 = c();     // Catch: Throwable -> L15
        long r8 = d();     // Catch: Throwable -> L15
        if (com.bytedance.apm6.foundation.context.a.u() == false) goto L13;
        com.bytedance.apm6.util.c.b.a("APM-Disk", "appUsage:" + r8);     // Catch: Throwable -> L15
    L13:
        return new com.bytedance.apm6.disk.b(r10, r6, r14, r16, r8, ((Long) ZeusTransformUtils.preCheckCast(r7.first, Long.class, "com.obric.aiagent.plugin")).longValue(), ((Long) ZeusTransformUtils.preCheckCast(r7.second, Long.class, "com.obric.aiagent.plugin")).longValue(), a(r8, new BigDecimal(r14)), a(r31), a(r32), a(r33), a(r2, r12));
    L15:
        th = move-exception;
        a("APM-Disk", WsConstants.KEY_CONNECTION_ERROR, th);
        return null;
    }

    private Pair<Long, Long> c() {
        long r2 = 0;
        if (Build.VERSION.SDK_INT < 26) goto L17;
        StorageStatsManager r14 = (StorageStatsManager) ZeusTransformUtils.preCheckCast(((Application) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(com.bytedance.apm6.foundation.context.a.getContext(), "com.obric.aiagent.plugin"), Application.class, "com.obric.aiagent.plugin")).getSystemService("storagestats"), StorageStatsManager.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L34
        StorageManager r0 = (StorageManager) ZeusTransformUtils.preCheckCast(((Application) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(com.bytedance.apm6.foundation.context.a.getContext(), "com.obric.aiagent.plugin"), Application.class, "com.obric.aiagent.plugin")).getSystemService(Scraps.STORAGE), StorageManager.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L34
        Iterator<StorageVolume> r1 = r0.getStorageVolumes().iterator();     // Catch: Throwable -> L34
        long r9 = 0;
    L7:
        if (r1.hasNext() == false) goto L14;
        String r11 = ((StorageVolume) ZeusTransformUtils.preCheckCast(r1.next(), StorageVolume.class, "com.obric.aiagent.plugin")).getUuid();     // Catch: Throwable -> L34
        if (r11 != null) goto L11;
        UUID r12 = StorageManager.UUID_DEFAULT;     // Catch: Throwable -> L34
    L12:
        r2 = r2 + r14.getTotalBytes(r12);     // Catch: Throwable -> L34
        r9 = r9 + r0.getAllocatableBytes(r12);     // Catch: Throwable -> L34
        goto L7
    L11:
        r12 = UUID.fromString(r11);     // Catch: Throwable -> L34
        goto L12
    L14:
        return new Pair(Long.valueOf((((r2 / 1000) / 1000) * 1024) * 1024), Long.valueOf((((r9 / 1000) / 1000) * 1024) * 1024));
    L17:
        if (Build.VERSION.SDK_INT < 24) goto L28;
        List<StorageVolume> r15 = ((StorageManager) ZeusTransformUtils.preCheckCast(((Application) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(com.bytedance.apm6.foundation.context.a.getContext(), "com.obric.aiagent.plugin"), Application.class, "com.obric.aiagent.plugin")).getSystemService(Scraps.STORAGE), StorageManager.class, "com.obric.aiagent.plugin")).getStorageVolumes();     // Catch: Throwable -> L34
        if (com.bytedance.apm6.util.f.a(r15) == false) goto L22;
        return null;
    L22:
        Iterator<StorageVolume> r16 = r15.iterator();     // Catch: Throwable -> L34
        long r3 = 0;
    L24:
        if (r16.hasNext() == false) goto L27;
        StorageVolume r13 = (StorageVolume) ZeusTransformUtils.preCheckCast(r16.next(), StorageVolume.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L34
        File r17 = (File) ZeusTransformUtils.preCheckCast(a(r13.getClass(), "getPathFile", new Class[0]).invoke(r13, new Object[0]), File.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L34
        r2 = r2 + r17.getTotalSpace();     // Catch: Throwable -> L34
        r3 = r3 + r17.getFreeSpace();     // Catch: Throwable -> L34
        goto L24
    L27:
        return new Pair(Long.valueOf((((r2 / 1000) / 1000) * 1024) * 1024), Long.valueOf((((r3 / 1000) / 1000) * 1024) * 1024));
    L28:
        StorageManager r18 = (StorageManager) ZeusTransformUtils.preCheckCast(((Application) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(com.bytedance.apm6.foundation.context.a.getContext(), "com.obric.aiagent.plugin"), Application.class, "com.obric.aiagent.plugin")).getSystemService(Scraps.STORAGE), StorageManager.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L34
        Iterator r19 = ((List) ZeusTransformUtils.preCheckCast(a(r18.getClass(), "getVolumes", new Class[0]).invoke(r18, new Object[0]), List.class, "com.obric.aiagent.plugin")).iterator();     // Catch: Throwable -> L34
        long r4 = 0;
    L30:
        if (r19.hasNext() == false) goto L33;
        Object r5 = r19.next();     // Catch: Throwable -> L34
        File r6 = (File) ZeusTransformUtils.preCheckCast(a(r5.getClass(), "getPathFile", new Class[0]).invoke(r5, new Object[0]), File.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L34
        r4 = r4 + r6.getFreeSpace();     // Catch: Throwable -> L34
        r2 = r2 + r6.getFreeSpace();     // Catch: Throwable -> L34
        goto L30
    L33:
        return new Pair(Long.valueOf(r2), Long.valueOf(r4));
    L35:
        return new Pair(Long.valueOf(com.bytedance.apm6.util.c.b(Environment.getDataDirectory().getPath()) + com.bytedance.apm6.util.c.b(Environment.getRootDirectory().getPath())), Long.valueOf(com.bytedance.apm6.util.c.a(Environment.getDataDirectory().getPath())));
    }

    private static Method a(Class r7, String r8, Class<?>... r9) {
        Method r10 = (Method) ZeusTransformUtils.preCheckCast(Class.class.getDeclaredMethod("getDeclaredMethod", new Class[]{String.class, Class[].class}).invoke(r7, new Object[]{r8, r9}), Method.class, "com.obric.aiagent.plugin");     // Catch: Exception -> L4
        r10.setAccessible(true);     // Catch: Exception -> L4
        return r10;
    L4:
        return null;
    }

    private long d() {
        if (Build.VERSION.SDK_INT < 26) goto L20;
        Application r0 = (Application) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(com.bytedance.apm6.foundation.context.a.getContext(), "com.obric.aiagent.plugin"), Application.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L17
        String r4 = r0.getPackageName();     // Catch: Throwable -> L17
        StorageStats r1 = ((StorageStatsManager) ZeusTransformUtils.preCheckCast(r0.getSystemService("storagestats"), StorageStatsManager.class, "com.obric.aiagent.plugin")).queryStatsForUid(((StorageManager) ZeusTransformUtils.preCheckCast(r0.getSystemService(Scraps.STORAGE), StorageManager.class, "com.obric.aiagent.plugin")).getUuidForPath(new File(r0.getDataDir().getParent(), r4)), r0.getPackageManager().getApplicationInfo(r4, 128).uid);     // Catch: Throwable -> L17
        if (com.bytedance.apm6.foundation.context.a.u() == false) goto L7;
        a("APM-Disk", "storageStats.getAppBytes():" + r1.getAppBytes());     // Catch: Throwable -> L17
    L7:
        return r1.getAppBytes();
    L20:
        long r3 = b(new File(((Application) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(com.bytedance.apm6.foundation.context.a.getContext(), "com.obric.aiagent.plugin"), Application.class, "com.obric.aiagent.plugin")).getPackageManager().getApplicationInfo(((Application) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(com.bytedance.apm6.foundation.context.a.getContext(), "com.obric.aiagent.plugin"), Application.class, "com.obric.aiagent.plugin")).getPackageName(), 0).sourceDir).getParentFile());     // Catch: Exception -> L15
        if (com.bytedance.apm6.foundation.context.a.u() == false) goto L12;
        a("APM-Disk", "storageStats.getAppBytes():" + (((e() + r3) + this.l) + this.m));     // Catch: Exception -> L15
    L12:
        return ((r3 + e()) + this.l) + this.m;
    L15:
        return 0;
    }

    private long e() {
        long r1 = 0;
        if (Build.VERSION.SDK_INT < 21) goto L7;
        File[] r0 = ((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(((Application) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(com.bytedance.apm6.foundation.context.a.getContext(), "com.obric.aiagent.plugin"), Application.class, "com.obric.aiagent.plugin")).getApplicationContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin")).getExternalMediaDirs();
        int r3 = r0.length;
        int r4 = 0;
    L5:
        if (r4 >= r3) goto L7;
        r1 = r1 + b(r0[r4]);
        r4 = r4 + 1;
    L7:
        return r1;
    }

    private JSONArray a(List<a> r8, long r9) {
        List r10 = (List) ZeusTransformUtils.wrapperContextForParams(r8, List.class, "com.obric.aiagent.plugin");
        if (r10 != null) goto L5;
        return null;
    L5:
        if (r10.isEmpty() == true) goto L37;
        BigDecimal r0 = new BigDecimal(r9);
        JSONArray r11 = new JSONArray();
        Iterator r12 = r10.iterator();
    L8:
        if (r12.hasNext() == false) goto L25;
        a r13 = (a) ZeusTransformUtils.preCheckCast(r12.next(), a.class, "com.obric.aiagent.plugin");
        if (a(r13) == false) goto L12;
        r13.f5304c = 0.0f;
    L13:
        List<a> r2 = r13.f;
        if (r2 == null) goto L24;
        if (r2.size() <= 0) goto L24;
        Iterator<a> r3 = r2.iterator();
    L19:
        if (r3.hasNext() == false) goto L24;
        a r4 = (a) ZeusTransformUtils.preCheckCast(r3.next(), a.class, "com.obric.aiagent.plugin");
        if (a(r4) == true) goto L22;
        r4.f5304c = a(r4.f5303b, r0);
        goto L19
    L22:
        r4.f5304c = 0.0f;
    L24:
        r11.put(r13.a());
        goto L8
    L12:
        r13.f5304c = a(r13.f5303b, r0);
        goto L13
    L25:
        return r11;
    L37:
        return null;
    }

    private float a(long r1, BigDecimal r3) {
        return (float) new BigDecimal(r1).divide(r3, 4, 4).doubleValue();
    }

    private boolean a(a r4) {
        Iterator<String> r3 = this.g.iterator();
    L4:
        if (r3.hasNext() == false) goto L9;
        String r0 = (String) ZeusTransformUtils.preCheckCast(r3.next(), String.class, "com.obric.aiagent.plugin");
        if (r4.f5302a.contains(r0) == false) goto L4;
        return true;
    L9:
        return false;
    }

    private List<String> b(List<String> r6) {
        List r7 = (List) ZeusTransformUtils.wrapperContextForParams(r6, List.class, "com.obric.aiagent.plugin");
        ArrayList r0 = new ArrayList();
        if (com.bytedance.apm6.util.f.a(r7) == false) goto L5;
        return r0;
    L5:
        Iterator r8 = r7.iterator();
    L7:
        if (r8.hasNext() == false) goto L14;
        String r2 = (String) ZeusTransformUtils.preCheckCast(r8.next(), String.class, "com.obric.aiagent.plugin");
        if (r2.contains("internal") == true) goto L10;
        if (r2.contains("external") == false) goto L7;
        r0.add(r2.replace("external", this.f5300d));
        goto L7
    L10:
        r0.add(r2.replace("internal", this.f5298b));
        goto L7
    L14:
        return r0;
    }

    private static List<String> b(y<? extends b> r4) {
        if (r4 != null) goto L5;
        return null;
    L5:
        LinkedList r0 = new LinkedList();
        Iterator r5 = r4.a().iterator();
    L7:
        if (r5.hasNext() == false) goto L9;
        r0.add(b.a((b) ZeusTransformUtils.preCheckCast(r5.next(), b.class, "com.obric.aiagent.plugin")));
        goto L7
    L9:
        return r0;
    }

    JSONArray a(y<b> r4) {
        JSONArray r3 = new JSONArray();
        Iterator r5 = r4.a().iterator();
    L4:
        if (r5.hasNext() == false) goto L8;
        JSONObject r0 = ((b) ZeusTransformUtils.preCheckCast(r5.next(), b.class, "com.obric.aiagent.plugin")).a();
        if (r0 == null) goto L4;
        r3.put(r0);
        goto L4
    L8:
        return r3;
    }

    private List<C0130c> a(String r24, y<b> r25, y<b> r26, y<b> r27, List<String> r28) {
        List r12 = (List) ZeusTransformUtils.wrapperContextForParams(r28, List.class, "com.obric.aiagent.plugin");
        ArrayList r13 = new ArrayList();
        File r1 = new File(r24);
        AnonymousClass1 r14 = null;
        C0130c r2 = new C0130c(this, r14);
        C0130c.a(r2, r24);
        r2.f5311a = new C0130c(this, r14);
        File[] r0 = r1.listFiles();
        if (r0 == null) goto L65;
        if (r0.length == 0) goto L65;
        if (r12.contains(r1.getAbsolutePath()) == false) goto L10;
        r13.add(r2);
        r12.remove(r1.getAbsolutePath());
    L10:
        C0130c.a(r2, r0.length);
        LinkedList r15 = new LinkedList();
        r15.offer(r2);
    L12:
        if (r15.isEmpty() == true) goto L63;
        int r6 = r15.size();
        int r7 = 0;
    L14:
        if (r7 >= r6) goto L12;
        C0130c r5 = (C0130c) ZeusTransformUtils.preCheckCast(r15.poll(), C0130c.class, "com.obric.aiagent.plugin");
        if (r5 != null) goto L18;
        int r19 = r7;
        LinkedList r3 = r15;
        int r16 = r6;
    L62:
        r7 = r19 + 1;
        r6 = r16;
        r15 = r3;
        goto L14
    L18:
        String r4 = C0130c.a(r5);
        File r8 = new File(r4);
        if (r8.exists() == true) goto L21;
    L61:
        r19 = r7;
        r3 = r15;
        r16 = r6;
        C0130c.b(r5.f5311a);
        goto L62
    L21:
        if (a(r8) == true) goto L61;
        if (r8.isFile() == false) goto L41;
        LinkedList r29 = r15;
        long r17 = r8.length();
        if (b(r17) == true) goto L30;
        r25.a(new b(this, r4, r17, 1));
    L30:
        if (r5.f5311a != null) goto L32;
        r3 = r29;
        r16 = r6;
        r19 = r7;
        goto L62
    L32:
        r5.f5311a.a(r17, r27, r26);
        if (C0130c.c(r5.f5311a) == true) goto L39;
        long r18 = c(r8.lastModified());
        if (r18 <= 0) goto L39;
        if (a(r17) == false) goto L39;
        r16 = r6;
        r19 = r7;
        r27.a(new d(this, r4, r6, 0, r18));
    L40:
        r3 = r29;
    L39:
        r16 = r6;
        r19 = r7;
        goto L40
    L41:
        r19 = r7;
        r29 = r15;
        r16 = r6;
        if (r12.contains(r8.getAbsolutePath()) == false) goto L44;
        r13.add(r5);
        r12.remove(r8.getAbsolutePath());
    L44:
        File[] r9 = r8.listFiles();
        if (r9 != null) goto L47;
    L60:
        r3 = r29;
        r5.f5311a.a(0, r27, r26);
        goto L62
    L47:
        if (r9.length == 0) goto L60;
        C0130c.a(r5, r9.length);
        int r10 = r9.length;
        int r11 = 0;
    L50:
        if (r11 >= r10) goto L40;
        File r20 = r9[r11];
        C0130c r21 = new C0130c(this, null);
        r21.f5311a = r5;
        C0130c.a(r21, r20.getAbsolutePath());
        if (r20.isDirectory() == true) goto L54;
    L58:
        File[] r110 = r9;
        int r111 = r10;
    L59:
        LinkedList r22 = r29;
        r22.offer(r21);
        r11 = r11 + 1;
        r29 = r22;
        r9 = r110;
        r10 = r111;
        goto L50
    L54:
        if (C0130c.c(r5) == true) goto L58;
        r110 = r9;
        r111 = r10;
        long r23 = c(r20.lastModified());
        if (r23 <= 0) goto L59;
        C0130c.a(r21, true);
        C0130c.a(r21, r23);
        goto L59
    L63:
        return r13;
    L65:
        return null;
    }

    private void c(List<a> r5) {
        List<a> r6 = (List) ZeusTransformUtils.wrapperContextForParams(r5, List.class, "com.obric.aiagent.plugin");
        if (com.bytedance.apm6.util.f.a(this.h) == false) goto L5;
        return;
    L5:
        Iterator<String> r0 = this.h.iterator();
    L7:
        if (r0.hasNext() == false) goto L9;
        c(new File((String) ZeusTransformUtils.preCheckCast(r0.next(), String.class, "com.obric.aiagent.plugin")), r6);
        goto L7
    }

    private void f() {
        if (this.j == false) goto L5;
        return;
    L5:
        this.j = true;
        Application r1 = (Application) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(com.bytedance.apm6.foundation.context.a.getContext(), "com.obric.aiagent.plugin"), Application.class, "com.obric.aiagent.plugin");
        r1.getPackageName();     // Catch: Exception -> L10
        this.f5298b = r1.getFilesDir().getParent();     // Catch: Exception -> L10
        this.f5299c = r1.getCacheDir().getAbsolutePath();     // Catch: Exception -> L10
        this.f5300d = a(r1);     // Catch: Exception -> L10
        File r2 = r1.getExternalCacheDir();     // Catch: Exception -> L10
        if (r2 == null) goto L14;
        this.f5301e = r2.getAbsolutePath();     // Catch: Exception -> L10
        return;
    L14:
        return;
    L10:
        this.f = true;
    }

    private String a(Context r2) {
        return ((Context) ZeusTransformUtils.wrapperContextForParams(r2, Context.class, "com.obric.aiagent.plugin")).getExternalFilesDir(null).getParentFile().getAbsolutePath();
    L5:
        return null;
    }

    private void a(File r4, List<a> r5) {
        List<a> r6 = (List) ZeusTransformUtils.wrapperContextForParams(r5, List.class, "com.obric.aiagent.plugin");
        File[] r7 = r4.listFiles();
        if (r7 != null) goto L5;
        return;
    L5:
        if (r7.length == 0) goto L12;
        int r0 = r7.length;
        int r1 = 0;
    L8:
        if (r1 >= r0) goto L13;
        b(r7[r1], r6);
        r1 = r1 + 1;
        goto L8
    L13:
        return;
    }

    private String a(String r3) {
        String r2 = b(r3);
        if (r2 == null) goto L7;
        if (r3 != null) goto L6;
        return null;
    L6:
        return r2 + r3.substring(r2.length()).replaceAll("[^/]", "*");
    L7:
        return null;
    }

    private long b(File r9, List<a> r10) {
        List r11 = (List) ZeusTransformUtils.wrapperContextForParams(r10, List.class, "com.obric.aiagent.plugin");
        long r0 = 0;
        if (r9 != null) goto L5;
    L33:
        return r0;
    L5:
        if (r9.exists() == false) goto L33;
        if (a(r9) == true) goto L33;
        int r3 = 0;
        AnonymousClass1 r4 = null;
        if (r9.isFile() == false) goto L16;
        long r1 = r9.length();
        if (r1 >= this.k.d()) goto L14;
        return r1;
    L14:
        a r2 = new a(this, r4);
        r2.f5305d = false;
        r2.f5302a = r9.getAbsolutePath();
        r2.f5303b = r1;
        r11.add(r2);
        return r1;
    L16:
        File[] r5 = r9.listFiles();
        if (r5 == null) goto L33;
        if (r5.length == 0) goto L33;
        a r6 = new a(this, r4);
        r6.f5305d = r9.isDirectory();
        r6.f5302a = r9.getAbsolutePath();
        ArrayList r12 = new ArrayList();
        r6.f = r12;
        r11.add(r6);
        int r13 = r5.length;
    L22:
        if (r3 >= r13) goto L32;
        File r7 = r5[r3];
        if (r7 == null) goto L31;
        if (r7.exists() == false) goto L31;
        if (a(r7) == true) goto L31;
        r0 = r0 + b(r7, r12);
    L31:
        r3 = r3 + 1;
        goto L22
    L32:
        r6.f5303b = r0;
        goto L33
    }

    private void c(File r6, List<a> r7) {
        List r8 = (List) ZeusTransformUtils.wrapperContextForParams(r7, List.class, "com.obric.aiagent.plugin");
        if (r6 != null) goto L5;
        return;
    L5:
        if (r6.exists() == true) goto L7;
        return;
    L7:
        if (a(r6) == true) goto L17;
        AnonymousClass1 r2 = null;
        if (r6.isFile() == false) goto L13;
        long r3 = r6.length();
        a r0 = new a(this, r2);
        r0.f5305d = false;
        r0.f5302a = r6.getAbsolutePath();
        r0.f5303b = r3;
        r0.f5306e = MonitorConstants.CUSTOM;
        r8.add(r0);
        return;
    L13:
        a r1 = new a(this, r2);
        r1.f5305d = true;
        r1.f5306e = MonitorConstants.CUSTOM;
        r1.f5302a = r6.getAbsolutePath();
        r1.f5303b = b(r6);
        r8.add(r1);
        return;
    }

    private boolean a(File r2) {
        if (com.bytedance.apm6.util.f.a(this.g) == false) goto L5;
        return false;
    L5:
        return this.g.contains(r2.getAbsolutePath());
    }

    private String b(String r4) {
        if (com.bytedance.apm6.util.f.a(this.i) == true) goto L11;
        if (r4 == null) goto L16;
        Iterator<String> r3 = this.i.iterator();
    L7:
        if (r3.hasNext() == false) goto L17;
        String r0 = (String) ZeusTransformUtils.preCheckCast(r3.next(), String.class, "com.obric.aiagent.plugin");
        if (r4.startsWith(r0) == false) goto L7;
        return r0;
    L17:
        return null;
    L16:
        return null;
    L11:
        return null;
    }

    private long c(long r3) {
        long r0 = System.currentTimeMillis() - r3;
        if (r0 >= this.k.h()) goto L5;
        return 0;
    L5:
        if (r0 >= 62899200000L) goto L9;
        return r0;
    L9:
        return 0;
    }

    private long b(File r7) {
        long r0 = 0;
        File[] r8 = r7.listFiles();     // Catch: Exception -> L16
        if (r8 != null) goto L6;
    L15:
        return 0;
    L6:
        if (r8.length == 0) goto L15;
        int r2 = r8.length;     // Catch: Exception -> L16
        int r3 = 0;
    L9:
        if (r3 >= r2) goto L18;
        File r4 = r8[r3];     // Catch: Exception -> L16
        if (r4.isDirectory() == false) goto L13;
        long r5 = b(r4);     // Catch: Exception -> L16
    L14:
        r0 = r0 + r5;
        r3 = r3 + 1;
        goto L9
    L13:
        r5 = r4.length();     // Catch: Exception -> L16
    L18:
        return r0;
    L16:
        e = move-exception;
        e.printStackTrace();
        goto L18
    }

    @Skip({com.obric.aiagent.apm.impl.BuildConfig.LIBRARY_PACKAGE_NAME})
    public static int a(String r0, String r1) {
        return Log.e(r0, r1);
    }

    @Skip({com.obric.aiagent.apm.impl.BuildConfig.LIBRARY_PACKAGE_NAME})
    public static int a(String r0, String r1, Throwable r2) {
        return Log.e(r0, r1, r2);
    }
}
