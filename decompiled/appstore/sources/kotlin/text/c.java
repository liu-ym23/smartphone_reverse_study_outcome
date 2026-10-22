package kotlin.text;

import java.nio.charset.Charset;
import org.apache.http.protocol.HTTP;

/* JADX INFO: loaded from: classes4.dex */
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final c f21251a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final Charset f21252b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final Charset f21253c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final Charset f21254d = null;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final Charset f21255e = null;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final Charset f21256f = null;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final Charset f21257g = null;

    static {
        f21251a = new c();
        Charset r10 = Charset.forName("UTF-8");
        kotlin.jvm.internal.q.f(r10, "forName(...)");
        f21252b = r10;
        Charset r11 = Charset.forName(HTTP.UTF_16);
        kotlin.jvm.internal.q.f(r11, "forName(...)");
        f21253c = r11;
        Charset r12 = Charset.forName("UTF-16BE");
        kotlin.jvm.internal.q.f(r12, "forName(...)");
        f21254d = r12;
        Charset r13 = Charset.forName("UTF-16LE");
        kotlin.jvm.internal.q.f(r13, "forName(...)");
        f21255e = r13;
        Charset r14 = Charset.forName("US-ASCII");
        kotlin.jvm.internal.q.f(r14, "forName(...)");
        f21256f = r14;
        Charset r15 = Charset.forName("ISO-8859-1");
        kotlin.jvm.internal.q.f(r15, "forName(...)");
        f21257g = r15;
    }

    public c() {
    }
}
