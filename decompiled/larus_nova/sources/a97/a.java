package a97;

import com.bytedance.reparo.core.exception.PatchException;

/* JADX INFO: loaded from: classes21.dex */
public class a {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final a f2281b = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final a f2282a;

    public void b(PatchException r100) {
    }

    public void c() {
    }

    static {
        f2281b = new a();
    }

    public void d() {
        c();
        a r100 = this.f2282a;
        if (r100 == null) goto L6;
        r100.d();
        return;
    }

    public a() {
    }

    public a(a r100) {
        this.f2282a = r100;
    }

    public final void a(PatchException r100) {
        b(r100);
        a r101 = this.f2282a;
        if (r101 == null) goto L6;
        r101.a(r100);
        return;
    }
}
