package rd;

import com.blankj.utilcode.constant.CacheConstants;
import com.obric.oui.time.ClockFormat;
import com.obric.oui.time.TimeStyle;
import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneId;
import java.time.ZoneOffset;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;
import java.util.Date;
import java.util.Locale;
import kotlin.jvm.internal.q;
import kotlin.jvm.internal.x;
import kotlin.text.StringsKt__StringsKt;
import kotlin.text.o;
import org.apache.http.message.TokenParser;

/* JADX INFO: loaded from: classes4.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final b f23874a = null;

    public /* synthetic */ class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f23875a = null;

        static {
            int[] r10 = new int[TimeStyle.values().length];
            r10[TimeStyle.FULL.ordinal()] = 1;
            r10[TimeStyle.FULL_Y.ordinal()] = 2;
            r10[TimeStyle.FULL_YM.ordinal()] = 3;
            r10[TimeStyle.FULL_YMD.ordinal()] = 4;
            r10[TimeStyle.FULL_MD.ordinal()] = 5;
            r10[TimeStyle.FULL_YMDHM.ordinal()] = 6;
            r10[TimeStyle.FULL_YMDEHM.ordinal()] = 7;
            r10[TimeStyle.BRIEF_HM.ordinal()] = 8;
            r10[TimeStyle.BRIEF_MD.ordinal()] = 9;
            r10[TimeStyle.BRIEF_YMDHM.ordinal()] = 10;
            r10[TimeStyle.RELATIVE_DETAILED.ordinal()] = 11;
            r10[TimeStyle.RELATIVE_FUZZY.ordinal()] = 12;
            r10[TimeStyle.RELATIVE_MIXED.ordinal()] = 13;
            r10[TimeStyle.RELATIVE_MIXED_BRIEF.ordinal()] = 14;
            f23875a = r10;
        }
    }

    static {
        f23874a = new b();
    }

    public b() {
    }

    public static final String a(TimeStyle r10, Date r11, ClockFormat r12, boolean r13) {
        q.g(r10, "style");
        q.g(r11, "date");
        q.g(r12, "clockFormat");
        Locale r14 = Locale.getDefault();
        q.f(r14, "getDefault()");
        ZoneId r15 = ZoneId.systemDefault();
        q.f(r15, "systemDefault()");
        return b(r10, r11, r14, r12, r15, r13);
    }

    public static final String b(TimeStyle r10, Date r11, Locale r12, ClockFormat r13, ZoneId r14, boolean r15) {
        q.g(r10, "style");
        q.g(r11, "date");
        q.g(r12, "locale");
        q.g(r13, "clockFormat");
        q.g(r14, "zoneId");
        switch(a.f23875a[r10.ordinal()]) {
            case 1: goto L15;
            case 2: goto L14;
            case 3: goto L13;
            case 4: goto L12;
            case 5: goto L11;
            case 6: goto L10;
            case 7: goto L9;
            case 8: goto L8;
            case 9: goto L7;
            case 10: goto L6;
            default: goto L5;
        };
    L6:
        String r16 = d.f23887l.a(c.f23876a.a(r12).c(), r13);
        return d(f23874a, r11, r12, r16, r14, r15, false, 32, null);
    L7:
        String r17 = d.f23887l.a(c.f23876a.a(r12).b(), r13);
        return d(f23874a, r11, r12, r17, r14, r15, false, 32, null);
    L8:
        String r18 = d.f23887l.a(c.f23876a.a(r12).a(), r13);
        return d(f23874a, r11, r12, r18, r14, r15, false, 32, null);
    L9:
        String r19 = d.f23887l.a(c.f23876a.a(r12).i(), r13);
        return f(f23874a, r11, r12, r19, r14, r15, false, 32, null);
    L10:
        String r20 = d.f23887l.a(c.f23876a.a(r12).j(), r13);
        return f(f23874a, r11, r12, r20, r14, r15, false, 32, null);
    L11:
        String r21 = d.f23887l.a(c.f23876a.a(r12).e(), r13);
        return f23874a.e(r11, r12, r21, r14, false, false);
    L12:
        String r22 = d.f23887l.a(c.f23876a.a(r12).h(), r13);
        return f23874a.e(r11, r12, r22, r14, false, false);
    L13:
        String r23 = d.f23887l.a(c.f23876a.a(r12).g(), r13);
        return f23874a.e(r11, r12, r23, r14, false, false);
    L14:
        String r24 = d.f23887l.a(c.f23876a.a(r12).f(), r13);
        return f23874a.e(r11, r12, r24, r14, false, false);
    L15:
        String r25 = d.f23887l.a(c.f23876a.a(r12).d(), r13);
        return f(f23874a, r11, r12, r25, r14, r15, false, 32, null);
    L5:
        throw new IllegalArgumentException("Invalid time style");
    }

    public static /* synthetic */ String d(b r10, Date r11, Locale r12, String r13, ZoneId r14, boolean r15, boolean r16, int r17, Object r18) {
        if ((r17 & 32) == 0) goto L6;
        r16 = true;
    L6:
        return r10.c(r11, r12, r13, r14, r15, r16);
    }

    public static /* synthetic */ String f(b r10, Date r11, Locale r12, String r13, ZoneId r14, boolean r15, boolean r16, int r17, Object r18) {
        if ((r17 & 32) == 0) goto L6;
        r16 = true;
    L6:
        return r10.e(r11, r12, r13, r14, r15, r16);
    }

    public final String c(Date r10, Locale r11, String r12, ZoneId r13, boolean r14, boolean r15) {
        Instant r16 = r10.toInstant();
        ZonedDateTime r17 = r16.atZone(r13);
        String r18 = r17.format(DateTimeFormatter.ofPattern(r12, r11));
        q.f(r18, "originTimeString");
        String r19 = h(r11, r18);
        String r20 = "";
        if (r14 == true) goto L5;
        String r21 = "";
    L6:
        if (r15 == false) goto L12;
        if (r13.getRules().isDaylightSavings(r16) == false) goto L12;
        r20 = " DST";
    L12:
        return r19 + r21 + r20;
    L5:
        q.f(r17, "zonedDateTime");
        r21 = g(r17);
        goto L6
    }

    public final String e(Date r10, Locale r11, String r12, ZoneId r13, boolean r14, boolean r15) {
        Instant r16 = r10.toInstant();
        ZonedDateTime r17 = r16.atZone(r13);
        StringsKt__StringsKt.b0(String.valueOf(r17.getNano() / 1000000), 3, '0');
        String r18 = r17.format(DateTimeFormatter.ofPattern(r12, r11));
        if (q.b(r11, Locale.UK) == false) goto L5;
        LocalDate r19 = r17.toLocalDate();
        q.f(r19, "zonedDateTime.toLocalDate()");
        q.f(r18, "originTimeString");
        r18 = j(r19, r18);
    L5:
        String r20 = "";
        if (r14 == true) goto L8;
        String r21 = "";
    L9:
        if (r15 == false) goto L15;
        if (r13.getRules().isDaylightSavings(r16) == false) goto L15;
        r20 = " DST";
    L15:
        return r18 + r21 + r20;
    L8:
        String r22 = r17.getOffset().getId();
        q.f(r22, "zonedDateTime.offset.id");
        r21 = " (UTC" + o.x(r22, "Z", "+00:00", false, 4, null) + ')';
        goto L9
    }

    public final String g(ZonedDateTime r10) {
        ZoneOffset r11 = r10.getOffset();
        int r12 = r11.getTotalSeconds();
        if ((r12 % CacheConstants.HOUR) != 0) goto L5;
        int r13 = r12 / CacheConstants.HOUR;
        x r14 = x.f21192a;
        String r15 = String.format("%+d", Arrays.copyOf(new Object[]{Integer.valueOf(r13)}, 1));
        q.f(r15, "format(format, *args)");
    L7:
        return " (UTC" + r15 + ')';
    L5:
        r15 = r11.getId();
        goto L7
    }

    public final String h(Locale r13, String r14) {
        if (q.b(r13, Locale.US) == true) goto L5;
        return r14;
    L5:
        return o.z(o.z(r14, "AM", "am", false, 4, null), "PM", "pm", false, 4, null);
    }

    public final String i(int r10) {
        if (11 <= r10) goto L5;
    L7:
        int r11 = r10 % 10;
        if (r11 != 1) goto L11;
        return "st";
    L11:
        if (r11 != 2) goto L14;
        return "nd";
    L14:
        if (r11 != 3) goto L19;
        return "rd";
    L19:
        return "th";
    L5:
        if (r10 >= 14) goto L7;
        return "th";
    }

    public final String j(LocalDate r13, String r14) {
        int r10 = r13.getDayOfMonth();
        String r11 = r13.getMonth().name().toLowerCase();
        q.f(r11, "this as java.lang.String).toLowerCase()");
        String r12 = o.k(r11);
        String r15 = i(r10);
        return o.z(o.z(o.z(r14, r10 + TokenParser.SP + r12, r10 + r15 + TokenParser.SP + r12, false, 4, null), "am", "AM", false, 4, null), "pm", "PM", false, 4, null);
    }
}
