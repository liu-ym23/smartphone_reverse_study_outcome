package com.ttnet.org.chromium.base;

import android.text.TextUtils;
import com.ttnet.org.chromium.base.annotations.UsedByReflection;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* JADX INFO: loaded from: classes4.dex */
public class PiiElider {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Pattern f18280a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final Pattern f18281b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final Pattern f18282c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final Pattern f18283d = null;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final Pattern f18284e = null;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final Pattern f18285f = null;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final String[] f18286g = null;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final String[] f18287h = null;

    static {
        Pattern r10 = Pattern.compile("((25[0-5]|2[0-4][0-9]|[0-1][0-9]{2}|[1-9][0-9]|[1-9])\\.(25[0-5]|2[0-4][0-9]|[0-1][0-9]{2}|[1-9][0-9]|[1-9]|0)\\.(25[0-5]|2[0-4][0-9]|[0-1][0-9]{2}|[1-9][0-9]|[1-9]|0)\\.(25[0-5]|2[0-4][0-9]|[0-1][0-9]{2}|[1-9][0-9]|[0-9]))");
        f18280a = r10;
        Pattern r11 = Pattern.compile("(([a-zA-Z0-9 -\ud7ff豈-﷏ﷰ-\uffef]([a-zA-Z0-9 -\ud7ff豈-﷏ﷰ-\uffef\\-]{0,61}[a-zA-Z0-9 -\ud7ff豈-﷏ﷰ-\uffef]){0,1}\\.)+[a-zA-Z -\ud7ff豈-﷏ﷰ-\uffef]{2,63}|" + r10 + ")");
        f18281b = r11;
        f18282c = Pattern.compile("\\sat\\sorg\\.chromium\\.[^ ]+.");
        f18283d = Pattern.compile("(?:\\b|^)((?:(http|https|Http|Https|rtsp|Rtsp):\\/\\/(?:(?:[a-zA-Z0-9\\$\\-\\_\\.\\+\\!\\*\\'\\(\\)\\,\\;\\?\\&\\=]|(?:\\%[a-fA-F0-9]{2})){1,64}(?:\\:(?:[a-zA-Z0-9\\$\\-\\_\\.\\+\\!\\*\\'\\(\\)\\,\\;\\?\\&\\=]|(?:\\%[a-fA-F0-9]{2})){1,25})?\\@)?)?(?:" + r11 + ")(?:\\:\\d{1,5})?)(\\/(?:(?:[a-zA-Z0-9 -\ud7ff豈-﷏ﷰ-\uffef\\;\\/\\?\\:\\@\\&\\=\\#\\~\\-\\.\\+\\!\\*\\'\\(\\)\\,\\_])|(?:\\%[a-fA-F0-9]{2}))*)?(?:\\b|$)");
        f18284e = Pattern.compile("([0-9a-fA-F]{2}[-:]+){5}[0-9a-fA-F]{2}");
        f18285f = Pattern.compile("\\[\\w*:CONSOLE.*\\].*");
        f18286g = new String[]{"com.ttnet.org.chromium.", "com.google."};
        f18287h = new String[]{"android.accessibilityservice", "android.accounts", "android.animation", "android.annotation", "android.app", "android.appwidget", "android.bluetooth", "android.content", "android.database", "android.databinding", "android.drm", "android.gesture", "android.graphics", "android.hardware", "android.inputmethodservice", "android.location", "android.media", "android.mtp", "android.net", "android.nfc", "android.opengl", "android.os", "android.preference", "android.print", "android.printservice", "android.provider", "android.renderscript", "android.sax", "android.security", "android.service", "android.speech", "android.support", "android.system", "android.telecom", "android.telephony", "android.test", "android.text", "android.transition", "android.util", "android.view", "android.webkit", "android.widget", "com.android.", "dalvik.", "java.", "javax.", "org.apache.", "org.json.", "org.w3c.dom.", "org.xml.", "org.xmlpull."};
    }

    public static String a(String r10) {
        if (f18282c.matcher(r10).find() == false) goto L5;
        return r10;
    L5:
        StringBuilder r11 = new StringBuilder(r10);
        Matcher r12 = f18283d.matcher(r11);
        int r13 = 0;
    L7:
        if (r12.find(r13) == false) goto L15;
        int r14 = r12.start();
        int r15 = r12.end();
        String r16 = r11.substring(r14, r15);
        if (b(r16) == true) goto L13;
        if (c(r16) == true) goto L13;
        r11.replace(r14, r15, "HTTP://WEBADDRESS.ELIDED");
        r13 = r14 + 24;
        r12 = f18283d.matcher(r11);
    L13:
        r13 = r15;
        goto L7
    L15:
        return r11.toString();
    }

    public static boolean b(String r10) {
        String[] r11 = f18286g;
        int r12 = r11.length;
        int r13 = 0;
    L3:
        if (r13 >= r12) goto L9;
        if (r10.startsWith(r11[r13]) == true) goto L6;
        r13 = r13 + 1;
        goto L3
    L6:
        return true;
    L9:
        return false;
    }

    public static boolean c(String r10) {
        String[] r11 = f18287h;
        int r12 = r11.length;
        int r13 = 0;
    L3:
        if (r13 >= r12) goto L9;
        if (r10.startsWith(r11[r13]) == true) goto L6;
        r13 = r13 + 1;
        goto L3
    L6:
        return true;
    L9:
        return false;
    }

    @UsedByReflection("jni_android.cc")
    public static String sanitizeStacktrace(String r10) {
        String[] r11 = r10.split("\\n");
        r11[0] = a(r11[0]);
        int r12 = 1;
    L4:
        if (r12 >= r11.length) goto L10;
        if (r11[r12].startsWith("Caused by:") == false) goto L8;
        r11[r12] = a(r11[r12]);
    L8:
        r12 = r12 + 1;
        goto L4
    L10:
        return TextUtils.join("\n", r11);
    }
}
