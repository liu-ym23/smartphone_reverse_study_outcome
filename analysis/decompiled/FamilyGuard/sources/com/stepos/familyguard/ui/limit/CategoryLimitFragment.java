package com.stepos.familyguard.ui.limit;

import D2.c;
import D2.j;
import D2.n;
import D2.p;
import D2.r;
import D2.s;
import D2.t;
import D2.y;
import D2.z;
import T1.g;
import android.content.Context;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.View;
import androidx.core.view.H;
import androidx.core.view.InterfaceC0479y;
import androidx.core.view.Y;
import androidx.lifecycle.C;
import androidx.lifecycle.V;
import androidx.preference.PreferenceCategory;
import androidx.recyclerview.widget.RecyclerView;
import com.stepos.digitalwellbeing.server.data.Category;
import com.stepos.digitalwellbeing.utils.PackageUtils;
import com.stepos.familyguard.R;
import com.stepos.familyguard.ui.widget.PackagePreference;
import java.util.List;
import t2.I;
import v2.C1183b;
import v2.d;
import v2.e;

/* loaded from: classes.dex */
public class CategoryLimitFragment extends BaseLimitFragment implements t {

    /* renamed from: E0, reason: collision with root package name */
    private int f14834E0;

    /* renamed from: F0, reason: collision with root package name */
    private int f14835F0;

    /* renamed from: G0, reason: collision with root package name */
    private r<String, Drawable> f14836G0;

    /* renamed from: H0, reason: collision with root package name */
    private r<String, s> f14837H0;

    /* renamed from: I0, reason: collision with root package name */
    private long f14838I0;

    /* renamed from: J0, reason: collision with root package name */
    private int f14839J0 = 0;

    /* renamed from: K0, reason: collision with root package name */
    private int f14840K0 = -1;

