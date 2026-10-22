package f2;

import e2.AbstractC3981h;
import f2.AbstractC4050e;
import java.util.Arrays;

/* renamed from: f2.a, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public final class C4046a extends AbstractC4050e {

    /* renamed from: a, reason: collision with root package name */
    public final Iterable<AbstractC3981h> f32530a;

    /* renamed from: b, reason: collision with root package name */
    public final byte[] f32531b;

    /* renamed from: f2.a$b */
    public static final class b extends AbstractC4050e.a {

        /* renamed from: a, reason: collision with root package name */
        public Iterable<AbstractC3981h> f32532a;

        /* renamed from: b, reason: collision with root package name */
        public byte[] f32533b;

        @Override // f2.AbstractC4050e.a
        public AbstractC4050e a() {
            String str = "";
            if (this.f32532a == null) {
                str = " events";
            }
            if (str.isEmpty()) {
                return new C4046a(this.f32532a, this.f32533b);
            }
            throw new IllegalStateException("Missing required properties:" + str);
        }

        @Override // f2.AbstractC4050e.a
        public AbstractC4050e.a b(Iterable<AbstractC3981h> iterable) {
            if (iterable == null) {
                throw new NullPointerException("Null events");
            }
            this.f32532a = iterable;
            return this;
        }

        @Override // f2.AbstractC4050e.a
        public AbstractC4050e.a c(byte[] bArr) {
            this.f32533b = bArr;
            return this;
        }
    }

    @Override // f2.AbstractC4050e
    public Iterable<AbstractC3981h> b() {
        return this.f32530a;
    }

    @Override // f2.AbstractC4050e
    public byte[] c() {
        return this.f32531b;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof AbstractC4050e) {
            AbstractC4050e abstractC4050e = (AbstractC4050e) obj;
            if (this.f32530a.equals(abstractC4050e.b())) {
                if (Arrays.equals(this.f32531b, abstractC4050e instanceof C4046a ? ((C4046a) abstractC4050e).f32531b : abstractC4050e.c())) {
                    return true;
                }
            }
        }
        return false;
    }

    public int hashCode() {
        return Arrays.hashCode(this.f32531b) ^ ((this.f32530a.hashCode() ^ 1000003) * 1000003);
    }

    public String toString() {
        return "BackendRequest{events=" + this.f32530a + ", extras=" + Arrays.toString(this.f32531b) + "}";
    }

    public C4046a(Iterable<AbstractC3981h> iterable, byte[] bArr) {
        this.f32530a = iterable;
        this.f32531b = bArr;
    }
}
