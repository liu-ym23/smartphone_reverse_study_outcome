package com.bytedance.frameworks.baselib.network.http.i;

import android.os.Build;
import android.text.TextUtils;
import android.util.Pair;
import com.bytedance.common.utility.Logger;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.TimeZone;

/* JADX INFO: compiled from: NetworklibUtils.java */
/* JADX INFO: loaded from: classes.dex */
public class g {
    private static final String TAG = "g";

    static {
    }

    public g() {
    }

    public static boolean a(String r5, String r6, String r7, List<Pair<String, String>> r8) {
        List r9 = (List) ZeusTransformUtils.wrapperContextForParams(r8, List.class, "com.obric.aiagent.plugin");
        if (TextUtils.isEmpty(r5) == false) goto L5;
        return false;
    L5:
        if (TextUtils.isEmpty(r6) == false) goto L7;
        return false;
    L7:
        if (TextUtils.isEmpty(r7) == true) goto L44;
        if (r9 == null) goto L46;
        String[] r10 = r5.split(r6);
        if (r10 != null) goto L13;
        return false;
    L13:
        int r11 = 0;
    L15:
        if (r11 >= r10.length) goto L32;
        if (TextUtils.isEmpty(r10[r11]) == true) goto L30;
        String[] r0 = r10[r11].trim().split(r7);
        if (r0 == null) goto L30;
        if (r0.length != 2) goto L30;
        if (TextUtils.isEmpty(r0[0]) == true) goto L30;
        if (TextUtils.isEmpty(r0[1]) == true) goto L30;
        r9.add(new Pair(r0[0].trim(), r0[1].trim()));
    L30:
        r11 = r11 + 1;
        goto L15
    L32:
        if (r9.size() != 0) goto L34;
        return false;
    L34:
        return true;
    L46:
        return false;
    L44:
        return false;
    }

    public static boolean a(String r8, List<Long> r9) {
        List r10 = (List) ZeusTransformUtils.wrapperContextForParams(r9, List.class, "com.obric.aiagent.plugin");
        if (TextUtils.isEmpty(r8) == false) goto L6;
        return false;
    L6:
        if (r8.contains("~") == true) goto L8;
        return false;
    L8:
        String[] r11 = r8.split("~");
        if (r11.length == 2) goto L12;
        return false;
    L12:
        if (TextUtils.isEmpty(r11[0]) == false) goto L14;
    L27:
        return false;
    L14:
        if (TextUtils.isEmpty(r11[1]) == true) goto L27;
        if (r10 != null) goto L18;
        r10 = new ArrayList();
    L18:
        long r2 = a(r11[0]);
        long r4 = a(r11[1]);
        if (r2 <= 0) goto L27;
        if (r4 <= 0) goto L27;
        if (r2 >= r4) goto L27;
        r10.add(Long.valueOf(r2));
        r10.add(Long.valueOf(r4));
        return true;
    }

    public static long a(String r3) {
        if (Logger.debug() == false) goto L5;
        Logger.d(TAG, "utcTime " + r3);
    L5:
        SimpleDateFormat r0 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        r0.setTimeZone(TimeZone.getTimeZone("UTC"));
        Date r4 = r0.parse(r3);     // Catch: ParseException -> L10
        if (r4 == null) goto L15;
        return r4.getTime();
    L15:
        return 0;
    L10:
        e = move-exception;
        e.printStackTrace();
        return 0;
    }

    public static boolean b(String r7, List<Date> r8) {
        List r9 = (List) ZeusTransformUtils.wrapperContextForParams(r8, List.class, "com.obric.aiagent.plugin");
        if (TextUtils.isEmpty(r7) == false) goto L6;
        return false;
    L6:
        if (r7.contains("~") == true) goto L8;
        return false;
    L8:
        String[] r10 = r7.split("~");
        if (r10.length == 2) goto L12;
        return false;
    L12:
        if (TextUtils.isEmpty(r10[0]) == false) goto L14;
    L25:
        return false;
    L14:
        if (TextUtils.isEmpty(r10[1]) == true) goto L25;
        Date r2 = b(r10[0]);
        Date r3 = b(r10[1]);
        if (r2 == null) goto L25;
        if (r3 == null) goto L25;
        if (Logger.debug() == false) goto L23;
        String r4 = TAG;
        Logger.d(r4, "parse dateTime " + r10[0] + " to " + r2);
        Logger.d(r4, "parse dateTime " + r10[1] + " to " + r3);
    L23:
        r9.add(r2);
        r9.add(r3);
        return true;
    }

    public static Date b(String r3) {
    L15:
        return null;
    L4:
        if (Build.VERSION.SDK_INT < 24) goto L10;
        if (Logger.debug() == false) goto L8;
        Logger.d(TAG, "parse dateTime " + r3 + " sdk version >= N");     // Catch: Throwable -> L15
    L8:
        SimpleDateFormat r0 = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ssXXX", Locale.getDefault());     // Catch: Throwable -> L15
    L13:
        return r0.parse(r3);
    L10:
        if (Logger.debug() == false) goto L12;
        Logger.d(TAG, "parse dateTime " + r3 + " sdk version < N");     // Catch: Throwable -> L15
    L12:
        r0 = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ssZZZZZ", Locale.getDefault());     // Catch: Throwable -> L15
        goto L13
    }
}
