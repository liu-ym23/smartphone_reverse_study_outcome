package re;

import android.content.Context;
import android.text.TextUtils;
import com.obric.capabilitykit.common.UiType;

/* JADX INFO: loaded from: classes4.dex */
public class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Context f23935a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f23936b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f23937c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f23938d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public String f23939e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public String f23940f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public boolean f23941g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public boolean f23942h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public int f23943i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public String f23944j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public boolean f23945k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public boolean f23946l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public boolean f23947m;

    public static /* synthetic */ class a {
    }

    /* JADX INFO: renamed from: re.b$b, reason: collision with other inner class name */
    public static class C0354b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public Context f23948a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public int f23949b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public int f23950c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public int f23951d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public String f23952e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public String f23953f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public boolean f23954g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public boolean f23955h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public int f23956i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        public String f23957j;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        public boolean f23958k;

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        public boolean f23959l;

        /* JADX INFO: renamed from: m, reason: collision with root package name */
        public boolean f23960m;

        public C0354b(Context r10) {
            this.f23949b = 14;
            this.f23950c = 20971520;
            this.f23951d = UiType.FLAG_REMOTE_CARD;
            this.f23954g = true;
            this.f23955h = true;
            this.f23956i = 3;
            this.f23957j = "fecbb32b759120b672045f74edc41d159b6a426ffc863b9e0be9ad4be12824546f549959b838993a430344f15197221e87bd362298814c75f5068148b980306f";
            this.f23958k = true;
            this.f23959l = false;
            this.f23960m = false;
            if (r10 == null) goto L10;
            Context r11 = r10.getApplicationContext();
            if (r11 == null) goto L7;
            r10 = r11;
        L7:
            this.f23948a = r10;
            return;
        L10:
            throw new RuntimeException("context must not be null");
        }

        public b a() {
            b r10 = new b(null);
            r10.p(this.f23948a);
            r10.u(this.f23949b);
            r10.w(this.f23950c);
            r10.y(this.f23951d);
            if (TextUtils.isEmpty(this.f23952e) == false) goto L5;
            String r11 = ze.a.a(this.f23948a);
        L6:
            r10.n(r11);
            if (TextUtils.isEmpty(this.f23953f) == false) goto L9;
            String r12 = ze.a.b(this.f23948a).getAbsolutePath();
        L10:
            r10.t(r12);
            r10.o(this.f23954g);
            r10.r(this.f23955h);
            r10.s(this.f23956i);
            r10.z(this.f23957j);
            r10.v(this.f23958k);
            r10.x(this.f23959l);
            r10.q(this.f23960m);
            return r10;
        L9:
            r12 = this.f23953f;
            goto L10
        L5:
            r11 = this.f23952e;
            goto L6
        }

        public C0354b b(boolean r10) {
            this.f23954g = r10;
            return this;
        }

        public C0354b c(boolean r10) {
            this.f23955h = r10;
            return this;
        }

        public C0354b d(int r10) {
            this.f23950c = r10;
            return this;
        }

        public C0354b e(int r10) {
            this.f23951d = r10;
            return this;
        }
    }

    public /* synthetic */ b(a r10) {
        this();
    }

    public boolean a() {
        return this.f23947m;
    }

    public String b() {
        return this.f23939e;
    }

    public Context c() {
        return this.f23935a;
    }

    public int d() {
        return this.f23943i;
    }

    public String e() {
        return this.f23940f;
    }

    public int f() {
        return this.f23936b;
    }

    public int g() {
        return this.f23937c;
    }

    public int h() {
        return this.f23938d;
    }

    public String i() {
        return this.f23944j;
    }

    public boolean j() {
        return this.f23941g;
    }

    public boolean k() {
        return this.f23942h;
    }

    public boolean l() {
        return this.f23945k;
    }

    public boolean m() {
        return this.f23946l;
    }

    public void n(String r10) {
        this.f23939e = r10;
    }

    public void o(boolean r10) {
        this.f23941g = r10;
    }

    public void p(Context r10) {
        this.f23935a = r10;
    }

    public void q(boolean r10) {
        this.f23947m = r10;
    }

    public void r(boolean r10) {
        this.f23942h = r10;
    }

    public void s(int r10) {
        this.f23943i = r10;
    }

    public void t(String r10) {
        this.f23940f = r10;
    }

    public void u(int r10) {
        this.f23936b = r10;
    }

    public void v(boolean r10) {
        this.f23945k = r10;
    }

    public void w(int r10) {
        this.f23937c = r10;
    }

    public void x(boolean r10) {
        this.f23946l = r10;
    }

    public void y(int r10) {
        this.f23938d = r10;
    }

    public void z(String r10) {
        this.f23944j = r10;
    }

    public b() {
    }
}
