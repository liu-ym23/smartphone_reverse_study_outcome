package Q5;

import La.C;
import La.H;
import com.autonavi.aps.amapapi.config.Const;
import java.util.List;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\b\bÀ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J5\u0010\n\u001a\u00020\t2\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\b\u0010\u0006\u001a\u0004\u0018\u00010\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u00042\b\u0010\b\u001a\u0004\u0018\u00010\u0004¢\u0006\u0004\b\n\u0010\u000bJ\u0019\u0010\u000e\u001a\u0004\u0018\u00010\r2\b\u0010\f\u001a\u0004\u0018\u00010\u0004¢\u0006\u0004\b\u000e\u0010\u000fJ\u0019\u0010\u0010\u001a\u0004\u0018\u00010\u00042\b\u0010\f\u001a\u0004\u0018\u00010\u0004¢\u0006\u0004\b\u0010\u0010\u0011R\u0014\u0010\u0012\u001a\u00020\r8\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u0012\u0010\u0013R\u0014\u0010\u0014\u001a\u00020\r8\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u0014\u0010\u0013¨\u0006\u0015"}, d2 = {"LQ5/f;", "", "<init>", "()V", "", "weatherText", "sunrise", "sunset", "time", "", Const.INTENT_KEY_PKGNAME, "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Z", "raw", "", "c", "(Ljava/lang/String;)Ljava/lang/Integer;", Const.INTENT_KEY_APIKEY, "(Ljava/lang/String;)Ljava/lang/String;", "DEFAULT_SUNRISE", "I", "DEFAULT_SUNSET", "foundation_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class f {
    private static final int DEFAULT_SUNRISE = 360;
    private static final int DEFAULT_SUNSET = 1080;
    public static final f INSTANCE = new f();

    public final String a(String raw) {
        String string;
        String strW1;
        String strD = N5.j.INSTANCE.d(raw);
        if (strD == null || (string = H.D1(strD).toString()) == null || (strW1 = H.w1(string, ' ', null, 2, null)) == null || strW1.length() <= 0) {
            return null;
        }
        return strW1;
    }

    public final boolean b(String weatherText, String sunrise, String sunset, String time) {
        l lVar = l.INSTANCE;
        if (lVar.e(weatherText)) {
            return lVar.f(weatherText);
        }
        Integer numC = c(time);
        if (numC == null) {
            return false;
        }
        int iIntValue = numC.intValue();
        Integer numC2 = c(sunrise);
        int iIntValue2 = numC2 != null ? numC2.intValue() : 360;
        Integer numC3 = c(sunset);
        return iIntValue < iIntValue2 || iIntValue >= (numC3 != null ? numC3.intValue() : DEFAULT_SUNSET);
    }

    public final Integer c(String raw) {
        String string;
        Integer numW;
        String strD = N5.j.INSTANCE.d(raw);
        if (strD != null && (string = H.D1(strD).toString()) != null) {
            List listA1 = H.a1(H.s1(string, ' ', null, 2, null), new char[]{':'}, false, 0, 6, null);
            if (listA1.size() >= 2 && (numW = C.w((String) listA1.get(0))) != null) {
                int iIntValue = numW.intValue();
                Integer numW2 = C.w((String) listA1.get(1));
                if (numW2 != null) {
                    int iIntValue2 = numW2.intValue();
                    if (iIntValue >= 0 && iIntValue < 24 && iIntValue2 >= 0 && iIntValue2 < 60) {
                        return Integer.valueOf((iIntValue * 60) + iIntValue2);
                    }
                }
            }
        }
        return null;
    }
}
