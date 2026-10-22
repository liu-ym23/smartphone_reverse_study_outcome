package com.stepos.familyguard.ui.usage;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.recyclerview.widget.LinearLayoutManager;
import com.stepos.familyguard.R;
import com.stepos.familyguard.ui.usage.AbstractC0599h;
import com.stepos.familyguard.ui.usage.z;
import com.stepos.familyguard.ui.usage.z.b;
import f2.C0702g;
import j2.C0780C;
import java.util.List;

/* loaded from: classes.dex */
public abstract class BaseLimitManagerSearchFragment<T extends z.b> extends ProxyFragment {

    /* renamed from: h0, reason: collision with root package name */
    protected C0780C f14867h0;

    /* renamed from: i0, reason: collision with root package name */
    protected A f14868i0;

    /* renamed from: j0, reason: collision with root package name */
    protected AbstractC0599h<T> f14869j0;

    /* renamed from: k0, reason: collision with root package name */
    private boolean f14870k0 = false;

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void Z1(int i5, z.b bVar) {
        C2.i.b(y1(), y1().getCurrentFocus());
        b2(i5, bVar);
    }

    @Override // androidx.fragment.app.ComponentCallbacksC0511f
    public void A0() {
        super.A0();
        AbstractC0599h<T> abstractC0599h = this.f14869j0;
        if (abstractC0599h != null) {
            abstractC0599h.l();
        }
    }

    @Override // androidx.fragment.app.ComponentCallbacksC0511f
    public void S0() {
        super.S0();
    }

    @Override // androidx.fragment.app.ComponentCallbacksC0511f
    public void T0() {
        super.T0();
        this.f14870k0 = false;
    }

    @Override // androidx.fragment.app.ComponentCallbacksC0511f
    public void U0(View view, Bundle bundle) throws IllegalAccessException, NoSuchFieldException, SecurityException, IllegalArgumentException {
        super.U0(view, bundle);
        Context contextW = w();
        AbstractC0599h<T> abstractC0599hX1 = X1(contextW);
        this.f14869j0 = abstractC0599hX1;
        abstractC0599hX1.x(new AbstractC0599h.a() { // from class: w2.h
            @Override // com.stepos.familyguard.ui.usage.AbstractC0599h.a
            public final void a(int i5, Object obj) {
                this.f23620a.Z1(i5, (z.b) obj);
            }
        });
        this.f14867h0.f17638d.setLayoutManager(new LinearLayoutManager(contextW));
        this.f14867h0.f17638d.X0();
        this.f14867h0.f17638d.setAdapter(this.f14869j0);
        this.f14867h0.f17638d.p1(T1.g.b(A1(), R.attr.marginMedium));
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.f14867h0.f17638d.getLayoutParams();
        if (y1() instanceof LimitSearchActivity) {
            layoutParams.topMargin = ((LimitSearchActivity) y1()).t();
        }
    }

    public abstract AbstractC0599h<T> X1(Context context);

    protected void Y1() {
        this.f14867h0.f17636b.setVisibility(8);
    }

    public void a2(List<T> list) {
        C0702g.b("BaseLimitManagerFragment", "onDataSetChanged() called with: dataSet = " + C0702g.k(list));
        if (list == null || list.isEmpty()) {
            if (this.f14870k0) {
                c2();
            }
            this.f14870k0 = true;
        } else {
            Y1();
        }
        this.f14869j0.w(list, this.f14868i0.i0());
    }

    protected abstract void b2(int i5, T t5);

    protected void c2() {
        if (this.f14867h0.f17636b.getVisibility() == 0) {
            return;
        }
        this.f14867h0.f17636b.setVisibility(0);
        this.f14867h0.f17637c.k();
    }

    @Override // com.stepos.familyguard.ui.usage.ProxyFragment, androidx.fragment.app.ComponentCallbacksC0511f
    public void v0(Bundle bundle) {
        super.v0(bundle);
        this.f14868i0 = (A) new androidx.lifecycle.U(y1()).a(A.class);
    }

    @Override // androidx.fragment.app.ComponentCallbacksC0511f
    public View z0(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        C0780C c0780cC = C0780C.c(layoutInflater, viewGroup, false);
        this.f14867h0 = c0780cC;
        return c0780cC.b();
    }
}
