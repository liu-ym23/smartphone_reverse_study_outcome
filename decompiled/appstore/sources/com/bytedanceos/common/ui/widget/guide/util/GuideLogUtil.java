package com.bytedanceos.common.ui.widget.guide.util;

import android.text.TextUtils;
import com.bytedance.librarian.LibrarianImpl;
import java.util.Locale;

/* JADX INFO: loaded from: classes2.dex */
public class GuideLogUtil {
    private static final int NONE = 8;
    public static final int level = 8;
    private static final String tagPrefix = "NewbieGuide";

    public GuideLogUtil() {
    }

    public static void d(String r10) {
    }

    public static void e(String r10) {
    }

    private static String generateTag() {
        StackTraceElement r10 = Thread.currentThread().getStackTrace()[4];
        String r11 = r10.getClassName();
        String r12 = String.format(Locale.CHINA, "%s.%s(L:%d)", new Object[]{r11.substring(r11.lastIndexOf(LibrarianImpl.Constants.DOT) + 1), r10.getMethodName(), Integer.valueOf(r10.getLineNumber())});
        if (TextUtils.isEmpty("NewbieGuide") == false) goto L6;
        return r12;
    L6:
        return "NewbieGuide:" + r12;
    }

    public static void i(String r10) {
    }

    public static void v(String r10) {
    }

    public static void w(String r10) {
    }

    public static void d(String r10, Throwable r11) {
    }

    public static void e(String r10, Throwable r11) {
    }

    public static void i(String r10, Throwable r11) {
    }

    public static void v(String r10, Throwable r11) {
    }

    public static void w(String r10, Throwable r11) {
    }
}
