package f1;

import android.view.View;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import e0.a0;

/* compiled from: r8-map-id-ca86e8b578419e4708a9a7ee3f056b062b20ba338a8b13e201aefe3710dbf238 */
/* loaded from: classes.dex */
public abstract class a extends t.a {

    /* renamed from: a, reason: collision with root package name */
    public b f2545a;

    @Override // t.a
    public boolean g(CoordinatorLayout coordinatorLayout, View view, int i8) {
        r(coordinatorLayout, view, i8);
        if (this.f2545a == null) {
            this.f2545a = new b(view);
        }
        b bVar = this.f2545a;
        View view2 = (View) bVar.f2548c;
        bVar.f2546a = view2.getTop();
        bVar.f2547b = view2.getLeft();
        b bVar2 = this.f2545a;
        View view3 = (View) bVar2.f2548c;
        int top = 0 - (view3.getTop() - bVar2.f2546a);
        int[] iArr = a0.f2285a;
        view3.offsetTopAndBottom(top);
        view3.offsetLeftAndRight(0 - (view3.getLeft() - bVar2.f2547b));
        return true;
    }

    public void r(CoordinatorLayout coordinatorLayout, View view, int i8) {
        coordinatorLayout.q(view, i8);
    }
}
