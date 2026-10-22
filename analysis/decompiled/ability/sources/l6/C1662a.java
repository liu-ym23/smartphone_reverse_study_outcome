package l6;

import com.stepos.taskrobot.logger.FormatStrategy;
import h2.d;
import java.text.SimpleDateFormat;
import java.util.Date;

/* renamed from: l6.a, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public final class C1662a implements FormatStrategy {
    public static final String e = System.getProperty("line.separator");

    /* renamed from: a, reason: collision with root package name */
    public final Date f5286a;
    public final SimpleDateFormat b;
    public final d c;
    public final String d;

    public C1662a(u1.d dVar) {
        this.f5286a = (Date) dVar.b;
        this.b = (SimpleDateFormat) dVar.c;
        this.c = (d) dVar.d;
        this.d = (String) dVar.e;
    }

    @Override // com.stepos.taskrobot.logger.FormatStrategy
    public final void log(int i, String str, String str2) {
        String str3;
        str2.getClass();
        String strB = this.d;
        if (str != null && str.length() != 0) {
            if (!(strB == str ? true : (str == null || strB.length() != str.length()) ? false : strB.equals(str))) {
                strB = B7.a.B(strB, "-", str);
            }
        }
        long jCurrentTimeMillis = System.currentTimeMillis();
        Date date = this.f5286a;
        date.setTime(jCurrentTimeMillis);
        StringBuilder sb = new StringBuilder();
        sb.append(Long.toString(date.getTime()));
        sb.append(",");
        sb.append(this.b.format(date));
        sb.append(",");
        switch (i) {
            case 2:
                str3 = "VERBOSE";
                break;
            case 3:
                str3 = "DEBUG";
                break;
            case 4:
                str3 = "INFO";
                break;
            case 5:
                str3 = "WARN";
                break;
            case 6:
                str3 = "ERROR";
                break;
            case 7:
                str3 = "ASSERT";
                break;
            default:
                str3 = "UNKNOWN";
                break;
        }
        androidx.compose.foundation.b.C(sb, str3, ",", strB);
        String str4 = e;
        if (str2.contains(str4)) {
            str2 = str2.replaceAll(str4, " <br> ");
        }
        androidx.compose.foundation.b.C(sb, ",", str2, str4);
        this.c.log(i, strB, sb.toString());
    }
}
