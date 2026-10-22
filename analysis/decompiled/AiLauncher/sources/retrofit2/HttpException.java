package retrofit2;

import java.util.Objects;
import yc.v;

/* loaded from: classes5.dex */
public class HttpException extends RuntimeException {

    /* renamed from: a, reason: collision with root package name */
    public final int f39886a;

    /* renamed from: b, reason: collision with root package name */
    public final String f39887b;

    /* renamed from: c, reason: collision with root package name */
    public final transient v<?> f39888c;

    public HttpException(v<?> vVar) {
        super(b(vVar));
        this.f39886a = vVar.b();
        this.f39887b = vVar.g();
        this.f39888c = vVar;
    }

    public static String b(v<?> vVar) {
        Objects.requireNonNull(vVar, "response == null");
        return "HTTP " + vVar.b() + " " + vVar.g();
    }

    public int a() {
        return this.f39886a;
    }

    public String c() {
        return this.f39887b;
    }

    public v<?> d() {
        return this.f39888c;
    }
}
