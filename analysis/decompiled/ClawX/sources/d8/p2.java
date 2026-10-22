package d8;

import java.util.HashMap;
import java.util.StringTokenizer;

/* compiled from: r8-map-id-ca86e8b578419e4708a9a7ee3f056b062b20ba338a8b13e201aefe3710dbf238 */
/* loaded from: classes.dex */
public abstract class p2 {

    /* renamed from: a, reason: collision with root package name */
    public static HashMap f2117a;

    static {
        try {
            b();
        } catch (SecurityException unused) {
        }
    }

    public static boolean a() {
        HashMap map = f2117a;
        return (map == null || map.get("multiline") == null) ? false : true;
    }

    public static void b() {
        String property = System.getProperty("dnsjava.options");
        if (property != null) {
            StringTokenizer stringTokenizer = new StringTokenizer(property, ",");
            while (stringTokenizer.hasMoreTokens()) {
                String strNextToken = stringTokenizer.nextToken();
                int iIndexOf = strNextToken.indexOf(61);
                if (iIndexOf == -1) {
                    if (f2117a == null) {
                        f2117a = new HashMap();
                    }
                    f2117a.put(strNextToken.toLowerCase(), "true");
                } else {
                    String strSubstring = strNextToken.substring(0, iIndexOf);
                    String strSubstring2 = strNextToken.substring(iIndexOf + 1);
                    if (f2117a == null) {
                        f2117a = new HashMap();
                    }
                    f2117a.put(strSubstring.toLowerCase(), strSubstring2.toLowerCase());
                }
            }
        }
    }
}
