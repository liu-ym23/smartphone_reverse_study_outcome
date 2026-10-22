package com.stepos.aiengine.modelmanager.settings;

import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.a;
import androidx.fragment.app.o;
import androidx.lifecycle.j0;
import androidx.preference.PreferenceCategory;
import androidx.preference.PreferenceFragmentCompat;
import androidx.preference.PreferenceScreen;
import androidx.preference.f;
import androidx.recyclerview.widget.RecyclerView;
import com.stepos.aiengine.R;
import com.stepos.aiengine.modelmanager.pref.NavPreference;
import kotlin.jvm.internal.g;
import lb.n;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final class AiEngineSettingsFragment extends PreferenceFragmentCompat {
    /* JADX INFO: Access modifiers changed from: private */
    public static final n onCreatePreferences$lambda$1(AiEngineSettingsFragment aiEngineSettingsFragment) {
        o activity = aiEngineSettingsFragment.getActivity();
        AiEngineSettingsActivity aiEngineSettingsActivity = activity instanceof AiEngineSettingsActivity ? (AiEngineSettingsActivity) activity : null;
        if (aiEngineSettingsActivity != null) {
            PrivacySettingsFragment privacySettingsFragment = new PrivacySettingsFragment();
            FragmentManager supportFragmentManager = aiEngineSettingsActivity.getSupportFragmentManager();
            supportFragmentManager.getClass();
            a aVar = new a(supportFragmentManager);
            aVar.e(privacySettingsFragment, R.id.settings_container);
            aVar.c();
            aVar.g(false);
        }
        return n.f10413a;
    }

    @Override // androidx.preference.PreferenceFragmentCompat
    public void onCreatePreferences(Bundle bundle, String str) {
        Context contextRequireContext = requireContext();
        g.e(contextRequireContext, "requireContext(...)");
        f preferenceManager = getPreferenceManager();
        preferenceManager.getClass();
        PreferenceScreen preferenceScreen = new PreferenceScreen(contextRequireContext, null);
        preferenceScreen.m(preferenceManager);
        PreferenceCategory preferenceCategory = new PreferenceCategory(contextRequireContext, null);
        preferenceCategory.I = R.layout.pref_category;
        String string = getString(R.string.mm_privacy_entry_title);
        if (!TextUtils.equals(string, preferenceCategory.f2353k)) {
            preferenceCategory.f2353k = string;
            preferenceCategory.j();
        }
        preferenceCategory.f2363v = false;
        preferenceScreen.B(preferenceCategory);
        String string2 = getString(R.string.mm_privacy_title);
        g.e(string2, "getString(...)");
        preferenceScreen.B(new NavPreference(contextRequireContext, string2, 0, 1, true, new j0(this, 10)));
        setPreferenceScreen(preferenceScreen);
    }

    @Override // androidx.preference.PreferenceFragmentCompat, androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle bundle) {
        g.f(view, "view");
        super.onViewCreated(view, bundle);
        setDivider(null);
        setDividerHeight(0);
        RecyclerView listView = getListView();
        Context contextRequireContext = requireContext();
        g.e(contextRequireContext, "requireContext(...)");
        listView.addItemDecoration(new i6.a(contextRequireContext));
    }
}
