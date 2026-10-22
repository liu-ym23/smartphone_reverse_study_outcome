package d.o;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.nio.charset.Charset;

/* JADX INFO: compiled from: Charsets.kt */
/* JADX INFO: loaded from: classes4.dex */
public final class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final d f38622a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final Charset f38623b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final Charset f38624c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final Charset f38625d = null;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final Charset f38626e = null;
    public static final Charset f = null;
    public static final Charset g = null;
    private static volatile Charset h;
    private static volatile Charset i;

    private d() {
    }

    static {
        f38622a = new d();
        Charset r0 = Charset.forName("UTF-8");
        d.h.b.o.c(r0, "forName(...)");
        f38623b = r0;
        Charset r1 = Charset.forName("UTF-16");
        d.h.b.o.c(r1, "forName(...)");
        f38624c = r1;
        Charset r2 = Charset.forName("UTF-16BE");
        d.h.b.o.c(r2, "forName(...)");
        f38625d = r2;
        Charset r3 = Charset.forName("UTF-16LE");
        d.h.b.o.c(r3, "forName(...)");
        f38626e = r3;
        Charset r4 = Charset.forName("US-ASCII");
        d.h.b.o.c(r4, "forName(...)");
        f = r4;
        Charset r5 = Charset.forName("ISO-8859-1");
        d.h.b.o.c(r5, "forName(...)");
        g = r5;
    }

    public final Charset a() {
        Charset r0 = h;
        if (r0 != null) goto L6;
        d r2 = (d) ZeusTransformUtils.preCheckCast(this, d.class, "com.obric.aiagent.plugin");
        Charset r1 = Charset.forName("UTF-32LE");
        d.h.b.o.c(r1, "forName(...)");
        h = r1;
        return r1;
    L6:
        return r0;
    }

    public final Charset b() {
        Charset r0 = i;
        if (r0 != null) goto L6;
        d r2 = (d) ZeusTransformUtils.preCheckCast(this, d.class, "com.obric.aiagent.plugin");
        Charset r1 = Charset.forName("UTF-32BE");
        d.h.b.o.c(r1, "forName(...)");
        i = r1;
        return r1;
    L6:
        return r0;
    }
}
