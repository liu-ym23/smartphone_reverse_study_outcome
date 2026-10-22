package com.bytedance.apm6.consumer.slardar.send;

import android.content.SharedPreferences;
import android.text.TextUtils;
import com.bytedance.mt.protector.impl.string2number.CastIntegerProtector;
import com.bytedance.mt.protector.impl.string2number.CastLongProtector;
import com.bytedance.security.android.aopcheck.PolarisFileOutputStreamWrapper;
import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import java.io.File;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: loaded from: classes3.dex */
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public SharedPreferences f190701a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public volatile boolean f190702b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public PolarisFileWrapper f190703c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final ConcurrentHashMap<String, b> f190704d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public long f190705e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public volatile boolean f190706f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final ArrayList<String> f190707g;

    public static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final c f190708a = null;

        static {
            f190708a = new c();
        }
    }

    public static class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public int f190709a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public long f190710b;

        public b(int r100, long r101) {
            this.f190709a = r100;
            this.f190710b = r101;
        }

        public void update(int r100, long r101) {
            this.f190709a = r100;
            this.f190710b = r101;
        }
    }

    public final synchronized void c() {
        monitor-enter(this);
    L13:
        th = move-exception;
        throw th;
    L4:
        if (this.f190702b == false) goto L7;
        monitor-exit(this);
        return;
    L7:
        PolarisFileWrapper r100 = new PolarisFileWrapper(mt3.b.e(), "log");     // Catch: Throwable -> L13
        if (r100.exists() == true) goto L10;
        r100.mkdirs();     // Catch: Throwable -> L13
    L10:
        this.f190703c = r100;     // Catch: Throwable -> L13
        this.f190701a = xu3.a.getContext().getSharedPreferences("log_report_message", 0);     // Catch: Throwable -> L13
        this.f190702b = true;     // Catch: Throwable -> L13
        monitor-exit(this);
    }

    public final synchronized void e() {
        monitor-enter(this);
        int r100 = 0;
        if (this.f190706f == true) goto L13;
        c r101 = a.f190708a;     // Catch: Throwable -> L25
        r101.c();     // Catch: Throwable -> L25
        String[] r102 = r101.f190703c.list();     // Catch: Throwable -> L25
        int r103 = r102.length;     // Catch: Throwable -> L25
    L6:
        if (r100 >= r103) goto L11;
        String r104 = r102[r100];     // Catch: Throwable -> L25
        if (this.f190707g.contains(r104) == true) goto L10;
        a(r104);     // Catch: Throwable -> L25
    L10:
        r100 = r100 + 1;     // Catch: Throwable -> L25
        goto L6
    L11:
        this.f190706f = true;     // Catch: Throwable -> L25
    L23:
        monitor-exit(this);
        return;
    L13:
        if (this.f190705e <= 0) goto L23;
        if (this.f190707g.size() != 0) goto L23;
        c r105 = a.f190708a;     // Catch: Throwable -> L25
        r105.c();     // Catch: Throwable -> L25
        String[] r106 = r105.f190703c.list();     // Catch: Throwable -> L25
        int r107 = r106.length;     // Catch: Throwable -> L25
    L17:
        if (r100 >= r107) goto L22;
        String r108 = r106[r100];     // Catch: Throwable -> L25
        if (this.f190707g.contains(r108) == true) goto L21;
        a(r108);     // Catch: Throwable -> L25
    L21:
        r100 = r100 + 1;     // Catch: Throwable -> L25
        goto L17
    L22:
        this.f190705e -= (long) this.f190707g.size();     // Catch: Throwable -> L25
    L25:
        th = move-exception;
        throw th;
    }

    public c() {
        this.f190704d = new ConcurrentHashMap();
        this.f190705e = 0;
        this.f190706f = false;
        this.f190707g = new ArrayList();
    }

    public final void a(String r100) {
        if (this.f190707g.size() <= 5000) goto L6;
        this.f190705e++;
        return;
    L6:
        this.f190707g.add(r100);
    }

    public final synchronized boolean b(File r100) {
        monitor-enter(this);
        boolean r101 = false;
        if (r100 != null) goto L24;
        monitor-exit(this);
        return false;
    L24:
        this.f190707g.remove(r100.getName());     // Catch: Throwable -> L20
        c();     // Catch: Throwable -> L20
        if (r100.exists() == true) goto L10;
    L16:
        r101 = true;
    L17:
        this.f190704d.remove(r100.getName());     // Catch: Throwable -> L20
        SharedPreferences.Editor r102 = this.f190701a.edit();     // Catch: Throwable -> L20
        r102.remove(r100.getName());     // Catch: Throwable -> L20
        r102.commit();     // Catch: Throwable -> L20
        monitor-exit(this);
        return r101;
    L10:
        if (r100.exists() == true) goto L26;
    L14:
        boolean r103 = false;
    L15:
        if (r103 == false) goto L17;
    L26:
        r103 = r100.delete();     // Catch: Throwable -> L23
    L20:
        th = move-exception;
        throw th;
    }

    public final b d(PolarisFileWrapper r100) {
        c();
        String r101 = r100.getName();
        if (this.f190704d.containsKey(r101) == true) goto L5;
        b r102 = null;
        if (this.f190701a.contains(r101) == false) goto L15;
        String r103 = this.f190701a.getString(r101, "");
        if (TextUtils.isEmpty(r103) == false) goto L16;
    L13:
        if (r102 == null) goto L15;
        this.f190704d.put(r101, r102);
        goto L15
    L16:
        String[] r104 = r103.split("_");     // Catch: Exception -> L12
        r102 = new b(CastIntegerProtector.parseInt(r104[0]), CastLongProtector.parseLong(r104[1]));     // Catch: Exception -> L12
    L15:
        return r102;
    L5:
        return this.f190704d.get(r101);
    }

    public final void g(PolarisFileWrapper r100, int r101, long r102) {
        c();     // Catch: Throwable -> L8
        SharedPreferences.Editor r103 = this.f190701a.edit();     // Catch: Throwable -> L8
        String r104 = r100.getName();     // Catch: Throwable -> L8
        if (this.f190704d.containsKey(r104) == false) goto L5;
        b r105 = this.f190704d.get(r104);     // Catch: Throwable -> L8
    L6:
        r105.update(r101, r102);     // Catch: Throwable -> L8
        r103.putString(r104, r105.f190709a + "_" + r105.f190710b);     // Catch: Throwable -> L8
        r103.commit();     // Catch: Throwable -> L8
        return;
    L5:
        r105 = new b(r101, r102);     // Catch: Throwable -> L8
        this.f190704d.put(r104, r105);     // Catch: Throwable -> L8
    L8:
        th = move-exception;
        List<String> r106 = mt3.a.f515607a;
        av3.b.c("APM-Slardar", "updateRetryMessage", th);
    }

    public final synchronized boolean f(byte[] r100, String r101, int r110, long r111, boolean r112) {
        monitor-enter(this);
        c();     // Catch: Throwable -> L35
        if (this.f190703c != null) goto L9;
        monitor-exit(this);
        return false;
    L9:
        if (r112 == false) goto L11;
        String r102 = "priority_";
    L12:
        String r103 = String.format("%s%d%s%s%s%s", new Object[]{r102, Long.valueOf(System.currentTimeMillis()), "_", UUID.randomUUID().toString(), ".", r101});     // Catch: Throwable -> L35
        PolarisFileWrapper r104 = new PolarisFileWrapper(this.f190703c, r103);     // Catch: Throwable -> L35
        FileChannel r105 = null;
        g(r104, r110, r111);     // Catch: Throwable -> L27
        r105 = new PolarisFileOutputStreamWrapper(r104).getChannel();     // Catch: Throwable -> L27
        r105.write(ByteBuffer.wrap(r100));     // Catch: Throwable -> L27
        if (this.f190707g.contains(r103) == true) goto L18;
        a(r103);     // Catch: Throwable -> L27
    L18:
        if (xu3.a.a() == false) goto L24;
        List<String> r106 = mt3.a.f515607a;     // Catch: Throwable -> L27
        StringBuilder r107 = new StringBuilder("saveFile:");     // Catch: Throwable -> L27
        r107.append(r104.getName());     // Catch: Throwable -> L27
        if (r112 == false) goto L22;
        String r113 = " [priority]";
    L23:
        r107.append(r113);     // Catch: Throwable -> L27
        av3.b.a("APM-Slardar", r107.toString());     // Catch: Throwable -> L27
    L22:
        r113 = "";
    L24:
        xu3.c.a(r105);     // Catch: Throwable -> L35
        monitor-exit(this);
        return true;
    L27:
        th = move-exception;
        List<String> r108 = mt3.a.f515607a;     // Catch: Throwable -> L32
        av3.b.c("APM-Slardar", "saveFile", th);     // Catch: Throwable -> L32
        xu3.c.a(r105);     // Catch: Throwable -> L35
        return false;
    L32:
        th = move-exception;
        xu3.c.a(r105);     // Catch: Throwable -> L35
        throw th;     // Catch: Throwable -> L35
    L11:
        r102 = "";
    L35:
        th = move-exception;
        throw th;
    }
}
