package androidx.camera.core.impl;

import D.B;
import android.util.Range;
import android.util.Size;
import androidx.camera.core.impl.y;

/* loaded from: classes.dex */
public final class f extends y {

    /* renamed from: b, reason: collision with root package name */
    public final Size f11400b;

    /* renamed from: c, reason: collision with root package name */
    public final Size f11401c;

    /* renamed from: d, reason: collision with root package name */
    public final B f11402d;

    /* renamed from: e, reason: collision with root package name */
    public final int f11403e;

    /* renamed from: f, reason: collision with root package name */
    public final Range<Integer> f11404f;

    /* renamed from: g, reason: collision with root package name */
    public final Config f11405g;

    /* renamed from: h, reason: collision with root package name */
    public final boolean f11406h;

    public static final class b extends y.a {

        /* renamed from: a, reason: collision with root package name */
        public Size f11407a;

        /* renamed from: b, reason: collision with root package name */
        public Size f11408b;

        /* renamed from: c, reason: collision with root package name */
        public B f11409c;

        /* renamed from: d, reason: collision with root package name */
        public Integer f11410d;

        /* renamed from: e, reason: collision with root package name */
        public Range<Integer> f11411e;

        /* renamed from: f, reason: collision with root package name */
        public Config f11412f;

        /* renamed from: g, reason: collision with root package name */
        public Boolean f11413g;

        @Override // androidx.camera.core.impl.y.a
        public y a() {
            String str = "";
            if (this.f11407a == null) {
                str = " resolution";
            }
            if (this.f11408b == null) {
                str = str + " originalConfiguredResolution";
            }
            if (this.f11409c == null) {
                str = str + " dynamicRange";
            }
            if (this.f11410d == null) {
                str = str + " sessionType";
            }
            if (this.f11411e == null) {
                str = str + " expectedFrameRateRange";
            }
            if (this.f11413g == null) {
                str = str + " zslDisabled";
            }
            if (str.isEmpty()) {
                return new f(this.f11407a, this.f11408b, this.f11409c, this.f11410d.intValue(), this.f11411e, this.f11412f, this.f11413g.booleanValue());
            }
            throw new IllegalStateException("Missing required properties:" + str);
        }

        @Override // androidx.camera.core.impl.y.a
        public y.a b(B b10) {
            if (b10 == null) {
                throw new NullPointerException("Null dynamicRange");
            }
            this.f11409c = b10;
            return this;
        }

        @Override // androidx.camera.core.impl.y.a
        public y.a c(Range<Integer> range) {
            if (range == null) {
                throw new NullPointerException("Null expectedFrameRateRange");
            }
            this.f11411e = range;
            return this;
        }

        @Override // androidx.camera.core.impl.y.a
        public y.a d(Config config) {
            this.f11412f = config;
            return this;
        }

        @Override // androidx.camera.core.impl.y.a
        public y.a e(Size size) {
            if (size == null) {
                throw new NullPointerException("Null originalConfiguredResolution");
            }
            this.f11408b = size;
            return this;
        }

        @Override // androidx.camera.core.impl.y.a
        public y.a f(Size size) {
            if (size == null) {
                throw new NullPointerException("Null resolution");
            }
            this.f11407a = size;
            return this;
        }

        @Override // androidx.camera.core.impl.y.a
        public y.a g(int i10) {
            this.f11410d = Integer.valueOf(i10);
            return this;
        }

        @Override // androidx.camera.core.impl.y.a
        public y.a h(boolean z10) {
            this.f11413g = Boolean.valueOf(z10);
            return this;
        }

        public b() {
        }

        public b(y yVar) {
            this.f11407a = yVar.f();
            this.f11408b = yVar.e();
            this.f11409c = yVar.b();
            this.f11410d = Integer.valueOf(yVar.g());
            this.f11411e = yVar.c();
            this.f11412f = yVar.d();
            this.f11413g = Boolean.valueOf(yVar.h());
        }
    }

    @Override // androidx.camera.core.impl.y
    public B b() {
        return this.f11402d;
    }

    @Override // androidx.camera.core.impl.y
    public Range<Integer> c() {
        return this.f11404f;
    }

    @Override // androidx.camera.core.impl.y
    public Config d() {
        return this.f11405g;
    }

    @Override // androidx.camera.core.impl.y
    public Size e() {
        return this.f11401c;
    }

    public boolean equals(Object obj) {
        Config config;
        if (obj == this) {
            return true;
        }
        if (obj instanceof y) {
            y yVar = (y) obj;
            if (this.f11400b.equals(yVar.f()) && this.f11401c.equals(yVar.e()) && this.f11402d.equals(yVar.b()) && this.f11403e == yVar.g() && this.f11404f.equals(yVar.c()) && ((config = this.f11405g) != null ? config.equals(yVar.d()) : yVar.d() == null) && this.f11406h == yVar.h()) {
                return true;
            }
        }
        return false;
    }

    @Override // androidx.camera.core.impl.y
    public Size f() {
        return this.f11400b;
    }

    @Override // androidx.camera.core.impl.y
    public int g() {
        return this.f11403e;
    }

    @Override // androidx.camera.core.impl.y
    public boolean h() {
        return this.f11406h;
    }

    public int hashCode() {
        int iHashCode = (((((((((this.f11400b.hashCode() ^ 1000003) * 1000003) ^ this.f11401c.hashCode()) * 1000003) ^ this.f11402d.hashCode()) * 1000003) ^ this.f11403e) * 1000003) ^ this.f11404f.hashCode()) * 1000003;
        Config config = this.f11405g;
        return (this.f11406h ? 1231 : 1237) ^ ((iHashCode ^ (config == null ? 0 : config.hashCode())) * 1000003);
    }

    @Override // androidx.camera.core.impl.y
    public y.a i() {
        return new b(this);
    }

    public String toString() {
        return "StreamSpec{resolution=" + this.f11400b + ", originalConfiguredResolution=" + this.f11401c + ", dynamicRange=" + this.f11402d + ", sessionType=" + this.f11403e + ", expectedFrameRateRange=" + this.f11404f + ", implementationOptions=" + this.f11405g + ", zslDisabled=" + this.f11406h + "}";
    }

    public f(Size size, Size size2, B b10, int i10, Range<Integer> range, Config config, boolean z10) {
        this.f11400b = size;
        this.f11401c = size2;
        this.f11402d = b10;
        this.f11403e = i10;
        this.f11404f = range;
        this.f11405g = config;
        this.f11406h = z10;
    }
}
