package com.networknt.org.apache.commons.validator.routines;

import io.ktor.sse.ServerSentEventKt;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.regex.Pattern;

/* loaded from: classes2.dex */
public class InetAddressValidator implements Serializable {

    /* renamed from: b, reason: collision with root package name */
    public static final InetAddressValidator f21956b = new InetAddressValidator();

    /* renamed from: c, reason: collision with root package name */
    public static final Pattern f21957c = Pattern.compile("\\d{1,3}");

    /* renamed from: d, reason: collision with root package name */
    public static final Pattern f21958d = Pattern.compile("[^\\s/%]+");

    /* renamed from: a, reason: collision with root package name */
    public final RegexValidator f21959a = new RegexValidator("^(\\d{1,3})\\.(\\d{1,3})\\.(\\d{1,3})\\.(\\d{1,3})$");

    public static InetAddressValidator a() {
        return f21956b;
    }

    public boolean b(String str) {
        return c(str) || d(str);
    }

    public boolean c(String str) {
        String[] strArrB = this.f21959a.b(str);
        if (strArrB == null) {
            return false;
        }
        for (String str2 : strArrB) {
            if (str2 != null && !str2.isEmpty()) {
                try {
                    if (Integer.parseInt(str2) > 255) {
                        return false;
                    }
                    if (str2.length() > 1 && str2.startsWith("0")) {
                        return false;
                    }
                } catch (NumberFormatException unused) {
                }
            }
            return false;
        }
        return true;
    }

    public boolean d(String str) throws NumberFormatException {
        int i10;
        int i11;
        String[] strArrSplit = str.split("/", -1);
        if (strArrSplit.length > 2) {
            return false;
        }
        if (strArrSplit.length == 2 && (!f21957c.matcher(strArrSplit[1]).matches() || (i11 = Integer.parseInt(strArrSplit[1])) < 0 || i11 > 128)) {
            return false;
        }
        String[] strArrSplit2 = strArrSplit[0].split("%", -1);
        if (strArrSplit2.length > 2) {
            return false;
        }
        if (strArrSplit2.length == 2 && !f21958d.matcher(strArrSplit2[1]).matches()) {
            return false;
        }
        String str2 = strArrSplit2[0];
        boolean zContains = str2.contains("::");
        if (zContains && str2.indexOf("::") != str2.lastIndexOf("::")) {
            return false;
        }
        if ((str2.startsWith(ServerSentEventKt.COLON) && !str2.startsWith("::")) || (str2.endsWith(ServerSentEventKt.COLON) && !str2.endsWith("::"))) {
            return false;
        }
        String[] strArrSplit3 = str2.split(ServerSentEventKt.COLON);
        if (zContains) {
            ArrayList arrayList = new ArrayList(Arrays.asList(strArrSplit3));
            if (str2.endsWith("::")) {
                arrayList.add("");
            } else if (str2.startsWith("::") && !arrayList.isEmpty()) {
                arrayList.remove(0);
            }
            strArrSplit3 = (String[]) arrayList.toArray(new String[0]);
        }
        if (strArrSplit3.length > 8) {
            return false;
        }
        int i12 = 0;
        int i13 = 0;
        for (int i14 = 0; i14 < strArrSplit3.length; i14++) {
            String str3 = strArrSplit3[i14];
            if (str3.isEmpty()) {
                i13++;
                if (i13 > 1) {
                    return false;
                }
            } else if (i14 == strArrSplit3.length - 1 && str3.contains(".")) {
                if (!c(str3)) {
                    return false;
                }
                i12 += 2;
                i13 = 0;
            } else {
                if (str3.length() > 4) {
                    return false;
                }
                try {
                    i10 = Integer.parseInt(str3, 16);
                } catch (NumberFormatException unused) {
                }
                if (i10 < 0 || i10 > 65535) {
                    return false;
                }
                i13 = 0;
            }
            i12++;
        }
        return i12 <= 8 && (i12 >= 8 || zContains);
    }
}
