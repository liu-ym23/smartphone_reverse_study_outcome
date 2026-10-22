package e2;

import e2.AbstractC3981h;
import java.util.Map;

/* renamed from: e2.a, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public final class C3974a extends AbstractC3981h {

    /* renamed from: a, reason: collision with root package name */
    public final String f32228a;

    /* renamed from: b, reason: collision with root package name */
    public final Integer f32229b;

    /* renamed from: c, reason: collision with root package name */
    public final C3980g f32230c;

    /* renamed from: d, reason: collision with root package name */
    public final long f32231d;

    /* renamed from: e, reason: collision with root package name */
    public final long f32232e;

    /* renamed from: f, reason: collision with root package name */
    public final Map<String, String> f32233f;

    /* renamed from: e2.a$b */
    public static final class b extends AbstractC3981h.a {

        /* renamed from: a, reason: collision with root package name */
        public String f32234a;

        /* renamed from: b, reason: collision with root package name */
        public Integer f32235b;

        /* renamed from: c, reason: collision with root package name */
        public C3980g f32236c;

        /* renamed from: d, reason: collision with root package name */
        public Long f32237d;

        /* renamed from: e, reason: collision with root package name */
        public Long f32238e;

        /* renamed from: f, reason: collision with root package name */
        public Map<String, String> f32239f;

        @Override // e2.AbstractC3981h.a
        public AbstractC3981h d() {
            String str = "";
            if (this.f32234a == null) {
                str = " transportName";
            }
            if (this.f32236c == null) {
                str = str + " encodedPayload";
            }
            if (this.f32237d == null) {
                str = str + " eventMillis";
            }
            if (this.f32238e == null) {
                str = str + " uptimeMillis";
            }
            if (this.f32239f == null) {
                str = str + " autoMetadata";
            }
            if (str.isEmpty()) {
                return new C3974a(this.f32234a, this.f32235b, this.f32236c, this.f32237d.longValue(), this.f32238e.longValue(), this.f32239f);
            }
            throw new IllegalStateException("Missing required properties:" + str);
        }

        @Override // e2.AbstractC3981h.a
        public Map<String, String> e() {
            Map<String, String> map = this.f32239f;
            if (map != null) {
                return map;
            }
            throw new IllegalStateException("Property \"autoMetadata\" has not been set");
        }

        @Override // e2.AbstractC3981h.a
        public AbstractC3981h.a f(Map<String, String> map) {
            if (map == null) {
                throw new NullPointerException("Null autoMetadata");
            }
            this.f32239f = map;
            return this;
        }

        @Override // e2.AbstractC3981h.a
        public AbstractC3981h.a g(Integer num) {
            this.f32235b = num;
            return this;
        }

        @Override // e2.AbstractC3981h.a
        public AbstractC3981h.a h(C3980g c3980g) {
            if (c3980g == null) {
                throw new NullPointerException("Null encodedPayload");
            }
            this.f32236c = c3980g;
            return this;
        }

        @Override // e2.AbstractC3981h.a
        public AbstractC3981h.a i(long j10) {
            this.f32237d = Long.valueOf(j10);
            return this;
        }

        @Override // e2.AbstractC3981h.a
        public AbstractC3981h.a j(String str) {
            if (str == null) {
                throw new NullPointerException("Null transportName");
            }
            this.f32234a = str;
            return this;
        }

        @Override // e2.AbstractC3981h.a
        public AbstractC3981h.a k(long j10) {
            this.f32238e = Long.valueOf(j10);
            return this;
        }
    }

    @Override // e2.AbstractC3981h
    public Map<String, String> c() {
        return this.f32233f;
    }

    @Override // e2.AbstractC3981h
    public Integer d() {
        return this.f32229b;
    }

    @Override // e2.AbstractC3981h
    public C3980g e() {
        return this.f32230c;
    }

    public boolean equals(Object obj) {
        Integer num;
        if (obj == this) {
            return true;
        }
        if (obj instanceof AbstractC3981h) {
            AbstractC3981h abstractC3981h = (AbstractC3981h) obj;
            if (this.f32228a.equals(abstractC3981h.j()) && ((num = this.f32229b) != null ? num.equals(abstractC3981h.d()) : abstractC3981h.d() == null) && this.f32230c.equals(abstractC3981h.e()) && this.f32231d == abstractC3981h.f() && this.f32232e == abstractC3981h.k() && this.f32233f.equals(abstractC3981h.c())) {
                return true;
            }
        }
        return false;
    }

    @Override // e2.AbstractC3981h
    public long f() {
        return this.f32231d;
    }

    public int hashCode() {
        int iHashCode = (this.f32228a.hashCode() ^ 1000003) * 1000003;
        Integer num = this.f32229b;
        int iHashCode2 = (((iHashCode ^ (num == null ? 0 : num.hashCode())) * 1000003) ^ this.f32230c.hashCode()) * 1000003;
        long j10 = this.f32231d;
        int i10 = (iHashCode2 ^ ((int) (j10 ^ (j10 >>> 32)))) * 1000003;
        long j11 = this.f32232e;
        return this.f32233f.hashCode() ^ ((i10 ^ ((int) (j11 ^ (j11 >>> 32)))) * 1000003);
    }

    @Override // e2.AbstractC3981h
    public String j() {
        return this.f32228a;
    }

    @Override // e2.AbstractC3981h
    public long k() {
        return this.f32232e;
    }

    public String toString() {
        return "EventInternal{transportName=" + this.f32228a + ", code=" + this.f32229b + ", encodedPayload=" + this.f32230c + ", eventMillis=" + this.f32231d + ", uptimeMillis=" + this.f32232e + ", autoMetadata=" + this.f32233f + "}";
    }

    public C3974a(String str, Integer num, C3980g c3980g, long j10, long j11, Map<String, String> map) {
        this.f32228a = str;
        this.f32229b = num;
        this.f32230c = c3980g;
        this.f32231d = j10;
        this.f32232e = j11;
        this.f32233f = map;
    }
}
