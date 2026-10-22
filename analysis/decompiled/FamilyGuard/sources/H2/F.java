package H2;

import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.ActivityC0516k;
import com.stepos.familyguard.ui.base.BaseFragment;
import com.stepos.minor.ui.MinorMainActivity;
import f2.C0702g;
import i2.AbstractActivityC0758a;

/* loaded from: classes.dex */
public class F extends BaseFragment {

    /* renamed from: f0, reason: collision with root package name */
    private j2.o f2712f0;

    /* renamed from: g0, reason: collision with root package name */
    private Q1.c<G2.v> f2713g0 = Q1.c.a();

    public static /* synthetic */ void Y1(G2.v vVar) {
        C0702g.b("MinorGuideFragment", "onButtonClick present: ");
        vVar.j(1);
    }

    private void Z1() {
        stepos.support.v7.app.a supportActionBar;
        ActivityC0516k activityC0516kQ = q();
        if (activityC0516kQ instanceof MinorMainActivity) {
            ((MinorMainActivity) activityC0516kQ).l0();
        } else {
            if (!(activityC0516kQ instanceof AbstractActivityC0758a) || (supportActionBar = ((AbstractActivityC0758a) activityC0516kQ).getSupportActionBar()) == null) {
                return;
            }
            U1(supportActionBar);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void a2(View view) {
        C0702g.b("MinorGuideFragment", "onButtonClick");
        this.f2713g0.c(new Q1.b() { // from class: H2.E
            @Override // Q1.b
            public final void accept(Object obj) {
                F.Y1((G2.v) obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void b2(View view) {
        y1().finish();
    }

    @Override // androidx.fragment.app.ComponentCallbacksC0511f
    public void Q0() {
        super.Q0();
        Z1();
        j2.o oVar = this.f2712f0;
        if (oVar != null) {
            oVar.f17748c.bringToFront();
        }
    }

    @Override // androidx.fragment.app.ComponentCallbacksC0511f
    public void U0(View view, Bundle bundle) {
        super.U0(view, bundle);
        this.f2712f0.f17747b.setOnClickListener(new View.OnClickListener() { // from class: H2.C
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                this.f2708a.a2(view2);
            }
        });
        this.f2712f0.f17748c.setOnClickListener(new View.OnClickListener() { // from class: H2.D
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                this.f2710a.b2(view2);
            }
        });
    }

    @Override // com.stepos.familyguard.ui.base.BaseFragment
    protected void U1(stepos.support.v7.app.a aVar) {
        aVar.p().n(8);
    }

    @Override // com.stepos.familyguard.ui.base.BaseFragment
    public void V1(boolean z5) {
        Z1();
    }

    @Override // com.stepos.familyguard.ui.base.BaseFragment, androidx.fragment.app.ComponentCallbacksC0511f
    public void s0(Context context) {
        super.s0(context);
        ActivityC0516k activityC0516kY1 = y1();
        if (activityC0516kY1 instanceof MinorMainActivity) {
            C0702g.b("MinorGuideFragment", "onAttach: ");
            this.f2713g0 = Q1.c.e(((MinorMainActivity) activityC0516kY1).j0());
        }
    }

    @Override // androidx.fragment.app.ComponentCallbacksC0511f
    public void v0(Bundle bundle) {
        super.v0(bundle);
    }

    @Override // androidx.fragment.app.ComponentCallbacksC0511f
    public View z0(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        this.f2712f0 = j2.o.c(layoutInflater);
        if (TextUtils.equals("CN", Q().getConfiguration().locale.getCountry())) {
            T1.g.e(1.18f, this.f2712f0.b());
        } else {
            T1.g.e(1.06f, this.f2712f0.b());
        }
        ActivityC0516k activityC0516kY1 = y1();
        if (activityC0516kY1 instanceof AbstractActivityC0758a) {
            AbstractActivityC0758a abstractActivityC0758a = (AbstractActivityC0758a) activityC0516kY1;
            int iV = abstractActivityC0758a.v();
            int iU = abstractActivityC0758a.u();
            ((ConstraintLayout.b) this.f2712f0.f17748c.getLayoutParams()).setMargins(0, iV, 0, 0);
            ConstraintLayout.b bVar = (ConstraintLayout.b) this.f2712f0.f17761p.getLayoutParams();
            bVar.setMargins(0, iV + iU + ((ViewGroup.MarginLayoutParams) bVar).topMargin, 0, 0);
        }
        return this.f2712f0.b();
    }
}
