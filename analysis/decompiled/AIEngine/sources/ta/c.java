package ta;

import android.os.Handler;
import android.os.HandlerThread;
import android.util.Log;
import com.stepos.statsapp.v3.utils.log.LogLevel;
import java.io.File;
import java.io.FileWriter;
import java.nio.charset.Charset;
import java.util.Date;
import mb.y;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final class c {

    /* renamed from: a, reason: collision with root package name */
    public static b f12949a;

    /* renamed from: b, reason: collision with root package name */
    public static final Handler f12950b;

    /* renamed from: c, reason: collision with root package name */
    public static final boolean f12951c;

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    public static class a implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        public final LogLevel f12952a;

        /* renamed from: b, reason: collision with root package name */
        public final String f12953b;

        /* renamed from: c, reason: collision with root package name */
        public final String f12954c;

        /* renamed from: d, reason: collision with root package name */
        public final String f12955d;

        /* renamed from: e, reason: collision with root package name */
        public final long f12956e;

        public a(LogLevel logLevel, String str, String str2, long j10, String str3) {
            this.f12952a = logLevel;
            this.f12953b = str;
            this.f12954c = str2;
            this.f12956e = j10;
            this.f12955d = str3;
        }

        @Override // java.lang.Runnable
        public final void run() throws Throwable {
            b bVar;
            LogLevel logLevel = this.f12952a;
            int iOrdinal = logLevel.ordinal();
            b bVar2 = c.f12949a;
            if (iOrdinal < 1 || (bVar = c.f12949a) == null) {
                return;
            }
            String str = this.f12953b;
            String str2 = this.f12955d + "|" + this.f12954c;
            long j10 = this.f12956e;
            try {
                StringBuilder sb2 = new StringBuilder();
                sb2.append(bVar.f12947d.format(new Date()));
                sb2.append("\t");
                sb2.append(bVar.f12948e);
                sb2.append("-");
                sb2.append(j10);
                sb2.append("\t");
                sb2.append(logLevel == LogLevel.f8041b ? "D" : logLevel == LogLevel.f8042c ? "I" : logLevel == LogLevel.f8043d ? "W" : "E");
                sb2.append("/");
                sb2.append(str);
                sb2.append(": ");
                sb2.append(str2);
                String strA = bVar.f12946c.a(sb2.toString().getBytes(Charset.forName("UTF-8")));
                if (bVar.f12945b.exists() && bVar.f12945b.length() + strA.getBytes().length > 10485760) {
                    String parent = bVar.f12945b.getParent();
                    File file = new File(parent, "usage_logs_v2_old.txt");
                    if (file.exists()) {
                        file.delete();
                    }
                    bVar.f12945b.renameTo(new File(parent, "usage_logs_v2_old.txt"));
                    bVar.f12945b = new File(bVar.f12944a, "usage_logs_v2.txt");
                }
                FileWriter fileWriter = null;
                try {
                    FileWriter fileWriter2 = new FileWriter(bVar.f12945b, true);
                    try {
                        fileWriter2.write(strA);
                        fileWriter2.write("\r\n");
                        jd.b.m(fileWriter2);
                    } catch (Exception unused) {
                        fileWriter = fileWriter2;
                        jd.b.m(fileWriter);
                    } catch (Throwable th) {
                        th = th;
                        fileWriter = fileWriter2;
                        jd.b.m(fileWriter);
                        throw th;
                    }
                } catch (Exception unused2) {
                } catch (Throwable th2) {
                    th = th2;
                }
            } catch (Exception e10) {
                Log.e("EncryptLogger", "Exception: " + e10.toString() + " - Cause: " + e10.getCause());
            }
        }
    }

    static {
        boolean z = false;
        f12951c = false;
        try {
            String strV = y.v("persist.stepos.usagestats.log", "false");
            if (strV != null) {
                if (strV.equals("true")) {
                    z = true;
                }
            }
        } catch (Exception e10) {
            Log.e("CommonUtils", "isPrintLog error " + e10.getMessage());
        }
        f12951c = z;
        HandlerThread handlerThread = new HandlerThread("UsageStats_Logger");
        handlerThread.start();
        f12950b = new Handler(handlerThread.getLooper());
    }

    public static void a(String str, String str2) {
        Log.d("[Cloud]Data", c(str, str2));
        f12950b.post(new a(LogLevel.f8041b, str, str2, Thread.currentThread().getId(), Thread.currentThread().getName()));
    }

    public static void b(String str, String str2) {
        Log.e("[Cloud]Data", c(str, str2));
        f12950b.post(new a(LogLevel.f8044e, str, str2, Thread.currentThread().getId(), Thread.currentThread().getName()));
    }

    public static String c(String str, String str2) {
        Thread threadCurrentThread = Thread.currentThread();
        StringBuilder sb2 = new StringBuilder("[");
        sb2.append(threadCurrentThread.getName());
        sb2.append("-");
        sb2.append(threadCurrentThread.getId());
        sb2.append("][");
        sb2.append(str);
        return ai.onnxruntime.a.o(sb2, "] ", str2);
    }

    public static void d(String str, String str2) {
        Log.i("[Cloud]Data", c(str, str2));
        f12950b.post(new a(LogLevel.f8042c, str, str2, Thread.currentThread().getId(), Thread.currentThread().getName()));
    }

    public static void e(String str, String str2) {
        Log.v("[Cloud]Data", c(str, str2));
        f12950b.post(new a(LogLevel.f8040a, str, str2, Thread.currentThread().getId(), Thread.currentThread().getName()));
    }

    public static void f(String str, String str2) {
        Log.w("[Cloud]Data", c(str, str2));
        f12950b.post(new a(LogLevel.f8043d, str, str2, Thread.currentThread().getId(), Thread.currentThread().getName()));
    }
}
