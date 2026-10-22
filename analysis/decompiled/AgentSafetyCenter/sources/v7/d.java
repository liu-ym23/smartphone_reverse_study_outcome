package v7;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public class d implements Serializable {

    /* renamed from: g, reason: collision with root package name */
    public static final Pattern f14841g = Pattern.compile("^(.+)@(\\S+)$");

    /* renamed from: h, reason: collision with root package name */
    public static final Pattern f14842h = Pattern.compile("^\\[(.*)\\]$");
    public static final Pattern i = Pattern.compile("^(((\\\\.)|[^\\s\\p{Cntrl}\\(\\)<>@,;:'\\\\\\\"\\.\\[\\]]|')+|(\"(\\\\\"|[^\"])*\"))(\\.(((\\\\.)|[^\\s\\p{Cntrl}\\(\\)<>@,;:'\\\\\\\"\\.\\[\\]]|')+|(\"(\\\\\"|[^\"])*\")))*$");

    /* renamed from: c, reason: collision with root package name */
    public final boolean f14843c;

    /* renamed from: f, reason: collision with root package name */
    public final c f14844f;

    static {
        new d(false, false);
        new d(false, true);
        new d(true, false);
        new d(true, true);
    }

    public d(boolean z10, boolean z11) {
        c cVar;
        this.f14843c = z11;
        synchronized (c.class) {
            cVar = z10 ? b.f14822b : b.f14821a;
        }
        this.f14844f = cVar;
    }

    public final boolean a(String str) {
        if (str != null && !str.endsWith(".")) {
            Matcher matcher = f14841g.matcher(str);
            if (matcher.matches()) {
                String strGroup = matcher.group(1);
                if ((strGroup == null || strGroup.length() > 64) ? false : i.matcher(strGroup).matches()) {
                    return b(matcher.group(2));
                }
            }
        }
        return false;
    }

    public boolean b(String str) throws NumberFormatException {
        String str2;
        boolean zContains;
        int i3;
        Matcher matcher = f14842h.matcher(str);
        if (!matcher.matches()) {
            boolean z10 = this.f14843c;
            c cVar = this.f14844f;
            return z10 ? cVar.c(str) || (!str.startsWith(".") && cVar.d(str)) : cVar.c(str);
        }
        e eVar = e.f14845f;
        String strGroup = matcher.group(1);
        if (!eVar.a(strGroup)) {
            String[] strArrSplit = strGroup.split("/", -1);
            if (strArrSplit.length <= 2 && (strArrSplit.length != 2 || (e.f14846g.matcher(strArrSplit[1]).matches() && (i3 = Integer.parseInt(strArrSplit[1])) >= 0 && i3 <= 128))) {
                String[] strArrSplit2 = strArrSplit[0].split("%", -1);
                if (strArrSplit2.length <= 2 && ((strArrSplit2.length != 2 || e.f14847h.matcher(strArrSplit2[1]).matches()) && ((!(zContains = (str2 = strArrSplit2[0]).contains("::")) || str2.indexOf("::") == str2.lastIndexOf("::")) && ((!str2.startsWith(":") || str2.startsWith("::")) && (!str2.endsWith(":") || str2.endsWith("::")))))) {
                    String[] strArrSplit3 = str2.split(":");
                    if (zContains) {
                        ArrayList arrayList = new ArrayList(Arrays.asList(strArrSplit3));
                        if (str2.endsWith("::")) {
                            arrayList.add("");
                        } else if (str2.startsWith("::") && !arrayList.isEmpty()) {
                            arrayList.remove(0);
                        }
                        strArrSplit3 = (String[]) arrayList.toArray(new String[0]);
                    }
                    if (strArrSplit3.length <= 8) {
                        int i10 = 0;
                        int i11 = 0;
                        int i12 = 0;
                        while (true) {
                            if (i10 >= strArrSplit3.length) {
                                if (i11 > 8 || (i11 < 8 && !zContains)) {
                                    break;
                                }
                            } else {
                                String str3 = strArrSplit3[i10];
                                if (str3.isEmpty()) {
                                    i12++;
                                    if (i12 > 1) {
                                        break;
                                    }
                                    i11++;
                                } else if (i10 == strArrSplit3.length - 1 && str3.contains(".")) {
                                    if (!eVar.a(str3)) {
                                        break;
                                    }
                                    i11 += 2;
                                    i12 = 0;
                                } else {
                                    if (str3.length() > 4) {
                                        break;
                                    }
                                    try {
                                        int i13 = Integer.parseInt(str3, 16);
                                        if (i13 < 0 || i13 > 65535) {
                                            break;
                                        }
                                        i12 = 0;
                                        i11++;
                                    } catch (NumberFormatException unused) {
                                        return false;
                                    }
                                }
                                i10++;
                            }
                        }
                    }
                }
            }
        }
    }
}
