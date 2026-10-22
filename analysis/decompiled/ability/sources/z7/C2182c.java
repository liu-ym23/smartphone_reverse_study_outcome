package z7;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* renamed from: z7.c, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public final class C2182c {
    public static final Pattern e = Pattern.compile("[ |\t]*([^/^ ^;^,]+/[^ ^;^,]+)", 2);
    public static final Pattern f = Pattern.compile("[ |\t]*(charset)[ |\t]*=[ |\t]*['|\"]?([^\"^'^;^,]*)['|\"]?", 2);
    public static final Pattern g = Pattern.compile("[ |\t]*(boundary)[ |\t]*=[ |\t]*['|\"]?([^\"^'^;^,]*)['|\"]?", 2);

    /* renamed from: a, reason: collision with root package name */
    public final String f6975a;
    public final String b;
    public final String c;
    public final String d;

    public C2182c(String str) {
        this.f6975a = str;
        if (str != null) {
            Matcher matcher = e.matcher(str);
            this.b = matcher.find() ? matcher.group(1) : "";
            Matcher matcher2 = f.matcher(str);
            this.c = matcher2.find() ? matcher2.group(2) : null;
        } else {
            this.b = "";
            this.c = "UTF-8";
        }
        if (!"multipart/form-data".equalsIgnoreCase(this.b)) {
            this.d = null;
        } else {
            Matcher matcher3 = g.matcher(str);
            this.d = matcher3.find() ? matcher3.group(2) : null;
        }
    }

    public final String a() {
        String str = this.c;
        return str == null ? "US-ASCII" : str;
    }
}
