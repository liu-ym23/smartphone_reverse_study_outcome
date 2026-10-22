package w5;

import b0.f1;
import java.util.List;

/* loaded from: classes.dex */
public final /* synthetic */ class n implements p7.a {

    /* renamed from: f, reason: collision with root package name */
    public final /* synthetic */ int f10736f;

    /* renamed from: g, reason: collision with root package name */
    public final /* synthetic */ f1 f10737g;

    public /* synthetic */ n(f1 f1Var, int i2) {
        this.f10736f = i2;
        this.f10737g = f1Var;
    }

    @Override // p7.a
    public final Object c() {
        int i2 = this.f10736f;
        c7.r rVar = c7.r.f1986a;
        f1 f1Var = this.f10737g;
        switch (i2) {
            case 0:
                f1Var.setValue(Boolean.FALSE);
                break;
            case 1:
                List list = a0.f10676k;
                f1Var.setValue(Boolean.TRUE);
                break;
            case 2:
                List list2 = a0.f10676k;
                f1Var.setValue(Integer.valueOf(((Number) f1Var.getValue()).intValue() + 1));
                break;
            case 3:
                List list3 = a0.f10676k;
                f1Var.setValue(Boolean.valueOf(!((Boolean) f1Var.getValue()).booleanValue()));
                break;
            default:
                List list4 = e0.f10700g;
                f1Var.setValue(Boolean.valueOf(!((Boolean) f1Var.getValue()).booleanValue()));
                break;
        }
        return rVar;
    }
}
