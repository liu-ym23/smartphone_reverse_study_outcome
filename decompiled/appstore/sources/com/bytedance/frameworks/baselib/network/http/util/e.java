package com.bytedance.frameworks.baselib.network.http.util;

import android.text.TextUtils;
import android.util.Pair;
import com.bytedance.common.utility.Logger;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.TimeZone;

/* JADX INFO: loaded from: classes.dex */
public abstract class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final String f7540a = "e";

    static {
    }

    public static long a(String r10) {
        Logger.d(f7540a, "utcTime " + r10);
        SimpleDateFormat r11 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        r11.setTimeZone(TimeZone.getTimeZone("UTC"));
        Date r12 = r11.parse(r10);     // Catch: ParseException -> L7
        if (r12 == null) goto L12;
        return r12.getTime();
    L12:
        return 0;
    L7:
        e = move-exception;
        e.printStackTrace();
        return 0;
    }

    public static boolean b(String r10, String r11, String r12, List r13) {
        if (TextUtils.isEmpty(r10) == false) goto L5;
        return false;
    L5:
        if (TextUtils.isEmpty(r11) == false) goto L7;
        return false;
    L7:
        if (TextUtils.isEmpty(r12) == true) goto L44;
        if (r13 == null) goto L46;
        String[] r14 = r10.split(r11);
        if (r14 != null) goto L13;
        return false;
    L13:
        int r15 = 0;
    L15:
        if (r15 >= r14.length) goto L32;
        if (TextUtils.isEmpty(r14[r15]) == true) goto L30;
        String[] r16 = r14[r15].trim().split(r12);
        if (r16 == null) goto L30;
        if (r16.length != 2) goto L30;
        if (TextUtils.isEmpty(r16[0]) == true) goto L30;
        if (TextUtils.isEmpty(r16[1]) == true) goto L30;
        r13.add(new Pair(r16[0].trim(), r16[1].trim()));
    L30:
        r15 = r15 + 1;
        goto L15
    L32:
        if (r13.size() != 0) goto L34;
        return false;
    L34:
        return true;
    L46:
        return false;
    L44:
        return false;
    }

    public static boolean c(String r10, List r11) {
        if (TextUtils.isEmpty(r10) == false) goto L6;
        return false;
    L6:
        if (r10.contains("~") == true) goto L8;
        return false;
    L8:
        String[] r12 = r10.split("~");
        if (r12.length == 2) goto L12;
        return false;
    L12:
        if (TextUtils.isEmpty(r12[0]) == false) goto L14;
    L27:
        return false;
    L14:
        if (TextUtils.isEmpty(r12[1]) == true) goto L27;
        if (r11 != null) goto L18;
        r11 = new ArrayList();
    L18:
        long r13 = a(r12[0]);
        long r14 = a(r12[1]);
        if (r13 <= 0) goto L27;
        if (r14 <= 0) goto L27;
        if (r13 >= r14) goto L27;
        r11.add(Long.valueOf(r13));
        r11.add(Long.valueOf(r14));
        return true;
    }
}
