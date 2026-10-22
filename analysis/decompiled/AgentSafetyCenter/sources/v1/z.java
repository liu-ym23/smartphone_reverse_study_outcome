package v1;

import android.view.View;
import android.view.accessibility.AccessibilityEvent;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final class z extends yb.l implements xb.l {

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ int f14598c;

    /* renamed from: f, reason: collision with root package name */
    public final /* synthetic */ a0 f14599f;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ z(a0 a0Var, int i) {
        super(1);
        this.f14598c = i;
        this.f14599f = a0Var;
    }

    @Override // xb.l
    public final Object invoke(Object obj) {
        switch (this.f14598c) {
            case 0:
                View view = this.f14599f.f14331a;
                return Boolean.valueOf(view.getParent().requestSendAccessibilityEvent(view, (AccessibilityEvent) obj));
            default:
                n1 n1Var = (n1) obj;
                if (n1Var.f14512f.contains(n1Var)) {
                    a0 a0Var = this.f14599f;
                    a0Var.f14331a.getSnapshotObserver().a(n1Var, a0Var.M, new a1.b(15, n1Var, a0Var));
                }
                return jb.v.f6774a;
        }
    }
}
