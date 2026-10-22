package u;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final class u extends s {

    /* renamed from: d, reason: collision with root package name */
    public final /* synthetic */ int f13136d;

    @Override // java.util.Iterator
    public final Object next() {
        switch (this.f13136d) {
            case 0:
                int i10 = this.f13135c;
                this.f13135c = i10 + 2;
                return this.f13133a[i10];
            default:
                int i11 = this.f13135c;
                this.f13135c = i11 + 2;
                return this.f13133a[i11 + 1];
        }
    }
}
