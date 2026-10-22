package com.bytedance.android.livesdk.utils;

import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.util.Locale;

/* JADX INFO: loaded from: classes11.dex */
public final class r1 {
    public static String a(Double r100) {
        DecimalFormat r101 = new DecimalFormat("#.#");
        r101.setRoundingMode(RoundingMode.DOWN);
        return r101.format(r100);
    }

    public static String b(String r100, Object... r101) {
        return String.format(Locale.US, r100, r101);
    }
}
