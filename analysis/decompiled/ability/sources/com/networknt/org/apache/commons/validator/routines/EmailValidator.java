package com.networknt.org.apache.commons.validator.routines;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import t3.AbstractC2015b;

/* loaded from: classes3.dex */
public class EmailValidator implements Serializable {
    public static final Pattern c = Pattern.compile("^(.+)@(\\S+)$");
    public static final Pattern d = Pattern.compile("^\\[(.*)\\]$");
    public static final Pattern e = Pattern.compile("^(((\\\\.)|[^\\s\\p{Cntrl}\\(\\)<>@,;:'\\\\\\\"\\.\\[\\]]|')+|(\"(\\\\\"|[^\"])*\"))(\\.(((\\\\.)|[^\\s\\p{Cntrl}\\(\\)<>@,;:'\\\\\\\"\\.\\[\\]]|')+|(\"(\\\\\"|[^\"])*\")))*$");

    /* renamed from: a, reason: collision with root package name */
    public final boolean f3007a;
    public final DomainValidator b;

    static {
        new EmailValidator(false, false);
        new EmailValidator(false, true);
        new EmailValidator(true, false);
        new EmailValidator(true, true);
    }

    public EmailValidator(boolean z10, boolean z11) {
        DomainValidator domainValidator;
        this.f3007a = z11;
        synchronized (DomainValidator.class) {
            domainValidator = z10 ? AbstractC2015b.b : AbstractC2015b.f6656a;
        }
        this.b = domainValidator;
    }

    public final boolean a(String str) {
        if (str != null && !str.endsWith(".")) {
            Matcher matcher = c.matcher(str);
            if (matcher.matches()) {
                String strGroup = matcher.group(1);
                if ((strGroup == null || strGroup.length() > 64) ? false : e.matcher(strGroup).matches()) {
                    return b(matcher.group(2));
                }
            }
        }
        return false;
    }

    public boolean b(String str) throws NumberFormatException {
        String str2;
        boolean zContains;
        int i;
        Matcher matcher = d.matcher(str);
        if (!matcher.matches()) {
            boolean z10 = this.f3007a;
            DomainValidator domainValidator = this.b;
            return z10 ? domainValidator.c(str) || (!str.startsWith(".") && domainValidator.d(str)) : domainValidator.c(str);
        }
        InetAddressValidator inetAddressValidator = InetAddressValidator.b;
        String strGroup = matcher.group(1);
        if (!inetAddressValidator.a(strGroup)) {
            String[] strArrSplit = strGroup.split("/", -1);
            if (strArrSplit.length <= 2 && (strArrSplit.length != 2 || (InetAddressValidator.c.matcher(strArrSplit[1]).matches() && (i = Integer.parseInt(strArrSplit[1])) >= 0 && i <= 128))) {
                String[] strArrSplit2 = strArrSplit[0].split("%", -1);
                if (strArrSplit2.length <= 2 && ((strArrSplit2.length != 2 || InetAddressValidator.d.matcher(strArrSplit2[1]).matches()) && ((!(zContains = (str2 = strArrSplit2[0]).contains("::")) || str2.indexOf("::") == str2.lastIndexOf("::")) && ((!str2.startsWith(":") || str2.startsWith("::")) && (!str2.endsWith(":") || str2.endsWith("::")))))) {
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
                        int i6 = 0;
                        int i10 = 0;
                        int i11 = 0;
                        while (true) {
                            if (i6 >= strArrSplit3.length) {
                                if (i10 > 8 || (i10 < 8 && !zContains)) {
                                    break;
                                }
                            } else {
                                String str3 = strArrSplit3[i6];
                                if (str3.isEmpty()) {
                                    i11++;
                                    if (i11 > 1) {
                                        break;
                                    }
                                    i10++;
                                } else if (i6 == strArrSplit3.length - 1 && str3.contains(".")) {
                                    if (!inetAddressValidator.a(str3)) {
                                        break;
                                    }
                                    i10 += 2;
                                    i11 = 0;
                                } else {
                                    if (str3.length() > 4) {
                                        break;
                                    }
                                    try {
                                        int i12 = Integer.parseInt(str3, 16);
                                        if (i12 < 0 || i12 > 65535) {
                                            break;
                                        }
                                        i11 = 0;
                                        i10++;
                                    } catch (NumberFormatException unused) {
                                        return false;
                                    }
                                }
                                i6++;
                            }
                        }
                    }
                }
            }
        }
    }
}
