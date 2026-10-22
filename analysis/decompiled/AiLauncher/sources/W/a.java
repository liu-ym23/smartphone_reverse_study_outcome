package W;

import W.d;

/* loaded from: classes.dex */
public final class a extends d {

    /* renamed from: a, reason: collision with root package name */
    public final String f6564a;

    /* renamed from: b, reason: collision with root package name */
    public final String f6565b;

    /* renamed from: c, reason: collision with root package name */
    public final String f6566c;

    /* renamed from: d, reason: collision with root package name */
    public final String f6567d;

    public static final class b extends d.a {

        /* renamed from: a, reason: collision with root package name */
        public String f6568a;

        /* renamed from: b, reason: collision with root package name */
        public String f6569b;

        /* renamed from: c, reason: collision with root package name */
        public String f6570c;

        /* renamed from: d, reason: collision with root package name */
        public String f6571d;

        @Override // W.d.a
        public d a() {
            String str = "";
            if (this.f6568a == null) {
                str = " glVersion";
            }
            if (this.f6569b == null) {
                str = str + " eglVersion";
            }
            if (this.f6570c == null) {
                str = str + " glExtensions";
            }
            if (this.f6571d == null) {
                str = str + " eglExtensions";
            }
            if (str.isEmpty()) {
                return new a(this.f6568a, this.f6569b, this.f6570c, this.f6571d);
            }
            throw new IllegalStateException("Missing required properties:" + str);
        }

        @Override // W.d.a
        public d.a b(String str) {
            if (str == null) {
                throw new NullPointerException("Null eglExtensions");
            }
            this.f6571d = str;
            return this;
        }

        @Override // W.d.a
        public d.a c(String str) {
            if (str == null) {
                throw new NullPointerException("Null eglVersion");
            }
            this.f6569b = str;
            return this;
        }

        @Override // W.d.a
        public d.a d(String str) {
            if (str == null) {
                throw new NullPointerException("Null glExtensions");
            }
            this.f6570c = str;
            return this;
        }

        @Override // W.d.a
        public d.a e(String str) {
            if (str == null) {
                throw new NullPointerException("Null glVersion");
            }
            this.f6568a = str;
            return this;
        }
    }

    @Override // W.d
    public String b() {
        return this.f6567d;
    }

    @Override // W.d
    public String c() {
        return this.f6565b;
    }

    @Override // W.d
    public String d() {
        return this.f6566c;
    }

    @Override // W.d
    public String e() {
        return this.f6564a;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof d) {
            d dVar = (d) obj;
            if (this.f6564a.equals(dVar.e()) && this.f6565b.equals(dVar.c()) && this.f6566c.equals(dVar.d()) && this.f6567d.equals(dVar.b())) {
                return true;
            }
        }
        return false;
    }

    public int hashCode() {
        return this.f6567d.hashCode() ^ ((((((this.f6564a.hashCode() ^ 1000003) * 1000003) ^ this.f6565b.hashCode()) * 1000003) ^ this.f6566c.hashCode()) * 1000003);
    }

    public String toString() {
        return "GraphicDeviceInfo{glVersion=" + this.f6564a + ", eglVersion=" + this.f6565b + ", glExtensions=" + this.f6566c + ", eglExtensions=" + this.f6567d + "}";
    }

    public a(String str, String str2, String str3, String str4) {
        this.f6564a = str;
        this.f6565b = str2;
        this.f6566c = str3;
        this.f6567d = str4;
    }
}
