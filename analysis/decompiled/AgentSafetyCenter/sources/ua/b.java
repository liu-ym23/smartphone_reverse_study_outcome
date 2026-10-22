package ua;

import android.util.Log;
import androidx.exifinterface.media.ExifInterface;
import d1.f;
import java.io.File;
import java.io.FileWriter;
import java.nio.charset.Charset;
import java.text.SimpleDateFormat;
import java.util.Date;
import t.o;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final class b implements Runnable {

    /* renamed from: c, reason: collision with root package name */
    public final int f14282c;

    /* renamed from: f, reason: collision with root package name */
    public final String f14283f;

    /* renamed from: g, reason: collision with root package name */
    public final String f14284g;

    /* renamed from: h, reason: collision with root package name */
    public final String f14285h;
    public final long i;

    public b(int i, String str, String str2, long j10, String str3) {
        this.f14282c = i;
        this.f14283f = str;
        this.f14284g = str2;
        this.i = j10;
        this.f14285h = str3;
    }

    @Override // java.lang.Runnable
    public final void run() throws Throwable {
        f fVar;
        int i = this.f14282c;
        int iC = s.f.c(i);
        f fVar2 = c.f14286a;
        if (iC < 1 || (fVar = c.f14286a) == null) {
            return;
        }
        String str = this.f14283f;
        String str2 = this.f14285h + "|" + this.f14284g;
        long j10 = this.i;
        try {
            StringBuilder sb2 = new StringBuilder();
            sb2.append(((SimpleDateFormat) fVar.f2971e).format(new Date()));
            sb2.append("\t");
            sb2.append(fVar.f2967a);
            sb2.append("-");
            sb2.append(j10);
            sb2.append("\t");
            sb2.append(i == 2 ? "D" : i == 3 ? "I" : i == 4 ? ExifInterface.LONGITUDE_WEST : ExifInterface.LONGITUDE_EAST);
            sb2.append("/");
            sb2.append(str);
            sb2.append(": ");
            sb2.append(str2);
            String strA = ((a) fVar.f2970d).a(sb2.toString().getBytes(Charset.forName("UTF-8")));
            if (((File) fVar.f2969c).exists() && ((File) fVar.f2969c).length() + strA.getBytes().length > 10485760) {
                String parent = ((File) fVar.f2969c).getParent();
                File file = new File(parent, "usage_logs_v2_old.txt");
                if (file.exists()) {
                    file.delete();
                }
                ((File) fVar.f2969c).renameTo(new File(parent, "usage_logs_v2_old.txt"));
                fVar.f2969c = new File((String) fVar.f2968b, "usage_logs_v2.txt");
            }
            FileWriter fileWriter = null;
            try {
                FileWriter fileWriter2 = new FileWriter((File) fVar.f2969c, true);
                try {
                    fileWriter2.write(strA);
                    fileWriter2.write("\r\n");
                    o.e(fileWriter2);
                } catch (Exception unused) {
                    fileWriter = fileWriter2;
                    o.e(fileWriter);
                } catch (Throwable th) {
                    th = th;
                    fileWriter = fileWriter2;
                    o.e(fileWriter);
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
