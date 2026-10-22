package okhttp3;

import java.nio.charset.Charset;
import okhttp3.internal.Util;

/* JADX INFO: loaded from: classes4.dex */
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f22856a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f22857b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Charset f22858c;

    public c(String r10, String r11) {
        this(r10, r11, Util.ISO_8859_1);
    }

    public c a(Charset r10) {
        return new c(this.f22856a, this.f22857b, r10);
    }

    public boolean equals(Object r10) {
        if ((r10 instanceof c) == false) goto L11;
        c r11 = (c) r10;
        if (r11.f22856a.equals(this.f22856a) == false) goto L11;
        if (r11.f22857b.equals(this.f22857b) == false) goto L11;
        if (r11.f22858c.equals(this.f22858c) == false) goto L11;
        return true;
    L11:
        return false;
    }

    public int hashCode() {
        return ((((899 + this.f22857b.hashCode()) * 31) + this.f22856a.hashCode()) * 31) + this.f22858c.hashCode();
    }

    public String toString() {
        return this.f22856a + " realm=\"" + this.f22857b + "\" charset=\"" + this.f22858c + "\"";
    }

    public c(String r10, String r11, Charset r12) {
        if (r10 == null) goto L13;
        if (r11 == null) goto L11;
        if (r12 == null) goto L9;
        this.f22856a = r10;
        this.f22857b = r11;
        this.f22858c = r12;
        return;
    L9:
        throw new NullPointerException("charset == null");
    L11:
        throw new NullPointerException("realm == null");
    L13:
        throw new NullPointerException("scheme == null");
    }
}
