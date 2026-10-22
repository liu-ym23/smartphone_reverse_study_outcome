package com.tmall.wireless.tangram.util;

import androidx.annotation.NonNull;
import com.bytedanceos.common.toolbox.i;
import com.tmall.wireless.tangram.TangramBuilder;

/* JADX INFO: loaded from: classes4.dex */
public class LogUtils {
    private static final String GLOBAL_TAG = "Tangram";
    private static LogDelegate sDefaultLogDelegate;

    public static class DefaultLogDelegate implements LogDelegate {
        public DefaultLogDelegate() {
        }

        @Override // com.tmall.wireless.tangram.util.LogUtils.LogDelegate
        public void d(String r10, String r11) {
            i.a(r10, r11);
        }

        @Override // com.tmall.wireless.tangram.util.LogUtils.LogDelegate
        public void e(String r10, String r11) {
            i.b(r10, r11);
        }

        @Override // com.tmall.wireless.tangram.util.LogUtils.LogDelegate
        public void i(String r10, String r11) {
            i.e(r10, r11);
        }

        @Override // com.tmall.wireless.tangram.util.LogUtils.LogDelegate
        public void v(String r10, String r11) {
            i.j(r10, r11);
        }

        @Override // com.tmall.wireless.tangram.util.LogUtils.LogDelegate
        public void w(String r10, String r11) {
            i.k(r10, r11);
        }

        @Override // com.tmall.wireless.tangram.util.LogUtils.LogDelegate
        public void e(String r10, String r11, Throwable r12) {
            i.c(r10, r11, r12);
        }

        @Override // com.tmall.wireless.tangram.util.LogUtils.LogDelegate
        public void w(String r10, String r11, Throwable r12) {
            i.l(r10, r11, r12);
        }
    }

    public interface LogDelegate {
        void d(String r10, String r11);

        void e(String r10, String r11);

        void e(String r10, String r11, Throwable r12);

        void i(String r10, String r11);

        void v(String r10, String r11);

        void w(String r10, String r11);

        void w(String r10, String r11, Throwable r12);
    }

    static {
        sDefaultLogDelegate = new DefaultLogDelegate();
    }

    public LogUtils() {
    }

    public static void d(String r10, String r11) {
        if (TangramBuilder.isPrintLog() == false) goto L6;
        sDefaultLogDelegate.d(globalTag(r10), r11);
        return;
    }

    public static void e(String r10, String r11) {
        sDefaultLogDelegate.e(globalTag(r10), r11);
    }

    private static String globalTag(String r10) {
        return "Tangram[" + r10 + "]";
    }

    public static void i(String r10, String r11) {
        if (TangramBuilder.isPrintLog() == false) goto L6;
        sDefaultLogDelegate.i(globalTag(r10), r11);
        return;
    }

    public static void setLogDelegate(@NonNull LogDelegate r10) {
        if (r10 == null) goto L6;
        sDefaultLogDelegate = r10;
        return;
    L6:
        throw new RuntimeException("LogDelegate should not be null");
    }

    public static void v(String r10, String r11) {
        if (TangramBuilder.isPrintLog() == false) goto L6;
        sDefaultLogDelegate.v(globalTag(r10), r11);
        return;
    }

    public static void w(String r10, String r11) {
        if (TangramBuilder.isPrintLog() == false) goto L6;
        sDefaultLogDelegate.w(globalTag(r10), r11);
        return;
    }

    public static void e(String r10, String r11, Throwable r12) {
        sDefaultLogDelegate.e(globalTag(r10), r11, r12);
    }

    public static void w(String r10, String r11, Throwable r12) {
        if (TangramBuilder.isPrintLog() == false) goto L6;
        sDefaultLogDelegate.w(globalTag(r10), r11, r12);
        return;
    }
}
