package androidx.appcompat.widget;

import android.content.Context;
import android.view.MenuItem;
import k.C0661o;
import k.C0663q;

/* loaded from: classes.dex */
public final class L0 extends G0 implements H0 {

    /* renamed from: A, reason: collision with root package name */
    public H0 f2863A;

    @Override // androidx.appcompat.widget.H0
    public final void a(C0661o c0661o, C0663q c0663q) {
        H0 h02 = this.f2863A;
        if (h02 != null) {
            h02.a(c0661o, c0663q);
        }
    }

    @Override // androidx.appcompat.widget.G0
    public final C0229u0 b(Context context, boolean z4) {
        K0 k02 = new K0(context, z4);
        k02.setHoverListener(this);
        return k02;
    }

    @Override // androidx.appcompat.widget.H0
    public final void c(C0661o c0661o, MenuItem menuItem) {
        H0 h02 = this.f2863A;
        if (h02 != null) {
            h02.c(c0661o, menuItem);
        }
    }
}
