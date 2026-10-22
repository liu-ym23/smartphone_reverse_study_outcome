package n0;

import org.libpag.BuildConfig;

/* loaded from: classes.dex */
public class g {

    /* renamed from: a, reason: collision with root package name */
    private final int f18880a;

    /* renamed from: b, reason: collision with root package name */
    private final int f18881b;

    /* renamed from: e, reason: collision with root package name */
    protected boolean f18884e;

    /* renamed from: d, reason: collision with root package name */
    private final StringBuilder f18883d = new StringBuilder();

    /* renamed from: c, reason: collision with root package name */
    private int f18882c = 0;

    protected g(int i5, int i6) {
        this.f18881b = i5;
        this.f18880a = i6;
        this.f18884e = i6 == 0;
    }

    protected String a() {
        return this.f18883d.length() != 0 ? this.f18883d.substring(1) : BuildConfig.FLAVOR;
    }

    protected void b(String str, int i5) {
        int i6 = this.f18881b;
        if (i5 < i6 || i5 >= i6 + this.f18880a) {
            return;
        }
        if (!str.equals("arg" + this.f18882c)) {
            this.f18884e = true;
        }
        this.f18883d.append(',');
        this.f18883d.append(str);
        this.f18882c++;
    }
}
