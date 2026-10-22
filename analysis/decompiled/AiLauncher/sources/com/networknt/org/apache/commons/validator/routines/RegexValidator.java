package com.networknt.org.apache.commons.validator.routines;

import com.autonavi.aps.amapapi.config.Const;
import java.io.Serializable;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* loaded from: classes2.dex */
public class RegexValidator implements Serializable {

    /* renamed from: a, reason: collision with root package name */
    public final Pattern[] f21960a;

    public RegexValidator(String str) {
        this(str, true);
    }

    public boolean a(String str) {
        if (str == null) {
            return false;
        }
        for (Pattern pattern : this.f21960a) {
            if (pattern.matcher(str).matches()) {
                return true;
            }
        }
        return false;
    }

    public String[] b(String str) {
        if (str == null) {
            return null;
        }
        int i10 = 0;
        for (Pattern pattern : this.f21960a) {
            Matcher matcher = pattern.matcher(str);
            if (matcher.matches()) {
                int iGroupCount = matcher.groupCount();
                String[] strArr = new String[iGroupCount];
                while (i10 < iGroupCount) {
                    int i11 = i10 + 1;
                    strArr[i10] = matcher.group(i11);
                    i10 = i11;
                }
                return strArr;
            }
        }
        return null;
    }

    public String toString() {
        StringBuilder sb2 = new StringBuilder();
        sb2.append("RegexValidator{");
        for (int i10 = 0; i10 < this.f21960a.length; i10++) {
            if (i10 > 0) {
                sb2.append(Const.STR_MART_COMMA);
            }
            sb2.append(this.f21960a[i10].pattern());
        }
        sb2.append("}");
        return sb2.toString();
    }

    public RegexValidator(String str, boolean z10) {
        this(new String[]{str}, z10);
    }

    public RegexValidator(String[] strArr, boolean z10) {
        if (strArr != null && strArr.length != 0) {
            this.f21960a = new Pattern[strArr.length];
            int i10 = z10 ? 0 : 2;
            for (int i11 = 0; i11 < strArr.length; i11++) {
                String str = strArr[i11];
                if (str != null && !str.isEmpty()) {
                    this.f21960a[i11] = Pattern.compile(strArr[i11], i10);
                } else {
                    throw new IllegalArgumentException("Regular expression[" + i11 + "] is missing");
                }
            }
            return;
        }
        throw new IllegalArgumentException("Regular expressions are missing");
    }
}
