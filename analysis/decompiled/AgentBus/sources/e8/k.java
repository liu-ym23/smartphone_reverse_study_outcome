package e8;

import f8.z;
import i8.c0;

/* loaded from: classes.dex */
public final class k extends c0 {

    /* renamed from: l, reason: collision with root package name */
    public final /* synthetic */ int f3157l;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public k(z zVar, e9.c cVar, int i2) {
        super(zVar, cVar);
        this.f3157l = i2;
        switch (i2) {
            case 1:
                q7.k.e(zVar, "module");
                q7.k.e(cVar, "fqName");
                super(zVar, cVar);
                break;
            default:
                break;
        }
    }

    @Override // f8.e0
    public final /* bridge */ /* synthetic */ o9.n v0() {
        switch (this.f3157l) {
        }
        return o9.m.f7933b;
    }
}
