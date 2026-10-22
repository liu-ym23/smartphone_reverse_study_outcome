package m;

import android.content.Context;
import android.view.KeyEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import androidx.appcompat.widget.Toolbar;
import java.util.ArrayList;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final class q2 implements l.x {

    /* renamed from: c, reason: collision with root package name */
    public l.l f8051c;

    /* renamed from: f, reason: collision with root package name */
    public l.n f8052f;

    /* renamed from: g, reason: collision with root package name */
    public final /* synthetic */ Toolbar f8053g;

    public q2(Toolbar toolbar) {
        this.f8053g = toolbar;
    }

    @Override // l.x
    public final boolean a() {
        return false;
    }

    @Override // l.x
    public final void c() {
        if (this.f8052f != null) {
            l.l lVar = this.f8051c;
            if (lVar != null) {
                int size = lVar.f7588f.size();
                for (int i = 0; i < size; i++) {
                    if (this.f8051c.getItem(i) == this.f8052f) {
                        return;
                    }
                }
            }
            k(this.f8052f);
        }
    }

    @Override // l.x
    public final boolean e(l.n nVar) {
        Toolbar toolbar = this.f8053g;
        toolbar.c();
        ViewParent parent = toolbar.f810l.getParent();
        if (parent != toolbar) {
            if (parent instanceof ViewGroup) {
                ((ViewGroup) parent).removeView(toolbar.f810l);
            }
            toolbar.addView(toolbar.f810l);
        }
        View actionView = nVar.getActionView();
        toolbar.f811m = actionView;
        this.f8052f = nVar;
        ViewParent parent2 = actionView.getParent();
        if (parent2 != toolbar) {
            if (parent2 instanceof ViewGroup) {
                ((ViewGroup) parent2).removeView(toolbar.f811m);
            }
            r2 r2VarH = Toolbar.h();
            r2VarH.f8058a = (toolbar.f816r & 112) | 8388611;
            r2VarH.f8059b = 2;
            toolbar.f811m.setLayoutParams(r2VarH);
            toolbar.addView(toolbar.f811m);
        }
        for (int childCount = toolbar.getChildCount() - 1; childCount >= 0; childCount--) {
            View childAt = toolbar.getChildAt(childCount);
            if (((r2) childAt.getLayoutParams()).f8059b != 2 && childAt != toolbar.f804c) {
                toolbar.removeViewAt(childCount);
                toolbar.I.add(childAt);
            }
        }
        toolbar.requestLayout();
        nVar.C = true;
        nVar.f7622n.p(false);
        KeyEvent.Callback callback = toolbar.f811m;
        if (callback instanceof k.b) {
            ((k.b) callback).onActionViewExpanded();
        }
        toolbar.t();
        return true;
    }

    @Override // l.x
    public final void i(Context context, l.l lVar) {
        l.n nVar;
        l.l lVar2 = this.f8051c;
        if (lVar2 != null && (nVar = this.f8052f) != null) {
            lVar2.d(nVar);
        }
        this.f8051c = lVar;
    }

    @Override // l.x
    public final boolean j(l.d0 d0Var) {
        return false;
    }

    @Override // l.x
    public final boolean k(l.n nVar) {
        Toolbar toolbar = this.f8053g;
        KeyEvent.Callback callback = toolbar.f811m;
        if (callback instanceof k.b) {
            ((k.b) callback).onActionViewCollapsed();
        }
        toolbar.removeView(toolbar.f811m);
        toolbar.removeView(toolbar.f810l);
        toolbar.f811m = null;
        ArrayList arrayList = toolbar.I;
        for (int size = arrayList.size() - 1; size >= 0; size--) {
            toolbar.addView((View) arrayList.get(size));
        }
        arrayList.clear();
        this.f8052f = null;
        toolbar.requestLayout();
        nVar.C = false;
        nVar.f7622n.p(false);
        toolbar.t();
        return true;
    }

    @Override // l.x
    public final void d(l.l lVar, boolean z10) {
    }
}
