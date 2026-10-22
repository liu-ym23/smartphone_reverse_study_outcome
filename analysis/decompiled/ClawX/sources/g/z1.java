package g;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import androidx.appcompat.widget.Toolbar;
import java.util.ArrayList;

/* compiled from: r8-map-id-ca86e8b578419e4708a9a7ee3f056b062b20ba338a8b13e201aefe3710dbf238 */
/* loaded from: classes.dex */
public final class z1 implements f.p {

    /* renamed from: a, reason: collision with root package name */
    public f.j f2877a;

    /* renamed from: b, reason: collision with root package name */
    public f.k f2878b;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ Toolbar f2879c;

    public z1(Toolbar toolbar) {
        this.f2879c = toolbar;
    }

    @Override // f.p
    public final boolean c(f.k kVar) {
        Toolbar toolbar = this.f2879c;
        toolbar.c();
        ViewParent parent = toolbar.f339h.getParent();
        if (parent != toolbar) {
            if (parent instanceof ViewGroup) {
                ((ViewGroup) parent).removeView(toolbar.f339h);
            }
            toolbar.addView(toolbar.f339h);
        }
        View view = kVar.z;
        if (view == null) {
            view = null;
        }
        toolbar.f340j = view;
        this.f2878b = kVar;
        ViewParent parent2 = view.getParent();
        if (parent2 != toolbar) {
            if (parent2 instanceof ViewGroup) {
                ((ViewGroup) parent2).removeView(toolbar.f340j);
            }
            a2 a2VarG = Toolbar.g();
            a2VarG.f2668a = (toolbar.f345o & 112) | 8388611;
            a2VarG.f2669b = 2;
            toolbar.f340j.setLayoutParams(a2VarG);
            toolbar.addView(toolbar.f340j);
        }
        for (int childCount = toolbar.getChildCount() - 1; childCount >= 0; childCount--) {
            View childAt = toolbar.getChildAt(childCount);
            if (((a2) childAt.getLayoutParams()).f2669b != 2 && childAt != toolbar.f333a) {
                toolbar.removeViewAt(childCount);
                toolbar.F.add(childAt);
            }
        }
        toolbar.requestLayout();
        kVar.B = true;
        kVar.f2485n.o(false);
        toolbar.s();
        return true;
    }

    @Override // f.p
    public final void e() {
        if (this.f2878b != null) {
            f.j jVar = this.f2877a;
            if (jVar != null) {
                int size = jVar.f2458f.size();
                for (int i8 = 0; i8 < size; i8++) {
                    if (this.f2877a.getItem(i8) == this.f2878b) {
                        return;
                    }
                }
            }
            f(this.f2878b);
        }
    }

    @Override // f.p
    public final boolean f(f.k kVar) {
        Toolbar toolbar = this.f2879c;
        toolbar.removeView(toolbar.f340j);
        toolbar.removeView(toolbar.f339h);
        toolbar.f340j = null;
        ArrayList arrayList = toolbar.F;
        for (int size = arrayList.size() - 1; size >= 0; size--) {
            toolbar.addView((View) arrayList.get(size));
        }
        arrayList.clear();
        this.f2878b = null;
        toolbar.requestLayout();
        kVar.B = false;
        kVar.f2485n.o(false);
        toolbar.s();
        return true;
    }

    @Override // f.p
    public final boolean h() {
        return false;
    }

    @Override // f.p
    public final void i(Context context, f.j jVar) {
        f.k kVar;
        f.j jVar2 = this.f2877a;
        if (jVar2 != null && (kVar = this.f2878b) != null) {
            jVar2.d(kVar);
        }
        this.f2877a = jVar;
    }

    @Override // f.p
    public final boolean j(f.t tVar) {
        return false;
    }

    @Override // f.p
    public final void b(f.j jVar, boolean z) {
    }
}
