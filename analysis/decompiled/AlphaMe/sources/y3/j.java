package y3;

import com.google.android.gms.common.api.internal.p;

/* loaded from: classes2.dex */
public final class j implements t3.b {

    /* renamed from: a, reason: collision with root package name */
    public final t3.f f16379a;

    /* renamed from: b, reason: collision with root package name */
    public final boolean f16380b = false;

    /* renamed from: c, reason: collision with root package name */
    public final int f16381c;

    public j(t3.f fVar, int i4) {
        this.f16379a = fVar;
        this.f16381c = i4 <= 0 ? B3.f.f227b : i4;
    }

    @Override // x3.e
    public final Object call(Object obj) {
        int i4 = this.f16381c;
        i iVar = new i(this.f16379a, (t3.g) obj, this.f16380b, i4);
        p pVar = new p(27, iVar);
        t3.g gVar = iVar.f16368e;
        gVar.i(pVar);
        gVar.d(iVar.f16369f);
        gVar.d(iVar);
        return iVar;
    }
}
