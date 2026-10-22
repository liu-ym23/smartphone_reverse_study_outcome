package androidx.datastore.preferences.protobuf;

/* renamed from: androidx.datastore.preferences.protobuf.f, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C0255f extends AbstractC0257g {

    /* renamed from: a, reason: collision with root package name */
    public int f3470a = 0;

    /* renamed from: b, reason: collision with root package name */
    public final int f3471b;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ AbstractC0259h f3472c;

    public C0255f(AbstractC0259h abstractC0259h) {
        this.f3472c = abstractC0259h;
        this.f3471b = abstractC0259h.size();
    }

    @Override // java.util.Iterator
    public final boolean hasNext() {
        return this.f3470a < this.f3471b;
    }
}
