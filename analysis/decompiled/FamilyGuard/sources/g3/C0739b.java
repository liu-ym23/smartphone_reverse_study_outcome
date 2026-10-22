package g3;

import android.os.Process;
import android.util.Log;
import androidx.exifinterface.media.ExifInterface;
import f3.C0719a;
import java.io.File;
import java.io.FileWriter;
import java.nio.charset.Charset;
import java.text.SimpleDateFormat;
import java.util.Date;

/* renamed from: g3.b, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public class C0739b implements InterfaceC0740c {

    /* renamed from: a, reason: collision with root package name */
    private final long f17560a = 10485760;

    /* renamed from: b, reason: collision with root package name */
    private final String f17561b = "usage_logs_v2.txt";

    /* renamed from: c, reason: collision with root package name */
    private final String f17562c = "usage_logs_v2_old.txt";

    /* renamed from: d, reason: collision with root package name */
    private String f17563d;

    /* renamed from: e, reason: collision with root package name */
    private File f17564e;

    /* renamed from: f, reason: collision with root package name */
    private C0738a f17565f;

    /* renamed from: g, reason: collision with root package name */
    private SimpleDateFormat f17566g;

    /* renamed from: h, reason: collision with root package name */
    private int f17567h;

    public C0739b(String str) {
        this.f17563d = str;
        File file = new File(str);
        if (!file.exists() || !file.isDirectory()) {
            file.mkdirs();
        }
        this.f17564e = new File(str, "usage_logs_v2.txt");
        this.f17565f = new C0738a("copyright");
        this.f17566g = new SimpleDateFormat("MM-dd HH:mm:ss.SSS");
        this.f17567h = Process.myPid();
    }

    @Override // g3.InterfaceC0740c
    public void a(EnumC0741d enumC0741d, String str, String str2, long j5) throws Throwable {
        try {
            StringBuilder sb = new StringBuilder();
            sb.append(this.f17566g.format(new Date()));
            sb.append("\t");
            sb.append(this.f17567h);
            sb.append("-");
            sb.append(j5);
            sb.append("\t");
            sb.append(enumC0741d == EnumC0741d.DEBUG ? "D" : enumC0741d == EnumC0741d.INFO ? "I" : enumC0741d == EnumC0741d.WARN ? ExifInterface.LONGITUDE_WEST : ExifInterface.LONGITUDE_EAST);
            sb.append("/");
            sb.append(str);
            sb.append(": ");
            sb.append(str2);
            String strA = this.f17565f.a(sb.toString().getBytes(Charset.forName("UTF-8")));
            if (this.f17564e.exists() && this.f17564e.length() + strA.getBytes().length > 10485760) {
                String parent = this.f17564e.getParent();
                File file = new File(parent, "usage_logs_v2_old.txt");
                if (file.exists()) {
                    file.delete();
                }
                this.f17564e.renameTo(new File(parent, "usage_logs_v2_old.txt"));
                this.f17564e = new File(this.f17563d, "usage_logs_v2.txt");
            }
            FileWriter fileWriter = null;
            try {
                FileWriter fileWriter2 = new FileWriter(this.f17564e, true);
                try {
                    fileWriter2.write(strA);
                    fileWriter2.write("\r\n");
                    C0719a.a(fileWriter2);
                } catch (Exception unused) {
                    fileWriter = fileWriter2;
                    C0719a.a(fileWriter);
                } catch (Throwable th) {
                    th = th;
                    fileWriter = fileWriter2;
                    C0719a.a(fileWriter);
                    throw th;
                }
            } catch (Exception unused2) {
            } catch (Throwable th2) {
                th = th2;
            }
        } catch (Exception e6) {
            Log.e("EncryptLogger", "Exception: " + e6.toString() + " - Cause: " + e6.getCause());
        }
    }
}
