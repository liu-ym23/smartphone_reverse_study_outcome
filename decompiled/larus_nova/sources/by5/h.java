package by5;

import android.content.SharedPreferences;
import android.text.TextUtils;
import com.bytedance.mt.protector.impl.string2number.CastIntegerProtector;
import com.bytedance.mt.protector.impl.string2number.CastLongProtector;
import com.bytedance.security.android.aopcheck.PolarisFileOutputStreamWrapper;
import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: loaded from: classes3.dex */
public final class h {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public SharedPreferences f21435a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public volatile boolean f21436b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final ConcurrentHashMap<String, b> f21437c;

    public static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final h f21438a = null;

        static {
            f21438a = new h();
        }
    }

    public static class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public int f21439a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public long f21440b;

        public b(int r100, long r101) {
            this.f21439a = r100;
            this.f21440b = r101;
        }

        public void update(int r100, long r101) {
            this.f21439a = r100;
            this.f21440b = r101;
        }
    }

    public final synchronized void b() {
        monitor-enter(this);
    L10:
        th = move-exception;
        throw th;
    L4:
        if (this.f21436b == false) goto L7;
        monitor-exit(this);
        return;
    L7:
        this.f21435a = n.getContext().getSharedPreferences("sdk_log_report_message", 0);     // Catch: Throwable -> L10
        this.f21436b = true;     // Catch: Throwable -> L10
        monitor-exit(this);
    }

    public h() {
        this.f21437c = new ConcurrentHashMap();
    }

    public final synchronized void a(PolarisFileWrapper r100) {
        monitor-enter(this);
        b();     // Catch: Throwable -> L6
        xu3.b.a(r100);     // Catch: Throwable -> L6
        this.f21437c.remove(r100.getName());     // Catch: Throwable -> L6
        SharedPreferences.Editor r101 = this.f21435a.edit();     // Catch: Throwable -> L6
        r101.remove(r100.getName());     // Catch: Throwable -> L6
        r101.commit();     // Catch: Throwable -> L6
        monitor-exit(this);
        return;
    L6:
        th = move-exception;
        throw th;
    }

    public final b c(PolarisFileWrapper r100) {
        b();
        String r101 = r100.getName();
        if (this.f21437c.containsKey(r101) == true) goto L5;
        b r102 = null;
        if (this.f21435a.contains(r101) == false) goto L19;
        String r103 = this.f21435a.getString(r101, "");
        if (TextUtils.isEmpty(r103) == false) goto L21;
    L17:
        if (r102 == null) goto L19;
        this.f21437c.put(r101, r102);
        goto L19
    L21:
        String[] r104 = r103.split("_");     // Catch: Exception -> L15
        if (r104.length != 2) goto L14;
        r102 = new b(CastIntegerProtector.parseInt(r104[0]), CastLongProtector.parseLong(r104[1]));     // Catch: Exception -> L15
    L20:
        goto L17
    L14:
        r102 = new b(0, 0);     // Catch: Exception -> L15
    L15:
        e = move-exception;
        fy5.c.c("parseRetryMessage " + r103, e);
    L19:
        return r102;
    L5:
        return this.f21437c.get(r101);
    }

    public final synchronized boolean d(byte[] r100, int r110, long r111) {
        monitor-enter(this);
        b();     // Catch: Throwable -> L25
        if (by5.a.c() != null) goto L9;
        monitor-exit(this);
        return false;
    L9:
        PolarisFileWrapper r101 = new PolarisFileWrapper(by5.a.c(), String.format("%d%s%s%s", new Object[]{Long.valueOf(System.currentTimeMillis()), "_", UUID.randomUUID().toString(), ".log"}));     // Catch: Throwable -> L25
        FileChannel r102 = null;
        e(r101, r110, r111);     // Catch: Throwable -> L17
        r102 = new PolarisFileOutputStreamWrapper(r101).getChannel();     // Catch: Throwable -> L17
        r102.write(ByteBuffer.wrap(r100));     // Catch: Throwable -> L17
        if (n.f21462e == false) goto L14;
        fy5.c.a("saveFile:" + r101.getName());     // Catch: Throwable -> L17
    L14:
        xu3.c.a(r102);     // Catch: Throwable -> L25
        monitor-exit(this);
        return true;
    L17:
        th = move-exception;
        fy5.c.c("saveFile:" + r101.getName(), th);     // Catch: Throwable -> L22
        xu3.c.a(r102);     // Catch: Throwable -> L25
        return false;
    L22:
        th = move-exception;
        xu3.c.a(r102);     // Catch: Throwable -> L25
        throw th;     // Catch: Throwable -> L25
    L25:
        th = move-exception;
        throw th;
    }

    public final void e(PolarisFileWrapper r100, int r101, long r102) {
        b();
        SharedPreferences.Editor r103 = this.f21435a.edit();
        String r104 = r100.getName();
        if (this.f21437c.containsKey(r104) == false) goto L5;
        b r105 = this.f21437c.get(r104);
    L6:
        r105.update(r101, r102);
        r103.putString(r104, r105.f21439a + "_" + r105.f21440b);
        r103.commit();
        return;
    L5:
        r105 = new b(r101, r102);
        this.f21437c.put(r104, r105);
        goto L6
    }
}
