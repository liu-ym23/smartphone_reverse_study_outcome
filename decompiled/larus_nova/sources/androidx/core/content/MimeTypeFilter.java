package androidx.core.content;

import com.byted.cast.linkcommon.cybergarage.http.HTTP;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes17.dex */
public final class MimeTypeFilter {
    private MimeTypeFilter() {
    }

    public static String matches(String r100, String[] r101) {
        if (r100 != null) goto L5;
        return null;
    L5:
        String[] r102 = r100.split(HTTP.URL_DEFAULT);
        int r103 = r101.length;
        int r104 = 0;
    L6:
        if (r104 >= r103) goto L11;
        String r105 = r101[r104];
        if (mimeTypeAgainstFilter(r102, r105.split(HTTP.URL_DEFAULT)) == true) goto L9;
        r104 = r104 + 1;
        goto L6
    L9:
        return r105;
    L11:
        return null;
    }

    public static String[] matchesMany(String[] r100, String r101) {
        int r102 = 0;
        if (r100 == null) goto L5;
        ArrayList r103 = new ArrayList();
        String[] r104 = r101.split(HTTP.URL_DEFAULT);
        int r105 = r100.length;
    L7:
        if (r102 >= r105) goto L13;
        String r106 = r100[r102];
        if (mimeTypeAgainstFilter(r106.split(HTTP.URL_DEFAULT), r104) == false) goto L11;
        r103.add(r106);
    L11:
        r102 = r102 + 1;
        goto L7
    L13:
        return (String[]) r103.toArray(new String[r103.size()]);
    L5:
        return new String[0];
    }

    private static boolean mimeTypeAgainstFilter(String[] r100, String[] r101) {
        if (r101.length != 2) goto L25;
        if (r101[0].isEmpty() == true) goto L23;
        if (r101[1].isEmpty() == true) goto L23;
        if (r100.length == 2) goto L12;
        return false;
    L12:
        if ("*".equals(r101[0]) == true) goto L17;
        if (r101[0].equals(r100[0]) == true) goto L17;
        return false;
    L17:
        if ("*".equals(r101[1]) == false) goto L19;
    L21:
        return true;
    L19:
        if (r101[1].equals(r100[1]) == true) goto L21;
        return false;
    L23:
        throw new IllegalArgumentException("Ill-formatted MIME type filter. Type or subtype empty.");
    L25:
        throw new IllegalArgumentException("Ill-formatted MIME type filter. Must be type/subtype.");
    }

    public static String matches(String[] r100, String r101) {
        if (r100 != null) goto L5;
        return null;
    L5:
        String[] r102 = r101.split(HTTP.URL_DEFAULT);
        int r103 = r100.length;
        int r104 = 0;
    L6:
        if (r104 >= r103) goto L11;
        String r105 = r100[r104];
        if (mimeTypeAgainstFilter(r105.split(HTTP.URL_DEFAULT), r102) == true) goto L9;
        r104 = r104 + 1;
        goto L6
    L9:
        return r105;
    L11:
        return null;
    }

    public static boolean matches(String r100, String r101) {
        if (r100 != null) goto L6;
        return false;
    L6:
        return mimeTypeAgainstFilter(r100.split(HTTP.URL_DEFAULT), r101.split(HTTP.URL_DEFAULT));
    }
}
