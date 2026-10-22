package k5;

import com.stepos.account.oauth.OAuthConstants;

/* loaded from: classes.dex */
public final class g implements t {
    public static void b(p7.o oVar, String str, String str2, Throwable th) {
        String str3;
        if (str2.length() <= 3500) {
            oVar.j(str, str2, th);
            return;
        }
        String strD0 = ga.r.d0(str2, '\n', ' ');
        int length = (strD0.length() + 3499) / 3500;
        int i2 = 0;
        int i10 = 1;
        while (i2 < strD0.length()) {
            int iMin = Math.min(i2 + 3500, strD0.length());
            if (length > 1) {
                str3 = "(" + i10 + "/" + length + ") ";
            } else {
                str3 = "";
            }
            String strSubstring = strD0.substring(i2, iMin);
            q7.k.d(strSubstring, "substring(...)");
            oVar.j(str, str3 + strSubstring, i10 == 1 ? th : null);
            i10++;
            i2 = iMin;
        }
    }

    public final void a(String str, String str2, Throwable th) {
        q7.k.e(str, "tag");
        q7.k.e(str2, OAuthConstants.FACTOR_RESULT_MESSAGE);
        b(c.f5621n, str, str2, th);
    }

    public final void c(String str, String str2, Throwable th) {
        q7.k.e(str, "tag");
        q7.k.e(str2, OAuthConstants.FACTOR_RESULT_MESSAGE);
        b(f.f5624n, str, str2, th);
    }
}
