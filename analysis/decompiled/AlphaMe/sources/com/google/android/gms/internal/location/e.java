package com.google.android.gms.internal.location;

import ch.qos.logback.core.pattern.color.ANSIConstants;
import ch.qos.logback.core.rolling.helper.DateTokenConverter;
import java.text.SimpleDateFormat;
import java.util.Locale;
import kotlin.jvm.internal.LongCompanionObject;

/* loaded from: classes.dex */
public abstract class e {

    /* renamed from: a, reason: collision with root package name */
    public static final StringBuilder f9962a;

    static {
        Locale locale = Locale.ROOT;
        new SimpleDateFormat("MM-dd HH:mm:ss.SSS", locale);
        new SimpleDateFormat("MM-dd HH:mm:ss", locale);
        f9962a = new StringBuilder(33);
    }

    public static void a(StringBuilder sb, long j4) {
        if (j4 == 0) {
            sb.append("0s");
            return;
        }
        sb.ensureCapacity(sb.length() + 27);
        boolean z4 = false;
        if (j4 < 0) {
            sb.append("-");
            if (j4 != Long.MIN_VALUE) {
                j4 = -j4;
            } else {
                j4 = LongCompanionObject.MAX_VALUE;
                z4 = true;
            }
        }
        if (j4 >= 86400000) {
            sb.append(j4 / 86400000);
            sb.append(DateTokenConverter.CONVERTER_KEY);
            j4 %= 86400000;
        }
        if (true == z4) {
            j4 = 25975808;
        }
        if (j4 >= 3600000) {
            sb.append(j4 / 3600000);
            sb.append("h");
            j4 %= 3600000;
        }
        if (j4 >= 60000) {
            sb.append(j4 / 60000);
            sb.append(ANSIConstants.ESC_END);
            j4 %= 60000;
        }
        if (j4 >= 1000) {
            sb.append(j4 / 1000);
            sb.append("s");
            j4 %= 1000;
        }
        if (j4 > 0) {
            sb.append(j4);
            sb.append("ms");
        }
    }
}
