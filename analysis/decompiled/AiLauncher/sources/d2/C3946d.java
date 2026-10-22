package d2;

import com.google.android.datatransport.cct.internal.NetworkConnectionInfo;
import d2.AbstractC3950h;
import java.util.Arrays;

/* renamed from: d2.d, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public final class C3946d extends AbstractC3950h {

    /* renamed from: a, reason: collision with root package name */
    public final long f32077a;

    /* renamed from: b, reason: collision with root package name */
    public final Integer f32078b;

    /* renamed from: c, reason: collision with root package name */
    public final long f32079c;

    /* renamed from: d, reason: collision with root package name */
    public final byte[] f32080d;

    /* renamed from: e, reason: collision with root package name */
    public final String f32081e;

    /* renamed from: f, reason: collision with root package name */
    public final long f32082f;

    /* renamed from: g, reason: collision with root package name */
    public final NetworkConnectionInfo f32083g;

    /* renamed from: d2.d$b */
    public static final class b extends AbstractC3950h.a {

        /* renamed from: a, reason: collision with root package name */
        public Long f32084a;

        /* renamed from: b, reason: collision with root package name */
        public Integer f32085b;

        /* renamed from: c, reason: collision with root package name */
        public Long f32086c;

        /* renamed from: d, reason: collision with root package name */
        public byte[] f32087d;

        /* renamed from: e, reason: collision with root package name */
        public String f32088e;

        /* renamed from: f, reason: collision with root package name */
        public Long f32089f;

        /* renamed from: g, reason: collision with root package name */
        public NetworkConnectionInfo f32090g;

        @Override // d2.AbstractC3950h.a
        public AbstractC3950h a() {
            String str = "";
            if (this.f32084a == null) {
                str = " eventTimeMs";
            }
            if (this.f32086c == null) {
                str = str + " eventUptimeMs";
            }
            if (this.f32089f == null) {
                str = str + " timezoneOffsetSeconds";
            }
            if (str.isEmpty()) {
                return new C3946d(this.f32084a.longValue(), this.f32085b, this.f32086c.longValue(), this.f32087d, this.f32088e, this.f32089f.longValue(), this.f32090g);
            }
            throw new IllegalStateException("Missing required properties:" + str);
        }

        @Override // d2.AbstractC3950h.a
        public AbstractC3950h.a b(Integer num) {
            this.f32085b = num;
            return this;
        }

        @Override // d2.AbstractC3950h.a
        public AbstractC3950h.a c(long j10) {
            this.f32084a = Long.valueOf(j10);
            return this;
        }

        @Override // d2.AbstractC3950h.a
        public AbstractC3950h.a d(long j10) {
            this.f32086c = Long.valueOf(j10);
            return this;
        }

        @Override // d2.AbstractC3950h.a
        public AbstractC3950h.a e(NetworkConnectionInfo networkConnectionInfo) {
            this.f32090g = networkConnectionInfo;
            return this;
        }

        @Override // d2.AbstractC3950h.a
        public AbstractC3950h.a f(byte[] bArr) {
            this.f32087d = bArr;
            return this;
        }

        @Override // d2.AbstractC3950h.a
        public AbstractC3950h.a g(String str) {
            this.f32088e = str;
            return this;
        }

        @Override // d2.AbstractC3950h.a
        public AbstractC3950h.a h(long j10) {
            this.f32089f = Long.valueOf(j10);
            return this;
        }
    }

    @Override // d2.AbstractC3950h
    public Integer b() {
        return this.f32078b;
    }

    @Override // d2.AbstractC3950h
    public long c() {
        return this.f32077a;
    }

    @Override // d2.AbstractC3950h
    public long d() {
        return this.f32079c;
    }

    @Override // d2.AbstractC3950h
    public NetworkConnectionInfo e() {
        return this.f32083g;
    }

    public boolean equals(Object obj) {
        Integer num;
        String str;
        NetworkConnectionInfo networkConnectionInfo;
        if (obj == this) {
            return true;
        }
        if (obj instanceof AbstractC3950h) {
            AbstractC3950h abstractC3950h = (AbstractC3950h) obj;
            if (this.f32077a == abstractC3950h.c() && ((num = this.f32078b) != null ? num.equals(abstractC3950h.b()) : abstractC3950h.b() == null) && this.f32079c == abstractC3950h.d()) {
                if (Arrays.equals(this.f32080d, abstractC3950h instanceof C3946d ? ((C3946d) abstractC3950h).f32080d : abstractC3950h.f()) && ((str = this.f32081e) != null ? str.equals(abstractC3950h.g()) : abstractC3950h.g() == null) && this.f32082f == abstractC3950h.h() && ((networkConnectionInfo = this.f32083g) != null ? networkConnectionInfo.equals(abstractC3950h.e()) : abstractC3950h.e() == null)) {
                    return true;
                }
            }
        }
        return false;
    }

    @Override // d2.AbstractC3950h
    public byte[] f() {
        return this.f32080d;
    }

    @Override // d2.AbstractC3950h
    public String g() {
        return this.f32081e;
    }

    @Override // d2.AbstractC3950h
    public long h() {
        return this.f32082f;
    }

    public int hashCode() {
        long j10 = this.f32077a;
        int i10 = (((int) (j10 ^ (j10 >>> 32))) ^ 1000003) * 1000003;
        Integer num = this.f32078b;
        int iHashCode = num == null ? 0 : num.hashCode();
        long j11 = this.f32079c;
        int iHashCode2 = (((((i10 ^ iHashCode) * 1000003) ^ ((int) (j11 ^ (j11 >>> 32)))) * 1000003) ^ Arrays.hashCode(this.f32080d)) * 1000003;
        String str = this.f32081e;
        int iHashCode3 = str == null ? 0 : str.hashCode();
        long j12 = this.f32082f;
        int i11 = (((iHashCode2 ^ iHashCode3) * 1000003) ^ ((int) ((j12 >>> 32) ^ j12))) * 1000003;
        NetworkConnectionInfo networkConnectionInfo = this.f32083g;
        return i11 ^ (networkConnectionInfo != null ? networkConnectionInfo.hashCode() : 0);
    }

    public String toString() {
        return "LogEvent{eventTimeMs=" + this.f32077a + ", eventCode=" + this.f32078b + ", eventUptimeMs=" + this.f32079c + ", sourceExtension=" + Arrays.toString(this.f32080d) + ", sourceExtensionJsonProto3=" + this.f32081e + ", timezoneOffsetSeconds=" + this.f32082f + ", networkConnectionInfo=" + this.f32083g + "}";
    }

    public C3946d(long j10, Integer num, long j11, byte[] bArr, String str, long j12, NetworkConnectionInfo networkConnectionInfo) {
        this.f32077a = j10;
        this.f32078b = num;
        this.f32079c = j11;
        this.f32080d = bArr;
        this.f32081e = str;
        this.f32082f = j12;
        this.f32083g = networkConnectionInfo;
    }
}
