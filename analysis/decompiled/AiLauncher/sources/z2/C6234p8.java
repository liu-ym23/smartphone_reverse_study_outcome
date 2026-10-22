package z2;

/* renamed from: z2.p8, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public final class C6234p8 extends AbstractC6274t8 {

    /* renamed from: a, reason: collision with root package name */
    public final String f45089a;

    /* renamed from: b, reason: collision with root package name */
    public final boolean f45090b;

    /* renamed from: c, reason: collision with root package name */
    public final int f45091c;

    public /* synthetic */ C6234p8(String str, boolean z10, int i10, C6224o8 c6224o8) {
        this.f45089a = str;
        this.f45090b = z10;
        this.f45091c = i10;
    }

    @Override // z2.AbstractC6274t8
    public final int a() {
        return this.f45091c;
    }

    @Override // z2.AbstractC6274t8
    public final String b() {
        return this.f45089a;
    }

    @Override // z2.AbstractC6274t8
    public final boolean c() {
        return this.f45090b;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof AbstractC6274t8) {
            AbstractC6274t8 abstractC6274t8 = (AbstractC6274t8) obj;
            if (this.f45089a.equals(abstractC6274t8.b()) && this.f45090b == abstractC6274t8.c() && this.f45091c == abstractC6274t8.a()) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        int iHashCode = this.f45089a.hashCode() ^ 1000003;
        return this.f45091c ^ (((iHashCode * 1000003) ^ (true != this.f45090b ? 1237 : 1231)) * 1000003);
    }

    public final String toString() {
        return "MLKitLoggingOptions{libraryName=" + this.f45089a + ", enableFirelog=" + this.f45090b + ", firelogEventType=" + this.f45091c + "}";
    }
}
