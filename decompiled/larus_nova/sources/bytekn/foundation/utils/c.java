package bytekn.foundation.utils;

import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes3.dex */
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Map<String, String> f21807a = null;

    static {
        f21807a = new LinkedHashMap();
    }

    public static String a(String r110) {
        int r100 = 0;
        if (StringsKt.startsWith$default(r110, "algo_", false, 2, null) == false) goto L5;
        return r110;
    L5:
        String r101 = (String) ((LinkedHashMap) f21807a).get(r110);
        if (r101 == null) goto L8;
        return r101;
    L8:
        String r102 = ".model";
        if (StringsKt.endsWith$default(r110, ".model", false, 2, null) == false) goto L11;
        String r103 = r110.substring(0, r110.length() - 6);
        boolean r104 = true;
    L12:
        StringBuilder r105 = new StringBuilder();
        int r106 = r103.length();
    L13:
        if (r100 >= r106) goto L18;
        char r111 = r103.charAt(r100);
        int r107 = StringsKt.indexOf$default("ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789_", r111, 0, false, 6, null);
        if (r107 == (-1)) goto L17;
        r111 = "CQTZKHGJYMUWPBDEVRASONFILXp4qvh1a053s98cti27ugkrnm6_yjfbxdewozl".charAt(r107);
    L17:
        r105.append(r111);
        r100 = r100 + 1;
        goto L13
    L18:
        StringBuilder r108 = new StringBuilder("algo_");
        r108.append(r105.toString());
        if (r104 == true) goto L22;
        r102 = "";
    L22:
        r108.append(r102);
        String r109 = r108.toString();
        f21807a.put(r110, r109);
        return r109;
    L11:
        r104 = false;
        r103 = r110;
        goto L12
    }
}
