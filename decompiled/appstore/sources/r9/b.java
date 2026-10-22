package r9;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* JADX INFO: loaded from: classes3.dex */
public class b {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final Pattern f23784e = null;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final Pattern f23785f = null;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final Pattern f23786g = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f23787a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f23788b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f23789c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final String f23790d;

    static {
        f23784e = Pattern.compile("[ |\t]*([^/^ ^;^,]+/[^ ^;^,]+)", 2);
        f23785f = Pattern.compile("[ |\t]*(charset)[ |\t]*=[ |\t]*['|\"]?([^\"^'^;^,]*)['|\"]?", 2);
        f23786g = Pattern.compile("[ |\t]*(boundary)[ |\t]*=[ |\t]*['|\"]?([^\"^'^;^,]*)['|\"]?", 2);
    }

    public b(String r10) {
        this.f23787a = r10;
        if (r10 == null) goto L5;
        this.f23788b = a(r10, f23784e, "", 1);
        this.f23789c = a(r10, f23785f, null, 2);
    L7:
        if ("multipart/form-data".equalsIgnoreCase(this.f23788b) == false) goto L9;
        this.f23790d = a(r10, f23786g, null, 2);
        return;
    L9:
        this.f23790d = null;
        return;
    L5:
        this.f23788b = "";
        this.f23789c = "UTF-8";
        goto L7
    }

    public final String a(String r10, Pattern r11, String r12, int r13) {
        Matcher r14 = r11.matcher(r10);
        if (r14.find() == true) goto L5;
        return r12;
    L5:
        return r14.group(r13);
    }

    public String b() {
        String r10 = this.f23789c;
        if (r10 != null) goto L6;
        return "US-ASCII";
    L6:
        return r10;
    }
}
