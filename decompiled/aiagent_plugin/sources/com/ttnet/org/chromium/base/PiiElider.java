package com.ttnet.org.chromium.base;

import android.content.Context;
import android.text.TextUtils;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* JADX INFO: loaded from: classes4.dex */
public class PiiElider {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final Pattern f37647a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final Pattern f37648b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final Pattern f37649c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static final Pattern f37650d = null;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static final String[] f37651e = null;
    private static final String[] f = null;

    public PiiElider() {
    }

    static {
        f37647a = Pattern.compile("(\\b|^)(((((http|https|Http|Https|rtsp|Rtsp)://(([a-zA-Z0-9$_.+!*'(),;?&=-]|(%[a-fA-F0-9]{2})){1,64}(:([a-zA-Z0-9$_.+!*'(),;?&=-]|(%[a-fA-F0-9]{2})){1,25})?@)?)?(([a-zA-Z0-9 -\ud7ff豈-﷏ﷰ-\uffef]([a-zA-Z0-9 -\ud7ff豈-﷏ﷰ-\uffef-]{0,61}[a-zA-Z0-9 -\ud7ff豈-﷏ﷰ-\uffef]){0,1}\\.)+[a-zA-Z -\ud7ff豈-﷏ﷰ-\uffef]{2,63}|((25[0-5]|2[0-4][0-9]|[0-1][0-9]{2}|[1-9][0-9]|[1-9])\\.(25[0-5]|2[0-4][0-9]|[0-1][0-9]{2}|[1-9][0-9]|[1-9]|0)\\.(25[0-5]|2[0-4][0-9]|[0-1][0-9]{2}|[1-9][0-9]|[1-9]|0)\\.(25[0-5]|2[0-4][0-9]|[0-1][0-9]{2}|[1-9][0-9]|[0-9])))(:\\d{1,5})?)|([a-zA-Z][a-zA-Z0-9+.-]+://((([a-zA-Z0-9 -\ud7ff豈-﷏ﷰ-\uffef;/?:@&=#~.+!*'(),_-])|(%[a-fA-F0-9]{2}))+))))(/(([a-zA-Z0-9 -\ud7ff豈-﷏ﷰ-\uffef;/?:@&=#~.+!*'(),_-])|(%[a-fA-F0-9]{2}))*)?(\\b|$)");
        f37648b = Pattern.compile("\\sat\\sorg\\.chromium\\.[^ ]+.|Caused by: java.lang.(ClassNotFoundException|NoClassDefFoundError):");
        f37649c = Pattern.compile("([0-9a-fA-F]{2}[-:]+){5}[0-9a-fA-F]{2}");
        f37650d = Pattern.compile("\\[\\w*:CONSOLE.*\\].*");
        f37651e = new String[]{"com.ttnet.org.chromium.", "com.google.", "com.chrome."};
        f = new String[]{"android.", "com.android.", "dalvik.", "java.", "javax.", "org.apache.", "org.json.", "org.w3c.dom.", "org.xml.", "org.xmlpull."};
    }

    public static String a(String r5) {
    L18:
        return "";
    L3:
        if (f37648b.matcher(r5).find() == false) goto L5;
        return r5;
    L5:
        StringBuilder r0 = new StringBuilder(r5);     // Catch: IllegalArgumentException -> L18
        Matcher r6 = f37647a.matcher(r0);     // Catch: IllegalArgumentException -> L18
        int r1 = 0;
    L7:
        if (r6.find(r1) == false) goto L16;
        int r2 = r6.start();     // Catch: IllegalArgumentException -> L18
        int r3 = r6.end();     // Catch: IllegalArgumentException -> L18
        String r4 = r0.substring(r2, r3);     // Catch: IllegalArgumentException -> L18
        if (d(r4) == true) goto L15;
        if (e(r4) == true) goto L15;
        if (b(r4) == true) goto L15;
        r0.replace(r2, r3, "HTTP://WEBADDRESS.ELIDED");     // Catch: IllegalArgumentException -> L18
        r1 = r2 + 24;     // Catch: IllegalArgumentException -> L18
        r6 = f37647a.matcher(r0);     // Catch: IllegalArgumentException -> L18
    L15:
        r1 = r3;
        goto L7
    L16:
        return r0.toString();
    }

    private static boolean b(String r3) {
        if (c(r3) == false) goto L6;
        return true;
    L6:
        int r0 = r3.lastIndexOf(".");
        if (r0 != (-1)) goto L10;
        return false;
    L10:
        return c(r3.substring(0, r0));
    }

    private static boolean c(String r4) {
        Class.forName(r4, false, ((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(d.a(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin")).getClassLoader());     // Catch: Throwable -> L6
        return true;
    L6:
        return false;
    }

    private static boolean d(String r5) {
        String[] r0 = f37651e;
        int r1 = r0.length;
        int r3 = 0;
    L3:
        if (r3 >= r1) goto L9;
        if (r5.startsWith(r0[r3]) == true) goto L6;
        r3 = r3 + 1;
        goto L3
    L6:
        return true;
    L9:
        return false;
    }

    private static boolean e(String r5) {
        String[] r0 = f;
        int r1 = r0.length;
        int r3 = 0;
    L3:
        if (r3 >= r1) goto L9;
        if (r5.startsWith(r0[r3]) == true) goto L6;
        r3 = r3 + 1;
        goto L3
    L6:
        return true;
    L9:
        return false;
    }

    public static String sanitizeStacktrace(String r3) {
        String[] r4 = r3.split("\\n");
        r4[0] = a(r4[0]);
        int r0 = 1;
    L4:
        if (r0 >= r4.length) goto L10;
        if (r4[r0].startsWith("Caused by:") == false) goto L8;
        r4[r0] = a(r4[r0]);
    L8:
        r0 = r0 + 1;
        goto L4
    L10:
        return TextUtils.join("\n", r4);
    }
}
