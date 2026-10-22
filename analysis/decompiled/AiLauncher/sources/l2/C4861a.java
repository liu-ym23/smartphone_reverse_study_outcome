package l2;

import l2.AbstractC4864d;

/* renamed from: l2.a, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public final class C4861a extends AbstractC4864d {

    /* renamed from: b, reason: collision with root package name */
    public final long f36903b;

    /* renamed from: c, reason: collision with root package name */
    public final int f36904c;

    /* renamed from: d, reason: collision with root package name */
    public final int f36905d;

    /* renamed from: e, reason: collision with root package name */
    public final long f36906e;

    /* renamed from: f, reason: collision with root package name */
    public final int f36907f;

    /* renamed from: l2.a$b */
    public static final class b extends AbstractC4864d.a {

        /* renamed from: a, reason: collision with root package name */
        public Long f36908a;

        /* renamed from: b, reason: collision with root package name */
        public Integer f36909b;

        /* renamed from: c, reason: collision with root package name */
        public Integer f36910c;

        /* renamed from: d, reason: collision with root package name */
        public Long f36911d;

        /* renamed from: e, reason: collision with root package name */
        public Integer f36912e;

        @Override // l2.AbstractC4864d.a
        public AbstractC4864d a() {
            String str = "";
            if (this.f36908a == null) {
                str = " maxStorageSizeInBytes";
            }
            if (this.f36909b == null) {
                str = str + " loadBatchSize";
            }
            if (this.f36910c == null) {
                str = str + " criticalSectionEnterTimeoutMs";
            }
            if (this.f36911d == null) {
                str = str + " eventCleanUpAge";
            }
            if (this.f36912e == null) {
                str = str + " maxBlobByteSizePerRow";
            }
            if (str.isEmpty()) {
                return new C4861a(this.f36908a.longValue(), this.f36909b.intValue(), this.f36910c.intValue(), this.f36911d.longValue(), this.f36912e.intValue());
            }
            throw new IllegalStateException("Missing required properties:" + str);
        }

        @Override // l2.AbstractC4864d.a
        public AbstractC4864d.a b(int i10) {
            this.f36910c = Integer.valueOf(i10);
            return this;
        }

        @Override // l2.AbstractC4864d.a
        public AbstractC4864d.a c(long j10) {
            this.f36911d = Long.valueOf(j10);
            return this;
        }

        @Override // l2.AbstractC4864d.a
        public AbstractC4864d.a d(int i10) {
            this.f36909b = Integer.valueOf(i10);
            return this;
        }

        @Override // l2.AbstractC4864d.a
        public AbstractC4864d.a e(int i10) {
            this.f36912e = Integer.valueOf(i10);
            return this;
        }

        @Override // l2.AbstractC4864d.a
        public AbstractC4864d.a f(long j10) {
            this.f36908a = Long.valueOf(j10);
            return this;
        }
    }

    @Override // l2.AbstractC4864d
    public int b() {
        return this.f36905d;
    }

    @Override // l2.AbstractC4864d
    public long c() {
        return this.f36906e;
    }

    @Override // l2.AbstractC4864d
    public int d() {
        return this.f36904c;
    }

    @Override // l2.AbstractC4864d
    public int e() {
        return this.f36907f;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof AbstractC4864d) {
            AbstractC4864d abstractC4864d = (AbstractC4864d) obj;
            if (this.f36903b == abstractC4864d.f() && this.f36904c == abstractC4864d.d() && this.f36905d == abstractC4864d.b() && this.f36906e == abstractC4864d.c() && this.f36907f == abstractC4864d.e()) {
                return true;
            }
        }
        return false;
    }

    @Override // l2.AbstractC4864d
    public long f() {
        return this.f36903b;
    }

    public int hashCode() {
        long j10 = this.f36903b;
        int i10 = (((((((int) (j10 ^ (j10 >>> 32))) ^ 1000003) * 1000003) ^ this.f36904c) * 1000003) ^ this.f36905d) * 1000003;
        long j11 = this.f36906e;
        return this.f36907f ^ ((i10 ^ ((int) ((j11 >>> 32) ^ j11))) * 1000003);
    }

    public String toString() {
        return "EventStoreConfig{maxStorageSizeInBytes=" + this.f36903b + ", loadBatchSize=" + this.f36904c + ", criticalSectionEnterTimeoutMs=" + this.f36905d + ", eventCleanUpAge=" + this.f36906e + ", maxBlobByteSizePerRow=" + this.f36907f + "}";
    }

    public C4861a(long j10, int i10, int i11, long j11, int i12) {
        this.f36903b = j10;
        this.f36904c = i10;
        this.f36905d = i11;
        this.f36906e = j11;
        this.f36907f = i12;
    }
}
