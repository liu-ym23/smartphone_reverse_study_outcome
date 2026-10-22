package xd;

import com.obric.oui.window.bean.WindowSizeClass;
import kotlin.jvm.internal.q;

/* JADX INFO: loaded from: classes4.dex */
public final class f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public WindowSizeClass f25876a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public a f25877b;

    public f(WindowSizeClass r10, a r11) {
        q.g(r10, "windowSizeClass");
        q.g(r11, "pageSize");
        this.f25876a = r10;
        this.f25877b = r11;
    }

    public boolean equals(Object r10) {
        if (this != r10) goto L6;
        return true;
    L6:
        if ((r10 instanceof f) == true) goto L8;
        return false;
    L8:
        f r11 = (f) r10;
        if (this.f25876a == r11.f25876a) goto L12;
        return false;
    L12:
        if (q.b(this.f25877b, r11.f25877b) == true) goto L14;
        return false;
    L14:
        return true;
    }

    public int hashCode() {
        return (this.f25876a.hashCode() * 31) + this.f25877b.hashCode();
    }

    public String toString() {
        return "WindowSizeWithPageSize(windowSizeClass=" + this.f25876a + ", pageSize=" + this.f25877b + ')';
    }
}
