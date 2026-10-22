package com.bytedance.android.livesdk.coupon.util;

import androidx.camera.video.AudioStats;
import java.util.Arrays;
import java.util.concurrent.TimeUnit;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.jvm.internal.StringCompanionObject;
import kotlin.text.Regex;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes8.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f121922a = null;

    public a() {
    }

    static {
        f121922a = new a();
    }

    public static String a(long r100) {
        double r101 = r100 / 100000.0d;
        if (Double.valueOf(r101 % ((double) 1)).equals(Double.valueOf(AudioStats.AUDIO_AMPLITUDE_NONE)) == true) goto L7;
        StringCompanionObject r102 = StringCompanionObject.INSTANCE;
        return String.format("%.1f", Arrays.copyOf(new Object[]{Double.valueOf(r101)}, 1));
    L7:
        return String.valueOf((int) r101);
    }

    public static String b(long r100) {
        Result.Companion r101 = Result.Companion;     // Catch: Throwable -> L4
        StringCompanionObject r102 = StringCompanionObject.INSTANCE;     // Catch: Throwable -> L4
        TimeUnit r103 = TimeUnit.MILLISECONDS;     // Catch: Throwable -> L4
        Object r104 = Result.m9449constructorimpl(String.format("%02d:%02d:%02d", Arrays.copyOf(new Object[]{Long.valueOf(r103.toHours(r100)), Long.valueOf(r103.toMinutes(r100) - TimeUnit.HOURS.toMinutes(r103.toHours(r100))), Long.valueOf(r103.toSeconds(r100) - TimeUnit.MINUTES.toSeconds(r103.toMinutes(r100)))}, 3)));     // Catch: Throwable -> L4
    L7:
        if (Result.m9452exceptionOrNullimpl(r104) == null) goto L11;
        r104 = "00:00:00";
    L11:
        return (String) r104;
    L4:
        th = move-exception;
        Result.Companion r110 = Result.Companion;
        r104 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L7
    }

    public static String c(long r110) {
        if (r110 > 0) goto L5;
        return "0";
    L5:
        long r100 = 100;
        long r101 = r110 % r100;
        long r111 = r110 / r100;
        if (r101 != 0) goto L10;
        return String.valueOf(r111);
    L10:
        if (r101 >= 10) goto L12;
        String r102 = "0" + r101;
    L14:
        if (r111 > 0) goto L17;
        String r112 = "0." + r102;
    L24:
        return new Regex("\\.0$").replace(new Regex("\\.00$").replace(r112, ""), "");
    L17:
        if (r111 >= 10) goto L20;
        r112 = r111 + '.' + r102;
        goto L24
    L20:
        if (r111 >= r100) goto L22;
        StringBuilder r103 = new StringBuilder();
        r103.append(r111);
        r103.append('.');
        r103.append(StringsKt.first(r102));
        r112 = r103.toString();
        goto L24
    L22:
        r112 = String.valueOf(r111);
        goto L24
    L12:
        r102 = String.valueOf(r101);
        goto L14
    }

    public static String d(long r100) {
        StringCompanionObject r101 = StringCompanionObject.INSTANCE;
        return String.format("%.2f", Arrays.copyOf(new Object[]{Double.valueOf(r100 / 100.0d)}, 1));
    }
}
