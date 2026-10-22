package stepos.support.v7.widget;

import android.content.Context;
import android.view.KeyEvent;
import android.view.View;
import android.widget.ImageButton;
import androidx.appcompat.R;
import androidx.appcompat.view.CollapsibleActionView;
import androidx.core.view.GravityCompat;
import java.util.ArrayList;

/* loaded from: classes4.dex */
public final class A0 implements Va.B {

    /* renamed from: a, reason: collision with root package name */
    public Va.n f6402a;
    public Va.q b;
    public final /* synthetic */ Toolbar c;

    public A0(Toolbar toolbar) {
        this.c = toolbar;
    }

    @Override // Va.B
    public final boolean a(Va.q qVar) {
        Toolbar toolbar = this.c;
        if (toolbar.i == null) {
            ImageButton imageButton = new ImageButton(toolbar.getContext(), null, R.attr.toolbarNavigationButtonStyle);
            toolbar.i = imageButton;
            imageButton.setImageDrawable(toolbar.g);
            toolbar.i.setContentDescription(toolbar.h);
            B0 b0F = Toolbar.f();
            b0F.f6291a = (toolbar.p & 112) | GravityCompat.START;
            b0F.b = 2;
            toolbar.i.setLayoutParams(b0F);
            toolbar.i.setOnClickListener(new ViewOnClickListenerC1983d(toolbar, 2));
        }
        if (toolbar.i.getParent() != toolbar) {
            toolbar.addView(toolbar.i);
        }
        View actionView = qVar.getActionView();
        toolbar.f6585j = actionView;
        this.b = qVar;
        if (actionView.getParent() != toolbar) {
            B0 b0F2 = Toolbar.f();
            b0F2.f6291a = (toolbar.p & 112) | GravityCompat.START;
            b0F2.b = 2;
            toolbar.f6585j.setLayoutParams(b0F2);
            toolbar.addView(toolbar.f6585j);
        }
        for (int childCount = toolbar.getChildCount() - 1; childCount >= 0; childCount--) {
            View childAt = toolbar.getChildAt(childCount);
            if (((B0) childAt.getLayoutParams()).b != 2 && childAt != toolbar.f6579a) {
                toolbar.removeViewAt(childCount);
                toolbar.f6566G.add(childAt);
            }
        }
        toolbar.requestLayout();
        qVar.f1452C = true;
        qVar.n.o(false);
        KeyEvent.Callback callback = toolbar.f6585j;
        if (callback instanceof CollapsibleActionView) {
            ((CollapsibleActionView) callback).onActionViewExpanded();
        }
        return true;
    }

    @Override // Va.B
    public final void b(Context context, Va.n nVar) {
        Va.q qVar;
        Va.n nVar2 = this.f6402a;
        if (nVar2 != null && (qVar = this.b) != null) {
            nVar2.d(qVar);
        }
        this.f6402a = nVar;
    }

    @Override // Va.B
    public final boolean c(Va.F f) {
        return false;
    }

    @Override // Va.B
    public final boolean d(Va.q qVar) {
        Toolbar toolbar = this.c;
        KeyEvent.Callback callback = toolbar.f6585j;
        if (callback instanceof CollapsibleActionView) {
            ((CollapsibleActionView) callback).onActionViewCollapsed();
        }
        toolbar.removeView(toolbar.f6585j);
        toolbar.removeView(toolbar.i);
        toolbar.f6585j = null;
        ArrayList arrayList = toolbar.f6566G;
        for (int size = arrayList.size() - 1; size >= 0; size--) {
            toolbar.addView((View) arrayList.get(size));
        }
        arrayList.clear();
        this.b = null;
        toolbar.requestLayout();
        qVar.f1452C = false;
        qVar.n.o(false);
        return true;
    }

    @Override // Va.B
    public final void f(Va.n nVar, boolean z10) {
    }

    @Override // Va.B
    public final boolean flagActionItems() {
        return false;
    }

    @Override // Va.B
    public final void updateMenuView(boolean z10) {
        if (this.b != null) {
            Va.n nVar = this.f6402a;
            if (nVar != null) {
                int size = nVar.e.size();
                for (int i = 0; i < size; i++) {
                    if (this.f6402a.getItem(i) == this.b) {
                        return;
                    }
                }
            }
            d(this.b);
        }
    }
}
