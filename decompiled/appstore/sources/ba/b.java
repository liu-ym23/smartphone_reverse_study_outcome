package ba;

import android.support.v4.media.session.PlaybackStateCompat;
import com.monitor.cloudmessage.entity.CloudMessageException;
import com.monitor.cloudmessage.utils.NetworkUtils;
import java.io.File;
import java.io.FileFilter;
import java.util.HashMap;
import java.util.Map;
import w0.c;

/* JADX INFO: loaded from: classes3.dex */
public class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Map f5950a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public volatile File f5951b;

    public class a implements FileFilter {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ b f5952a;

        public a(b r10) {
            this.f5952a = r10;
        }

        @Override // java.io.FileFilter
        public boolean accept(File r10) {
            return r10.isFile();
        }
    }

    /* JADX INFO: renamed from: ba.b$b, reason: collision with other inner class name */
    public static class C0065b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final b f5953a = null;

        static {
            f5953a = new b();
        }

        public static /* synthetic */ b a() {
            return f5953a;
        }
    }

    public b() {
        this.f5950a = new HashMap();
    }

    public static b b() {
        return C0065b.a();
    }

    public final void a() {
        if (this.f5951b != null) goto L5;
        return;
    L5:
        if (this.f5951b.exists() == true) goto L9;
        this.f5951b.mkdirs();
        return;
    }

    public File c() {
        if (this.f5951b == null) goto L5;
    L9:
        a();
        return this.f5951b;
    L5:
        if (c.g() == null) goto L7;
        this.f5951b = new File(c.g().getFilesDir(), "cloud_uploading");
        goto L9
    L7:
        return null;
    }

    public boolean d(String r10) {
        if (this.f5950a.get(r10) != Boolean.TRUE) goto L5;
        return true;
    L5:
        return false;
    }

    public synchronized void e(w9.a r11, File r12, String r13) {
        monitor-enter(this);
        ba.a.c("命令产物已生成，等待上传", r11);     // Catch: Throwable -> L8
        a();     // Catch: Throwable -> L8
        String r10 = r11.b();     // Catch: Throwable -> L8
        File r14 = c();     // Catch: Throwable -> L8
        if (r14 == null) goto L39;
        File r15 = new File(r14, r10);     // Catch: Throwable -> L8
        if (r15.exists() == false) goto L10;
        com.monitor.cloudmessage.utils.b.f(r15);     // Catch: Throwable -> L8
    L10:
        r12.renameTo(r15);     // Catch: Throwable -> L8
        long r16 = com.bytedance.apm.util.b.e(r15);     // Catch: Throwable -> L8
        boolean r17 = true;
        if (r11.f() == true) goto L13;
    L15:
        boolean r18 = false;
    L16:
        this.f5950a.put(r10, Boolean.valueOf(r18));     // Catch: Throwable -> L8
        if (r18 == true) goto L19;
    L23:
        File[] r19 = r15.listFiles(new a(this));     // Catch: Throwable -> L8
        int r20 = r19.length;     // Catch: Throwable -> L8
        int r21 = 0;
    L24:
        if (r21 >= r20) goto L33;
        File r22 = r19[r21];     // Catch: Throwable -> L8
        boolean r23 = ba.a.b(r10, r22, r13, "正在上传:" + r22.getName());     // Catch: Throwable -> L8
        StringBuilder r24 = new StringBuilder();     // Catch: Throwable -> L8
        r24.append("文件上传");     // Catch: Throwable -> L8
        if (r23 == false) goto L28;
        String r25 = "成功";
    L29:
        r24.append(r25);     // Catch: Throwable -> L8
        r24.append(":");     // Catch: Throwable -> L8
        r24.append(r22.getName());     // Catch: Throwable -> L8
        ba.a.c(r24.toString(), r11);     // Catch: Throwable -> L8
        if (r23 == true) goto L32;
        r17 = false;
    L32:
        r21 = r21 + 1;     // Catch: Throwable -> L8
        goto L24
    L28:
        r25 = "失败";
        goto L29
    L33:
        if (r17 == false) goto L35;
        ba.a.e(r10);     // Catch: Throwable -> L8
    L35:
        com.monitor.cloudmessage.utils.b.f(r15);     // Catch: Throwable -> L8
        monitor-exit(this);
        return;
    L19:
        if (NetworkUtils.l(v9.a.k().i()) == true) goto L23;
        ba.a.c("产物超过阈值，等待WiFi环境执行. fileTotalSize=" + r16, r11);     // Catch: Throwable -> L8
        monitor-exit(this);
        return;
    L13:
        if (r16 <= PlaybackStateCompat.ACTION_SET_SHUFFLE_MODE) goto L15;
        r18 = true;
        goto L16
    L39:
        throw new CloudMessageException("pending目录因拿不到context而未设置");     // Catch: Throwable -> L8
    L8:
        th = move-exception;
        throw th;
    }
}
