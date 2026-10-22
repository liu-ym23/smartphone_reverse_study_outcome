package com.obric.aiagent.product.a;

import android.os.Build;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.h.b.ad;
import d.h.b.o;
import d.o.i;
import d.o.k;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeFormatterBuilder;
import java.time.format.TextStyle;
import java.time.temporal.TemporalAccessor;
import java.util.Arrays;
import java.util.Date;
import java.util.Locale;
import java.util.TimeZone;

/* JADX INFO: compiled from: UtcToDateUtil.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final f f18787a = null;

    static {
        f18787a = new f();
    }

    private f() {
    }

    public final int a(long r4) {
    L8:
        return 0;
    L4:
        if (Build.VERSION.SDK_INT < 26) goto L6;
        Instant r3 = Instant.ofEpochMilli(r4);     // Catch: Exception -> L8
        String r5 = DateTimeFormatter.ofPattern("yyyyMMdd").withZone(ZoneId.of("Asia/Shanghai")).format((TemporalAccessor) ZeusTransformUtils.preCheckCast(r3, TemporalAccessor.class, "com.obric.aiagent.plugin"));     // Catch: Exception -> L8
        o.a(r5);     // Catch: Exception -> L8
        int r6 = Integer.parseInt(r5);     // Catch: Exception -> L8
    L10:
        return r6;
    L6:
        Date r7 = new Date(r4);     // Catch: Exception -> L8
        SimpleDateFormat r8 = new SimpleDateFormat("yyyyMMdd", Locale.ENGLISH);     // Catch: Exception -> L8
        r8.setTimeZone(TimeZone.getTimeZone("Asia/Shanghai"));     // Catch: Exception -> L8
        String r9 = r8.format(r7);     // Catch: Exception -> L8
        o.a(r9);     // Catch: Exception -> L8
        r6 = Integer.parseInt(r9);     // Catch: Exception -> L8
        goto L10
    }

    public final Integer a(String r4) {
        o.e(r4, "data");
        String r5 = d.o.o.a((CharSequence) ZeusTransformUtils.preCheckCast(r4, CharSequence.class, "com.obric.aiagent.plugin")).toString();
        if (d.o.o.d((CharSequence) ZeusTransformUtils.preCheckCast(r5, CharSequence.class, "com.obric.aiagent.plugin")) == false) goto L12;
        System.out.println("ro.build.date 属性为空");
        return null;
    L12:
        String r0 = ZonedDateTime.parse((CharSequence) ZeusTransformUtils.preCheckCast(r5, CharSequence.class, "com.obric.aiagent.plugin"), new DateTimeFormatterBuilder().parseCaseInsensitive().appendPattern("EEE MMM dd HH:mm:ss ").appendZoneText(TextStyle.SHORT).appendPattern(" yyyy").toFormatter(Locale.ENGLISH)).format(DateTimeFormatter.ofPattern("yyyyMMdd"));     // Catch: Exception -> L9
        o.a(r0);     // Catch: Exception -> L9
        return Integer.valueOf(Integer.parseInt(r0));
    L9:
        e = move-exception;
        System.out.println("解析 ro.build.date 失败：" + e.getMessage() + "，尝试降级解析");
        return b(r5);
    }

    private final Integer b(String r11) {
        i r12 = k.a(new k("(\\d{4})\\D*(\\d{2}|\\w{3})\\D*(\\d{2})"), (CharSequence) ZeusTransformUtils.preCheckCast(r11, CharSequence.class, "com.obric.aiagent.plugin"), 0, 2, null);
        if (r12 != null) goto L5;
        return null;
    L5:
        i.b r13 = r12.e();
        String r0 = (String) ZeusTransformUtils.preCheckCast(r13.a().d().get(1), String.class, "com.obric.aiagent.plugin");
        String r6 = (String) ZeusTransformUtils.preCheckCast(r13.a().d().get(2), String.class, "com.obric.aiagent.plugin");
        String r14 = (String) ZeusTransformUtils.preCheckCast(r13.a().d().get(3), String.class, "com.obric.aiagent.plugin");
        if (new k("\\d{2}").a((CharSequence) ZeusTransformUtils.preCheckCast(r6, CharSequence.class, "com.obric.aiagent.plugin")) == false) goto L8;
        Integer r10 = Integer.valueOf(Integer.parseInt(r6));
    L9:
        if (r10 == null) goto L12;
        int r15 = r10.intValue();
        ad r2 = ad.f38485a;
        String r16 = String.format("%04d%02d%02d", Arrays.copyOf(new Object[]{Integer.valueOf(Integer.parseInt(r0)), Integer.valueOf(r15), Integer.valueOf(Integer.parseInt(r14))}, 3));
        o.c(r16, "format(format, *args)");
        return Integer.valueOf(Integer.parseInt(r16));
    L12:
        return null;
    L8:
        r10 = c(r6);
        goto L9
    }

    private final Integer c(String r2) {
        Locale r1 = Locale.ENGLISH;
        o.c(r1, "ENGLISH");
        String r3 = r2.toUpperCase(r1);
        o.c(r3, "this as java.lang.String).toUpperCase(locale)");
        switch(r3.hashCode()) {
            case 65027: goto L50;
            case 65171: goto L46;
            case 67554: goto L42;
            case 69475: goto L38;
            case 73207: goto L34;
            case 73825: goto L30;
            case 73827: goto L26;
            case 76094: goto L22;
            case 76101: goto L18;
            case 77493: goto L14;
            case 78080: goto L10;
            case 81982: goto L6;
            default: goto L53;
        };
    L53:
        return null;
    L6:
        if (r3.equals("SEP") == false) goto L53;
        return 9;
    L10:
        if (r3.equals("OCT") == false) goto L53;
        return 10;
    L14:
        if (r3.equals("NOV") == false) goto L53;
        return 11;
    L18:
        if (r3.equals("MAY") == false) goto L53;
        return 5;
    L22:
        if (r3.equals("MAR") == false) goto L53;
        return 3;
    L26:
        if (r3.equals("JUN") == false) goto L53;
        return 6;
    L30:
        if (r3.equals("JUL") == false) goto L53;
        return 7;
    L34:
        if (r3.equals("JAN") == false) goto L53;
        return 1;
    L38:
        if (r3.equals("FEB") == false) goto L53;
        return 2;
    L42:
        if (r3.equals("DEC") == false) goto L53;
        return 12;
    L46:
        if (r3.equals("AUG") == false) goto L53;
        return 8;
    L50:
        if (r3.equals("APR") == false) goto L53;
        return 4;
    }
}
