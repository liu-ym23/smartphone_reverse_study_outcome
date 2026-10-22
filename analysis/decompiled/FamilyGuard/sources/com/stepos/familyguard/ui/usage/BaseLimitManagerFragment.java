package com.stepos.familyguard.ui.usage;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.LinearLayoutManager;
import com.stepos.familyguard.ui.usage.AbstractC0598g;
import com.stepos.familyguard.ui.usage.z;
import com.stepos.familyguard.ui.usage.z.b;
import f2.C0702g;
import j2.C0780C;
import java.util.List;

/* loaded from: classes.dex */
public abstract class BaseLimitManagerFragment<T extends z.b> extends ProxyFragment {

    /* renamed from: h0, reason: collision with root package name */
    protected C0780C f14864h0;

    /* renamed from: i0, reason: collision with root package name */
    protected z f14865i0;

    /* renamed from: j0, reason: collision with root package name */
    protected AbstractC0598g<T> f14866j0;

    @Override // androidx.fragment.app.ComponentCallbacksC0511f
    public void A0() {
        super.A0();
        AbstractC0598g<T> abstractC0598g = this.f14866j0;
        if (abstractC0598g != null) {
            abstractC0598g.n();
        }
    }

    @Override // androidx.fragment.app.ComponentCallbacksC0511f
    public void S0() {
        super.S0();
    }

    @Override // androidx.fragment.app.ComponentCallbacksC0511f
    public void U0(View view, Bundle bundle) throws IllegalAccessException, NoSuchFieldException, SecurityException, IllegalArgumentException {
        super.U0(view, bundle);
        Context contextW = w();
        AbstractC0598g<T> abstractC0598gW1 = W1(contextW);
        this.f14866j0 = abstractC0598gW1;
        abstractC0598gW1.z(new AbstractC0598g.b() { // from class: w2.g
            @Override // com.stepos.familyguard.ui.usage.AbstractC0598g.b
            public final void a(int i5, Object obj) {
                this.f23618a.Y1(i5, (z.b) obj);
            }
        });
        this.f14864h0.f17638d.setLayoutManager(new LinearLayoutManager(contextW));
        this.f14864h0.f17638d.X0();
        this.f14864h0.f17638d.setAdapter(this.f14866j0);
    }

    public abstract AbstractC0598g<T> W1(Context context);

    public void X1(List<T> list) {
        C0702g.b("BaseLimitManagerFragment", "onDataSetChanged() called with: dataSet = [" + C0702g.k(list) + "]");
        this.f14866j0.y(list);
    }

    public abstract void Y1(int i5, T t5);

    @Override // com.stepos.familyguard.ui.usage.ProxyFragment, androidx.fragment.app.ComponentCallbacksC0511f
    public void v0(Bundle bundle) {
        super.v0(bundle);
        this.f14865i0 = (z) new androidx.lifecycle.U(y1()).a(z.class);
    }

    @Override // androidx.fragment.app.ComponentCallbacksC0511f
    public View z0(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        C0780C c0780cC = C0780C.c(layoutInflater, viewGroup, false);
        this.f14864h0 = c0780cC;
        return c0780cC.b();
    }
}
