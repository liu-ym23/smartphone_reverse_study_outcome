package com.bytedance.android.live.revenue.common;

import java.util.Arrays;
import java.util.Locale;
import kotlin.jvm.internal.StringCompanionObject;

/* JADX INFO: loaded from: classes47.dex */
public final class j0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f90840a = 0;

    static {
    }

    public static String a(long r100) {
        if (r100 < 10000000) goto L6;
        StringBuilder r101 = new StringBuilder();
        StringCompanionObject r102 = StringCompanionObject.INSTANCE;
        r101.append(String.format(Locale.US, "%.0f", Arrays.copyOf(new Object[]{Double.valueOf((r100 * 1.0d) / ((double) 10000))}, 1)));
        r101.append("万");
        return r101.toString();
    L6:
        return String.valueOf(r100);
    }
}
