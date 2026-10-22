package com.google.android.material.datepicker;

import android.content.res.Resources;
import android.icu.text.DateFormat;
import com.bytedance.common.wschannel.WsChannelMultiProcessSharedProvider;
import com.obric.aiagent.plugin.R;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;
import java.util.TimeZone;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: compiled from: UtcDates.java */
/* JADX INFO: loaded from: classes2.dex */
class i {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    static AtomicReference<h> f13371a;

    static {
        f13371a = new AtomicReference();
    }

    static h a() {
        h r0 = (h) ZeusTransformUtils.preCheckCast(f13371a.get(), h.class, "com.obric.aiagent.plugin");
        if (r0 == null) goto L5;
        return r0;
    L5:
        return h.a();
    }

    private static TimeZone e() {
        return TimeZone.getTimeZone("UTC");
    }

    private static android.icu.util.TimeZone f() {
        return android.icu.util.TimeZone.getTimeZone("UTC");
    }

    static Calendar b() {
        Calendar r0 = a().b();
        r0.set(11, 0);
        r0.set(12, 0);
        r0.set(13, 0);
        r0.set(14, 0);
        r0.setTimeZone(e());
        return r0;
    }

    static Calendar c() {
        return a(null);
    }

    static Calendar a(Calendar r3) {
        Calendar r0 = Calendar.getInstance(e());
        if (r3 != null) goto L5;
        r0.clear();
    L6:
        return r0;
    L5:
        r0.setTimeInMillis(r3.getTimeInMillis());
        goto L6
    }

    static Calendar b(Calendar r4) {
        Calendar r5 = a(r4);
        Calendar r0 = c();
        r0.set(r5.get(1), r5.get(2), r5.get(5));
        return r0;
    }

    static long a(long r1) {
        Calendar r0 = c();
        r0.setTimeInMillis(r1);
        return b(r0).getTimeInMillis();
    }

    private static DateFormat a(String r0, Locale r1) {
        DateFormat r2 = DateFormat.getInstanceForSkeleton(r0, r1);
        r2.setTimeZone(f());
        return r2;
    }

    private static java.text.DateFormat a(int r0, Locale r1) {
        java.text.DateFormat r2 = java.text.DateFormat.getDateInstance(r0, r1);
        r2.setTimeZone(e());
        return r2;
    }

    static SimpleDateFormat d() {
        SimpleDateFormat r1 = new SimpleDateFormat(((SimpleDateFormat) ZeusTransformUtils.preCheckCast(java.text.DateFormat.getDateInstance(3, Locale.getDefault()), SimpleDateFormat.class, "com.obric.aiagent.plugin")).toPattern().replaceAll("\\s+", ""), Locale.getDefault());
        r1.setTimeZone(e());
        r1.setLenient(false);
        return r1;
    }

    static String a(Resources r5, SimpleDateFormat r6) {
        String r7 = r6.toPattern();
        String r0 = r5.getString(ZeusTransformUtils.mapRes(R.string.mtrl_picker_text_input_year_abbr, WsChannelMultiProcessSharedProvider.STRING_TYPE, "mtrl_picker_text_input_year_abbr"));
        String r2 = r5.getString(ZeusTransformUtils.mapRes(R.string.mtrl_picker_text_input_month_abbr, WsChannelMultiProcessSharedProvider.STRING_TYPE, "mtrl_picker_text_input_month_abbr"));
        String r8 = r5.getString(ZeusTransformUtils.mapRes(R.string.mtrl_picker_text_input_day_abbr, WsChannelMultiProcessSharedProvider.STRING_TYPE, "mtrl_picker_text_input_day_abbr"));
        if (r7.replaceAll("[^y]", "").length() != 1) goto L6;
        r7 = r7.replace("y", "yyyy");
    L6:
        return r7.replace("d", r8).replace("M", r2).replace("y", r0);
    }

    static DateFormat a(Locale r1) {
        return a("yMMMd", r1);
    }

    static DateFormat b(Locale r1) {
        return a("MMMd", r1);
    }

    static DateFormat c(Locale r1) {
        return a("MMMEd", r1);
    }

    static DateFormat d(Locale r1) {
        return a("yMMMEd", r1);
    }

    static java.text.DateFormat e(Locale r1) {
        return a(2, r1);
    }

    static java.text.DateFormat f(Locale r2) {
        SimpleDateFormat r3 = (SimpleDateFormat) ZeusTransformUtils.preCheckCast(e(r2), SimpleDateFormat.class, "com.obric.aiagent.plugin");
        r3.applyPattern(a(r3.toPattern()));
        return r3;
    }

    static java.text.DateFormat g(Locale r1) {
        return a(0, r1);
    }

    private static String a(String r5) {
        int r0 = a(r5, "yY", 1, 0);
        if (r0 < r5.length()) goto L5;
        return r5;
    L5:
        String r2 = "EMd";
        int r3 = a(r5, "EMd", 1, r0);
        if (r3 >= r5.length()) goto L9;
        r2 = "EMd,";
    L9:
        return r5.replace(r5.substring(a(r5, r2, -1, r0) + 1, r3), " ").trim();
    }

    private static int a(String r2, String r3, int r4, int r5) {
    L2:
        if (r5 < 0) goto L17;
        if (r5 >= r2.length()) goto L17;
        if (r3.indexOf(r2.charAt(r5)) != (-1)) goto L17;
        if (r2.charAt(r5) != '\'') goto L16;
    L9:
        r5 = r5 + r4;
        if (r5 < 0) goto L16;
        if (r5 >= r2.length()) goto L16;
        if (r2.charAt(r5) != '\'') goto L9;
    L16:
        r5 = r5 + r4;
    L17:
        return r5;
    }
}
