package l2;

import e2.AbstractC3981h;

/* renamed from: l2.b, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public final class C4862b extends AbstractC4869i {

    /* renamed from: a, reason: collision with root package name */
    public final long f36913a;

    /* renamed from: b, reason: collision with root package name */
    public final e2.m f36914b;

    /* renamed from: c, reason: collision with root package name */
    public final AbstractC3981h f36915c;

    public C4862b(long j10, e2.m mVar, AbstractC3981h abstractC3981h) {
        this.f36913a = j10;
        if (mVar == null) {
            throw new NullPointerException("Null transportContext");
        }
        this.f36914b = mVar;
        if (abstractC3981h == null) {
            throw new NullPointerException("Null event");
        }
        this.f36915c = abstractC3981h;
    }

    @Override // l2.AbstractC4869i
    public AbstractC3981h b() {
        return this.f36915c;
    }

    @Override // l2.AbstractC4869i
    public long c() {
        return this.f36913a;
    }

    @Override // l2.AbstractC4869i
    public e2.m d() {
        return this.f36914b;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof AbstractC4869i) {
            AbstractC4869i abstractC4869i = (AbstractC4869i) obj;
            if (this.f36913a == abstractC4869i.c() && this.f36914b.equals(abstractC4869i.d()) && this.f36915c.equals(abstractC4869i.b())) {
                return true;
            }
        }
        return false;
    }

    public int hashCode() {
        long j10 = this.f36913a;
        return this.f36915c.hashCode() ^ ((((((int) (j10 ^ (j10 >>> 32))) ^ 1000003) * 1000003) ^ this.f36914b.hashCode()) * 1000003);
    }

    public String toString() {
        return "PersistedEvent{id=" + this.f36913a + ", transportContext=" + this.f36914b + ", event=" + this.f36915c + "}";
    }
}
