package j1;

import android.view.accessibility.AccessibilityEvent;

/* loaded from: classes.dex */
public final class e0 extends q7.m implements p7.k {

    /* renamed from: g, reason: collision with root package name */
    public final /* synthetic */ int f5129g;

    /* renamed from: h, reason: collision with root package name */
    public final /* synthetic */ f0 f5130h;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ e0(f0 f0Var, int i2) {
        super(1);
        this.f5129g = i2;
        this.f5130h = f0Var;
    }

    @Override // p7.k
    public final Object invoke(Object obj) {
        switch (this.f5129g) {
            case 0:
                f0 f0Var = this.f5130h;
                return Boolean.valueOf(f0Var.f5138d.getParent().requestSendAccessibilityEvent(f0Var.f5138d, (AccessibilityEvent) obj));
            default:
                s1 s1Var = (s1) obj;
                if (s1Var.f5325g.contains(s1Var)) {
                    f0 f0Var2 = this.f5130h;
                    f0Var2.f5138d.getSnapshotObserver().a(s1Var, f0Var2.P, new a8.e(10, s1Var, f0Var2));
                }
                return c7.r.f1986a;
        }
    }
}
