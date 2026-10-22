package l0;

import java.io.Closeable;

/* loaded from: classes.dex */
public abstract class k implements Cloneable, Closeable {

    /* renamed from: a, reason: collision with root package name */
    protected boolean f18126a;

    /* renamed from: c, reason: collision with root package name */
    protected char f18128c;

    /* renamed from: d, reason: collision with root package name */
    protected a f18129d;

    /* renamed from: e, reason: collision with root package name */
    private Boolean f18130e;

    /* renamed from: b, reason: collision with root package name */
    protected int f18127b = -1;

    /* renamed from: f, reason: collision with root package name */
    protected int f18131f = 0;

    /* renamed from: g, reason: collision with root package name */
    protected boolean f18132g = false;

    public enum a {
        Object,
        Array,
        Value
    }

    static class b extends k {

        /* renamed from: h, reason: collision with root package name */
        private final String f18137h;

        public b(String str) {
            this.f18137h = str;
            A();
            C();
        }

        @Override // l0.k
        void A() {
            int i5 = this.f18127b + 1;
            this.f18127b = i5;
            if (i5 < this.f18137h.length()) {
                this.f18128c = this.f18137h.charAt(this.f18127b);
            } else {
                this.f18128c = (char) 0;
                this.f18126a = true;
            }
        }

        @Override // l0.k
        protected final void v() {
            char cCharAt;
            int i5 = this.f18127b;
            do {
                i5++;
                if (i5 >= this.f18137h.length() || (cCharAt = this.f18137h.charAt(i5)) == '\\') {
                    A();
                    while (true) {
                        char c6 = this.f18128c;
                        if (c6 == '\\') {
                            A();
                            if (this.f18128c == 'u') {
                                A();
                                A();
                                A();
                                A();
                                A();
                            } else {
                                A();
                            }
                        } else if (c6 == '\"') {
                            A();
                            return;
                        } else if (this.f18126a) {
                            return;
                        } else {
                            A();
                        }
                    }
                }
            } while (cCharAt != '\"');
            int i6 = i5 + 1;
            this.f18128c = this.f18137h.charAt(i6);
            this.f18127b = i6;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:130:0x0183  */
    /* JADX WARN: Removed duplicated region for block: B:181:? A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private boolean u() {
        /*
            Method dump skipped, instructions count: 532
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: l0.k.u():boolean");
    }

    public static k w(String str) {
        return new b(str);
    }

    static final boolean x(char c6) {
        return c6 == ' ' || c6 == '\t' || c6 == '\r' || c6 == '\n' || c6 == '\f' || c6 == '\b';
    }

    abstract void A();

    void C() {
        while (x(this.f18128c)) {
            A();
        }
    }

    public boolean D() {
        Boolean bool = this.f18130e;
        if (bool != null) {
            return bool.booleanValue();
        }
        while (u()) {
            C();
            this.f18131f++;
            if (this.f18126a) {
                this.f18130e = Boolean.TRUE;
                return true;
            }
            if (!this.f18132g) {
                this.f18130e = Boolean.FALSE;
                return false;
            }
            C();
            if (this.f18126a) {
                this.f18130e = Boolean.TRUE;
                return true;
            }
        }
        this.f18130e = Boolean.FALSE;
        return false;
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() {
    }

    protected abstract void v();
}
