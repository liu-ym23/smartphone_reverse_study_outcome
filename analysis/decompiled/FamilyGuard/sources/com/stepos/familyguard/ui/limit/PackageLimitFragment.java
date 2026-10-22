package com.stepos.familyguard.ui.limit;

import T1.g;
import android.graphics.Rect;
import android.os.Bundle;
import android.view.View;
import androidx.lifecycle.V;
import androidx.recyclerview.widget.RecyclerView;
import com.stepos.familyguard.R;
import t2.Y;
import t2.q0;
import v2.C1183b;
import v2.d;
import v2.e;

/* loaded from: classes.dex */
public class PackageLimitFragment extends BaseLimitFragment {
    @Override // com.stepos.familyguard.ui.limit.BaseLimitFragment
    protected Y D2(Bundle bundle) {
        e dVar;
        if (bundle == null) {
            return null;
        }
        String string = bundle.getString("packageName", null);
        int i5 = bundle.getInt("proxy", 0);
        long j5 = bundle.getLong("operator_id", -1L);
        q0 q0Var = (q0) V.b(q()).a(q0.class);
        if (!q0Var.S()) {
            if (i5 == 0) {
                dVar = new C1183b(w().getApplicationContext());
            } else {
                dVar = new d(j5);
                dVar.init();
            }
            q0Var.R(string, dVar, j5);
        }
        return q0Var;
    }

    @Override // com.stepos.familyguard.ui.limit.BaseLimitFragment
    protected int E2() {
        return R.xml.us_package_limit_preferences;
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
            return 3;
        }
        if (i5 == i6 - 2) {
            return 4;
        }
        return i5 == i6 - 3 ? 2 : 1;
    }
}
