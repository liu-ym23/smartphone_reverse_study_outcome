package androidx.appcompat.widget;

import android.content.Context;
import android.view.KeyEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import j.InterfaceC0625d;
import java.util.ArrayList;
import k.C0661o;
import k.C0663q;
import k.InterfaceC0640A;
import k.SubMenuC0646G;

/* loaded from: classes.dex */
public final class c1 implements InterfaceC0640A {

    /* renamed from: a, reason: collision with root package name */
    public C0661o f3071a;

    /* renamed from: b, reason: collision with root package name */
    public C0663q f3072b;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ Toolbar f3073c;

    public c1(Toolbar toolbar) {
        this.f3073c = toolbar;
    }

    @Override // k.InterfaceC0640A
    public final void a() {
        if (this.f3072b != null) {
            C0661o c0661o = this.f3071a;
            if (c0661o != null) {
                int size = c0661o.f13243f.size();
                for (int i4 = 0; i4 < size; i4++) {
                    if (this.f3071a.getItem(i4) == this.f3072b) {
                        return;
                    }
                }
            }
            h(this.f3072b);
        }
    }

    @Override // k.InterfaceC0640A
    public final void b(C0661o c0661o, boolean z4) {
    }

    @Override // k.InterfaceC0640A
    public final boolean c() {
        return false;
    }

    @Override // k.InterfaceC0640A
    public final boolean d(C0663q c0663q) {
        Toolbar toolbar = this.f3073c;
        toolbar.c();
        ViewParent parent = toolbar.f2991h.getParent();
        if (parent != toolbar) {
            if (parent instanceof ViewGroup) {
                ((ViewGroup) parent).removeView(toolbar.f2991h);
            }
            toolbar.addView(toolbar.f2991h);
        }
        View actionView = c0663q.getActionView();
        toolbar.f2992i = actionView;
        this.f3072b = c0663q;
        ViewParent parent2 = actionView.getParent();
        if (parent2 != toolbar) {
            if (parent2 instanceof ViewGroup) {
                ((ViewGroup) parent2).removeView(toolbar.f2992i);
            }
            d1 d1VarG = Toolbar.g();
            d1VarG.f2583a = (toolbar.f2997n & 112) | 8388611;
            d1VarG.f3077b = 2;
            toolbar.f2992i.setLayoutParams(d1VarG);
            toolbar.addView(toolbar.f2992i);
        }
        for (int childCount = toolbar.getChildCount() - 1; childCount >= 0; childCount--) {
            View childAt = toolbar.getChildAt(childCount);
            if (((d1) childAt.getLayoutParams()).f3077b != 2 && childAt != toolbar.f2984a) {
                toolbar.removeViewAt(childCount);
                toolbar.f2971E.add(childAt);
            }
        }
        toolbar.requestLayout();
        c0663q.f13268C = true;
        c0663q.f13282n.p(false);
        KeyEvent.Callback callback = toolbar.f2992i;
        if (callback instanceof InterfaceC0625d) {
            ((InterfaceC0625d) callback).b();
        }
        toolbar.s();
        return true;
    }

    @Override // k.InterfaceC0640A
    public final boolean f(SubMenuC0646G subMenuC0646G) {
        return false;
    }

    @Override // k.InterfaceC0640A
    public final boolean h(C0663q c0663q) {
        Toolbar toolbar = this.f3073c;
        KeyEvent.Callback callback = toolbar.f2992i;
        if (callback instanceof InterfaceC0625d) {
            ((InterfaceC0625d) callback).g();
        }
        toolbar.removeView(toolbar.f2992i);
        toolbar.removeView(toolbar.f2991h);
        toolbar.f2992i = null;
        ArrayList arrayList = toolbar.f2971E;
        for (int size = arrayList.size() - 1; size >= 0; size--) {
            toolbar.addView((View) arrayList.get(size));
        }
        arrayList.clear();
        this.f3072b = null;
        toolbar.requestLayout();
        c0663q.f13268C = false;
        c0663q.f13282n.p(false);
        toolbar.s();
        return true;
    }

    @Override // k.InterfaceC0640A
    public final void k(Context context, C0661o c0661o) {
        C0663q c0663q;
        C0661o c0661o2 = this.f3071a;
        if (c0661o2 != null && (c0663q = this.f3072b) != null) {
            c0661o2.d(c0663q);
        }
        this.f3071a = c0661o;
    }
}
