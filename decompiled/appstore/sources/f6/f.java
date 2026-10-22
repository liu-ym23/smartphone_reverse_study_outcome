package f6;

import com.bytedance.retrofit2.RetrofitMetrics;
import com.bytedance.retrofit2.mime.TypedInput;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public final class f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final g6.c f19528a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Object f19529b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final TypedInput f19530c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public RetrofitMetrics f19531d;

    public f(g6.c r10, Object r11, TypedInput r12) {
        this.f19528a = r10;
        this.f19529b = r11;
        this.f19530c = r12;
    }

    public static f c(TypedInput r10, g6.c r11) {
        if (r10 == null) goto L13;
        if (r11 == null) goto L11;
        if (r11.g() == true) goto L9;
        return new f(r11, null, r10);
    L9:
        throw new IllegalArgumentException("rawResponse should not be successful response");
    L11:
        throw new NullPointerException("rawResponse == null");
    L13:
        throw new NullPointerException("body == null");
    }

    public static f g(Object r10, g6.c r11) {
        if (r11 == null) goto L10;
        if (r11.g() == false) goto L8;
        return new f(r11, r10, null);
    L8:
        throw new IllegalArgumentException("rawResponse must be successful response");
    L10:
        throw new NullPointerException("rawResponse == null");
    }

    public Object a() {
        return this.f19529b;
    }

    public int b() {
        return this.f19528a.e();
    }

    public List d() {
        return this.f19528a.d();
    }

    public g6.c e() {
        return this.f19528a;
    }

    public void f(RetrofitMetrics r10) {
        this.f19531d = r10;
    }
}
