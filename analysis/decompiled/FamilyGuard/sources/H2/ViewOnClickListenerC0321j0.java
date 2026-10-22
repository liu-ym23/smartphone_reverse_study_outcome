package H2;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.res.ColorStateList;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import androidx.fragment.app.ActivityC0516k;
import com.stepos.familyguard.R;
import com.stepos.familyguard.ui.base.BaseFragment;
import com.stepos.familyguard.ui.limit.GlobalLimitActivity;
import com.stepos.minor.Minor;
import com.stepos.minor.ui.MinorEditActivity;
import com.stepos.minor.ui.MinorLimitManagerActivity;
import com.stepos.minor.ui.MinorMainActivity;
import com.stepos.minor.ui.MinorSelectActivity;
import com.stepos.minor.ui.MinorWhitelistAppActivity;
import f2.C0702g;
import h.C0744a;
import java.util.List;
import java.util.concurrent.Callable;
import stepos.support.v7.app.s;
import z3.C1347a;

/* renamed from: H2.j0, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public class ViewOnClickListenerC0321j0 extends BaseFragment implements View.OnClickListener {

    /* renamed from: f0, reason: collision with root package name */
    private Minor f2788f0;

    /* renamed from: g0, reason: collision with root package name */
    private F2.y f2789g0;

    /* renamed from: h0, reason: collision with root package name */
    private j2.p f2790h0;

    /* renamed from: H2.j0$a */
    private class a implements View.OnClickListener {

        /* renamed from: a, reason: collision with root package name */
        private long f2791a;

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            long jCurrentTimeMillis = System.currentTimeMillis();
            if (jCurrentTimeMillis - this.f2791a < 600) {
                return;
            }
            this.f2791a = jCurrentTimeMillis;
            ViewOnClickListenerC0321j0.this.onClick(view);
        }

        private a() {
            this.f2791a = 0L;
        }
    }

    public static /* synthetic */ void W1(Activity activity, DialogInterface dialogInterface, int i5) {
        if (activity instanceof MinorMainActivity) {
            ((MinorMainActivity) activity).j0().j(3);
        }
    }

    private void c2() {
        ActivityC0516k activityC0516kY1 = y1();
        if (activityC0516kY1 instanceof MinorMainActivity) {
            ((MinorMainActivity) activityC0516kY1).y0();
        }
    }

    private void d2(boolean z5) {
        final ActivityC0516k activityC0516kY1 = y1();
        new s.a(activityC0516kY1).C(new CharSequence[]{W(R.string.mm_turn_off_minor_mode)}, new DialogInterface.OnClickListener() { // from class: H2.h0
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i5) {
                ViewOnClickListenerC0321j0.W1(activityC0516kY1, dialogInterface, i5);
            }
        }, true, new ColorStateList[]{C0744a.a(A1(), R.color.stepos_alert_showat_bottom_red)}).x(R.string.mm_turn_off_minor_mode_dialog).A();
    }

    @Override // androidx.fragment.app.ComponentCallbacksC0511f
    public void A0() {
        super.A0();
    }

    @Override // androidx.fragment.app.ComponentCallbacksC0511f
    public boolean J0(MenuItem menuItem) {
        ActivityC0516k activityC0516kY1 = y1();
        G2.v vVarJ0 = activityC0516kY1 instanceof MinorMainActivity ? ((MinorMainActivity) activityC0516kY1).j0() : null;
        if (menuItem.getItemId() == R.id.menu_shortcut) {
            I2.c.e(activityC0516kY1.getApplicationContext());
            return true;
        }
        if (menuItem.getItemId() == R.id.menu_password) {
            if (vVarJ0 == null) {
                return true;
            }
            vVarJ0.j(5);
            return true;
        }
        if (menuItem.getItemId() != R.id.menu_phone_number || vVarJ0 == null) {
            return true;
        }
        vVarJ0.j(6);
        return true;
    }

    @Override // androidx.fragment.app.ComponentCallbacksC0511f
    public void N0(Menu menu) {
        super.N0(menu);
        final MenuItem menuItemFindItem = menu.findItem(R.id.menu_shortcut);
        if (menuItemFindItem != null) {
            final Context contextA1 = A1();
            x3.f.x(new Callable() { // from class: H2.f0
                @Override // java.util.concurrent.Callable
                public final Object call() {
                    Context context = contextA1;
                    return Boolean.valueOf(I2.c.j(context, context.getPackageName(), MinorMainActivity.class.getName()));
                }
            }).X(T3.a.c()).G(C1347a.a()).T(new D3.c() { // from class: H2.g0
                @Override // D3.c
                public final void accept(Object obj) {
                    Boolean bool = (Boolean) obj;
                    menuItemFindItem.setEnabled(!bool.booleanValue());
                }
            }, S1.a.b());
        }
    }

    @Override // com.stepos.familyguard.ui.base.BaseFragment, androidx.fragment.app.ComponentCallbacksC0511f
    public void S0() {
        super.S0();
        c2();
    }

    @Override // androidx.fragment.app.ComponentCallbacksC0511f
    public void U0(View view, Bundle bundle) {
        super.U0(view, bundle);
        a aVar = new a();
        this.f2790h0.f17772h.setOnClickListener(aVar);
        this.f2790h0.f17767c.setOnClickListener(aVar);
        this.f2790h0.f17770f.setOnClickListener(aVar);
        this.f2790h0.f17769e.setOnClickListener(aVar);
        this.f2790h0.f17771g.setOnClickListener(aVar);
        this.f2790h0.f17768d.setOnClickListener(aVar);
        c2();
    }

    public void a2(Minor minor) {
        C0702g.b("MinorMainFragment", "onActiveMinorChanged() called with: activeMinor = [" + minor + "]");
        ActivityC0516k activityC0516kY1 = y1();
        this.f2788f0 = minor;
        if (minor != null) {
            this.f2790h0.f17775k.setText(minor.getName());
            this.f2790h0.f17774j.setText(this.f2788f0.getAgeDesc(activityC0516kY1));
            if (this.f2788f0.getIcon() != null) {
                this.f2790h0.f17766b.setImageBitmap(C2.h.i(this.f2788f0.getIcon()));
            } else {
                this.f2790h0.f17766b.setImageDrawable(C0744a.b(activityC0516kY1, R.drawable.stepos_avastar_person_00));
            }
            this.f2789g0.l0(this.f2788f0.getId()).X(T3.a.c()).G(C1347a.a()).S(new D3.c() { // from class: H2.i0
                @Override // D3.c
                public final void accept(Object obj) {
                    C0702g.b("MinorMainFragment", C0702g.k((List) obj));
                }
            });
        }
    }

    public void b2(List<Minor> list) {
        C0702g.b("MinorMainFragment", "onMinorsChange() called with: minors = " + C0702g.k(list));
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        int id = view.getId();
        ActivityC0516k activityC0516kY1 = y1();
        if (id == R.id.ll_minor) {
            MinorEditActivity.L(y1(), this.f2788f0.getId());
            return;
        }
        if (id == R.id.btn_switch) {
            MinorSelectActivity.K(activityC0516kY1, 1);
            return;
        }
        if (id == R.id.layout_use_duration) {
            GlobalLimitActivity.Z(A1(), this.f2788f0.getId(), this.f2788f0.getAgeRange());
            return;
        }
        if (id == R.id.layout_app_manage) {
            MinorLimitManagerActivity.a0(A1(), 0, this.f2788f0.getId());
        } else if (id == R.id.layout_whitelist) {
            MinorWhitelistAppActivity.i0(y1(), this.f2788f0.getId());
        } else if (id == R.id.btn_turn_off) {
            d2(false);
        }
    }

    @Override // com.stepos.familyguard.ui.base.BaseFragment, androidx.fragment.app.ComponentCallbacksC0511f
    public void s0(Context context) {
        super.s0(context);
    }

    @Override // androidx.fragment.app.ComponentCallbacksC0511f
    public void v0(Bundle bundle) {
        super.v0(bundle);
        F2.y yVar = (F2.y) new androidx.lifecycle.U(y1()).a(F2.y.class);
        this.f2789g0 = yVar;
        yVar.g0().g(this, new androidx.lifecycle.C() { // from class: H2.d0
            @Override // androidx.lifecycle.C
            public final void a(Object obj) {
                this.f2776a.a2((Minor) obj);
            }
        });
        this.f2789g0.i0().g(this, new androidx.lifecycle.C() { // from class: H2.e0
            @Override // androidx.lifecycle.C
            public final void a(Object obj) {
                this.f2778a.b2((List) obj);
            }
        });
        I1(true);
    }

    @Override // androidx.fragment.app.ComponentCallbacksC0511f
    public void y0(Menu menu, MenuInflater menuInflater) {
        super.y0(menu, menuInflater);
        menuInflater.inflate(R.menu.menu_minor_main, menu);
    }

    @Override // androidx.fragment.app.ComponentCallbacksC0511f
    public View z0(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        this.f2790h0 = j2.p.c(layoutInflater);
        if (TextUtils.equals("CN", Q().getConfiguration().locale.getCountry())) {
            T1.g.e(1.18f, this.f2790h0.b());
        } else {
            T1.g.e(1.06f, this.f2790h0.b());
        }
        return this.f2790h0.b();
    }
}
