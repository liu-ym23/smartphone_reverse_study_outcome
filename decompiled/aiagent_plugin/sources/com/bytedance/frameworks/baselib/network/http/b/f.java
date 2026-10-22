package com.bytedance.frameworks.baselib.network.http.b;

import android.text.TextUtils;
import com.ss.android.socialbase.downloader.constants.DownloadConstants;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.net.URI;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashSet;
import java.util.Locale;
import java.util.Objects;
import java.util.Set;

/* JADX INFO: compiled from: HttpCookie.java */
/* JADX INFO: loaded from: classes.dex */
public class f implements Cloneable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final Set<String> f8159a = null;
    private static final ThreadLocal<DateFormat> j = null;
    private static final String[] k = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private String f8160b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private boolean f8161c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private long f8162d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private String f8163e;
    private String f;
    private String g;
    private boolean h;
    private String i;

    /* JADX INFO: compiled from: HttpCookie.java */
    static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        boolean f8164a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final String f8165b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private final String f8166c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private int f8167d;

        a(String r2) {
            this.f8167d = 0;
            this.f8164a = false;
            this.f8165b = r2;
            this.f8166c = r2.toLowerCase(Locale.US);
        }

        f a(URI r7) {
            if (this.f8166c.startsWith("set-cookie:") == false) goto L5;
            this.f8167d += 11;
        L5:
            int r0 = 0;
            String r1 = a(false);
            if (TextUtils.isEmpty(r1) == true) goto L39;
            if (a() == false) goto L37;
            f r3 = new f(r1, b());
            r3.b(String.valueOf(System.currentTimeMillis()), false);
        L10:
            c();
            if (this.f8167d >= this.f8165b.length()) goto L26;
            r0 = r0 + 1;
            if (this.f8165b.charAt(this.f8167d) != ';') goto L16;
            this.f8167d++;
        L16:
            String r2 = a(true);
            if (TextUtils.isEmpty(r2) == true) goto L24;
            String r4 = null;
            if (a() == false) goto L22;
            r4 = b();
        L22:
            a(r3, r2, r4);
        L24:
            if (r0 < 100) goto L10;
        L26:
            if (TextUtils.isEmpty(r3.a()) == false) goto L33;
            String r5 = e.a(r7);
            if (TextUtils.isEmpty(r5) == true) goto L31;
            r3.a(r5, !r5.startsWith("."));
            goto L33
        L31:
            throw new IllegalArgumentException("No domain in " + this.f8165b);
        L33:
            if (TextUtils.isEmpty(r3.d()) == false) goto L35;
            r3.a(f.d(r7.getPath()));
        L35:
            return r3;
        L37:
            throw new IllegalArgumentException("Expected '=' after " + r1 + " in " + this.f8165b);
        L39:
            throw new IllegalArgumentException("No cookies in " + this.f8165b);
        }

        private void a(f r5, String r6, String r7) {
            if (TextUtils.isEmpty(r7) == true) goto L27;
            if (r6.equals("domain") == false) goto L11;
            if (r7.charAt(0) == '.') goto L9;
            r7 = "." + r7;
        L9:
            r5.a(r7.toLowerCase(Locale.US), false);
            return;
        L11:
            if (r6.equals("max-age") == false) goto L17;
            long r2 = Long.parseLong(r7);     // Catch: NumberFormatException -> L14
            this.f8164a = true;     // Catch: NumberFormatException -> L14
            f.a(r5, r2);     // Catch: NumberFormatException -> L14
            return;
        L15:
            throw new IllegalArgumentException("Invalid max-age: " + r7);
        L17:
            if (r6.equals("expires") == false) goto L24;
            if (this.f8164a == true) goto L24;
            Date r4 = f.e(r7);
            if (r4 == null) goto L33;
            f.b(r5, r4.getTime());
            return;
        L33:
            return;
        L24:
            if (r6.equals(DownloadConstants.PATH_KEY) == false) goto L35;
            f.a(r5, r7);
            return;
        L35:
            return;
        L27:
            if (r6.equals("secure") == false) goto L37;
            f.a(r5, true);
            return;
        }

        private String a(boolean r3) {
            c();
            int r0 = a(";= \t");
            if (r3 == false) goto L5;
            String r4 = this.f8166c;
        L6:
            int r1 = this.f8167d;
            if (r1 >= r0) goto L9;
            String r5 = r4.substring(r1, r0);
        L10:
            this.f8167d = r0;
            return r5;
        L9:
            r5 = null;
            goto L10
        L5:
            r4 = this.f8165b;
            goto L6
        }

        private boolean a() {
            c();
            if (this.f8167d < this.f8165b.length()) goto L5;
            return false;
        L5:
            if (this.f8165b.charAt(this.f8167d) != '=') goto L10;
            this.f8167d++;
            return true;
        L10:
            return false;
        }

        private String b() {
            c();
            int r0 = a(";");
            String r1 = this.f8165b.substring(this.f8167d, r0);
            this.f8167d = r0;
            return r1;
        }

        private int a(String r4) {
            int r0 = this.f8167d;
        L4:
            if (r0 >= this.f8165b.length()) goto L10;
            if (r4.indexOf(this.f8165b.charAt(r0)) != (-1)) goto L7;
            r0 = r0 + 1;
            goto L4
        L7:
            return r0;
        L10:
            return this.f8165b.length();
        }

        private void c() {
        L3:
            if (this.f8167d >= this.f8165b.length()) goto L8;
            if (" \t".indexOf(this.f8165b.charAt(this.f8167d)) == (-1)) goto L11;
            this.f8167d++;
            goto L3
        L11:
            return;
        }
    }

    static /* synthetic */ String a(f r0, String r1) {
        r0.g = r1;
        return r1;
    }

    static /* synthetic */ void a(f r0, long r1) {
        r0.b(r1);
    }

    static /* synthetic */ boolean a(f r0, boolean r1) {
        r0.h = r1;
        return r1;
    }

    static /* synthetic */ void b(f r0, long r1) {
        r0.c(r1);
    }

    static /* synthetic */ String d(String r0) {
        return h(r0);
    }

    static /* synthetic */ Date e(String r0) {
        return g(r0);
    }

    static {
        HashSet r0 = new HashSet();
        f8159a = r0;
        r0.add("comment");
        r0.add("commenturl");
        r0.add("discard");
        r0.add("domain");
        r0.add("expires");
        r0.add("httponly");
        r0.add("max-age");
        r0.add(DownloadConstants.PATH_KEY);
        r0.add("port");
        r0.add("secure");
        r0.add("version");
        j = new AnonymousClass1();
        k = new String[]{"EEEE, dd-MMM-yy HH:mm:ss zzz", "EEE MMM d HH:mm:ss yyyy", "EEE, dd-MMM-yyyy HH:mm:ss z", "EEE, dd-MMM-yyyy HH-mm-ss z", "EEE, dd MMM yy HH:mm:ss z", "EEE dd-MMM-yyyy HH:mm:ss z", "EEE dd MMM yyyy HH:mm:ss z", "EEE dd-MMM-yyyy HH-mm-ss z", "EEE dd-MMM-yy HH:mm:ss z", "EEE dd MMM yy HH:mm:ss z", "EEE,dd-MMM-yy HH:mm:ss z", "EEE,dd-MMM-yyyy HH:mm:ss z", "EEE, dd-MM-yyyy HH:mm:ss z", "EEE MMM d yyyy HH:mm:ss z"};
    }

    static f a(URI r1, String r2) {
        return new a(r2).a(r1);
    }

    public f() {
        this.f8161c = true;
        this.f8162d = -1;
    }

    f(String r3, String r4) {
        this.f8161c = true;
        this.f8162d = -1;
        String r0 = r3.trim();
        if (f(r0) == false) goto L7;
        this.f = r0;
        this.i = r4;
        return;
    L7:
        throw new IllegalArgumentException("Invalid name: " + r3);
    }

    private boolean f(String r5) {
        if (r5.isEmpty() == false) goto L5;
    L9:
        boolean r4 = false;
    L10:
        if (r4 == false) goto L25;
        int r1 = 0;
    L13:
        if (r1 >= r5.length()) goto L25;
        char r2 = r5.charAt(r1);
        if (r2 >= 127) goto L34;
        if (r2 == ';') goto L31;
        if (r2 == ',') goto L32;
        if (Character.isWhitespace(r2) == true) goto L33;
        r1 = r1 + 1;
        goto L13
    L33:
        return false;
    L32:
        return false;
    L31:
        return false;
    L34:
        return false;
    L25:
        return r4;
    L5:
        if (r5.startsWith("$") == true) goto L9;
        if (f8159a.contains(r5.toLowerCase(Locale.US)) == true) goto L9;
        r4 = true;
        goto L10
    }

    public String a() {
        return this.f8160b;
    }

    boolean b() {
        return this.f8161c;
    }

    public String c() {
        return this.f;
    }

    public String d() {
        return this.g;
    }

    public boolean e() {
        return this.h;
    }

    public String f() {
        return this.i;
    }

    public long g() {
        return this.f8162d;
    }

    long h() {
        if (TextUtils.isEmpty(this.f8163e) == false) goto L7;
        return -1;
    L7:
        if (this.f8163e.startsWith("s_") == false) goto L11;
        return Long.parseLong(this.f8163e.substring(2));
    L11:
        return Long.parseLong(this.f8163e);
    }

    long i() {
        long r0 = this.f8162d;
        if (r0 > 0) goto L6;
        return r0;
    L6:
        return r0 - System.currentTimeMillis();
    }

    boolean j() {
        long r0 = this.f8162d;
        if (r0 != (-1)) goto L6;
        return false;
    L6:
        if (r0 != 0) goto L9;
        return true;
    L9:
        if (System.currentTimeMillis() > this.f8162d) goto L11;
        return false;
    L11:
        return true;
    }

    public void a(String r2, boolean r3) {
        if (TextUtils.isEmpty(this.f8160b) == true) goto L5;
        return;
    L5:
        if (r2 != null) goto L7;
        String r4 = null;
    L8:
        this.f8160b = r4;
        this.f8161c = r3;
        return;
    L7:
        r4 = r2.toLowerCase(Locale.US);
        goto L8
    }

    public void a(String r1) {
        this.g = r1;
    }

    public void b(String r1) {
        this.f = r1;
    }

    public void c(String r1) {
        this.i = r1;
    }

    public void a(long r1) {
        this.f8162d = r1;
    }

    public void b(String r2, boolean r3) {
        if (r3 == false) goto L4;
        String r4 = "s_";
    L5:
        this.f8163e = r4 + r2;
        return;
    L4:
        r4 = "";
        goto L5
    }

    public void a(boolean r1) {
        this.h = r1;
    }

    private void b(long r5) {
        if (r5 <= 0) goto L5;
        this.f8162d = System.currentTimeMillis() + (r5 * 1000);
        return;
    L5:
        this.f8162d = 0;
    }

    private void c(long r5) {
        if ((r5 - System.currentTimeMillis()) <= 0) goto L5;
        this.f8162d = r5;
        return;
    L5:
        this.f8162d = 0;
    }

    public Object clone() {
        return super.clone();
    L5:
        throw new AssertionError();
    }

    public boolean equals(Object r5) {
        if (r5 != this) goto L6;
        return true;
    L6:
        if (ZeusTransformUtils.instanceOf(r5, f.class) == false) goto L23;
        f r6 = (f) ZeusTransformUtils.preCheckCast(r5, f.class, "com.obric.aiagent.plugin");
        if (this.f.equals(r6.c()) == false) goto L22;
        String r0 = this.f8160b;
        if (r0 == null) goto L15;
        if (r0.equalsIgnoreCase(r6.f8160b) == false) goto L22;
    L17:
        if (Objects.equals(this.g, r6.g) == false) goto L22;
        if (this.f8161c != r6.f8161c) goto L22;
        return true;
    L15:
        if (r6.f8160b == null) goto L17;
    L22:
        return false;
    L23:
        return false;
    }

    public int hashCode() {
        int r0 = (this.f.hashCode() * 31) + 17;
        String r1 = this.f8160b;
        int r2 = 0;
        if (r1 != null) goto L5;
        int r3 = 0;
    L6:
        int r4 = r0 + (r3 * 31);
        String r5 = this.g;
        if (r5 == null) goto L11;
        r2 = r5.hashCode();
    L11:
        return (r4 + (r2 * 31)) + ((!this.f8161c ? 1 : 0) * 31);
    L5:
        r3 = r1.toLowerCase(Locale.US).hashCode();
        goto L6
    }

    public String toString() {
        return this.f + "=" + this.i;
    }

    String k() {
        return this.f + "=" + this.i + "|dom=" + this.f8160b + "|path=" + this.g + "|sec=" + this.h + "|ho=" + this.f8161c + "|exp_t=" + this.f8162d + "|age=" + i() + "|ct=" + this.f8163e;
    }

    private static Date g(String r6) {
        return ((DateFormat) ZeusTransformUtils.preCheckCast(j.get(), DateFormat.class, "com.obric.aiagent.plugin")).parse(r6);
    L4:
        String[] r0 = k;
        int r1 = r0.length;
        int r2 = 0;
    L5:
        if (r2 >= r1) goto L10;
        String r3 = r0[r2];
        return new SimpleDateFormat(r3, Locale.US).parse(r6);
    L9:
        r2 = r2 + 1;
        goto L5
    L10:
        return null;
    }

    private static String h(String r2) {
        if (TextUtils.isEmpty(r2) == false) goto L5;
    L12:
        return "/";
    L5:
        if (r2.startsWith("/") == false) goto L12;
        int r0 = r2.lastIndexOf(47);
        if (r0 > 0) goto L11;
        return "/";
    L11:
        return r2.substring(0, r0);
    }
}
