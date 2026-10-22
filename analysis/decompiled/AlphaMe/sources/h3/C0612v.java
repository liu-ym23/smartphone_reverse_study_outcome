package h3;

import androidx.room.AbstractC0351g;
import java.util.Date;
import java.util.regex.Pattern;
import kotlin.jvm.internal.Intrinsics;
import okhttp3.internal.http.DatesKt;

/* renamed from: h3.v, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public final class C0612v {

    /* renamed from: j, reason: collision with root package name */
    public static final Pattern f12974j = Pattern.compile("(\\d{2,4})[^\\d]*");

    /* renamed from: k, reason: collision with root package name */
    public static final Pattern f12975k = Pattern.compile("(?i)(jan|feb|mar|apr|may|jun|jul|aug|sep|oct|nov|dec).*");

    /* renamed from: l, reason: collision with root package name */
    public static final Pattern f12976l = Pattern.compile("(\\d{1,2})[^\\d]*");

    /* renamed from: m, reason: collision with root package name */
    public static final Pattern f12977m = Pattern.compile("(\\d{1,2}):(\\d{1,2}):(\\d{1,2})[^\\d]*");

    /* renamed from: a, reason: collision with root package name */
    public final String f12978a;

    /* renamed from: b, reason: collision with root package name */
    public final String f12979b;

    /* renamed from: c, reason: collision with root package name */
    public final long f12980c;

    /* renamed from: d, reason: collision with root package name */
    public final String f12981d;

    /* renamed from: e, reason: collision with root package name */
    public final String f12982e;

    /* renamed from: f, reason: collision with root package name */
    public final boolean f12983f;

    /* renamed from: g, reason: collision with root package name */
    public final boolean f12984g;

    /* renamed from: h, reason: collision with root package name */
    public final boolean f12985h;

    /* renamed from: i, reason: collision with root package name */
    public final boolean f12986i;

    public C0612v(String str, String str2, long j4, String str3, String str4, boolean z4, boolean z5, boolean z6, boolean z7) {
        this.f12978a = str;
        this.f12979b = str2;
        this.f12980c = j4;
        this.f12981d = str3;
        this.f12982e = str4;
        this.f12983f = z4;
        this.f12984g = z5;
        this.f12985h = z6;
        this.f12986i = z7;
    }

    public final String a(boolean z4) {
        StringBuilder sb = new StringBuilder();
        sb.append(this.f12978a);
        sb.append('=');
        sb.append(this.f12979b);
        if (this.f12985h) {
            long j4 = this.f12980c;
            if (j4 == Long.MIN_VALUE) {
                sb.append("; max-age=0");
            } else {
                sb.append("; expires=");
                sb.append(DatesKt.toHttpDateString(new Date(j4)));
            }
        }
        if (!this.f12986i) {
            sb.append("; domain=");
            if (z4) {
                sb.append(".");
            }
            sb.append(this.f12981d);
        }
        sb.append("; path=");
        sb.append(this.f12982e);
        if (this.f12983f) {
            sb.append("; secure");
        }
        if (this.f12984g) {
            sb.append("; httponly");
        }
        String string = sb.toString();
        Intrinsics.checkNotNullExpressionValue(string, "toString()");
        return string;
    }

    public final boolean equals(Object obj) {
        if (obj instanceof C0612v) {
            C0612v c0612v = (C0612v) obj;
            if (Intrinsics.areEqual(c0612v.f12978a, this.f12978a) && Intrinsics.areEqual(c0612v.f12979b, this.f12979b) && c0612v.f12980c == this.f12980c && Intrinsics.areEqual(c0612v.f12981d, this.f12981d) && Intrinsics.areEqual(c0612v.f12982e, this.f12982e) && c0612v.f12983f == this.f12983f && c0612v.f12984g == this.f12984g && c0612v.f12985h == this.f12985h && c0612v.f12986i == this.f12986i) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        return Boolean.hashCode(this.f12986i) + ((Boolean.hashCode(this.f12985h) + ((Boolean.hashCode(this.f12984g) + ((Boolean.hashCode(this.f12983f) + AbstractC0351g.d(this.f12982e, AbstractC0351g.d(this.f12981d, B0.g.f(this.f12980c, AbstractC0351g.d(this.f12979b, AbstractC0351g.d(this.f12978a, 527, 31), 31), 31), 31), 31)) * 31)) * 31)) * 31);
    }

    public final String toString() {
        return a(false);
    }
}
