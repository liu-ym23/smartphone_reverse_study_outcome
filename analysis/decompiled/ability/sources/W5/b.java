package W5;

import D9.t;
import android.util.Log;
import androidx.exifinterface.media.ExifInterface;
import com.stepos.statsapp.v3.utils.log.LogLevel;
import java.io.File;
import java.io.FileWriter;
import java.nio.charset.Charset;
import java.text.SimpleDateFormat;
import java.util.Date;
import org.json.HTTP;
import z2.l;

/* loaded from: classes3.dex */
public final class b implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    public final LogLevel f1490a;
    public final String b;
    public final String c;
    public final String d;
    public final long e;

    public b(LogLevel logLevel, String str, String str2, long j5, String str3) {
        this.f1490a = logLevel;
        this.b = str;
        this.c = str2;
        this.e = j5;
        this.d = str3;
    }

    @Override // java.lang.Runnable
    public final void run() throws Throwable {
        t tVar;
        LogLevel logLevel = this.f1490a;
        int iOrdinal = logLevel.ordinal();
        t tVar2 = c.f1491a;
        if (iOrdinal < 1 || (tVar = c.f1491a) == null) {
            return;
        }
        String str = this.b;
        String str2 = this.d + "|" + this.c;
        long j5 = this.e;
        try {
            StringBuilder sb = new StringBuilder();
            sb.append(((SimpleDateFormat) tVar.f).format(new Date()));
            sb.append("\t");
            sb.append(tVar.c);
            sb.append("-");
            sb.append(j5);
            sb.append("\t");
            sb.append(logLevel == LogLevel.b ? "D" : logLevel == LogLevel.c ? "I" : logLevel == LogLevel.d ? ExifInterface.LONGITUDE_WEST : ExifInterface.LONGITUDE_EAST);
            sb.append("/");
            sb.append(str);
            sb.append(": ");
            sb.append(str2);
            String strA = ((a) tVar.e).a(sb.toString().getBytes(Charset.forName("UTF-8")));
            if (((File) tVar.d).exists() && ((File) tVar.d).length() + strA.getBytes().length > 10485760) {
                String parent = ((File) tVar.d).getParent();
                File file = new File(parent, "usage_logs_v2_old.txt");
                if (file.exists()) {
                    file.delete();
                }
                ((File) tVar.d).renameTo(new File(parent, "usage_logs_v2_old.txt"));
                tVar.d = new File((String) tVar.b, "usage_logs_v2.txt");
            }
            FileWriter fileWriter = null;
            try {
                FileWriter fileWriter2 = new FileWriter((File) tVar.d, true);
                try {
                    fileWriter2.write(strA);
                    fileWriter2.write(HTTP.CRLF);
                    l.o(fileWriter2);
                } catch (Exception unused) {
                    fileWriter = fileWriter2;
                    l.o(fileWriter);
                } catch (Throwable th) {
                    th = th;
                    fileWriter = fileWriter2;
                    l.o(fileWriter);
                    throw th;
                }
            } catch (Exception unused2) {
            } catch (Throwable th2) {
                th = th2;
            }
        } catch (Exception e) {
            Log.e("EncryptLogger", "Exception: " + e.toString() + " - Cause: " + e.getCause());
        }
    }
}
