package H2;

import android.os.Bundle;
import android.view.View;
import androidx.core.view.InterfaceC0479y;
import androidx.core.view.Y;
import androidx.preference.Preference;
import androidx.recyclerview.widget.RecyclerView;
import com.stepos.familyguard.R;
import com.stepos.familyguard.ui.limit.BaseLimitFragment;
import com.stepos.minor.WhitelistApp;
import v2.C1183b;

/* loaded from: classes.dex */
public class B extends BaseLimitFragment {

    /* renamed from: E0, reason: collision with root package name */
    private long f2704E0;

    /* renamed from: F0, reason: collision with root package name */
    private int f2705F0;

    /* renamed from: G0, reason: collision with root package name */
    private int f2706G0 = -1;

    private void Y2() {
        RecyclerView recyclerViewX1 = X1();
        if (recyclerViewX1 == null) {
            return;
        }
        recyclerViewX1.setClipToPadding(false);
        if (this.f2706G0 < 0) {
            this.f2706G0 = recyclerViewX1.getPaddingBottom();
        }
        androidx.core.view.H.w0(recyclerViewX1, new InterfaceC0479y() { // from class: H2.A
            @Override // androidx.core.view.InterfaceC0479y
            public final androidx.core.view.Y a(View view, androidx.core.view.Y y5) {
                return this.f2702a.Z2(view, y5);
            }
        });
        recyclerViewX1.setPadding(recyclerViewX1.getPaddingLeft(), recyclerViewX1.getPaddingTop(), recyclerViewX1.getPaddingRight(), this.f2706G0 + a3(recyclerViewX1));
        androidx.core.view.H.g0(recyclerViewX1);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ androidx.core.view.Y Z2(View view, androidx.core.view.Y y5) {
        int iA3 = y5.f(Y.l.d()).f9645d;
        if (iA3 <= 0) {
            iA3 = a3(view);
        }
        view.setPadding(view.getPaddingLeft(), view.getPaddingTop(), view.getPaddingRight(), this.f2706G0 + iA3);
        return y5;
    }

    private static int a3(View view) {
        int identifier = view.getResources().getIdentifier("navigation_bar_height", "dimen", "android");
        return identifier > 0 ? view.getResources().getDimensionPixelSize(identifier) : Math.round(view.getResources().getDisplayMetrics().density * 48.0f);
    }

    @Override // androidx.fragment.app.ComponentCallbacksC0511f
    public void A0() {
        super.A0();
    }

    @Override // com.stepos.familyguard.ui.limit.BaseLimitFragment
    protected t2.Y D2(Bundle bundle) {
        if (bundle == null) {
            return null;
        }
        int i5 = bundle.getInt("proxy", 0);
        t2.X x5 = (t2.X) new androidx.lifecycle.U(y1()).a(t2.X.class);
        if (!x5.S()) {
            x5.R(i5 == 0 ? new C1183b(w().getApplicationContext()) : null, this.f2705F0, this.f2704E0);
        }
        return x5;
    }

    @Override // com.stepos.familyguard.ui.limit.BaseLimitFragment
    protected int E2() {
        return R.xml.us_global_limit_preferences;
    }

    @Override // com.stepos.familyguard.ui.limit.BaseLimitFragment
    protected void K2(boolean z5) {
        super.K2(z5);
    }

    @Override // com.stepos.familyguard.ui.limit.BaseLimitFragment, androidx.preference.g, androidx.fragment.app.ComponentCallbacksC0511f
    public void U0(View view, Bundle bundle) {
        super.U0(view, bundle);
        Y2();
    }

    @Override // com.stepos.familyguard.ui.limit.BaseLimitFragment, androidx.preference.g
    public void c2(Bundle bundle, String str) {
        super.c2(bundle, str);
        Preference preferenceA = a(W(R.string.us_limit_how_to_limit_key));
        if (preferenceA != null) {
            preferenceA.K0(false);
        }
    }

    @Override // com.stepos.familyguard.ui.widget.PreferenceFragment
    public int n2(int i5, int i6) {
        if (i5 == 0 || i5 == 1 || i5 == 5) {
            return 4;
        }
        if (i5 == 2 || i5 == 6) {
            return 0;
        }
        return (i5 == 4 || i5 == i6 - 1) ? 2 : 1;
    }

    @Override // com.stepos.familyguard.ui.limit.BaseLimitFragment, androidx.preference.g, androidx.fragment.app.ComponentCallbacksC0511f
    public void v0(Bundle bundle) {
        if (u() != null) {
            this.f2704E0 = u().getLong(WhitelistApp.COLUMN_MINOR_ID, -1L);
            this.f2705F0 = u().getInt("minor_age_range", 0);
        } else {
            this.f2704E0 = -1L;
            this.f2705F0 = 0;
        }
        super.v0(bundle);
    }
}
