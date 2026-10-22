package com.blankj.utilcode.util;

import android.content.res.Resources;
import java.util.IllegalFormatException;

/* loaded from: classes.dex */
public final class o {
    public static String a(String str, Object... objArr) {
        if (str != null && objArr != null && objArr.length > 0) {
            try {
                return String.format(str, objArr);
            } catch (IllegalFormatException e10) {
                e10.printStackTrace();
            }
        }
        return str;
    }

    public static String b(int i10) {
        return c(i10, null);
    }

    public static String c(int i10, Object... objArr) {
        try {
            return a(p.a().getString(i10), objArr);
        } catch (Resources.NotFoundException e10) {
            e10.printStackTrace();
            return String.valueOf(i10);
        }
    }
}