    private void Z2() {
        RecyclerView recyclerViewX1 = X1();
        if (recyclerViewX1 == null) {
            return;
        }
        recyclerViewX1.setClipToPadding(false);
        if (this.f14840K0 < 0) {
            this.f14840K0 = recyclerViewX1.getPaddingBottom();
        }
        H.w0(recyclerViewX1, new InterfaceC0479y() { // from class: t2.n
            @Override // androidx.core.view.InterfaceC0479y
            public final androidx.core.view.Y a(View view, androidx.core.view.Y y5) {
                return this.f22602a.a3(view, y5);
            }
        });
        recyclerViewX1.setPadding(recyclerViewX1.getPaddingLeft(), recyclerViewX1.getPaddingTop(), recyclerViewX1.getPaddingRight(), this.f14840K0 + d3(recyclerViewX1));
        H.g0(recyclerViewX1);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ Y a3(View view, Y y5) {
        int iD3 = y5.f(Y.l.d()).f9645d;
        if (iD3 <= 0) {
            iD3 = d3(view);
        }
        view.setPadding(view.getPaddingLeft(), view.getPaddingTop(), view.getPaddingRight(), this.f14840K0 + iD3);
        return y5;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b3(Category category) {
        if (category == null) {
            return;
        }
        List<String> packages = category.getPackages();
        PreferenceCategory preferenceCategory = (PreferenceCategory) Y1().T0("category_packages");
        if (preferenceCategory == null || preferenceCategory.X0() != 0) {
            return;
        }
        int i5 = 0;
        for (String str : packages) {
            if (this.f14834E0 != 0 || PackageUtils.h(w()).o(str)) {
                PackagePreference packagePreference = new PackagePreference(w(), this.f14836G0, this.f14837H0);
                packagePreference.T0(str);
                preferenceCategory.R0(packagePreference);
                i5++;
            }
        }
        preferenceCategory.G0(X(R.string.us_app_count, Integer.valueOf(i5)));
        this.f14839J0 = i5;
    }

    private static int d3(View view) {
        int identifier = view.getResources().getIdentifier("navigation_bar_height", "dimen", "android");
        return identifier > 0 ? view.getResources().getDimensionPixelSize(identifier) : Math.round(view.getResources().getDisplayMetrics().density * 48.0f);
    }

    @Override // androidx.fragment.app.ComponentCallbacksC0511f
    public void A0() {
        super.A0();
        r<String, Drawable> rVar = this.f14836G0;
        if (rVar != null) {
            rVar.e();
            this.f14836G0.a();
        }
        r<String, s> rVar2 = this.f14837H0;
        if (rVar2 != null) {
            rVar2.e();
            this.f14837H0.a();
        }
    }

    @Override // com.stepos.familyguard.ui.limit.BaseLimitFragment
    protected t2.Y D2(Bundle bundle) {
        e dVar;
        this.f14835F0 = bundle.getInt("categoryId", 0);
        this.f14834E0 = bundle.getInt("proxy", 0);
        long j5 = bundle.getLong("operator_id", -1L);
        this.f14838I0 = j5;
        if (this.f14834E0 == 0) {
            dVar = new C1183b(w());
        } else {
            dVar = new d(j5);
            dVar.init();
        }
        I i5 = (I) V.a(this).a(I.class);
        i5.T(this.f14835F0, dVar, this.f14838I0);
        return i5;
    }

    @Override // com.stepos.familyguard.ui.limit.BaseLimitFragment
    protected int E2() {
        return R.xml.us_category_limit_preferences;
    }

    @Override // com.stepos.familyguard.ui.limit.BaseLimitFragment
    protected void K2(boolean z5) {
        t2.Y y5;
        super.K2(z5);
        if (!z5 || (y5 = this.f14828v0) == null) {
            return;
        }
        ((I) y5).y(this.f14835F0);
    }

    @Override // com.stepos.familyguard.ui.limit.BaseLimitFragment, androidx.preference.g, androidx.fragment.app.ComponentCallbacksC0511f
    public void U0(View view, Bundle bundle) {
        super.U0(view, bundle);
        Z2();
    }

    protected void c3(Context context) {
        if (this.f14834E0 == 0) {
            this.f14837H0 = new c(null);
            this.f14836G0 = new D2.b(j.a().b());
        } else {
            this.f14836G0 = new n(j.a().c(), this.f14838I0);
            this.f14837H0 = new p(new y());
        }
        r<String, Drawable> rVar = this.f14836G0;
        if (rVar != null) {
            rVar.f(this);
        }
        r<String, s> rVar2 = this.f14837H0;
        if (rVar2 != null) {
            rVar2.f(this);
        }
    }

    @Override // D2.t
    public boolean d(boolean z5, Object obj, z zVar) {
        if (obj instanceof s) {
            zVar.a(((s) obj).f1196a);
            return true;
        }
        zVar.a(obj);
        return true;
    }

    @Override // com.stepos.familyguard.ui.widget.PreferenceFragment
    public void l2(int i5, int i6, Rect rect, View view, RecyclerView recyclerView, RecyclerView.State state) {
        if (i5 == i6 - 1) {
            rect.bottom = g.a(view.getContext(), R.attr.marginBottomMax);
        }
    }

    @Override // com.stepos.familyguard.ui.widget.PreferenceFragment
    public int n2(int i5, int i6) {
        if (i5 == 0) {
            return 4;
        }
        int i7 = this.f14827u0.P() ? i5 - 1 : i5;
        if (i7 == 0) {
            return 4;
        }
        if (i7 == 1) {
            return 0;
        }
        if (i7 == 3) {
            return 2;
        }
        if (i7 == 4) {
            return 4;
        }
        if (i7 == 5) {
            return 0;
        }
        if (i5 == i6 - 1) {
            int i8 = this.f14839J0;
            if (i8 == 0) {
                return 4;
            }
            return i8 == 1 ? 3 : 2;
        }
        int i9 = this.f14839J0;
        if (i5 == i6 - i9) {
            return 0;
        }
        if (i5 == (i6 - i9) - 1) {
            return 4;
        }
        if (i5 == (i6 - i9) - 2) {
            return 3;
        }
        if (i5 == (i6 - i9) - 3) {
            return 4;
        }
        return i5 == (i6 - i9) - 4 ? 2 : 1;
    }

    @Override // com.stepos.familyguard.ui.limit.BaseLimitFragment, androidx.preference.g, androidx.fragment.app.ComponentCallbacksC0511f
    public void v0(Bundle bundle) {
        super.v0(bundle);
        ((I) this.f14828v0).S().g(this, new C() { // from class: t2.o
            @Override // androidx.lifecycle.C
            public final void a(Object obj) {
                this.f22605a.b3((Category) obj);
            }
        });
        this.f14838I0 = u().getLong("operator_id", -1L);
        c3(w());
    }
}
