package okhttp3;

import java.nio.charset.Charset;
import java.util.Locale;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* JADX INFO: loaded from: classes4.dex */
public final class MediaType {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final Pattern f22718e = null;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final Pattern f22719f = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f22720a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f22721b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f22722c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final String f22723d;

    static {
        f22718e = Pattern.compile("([a-zA-Z0-9-!#$%&'*+.^_`{|}~]+)/([a-zA-Z0-9-!#$%&'*+.^_`{|}~]+)");
        f22719f = Pattern.compile(";\\s*(?:([a-zA-Z0-9-!#$%&'*+.^_`{|}~]+)=(?:([a-zA-Z0-9-!#$%&'*+.^_`{|}~]+)|\"([^\"]*)\"))?");
    }

    public MediaType(String r10, String r11, String r12, String r13) {
        this.f22720a = r10;
        this.f22721b = r11;
        this.f22722c = r12;
        this.f22723d = r13;
    }

    public static MediaType c(String r10) {
        Matcher r11 = f22718e.matcher(r10);
        if (r11.lookingAt() == true) goto L5;
        return null;
    L5:
        String r12 = r11.group(1);
        Locale r13 = Locale.US;
        String r14 = r12.toLowerCase(r13);
        String r15 = r11.group(2).toLowerCase(r13);
        Matcher r16 = f22719f.matcher(r10);
        int r17 = r11.end();
        String r18 = null;
    L7:
        if (r17 >= r10.length()) goto L33;
        r16.region(r17, r10.length());
        if (r16.lookingAt() == false) goto L10;
        String r19 = r16.group(1);
        if (r19 == null) goto L31;
        if (r19.equalsIgnoreCase("charset") == false) goto L31;
        String r20 = r16.group(2);
        if (r20 != null) goto L19;
        r20 = r16.group(3);
    L26:
        if (r18 != null) goto L28;
    L30:
        r18 = r20;
        goto L31
    L28:
        if (r20.equalsIgnoreCase(r18) == true) goto L30;
        return null;
    L19:
        if (r20.startsWith("'") == false) goto L26;
        if (r20.endsWith("'") == false) goto L26;
        if (r20.length() <= 2) goto L26;
        r20 = r20.substring(1, r20.length() - 1);
    L31:
        r17 = r16.end();
        goto L7
    L10:
        return null;
    L33:
        return new MediaType(r10, r14, r15, r18);
    }

    public Charset a() {
        return b(null);
    }

    public Charset b(Charset r10) {
        String r11 = this.f22723d;     // Catch: IllegalArgumentException -> L6
        if (r11 == null) goto L9;
        return Charset.forName(r11);
    L9:
        return r10;
    L10:
        return r10;
    }

    public String d() {
        return this.f22721b;
    }

    public boolean equals(Object r10) {
        if ((r10 instanceof MediaType) == true) goto L5;
    L7:
        return false;
    L5:
        if (((MediaType) r10).f22720a.equals(this.f22720a) == false) goto L7;
        return true;
    }

    public int hashCode() {
        return this.f22720a.hashCode();
    }

    public String toString() {
        return this.f22720a;
    }
}
