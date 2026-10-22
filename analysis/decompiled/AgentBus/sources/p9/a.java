package p9;

import e9.f;
import f8.k;
import i8.n;
import v9.v;

/* loaded from: classes.dex */
public final class a extends a4.d implements d {

    /* renamed from: g, reason: collision with root package name */
    public final /* synthetic */ int f8525g = 1;

    /* renamed from: h, reason: collision with root package name */
    public final f f8526h;

    /* renamed from: i, reason: collision with root package name */
    public final k f8527i;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public a(f8.b bVar, v vVar, f fVar) {
        super(vVar);
        q7.k.e(vVar, "receiverType");
        this.f8527i = (n) bVar;
        this.f8526h = fVar;
    }

    public final f E0() {
        switch (this.f8525g) {
        }
        return this.f8526h;
    }

    public final String toString() {
        switch (this.f8525g) {
            case 0:
                return getType() + ": Ctx { " + ((f8.e) this.f8527i) + " }";
            default:
                return "Cxt { " + ((n) this.f8527i) + " }";
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public a(f8.e eVar, v vVar, f fVar) {
        super(vVar);
        q7.k.e(vVar, "receiverType");
        this.f8527i = eVar;
        this.f8526h = fVar;
    }
}
