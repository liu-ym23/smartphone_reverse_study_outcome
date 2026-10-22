package com.networknt.org.apache.commons.validator.routines;

import androidx.appfunctions.metadata.a;
import java.io.Serializable;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* loaded from: classes3.dex */
public class RegexValidator implements Serializable {

    /* renamed from: a, reason: collision with root package name */
    public final Pattern[] f3009a = new Pattern[1];

    public RegexValidator(String str) {
        String[] strArr = {str};
        for (int i = 0; i < 1; i++) {
            String str2 = strArr[i];
            if (str2 == null || str2.isEmpty()) {
                throw new IllegalArgumentException(a.i(i, "Regular expression[", "] is missing"));
            }
            this.f3009a[i] = Pattern.compile(strArr[i], 0);
        }
    }

    public final String[] a(String str) {
        if (str == null) {
            return null;
        }
        int i = 0;
        for (Pattern pattern : this.f3009a) {
            Matcher matcher = pattern.matcher(str);
            if (matcher.matches()) {
                int iGroupCount = matcher.groupCount();
                String[] strArr = new String[iGroupCount];
                while (i < iGroupCount) {
                    int i6 = i + 1;
                    strArr[i] = matcher.group(i6);
                    i = i6;
                }
                return strArr;
            }
        }
        return null;
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder("RegexValidator{");
        int i = 0;
        while (true) {
            Pattern[] patternArr = this.f3009a;
            if (i >= patternArr.length) {
                sb.append("}");
                return sb.toString();
            }
            if (i > 0) {
                sb.append(",");
            }
            sb.append(patternArr[i].pattern());
            i++;
        }
    }
}
