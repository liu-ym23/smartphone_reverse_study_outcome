package stepos.support.v7.widget;

import android.content.Context;
import android.view.KeyEvent;
import android.view.View;
import android.widget.ImageButton;
import androidx.appcompat.app.ViewOnClickListenerC0177c;
import com.stepos.alphame.R;
import j.InterfaceC0625d;
import java.util.ArrayList;

/* loaded from: classes2.dex */
public final class r0 implements L3.w {

    /* renamed from: a, reason: collision with root package name */
    public L3.k f15143a;

    /* renamed from: b, reason: collision with root package name */
    public L3.l f15144b;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ Toolbar f15145c;

    public r0(Toolbar toolbar) {
        this.f15145c = toolbar;
    }

    @Override // L3.w
    public final void a() {
        if (this.f15144b != null) {
            L3.k kVar = this.f15143a;
            if (kVar != null) {
                int size = kVar.f1285e.size();
                for (int i4 = 0; i4 < size; i4++) {
                    if (this.f15143a.getItem(i4) == this.f15144b) {
                        return;
                    }
                }
            }
            f(this.f15144b);
        }
    }

    @Override // L3.w
    public final boolean c() {
        return false;
    }

    @Override // L3.w
    public final void d(L3.k kVar, boolean z4) {
    }

    @Override // L3.w
    public final boolean e(L3.A a4) {
        return false;
    }

    @Override // L3.w
    public final boolean f(L3.l lVar) {
        Toolbar toolbar = this.f15145c;
        KeyEvent.Callback callback = toolbar.f15022j;
        if (callback instanceof InterfaceC0625d) {
            ((InterfaceC0625d) callback).g();
        }
        toolbar.removeView(toolbar.f15022j);
        toolbar.removeView(toolbar.f15021i);
        toolbar.f15022j = null;
        ArrayList arrayList = toolbar.f14997G;
        for (int size = arrayList.size() - 1; size >= 0; size--) {
            toolbar.addView((View) arrayList.get(size));
        }
        arrayList.clear();
        this.f15144b = null;
        toolbar.requestLayout();
        lVar.f1304C = false;
        lVar.f1318n.o(false);
        return true;
    }

    @Override // L3.w
    public final void g(Context context, L3.k kVar) {
        L3.l lVar;
        L3.k kVar2 = this.f15143a;
        if (kVar2 != null && (lVar = this.f15144b) != null) {
            kVar2.d(lVar);
        }
        this.f15143a = kVar;
    }

    @Override // L3.w
    public final boolean h(L3.l lVar) {
        Toolbar toolbar = this.f15145c;
        if (toolbar.f15021i == null) {
            ImageButton imageButton = new ImageButton(toolbar.getContext(), null, R.attr.toolbarNavigationButtonStyle);
            toolbar.f15021i = imageButton;
            imageButton.setImageDrawable(toolbar.f15019g);
            toolbar.f15021i.setContentDescription(toolbar.f15020h);
            s0 s0VarF = Toolbar.f();
            s0VarF.f14437a = (toolbar.f15030p & 112) | 8388611;
            s0VarF.f15147b = 2;
            toolbar.f15021i.setLayoutParams(s0VarF);
            toolbar.f15021i.setOnClickListener(new ViewOnClickListenerC0177c(8, toolbar));
        }
        if (toolbar.f15021i.getParent() != toolbar) {
            toolbar.addView(toolbar.f15021i);
        }
        View actionView = lVar.getActionView();
        toolbar.f15022j = actionView;
        this.f15144b = lVar;
        if (actionView.getParent() != toolbar) {
            s0 s0VarF2 = Toolbar.f();
            s0VarF2.f14437a = (toolbar.f15030p & 112) | 8388611;
            s0VarF2.f15147b = 2;
            toolbar.f15022j.setLayoutParams(s0VarF2);
            toolbar.addView(toolbar.f15022j);
        }
        for (int childCount = toolbar.getChildCount() - 1; childCount >= 0; childCount--) {
            View childAt = toolbar.getChildAt(childCount);
            if (((s0) childAt.getLayoutParams()).f15147b != 2 && childAt != toolbar.f15013a) {
                toolbar.removeViewAt(childCount);
                toolbar.f14997G.add(childAt);
            }
        }
        toolbar.requestLayout();
        lVar.f1304C = true;
        lVar.f1318n.o(false);
        KeyEvent.Callback callback = toolbar.f15022j;
        if (callback instanceof InterfaceC0625d) {
            ((InterfaceC0625d) callback).b();
        }
        return true;
    }
}
