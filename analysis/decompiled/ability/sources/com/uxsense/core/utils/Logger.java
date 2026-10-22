package com.uxsense.core.utils;

import kotlin.Metadata;

@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0003\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\bf\u0018\u00002\u00020\u0001J+\u0010\b\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u00022\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0005H&¢\u0006\u0004\b\b\u0010\tJ+\u0010\n\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u00022\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0005H&¢\u0006\u0004\b\n\u0010\tJ+\u0010\u000b\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u00022\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0005H&¢\u0006\u0004\b\u000b\u0010\tJ+\u0010\f\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u00022\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0005H&¢\u0006\u0004\b\f\u0010\tJ+\u0010\r\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u00022\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0005H&¢\u0006\u0004\b\r\u0010\t¨\u0006\u000e"}, d2 = {"Lcom/uxsense/core/utils/Logger;", "", "", "tag", "message", "", "tr", "LC7/r;", "v", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V", "d", "i", "w", "e", "uxsense_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes3.dex */
public interface Logger {

    @Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
    public static final class DefaultImpls {
        public static /* synthetic */ void d$default(Logger logger, String str, String str2, Throwable th, int i, Object obj) {
            if (obj != null) {
                throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: d");
            }
            if ((i & 4) != 0) {
                th = null;
            }
            logger.d(str, str2, th);
        }

        public static /* synthetic */ void e$default(Logger logger, String str, String str2, Throwable th, int i, Object obj) {
            if (obj != null) {
                throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: e");
            }
            if ((i & 4) != 0) {
                th = null;
            }
            logger.e(str, str2, th);
        }

        public static /* synthetic */ void i$default(Logger logger, String str, String str2, Throwable th, int i, Object obj) {
            if (obj != null) {
                throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: i");
            }
            if ((i & 4) != 0) {
                th = null;
            }
            logger.i(str, str2, th);
        }

        public static /* synthetic */ void v$default(Logger logger, String str, String str2, Throwable th, int i, Object obj) {
            if (obj != null) {
                throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: v");
            }
            if ((i & 4) != 0) {
                th = null;
            }
            logger.v(str, str2, th);
        }

        public static /* synthetic */ void w$default(Logger logger, String str, String str2, Throwable th, int i, Object obj) {
            if (obj != null) {
                throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: w");
            }
            if ((i & 4) != 0) {
                th = null;
            }
            logger.w(str, str2, th);
        }
    }

    void d(String tag, String message, Throwable tr);

    void e(String tag, String message, Throwable tr);

    void i(String tag, String message, Throwable tr);

    void v(String tag, String message, Throwable tr);

    void w(String tag, String message, Throwable tr);
}
