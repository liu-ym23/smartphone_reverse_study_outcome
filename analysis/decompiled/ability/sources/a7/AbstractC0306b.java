package a7;

import a.AbstractC0291a;
import java.time.Instant;
import java.time.ZoneId;
import java.time.ZoneOffset;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.Locale;

/* renamed from: a7.b, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public abstract class AbstractC0306b {

    /* renamed from: a, reason: collision with root package name */
    public static final DateTimeFormatter f1648a = DateTimeFormatter.ofPattern("EEE, dd MMM yyyy HH:mm:ss z", Locale.ENGLISH).withZone(ZoneId.of("GMT"));

    static {
        DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'");
        DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss'Z'");
    }

    public static String a(Date date) {
        if (date == null) {
            return null;
        }
        return f1648a.format(date.toInstant().atZone(ZoneOffset.UTC));
    }

    public static Date b(String str) {
        if (AbstractC0291a.y(str)) {
            return Date.from(Instant.from(f1648a.parse(str)));
        }
        return null;
    }
}
