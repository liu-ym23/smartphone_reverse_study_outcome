package com.android.contacts.common.util;

import java.text.SimpleDateFormat;
import java.util.Locale;

/* JADX INFO: loaded from: classes.dex */
public class CommonDateUtils {
    public static final SimpleDateFormat DATE_AND_TIME_FORMAT = null;
    public static final int DEFAULT_HOUR = 8;
    public static final SimpleDateFormat FULL_DATE_FORMAT = null;
    public static final SimpleDateFormat NO_YEAR_DATE_AND_TIME_FORMAT = null;
    public static final SimpleDateFormat NO_YEAR_DATE_FORMAT = null;

    public CommonDateUtils() {
    }

    static {
        NO_YEAR_DATE_FORMAT = new SimpleDateFormat("--MM-dd", Locale.US);
        FULL_DATE_FORMAT = new SimpleDateFormat("yyyy-MM-dd", Locale.US);
        DATE_AND_TIME_FORMAT = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'", Locale.US);
        NO_YEAR_DATE_AND_TIME_FORMAT = new SimpleDateFormat("--MM-dd'T'HH:mm:ss.SSS'Z'", Locale.US);
    }
}
