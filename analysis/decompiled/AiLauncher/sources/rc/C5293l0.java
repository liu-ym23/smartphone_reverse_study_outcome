package rc;

import org.scilab.forge.jlatexmath.ParseException;

/* renamed from: rc.l0, reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public class C5293l0 extends C5291k0 {
    public static void e(String str, String str2, String str3, int i10) throws ParseException {
        StringBuilder sb2 = new StringBuilder();
        sb2.append(str2);
        sb2.append(" #");
        int i11 = i10 + 1;
        sb2.append(i11);
        sb2.append(" ");
        sb2.append(str3);
        C5291k0.a(str + "@env", sb2.toString(), i11);
    }

    public static void f(String str, String str2, String str3, int i10) throws ParseException {
        if (C5291k0.f39338a.get(str + "@env") == null) {
            throw new ParseException("Environment " + str + "is not defined ! Use newenvironment instead ...");
        }
        StringBuilder sb2 = new StringBuilder();
        sb2.append(str2);
        sb2.append(" #");
        int i11 = i10 + 1;
        sb2.append(i11);
        sb2.append(" ");
        sb2.append(str3);
        C5291k0.c(str + "@env", sb2.toString(), i11);
    }
}
