package androidx.core.net;

import android.net.Uri;
import com.bytedance.ee.bear.drive.biz.upload.filepicker.model.Permission;

/* JADX INFO: loaded from: classes6.dex */
public final class UriCompat {
    private UriCompat() {
    }

    public static String toSafeString(Uri r100) {
        String r101 = r100.getScheme();
        String r102 = r100.getSchemeSpecificPart();
        if (r101 != null) goto L5;
    L49:
        StringBuilder r103 = new StringBuilder(64);
        if (r101 == null) goto L52;
        r103.append(r101);
        r103.append(':');
    L52:
        if (r102 == null) goto L55;
        r103.append(r102);
    L55:
        return r103.toString();
    L5:
        if (r101.equalsIgnoreCase("tel") == false) goto L7;
    L33:
        StringBuilder r104 = new StringBuilder(64);
        r104.append(r101);
        r104.append(':');
        if (r102 == null) goto L48;
        int r105 = 0;
    L37:
        if (r105 >= r102.length()) goto L48;
        char r106 = r102.charAt(r105);
        if (r106 == '-') goto L45;
        if (r106 == '@') goto L45;
        if (r106 == '.') goto L45;
        r104.append(Permission.EXECUTE);
    L46:
        r105 = r105 + 1;
    L45:
        r104.append(r106);
    L48:
        return r104.toString();
    L7:
        if (r101.equalsIgnoreCase("sip") == true) goto L33;
        if (r101.equalsIgnoreCase("sms") == true) goto L33;
        if (r101.equalsIgnoreCase("smsto") == true) goto L33;
        if (r101.equalsIgnoreCase("mailto") == true) goto L33;
        if (r101.equalsIgnoreCase("nfc") == true) goto L33;
        if (r101.equalsIgnoreCase("http") == false) goto L20;
    L25:
        StringBuilder r107 = new StringBuilder("//");
        String r108 = "";
        if (r100.getHost() == null) goto L28;
        String r109 = r100.getHost();
    L29:
        r107.append(r109);
        if (r100.getPort() == (-1)) goto L32;
        r108 = ":" + r100.getPort();
    L32:
        r107.append(r108);
        r107.append("/...");
        r102 = r107.toString();
        goto L49
    L28:
        r109 = "";
        goto L29
    L20:
        if (r101.equalsIgnoreCase("https") == true) goto L25;
        if (r101.equalsIgnoreCase("ftp") == true) goto L25;
        if (r101.equalsIgnoreCase("rtsp") == false) goto L49;
        goto L25
    }
}
