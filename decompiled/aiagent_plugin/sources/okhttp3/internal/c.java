package okhttp3.internal;

import android.support.v4.media.session.PlaybackStateCompat;
import com.bytedance.apm.battery.dao.DBHelper;
import com.ss.android.socialbase.downloader.setting.DownloadSettingKeys;
import com.ss.android.socialbase.downloader.utils.DownloadUtils;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.a.al;
import d.a.ao;
import d.a.i;
import d.a.p;
import d.h.b.ad;
import d.h.b.o;
import d.l.n;
import d.o.d;
import d.o.k;
import d.x;
import e.aa;
import e.f;
import e.g;
import e.h;
import e.r;
import e.y;
import java.io.Closeable;
import java.io.File;
import java.io.IOException;
import java.io.InterruptedIOException;
import java.lang.reflect.Field;
import java.net.Socket;
import java.net.SocketTimeoutException;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.TimeZone;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.TimeUnit;
import okhttp3.ac;
import okhttp3.ae;
import okhttp3.e;
import okhttp3.u;
import okhttp3.v;
import okhttp3.z;

/* JADX INFO: compiled from: Util.kt */
/* JADX INFO: loaded from: classes4.dex */
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final byte[] f39833a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final u f39834b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final ae f39835c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final ac f39836d = null;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final TimeZone f39837e = null;
    public static final boolean f = false;
    public static final String g = null;
    private static final r h = null;
    private static final k i = null;

    public static final int a(byte r0, int r1) {
        return r0 & r1;
    }

    public static final int a(char r4) {
        boolean r1 = true;
        if ('0' <= r4) goto L5;
    L7:
        boolean r3 = false;
    L8:
        if (r3 == true) goto L28;
        char r0 = 'a';
        if ('a' <= r4) goto L13;
    L15:
        boolean r5 = false;
    L16:
        if (r5 == true) goto L29;
        r0 = 'A';
        if ('A' <= r4) goto L21;
    L23:
        r1 = false;
    L24:
        if (r1 == true) goto L29;
        return -1;
    L21:
        if (r4 >= 'G') goto L23;
    L29:
        return (r4 - r0) + 10;
    L13:
        if (r4 >= 'g') goto L15;
        r5 = true;
        goto L16
    L28:
        return r4 - '0';
    L5:
        if (r4 >= ':') goto L7;
        r3 = true;
        goto L8
    }

    public static final int a(short r0, int r1) {
        return r0 & r1;
    }

    public static final long a(int r2, long r3) {
        return ((long) r2) & r3;
    }

    private static final okhttp3.r a(okhttp3.r r2, e r3) {
        e r4 = (e) ZeusTransformUtils.wrapperContextForParams(r3, e.class, "com.obric.aiagent.plugin");
        o.e(r2, "$this_asFactory");
        o.e(r4, "it");
        return r2;
    }

    public static /* synthetic */ Thread lambda$YkPHNqGK348g8mzA3x8qIGED6HU(String r0, boolean r1, Runnable r2) {
        return a(r0, r1, r2);
    }

    /* JADX INFO: renamed from: lambda$Z0PfrgtZgpcHRLW-ppvU1OturPI, reason: not valid java name */
    public static /* synthetic */ okhttp3.r m1252lambda$Z0PfrgtZgpcHRLWppvU1OturPI(okhttp3.r r0, e r1) {
        return a(r0, r1);
    }

    static {
        byte[] r2 = new byte[0];
        f39833a = r2;
        f39834b = u.f40205a.a(new String[0]);
        f39835c = ae.a.a(ae.f39722a, r2, null, 1, null);
        f39836d = ac.a.a(ac.g, r2, null, 0, 0, 7, null);
        h = r.f38742b.a(new h[]{h.f38722a.c("efbbbf"), h.f38722a.c("feff"), h.f38722a.c("fffe"), h.f38722a.c("0000ffff"), h.f38722a.c("ffff0000")});
        TimeZone r1 = TimeZone.getTimeZone("GMT");
        o.a(r1);
        f39837e = r1;
        i = new k("([0-9a-fA-F]*:[0-9a-fA-F:.]*)|([\\d.]+)");
        f = false;
        String r0 = z.class.getName();
        o.c(r0, "OkHttpClient::class.java.name");
        g = d.o.o.b(d.o.o.a(r0, (CharSequence) ZeusTransformUtils.preCheckCast("okhttp3.", CharSequence.class, "com.obric.aiagent.plugin")), (CharSequence) ZeusTransformUtils.preCheckCast("Client", CharSequence.class, "com.obric.aiagent.plugin"));
    }

    public static final void a(long r4, long r6, long r8) {
        if ((r6 | r8) < 0) goto L10;
        if (r6 > r4) goto L10;
        if ((r4 - r6) < r8) goto L10;
        return;
    L10:
        throw new ArrayIndexOutOfBoundsException();
    }

    public static final ThreadFactory a(final String r1, final boolean r2) {
        o.e(r1, "name");
        return new $$Lambda$c$YkPHNqGK348g8mzA3x8qIGED6HU(r1, r2);
    }

    private static final Thread a(String r2, boolean r3, Runnable r4) {
        Runnable r5 = (Runnable) ZeusTransformUtils.wrapperContextForParams(r4, Runnable.class, "com.obric.aiagent.plugin");
        o.e(r2, "$name");
        Thread r0 = new Thread(r5, r2);
        r0.setDaemon(r3);
        return r0;
    }

    public static final String[] a(String[] r9, String[] r10, Comparator<? super String> r11) {
        Comparator r12 = (Comparator) ZeusTransformUtils.wrapperContextForParams(r11, Comparator.class, "com.obric.aiagent.plugin");
        o.e(r9, "<this>");
        o.e(r10, "other");
        o.e(r12, "comparator");
        List r0 = (List) ZeusTransformUtils.preCheckCast(new ArrayList(), List.class, "com.obric.aiagent.plugin");
        int r2 = r9.length;
        int r4 = 0;
    L3:
        if (r4 >= r2) goto L12;
        String r5 = r9[r4];
        int r6 = r10.length;
        int r7 = 0;
    L5:
        if (r7 >= r6) goto L10;
        if (r12.compare(r5, r10[r7]) == 0) goto L8;
        r7 = r7 + 1;
        goto L5
    L8:
        r0.add(r5);
    L10:
        r4 = r4 + 1;
        goto L3
    L12:
        return (String[]) ZeusTransformUtils.preCheckCast(((Collection) ZeusTransformUtils.preCheckCast(r0, Collection.class, "com.obric.aiagent.plugin")).toArray(new String[0]), String[].class, "com.obric.aiagent.plugin");
    }

    public static final boolean b(String[] r9, String[] r10, Comparator<? super String> r11) {
        Comparator r12 = (Comparator) ZeusTransformUtils.wrapperContextForParams(r11, Comparator.class, "com.obric.aiagent.plugin");
        o.e(r9, "<this>");
        o.e(r12, "comparator");
        if (r9.length != 0) goto L5;
        boolean r0 = true;
    L6:
        if (r0 == true) goto L23;
        if (r10 == null) goto L23;
        if (r10.length != 0) goto L11;
        boolean r1 = true;
    L12:
        if (r1 == true) goto L23;
        int r2 = r9.length;
        int r4 = 0;
    L15:
        if (r4 >= r2) goto L23;
        String r5 = r9[r4];
        Iterator r6 = d.h.b.c.a(r10);
    L18:
        if (r6.hasNext() == false) goto L22;
        if (r12.compare(r5, (String) ZeusTransformUtils.preCheckCast(r6.next(), String.class, "com.obric.aiagent.plugin")) != 0) goto L18;
        return true;
    L22:
        r4 = r4 + 1;
        goto L15
    L11:
        r1 = false;
    L23:
        return false;
    L5:
        r0 = false;
        goto L6
    }

    public static /* synthetic */ String a(v r0, boolean r1, int r2, Object r3) {
        if ((r2 & 1) == 0) goto L6;
        r1 = false;
    L6:
        return a(r0, r1);
    }

    public static final String a(v r5, boolean r6) {
        o.e(r5, "<this>");
        if (d.o.o.c((CharSequence) ZeusTransformUtils.preCheckCast(r5.b(), CharSequence.class, "com.obric.aiagent.plugin"), (CharSequence) ZeusTransformUtils.preCheckCast(":", CharSequence.class, "com.obric.aiagent.plugin"), false, 2, null) == false) goto L5;
        String r0 = '[' + r5.b() + ']';
    L6:
        if (r6 == true) goto L10;
        if (r5.c() != v.f40208a.a(r5.a())) goto L10;
        return r0;
    L10:
        return r0 + ':' + r5.c();
    L5:
        r0 = r5.b();
        goto L6
    }

    public static final String[] a(String[] r2, String r3) {
        o.e(r2, "<this>");
        o.e(r3, "value");
        Object[] r4 = Arrays.copyOf(r2, r2.length + 1);
        o.c(r4, "copyOf(this, newSize)");
        String[] r5 = (String[]) ZeusTransformUtils.preCheckCast(r4, String[].class, "com.obric.aiagent.plugin");
        r5[i.f(r5)] = r3;
        return r5;
    }

    public static /* synthetic */ int a(String r0, int r1, int r2, int r3, Object r4) {
        if ((r3 & 1) == 0) goto L6;
        r1 = 0;
    L6:
        if ((r3 & 2) == 0) goto L9;
        r2 = r0.length();
    L9:
        return a(r0, r1, r2);
    }

    public static final int a(String r4, int r5, int r6) {
        o.e(r4, "<this>");
    L3:
        if (r5 >= r6) goto L31;
        char r0 = r4.charAt(r5);
        boolean r2 = false;
        if (r0 != '\t') goto L8;
    L6:
        boolean r1 = true;
    L11:
        if (r1 == false) goto L14;
    L12:
        boolean r3 = true;
    L17:
        if (r3 == false) goto L20;
    L18:
        boolean r7 = true;
    L23:
        if (r7 == false) goto L26;
    L24:
        r2 = true;
    L28:
        if (r2 == false) goto L29;
        r5 = r5 + 1;
        goto L3
    L29:
        return r5;
    L26:
        if (r0 != ' ') goto L28;
    L20:
        if (r0 == '\r') goto L18;
        r7 = false;
        goto L23
    L14:
        if (r0 == '\f') goto L12;
        r3 = false;
        goto L17
    L8:
        if (r0 == '\n') goto L6;
        r1 = false;
        goto L11
    L31:
        return r6;
    }

    public static /* synthetic */ int b(String r0, int r1, int r2, int r3, Object r4) {
        if ((r3 & 1) == 0) goto L6;
        r1 = 0;
    L6:
        if ((r3 & 2) == 0) goto L9;
        r2 = r0.length();
    L9:
        return b(r0, r1, r2);
    }

    public static final int b(String r4, int r5, int r6) {
        o.e(r4, "<this>");
        int r7 = r6 - 1;
        if (r5 > r7) goto L33;
    L4:
        char r1 = r4.charAt(r7);
        boolean r3 = false;
        if (r1 != '\t') goto L8;
    L6:
        boolean r2 = true;
    L11:
        if (r2 == false) goto L14;
    L12:
        boolean r8 = true;
    L17:
        if (r8 == false) goto L20;
    L18:
        boolean r9 = true;
    L23:
        if (r9 == false) goto L26;
    L24:
        r3 = true;
    L28:
        if (r3 == false) goto L30;
        if (r7 == r5) goto L33;
        r7 = r7 - 1;
        goto L4
    L30:
        return r7 + 1;
    L26:
        if (r1 != ' ') goto L28;
    L20:
        if (r1 == '\r') goto L18;
        r9 = false;
        goto L23
    L14:
        if (r1 == '\f') goto L12;
        r8 = false;
        goto L17
    L8:
        if (r1 == '\n') goto L6;
        r2 = false;
    L33:
        return r5;
    }

    public static /* synthetic */ String c(String r0, int r1, int r2, int r3, Object r4) {
        if ((r3 & 1) == 0) goto L6;
        r1 = 0;
    L6:
        if ((r3 & 2) == 0) goto L9;
        r2 = r0.length();
    L9:
        return c(r0, r1, r2);
    }

    public static final String c(String r1, int r2, int r3) {
        o.e(r1, "<this>");
        int r4 = a(r1, r2, r3);
        String r5 = r1.substring(r4, b(r1, r4, r3));
        o.c(r5, "this as java.lang.String…ing(startIndex, endIndex)");
        return r5;
    }

    public static final int a(String r5, String r6, int r7, int r8) {
        o.e(r5, "<this>");
        o.e(r6, "delimiters");
    L3:
        if (r7 >= r8) goto L8;
        if (d.o.o.c((CharSequence) ZeusTransformUtils.preCheckCast(r6, CharSequence.class, "com.obric.aiagent.plugin"), r5.charAt(r7), false, 2, null) == true) goto L6;
        r7 = r7 + 1;
        goto L3
    L6:
        return r7;
    L8:
        return r8;
    }

    public static /* synthetic */ int a(String r0, char r1, int r2, int r3, int r4, Object r5) {
        if ((r4 & 2) == 0) goto L6;
        r2 = 0;
    L6:
        if ((r4 & 4) == 0) goto L9;
        r3 = r0.length();
    L9:
        return a(r0, r1, r2, r3);
    }

    public static final int a(String r1, char r2, int r3, int r4) {
        o.e(r1, "<this>");
    L3:
        if (r3 >= r4) goto L8;
        if (r1.charAt(r3) == r2) goto L6;
        r3 = r3 + 1;
        goto L3
    L6:
        return r3;
    L8:
        return r4;
    }

    public static final int a(String r4) {
        o.e(r4, "<this>");
        int r0 = r4.length();
        int r1 = 0;
    L3:
        if (r1 >= r0) goto L11;
        char r2 = r4.charAt(r1);
        if (o.a(r2, 31) <= 0) goto L10;
        if (o.a(r2, 127) >= 0) goto L10;
        r1 = r1 + 1;
    L10:
        return r1;
    L11:
        return -1;
    }

    public static final boolean b(String r3) {
        o.e(r3, "<this>");
        return i.a((CharSequence) ZeusTransformUtils.preCheckCast(r3, CharSequence.class, "com.obric.aiagent.plugin"));
    }

    public static final boolean c(String r2) {
        o.e(r2, "name");
        if (d.o.o.a(r2, "Authorization", true) == false) goto L5;
        return true;
    L5:
        if (d.o.o.a(r2, "Cookie", true) == false) goto L7;
        return true;
    L7:
        if (d.o.o.a(r2, "Proxy-Authorization", true) == false) goto L9;
        return true;
    L9:
        if (d.o.o.a(r2, "Set-Cookie", true) == true) goto L16;
        return false;
    L16:
        return true;
    }

    public static final String a(String r2, Object... r3) {
        o.e(r2, "format");
        o.e(r3, "args");
        ad r0 = ad.f38485a;
        Locale r1 = Locale.US;
        Object[] r4 = Arrays.copyOf(r3, r3.length);
        String r5 = String.format(r1, r2, Arrays.copyOf(r4, r4.length));
        o.c(r5, "format(locale, format, *args)");
        return r5;
    }

    public static final Charset a(g r2, Charset r3) {
        g r4 = (g) ZeusTransformUtils.wrapperContextForParams(r2, g.class, "com.obric.aiagent.plugin");
        o.e(r4, "<this>");
        o.e(r3, DownloadSettingKeys.BugFix.DEFAULT);
        int r5 = r4.a(h);
        if (r5 == (-1)) goto L21;
        if (r5 != 0) goto L6;
        Charset r6 = StandardCharsets.UTF_8;
        o.c(r6, "UTF_8");
        return r6;
    L6:
        if (r5 != 1) goto L8;
        Charset r7 = StandardCharsets.UTF_16BE;
        o.c(r7, "UTF_16BE");
        return r7;
    L8:
        if (r5 != 2) goto L10;
        Charset r8 = StandardCharsets.UTF_16LE;
        o.c(r8, "UTF_16LE");
        return r8;
    L10:
        if (r5 == 3) goto L23;
        if (r5 != 4) goto L15;
        return d.f38622a.a();
    L15:
        throw new AssertionError();
    L23:
        return d.f38622a.b();
    L21:
        return r3;
    }

    public static final int a(String r7, long r8, TimeUnit r10) {
        o.e(r7, "name");
        boolean r3 = true;
        if (r8 < 0) goto L5;
        boolean r5 = true;
    L6:
        if (r5 == false) goto L31;
        if (r10 == null) goto L9;
        boolean r6 = true;
    L10:
        if (r6 == false) goto L29;
        long r9 = r10.toMillis(r8);
        if (r9 > 2147483647L) goto L14;
        boolean r11 = true;
    L15:
        if (r11 == false) goto L27;
        if (r9 != 0) goto L21;
        if (r8 <= 0) goto L21;
        r3 = false;
    L21:
        if (r3 == false) goto L25;
        return (int) r9;
    L25:
        throw new IllegalArgumentException((r7 + " too small.").toString());
    L27:
        throw new IllegalArgumentException((r7 + " too large.").toString());
    L14:
        r11 = false;
        goto L15
    L29:
        throw new IllegalStateException("unit == null".toString());
    L9:
        r6 = false;
        goto L10
    L31:
        throw new IllegalStateException((r7 + " < 0").toString());
    L5:
        r5 = false;
        goto L6
    }

    public static final u a(List<okhttp3.internal.g.c> r4) {
        List r5 = (List) ZeusTransformUtils.wrapperContextForParams(r4, List.class, "com.obric.aiagent.plugin");
        o.e(r5, "<this>");
        u.a r0 = new u.a();
        Iterator r6 = r5.iterator();
    L4:
        if (r6.hasNext() == false) goto L7;
        okhttp3.internal.g.c r2 = (okhttp3.internal.g.c) ZeusTransformUtils.preCheckCast(r6.next(), okhttp3.internal.g.c.class, "com.obric.aiagent.plugin");
        h r3 = r2.a();
        h r7 = r2.b();
        r0.b(r3.d(), r7.d());
        goto L4
    L7:
        return r0.b();
    }

    public static final List<okhttp3.internal.g.c> a(u r6) {
        o.e(r6, "<this>");
        Iterable r0 = (Iterable) ZeusTransformUtils.preCheckCast(n.b(0, r6.a()), Iterable.class, "com.obric.aiagent.plugin");
        Collection r1 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(p.a(r0, 10)), Collection.class, "com.obric.aiagent.plugin");
        Iterator r2 = r0.iterator();
    L4:
        if (r2.hasNext() == false) goto L7;
        int r3 = ((al) ZeusTransformUtils.preCheckCast(r2, al.class, "com.obric.aiagent.plugin")).a();
        r1.add(new okhttp3.internal.g.c(r6.a(r3), r6.b(r3)));
        goto L4
    L7:
        return (List) ZeusTransformUtils.preCheckCast(r1, List.class, "com.obric.aiagent.plugin");
    }

    public static final boolean a(v r2, v r3) {
        o.e(r2, "<this>");
        o.e(r3, "other");
        if (o.a(r2.b(), r3.b()) == true) goto L5;
    L9:
        return false;
    L5:
        if (r2.c() != r3.c()) goto L9;
        if (o.a(r2.a(), r3.a()) == false) goto L9;
        return true;
    }

    public static final okhttp3.r.c a(final okhttp3.r r1) {
        o.e(r1, "<this>");
        return new $$Lambda$c$Z0PfrgtZgpcHRLWppvU1OturPI(r1);
    }

    public static final void a(f r2, int r3) {
        f r4 = (f) ZeusTransformUtils.wrapperContextForParams(r2, f.class, "com.obric.aiagent.plugin");
        o.e(r4, "<this>");
        r4.h((r3 >>> 16) & 255);
        r4.h((r3 >>> 8) & 255);
        r4.h(r3 & 255);
    }

    public static final int a(g r3) {
        g r4 = (g) ZeusTransformUtils.wrapperContextForParams(r3, g.class, "com.obric.aiagent.plugin");
        o.e(r4, "<this>");
        int r0 = (a(r4.k(), 255) << 16) | (a(r4.k(), 255) << 8);
        return a(r4.k(), 255) | r0;
    }

    public static final boolean a(aa r11, int r12, TimeUnit r13) {
        aa r14 = (aa) ZeusTransformUtils.wrapperContextForParams(r11, aa.class, "com.obric.aiagent.plugin");
        o.e(r14, "<this>");
        o.e(r13, "timeUnit");
        long r0 = System.nanoTime();
        if (r14.a().u_() == false) goto L5;
        long r5 = r14.a().d() - r0;
    L6:
        r14.a().a(Math.min(r5, r13.toNanos(r12)) + r0);
        e.e r15 = new e.e();     // Catch: Throwable -> L16 InterruptedIOException -> L22
    L9:
        if (r14.a(r15, PlaybackStateCompat.ACTION_PLAY_FROM_URI) == (-1)) goto L12;
        r15.x();     // Catch: Throwable -> L16 InterruptedIOException -> L22
    L12:
        boolean r16 = true;
        if (r5 != Long.MAX_VALUE) goto L15;
    L14:
        r14.a().w_();
    L25:
        return r16;
    L15:
        r14.a().a(r0 + r5);
    L22:
        r16 = false;
        if (r5 != Long.MAX_VALUE) goto L15;
    L16:
        th = move-exception;
        if (r5 != Long.MAX_VALUE) goto L20;
        r14.a().w_();
    L21:
        throw th;
    L20:
        r14.a().a(r0 + r5);
        goto L21
    L5:
        r5 = Long.MAX_VALUE;
        goto L6
    }

    public static final boolean b(aa r2, int r3, TimeUnit r4) {
        aa r5 = (aa) ZeusTransformUtils.wrapperContextForParams(r2, aa.class, "com.obric.aiagent.plugin");
        o.e(r5, "<this>");
        o.e(r4, "timeUnit");
        return a(r5, r3, r4);
    L5:
        return false;
    }

    public static final boolean a(Socket r2, g r3) {
        g r4 = (g) ZeusTransformUtils.wrapperContextForParams(r3, g.class, "com.obric.aiagent.plugin");
        o.e(r2, "<this>");
        o.e(r4, DBHelper.BATTERY_COL_SOURCE);
        int r1 = r2.getSoTimeout();     // Catch: IOException -> L10 SocketTimeoutException -> L12
        r2.setSoTimeout(1);     // Catch: Throwable -> L7
        boolean r5 = !r4.h();
        r2.setSoTimeout(r1);     // Catch: IOException -> L10 SocketTimeoutException -> L12
        return r5;
    L7:
        th = move-exception;
        r2.setSoTimeout(r1);     // Catch: IOException -> L10 SocketTimeoutException -> L12
        throw th;     // Catch: IOException -> L10 SocketTimeoutException -> L12
    L10:
        return false;
    L17:
        return true;
    }

    public static final int a(e.e r3, byte r4) {
        o.e(r3, "<this>");
        int r0 = 0;
    L4:
        if (r3.h() == true) goto L8;
        if (r3.c(0) != r4) goto L8;
        r0 = r0 + 1;
        r3.k();
    L8:
        return r0;
    }

    public static final int a(String r3, int r4) {
        o.e(r3, "<this>");
        int r0 = r3.length();
    L3:
        if (r4 >= r0) goto L11;
        char r1 = r3.charAt(r4);
        if (r1 == ' ') goto L9;
        if (r1 == '\t') goto L9;
        return r4;
    L9:
        r4 = r4 + 1;
        goto L3
    L11:
        return r3.length();
    }

    public static final long a(okhttp3.ad r2) {
        o.e(r2, "<this>");
        String r3 = r2.f().a(DownloadUtils.CONTENT_LENGTH);
        if (r3 != null) goto L5;
        return -1;
    L5:
        return a(r3, -1);
    }

    public static final long a(String r1, long r2) {
        o.e(r1, "<this>");
        return Long.parseLong(r1);
    L8:
        return r2;
    }

    public static final int b(String r2, int r3) {
        if (r2 != null) goto L14;
    L12:
        return r3;
    L14:
        long r4 = Long.parseLong(r2);     // Catch: NumberFormatException -> L13
        if (r4 <= 2147483647L) goto L8;
        return Integer.MAX_VALUE;
    L8:
        if (r4 >= 0) goto L11;
        return 0;
    L11:
        return (int) r4;
    }

    public static final <T> List<T> b(List<? extends T> r2) {
        List r3 = (List) ZeusTransformUtils.wrapperContextForParams(r2, List.class, "com.obric.aiagent.plugin");
        o.e(r3, "<this>");
        List<T> r4 = Collections.unmodifiableList(p.g((Collection) ZeusTransformUtils.preCheckCast(r3, Collection.class, "com.obric.aiagent.plugin")));
        o.c(r4, "unmodifiableList(toMutableList())");
        return r4;
    }

    @SafeVarargs
    public static final <T> List<T> a(T... r2) {
        o.e(r2, "elements");
        Object[] r3 = (Object[]) ZeusTransformUtils.preCheckCast(r2.clone(), Object[].class, "com.obric.aiagent.plugin");
        List<T> r4 = Collections.unmodifiableList(p.b(Arrays.copyOf(r3, r3.length)));
        o.c(r4, "unmodifiableList(listOf(*elements.clone()))");
        return r4;
    }

    public static final <K, V> Map<K, V> a(Map<K, ? extends V> r2) {
        Map r3 = (Map) ZeusTransformUtils.wrapperContextForParams(r2, Map.class, "com.obric.aiagent.plugin");
        o.e(r3, "<this>");
        if (r3.isEmpty() == true) goto L7;
        Map<K, V> r4 = Collections.unmodifiableMap((Map) ZeusTransformUtils.preCheckCast(new LinkedHashMap(r3), Map.class, "com.obric.aiagent.plugin"));
        o.c(r4, "{\n    Collections.unmodi…(LinkedHashMap(this))\n  }");
        return r4;
    L7:
        return ao.b();
    }

    public static final void a(Closeable r2) {
        Closeable r3 = (Closeable) ZeusTransformUtils.wrapperContextForParams(r2, Closeable.class, "com.obric.aiagent.plugin");
        o.e(r3, "<this>");
        r3.close();     // Catch: Exception -> L7 RuntimeException -> L5
        return;
    L5:
        e = move-exception;
        throw e;
    }

    public static final void a(Socket r2) {
        o.e(r2, "<this>");
        r2.close();     // Catch: Exception -> L12 RuntimeException -> L5 AssertionError -> L10
        return;
    L10:
        e = move-exception;
        throw e;
    L5:
        e = move-exception;
        if (o.a(e.getMessage(), "bio == null") == false) goto L9;
        return;
    L9:
        throw e;
    }

    public static final boolean a(okhttp3.internal.h.a r3, File r4) {
        okhttp3.internal.h.a r5 = (okhttp3.internal.h.a) ZeusTransformUtils.wrapperContextForParams(r3, okhttp3.internal.h.a.class, "com.obric.aiagent.plugin");
        o.e(r5, "<this>");
        o.e(r4, "file");
        Closeable r0 = (Closeable) ZeusTransformUtils.preCheckCast(r5.b(r4), Closeable.class, "com.obric.aiagent.plugin");
        y r1 = (y) ZeusTransformUtils.preCheckCast(r0, y.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L11
        r5.delete(r4);     // Catch: IOException -> L8 Throwable -> L11
        d.f.c.a(r0, null);
        return true;
    L8:
        x r2 = x.f38692a;     // Catch: Throwable -> L11
        d.f.c.a(r0, null);
        r5.delete(r4);
        return false;
    L11:
        th = move-exception;
        throw th;     // Catch: Throwable -> L13
    L13:
        th = move-exception;
        d.f.c.a(r0, th);
        throw th;
    }

    public static final <T> T a(Object r4, Class<T> r5, String r6) {
        o.e(r4, "instance");
        o.e(r5, "fieldType");
        o.e(r6, "fieldName");
        Class<?> r0 = r4.getClass();
    L3:
        T r2 = null;
        if (o.a(r0, Object.class) == true) goto L12;
        Field r1 = r0.getDeclaredField(r6);     // Catch: NoSuchFieldException -> L10
        r1.setAccessible(true);     // Catch: NoSuchFieldException -> L10
        Object r3 = r1.get(r4);     // Catch: NoSuchFieldException -> L10
        if (ZeusTransformUtils.instanceOf(r5, r3) == false) goto L9;
        r2 = r5.cast(r3);     // Catch: NoSuchFieldException -> L10
    L9:
        return r2;
    L10:
        r0 = r0.getSuperclass();
        o.c(r0, "c.superclass");
        goto L3
    L12:
        if (o.a(r6, "delegate") == true) goto L17;
        Object r7 = a(r4, Object.class, "delegate");
        if (r7 == null) goto L17;
        return (T) a(r7, r5, r6);
    L17:
        return null;
    }

    public static final <E> void a(List<E> r2, E r3) {
        List r4 = (List) ZeusTransformUtils.wrapperContextForParams(r2, List.class, "com.obric.aiagent.plugin");
        o.e(r4, "<this>");
        if (r4.contains(r3) == true) goto L6;
        r4.add(r3);
        return;
    }

    public static final Throwable a(Exception r4, List<? extends Exception> r5) {
        List r6 = (List) ZeusTransformUtils.wrapperContextForParams(r5, List.class, "com.obric.aiagent.plugin");
        o.e(r4, "<this>");
        o.e(r6, "suppressed");
        Iterator r7 = r6.iterator();
    L4:
        if (r7.hasNext() == false) goto L7;
        Exception r0 = (Exception) ZeusTransformUtils.preCheckCast(r7.next(), Exception.class, "com.obric.aiagent.plugin");
        d.a.a((Throwable) ZeusTransformUtils.preCheckCast(r4, Throwable.class, "com.obric.aiagent.plugin"), (Throwable) ZeusTransformUtils.preCheckCast(r0, Throwable.class, "com.obric.aiagent.plugin"));
        goto L4
    L7:
        return (Throwable) ZeusTransformUtils.preCheckCast(r4, Throwable.class, "com.obric.aiagent.plugin");
    }

    public static final int a(String[] r4, String r5, Comparator<String> r6) {
        Comparator r7 = (Comparator) ZeusTransformUtils.wrapperContextForParams(r6, Comparator.class, "com.obric.aiagent.plugin");
        o.e(r4, "<this>");
        o.e(r5, "value");
        o.e(r7, "comparator");
        int r0 = r4.length;
        int r2 = 0;
    L3:
        if (r2 >= r0) goto L11;
        if (r7.compare(r4[r2], r5) != 0) goto L7;
        boolean r3 = true;
    L8:
        if (r3 == true) goto L15;
        r2 = r2 + 1;
        goto L3
    L15:
        return r2;
    L7:
        r3 = false;
        goto L8
    L11:
        return -1;
    }
}
