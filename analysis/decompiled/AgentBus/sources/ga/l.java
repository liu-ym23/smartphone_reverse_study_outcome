package ga;

import d7.s;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes.dex */
public abstract class l extends ib.k {
    public static String Y(String str) throws IOException {
        q7.k.e(str, "<this>");
        if (k.t0("|")) {
            throw new IllegalArgumentException("marginPrefix must be non-blank string.");
        }
        List listX0 = k.x0(str);
        int length = str.length();
        listX0.size();
        int iT0 = s.t0(listX0);
        ArrayList arrayList = new ArrayList();
        int i2 = 0;
        for (Object obj : listX0) {
            int i10 = i2 + 1;
            String strSubstring = null;
            if (i2 < 0) {
                s.z0();
                throw null;
            }
            String str2 = (String) obj;
            if ((i2 != 0 && i2 != iT0) || !k.t0(str2)) {
                int length2 = str2.length();
                int i11 = 0;
                while (true) {
                    if (i11 >= length2) {
                        i11 = -1;
                        break;
                    }
                    if (!ib.c.E(str2.charAt(i11))) {
                        break;
                    }
                    i11++;
                }
                if (i11 != -1 && r.f0(i11, str2, "|", false)) {
                    strSubstring = str2.substring("|".length() + i11);
                    q7.k.d(strSubstring, "substring(...)");
                }
                if (strSubstring == null) {
                    strSubstring = str2;
                }
            }
            if (strSubstring != null) {
                arrayList.add(strSubstring);
            }
            i2 = i10;
        }
        StringBuilder sb2 = new StringBuilder(length);
        d7.r.T0(arrayList, sb2, "\n", null, null, null, 124);
        return sb2.toString();
    }
}
