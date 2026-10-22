package T2;

import android.util.Log;
import androidx.exifinterface.media.ExifInterface;
import ch.qos.logback.classic.net.SyslogAppender;
import ch.qos.logback.core.rolling.SizeBasedTriggeringPolicy;
import com.baidu.mapapi.http.HttpClient;
import com.stepos.activeview.utils.Constants;
import com.stepos.alphame.utils.Consts;
import java.io.File;
import java.io.FileWriter;
import java.nio.charset.Charset;
import java.util.Date;
import t.h;
import t0.J;

/* loaded from: classes.dex */
public final class c implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    public final int f1867a;

    /* renamed from: b, reason: collision with root package name */
    public final String f1868b;

    /* renamed from: c, reason: collision with root package name */
    public final String f1869c;

    /* renamed from: d, reason: collision with root package name */
    public final String f1870d;

    /* renamed from: e, reason: collision with root package name */
    public final long f1871e;

    public c(int i4, String str, String str2, long j4, String str3) {
        this.f1867a = i4;
        this.f1868b = str;
        this.f1869c = str2;
        this.f1871e = j4;
        this.f1870d = str3;
    }

    @Override // java.lang.Runnable
    public final void run() throws Throwable {
        b bVar;
        int i4 = this.f1867a;
        int iA = h.a(i4);
        b bVar2 = d.f1872a;
        if (iA < 1 || (bVar = d.f1872a) == null) {
            return;
        }
        String str = this.f1868b;
        String str2 = this.f1870d + Consts.SPLITTER_DETAIL + this.f1869c;
        long j4 = this.f1871e;
        try {
            StringBuilder sb = new StringBuilder();
            sb.append(bVar.f1865d.format(new Date()));
            sb.append(SyslogAppender.DEFAULT_STACKTRACE_PATTERN);
            sb.append(bVar.f1866e);
            sb.append("-");
            sb.append(j4);
            sb.append(SyslogAppender.DEFAULT_STACKTRACE_PATTERN);
            sb.append(i4 == 2 ? "D" : i4 == 3 ? "I" : i4 == 4 ? ExifInterface.LONGITUDE_WEST : ExifInterface.LONGITUDE_EAST);
            sb.append("/");
            sb.append(str);
            sb.append(": ");
            sb.append(str2);
            String strA = bVar.f1864c.a(sb.toString().getBytes(Charset.forName(Constants.UTF_8_CODE)));
            if (bVar.f1863b.exists() && bVar.f1863b.length() + strA.getBytes().length > SizeBasedTriggeringPolicy.DEFAULT_MAX_FILE_SIZE) {
                String parent = bVar.f1863b.getParent();
                File file = new File(parent, "usage_logs_v2_old.txt");
                if (file.exists()) {
                    file.delete();
                }
                bVar.f1863b.renameTo(new File(parent, "usage_logs_v2_old.txt"));
                bVar.f1863b = new File(bVar.f1862a, "usage_logs_v2.txt");
            }
            FileWriter fileWriter = null;
            try {
                FileWriter fileWriter2 = new FileWriter(bVar.f1863b, true);
                try {
                    fileWriter2.write(strA);
                    fileWriter2.write(HttpClient.NEWLINE);
                    J.l(fileWriter2);
                } catch (Exception unused) {
                    fileWriter = fileWriter2;
                    J.l(fileWriter);
                } catch (Throwable th) {
                    th = th;
                    fileWriter = fileWriter2;
                    J.l(fileWriter);
                    throw th;
                }
            } catch (Exception unused2) {
            } catch (Throwable th2) {
                th = th2;
            }
        } catch (Exception e4) {
            Log.e("EncryptLogger", "Exception: " + e4.toString() + " - Cause: " + e4.getCause());
        }
    }
}
