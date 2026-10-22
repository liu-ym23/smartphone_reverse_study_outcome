package com.stepos.familyguard.ui.main;

import android.app.Activity;
import android.graphics.Rect;
import android.os.Bundle;
import android.view.View;
import androidx.fragment.app.ActivityC0516k;
import androidx.preference.Preference;
import androidx.recyclerview.widget.RecyclerView;
import com.stepos.familyguard.R;
import com.stepos.familyguard.ui.main.PrivacySettingPreferenceFragment;
import com.stepos.familyguard.ui.widget.PreferenceFragment;
import com.stepos.policy.sdk.util.PolicySdkToolsUtils;
import p2.g;

/* loaded from: classes.dex */
public class PrivacySettingPreferenceFragment extends PreferenceFragment implements Preference.d {

    /* renamed from: p0, reason: collision with root package name */
    protected Preference f14859p0;

    /* renamed from: q0, reason: collision with root package name */
    private int f14860q0;

    public static /* synthetic */ void q2(Activity activity, boolean z5) {
        if (z5) {
            activity.finishAffinity();
        }
    }

    @Override // androidx.preference.Preference.d
    public boolean c(Preference preference, Object obj) {
        return false;
    }

    @Override // androidx.preference.g
    public void c2(Bundle bundle, String str) {
        U1(R.xml.fg_privacy_settings_preference);
        Preference preferenceA = a(W(R.string.fg_revoke_privacy_settings_key));
        this.f14859p0 = preferenceA;
        if (preferenceA != null) {
            preferenceA.K0(r2());
        }
    }

    @Override // androidx.preference.g, androidx.preference.j.c
    public boolean j(Preference preference) {
        final ActivityC0516k activityC0516kQ = q();
        if (activityC0516kQ == null || preference == null) {
            return super.j(preference);
        }
        String strS = preference.s();
        String language = PolicySdkToolsUtils.Companion.getLanguage();
        if (strS.equals(W(R.string.fg_user_protocol_key))) {
            g.C(activityC0516kQ, W(R.string.fg_user_protocol_title), "up", language, false);
        } else if (strS.equals(W(R.string.fg_privacy_policy_key))) {
            g.C(activityC0516kQ, W(R.string.fg_privacy_policy_title), "pp", language, false);
        } else if (strS.equals(W(R.string.fg_revoke_privacy_settings_key))) {
            if (this.f14860q0 == 2) {
                g.S(activityC0516kQ, new g.l() { // from class: u2.j
                    @Override // p2.g.l
                    public final void a(boolean z5) {
                        PrivacySettingPreferenceFragment.q2(activityC0516kQ, z5);
                    }
                });
            } else {
                g.T(activityC0516kQ);
            }
        } else if (strS.equals(W(R.string.fg_child_personal_information_collection_list_key))) {
            g.C(activityC0516kQ, W(R.string.fg_child_personal_information_collection_list_title), "pcpi", language, false);
        }
        return super.j(preference);
    }

    @Override // com.stepos.familyguard.ui.widget.PreferenceFragment
    public void l2(int i5, int i6, Rect rect, View view, RecyclerView recyclerView, RecyclerView.State state) {
        if (i5 == 0) {
            rect.top = T1.g.a(view.getContext(), R.attr.marginMedium);
        }
    }

    @Override // com.stepos.familyguard.ui.widget.PreferenceFragment
    public int n2(int i5, int i6) {
        if (i5 == 0) {
            return 0;
        }
        return i5 == i6 - 1 ? 2 : 1;
    }

    protected boolean r2() {
        return true;
    }

    @Override // androidx.preference.g, androidx.fragment.app.ComponentCallbacksC0511f
    public void v0(Bundle bundle) {
        super.v0(bundle);
        this.f14860q0 = y1().getIntent().getIntExtra("from", 1);
    }
}
