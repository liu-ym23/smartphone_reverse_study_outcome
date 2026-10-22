package q9;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes3.dex */
public class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public String f23568a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public String f23569b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public String f23570c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public List f23571d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public float f23572e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public int f23573f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public int f23574g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public boolean f23575h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public int f23576i;

    public a(String r10, String r11, String r12) {
        this.f23574g = 3;
        this.f23576i = 0;
        this.f23568a = r10;
        this.f23569b = r11;
        this.f23570c = r12;
        this.f23573f = 0;
        this.f23571d = new ArrayList();
    }

    public void a(c r10) {
        this.f23571d.add(r10);
    }

    public long b() {
        Iterator r10 = this.f23571d.iterator();
        long r11 = 0;
    L4:
        if (r10.hasNext() == false) goto L6;
        r11 = (long) (r11 + ((c) r10.next()).b());
        goto L4
    L6:
        return r11;
    }

    public int c() {
        return this.f23573f;
    }

    public float d() {
        return this.f23572e;
    }

    public int e(long r10) {
        Iterator r11 = this.f23571d.iterator();
        long r12 = 0;
        int r13 = 0;
    L4:
        if (r11.hasNext() == false) goto L11;
        c r14 = (c) r11.next();
        if (r10 < r12) goto L10;
        if (r10 >= (r12 + r14.b())) goto L10;
        return r13;
    L10:
        r12 = (long) (r12 + r14.b());
        r13 = r13 + 1;
        goto L4
    L11:
        return 0;
    }

    public boolean equals(Object r10) {
        if ((r10 instanceof a) == false) goto L10;
        a r11 = (a) r10;
        String r12 = this.f23568a;
        if (r12 != null) goto L7;
        return false;
    L7:
        if (r12.equals(r11.f23568a) == false) goto L13;
        return true;
    L13:
        return false;
    L10:
        return false;
    }

    public List f() {
        return this.f23571d;
    }

    public int g() {
        return this.f23574g;
    }

    public boolean h() {
        return this.f23575h;
    }

    public void i(int r10) {
        this.f23576i = r10;
    }

    public void j(boolean r10) {
        this.f23575h = r10;
    }

    public void k(int r10) {
        this.f23573f = r10;
    }

    public void l(float r10) {
        this.f23572e = r10;
    }

    public void m(int r10) {
        this.f23574g = r10;
    }
}
