package fa;

import android.content.Context;
import android.text.TextUtils;
import com.obric.capabilitykit.common.UiType;

/* JADX INFO: loaded from: classes3.dex */
public class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Context f19591a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f19592b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f19593c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f19594d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public String f19595e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public String f19596f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public boolean f19597g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public boolean f19598h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public int f19599i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public String f19600j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public boolean f19601k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public boolean f19602l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public boolean f19603m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public boolean f19604n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public boolean f19605o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public int f19606p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public float f19607q;

    public static /* synthetic */ class a {
    }

    /* JADX INFO: renamed from: fa.b$b, reason: collision with other inner class name */
    public static class C0251b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public Context f19608a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public int f19609b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public int f19610c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public float f19611d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public int f19612e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public String f19613f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public String f19614g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public boolean f19615h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public boolean f19616i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        public int f19617j;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        public String f19618k;

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        public boolean f19619l;

        /* JADX INFO: renamed from: m, reason: collision with root package name */
        public boolean f19620m;

        /* JADX INFO: renamed from: n, reason: collision with root package name */
        public boolean f19621n;

        /* JADX INFO: renamed from: o, reason: collision with root package name */
        public boolean f19622o;

        /* JADX INFO: renamed from: p, reason: collision with root package name */
        public boolean f19623p;

        /* JADX INFO: renamed from: q, reason: collision with root package name */
        public int f19624q;

        public C0251b(Context r10) {
            this.f19609b = 14;
            this.f19610c = 20971520;
            this.f19611d = 0.1f;
            this.f19612e = UiType.FLAG_REMOTE_CARD;
            this.f19615h = true;
            this.f19616i = true;
            this.f19617j = 3;
            this.f19618k = "fecbb32b759120b672045f74edc41d159b6a426ffc863b9e0be9ad4be12824546f549959b838993a430344f15197221e87bd362298814c75f5068148b980306f";
            this.f19619l = true;
            this.f19620m = false;
            this.f19621n = false;
            this.f19622o = false;
            this.f19623p = false;
            this.f19624q = 256;
            if (r10 == null) goto L10;
            Context r11 = r10.getApplicationContext();
            if (r11 == null) goto L7;
            r10 = r11;
        L7:
            this.f19608a = r10;
            return;
        L10:
            throw new RuntimeException("context must not be null");
        }

        public b a() {
            b r10 = new b(null);
            r10.u(this.f19608a);
            r10.A(this.f19609b);
            r10.C(this.f19610c);
            r10.H(this.f19611d);
            r10.F(this.f19612e);
            if (TextUtils.isEmpty(this.f19613f) == false) goto L5;
            String r11 = na.a.a(this.f19608a);
        L6:
            r10.r(r11);
            if (TextUtils.isEmpty(this.f19614g) == false) goto L9;
            String r12 = na.a.b(this.f19608a).getAbsolutePath();
        L10:
            r10.z(r12);
            r10.t(this.f19615h);
            r10.x(this.f19616i);
            r10.y(this.f19617j);
            r10.G(this.f19618k);
            r10.B(this.f19619l);
            r10.E(this.f19620m);
            r10.v(this.f19621n);
            r10.w(this.f19623p);
            r10.D(this.f19622o);
            r10.s(this.f19624q);
            return r10;
        L9:
            r12 = this.f19614g;
            goto L10
        L5:
            r11 = this.f19613f;
            goto L6
        }

        public C0251b b(boolean r10) {
            this.f19615h = r10;
            return this;
        }

        public C0251b c(boolean r10) {
            this.f19616i = r10;
            return this;
        }

        public C0251b d(int r10) {
            this.f19617j = r10;
            return this;
        }

        public C0251b e(String r10) {
            this.f19614g = r10;
            return this;
        }

        public C0251b f(int r10) {
            this.f19609b = r10;
            return this;
        }

        public C0251b g(int r10) {
            this.f19610c = r10;
            return this;
        }

        public C0251b h(boolean r10) {
            this.f19620m = r10;
            return this;
        }
    }

    public /* synthetic */ b(a r10) {
        this();
    }

    public void A(int r10) {
        this.f19592b = r10;
    }

    public void B(boolean r10) {
        this.f19601k = r10;
    }

    public void C(int r10) {
        this.f19593c = r10;
    }

    public void D(boolean r10) {
        this.f19604n = r10;
    }

    public void E(boolean r10) {
        this.f19602l = r10;
    }

    public void F(int r10) {
        this.f19594d = r10;
    }

    public void G(String r10) {
        this.f19600j = r10;
    }

    public void H(float r10) {
        this.f19607q = r10;
    }

    public boolean a() {
        return this.f19603m;
    }

    public boolean b() {
        return this.f19605o;
    }

    public String c() {
        return this.f19595e;
    }

    public int d() {
        return this.f19606p;
    }

    public Context e() {
        return this.f19591a;
    }

    public int f() {
        return this.f19599i;
    }

    public String g() {
        return this.f19596f;
    }

    public int h() {
        return this.f19592b;
    }

    public int i() {
        return this.f19593c;
    }

    public int j() {
        return this.f19594d;
    }

    public String k() {
        return this.f19600j;
    }

    public float l() {
        return this.f19607q;
    }

    public boolean m() {
        return this.f19597g;
    }

    public boolean n() {
        return this.f19598h;
    }

    public boolean o() {
        return this.f19601k;
    }

    public boolean p() {
        return this.f19604n;
    }

    public boolean q() {
        return this.f19602l;
    }

    public void r(String r10) {
        this.f19595e = r10;
    }

    public void s(int r10) {
        this.f19606p = r10;
    }

    public void t(boolean r10) {
        this.f19597g = r10;
    }

    public void u(Context r10) {
        this.f19591a = r10;
    }

    public void v(boolean r10) {
        this.f19603m = r10;
    }

    public void w(boolean r10) {
        this.f19605o = r10;
    }

    public void x(boolean r10) {
        this.f19598h = r10;
    }

    public void y(int r10) {
        this.f19599i = r10;
    }

    public void z(String r10) {
        this.f19596f = r10;
    }

    public b() {
    }
}
