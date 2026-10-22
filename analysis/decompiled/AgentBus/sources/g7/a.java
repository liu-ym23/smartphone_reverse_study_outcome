package g7;

/* loaded from: classes.dex */
public abstract class a implements j {

    /* renamed from: f, reason: collision with root package name */
    public final k f3861f;

    public a(k kVar) {
        this.f3861f = kVar;
    }

    @Override // g7.l
    public final l Q(l lVar) {
        return i.plus(this, lVar);
    }

    @Override // g7.j
    public final k getKey() {
        return this.f3861f;
    }

    @Override // g7.l
    public j o(k kVar) {
        return i.get(this, kVar);
    }

    @Override // g7.l
    public final Object r(Object obj, p7.n nVar) {
        return i.fold(this, obj, nVar);
    }

    @Override // g7.l
    public l z(k kVar) {
        return i.minusKey(this, kVar);
    }
}
