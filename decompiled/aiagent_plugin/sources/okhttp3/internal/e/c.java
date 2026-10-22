package okhttp3.internal.e;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.h.b.o;
import d.x;
import java.text.DateFormat;
import java.text.ParsePosition;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

/* JADX INFO: compiled from: dates.kt */
/* JADX INFO: loaded from: classes4.dex */
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final a f39916a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final String[] f39917b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final DateFormat[] f39918c = null;

    /* JADX INFO: compiled from: dates.kt */
    public static final class a extends ThreadLocal<DateFormat> {
        a() {
        }

        @Override // java.lang.ThreadLocal
        public /* synthetic */ DateFormat initialValue() {
            return a();
        }

        public DateFormat a() {
            SimpleDateFormat r2 = new SimpleDateFormat("EEE, dd MMM yyyy HH:mm:ss 'GMT'", Locale.US);
            r2.setLenient(false);
            r2.setTimeZone(okhttp3.internal.c.f39837e);
            return (DateFormat) ZeusTransformUtils.preCheckCast(r2, DateFormat.class, "com.obric.aiagent.plugin");
        }
    }

    static {
        f39916a = new a();
        String[] r0 = {"EEE, dd MMM yyyy HH:mm:ss zzz", "EEEE, dd-MMM-yy HH:mm:ss zzz", "EEE MMM d HH:mm:ss yyyy", "EEE, dd-MMM-yyyy HH:mm:ss z", "EEE, dd-MMM-yyyy HH-mm-ss z", "EEE, dd MMM yy HH:mm:ss z", "EEE dd-MMM-yyyy HH:mm:ss z", "EEE dd MMM yyyy HH:mm:ss z", "EEE dd-MMM-yyyy HH-mm-ss z", "EEE dd-MMM-yy HH:mm:ss z", "EEE dd MMM yy HH:mm:ss z", "EEE,dd-MMM-yy HH:mm:ss z", "EEE,dd-MMM-yyyy HH:mm:ss z", "EEE, dd-MM-yyyy HH:mm:ss z", "EEE MMM d yyyy HH:mm:ss z"};
        f39917b = r0;
        f39918c = new DateFormat[r0.length];
    }

    public static final Date a(String r10) {
        o.e(r10, "<this>");
        if (((CharSequence) ZeusTransformUtils.preCheckCast(r10, CharSequence.class, "com.obric.aiagent.plugin")).length() != 0) goto L5;
        boolean r0 = true;
    L7:
        if (r0 == false) goto L9;
        return null;
    L9:
        ParsePosition r1 = new ParsePosition(0);
        Date r3 = ((DateFormat) ZeusTransformUtils.preCheckCast(f39916a.get(), DateFormat.class, "com.obric.aiagent.plugin")).parse(r10, r1);
        if (r1.getIndex() != r10.length()) goto L12;
        return r3;
    L12:
        String[] r4 = f39917b;
        monitor-enter(r4);
        int r5 = r4.length;     // Catch: Throwable -> L27
        int r6 = 0;
    L15:
        if (r6 >= r5) goto L24;
        DateFormat[] r7 = f39918c;     // Catch: Throwable -> L27
        DateFormat r8 = r7[r6];     // Catch: Throwable -> L27
        if (r8 != null) goto L19;
        SimpleDateFormat r9 = new SimpleDateFormat(f39917b[r6], Locale.US);     // Catch: Throwable -> L27
        r9.setTimeZone(okhttp3.internal.c.f39837e);     // Catch: Throwable -> L27
        r8 = (DateFormat) ZeusTransformUtils.preCheckCast(r9, DateFormat.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L27
        r7[r6] = r8;     // Catch: Throwable -> L27
    L19:
        r1.setIndex(0);     // Catch: Throwable -> L27
        Date r11 = r8.parse(r10, r1);     // Catch: Throwable -> L27
        if (r1.getIndex() != 0) goto L21;
        r6 = r6 + 1;
        goto L15
    L21:
        monitor-exit(r4);
        return r11;
    L24:
        x r12 = x.f38692a;     // Catch: Throwable -> L27
        monitor-exit(r4);
        return null;
    L27:
        th = move-exception;
        throw th;
    L5:
        r0 = false;
        goto L7
    }

    public static final String a(Date r3) {
        o.e(r3, "<this>");
        String r4 = ((DateFormat) ZeusTransformUtils.preCheckCast(f39916a.get(), DateFormat.class, "com.obric.aiagent.plugin")).format(r3);
        o.c(r4, "STANDARD_DATE_FORMAT.get().format(this)");
        return r4;
    }
}
