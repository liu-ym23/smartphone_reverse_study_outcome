package com.stepos.aiengine.modelmanager.settings;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import androidx.activity.result.ActivityResult;
import androidx.fragment.app.o;
import androidx.preference.PreferenceFragmentCompat;
import androidx.preference.PreferenceScreen;
import androidx.preference.f;
import androidx.recyclerview.widget.RecyclerView;
import com.google.android.material.button.a;
import com.stepos.aiengine.R;
import com.stepos.aiengine.cta.WithdrawActivity;
import com.stepos.aiengine.modelmanager.pref.NavPreference;
import com.stepos.core.common.util.ActionDebouncer;
import d.b;
import e.c;
import kotlin.jvm.internal.g;
import lb.n;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final class PrivacySettingsFragment extends PreferenceFragmentCompat {
    private final b<Intent> withdrawLauncher;

    public PrivacySettingsFragment() {
        b<Intent> bVarRegisterForActivityResult = registerForActivityResult(new c(), new a(this));
        g.e(bVarRegisterForActivityResult, "registerForActivityResult(...)");
        this.withdrawLauncher = bVarRegisterForActivityResult;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final n onCreatePreferences$lambda$1(PrivacySettingsFragment privacySettingsFragment) {
        ActionDebouncer actionDebouncer = c6.c.f3292a;
        o oVarRequireActivity = privacySettingsFragment.requireActivity();
        g.e(oVarRequireActivity, "requireActivity(...)");
        String string = privacySettingsFragment.getString(R.string.mm_privacy_policy);
        g.e(string, "getString(...)");
        c6.c.a(oVarRequireActivity, string);
        return n.f10413a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final n onCreatePreferences$lambda$2(PrivacySettingsFragment privacySettingsFragment, Context context) {
        privacySettingsFragment.withdrawLauncher.a(new Intent(context, (Class<?>) WithdrawActivity.class));
        return n.f10413a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void withdrawLauncher$lambda$0(PrivacySettingsFragment privacySettingsFragment, ActivityResult result) {
        o activity;
        g.f(result, "result");
        if (result.getResultCode() != -1 || (activity = privacySettingsFragment.getActivity()) == null) {
            return;
        }
        activity.finish();
    }

    @Override // androidx.preference.PreferenceFragmentCompat
    public void onCreatePreferences(Bundle bundle, String str) {
        Context contextRequireContext = requireContext();
        g.e(contextRequireContext, "requireContext(...)");
        f preferenceManager = getPreferenceManager();
        preferenceManager.getClass();
        PreferenceScreen preferenceScreen = new PreferenceScreen(contextRequireContext, null);
        preferenceScreen.m(preferenceManager);
        String string = getString(R.string.mm_privacy_policy);
        g.e(string, "getString(...)");
        preferenceScreen.B(new NavPreference(contextRequireContext, string, 0, 2, true, new b6.g(this, 14)));
        String string2 = getString(R.string.mm_privacy_withdraw);
        g.e(string2, "getString(...)");
        preferenceScreen.B(new NavPreference(contextRequireContext, string2, 1, 2, false, new android.llama.cpp.b(9, this, contextRequireContext)));
        setPreferenceScreen(preferenceScreen);
    }

    @Override // androidx.preference.PreferenceFragmentCompat, androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle bundle) {
        g.f(view, "view");
        super.onViewCreated(view, bundle);
        setDivider(null);
        setDividerHeight(0);
        getListView().setPadding(getListView().getPaddingLeft(), (int) (8 * getResources().getDisplayMetrics().density), getListView().getPaddingRight(), getListView().getPaddingBottom());
        getListView().setClipToPadding(false);
        RecyclerView listView = getListView();
        Context contextRequireContext = requireContext();
        g.e(contextRequireContext, "requireContext(...)");
        listView.addItemDecoration(new i6.a(contextRequireContext));
    }
}
