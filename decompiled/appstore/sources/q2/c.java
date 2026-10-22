package q2;

import com.bytedance.apm6.monitor.Monitorable;
import java.io.File;
import java.io.FileFilter;
import java.io.FileOutputStream;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.channels.FileLock;
import java.util.ArrayList;
import java.util.UUID;
import org.json.JSONObject;
import r3.d;

/* JADX INFO: loaded from: classes.dex */
public class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final File f23506a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final long f23507b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public ByteBuffer f23508c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public FileLock f23509d;

    public class a implements FileFilter {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ c f23510a;

        public a(c r10) {
            this.f23510a = r10;
        }

        @Override // java.io.FileFilter
        public boolean accept(File r10) {
            String r11 = r10.getName();
            if (r11.endsWith(".log") == false) goto L7;
            return true;
        L7:
            if (r11.endsWith(".txt") == false) goto L9;
            return false;
        L9:
            r3.c.a(r10);
            return false;
        }
    }

    public class b implements Monitorable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ JSONObject f23511a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ JSONObject f23512b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ c f23513c;

        public b(c r10, JSONObject r11, JSONObject r12) {
            this.f23513c = r10;
            this.f23511a = r11;
            this.f23512b = r12;
        }

        @Override // com.bytedance.apm6.monitor.Monitorable
        public String getLogType() {
            return "service_monitor";
        }

        @Override // com.bytedance.apm6.monitor.Monitorable
        public boolean isValid() {
            return true;
        }

        @Override // com.bytedance.apm6.monitor.Monitorable
        public JSONObject toJsonObject() {
            JSONObject r10 = new JSONObject();     // Catch: Exception -> L4
            r10.put("log_type", "service_monitor");     // Catch: Exception -> L4
            r10.put("service", "apm_error");     // Catch: Exception -> L4
            JSONObject r11 = new JSONObject();     // Catch: Exception -> L4
            r11.put("type", "large_data");     // Catch: Exception -> L4
            r11.put("error_service", this.f23511a);     // Catch: Exception -> L4
            r11.put("error_log_type", this.f23512b);     // Catch: Exception -> L4
            r10.put("category", r11);     // Catch: Exception -> L4
            return r10;
        L4:
            return null;
        }
    }

    public c(long r10, File r11, File r12) {
        this.f23506a = r12;
        this.f23507b = r10;
        FileChannel r13 = new RandomAccessFile(r11, "rw").getChannel();     // Catch: Throwable -> L5
        this.f23509d = r13.tryLock();     // Catch: Throwable -> L5
        this.f23508c = r13.map(FileChannel.MapMode.READ_WRITE, 0, 262162);     // Catch: Throwable -> L5
        b();     // Catch: Throwable -> L5
    L8:
        if (this.f23508c != null) goto L10;
        this.f23508c = ByteBuffer.allocate(262162);
    L10:
        j();
        return;
    L5:
        th = move-exception;
        s3.a.c(n2.a.f22354a, "create MappedByteBuffer failed. will fallback into HeapByteBuffer", th);
        goto L8
    }

    public final Monitorable a(JSONObject r10) {
        JSONObject r11 = null;
        if (r10 == null) goto L5;
        JSONObject r12 = r10.optJSONObject("service");
    L6:
        if (r10 == null) goto L9;
        r11 = r10.optJSONObject("log_type");
    L9:
        return new b(this, r12, r11);
    L5:
        r12 = null;
        goto L6
    }

    public synchronized void b() {
        monitor-enter(this);
        short r10 = e();     // Catch: Throwable -> L11
        long r11 = d();     // Catch: Throwable -> L11
        int r12 = g();     // Catch: Throwable -> L11
        int r13 = f();     // Catch: Throwable -> L11
        if (r10 != 2082) goto L50;
        if (r13 <= 0) goto L50;
        if (r12 <= 0) goto L50;
        if (r3.a.c() == false) goto L13;
        s3.a.a(n2.a.f22354a, "flushing: headerId=" + r11 + " totalCount=" + r12 + " totalBytes=" + r13);     // Catch: Throwable -> L11
    L13:
        long r14 = System.nanoTime();     // Catch: Throwable -> L11
        boolean r15 = false;
        FileChannel r16 = null;
        String r17 = System.currentTimeMillis() + "_" + UUID.randomUUID().toString();     // Catch: Throwable -> L29
    L21:
        th = move-exception;
        s3.a.c(n2.a.f22354a, "flushDir create error.", th);     // Catch: Throwable -> L29
    L26:
        File r18 = new File(this.f23506a, r17 + ".txt");     // Catch: Throwable -> L29
        if (r18.exists() == false) goto L31;
        s3.a.b(n2.a.f22354a, "file is exist:" + r18.getName());     // Catch: Throwable -> L29
    L31:
        r16 = new FileOutputStream(r18, false).getChannel();     // Catch: Throwable -> L29
        this.f23508c.position(r13 + 18);     // Catch: Throwable -> L29
        this.f23508c.flip();     // Catch: Throwable -> L29
        r16.write(this.f23508c);     // Catch: Throwable -> L29
        if (r18.renameTo(new File(this.f23506a, r17 + ".log")) == false) goto L34;
        r15 = true;
    L36:
        if (r3.a.c() == false) goto L38;
        s3.a.a(n2.a.f22354a, "flush to file success. flushFile=" + r18.getAbsolutePath());     // Catch: Throwable -> L29
    L38:
        d.a(r16);     // Catch: Throwable -> L11
        if (r15 == true) goto L44;
        c();     // Catch: Throwable -> L11
    L44:
        j();     // Catch: Throwable -> L11
        if (r3.a.c() == false) goto L47;
        s3.a.a(n2.a.f22354a, "flush cost=" + (System.nanoTime() - r14));     // Catch: Throwable -> L11
    L47:
        monitor-exit(this);
        return;
    L34:
        s3.a.b(n2.a.f22354a, "rename error" + r18.getAbsolutePath());     // Catch: Throwable -> L29
        goto L36
    L17:
        if (this.f23506a.exists() == true) goto L26;
        File r19 = this.f23506a.getParentFile();     // Catch: Throwable -> L21
        if (r19.exists() == true) goto L23;
        r19.mkdirs();     // Catch: Throwable -> L21
    L23:
        this.f23506a.mkdirs();     // Catch: Throwable -> L21
    L29:
        th = move-exception;
        s3.a.c(n2.a.f22354a, this.f23506a.exists() + " flush to file failed.", th);     // Catch: Throwable -> L57
    L50:
        if (r3.a.c() == false) goto L52;
        s3.a.a(n2.a.f22354a, "flushing: Skipped. no data to flush. reset buffer now.");     // Catch: Throwable -> L11
    L52:
        j();     // Catch: Throwable -> L11
        monitor-exit(this);
        return;
    L11:
        th = move-exception;
        throw th;
    }

    public final void c() {
        this.f23508c.position(f() + 18);
        this.f23508c.flip();
        q2.a r10 = q2.a.b(this.f23508c);
        if (r3.a.c() == false) goto L5;
        s3.a.a(n2.a.f22354a, "flush to memory success. logFile=" + r10);
    L5:
        n2.c.e().m(r10);
    }

    public final long d() {
        return this.f23508c.getLong(2);
    }

    public final short e() {
        return this.f23508c.getShort(0);
    }

    public final int f() {
        return this.f23508c.getInt(14);
    }

    public final int g() {
        return this.f23508c.getInt(10);
    }

    public synchronized String[] h() {
        monitor-enter(this);
        File[] r10 = n2.b.b().listFiles(new a(this));     // Catch: Throwable -> L11
        if (r10 != null) goto L8;
        monitor-exit(this);
        return null;
    L8:
        ArrayList r11 = new ArrayList();     // Catch: Throwable -> L11
        int r12 = r10.length;     // Catch: Throwable -> L11
        int r13 = 0;
    L9:
        if (r13 >= r12) goto L13;
        r11.add(r10[r13].getName());     // Catch: Throwable -> L11
        r13 = r13 + 1;     // Catch: Throwable -> L11
        goto L9
    L13:
        String[] r14 = (String[]) r11.toArray(new String[r11.size()]);     // Catch: Throwable -> L11
        monitor-exit(this);
        return r14;
    L11:
        th = move-exception;
        throw th;
    }

    public synchronized void i(JSONObject r10) {
        monitor-enter(this);
        if (r10 != null) goto L31;
        monitor-exit(this);
        return;
    L31:
        String r11 = r10.toString();     // Catch: Throwable -> L9
        if (r3.a.c() == false) goto L11;
        o1.a.c(r10);     // Catch: Throwable -> L9
    L11:
        byte[] r12 = r11.getBytes();     // Catch: Throwable -> L9
        int r13 = r12.length + 4;     // Catch: Throwable -> L9
        if (r13 <= 262144) goto L17;
        l3.a.d(a(r10));     // Catch: Throwable -> L9
        monitor-exit(this);
        return;
    L17:
        if (r13 <= this.f23508c.remaining()) goto L19;
        b();     // Catch: Throwable -> L9
    L19:
        this.f23508c.putInt(r12.length);     // Catch: Throwable -> L9
        this.f23508c.put(r12);     // Catch: Throwable -> L9
        l(g() + 1);     // Catch: Throwable -> L9
        k(f() + r13);     // Catch: Throwable -> L9
        if (r3.a.c() == false) goto L23;
        String r14 = String.format("push success: totalCount=%s, totalBytes=%s, logItem=%s", new Object[]{Integer.valueOf(g()), Integer.valueOf(f()), r11});     // Catch: Throwable -> L9
        s3.a.a(n2.a.f22354a, r14);     // Catch: Throwable -> L9
    L23:
        if (this.f23508c.position() < 262134) goto L25;
    L26:
        b();     // Catch: Throwable -> L9
    L27:
        monitor-exit(this);
        return;
    L25:
        if (g() < 256) goto L27;
    L9:
        th = move-exception;
        throw th;
    }

    public final void j() {
        this.f23508c.clear();
        this.f23508c.putShort(2082);
        this.f23508c.putLong(this.f23507b);
        this.f23508c.putInt(0);
        this.f23508c.putInt(0);
    }

    public final void k(int r10) {
        this.f23508c.putInt(14, r10);
    }

    public final void l(int r10) {
        this.f23508c.putInt(10, r10);
    }
}
