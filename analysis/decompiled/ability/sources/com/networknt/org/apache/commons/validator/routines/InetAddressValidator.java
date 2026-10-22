package com.networknt.org.apache.commons.validator.routines;

import java.io.Serializable;
import java.util.regex.Pattern;

/* loaded from: classes3.dex */
public class InetAddressValidator implements Serializable {
    public static final InetAddressValidator b = new InetAddressValidator();
    public static final Pattern c = Pattern.compile("\\d{1,3}");
    public static final Pattern d = Pattern.compile("[^\\s/%]+");

    /* renamed from: a, reason: collision with root package name */
    public final RegexValidator f3008a = new RegexValidator("^(\\d{1,3})\\.(\\d{1,3})\\.(\\d{1,3})\\.(\\d{1,3})$");

    public final boolean a(String str) {
        String[] strArrA = this.f3008a.a(str);
        if (strArrA == null) {
            return false;
        }
        for (String str2 : strArrA) {
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
}
