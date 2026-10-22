package z9;

import f8.g;
import f8.q0;
import p7.k;
import q7.m;
import t9.s;
import v9.z0;

/* loaded from: classes.dex */
public final class a extends m implements k {

    /* renamed from: h, reason: collision with root package name */
    public static final a f12491h;

    /* renamed from: i, reason: collision with root package name */
    public static final a f12492i;

    /* renamed from: g, reason: collision with root package name */
    public final /* synthetic */ int f12493g;

    static {
        int i2 = 1;
        f12491h = new a(i2, 0);
        f12492i = new a(i2, 1);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ a(int i2, int i10) {
        super(i2);
        this.f12493g = i10;
    }

    @Override // p7.k
    public final Object invoke(Object obj) {
        switch (this.f12493g) {
            case 0:
                z0 z0Var = (z0) obj;
                q7.k.e(z0Var, "it");
                g gVarC = z0Var.E0().c();
                boolean z4 = false;
                if (gVarC != null && (gVarC instanceof q0) && (((q0) gVarC).p() instanceof s)) {
                    z4 = true;
                }
                return Boolean.valueOf(z4);
            default:
                z0 z0Var2 = (z0) obj;
                q7.k.e(z0Var2, "it");
                g gVarC2 = z0Var2.E0().c();
                boolean z10 = false;
                if (gVarC2 != null && ((gVarC2 instanceof s) || (gVarC2 instanceof q0))) {
                    z10 = true;
                }
                return Boolean.valueOf(z10);
        }
    }
}
